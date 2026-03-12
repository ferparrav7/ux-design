import { Screen } from '../router.js';
import { patientData, getAdherence, getActiveCount, getNotificationSettings, updateNotificationSetting, NotificationSettings, getMedications, deleteMedication } from '../data/mockData.js';

export class ConfigScreen implements Screen {
    render(): string {
        const adherence = getAdherence();
        const activeCount = getActiveCount();
        const settings = getNotificationSettings();
        const medications = getMedications();
        
        const badgeHtml = activeCount > 0 ? `<span class="badge">${activeCount}</span>` : '';
        const bellDotHtml = activeCount > 0 ? `<div class="bell-dot"></div>` : '';

        return `
            <div class="app-layout">
                <aside class="sidebar">
                    <div class="sidebar-header">💊 MediAlarm</div>
                    <nav class="sidebar-nav">
                        <a href="#dashboard" class="nav-item"><span>🏠</span> Dashboard</a>
                        <a href="#history" class="nav-item"><span>📋</span> Historial</a>
                        <a href="#alerts" class="nav-item"><span>🔔</span> Alertas ${badgeHtml}</a>
                        <a href="#config" class="nav-item active"><span>⚙️</span> Configuración</a>
                    </nav>
                    <div class="sidebar-patient">
                        <div class="patient-card">
                            <p style="font-size: 10px; font-weight: 600; color: var(--text-meta); text-transform: uppercase; margin-bottom: 12px;">PACIENTE</p>
                            <div class="pc-header">
                                <div class="pc-avatar">👵</div>
                                <div class="pc-info">
                                    <p class="name">${patientData.name}</p>
                                    <p class="age">${patientData.age} años</p>
                                </div>
                            </div>
                            <div class="pc-stats"><span>Adherencia</span><span style="font-weight: 700; color: var(--text-main);">${adherence}%</span></div>
                            <div class="pc-bar-bg"><div class="pc-bar-fill" style="width: ${adherence}%;"></div></div>
                        </div>
                    </div>
                </aside>

                <main class="main-wrapper">
                    <header class="top-header">
                        <h2 class="header-title">Configuración</h2>
                        <div class="header-actions">
                            <a href="#alerts" class="bell-icon" style="text-decoration: none;">🔔${bellDotHtml}</a>
                            <div class="user-profile">
                                <div class="user-info"><p class="u-name">Ana García</p><p class="u-role">Familiar</p></div>
                                <div class="u-avatar">👤</div>
                            </div>
                        </div>
                    </header>

                    <div class="content-area">
                        <div class="config-wrap">
                            <div style="margin-bottom: 8px;">
                                <h1 style="font-size: 24px; color: var(--text-main);">Configuración</h1>
                                <p style="color: var(--text-meta); margin-top: 4px;">Administra tu cuenta y preferencias</p>
                            </div>

                            <div class="cf-section">
                                <div class="cf-header">
                                    <div class="cf-header-left"><span>👤</span> Perfil de Usuario</div>
                                    <button class="btn-icon btn-edit-profile" style="font-size: 13px; font-weight: 600; color: var(--text-main);">Editar</button>
                                </div>
                                <div class="cf-body form-grid">
                                    <div class="form-group"><label>Nombre</label><div class="form-value">Ana García</div></div>
                                    <div class="form-group"><label>Email</label><div class="form-value">ana.garcia@email.com</div></div>
                                    <div class="form-group"><label>Rol</label><div class="form-value">Family</div></div>
                                </div>
                            </div>

                            <div class="cf-section">
                                <div class="cf-header">
                                    <div class="cf-header-left"><span>🛡️</span> Datos del Paciente</div>
                                    <button class="btn-icon btn-edit-patient" style="font-size: 13px; font-weight: 600; color: var(--text-main);">Editar</button>
                                </div>
                                <div class="cf-body" style="display: flex; gap: 24px; align-items: center;">
                                    <div style="width: 64px; height: 64px; background: var(--light); border-radius: 50%; display: grid; place-items: center; font-size: 32px;">👵</div>
                                    <div>
                                        <h4 style="font-size: 16px; font-weight: 600; color: var(--text-main);">${patientData.name}</h4>
                                        <p style="font-size: 13px; color: var(--text-meta); margin-top: 4px;">${patientData.age} años • Diabetes Tipo 2, Hipertensión</p>
                                    </div>
                                </div>
                            </div>

                            <div class="cf-section">
                                <div class="cf-header"><div class="cf-header-left"><span>🔔</span> Notificaciones</div></div>
                                <div>
                                    <div class="toggle-row">
                                        <div class="tr-text"><h4>Alertas por Email</h4><p>Recibir resumen diario y alertas graves</p></div>
                                        <label class="toggle-switch">
                                            <input type="checkbox" class="setting-toggle" data-key="email" ${settings.email ? 'checked' : ''}>
                                            <span class="slider"></span>
                                        </label>
                                    </div>
                                    <div class="toggle-row">
                                        <div class="tr-text"><h4>Notificaciones Push</h4><p>Alertas en tiempo real en el navegador</p></div>
                                        <label class="toggle-switch">
                                            <input type="checkbox" class="setting-toggle" data-key="push" ${settings.push ? 'checked' : ''}>
                                            <span class="slider"></span>
                                        </label>
                                    </div>
                                    <div class="toggle-row">
                                        <div class="tr-text"><h4>Alertas SMS</h4><p>Solo para emergencias críticas</p></div>
                                        <label class="toggle-switch">
                                            <input type="checkbox" class="setting-toggle" data-key="sms" ${settings.sms ? 'checked' : ''}>
                                            <span class="slider"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="cf-section">
                                <div class="cf-header">
                                    <div class="cf-header-left"><span>💊</span> Medicamentos Activos</div>
                                    <button class="btn-icon btn-add-med" style="font-size: 13px; font-weight: 600; color: var(--text-main);">+ Agregar</button>
                                </div>
                                <div id="medications-list">
                                    ${medications.length === 0 
                                        ? `<div style="padding: 24px; text-align: center; color: var(--text-meta);">No hay medicamentos registrados</div>`
                                        : medications.map(med => `
                                            <div class="med-row">
                                                <div class="mr-info">
                                                    <h4>${med.name} <span>(${med.dose})</span></h4>
                                                    <p>${med.frequency} • ${med.times}</p>
                                                </div>
                                                <div class="mr-actions">
                                                    <button class="btn-icon btn-edit-med" data-name="${med.name}" data-dose="${med.dose}" data-freq="${med.frequency}">✏️</button>
                                                    <button class="btn-icon btn-delete-med" data-id="${med.id}" data-name="${med.name}">🗑️</button>
                                                </div>
                                            </div>
                                        `).join('')
                                    }
                                </div>
                            </div>

                            <button id="btn-logout" class="btn btn-sec" style="width: 100%; padding: 16px; color: var(--danger); font-weight: 600; border: 1px solid var(--border); cursor: pointer;">
                                🚪 Cerrar Sesión
                            </button>
                        </div>
                    </div>

                    <!-- Modal Flotante Genérico -->
                    <div id="modal-overlay" style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0,0,0,0.5); z-index: 100; justify-content: center; align-items: center;">
                        <div style="background: white; padding: 32px; border-radius: 12px; width: 400px; box-shadow: 0 4px 20px rgba(0,0,0,0.15);">
                            <h3 id="modal-title" style="margin-bottom: 16px; font-size: 18px; color: var(--text-main);">Título del Modal</h3>
                            <div id="modal-content" style="display: flex; flex-direction: column; gap: 16px;">
                                <!-- El contenido se inyectará dinámicamente -->
                            </div>
                            <div style="display: flex; justify-content: flex-end; gap: 12px; margin-top: 24px;">
                                <button id="btn-close-modal" class="btn btn-sec">Cancelar</button>
                                <button id="btn-confirm-modal" class="btn btn-pri">Guardar</button>
                            </div>
                        </div>
                    </div>

                </main>
            </div>
        `;
    }

    onMount(): void {
        // Toggles de notificaciones
        const toggles = document.querySelectorAll('.setting-toggle');
        toggles.forEach(toggle => {
            toggle.addEventListener('change', (e) => {
                const target = e.target as HTMLInputElement;
                const key = target.getAttribute('data-key') as keyof NotificationSettings;
                const value = target.checked;
                updateNotificationSetting(key, value);
            });
        });

        // Lógica del Modal
        const modalOverlay = document.getElementById('modal-overlay');
        const modalTitle = document.getElementById('modal-title');
        const modalContent = document.getElementById('modal-content');
        const btnCloseModal = document.getElementById('btn-close-modal');
        const btnConfirmModal = document.getElementById('btn-confirm-modal');
        
        let pendingAction: { type: 'delete' | 'logout', id?: number } | null = null;

        const openModal = (type: 'profile' | 'patient' | 'med' | 'delete' | 'logout', data?: any) => {
            if (modalOverlay && modalTitle && modalContent && btnConfirmModal && btnCloseModal) {
                modalOverlay.style.display = 'flex';
                modalContent.innerHTML = ''; // Limpiar contenido previo
                pendingAction = null; // Resetear acción

                // Configuración por defecto de botones (Guardar/Editar)
                btnConfirmModal.textContent = 'Guardar';
                btnConfirmModal.classList.remove('btn-danger'); 
                btnConfirmModal.classList.add('btn-pri');
                (btnConfirmModal as HTMLButtonElement).disabled = true;
                (btnConfirmModal as HTMLButtonElement).style.opacity = '0.5';
                (btnConfirmModal as HTMLButtonElement).style.cursor = 'not-allowed';
                (btnConfirmModal as HTMLButtonElement).style.backgroundColor = '';
                (btnConfirmModal as HTMLButtonElement).style.color = '';
                (btnConfirmModal as HTMLButtonElement).style.border = 'none';
                
                btnCloseModal.textContent = 'Cerrar';

                // Estilo común para inputs deshabilitados
                const disabledStyle = 'cursor: not-allowed; opacity: 0.7;';

                if (type === 'profile') {
                    modalTitle.textContent = 'Editar Perfil de Usuario';
                    modalContent.innerHTML = `
                        <div class="form-group"><label>Nombre</label><input type="text" class="wire-input" disabled style="${disabledStyle}" value="Ana García"></div>
                        <div class="form-group"><label>Email</label><input type="email" class="wire-input" disabled style="${disabledStyle}" value="ana.garcia@email.com"></div>
                        <div class="form-group"><label>Rol</label><input type="text" class="wire-input" disabled style="${disabledStyle}" value="Family"></div>
                    `;
                } else if (type === 'patient') {
                    modalTitle.textContent = 'Editar Datos del Paciente';
                    modalContent.innerHTML = `
                        <div class="form-group"><label>Nombre</label><input type="text" class="wire-input" disabled style="${disabledStyle}" value="${patientData.name}"></div>
                        <div class="form-group"><label>Edad</label><input type="number" class="wire-input" disabled style="${disabledStyle}" value="${patientData.age}"></div>
                        <div class="form-group"><label>Condiciones</label><input type="text" class="wire-input" disabled style="${disabledStyle}" value="Diabetes Tipo 2, Hipertensión"></div>
                    `;
                } else if (type === 'med') {
                    const isEdit = !!data;
                    modalTitle.textContent = isEdit ? 'Editar Medicamento' : 'Agregar Medicamento';
                    modalContent.innerHTML = `
                        <div class="form-group"><label>Nombre</label><input type="text" class="wire-input" disabled style="${disabledStyle}" value="${data?.name || ''}" placeholder="Ej. Ibuprofeno"></div>
                        <div class="form-group"><label>Dosis</label><input type="text" class="wire-input" disabled style="${disabledStyle}" value="${data?.dose || ''}" placeholder="Ej. 400mg"></div>
                        <div class="form-group"><label>Frecuencia</label><input type="text" class="wire-input" disabled style="${disabledStyle}" value="${data?.freq || ''}" placeholder="Ej. 8 horas"></div>
                    `;
                } else if (type === 'delete') {
                    modalTitle.textContent = 'Eliminar Medicamento';
                    modalContent.innerHTML = `
                        <p style="color: var(--text-sec);">¿Estás seguro de que deseas eliminar <strong>${data?.name}</strong> de la lista?</p>
                        <p style="color: var(--text-meta); font-size: 13px;">Esta acción no se puede deshacer.</p>
                    `;
                    
                    // Configurar botones para acción destructiva
                    btnConfirmModal.textContent = 'Eliminar';
                    btnConfirmModal.classList.remove('btn-pri');
                    btnConfirmModal.classList.add('btn-danger');
                    (btnConfirmModal as HTMLButtonElement).style.backgroundColor = 'var(--danger)';
                    (btnConfirmModal as HTMLButtonElement).style.border = 'none'; // Quitar borde
                    (btnConfirmModal as HTMLButtonElement).style.color = 'white';
                    (btnConfirmModal as HTMLButtonElement).disabled = false;
                    (btnConfirmModal as HTMLButtonElement).style.opacity = '1';
                    (btnConfirmModal as HTMLButtonElement).style.cursor = 'pointer';
                    
                    btnCloseModal.textContent = 'Cancelar';
                    pendingAction = { type: 'delete', id: data?.id };
                } else if (type === 'logout') {
                    modalTitle.textContent = 'Cerrar Sesión';
                    modalContent.innerHTML = `
                        <p style="color: var(--text-sec);">¿Estás seguro de que deseas cerrar tu sesión actual?</p>
                    `;
                    
                    // Configurar botones para acción destructiva
                    btnConfirmModal.textContent = 'Cerrar Sesión';
                    btnConfirmModal.classList.remove('btn-pri');
                    btnConfirmModal.classList.add('btn-danger');
                    (btnConfirmModal as HTMLButtonElement).style.backgroundColor = 'var(--danger)';
                    (btnConfirmModal as HTMLButtonElement).style.border = 'none'; // Quitar borde
                    (btnConfirmModal as HTMLButtonElement).style.color = 'white';
                    (btnConfirmModal as HTMLButtonElement).disabled = false;
                    (btnConfirmModal as HTMLButtonElement).style.opacity = '1';
                    (btnConfirmModal as HTMLButtonElement).style.cursor = 'pointer';
                    
                    btnCloseModal.textContent = 'Cancelar';
                    pendingAction = { type: 'logout' };
                }
            }
        };

        const closeModal = () => {
            if (modalOverlay) {
                modalOverlay.style.display = 'none';
            }
        };

        if (btnCloseModal) {
            btnCloseModal.addEventListener('click', closeModal);
        }

        if (btnConfirmModal) {
            btnConfirmModal.addEventListener('click', () => {
                if (pendingAction) {
                    if (pendingAction.type === 'delete' && pendingAction.id) {
                        deleteMedication(pendingAction.id);
                        // Forzar re-render
                        const currentHash = window.location.hash;
                        window.location.hash = ''; 
                        window.location.hash = currentHash;
                    } else if (pendingAction.type === 'logout') {
                        window.location.hash = 'login';
                    }
                    closeModal();
                }
            });
        }

        // Asignar eventos
        const editProfileBtn = document.querySelector('.btn-edit-profile');
        if (editProfileBtn) editProfileBtn.addEventListener('click', () => openModal('profile'));

        const editPatientBtn = document.querySelector('.btn-edit-patient');
        if (editPatientBtn) editPatientBtn.addEventListener('click', () => openModal('patient'));

        const addMedBtn = document.querySelector('.btn-add-med');
        if (addMedBtn) addMedBtn.addEventListener('click', () => openModal('med'));

        const logoutBtn = document.getElementById('btn-logout');
        if (logoutBtn) logoutBtn.addEventListener('click', () => openModal('logout'));

        const editMedButtons = document.querySelectorAll('.btn-edit-med');
        editMedButtons.forEach(btn => {
            btn.addEventListener('click', (e) => {
                const target = e.currentTarget as HTMLElement;
                const data = {
                    name: target.getAttribute('data-name'),
                    dose: target.getAttribute('data-dose'),
                    freq: target.getAttribute('data-freq')
                };
                openModal('med', data);
            });
        });

        // Botones de borrar medicamento (ahora abren modal)
        const deleteButtons = document.querySelectorAll('.btn-delete-med');
        deleteButtons.forEach(btn => {
            btn.addEventListener('click', (e) => {
                const target = e.currentTarget as HTMLElement;
                const id = parseInt(target.getAttribute('data-id') || '0');
                const name = target.getAttribute('data-name');
                if (id) {
                    openModal('delete', { id, name });
                }
            });
        });
    }
}

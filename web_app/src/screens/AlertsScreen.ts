import { Screen } from '../router.js';
import { patientData, getAdherence, getActiveAlerts, getActiveCount, resolveAlert } from '../data/mockData.js';

export class AlertsScreen implements Screen {
    render(): string {
        const adherence = getAdherence();
        const activeAlerts = getActiveAlerts();
        const activeCount = getActiveCount();
        
        // Lógica para mostrar el badge solo si hay alertas
        const badgeHtml = activeCount > 0 ? `<span class="badge">${activeCount}</span>` : '';
        const bellDotHtml = activeCount > 0 ? `<div class="bell-dot"></div>` : '';

        return `
            <div class="app-layout">
                <aside class="sidebar">
                    <div class="sidebar-header">💊 MediAlarm</div>
                    <nav class="sidebar-nav">
                        <a href="#dashboard" class="nav-item"><span>🏠</span> Dashboard</a>
                        <a href="#history" class="nav-item"><span>📋</span> Historial</a>
                        <a href="#alerts" class="nav-item active"><span>🔔</span> Alertas ${badgeHtml}</a>
                        <a href="#config" class="nav-item"><span>⚙️</span> Configuración</a>
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
                        <h2 class="header-title">Gestión de Alertas</h2>
                        <div class="header-actions">
                            <a href="#alerts" class="bell-icon" style="text-decoration: none;">🔔${bellDotHtml}</a>
                            <div class="user-profile">
                                <div class="user-info"><p class="u-name">Ana García</p><p class="u-role">Familiar</p></div>
                                <div class="u-avatar">👤</div>
                            </div>
                        </div>
                    </header>

                    <div class="content-area">
                        <div style="margin-bottom: 32px;">
                            <h1 style="font-size: 24px; color: var(--text-main);">Centro de Alertas</h1>
                            <p style="color: var(--text-meta); margin-top: 4px;">Gestiona las notificaciones y emergencias</p>
                        </div>

                        <div class="tabs">
                            <a href="#alerts" class="tab active">Activas <span class="badge" style="margin-left:8px;">${activeCount}</span></a>
                            <a href="#alerts-resolved" class="tab">Resueltas</a>
                        </div>

                        <div id="alerts-container">
                            ${activeAlerts.length === 0 
                                ? `<div style="text-align:center; padding: 40px; color: var(--text-meta);">No hay alertas activas 🎉</div>` 
                                : activeAlerts.map(alert => `
                                    <div class="al-card ${alert.severity === 'high' ? 'al-high' : 'al-med'}">
                                        <div class="al-info-wrap">
                                            <div class="al-icon-box">⚠️</div>
                                            <div>
                                                <h3 class="al-title">${alert.med}</h3>
                                                <p class="al-msg">${alert.msg}</p>
                                                <div class="al-meta">
                                                    <span>⏰ Programada: ${alert.timeScheduled}</span>
                                                    <span>•</span>
                                                    <span>${alert.timeActual}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="al-actions">
                                            <button class="btn btn-sec">📞 Llamar</button>
                                            <button class="btn btn-pri btn-resolve" data-id="${alert.id}">✓ Marcar Resuelta</button>
                                        </div>
                                    </div>
                                `).join('')
                            }
                        </div>

                    </div>
                </main>
            </div>
        `;
    }

    onMount(): void {
        const resolveButtons = document.querySelectorAll('.btn-resolve');
        resolveButtons.forEach(btn => {
            btn.addEventListener('click', (e) => {
                const id = parseInt((e.target as HTMLElement).getAttribute('data-id') || '0');
                if (id) {
                    resolveAlert(id);
                    // Forzar recarga de la ruta actual para re-renderizar
                    // Esto es necesario porque el router simple no detecta cambios de estado interno
                    // Al recargar, getActiveAlerts() devolverá la lista actualizada sin la alerta resuelta
                    const currentHash = window.location.hash;
                    window.location.hash = ''; 
                    window.location.hash = currentHash;
                }
            });
        });
    }
}

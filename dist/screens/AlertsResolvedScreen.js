import { patientData, getAdherence, getResolvedAlerts, getActiveCount, unresolveAlert } from '../data/mockData.js';
export class AlertsResolvedScreen {
    render() {
        const adherence = getAdherence();
        const resolvedAlerts = getResolvedAlerts();
        const activeCount = getActiveCount();
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
                            <a href="#alerts" class="tab">Activas <span class="badge" style="margin-left:8px;">${activeCount}</span></a>
                            <a href="#alerts-resolved" class="tab active">Resueltas</a>
                        </div>

                        <div id="resolved-alerts-container">
                            ${resolvedAlerts.length === 0
            ? `<div style="text-align:center; padding: 40px; color: var(--text-meta);">No hay alertas resueltas aún</div>`
            : resolvedAlerts.map(alert => `
                                    <div class="al-card al-med" style="background: var(--bg-light);">
                                        <div class="al-info-wrap">
                                            <div class="al-icon-box" style="background: var(--light);">⚠️</div>
                                            <div>
                                                <h3 class="al-title" style="color: var(--text-sec);">${alert.med}</h3>
                                                <p class="al-msg">${alert.msg}</p>
                                                <div class="al-meta">
                                                    <span>⏰ Programada: ${alert.timeScheduled}</span>
                                                    <span>•</span>
                                                    <span>${alert.timeActual}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="al-actions">
                                            <button class="btn btn-sec btn-unresolve" data-id="${alert.id}">No resuelto</button>
                                            <span class="status-badge sb-taken" style="background: transparent; border: none; font-size: 13px;">✓ Resuelta</span>
                                        </div>
                                    </div>
                                `).join('')}
                        </div>

                    </div>
                </main>
            </div>
        `;
    }
    onMount() {
        const unresolveButtons = document.querySelectorAll('.btn-unresolve');
        unresolveButtons.forEach(btn => {
            btn.addEventListener('click', (e) => {
                const id = parseInt(e.target.getAttribute('data-id') || '0');
                if (id) {
                    unresolveAlert(id);
                    // Forzar re-render
                    const currentHash = window.location.hash;
                    window.location.hash = '';
                    window.location.hash = currentHash;
                }
            });
        });
    }
}

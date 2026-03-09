import { Screen } from '../router.js';
import { patientData, getAdherence, getBannerVisibility, hideBanner } from '../data/mockDashboard.js';
import { getActiveCount, getActiveAlerts } from '../data/mockAlerts.js';

export class DashboardScreen implements Screen {
    render(): string {
        const adherence = getAdherence();
        const activeCount = getActiveCount();
        const activeAlerts = getActiveAlerts();
        const showBanner = getBannerVisibility(activeAlerts.some(a => a.id === 1));
        
        const badgeHtml = activeCount > 0 ? `<span class="badge">${activeCount}</span>` : '';
        const bellDotHtml = activeCount > 0 ? `<div class="bell-dot"></div>` : '';
        
        const getBarClass = (val: number) => {
            if (val >= 90) return 'excelente';
            if (val >= 70) return 'regular';
            return 'atencion';
        };

        // Lógica para el estilo de la tarjeta de Alertas Activas
        const alertsCardStyle = activeCount > 0 
            ? 'border-color: var(--danger); background: var(--bg-danger);' 
            : 'border-color: var(--border); background: var(--white);';
            
        const alertsTitleStyle = activeCount > 0 
            ? 'color: var(--danger); font-weight:600;' 
            : 'color: var(--text-sec); font-weight:500;';
            
        const alertsIconStyle = activeCount > 0 
            ? 'color: var(--danger); background: var(--white);' 
            : 'color: var(--primary); background: var(--bg-light);';
            
        const alertsValueStyle = activeCount > 0 
            ? 'color: var(--danger);' 
            : 'color: var(--text-main);';
            
        const alertsSubText = activeCount > 0 
            ? 'Requieren atención' 
            : 'Todo en orden';
            
        const alertsSubStyle = activeCount > 0 
            ? 'color: var(--danger);' 
            : 'color: var(--text-meta);';

        return `
            <div class="app-layout">
                <aside class="sidebar">
                    <div class="sidebar-header">💊 MediAlarm</div>
                    <nav class="sidebar-nav">
                        <a href="#dashboard" class="nav-item active"><span>🏠</span> Dashboard</a>
                        <a href="#history" class="nav-item"><span>📋</span> Historial</a>
                        <a href="#alerts" class="nav-item"><span>🔔</span> Alertas ${badgeHtml}</a>
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
                        <h2 class="header-title">Panel Principal</h2>
                        <div class="header-actions">
                            <a href="#alerts" class="bell-icon" style="text-decoration: none;">🔔${bellDotHtml}</a>
                            <div class="user-profile">
                                <div class="user-info"><p class="u-name">Ana García</p><p class="u-role">Familiar</p></div>
                                <div class="u-avatar">👤</div>
                            </div>
                        </div>
                    </header>

                    ${showBanner ? `
                    <div class="alert-banner" id="alert-banner">
                        <div class="ab-left">
                            <div class="ab-icon">⚠️</div>
                            <p class="ab-text">¡Alerta de medicación! María no ha confirmado Losartán programado a las 08:00</p>
                        </div>
                        <div class="ab-actions">
                            <a href="#dashboard" class="btn btn-sec" style="height: 36px;">📞 Llamar</a>
                            <button class="btn btn-pri" id="btn-entendido" style="height: 36px;">Entendido</button>
                            <button class="btn-icon" id="btn-close-banner">✖</button>
                        </div>
                    </div>
                    ` : ''}

                    <div class="content-area">
                        <div style="display: flex; justify-content: space-between; margin-bottom: 24px;">
                            <div>
                                <h1 style="font-size: 24px; color: var(--text-main);">Buenos días, Ana</h1>
                                <p style="color: var(--text-meta); margin-top: 4px;">Resumen del jueves, 19 de febrero</p>
                            </div>
                        </div>

                        <div class="stat-grid">
                            <div class="stat-card">
                                <div class="sc-top"><p class="sc-title">Medicinas de Hoy</p><div class="sc-icon">💊</div></div>
                                <h3 class="sc-value">${patientData.today.taken}/${patientData.today.total}</h3>
                                <p class="sc-sub">Dosis tomadas</p>
                            </div>
                            <div class="stat-card">
                                <div class="sc-top"><p class="sc-title">Cumplimiento</p><div class="sc-icon">📈</div></div>
                                <h3 class="sc-value">${adherence}%</h3>
                                <p class="sc-sub">Últimos 7 días</p>
                                <p class="sc-trend">↑ 2.5% vs. semana pasada</p>
                            </div>
                            <div class="stat-card" style="${alertsCardStyle}">
                                <div class="sc-top"><p class="sc-title" style="${alertsTitleStyle}">Alertas Activas</p><div class="sc-icon" style="${alertsIconStyle}">⚠️</div></div>
                                <h3 class="sc-value" style="${alertsValueStyle}">${activeCount}</h3>
                                <p class="sc-sub" style="${alertsSubStyle}">${alertsSubText}</p>
                            </div>
                            <div class="stat-card">
                                <div class="sc-top"><p class="sc-title">Próxima Toma</p><div class="sc-icon">⏰</div></div>
                                <h3 class="sc-value">${patientData.today.nextDose}</h3>
                                <p class="sc-sub">${patientData.today.nextMed}</p>
                            </div>
                        </div>

                        <div class="dash-cols">
                            <div class="card-box">
                                <div class="cb-header">
                                    <h3 class="cb-title">Agenda de Hoy</h3>
                                    <span class="cb-subtitle">${patientData.today.total} dosis programadas</span>
                                </div>
                                <div class="agenda-list">
                                    <div class="agenda-item">
                                        <div class="ai-left">
                                            <div class="ai-time"><h4>07:30</h4><span>Horario</span></div>
                                            <div class="ai-med"><h4>Omeprazol</h4><p>20mg</p></div>
                                        </div>
                                        <div class="ai-right">
                                            <span class="ai-actual">Tomada a las 07:35</span>
                                            <span class="status-badge sb-taken">✓ Tomada</span>
                                        </div>
                                    </div>
                                    <div class="agenda-item">
                                        <div class="ai-left">
                                            <div class="ai-time"><h4>08:00</h4><span>Horario</span></div>
                                            <div class="ai-med"><h4>Losartán</h4><p>50mg</p></div>
                                        </div>
                                        <div class="ai-right">
                                            <span class="status-badge sb-missed">✖ Saltada</span>
                                        </div>
                                    </div>
                                    <div class="agenda-item">
                                        <div class="ai-left">
                                            <div class="ai-time"><h4>08:00</h4><span>Horario</span></div>
                                            <div class="ai-med"><h4>Metformina</h4><p>850mg</p></div>
                                        </div>
                                        <div class="ai-right">
                                            <span class="ai-actual">Tomada a las 08:10</span>
                                            <span class="status-badge sb-taken">✓ Tomada</span>
                                        </div>
                                    </div>
                                    <div class="agenda-item">
                                        <div class="ai-left">
                                            <div class="ai-time"><h4>14:00</h4><span>Horario</span></div>
                                            <div class="ai-med"><h4>Metformina</h4><p>850mg</p></div>
                                        </div>
                                        <div class="ai-right">
                                            <span class="status-badge sb-pending">⏳ Pendiente</span>
                                        </div>
                                    </div>
                                    <div class="agenda-item">
                                        <div class="ai-left">
                                            <div class="ai-time"><h4>20:00</h4><span>Horario</span></div>
                                            <div class="ai-med"><h4>Losartán</h4><p>50mg</p></div>
                                        </div>
                                        <div class="ai-right">
                                            <span class="status-badge sb-pending">⏳ Pendiente</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div style="display: flex; flex-direction: column; gap: 24px;">
                                <div class="card-box chart-wrap">
                                    <h3 class="cb-title" style="margin-bottom: 20px;">Adherencia Semanal</h3>
                                    <div class="chart-bars">
                                        ${patientData.weeklyAdherence.map((val, i) => `
                                            <div class="c-bar-group">
                                                <div class="c-bar ${getBarClass(val)}" style="height: ${val}%;"></div>
                                                <span class="c-label">${['Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb', 'Dom'][i]}</span>
                                            </div>
                                        `).join('')}
                                    </div>
                                    <div class="chart-legend">
                                        <div class="cl-item"><div class="cl-dot" style="background: var(--primary);"></div> Excelente</div>
                                        <div class="cl-item"><div class="cl-dot" style="background: var(--warning);"></div> Regular</div>
                                        <div class="cl-item"><div class="cl-dot" style="background: var(--danger);"></div> Atención</div>
                                    </div>
                                </div>

                                <div class="card-box">
                                    <div class="cb-header"><h3 class="cb-title">Alertas Recientes</h3></div>
                                    <div style="padding: 16px;">
                                        ${activeAlerts.length === 0 
                                            ? `<div style="text-align:center; padding: 10px; color: var(--text-meta); font-size: 13px;">No hay alertas recientes 🎉</div>`
                                            : activeAlerts.map(alert => `
                                                <div style="display: flex; gap: 12px; margin-bottom: 16px; align-items: flex-start;">
                                                    <div class="ab-icon" style="width:24px; height:24px; font-size:12px; flex-shrink: 0;">⚠️</div>
                                                    <div>
                                                        <p style="font-size: 13px; font-weight: 500;">María no ha confirmado ${alert.med}</p>
                                                        <p style="font-size: 11px; color: var(--text-meta);">${alert.timeActual}</p>
                                                    </div>
                                                </div>
                                            `).join('')
                                        }
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        `;
    }

    onMount(): void {
        const banner = document.getElementById('alert-banner');
        const btnEntendido = document.getElementById('btn-entendido');
        const btnClose = document.getElementById('btn-close-banner');

        if (banner && btnEntendido && btnClose) {
            const hideBannerAction = () => {
                hideBanner(); // Actualiza el estado global
                banner.style.display = 'none'; // Oculta visualmente
            };

            btnEntendido.addEventListener('click', hideBannerAction);
            btnClose.addEventListener('click', hideBannerAction);
        }
    }
}

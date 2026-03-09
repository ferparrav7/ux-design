import { patientData, getAdherence, getActiveCount } from '../data/mockData.js';
// Datos mockeados para la tabla de historial
const historyData = [
    { date: '19/02/2026', time: '07:30', med: 'Omeprazol', dose: '20mg', status: 'taken', notes: 'Tomada a las 07:35' },
    { date: '19/02/2026', time: '08:00', med: 'Metformina', dose: '850mg', status: 'taken', notes: 'Tomada a las 08:10' },
    { date: '19/02/2026', time: '08:00', med: 'Losartán', dose: '50mg', status: 'missed', notes: '-' },
    { date: '18/02/2026', time: '21:00', med: 'Atorvastatina', dose: '40mg', status: 'taken', notes: 'Tomada a las 21:05' },
    { date: '18/02/2026', time: '20:00', med: 'Losartán', dose: '50mg', status: 'taken', notes: 'Tomada a las 20:02' },
    { date: '18/02/2026', time: '20:00', med: 'Metformina', dose: '850mg', status: 'taken', notes: 'Tomada a las 20:15' },
    { date: '18/02/2026', time: '14:00', med: 'Metformina', dose: '850mg', status: 'pending', notes: '-' },
    { date: '17/02/2026', time: '08:00', med: 'Losartán', dose: '50mg', status: 'missed', notes: 'Olvido' }
];
export class HistoryScreen {
    constructor() {
        this.currentData = [...historyData];
    }
    render() {
        const adherence = getAdherence();
        const activeCount = getActiveCount();
        const badgeHtml = activeCount > 0 ? `<span class="badge">${activeCount}</span>` : '';
        const bellDotHtml = activeCount > 0 ? `<div class="bell-dot"></div>` : '';
        return `
            <div class="app-layout">
                <aside class="sidebar">
                    <div class="sidebar-header">💊 MediAlarm</div>
                    <nav class="sidebar-nav">
                        <a href="#dashboard" class="nav-item"><span>🏠</span> Dashboard</a>
                        <a href="#history" class="nav-item active"><span>📋</span> Historial</a>
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
                        <h2 class="header-title">Historial de Tomas</h2>
                        <div class="header-actions">
                            <a href="#alerts" class="bell-icon" style="text-decoration: none;">🔔${bellDotHtml}</a>
                            <div class="user-profile">
                                <div class="user-info"><p class="u-name">Ana García</p><p class="u-role">Familiar</p></div>
                                <div class="u-avatar">👤</div>
                            </div>
                        </div>
                    </header>

                    <div class="content-area">
                        <div style="display: flex; justify-content: space-between; align-items: flex-start; margin-bottom: 24px;">
                            <div>
                                <h1 style="font-size: 24px; color: var(--text-main);">Historial Completo</h1>
                                <p style="color: var(--text-meta); margin-top: 4px;">Registro detallado de todas las tomas</p>
                            </div>
                            <button class="btn btn-sec">📄 Exportar PDF</button>
                        </div>

                        <div class="filters-bar">
                            <input type="text" id="search-input" class="wire-input" placeholder="🔍 Buscar medicamento...">
                            <input type="date" class="wire-input" disabled style="opacity: 0.5; cursor: not-allowed;" title="Filtro deshabilitado">
                            <select id="status-select" class="wire-input wire-select">
                                <option value="all">Todos los estados</option>
                                <option value="taken">Tomada</option>
                                <option value="missed">Saltada</option>
                                <option value="pending">Pendiente</option>
                            </select>
                            <button id="btn-apply-filters" class="btn btn-pri">Aplicar Filtros</button>
                        </div>

                        <div class="table-wrap">
                            <table>
                                <thead>
                                <tr>
                                    <th>FECHA</th>
                                    <th>HORA</th>
                                    <th>MEDICAMENTO</th>
                                    <th>DOSIS</th>
                                    <th>ESTADO</th>
                                    <th>NOTAS</th>
                                </tr>
                                </thead>
                                <tbody id="history-table-body">
                                    ${this.renderTableRows(this.currentData)}
                                </tbody>
                            </table>

                            <div class="pagination">
                                <div class="page-info">Mostrando <span style="font-weight:600;" id="showing-count">${this.currentData.length}</span> resultados</div>
                                <div class="page-controls">
                                    <button class="page-btn">Anterior</button>
                                    <button class="page-btn active">1</button>
                                    <button class="page-btn">2</button>
                                    <button class="page-btn">3</button>
                                    <button class="page-btn">Siguiente</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        `;
    }
    renderTableRows(data) {
        if (data.length === 0) {
            return `<tr><td colspan="6" style="text-align: center; padding: 24px; color: var(--text-meta);">No se encontraron resultados</td></tr>`;
        }
        return data.map(row => {
            let badgeClass = '';
            let badgeText = '';
            if (row.status === 'taken') {
                badgeClass = 'sb-taken';
                badgeText = '✓ Tomada';
            }
            else if (row.status === 'missed') {
                badgeClass = 'sb-missed';
                badgeText = '✖ Saltada';
            }
            else {
                badgeClass = 'sb-pending';
                badgeText = '⏳ Pendiente';
            }
            return `
                <tr>
                    <td>${row.date}</td>
                    <td>${row.time}</td>
                    <td style="font-weight: 600;">${row.med}</td>
                    <td>${row.dose}</td>
                    <td><span class="status-badge ${badgeClass}">${badgeText}</span></td>
                    <td style="color: var(--text-meta);">${row.notes}</td>
                </tr>
            `;
        }).join('');
    }
    onMount() {
        const searchInput = document.getElementById('search-input');
        const statusSelect = document.getElementById('status-select');
        const btnApply = document.getElementById('btn-apply-filters');
        const tableBody = document.getElementById('history-table-body');
        const showingCount = document.getElementById('showing-count');
        const filterData = () => {
            const searchTerm = searchInput.value.toLowerCase();
            const statusFilter = statusSelect.value;
            this.currentData = historyData.filter(item => {
                const matchesSearch = item.med.toLowerCase().includes(searchTerm);
                const matchesStatus = statusFilter === 'all' || item.status === statusFilter;
                return matchesSearch && matchesStatus;
            });
            if (tableBody) {
                tableBody.innerHTML = this.renderTableRows(this.currentData);
            }
            if (showingCount) {
                showingCount.textContent = this.currentData.length.toString();
            }
        };
        if (btnApply) {
            btnApply.addEventListener('click', filterData);
        }
        if (searchInput) {
            searchInput.addEventListener('keyup', (e) => {
                if (e.key === 'Enter')
                    filterData();
            });
        }
    }
}

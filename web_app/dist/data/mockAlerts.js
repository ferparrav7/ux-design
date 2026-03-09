import { hideBanner, showBannerAgain } from './mockDashboard.js';
const alertsData = [
    {
        id: 1,
        med: 'Losartán',
        msg: 'María no ha confirmado la toma de Losartán programada a las 08:00',
        timeScheduled: '08:00',
        timeActual: '19 feb 2026, 08:15',
        severity: 'high',
        status: 'active'
    },
    {
        id: 2,
        med: 'Metformina',
        msg: 'Toma retrasada confirmada por cuidador',
        timeScheduled: 'Ayer 20:00',
        timeActual: 'Resuelto por Ana García',
        severity: 'medium',
        status: 'resolved',
        resolvedBy: 'Ana García'
    },
    {
        id: 3,
        med: 'Losartán',
        msg: 'María no ha confirmado la toma de Losartán programada a las 08:00',
        timeScheduled: 'Hoy 08:00',
        timeActual: 'Resuelto por Ana García',
        severity: 'medium',
        status: 'resolved',
        resolvedBy: 'Ana García'
    }
];
export const getActiveAlerts = () => alertsData.filter(a => a.status === 'active');
export const getResolvedAlerts = () => alertsData.filter(a => a.status === 'resolved');
export const getActiveCount = () => alertsData.filter(a => a.status === 'active').length;
export const resolveAlert = (id) => {
    const alert = alertsData.find(a => a.id === id);
    if (alert) {
        alert.status = 'resolved';
        alert.severity = 'medium';
        alert.resolvedBy = 'Ana García';
        alert.timeActual = 'Recién resuelto';
        if (id === 1) {
            hideBanner();
        }
    }
};
export const unresolveAlert = (id) => {
    const alert = alertsData.find(a => a.id === id);
    if (alert) {
        alert.status = 'active';
        alert.severity = 'high';
        alert.resolvedBy = undefined;
        alert.timeActual = 'Reactivada';
        if (id === 1) {
            showBannerAgain();
        }
    }
};

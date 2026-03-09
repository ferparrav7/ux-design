export const patientData = {
    name: "María García López",
    age: 78,
    // Datos diarios para el gráfico con variabilidad para probar colores
    // Excelente (>=90), Regular (>=70), Atención (<70)
    weeklyAdherence: [100, 92, 75, 95, 60, 92, 40],
    today: {
        total: 7,
        taken: 6,
        nextDose: "14:00",
        nextMed: "Metformina"
    }
};
/**
 * Calcula la adherencia total como el promedio de la adherencia semanal
 */
export const getAdherence = () => {
    const sum = patientData.weeklyAdherence.reduce((acc, val) => acc + val, 0);
    return Math.round(sum / patientData.weeklyAdherence.length);
};
// --- ESTADO DEL BANNER ---
let isBannerVisible = true;
export const getBannerVisibility = (hasActiveAlerts) => {
    return isBannerVisible && hasActiveAlerts;
};
export const hideBanner = () => { isBannerVisible = false; };
export const showBannerAgain = () => { isBannerVisible = true; };

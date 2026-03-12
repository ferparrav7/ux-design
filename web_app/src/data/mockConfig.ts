// --- CONFIGURACIÓN DE NOTIFICACIONES ---
export interface NotificationSettings {
    email: boolean;
    push: boolean;
    sms: boolean;
}

const notificationSettings: NotificationSettings = {
    email: true,
    push: true,
    sms: false
};

export const getNotificationSettings = () => notificationSettings;
export const updateNotificationSetting = (key: keyof NotificationSettings, value: boolean) => {
    notificationSettings[key] = value;
};

// --- GESTIÓN DE MEDICAMENTOS ---
export interface Medication {
    id: number;
    name: string;
    dose: string;
    frequency: string;
    times: string;
}

let medicationsData: Medication[] = [
    { id: 1, name: 'Metformina', dose: '850mg', frequency: '3 veces al día', times: '08:00, 14:00, 20:00' },
    { id: 2, name: 'Losartán', dose: '50mg', frequency: '2 veces al día', times: '08:00, 20:00' },
    { id: 3, name: 'Omeprazol', dose: '20mg', frequency: '1 vez al día', times: '07:30' },
    { id: 4, name: 'Atorvastatina', dose: '40mg', frequency: '1 vez al día', times: '21:00' }
];

export const getMedications = () => medicationsData;
export const deleteMedication = (id: number) => {
    medicationsData = medicationsData.filter(m => m.id !== id);
};

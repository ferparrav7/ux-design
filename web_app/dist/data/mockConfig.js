const notificationSettings = {
    email: true,
    push: true,
    sms: false
};
export const getNotificationSettings = () => notificationSettings;
export const updateNotificationSetting = (key, value) => {
    notificationSettings[key] = value;
};
let medicationsData = [
    { id: 1, name: 'Metformina', dose: '850mg', frequency: '3 veces al día', times: '08:00, 14:00, 20:00' },
    { id: 2, name: 'Losartán', dose: '50mg', frequency: '2 veces al día', times: '08:00, 20:00' },
    { id: 3, name: 'Omeprazol', dose: '20mg', frequency: '1 vez al día', times: '07:30' },
    { id: 4, name: 'Atorvastatina', dose: '40mg', frequency: '1 vez al día', times: '21:00' }
];
export const getMedications = () => medicationsData;
export const deleteMedication = (id) => {
    medicationsData = medicationsData.filter(m => m.id !== id);
};

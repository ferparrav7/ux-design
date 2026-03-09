# MediAlarm Web

MediAlarm es una aplicación web diseñada para el monitoreo de medicación y gestión de alertas para pacientes y sus familiares. Esta versión web proporciona una interfaz moderna y funcional basada en los wireframes originales.

## 🚀 Características

*   **Dashboard Principal**: Resumen diario de tomas, adherencia dinámica y gestión de alertas en tiempo real.
*   **Gestión de Alertas**: Sistema interactivo para visualizar, resolver y reactivar alertas de medicación.
*   **Historial**: Registro detallado de todas las tomas con filtros funcionales por nombre de medicamento y estado.
*   **Configuración**: Gestión persistente de notificaciones, visualización de datos del paciente y administración de medicamentos (con diálogos de confirmación).
*   **Validación de Login**: Control de acceso con validación de formato de correo electrónico.
*   **Diseño semi-Responsivo**: Interfaz adaptada para una experiencia de usuario fluida y profesional.

## 🛠️ Tecnologías

*   **HTML5**: Estructura semántica.
*   **CSS3**: Estilos personalizados basados en variables CSS para una fácil personalización.
*   **TypeScript**: Lógica de la aplicación y tipado estático para mayor robustez.
*   **Vanilla JS Router**: Sistema de enrutamiento ligero basado en hash para una SPA (Single Page Application).
*   **Modular Data Store**: Datos centralizados y divididos por módulos para una mejor organización.

## 📂 Estructura del Proyecto

```
MediAlarm/
├── index.html              # Punto de entrada de la aplicación
├── package.json            # Configuración de npm y scripts
├── tsconfig.json           # Configuración de TypeScript
├── README.md               # Documentación del proyecto
├── dist/                   # Archivos JavaScript compilados (generado automáticamente)
└── src/
    ├── app.ts              # Lógica principal e inicialización
    ├── router.ts           # Enrutador simple para la navegación
    ├── data/               # Capa de datos (Mock Data)
    │   ├── mockData.ts      # Archivo barril
    │   ├── mockDashboard.ts
    │   ├── mockAlerts.ts
    │   └── mockConfig.ts
    ├── styles/
    │   └── main.css        # Hoja de estilos principal
    └── screens/            # Componentes de las pantallas
        ├── LoginScreen.ts
        ├── DashboardScreen.ts
        ├── HistoryScreen.ts
        ├── AlertsScreen.ts
        ├── AlertsResolvedScreen.ts
        └── ConfigScreen.ts
```

## ⚙️ Instalación y Ejecución

1.  **Prerrequisitos**: Asegúrate de tener [Node.js](https://nodejs.org/) instalado.

2.  **Instalar dependencias**:
    ```bash
    npm install
    ```

3.  **Compilar TypeScript**:
    Para compilar el código TypeScript a JavaScript y observar cambios automáticamente:
    ```bash
    npm start
    ```
    Esto ejecutará `tsc -w` y generará los archivos en la carpeta `dist/`.

4.  **Ejecutar la aplicación**:
    Para evitar problemas de CORS con módulos ES6, sirve el proyecto usando un servidor local:

    ```bash
    npx serve .
    ```
    Luego abre la URL proporcionada (`http://localhost:3000`) en tu navegador.

## 🎨 Personalización

Los colores y estilos base se encuentran definidos como variables CSS en `src/styles/main.css` bajo la sección `:root`, lo que facilita la adaptación de la paleta de colores (Style Tile).

## 📄 Licencia

Este proyecto está bajo la licencia ISC.

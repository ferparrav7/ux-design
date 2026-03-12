# MediAlarm – Frontend móvil (maquetación)

Aplicación Android de **solo maquetación** que replica las 20 pantallas definidas en los mockups de MediAlarm. Sin lógica ni backend; interfaces navegables y controles interactivos a nivel visual.

## Requisitos

- **minSdk:** 27 (Android 8.1)
- **targetSdk:** 34
- Kotlin 1.9 + Jetpack Compose

## Cómo abrir y ejecutar

1. Abre el proyecto en **Android Studio** (Arctic Fox o superior).
2. Si es la primera vez, Android Studio generará el wrapper de Gradle automáticamente. Sincroniza y espera la indexación.
3. Conecta un dispositivo o inicia un emulador (API 27 o superior).
4. Pulsa **Run** o, desde terminal (con el wrapper ya generado):
   ```bash
   gradlew.bat installDebug
   ```

## Cómo generar el APK

Asegúrate de tener **JAVA_HOME** apuntando a un JDK 17 válido y el **Android SDK** instalado (o abre el proyecto en Android Studio, que los usa automáticamente).

Desde la raíz del proyecto:

```bash
# Windows
gradlew.bat assembleDebug

# Linux / macOS
./gradlew assembleDebug
```

El APK se genera en:

`app/build/outputs/apk/debug/app-debug.apk`

Instalable en dispositivos con **API 27 o superior**.

## Pantallas incluidas (20)

1. Splash  
2. Login  
3. Verificar SMS  
4. Perfil  
5. Vincular familiar  
6. Home  
7. Selector agregar (voz / manual)  
8. Escuchando voz  
9. Confirmar voz  
10. Wizard – Nombre  
11. Wizard – Hora  
12. Wizard – Tipo  
13. Wizard – Frecuencia  
14. Wizard – Días  
15. Alarma (pantalla de recordatorio)  
16. Historial  
17. Configuración  
18. Detalle alarma  
19. Confirmar borrar  
20. Seleccionar contactos  

Navegación entre pantallas mediante botones y flujos del mockup. Switches, tabs y selección de opciones son interactivos en la UI pero no guardan datos.

## Repositorio

- **URL del repositorio:** (añade aquí la URL de tu repositorio git público una vez subas el proyecto)

## APK para entrega

- **Enlace de descarga del APK:** (sube el archivo `app-debug.apk` a una carpeta compartida con permisos de acceso e ingresa aquí el vínculo para descargarlo)


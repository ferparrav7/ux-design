package com.medialarm.ui.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object VerificarSms : Screen("verificar_sms")
    data object Perfil : Screen("perfil")
    data object Vincular : Screen("vincular")
    data object Home : Screen("home")
    data object SelectorAgregar : Screen("selector_agregar")
    data object EscuchandoVoz : Screen("escuchando_voz")
    data object ConfirmarVoz : Screen("confirmar_voz")
    data object WizardNombre : Screen("wizard_nombre")
    data object WizardHora : Screen("wizard_hora")
    data object WizardTipo : Screen("wizard_tipo")
    data object WizardFrecuencia : Screen("wizard_frecuencia")
    data object WizardDias : Screen("wizard_dias")
    data object Alarma : Screen("alarma")
    data object Historial : Screen("historial")
    data object Config : Screen("config")
    data object DetalleAlarma : Screen("detalle_alarma")
    data object ConfirmarBorrar : Screen("confirmar_borrar")
    data object SeleccionarContactos : Screen("seleccionar_contactos")
}

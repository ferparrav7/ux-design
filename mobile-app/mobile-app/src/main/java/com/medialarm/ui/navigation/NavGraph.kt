package com.medialarm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.medialarm.ui.screens.*

@Composable
fun MediAlarmNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(onNavigate = { navController.navigate(Screen.Login.route) { popUpTo(0) { inclusive = true } } })
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateVerificar = { navController.navigate(Screen.VerificarSms.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.VerificarSms.route) {
            VerificarSmsScreen(
                onNavigatePerfil = { navController.navigate(Screen.Perfil.route) { popUpTo(Screen.Login.route) { inclusive = true } } },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Perfil.route) {
            PerfilScreen(
                onNavigateVincular = { navController.navigate(Screen.Vincular.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Vincular.route) {
            VincularScreen(
                onNavigateHome = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Perfil.route) { inclusive = true } } },
                onSkip = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Perfil.route) { inclusive = true } } },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateConfig = { navController.navigate(Screen.Config.route) },
                onNavigateHistorial = { navController.navigate(Screen.Historial.route) },
                onNavigateAgregar = { navController.navigate(Screen.SelectorAgregar.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.SelectorAgregar.route) {
            SelectorAgregarScreen(
                onNavigateVoz = { navController.navigate(Screen.EscuchandoVoz.route) },
                onNavigateManual = { navController.navigate(Screen.WizardNombre.route) },
                onCancel = { navController.popBackStack() }
            )
        }
        composable(Screen.EscuchandoVoz.route) {
            EscuchandoVozScreen(
                onContinue = { navController.navigate(Screen.ConfirmarVoz.route) },
                onCancel = { navController.popBackStack() }
            )
        }
        composable(Screen.ConfirmarVoz.route) {
            ConfirmarVozScreen(
                onConfirm = { navController.navigate(Screen.Alarma.route) { popUpTo(Screen.SelectorAgregar.route) { inclusive = true } } },
                onRetry = { navController.popBackStack() },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.WizardNombre.route) {
            WizardNombreScreen(
                onNext = { navController.navigate(Screen.WizardHora.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.WizardHora.route) {
            WizardHoraScreen(
                onNext = { navController.navigate(Screen.WizardTipo.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.WizardTipo.route) {
            WizardTipoScreen(
                onNext = { navController.navigate(Screen.WizardFrecuencia.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.WizardFrecuencia.route) {
            WizardFrecuenciaScreen(
                onNext = { navController.navigate(Screen.WizardDias.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.WizardDias.route) {
            WizardDiasScreen(
                onCreate = { navController.navigate(Screen.Alarma.route) { popUpTo(Screen.SelectorAgregar.route) { inclusive = true } } },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Alarma.route) {
            AlarmaScreen(
                onNavigateHome = { navController.navigate(Screen.Home.route) { popUpTo(0) { inclusive = true } } },
                onNavigateDetalle = { navController.navigate(Screen.DetalleAlarma.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Historial.route) {
            HistorialScreen(
                onNavigateHome = { navController.navigate(Screen.Home.route) },
                onNavigateConfig = { navController.navigate(Screen.Config.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Config.route) {
            ConfigScreen(
                onNavigateHome = { navController.navigate(Screen.Home.route) },
                onNavigateHistorial = { navController.navigate(Screen.Historial.route) },
                onNavigateDetalleAlarma = { navController.navigate(Screen.DetalleAlarma.route) },
                onNavigateContactos = { navController.navigate(Screen.SeleccionarContactos.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.DetalleAlarma.route) {
            DetalleAlarmaScreen(
                onEdit = { },
                onCancelAlarm = { navController.navigate(Screen.ConfirmarBorrar.route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.ConfirmarBorrar.route) {
            ConfirmarBorrarScreen(
                onConfirm = { navController.navigate(Screen.Home.route) { popUpTo(Screen.DetalleAlarma.route) { inclusive = true } } },
                onCancel = { navController.popBackStack() }
            )
        }
        composable(Screen.SeleccionarContactos.route) {
            SeleccionarContactosScreen(
                onSend = { navController.popBackStack() },
                onCancel = { navController.popBackStack() }
            )
        }
    }
}

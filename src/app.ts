import { Router } from './router.js';
import { LoginScreen } from './screens/LoginScreen.js';
import { DashboardScreen } from './screens/DashboardScreen.js';
import { HistoryScreen } from './screens/HistoryScreen.js';
import { AlertsScreen } from './screens/AlertsScreen.js';
import { AlertsResolvedScreen } from './screens/AlertsResolvedScreen.js';
import { ConfigScreen } from './screens/ConfigScreen.js';

class App {
    private router: Router;

    constructor() {
        this.router = new Router();
        this.init();
    }

    private init() {
        this.router.addRoute('login', new LoginScreen());
        this.router.addRoute('dashboard', new DashboardScreen());
        this.router.addRoute('history', new HistoryScreen());
        this.router.addRoute('alerts', new AlertsScreen());
        this.router.addRoute('alerts-resolved', new AlertsResolvedScreen());
        this.router.addRoute('config', new ConfigScreen());

        // Initial navigation
        const hash = window.location.hash.slice(1) || 'login';
        this.router.navigateTo(hash);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    new App();
});

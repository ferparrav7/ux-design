export class Router {
    constructor() {
        this.routes = new Map();
        this.currentRoute = null;
        this.appContainer = document.getElementById('app');
        window.addEventListener('hashchange', this.handleHashChange.bind(this));
    }
    addRoute(path, screen) {
        this.routes.set(path, screen);
    }
    navigateTo(path) {
        window.location.hash = path;
        this.loadRoute(path);
    }
    handleHashChange() {
        const hash = window.location.hash.slice(1) || 'login';
        this.loadRoute(hash);
    }
    loadRoute(path) {
        const screen = this.routes.get(path);
        if (screen) {
            this.currentRoute = path;
            this.appContainer.innerHTML = screen.render();
            if (screen.onMount) {
                screen.onMount();
            }
        }
        else {
            console.error(`Route not found: ${path}`);
            if (path !== 'login') {
                this.navigateTo('login');
            }
        }
    }
}

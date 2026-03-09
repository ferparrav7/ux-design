export interface Screen {
    render(): string;
    onMount?(): void;
}

export class Router {
    private routes: Map<string, Screen> = new Map();
    private currentRoute: string | null = null;
    private appContainer: HTMLElement;

    constructor() {
        this.appContainer = document.getElementById('app') as HTMLElement;
        window.addEventListener('hashchange', this.handleHashChange.bind(this));
    }

    public addRoute(path: string, screen: Screen) {
        this.routes.set(path, screen);
    }

    public navigateTo(path: string) {
        window.location.hash = path;
        this.loadRoute(path);
    }

    private handleHashChange() {
        const hash = window.location.hash.slice(1) || 'login';
        this.loadRoute(hash);
    }

    private loadRoute(path: string) {
        const screen = this.routes.get(path);
        if (screen) {
            this.currentRoute = path;
            this.appContainer.innerHTML = screen.render();
            if (screen.onMount) {
                screen.onMount();
            }
        } else {
            console.error(`Route not found: ${path}`);
            if (path !== 'login') {
                this.navigateTo('login');
            }
        }
    }
}

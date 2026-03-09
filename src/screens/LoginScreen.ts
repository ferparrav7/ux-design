import { Screen } from '../router.js';

export class LoginScreen implements Screen {
    render(): string {
        return `
            <div class="login-layout">
                <div class="login-box">
                    <div class="lb-icon">💊</div>
                    <h1 class="lb-title">MediAlarm</h1>
                    <p class="lb-sub">Portal Familiar de Monitoreo</p>

                    <div class="lb-form">
                        <div class="form-group">
                            <label>Correo Electrónico</label>
                            <input type="email" id="email-input" class="wire-input" placeholder="nombre@ejemplo.com">
                            <p id="email-error" style="color: var(--danger); font-size: 11px; margin-top: 4px; display: none;">Por favor, ingresa un correo electrónico válido.</p>
                        </div>
                        <div class="form-group" style="margin-top: 16px;">
                            <label>Contraseña</label>
                            <input type="password" id="password-input" class="wire-input" placeholder="••••••••">
                        </div>
                        <div class="lb-options">
                            <label><input type="checkbox"> Recordarme</label>
                            <a href="#">¿Olvidaste tu contraseña?</a>
                        </div>
                        <button id="btn-login" class="btn btn-pri" style="width: 100%; padding: 14px; font-size: 14px; border: none;">Iniciar Sesión →</button>
                    </div>

                    <div style="margin-top: 32px; padding-top: 24px; border-top: 1px solid var(--border); font-size: 13px; color: var(--text-meta);">
                        ¿Necesitas ayuda? <a href="#" style="color: var(--primary); font-weight: 500; text-decoration: none;">Contactar soporte</a>
                    </div>
                </div>
            </div>
        `;
    }

    onMount(): void {
        const emailInput = document.getElementById('email-input') as HTMLInputElement;
        const emailError = document.getElementById('email-error') as HTMLElement;
        const btnLogin = document.getElementById('btn-login') as HTMLButtonElement;

        const validateEmail = (email: string) => {
            const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return re.test(email);
        };

        const handleLogin = () => {
            const email = emailInput.value;
            if (validateEmail(email)) {
                emailError.style.display = 'none';
                emailInput.style.borderColor = 'var(--border)';
                // Navegar al dashboard si es válido
                window.location.hash = 'dashboard';
            } else {
                emailError.style.display = 'block';
                emailInput.style.borderColor = 'var(--danger)';
            }
        };

        if (btnLogin) {
            btnLogin.addEventListener('click', handleLogin);
        }

        if (emailInput) {
            emailInput.addEventListener('keyup', (e) => {
                if (e.key === 'Enter') handleLogin();
            });
        }
    }
}

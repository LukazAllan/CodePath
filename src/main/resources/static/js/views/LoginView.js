// View: responsável por renderizar a UI de login e capturar eventos do usuário.

export default class LoginView {
    constructor() {
        this.app = document.getElementById('app-root');
        this.render();
    }

    // Renderiza o HTML do formulário de login dentro da <main id="app-root">
    render() {
        this.app.innerHTML = `
            <div class="login-container">
                <img src="/assets/Logo.jpg" alt="Logo da CodePath" class="logo">
                <h2>Acesse a plataforma</h2>

                <form id="login-form">
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" id="email" placeholder="seuemail@exemplo.com" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input type="password" id="password" placeholder="Sua senha" required>
                    </div>

                    <p id="error-message" class="error"></p>

                    <button type="submit" class="btn-primary">Entrar</button>
                </form>

                <div class="login-links">
                    <a href="#" id="link-forgot-password">Esqueci a senha</a>
                    <a href="#" id="link-register">Criar uma conta</a>
                </div>
                </div>
                `;
                }

                /**
                * Conecta o evento de submissão do formulário a uma função (handler)
                * que será fornecida pelo Controller.
                * @param {Function} handler A função que deve ser executada quando o form for enviado.
                */
                bindLogin(handler) {
                const form = document.getElementById('login-form');
                form.addEventListener('submit', event => {
                event.preventDefault(); // Impede o recarregamento da página

                const email = document.getElementById('email').value;
                const password = document.getElementById('password').value;

                // Chama a função do controller com os dados do form
                handler(email, password);
                });
                }

                bindLinkRegister(handler) {
                    document.getElementById('link-register').addEventListener('click', event => {
                        event.preventDefault();
                        handler();
                    });
                }

                bindLinkForgotPassword(handler) {
                    document.getElementById('link-forgot-password').addEventListener('click', event => {
                        event.preventDefault();
                        handler();
                    });
                }

                /**
                * Exibe uma mensagem de erro no parágrafo #error-message
                * @param {string} message A mensagem de erro a ser exibida.
                */
    displayError(message) {
        const errorElement = document.getElementById('error-message');
        errorElement.textContent = message;
        errorElement.style.display = 'block'; // Garante que o elemento seja visível
    }
}

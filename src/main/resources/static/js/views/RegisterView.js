export default class RegisterView {
    constructor() {
        this.app = document.getElementById('app-root');
    }

    render() {
        this.app.innerHTML = `
            <div class="login-container">
                <h2>Crie sua conta</h2>
                <form id="register-form">
                    <div class="form-group">
                        <label for="name">Nome Completo</label>
                        <input type="text" id="name" placeholder="Seu nome" required>
                    </div>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" id="email" placeholder="seuemail@exemplo.com" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input type="password" id="password" placeholder="Mínimo 6 caracteres" required>
                    </div>
                    <p id="error-message" class="error"></p>
                    <button type="submit" class="btn-primary">Cadastrar</button>
                </form>
                <div class="login-links">
                    <a href="#" id="link-login">Já tem uma conta? Entre aqui</a>
                </div>
            </div>
        `;
    }

    bindRegister(handler) {
        document.getElementById('register-form').addEventListener('submit', e => {
            e.preventDefault();
            const name = document.getElementById('name').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            handler(name, email, password);
        });
    }

    bindLinkLogin(handler) {
        document.getElementById('link-login').addEventListener('click', e => {
            e.preventDefault();
            handler();
        });
    }

    displayError(message) {
        const error = document.getElementById('error-message');
        error.textContent = message;
        error.style.display = 'block';
    }
}
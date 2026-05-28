export default class ForgotPasswordView {
    constructor() {
        this.app = document.getElementById('app-root');
    }

    render() {
        this.app.innerHTML = `
            <div class="login-container">
                <h2>Recuperar Senha</h2>
                <p style="color: #777; margin-bottom: 20px;">Insira seu e-mail para receber as instruções de recuperação.</p>
                
                <form id="forgot-password-form">
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" id="email" placeholder="seuemail@exemplo.com" required>
                    </div>
                    
                    <p id="message" class="error" style="color: #27ae60;"></p> <!-- Usando verde para sucesso -->
                    <p id="error-message" class="error"></p>

                    <button type="submit" class="btn-primary">Enviar Instruções</button>
                </form>

                <div class="login-links">
                    <a href="#" id="link-login">Voltar para o Login</a>
                </div>
            </div>
        `;
    }

    bindSubmit(handler) {
        document.getElementById('forgot-password-form').addEventListener('submit', e => {
            e.preventDefault();
            const email = document.getElementById('email').value;
            handler(email);
        });
    }

    bindLinkLogin(handler) {
        document.getElementById('link-login').addEventListener('click', e => {
            e.preventDefault();
            handler();
        });
    }

    displayMessage(message) {
        const msg = document.getElementById('message');
        msg.textContent = message;
        msg.style.display = 'block';
        document.getElementById('error-message').style.display = 'none';
    }

    displayError(message) {
        const error = document.getElementById('error-message');
        error.textContent = message;
        error.style.display = 'block';
        document.getElementById('message').style.display = 'none';
    }
}
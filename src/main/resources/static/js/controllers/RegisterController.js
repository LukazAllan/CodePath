import RegisterView from '../views/RegisterView.js';
import ApiService from '../services/api.js';

export default class RegisterController {
    constructor() {
        this.view = new RegisterView();
        this.apiService = new ApiService();
        this.view.render();
        this.view.bindRegister(this.handleRegister);
        this.view.bindLinkLogin(this.handleGoToLogin);
    }

    handleRegister = async (name, email, password) => {
        try {
            await this.apiService.signup(name, email, password);
            alert('Conta criada com sucesso! Agora faça seu login.');
            this.handleGoToLogin();
        } catch (error) {
            this.view.displayError(error.message);
        }
    }

    handleGoToLogin = async () => {
        // Importação dinâmica para evitar referência circular
        const { default: LoginController } = await import('./LoginController.js');
        new LoginController();
    }
}
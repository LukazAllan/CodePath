import ForgotPasswordView from '../views/ForgotPasswordView.js';
import ApiService from '../services/api.js';

export default class ForgotPasswordController {
    constructor() {
        this.view = new ForgotPasswordView();
        this.apiService = new ApiService();
        this.view.render();
        this.view.bindSubmit(this.handleSubmit);
        this.view.bindLinkLogin(this.handleGoToLogin);
    }

    handleSubmit = async (email) => {
        try {
            // Simulando uma chamada de API por enquanto
            console.log('Solicitando recuperação para:', email);
            
            // Simula um delay de rede
            this.view.displayMessage('Enviando...');
            await new Promise(resolve => setTimeout(resolve, 1500));

            this.view.displayMessage('Se este e-mail estiver cadastrado, você receberá um link de recuperação em instantes.');
            
        } catch (error) {
            this.view.displayError('Erro ao processar solicitação. Tente novamente.');
        }
    }

    handleGoToLogin = async () => {
        const { default: LoginController } = await import('./LoginController.js');
        new LoginController();
    }
}
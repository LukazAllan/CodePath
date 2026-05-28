import DashboardView from '../views/DashboardView.js';
import ApiService from '../services/api.js';

export default class DashboardController {
    constructor() {
        this.view = new DashboardView();
        this.apiService = new ApiService();
        this.init();
    }

    async init() {
        try {
            // Busca dados reais do usuário logado
            const userData = await this.apiService.me();
            this.view.render(userData);
            
            // Vincula o botão de logout
            this.view.bindLogout(this.handleLogout);
            this.view.bindNavPerfil(this.handleGoToPerfil);
            
        } catch (error) {
            console.error('Erro ao carregar Dashboard:', error);
            // Se der erro (ex: token inválido), volta para o login
            this.handleLogout();
        }
    }

    handleGoToPerfil = async () => {
        const { default: ProfileController } = await import('./ProfileController.js');
        new ProfileController();
    }

    handleLogout = async () => {
        this.apiService.logout();
        const { default: LoginController } = await import('./LoginController.js');
        new LoginController();
    }
}
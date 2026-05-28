import ProfileView from '../views/ProfileView.js';
import ApiService from '../services/api.js';

export default class ProfileController {
    constructor() {
        this.view = new ProfileView();
        this.apiService = new ApiService();
        this.init();
    }

    async init() {
        try {
            const userData = await this.apiService.me();
            this.view.render(userData);
            
            this.view.bindLogout(this.handleLogout);
            this.view.bindNavAprender(this.handleGoToAprender);
            
        } catch (error) {
            console.error('Erro ao carregar Perfil:', error);
            this.handleLogout();
        }
    }

    handleGoToAprender = async () => {
        const { default: DashboardController } = await import('./DashboardController.js');
        new DashboardController();
    }

    handleLogout = async () => {
        this.apiService.logout();
        const { default: LoginController } = await import('./LoginController.js');
        new LoginController();
    }
}
// Controller: o cérebro que conecta a View, o Model e os Services.
// js/controllers/LoginController.js
import LoginView from "../views/LoginView.js";
import ApiService from "../services/api.js";

export default class LoginController {
  constructor() {
    this.view = new LoginView();
    this.apiService = new ApiService();

    // Vincula o evento da View ao handler do Controller
    this.view.bindLogin(this.handleLogin);
    this.view.bindLinkRegister(this.handleGoToRegister);
    this.view.bindLinkForgotPassword(this.handleGoToForgotPassword);
  }

  // Transformamos em 'async' para esperar a resposta da API
  handleLogin = async (email, password) => {
    try {
      // 1. Tenta realizar o login
      const data = await this.apiService.login(email, password);

      // 2. Se deu certo, salva o token
      if (data.token) {
          this.apiService.saveToken(data.token);
          console.log("Login realizado com sucesso!");

          // 3. Redireciona para o Dashboard
          const { default: DashboardController } = await import('./DashboardController.js');
          new DashboardController();
      }
    } catch (error) {
      // 4. Se deu erro, exibe na tela usando o método da View
      this.view.displayError(error.message);
    }
  };

  handleGoToRegister = async () => {
    const { default: RegisterController } = await import("./RegisterController.js");
    new RegisterController();
  };

  handleGoToForgotPassword = async () => {
    const { default: ForgotPasswordController } = await import("./ForgotPasswordController.js");
    new ForgotPasswordController();
  };
}

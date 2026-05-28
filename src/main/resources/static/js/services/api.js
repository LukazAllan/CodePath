// Camada de serviço: Responsável por todas as chamadas à API backend.
// js/services/api.js
export default class ApiService {
  constructor() {
    this.baseUrl = "/auth"; // Prefixo da nossa API de autenticação
  }

  async login(email, password) {
    try {
      const response = await fetch(`${this.baseUrl}/login`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });

      if (!response.ok) {
        // Se a API retornar erro (ex: 401), tentamos ler a mensagem de erro
        const errorData = await response.json().catch(() => ({}));
        throw new Error(errorData.message || "E-mail ou senha inválidos.");
      }

      return await response.json(); // Retorna o DTO com o token
    } catch (error) {
      console.error("Erro na chamada de login:", error);
      throw error;
    }
  }

  // Métodos utilitários para o Token
  saveToken(token) {
    localStorage.setItem("codepath_token", token);
  }

  getToken() {
    return localStorage.getItem("codepath_token");
  }

  // Novo método método de criação de conta
  async signup(name, email, password) {
    const response = await fetch(`${this.baseUrl}/signup`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, email, password }),
    });

    if (!response.ok) {
      const errorData = await response.json().catch(() => ({}));
      throw new Error(errorData.message || "Erro ao criar conta.");
    }
    return await response.json();
  }

  /**
   * Busca os dados do usuário atual usando o token.
   */
  async me() {
    const token = this.getToken();
    if (!token) throw new Error("Não autenticado");

    const response = await fetch(`${this.baseUrl}/me`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token }),
    });

    if (!response.ok) {
      this.logout();
      throw new Error("Sessão expirada");
    }

    return await response.json();
  }
}

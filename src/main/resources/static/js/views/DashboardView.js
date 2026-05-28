export default class DashboardView {
    constructor() {
        this.app = document.getElementById('app-root');
    }

    render(userData) {
        this.app.innerHTML = `
            <div class="app-layout">
                <!-- Sidebar -->
                <aside class="sidebar">
                    <div class="logo-section">
                        <img src="/assets/Logo.jpg" alt="Logo">
                        <span>CodePath</span>
                    </div>

                    <nav class="nav-menu">
                        <a href="#" class="nav-item active" id="nav-aprender">
                            <span>🏠</span> APRENDER
                        </a>
                        <a href="#" class="nav-item">
                            <span>🏆</span> RANKING
                        </a>
                        <a href="#" class="nav-item" id="nav-perfil">
                            <span>👤</span> PERFIL
                        </a>
                        <a href="#" class="nav-item">
                            <span>🤖</span> TUTOR IA
                        </a>
                        <a href="#" class="nav-item">
                            <span>🛡️</span> GERENTE
                        </a>
                    </nav>

                    <div class="sidebar-footer">
                        <div class="user-info-small">
                            <div class="user-avatar-small"></div>
                            <span>${userData.name.toUpperCase()}</span>
                        </div>
                        <button id="btn-logout" class="btn-logout">Sair</button>
                    </div>
                </aside>

                <!-- Main Content -->
                <main class="main-content">
                    <header class="dashboard-header">
                        <div class="course-selector">
                            <span class="flag">🟨</span> IDIOMA ATIVO: <strong>JAVASCRIPT</strong>
                        </div>
                        
                        <div class="stats-container">
                            <div class="stat-item streak">
                                <span>⚡</span> ${userData.streak || 1}
                            </div>
                            <div class="stat-item hearts">
                                <span>❤️</span> ${userData.hearts || 5}
                            </div>
                            <div class="stat-item xp">
                                <span>🏆</span> ${userData.xp || 0} XP
                            </div>
                        </div>
                    </header>

                    <!-- Banner -->
                    <section class="welcome-banner">
                        <h1>Bem-vindo de volta!</h1>
                        <button class="btn-start-lesson">COMEÇAR LIÇÃO DE JAVASCRIPT</button>
                    </section>

                    <!-- Cards -->
                    <div class="dashboard-grid">
                        <div class="dashboard-card">
                            <h3><span>📖</span> Progresso Atual</h3>
                            <div class="progress-container">
                                <div class="progress-fill" style="width: 30%"></div>
                            </div>
                            <p class="progress-text">30 / 100 XP para o próximo nível</p>
                        </div>

                        <div class="dashboard-card">
                            <h3><span>⚡</span> Ofensiva</h3>
                            <h2 style="font-size: 32px; margin: 10px 0;">${userData.streak || 1} dias</h2>
                            <p class="progress-text">Não perca o ritmo!</p>
                        </div>
                    </div>

                    <h2 style="margin-top: 40px; color: #4b4b4b;">Seu Currículo Personalizado</h2>
                    <!-- Placeholder para a lista de lições -->
                    <div style="border: 2px dashed #e5e5e5; height: 200px; border-radius: 20px; margin-top: 20px;"></div>
                </main>
            </div>
        `;
    }

    bindLogout(handler) {
        document.getElementById('btn-logout').addEventListener('click', handler);
    }

    bindNavPerfil(handler) {
        document.getElementById('nav-perfil').addEventListener('click', event => {
            event.preventDefault();
            handler();
        });
    }
}
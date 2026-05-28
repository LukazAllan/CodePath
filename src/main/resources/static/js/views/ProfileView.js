export default class ProfileView {
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
                        <a href="#" class="nav-item" id="nav-aprender">
                            <span>🏠</span> APRENDER
                        </a>
                        <a href="#" class="nav-item">
                            <span>🏆</span> RANKING
                        </a>
                        <a href="#" class="nav-item active" id="nav-perfil">
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

                    <!-- Profile Header Card -->
                    <section class="profile-card-header">
                        <div class="profile-avatar-container">
                            <img src="https://via.placeholder.com/150" alt="Avatar" class="profile-avatar-large">
                            <div class="profile-badge">🏅</div>
                        </div>
                        
                        <div class="profile-details">
                            <h1>${userData.name}</h1>
                            <p class="profile-email">${userData.email}</p>
                            
                            <div class="profile-actions">
                                <button class="btn-secondary-outline">
                                    📅 Entrou em 4/10/2026
                                </button>
                                <button class="btn-blue-outline">
                                    ⚙️ Mudar Trilha
                                </button>
                            </div>
                            
                            <button class="btn-purple">Desativar Gerência</button>
                        </div>
                    </section>

                    <!-- Stats Mini Grid -->
                    <div class="stats-mini-grid">
                        <div class="mini-stat-card stat-ofensiva">
                            <span>⚡</span>
                            <div class="label">Ofensiva</div>
                            <div class="value">${userData.streak || 1} dias</div>
                        </div>
                        <div class="mini-stat-card stat-xp">
                            <span>🏆</span>
                            <div class="label">Total XP</div>
                            <div class="value">${userData.xp || 0}</div>
                        </div>
                        <div class="mini-stat-card stat-nivel">
                            <span>🏅</span>
                            <div class="label">Nível</div>
                            <div class="value">1</div>
                        </div>
                        <div class="mini-stat-card stat-vidas">
                            <span>❤️</span>
                            <div class="label">Vidas</div>
                            <div class="value">${userData.hearts || 5}</div>
                        </div>
                    </div>
                </main>
            </div>
        `;
    }

    bindLogout(handler) {
        document.getElementById('btn-logout').addEventListener('click', handler);
    }

    bindNavAprender(handler) {
        document.getElementById('nav-aprender').addEventListener('click', event => {
            event.preventDefault();
            handler();
        });
    }
}
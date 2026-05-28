// Ponto de entrada (main) da aplicação. Ele orquestra o início de tudo.
// js/main.js

import LoginController from './controllers/LoginController.js';

// Quando a página carregar, cria uma nova instância do LoginController.
// O construtor do controller cuidará de renderizar a view e preparar os eventos.
new LoginController();

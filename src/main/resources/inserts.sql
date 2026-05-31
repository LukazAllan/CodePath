    BEGIN TRANSACTION;
    -- =========================================================
    -- SCHEMA
    -- =========================================================
    create table answer (
        id integer,
        body varchar(255),
        left_value varchar(255),
        right_value varchar(255),
        question_id bigint,
        user_id bigint,
        primary key (id)
    );
    create table course (id integer, name varchar(255), primary key (id));
    create table enrollment (
        id integer,
        enrolled_at timestamp,
        course_id bigint,
        user_id bigint,
        primary key (id)
    );
    create table lesson (
        id integer,
        active boolean,
        content varchar(255),
        name varchar(255),
        ordem integer,
        section_id bigint,
        primary key (id)
    );
    create table lesson_progress (
        id integer,
        completed boolean,
        completed_at timestamp,
        stars smallint,
        status varchar(255) check ((status in ('LOCKED', 'ACTIVE', 'DONE'))),
        lesson_id bigint unique,
        user_id bigint,
        primary key (id)
    );
    create table question (
        id integer,
        code varchar(255),
        correct integer,
        hint varchar(255),
        label varchar(255),
        prompt varchar(255),
        type varchar(255) check (
            (
                type in (
                    'MULTIPLE_CHOICE',
                    'TRUE_FALSE',
                    'SHORT_TEXT',
                    'MATCHING'
                )
            )
        ),
        lesson_id bigint,
        primary key (id)
    );
    create table question_accepted_answers (
        question_id bigint not null,
        accepted_answers varchar(255)
    );
    create table question_options (question_id bigint not null, options varchar(255));
    create table question_pairs (
        question_id bigint not null,
        dir varchar(255),
        esq varchar(255)
    );
    create table section (
        id integer,
        color varchar(255),
        icon varchar(255),
        ordem integer,
        subtitle varchar(255),
        title varchar(255),
        course_id bigint,
        primary key (id)
    );
    create table session (
        id integer,
        created_at timestamp not null,
        language varchar(255),
        last_activity timestamp not null,
        platform varchar(255),
        resolution varchar(255),
        token varchar(255) not null unique,
        user_agent varchar(255),
        user_id bigint not null,
        primary key (id)
    );
    create table streak (
        id integer,
        days integer default 0,
        last_day TEXT,
        user_id bigint,
        primary key (id)
    );
    create table suggestion (
        id integer,
        comment varchar(255),
        status varchar(255) check ((status in ('PENDING', 'APROVED', 'REJECTED'))),
        question_id bigint,
        user_id bigint,
        primary key (id)
    );
    create table users (
        id integer,
        created_at timestamp,
        email varchar(255) not null,
        hearts integer not null,
        name varchar(255) not null unique,
        password varchar(255) not null,
        role varchar(255) check ((role in ('USER', 'ADMIN'))),
        xp integer not null,
        primary key (id)
    );
    --alter table lesson_progress drop constraint UKaoofwchivhdgkx18vlyra9uie
    --alter table session drop constraint UK99a8wt1ryupsm3bw11qtj7oo1
    --alter table users drop constraint UK3g1j96g94xpk3lpxl2qbl985x
    -- =========================================================
    -- TRIGGERS
    -- =========================================================
    drop trigger if exists tg_create_streak;
    create trigger if not exists tg_create_streak
        after insert on users
        for each row
    begin
        insert or abort into streak(days, last_day, user_id)
        values
            (0, CURRENT_TIMESTAMP, new.id);
    end;

    -- =========================================================
    -- COURSE
    -- =========================================================

    INSERT INTO course (id, name)
    VALUES (1, 'Trilha Backend Java + Spring Boot');

    -- =========================================================
    -- SECTIONS
    -- =========================================================

    INSERT INTO section (id, course_id, title, subtitle, color, icon, ordem)
    VALUES
        (1, 1, 'Fundamentos de Backend', 'Conceitos iniciais do desenvolvimento backend', 'green', '⚙', 1),
        (2, 1, 'APIs e Arquitetura', 'Comunicação entre sistemas e padrões REST', 'blue', '🌐', 2),
        (3, 1, 'Spring Boot e Persistência', 'Persistência de dados e estrutura Java', 'purple', '🗄', 3);

    -- =========================================================
    -- LESSONS
    -- =========================================================

    INSERT INTO lesson (id, section_id, name, content, ordem, active)
    VALUES
        (1, 1, 'Introdução ao Backend', 'Conceitos básicos sobre backend, entidades e arquitetura.', 1, true),
        (2, 1, 'Modelagem e Estrutura', 'Modelagem de entidades, boilerplate e anotações.', 2, true),
        (3, 1, 'Frameworks Java', 'Introdução ao Spring Boot e Lombok.', 3, true),

        (4, 2, 'APIs REST', 'Conceitos fundamentais de APIs REST e RESTful.', 1, true),
        (5, 2, 'HTTP e Comunicação', 'Métodos HTTP, requests e responses.', 2, true),
        (6, 2, 'Arquitetura de Sistemas', 'Integração entre frontend e backend.', 3, true),

        (7, 3, 'Persistência com JPA', 'Uso de entidades e banco de dados.', 1, true),
        (8, 3, 'Banco de Dados', 'Conceitos de SQL, tabelas e relacionamentos.', 2, true),
        (9, 3, 'Boas Práticas Backend', 'Organização de código e separação em camadas.', 3, true);

    -- =========================================================
    -- QUESTIONS
    -- =========================================================

    INSERT INTO question (id, type, lesson_id, label, prompt, code, correct, hint)
    VALUES
        (1, 'SHORT_TEXT', 1, 'Conceito de Backend', 'O que é Backend?', NULL, NULL, 'Pense na camada responsável pelas regras de negócio.'),
        (2, 'MULTIPLE_CHOICE', 1, 'Modelagem', 'Qual camada modela entidades do sistema?', NULL, 0, 'Relaciona-se às entidades do banco.'),
        (3, 'TRUE_FALSE', 1, 'Lombok', 'Lombok reduz boilerplate no Java.', NULL, 0, 'Lombok automatiza getters e setters.'),
        (4, 'MULTIPLE_CHOICE', 1, 'Anotações', 'Qual anotação representa uma entidade JPA?', NULL, 1, 'É utilizada junto ao Hibernate.'),
        (5, 'SHORT_TEXT', 1, 'Boilerplate', 'O que significa boilerplate?', NULL, NULL, 'Refere-se a código repetitivo.'),

        (6, 'MULTIPLE_CHOICE', 2, 'Spring', 'Qual framework Java é amplamente usado para backend?', NULL, 2, 'Muito usado com APIs REST.'),
        (7, 'TRUE_FALSE', 2, 'Hibernate', 'Hibernate é um ORM utilizado no Java.', NULL, 0, 'ORM faz mapeamento objeto-relacional.'),
        (8, 'SHORT_TEXT', 2, 'DTO', 'O que significa DTO?', NULL, NULL, 'É usado para transferência de dados.'),
        (9, 'MULTIPLE_CHOICE', 2, 'Arquitetura', 'Qual camada acessa diretamente o banco de dados?', NULL, 1, 'Ela contém consultas.'),
        (10, 'TRUE_FALSE', 2, 'Repository', 'Repositories geralmente acessam o banco de dados.', NULL, 0, 'Pense no Spring Data.'),

        (11, 'SHORT_TEXT', 3, 'Controller', 'Qual camada recebe requisições HTTP?', NULL, NULL, 'Ela expõe endpoints.'),
        (12, 'MULTIPLE_CHOICE', 3, 'Service', 'Qual camada contém regras de negócio?', NULL, 2, 'Fica entre controller e repository.'),
        (13, 'TRUE_FALSE', 3, 'API', 'Uma API define formas de comunicação entre sistemas.', NULL, 0, 'APIs permitem integração.'),
        (14, 'MULTIPLE_CHOICE', 3, 'JSON', 'Qual formato é comum em APIs REST?', NULL, 3, 'Muito usado no frontend e backend.'),
        (15, 'SHORT_TEXT', 3, 'REST', 'O que significa REST?', NULL, NULL, 'É um estilo arquitetural.'),

        (16, 'MULTIPLE_CHOICE', 4, 'RESTful', 'Um sistema RESTful segue princípios de qual arquitetura?', NULL, 0, 'É baseada em recursos HTTP.'),
        (17, 'TRUE_FALSE', 4, 'HTTP', 'GET é um método HTTP utilizado para consulta.', NULL, 0, 'Ele normalmente não altera dados.'),
        (18, 'SHORT_TEXT', 4, 'POST', 'Qual método HTTP é usado para criação?', NULL, NULL, 'Usado para inserir recursos.'),
        (19, 'MULTIPLE_CHOICE', 4, 'PUT', 'Qual método HTTP atualiza um recurso?', NULL, 2, 'É usado para edição completa.'),
        (20, 'TRUE_FALSE', 4, 'DELETE', 'DELETE remove recursos em APIs REST.', NULL, 0, 'Relaciona-se à exclusão.'),

        (21, 'SHORT_TEXT', 5, 'Frontend', 'O que é frontend?', NULL, NULL, 'É a interface vista pelo usuário.'),
        (22, 'MULTIPLE_CHOICE', 5, 'JavaScript', 'Qual linguagem é muito usada no frontend?', NULL, 1, 'Executa no navegador.'),
        (23, 'TRUE_FALSE', 5, 'HTML', 'HTML é uma linguagem de marcação.', NULL, 0, 'Estrutura páginas web.'),
        (24, 'MULTIPLE_CHOICE', 5, 'CSS', 'Qual tecnologia estiliza páginas web?', NULL, 0, 'Define cores e layouts.'),
        (25, 'SHORT_TEXT', 5, 'Integração', 'Como frontend e backend geralmente se comunicam?', NULL, NULL, 'Pense em APIs.'),

        (26, 'MULTIPLE_CHOICE', 6, 'Banco de Dados', 'Qual banco relacional é utilizado no projeto?', NULL, 3, 'É open-source e robusto.'),
        (27, 'TRUE_FALSE', 6, 'SQL', 'SQL é utilizado para manipular bancos relacionais.', NULL, 0, 'Usado para SELECT e INSERT.'),
        (28, 'SHORT_TEXT', 6, 'Tabela', 'O que é uma tabela em banco de dados?', NULL, NULL, 'Ela armazena registros.'),
        (29, 'MULTIPLE_CHOICE', 6, 'Primary Key', 'Qual campo identifica unicamente um registro?', NULL, 2, 'Geralmente chamado de ID.'),
        (30, 'TRUE_FALSE', 6, 'Foreign Key', 'Foreign keys relacionam tabelas.', NULL, 0, 'Elas criam vínculos.'),

        (31, 'SHORT_TEXT', 7, 'JPA', 'O que significa JPA?', NULL, NULL, 'É uma especificação Java.'),
        (32, 'MULTIPLE_CHOICE', 7, 'Entity', 'Qual anotação marca uma entidade?', NULL, 1, 'Usada com tabelas.'),
        (33, 'TRUE_FALSE', 7, 'Repository', 'JpaRepository facilita operações CRUD.', NULL, 0, 'Spring Data simplifica consultas.'),
        (34, 'MULTIPLE_CHOICE', 7, 'ORM', 'O que um ORM faz?', NULL, 0, 'Relaciona objetos e tabelas.'),
        (35, 'SHORT_TEXT', 7, 'CRUD', 'O que significa CRUD?', NULL, NULL, 'São quatro operações básicas.'),

        (36, 'MULTIPLE_CHOICE', 8, 'INSERT', 'Qual comando SQL insere dados?', NULL, 2, 'Usado para adicionar registros.'),
        (37, 'TRUE_FALSE', 8, 'SELECT', 'SELECT consulta dados em SQL.', NULL, 0, 'Muito usado em listagens.'),
        (38, 'SHORT_TEXT', 8, 'UPDATE', 'Qual comando SQL atualiza dados?', NULL, NULL, 'Altera registros existentes.'),
        (39, 'MULTIPLE_CHOICE', 8, 'DELETE', 'Qual comando SQL remove registros?', NULL, 3, 'Exclui linhas de tabelas.'),
        (40, 'TRUE_FALSE', 8, 'JOIN', 'JOIN relaciona dados entre tabelas.', NULL, 0, 'Muito usado em consultas complexas.'),

        (41, 'SHORT_TEXT', 9, 'MVC', 'O que significa MVC?', NULL, NULL, 'Relaciona model, view e controller.'),
        (42, 'MULTIPLE_CHOICE', 9, 'Clean Code', 'Qual prática melhora legibilidade do código?', NULL, 1, 'Relaciona-se à organização.'),
        (43, 'TRUE_FALSE', 9, 'DTO', 'DTOs ajudam a evitar exposição direta das entidades.', NULL, 0, 'São objetos de transferência.'),
        (44, 'MULTIPLE_CHOICE', 9, 'Camadas', 'Qual camada normalmente contém endpoints?', NULL, 0, 'Recebe requisições HTTP.'),
        (45, 'SHORT_TEXT', 9, 'Boas práticas', 'Por que separar controller, service e repository?', NULL, NULL, 'Pense em organização e responsabilidade.');

    -- =========================================================
    -- MULTIPLE CHOICE OPTIONS
    -- =========================================================

    INSERT INTO question_options (question_id, options)
    VALUES
        (2, 'Controller'),
        (2, 'View'),
        (2, 'Model'),
        (2, 'Session'),

        (4, '@Service'),
        (4, '@Entity'),
        (4, '@Autowired'),
        (4, '@Bean'),

        (6, 'Laravel'),
        (6, 'Django'),
        (6, 'Spring Boot'),
        (6, 'React'),

        (9, 'Service'),
        (9, 'Repository'),
        (9, 'Controller'),
        (9, 'DTO'),

        (12, 'Repository'),
        (12, 'DTO'),
        (12, 'Service'),
        (12, 'Entity'),

        (14, 'XML'),
        (14, 'CSV'),
        (14, 'TXT'),
        (14, 'JSON'),

        (16, 'REST'),
        (16, 'SOAP'),
        (16, 'MVC'),
        (16, 'Monolítica'),

        (19, 'GET'),
        (19, 'POST'),
        (19, 'PUT'),
        (19, 'TRACE'),

        (22, 'Java'),
        (22, 'JavaScript'),
        (22, 'C'),
        (22, 'Go'),

        (24, 'CSS'),
        (24, 'HTML'),
        (24, 'SQL'),
        (24, 'Java'),

        (26, 'MongoDB'),
        (26, 'SQLite'),
        (26, 'MySQL'),
        (26, 'PostgreSQL'),

        (29, 'Foreign Key'),
        (29, 'Index'),
        (29, 'Primary Key'),
        (29, 'Join'),

        (32, '@Repository'),
        (32, '@Entity'),
        (32, '@Service'),
        (32, '@RestController'),

        (34, 'Mapeia objetos para tabelas'),
        (34, 'Cria interfaces gráficas'),
        (34, 'Executa CSS'),
        (34, 'Renderiza HTML'),

        (36, 'SELECT'),
        (36, 'UPDATE'),
        (36, 'INSERT'),
        (36, 'DELETE'),

        (39, 'UPDATE'),
        (39, 'CREATE'),
        (39, 'INSERT'),
        (39, 'DELETE'),

        (42, 'Duplicar código'),
        (42, 'Clean Code'),
        (42, 'Hardcode'),
        (42, 'Código espaguete'),

        (44, 'Controller'),
        (44, 'Repository'),
        (44, 'Entity'),
        (44, 'Database');

    -- =========================================================
    -- SHORT TEXT ACCEPTED ANSWERS
    -- =========================================================

    INSERT INTO question_accepted_answers (question_id, accepted_answers)
    VALUES
        (1, 'Camada responsável pelas regras de negócio e acesso ao banco de dados'),
        (5, 'Código repetitivo necessário para funcionamento básico'),
        (8, 'Data Transfer Object'),
        (11, 'Controller'),
        (15, 'Representational State Transfer'),
        (18, 'POST'),
        (21, 'Interface visual do sistema'),
        (25, 'APIs REST'),
        (28, 'Estrutura que armazena registros em banco de dados'),
        (31, 'Java Persistence API'),
        (35, 'Create Read Update Delete'),
        (38, 'UPDATE'),
        (41, 'Model View Controller'),
        (45, 'Separação de responsabilidades');
    
    -- ========================================================
    -- USERS
    -- ========================================================

    INSERT INTO users(id, created_at, email, hearts, name, password,role, xp) 
    VALUES
        (1, CURRENT_TIMESTAMP, 'esteuser@codepath.com', 50, 'esteuser', '12345', 'USER', 0),
        (2, CURRENT_TIMESTAMP, 'esteadmin@codepath.com', 50, 'esteadmin', '12345', 'ADMIN', 0);
    
    -- ========================================================
    -- Enrollments
    -- ========================================================

    insert into enrollment(
        enrolled_at,
        course_id,
        user_id)
    values
        (CURRENT_TIMESTAMP, 1, 1);


    COMMIT;

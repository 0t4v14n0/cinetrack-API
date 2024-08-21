<h1>CineTrack</h1>
    <p>CineTrack é um sistema de gerenciamento e avaliação de séries e filmes, com funcionalidades para cadastro de usuários, gerenciamento de favoritos, revisão de conteúdos e interação social através de um sistema de amigos e chat em tempo real.</p>

<h2>Funcionalidades</h2>
    <ol>
        <li><strong>Cadastro/Login</strong>
            <ul>
                <li>Usuários podem se registrar e fazer login na plataforma.</li>
            </ul>
        </li>
        <li><strong>Atualizar Informações de Usuário</strong>
            <ul>
                <li>Permite a atualização das informações do perfil do usuário.</li>
            </ul>
        </li>
        <li><strong>Exibir Perfis de Usuários Existentes</strong>
            <ul>
                <li>Visualize os perfis de outros usuários da plataforma.</li>
            </ul>
        </li>
        <li><strong>Adicionar Séries/Filmes ao Banco de Dados</strong>
            <ul>
                <li>Adiciona séries e filmes que não existem no banco de dados, coletando informações da API OMDB.</li>
            </ul>
        </li>
        <li><strong>CRUD Reviews de Série/Temporada/Episódio</strong>
            <ul>
                <li>Realiza operações de criar, ler, atualizar e deletar reviews para séries, temporadas e episódios.</li>
            </ul>
        </li>
        <li><strong>CRUD Favoritos</strong>
            <ul>
                <li>Adiciona, visualiza, atualiza e remove séries e filmes favoritos do usuário, com retorno formatado.</li>
            </ul>
        </li>
        <li><strong>Sistema de Curtidas para Reviews</strong>
            <ul>
                <li>Usuários podem curtir e descurtir reviews.</li>
            </ul>
        </li>
        <li><strong>Sistema de Amigos</strong>
            <ul>
                <li>Gerencia relacionamentos de amizade entre usuários, incluindo envio e aceitação de convites.</li>
            </ul>
        </li>
        <li><strong>Chat em Tempo Real</strong>
            <ul>
                <li>Comunicação em tempo real entre amigos utilizando WebSocket para envio e recebimento de mensagens.</li>
            </ul>
        </li>
    </ol>

<h2>Tecnologias Utilizadas</h2>
    <ul>
        <li><strong>Backend:</strong> Spring Boot</li>
        <li><strong>Banco de Dados:</strong> MySQL</li>
        <li><strong>API de Séries e Filmes:</strong> OMDB</li>
        <li><strong>WebSocket:</strong> Para comunicação em tempo real</li>
    </ul>
    
<h1>Configuração e Uso</h1>

<h2>Configuração do Projeto</h2>
    <ol>
        <li><strong>Clone o Repositório:</strong>
            <pre><code>git clone https://github.com/0t4v14n0/cinetrack-API.git</code></pre>
        </li>
        <li><strong>Configuração do Banco de Dados:</strong>
            <p>Configure o banco de dados MySQL e ajuste as credenciais no arquivo de propriedades do Spring Boot (<code>application.properties</code>).</p>
        </li>
        <li><strong>Dependências:</strong>
            <p>Certeza de que todas as dependências estão instaladas. Utilize Maven ou Gradle para gerenciar dependências.</p>
            <pre><code>mvn install</code></pre>
        </li>
        <li><strong>Executar o Projeto:</strong>
            <p>Inicie a aplicação Spring Boot.</p>
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
    </ol>

<h2>Documentação da API</h2>
    <p><strong>Swagger:</strong> Utilize o Swagger para visualizar e testar os endpoints da API. Acesse a documentação em <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>.</p>

<h2>Licença</h2>
    <p>Este projeto é licenciado sob a <a href="LICENSE">Licença MIT</a>.</p>

<h2>Contato</h2>
    <p>Para mais informações, entre em contato com <a href="mailto:0t4v14n0@gmail.com">0t4v14n0@gmail.com</a>.</p>

<h1>Diagrama do Banco de Dados</h1>
<h1><img id = "diagrama" src="src/main/resources/static/images/diagram.png" alt="Diagrama do Banco de Dados" width="743" height="719"></h1>

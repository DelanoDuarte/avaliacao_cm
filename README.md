# Avaliacão Casas Magalhães

## Instruções de Execução
 - Importar os projetos **avaliacao-cm-api** e **avaliacao-cm-mensageria** em sua IDE de preferência. (Ambos são Projetos Spring/Spring Boot).
 - Executar os Projetos, em suas respectivas classes de Execução:
 1. **avaliacao-cm-api** : AvaliacaoCmApiApplication.class (**Obs.:** Ao executar a aplicação, 3 registros de usuários serão inseridos para facilitar os testes da API.)
 2. **avaliacao-cm-mensageria** : AvaliacaoCmMensageriaApplication.class (**Obs. :** O servidor do RabbitMQ deve esta instalado e rodando para a execução da aplicação de mensageria. Link de instalação: https://www.rabbitmq.com/download.html)

 - Depois de executar os projetos, para Acessar a Documentação da API do projeto **avaliacao-cm-api**, basta acessar: http://localhost:8080/api/avalicao_cm/swagger-ui.html
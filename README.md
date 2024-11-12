## Microsserviço de Usuários

Este micrserviço de usuários faz parte de:
- https://github.com/gusttv/bun-hono-bff


### Instalação e Execução
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   ```
2. **Configure as variáveis de ambiente:**
    * `SPRING_DATASOURCE_URL`
    * `SPRING_DATASOURCE_USERNAME` 
    * `SPRING_DATASOURCE_PASSWORD`
    * `API_SECURITY_TOKEN_SECRET`
3. **Execute o projeto:**
   ```bash
   docker compose up -d
   mvn spring-boot:run
   ```

### Endpoints
* **POST /auth/login:** Realiza o login do usuário.
* **POST /auth/register:** Cadastra um novo usuário.
* **GET /users:** Retorna a lista de todos os usuários.
* **GET /users/{id}**: Retorna um usuário específico pelo ID.
* **PUT /users/{id}**: Atualiza um usuário específico.
* **DELETE /users/{id}**: Exclui um usuário específico.


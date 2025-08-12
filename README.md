# Cinema API

API REST para gestão de cinema: filmes, gêneros, sessões, unidades, salas, cadeiras e fluxo de compra. Autenticação via JWT, perfis `ROLE_USER` e `ROLE_ADMIN`.

## Tecnologias
- Java 17\+
- Spring Boot
- Spring Security \+ JWT
- Maven

## Requisitos
- Java 17\+
- Maven 3.8\+

## Configuração
Defina propriedades em 'src/main/resources/application.properties' (ou variáveis de ambiente):
- `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`
- `spring.jpa.hibernate.ddl-auto`
- `jwt.secret` \=\= segredo do token
- `jwt.expiration` \=\= expiração em ms

Exemplo mínimo:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cinema
spring.datasource.username=cinema
spring.datasource.password=cinema
spring.jpa.hibernate.ddl-auto=update

jwt.secret=troque-este-segredo
jwt.expiration=86400000
```

## Como executar
Desenvolvimento:
```bash
mvn spring-boot:run
```

Empacotar:
```bash
mvn clean package
```

Executar o JAR:
```bash
java -jar target/<arquivo-gerado>.jar
```

## Documentação da API
Swagger UI: `GET` `'/swagger-ui/index.html'`  
OpenAPI: `GET` `'/v3/api-docs'`

## Autenticação
- Registro público: `POST` `'/api/v1/clientes'`
- Login: `POST` `'/api/v1/clientes/auth'` → retorna JWT
- Envie `Authorization: Bearer <token>` nas rotas protegidas.

Exemplo de login:
```http
POST /api/v1/clientes/auth HTTP/1.1
Content-Type: application/json

{
  "email": "user@dominio.com",
  "senha": "minha-senha"
}
```

## Regras de acesso
- Público:
    - `'/api/v1/filmes/**'`, `'/api/v1/generos/**'`, `'/api/v1/sessoes/**'`, `'/api/v1/unidades/**'`, `'/api/v1/salas/**'`, `'/api/v1/fileiras/**'`, `'/api/v1/cadeiras/**'`, `'/api/v1/tipos-sessao/**'`, `'/api/v1/intervalos-exibicao/**'`, `'/api/v1/imagens/**'`, `'/api/v1/clientes/**'`
    - `POST` `'/api/v1/clientes'` e `'/api/v1/clientes/auth'`
- Autenticado (`ROLE_USER` ou `ROLE_ADMIN`):
    - `'/api/v1/pedidos/**'`, `'/api/v1/ingressos/**'`, `'/api/v1/cartoes/**'`, `'/api/v1/enderecos/**'`, `'/api/v1/cupons-desconto/**'`
- Administrativo (`ROLE_ADMIN`):
    - `'/api/v1/funcionarios/**'`, `'/api/v1/items-bomboniere/**'`

Sessões são stateless e o filtro JWT valida o token em cada requisição.

## Testes
```bash
mvn test
```

## Estrutura (resumo)
- Código fonte: 'src/main/java'
- Recursos: 'src/main/resources'
- Configurações de segurança: 'src/main/java/br/com/multicinema/cinemaapi/security'
- Build: 'pom.xml'

## Notas
- Senhas armazenadas com `BCrypt`.
- Ajuste CORS conforme necessidade.
- Mantenha o `jwt.secret` seguro e fora do controle de versão.

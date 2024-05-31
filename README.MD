# Sistema de gestão financeira

**Apresentamos a você O Money Planner!** 

Uma aplicação de gestão financeira simples e poderosa para quem busca:

* **Controlar suas despesas sem enrolação:** Anote seus gastos e saiba exatamente para onde seu dinheiro está indo. 📊
* **Definir metas e alcançá-las:** Planeje seus objetivos financeiros e acompanhe seu progresso. 🚀
* **Investir de forma descomplicada:** Dê os primeiros passos no mundo dos investimentos com simplicidade e segurança. 📈

**Chega de planilhas confusas e aplicativos complicados!** 🙅‍♂️

Com este projeto, você terá o controle total de suas finanças de forma fácil e intuitiva. 😉


**Juntos, vamos transformar sua relação com o dinheiro!** 💪💰

## Como usar o projeto?
Para usar o projeto, siga os seguintes passos:
1. Clone o repositório em sua máquina local.
``` bash
git clone https://github.com/LucasBandeiraSilva/Gestao-financeira.git
```
2. Abra sua IDE de prefêrencia (ex: VS Code, InteliJ, eclipse)

3. configure o Banco de dados.
*configure as credências de acesso no arquivo* **application.properties**
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```
4. **Execute a aplicação Spring Boot**
* Localize a classe principal que contem o método  `main` (ProjetoApplication.java).
* Execute a classe como uma aplicação Java.

5. **Acesse a aplicação em seu navegador**
* Acesse a URL http://localhost:8080/ para acessar a aplicação.
* Acesse a URL http://localhost:8080/h2-console/ para acessar o Banco de dados

**Pronto!** Agora você pode começar a usar o Money Planner e ter o controle total das suas finanças. 💪💰





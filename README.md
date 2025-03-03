# Example Spring Boot 3 application using Conductor
Orkes Java SDK Example based on Spring Boot

## Setup
> [!NOTE]  
> If you are testing against https://play.orkes.io or Orkes Conductor instance that requires API Keys please set the following environment variables:
> ```
> export KEY=your_api_key
> export SECRET=your_api_key_secret
> ```
>
> When testing against localhost, please unset **KEY** and **SECRET**

## Run
1. Start the application using `./mvnw spring-boot:run`
2. Visit the swagger page at http://localhost:8080/swagger-ui.html
3. Execute the `/triggerDepositFlow` endpoint with inputs to start the workflow

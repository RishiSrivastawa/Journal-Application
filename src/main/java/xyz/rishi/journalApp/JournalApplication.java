package xyz.rishi.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication marks the main class of a Spring Boot app.
// It combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.
// @Configuration means this class defines Spring beans.
// @EnableAutoConfiguration lets Spring Boot automatically configure the app.
// @ComponentScan tells Spring to find components like controllers and services.
// This annotation is needed only once, usually on the main application class.
@SpringBootApplication
public class JournalApplication {

    public static void main(String[] args) {
        //.run method starts the Spring Boot application.
        //it bootstraps the app, starting the Spring context and auto-configuring beans.
//        Client (Postman / Browser)
//        ↓
//        Controller  (@RestController)
//        ↓
//        Service     (business logic)
//        ↓
//        Repository  (MongoDB access)
//        ↓
//        MongoDB (journal_entries collection)

        SpringApplication.run(JournalApplication.class, args);
    }


}
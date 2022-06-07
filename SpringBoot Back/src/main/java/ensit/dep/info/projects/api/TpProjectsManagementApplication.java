package ensit.dep.info.projects.api;

import ensit.dep.info.projects.api.projectPackage.Project;
import ensit.dep.info.projects.api.projectPackage.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class TpProjectsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpProjectsManagementApplication.class, args);
    }

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World from my new spring boot server";
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }


}
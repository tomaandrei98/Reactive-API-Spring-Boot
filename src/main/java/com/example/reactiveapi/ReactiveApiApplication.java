package com.example.reactiveapi;

import com.example.reactiveapi.model.Student;
import com.example.reactiveapi.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                studentService.save(Student.builder()
                        .firstName("Andrei " + i)
                        .lastName("Toma " + i)
                        .age(i)
                        .build()
                ).subscribe();
            }
        };
    }
}

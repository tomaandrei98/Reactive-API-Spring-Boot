package com.example.reactiveapi.service;

import com.example.reactiveapi.model.Student;
import com.example.reactiveapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    public Flux<Student> findAll() {
        return studentRepository.findAll()
                .delayElements(Duration.of(1, ChronoUnit.SECONDS));
    }

    public Mono<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }
}

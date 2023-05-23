package com.example.springannotations;

import com.example.springannotations.lazy.LazyLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAnnotationsApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationsApplication.class, args);
        System.out.println("Application Started...");
        // manually calling bean
        LazyLoader lazyLoader = context.getBean(LazyLoader.class);
    }
}

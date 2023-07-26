package com.hartron.springbootapi.springbootapi;

 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(EmployeeRepository repository){
        return args -> {
            log.info("PreLoading", repository.save(new Employee("Nishchay","Student")));
            log.info("PreLoading", repository.save(new Employee("Litesh","Frontend Developer")));

        };



    }


}
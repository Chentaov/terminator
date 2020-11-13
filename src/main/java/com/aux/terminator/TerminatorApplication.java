package com.aux.terminator;

import com.aux.terminator.dao.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TerminatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerminatorApplication.class, args);
    }

}

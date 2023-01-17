package com.assessment.contactmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ContactManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactManagementApplication.class, args);
    }

}

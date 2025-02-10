package com.vantutran2k1.todoapp.migration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class ToDoAppMigration implements CommandLineRunner {
    private final Flyway flyway;

    @Autowired
    public ToDoAppMigration(final Flyway flyway) {
        this.flyway = flyway;
    }

    public static void main(final String[] args) {
        SpringApplication.run(ToDoAppMigration.class, args);
    }

    @Override
    public void run(String... args) {
        flyway.migrate();
    }
}

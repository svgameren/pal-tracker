package io.pivotal.pal.tracker;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    public TimeEntryRepository getTimeEntryRepository() throws SQLException {
        DataSource dataSource = new MariaDbDataSource(System.getenv("SPRING_DATASOURCE_URL"));

        return new JdbcTimeEntryRepository(dataSource);
    }
}

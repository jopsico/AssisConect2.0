package com.assisconnect.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@Component
public class DatabaseMigrationConfig implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            String dbProductName = jdbcTemplate.execute((Connection conn) -> {
                DatabaseMetaData metaData = conn.getMetaData();
                return metaData.getDatabaseProductName().toLowerCase();
            });

            if (dbProductName.contains("mysql")) {
                jdbcTemplate.execute("ALTER TABLE idosos MODIFY COLUMN foto_url LONGTEXT");
                System.out.println("[DatabaseMigration] MySQL: Coluna foto_url alterada para LONGTEXT.");
            } else if (dbProductName.contains("postgresql")) {
                jdbcTemplate.execute("ALTER TABLE idosos ALTER COLUMN foto_url TYPE TEXT");
                System.out.println("[DatabaseMigration] PostgreSQL: Coluna foto_url alterada para TEXT.");
            }
        } catch (Exception e) {
            System.out.println("[DatabaseMigration] Coluna já atualizada ou erro ignorável: " + e.getMessage());
        }
    }
}

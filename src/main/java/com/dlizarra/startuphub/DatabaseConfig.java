package com.dlizarra.startuphub;

import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class DatabaseConfig {

	@Profile(StartupHubProfiles.STANDALONE)
	@PropertySource("classpath:application-default.properties") // Not loaded by naming convention
	@Configuration
    static class StandaloneDatabaseConfig {
        @Bean
        ServletRegistrationBean h2ConsoleServlet(){
            ServletRegistrationBean servlet = new ServletRegistrationBean(new WebServlet(), "/h2console/*");        
            return servlet;
        }    
        
        @Bean
        public DataSource dataSource(Environment env) {
        	HikariDataSource ds = new HikariDataSource();    	
        	ds.setJdbcUrl(env.getRequiredProperty("h2.jdbcurl"));
        	ds.setUsername(env.getRequiredProperty("h2.username"));    	
        	return ds;
        }
    }
	
	@Profile(StartupHubProfiles.STAGING)	
	@Configuration
    static class StagingDatabaseConfig {        
        @Bean
        public DataSource dataSource(Environment env) {
        	HikariDataSource ds = new HikariDataSource();    	
        	ds.setJdbcUrl(env.getRequiredProperty("psql.jdbcurl"));
        	ds.setUsername(env.getRequiredProperty("psql.username"));    	
        	return ds;
        }
    }
	
}

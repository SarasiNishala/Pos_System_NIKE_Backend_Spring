package lk.ijse.gdse68.nike_spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse68.nike_spring")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.gdse68.nike_spring")
@EnableTransactionManagement
public class WebAppConfig {}

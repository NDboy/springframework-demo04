package demo04;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)

public class AppConfig {

//    @Autowired
//    private Environment environment;
//
    @Bean
    public DataSource dataSource() {
        try {
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

//            dataSource.setUrl(environment.getProperty("jdbc.url"));
//            dataSource.setUser(environment.getProperty("jdbc.username"));
//            dataSource.setPassword(environment.getProperty("jdbc.password"));
            return dataSource;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create datasource", se);
        }
    }
//
//    @Bean
//    public Flyway flyway() {
//        Flyway flyway = Flyway.configure()
//                .dataSource(dataSource()).load();
//        flyway.clean();
//        flyway.migrate();
//        return flyway;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        return new JpaTransactionManager();
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter =
//                new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setShowSql(true);
//        return hibernateJpaVendorAdapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
//                new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setPackagesToScan("com.demo01.demo");
//        return entityManagerFactoryBean;
//    }

}

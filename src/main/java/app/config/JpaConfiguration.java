package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(value = "app")
@EnableJpaRepositories(basePackages = "app.repositories")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class JpaConfiguration {

	@Resource
	private Environment env;

	private static final String PROP_DATABASE_DRIVER = "db.driver";
	private static final String PROP_DATABASE_PASSWORD = "db.password";
	private static final String PROP_DATABASE_URL = "db.url";
	private static final String PROP_DATABASE_USERNAME = "db.username";
	//Hibernate
	private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	private static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty(PROP_DATABASE_DRIVER));
		dataSource.setUrl(env.getProperty(PROP_DATABASE_URL));
		dataSource.setUsername(env.getProperty(PROP_DATABASE_USERNAME));
		dataSource.setPassword(env.getProperty(PROP_DATABASE_PASSWORD));

		return dataSource;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf =
				new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(env.getProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	public Properties jpaProperties() {
		Properties properties = new Properties();
		properties.setProperty(PROP_HIBERNATE_DIALECT, env.getProperty(PROP_HIBERNATE_DIALECT));
		properties.setProperty(PROP_HIBERNATE_SHOW_SQL, env.getProperty(PROP_HIBERNATE_SHOW_SQL));
		properties.setProperty(PROP_HIBERNATE_HBM2DDL_AUTO, env.getProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
		return properties;
	}
}
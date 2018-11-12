package demo.app.demoapp.data.jpa;

import java.util.ArrayList;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * A configuration class for Spring JPA. Connection properties
 * are set in a properties file.
 * 
 * @author joseph_sicree
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = { "demo.app.demoapp.data.jpa.repository" })
@PropertySource({ "classpath:demoapp_jpa.properties" })
//@EnableCaching
public class JpaConfig {

	private static final String PROPERTY_NAME_DATABASE_DRIVER_CLASS = "db.driverClass";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

	@Resource
	private Environment environment;
	
	/**
	 * Default ctor
	 */
	public JpaConfig() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return a configured data source.
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource ds = null;

		ds = new DriverManagerDataSource();
		ds.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER_CLASS));

		String url = environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL);		
		ds.setUrl(url);		
		ds.setUsername(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		ds.setPassword(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
//		ds.setMinPoolSize(5);
//		ds.setMaxPoolSize(10);
		return ds;
	}	
	
	/**
	 * Return an entity manager factory
	 * 
	 * @param dataSource
	 * @param jpaVendorAdapter
	 * 
	 * @return A <code>LocalContainerEntityManagerFactoryBean</code>
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan(environment
				.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

		Properties jpaProperties = new Properties();
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		lef.setJpaProperties(jpaProperties);

		return lef;
	}

	/**
	 * 
	 * @return A <code>JpaVendorAdapter</code>
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	/**
	 * 
	 * @param entityManagerFactory
	 * 
	 * @return A <code>PlatformTransactionManager</code>
	 */
	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	/**
	 * 
	 * @return A <code>CacheManager</code>
	 */
	@Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<ConcurrentMapCache> cacheList = new ArrayList<ConcurrentMapCache>();
        cacheManager.setCaches(cacheList);
        return cacheManager;
    }
	
}

package com.test.poc.compositepu.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {"classpath:dbConf.properties"})
public class CustomEntityManagerFactory {

	public static final Logger LOG = LoggerFactory.getLogger(CustomEntityManagerFactory.class);

	@Value("${database.driver}")
	private String JDBC_DRIVER;
	@Value("${database.username}")
	private String DB_USERNAME;
	@Value("${database.password}")
	private String DB_PASSWORD;
	@Value("${database.host}")
	private String DB_HOST;
	@Value("${database.params}")
	private String DB_PARAMS;

	private static final String DB_ONE = "dbone";
	private static final String DB_TWO = "dbtwo";

	private static final String PU_ONE = "PUONE";
	private static final String PU_TWO = "PUTWO";
	private static final String COMPOSITE_PU = "CompositePU";

	private static final String JAVAX_PERSISTENCE_JDBC_USER = "javax.persistence.jdbc.user";
	private static final String JAVAX_PERSISTENCE_JDBC_PASSWORD = "javax.persistence.jdbc.password";
	private static final String JAVAX_PERSISTENCE_JDBC_DRIVER = "javax.persistence.jdbc.driver";
	private static final String JAVAX_PERSISTENCE_JDBC_URL = "javax.persistence.jdbc.url";

	private static final String ECLIPSELINK_COMPOSITE_UNIT_PROPERTIES = "eclipselink.composite-unit.properties";

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	protected EntityManagerFactory entityManagerFactory() throws PersistenceException {
		LOG.info("-> entityManagerFactory");
		Map<String, String> props1 = new HashMap<>();
		props1.put(JAVAX_PERSISTENCE_JDBC_USER, DB_USERNAME);
		props1.put(JAVAX_PERSISTENCE_JDBC_PASSWORD, DB_PASSWORD);
		props1.put(JAVAX_PERSISTENCE_JDBC_DRIVER, JDBC_DRIVER);
		props1.put(JAVAX_PERSISTENCE_JDBC_URL, DB_HOST + DB_ONE + DB_PARAMS);
		Map<String, String> props2 = new HashMap<>();
		props2.put(JAVAX_PERSISTENCE_JDBC_USER, DB_USERNAME);
		props2.put(JAVAX_PERSISTENCE_JDBC_PASSWORD, DB_PASSWORD);
		props2.put(JAVAX_PERSISTENCE_JDBC_DRIVER, JDBC_DRIVER);
		props2.put(JAVAX_PERSISTENCE_JDBC_URL, DB_HOST + DB_TWO + DB_PARAMS);

		Map<String, Map<String, String>> memberProps = new HashMap<>();
		memberProps.put(PU_ONE, props1);
		memberProps.put(PU_TWO, props2);
		Map props = new HashMap();
		props.put(ECLIPSELINK_COMPOSITE_UNIT_PROPERTIES, memberProps);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(COMPOSITE_PU, props);

		LOG.info("<- entityManagerFactory emf.getProperties={}", emf.getProperties());
		return emf;
	}

}

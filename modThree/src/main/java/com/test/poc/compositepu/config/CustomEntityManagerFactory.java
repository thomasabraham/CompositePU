package com.test.poc.compositepu.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEntityManagerFactory {

	public static final Logger LOG = LoggerFactory.getLogger(CustomEntityManagerFactory.class);

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "Welcome123";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_PARAMS = "?useUnicode=yes&characterEncoding=UTF-8"
			+ "&zeroDateTimeBehavior=convertToNull&connectionCollation=utf8_general_ci"
			+ "& characterSetResults=utf8";
	private static final String DB_ONE = "dbone";
	private static final String DB_TWO = "dbtwo";
	private static final String PU_ONE = "PUONE";
	private static final String PU_TWO = "PUTWO";

	private static final String JAVAX_PERSISTENCE_JDBC_USER = "javax.persistence.jdbc.user";
	private static final String JAVAX_PERSISTENCE_JDBC_PASSWORD = "javax.persistence.jdbc.password";
	private static final String JAVAX_PERSISTENCE_JDBC_DRIVER = "javax.persistence.jdbc.driver";
	private static final String JAVAX_PERSISTENCE_JDBC_URL = "javax.persistence.jdbc.url";

	private static final String ECLIPSELINK_COMPOSITE_UNIT_PROPERTIES = "eclipselink.composite-unit.properties";
	private String COMPOSITE_PU = "CompositePU";

	@Bean
	protected EntityManagerFactory entityManagerFactory() throws PersistenceException {
		LOG.info("-> entityManagerFactory");
		Map<String, String> props1 = new HashMap<>();
		props1.put(JAVAX_PERSISTENCE_JDBC_USER, DB_USERNAME);
		props1.put(JAVAX_PERSISTENCE_JDBC_PASSWORD, DB_PASSWORD);
		props1.put(JAVAX_PERSISTENCE_JDBC_DRIVER, JDBC_DRIVER);
		props1.put(JAVAX_PERSISTENCE_JDBC_URL, DB_URL + DB_ONE + DB_PARAMS);
		Map<String, String> props2 = new HashMap<>();
		props2.put(JAVAX_PERSISTENCE_JDBC_USER, DB_USERNAME);
		props2.put(JAVAX_PERSISTENCE_JDBC_PASSWORD, DB_PASSWORD);
		props2.put(JAVAX_PERSISTENCE_JDBC_DRIVER, JDBC_DRIVER);
		props2.put(JAVAX_PERSISTENCE_JDBC_URL, DB_URL + DB_TWO + DB_PARAMS);

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

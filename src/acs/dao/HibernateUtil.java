package acs.dao;


import org.apache.commons.logging.impl.Log4JLogger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import acs.modal.ACSMessage;
import acs.modal.AcsCardData;
import acs.modal.CurrencyCountry;
import acs.modal.FieldDefinition;
import acs.modal.Page;
import acs.modal.PageAccessParam;
import acs.modal.PageParams;
import acs.modal.RangeParameters;


public class HibernateUtil {
	private static HibernateUtil me;
	private Configuration cfg;
	private SessionFactory sessionFactory;
	public static Log4JLogger logger = new Log4JLogger(HibernateUtil.class.toString());
	
	private HibernateUtil() throws HibernateException {

		cfg = new Configuration();

		cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.OracleDriver");    
        cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@192.168.1.29:1521:eps");
		cfg.setProperty("hibernate.connection.username", "epsacs");
		cfg.setProperty("hibernate.default_schema", "epsacs");
		cfg.setProperty("hibernate.connection.password", "eps00001"); 
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		cfg.setProperty("hibernate.show_sql", "true"); 
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");

		this.cfg.addAnnotatedClass(ACSMessage.class);
		this.cfg.addAnnotatedClass(CurrencyCountry.class);
		this.cfg.addAnnotatedClass(Page.class);
		this.cfg.addAnnotatedClass(AcsCardData.class);
		// this.cfg.addAnnotatedClass(PageParams.class);
		this.cfg.addAnnotatedClass(RangeParameters.class);
		this.cfg.addAnnotatedClass(FieldDefinition.class);
		this.cfg.addAnnotatedClass(PageAccessParam.class);
		
		sessionFactory = cfg.buildSessionFactory();
	}

	public static synchronized HibernateUtil getInstance() {
		logger.info(" HibernateUtil ");

		if (me == null) {
			me = new HibernateUtil();
		}

		return me;
	}

	public Session getSession() throws HibernateException {
	logger.info("get session");
		Session session = sessionFactory.openSession();
		if (!session.isConnected()) {
			logger.info("  !session.isConnected()  true");

			this.reconnect();
		}
		return session;
	}

	private void reconnect() throws HibernateException {
		this.sessionFactory = cfg.buildSessionFactory();
	}
}
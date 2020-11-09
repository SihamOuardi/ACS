package acs.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.OptimisticLockException;

import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;


public class DAO {
	public static boolean successOperation = false;
	public static String failedOperationError;
	public static Log4JLogger logger = new Log4JLogger(DAO.class.toString());

	public DAO() {
	}

	public Session getSession() {
		//Session session = HibernateSessionFactory.currentSession();
		Session session = HibernateUtil.getInstance().getSession();
		return session;
	}


	public void save(Object obj) {	
		// Audit audit = new Audit();
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		Transaction tx = null;
		try {
			Session session = getSession();
			// session.flush();
			tx = session.beginTransaction();
			System.out.println("save  obj " + obj.toString());
			session.save(obj);
			tx.commit();
			// audit.auditInsert(obj);
			tx = null;
			session.persist(obj);
			session.flush();
			successOperation = true;
		} catch (org.hibernate.JDBCException jdbce) {
			
			successOperation = false;
			DAO.failedOperationError = jdbce.getCause().getMessage();
			System.out.println("org.hibernate.JDBCException " + jdbce.getMessage());
			// throw jdbce;
		} catch (org.hibernate.HibernateException e) {
			System.out.println("org.hibernate.HibernateException " + e.getMessage());
			successOperation = false;
			e.getMessage();

		} catch (SecurityException e) {
			System.out.println("SecurityException " + e.getMessage());

			e.getMessage();
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());

			e.getMessage();
		}
		
		finally {
			
		}
	}

	public Object load(Class className, Object id, Object obj) throws Exception {
		Object object;
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		// getSession().flush();
		if (getSession().equals(obj)) {
			object = getSession().load(className, (Serializable) id);
		} else {
			try {
				object = findByIdObject(className, id);
			} catch (org.hibernate.JDBCException jdbce) {
				jdbce.getMessage();
				
				throw jdbce;
			} catch (NonUniqueObjectException e) {
				object = getSession().get(className, (Serializable) id);
			}
		}
		return object;
	}

	@SuppressWarnings("boxing")
	public Object findByIdObject(Class entity, Object id) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			// getSession().refresh(entity);
			Object obj = getSession().get(entity, (Serializable) id);
			return obj;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void saveOrUpdate(Object obj) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		//Audit audit = new Audit();
		Transaction tx = null;
		Session session = getSession();
		/*Session session_upd = (Session) SessionUtils.getAttribute("trx_update");
		if (session_upd != null && (!session_upd.equals(session))) {
			session = session_upd;
			session.clear();
		} else {
			// session = getSession();
			session.clear();
		}*/
		logger.info("Debug-Method: saveOrUpdate - begin");
		tx = session.getTransaction(); // A revérifier
        tx.begin();
		try {
			// audit.auditUpdateBefore(obj);
			/*if (tx.getStatus() != TransactionStatus.ACTIVE) {
				tx.begin();
			}*/
			session.saveOrUpdate(obj);
			if (!tx.wasCommitted())
                tx.commit();			// audit.auditUpdateAfter(obj);
			//SessionUtils.setAttribute("trx_update", null);
			session.flush();
			successOperation = true;
		} catch (org.hibernate.JDBCException jdbce) {
			System.out.print(jdbce.getCause().getMessage());
			successOperation = false;
			logger.info(jdbce.getCause().getMessage());
			DAO.failedOperationError = jdbce.getCause().getMessage();
		} catch (org.hibernate.TransactionException jte) {
			if (tx.wasCommitted()) {
				tx.rollback();
				tx = null;
			}
			
			logger.fatal("jte"+jte);
			throw jte;
		} catch (org.hibernate.HibernateException e) {
			successOperation = false;
			// logger.info(e.getCause().getMessage());
			if (tx != null)
				tx.rollback();
			System.out.print(e.getCause());
			e.getMessage();
			// DAO.failedOperationError = e.getCause().getMessage();
			// getSession().refresh(obj);
			logger.fatal(e);
		} catch (SecurityException e) {
			e.getMessage();
			logger.fatal(e);
		} catch (IllegalArgumentException e) {
			logger.fatal(e);
			e.getMessage();
		} catch (OptimisticLockException ole) {

			successOperation = false;
			// if (getSession().isOpen()) getSession().close();
			logger.fatal(ole);
			if (tx != null)
				tx.rollback();
			System.out.print(ole.getCause());
			ole.getMessage();

		} finally {
			try {
				if (getSession().isOpen()) {
					session.close();
				}
			} catch (Exception e) {
				successOperation = false;
				e.getMessage();
				DAO.failedOperationError = e.getCause().getMessage();
			}

		}
	}

	public void saveOrUpdate(Object obj, String index) {

		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		//Audit audit = new Audit();
		Transaction tx = null;
		Session session = getSession();
		/*Session session_upd = (Session) SessionUtils.getAttribute(index);

		// log.info("Debug-Method: saveOrUpdate(..., String index) - begin");
		if (session_upd != null && (!session_upd.equals(session))) {
			session = session_upd;
			session.clear();
		} else {
			session = getSession();
			session.flush();
		}*/
		tx = session.getTransaction(); // A revérifier
		try {
			//audit.auditUpdateBefore(obj);
			/*if (tx.getStatus() != TransactionStatus.ACTIVE) {
				tx.begin();
			}*/
			session.saveOrUpdate(obj);
			// logger.info("User saveOrUpdate object: " + obj.toString());
			tx.commit();
			//audit.auditUpdateAfter(obj);
			//SessionUtils.setAttribute("trx_update", null);
			session.flush();
			successOperation = true;
		} catch (org.hibernate.JDBCException jdbce) {
			successOperation = false;
			logger.warn(jdbce.getCause().getMessage());
			DAO.failedOperationError = jdbce.getCause().getMessage();
		} catch (org.hibernate.TransactionException jte) {
			if (tx != null) {
				tx.rollback();
				tx = null;
			}
			
			throw jte;
		} catch (org.hibernate.HibernateException e) {
			successOperation = false;
			logger.warn(e.getCause().getMessage());
			// if (getSession().isOpen()) getSession().close();
			if (tx != null)
				tx.rollback();
			System.out.print(e.getCause());
			e.getMessage();
			DAO.failedOperationError = e.getCause().getMessage();
			// getSession().refresh(obj);
		} catch (SecurityException e) {
			e.getMessage();
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} catch (OptimisticLockException ole) {
			successOperation = false;
			// if (getSession().isOpen()) getSession().close();
			if (tx != null)
				tx.rollback();
			System.out.print(ole.getCause());
			ole.getMessage();
		} finally {
			try {
				if (getSession().isOpen()) {
					// HibernateSessionFactory.closeSession();
				}
			} catch (Exception e) {
				successOperation = false;
				e.getMessage();
				DAO.failedOperationError = e.getCause().getMessage();
			}
		}
	}

	public void delete(Object obj, String index) {
		// Audit audit = new Audit();
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		Session session = getSession();
		Transaction tx = null;
		/*Session session_upd = (Session) SessionUtils.getAttribute(index);		
		if (session_upd != null && (!session_upd.equals(session))) {
			session = session_upd;
			session.clear();
		} else {
			session = getSession();
			session.flush();
		}*/
		try {
			tx = session.beginTransaction();
			// audit.auditDelete(obj);
			session.delete(obj);
			tx.commit();
			tx = null;
			//SessionUtils.setAttribute("trx_update", null);
			// session.persist(obj);
			successOperation = true;
			session.flush();
		} catch (org.hibernate.JDBCException jdbce) {
			successOperation = false;
			DAO.failedOperationError = jdbce.getCause().getMessage();
			System.out.print(jdbce.getCause().getMessage());
			jdbce.getMessage();
		} catch (org.hibernate.HibernateException e) {
			successOperation = false;
			// if (getSession().isOpen()) getSession().close();
			if (tx != null)
				tx.rollback();
			System.out.print(e.getCause());
			e.getMessage();
			DAO.failedOperationError = e.getCause().getMessage();
			System.out.print(e.getCause().getMessage());
			// getSession().refresh(obj);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} /*
		 * catch (SQLException e) { e.printStackTrace(); } catch
		 * (NoSuchFieldException e) { e.printStackTrace(); } catch
		 * (IllegalAccessException e) { e.printStackTrace(); }
		 */
		finally {
			/*
			 * try { if (getSession().isOpen()){ getSession().close(); } } catch
			 * (Exception e) { successOperation = false; e.printStackTrace();
			 * DAO.failedOperationError = e.getCause().getMessage(); }
			 */

		}
	}

	public void delete(Object obj) {
		// Audit audit = new Audit();
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		//Audit audit = new Audit(); // MAW20160409
		Session session = getSession();
		//Session session_upd = (Session) SessionUtils.getAttribute("trx_update");
		Transaction tx = null;
/*
		if (session_upd != null && (!session_upd.equals(session))) {
			session = session_upd;
			session.clear();
		} else {
			session = getSession();
			session.flush();
		}
*/
		try {
			// START MAW20160409
			//audit.auditDelete(obj);
			// END MAW20160409

			tx = session.beginTransaction();
			// audit.auditDelete(obj);
			session.delete(obj);
			tx.commit();
			tx = null;
			//SessionUtils.setAttribute("trx_update", null);
			// session.persist(obj);
			successOperation = true;
			// getSession().flush();
		} catch (org.hibernate.JDBCException jdbce) {
			successOperation = false;
			DAO.failedOperationError = jdbce.getCause().getMessage();
			System.out.print(jdbce.getCause().getMessage());
			jdbce.getMessage();
		} catch (org.hibernate.HibernateException e) {
			successOperation = false;
			// if (getSession().isOpen()) getSession().close();

			if (tx != null)
				tx.rollback();
			System.out.print(e.getCause());
			e.getMessage();
			DAO.failedOperationError = e.getCause().getMessage();
			System.out.print(e.getCause().getMessage());
			// getSession().refresh(obj);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} /*
		 * catch (SQLException e) { e.printStackTrace(); } catch
		 * (NoSuchFieldException e) { e.printStackTrace(); } catch
		 * (IllegalAccessException e) { e.printStackTrace(); }
		 */ finally {
			/*
			 * try { if (getSession().isOpen()){ getSession().close(); } } catch
			 * (Exception e) { successOperation = false; e.printStackTrace();
			 * DAO.failedOperationError = e.getCause().getMessage(); }
			 */

		}
	}

	

	@SuppressWarnings("unchecked")
	public List findByExample(Object object, String clas) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			getSession().flush();
			List results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Example.create(object)).list();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}
	
	public Object findByGenCriteriaUniqueResult(Class table, String creteria) {
		//FacesContext context = FacesContext.getCurrentInstance();
		//ExternalContext ectx = context.getExternalContext();
		logger.info("Debug-Method: findByGenCriteriaUniqueResult - begin");
		try {
			// log.info("Debug-Method: findByGenCriteriaUniqueResult - try");
			List resultList = new ArrayList();
			Object result = null;
			String queryString = "from " + GetClassNameOnly(table) + " "+ creteria;
			
			Query queryObject = getSession().createQuery(queryString).setMaxResults(1);
			resultList = queryObject.list();
			logger.info(" resultList " + resultList.size());

			for (Object object : resultList) {
				result = object;
			}
			
			return result;
		} catch (org.hibernate.JDBCException jdbce) {
			logger.info(" jdbce " + jdbce.getMessage());

			throw jdbce;
		} catch (RuntimeException re) {
			logger.info(" re " + re.getMessage());
			throw re;
		}
	}
	
	private String GetClassNameOnly(Class table) {
		String tab[] = table.getName().toString().split("\\.");
		String ClassName = null;
		for (String string : tab) {
			ClassName = string;
		}
		return ClassName;
	}

	private String GetTableNameOnly(String str) {
		String tab[] = str.split("\\.");
		String ClassName = null;
		for (String string : tab) {
			ClassName = string;
		}
		return ClassName;
	}
	

	public List findByExampleDAO(Object object, String clas,
			String[] excludeProperty) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			Criteria crit = getSession().createCriteria(
					"dao.Hibernate.Model." + clas);
			Example example = Example.create(object);
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);
			}
			crit.add(example);
			return crit.list();
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByOrder(Object object, String clas, String order) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			List results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.addOrder(Order.desc(order)).list();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	// add by Jurin for sorting list in ascendant order
	public List findByOrderAsc(Object object, String clas, String order) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			List results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Example.create(object)).addOrder(Order.asc(order))
					.list();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByCriterion(String clas, Criterion... criterion) {
		Criteria crit = getSession().createCriteria(
				"dao.Hibernate.Model." + clas);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	public Object findByproperty(String clas, String order, String property,
			String value) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			Object results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Property.forName(property).eq(value))
					.addOrder(Order.desc(order)).uniqueResult();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public List findListByproperty(String clas, String order, String property,
			String value) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			List results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Property.forName(property).eq(value))
					.addOrder(Order.desc(order)).list();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.printStackTrace();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public List findThreeResultPersonaliser(String clas, String order,
			String property, String value, String status, String val,
			String tableInd, String valTab) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {

			List results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Property.forName(property).eq(value))
					.add(Property.forName(status).eq(val))
					.add(Property.forName(tableInd).eq(valTab))
					.addOrder(Order.desc(order)).setMaxResults(3).list();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.printStackTrace();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public Object findWording(String clas, String valTab, String tre,
			String wordin) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {

			Object results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.setProjection(Projections.property(wordin))
					.add(Property.forName(valTab).eq(tre)).setMaxResults(1)
					.uniqueResult();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.printStackTrace();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public List findThreeResult(String clas, String order, String property,
			String value) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			List results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Property.forName(property).eq(value))
					.addOrder(Order.desc(order)).setMaxResults(3).list();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public List findResultsByOrder(String clas, String order, String property,
			String value) {
		try {
			List results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Property.forName(property).eq(value))
					.addOrder(Order.desc(order)).list();

			return results;
		} catch (RuntimeException re) {
			re.getMessage();
			throw re;
		}
	}

	public Object findUniqueResult(Object object, String clas, String order) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			Object results = getSession()
					.createCriteria("dao.Hibernate.Model." + clas)
					.add(Example.create(object)).addOrder(Order.desc(order))
					.setMaxResults(1).uniqueResult();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public Object findUniqueResult(Object object, Class clas) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/

		try {
			Object results = getSession().createCriteria(clas)
					.add(Example.create(object)).setMaxResults(1)
					.uniqueResult();

			return results;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByDate(String table, String propertyName, String s1,
			String s2) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			String queryString = "from " + table + " as model where model."
					+ propertyName + " >= to_date( '" + s1
					+ "' , 'DD/MM/RRRR hh24:mi') and model." + propertyName
					+ "  <= to_date( '" + s2 + "' , 'DD/MM/RRRR hh24:mi')"
					+ " ORDER BY  " + propertyName + "  desc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByDateAndProperty(String table, String date, String s1,
			String s2, String propertyName, String s3) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			String queryString = "from " + table + " as model where model."
					+ date + " >= to_date( '" + s1
					+ "' , 'DD/MM/RRRR hh24:mi') and model." + date
					+ "  <= to_date( '" + s2 + "' , 'DD/MM/RRRR hh24:mi')"
					+ " and model." + propertyName + " like '%" + s3 + "%'"
					+ " ORDER BY  " + propertyName + "  desc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (org.hibernate.JDBCException jdbce) {
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List FindByDateAndCriteria(String table, String date, String s1,
			String s2, String cretiria) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {

			cretiria = cretiria + " And TRUNC(" + date
					+ ") >=  TRUNC(TO_DATE ('" + s1 + "'	, 'dd/MM/yyyy'))";
			cretiria = cretiria + " And TRUNC(" + date
					+ ") <=  TRUNC(TO_DATE ('" + s2 + "'	, 'dd/MM/yyyy'))";

			cretiria = cretiria + " ORDER BY  " + date + " desc";

			String queryString = "  From " + table + cretiria;
			// System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);

			return queryObject.list();
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByGenCriteria(String table, String creteria) {

		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/

		getSession().clear();
		try {
			String queryString = "from " + table + creteria;
			// getSession().flush();
			Query queryObject = getSession().createQuery(queryString);

			// queryObject.setCacheMode(CacheMode.REFRESH);
			// queryObject.setFlushMode(FlushMode.ALWAYS);
			return queryObject.list();
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List selectSimpleCriteria(String propertyNameFromDB,
			String tableNameFromDB, String FieldOfCondition, String Condition) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		String sql = "Select  " + propertyNameFromDB + " from "
				+ tableNameFromDB + " WHERE " + FieldOfCondition + " = '"
				+ Condition + "'";

		try {
			List results;
			results = getSession().createSQLQuery(sql).list();
			return results;

		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public List selectSimple(String propertyNameFromDB, String tableNameFromDB) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		String sql = "Select  " + propertyNameFromDB + " from "
				+ tableNameFromDB;

		try {
			List results;
			results = getSession().createSQLQuery(sql).list();
			return results;

		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public List findDistinctByGenCriteria(String propertyNameFromDB,
			String tableNameFromDB, String sqlCreteria) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		String sql = "Select distinct " + propertyNameFromDB + " from "
				+ tableNameFromDB + sqlCreteria;

		try {
			List results;
			results = getSession().createSQLQuery(sql).list();
			return results;

		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
		
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public Object findByGenCriteriaUniqueResult(String table, String creteria) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			List resultList = new ArrayList();
			Object result = null;
			String queryString = "from " + table + creteria;
			
			System.out.println("queryString ["+queryString+"]");

			Query queryObject = getSession().createQuery(queryString)
					.setMaxResults(1);
			resultList = queryObject.list();
			for (Object object : resultList) {
				result = object;
			}
			
			logger.info("result result ["+result+"]");

			return result;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public Object findById(String entity, String id) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			Object obj = getSession().get("eps.model." + entity, id);
			return obj;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("boxing")
	public Object findObjectById(String entity, Object id) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			Object obj = getSession().get("dao.Hibernate.Model." + entity,
					(Serializable) id);
			return obj;
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			/*
			 * String url = ((HttpServletRequest) ectx.getRequest())
			 * .getContextPath() + "/pages/common/eps_connect_error.jsf"; try {
			 * ectx.redirect(url); } catch (IOException e1) {
			 * e1.printStackTrace(); }
			 */
			throw jdbce;
		} catch (RuntimeException re) {
			re.getMessage();
			throw re;
		}
	}

	

	

	@SuppressWarnings("unchecked")
	public List requestExecute(String request) {
		/*FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ectx = context.getExternalContext();*/
		try {
			Query query = getSession().createSQLQuery(request);
			return query.list();
		} catch (org.hibernate.JDBCException jdbce) {
			jdbce.getMessage();
			
			throw jdbce;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public boolean isSuccessOperation() {
		return successOperation;
	}

	public void setSuccessOperation(boolean successOperation) {
		DAO.successOperation = successOperation;
	}

	public String getFailedOperationError() {
		return failedOperationError;
	}

	public void setFailedOperationError(String failedOperationError) {
		DAO.failedOperationError = failedOperationError;
	}
	
	
	
}

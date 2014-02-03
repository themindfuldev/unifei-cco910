package br.edu.unifei.beans;

// Generated 30/10/2008 01:01:31 by Hibernate Tools 3.2.2.CR1

import static org.hibernate.criterion.Example.create;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import br.edu.unifei.utils.HibernateUtils;

/**
 * Home object for domain model class ClassificacaoMedico.
 * @see br.edu.unifei.beans.ClassificacaoMedico
 * @author Hibernate Tools
 */
public class ClassificacaoMedicoDao {

	private static final Log log = LogFactory
			.getLog(ClassificacaoMedicoDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return HibernateUtils.getSessionFactory();
	}

	public void persist(ClassificacaoMedico transientInstance) {
		log.debug("persisting ClassificacaoMedico instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ClassificacaoMedico instance) {
		log.debug("attaching dirty ClassificacaoMedico instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClassificacaoMedico instance) {
		log.debug("attaching clean ClassificacaoMedico instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ClassificacaoMedico persistentInstance) {
		log.debug("deleting ClassificacaoMedico instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClassificacaoMedico merge(ClassificacaoMedico detachedInstance) {
		log.debug("merging ClassificacaoMedico instance");
		try {
			ClassificacaoMedico result = (ClassificacaoMedico) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ClassificacaoMedico findById(java.lang.Integer id) {
		log.debug("getting ClassificacaoMedico instance with id: " + id);
		try {
			ClassificacaoMedico instance = (ClassificacaoMedico) sessionFactory
					.getCurrentSession().get(
							"br.edu.unifei.beans.ClassificacaoMedico", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ClassificacaoMedico> findByExample(ClassificacaoMedico instance) {
		log.debug("finding ClassificacaoMedico instance by example");
		try {
			List<ClassificacaoMedico> results = (List<ClassificacaoMedico>) sessionFactory
					.getCurrentSession().createCriteria(
							"br.edu.unifei.beans.ClassificacaoMedico").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByHQL(String hql) {
		log.debug("getting list with hql: " + hql);
		try {
			sessionFactory.getCurrentSession().getTransaction().begin();
			List returnList = sessionFactory.getCurrentSession().createQuery(hql).list();
			sessionFactory.getCurrentSession().getTransaction().commit();
			return returnList;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw re;
		}
	}
	
	public List findByHQL(String hql, Map<String, Date> datas) {
		log.debug("getting list with hql: " + hql);
		try {
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			for (Map.Entry<String, Date> entrada: datas.entrySet()) {
				query.setDate(entrada.getKey(), entrada.getValue());
			}
			
			List returnList = query.list();
			sessionFactory.getCurrentSession().getTransaction().commit();
			return returnList;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw re;
		}
	}
}

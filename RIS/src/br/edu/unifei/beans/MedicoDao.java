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
 * Home object for domain model class Medico.
 * @see br.edu.unifei.beans.Medico
 * @author Hibernate Tools
 */
public class MedicoDao {

	private static final Log log = LogFactory.getLog(MedicoDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return HibernateUtils.getSessionFactory();
	}

	public void persist(Medico transientInstance) {
		log.debug("persisting Medico instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Medico instance) {
		log.debug("attaching dirty Medico instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Medico instance) {
		log.debug("attaching clean Medico instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Medico persistentInstance) {
		log.debug("deleting Medico instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Medico merge(Medico detachedInstance) {
		log.debug("merging Medico instance");
		try {
			Medico result = (Medico) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Medico findById(java.lang.Integer id) {
		log.debug("getting Medico instance with id: " + id);
		try {
			Medico instance = (Medico) sessionFactory.getCurrentSession().get(
					"br.edu.unifei.beans.Medico", id);
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

	public List<Medico> findByExample(Medico instance) {
		log.debug("finding Medico instance by example");
		try {
			List<Medico> results = (List<Medico>) sessionFactory
					.getCurrentSession().createCriteria(
							"br.edu.unifei.beans.Medico").add(create(instance))
					.list();
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

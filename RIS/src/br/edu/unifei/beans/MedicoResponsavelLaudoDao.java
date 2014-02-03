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
 * Home object for domain model class MedicoResponsavelLaudo.
 * @see br.edu.unifei.beans.MedicoResponsavelLaudo
 * @author Hibernate Tools
 */
public class MedicoResponsavelLaudoDao {

	private static final Log log = LogFactory
			.getLog(MedicoResponsavelLaudoDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return HibernateUtils.getSessionFactory();
	}

	public void persist(MedicoResponsavelLaudo transientInstance) {
		log.debug("persisting MedicoResponsavelLaudo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MedicoResponsavelLaudo instance) {
		log.debug("attaching dirty MedicoResponsavelLaudo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MedicoResponsavelLaudo instance) {
		log.debug("attaching clean MedicoResponsavelLaudo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MedicoResponsavelLaudo persistentInstance) {
		log.debug("deleting MedicoResponsavelLaudo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MedicoResponsavelLaudo merge(MedicoResponsavelLaudo detachedInstance) {
		log.debug("merging MedicoResponsavelLaudo instance");
		try {
			MedicoResponsavelLaudo result = (MedicoResponsavelLaudo) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MedicoResponsavelLaudo findById(
			br.edu.unifei.beans.MedicoResponsavelLaudoId id) {
		log.debug("getting MedicoResponsavelLaudo instance with id: " + id);
		try {
			MedicoResponsavelLaudo instance = (MedicoResponsavelLaudo) sessionFactory
					.getCurrentSession().get(
							"br.edu.unifei.beans.MedicoResponsavelLaudo", id);
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

	public List<MedicoResponsavelLaudo> findByExample(
			MedicoResponsavelLaudo instance) {
		log.debug("finding MedicoResponsavelLaudo instance by example");
		try {
			List<MedicoResponsavelLaudo> results = (List<MedicoResponsavelLaudo>) sessionFactory
					.getCurrentSession().createCriteria(
							"br.edu.unifei.beans.MedicoResponsavelLaudo").add(
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

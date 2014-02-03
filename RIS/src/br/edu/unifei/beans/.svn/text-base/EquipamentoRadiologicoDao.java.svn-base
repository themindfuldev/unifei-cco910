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
 * Home object for domain model class EquipamentoRadiologico.
 * @see br.edu.unifei.beans.EquipamentoRadiologico
 * @author Hibernate Tools
 */
public class EquipamentoRadiologicoDao {

	private static final Log log = LogFactory
			.getLog(EquipamentoRadiologicoDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return HibernateUtils.getSessionFactory();
	}

	public void persist(EquipamentoRadiologico transientInstance) {
		log.debug("persisting EquipamentoRadiologico instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EquipamentoRadiologico instance) {
		log.debug("attaching dirty EquipamentoRadiologico instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EquipamentoRadiologico instance) {
		log.debug("attaching clean EquipamentoRadiologico instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EquipamentoRadiologico persistentInstance) {
		log.debug("deleting EquipamentoRadiologico instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EquipamentoRadiologico merge(EquipamentoRadiologico detachedInstance) {
		log.debug("merging EquipamentoRadiologico instance");
		try {
			EquipamentoRadiologico result = (EquipamentoRadiologico) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EquipamentoRadiologico findById(java.lang.Integer id) {
		log.debug("getting EquipamentoRadiologico instance with id: " + id);
		try {
			EquipamentoRadiologico instance = (EquipamentoRadiologico) sessionFactory
					.getCurrentSession().get(
							"br.edu.unifei.beans.EquipamentoRadiologico", id);
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

	public List<EquipamentoRadiologico> findByExample(
			EquipamentoRadiologico instance) {
		log.debug("finding EquipamentoRadiologico instance by example");
		try {
			List<EquipamentoRadiologico> results = (List<EquipamentoRadiologico>) sessionFactory
					.getCurrentSession().createCriteria(
							"br.edu.unifei.beans.EquipamentoRadiologico").add(
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

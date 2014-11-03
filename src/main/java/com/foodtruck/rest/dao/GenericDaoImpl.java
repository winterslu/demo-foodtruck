/**
 * 
 */
package com.foodtruck.rest.dao;

import java.io.Serializable;
import java.util.List;

import jersey.repackaged.com.google.common.base.Preconditions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


/**
 * A generic Hibernate implementation for all other Hibernate Data Access Object
 * @author winters
 * 
 * @param <Entity> the entity type
 * @param <PrimaryKey> the key type
 */
@Transactional
public abstract class GenericDaoImpl<Entity, PrimaryKey extends Serializable>
	extends HibernateDaoSupport 
	implements GenericDao<Entity, PrimaryKey> {

	private static final Log LOG = LogFactory.getLog(GenericDaoImpl.class);
	
	private final Class<Entity> entity;
	
	public GenericDaoImpl(Class<Entity> entity) {
		Preconditions.checkArgument(entity.isAnnotationPresent(javax.persistence.Entity.class),
				"The entity must be a Hibernate Entity");
		this.entity = entity;
	}
	
	
	@Autowired
	public void init(
			@Qualifier("sessionFactory") 
			SessionFactory sessionFactory) {
		Preconditions.checkNotNull(sessionFactory, "The sessionFactory has not been provided");
		super.setSessionFactory(sessionFactory);
	}
	
	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> getAll(){
		LOG.debug("Loading model: " + entity.getCanonicalName());
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(entity);
		return criteria.list();
	}
	
	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public Entity get(PrimaryKey key){
		Preconditions.checkNotNull(key, "The PrimaryKey must be provided");
		Entity theEntity = (Entity) getSessionFactory().getCurrentSession().get(entity, key);
		return theEntity;
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public Serializable save(Entity theEntity){
		return getSessionFactory().getCurrentSession().save(theEntity);
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public void saveOrUpdate(Entity theEntity){
		getSessionFactory().getCurrentSession().saveOrUpdate(theEntity);
	}
	
	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public Entity update(Entity theEntity){
		return (Entity)getSessionFactory().getCurrentSession().merge(theEntity);
	}
	
	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public void delete(PrimaryKey key){
		Entity theEntity = (Entity) getSessionFactory().getCurrentSession().get(entity, key);
		getSessionFactory().getCurrentSession().delete(theEntity);
	}
	
}

package com.test.poc.compositepu.dao;

import com.test.poc.compositepu.entity.TableOne;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TableOneDaoImpl implements TableOneDao {

	private static final Logger LOG = LoggerFactory.getLogger(TableOneDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TableOne> getTableOneList(Integer start, Integer range) {
		LOG.info("-> getTableOneList start={}, range={}", start, range);
		List<TableOne> result;
		try {
			String queryStr = "SELECT t FROM " + TableOne.class.getName() + " t ";
			LOG.info(queryStr);
			Query query = em.createQuery(queryStr);
			if (start != null) {
				query.setFirstResult(start);
			}
			if (range != null) {
				query.setMaxResults(range);
			}
			result = query.getResultList();
			LOG.info("<- getTableOneList returning {} objects", result.size());
			return result;
		} catch (IllegalArgumentException ex) {
			LOG.error("Got IllegalArgumentException ", ex);
			throw new RuntimeException("The criteria passed is incorrect", ex);
		} catch (Exception e) {
			LOG.error("Got other Exception: {}", e);
			throw new RuntimeException("Generic Exception occured", e);
		}
	}
}

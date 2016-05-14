package com.test.poc.compositepu.dao;

import com.test.poc.compositepu.entity.TableTwo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TableTwoDaoImpl implements TableTwoDao {

	private static final Logger LOG = LoggerFactory.getLogger(TableTwoDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TableTwo> getTableTwoList(Integer start, Integer range) {
		LOG.info("-> getTableTwoList start={}, range={}", start, range);
		List<TableTwo> result;
		try {
			String queryStr = "SELECT t FROM " + TableTwo.class.getName() + " t ";
			LOG.info(queryStr);
			Query query = em.createQuery(queryStr);
			if (start != null) {
				query.setFirstResult(start);
			}
			if (range != null) {
				query.setMaxResults(range);
			}
			result = query.getResultList();
			LOG.info("<- getTableTwoList returning {} objects", result.size());
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

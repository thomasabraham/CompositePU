package com.test.poc.compositepu.service;

import com.test.poc.compositepu.dao.*;
import com.test.poc.compositepu.entity.TableOne;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TableOneServiceImpl implements TableOneService {

	private static final Logger LOG = LoggerFactory.getLogger(TableOneServiceImpl.class);

	@Autowired
	private TableOneDao tableOneDao;

	@Override
	public List<TableOne> getTableOneList(Integer start, Integer range) {
		LOG.info("-> getTableOneList start={}, range={}", start, range);
		List<TableOne> result;
		result = tableOneDao.getTableOneList(start, range);
		LOG.info("<- getTableOneList returning {} objects", result.size());
		return result;
	}
}

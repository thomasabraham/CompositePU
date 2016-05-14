package com.test.poc.compositepu.service;

import com.test.poc.compositepu.dao.*;
import com.test.poc.compositepu.entity.TableTwo;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TableTwoServiceImpl implements TableTwoService {

	private static final Logger LOG = LoggerFactory.getLogger(TableTwoServiceImpl.class);

	@Autowired
	private TableTwoDao tableTwoDao;

	@Override
	public List<TableTwo> getTableTwoList(Integer start, Integer range) {
		LOG.info("-> getTableTwoList start={}, range={}", start, range);
		List<TableTwo> result;
		result = tableTwoDao.getTableTwoList(start, range);
		LOG.info("<- getTableTwoList returning {} objects", result.size());
		return result;
	}
}

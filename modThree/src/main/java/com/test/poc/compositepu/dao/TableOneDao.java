package com.test.poc.compositepu.dao;

import com.test.poc.compositepu.entity.TableOne;
import java.util.List;

public interface TableOneDao {

	List<TableOne> getTableOneList(Integer start, Integer range);
}

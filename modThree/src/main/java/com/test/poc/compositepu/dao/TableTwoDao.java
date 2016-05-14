package com.test.poc.compositepu.dao;

import com.test.poc.compositepu.entity.TableTwo;
import java.util.List;

public interface TableTwoDao {

	List<TableTwo> getTableTwoList(Integer start, Integer range);
}

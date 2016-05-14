package com.test.poc.compositepu.service;

import com.test.poc.compositepu.entity.TableTwo;
import java.util.List;

public interface TableTwoService {

	List<TableTwo> getTableTwoList(Integer start, Integer range);
}

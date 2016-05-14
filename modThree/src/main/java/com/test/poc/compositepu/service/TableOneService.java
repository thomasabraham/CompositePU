package com.test.poc.compositepu.service;

import com.test.poc.compositepu.entity.TableOne;
import java.util.List;

public interface TableOneService {

	List<TableOne> getTableOneList(Integer start, Integer range);
}

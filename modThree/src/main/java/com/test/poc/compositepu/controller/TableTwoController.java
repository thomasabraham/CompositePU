package com.test.poc.compositepu.controller;

import com.test.poc.compositepu.entity.TableTwo;
import com.test.poc.compositepu.service.TableTwoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class TableTwoController {

	private static final Logger LOG = LoggerFactory.getLogger(TableTwoController.class);

	@Autowired
	private TableTwoService tableTwoService;

	@RequestMapping(value = "/tabletwo", method = RequestMethod.GET)
	@ResponseBody
	public List<TableTwo> getTableTwoList(@RequestParam Integer start,
			@RequestParam Integer range) {
		LOG.info("-> getTableTwoList start={}, range={}", start, range);
		List<TableTwo> result = tableTwoService.getTableTwoList(start, range);
		LOG.info("<- getTableTwoList returning {} objects", result.size());
		return result;
	}

}

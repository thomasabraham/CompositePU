package com.test.poc.compositepu.controller;

import com.test.poc.compositepu.entity.TableOne;
import com.test.poc.compositepu.service.TableOneService;
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
public class TableOneController {

	private static final Logger LOG = LoggerFactory.getLogger(TableOneController.class);

	@Autowired
	private TableOneService tableOneService;

	@RequestMapping(value = "/tableone", method = RequestMethod.GET)
	@ResponseBody
	public List<TableOne> getTableOneList(@RequestParam Integer start,
			@RequestParam Integer range) {
		LOG.info("-> getTableOneList start={}, range={}", start, range);
		List<TableOne> result = tableOneService.getTableOneList(start, range);
		LOG.info("<- getTableOneList returning {} objects", result.size());
		return result;
	}

}

package org.ozen.core.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobController {
	
	Logger logger = LoggerFactory.getLogger(JobController.class);
	
	public void testrun(){
		logger.info(System.currentTimeMillis()+"2222222");
		System.out.println(System.currentTimeMillis()+"===");
	}
	
}

package com.project0.logging;

import org.apache.log4j.Logger;

public class Logging {
	
	public final static Logger logger = Logger.getLogger(Logging.class);
	
	public static void main(String[] args) {
		
		System.out.println("regular sysout without log4j");
		logger.trace("trace message - very fine-grained");
		logger.debug("this statement should be useful for debugging the application");
		logger.info("informational message use this level of logging");
		logger.warn("something bad potentially could happen");
		logger.error("something went wrong");
		logger.fatal("something very bad happened");
	}


}

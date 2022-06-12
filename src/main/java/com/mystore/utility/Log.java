
 
/**
 * 
 */
package com.mystore.utility;

import org.apache.log4j.Logger;

/**
 * @author baitharu
 * 
 * Step 1 : Include log4j maven dependency in pom.xml
 * Step  2: include a log4j.xml in ur project path(it includes appenders like console/file appenders)
 * includes pattern Layout and also path of getting the logs
 * Step 3: create methods for log levels and
 * create start and endTC methods for log levels
 * Initialize log object using getlogger method of log4j
 *Step 4 : Create log.java class in UTility and there initialize the log4j.xml via DOMConfigurator(feom apache log4j library) in BAse class
 *
 */
public class Log {
	
	public static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName) {
		log.info("=================================="+sTestCaseName+ " TESTCASE START=================================================");
	}
	
	public static void endTestCase(String sTestCaseName) {
		log.info("=================================="+sTestCaseName+ " TESTCASE END===================================================");
	}
	
	
	
	public static void warn(String message) {
		log.warn(message);
	}
	
	public static void info(String message) {
		log.info(message);
	}
	
	public static void fatal(String message) {
		log.fatal(message);
	}
	public static void error(String message) {
		log.error(message);
	}
	public static void debug(String message) {
		log.debug(message);
	}

}

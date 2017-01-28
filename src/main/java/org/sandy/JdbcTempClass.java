package org.sandy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTempClass {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcDAO jdbcDAO= ac.getBean("jdbcDAO", JdbcDAO.class);
		//jdbcDAO.createTable();
		//jdbcDAO.insertData(1, "sandeep");
		//jdbcDAO.updateData(4, "sandeepUpdated");
		//jdbcDAO.deleteData(1);
		jdbcDAO.selectData();
	}

}

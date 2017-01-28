package org.sandy;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class JdbcDAO {

	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("jjj");
	}

	public void createTable() {
		String query = "CREATE TABLE sample (id INTEGER, name VARCHAR(255))";
		jdbcTemplate.execute(query);
		System.out.println("created");
	}

	public void insertData(int id, String name) {
		String query = "insert into sample (id, name) values (?, ?)";
		jdbcTemplate.update(query, id, name );
		System.out.println("inserted");
	}

	public void updateData(int id, String name) {
		String query = "update sample set name = ? where id = ?";
		jdbcTemplate.update(query, name, id);
		System.out.println("updated");
	}

	public void deleteData(int id) {
		String query = "delete from sample where id = ?";
		jdbcTemplate.update(query, id);
		System.out.println("deleted");
	}
	public void selectData() {
		String query = "select * from sample";
		List<Sample> list = jdbcTemplate.query(query, new RowMapperImpl());
		for(Sample samp : list) {
			System.out.println(samp.getId());
			System.out.println(samp.getName());
		}
		System.out.println("List of data" + list.size());
	}
}

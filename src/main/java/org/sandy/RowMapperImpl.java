package org.sandy;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Sample>{

	@Override
	public Sample mapRow(ResultSet rs, int value) throws SQLException {
		Sample sample = new Sample();
		sample.setId(rs.getInt("id"));
		sample.setName(rs.getString("name"));
		return sample;
	}

}

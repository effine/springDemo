
/**
 * @author verphen
 * @date 2014年6月24日  下午3:29:18
 */

package com.verphen.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.verphen.model.Student;

public class TestJDBC extends JdbcDaoSupport{
	public List<Student> getStuList() {
		List<Student> stuList = new ArrayList<Student>();
		String sql = "select * from student";
		System.out.println("是否为空："+ getJdbcTemplate());
		stuList = getJdbcTemplate().query(sql, new RowMapper<Student>(){
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setUsername(rs.getString("username"));
				stu.setPassword(rs.getString("password"));
				return stu;
			}
		});
		return stuList;
	}
}



package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImp implements StudentDao {
	JdbcTemplate template;

	public int insert(Student student) {
		String query = "INSERT INTO STUDENT (ID,NAME,CITY) VALUES(?,?,?)";
		int r = this.template.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int change(Student student) {
		String query = "UPDATE STUDENT SET NAME=?, CITY=? WHERE ID=?";
		int r = this.template.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	public int delete(Student student) {
		String query = "DELETE FROM STUDENT WHERE NAME=?";
		int r = this.template.update(query, student.getName());
		return r;
	}

	public Student getStudent(int rowid) {
		String query = "SELECT * FROM STUDENT WHERE ID=?";
		RowMapper<Student> rowMapper = new RowMapperImp();
		Student r = this.template.queryForObject(query, rowMapper, rowid);
		return r;
	}

	public List<Student> getAllStudent() {
		String query = "SELECT * FROM STUDENT";
		List<Student> list = this.template.query(query, new RowMapperImp());
		return list;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}

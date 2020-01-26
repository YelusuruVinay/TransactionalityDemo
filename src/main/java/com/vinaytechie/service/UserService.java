package com.vinaytechie.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinaytechie.model.User;

@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void insert(List<User> users) {

		for (User user : users) {
			System.out.println("User inserting into table" + user.getName());
			jdbcTemplate.update("insert into USER(Name,Dept,Salary) values(?,?,?) ", preparedStatement -> {
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getDept());
				preparedStatement.setLong(3, user.getSalary());
			});
		}

	}

	public List<User> getUsers() {
		List<User> userList = jdbcTemplate.query("Select Name,Dept,Salary from USER", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("Name"), rs.getString("Dept"), rs.getLong("Salary"));
			}
		});
		System.out.println("retrieve all users " + userList);
		return userList;

	}
}

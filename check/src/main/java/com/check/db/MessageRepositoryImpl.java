package com.check.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositoryImpl implements MessageRepositoryCustom {

	@Autowired
	DataSource dataSource;

	@Override
	public boolean checkIfMessageExists(Message message) {

		try {
			Statement stmt = dataSource.getConnection().createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from message where msg = '"
							+ message.getMsg() + "'");
			if (!rs.next()) {
				return false;

			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

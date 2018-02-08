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

	private static String convertToSequence(int number) {
		StringBuilder builder = new StringBuilder();
		while (number > 0) {
			int val = number % 34;
			if (val < 10) {
				builder.append(val);
			} else if (val <= 17) {
				builder.append((char) (val + 55));
			} else if (18 <= val && val < 24) {
				builder.append((char) (val + 1 + 55));

			} else {
				builder.append((char) (val + 2 + 55));
			}
			number = number / 34;
		}
		return builder.reverse().toString().toUpperCase();
	}
	
	public static String reverseStr(String name){
        
		String reverse = "";
        if(name.length() == 1){
            return name;
        } else {
            reverse += name.charAt(name.length()-1)
                    +reverseStr(name.substring(0,name.length()-1));
            return reverse;
        }
    }
	
	public static boolean isPalindrome(String name) {
		  int n = name.length();
		  for (int i = 0; i < (n/2); ++i) {
		     if (name.charAt(i) != name.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
		} 

	public static void main(String args[]) {
		System.out.println(convertToSequence(1118));
		System.out.println(reverseStr("shar"));
		System.out.println(isPalindrome("shsaaa"));
	}

}

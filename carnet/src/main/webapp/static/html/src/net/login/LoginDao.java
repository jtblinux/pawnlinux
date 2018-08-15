package net.login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDao {
	// 得到JdbcTemplae对象
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Login login(Login login) {
		String sql = "select * from login where username='" + login.getUsername() + "' and pwd='" + login.getPwd()
				+ "' ";
		String countsql = "select count(1) from (" + sql + ") a";
		int count = jdbcTemplate.queryForInt(countsql);
		if (count > 0) {
			Map<String, Object> usermap = jdbcTemplate.queryForMap(sql);
			System.out.println(usermap);
			if (usermap != null) {
				login.setRealname("" + usermap.get("realname"));
			} else {
				login = null;
			}
		} else {
			login = null;
		}
		return login;
	}

}

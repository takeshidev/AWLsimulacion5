package cl.takeshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.takeshi.beans.Post;

public class DAOpost {

	private String BORRAR_POSTS = "delete from posts";
	private final String INSERT_POSTS = "INSERT INTO POSTS (ID, USERS_ID, TITLE, BODY) VALUES (?, ?, ?, ?)";
	
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void borrarPosts(){
		template.execute(BORRAR_POSTS);
		System.out.println("POSTS ELIMINADOS");
	}
	
	public int ingresarPost (Post p) {
		return template.update(INSERT_POSTS,  new Object[]{
				p.getId(),
				p.getUserId(),
				p.getTitle(),
				p.getBody()
		}
		);
		
	}
	
	
	
	
	
	public class PostMapper implements RowMapper<Post>{
		public Post mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Post(
					rs.getInt("id"),
					rs.getInt("userId"),
					rs.getString("title"),
					rs.getString("body")	
					);
		}
	}
	
	
}

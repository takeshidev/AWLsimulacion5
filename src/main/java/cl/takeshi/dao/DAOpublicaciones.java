package cl.takeshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.takeshi.beans.Publicacion;

public class DAOpublicaciones {

	private final String LISTAR_TODO = 
			"SELECT posts.id, posts.title, posts.body, users.username, COUNT(comments.id) AS IDcomment FROM users INNER JOIN posts ON posts.users_id = users.id INNER JOIN comments ON comments.posts_id = posts.id GROUP BY posts.id, posts.title, posts.body, users.username";
	private final String LISTAR_BYID = 
			"SELECT posts.id, posts.title, posts.body, users.username, COUNT(comments.id) AS IDcomment FROM users INNER JOIN posts ON posts.users_id = users.id INNER JOIN comments ON comments.posts_id = posts.id WHERE posts.id =";
	private String LISTAR_BYID2= " GROUP BY posts.id, posts.title, posts.body,  users.username";
	
		
	JdbcTemplate template;
		
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public List<Publicacion> listarTodos(){
		return template.query(LISTAR_TODO, new PublicacionMapper());
	}
	
	public List<Publicacion> listarById(int id){
		return template.query(LISTAR_BYID+id+LISTAR_BYID2, new PublicacionMapper());
		
	}
	
	
	public class PublicacionMapper implements RowMapper<Publicacion>{
		public Publicacion mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Publicacion(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("body"),
					rs.getString("username"),
					rs.getInt("idcomment")
					);
					
		};
	}
	
}

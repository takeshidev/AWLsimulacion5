package cl.takeshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.takeshi.beans.Comment;
import cl.takeshi.beans.Post;

public class DAOcomment {
	
	private String BORRAR_COMMENTS = "delete from comments";
	private final String INSERT_COMMENT = "INSERT INTO COMMENTS (ID, POSTS_ID, NAME, EMAIL, BODY) VALUES (?, ?, ?, ?, ?)";
	private String VER_COMMENTS= "SELECT comments.id, comments.posts_id as postid, comments.name, comments.email, comments.body FROM users INNER JOIN posts ON posts.users_id = users.id INNER JOIN comments ON comments.posts_id = posts.id WHERE comments.posts_id ="; 
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void borrarComentarios(){
		template.execute(BORRAR_COMMENTS);
		System.out.println("COMENTARIOS ELIMINADOS");
	}
	
	public int ingresarComentario (Comment c) {
		return template.update(INSERT_COMMENT,  new Object[]{
				c.getId(),
				c.getPostId(),
				c.getName(),
				c.getEmail(),
				c.getBody()
		}
		);
		
	}
	
	public List<Comment> listarcomentarios(int id){
		return template.query(VER_COMMENTS+id, new CommentMapper());
	}
	
	
	public class CommentMapper implements RowMapper<Comment>{
		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Comment(
					rs.getInt("id"),
					rs.getInt("postId"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("body")
					);
		}
	}
	
	
	
}

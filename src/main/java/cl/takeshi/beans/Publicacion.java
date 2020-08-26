package cl.takeshi.beans;

public class Publicacion {

	private int id;
	private String title;
	private String body;
	private String username;
	private int idcomment;
	
	
	public Publicacion() {
		super();
	}

	public Publicacion(int id, String title, String body, String username, int idcomment) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.username = username;
		this.idcomment = idcomment;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public String getUsername() {
		return username;
	}

	public int getIdcomment() {
		return idcomment;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}
	
	
	
	
	
}

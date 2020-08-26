package cl.takeshi.beans;

public class Comment {

	private int id;
	private int postId;
	private String name;
	private String email;
	private String body;
	private String veinte;
	
	
	public Comment() {
		super();
	}

	public Comment(int id, int postId, String name, String email, String body) {
		super();
		this.id = id;
		this.postId = postId;
		this.name = name;
		this.email = email;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public int getPostId() {
		return postId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getBody() {
		return body;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getVeinte() {
		return veinte;
	}

	public void setVeinte(String veinte) {
		this.veinte = veinte;
	}
	
	
	
}

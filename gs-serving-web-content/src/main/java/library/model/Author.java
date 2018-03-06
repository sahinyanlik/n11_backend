package library.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7200921225117587519L;
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

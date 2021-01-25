package srdt.co.in.addons.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	private Long id;
	private String  Name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public User(Long id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

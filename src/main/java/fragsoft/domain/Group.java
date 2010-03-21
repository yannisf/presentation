package fragsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {

	private static final long serialVersionUID = -4524848488026169491L;

	private String id;
	private String name;
	private List<User> users;

	public Group() { }

	public Group(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		if(users == null) {
			users = new ArrayList<User>();
		}
		
		return users;
	}
	
	public void  addUser(User user) {
		getUsers().add(user);
		user.addGroup(this);
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

}

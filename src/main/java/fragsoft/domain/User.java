package fragsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = -4588667752825101729L;

	private String id;
	private String username;
	private List<Group> groups;

	public User() { }

	public User(String id, String username) {
		this.id = id;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Group> getGroups() {
		if(groups == null) {
			groups = new ArrayList<Group>();
		}
		
		return groups;
	}
	
	public void addGroup(Group group) {
		getGroups().add(group);
		group.addUser(this);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}

}

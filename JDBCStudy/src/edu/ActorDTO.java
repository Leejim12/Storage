package edu;

public class ActorDTO {
	int actor_id;
	String first_name;
	String last_name;
	String last_update;
	
	public ActorDTO(int int1, String string, String string2, String last_update) {
		super();
		this.actor_id = int1;
		this.first_name = string;
		this.last_name = string2;
		this.last_update = last_update;
	}
	
	
	public String getLast_update() {
		return last_update;
	}


	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}


	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	@Override
	public String toString() {
		return "ActorDTO [actor_id=" + actor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", last_update=" + last_update + "]";
	}
	
	

}

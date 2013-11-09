import java.util.*;
import java.io.*;

public class MovieGoer implements Serializable{
	
	private String name;
	


	private String phone;
	private String email;
	
	
	public MovieGoer(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "MovieGoer [name=" + name + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
}
	
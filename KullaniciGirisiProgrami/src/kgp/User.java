package kgp;

public class User {

	private String userId;
	private String password;
	private String name;
	private int age;
	private String school;
	private String department;


	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;

	}




	public User(String userId, String password, String name, int age, String school, String department) {
		this(userId, password);
		this.name = name;
		this.age = age;
		this.school = school;
		this.department = department;
	}

	
	



	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}




}

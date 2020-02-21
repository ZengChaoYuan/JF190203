package bean;

public class User {
	private int userId;
	private String userName;
	private int sex;

	public User(int userId, String userName, int sex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

}

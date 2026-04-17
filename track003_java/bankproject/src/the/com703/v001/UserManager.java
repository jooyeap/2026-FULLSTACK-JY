package the.com703.v001;

public class UserManager {
	
	User[] userList = new User[3];
	int count = 0;

	public void user_Info(User user) {
		if (count < userList.length) {
			userList[count] = user;
			count++;
		}
		else {System.out.println("3개 초과");}
	}
}

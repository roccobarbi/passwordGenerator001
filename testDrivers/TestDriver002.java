package passwordGenerator001.testDrivers;

import passwordGenerator001.Password;

public class TestDriver002 {
	public static void main(String[] args){
		Password password = new Password(8);
		System.out.println(password.getPassword());
		System.out.println("Length = " + password.getPassword().length());
	}
}

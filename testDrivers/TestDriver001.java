package passwordGenerator001.testDrivers;

import passwordGenerator001.*;

public class TestDriver001 {
	public static void main(String[] args){
		Password password = new Password();
		System.out.println(password.getPassword());
		System.out.println("Length = " + password.getPassword().length());
	}
}

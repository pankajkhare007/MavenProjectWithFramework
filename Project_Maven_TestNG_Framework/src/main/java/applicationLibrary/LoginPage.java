package applicationLibrary;

import java.sql.ResultSet;

import core.MySQLConnection;
import core.WebControls;
import objectRepository.Common;

public class LoginPage {
	
	public static void login() {
		
		var data  = MySQLConnection.getData("SELECT * FROM login");
		
		WebControls.inputText(Common.username, data.get("Username"), "Entered username");
		WebControls.inputText(Common.password, data.get("Password"), "Entered password");
	}

}

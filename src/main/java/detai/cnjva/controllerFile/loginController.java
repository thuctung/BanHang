package detai.cnjva.controllerFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detai.cnjva.DAOFile.UserDAO;
import detai.cnjva.connecDatabase.connection;
import detai.cnjva.modelFile.User;

@Controller
public class loginController {
	@Autowired
	private UserDAO userDao;
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String Posstlogin(HttpServletRequest request) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		//UserDAO userDao = new UserDAO();
		String userName = request.getParameter("username");
		String password = request.getParameter("matkhau");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(password);		
		// goi DAO
		if(userDao.checkLogin(user)) {
			request.setAttribute("mess","Ok" );
			return "redirect:/";
		}
		request.setAttribute("mess","Fails" );
		return "login";
	}
}

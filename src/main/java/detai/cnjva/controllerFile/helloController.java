package detai.cnjva.controllerFile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import detai.cnjva.DAOFile.UserInfoDAO;
import detai.cnjva.modelFile.UserInfo;
@Controller
public class helloController {
	//@Autowired

	@RequestMapping("/")
	public String hello(Model model) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		return "index";
	}
}

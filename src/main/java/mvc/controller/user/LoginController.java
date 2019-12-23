package mvc.controller.user;

import javax.servlet.http.HttpSession;

import mvc.business.user.UserDAO;
import mvc.business.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료하고 메인 화면으로 이동
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) { // Command 객체는 컨테이너에 의해 자동으로 result 에 등록
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, Model model) {
		if(vo != null) {
			UserVO user = userDAO.getUser(vo);
			model.addAttribute("user", user);
			return "redirect:getBoardList.do";
		} else {
			return "login";
		}		
	}

}

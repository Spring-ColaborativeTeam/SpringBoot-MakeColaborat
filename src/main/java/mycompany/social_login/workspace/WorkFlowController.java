/**
 * 
 */
package mycompany.social_login.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Manuel Felipe.
 *
 */
@Controller
public class WorkFlowController {

	

	@RequestMapping(value = "/userwork", method = RequestMethod.GET)
	public String showWorkSpace(WebRequest request, Model model) {
		return "userwork";
	}
        @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showFormRegister(WebRequest request, Model model) {
		return "registerForm";
	}

}

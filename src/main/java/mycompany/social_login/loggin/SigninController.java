/**
 * 
 */
package mycompany.social_login.loggin;

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
public class SigninController {

	
        /**
         * 
         * @param request
         * @param model
         * @return 
         */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		return "signin";
	}

}

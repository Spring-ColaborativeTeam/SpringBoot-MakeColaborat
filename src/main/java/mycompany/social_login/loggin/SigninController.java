/**
 * 
 */
package mycompany.social_login.loggin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
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
	public String GetLoggingForm(WebRequest request, Model model) {
           
		return "signin";
	}

        
}

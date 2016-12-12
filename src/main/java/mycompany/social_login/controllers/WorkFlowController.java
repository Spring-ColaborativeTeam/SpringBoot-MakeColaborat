/**
 * 
 */
package mycompany.social_login.controllers;

import mycompany.social_login.home.ManejadorUsuarioExcepcion;
import mycompany.social_login.home.ManejoUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Manuel Felipe.
 *
 */
@Controller
public class WorkFlowController {

   @Autowired
    ManejoUsuarios mu;

	@RequestMapping(value = "/userwork.{user}", method = RequestMethod.GET)
	public String showWorkSpace(WebRequest request,@PathVariable("user") String user) {
              
		return "userwork";
	}
        @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showFormRegister(WebRequest request) {
		return "registerForm";
	}
        @RequestMapping(value = "/userProfile.{user}", method = RequestMethod.GET)
       public String showLogginForm(WebRequest request , @PathVariable("user") String user) throws ManejadorUsuarioExcepcion{
            if(mu.getUsuario(user)!=null){
                 return "userProfile";
            }
          else
                return "";
          
       }

}

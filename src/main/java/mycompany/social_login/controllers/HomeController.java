/**
 * 
 */
package mycompany.social_login.controllers;

import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Manuel Felipe.
 *
 */
@Controller
@SessionAttributes("twitterProfile")
public class HomeController {

    
	 private Twitter twitter;

	 private ConnectionRepository connectionRepository;
	/**
         * Constructor de HomeController , inyecta dos beans.
         * @param twitter Servicio del API para Twitter de springframework.social.
         * @param connectionRepository provee una interfaz que funcionara como una especie de DAO 
         *                             para guardar y restaurar objetos de conexiòn de un almacen persistente.
         *                             Hay que consultar UsersConnectionRepository.
         */
	@Autowired
	public HomeController(Twitter twitter,
			ConnectionRepository connectionRepository) {
		this.twitter = twitter;
		this.connectionRepository = connectionRepository;
	}
   /**
   * RequestMapping ruta de inicio 
   * @param model  objeto que tiene acceso tanto a la vista como a los controllers.
   * @return 
   */
	@RequestMapping("/")
	public String home(Model model) {
       
   //    if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
     //      return "home";
       //}

     //  model.addAttribute(twitter.userOperations().getUserProfile());
        //ursoredList<TwitterProfile> friends = retrieveFriends();
       // model.addAttribute("friends", friends);
       return "home";
	}

	/**
         * La anotacaion @Cacheable indica que el resultado de la invocación de este
         * metodo se puede guardar en cache. 
         * CursoredList : http://docs.spring.io/spring-social-twitter/docs/1.0.5.RELEASE/api/org/springframework/social/twitter/api/CursoredList.html
	 * @return
	 */
	@Cacheable(key="retrieveFriends")
	public CursoredList<TwitterProfile> retrieveFriends() {
		CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
		return friends;
	}
}

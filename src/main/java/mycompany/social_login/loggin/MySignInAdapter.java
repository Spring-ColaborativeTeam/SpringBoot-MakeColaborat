/**
 * 
 */
package mycompany.social_login.loggin;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;
/**
 * @author Manuel Felipe.
 *
 */
public class MySignInAdapter implements SignInAdapter{

	
	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {

		return extractOriginalUrl(request);
	}

	private String extractOriginalUrl(NativeWebRequest request) {
		HttpServletRequest nativeReq = request.getNativeRequest(HttpServletRequest.class);
                System.out.println("nativeReq" + nativeReq.toString());
		HttpServletResponse nativeRes = request.getNativeResponse(HttpServletResponse.class);
    System.out.println("nativeResp" + nativeRes.toString());
			return null;

	}
		 


}

package FormValidation06Boot.FormValidation06BootStart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginpage")
	public String showMyLoginPage()
	{
		return "fancy-login";
	}


}

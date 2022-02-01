package FormValidation06Boot.FormValidation06BootStart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "FormValidation06Boot.FormValidation06BootStart")
public class ServletInitializer extends SpringBootServletInitializer {

	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(FormValidation06BootStartApplication.class);
	    }

	    public static void main(String[] args) {
	    	SpringApplication.run(FormValidation06BootStartApplication.class);
	    }
	
}

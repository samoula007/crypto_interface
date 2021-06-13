//declaring package
package com.trendo.backend;

//imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//spring controller
@Controller
public class HomeController {
	// mapping app at root localhost
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

}

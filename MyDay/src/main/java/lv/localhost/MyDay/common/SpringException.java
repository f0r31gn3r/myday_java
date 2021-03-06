package lv.localhost.MyDay.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringException {
	@ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {
        return "notfound";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable("name") final String name, Model model) {
        if (name.equals("null")) throw new ResourceNotFoundException();
        model.addAttribute("msg", name);
        return "notfound";
    }
}

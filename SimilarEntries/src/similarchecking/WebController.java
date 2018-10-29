package similarchecking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import java.io.FileNotFoundException;

@Controller
public class WebController {
  @RequestMapping(method = RequestMethod.GET)public String printOutput(ModelMap model) {
    Main run = new Main();
    try {
      model.addAttribute("message", run.main());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return "index";
  }
}
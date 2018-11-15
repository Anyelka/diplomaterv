package home.wagers;

import service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RemoveWagerController {

    private static final String REQUEST_MAPPING = "/removeWager.html";

    @Autowired
    private WagerService wagerService;
    
    @RequestMapping(REQUEST_MAPPING)
    public String removeWager(RemoveWagerRequest removeWagerRequest) {
        wagerService.deleteWager(removeWagerRequest.getId());
        return "redirect:/home.html";
    }
}

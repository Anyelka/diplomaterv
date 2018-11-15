package home.accountdetails;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConModController {
    private static final String REQUEST_MAPPING = "/concurrentModificationError.html";

    @RequestMapping(REQUEST_MAPPING)
    public String concurrentModificationErrorPage() {
        return "concurrentModificationError";
    }
}

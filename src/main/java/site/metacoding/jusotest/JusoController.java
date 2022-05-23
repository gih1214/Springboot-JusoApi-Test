package site.metacoding.jusotest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JusoController {

    @GetMapping("/")
    public String index(Model model) {
        String jusoUrl = "https://www.juso.go.kr/addrlink/addrLinkUrl.do?confmKey=devU01TX0FVVEgyMDIyMDUyMzEwNDgzNTExMjYwMDA=&returnUrl=http://localhost:8080/juso/callback&resultType=4";
        model.addAttribute("jusoUrl", jusoUrl);
        return "index";
    }

    @PostMapping("/juso/callback")
    public void jusoCallback(String roadFullAddr) {
        System.out.println(roadFullAddr);
    }
}
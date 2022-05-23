package site.metacoding.jusotest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JusoController {

    @GetMapping("/")
    public String index(Model model) {
        String jusoUrl = "https://www.juso.go.kr/addrlink/addrLinkUrl.do?confmKey=devU01TX0FVVEgyMDIyMDUyMzEwNDgzNTExMjYwMDA=&returnUrl=http://localhost:8080/juso/callback&resultType=4";
        model.addAttribute("jusoUrl", jusoUrl);
        return "index";
    }

    // 해당 콜백이 호출되면 push 해주는 것이 좋다. (그럴려면 스트림이 유지되고 있어야 함)
    // -> 웹소켓, SSE
    @PostMapping("/juso/callback")
    public void jusoCallback(String roadFullAddr) {
        System.out.println(roadFullAddr);
        Store.roadFullAddr = roadFullAddr;
    }

    // 서버에 잠시 주소를 저장해놓음
    @GetMapping("/juso/check")
    public @ResponseBody String jusoCheck() {
        return Store.roadFullAddr;
    }
}

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:dbing
 */

@Controller
public class TestController {

    @RequestMapping("/test")
    public void test(){
        System.out.println("test");
    }

}

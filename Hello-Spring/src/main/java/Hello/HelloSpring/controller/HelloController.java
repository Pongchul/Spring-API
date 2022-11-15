package Hello.HelloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hi")
    public String hi(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody // -> http body 부분에 직접 데이터로 넘겨주겠다
    public String helloSpring(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    // hello가 단순 String일 경우 String Converter가 동작을 하지만
    // 지금 같은 경우 객체로 들어갔기 때문에 Json converter가 작동한다.

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

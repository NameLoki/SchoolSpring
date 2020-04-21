package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // @GetMapping
    // public String hello() {
    //     return "Hellow World!";
    // } 

    @GetMapping("/greeting")
    public String greeting(@RequestParam final String say, @RequestParam final String to) {
        return say + " " + to;
    }

    @GetMapping("/greeting1/{say}/{to}")
    public String greeting1(@PathVariable final String say, @PathVariable final String to) { // Path형식
        return say + " " + to + " greeting1";
    }

    @PostMapping("/greetingPost")
    public String greetingPost(@RequestParam final String sayPost, @RequestParam final String toPost) {
        return sayPost + " " + toPost + "Post";
    }
}
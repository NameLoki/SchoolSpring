package kr.hs.dgsw.webclass01.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webclass01.calculator.model.interfaces.CalculatorService;

@RestController
public class GetController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(@RequestParam("sign") String sign, @RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        return calculatorService.getResult(num1, num2, sign);
    }
}
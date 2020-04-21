package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    private boolean isNumber = true;

    @GetMapping("/calculator/{mark}")
    public String calculator(@PathVariable final String mark, @RequestParam("str1") String str, @RequestParam final String str2) {

        float num1 = parse(str);
        float num2 = parse(str2);

        String message = null;

        if(!isNumber) {

            message = "숫자가 아닙니다.";

        } else {
            
            if(mark.equals("add")) {
                message = String.valueOf(add(num1, num2));
            } else if(mark.equals("sub")) {
                message = String.valueOf(sub(num1, num2));
            } else if(mark.equals("mul")) {
                message = String.valueOf(mul(num1, num2));
            } else if(mark.equals("div")) {

                float temp = div(num1, num2);

                if(temp < 0) {
                    message = "나눗셈에는 0이 들어갈 수 없습니다.";
                } else {
                    message = String.valueOf(temp);
                }
            } else {
                message = "비정상적인 접근입니다.";
            }
        }

        return message;
    }

    private float add(float n1, float n2) {
        return n1 + n2;
    }

    private float sub(float n1, float n2) {
        return n1 - n2;
    }

    private float mul(float n1, float n2) {
        return n1 * n2;
    }

    private float div(float n1, float n2) {
        if(n1 == 0 || n2 == 0) {
            return -1;
        }
        return n1 / n2;
    }

    private float parse(String str) {

        float num = 0.0f;

        try {
            num = Float.parseFloat(str);
        } catch (NumberFormatException e) {
            isNumber = false;
        }

        return num;
    }
}
package kr.hs.dgsw.webclass01.calculator.model;

import org.springframework.stereotype.Service;

import kr.hs.dgsw.webclass01.calculator.model.interfaces.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private boolean isZero;
    private boolean isNotNumber;
    private String message;

    public CalculatorServiceImpl() {
        reset();
    }

    @Override
    public int calculator(int num1, int num2, String sign) {
        int result = 0;

        switch(sign) {
            case "add":
                result = num1 + num2; 
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                if(num2 == 0) {
                    isZero = true;
                } else {
                    result = num1 / num2;
                }
                break;
        }

        return result;

    }

    public int numParser(String str) {
        int num = 0;

        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            isNotNumber = true;
            message = e.toString();
        }

        return num;
    }

    @Override
    public String getResult(String num1, String num2, String sign) {

        int result = calculator(numParser(num1), numParser(num2), sign);

        if(isNotNumber) {
            message += " 숫자가 아닌 것을 확인해주세요.";
        } else if(isZero) {
            message = "0으로 나누기를 시도했습니다.";
        } else {
            message = "결과 : " + result;
        }

        reset();

        return message;
    }

    private void reset() {
        isZero = false;
        isNotNumber = false;
    }

}
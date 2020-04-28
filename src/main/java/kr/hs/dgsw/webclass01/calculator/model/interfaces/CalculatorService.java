package kr.hs.dgsw.webclass01.calculator.model.interfaces;

public interface CalculatorService {

    public int calculator(int num1, int num2, String sign);

    public String getResult(String num1, String num2, String sign);
}
import java.util.regex.Pattern;

public class EvaluateByString {

    public String evaluate(String expression) throws EvaluateCalculationException{
        String evaluateResult;
        if (!expression.matches("^-?\\d+\\.?\\d?[-+*\\/]-?\\d+\\.?\\d?$")){
            throw new EvaluateCalculationException();
        }


        if(expression.contains("+")){
            String[] calc = expression.split("\\+");
            evaluateResult = String.valueOf(Double.parseDouble(calc[0]) + Double.parseDouble(calc[1]));
            return evaluateResult;

        }
        if(expression.contains("*")){
            String[] calc = expression.split("\\*");
            evaluateResult = String.valueOf(Double.parseDouble(calc[0]) * Double.parseDouble(calc[1]));
            return evaluateResult;

        }
        if(expression.contains("/")){
            String[] calc = expression.split("\\/");
            if(Integer.parseInt(calc[1])==0){
                throw new EvaluateCalculationException();
            }
            evaluateResult = String.valueOf(Double.parseDouble(calc[0]) / Double.parseDouble(calc[1]));
            return evaluateResult;
        }
        else{
            int minus = expression.length() - expression.replace("-", "").length();
            if (minus == 1){
                String[] calc = expression.split("\\-");
                evaluateResult = String.valueOf(Double.parseDouble(calc[0]) - Double.parseDouble(calc[1]));
                return evaluateResult;
            }
            else{
                String a = expression.substring(0, expression.indexOf("-", 1));
                String b = expression.substring(expression.indexOf("-", 1)+1);
                evaluateResult = String.valueOf(Double.parseDouble(a) - Double.parseDouble(b));
                return evaluateResult;
            }
        }
    }
}

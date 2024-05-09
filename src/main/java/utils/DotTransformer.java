package utils;

public class DotTransformer {

    public static Double dotTransform(String num){
        String strNum = num.replace(",",".");
        return Double.parseDouble(strNum);
    }
}

package br.com.kaiocandido.convert;

public class IsNumeric {

    public boolean validador(String number){

        if(number == null || number.isEmpty()){
            return false;
        }

        String n = number.replace(",", ".");

        return n.matches("[-+]?[0-9]*\\.?[0-9]+") ? true : false;
    }
}

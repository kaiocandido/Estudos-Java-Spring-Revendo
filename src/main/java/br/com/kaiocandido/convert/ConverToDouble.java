package br.com.kaiocandido.convert;

import br.com.kaiocandido.exception.UnsuportedMathOperationException;

public class ConverToDouble {

    public Double converter(String number) throws UnsuportedMathOperationException {
        if(number == null || number.isEmpty()){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        String n = number.replace(",", ".");

        return Double.parseDouble(n);

    }
}

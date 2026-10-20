package br.com.kaiocandido.controllers;

import br.com.kaiocandido.convert.ConverToDouble;
import br.com.kaiocandido.convert.IsNumeric;
import br.com.kaiocandido.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {

    IsNumeric numerico = new IsNumeric();
    ConverToDouble converterNumero = new ConverToDouble();

    @RequestMapping("/sum/{x}/{y}")
    public Double sum(@PathVariable("x") String x, @PathVariable("y") String y) throws UnsuportedMathOperationException {
        if(!numerico.validador(x) || !numerico.validador(y)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        return converterNumero.converter(x) + converterNumero.converter(y);
    }

    @RequestMapping("/sub/{x}/{y}")
    public Double sub(@PathVariable("x") String x, @PathVariable("y") String y) throws UnsuportedMathOperationException {
        if(!numerico.validador(x) || !numerico.validador(y)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        return converterNumero.converter(x) - converterNumero.converter(y);
    }

    @RequestMapping("/div/{x}/{y}")
    public Double div(@PathVariable("x") String x, @PathVariable("y") String y) throws UnsuportedMathOperationException {
        if(!numerico.validador(x) || !numerico.validador(y)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        return converterNumero.converter(x) / converterNumero.converter(y);
    }

    @RequestMapping("/media/{x}/{y}")
    public Double media(@PathVariable("x") String x, @PathVariable("y") String y) throws UnsuportedMathOperationException {
        if(!numerico.validador(x) || !numerico.validador(y)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        return (converterNumero.converter(x) + converterNumero.converter(y)) / 2;
    }

    @RequestMapping("/raiz/{x}/{y}")
    public Double raiz(@PathVariable("x") String x) throws UnsuportedMathOperationException {
        if(!numerico.validador(x)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        return Math.sqrt(converterNumero.converter(x));
    }

}

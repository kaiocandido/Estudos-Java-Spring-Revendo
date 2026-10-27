package br.com.kaiocandido.controllers;

import br.com.kaiocandido.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class testeLogController {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(testeLogController.class);

    @GetMapping("/teste")
    public String testeLog(){
        logger.info("This is an INFO Log");
        logger.warn("This is an WARN");
        logger.debug("This is an DEBUG");
        logger.error("This is an ERROR");

        return "Logs generate successfully!!";
    }
}

package br.com.kaiocandido.exception;

import java.util.Date;

public record ExceptionRespose(Date timestamp, String msg, String datails) {

}

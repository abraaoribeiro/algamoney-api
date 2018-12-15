package com.example.algamoney.api.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AlgamoneyExceptionHendler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String messagemUsuario = messageSource.getMessage("message.invalida", null, LocaleContextHolder.getLocale());
		String messagemDesenvolvedor = ex.getCause().toString();

		return handleExceptionInternal(ex, new Erro(messagemUsuario, messagemDesenvolvedor), headers,
				HttpStatus.BAD_REQUEST, request);
	}

	public static class Erro {

		private String messagemUsuario;
		private String messagemDesenvolvedor;

		private Erro(String messagemUsuario, String messagemDesenvolvedor) {
			this.messagemUsuario = messagemUsuario;
			this.messagemDesenvolvedor = messagemDesenvolvedor;

		}

		public String getMessagemUsuario() {
			return messagemUsuario;
		}

		public String getMessagemDesenvolvedor() {
			return messagemDesenvolvedor;
		}

	}

}

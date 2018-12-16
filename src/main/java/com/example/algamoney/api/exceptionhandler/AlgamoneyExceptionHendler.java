package com.example.algamoney.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class AlgamoneyExceptionHendler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String messagemUsuario = messageSource.getMessage("message.invalida", null, LocaleContextHolder.getLocale());
		String messagemDesenvolvedor = ex.getCause().toString();

		List<Erro> erros = Arrays.asList( new Erro(messagemUsuario, messagemDesenvolvedor));
		return handleExceptionInternal(ex, erros,headers,HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		return super.handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	private List<Erro> criarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<>();
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			String messagemUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String messagemDesenvolvedor = fieldError.toString();
			
			erros.add(new Erro(messagemUsuario, messagemDesenvolvedor));
			                                  
		}
		return erros;

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

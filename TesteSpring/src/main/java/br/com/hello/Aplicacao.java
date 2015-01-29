package br.com.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Aplicacao {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Aplicacao.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		MessagePrinter printer2 = context.getBean(MessagePrinter.class);
		System.out.println("instancias 1: " + printer.toString() + " - " + "instancias 1: " + printer2.toString());
		printer.printMessage();
	}

	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello World!";
			}
		};
	}

}

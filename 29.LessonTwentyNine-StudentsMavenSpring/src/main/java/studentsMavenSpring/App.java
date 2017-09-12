package studentsMavenSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import studentsMavenSpring.config.AppConfig;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Hello World!");
	}
}

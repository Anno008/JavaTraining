package studentsMavenSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import studentsMavenSpring.config.AppConfig;
import studentsMavenSpring.view.MainView;

public class App {	
	public static void main(String[] args) {
		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MainView mainView = context.getBean(MainView.class);
		mainView.start();
	}
}

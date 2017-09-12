package countriesMavenSpring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import countriesMavenSpring.config.AppConfig;
import countriesMavenSpring.view.CountryView;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CountryView view = context.getBean(CountryView.class);
		view.start();
	}
}

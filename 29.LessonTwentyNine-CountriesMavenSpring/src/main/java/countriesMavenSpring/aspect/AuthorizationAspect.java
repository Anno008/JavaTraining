package countriesMavenSpring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import countriesMavenSpring.service.AuthorizationService;

@Component
@Aspect
public class AuthorizationAspect {

	@Autowired
	private AuthorizationService authorizationService;

	// For every method that we want only the administrator to be able to execute annotate the method with @IAuthorizationEvent
	@Around("@annotation(countriesMavenSpring.aspect.IAuthorizationEvent)")
	public Object authorize(ProceedingJoinPoint jp) throws Throwable {
		if (authorizationService.getLoggedUser().isAdmin()) {
			return jp.proceed();
		}
		System.out.println("You are not authorized for this command.");
		return null;
	}
}

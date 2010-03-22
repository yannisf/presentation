package fragsoft.crosscut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ManagedBeanInterceptor {
	
	private static final Logger LOG = LoggerFactory.getLogger(ManagedBeanInterceptor.class);
	
	  @Pointcut("execution(String fragsoft.controllers.UserController.*())" )
	  void action() {}
	  
	  @Before("action()") 
	  public void beforeAction() {
		  LOG.info("AspectJ interception. ");
	  }

	
	


}

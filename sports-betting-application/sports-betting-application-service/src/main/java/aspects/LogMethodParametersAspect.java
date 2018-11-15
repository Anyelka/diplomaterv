package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodParametersAspect {
    private static final Logger LOG = LoggerFactory.getLogger(LogMethodParametersAspect.class);

    @Before("PointCuts.all()")
    public void logMethodParameters(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        if(arguments.length!=0) {
            LOG.info("->"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+ "() method's parameters:");
            for(Object param : arguments) {
                LOG.info("\t\t-> " + param.toString());            
            }
        }
            
        
    }
}

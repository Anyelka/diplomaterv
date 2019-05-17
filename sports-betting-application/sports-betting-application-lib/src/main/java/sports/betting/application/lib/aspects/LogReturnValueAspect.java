package sports.betting.application.lib.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogReturnValueAspect {
    private static final Logger LOG = LoggerFactory.getLogger(LogReturnValueAspect.class);

    @AfterReturning(pointcut = "PointCuts.all()", returning = "retVal")
    public void logReturnValue(JoinPoint joinPoint, Object retVal) {
        if (retVal != null) {
            LOG.info("->" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "() method's return value: "
                    + retVal.toString());
        } else {
            LOG.info("");
        }
    }

}

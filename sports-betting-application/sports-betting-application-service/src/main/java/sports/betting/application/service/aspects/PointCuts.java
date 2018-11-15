package sports.betting.application.service.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

	@Pointcut("execution(* org.sports.betting.application.app.*.*.*(..))")
	public void all() {}
}

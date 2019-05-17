package sports.betting.application.lib.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

	@Pointcut("execution(* sports.betting.application.*.*.*(..))")
	public void all() {}
}

package ioc2.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut() {} // 참조 메소드
	
	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
	public void getPointcut() {} // 참조 메소드
	
	@Pointcut("execution(* com.multicampus.biz.board.*Impl.*(..))")
	public void boardPointcut() {} // 참조 메소드
	
	@Pointcut("execution(* com.multicampus.biz.user.*Impl.*(..))")
	public void userPointcut() {} // 참조 메소드
}

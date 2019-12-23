package mvc.business.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcut {
	@Pointcut("execution(* mvc.business..*Impl.*(..))")
	public void allPointcut() {} // 참조 메소드
	
	@Pointcut("execution(* mvc.business..*Impl.get*(..))")
	public void getPointcut() {} // 참조 메소드
	
	@Pointcut("execution(* mvc.business.board.*Impl.*(..))")
	public void boardPointcut() {} // 참조 메소드
	
	@Pointcut("execution(* mvc.business.user.*Impl.*(..))")
	public void userPointcut() {} // 참조 메소드
}

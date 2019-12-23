package mvc.business.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect = PointCut + Advice
public class LogAdvice {

	@Before("mvc.business.common.aspect.CommonPointcut.allPointcut()") // 위 지점들(Pointcut)의 실행 전에 다음 메소드를 수행해라
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] " + method + "() 메소드 ARGS : " + args[0].toString());
	}
}

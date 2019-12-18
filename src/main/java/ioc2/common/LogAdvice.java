package ioc2.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect = PointCut + Advice
public class LogAdvice {

	@Before("BoardPointcut.allPointcut()") // �� ������(pointcut)�� ���� ���� ���� �޼ҵ带 �����ض�
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��] " + method + 
			"() �޼ҵ� ARGS : " + args[0].toString());
	}
}

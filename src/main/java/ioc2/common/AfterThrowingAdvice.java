package ioc2.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut = "BoardPointcut.allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();

		System.out.println("[예외 처리] " + method + "() 수행 중 발생한 예외 처리");

		if (exceptObj instanceof IllegalArgumentException) {
			System.out.println("IllegalArgumentException");
		} else if (exceptObj instanceof NullPointerException) {
			System.out.println("NullPointerException");
		} else if (exceptObj instanceof SQLException) {
			System.out.println("SQLException");
		} else if (exceptObj instanceof ArithmeticException) {
			System.out.println("ArithmeticException");
		} else {
			System.out.println("Unknown Error");
		}
	}
}

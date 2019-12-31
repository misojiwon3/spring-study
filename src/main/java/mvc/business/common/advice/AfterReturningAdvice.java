package mvc.business.common.advice;

import ioc2.user.UserVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {

    @AfterReturning(pointcut = "mvc.business.common.aspect.CommonPointcut.getPointcut()", returning = "returnObj")
    public void afterLog(JoinPoint jp, Object returnObj) {
        String method = jp.getSignature().getName();

        if (returnObj != null) {
            System.out.println("[After] " + method + "() : return => " + returnObj.toString());

            if (returnObj instanceof UserVO) {
                UserVO user = (UserVO) returnObj;
                if (user.getRole().equals("Admin")) {
                    System.out.println(user.getName() + "관리자가 로그인 했습니다");
                }
            }
        } else {
            System.out.println("Returned value is Null");
        }
    }
}

package ioc2.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

    @Around("BoardPointcut.allPointcut()")
    public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
        String method = jp.getSignature().getName();

        Object obj = null;
        StopWatch watch = new StopWatch();
        watch.start();
        obj = jp.proceed();
        watch.stop();
        System.out.println(method + "() 메소드 처리에 소요된 시간 : " + watch.getTotalTimeMillis() + "ms");
        return obj;
    }
}

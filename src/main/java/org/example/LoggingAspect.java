package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.CommentService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method " + methodName +" will execute with params: "  + Arrays.asList(args));

        Comment comment = new Comment();
        comment.setText("OTHER TEXT!");
        Object[] newArgs = {comment};

        Object returnedMethod = joinPoint.proceed(newArgs);
        logger.info("Method execute and return " + returnedMethod);
        return /*returnedMethod*/ "FAILED!";
    }

}

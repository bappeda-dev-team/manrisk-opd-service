package cc.kertaskerja.manrisk.manajemenrisiko.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RekinLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(RekinLoggingAspect.class);

    // Pointcut for controller methods
    @Pointcut("execution(* cc.kertaskerja.manrisk.manajemenrisiko.controller.*.*(..))")
    private void forControllerPackage() {}

    // Pointcut for service methods - fixed to include subpackages
    @Pointcut("execution(* cc.kertaskerja.manrisk.manajemenrisiko.service..*.*(..))")
    private void forServicePackage() {}

    // Pointcut for repository methods
    @Pointcut("execution(* cc.kertaskerja.manrisk.manajemenrisiko.repository.*.*(..))")
    private void forRepositoryPackage() {}

    // Combined pointcut for all application flow
    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow() {}

    // Before advice
    @Before("forAppFlow()")
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("===> BEFORE: {}.{}", className, methodName);
        
        if (args.length > 0) {
            logger.info("===> Arguments: {}", Arrays.toString(args));
        } else {
            logger.info("===> No arguments");
        }
    }

    // After returning advice - fixed the log message
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("===> AFTER RETURNING: {}.{}", className, methodName);
        
        if (result != null) {
            // Avoid logging large objects or sensitive data
            if (result instanceof String || result instanceof Number || result instanceof Boolean) {
                logger.info("===> Result: {}", result);
            } else if (result instanceof java.util.Collection) {
                logger.info("===> Result: Collection with {} elements", 
                    ((java.util.Collection<?>) result).size());
            } else {
                logger.info("===> Result: {} instance", result.getClass().getSimpleName());
            }
        } else {
            logger.info("===> Result: null");
        }
    }

    // After throwing advice for exceptions
    @AfterThrowing(pointcut = "forAppFlow()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.error("===> EXCEPTION in {}.{}: {} - {}", 
            className, methodName, exception.getClass().getSimpleName(), exception.getMessage());
    }

    // Around advice for performance monitoring
    @Around("forServicePackage()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        
        long startTime = System.currentTimeMillis();
        
        try {
            Object result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            
            logger.info("===> PERFORMANCE: {}.{} executed in {} ms", 
                className, methodName, executionTime);
            
            return result;
        } catch (Throwable throwable) {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            
            logger.error("===> PERFORMANCE: {}.{} failed after {} ms", 
                className, methodName, executionTime);
            
            throw throwable;
        }
    }

    // Specific pointcut for monitoring Rekin operations
    @Pointcut("execution(* cc.kertaskerja.manrisk.manajemenrisiko.service.rekin.RekinService.*(..))")
    private void forRekinService() {}

    @Before("forRekinService()")
    public void logRekinOperation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        switch (methodName) {
            case "findAll":
                logger.info("===> REKIN OPERATION: Finding all Rekin records for OPD: {}, Year: {}", 
                    args.length > 0 ? args[0] : "unknown", 
                    args.length > 1 ? args[1] : "unknown");
                break;
            case "findByIdRekin":
                logger.info("===> REKIN OPERATION: Finding Rekin by ID: {} for OPD: {}, Year: {}", 
                    args.length > 2 ? args[2] : "unknown",
                    args.length > 0 ? args[0] : "unknown", 
                    args.length > 1 ? args[1] : "unknown");
                break;
            case "findByNip":
                logger.info("===> REKIN OPERATION: Finding Rekin by NIP: {} for OPD: {}, Year: {}", 
                    args.length > 2 ? args[2] : "unknown",
                    args.length > 0 ? args[0] : "unknown", 
                    args.length > 1 ? args[1] : "unknown");
                break;
            case "save":
                logger.info("===> REKIN OPERATION: Saving Rekin record");
                break;
            default:
                logger.info("===> REKIN OPERATION: {}", methodName);
        }
    }
}
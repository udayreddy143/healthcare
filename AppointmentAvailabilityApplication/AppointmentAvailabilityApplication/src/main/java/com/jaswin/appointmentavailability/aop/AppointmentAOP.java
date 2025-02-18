package com.jaswin.appointmentavailability.aop;

import com.jaswin.appointmentavailability.dto.AppointmentDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class AppointmentAOP {
    //By using cache we can store frequently used data
    Map<Integer, List<AppointmentDTO>> appointmentCache = new HashMap<>();

    @Around("execution(* com.jaswin.appointmentavailability.service.impl.AppointmentServiceImpl.getAppointmentsBySlotId(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("It executes before actual target method");
        Object[] param = joinPoint.getArgs();
        int slotid = (int) param[0];

        System.out.println(param[0]);
        if (appointmentCache.get(slotid) != null) {
            List<AppointmentDTO> appointmentDTO = appointmentCache.get(slotid);
            System.out.println("Got the data from cache");
            return appointmentDTO;
        } else {
            //getAppointmentsBySlotId method executed and its response handover to object
            List<AppointmentDTO> obj = (List<AppointmentDTO>) joinPoint.proceed();
            //once the data coming from the DB then we can store the data in cache
            appointmentCache.put(slotid, obj);
            System.out.println("It executed after the Service method");
            return obj;
        }
    }
}

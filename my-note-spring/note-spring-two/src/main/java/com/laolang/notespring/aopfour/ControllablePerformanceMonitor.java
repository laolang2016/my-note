package com.laolang.notespring.aopfour;

import com.laolang.notespring.aopone.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    @Override
    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }

    /**
     * 拦截方法
     * @param mi
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object o = null;
        // 对于支持性能监视可控代理，通过判断其状态决定是否开启性能监控功能
        if( MonitorStatusMap.get() != null && MonitorStatusMap.get() ){
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            o = super.invoke(mi);
            PerformanceMonitor.end();
        }else{
            o = super.invoke(mi);
        }
        return o;
    }
}

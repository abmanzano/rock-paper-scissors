package com.manzano.aop.interceptor;

import com.manzano.aop.GameStatistics;
import com.manzano.data.Player;
import com.manzano.service.StatisticsManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.List;

@GameStatistics
@Interceptor
public class GameStatisticsInterceptor implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(GameStatisticsInterceptor.class);

    @Inject
    private StatisticsManagerService statisticsManagerService;

    @AroundInvoke
    public Object addRoundToTotalStatistics(InvocationContext invocationCtx) throws Exception {
        LOGGER.info("Interceptor to populate game statistics");

        //execute the intercepted method
        Object returnValue = invocationCtx.proceed();

        // Our code to store statistics here
        List<Player> players = (List<Player>) returnValue;
        statisticsManagerService.addRoundToStatistics(players);

        return returnValue;
    }
}

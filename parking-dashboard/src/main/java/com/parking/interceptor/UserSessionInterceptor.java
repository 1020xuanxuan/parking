package com.parking.interceptor;

import com.parking.dao.system.SysFunctionDao;
import com.parking.entity.system.SysFunction;
import com.parking.utils.MenuUtils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
public class UserSessionInterceptor implements HandlerInterceptor {

    @Autowired
    private SysFunctionDao sysFunctionDao;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        List<SysFunction> allFunctions = sysFunctionDao.getEntities(null,null);
        MenuUtils.calculateMenu(allFunctions,httpServletRequest);
        return Boolean.TRUE;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

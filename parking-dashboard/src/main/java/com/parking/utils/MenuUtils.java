package com.parking.utils;


import com.parking.entity.system.SysFunction;
import com.parking.system.SysFunctionDto;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by BaoCai on 17/9/23.
 * Description:
 */
public class MenuUtils {

    /**
     * Top Menu  and   left Menu
     * @param allFunctionList
     * @param httpServletRequest
     */
    public static void calculateMenu(List<SysFunction> allFunctionList, HttpServletRequest httpServletRequest) {
        //topMenu
        List<SysFunction> topMenu = allFunctionList.parallelStream().filter(sysFunction -> sysFunction.getFunctionParentId()==null)
                .collect(Collectors.toList());
        httpServletRequest.setAttribute("topMenu",topMenu);
        allFunctionList.removeAll(topMenu);
        //leftMenu
        Map<String,List<SysFunction>> allFunctionMap = functionListToMap(allFunctionList);
        Map<String,List<SysFunctionDto>> leftMenuMap = buildLeftMenu(allFunctionMap,topMenu);
        httpServletRequest.setAttribute("leftMenuMap",leftMenuMap);
    }

    private static Map<String,List<SysFunctionDto>> buildLeftMenu(Map<String, List<SysFunction>> allFunctionMap, List<SysFunction> topMenu) {
        Map<String,List<SysFunctionDto>> leftMenuMap = new HashMap<>();
        topMenu.forEach(top -> {
            List<SysFunctionDto> sysFunctionDto = buildFunctionDto(top.getId(),allFunctionMap);
            leftMenuMap.put(top.getId(),sysFunctionDto);
        });
        return leftMenuMap;
    }

    private static List<SysFunctionDto> buildFunctionDto(String id,Map<String, List<SysFunction>> allFunctionMap) {
        List<SysFunction> functionList = allFunctionMap.get(id);
        if(CollectionUtils.isEmpty(functionList)){
            return null;
        }
        List<SysFunctionDto> sysFunctionDtos = new ArrayList<>();
        functionList.forEach(function -> {
            SysFunctionDto functionDto = new SysFunctionDto();
            functionDto.setFunctionName(function.getFunctionName());
            functionDto.setParentId(String.valueOf(function.getFunctionParentId()));
            functionDto.setFunctionUrl(function.getFunctionUrl());
            //递归
            functionDto.setChildenFunctions(buildFunctionDto(function.getId(),allFunctionMap));
            functionDto.setParentFunction(StringUtils.isEmpty(function.getFunctionUrl()));
            sysFunctionDtos.add(functionDto);
        });
        return sysFunctionDtos;
    }

    private static Map<String,List<SysFunction>> functionListToMap(List<SysFunction> allFunctionList) {
        Map<String,List<SysFunction>> map = new HashMap();
        allFunctionList.forEach(sysFunction -> {
            if(!map.containsKey(sysFunction.getFunctionParentId())){
                map.put(sysFunction.getFunctionParentId(),new ArrayList());
            }
            map.get(sysFunction.getFunctionParentId()).add(sysFunction);
        });
        return map;
    }

    /**
     * 当前请求路径层级关系
     * @param currentFunction
     * @param httpServletRequest
     * @param functionList
     */
    public static void reSetCurrentUrl(SysFunction currentFunction, HttpServletRequest httpServletRequest, List<SysFunction> functionList) {
        if(null == currentFunction){
            //跳到首页
            httpServletRequest.setAttribute("currentFunctionTreeInfo","1");
            return;
        }
        StringBuffer currentFunctionTreeInfo = new StringBuffer();
        while(currentFunction!=null){
            currentFunctionTreeInfo.append(currentFunction.getId() + "--");
            if(null == currentFunction.getFunctionParentId()){
                break;
            }
            currentFunction = findParentFunction(currentFunction.getFunctionParentId(),functionList);
        }
        httpServletRequest.setAttribute("currentFunctionTreeInfo",currentFunctionTreeInfo.toString());
    }

    private static SysFunction findParentFunction(String functionParentId, List<SysFunction> functionList) {
        return functionList.stream().filter(function -> functionParentId.equals(function.getId())).findFirst().orElse(null);
    }

    public static void main(String[] args){
    }

}

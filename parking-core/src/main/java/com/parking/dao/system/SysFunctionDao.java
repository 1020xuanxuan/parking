package com.parking.dao.system;

import com.parking.dao.BaseDao;
import com.parking.entity.system.QSysFunction;
import com.parking.entity.system.SysFunction;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysFunctionDao extends BaseDao<SysFunction, QSysFunction> {
    public SysFunctionDao() {
        this.setQEntity(QSysFunction.sysFunction);
    }
}

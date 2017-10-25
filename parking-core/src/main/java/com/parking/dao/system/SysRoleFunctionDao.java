package com.parking.dao.system;

import com.parking.dao.BaseDao;
import com.parking.entity.system.QSysRoleFunction;
import com.parking.entity.system.SysRoleFunction;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysRoleFunctionDao extends BaseDao<SysRoleFunction,QSysRoleFunction> {
    public SysRoleFunctionDao(){
        this.setQEntity(QSysRoleFunction.sysRoleFunction);
    }
}

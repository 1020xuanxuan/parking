package com.parking.dao.system;

import com.parking.dao.BaseDao;
import com.parking.entity.system.QSysRole;
import com.parking.entity.system.SysRole;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysRoleDao extends BaseDao<SysRole,QSysRole> {
    public SysRoleDao(){
        this.setQEntity(QSysRole.sysRole);
    }
}

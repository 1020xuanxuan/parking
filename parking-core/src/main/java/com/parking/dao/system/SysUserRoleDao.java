package com.parking.dao.system;

import com.parking.dao.BaseDao;
import com.parking.entity.system.QSysUserRole;
import com.parking.entity.system.SysUserRole;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysUserRoleDao extends BaseDao<SysUserRole,QSysUserRole> {
    public SysUserRoleDao(){
        this.setQEntity(QSysUserRole.sysUserRole);
    }
}

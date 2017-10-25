package com.parking.dao.system;

import com.parking.dao.BaseDao;
import com.parking.entity.system.QSysUser;
import com.parking.entity.system.SysUser;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysUserDao extends BaseDao<SysUser,QSysUser> {
    public SysUserDao(){
        this.setQEntity(QSysUser.sysUser);
    }
}

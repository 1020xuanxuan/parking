package com.parking.entity.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Entity
@Table(name = "sys_user_role")
@Getter
@Setter
public class SysUserRole implements Serializable {
    private String roleId;

    @Column(name = "sys_user_id")
    private String UserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_user_id")
    private SysUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private SysRole role;

}

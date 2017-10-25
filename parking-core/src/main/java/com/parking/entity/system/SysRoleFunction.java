package com.parking.entity.system;

import java.io.Serializable;

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
@Table(name = "sys_role_function")
@Getter
@Setter
public class SysRoleFunction implements Serializable {

    private String roleId;

    private String functionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private SysRole role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "function_id")
    private SysFunction function;
}

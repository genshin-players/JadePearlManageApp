package cn.bdqn.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
* <p>
    * 用户（所有学生，老师，管理员）
    * </p>
*
* @author ljj
* @since 2023-06-11
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Integer roleId;

            /**
            * json格式，账号信息，包含用户名密码（待定）
            */
    private String accountInfo;

            /**
            * json格式，身份信息，包含姓名、年龄、性别、联系方式等
            */
    private String identityInfo;

            /**
            * 创建日期
            */
    private LocalDateTime createTime;

    private LocalDate updateTime;


}

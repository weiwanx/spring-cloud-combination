-- 检查是否存在该表
DROP TABLE IF EXISTS `us_admin`;
create TABLE `us_admin`
(
    `id`            bigint(20)                      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_name`     varchar(64)                     NOT NULL COMMENT '用户编号',
    `pass_word`     varchar(64)                     NOT NULL COMMENT '用户密码',
    `icon`          varchar(500)                    DEFAULT NULL COMMENT '图标',
    `email`         varchar(100)                    DEFAULT NULL COMMENT '邮箱',
    `nick_name`     varchar(200)                    DEFAULT NULL COMMENT '用户昵称',
    `note`          varchar(500)                    DEFAULT NULL COMMENT '备注信息',
    `create_time`   datetime                        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `login_time`    datetime                        DEFAULT NULL COMMENT '最后登录时间',
    `status`        int(4)                          DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='后台用户表';

-- 设置唯一索引
ALTER TABLE `us_admin`
    ADD UNIQUE INDEX `uq_nick_name` (`nick_name`);

-- 设置唯一索引
ALTER TABLE `us_admin`
    ADD UNIQUE INDEX `uq_user_name` (`user_name`);

-- 检查是否存在该表
DROP TABLE IF EXISTS `us_role`;
create TABLE `us_role`
(
    `id`            bigint(20)                      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          varchar(64)                     DEFAULT NULL COMMENT '名称',
    `description`   varchar(64)                     DEFAULT NULL COMMENT '描述',
    `admin_count`   int(8)                          DEFAULT NULL COMMENT '后台用户数量',
    `create_time`   datetime                        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`        int(4)                          DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='后台用户角色表';

-- 设置唯一索引
ALTER TABLE `us_role`
    ADD UNIQUE INDEX `uq_name` (`name`);

-- 检查是否存在该表
DROP TABLE IF EXISTS `us_permission`;
create TABLE `us_permission`
(
    `id`            bigint(20)                      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `pid`           bigint(20)                      NOT NULL COMMENT '父级权限id',
    `name`          varchar(64)                     DEFAULT NULL COMMENT '名称',
    `value`         varchar(64)                     DEFAULT NULL COMMENT '权限值',
    `icon`          varchar(500)                    DEFAULT NULL COMMENT '图标',
    `type`          int(1)                          DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    `url`           varchar(100)                    DEFAULT NULL COMMENT '前端资源路径',
    `sort`          int(4)                          DEFAULT NULL COMMENT '排序',
    `create_time`   datetime                        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`        int(4)                          DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='后台用户权限表';

  -- 检查是否存在该表
DROP TABLE IF EXISTS `us_admin_role_relation`;
create TABLE `us_admin_role_relation`
(
    `id`            bigint(20)                      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `admin_id`      bigint(20)                      NOT NULL COMMENT '用户id',
    `role_id`       bigint(20)                      NOT NULL COMMENT '角色id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='后台用户和角色关系表';

  -- 检查是否存在该表
DROP TABLE IF EXISTS `us_role_permission_relation`;
create TABLE `us_role_permission_relation`
(
    `id`            bigint(20)                      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `role_id`       bigint(20)                      NOT NULL COMMENT '角色id',
    `permission_id` bigint(20)                      NOT NULL COMMENT '权限id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='后台用户角色和权限关系表';

  -- 检查是否存在该表
DROP TABLE IF EXISTS `us_admin_permission_relation`;
create TABLE `us_admin_permission_relation`
(
    `id`            bigint(20)                      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `admin_id`      bigint(20)                      NOT NULL COMMENT '用户id',
    `permission_id` bigint(20)                      NOT NULL COMMENT '权限id',
    `type`          int(1)                          NOT NULL COMMENT '类型',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  ROW_FORMAT = DYNAMIC COMMENT ='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';
















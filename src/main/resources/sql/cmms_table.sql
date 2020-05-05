/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` varchar(64) DEFAULT NULL COMMENT '配置菜单路径，只允许view下配置',
  `path` varchar(64) DEFAULT NULL COMMENT '菜单路由',
  `name` varchar(64) DEFAULT NULL COMMENT '路由名称(keepAlive要使用的组件名)',
  `component` varchar(64) DEFAULT NULL COMMENT '菜单路由对应的组件',
  `icon_cls` varchar(64) DEFAULT NULL COMMENT '菜单图标,meta元素',
  `title` varchar(64) NOT NULL COMMENT '菜单名称,meta元素',
  `keep_alive` tinyint(1) DEFAULT '1' COMMENT '菜单是否缓存,meta元素',
  `require_auth` tinyint(1) DEFAULT '1' COMMENT '菜单是否需要登录,meta元素',
  `parent_id` int(11) NOT NULL COMMENT '上级ID',
  `folder` tinyint(1) NOT NULL COMMENT '是否为文件夹',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';



/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_code` varchar(64) UNIQUE NOT NULL COMMENT '角色码',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统角色表';



/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `mid` int(11) DEFAULT NULL COMMENT '菜单id',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='系统角色菜单表';



/*Table structure for table `sys_user` */
DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `login_name` varchar(40) UNIQUE NOT NULL COMMENT '登录名称',
  `login_pwd` varchar(255) NOT NULL COMMENT '登录密码',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `user_face` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `user_gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `mobile_phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `user_mail` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `user_remark` varchar(255) DEFAULT NULL COMMENT '签名',
  `user_status` varchar(2) DEFAULT '1' COMMENT '用户状态',
  `cert_no` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `org_code` varchar(25) NOT NULL COMMENT '机构号',
  `user_address` varchar(64) DEFAULT NULL COMMENT '地址',
  `user_position` varchar(40) DEFAULT NULL COMMENT '职位',
  `first_login_time` varchar(22) DEFAULT NULL COMMENT '首次登录时间',
  `last_login_time` varchar(22) DEFAULT NULL COMMENT '上次登录时间',
  `last_logout_time` varchar(22) DEFAULT NULL COMMENT '上次退出时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';



/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `rid` int(11) DEFAULT NULL COMMENT '角色ID',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户角色表';



/*Table structure for table `sys_org` */
DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `org_name` varchar(40) NOT NULL COMMENT '机构名称',
  `org_code` varchar(25) UNIQUE NOT NULL COMMENT '机构码',
  `parent_id` int(11) NOT NULL COMMENT '父ID',
  `org_status` varchar(2) DEFAULT '1' COMMENT '机构状态',
  `org_principal` varchar(40) DEFAULT NULL COMMENT '机构负责人',
  `org_phone` varchar(16) DEFAULT NULL COMMENT '机构电话',
  `org_address` varchar(64) DEFAULT NULL COMMENT '机构地址',
  `org_remark` varchar(255) DEFAULT NULL COMMENT '机构备注',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统组织机构表';



/*Table structure for table `sys_org_user` 用不着了 */

DROP TABLE IF EXISTS `sys_org_user`;

CREATE TABLE `sys_org_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `org_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统机构用户表';



/*Table structure for table `sys_select` */

DROP TABLE IF EXISTS `sys_select`;

CREATE TABLE `sys_select` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `select_code` varchar(20) UNIQUE NOT NULL COMMENT '选择代码',
  `select_name` varchar(40) NOT NULL COMMENT '代码名称',
  `select_remark` varchar(40) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统下拉选码表';



/*Table structure for table `sys_option` */

DROP TABLE IF EXISTS `sys_option`;

CREATE TABLE `sys_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `select_id` int(11) NOT NULL COMMENT 'select的id',
  `option_value` varchar(10) NOT NULL COMMENT '选项值',
  `option_label` varchar(40) NOT NULL COMMENT '选项名称',
  `option_key` int(11) NOT NULL COMMENT '选项顺序',
  `option_remark` varchar(40) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(22) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(22) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统下拉选项表';



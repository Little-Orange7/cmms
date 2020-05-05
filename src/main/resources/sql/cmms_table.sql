/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` varchar(64) DEFAULT NULL COMMENT '���ò˵�·����ֻ����view������',
  `path` varchar(64) DEFAULT NULL COMMENT '�˵�·��',
  `name` varchar(64) DEFAULT NULL COMMENT '·������(keepAliveҪʹ�õ������)',
  `component` varchar(64) DEFAULT NULL COMMENT '�˵�·�ɶ�Ӧ�����',
  `icon_cls` varchar(64) DEFAULT NULL COMMENT '�˵�ͼ��,metaԪ��',
  `title` varchar(64) NOT NULL COMMENT '�˵�����,metaԪ��',
  `keep_alive` tinyint(1) DEFAULT '1' COMMENT '�˵��Ƿ񻺴�,metaԪ��',
  `require_auth` tinyint(1) DEFAULT '1' COMMENT '�˵��Ƿ���Ҫ��¼,metaԪ��',
  `parent_id` int(11) NOT NULL COMMENT '�ϼ�ID',
  `folder` tinyint(1) NOT NULL COMMENT '�Ƿ�Ϊ�ļ���',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='ϵͳ�˵���';



/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '��ɫID',
  `role_code` varchar(64) UNIQUE NOT NULL COMMENT '��ɫ��',
  `role_name` varchar(64) NOT NULL COMMENT '��ɫ����',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ��ɫ��';



/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rid` int(11) DEFAULT NULL COMMENT '��ɫid',
  `mid` int(11) DEFAULT NULL COMMENT '�˵�id',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='ϵͳ��ɫ�˵���';



/*Table structure for table `sys_user` */
DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�û�ID',
  `login_name` varchar(40) UNIQUE NOT NULL COMMENT '��¼����',
  `login_pwd` varchar(255) NOT NULL COMMENT '��¼����',
  `user_name` varchar(32) DEFAULT NULL COMMENT '�û�����',
  `user_face` varchar(255) DEFAULT NULL COMMENT '�û�ͷ��',
  `user_gender` varchar(10) DEFAULT NULL COMMENT '�Ա�',
  `mobile_phone` varchar(11) DEFAULT NULL COMMENT '�ֻ�����',
  `user_mail` varchar(40) DEFAULT NULL COMMENT '����',
  `user_remark` varchar(255) DEFAULT NULL COMMENT 'ǩ��',
  `user_status` varchar(2) DEFAULT '1' COMMENT '�û�״̬',
  `cert_no` varchar(32) DEFAULT NULL COMMENT '֤������',
  `org_code` varchar(25) NOT NULL COMMENT '������',
  `user_address` varchar(64) DEFAULT NULL COMMENT '��ַ',
  `user_position` varchar(40) DEFAULT NULL COMMENT 'ְλ',
  `first_login_time` varchar(22) DEFAULT NULL COMMENT '�״ε�¼ʱ��',
  `last_login_time` varchar(22) DEFAULT NULL COMMENT '�ϴε�¼ʱ��',
  `last_logout_time` varchar(22) DEFAULT NULL COMMENT '�ϴ��˳�ʱ��',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ�û���';



/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` int(11) DEFAULT NULL COMMENT '�û�ID',
  `rid` int(11) DEFAULT NULL COMMENT '��ɫID',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ�û���ɫ��';



/*Table structure for table `sys_org` */
DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�û�ID',
  `org_name` varchar(40) NOT NULL COMMENT '��������',
  `org_code` varchar(25) UNIQUE NOT NULL COMMENT '������',
  `parent_id` int(11) NOT NULL COMMENT '��ID',
  `org_status` varchar(2) DEFAULT '1' COMMENT '����״̬',
  `org_principal` varchar(40) DEFAULT NULL COMMENT '����������',
  `org_phone` varchar(16) DEFAULT NULL COMMENT '�����绰',
  `org_address` varchar(64) DEFAULT NULL COMMENT '������ַ',
  `org_remark` varchar(255) DEFAULT NULL COMMENT '������ע',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ��֯������';



/*Table structure for table `sys_org_user` �ò����� */

DROP TABLE IF EXISTS `sys_org_user`;

CREATE TABLE `sys_org_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `org_id` int(11) DEFAULT NULL COMMENT '����ID',
  `user_id` int(11) DEFAULT NULL COMMENT '�û�ID',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ�����û���';



/*Table structure for table `sys_select` */

DROP TABLE IF EXISTS `sys_select`;

CREATE TABLE `sys_select` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `select_code` varchar(20) UNIQUE NOT NULL COMMENT 'ѡ�����',
  `select_name` varchar(40) NOT NULL COMMENT '��������',
  `select_remark` varchar(40) DEFAULT NULL COMMENT '��ע',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ����ѡ���';



/*Table structure for table `sys_option` */

DROP TABLE IF EXISTS `sys_option`;

CREATE TABLE `sys_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `select_id` int(11) NOT NULL COMMENT 'select��id',
  `option_value` varchar(10) NOT NULL COMMENT 'ѡ��ֵ',
  `option_label` varchar(40) NOT NULL COMMENT 'ѡ������',
  `option_key` int(11) NOT NULL COMMENT 'ѡ��˳��',
  `option_remark` varchar(40) DEFAULT NULL COMMENT '��ע',
  `create_user` varchar(40) DEFAULT NULL COMMENT '������',
  `create_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  `update_user` varchar(40) DEFAULT NULL COMMENT '������',
  `update_time` varchar(22) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ����ѡ���';



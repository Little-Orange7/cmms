/*Data for the table `sys_menu` */


insert into `sys_menu`(`id`,`url`,`path`,`component`,`name`,`icon_cls`,`title`,`keep_alive`,`require_auth`,`parent_id`,`folder`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,'/','/','/','/','/','根目录',NULL,NULL,-1,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(2,'/components/Layout.vue','/','/Layout.vue','Layout','el-icon-setting','系统管理',NULL,NULL,1,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(3,'/','/system/settings/common/Folder','/system/settings/common/Folder.vue','Folder','el-icon-user','基础设置',NULL,NULL,2,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(4,'/views/system/settings/menu/MenuList.vue','/system/settings/menu/MenuList','/system/settings/menu/MenuList.vue','MenuList','el-icon-document','菜单管理',1,1,3,0,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(5,'/views/system/settings/role/RoleList.vue','/system/settings/role/RoleList','/system/settings/role/RoleList.vue','RoleList','el-icon-document','角色管理',1,1,3,0,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(6,'/views/system/settings/user/UserList.vue','/system/settings/user/UserList','/system/settings/user/UserList.vue','UserList','el-icon-document','用户管理',1,1,3,0,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(7,'/','/system/settings/common/Folder','/system/settings/common/Folder.vue','Folder','el-icon-s-grid','机构设置',NULL,NULL,2,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(8,'/views/system/settings/organ/OrganList.vue','/system/settings/organ/OrganList','/system/settings/organ/OrganList.vue','OrganList','el-icon-document','机构管理',1,1,7,0,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(9,'/views/system/settings/organ/OrganUser.vue','/system/settings/organ/OrganUser','/system/settings/organ/OrganUser.vue','OrganUser','el-icon-document','机构用户',1,1,7,0,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(10,'/','/system/settings/common/Folder','/system/settings/common/Folder.vue','Folder','el-icon-collection','资源管理',NULL,NULL,2,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(11,'/views/system/settings/select/SelectList.vue','/system/settings/select/SelectList','/system/settings/select/SelectList.vue','SelectList','el-icon-document','下拉选配置',1,1,10,0,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(12,'/components/Layout.vue','/','/Layout.vue','Layout','el-icon-user','员工管理',NULL,NULL,1,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(13,'/views/system/employee/EmpList.vue','/system/employee/EmpList','/system/employee/EmpList.vue','EmpList','el-icon-document','员工列表',1,1,12,0,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');


/*Data for the table `sys_role` */

insert into `sys_role`(`id`,`role_code`,`role_name`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,'sysAdmin','系统管理员','admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');


/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu` (`id`,`rid`,`mid`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,1,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(2,1,2,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(3,1,3,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(4,1,4,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(5,1,5,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(6,1,6,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(7,1,7,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(8,1,8,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(9,1,9,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(10,1,10,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(11,1,11,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(12,1,12,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(13,1,13,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');


/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`login_name`,`login_pwd`,`user_name`,`user_face`,`user_gender`,`mobile_phone`,`user_mail`,`user_remark`,`user_status`,`cert_no`,`org_code`,`user_address`,`user_position`,`first_login_time`,`last_login_time`,`last_logout_time`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,'admin','202cb962ac59075b964b07152d234b70','超级用户','','男','15866669999','123456@qq.com','面对疾风吧！','1','411500196612310612','HQ','幸福路1号','技术主管','2020-04-10 20:35:10','2020-04-20 10:00:01','2020-04-20 21:30:01','admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');


/*Data for the table `sys_user_role` */

insert into `sys_user_role`(`id`,`uid`,`rid`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,1,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');



/*Data for the table `sys_org` */

insert into `sys_org`(`id`,`org_name`,`org_code`,`parent_id`,`org_status`,`org_principal`,`org_phone`,`org_address`,`org_remark`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,'集团总部','HQ',-1,'1','CEO','021-12345678','北京望京','各个子公司的总集团','admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');



/*Data for the table `sys_org_user` */

insert  into `sys_org_user`(`id`,`org_id`,`user_id`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,1,1,'admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');



/*Data for the table `sys_select` */

insert  into `sys_select`(`id`,`select_code`,`select_name`,`select_remark`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,'SYS_USER_STATUS','系统用户状态','系统用户状态','admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');


/*Data for the table `sys_option` */

insert  into `sys_option`(`id`,`select_id`,`option_value`,`option_label`,`option_key`,`option_remark`,`create_user`,`create_time`,`update_user`,`update_time`) values 
(1,1,'1','启用',1,'启用','admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00'),
(2,1,'0','禁用',1,'禁用','admin','2020-04-10 09:00:00','admin','2020-04-15 21:00:00');




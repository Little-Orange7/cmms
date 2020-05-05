# 前言
很多公司稍微复杂一点的业务，基本上都需要后台管理系统，来对业务进行各个维度的统计、对公司人员管理等等，这些后台管理系统都有一个基础的共性，就是对登录用户的管理，对用户角色的管理，对登录用户的操作权限的管理等，所以此项目就将这部分作为一个基础功能编写出来作为一个通用后台管理系统（common management system），为各种后台管理系统提供一个基础的版本框架，使企业能快速的开发自己的业务模块，而非重新从零开始搭建编写这种基础性的功能。整个项目是完全前后端分离，分为两个部分，前端使用vue编写（对应仓库中的cmms-vue），后端使用springboot编写（对应仓库中的cmms）。
# cmms简介
此项目为通用后台管理系统vue项目对应的服务端，用springboot编写；此项目作为一个后台管理系统，较为简单，只编写了系统管理相关的业务逻辑，可根据不同公司的具体业务，添加相应的业务模块进行二次开发，与仓库中的cmms-vue前端搭配使用。
# 技术
springboot、mybatis、filter过滤器、logback日志框架。（可根据不同的需要，整合拓展相应的技术）

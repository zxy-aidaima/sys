/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/1/24 10:59:30                           */
/*==============================================================*/


drop table if exists answer;

drop table if exists codeconf;

drop table if exists gift;

drop table if exists initiateactivity;

drop table if exists initiateactivitytrack;

drop table if exists integral;

drop table if exists joinactivity;

drop table if exists joinactivityapproval;

drop table if exists notice;

drop table if exists question;

drop table if exists registerinfo;

drop table if exists registertrack;

drop table if exists userlogin;

/*==============================================================*/
/* Table: answer                                                */
/*==============================================================*/
create table answer
(
   answerid             int not null comment '答案ID',
   questionid           int not null comment '问题ID',
   answercontent        varchar(100) not null comment '解答内容',
   answereperson        varchar(20) not null comment '解答人',
   answerdate           datetime comment '解答时间',
   answerlikenum        int(3) comment '回答被赞次数',
   primary key (answerid)
);

alter table answer comment '答案表(各个用户的评论)';

/*==============================================================*/
/* Table: codeconf                                              */
/*==============================================================*/
create table codeconf
(
   id                   int(11) not null auto_increment comment '自增主键',
   code                 varchar(10) not null comment '编码',
   `describe`           varchar(50) comment '编码描述',
   codename             varchar(20) not null comment '编码名称',
   state                char(1) not null comment '状态(0-无效,1-有效)',
   `datetime`             datetime comment '创建时间',
   remark               varchar(100) comment '备注',
   primary key (id)
);

alter table codeconf comment '码表';

/*==============================================================*/
/* Table: gift                                                  */
/*==============================================================*/
create table gift
(
   giftid               char(17) not null comment '礼物主键ID',
   giftname             varchar(80) not null comment '礼物名称',
   gift                 varchar(100) not null comment '礼物',
   gifttype             char(2) comment '礼物类型',
   `adddate`             datetime not null comment '添加时间',
   number               int(2) comment '剩余数量',
   validflag            char(1) not null comment '礼物有效状态(1-有效,0-无效)',
   primary key (giftid)
);

alter table gift comment '礼品表';

/*==============================================================*/
/* Table: initiateactivity                                      */
/*==============================================================*/
create table initiateactivity
(
   activityid           char(17) not null comment '活动号',
   rrgisterid           char(17) not null comment '注册账号',
   uname                varchar(15) not null comment '发起者姓名',
   activityprovince     varchar(20) not null comment '活动所在省',
   activitycity         varchar(20) not null comment '活动所在市',
   activitycounty       varchar(20) not null comment '活动所在县',
   activitydetail       varchar(50) comment '活动所在详细地址',
   `date`                 datetime not null comment '发起时间',
   validflag            char(1) not null comment '活动有效状态(有效-1,无效-0)',
   title                varchar(20) not null comment '活动标题',
   massage              varchar(100) not null comment '活动主要内容',
   primary key (activityid)
);

alter table initiateactivity comment '发起活动表';

/*==============================================================*/
/* Table: initiateactivitytrack                                 */
/*==============================================================*/
create table initiateactivitytrack
(
   rrgisterid           char(17) not null comment '注册账号',
   activityid           char(17) not null comment '活动号',
   uname                varchar(15) not null comment '发起者姓名',
   activityprovince     varchar(20) not null comment '活动所在省',
   activitycity         varchar(20) not null comment '活动所在市',
   activitycounty       varchar(20) not null comment '活动所在县',
   activitydetail       varchar(50) comment '活动所在详细地址',
   `date`                 datetime not null comment '发起时间',
   validflag            char(1) not null comment '活动有效状态(有效-1,无效-0)',
   title                varchar(20) not null comment '活动标题',
   massage              varchar(100) not null comment '活动主要内容',
   reason               varchar(80) not null comment '驳回原因',
   returndate           datetime not null comment '驳回时间',
   primary key (rrgisterid)
);

alter table initiateactivitytrack comment '发起活动轨迹表';

/*==============================================================*/
/* Table: integral                                              */
/*==============================================================*/
create table integral
(
   registerid           varchar(17) not null comment '注册账号',
   uname                varchar(15) not null comment '姓名',
   lasttime             datetime not null comment '上次积分时间',
   roletype             char(1) comment '角色类型(管理员-0,志愿者-1,用户-2)',
   validflag            char(1) not null comment '积分有效状态(有效-1,无效-0)',
   nnumber              int not null comment 'N积分(积分计算系数)',
   snumber              int not null comment 'S积分(总积分)',
   primary key (registerid)
);

alter table integral comment '积分表';

/*==============================================================*/
/* Table: joinactivity                                          */
/*==============================================================*/
create table joinactivity
(
   activityid           char(17) not null comment '活动号',
   rrgisterid           char(17) not null comment '注册账号',
   uname                varchar(15) not null comment '姓名',
   phonenumber          char(11) not null comment '手机号',
   activityprovince     varchar(20) not null comment '活动所在省',
   activitycity         varchar(20) not null comment '活动所在市',
   activitycounty       varchar(20) not null comment '活动所在县',
   activitydetail       varchar(50) comment '活动所在详细地址',
   `date`                 datetime not null comment '活动时间',
   validflag            char(1) not null comment '活动有效状态(有效-1,无效-0)',
   primary key (activityid)
);

alter table joinactivity comment '参加活动表';

/*==============================================================*/
/* Table: joinactivityapproval                                  */
/*==============================================================*/
create table joinactivityapproval
(
   rrgisterid           char(17) not null comment '注册账号',
   uname                varchar(15) not null comment '姓名',
   phonenumber          char(11) not null comment '手机号',
   activityprovince     varchar(20) not null comment '活动所在省',
   activitycity         varchar(20) not null comment '活动所在市',
   activitycounty       varchar(20) not null comment '活动所在县',
   activitydetail       varchar(50) comment '活动所在详细地址',
   returndate           datetime not null comment '驳回时间',
   reason               varchar(80) not null comment '驳回理由',
   primary key (rrgisterid)
);

alter table joinactivityapproval comment ' 参加活动审批表';

/*==============================================================*/
/* Table: notice                                                */
/*==============================================================*/
create table notice
(
   noticeid             char(17) not null comment '公告ID',
   uname                varchar(20) comment '发布人',
   massage              varchar(100) comment '公告内容',
   releasetime          datetime comment '发布时间',
   validflag            char(1) comment '公告有效状态(有效-1,无效-0)',
   primary key (noticeid)
);

alter table notice comment '公告信息表';

/*==============================================================*/
/* Table: question                                              */
/*==============================================================*/
create table question
(
   questionid           int not null comment '问题ID',
   questioncontent      varchar(100) not null comment '问题内容/解答内容',
   questiontypeflag     int(1) not null comment '问解答案标志(解答-1,未答-0)',
   questionperson       varchar(20) not null comment '提问人',
   questiondate         datetime not null comment '提问时间',
   questionlikenum      int(3) comment '问题被赞次数',
   primary key (questionid)
);

alter table question comment '问题表';

/*==============================================================*/
/* Table: registerinfo                                          */
/*==============================================================*/
create table registerinfo
(
   registerid           char(17) not null comment '注册账号',
   phonenumber          char(11) not null comment '手机号',
   uname                varchar(15) not null comment '姓名',
   sex                  char(1) not null comment '性别(男-1,女-0)',
   identifynumber       char(18) not null comment '身份证号',
   age                  int(2) not null comment '年龄',
   liveprovince         varchar(20) comment '住址省',
   livecity             varchar(20) comment '住址市',
   livecounty           varchar(20) comment '住址县/区',
   livetownvillage      varchar(50) comment '住址乡/镇/街道',
   registerprovince     varchar(20) not null comment '注册地省',
   registercity         varchar(20) not null comment '注册地市',
   registecounty        varchar(20) not null comment '注册县/区',
   registertownvillage  varchar(50) comment '注册乡/镇/街道',
   approvename          varchar(15) comment '审核人',
   registerdate         datetime comment '注册时间',
   typeflag             char(1) not null comment '状态(未审核-0,审核不通过-1,审核通过-2,无效数据-3)',
   primary key (registerid)
);

alter table registerinfo comment '注册信息表';

/*==============================================================*/
/* Table: registertrack                                         */
/*==============================================================*/
create table registertrack
(
   id                   int(11) not null auto_increment comment '自增主键',
   phonenumber          char(11) not null comment '手机号',
   uname                varchar(15) not null comment '姓名',
   sex                  char(1) not null comment '性别(男-1,女-0)',
   identifynumber       char(18) not null comment '身份证号',
   age                  int(2) not null comment '年龄',
   liveprovince         varchar(20) comment '住址省',
   livecity             varchar(20) comment '住址市',
   livecounty           varchar(20) comment '住址县/区',
   livetownvillage      varchar(50) comment '住址乡/镇/街道',
   registerprovince     varchar(20) not null comment '注册地省',
   registercity         varchar(20) not null comment '注册地市',
   registecounty        varchar(20) not null comment '注册县/区',
   registertownvillage  varchar(50) comment '注册乡/镇/街道',
   reason               varchar(80) comment '申请原因',
   approvename          varchar(15) comment '审核人',
   returnreason         varchar(80) comment '驳回理由',
   returndate           datetime comment '驳回时间',
   typeflag             char(1) not null comment '状态(未审核-0,审核不通过-1,审核通过-2,无效数据-3)',
   primary key (id)
);

alter table registertrack comment '注册轨迹表';

/*==============================================================*/
/* Table: userlogin                                             */
/*==============================================================*/
create table userlogin
(
   registerid           varchar(17) not null comment '注册账号',
   uname                varchar(15) not null comment '姓名',
   phonenumber          char(11) not null comment '手机号',
   upassword            varchar(32) not null comment '密码',
   loginflag            char(1) not null comment '登录状态',
   lasttime             datetime not null comment '上次登录时间',
   roletype             char(1) comment '角色类型(管理员-0,志愿者-1,用户-2)',
   validflag            char(1) not null comment '账号有效状态(有效-1,无效-0)',
   primary key (registerid)
);

alter table userlogin comment '用户登录密码表';


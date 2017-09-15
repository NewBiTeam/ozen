/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : ozen

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-15 17:23:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for date
-- ----------------------------
DROP TABLE IF EXISTS `date`;
CREATE TABLE `date` (
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of date
-- ----------------------------

-- ----------------------------
-- Table structure for sys_bizcode
-- ----------------------------
DROP TABLE IF EXISTS `sys_bizcode`;
CREATE TABLE `sys_bizcode` (
  `id` bigint(4) NOT NULL AUTO_INCREMENT,
  `text` varchar(30) NOT NULL,
  `code` varchar(50) NOT NULL,
  `type` varchar(10) NOT NULL DEFAULT '',
  `type_name` varchar(30) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态。默认1=正常',
  `remark` varchar(200) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字段表';

-- ----------------------------
-- Records of sys_bizcode
-- ----------------------------

-- ----------------------------
-- Table structure for sys_operation_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_record`;
CREATE TABLE `sys_operation_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '操作用户',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `operation_type` varchar(100) DEFAULT NULL COMMENT '操作类型',
  `remark` text COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志';

-- ----------------------------
-- Records of sys_operation_record
-- ----------------------------

-- ----------------------------
-- Table structure for tb_bill_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_bill_category`;
CREATE TABLE `tb_bill_category` (
  `cate_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(20) NOT NULL COMMENT '类别名称',
  `cate_type` tinyint(1) NOT NULL COMMENT '分类1：消费 2：收入',
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bill_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_bill_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_bill_record`;
CREATE TABLE `tb_bill_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `describe` varchar(50) DEFAULT NULL COMMENT '描述',
  `money` int(10) NOT NULL DEFAULT '0' COMMENT '金额',
  `cate_id` tinyint(1) DEFAULT NULL COMMENT '类别ID',
  `time` datetime NOT NULL COMMENT '记账时间',
  `type` tinyint(1) NOT NULL COMMENT '类型0：消费记录 1：收入记录',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态0：他人不可见 1：他人可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bill_record
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `nick_name` varchar(100) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `sex` tinyint(1) NOT NULL COMMENT '性别1：男 2：女 3：保密',
  `region` varchar(15) DEFAULT '' COMMENT '地区城市',
  `avatar` varchar(255) DEFAULT '' COMMENT '头像',
  `constellation` varchar(30) DEFAULT '' COMMENT '星座',
  `usign` varchar(5000) DEFAULT '' COMMENT '个性签名',
  `integral` int(11) NOT NULL DEFAULT '0' COMMENT '累计总积分',
  `surplus_integral` int(11) NOT NULL DEFAULT '0' COMMENT '可用积分',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `telphone` varchar(15) DEFAULT '' COMMENT '手机号',
  `privacy` tinyint(1) NOT NULL DEFAULT '1' COMMENT '隐私设置0：公开 1：不公开 2：仅向我的好友公开',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户状态1：正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近登录时间',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '张三', '3', '上海', '1', '金牛座', '世界上本没有路，走的人多了变成了一条路', '200', '120', '136642159@qq.com', '13307193326', '1', '1', '2017-09-15 10:04:13', '2017-09-15 15:13:42', '123456', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `tb_user` VALUES ('2', '李四', '1', '上海', '1', '巨蟹座', '世界上本没有路，走的人多了变成了一条路', '200', '120', '136642159@qq.com', '13307193326', '1', '1', '2017-09-15 10:04:13', '2017-09-15 15:13:42', '1', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for tb_user_advise
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_advise`;
CREATE TABLE `tb_user_advise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `content` text COMMENT '吐槽内容',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户吐槽表';

-- ----------------------------
-- Records of tb_user_advise
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_comment`;
CREATE TABLE `tb_user_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `mood_id` int(11) NOT NULL COMMENT '用户心情ID',
  `content` text NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户评论表';

-- ----------------------------
-- Records of tb_user_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_like
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_like`;
CREATE TABLE `tb_user_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `mood_id` int(20) NOT NULL COMMENT '心情ID',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态0：取消点赞 1：已点赞',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`mood_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户点赞动态记录表';

-- ----------------------------
-- Records of tb_user_like
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_mood
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_mood`;
CREATE TABLE `tb_user_mood` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `img` varchar(255) DEFAULT NULL COMMENT '配图',
  `comments` tinyint(10) NOT NULL DEFAULT '0' COMMENT '评论数',
  `likes` tinyint(10) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_mood
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_relation`;
CREATE TABLE `tb_user_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NOT NULL COMMENT '用户id',
  `follow_user_id` bigint(10) NOT NULL COMMENT '关注的用户id',
  `re_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态1：互粉',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_relation
-- ----------------------------

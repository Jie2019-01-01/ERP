/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : erpdb

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2020-02-27 11:52:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_dep
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dep`;
CREATE TABLE `tbl_dep` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `depName` varchar(20) NOT NULL,
  `tele` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_dep
-- ----------------------------
INSERT INTO `tbl_dep` VALUES ('1', '人事', '741');
INSERT INTO `tbl_dep` VALUES ('2', '销售部', '123');
INSERT INTO `tbl_dep` VALUES ('3', '市场部', '789');
INSERT INTO `tbl_dep` VALUES ('4', '采购部', '456');
INSERT INTO `tbl_dep` VALUES ('5', '财务', '852');

-- ----------------------------
-- Table structure for tbl_emp
-- ----------------------------
DROP TABLE IF EXISTS `tbl_emp`;
CREATE TABLE `tbl_emp` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `realName` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tele` varchar(30) NOT NULL,
  `gender` int(1) NOT NULL,
  `address` varchar(30) NOT NULL,
  `birth` bigint(20) NOT NULL,
  `lastLoginTime` bigint(20) NOT NULL,
  `depUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `depUuid` (`depUuid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_emp
-- ----------------------------
INSERT INTO `tbl_emp` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '杰哥', 'wy12012156@163.com', '1325689673', '1', '黑龙江', '774979200000', '1582774382494', '4');
INSERT INTO `tbl_emp` VALUES ('2', 'root', '63a9f0ea7bb98050796b649e85481845', '赵玮', 'zhaowei@163.com', '15879655689', '0', '黑河市', '833385600000', '1582275164950', '2');
INSERT INTO `tbl_emp` VALUES ('4', 'dlrb', '1d0c2e5bdb35193f1e888a5b5d127726', '迪力热巴', 'dlrb@163.com', '1789362109', '0', '新疆', '684979200000', '1582018188223', '3');
INSERT INTO `tbl_emp` VALUES ('5', 'xuzhu', 'd1555b7beaf252d7f800fb4c8d1c761b', '虚竹', 'xuzhu83@qq.com', '8369008', '1', '井冈山', '1581955200000', '1582618116419', '4');
INSERT INTO `tbl_emp` VALUES ('6', 'qiaofeng', '54ae6c5d1ddbe1383461aad8e3407ff4', '乔峰', 'qiaofeng@qq.com', '78526366', '1', '辽国', '1581782400000', '1582618060641', '4');
INSERT INTO `tbl_emp` VALUES ('7', 'duanyu', '9528b16f36869ea8a3a7da1bd399b17a', '段誉', 'duanyu@qq.com', '582893865', '1', '大理', '1581782400000', '1582618134278', '4');
INSERT INTO `tbl_emp` VALUES ('8', 'ee', '08a4415e9d594ff960030b921d42b91e', 'ee', 'ee', 'ee', '0', 'ee', '1581782400000', '1582018212983', '2');
INSERT INTO `tbl_emp` VALUES ('9', 'ff', '633de4b0c14ca52ea2432a3c8a5c4c31', 'ff', 'ff', 'ff', '0', 'ff', '1581782400000', '1582018212983', '2');
INSERT INTO `tbl_emp` VALUES ('10', 'gg', '73c18c59a39b18382081ec00bb456d43', 'gg', 'gg', 'gg', '1', 'gg', '1581782400000', '1582018212983', '2');
INSERT INTO `tbl_emp` VALUES ('11', 'hh', '5e36941b3d856737e81516acd45edc50', 'hh', 'hh', 'hh', '1', 'hh', '1581782400000', '1582018212983', '2');
INSERT INTO `tbl_emp` VALUES ('12', 'dd', '1aabac6d068eef6a7bad3fdf50a05cc8', 'ii', 'ii', 'ii', '1', 'ii', '1581782400000', '1582018212983', '2');

-- ----------------------------
-- Table structure for tbl_emp_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_emp_role`;
CREATE TABLE `tbl_emp_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `roleUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_emp_role
-- ----------------------------
INSERT INTO `tbl_emp_role` VALUES ('2', '1', '1');
INSERT INTO `tbl_emp_role` VALUES ('3', '2', '10');
INSERT INTO `tbl_emp_role` VALUES ('5', '6', '2');
INSERT INTO `tbl_emp_role` VALUES ('6', '5', '1');
INSERT INTO `tbl_emp_role` VALUES ('7', '7', '2');

-- ----------------------------
-- Table structure for tbl_goods
-- ----------------------------
DROP TABLE IF EXISTS `tbl_goods`;
CREATE TABLE `tbl_goods` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `gname` varchar(30) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `produce` varchar(255) NOT NULL,
  `unit` varchar(1) NOT NULL,
  `inPrice` double(10,2) NOT NULL,
  `outPrice` double(10,2) NOT NULL,
  `goodsTypeUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_goods
-- ----------------------------
INSERT INTO `tbl_goods` VALUES ('1', '华为p10', '深圳', '广东1厂', '款', '3265.00', '4562.36', '1');
INSERT INTO `tbl_goods` VALUES ('2', '孜然味', '丰台', '烤鸭1厂', '只', '18.50', '36.85', '5');
INSERT INTO `tbl_goods` VALUES ('3', '黑椒味', '丰台', '烤鸭1厂', '只', '19.50', '38.85', '5');
INSERT INTO `tbl_goods` VALUES ('4', '香辣味', '丰台', '烤鸭3厂', '只', '18.36', '36.85', '5');
INSERT INTO `tbl_goods` VALUES ('5', '孜然味', '朝阳', '烤鸭1厂', '只', '20.50', '30.32', '6');
INSERT INTO `tbl_goods` VALUES ('6', 'oppo x20', '上海', 'oppo1厂', '款', '5263.00', '7854.00', '1');
INSERT INTO `tbl_goods` VALUES ('7', '卫龙', '成都辣条街', '辣条4厂', '袋', '0.50', '1.00', '7');
INSERT INTO `tbl_goods` VALUES ('8', '华硕1530', '上海', '华硕1厂', '台', '8885.00', '9996.03', '2');
INSERT INTO `tbl_goods` VALUES ('9', '联想Thinkpad', '上海', '联想1厂', '台', '4567.58', '8752.96', '2');
INSERT INTO `tbl_goods` VALUES ('10', '苹果Mac Pro', '美国', '硅谷', '台', '10520.00', '19854.00', '2');
INSERT INTO `tbl_goods` VALUES ('11', '周晓玲', '都江堰', '晓玲1厂', '袋', '2.50', '3.00', '7');
INSERT INTO `tbl_goods` VALUES ('12', '索尼数码相机', '韩国', '索尼1厂', '台', '25843.00', '28541.99', '3');
INSERT INTO `tbl_goods` VALUES ('13', '三星', '韩国', '三星1厂', '台', '78952.00', '157852.00', '3');
INSERT INTO `tbl_goods` VALUES ('14', '明基', '欧美', '明基3厂', '台', '45621.00', '78954.00', '3');
INSERT INTO `tbl_goods` VALUES ('15', '爱国者', '中国', '香港', '台', '4564.35', '7512.00', '3');
INSERT INTO `tbl_goods` VALUES ('16', '富士', '日本', '富士45厂', '台', '7895.20', '9999.99', '3');
INSERT INTO `tbl_goods` VALUES ('17', '五香味', '海淀', '烤鸭1厂', '只', '40.22', '50.12', '6');

-- ----------------------------
-- Table structure for tbl_goodstype
-- ----------------------------
DROP TABLE IF EXISTS `tbl_goodstype`;
CREATE TABLE `tbl_goodstype` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `gtname` varchar(30) NOT NULL,
  `supplierUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_goodstype
-- ----------------------------
INSERT INTO `tbl_goodstype` VALUES ('1', '手机', '1');
INSERT INTO `tbl_goodstype` VALUES ('2', '电脑', '1');
INSERT INTO `tbl_goodstype` VALUES ('3', '相机', '1');
INSERT INTO `tbl_goodstype` VALUES ('5', '全聚德', '3');
INSERT INTO `tbl_goodstype` VALUES ('6', '京味斋', '3');
INSERT INTO `tbl_goodstype` VALUES ('7', '辣条', '2');
INSERT INTO `tbl_goodstype` VALUES ('8', '运动鞋', '4');

-- ----------------------------
-- Table structure for tbl_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu`;
CREATE TABLE `tbl_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `mname` varchar(30) NOT NULL,
  `murl` varchar(100) NOT NULL,
  `parent` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=707 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_menu
-- ----------------------------
INSERT INTO `tbl_menu` VALUES ('1', '系统菜单', '-', '0');
INSERT INTO `tbl_menu` VALUES ('100', '商品管理', '-', '1');
INSERT INTO `tbl_menu` VALUES ('101', '供应商', 'supplier_list.action', '100');
INSERT INTO `tbl_menu` VALUES ('102', '类别', 'goodsType_list.action', '100');
INSERT INTO `tbl_menu` VALUES ('103', '商品', 'goods_list.action', '100');
INSERT INTO `tbl_menu` VALUES ('200', '采购管理', '-', '1');
INSERT INTO `tbl_menu` VALUES ('201', '采购订单', 'order_inList.action', '200');
INSERT INTO `tbl_menu` VALUES ('203', '采购审批', 'order_inCheckList.action', '200');
INSERT INTO `tbl_menu` VALUES ('300', '销售管理', '-', '1');
INSERT INTO `tbl_menu` VALUES ('400', '商品运输', '-', '1');
INSERT INTO `tbl_menu` VALUES ('401', '任务指派', 'order_taskList.action', '400');
INSERT INTO `tbl_menu` VALUES ('402', '任务查询', 'order_queryList.action', '400');
INSERT INTO `tbl_menu` VALUES ('500', '仓库管理', '-', '1');
INSERT INTO `tbl_menu` VALUES ('501', '库存查询', '***', '500');
INSERT INTO `tbl_menu` VALUES ('502', '入库', 'order_storeInList.action', '500');
INSERT INTO `tbl_menu` VALUES ('600', '报表中心', '-', '1');
INSERT INTO `tbl_menu` VALUES ('601', '进货报表', 'bill_buyBillList.action', '600');
INSERT INTO `tbl_menu` VALUES ('700', '基础维护', '-', '1');
INSERT INTO `tbl_menu` VALUES ('701', '部门维护', 'dep_list.action', '700');
INSERT INTO `tbl_menu` VALUES ('702', '员工维护', 'emp_list.action', '700');
INSERT INTO `tbl_menu` VALUES ('703', '角色维护', 'role_list.action', '700');
INSERT INTO `tbl_menu` VALUES ('704', '资源维护', 'res_list.action ', '700');
INSERT INTO `tbl_menu` VALUES ('705', '菜单维护', 'menu_list.action', '700');
INSERT INTO `tbl_menu` VALUES ('706', '仓库维护', 'store_list.action', '700');

-- ----------------------------
-- Table structure for tbl_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu_role`;
CREATE TABLE `tbl_menu_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `menuUuid` bigint(20) NOT NULL,
  `roleUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_menu_role
-- ----------------------------
INSERT INTO `tbl_menu_role` VALUES ('1', '200', '1');
INSERT INTO `tbl_menu_role` VALUES ('2', '600', '1');
INSERT INTO `tbl_menu_role` VALUES ('3', '701', '1');
INSERT INTO `tbl_menu_role` VALUES ('4', '101', '1');
INSERT INTO `tbl_menu_role` VALUES ('5', '501', '1');
INSERT INTO `tbl_menu_role` VALUES ('6', '702', '1');
INSERT INTO `tbl_menu_role` VALUES ('7', '601', '1');
INSERT INTO `tbl_menu_role` VALUES ('8', '100', '1');
INSERT INTO `tbl_menu_role` VALUES ('9', '401', '1');
INSERT INTO `tbl_menu_role` VALUES ('11', '300', '1');
INSERT INTO `tbl_menu_role` VALUES ('12', '700', '1');
INSERT INTO `tbl_menu_role` VALUES ('13', '705', '1');
INSERT INTO `tbl_menu_role` VALUES ('14', '704', '1');
INSERT INTO `tbl_menu_role` VALUES ('15', '1', '1');
INSERT INTO `tbl_menu_role` VALUES ('16', '400', '1');
INSERT INTO `tbl_menu_role` VALUES ('17', '500', '1');
INSERT INTO `tbl_menu_role` VALUES ('18', '703', '1');
INSERT INTO `tbl_menu_role` VALUES ('20', '102', '1');
INSERT INTO `tbl_menu_role` VALUES ('21', '103', '1');
INSERT INTO `tbl_menu_role` VALUES ('22', '201', '1');
INSERT INTO `tbl_menu_role` VALUES ('23', '203', '1');
INSERT INTO `tbl_menu_role` VALUES ('24', '402', '1');
INSERT INTO `tbl_menu_role` VALUES ('25', '402', '2');
INSERT INTO `tbl_menu_role` VALUES ('26', '401', '2');
INSERT INTO `tbl_menu_role` VALUES ('27', '400', '2');
INSERT INTO `tbl_menu_role` VALUES ('28', '706', '1');
INSERT INTO `tbl_menu_role` VALUES ('29', '502', '1');
INSERT INTO `tbl_menu_role` VALUES ('30', '601', '1');

-- ----------------------------
-- Table structure for tbl_operdetail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_operdetail`;
CREATE TABLE `tbl_operdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `operTime` bigint(20) NOT NULL,
  `type` int(1) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `storeUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_operdetail
-- ----------------------------
INSERT INTO `tbl_operdetail` VALUES ('17', '1', '1582697785605', '0', '15', '1', '1');
INSERT INTO `tbl_operdetail` VALUES ('18', '1', '1582697821121', '0', '14', '1', '1');
INSERT INTO `tbl_operdetail` VALUES ('19', '1', '1582698164279', '0', '14', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('20', '1', '1582698166483', '0', '15', '1', '3');
INSERT INTO `tbl_operdetail` VALUES ('21', '1', '1582698168045', '0', '16', '1', '5');
INSERT INTO `tbl_operdetail` VALUES ('22', '1', '1582699071701', '0', '13', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('23', '1', '1582699073258', '0', '14', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('24', '1', '1582699079261', '0', '16', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('25', '1', '1582699082197', '0', '15', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('26', '1', '1582699083953', '0', '12', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('27', '1', '1582699134228', '0', '14', '1', '1');
INSERT INTO `tbl_operdetail` VALUES ('28', '1', '1582699136019', '0', '14', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('29', '1', '1582699139684', '0', '15', '1', '3');
INSERT INTO `tbl_operdetail` VALUES ('30', '1', '1582699140698', '0', '15', '1', '1');
INSERT INTO `tbl_operdetail` VALUES ('31', '1', '1582699142122', '0', '13', '1', '2');
INSERT INTO `tbl_operdetail` VALUES ('32', '1', '1582699143852', '0', '16', '1', '5');

-- ----------------------------
-- Table structure for tbl_order
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE `tbl_order` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(60) NOT NULL,
  `totalCount` int(11) NOT NULL,
  `totalPrice` double(10,2) NOT NULL,
  `creater` bigint(20) NOT NULL,
  `createTime` bigint(20) NOT NULL,
  `checker` bigint(20) DEFAULT NULL,
  `checkTime` bigint(20) DEFAULT NULL,
  `completer` bigint(20) DEFAULT NULL,
  `endTime` bigint(20) DEFAULT NULL,
  `orderType` int(1) NOT NULL,
  `status` int(3) NOT NULL,
  `supplierUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_order
-- ----------------------------
INSERT INTO `tbl_order` VALUES ('6', '1D8EF56B201', '50', '223190.00', '1', '1582543872253', '1', '1582599345978', '5', null, '1', '131', '1');
INSERT INTO `tbl_order` VALUES ('7', '1DD5BD3B001', '5', '44425.00', '1', '1582545029147', '1', '1582600724947', null, null, '1', '120', '1');
INSERT INTO `tbl_order` VALUES ('8', '1DDD3094404', '10', '325751.10', '1', '1582545132866', '1', '1582600926668', '1', '1582699083965', '1', '199', '1');
INSERT INTO `tbl_order` VALUES ('9', '1DDD3094405', '2500', '4250.00', '1', '1582545161941', null, null, null, null, '1', '111', '2');
INSERT INTO `tbl_order` VALUES ('10', '1DE0EA40E06', '280', '5277.40', '1', '1582545180900', '1', '1582599659211', '1', null, '1', '141', '3');
INSERT INTO `tbl_order` VALUES ('11', '1DE4A3ED807', '45', '1415.50', '1', '1582545279996', null, null, null, null, '1', '111', '3');
INSERT INTO `tbl_order` VALUES ('12', '1D96724DC81', '14', '352500.40', '1', '1582594386270', '1', '1582605734522', '1', '1582699143856', '1', '199', '1');
INSERT INTO `tbl_order` VALUES ('13', '1DCAA347F01', '850', '1125.00', '1', '1582685242870', null, null, null, null, '1', '111', '2');

-- ----------------------------
-- Table structure for tbl_orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_orderdetail`;
CREATE TABLE `tbl_orderdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `inPrice` decimal(10,2) NOT NULL,
  `orderUuid` bigint(20) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `buyCount` int(11) NOT NULL,
  `surplus` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_orderdetail
-- ----------------------------
INSERT INTO `tbl_orderdetail` VALUES ('8', '3265.00', '6', '1', '20', '20');
INSERT INTO `tbl_orderdetail` VALUES ('9', '5263.00', '6', '6', '30', '30');
INSERT INTO `tbl_orderdetail` VALUES ('10', '8885.00', '7', '10', '5', '5');
INSERT INTO `tbl_orderdetail` VALUES ('11', '78952.00', '8', '13', '2', '0');
INSERT INTO `tbl_orderdetail` VALUES ('12', '45621.00', '8', '14', '2', '0');
INSERT INTO `tbl_orderdetail` VALUES ('13', '7895.20', '8', '16', '2', '0');
INSERT INTO `tbl_orderdetail` VALUES ('14', '4564.35', '8', '15', '2', '0');
INSERT INTO `tbl_orderdetail` VALUES ('15', '25843.00', '8', '12', '2', '0');
INSERT INTO `tbl_orderdetail` VALUES ('16', '0.50', '9', '7', '1000', '1000');
INSERT INTO `tbl_orderdetail` VALUES ('17', '2.50', '9', '11', '1500', '1500');
INSERT INTO `tbl_orderdetail` VALUES ('18', '18.36', '10', '4', '90', '90');
INSERT INTO `tbl_orderdetail` VALUES ('19', '18.50', '10', '2', '80', '80');
INSERT INTO `tbl_orderdetail` VALUES ('20', '19.50', '10', '3', '110', '110');
INSERT INTO `tbl_orderdetail` VALUES ('21', '40.22', '11', '17', '25', '25');
INSERT INTO `tbl_orderdetail` VALUES ('22', '20.50', '11', '5', '20', '20');
INSERT INTO `tbl_orderdetail` VALUES ('23', '45621.00', '12', '14', '3', '0');
INSERT INTO `tbl_orderdetail` VALUES ('24', '4564.35', '12', '15', '4', '0');
INSERT INTO `tbl_orderdetail` VALUES ('25', '78952.00', '12', '13', '2', '0');
INSERT INTO `tbl_orderdetail` VALUES ('26', '7895.20', '12', '16', '5', '0');
INSERT INTO `tbl_orderdetail` VALUES ('27', '2.50', '13', '11', '350', '350');
INSERT INTO `tbl_orderdetail` VALUES ('28', '0.50', '13', '7', '500', '500');

-- ----------------------------
-- Table structure for tbl_res
-- ----------------------------
DROP TABLE IF EXISTS `tbl_res`;
CREATE TABLE `tbl_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `resName` varchar(30) NOT NULL,
  `resValue` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_res
-- ----------------------------
INSERT INTO `tbl_res` VALUES ('1', '部门列表', 'cn.itcast.erp.auth.dep.action.DepAction.list');
INSERT INTO `tbl_res` VALUES ('2', '部门添加/修改', 'cn.itcast.erp.auth.dep.action.DepAction.saveOrUpdate');
INSERT INTO `tbl_res` VALUES ('3', '部门操作', 'cn.itcast.erp.auth.dep.action.DepAction.input');
INSERT INTO `tbl_res` VALUES ('4', '部门删除', 'cn.itcast.erp.auth.dep.action.DepAction.delete');
INSERT INTO `tbl_res` VALUES ('5', '员工列表', 'cn.itcast.erp.auth.emp.action.EmpAction.list');
INSERT INTO `tbl_res` VALUES ('6', '员工操作', 'cn.itcast.erp.auth.emp.action.EmpAction.input');
INSERT INTO `tbl_res` VALUES ('7', '员工操作（添加/修改）', 'cn.itcast.erp.auth.emp.action.EmpAction.saveOrUpdate');
INSERT INTO `tbl_res` VALUES ('8', '员工删除', 'cn.itcast.erp.auth.emp.action.EmpAction.delete');
INSERT INTO `tbl_res` VALUES ('9', '资源列表', 'cn.itcast.erp.auth.res.action.ResAction.list');
INSERT INTO `tbl_res` VALUES ('10', '资源操作', 'cn.itcast.erp.auth.res.action.ResAction.input');
INSERT INTO `tbl_res` VALUES ('11', '资源添加/修改', 'cn.itcast.erp.auth.res.action.ResAction.saveOrUpdate');
INSERT INTO `tbl_res` VALUES ('12', '资源删除', 'cn.itcast.erp.auth.res.action.ResAction.delete');
INSERT INTO `tbl_res` VALUES ('14', '角色列表', 'cn.itcast.erp.auth.role.action.RoleAction.list');
INSERT INTO `tbl_res` VALUES ('15', '角色操作', 'cn.itcast.erp.auth.role.action.RoleAction.input');
INSERT INTO `tbl_res` VALUES ('16', '角色添加/修改', 'cn.itcast.erp.auth.role.action.RoleAction.saveOrUpdate');
INSERT INTO `tbl_res` VALUES ('17', '角色删除', 'cn.itcast.erp.auth.role.action.RoleAction.delete');

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `rname` varchar(30) NOT NULL,
  `rcode` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES ('1', '管理员', 'admin');
INSERT INTO `tbl_role` VALUES ('2', '采购主管', 'buymgr');
INSERT INTO `tbl_role` VALUES ('3', '采购员', 'buyer');
INSERT INTO `tbl_role` VALUES ('4', '人事主管', 'hrmgr');
INSERT INTO `tbl_role` VALUES ('5', '人事', 'hr');
INSERT INTO `tbl_role` VALUES ('6', '财务主管', 'financialmgr');
INSERT INTO `tbl_role` VALUES ('7', '财务人员', 'financial');
INSERT INTO `tbl_role` VALUES ('10', '部长', 'minister');

-- ----------------------------
-- Table structure for tbl_role_res
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_res`;
CREATE TABLE `tbl_role_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) NOT NULL,
  `resUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role_res
-- ----------------------------
INSERT INTO `tbl_role_res` VALUES ('1', '4', '8');
INSERT INTO `tbl_role_res` VALUES ('2', '4', '5');
INSERT INTO `tbl_role_res` VALUES ('3', '4', '7');
INSERT INTO `tbl_role_res` VALUES ('4', '4', '6');
INSERT INTO `tbl_role_res` VALUES ('5', '3', '5');
INSERT INTO `tbl_role_res` VALUES ('6', '10', '1');
INSERT INTO `tbl_role_res` VALUES ('7', '10', '3');
INSERT INTO `tbl_role_res` VALUES ('8', '10', '6');
INSERT INTO `tbl_role_res` VALUES ('9', '10', '2');
INSERT INTO `tbl_role_res` VALUES ('10', '10', '5');
INSERT INTO `tbl_role_res` VALUES ('11', '10', '7');
INSERT INTO `tbl_role_res` VALUES ('12', '1', '1');
INSERT INTO `tbl_role_res` VALUES ('13', '1', '3');
INSERT INTO `tbl_role_res` VALUES ('14', '1', '4');
INSERT INTO `tbl_role_res` VALUES ('15', '1', '12');
INSERT INTO `tbl_role_res` VALUES ('16', '1', '6');
INSERT INTO `tbl_role_res` VALUES ('17', '1', '9');
INSERT INTO `tbl_role_res` VALUES ('18', '1', '5');
INSERT INTO `tbl_role_res` VALUES ('19', '1', '2');
INSERT INTO `tbl_role_res` VALUES ('20', '1', '17');
INSERT INTO `tbl_role_res` VALUES ('21', '1', '15');
INSERT INTO `tbl_role_res` VALUES ('22', '1', '11');
INSERT INTO `tbl_role_res` VALUES ('23', '1', '16');
INSERT INTO `tbl_role_res` VALUES ('24', '1', '10');
INSERT INTO `tbl_role_res` VALUES ('25', '1', '7');
INSERT INTO `tbl_role_res` VALUES ('26', '1', '8');
INSERT INTO `tbl_role_res` VALUES ('27', '1', '14');

-- ----------------------------
-- Table structure for tbl_store
-- ----------------------------
DROP TABLE IF EXISTS `tbl_store`;
CREATE TABLE `tbl_store` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `sname` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `empUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_store
-- ----------------------------
INSERT INTO `tbl_store` VALUES ('1', '熟食仓库', '三楼', '7');
INSERT INTO `tbl_store` VALUES ('2', '食品仓库', '一楼', '6');
INSERT INTO `tbl_store` VALUES ('3', '服装仓库', '二楼', '5');
INSERT INTO `tbl_store` VALUES ('4', '电子产品库', '空港工业园', '1');

-- ----------------------------
-- Table structure for tbl_storedetail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_storedetail`;
CREATE TABLE `tbl_storedetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `storeUuid` bigint(20) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_storedetail
-- ----------------------------
INSERT INTO `tbl_storedetail` VALUES ('10', '1', '13', '4');
INSERT INTO `tbl_storedetail` VALUES ('11', '1', '14', '5');
INSERT INTO `tbl_storedetail` VALUES ('12', '1', '16', '7');
INSERT INTO `tbl_storedetail` VALUES ('13', '1', '15', '6');
INSERT INTO `tbl_storedetail` VALUES ('14', '1', '12', '2');

-- ----------------------------
-- Table structure for tbl_supplier
-- ----------------------------
DROP TABLE IF EXISTS `tbl_supplier`;
CREATE TABLE `tbl_supplier` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `sname` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `tele` varchar(30) NOT NULL,
  `pattern` int(1) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_supplier
-- ----------------------------
INSERT INTO `tbl_supplier` VALUES ('1', '齐市百脑汇', '龙沙路中环二佰', '王电脑', '123', '1');
INSERT INTO `tbl_supplier` VALUES ('2', '成都副食品批发', '四川食品街', '张食品', '456', '1');
INSERT INTO `tbl_supplier` VALUES ('3', '北京烤鸭', '北京丰台', '周烤鸭', '789', '0');
INSERT INTO `tbl_supplier` VALUES ('4', '阿迪达斯', '美国圣保罗', '迪哥', '456x', '0');

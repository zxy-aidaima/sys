

INSERT INTO `vms`.`registerinfo`(`registerid`,`phonenumber`, `uname`, `sex`, `identifynumber`, `age`, `liveprovince`, `livecity`, `livecounty`, `livetownvillage`, `registerprovince`, `registercity`, `registecounty`, `registertownvillage`, `approvename`, `registerdate`, `typeflag`) VALUES ('111111','13231781681', '阿萌', '0', '130925199653215421', 18, '北京市', '北京城区', '东城区', '123', '河北省', '石家庄市', '长安区', NULL, NULL, NULL, '2');


INSERT INTO `vms`.`registertrack`(`phonenumber`, `uname`, `sex`, `identifynumber`, `age`, `liveprovince`, `livecity`, `livecounty`, `livetownvillage`, `registerprovince`, `registercity`, `registecounty`, `registertownvillage`, `reason`, `approvename`, `returnreason`, `returndate`, `typeflag`) VALUES ('13231781681', '阿萌', '0', '130925199653215421', 18, '北京市', '北京城区', '东城区', '123', '河北省', '石家庄市', '长安区', NULL, '66666', NULL, NULL, NULL, '2');
INSERT INTO `vms`.`registertrack`(`phonenumber`, `uname`, `sex`, `identifynumber`, `age`, `liveprovince`, `livecity`, `livecounty`, `livetownvillage`, `registerprovince`, `registercity`, `registecounty`, `registertownvillage`, `reason`, `approvename`, `returnreason`, `returndate`, `typeflag`) VALUES ('13231781682', '阿前', '1', '130925199653215421', 19, '北京市', '北京城区', '西城区', '鑫福华园小区3栋112室', '北京市', '北京城区', '朝阳区', NULL, '闲得慌', NULL, NULL, NULL, '0');
INSERT INTO `vms`.`registertrack`(`phonenumber`, `uname`, `sex`, `identifynumber`, `age`, `liveprovince`, `livecity`, `livecounty`, `livetownvillage`, `registerprovince`, `registercity`, `registecounty`, `registertownvillage`, `reason`, `approvename`, `returnreason`, `returndate`, `typeflag`) VALUES ('13231781683', '阿吖', '0', '130925199653211234', 19, '北京市', '北京城区', '丰台区', '333', '河北省', '邯郸市', '永年区', '444', '234555', NULL, NULL, NULL, '0');


-- 密码81dc9bdb52d04dc20036dbd8313ed055解密为1234
INSERT INTO `vms`.`userlogin`(`registerid`, `uname`, `phonenumber`, `upassword`, `loginflag`, `lasttime`, `roletype`, `validflag`) 
VALUES ('1', '阿萌', '13232654489', '81dc9bdb52d04dc20036dbd8313ed055', '0', '2020-12-26 23:03:22', '0', '1');
INSERT INTO `vms`.`userlogin`(`registerid`, `uname`, `phonenumber`, `upassword`, `loginflag`, `lasttime`, `roletype`, `validflag`) 
VALUES ('2', '阿雅', '13156485642', '81dc9bdb52d04dc20036dbd8313ed055', '0', '2020-12-26 23:31:02', '1', '1');
INSERT INTO `vms`.`userlogin`(`registerid`, `uname`, `phonenumber`, `upassword`, `loginflag`, `lasttime`, `roletype`, `validflag`) 
VALUES ('3', '阿发', '13156987413', '81dc9bdb52d04dc20036dbd8313ed055', '0', '2020-12-26 23:31:02', '2', '1');

-- 省份码表
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('11', '北京市', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('12', '天津市', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('13', '河北省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('14', '山西省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('15', '内蒙古自治区', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('21', '辽宁省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('22', '吉林省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('23', '黑龙江省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('31', '上海市', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('32', '江苏省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('33', '浙江省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('34', '安徽省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('35', '福建省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('36', '江西省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('37', '山东省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('41', '河南省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('42', '湖北省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('43', '湖南省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('44', '广东省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('45', '广西壮族自治区', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('46', '海南省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('50', '重庆市', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('51', '四川省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('52', '贵州省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('53', '云南省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('54', '西藏自治区', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('61', '陕西省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('62', '甘肃省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('63', '青海省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('64', '宁夏回族自治区', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('65', '新疆维吾尔自治区', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('71', '台湾省', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('81', '香港特别行政区', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('82', '澳门特别行政区', 'province', '1', '2021-01-09 23:21:48', NULL);
INSERT INTO `vms`.`codeconf`(`code`, `describe`, `codename`, `state`, `datetime`, `remark`) VALUES ('99', '国外', 'province', '1', '2021-01-09 23:21:48', NULL);







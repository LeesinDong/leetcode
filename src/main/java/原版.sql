CREATE TABLE `t_biggie` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'long user ID',
  `bit_map` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '大神位图 主要存储各种开关',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0-正常；1-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` bigint(20) unsigned NOT NULL DEFAULT '0',
  `main_city` varchar(50) NOT NULL DEFAULT '' COMMENT '主接单城市',
  `start_hours` varchar(10) NOT NULL DEFAULT '08:00' COMMENT '开始接单时间',
  `end_hours` varchar(10) NOT NULL DEFAULT '02:00' COMMENT '结束接单时间',
  `order_days` varchar(20) NOT NULL DEFAULT '0,1,2,3,4,5,6' COMMENT '接单日期 0为周日',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '大神状态 0=冻结 1=正常',
  `frozen_reason` varchar(255) NOT NULL DEFAULT '' COMMENT '冻结原因',
  `frozen_time` datetime DEFAULT NULL COMMENT '冻结开始时间',
  `frozen_end_time` datetime DEFAULT NULL COMMENT '冻结结束时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UINIQ_UID` (`uid`),
  KEY `IDX_UID` (`uid`),
  KEY `IDX_CREATE_TIME` (`create_time`),
  KEY `IDX_UPDATE_TIME` (`update_time`),
  KEY `IDX_BIGGIE_ID` (`biggie_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1286 DEFAULT CHARSET=utf8 COMMENT='大神信息表';
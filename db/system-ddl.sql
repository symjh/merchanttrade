/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云-mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 47.106.91.233:3306
 Source Schema         : sinosoft

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 18/09/2018 17:23:57
*/

SET NAMES utf8;

-- ----------------------------
--  Table structure for JOB_EXECUTION_LOG
-- ----------------------------
DROP TABLE IF EXISTS job_execution_log;
CREATE TABLE job_execution_log (
  id               VARCHAR(40)  NOT NULL,
  job_name         VARCHAR(100) NOT NULL,
  task_id          VARCHAR(255) NOT NULL,
  hostname         VARCHAR(255) NOT NULL,
  ip               VARCHAR(50)  NOT NULL,
  sharding_item    INT(11)      NOT NULL,
  execution_source VARCHAR(20)  NOT NULL,
  failure_cause    VARCHAR(4000) DEFAULT NULL,
  is_success       INT(11)      NOT NULL,
  start_time       TIMESTAMP    NULL DEFAULT NULL,
  complete_time    TIMESTAMP    NULL DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- ----------------------------
--  Table structure for JOB_STATUS_TRACE_LOG
-- ----------------------------
DROP TABLE IF EXISTS job_status_trace_log;
CREATE TABLE job_status_trace_log (
  id               VARCHAR(40)  NOT NULL,
  job_name         VARCHAR(100) NOT NULL,
  original_task_id VARCHAR(255) NOT NULL,
  task_id          VARCHAR(255) NOT NULL,
  slave_id         VARCHAR(50)  NOT NULL,
  source           VARCHAR(50)  NOT NULL,
  execution_type   VARCHAR(20)  NOT NULL,
  sharding_item    VARCHAR(100) NOT NULL,
  state            VARCHAR(20)  NOT NULL,
  message          VARCHAR(4000) DEFAULT NULL,
  creation_time    TIMESTAMP    NULL DEFAULT NULL,
  PRIMARY KEY (id),
  KEY              TASK_ID_STATE_INDEX (task_id, STATE )
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- ----------------------------
--  Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS sys_dept;
CREATE TABLE sys_dept (
  dept_id     INT(20)   NOT NULL AUTO_INCREMENT,
  name        VARCHAR(50) DEFAULT NULL COMMENT '部门名称',
  order_num   INT(11)     DEFAULT NULL COMMENT '排序',
  create_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  del_flag    CHAR(1)     DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  parent_id   INT(11)     DEFAULT NULL,
  PRIMARY KEY (dept_id)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET =utf8 ROW_FORMAT = DYNAMIC COMMENT = '部门管理';

-- ----------------------------
--  Table structure for sys_dept_relation
-- ----------------------------
DROP TABLE IF EXISTS sys_dept_relation;
CREATE TABLE sys_dept_relation (
  ancestor   INT(11) NOT NULL COMMENT '祖先节点',
  descendant INT(11) NOT NULL COMMENT '后代节点',
  PRIMARY KEY (ancestor, descendant),
  KEY        IDX1 (ancestor),
  KEY        IDX2 (descendant)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 ROW_FORMAT = DYNAMIC;

-- ----------------------------
--  Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict (
  id          INT(64)        NOT NULL AUTO_INCREMENT COMMENT '编号',
  value       VARCHAR(100)   NOT NULL COMMENT '数据值',
  label       VARCHAR(100)   NOT NULL COMMENT '标签名',
  type        VARCHAR(100)   NOT NULL COMMENT '类型',
  description VARCHAR(100)   NOT NULL COMMENT '描述',
  sort        DECIMAL(10, 0) NOT NULL COMMENT '排序（升序）',
  create_time TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  remarks     VARCHAR(255) DEFAULT NULL COMMENT '备注信息',
  del_flag    CHAR(1)        NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (id),
  KEY         SYS_DICT_VALUE ( VALUE ),
  KEY         SYS_DICT_LABEL (label),
  KEY         SYS_DICT_DEL_FLAG (del_flag)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET =utf8 ROW_FORMAT = DYNAMIC COMMENT = '字典表';

-- ----------------------------
--  Table structure for sys_log_0
-- ----------------------------
DROP TABLE IF EXISTS sys_log_0;
CREATE TABLE sys_log_0 (
  id          BIGINT (64) NOT NULL COMMENT '编号',
  type        CHAR(1)       DEFAULT '1' COMMENT '日志类型',
  title       VARCHAR(255)  DEFAULT '' COMMENT '日志标题',
  service_id  VARCHAR(32)   DEFAULT NULL COMMENT '服务ID',
  create_by   VARCHAR(64)   DEFAULT NULL COMMENT '创建者',
  create_time DATETIME      DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME      DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  remote_addr VARCHAR(255)  DEFAULT NULL COMMENT '操作IP地址',
  user_agent  VARCHAR(1000) DEFAULT NULL COMMENT '用户代理',
  request_uri VARCHAR(255)  DEFAULT NULL COMMENT '请求URI',
  method      VARCHAR(10)   DEFAULT NULL COMMENT '操作方式',
  params      TEXT COMMENT '操作提交的数据',
  time        MEDIUMTEXT COMMENT '执行时间',
  del_flag    CHAR(1)       DEFAULT '0' COMMENT '删除标记',
  exception   TEXT COMMENT '异常信息',
  PRIMARY KEY (id),
  KEY         SYS_LOG_CREATE_BY (create_by),
  KEY         SYS_LOG_REQUEST_URI (request_uri),
  KEY         SYS_LOG_TYPE ( TYPE ),
  KEY         SYS_LOG_CREATE_DATE (create_time)
) ENGINE=InnoDB DEFAULT CHARSET =utf8 ROW_FORMAT=DYNAMIC COMMENT = '日志表';

-- ----------------------------
--  Table structure for sys_log_1
-- ----------------------------
DROP TABLE IF EXISTS sys_log_1;
CREATE TABLE sys_log_1 (
  id          BIGINT (64) NOT NULL COMMENT '编号',
  type        CHAR(1)       DEFAULT '1' COMMENT '日志类型',
  title       VARCHAR(255)  DEFAULT '' COMMENT '日志标题',
  service_id  VARCHAR(32)   DEFAULT NULL COMMENT '服务ID',
  create_by   VARCHAR(64)   DEFAULT NULL COMMENT '创建者',
  create_time DATETIME      DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME      DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  remote_addr VARCHAR(255)  DEFAULT NULL COMMENT '操作IP地址',
  user_agent  VARCHAR(1000) DEFAULT NULL COMMENT '用户代理',
  request_uri VARCHAR(255)  DEFAULT NULL COMMENT '请求URI',
  method      VARCHAR(10)   DEFAULT NULL COMMENT '操作方式',
  params      TEXT COMMENT '操作提交的数据',
  time        MEDIUMTEXT COMMENT '执行时间',
  del_flag    CHAR(1)       DEFAULT '0' COMMENT '删除标记',
  exception   TEXT COMMENT '异常信息',
  PRIMARY KEY (id),
  KEY         SYS_LOG_CREATE_BY (create_by),
  KEY         SYS_LOG_REQUEST_URI (request_uri),
  KEY         SYS_LOG_TYPE ( TYPE ),
  KEY         SYS_LOG_CREATE_DATE (create_time)
) ENGINE=InnoDB DEFAULT CHARSET =utf8 ROW_FORMAT=DYNAMIC COMMENT = '日志表';

-- ----------------------------
--  Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu (
  parent_id   INT(11)      DEFAULT NULL COMMENT '父菜单ID',
  menu_id     INT(11)     NOT NULL COMMENT '菜单ID',
  name        VARCHAR(32) NOT NULL COMMENT '菜单名称',
  permission  VARCHAR(32)  DEFAULT NULL COMMENT '菜单权限标识',
  path        VARCHAR(128) DEFAULT NULL COMMENT '前端URL',
  url         VARCHAR(128) DEFAULT NULL COMMENT '请求链接',
  method      VARCHAR(32)  DEFAULT NULL COMMENT '请求方法',
  icon        VARCHAR(32)  DEFAULT NULL COMMENT '图标',
  component   VARCHAR(64)  DEFAULT NULL COMMENT 'VUE页面',
  sort        INT(11)      DEFAULT '1' COMMENT '排序值',
  type        CHAR(1)      DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  create_time TIMESTAMP   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP   NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag    CHAR(1)      DEFAULT '0' COMMENT '0--正常 1--删除',
  PRIMARY KEY (menu_id)
) ENGINE=InnoDB DEFAULT CHARSET =utf8 ROW_FORMAT=DYNAMIC COMMENT = '菜单权限表';

-- ----------------------------
--  Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS sys_oauth_client_details;
CREATE TABLE sys_oauth_client_details (
  client_id               VARCHAR(40) NOT NULL,
  resource_ids            VARCHAR(256)  DEFAULT NULL,
  client_secret           VARCHAR(256)  DEFAULT NULL,
  scope                   VARCHAR(256)  DEFAULT NULL,
  authorized_grant_types  VARCHAR(256)  DEFAULT NULL,
  web_server_redirect_uri VARCHAR(256)  DEFAULT NULL,
  authorities             VARCHAR(256)  DEFAULT NULL,
  access_token_validity   INT(11)       DEFAULT NULL,
  refresh_token_validity  INT(11)       DEFAULT NULL,
  additional_information  VARCHAR(4096) DEFAULT NULL,
  autoapprove             VARCHAR(256)  DEFAULT NULL,
  PRIMARY KEY (client_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- ----------------------------
--  Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  role_id     INT(11)   NOT NULL AUTO_INCREMENT,
  role_name   VARCHAR(64) COLLATE utf8mb4_bin NOT NULL,
  role_code   VARCHAR(64) COLLATE utf8mb4_bin NOT NULL,
  role_desc   VARCHAR(255) COLLATE utf8mb4_bin DEFAULT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  del_flag    CHAR(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (role_id),
  UNIQUE KEY role_idx1_role_code (role_code)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET =utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
--  Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS sys_role_dept;
CREATE TABLE sys_role_dept (
  id      INT(20) NOT NULL AUTO_INCREMENT,
  role_id INT(20) DEFAULT NULL COMMENT '角色ID',
  dept_id INT(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET =utf8 ROW_FORMAT = DYNAMIC COMMENT = '角色与部门对应关系';

-- ----------------------------
--  Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu (
  role_id INT(11) NOT NULL COMMENT '角色ID',
  menu_id INT(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (role_id, menu_id)
) ENGINE=InnoDB DEFAULT CHARSET =utf8 ROW_FORMAT=DYNAMIC COMMENT = '角色菜单表';

-- ----------------------------
--  Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  user_id     INT(11)   NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  username    VARCHAR(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  password    VARCHAR(255) COLLATE utf8mb4_bin NOT NULL,
  salt        VARCHAR(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '随机盐',
  phone       VARCHAR(20) COLLATE utf8mb4_bin NOT NULL COMMENT '简介',
  avatar      VARCHAR(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  dept_id     INT(11) DEFAULT NULL COMMENT '部门ID',
  create_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  del_flag    CHAR(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '0-正常，1-删除',
  PRIMARY KEY (user_id),
  UNIQUE KEY user_idx1_username (username),
  UNIQUE KEY user_idx2_phone (phone)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET =utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC COMMENT = '用户表';

-- ----------------------------
--  Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role (
  user_id INT(11) NOT NULL COMMENT '用户ID',
  role_id INT(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (user_id, role_id)
) ENGINE=InnoDB DEFAULT CHARSET =utf8 ROW_FORMAT=DYNAMIC COMMENT = '用户角色表';

-- ----------------------------
--  Table structure for sys_zuul_route
-- ----------------------------
DROP TABLE IF EXISTS sys_zuul_route;
CREATE TABLE sys_zuul_route (
  id                    INT(11)      NOT NULL AUTO_INCREMENT COMMENT 'router Id',
  path                  VARCHAR(255) NOT NULL COMMENT '路由路径',
  service_id            VARCHAR(255) NOT NULL COMMENT '服务名称',
  url                   VARCHAR(255) DEFAULT NULL COMMENT 'url代理',
  strip_prefix          CHAR(1)      DEFAULT '1' COMMENT '转发去掉前缀',
  retryable             CHAR(1)      DEFAULT '1' COMMENT '是否重试',
  enabled               CHAR(1)      DEFAULT '1' COMMENT '是否启用',
  sensitiveHeaders_list VARCHAR(255) DEFAULT NULL COMMENT '敏感请求头',
  create_time           TIMESTAMP    NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time           TIMESTAMP    NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag              CHAR(1)      DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET =utf8mb4 COMMENT = '动态路由配置表';

-- ----------------------------
--  Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS zipkin_annotations;
CREATE TABLE zipkin_annotations (
  trace_id_high         BIGINT (20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  trace_id              BIGINT (20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  span_id               BIGINT (20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  a_key                 VARCHAR(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  a_value               BLOB COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  a_type                INT(11)      NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  a_timestamp           BIGINT (20) DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  endpoint_ipv4         INT(11)      DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  endpoint_ipv6         BINARY (16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  endpoint_port         SMALLINT(6)  DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  endpoint_service_name VARCHAR(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY trace_id_high (trace_id_high, trace_id, span_id, a_key, a_timestamp) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY trace_id_high_4 (trace_id_high, trace_id, span_id, a_key, a_timestamp) COMMENT 'Ignore insert on duplicate',
  KEY                   TRACE_ID_HIGH_2 (trace_id_high, trace_id, span_id) COMMENT 'for joining with zipkin_spans',
  KEY                   TRACE_ID_HIGH_3 (trace_id_high, trace_id) COMMENT 'for getTraces/ByIds',
  KEY                   ENDPOINT_SERVICE_NAME (endpoint_service_name) COMMENT 'for getTraces and getServiceNames',
  KEY                   A_TYPE (a_type) COMMENT 'for getTraces',
  KEY                   A_KEY (a_key) COMMENT 'for getTraces',
  KEY                   TRACE_ID (trace_id, span_id, a_key) COMMENT 'for dependencies job',
  KEY                   TRACE_ID_HIGH_5 (trace_id_high, trace_id, span_id) COMMENT 'for joining with zipkin_spans',
  KEY                   TRACE_ID_HIGH_6 (trace_id_high, trace_id) COMMENT 'for getTraces/ByIds',
  KEY                   ENDPOINT_SERVICE_NAME_2 (endpoint_service_name) COMMENT 'for getTraces and getServiceNames',
  KEY                   A_TYPE_2 (a_type) COMMENT 'for getTraces',
  KEY                   A_KEY_2 (a_key) COMMENT 'for getTraces',
  KEY                   TRACE_ID_2 (trace_id, span_id, a_key) COMMENT 'for dependencies job'
) ENGINE = InnoDB DEFAULT CHARSET = utf8 ROW_FORMAT = COMPRESSED;

-- ----------------------------
--  Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS zipkin_dependencies;
CREATE TABLE zipkin_dependencies (
  day        DATE         NOT NULL,
  parent     VARCHAR(255) NOT NULL,
  child      VARCHAR(255) NOT NULL,
  call_count BIGINT (20) DEFAULT NULL,
  UNIQUE KEY DAY ( DAY, PARENT, CHILD ),
  UNIQUE KEY day_2 ( DAY, PARENT, CHILD )
) ENGINE = InnoDB DEFAULT CHARSET = utf8 ROW_FORMAT = COMPRESSED;

-- ----------------------------
--  Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS zipkin_spans;
CREATE TABLE zipkin_spans (
  trace_id_high BIGINT (20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  trace_id      BIGINT (20) NOT NULL,
  id            BIGINT (20) NOT NULL,
  name          VARCHAR(255) NOT NULL,
  parent_id     BIGINT (20) DEFAULT NULL,
  debug         BIT (1) DEFAULT NULL,
  start_ts      BIGINT (20) DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  duration      BIGINT (20) DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY trace_id_high (trace_id_high, trace_id, ID ) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY trace_id_high_4 (trace_id_high, trace_id, ID ) COMMENT 'ignore insert on duplicate',
  KEY           TRACE_ID_HIGH_2 (trace_id_high, trace_id, ID ) COMMENT 'for joining with zipkin_annotations',
  KEY           TRACE_ID_HIGH_3 (trace_id_high, trace_id) COMMENT 'for getTracesByIds',
  KEY           NAME ( NAME ) COMMENT 'for getTraces and getSpanNames',
  KEY           START_TS (start_ts) COMMENT 'for getTraces ordering and range',
  KEY           TRACE_ID_HIGH_5 (trace_id_high, trace_id, ID ) COMMENT 'for joining with zipkin_annotations',
  KEY           TRACE_ID_HIGH_6 (trace_id_high, trace_id) COMMENT 'for getTracesByIds',
  KEY           NAME_2 ( NAME ) COMMENT 'for getTraces and getSpanNames',
  KEY           START_TS_2 (start_ts) COMMENT 'for getTraces ordering and range'
) ENGINE = InnoDB DEFAULT CHARSET = utf8 ROW_FORMAT = COMPRESSED;




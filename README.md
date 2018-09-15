# merchanttrade

#### 项目介绍
一个聚合支付平台，关联项目地址
- 配置中心 merchanttrade-config - https://github.com/Ripin/merchanttrade-config
- 前端页面 merchanttrade-ui - https://github.com/Ripin/merchanttrade-ui

#### 软件架构
项目架构引用开源架构 https://gitee.com/log4j/pig

``` lua
merchanttrade
├── ins-ui -- element-vue-admin实现[8000]
├── ins-auth -- 授权服务提供[8010]
├── ins-common -- 系统公共模块 
├── ins-config -- 配置中心[8888]
├── ins-eureka -- 服务注册与发现[8761]
├── ins-gateway -- ZUUL网关[9999]
├── ins-modules -- 微服务模块
├    ├── ins-daemon-service -- 分布式调度中心[8060]
├    ├── ins-mc-service -- 消息中心[8050]
├    ├── ins-sso-client-demo -- 单点登录客户端示例[8040]
├    └── ins-upms-service -- 权限管理提供[8020]
├    └── ins-trade-service -- 聚合支付[8030]
└── ins-visual  -- 图形化模块 
     ├── ins-monitor -- 服务状态监控、turbine [5001]
     ├── ins-zipkin-elk -- zipkin、ELK监控[5002、5601]
     └── ins-cache-cloud -- 缓存管理、统一监控[5005]
```



#### 安装使用步骤

1. 下载 merchanttrade、merchanttrade-config、merchanttrade-ui 3个项目
2. 导入项目至idea中，merchanttrade工程下执行clean package -DskipTests
3. 依次启动ins-auth、ins-gateway、ins-upms-service
4. 安装node.js环境（npm包管理器），在merchanttrade-ui项目目录下执行
```bash 
  # 安装依赖
  npm install
  # 建议不要用cnpm  安装有各种诡异的bug 可以通过如下操作解决npm速度慢的问题
  npm install --registry=https://registry.npm.taobao.org
  # 安装过程中如果node-sass出错，执行以下命令安装，然后重新执行上一步install命令
  npm i node-sass --sass_binary_site=https://npm.taobao.org/mirrors/node-sass/

  # 本地开发，安装成功后，启动ui服务
  npm run dev
  
```
5. 登陆操作admin/123456


#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request



#### 功能清单
- 完善登录：账号密码模式、短信验证码模式、社交账号模式均整合Spring security oAuth
- 单点登录：基于Srping security oAuth 提供单点登录接口，方便其他系统对接
- 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
- 机构管理：配置系统组织机构，树结构展现，可随意调整上下级。
- 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
- 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
- 动态路由：基于zuul实现动态路由，后端可配置化
- 终端管理：动态配置oauth终端，后端可配置化
- 字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：是否等。
- 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
- 服务限流：多种维度的流量控制（服务、IP、用户等）
- 消息总线：配置动态实时刷新
- 分库分表：shardingdbc分库分表策略
- 数据权限: 使用mybatis对原查询做增强，业务代码不用控制，即可实现。
- 文件系统: 支持FastDFS、七牛云，扩展API几行代码实现上传下载
- 消息中心：短信、邮件模板发送，几行代码实现发送
- 聚合文档：基于zuul实现 swagger各个模块的实现
- 代码生成：前后端代码的生成，支持Vue
- 缓存管理：基于Cache Cloud 保证Redis 的高可用
- 服务监控: Spring Boot Admin
- 分布式任务调度： 基于elastic-job的分布式文件系统，zookeeper做调度中心
- zipkin链路追踪： 数据保存ELK，图形化展示
- pinpoint链路追踪： 数据保存hbase，图形化展示

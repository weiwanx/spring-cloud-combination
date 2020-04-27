# spring-cloud-combination
springcloud全家桶，相关组件都有用到，持续更新中

| 服务名 | 作用 | clone后需要修改的内容 |
|------|------------|------------|
| combination-server-eureka  | 注册中心          | 无         |
| combination-server-rabbitmq  | 注册在eureka内的服务，里面包含了rabbitmq五种常用模式的测试代码，以及集成rabbitmq需要的代码都在其中        | application.yml内的rabbitmq相关参数修改为你本地        |
| combination-server-user  | 注册在eureka内的服务，里面整合了SpringSecurity和JWT实现认证和授权       | application.yml内的数据库和rabbitmq相关参数修改为你本地，数据库方面准备一个新库，表结构等在你启动项目之后会通过flyway自动同步到数据库       |
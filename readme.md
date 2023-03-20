#  NWPU-Survival-Manual server
NWPU-SURVIVAL-MANUAL旨在为西工大学生搭建一个集查询，分享，评价等功能的课程论坛。用多种多样的分类方式来帮助同学高效，准确，快速地选择各种课程，弥补西工大教务内容详尽但特点不突出的缺点。同时开辟课程评论通道，让学生为课程打分，为选课提供参考，让大量优质课程为同学所知，同时极大程度上压缩同学们在选课时通过“表白墙”，“互助群”等渠道获取课程信息的时间投入。



## 快速开始
需要配置数据库设置(``src/main/resources/application.properties``)：

```java
server.port=8088

#???????
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/nsm?characterEncoding=utf-8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
```

依赖详情可以查看根目录下的pom.xml,按照依赖要求安装相应环境之后可以直接运行`.\src\main\java\com.yyh.nwpusurvivalmanual\`下的Application即可开启后端。

测试端口：`localhost:8088`


`http test` 目录下存放着部分用于测试后端接口的请求文件，可以使用其进行接口测试



## 文件结构说明


``mapper`` ：存放对接mysql的具体数据库操作

``controller``： 前端请求的接口

``config``： 存放相关配置信息，我在这里存放了前后端跨域配置

``entity``：存放在数据库中无直接映射关系的实体

``model``：存放在数据库中有直接映射关系的实体

``service``：服务接口


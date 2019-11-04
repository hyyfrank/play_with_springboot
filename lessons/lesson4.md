1. mybatis with xml setting
2. 解决下IDEA里的pom.xml解析问题
File->Setting->Maven->Repositories->Update 更新下
选择Always update snapshot
maven的配置文件setting.xml加如下
```xml
<mirror>
      <id>nexus-aliyun</id>
      <mirrorOf>*</mirrorOf>
      <name>Nexus aliyun</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
```

* maven version should stay old 3.5.4
* constructor way instead of using autowire annotation on field
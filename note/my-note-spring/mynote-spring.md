# hello world

## 目录结构

```shell
laolang@laolang-PC:~/github/my-note/my-note-spring/note-spring-one$ tree
.
├── note-spring-one.iml
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── laolang
    │   │           └── notespring
    │   │               └── domain
    │   │                   └── User.java
    │   └── resources
    └── test
        ├── java
        │   └── com
        │       └── laolang
        │           └── notespring
        │               └── SpringHelloWorldTest.java
        └── resources
            ├── logback-test.xml
            └── spring-test-public.xml

14 directories, 6 files
laolang@laolang-PC:~/github/my-note/my-note-spring/note-spring-one$ 
```



## pom

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.laolang.note</groupId>
    <artifactId>note-spring-one</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- 集中定义依赖版本号 -->
    <properties>
        <!-- test -->
        <junit.version>4.10</junit.version>
        <hamcrest.version>1.3</hamcrest.version>

        <!-- spring -->
        <spring.version>4.2.0.RELEASE</spring.version>

        <!-- log -->
        <slf4j.version>1.7.12</slf4j.version>
        <logback.version>1.1.3</logback.version>
        <logback.ext.version>0.1.2</logback.ext.version>
    </properties>

    <dependencies>
        <!-- test -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-all</artifactId>
            <version>${hamcrest.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- Spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-oxm</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- logback -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>jcl-over-slf4j</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>${logback.version}</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>${logback.version}</version>
        </dependency>
        <dependency>
            <groupId>org.logback-extensions</groupId>
            <artifactId>logback-ext-spring</artifactId>
            <version>${logback.ext.version}</version>
        </dependency>
    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <!-- 资源文件拷贝插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.7</version>
                <configuration>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <!-- java编译插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <excludes>
                    <exclude>**/*.properties</exclude>
                    <exclude>**/*.xml</exclude>
                </excludes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
</project>
```

## logback-test.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<configuration>

    <property name="LOG_HOME" value="/home/laolang/projectpath/mynote/my-note-spring-one/log"/>
    <property name="LOG_FILE_NAME" value="my-note-spring-one-test-log"/>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <!-- encoder的默认实现类是ch.qos.logback.classic.encoder.PatternLayoutEncoder -->
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} -[%file]:[%line] - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="pullLog"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_HOME}/${LOG_FILE_NAME}.log</file>

        <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
            <fileNamePattern>${LOG_HOME}/${LOG_FILE_NAME}.%i.log.gz</fileNamePattern>
            <!-- 当归档文件超过三个后，覆盖最早的日志 -->
            <minIndex>1</minIndex>
            <maxIndex>500</maxIndex>
        </rollingPolicy>

        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <!-- 当文件超过500KB时进行压缩 -->
            <maxFileSize>10MB</maxFileSize>
        </triggeringPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} -[%file]:[%line] - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- show parameters for hibernate sql 专为 Hibernate 定制 -->
    <logger name="org.hibernate.type.descriptor.sql.BasicBinder"
            level="TRACE" />
    <logger name="org.hibernate.type.descriptor.sql.BasicExtractor"
            level="DEBUG" />
    <logger name="org.hibernate.SQL" level="DEBUG" />
    <logger name="org.hibernate.type" level="TRACE" />
    <logger name="org.hibernate.engine.QueryParameters" level="DEBUG" />
    <logger name="org.hibernate.engine.query.HQLQueryPlan" level="DEBUG" />


    <!-- name值可以是包名或具体的类名：该包（包括子包）下的类或该类将采用此logger -->
    <logger name="com.laolang" level="INFO" additivity="true">
        <appender-ref ref="pullLog"/>
    </logger>

    <!-- root的默认level是DEBUG -->
    <root level="DEBUG">
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="pullLog"/>
    </root>
</configuration>
```



## User

```java
package com.laolang.notespring.domain;

import java.util.Date;

public class User {


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private Integer id;

    private String userCode;

    private String nickName;

    private String pwd;

}

```

## test

```java
package com.laolang.notespring;

import com.laolang.notespring.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SpringHelloWorldTest {

    @Test
    public void helloworldTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-public.xml");
        User user = (User) context.getBean("user");
        assertNotNull(user);
    }
}

```

# 整合多个配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <import resource="classpath:spring-test-ioc-one.xml" />

</beans>
```

如果一个配置文件a.xml定义的bean引用了另一个配置文件b.xml定义的bean，那么不一定需要通过import引入b.xml，只要在spring启动时指定需要的配置文件列表即可。区别：

import : 如果引入了，那么相当于a.xml包含了a.xml和 b.xml两个文件的内容，此时只需要加载a.xml即可

否则就需要spring在内存中对两个配置文件进行合并

# IOC

## 注入方式

* 属性注入
* 构造函数注入
* 工厂方法注入



## 配置方式

* xml 配置
* 注解配置
* java代码配置
* groovy 配置
* 编码方式动态添加bean



## XML 属性注入

```xml
<bean id="user" class="com.laolang.notespring.domain.User">
    <property name="id" value="1001" />
    <property name="userCode" value="u1001" />
    <property name="nickName" value="小代码" />
    <property name="pwd" value="123456" />
</bean>
```

注意：

java允许以大写字母开头的属性变量名，但必须满足变量的前两个字母要么全部大写要么全部小写的要求

## XML 构造函数注入

构造函数

```java
public User(Integer id, String nickName, Integer age) {
    this.id = id;
    this.nickName = nickName;
    this.age = age;
}
```

xml配置 

```xml
<bean id="user2" class="com.laolang.notespring.domain.User">
    <constructor-arg index="0" value="1002" />
    <constructor-arg index="1" value="老狼" />
    <constructor-arg index="2" value="23" />
</bean>
```

constructor-arg 的属性

* index : 参数索引
* type : 参数类型
* value : 参数值
* ref : 引用另一个bean

如果两个构造函数的入参数目相同，则可以同时指定type和index

## XML工厂方法注入

### 静态工厂方法

工厂类

```java
package com.laolang.notespring.factory;

import com.laolang.notespring.domain.User;

public class UserStaticFactory {

    public static User createUser(){
        User user = new User();
        user.setId(1003);
        user.setNickName("laolang");
        return user;
    }

    public static User createUser( Integer id, String nickName ){
        User user = new User();
        user.setId(id);
        user.setNickName(nickName);
        return user;
    }
}

```

xml 配置

```xml
<!-- 无参的静态工厂注入 -->
<bean id="user3" class="com.laolang.notespring.factory.UserStaticFactory" factory-method="createUser" />
<!-- 带参数的静态工厂注入 -->
<bean id="user4" class="com.laolang.notespring.factory.UserStaticFactory" factory-method="createUser">
    <constructor-arg index="0" value="1004" />
    <constructor-arg index="1" value="xiaodaima" />
</bean>
```

### 非静态工厂方法

工厂

```java
package com.laolang.notespring.factory;

import com.laolang.notespring.domain.User;

public class UserFactory {

    public User createUser(){
        User user = new User();
        user.setId(1003);
        user.setNickName("laolang");
        return user;
    }

    public User createUser( Integer id, String nickName ){
        User user = new User();
        user.setId(id);
        user.setNickName(nickName);
        return user;
    }
}

```

xml配置

```xml
<!-- 工厂类 -->
<bean id="userFactory" class="com.laolang.notespring.factory.UserFactory" />
<!-- 无参工厂方法注入 -->
<bean id="user5" factory-bean="userFactory" factory-method="createUser" />
<!-- 带参数的工厂方法注入 -->
<bean id="user6" factory-bean="userFactory" factory-method="createUser">
    <constructor-arg index="0" value="1004" />
    <constructor-arg index="1" value="xiaodaima" />
</bean>
```

## 注入参数 

### 引用其他bean

```xml
<bean id="userInfo" class="com.laolang.notespring.domain.UserInfo">
    <property name="id" value="1001" />
    <property name="userId" value="1001" />
    <property name="info" value="user info" />
</bean>

<bean id="user7" class="com.laolang.notespring.domain.User" >
    <property name="id" value="1001" />
    <property name="userCode" value="u1001" />
    <property name="userInfo" ref="userInfo" />
</bean>
```

ref的属性：

bean :

local :

parent :

### null 值

```xml
<bean id="user8" class="com.laolang.notespring.domain.User">
    <property name="id" value="1001" />
    <property name="userCode" value="u1001" />
    <property name="userInfo"><null /></property>
</bean>
```

### Date 类型注入

参考：http://blog.csdn.net/u011165335/article/details/51029816

* 方式一：利用SimpleDateFormat的构造方法注入

```xml
<!-- 注入 date 类型 -->
<bean id="dateFormat" class="java.text.SimpleDateFormat">
    <constructor-arg value="yyyy-MM-dd" />
</bean>
<bean id="user4" class="com.laolang.sstudy.ioc.domain.User">
    <property name="birthday">
        <bean factory-bean="dateFormat" factory-method="parse">
            <constructor-arg value="1991-12-06" />
        </bean>
    </property>
</bean>
```

* 方式二：纯配置，先自定义CustomDateEditor，再转换类型

```xml
    <?xml version="1.0" encoding="UTF-8"?>  
    <beans xmlns="http://www.springframework.org/schema/beans"  
        xmlns:p="http://www.springframework.org/schema/p" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
        xsi:schemaLocation="  
            http://www.springframework.org/schema/beans   
            http://www.springframework.org/schema/beans/spring-beans.xsd">  
      
          
        <!-- 自定义日期编辑器 -->  
        <bean id="dateEditor"  
            class="org.springframework.beans.propertyeditors.CustomDateEditor">  
            <constructor-arg>  
                <bean class="java.text.SimpleDateFormat">  
                    <constructor-arg value="yyyy-MM-dd"></constructor-arg>  
                </bean>  
            </constructor-arg>  
            <constructor-arg value="true" />  
        </bean>  
        <!-- 使 Spring转换为java.util.Date -->  
        <bean class="org.springframework.beans.factory.config.CustomEditorConfigurer">  
            <property name="customEditors">  
                <map>  
                    <entry key="java.util.Date">  
                        <ref bean="dateEditor" />  
                    </entry>  
                </map>  
            </property>  
        </bean>  
    </beans>  
```

* 方式三：先用一个类重写PropertyEditorSupport的setAsText方法，再在配置文件中，配置转换类型就可以了，跟上面方法类似

```java
    public class MyDatePropertyEditor extends PropertyEditorSupport {  
        private String format;  
      
        public String getFormat() {  
            return format;  
        }  
      
        public void setFormat(String format) {  
            this.format = format;  
        }  
      
        // text为需要转换的值，当为bean注入的类型与编辑器转换的类型匹配时就会交给setAsText方法处理  
        public void setAsText(String text) throws IllegalArgumentException {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            try {  
                this.setValue(sdf.parse(text));  
            } catch (ParseException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
```

```xml
    <?xml version="1.0" encoding="UTF-8"?>  
    <beans xmlns="http://www.springframework.org/schema/beans"  
        xmlns:p="http://www.springframework.org/schema/p" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
        xsi:schemaLocation="  
            http://www.springframework.org/schema/beans   
            http://www.springframework.org/schema/beans/spring-beans.xsd">  
      
        <!--方式3：创建一个类 重写PropertyEditorSupport的setAsText方法 -->  
        <!-- 自定义日期编辑器 -->  
        <bean class="org.springframework.beans.factory.config.CustomEditorConfigurer">  
            <property name="customEditors">  <!--需要编辑的属性类型，是一个map -->  
                <map>  
                    <entry key="java.util.Date">  
                        <bean class="com.springDemo1.Date类型注入.MyDatePropertyEditor">  
                            <property name="format" value="yyyy-MM-dd" />  <!--注入需要转换的格式 -->  
                        </bean>  
                    </entry>  
                </map>  
            </property>  
        </bean>  
    </beans>  
```

### 级联属性

java类

```java
public UserInfo getInfo() {
    return info;
}

public void setInfo(UserInfo info) {
    this.info = info;
}

private UserInfo info = new UserInfo();
```

xml配置

```xml
<bean id="user9" class="com.laolang.notespring.domain.User">
    <property name="id" value="1001" />
    <property name="userCode" value="u1001" />
    <property name="info.userId" value="1001" />
    <property name="info.id" value="1001" />
    <property name="info.info" value="user info" />
</bean>
```

使用级联属性必须在生命属性时初始化，否则会抛出`NullValueInNestedPathException`异常

spring没有对级联的层数进行限制

## 注入集合类型

### List

java 代码

```xml
public List<String> getInfoList() {
    return infoList;
}

public void setInfoList(List<String> infoList) {
    this.infoList = infoList;
}

private List<String> infoList = new ArrayList<>();
```

xml配置

```xml
<bean id="user10" class="com.laolang.notespring.domain.User">
    <property name="infoList">
        <list>
            <value>info one</value>
            <value>info two</value>
            <value>info three</value>
        </list>
    </property>
</bean>
```

### Set

java 代码

```xml
public Set<String> getInfoSet() {
    return infoSet;
}

public void setInfoSet(Set<String> infoSet) {
    this.infoSet = infoSet;
}

private Set<String> infoSet = new HashSet<>();
```

xml 配置

```xml
<bean id="user11" class="com.laolang.notespring.domain.User">
    <property name="infoSet">
        <set>
            <value>info set one</value>
            <value>info set two</value>
            <value>info set three</value>
        </set>
    </property>
</bean>
```

### Map

java 代码

```java
public Map<String, String> getInfoMap() {
    return infoMap;
}

public void setInfoMap(Map<String, String> infoMap) {
    this.infoMap = infoMap;
}

private Map<String , String> infoMap;
```

xml配置

```xml
<bean id="user12" class="com.laolang.notespring.domain.User">
    <property name="infoMap">
        <bean class="java.util.HashMap">
            <constructor-arg>
                <map>
                    <entry key="info1" value="info map one" />
                    <entry key="info2" value="info map two" />
                    <entry key="info3" value="info map three" />
                </map>
            </constructor-arg>
        </bean>
    </property>
</bean>
```

### Properties

java 代码

```java
public Properties getEmails() {
    return emails;
}

public void setEmails(Properties emails) {
    this.emails = emails;
}

private Properties emails = new Properties();
```

xml 配置

```xml
<bean id="user13" class="com.laolang.notespring.domain.User">
    <property name="emails">
        <props>
            <prop key="jobMail">job@163.com</prop>
            <prop key="lifeMail">life@163.com</prop>
        </props>
    </property>
</bean>
```

### 集合合并

```xml
<bean id="user14" class="com.laolang.notespring.domain.User" abstract="true">
    <property name="infoList">
        <list>
            <value>info one</value>
            <value>info two</value>
            <value>info three</value>
        </list>
    </property>
</bean>
<bean id="user15" parent="user14">
    <property name="infoList">
        <list merge="true">
            <value>info four</value>
            <value>info five</value>
        </list>
    </property>
</bean>
<bean id="user16" parent="user14">
    <property name="infoList">
        <list merge="false">
            <value>info four</value>
            <value>info five</value>
        </list>
    </property>
</bean>
```

merge="true"指定子bean与bean中的同名值进行合并

merge="false"则不会和同名集合属性合并

### 使用util配置集合类型

```xml
<util:list id="infolist" list-class="java.util.ArrayList">
    <value>info one</value>
    <value>info two</value>
    <value>info three</value>
</util:list>

<bean id="user17" class="com.laolang.notespring.domain.User">
    <property name="infoList" ref="infolist" />
</bean>

<bean id="user18" class="com.laolang.notespring.domain.User">
    <property name="infoList">
        <util:list list-class="java.util.ArrayList">
            <value>info one</value>
            <value>info two</value>
            <value>info three</value>
        </util:list>
    </property>
</bean>
```

util:list和util:set支持value-type属性，指定集合中值的类型

util:map支持key-type和value-type属性，指定map的键和值的类型


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

## 方法注入

方法注入主要解决：通过一个singleton Bean获取一个prototype Bean时使用

```xml
<bean id="userEmail" class="com.laolang.notespring.domain.UserEmail" scope="prototype">
    <property name="id" value="1001" />
    <property name="userId" value="1001" />
    <property name="email" value="xiaodaima@163.com" />
</bean>

<bean id="userEmailLookup" class="com.laolang.notespring.domain.UserEmailLookup">
    <lookup-method name="getUserEmail" bean="userEmail" />
</bean>
```

以上配置与下面代码效果相同

```java
package com.laolang.notespring.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserEmailLookupByAware implements ApplicationContextAware {

    private ApplicationContext context;

    public UserEmail getUserEmail(){
        return (UserEmail) context.getBean("userEmail");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

```

注意：由于方法注入时spring需要用到CGLIB类包，所以需要加入相应的maven依赖

```xml
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>${cglib.versoin}</version>
</dependency>
```

## bean 之间依赖关系

### 继承

通过 bean 的 abstract 和 parent 属性

### 以来

如果没有使用ref建立对其他bean的依赖关系，那么可以通过bean的depends-on属性来指定依赖关系，保证所依赖的bean在该bean实例化之前创建好。可以如果依赖多个，则可以通过逗号、空格或分号分隔



## FactoryBean

如果bean的实例化比较复杂，使用传统的配置方式不够灵活，则可以通过编码的方式实现，需要实现`org.springframework.beans.factory.FactoryBean`工厂类接口

factorybean 实现类 

```java
package com.laolang.notespring.factory;

import com.laolang.notespring.domain.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {

    public String getUserInfo() {
        return userInfo;
    }

    // 接收逗号分隔的属性值
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    private String userInfo;

    // 实例化 bean
    @Override
    public User getObject() throws Exception {
        User user = new User();
        String[] infos = userInfo.split(",");
        user.setId(Integer.valueOf(infos[0]));
        user.setUserCode(infos[1]);
        user.setNickName(infos[2]);
        return user;
    }

    // 返回 bean 类型
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    // 通过该标示确定是否为单利
    @Override
    public boolean isSingleton() {
        return true;
    }
}

```

xml 配置 

```xml
<bean id="user19" class="com.laolang.notespring.factory.UserFactoryBean">
    <property name="userInfo" value="1001,u1001,xiaodaima" />
</bean>
```

测试

```java
@Test
public void factoryBeanTest() throws Exception {
    User user = (User) context.getBean("user19");
    User user2 = (User) context.getBean("user19");
    assertNotNull(user);
    assertNotNull(user2);
    assertEquals(true , user == user2 );
    // 获得对应的 FactoryBean 实例
    UserFactoryBean userFactoryBean = (UserFactoryBean) context.getBean("&user19");
    User user3 = userFactoryBean.getObject();
    assertNotNull(user3);
    // 此时手动调用则每次返回一个新的实例
    assertEquals(false , user == user3 );
}
```

## 基于注解的配置

spring 的注解包括：

@Componet

@Repository

@Service

@Controller

者四个注解功能相同，只是为了标注类本身的用途

### 配置扫描包

java 代码

```java
package com.laolang.notespring.po;

import org.springframework.stereotype.Component;

@Component
public class Student {

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
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

xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.laolang.notespring.po" />
</beans>
```

测试

```java
@Test
public void componetTest(){
    Student student = context.getBean(Student.class);
    assertNotNull(student);
}
```

扫描配置

resource-parrern

context:include-filter

context:excude-filter

## 基于java配置

## 基于groovy配置

## 通过编码方式动态添加bean

### 扩展自定义标签



## 读取外部属性文件

### 基本使用

属性文件

```properties
user.id=1001
user.nickName=xiaodaima
user.userCode=u1001
```

xml 配置

```xml
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <!-- 允许JVM参数覆盖 -->
    <property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE" />
    <!-- 忽略没有找到的资源文件 -->
    <property name="ignoreResourceNotFound" value="true" />
    <!--
    如果配置文件中定义了多个 PropertyPlaceholderConfigurer ，
    则通过该属性指定优先顺序， 默认值为：2147483647
    -->
    <property name="order" value="1" />
    <!-- 属性文件编码格式。spring使用操作系统默认编码读取属性文件 -->
    <property name="fileEncoding" value="utf-8" />
    <!-- 导入一个配置文件 -->
    <!--<property name="location" value="classpath:db-test.properties" />-->
    <!-- 导入多个配置文件 -->
    <property name="locations">
        <list>
            <value>classpath:db-test.properties</value>
        </list>
    </property>
</bean>
```

### 简单使用

```xml
<context:property-placeholder location="classpath:user-test.properties" />
```

### 基于注解使用

```java
package com.laolang.notespring.po;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DbInfo {

    public DbInfo() {
    }

    @Override
    public String toString() {
        return "DbInfo{" +
                "className='" + className + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Value("${db.className}")
    private String className;

    @Value("${db.username}")
    private String username;

    @Value("${db.pwd}")
    private String pwd;

    @Value("${db.url}")
    private String url;
}

```

### 使用加密属性文件

### 属性文件自身的引用

### 引用bean的属性值

## 国际化信息

## 容器事件

# aop 基础

## aop 概述 

aop是Aspect Oriented Programming的简称。aop 是有特定的应用场合的，它只适合那些具有横切逻辑的应用场合，如性能监控、访问控制、事务管理及日志记录。

## aop 术语

1. 连接点(Joinpoint)

特定点是程序执行的某个特定位置，如类开始初始化前、类初始化后、类的某个方法调用前/电泳后、方法抛出异常后。一个类或一段程序代码拥有的一些具有便捷性质的特定点，这些代码中的特定点就被称为链接点。

**spring仅支持方法的链接点，即仅能在方法调用前、方法调用后、方法跑出异常时及方法调用前后这些程序执行点织入增强。**

连接点由两个信息确定：

* 用方法表示的程序执行点
* 用相对位置表示的方位

spring 使用切点对执行点进行定位，而方位则在增强类型中定义

2. 切点(Pointcut)

每个程序类都拥有多个链接点，如一个拥有两个方法的类，则者两个方法都是连接点。aop通过切点定位特定的连接点。如果把连接点比作数据库中的数据，那么切点就相当于查询条件。切点和连接点是一对多的关系。

在spring中，切点通过`org.springframework.aop.Pointcut`接口描述，它使用类和方法作为连接点的查询条件，spring aop 的规则解析引擎负责解析切点所设定的查询条件，找到对应的连接点。

切点只能定位到某个方法上，如果希望定位到具体的连接点上，还需要提供方位信息。

3. 增强(Advice)

增强是织入目标类连接点上的一段程序代码。

在spring中，增强除用于描述一段程序代码外，还拥有另一个和连接点相关的信息：执行点的方位。结合执行点的方位信息和切点信息，就可以找到特定的链接。

4. 目标对象(Target)

增强逻辑的织入目标类。

5. 引介(Introduction)

引介是一种特殊的增强，它为类添加一些属性和方法。

6. 织入(Weaving)

织入是将增强添加到目标类的具体连接点上的过程。

aop的织入方式

* 编译期织入，者要求使用特殊的java编译器
* 类装载期织入，者要求使用特殊的类装载器
* 动态代理织入，在运行期为目标类添加增强生成子类的方式

**spring 采用动态代理织入，AspectJ采用编译期织入和类装载期织入**

7. 代理(Proxy)

一个类被aop织入增强后，就产生了一个结果类，它是融合了原类和增强逻辑的代理类。

根据不同的代理方式，代理类既可能是和原类具有相同接口的类，也可能是原类的子类，所以可以采用与调用原类相同的方式调用代理类。

8. 切面(Aspect)

切面由切点和增强（引介）组成，既包括横切的逻辑定义，也包括连接点的定义。

spring aop 就是负责实施切面的框架，它将切面所定义的横切逻辑织入切面所指定的连接点中。

aop 的工作中心在于如何将增强应用与目标对象的链接点上。者包括两项工作：

* 如何通过切点和增强定位到连接点上
* 如何在增强中编写切面的代码

## aop 的实现者

1. AspectJ

http://www.eclipse.org.aspectj

2. AspectWerkz
3. JBoss AOP

http://www.jboss.org/products/aop

4. Spring SOP

## 基础知识

spring aop使用了两种代理机制

* 基于JDK的动态代理
* 基于CGLIB的动态代理

原因：JDK本身只提供接口的代理，而不支持类的代理

### 带横切逻辑的实例

接口类

```java
package com.laolang.notespring.aopone;

public interface ForumService {

    void removeTopic( int topicId );

    void removeForum( int forumId );
}

```

实现类

```java
package com.laolang.notespring.aopone;

public class ForumServiceImpl implements ForumService{
    @Override
    public void removeTopic(int topicId) {
        // 开始对该方法进行性能监视
        PerformanceMonitor.begin("com.laolang.notespring.aopone.ForumServiceImpl. removeTopic");
        System.out.println("模拟删除Topic记录："+topicId);
        try{
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        // 结束对该方法的性能监视
        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        PerformanceMonitor.begin("com.laolang.notespring.aopone.ForumServiceImpl. removeForum");
        System.out.println("模拟删除Forum记录："+forumId);
        try{
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();

    }
}

```

性能监视类

```java
package com.laolang.notespring.aopone;

/**
 * 性能监视实现类
 */
public class PerformanceMonitor {

    // 通过一个ThreadLocal保存与调用线程相关的性能监视信息
    private static ThreadLocal<MethodPerformance> performanceThreadLocal = new ThreadLocal<MethodPerformance>();

    // 自动对某一目标方法的性能监视
    public static void begin(String method ){
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceThreadLocal.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        MethodPerformance mp = performanceThreadLocal.get();
        mp.printPerformance();
    }
}

```

记录性能监视信息类 

```java
package com.laolang.notespring.aopone;

/**
 * 记录性能监视信息
 */
public class MethodPerformance {

    private long begin;

    private long end;

    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod + " 花费 " + elapse + " 毫秒");
    }
}

```

测试

```java
package com.laolang.notespring.aopone;

import org.junit.Test;

public class ForumServiceTest {

    @Test
    public void forumServiceTest(){
        ForumService forumService = new ForumServiceImpl();
        forumService.removeTopic(10);
        forumService.removeForum(20);
    }
}

```

结果

```shell
begin monitor...
模拟删除Topic记录：10
end monitor...
com.laolang.notespring.aopone.ForumServiceImpl. removeTopic 花费 20 毫秒
begin monitor...
模拟删除Forum记录：20
end monitor...
com.laolang.notespring.aopone.ForumServiceImpl. removeForum 花费 20 毫秒
```

当某个方法需要进行性能监视时，必须调整方法代码。可以通过代理的方式将业务类方法中开启和结束性能监视的横切代码从业务类中完全移除



### 使用jdk动态代理

将实现类中的性能监视代码移除

```java
package com.laolang.notespring.aoptwo;

public class ForumServiceImpl implements ForumService{
    @Override
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录："+topicId);
        try{
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录："+forumId);
        try{
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

```

实现InvocationHandler接口

```java
package com.laolang.notespring.aoptwo;



import com.laolang.notespring.aopone.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

    // 被代理的目标对象
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 最终生成的代理示例，一般不会用到
     * @param method 被代理目标示例的某个具体方法，通过它可以发起目标示例方法的反射调用
     * @param args 被代理示例某个方法的入参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+". "+method.getName());
        Object obj = method.invoke(target,args);
        PerformanceMonitor.end();
        return obj;
    }
}

```

测试

```java
package com.laolang.notespring.aoptwo;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

    @Test
    public void forumServiceAopByJdkTest(){
        // 希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();

        // 根据编制了目标业务类逻辑和性能监视横切逻辑的InvocationHandler示例创建代理示例
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        // 调用代理实例
        proxy.removeTopic(10);
        proxy.removeForum(20);
    }
}

```



效果相同

### CGLIB动态代理 

代理创建器

```java
package com.laolang.notespring.aopthree;

import com.laolang.notespring.aopone.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy( Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(o.getClass().getName() + ". "+method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
        PerformanceMonitor.end();
        return result;
    }
}

```

测试

```java
package com.laolang.notespring.aopthree;


import com.laolang.notespring.aoptwo.ForumServiceImpl;
import org.junit.Test;

public class CglibProxyTest {

    @Test
    public void cglibTest(){
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(10);
        forumService.removeForum(20);
    }
}

```

效果

```shell
begin monitor...
模拟删除Topic记录：10
end monitor...
com.laolang.notespring.aoptwo.ForumServiceImpl$$EnhancerByCGLIB$$4a2aba90. removeTopic 花费 52 毫秒
begin monitor...
模拟删除Forum记录：20
end monitor...
com.laolang.notespring.aoptwo.ForumServiceImpl$$EnhancerByCGLIB$$4a2aba90. removeForum 花费 20 毫秒
```



### 小结

上面的代码需要改进的地方

* 目标类的所有方法都添加了性能监视横切逻辑
* 通过硬编码的方式制定了织入横切逻辑的织入点
* 手工编写代理实例的创建过程，无法通用

CGLIB性能比jdk高，但是创建时间比jdk长

对于singleton的代理对象或具有实例池的代理，因为无须频繁的创建代理对象，所以比较适合采用CGLIB，反之则采用jdk

## 创建增强类型

### 增强类型

spring 支持的5种类型的增强

* 前置增强：org.springframework.aop.BeforeAdvice。因为spring只支持犯法级的增强，所以MethodBeforeAdvice是目前可用的前置增强，表示在目标方法执行前实施增强，BeforeAdvice是为了将来版本扩展需要而定义的
* 后置增强：org.springframework.aop.AfterReturningAdive
* 环绕增强：org.aopallicance.intercept.MethodInterceptor
* 异常抛出增强：org.springframework.aop.ThrowsAdvice
* 引介增强：org.springramework.aop.IntroductionInterceptor，表示在目标类中添加一些新的方法和属性

### 前置增强

接口

```java
package com.laolang.notespring.aopfour;

public interface Waiter {

    void greetTo( String name );

    void serveTo( String name );
}

```

实现

```java
package com.laolang.notespring.aopfour;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to + " + name + " ...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to + " + name + " ...");
    }
}

```

增强

```java
package com.laolang.notespring.aopfour;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String) objects[0];
        System.out.println("How are you! Mr."+clientName+".");
    }
}

```

测试

```java
package com.laolang.notespring.aopfour;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class AdviceTest {


    @Test
    public void methodBeforeAdviceTest(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // spring 提供的代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置代理目标
        proxyFactory.setTarget(target);
        // 为代理目标添加增强
        proxyFactory.addAdvice(advice);

        // 生成代理实例
        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("xiaodaima");
        proxy.serveTo("laolang");

    }
}

```

如果通过ProxyFactory的setInterfaces(Class[] interfaces)方法指定目标进口进行代理，则使用JdkDynamicAopProxy，如果针对类代理，则使用Cglib2AopProxy。

此外，可以通过ProxyFactory.setOptimize(true)方法让ProxyFactory启动优化代理方式，这样针对几口的代理也会使用Cglib2AopProxy



xml配置

```xml
<bean id="greetingBeforeAdvice" class="com.laolang.notespring.aopfour.GreetingBeforeAdvice" />

<!-- 代理的目标对象 -->
<bean id="target" class="com.laolang.notespring.aopfour.NaiveWaiter" />

<bean id="waiter" class="org.springframework.aop.framework.ProxyFactoryBean">
    <!-- 代理要实现的接口 -->
    <property name="proxyInterfaces">
        <list>
            <value>com.laolang.notespring.aopfour.Waiter</value>
        </list>
    </property>
    <!-- 需要织入目标对象的Bean列表，调用配置顺序对应调用顺序 -->
    <property name="interceptorNames">
        <array>
            <value>greetingBeforeAdvice</value>
        </array>
    </property>
    <property name="target" ref="target" />

    <!-- 是否为单例，默认为 true  -->
    <!--<property name="singleton" value="true" />-->
    <!-- 设置为 true 时，强制使用CGLIB动态代理，对于singleton的代理，推荐使用CGLIB动态代理，其他作用域类型则使用JDK动态代理 -->
    <!--<property name="optimize" value="true" />-->
    <!-- 是否对类进行代理，当设置为true时，使用CGLIB动态代理 ，设置此属性后无须再设置 proxyInterfaces 属性，即使设置也会被忽略-->
    <!--<property name="proxyTargetClass" value="true" />-->
</bean>
```

测试

```xml
@Test
public void methodBeforeAdviceTest02(){
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
    Waiter waiter = (Waiter) context.getBean("waiter");
    waiter.greetTo("xiaodaima");
    waiter.serveTo("laolang");
}
```

### 后置增强

增强

```java
package com.laolang.notespring.aopfour;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}

```

xml 配置

```xml
<bean id="greetingBeforeAdvice" class="com.laolang.notespring.aopfour.GreetingBeforeAdvice" />
<bean id="greetingAfterAdvice" class="com.laolang.notespring.aopfour.GreetingAfterAdvice" />
<!-- 代理的目标对象 -->
<bean id="target" class="com.laolang.notespring.aopfour.NaiveWaiter" />

<bean id="waiter" class="org.springframework.aop.framework.ProxyFactoryBean">
    <!-- 代理要实现的接口 -->
    <property name="proxyInterfaces">
        <list>
            <value>com.laolang.notespring.aopfour.Waiter</value>
        </list>
    </property>
    <!-- 需要织入目标对象的Bean列表，调用配置顺序对应调用顺序 -->
    <property name="interceptorNames">
        <list>
            <value>greetingBeforeAdvice</value>
            <value>greetingAfterAdvice</value>
        </list>
    </property>
    <property name="target" ref="target" />

    <!-- 是否为单例，默认为 true  -->
    <!--<property name="singleton" value="true" />-->
    <!-- 设置为 true 时，强制使用CGLIB动态代理，对于singleton的代理，推荐使用CGLIB动态代理，其他作用域类型则使用JDK动态代理 -->
    <!--<property name="optimize" value="true" />-->
    <!-- 是否对类进行代理，当设置为true时，使用CGLIB动态代理 ，设置此属性后无须再设置 proxyInterfaces 属性，即使设置也会被忽略-->
    <!--<property name="proxyTargetClass" value="true" />-->
</bean>
```

### 环绕增强

增强

```java
package com.laolang.notespring.aopfour;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 目标方法入参
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];

        // 在目标方法执行前调用
        System.out.println("How are you! Mr." + clientName+".");

        // 通过反射机制调用目标方法
        Object o = methodInvocation.proceed();

        // 在目标方法执行后调用
        System.out.println("Please enjoy yourself!");

        return o;
    }
}

```

xml 配置

```xml
<bean id="greetingInterceptor" class="com.laolang.notespring.aopfour.GreetingInterceptor" />
<bean id="target2" class="com.laolang.notespring.aopfour.NaiveWaiter" />
<bean id="waiter2" class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="proxyInterfaces">
        <list>
            <value>com.laolang.notespring.aopfour.Waiter</value>
        </list>
    </property>
    <property name="interceptorNames">
        <list>
            <value>greetingInterceptor</value>
        </list>
    </property>
    <property name="target" ref="target2" />
</bean>
```

测试

```java
@Test
public void methodInterceptorTest(){
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
    Waiter waiter = (Waiter) context.getBean("waiter2");
    waiter.greetTo("laolang");
}
```

### 异常抛出增强

抛出异常的类

```java
package com.laolang.notespring.aopfour;

import java.sql.SQLException;

public class ForumService {

    public void removeForum( int forumId ){
        throw new RuntimeException("运行异常");
    }

    public void updateForum(Object o ) throws SQLException {
        throw new SQLException("数据库异常");
    }
}

```

增强

```java
package com.laolang.notespring.aopfour;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class TransactionManager implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e){
        System.out.println("-----------");
        System.out.println("method:"+method.getName());
        System.out.println("抛出异常："+e.getMessage());
        System.out.println("成功回滚事物");
    }
}

```

xml配置

```xml
<bean id="transactionManager" class="com.laolang.notespring.aopfour.TransactionManager" />
<bean id="forumServiceTarget" class="com.laolang.notespring.aopfour.ForumService" />
<bean id="forumService" class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="interceptorNames">
        <list>
            <value>transactionManager</value>
        </list>
    </property>
    <property name="target" ref="forumServiceTarget" />
    <!-- 使用CGLIB代理 -->
    <property name="proxyTargetClass" value="true" />
</bean>
```

测试

```java
@Test(expected = SQLException.class)
public void throsAdviceTest() throws SQLException {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
    ForumService forumService = (ForumService) context.getBean("forumService");
//        forumService.removeForum(1);
    forumService.updateForum(null);
}
```

ThrowsAdvice是一个标签接口，在运行期间spring使用反射机制自行判断，必须采用一下签名形式定义异常抛出的增强方法：

```java
void afterThrowing([Method method, Object[] args, Object target], Thrwoable)
```

前三个参数要么提供，要么不提供，最后一个是Throwable或其子类

### 引介增强

接口

```java
package com.laolang.notespring.aopfour;

public interface Monitorable {
    void setMonitorActive(boolean active);
}

```

实现 

```java
package com.laolang.notespring.aopfour;

import com.laolang.notespring.aopone.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    @Override
    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }

    /**
     * 拦截方法
     * @param mi
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object o = null;
        // 对于支持性能监视可控代理，通过判断其状态决定是否开启性能监控功能
        if( MonitorStatusMap.get() != null && MonitorStatusMap.get() ){
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            o = super.invoke(mi);
            PerformanceMonitor.end();
        }else{
            o = super.invoke(mi);
        }
        return o;
    }
}

```

xml 配置

```xml
<bean id="pmonitor" class="com.laolang.notespring.aopfour.ControllablePerformanceMonitor"/>
<bean id="forumServiceTarget2" class="com.laolang.notespring.aoptwo.ForumServiceImpl" />
<bean id="forumService2" class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="proxyInterfaces">
        <list>
            <value>com.laolang.notespring.aopfour.Monitorable</value>
        </list>
    </property>
    <property name="interceptorNames">
        <list>
            <value>pmonitor</value>
        </list>
    </property>
    <property name="target" ref="forumServiceTarget2" />
    <!-- 引介增强一定要通过创建子类来生成代理，所以需要强制使用CGLIB，否则会报错 -->
    <property name="proxyTargetClass" value="true" />
</bean>
```

测试

```java
@Test
public void delegatingIntroductionInterceptorTest(){
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
    com.laolang.notespring.aoptwo.ForumService forumService = (com.laolang.notespring.aoptwo.ForumService) context.getBean("forumService2");
    // 默认未开启性能监视功能
    forumService.removeTopic(10);
    forumService.removeForum(20);

    System.out.println("------------");

    // 开启性能监视功能
    Monitorable monitorable = (Monitorable) forumService;
    monitorable.setMonitorActive(true);

    forumService.removeTopic(10);
    forumService.removeForum(20);
}
```






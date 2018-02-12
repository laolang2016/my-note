package com.laolang.notespring;

import com.laolang.notespring.domain.User;
import com.laolang.notespring.domain.UserEmail;
import com.laolang.notespring.domain.UserEmailLookup;
import com.laolang.notespring.domain.UserEmailLookupByAware;
import com.laolang.notespring.factory.UserFactoryBean;
import com.laolang.notespring.po.DbInfo;
import com.laolang.notespring.po.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class SpringHelloWorldTest {

    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring-test-public.xml");
    }

    @Test
    public void helloworldTest(){
        User user = (User) context.getBean("user");
        assertNotNull(user);
    }

    @Test
    public void constructorIndexTest(){
        User user = (User) context.getBean("user2");
        assertNotNull(user);
    }

    @Test
    public void staticFactoryTest(){
        User u1 = (User) context.getBean("user3");
        assertNotNull(u1);
        User u2 = (User) context.getBean("user4");
        assertNotNull(u2);
    }

    @Test
    public void factoryTest(){
        User u1 = (User) context.getBean("user5");
        assertNotNull(u1);
        User u2 = (User) context.getBean("user6");
        assertNotNull(u2);
    }

    @Test
    public void refTest(){
        User user = (User) context.getBean("user7");
        assertNotNull(user);
        assertNotNull(user.getUserInfo());
    }

    @Test
    public void nullTest(){
        User user = (User) context.getBean("user8");
        assertNotNull(user);
        assertNull(user.getUserInfo());
    }

    @Test
    public void user9Test(){
        User user = (User) context.getBean("user9");
        assertNotNull(user);
        assertNotNull(user.getInfo());
        assertEquals("info.info","user info" , user.getInfo().getInfo());
    }

    @Test
    public void listTest(){
        User user = (User) context.getBean("user10");
        assertNotNull(user);
        assertNotNull(user.getInfoList());
        assertEquals("info one",user.getInfoList().get(0));
        assertEquals("info two",user.getInfoList().get(1));
        assertEquals("info three",user.getInfoList().get(2));
    }

    @Test
    public void setTest(){
        User user = (User) context.getBean("user11");
        assertNotNull(user);
        assertNotNull(user.getInfoSet());
        int i = 0;
        for (String info : user.getInfoSet() ){
            i++;
            switch (i){
                case 1 :{
                    assertEquals("info set one",info);
                    break;
                }
                case 2 :{
                    assertEquals("info set two",info);
                    break;
                }
                case 3 :{
                    assertEquals("info set three",info);
                    break;
                }
                default:{
                    fail();
                    break;
                }
            }
        }
    }

    @Test
    public void mapTest(){
        User user = (User) context.getBean("user12");
        assertNotNull(user);
        assertNotNull(user.getInfoMap());
        Iterator<String> iterator = user.getInfoMap().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            switch (key){
                case "info1" :{
                    assertEquals("info map one",user.getInfoMap().get(key));
                    break;
                }
                case "info2" :{
                    assertEquals("info map two",user.getInfoMap().get(key));
                    break;
                }
                case "info3" :{
                    assertEquals("info map three",user.getInfoMap().get(key));
                    break;
                }
                default:{
                    fail();
                    break;
                }
            }
        }
    }

    @Test
    public void proTest(){
        User user = (User) context.getBean("user13");
        assertNotNull(user);
        assertNotNull(user.getEmails());
        Iterator iterator = user.getEmails().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
            String key = entry.getKey();
            String val = entry.getValue();
            switch (key){
                case "jobMail":{
                    assertEquals("job@163.com",val);
                    break;
                }
                case "lifeMail":{
                    assertEquals("life@163.com",val);
                    break;
                }
                default:{
                    fail();
                    break;
                }
            }
        }
    }

    @Test
    public void mergerTrueTest(){
        User user = (User) context.getBean("user15");
        assertNotNull(user);
        assertNotNull(user.getInfoList());
        assertEquals(5,user.getInfoList().size());
        int i = 0;
        for ( String info : user.getInfoList() ){
            i++;
            switch (i){
                case 1 :{
                    assertEquals("info one",info);
                    break;
                }
                case 2 :{
                    assertEquals("info two",info);
                    break;
                }
                case 3 :{
                    assertEquals("info three",info);
                    break;
                }
                case 4 :{
                    assertEquals("info four",info);
                    break;
                }
                case 5 :{
                    assertEquals("info five",info);
                    break;
                }
                default:{
                    fail();
                    break;
                }
            }
        }
    }

    @Test
    public void mergerFalseTest(){
        User user = (User) context.getBean("user16");
        assertNotNull(user);
        assertNotNull(user.getInfoList());
        assertEquals(2,user.getInfoList().size());
        int i = 0;
        for ( String info : user.getInfoList() ){
            i++;
            switch (i){
                case 1 :{
                    assertEquals("info four",info);
                    break;
                }
                case 2 :{
                    assertEquals("info five",info);
                    break;
                }
                default:{
                    fail();
                    break;
                }
            }
        }
    }

    @Test
    public void utilListTest(){
        User user = (User) context.getBean("user17");
        assertNotNull(user);
        assertNotNull(user.getInfoList());
        assertEquals(3,user.getInfoList().size());
        int i = 0;
        for (String info : user.getInfoList() ){
            i++;
            switch (i){
                case 1 :{
                    assertEquals("info one",info);
                    break;
                }
                case 2 :{
                    assertEquals("info two",info);
                    break;
                }
                case 3 :{
                    assertEquals("info three",info);
                    break;
                }
                default:{
                    fail();
                    break;
                }
            }
        }
    }

    @Test
    public void utilListTest2(){
        User user = (User) context.getBean("user18");
        assertNotNull(user);
        assertNotNull(user.getInfoList());
        assertEquals(3,user.getInfoList().size());
        int i = 0;
        for (String info : user.getInfoList() ){
            i++;
            switch (i){
                case 1 :{
                    assertEquals("info one",info);
                    break;
                }
                case 2 :{
                    assertEquals("info two",info);
                    break;
                }
                case 3 :{
                    assertEquals("info three",info);
                    break;
                }
                default:{
                    fail();
                    break;
                }
            }
        }
    }

    @Test
    public void lookUpTest(){
        UserEmailLookup userEmailLookup = (UserEmailLookup) context.getBean("userEmailLookup");
        UserEmail email1 = userEmailLookup.getUserEmail();
        UserEmail email2 = userEmailLookup.getUserEmail();
        assertEquals(false,email1 == email2 );
    }

    @Test
    public void lookUpByAwareTest(){
        UserEmailLookupByAware userEmailLookupByAware = (UserEmailLookupByAware) context.getBean("userEmailLookupByAware");
        UserEmail email1 = userEmailLookupByAware.getUserEmail();
        UserEmail email2 = userEmailLookupByAware.getUserEmail();
        assertEquals(false,email1 == email2 );
    }

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

    @Test
    public void componetTest(){
        Student student = context.getBean(Student.class);
        assertNotNull(student);
    }

    @Test
    public void propertiesTest01(){
        User user = (User) context.getBean("user20");
        assertNotNull(user);

        assertNotNull(user.getId());
        assertEquals(true , 1001 == user.getId());

        assertNotNull(user.getNickName());
        assertEquals("xiaodaima",user.getNickName());

        assertNotNull(user.getUserCode());
        assertEquals("u1001",user.getUserCode());
    }

    @Test
    public void propertiesTest02(){
        DbInfo dbInfo = context.getBean(DbInfo.class);
        assertNotNull(dbInfo);

        assertNotNull(dbInfo.getClassName());
        assertEquals("mysql",dbInfo.getClassName());

        assertNotNull(dbInfo.getPwd());
        assertEquals("root",dbInfo.getPwd());

        assertNotNull(dbInfo.getUsername());
        assertEquals("root",dbInfo.getUsername());

        assertNotNull(dbInfo.getUrl());
        assertEquals("mysqlurl",dbInfo.getUrl());
    }


}


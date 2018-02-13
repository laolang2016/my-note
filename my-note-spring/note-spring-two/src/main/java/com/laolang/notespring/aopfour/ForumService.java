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

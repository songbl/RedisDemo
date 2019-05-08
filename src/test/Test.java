package test;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class Test {
   static JdbcTemplate template;
    public static void main(String args[]){
        String sql="update province set name = 'abc' where id=?";
        //1.声明成员变量 jdbctemplement
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        template.update(sql,2);
        //如上内容正常，连接Mysql没有问题

        final String sql2 = "select count(*) from province";
        int count = template.queryForObject(sql2, Integer.class);
        System.out.println("数据总数：" + count);
    }


}

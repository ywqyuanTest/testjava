package ywq.dr.chaptr.ywq.dr.chaptr.helper;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.log4j.spi.LoggerFactory;
import ywq.dr.chaptr.ywq.dr.chaptr.util.CollectionUtil;
import ywq.dr.chaptr.ywq.dr.chaptr.util.PropsUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by xm001 on 2016/3/11.
 */
public class DatabaseHelper {


    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DatabaseHelper.class);

    private static final BasicDataSource DATA_SOURCE;

    static {

        Properties conf = PropsUtil.LoadProps("config.properties");
        String driver = conf.getProperty("jdbc.driver");
        String url = conf.getProperty("jdbc.url");
        String username = conf.getProperty("jdbc.username");
        String password = conf.getProperty("jdbc.password");
        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(driver);
        DATA_SOURCE.setUrl(url);
        DATA_SOURCE.setUsername(username);
        DATA_SOURCE.setPassword(password);
    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() {
        Connection conn = CONNECTION_HOLDER.get();
        if (conn == null) {
            try {

                conn = DATA_SOURCE.getConnection();
            } catch (SQLException e) {

                LOGGER.error("get connection failure", e);
                throw  new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }
    /**
     *
     * 查询实体列表
     */
    public static<T> List<T> queryEntityList(Class<T> entityClass,Connection conn,String sql){

        List<T> entityList;
        try {
            entityList = QUERY_RUNNER.query(conn,sql,new BeanListHandler<T>(entityClass));
        }catch (Exception e){
            LOGGER.error("query entity list failure",e);
            throw new RuntimeException(e);
        }
        return  entityList;
    }
    /**
     *
     * 查询实体个数
     */

    public static <T> T queryEntity(Class<T> entityClass,String sql,Object params){
        T entity;
        Connection conn = getConnection();
        try{
            entity = QUERY_RUNNER.query(conn,sql,new BeanHandler<T>(entityClass),params);
        }catch (SQLException e){
            LOGGER.error("query entity failure ",e);
            throw new RuntimeException(e);
        }
        return  entity;
    }
    /**
     *
     * 执行查询语句
     */
    public static List<Map<String,Object>> executeQuery(String sql,Object params){
        List<Map<String,Object>> result;
        Connection conn = getConnection();
        try{
            result = QUERY_RUNNER.query(conn,sql,new MapListHandler(),params);

        }catch (Exception e){
            LOGGER.error("execute query failure",e);
            throw new RuntimeException(e);
        }
        return  result;
    }
    /**
     *
     * 执行更新语句
     */
    public static int executeUpdate(String sql,Object params){

        int rows = 0;
        Connection conn = getConnection();
        try {
            rows = QUERY_RUNNER.update(conn,sql,params);
        }catch (SQLException e){

            LOGGER.error("execute update failure",e);
            throw new RuntimeException(e);
        }
        return  rows;
    }
    /**
     *
     * 插入实体
     */
//    public static <T> boolean insertEntity(Class<T> entityClass,Map<String,Object> filedMap){
//        if(CollectionUtil.isEmpty(filedMap)){
//            LOGGER.error("can not insert entity:fieldMap is empty");
//            return false;
//        }
//        String sql = "Insert INTO"+getTableName(entityClass);
//        StringBuilder colummns = new StringBuilder("(");
//        StringBuilder values = new StringBuilder("(");
//    }
}

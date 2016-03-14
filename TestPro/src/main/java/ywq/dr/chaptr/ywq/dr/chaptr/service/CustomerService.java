package ywq.dr.chaptr.ywq.dr.chaptr.service;

import ywq.dr.chaptr.ywq.dr.chaptr.helper.DatabaseHelper;
import ywq.dr.chaptr.ywq.dr.chaptr.model.Customer;
import ywq.dr.chaptr.ywq.dr.chaptr.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xm001 on 2016/3/11.
 */
public class CustomerService {


    public List<Customer> getCustomerList(){

        //TODO
        Connection connection = null;

        try{


            String sql = "select *from customer";
            connection = DatabaseHelper.getConnection();
            return DatabaseHelper.queryEntityList(Customer.class,connection,sql);


        }finally {
           DatabaseHelper.closeConnection(connection);
        }
    }
    public Customer getCustomer(long id){

        //TODO
        return null;
    }
    public boolean createCustomer(Map<String,Object> filedMap){
        //TODO
        return true;
    }
    public boolean updateCustomer(long id,Map<String ,Object> filedMap){
        //TODO
        return false;
    }
    public boolean deleteCustomer(long id){
        //TODO
        return  false;
    }


}

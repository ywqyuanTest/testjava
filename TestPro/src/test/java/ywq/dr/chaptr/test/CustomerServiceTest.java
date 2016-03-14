package ywq.dr.chaptr.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import ywq.dr.chaptr.ywq.dr.chaptr.model.Customer;
import ywq.dr.chaptr.ywq.dr.chaptr.service.CustomerService;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Objects;

/**
 * 单元测试
 * Created by xm001 on 2016/3/11.
 */

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init(){
        //TODO初始化数据库
    }

    @Test
    public void getCustomerListTest() throws Exception{

        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{

        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    public void createCustomerTest() throws Exception{
        Map<String,Object> fieldMap = new HashMap<String,Object>();
        fieldMap.put("name","test1");
        fieldMap.put("contact","ywqyuan");
        fieldMap.put("telephone","18050197652");
        boolean reslut = customerService.createCustomer(fieldMap);
        Assert.assertTrue(reslut);
    }
    @Test
    public void updateCustomerTest() throws Exception{
        long id = 1;
        Map<String,Object> filedMap = new HashMap<String,Object>();
        filedMap.put("conntact","Fuck");
        boolean result = customerService.updateCustomer(id,filedMap);
        Assert.assertTrue(result);
    }
    public void deleteCustomerTest() throws Exception{
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }




}

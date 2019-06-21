package com.achihoang.service;

import com.achihoang.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl  implements CustomerService{
    private static Map<Integer, Customer> customers;

    static{
        customers=new HashMap<>();
        customers.put(1, new Customer(1,"Mai Van Hoan","1983-08-20","Ha noi",""));
        customers.put(2, new Customer(2,"Nguyen Van Nam","1983-08-21","Bac Giang",""));
        customers.put(3, new Customer(3,"Nguyen Thai Hoa","1983-08-22","Nam Dinh",""));
        customers.put(4, new Customer(4,"Tran Dang Khoa","1983-08-17","Ha Tay",""));
        customers.put(5, new Customer(5,"Nguyen Dinh Thi","1983-08-19","Ha noi",""));
    }
    @Override
    public List<Customer>findAll(){
        return new ArrayList<>(customers.values());
    }
}

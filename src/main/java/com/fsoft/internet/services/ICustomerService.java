package com.fsoft.internet.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fsoft.internet.entities.Customer;

public interface ICustomerService {
	
    List<Customer> selectAllCustomer();

    Map<String, String> saveCustomer(Customer customer);

    Customer selectCustomer(String id);

    Map<String, String> updateCustomer(Customer customer) throws SQLException;

    void deleteCustomer(String id) throws SQLException;

    List<Customer> searchCustomer(String name);


    
}

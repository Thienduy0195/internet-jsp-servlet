package com.fsoft.internet.services.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsoft.internet.entities.Customer;
import com.fsoft.internet.repositories.ICustomerRepository;
import com.fsoft.internet.repositories.impl.CustomerRepository;
import com.fsoft.internet.services.ICustomerService;

public class CustomerService implements ICustomerService {

    public static final String REGEX_CUSTOMER_ID ="^KH(\\-)[0-9]{4}$";
    public static final String REGEX_NAME = "^[\\p{Lu}\\p{Ll}\\s]+$";
    public static final String REGEX_NUMBER = "^[0-9]+$";
    public static final String REGEX_ID_CARD = "^[0-9]{9}$";
    public static final String REGEX_PHONE =   "^(84|0[3|5|7|8|9])+([0-9]{8})$"; //"^((\\(84\\)(\\+))|0)(90|91)+([0-9]{7})$";
    public static final String REGEX_EMAIL = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    ICustomerRepository customerRepository = new CustomerRepository();


    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAll();
    }

    @Override
    public Map<String, String> saveCustomer(Customer customer) {
        Map<String, String> map = new HashMap<>();
        if (!customer.getCustomerId().matches(REGEX_CUSTOMER_ID)) {
            map.put("customerId", "Invalid ID");
        }

        if (!customer.getName().matches(REGEX_NAME)) {
            map.put("name", "Invalid name");
        }
        if (!customer.getPhoneNumber().matches(REGEX_PHONE)) {
            map.put("phoneNumber", "Invalid phone number");
        }
        if (!customer.getEmail().matches(REGEX_EMAIL)){
            map.put("email", "Invalid email");
        }
        if (map.isEmpty()){
            customerRepository.save(customer);
        }
        return map;
    }

    @Override
    public Customer selectCustomer(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Map<String, String> updateCustomer(Customer customer) throws SQLException {
        Map<String, String> map = new HashMap<>();
        if (!customer.getCustomerId().matches(REGEX_CUSTOMER_ID)) {
            map.put("id", "Invalid ID");
        }

        if (!customer.getName().matches(REGEX_NAME)) {
            map.put("name", "Invalid name");
        }
        if (!customer.getPhoneNumber().matches(REGEX_PHONE)) {
            map.put("phone", "Invalid phone number");
        }
        if (!customer.getEmail().matches(REGEX_EMAIL)){
            map.put("email", "Invalid email");
        }
        if (map.isEmpty()){
            customerRepository.update(customer);
        }
        return map;
    }

    @Override
    public void deleteCustomer(String id) throws SQLException {
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> searchCustomer(String name) {
        return customerRepository.search(name);
    }


}
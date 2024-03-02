package com.fsoft.internet.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.internet.entities.Customer;
import com.fsoft.internet.repositories.BaseRepository;
import com.fsoft.internet.repositories.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository {

    private static final String SELECT_ALL_CUSTOMER = "select * from customer where deleteStatus = 0;";
    private static final String INSERT_CUSTOMER_SQL = "insert into customer values (?,?,?,?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where deleteStatus = 0 and customerId=?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set name=?, address = ?, phoneNumber = ?, email = ? where customerId = ?;";
    private static final String DELETE_CUSTOMER_SQL = "update customer set deleteStatus = 1 where customerId = ?;";
    private static final String SEARCH_CUSTOMER_SQL = "select * from customer where `customer_name` like ?;";
    
    private static Connection connection = null;

    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_CUSTOMER);
            Customer customer;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getString("customerId"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPhoneNumber(resultSet.getString("phoneNumber"));
                customer.setEmail(resultSet.getString("email"));
                customer.setDeleteStatus(resultSet.getInt("deleteStatus"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
        	connection = BaseRepository.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setInt(6, customer.getDeleteStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Customer findById(String id) {
        Customer customer = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(id);
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPhoneNumber(resultSet.getString("phoneNumber"));
                customer.setEmail(resultSet.getString("email"));
                customer.setDeleteStatus(resultSet.getInt("deleteStatus"));
                
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return customer;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getCustomerId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Customer> search(String name) {
        PreparedStatement preparedStatement = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            preparedStatement = BaseRepository.getConnection().prepareStatement(SEARCH_CUSTOMER_SQL);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                customer = new Customer();
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

}
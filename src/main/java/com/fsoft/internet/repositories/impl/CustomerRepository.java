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

    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static final String INSERT_CUSTOMER_SQL = "insert into customer values (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where id=?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday= ?, customer_gender=?, customer_id_card= ?, customer_phone = ?, customer_email = ?, customer_address=? where customer_id = ?;";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where id = ?;";
    private static final String SEARCH_CUSTOMER_SQL = "select * from customer where `customer_name` like ?;";
    
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_CUSTOMER);
            Customer customer;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getString("customer_id"));
//                customer.setCustomerType(resultSet.getInt("customer_type_id"));
//                customer.setCustomerName(resultSet.getString("customer_name"));
//                customer.setCustomerBirthDay(resultSet.getString("customer_birthday"));
//                customer.setCustomerGender(resultSet.getInt("customer_gender"));
//                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
//                customer.setCustomerPhone(resultSet.getString("customer_phone"));
//                customer.setCustomerEmail(resultSet.getString("customer_email"));
//                customer.setCustomerAddress(resultSet.getString("customer_address"));
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
            preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getCustomerId());
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
            preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(id);
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
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            preparedStatement.setString(9, customer.getCustomerId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = baseRepository.getConnection();
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
            preparedStatement = baseRepository.getConnection().prepareStatement(SEARCH_CUSTOMER_SQL);
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
package com.fsoft.internet.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.internet.entities.Customer;
import com.fsoft.internet.services.impl.CustomerService;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
		case "create":
			createCustomer(request, response);
			break;
		case "edit":
			editCustomer(request, response);
			break;
		case "delete":
			deleteCustomer(request, response);
			break;
		}
	}

	private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> errorsMap = new HashMap<>();
		String customerId = request.getParameter("customerId");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");

		Customer customer = customerService.selectCustomer(customerId);
		if (customer != null) {
			String message = "Customer id is exist!!";
			request.setAttribute("message", message);
			request.setAttribute("customer", customer);
			try {
				request.getRequestDispatcher("views/create-customer.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			customer = new Customer(customerId, name, address,
					phoneNumber, email, 0);
			errorsMap = customerService.saveCustomer(customer);
			if (errorsMap.isEmpty()) {
				try {
					response.sendRedirect("/customer");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("customer", customer);
				request.setAttribute("error", errorsMap);
				try {
					request.getRequestDispatcher("views/customer/create-customer.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
		String customerId = request.getParameter("customerId");
		Customer customer = customerService.selectCustomer(customerId);
		customer.setName( request.getParameter("name"));
		customer.setAddress( request.getParameter("address"));
		customer.setEmail( request.getParameter("email"));
		customer.setPhoneNumber( request.getParameter("phoneNumber"));
		Map<String, String> map;
		if (customer != null) {
			try {
				map = customerService.updateCustomer(customer);
				if (map.isEmpty()) {
					response.sendRedirect("/customer");
				} else {
					request.setAttribute("customer", customer);
					request.setAttribute("message", "Update failed!");
					request.setAttribute("error", map);
					try {
						request.getRequestDispatcher("view/edit-customer.jsp").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException | IOException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		String customerId = request.getParameter("customerId");
		try {
			customerService.deleteCustomer(customerId);
			List<Customer> customerList = customerService.selectAllCustomer();
			request.setAttribute("customers", customerList);
			request.getRequestDispatcher("views/customer/customer-list.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
		case "create":
			showCreateForm(request, response);
			break;
		case "edit":
			showEditForm(request, response);
			break;
		case "delete":
			break;
		case "search":
			searchUser(request, response);
			break;
		default:
			showList(request, response);
		}
	}

	private void showList(HttpServletRequest request, HttpServletResponse response) {

		List<Customer> customerList = customerService.selectAllCustomer();
		request.setAttribute("customers", customerList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/customer-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void searchUser(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("customerName");
		String searchName = name.replaceAll(" ", "");
		List<Customer> customerList = customerService.searchCustomer(searchName);
		String mess = "";
		if (customerList.isEmpty()) {
			mess = "Not found the searching name!";
		}
		request.setAttribute("customerList", customerList);
		request.setAttribute("mess", mess);
		try {
			request.getRequestDispatcher("view/customer.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
		String customerId = request.getParameter("customerId");
		Customer customer = customerService.selectCustomer(customerId);
		if (customer != null) {
			request.setAttribute("customer", customer);
			try {
				request.getRequestDispatcher("views/customer/edit-customer.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("views/customer/create-customer.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
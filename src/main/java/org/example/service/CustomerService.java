package org.example.service;

import org.example.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private static Map<String, Customer> customers = new HashMap<>();

    public CustomerService() {
    }

    public void addCustomers(String email, String firstName, String lastName) {
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String email){
        return customers.get(email);
    }

    public Customer getAllCustomers(){
        return (Customer) customers.values();
    }
}

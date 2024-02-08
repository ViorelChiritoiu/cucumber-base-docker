package com.cucumber.stepdefinitions;

import com.cucumber.objects.Customer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DataTableSteps {

/*    @DataTableType
    public Customer customerEntry(List<String> entry) {
        return new Customer(entry.get(0), entry.get(1));
    }*/

    @DataTableType
    public Customer customerEntry(Map<String, String> entry) {
        return new Customer(entry.get("username"), entry.get("password"));
    }

    @Given("my credentials srnh")
    public void myCredentialsSrnh(DataTable dataTable) {
        List<String> credentials = dataTable.values();
        System.out.println("Username: " + credentials.get(0));
        System.out.println("Password: " + credentials.get(1));
    }

    @Given("my credentials mrnh")
    public void myCredentialsMrnh(DataTable dataTable) {
        List<List<String>> credentials = dataTable.asLists();
        System.out.println("Username: " + credentials.get(0).get(0));
        System.out.println("Password: " + credentials.get(0).get(1));
        System.out.println("Username: " + credentials.get(1).get(0));
        System.out.println("Password: " + credentials.get(1).get(1));
    }

    @Given("my credentials dtt")
    public void myCredentialsDtt(List<Customer> customers) {
        System.out.println("Username: " + customers.get(0).getUsername());
        System.out.println("Password: " + customers.get(0).getPassword());
        System.out.println("Username: " + customers.get(1).getUsername());
        System.out.println("Password: " + customers.get(1).getPassword());
    }

/*    @Given("my credentials srwh")
    public void myCredentialsSrwh(List<List<String>> customers) {
        System.out.println("Username: " + customers.get(1).get(0));
        System.out.println("Password: " + customers.get(1).get(1));
    }*/

    @Given("my credentials srwh")
    public void myCredentialsSrwh(List<Map<String, String>> customers) {
        System.out.println("Username: " + customers.get(0).get("username"));
        System.out.println("Password: " + customers.get(0).get("password"));
    }

    @Given("my credentials mrwh")
    public void myCredentialsMrwh(List<Map<String, String>> customers) {
        System.out.println("Username: " + customers.get(0).get("username"));
        System.out.println("Password: " + customers.get(0).get("password"));
        System.out.println("Username: " + customers.get(1).get("username"));
        System.out.println("Password: " + customers.get(1).get("password"));
    }

    @Given("my credentials rwhdtt")
    public void myCredentialsRwhdtt(Customer customer) {
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Password: " + customer.getPassword());
    }

    @Given("my credentials scwnh")
    public void myCredentialsScwnh(List<String> customer) {
        System.out.println("Username: " + customer.get(0));
        System.out.println("Password: " + customer.get(1));
    }

    @Given("my credentials scwh")
    public void myCredentialsScwh(DataTable dataTable) {
        Map<String, String> customer = dataTable.asMap();
        System.out.println("Username: " + customer.get("username"));
        System.out.println("Password: " + customer.get("password"));
    }

    @Given("my credentials sgwnhdtt")
    public void myCredentialsSgwnhdtt(@Transpose Customer customer) {
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Password: " + customer.getPassword());
    }

    @Given("my credentials scwhdtt")
    public void myCredentialsScwhdtt(@Transpose Customer customer) {
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Password: " + customer.getPassword());
    }
}

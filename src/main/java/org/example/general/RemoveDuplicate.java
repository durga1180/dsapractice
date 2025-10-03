package org.example.general;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Customer c1 = new Customer(10,"Utkarsh");
        c1.setPhoneNum(10000);
        Customer c2 = new Customer(11, "Utkarsh");
        c1.setPhoneNum(99999);
        Customer c3 = new Customer(20, "Vedaansh");
        Set<Customer> customers = new HashSet<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        System.out.println(customers);
        Set<String> stringSet = new HashSet<>();
        List<Customer> filterCustomer = customers.stream().filter(c -> stringSet.add(c.getName()) ).collect(Collectors.toList());
        System.out.println(filterCustomer);
    }
}
class Customer {
    int age;
    String name;
    int phoneNum;

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String key() {
        return getAge()+"_"+getName();
    }
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

package com.myproject.introduction.accessmodfr2;

class Address2 {
    String city;
    String street;

    Address2(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address2{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}

class Student2 {
    int id;
    String name;
    Address2 address;

    Student2(int id, String name, Address2 address) {
        this.id = id;
        this.name = name;
        this.address = new Address2(address.city, address.street);
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

public class TestDeepCopy2 {
    static void main() {
        Address2 add = new Address2("San Fransisco", "Vancouver");
        Student2 st = new Student2(101, "Visper", add);
        System.out.println(st);
        System.out.println(add);

        st.id = 102;
        st.name = "Francis";
        st.address.city = "Seatle";
        st.address.street = "Moscow";

        System.out.println(st);
        System.out.println(add);
    }
}

package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
       /* Customer customer1 = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact1=new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        DataAdapter dataAdapter = new DataAdapter(customer1,contact1);

        //System.out.println(dataAdapter.getDialString());
        //System.out.println(dataAdapter.getContactFirstName());
        //System.out.println(dataAdapter.getContactLastName());
        //System.out.println(dataAdapter.getCompany());
        //System.out.println(dataAdapter.getCountryCode());*/

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCompany() {
           return this.customer.getCompanyName();
        }

        @Override
        public String getCountryCode() {
            String code = null;
            for (Map.Entry<String,String> p : countries.entrySet()) {
                if (p.getValue().equals(this.customer.getCountryName())) {
                    code = p.getKey();
                }
            }
            return code;
        }

        @Override
        public String getContactFirstName() {
            String[] n = this.contact.getName().split(" ");
            return n[1].trim();
        }

        @Override
        public String getContactLastName() {
            String[] n = this.contact.getName().split(", ");
            return n[0].trim();
        }

        @Override
        public String getDialString() {
            String[] sphone = contact.getPhoneNumber().split("\\(|\\)|-");
            return String.format("%s%s%s%s%s%s","callto://",sphone[0], sphone[1], sphone[2], sphone[3], sphone[4]);
        }

    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
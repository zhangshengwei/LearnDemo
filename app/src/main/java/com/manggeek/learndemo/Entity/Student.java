package com.manggeek.learndemo.Entity;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-18 21:19
 */
public class Student {

    private final String name;

    private final String age;

    private final String phone;

    private final String address;

    private Student(Builder builder){
        this.name=builder.name;
        this.address=builder.address;
        this.age=builder.age;
        this.phone=builder.phone;
    }

    public String getName() { return name; }

    public String getAge() { return age; }

    public String getPhone() { return phone; }

    public String getAddress() { return address; }

    public static class Builder{

        private final String name;

        private final String age;

        private  String phone;

        private  String address;

        public Builder(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public Builder phone(String phone){
            this.phone=phone;
            return this;
        }

        public Builder address(String address){
            this.address=address;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

    }

}

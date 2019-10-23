package com.rana.rough;

import java.util.Objects;

public class Employee implements Comparable{

    static class Stu{
        public String fName;
    }
    private String fName;
    private String lName;
    private String age;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fName, employee.fName) &&
                Objects.equals(lName, employee.lName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode");
        return Objects.hash(fName, lName, age);
    }

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee) o;
        return this.age.compareTo(((Employee) o).age);
    }
}

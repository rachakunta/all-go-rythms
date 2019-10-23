package com.rana.rough;

import java.util.HashSet;
import java.util.TreeSet;

public class EmployeeDriver {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee.Stu stu = new Employee.Stu();
        stu.fName = "27";
        String s1 = new String("5");
        String s4 = new String("9");
        String s3 = s1;
        String s2 = s1;
        /*System.out.println("s1 "+System.identityHashCode(s1 + "s"));
        System.out.println("s2 "+System.identityHashCode(s2));
        System.out.println("s3 "+System.identityHashCode(s3 + "s"));
        System.out.println("s4 "+System.identityHashCode(s4));
        System.out.println(s1.hashCode() + " "+s2.hashCode());
        System.out.println("....."+(s1 == s4));
        System.out.println(s1.equals(s2));*/
        e1.setAge(s1);
        Employee e2 = new Employee();
        e2.setAge(s4);
        TreeSet<Employee> set = new TreeSet<>();
        set.add(e1);
        set.add(e2);
        System.out.println(stu.fName);
        System.out.println(set.size());
        int div = 5/2;
        System.out.println("div  : "+ (double)div);
    }
}

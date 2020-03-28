package com.yh;

import java.util.Arrays;
import java.util.List;

class CourseLearningApplicationTests {

    public static void main(String[] args) {
        String[] str = {"admin", "dev", "student"};
        List<String> role = Arrays.asList(str);
        Arrays.asList(str);
        System.out.println(role);

        String str1 = "admin,dev,student";
        List<String> lis = Arrays.asList(str1.split(","));

        System.out.println(lis);

    }

}

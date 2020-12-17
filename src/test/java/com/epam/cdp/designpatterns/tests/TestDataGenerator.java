package com.epam.cdp.designpatterns.tests;

import com.epam.cdp.designpatterns.businessobjects.FilterTest;
import com.epam.cdp.designpatterns.businessobjects.TestLetter;
import com.epam.cdp.designpatterns.businessobjects.User;

public class TestDataGenerator {

    private User user;
    private TestLetter email;
    private FilterTest filter;

    public User getUser() {
        return user = new User("testalexnsk", "Uer89fd1982");
    }

    public TestLetter getEmail() {
        return email = TestLetter.getBuilder()
                .setEmail("achernyak82@mail.ru")
                .setSubject("testEmail")
                .setData("SOME DATA")
                .build();
    }

    public TestLetter getEmailToMyself() {
        return email = TestLetter.getBuilder()
                .setEmail("testalexnsk@mail.ru")
                .setSubject("TESTemail")
                .setData("SOMEDATA")
                .build();
    }

    public FilterTest getFilter() {
        return filter = new FilterTest("testemail");
    }
}

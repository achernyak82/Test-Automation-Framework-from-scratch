package com.epam.cdp.bdd.tests;

import com.epam.cdp.bdd.businessobjects.FilterTest;
import com.epam.cdp.bdd.businessobjects.TestLetter;
import com.epam.cdp.bdd.businessobjects.User;

public class TestDataGenerator {

    private User user;
    private TestLetter email;
    private FilterTest filter;

    public User getUser() {
        return user = new User("testalexnsk", "Uer89fd1982");
    }

    public TestLetter getEmail() {
        return email = new TestLetter("achernyak82@mail.ru", "testEmail", "SOME DATA");
    }

    public TestLetter getEmailToMyself() {
        return email = new TestLetter("testalexnsk@mail.ru", "TESTemail", "SOME DATA");
    }

    public FilterTest getFilter() {
        return filter = new FilterTest("testemail");
    }
}

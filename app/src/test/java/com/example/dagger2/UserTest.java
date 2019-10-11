package com.example.dagger2;

import com.example.dagger2.models.User;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user = new User();

    @Test
    public void validateUserNameAndAge() {
        user.setName("Teste");
        user.setAge(18);
        int expected = 0;
        int result = user.checkUser();
        assertEquals(expected, result);
    }

    @Test
    public void validateUserNameIsNull() {
        user.setName(null);
        user.setAge(18);
        int expected = -1;
        int result = user.checkUser();
        assertEquals(expected, result);
    }

    @Test
    public void validateUserAgeIsZero() {
        user.setName("Teste");
        user.setAge(0);
        int expected = -1;
        int result = user.checkUser();
        assertEquals(expected, result);
    }

    @Test
    public void validateUserNameIsNullAndAgeIsZero() {
        user.setName(null);
        user.setAge(0);
        int expected = -1;
        int result = user.checkUser();
        assertEquals(expected, result);
    }

    @Test
    public void validateGetUserNameAndAge() {
        user.setName("Teste");
        user.setAge(18);
        String expectedName = "Teste";
        int expectedAge = 18;

        String resultName = user.getName();
        int resultAge = user.getAge();

        assertEquals(expectedName, resultName);
        assertEquals(expectedAge, resultAge);
    }
}
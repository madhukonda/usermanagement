package com.rao.usermanagement.unit;

import com.rao.usermanagement.validations.PasswordValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PasswordValidatorTest {

    @Test
    public void testNormalPassword() throws InterruptedException {

        Thread.sleep(5000);
        assertTrue(PasswordValidator.validatePassword("454545@343Asa"));
        //Sort on length
        assertFalse(PasswordValidator.validatePassword("howto"));
    }

    @Test
    public void testForceNumeric() throws InterruptedException {

        //Contains numeric
        Thread.sleep(5000);
        assertTrue(PasswordValidator.validatePassword("454545@343Asa"));

        //No numeric
        assertFalse(PasswordValidator.validatePassword("howtodoinjava"));
    }

    @Test
    public void testForceCapitalLetter() throws InterruptedException {

        Thread.sleep(5000);

        assertTrue(PasswordValidator.validatePassword("454545@343Asa"));
        //No capital letter
        assertFalse(PasswordValidator.validatePassword("howtodoinjava"));
    }

    @Test
    public void testForceSpecialCharacter() throws InterruptedException {
        Thread.sleep(5000);
        assertTrue(PasswordValidator.validatePassword("454545@343Asa"));
        assertFalse(PasswordValidator.validatePassword("howtodoinjava"));
    }
}

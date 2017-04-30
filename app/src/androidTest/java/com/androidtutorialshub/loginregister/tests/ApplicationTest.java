package com.androidtutorialshub.loginregister.tests;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test_esto_siempre_pasa(){
        assertEquals("Hello World","Hello World");
    }
    public void test_esto_nunca_pasa(){
        assertEquals("Hello World","Hola Mundo");
    }
}
package com.androidtutorialshub.loginregister.tests;

import android.test.ApplicationTestCase;

import com.androidtutorialshub.loginregister.activities.Volley_Singleton;

import junit.framework.TestCase;

import static com.androidtutorialshub.loginregister.activities.Volley_Singleton.url_connect;

/**
 * Created by FERNANDO on 29/04/2017.
 */

public class PruebasHTTP extends TestCase {
    public void test_otra_prueba(){
        String url = Volley_Singleton.getUrl_connect()+"user_professor/new";
        assertEquals(true,url_connect);
        //assertNull(null);
    }

}

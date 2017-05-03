package com.androidtutorialshub.loginregister.tests;

import android.app.Application;
import android.test.ApplicationTestCase;
import com.androidtutorialshub.loginregister.activities.LoginActivity;

import static com.androidtutorialshub.loginregister.R.id.textInputEditTextEmail;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    LoginActivity test_LoginActivity;
    public ApplicationTest() {
        super(Application.class);
        test_LoginActivity = new LoginActivity();
    }


    public void test_esto_siempre_pasa(){
        assertEquals("Hello World","Hello World");
    }
    public void test_esto_nunca_pasa(){
        assertEquals("Hello World","Hola Mundo");
    }

    //public void login_valido(){assertEquals("mensaje",test_LoginActivity.login_usuario("Azurdia90","1234"));}
    public void usuario_invalido(){assertNull("");}

    public void contraseña_valida(){assertNotNull("");}
    public void contraseña_invalida(){assertNull("");}

    //private String login = LoginActivity.login_usuaro(String usuario, String contraseña);

}
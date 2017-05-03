package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.helpers.InputValidation;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

import org.json.JSONObject;

import java.util.HashMap;

/**********************************ADD TO CRISTIAN AZURDIA*****************************************/

/**************************************************************************************************/
public class LoginSuccessActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginSuccessActivity.this;

    private NestedScrollView nestedScrollView;



    private AppCompatButton appCompatButtonLogin;

   private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);


    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatButtonLogin.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                //verifyFromSQLite();
                //login_usuario(textInputEditTextEmail.getText().toString(),textInputEditTextPassword.getText().toString());
                break;
            case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    public void login_usuario(String usuario, String contraseña){
        String url =  Volley_Singleton.getUrl_connect()+"user_professor/list";
        HashMap<String,String> parametros = new HashMap();
        parametros.put("usuario",usuario);
        parametros.put("contrasenia",contraseña);

        JsonObjectRequest stringRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                new JSONObject(parametros),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Manejo de la respuesta
                        leer_objeto_json(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejo de errores
                        Log.i("Error:",error.toString());
                    }
                });
        Volley_Singleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    public void leer_objeto_json(JSONObject response){
        try{
            String respuesta = response.getString("mensaje");
            Toast toast = Toast.makeText(this, respuesta, Toast.LENGTH_SHORT);
            toast.show();
            if(respuesta.equals("usuario existente") == true){
                Intent accountsIntent = new Intent(activity, UsersListActivity.class);
                startActivity(accountsIntent);
            }else {
                //textInputEditTextEmail.setText("");
                //textInputEditTextPassword.setText("");
            }
            //Intent regresar = new Intent(LoginActivity.this,LoginActivity.class);
            //startActivity(regresar);
        }catch(Exception e){
            Toast toast = Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /***********************************************************************************************
     **************** CODIGO UTIILZADO PARA SQL LITE POR EL MOMENTO NO SE TRABAJARA EN EL***********
     **********************************************************************************************/

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */

    /**
     * This method is to empty all input edit text
     */

}

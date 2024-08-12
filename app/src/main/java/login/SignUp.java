package login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shameer.etree.R;
import com.shameer.etree.UserHelperClass;


public class SignUp extends AppCompatActivity {
    TextInputLayout regName, regUsername, regEmail, regPhone, regPassword;
    ImageView backBtn;
    Button button, regLoginButton, regbtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //hooks
        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
     //   regPhone = findViewById(R.id.reg_phone);
        regbtn = findViewById(R.id.login_button);
        button = findViewById(R.id.backlogin);
        backBtn = findViewById(R.id.back_pressed);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        String name = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        // String phoneNo = regPhone.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        //reference.setValue("this data have to store here");

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserHelperClass helperClass = new UserHelperClass(name, username, email, password);
                reference.child(name).setValue(helperClass);

            }
        });





        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }


        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp.super.onBackPressed();

            }
        });
    }


    private void login() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }


}
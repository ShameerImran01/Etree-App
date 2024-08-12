package login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.shameer.etree.R;
import com.shameer.etree.UserDashboard;

public class Login extends AppCompatActivity {
    ImageView backBtn;
    Button button , regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.Signup);
        button.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
        regbtn = findViewById(R.id.reg);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        backBtn = findViewById(R.id.login_back_button);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Login.super.onBackPressed();

            }
        });
    }

    private void login() {
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);

    }

    private void signUp() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
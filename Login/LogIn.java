package android.aitlindia.com.saddacanteen.Login;

import android.aitlindia.com.saddacanteen.Main.MainActivity;
import android.aitlindia.com.saddacanteen.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//View
public class LogIn extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText inputEmail, inputPassword;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loginPresenter = new LoginPresenter(this);

        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);

        findViewById(R.id.btnSignup).setOnClickListener(this);
        findViewById(R.id.btnLogin).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSignup:
                startActivity(new Intent(LogIn.this, MainActivity.class));
                finish();
                break;

            case R.id.btnLogin:
                if (loginPresenter.updateLogEmail(inputEmail.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (loginPresenter.updateLogPassword(inputPassword.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

        }
    }
}

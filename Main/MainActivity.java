package android.aitlindia.com.saddacanteen.Main;

import android.aitlindia.com.saddacanteen.Login.LogIn;
import android.aitlindia.com.saddacanteen.R;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//View
public class MainActivity extends AppCompatActivity implements MainView{

    private EditText email,password,fullname,username,phone;
    private Button signup;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mainPresenter = new MainPresenter(this);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        fullname = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        phone = (EditText) findViewById(R.id.phone);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( mainPresenter.updateFullName(fullname.getText().toString().trim()) ){
                    Toast.makeText(getApplicationContext(),"Enter Fullname !", Toast.LENGTH_SHORT).show();
                    return;
                }

                if( mainPresenter.updateUserName(username.getText().toString().trim()) ){
                    Toast.makeText(getApplicationContext(),"Enter UserName !",Toast.LENGTH_SHORT).show();
                    return;
                }

                if( mainPresenter.updateEmail(email.getText().toString().trim()) ){
                    Toast.makeText(getApplicationContext(),"Enter Email !",Toast.LENGTH_SHORT).show();
                    return;
                }

                if( mainPresenter.updatePassword(password.getText().toString().trim()) ){
                    Toast.makeText(getApplicationContext(),"Enter Password !",Toast.LENGTH_SHORT).show();
                    return;
                }

                if( mainPresenter.updatePhone(phone.getText().toString().trim()) ){
                    Toast.makeText(getApplicationContext(),"Enter phone !",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!mainPresenter.isEmailValid()) {
                    email.setError("Invalid Email Address");
                    return;
                }

                if(mainPresenter.passWordLength() < 6 ){
                    Toast.makeText(getApplicationContext(),"Entered Password is too short !",Toast.LENGTH_SHORT).show();
                     return;
                }


            }
        });

    }


}





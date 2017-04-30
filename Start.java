package android.aitlindia.com.saddacanteen;

import android.aitlindia.com.saddacanteen.Login.LogIn;
import android.aitlindia.com.saddacanteen.Main.MainActivity;
import android.aitlindia.com.saddacanteen.Navigation.LoadImageTask;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Start extends AppCompatActivity implements LoadImageTask.Listener {

    public static String IMAGE_URL;
    private Button deleteaccount, signout;
    private FirebaseAuth auth;
    private TextView email_text_view,name_text_view;
    private FirebaseAuth.AuthStateListener authListener;
    private ImageView imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        auth = FirebaseAuth.getInstance();
        signout = (Button) findViewById(R.id.signout);
        name_text_view = (TextView) findViewById(R.id.name_text_view);
        email_text_view = (TextView) findViewById(R.id.email_text_view);
        deleteaccount = (Button) findViewById(R.id.deleteaccount);

        imgUrl = (ImageView) findViewById(R.id.url);

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    Toast.makeText(Start.this,"you are log out",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Start.this, LogIn.class));
                    finish();
                }
              
              }
            };


        deleteaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Start.this, "Your profile is deleted:( Create a account now!",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Start.this, MainActivity.class));
                                        finish();

                                    } else {
                                        Toast.makeText(Start.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }

    //sign out method
    public void signOut() {
        auth.signOut();
    }


    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imgUrl.setImageBitmap(bitmap);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error Loading Image !", Toast.LENGTH_SHORT).show();
    }
}

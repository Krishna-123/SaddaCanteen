package android.aitlindia.com.saddacanteen.Navigation;

import android.aitlindia.com.saddacanteen.GoogleSignIn;
import android.aitlindia.com.saddacanteen.R;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, LoadImageTask.Listener {


    public static String IMAGE_URL;
    MenuItem item;
    private ImageView profile_image,profile_image1;
    private FirebaseAuth mAuth;
    private TextView email_text,name_text;
    private FirebaseAuth.AuthStateListener mAuthListener;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        item = (MenuItem) findViewById(R.id.action_navigation);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View view =  navigationView.getHeaderView(0);
        profile_image = (ImageView)view.findViewById(R.id.profile_image);
        profile_image1 = (ImageView)view.findViewById(R.id.profile_image1);
        name_text = (TextView)view.findViewById(R.id.name_text);
        email_text = (TextView)view.findViewById(R.id.email_text);
        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() == null){

                    startActivity(new Intent(Navigation.this,GoogleSignIn.class));

                    finish();
                }
                else{
                    if(firebaseAuth.getCurrentUser().getDisplayName() != null) {

                        IMAGE_URL = firebaseAuth.getCurrentUser().getPhotoUrl().toString();
                             new LoadImageTask(Navigation.this).execute(IMAGE_URL);
                        name_text.setText("HI " + firebaseAuth.getCurrentUser().getDisplayName().toString());
                        email_text.setText(firebaseAuth.getCurrentUser().getEmail().toString());
                    }
                }

            }
        };


    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
           // item.setIcon(R.drawable.back);

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        this.item = item;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_navigation) {
            if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                 drawer.closeDrawer(Gravity.RIGHT);

            }
            else {
                drawer.openDrawer(Gravity.RIGHT);
               // item.setIcon(R.drawable.next);

            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_signOut) {
            mAuth.signOut();
            Toast.makeText(this,"sign Out ",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        profile_image.setImageBitmap(bitmap);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error Loading Image !", Toast.LENGTH_SHORT).show();
    }
}

package android.aitlindia.com.saddacanteen.Main;

import android.graphics.PointF;

/**
 * Created by krishna on 19/4/17.
 */

public class MainModel {

    String fullName, userName, Email, Password, phone;

    void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    void setUserName(String userName)
    {
        this.userName = userName;
    }
    void setEmail(String Email)
    {
        this.Email = Email;
    }
    void setPassword(String Password)
    {
        this.Password = Password;
    }
    void setPhone(String phone)
    {
        this.phone = phone;
    }

   public String getEmail(){ return Email; }

    public String getPassword() {
        return Password;
    }
}

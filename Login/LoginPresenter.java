package android.aitlindia.com.saddacanteen.Login;

import static android.text.TextUtils.isEmpty;

/**
 * Created by krishna on 19/4/17.
 */

//Presenter
public class LoginPresenter {

    private LoginModel loginModel;
    private LoginView loginView;

    LoginPresenter(LoginView loginView) {
        loginModel = new LoginModel();
        this.loginView = loginView;
    }

    boolean updateLogEmail(String Email) {
        loginModel.setLogEmail(Email);
        return (isEmpty(Email));
    }

    boolean updateLogPassword(String Password) {
        loginModel.setLogPassword(Password);
        return (isEmpty(Password));
    }

}

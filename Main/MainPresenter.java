package android.aitlindia.com.saddacanteen.Main;

import android.text.TextUtils;

import static android.text.TextUtils.isEmpty;

/**
 * Created by krishna on 19/4/17.
 */

  class MainPresenter {
    MainModel mainModel;
    MainView mainView;

    MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }

    boolean updateFullName(String fullname) {
        mainModel.setFullName(fullname);

        return (isEmpty(fullname));

    }

    boolean updateUserName(String userName) {
        mainModel.setUserName(userName);

        return (isEmpty(userName));
    }

    boolean updateEmail(String Email) {
        mainModel.setEmail(Email);

        return (isEmpty(Email));
    }

    boolean updatePassword(String password) {
        mainModel.setPassword(password);

        return (isEmpty(password));
    }

    boolean updatePhone(String phone) {
        mainModel.setPhone(phone);

        return (isEmpty(phone));
    }

    boolean isEmailValid() {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mainModel.getEmail()).matches();
    }

    int passWordLength(){
        return mainModel.getPassword().length();
    }

}

package test.bwie.apple.jingdongproject.presenter;

import test.bwie.apple.jingdongproject.bean.LoginBean;
import test.bwie.apple.jingdongproject.model.IModel.ILoginModel;
import test.bwie.apple.jingdongproject.model.LoginModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.LoginView;

/**
 * Created by Apple on 2017/12/14.
 */

public class LoginPresenter {
    ILoginModel iLoginModel;
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        iLoginModel = new LoginModel();
    }
    public void dolp(String mobile,String password){
        iLoginModel.dologin(mobile, password, new OnNetListener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {

                loginView.showlogin(loginBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

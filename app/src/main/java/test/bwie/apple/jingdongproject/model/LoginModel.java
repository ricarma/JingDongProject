package test.bwie.apple.jingdongproject.model;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.jingdongproject.bean.LoginBean;
import test.bwie.apple.jingdongproject.model.IModel.ILoginModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/14.
 */

public class LoginModel implements ILoginModel{
    @Override
    public void dologin(String mobile, String password, final OnNetListener<LoginBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.loginbean(mobile, password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<LoginBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                onNetListener.onSuccess(loginBean);
            }
        });

    }
}

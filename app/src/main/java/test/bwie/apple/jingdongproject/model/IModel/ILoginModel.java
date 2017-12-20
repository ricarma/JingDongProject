package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.LoginBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/14.
 */

public interface ILoginModel {
    public void dologin(String mobile,String password,OnNetListener<LoginBean> onNetListener);
}

package test.bwie.apple.jingdongproject.presenter;

import android.util.Log;

import test.bwie.apple.jingdongproject.bean.RegBean;
import test.bwie.apple.jingdongproject.model.IModel.IRegModel;
import test.bwie.apple.jingdongproject.model.RegModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.RegView;

/**
 * Created by Apple on 2017/12/14.
 */

public class RegPrensenter {
    IRegModel iRegModel;
    RegView regView;

    public RegPrensenter(RegView regView) {
        this.regView = regView;
        iRegModel = new RegModel();
    }
    public void dorp(String mobile, String password){
        iRegModel.doreg(mobile, password, new OnNetListener<RegBean>() {
            @Override
            public void onSuccess(RegBean regBean) {
                String data = regBean.getCode();
                String msg = regBean.getMsg();
                regView.showreg(data,msg);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.SonBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/15.
 */

public interface ISonModel {
    public void doson(String pscid, OnNetListener<SonBean> onNetListener);
}

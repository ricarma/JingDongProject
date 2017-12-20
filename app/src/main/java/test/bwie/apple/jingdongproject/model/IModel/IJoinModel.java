package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.JoinBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/18.
 */

public interface IJoinModel {
    public void dojoin(String uid, String pid, String token, OnNetListener<JoinBean> onNetListener);
}

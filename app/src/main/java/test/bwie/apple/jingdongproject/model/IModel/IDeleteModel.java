package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.DeleteBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/18.
 */

public interface IDeleteModel {
    public void dodelete(String uid, String pid, String token, OnNetListener<DeleteBean> onNetListener);
}

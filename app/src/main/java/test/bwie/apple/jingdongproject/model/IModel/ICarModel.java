package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.CarBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/18.
 */

public interface ICarModel {
    public void docar(String uid, String token, OnNetListener<CarBean> onNetListener);
}

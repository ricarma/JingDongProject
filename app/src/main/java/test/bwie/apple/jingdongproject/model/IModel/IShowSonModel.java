package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.ShowSonBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/16.
 */

public interface IShowSonModel {
    public void doshowson(String pscid, OnNetListener<ShowSonBean> onNetListener);
}

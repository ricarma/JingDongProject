package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.RegBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/14.
 */

public interface IRegModel {
    public void doreg(String mobile,String password,OnNetListener<RegBean> onNetListener);
}

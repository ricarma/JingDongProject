package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.XiangQingBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/15.
 */

public interface IXiangQingModel {
    public void doxiangqing(String pid, OnNetListener<XiangQingBean> onNetListener);
}

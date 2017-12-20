package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/13.
 */

public interface IIndexModel {
    public void doindex(OnNetListener<IndexBean> onNetListener);
}
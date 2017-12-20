package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/13.
 */

public interface IDiffModel {
    public void dodiff(OnNetListener<DiffBean> onNetListener);
}

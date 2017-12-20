package test.bwie.apple.jingdongproject.model.IModel;

import test.bwie.apple.jingdongproject.bean.SearchBean;
import test.bwie.apple.jingdongproject.net.OnNetListener;

/**
 * Created by Apple on 2017/12/14.
 */

public interface ISearchModel {
    public void dosearch(String name,OnNetListener<SearchBean> onNetListener);
}

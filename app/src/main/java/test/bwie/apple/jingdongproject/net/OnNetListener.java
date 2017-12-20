package test.bwie.apple.jingdongproject.net;

import test.bwie.apple.jingdongproject.bean.IndexBean;

/**
 * Created by Apple on 2017/12/13.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onError(Exception e);
}

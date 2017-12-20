package test.bwie.apple.jingdongproject.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.jingdongproject.bean.XiangQingBean;
import test.bwie.apple.jingdongproject.model.IModel.IXiangQingModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/15.
 */

public class XiangQingModel implements IXiangQingModel {
    @Override
    public void doxiangqing(String pid, final OnNetListener<XiangQingBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.xiangqingbean(pid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<XiangQingBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.getMessage();
            }

            @Override
            public void onNext(XiangQingBean xiangQingBean) {
                onNetListener.onSuccess(xiangQingBean);
            }
        });
    }
}

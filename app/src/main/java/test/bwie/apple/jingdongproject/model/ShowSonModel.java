package test.bwie.apple.jingdongproject.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.jingdongproject.bean.ShowSonBean;
import test.bwie.apple.jingdongproject.model.IModel.IShowSonModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/16.
 */

public class ShowSonModel implements IShowSonModel{
    @Override
    public void doshowson(String pscid, final OnNetListener<ShowSonBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.showsonbean(pscid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ShowSonBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShowSonBean showSonBean) {
                onNetListener.onSuccess(showSonBean);
            }
        });
    }
}

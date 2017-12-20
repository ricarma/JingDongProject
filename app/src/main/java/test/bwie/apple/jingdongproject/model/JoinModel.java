package test.bwie.apple.jingdongproject.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.jingdongproject.bean.JoinBean;
import test.bwie.apple.jingdongproject.model.IModel.IJoinModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/18.
 */

public class JoinModel implements IJoinModel{
    @Override
    public void dojoin(String uid, String pid, String token, final OnNetListener<JoinBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.joinbean(uid,pid,token).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<JoinBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(JoinBean joinBean) {
                onNetListener.onSuccess(joinBean);
            }
        });
    }
}

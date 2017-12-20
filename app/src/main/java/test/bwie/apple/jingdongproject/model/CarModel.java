package test.bwie.apple.jingdongproject.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.jingdongproject.bean.CarBean;
import test.bwie.apple.jingdongproject.model.IModel.ICarModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/18.
 */

public class CarModel implements ICarModel{
    @Override
    public void docar(String uid, String token, final OnNetListener<CarBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.carbean(uid,token).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<CarBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CarBean carBean) {
                onNetListener.onSuccess(carBean);
            }
        });
    }
}

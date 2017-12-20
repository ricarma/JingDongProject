package test.bwie.apple.jingdongproject.model;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.model.IModel.IIndexModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/13.
 */

public class IndexModel implements IIndexModel {
    @Override
    public void doindex(final OnNetListener<IndexBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        Call<IndexBean> beanCall = serviceApi.indexbean();
        beanCall.enqueue(new Callback<IndexBean>() {
            @Override
            public void onResponse(Call<IndexBean> call, Response<IndexBean> response) {
                Log.i("Ttt",response.body().toString());
                onNetListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<IndexBean> call, Throwable t) {
                onNetListener.onError((Exception)t);
            }
        });
    }
}

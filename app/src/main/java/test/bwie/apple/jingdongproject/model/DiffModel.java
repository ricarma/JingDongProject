package test.bwie.apple.jingdongproject.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.model.IModel.IDiffModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/13.
 */

public class DiffModel implements IDiffModel {
    @Override
    public void dodiff(final OnNetListener<DiffBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        Call<DiffBean> diffbean = serviceApi.diffbean();
        diffbean.enqueue(new Callback<DiffBean>() {
            @Override
            public void onResponse(Call<DiffBean> call, Response<DiffBean> response) {
                onNetListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DiffBean> call, Throwable t) {
                onNetListener.onError((Exception)t);
            }
        });
    }
}

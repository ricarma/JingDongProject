package test.bwie.apple.jingdongproject.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.bwie.apple.jingdongproject.bean.SearchBean;
import test.bwie.apple.jingdongproject.model.IModel.ISearchModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.utils.RetrofitHelper;
import test.bwie.apple.jingdongproject.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/14.
 */

public class SearchModel implements ISearchModel {
    @Override
    public void dosearch(String name, final OnNetListener<SearchBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        Call<SearchBean> searchbean = serviceApi.searchbean(name);
        searchbean.enqueue(new Callback<SearchBean>() {
            @Override
            public void onResponse(Call<SearchBean> call, Response<SearchBean> response) {
                onNetListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SearchBean> call, Throwable t) {
                onNetListener.onError((Exception)t);
            }
        });
    }
}

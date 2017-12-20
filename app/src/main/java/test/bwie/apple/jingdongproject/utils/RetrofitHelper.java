package test.bwie.apple.jingdongproject.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Apple on 2017/12/13.
 */

public class RetrofitHelper {
    private static OkHttpClient client;
    private static ServiceApi serviceApi;
    static {
        initOk();
    }

    private static void initOk() {
        if (client==null){
            synchronized (RetrofitHelper.class){
                if (client==null){
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
                }
            }
        }
    }
    public static ServiceApi getServiceApi(){
        if (serviceApi==null){
            synchronized (ServiceApi.class){
                if (serviceApi==null){
                    serviceApi = RetrofitHelper.creatApi(ServiceApi.class,Api.HOST);
                }
            }
        }
        return serviceApi;
    }
    public static <T> T creatApi(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}

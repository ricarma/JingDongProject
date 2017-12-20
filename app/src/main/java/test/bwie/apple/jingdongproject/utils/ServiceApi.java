package test.bwie.apple.jingdongproject.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import test.bwie.apple.jingdongproject.bean.CarBean;
import test.bwie.apple.jingdongproject.bean.DeleteBean;
import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.bean.JoinBean;
import test.bwie.apple.jingdongproject.bean.LoginBean;
import test.bwie.apple.jingdongproject.bean.RegBean;
import test.bwie.apple.jingdongproject.bean.SearchBean;
import test.bwie.apple.jingdongproject.bean.ShowSonBean;
import test.bwie.apple.jingdongproject.bean.SonBean;
import test.bwie.apple.jingdongproject.bean.XiangQingBean;
import test.bwie.apple.jingdongproject.fragment.CarFragment;

/**
 * Created by Apple on 2017/12/13.
 */

public interface ServiceApi {
    //Index页面的Banner
    @GET(Api.INDEX_BANNER)
    Call<IndexBean> indexbean();

    //搜索
    @GET(Api.SEARCH)
    Call<SearchBean> searchbean(@Query("keywords") String name);

    //Index页面的分类
    @GET(Api.INDEX_DIFF)
    Call<DiffBean> diffbean();

    //注册
    @GET(Api.REG)
    Observable<RegBean> regbean(@Query("mobile")String mobile, @Query("password")String password);

    //登录
    @GET(Api.LOGIN)
    Observable<LoginBean> loginbean(@Query("mobile")String mobile, @Query("password")String password);

    //详情
    @GET(Api.XIANGQING)
    Observable<XiangQingBean> xiangqingbean(@Query("pid") String pid);

    //子类
    @GET(Api.SON)
    Observable<SonBean> sonbean(@Query("pscid")String pscid);

    //子类详情
    @GET(Api.SHOWSON)
    Observable<ShowSonBean> showsonbean(@Query("pscid")String pscid);

    //加入购物车
    @GET(Api.JOIN)
    Observable<JoinBean> joinbean(@Query("uid") String uid,@Query("pid")String pid,@Query("token") String token);

    //查询购物车
    @GET(Api.CAR)
    Observable<CarBean> carbean(@Query("uid") String uid,@Query("token")String token);

    //删除购物车
    @GET(Api.DELETE)
    Observable<DeleteBean> deletebean(@Query("uid") String uid,@Query("pid") String pid,@Query("token") String token);
}

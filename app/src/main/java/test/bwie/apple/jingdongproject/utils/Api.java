package test.bwie.apple.jingdongproject.utils;

/**
 * Created by Apple on 2017/12/13.
 */

public class Api {
    //共用接口
    public static final String HOST = "https://www.zhaoapi.cn/";
    //首页的banner条
    public static final String INDEX_BANNER = "ad/getAd?source=android";
    //首页的分类
    public static final String INDEX_DIFF = "product/getCatagory?source=android";
    //搜索框
    public static final String SEARCH = "product/searchProducts?source=android";
    //注册
    public static final String REG="user/reg?source=android";
    //登录
    public static final String LOGIN = "user/login?source=android";
    //详情
    public static final String XIANGQING = "product/getProductDetail?source=android";
    //子类
    public static final String SON = "product/getProductCatagory?source=android";
    //子类详情
    public static final String SHOWSON = "product/getProducts?source=android";
    //加入购物车
    public static final String JOIN = "product/addCart?source=android";
    //查询购物车
    public static final String CAR = "product/getCarts?source=android";
    //删除购物车
    public static final String DELETE = "product/deleteCart?source=android";
}


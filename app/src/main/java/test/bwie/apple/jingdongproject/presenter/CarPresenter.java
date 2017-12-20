package test.bwie.apple.jingdongproject.presenter;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.bean.CarBean;
import test.bwie.apple.jingdongproject.model.CarModel;
import test.bwie.apple.jingdongproject.model.IModel.ICarModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.CarView;

/**
 * Created by Apple on 2017/12/18.
 */

public class CarPresenter {
    ICarModel iCarModel;
    CarView carView;

    public CarPresenter(CarView carView) {
        this.carView = carView;
        iCarModel = new CarModel();
    }
    public void docp(String uid,String token){
        iCarModel.docar(uid, token, new OnNetListener<CarBean>() {
            @Override
            public void onSuccess(CarBean carBean) {
                List<CarBean.DataBean> dataBeans = carBean.getData();
                List<List<CarBean.DataBean.ListBean>> childlist = new ArrayList<List<CarBean.DataBean.ListBean>>();
                for (int i=0;i<dataBeans.size();i++){
                    List<CarBean.DataBean.ListBean> datas = dataBeans.get(i).getList();
                    childlist.add(datas);
                }
                carView.showcar(dataBeans,childlist);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

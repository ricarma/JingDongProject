package test.bwie.apple.jingdongproject.view.IView;

import java.util.List;

import test.bwie.apple.jingdongproject.bean.CarBean;

/**
 * Created by Apple on 2017/12/18.
 */

public interface CarView {
    public void showcar(List<CarBean.DataBean> grouplist,List<List<CarBean.DataBean.ListBean>> childlist);
}

package test.bwie.apple.jingdongproject.presenter;

import test.bwie.apple.jingdongproject.bean.ShowSonBean;
import test.bwie.apple.jingdongproject.model.IModel.IShowSonModel;
import test.bwie.apple.jingdongproject.model.ShowSonModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.ShowSonView;

/**
 * Created by Apple on 2017/12/16.
 */

public class ShowSonPresenter {
    IShowSonModel iShowSonModel;
    ShowSonView showSonView;

    public ShowSonPresenter(ShowSonView showSonView) {
        this.showSonView = showSonView;
        iShowSonModel = new ShowSonModel();
    }
    public void doss(String pscid){
        iShowSonModel.doshowson(pscid, new OnNetListener<ShowSonBean>() {
            @Override
            public void onSuccess(ShowSonBean showSonBean) {
                showSonView.showshowson(showSonBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

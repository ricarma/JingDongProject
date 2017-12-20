package test.bwie.apple.jingdongproject.presenter;

import test.bwie.apple.jingdongproject.bean.SonBean;
import test.bwie.apple.jingdongproject.model.IModel.ISonModel;
import test.bwie.apple.jingdongproject.model.SonModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.SonView;

/**
 * Created by Apple on 2017/12/15.
 */

public class SonPresenter {
    ISonModel iSonModel;
    SonView sonView;

    public SonPresenter(SonView sonView) {
        this.sonView = sonView;
        iSonModel = new SonModel();
    }
    public void dos(String pscid){
        iSonModel.doson(pscid, new OnNetListener<SonBean>() {
            @Override
            public void onSuccess(SonBean sonBean) {
                sonView.showson(sonBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

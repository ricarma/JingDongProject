package test.bwie.apple.jingdongproject.presenter;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.bean.JoinBean;
import test.bwie.apple.jingdongproject.bean.LoginBean;
import test.bwie.apple.jingdongproject.model.IModel.IJoinModel;
import test.bwie.apple.jingdongproject.model.JoinModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.JoinView;

/**
 * Created by Apple on 2017/12/18.
 */

public class JoinPresenter {
    IJoinModel iJoinModel;
    JoinView joinView;

    public JoinPresenter(JoinView joinView) {
        this.joinView = joinView;
        iJoinModel = new JoinModel();
    }
    public void dojp(final String uid, final String pid, final String token){
        iJoinModel.dojoin(uid, pid, token, new OnNetListener<JoinBean>() {
            @Override
            public void onSuccess(JoinBean joinBean) {
                joinView.showjoin(joinBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

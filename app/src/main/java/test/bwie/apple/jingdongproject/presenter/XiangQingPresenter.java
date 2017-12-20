package test.bwie.apple.jingdongproject.presenter;

import test.bwie.apple.jingdongproject.bean.XiangQingBean;
import test.bwie.apple.jingdongproject.model.IModel.IXiangQingModel;
import test.bwie.apple.jingdongproject.model.XiangQingModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.XiangQingView;

/**
 * Created by Apple on 2017/12/15.
 */

public class XiangQingPresenter {
    IXiangQingModel iXiangQingModel;
    XiangQingView xiangQingView;

    public XiangQingPresenter(XiangQingView xiangQingView) {
        this.xiangQingView = xiangQingView;
        iXiangQingModel = new XiangQingModel();
    }
    public void doxq(String pid){
        iXiangQingModel.doxiangqing(pid, new OnNetListener<XiangQingBean>() {
            @Override
            public void onSuccess(XiangQingBean xiangQingBean) {
                xiangQingView.showxiangqing(xiangQingBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

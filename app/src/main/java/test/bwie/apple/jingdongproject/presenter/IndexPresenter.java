package test.bwie.apple.jingdongproject.presenter;

import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.model.IModel.IIndexModel;
import test.bwie.apple.jingdongproject.model.IndexModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.IndexView;

/**
 * Created by Apple on 2017/12/13.
 */

public class IndexPresenter {
    IIndexModel iIndexModel;
    IndexView indexView;

    public IndexPresenter(IndexView indexView) {
        this.indexView = indexView;
        iIndexModel = new IndexModel();
    }
    public void dodo(){
        iIndexModel.doindex(new OnNetListener<IndexBean>() {
            @Override
            public void onSuccess(IndexBean indexBean) {
               // List<IndexBean> list = indexBean;
                indexView.show(indexBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

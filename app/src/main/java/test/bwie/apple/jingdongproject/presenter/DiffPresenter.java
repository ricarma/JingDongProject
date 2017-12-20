package test.bwie.apple.jingdongproject.presenter;

import java.util.List;

import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.model.DiffModel;
import test.bwie.apple.jingdongproject.model.IModel.IDiffModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.DiffView;

/**
 * Created by Apple on 2017/12/13.
 */

public class DiffPresenter {
    IDiffModel iDiffModel;
    DiffView diffView;

    public DiffPresenter(DiffView diffView) {
        this.diffView = diffView;
        iDiffModel = new DiffModel();
    }
    public void dodo2(){
        iDiffModel.dodiff(new OnNetListener<DiffBean>() {
            @Override
            public void onSuccess(DiffBean diffBean) {
                diffView.showdiff(diffBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

package test.bwie.apple.jingdongproject.presenter;

import test.bwie.apple.jingdongproject.bean.DeleteBean;
import test.bwie.apple.jingdongproject.model.DeleteModel;
import test.bwie.apple.jingdongproject.model.IModel.IDeleteModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.DeleteView;

/**
 * Created by Apple on 2017/12/18.
 */

public class DeletePresenter {
    IDeleteModel iDeleteModel;
    DeleteView deleteView;

    public DeletePresenter(DeleteView deleteView) {
        this.deleteView = deleteView;
        iDeleteModel = new DeleteModel();
    }
    public void dodp(String uid,String pid,String token){
        iDeleteModel.dodelete(uid, pid, token, new OnNetListener<DeleteBean>() {
            @Override
            public void onSuccess(DeleteBean deleteBean) {
                deleteView.showdelete(deleteBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

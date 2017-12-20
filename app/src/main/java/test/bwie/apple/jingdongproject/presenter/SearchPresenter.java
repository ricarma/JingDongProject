package test.bwie.apple.jingdongproject.presenter;

import java.util.List;

import test.bwie.apple.jingdongproject.bean.SearchBean;
import test.bwie.apple.jingdongproject.model.IModel.ISearchModel;
import test.bwie.apple.jingdongproject.model.SearchModel;
import test.bwie.apple.jingdongproject.net.OnNetListener;
import test.bwie.apple.jingdongproject.view.IView.SearchView;

/**
 * Created by Apple on 2017/12/14.
 */

public class SearchPresenter {
    ISearchModel iSearchModel;
    SearchView searchView;

    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
        iSearchModel = new SearchModel();
    }
    public void dofind(String name){
        iSearchModel.dosearch(name, new OnNetListener<SearchBean>() {
            @Override
            public void onSuccess(SearchBean searchBean) {
                List<SearchBean.DataBean> list = searchBean.getData();
                searchView.showsearch(list);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}

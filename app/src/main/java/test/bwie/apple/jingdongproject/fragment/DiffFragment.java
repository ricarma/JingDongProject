package test.bwie.apple.jingdongproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.adapter.Diff_Right_Adapter;
import test.bwie.apple.jingdongproject.adapter.ElvAdapter;
import test.bwie.apple.jingdongproject.adapter.LVAdapter;
import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.bean.SonBean;
import test.bwie.apple.jingdongproject.net.ImageLoaderHelper;
import test.bwie.apple.jingdongproject.presenter.DiffPresenter;
import test.bwie.apple.jingdongproject.presenter.SonPresenter;
import test.bwie.apple.jingdongproject.view.IView.DiffView;
import test.bwie.apple.jingdongproject.view.IView.SonView;
import test.bwie.apple.jingdongproject.view.ShowSonActivity;

/**
 * Created by Apple on 2017/12/12.
 */

public class DiffFragment extends Fragment implements DiffView,SonView{
    private LVAdapter lvadapter;
    private ListView lv;
    private DiffPresenter diffPresenter;
    private SonPresenter sonPresenter;
    private Diff_Right_Adapter adapter;
    private ElvAdapter elvAdapter;
    private ExpandableListView elv;
    private RecyclerView diffrv;
    private List<SonBean.DataBean.ListBean> listBeans = new ArrayList<>();
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<SonBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表数据
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diff, container, false);
        lv = view.findViewById(R.id.lv);
        elv = view.findViewById(R.id.elv);
        diffrv = view.findViewById(R.id.diffrv);
        Banner banner = view.findViewById(R.id.banner);
        banner.setImageLoader(new ImageLoaderHelper());
        //添加到Banner
        List<String> images = new ArrayList<>();
        images.add("http://img1.imgtn.bdimg.com/it/u=3622082173,2435093992&fm=27&gp=0.jpg");
        images.add("http://pic.pc6.com/up/2014-12/20141215171051.jpg");
        images.add("http://www.sgstad.com/UploadFile/jdlc.jpg");
        images.add("http://pic2.ooopic.com/11/59/56/04b1OOOPICb9.jpg");
        images.add("http://ww1.sinaimg.cn/large/6e687dfbjw1eipzbjxujej20a005kq3x.jpg");
        images.add("http://img.zcool.cn/community/017f9d5543af760000019ae9f3d17a.jpg");
        images.add("http://img4.imgtn.bdimg.com/it/u=495862939,1762558918&fm=214&gp=0.jpg");
        images.add("http://img.zcool.cn/community/0191105543a8060000019ae9e010f7.jpg@900w_1l_2o_100sh.jpg");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        diffPresenter = new DiffPresenter(this);
        diffPresenter.dodo2();
        sonPresenter = new SonPresenter(this);
        return view;
    }

    /**
     * 右边的列表
     * @param sonBean
     */
    @Override
    public void showson(SonBean sonBean) {
        groupList.clear();
        childList.clear();
        List<SonBean.DataBean> list = sonBean.getData();
        for (int i=0;i<list.size();i++){
            SonBean.DataBean dataBean = list.get(i);
            //拿到一级名字
            groupList.add(dataBean.getName());
            //拿到二级列表
            childList.add(dataBean.getList());
        }
        //循环拿到第一层
        elvAdapter = new ElvAdapter(getContext(),groupList,childList);
        elv.setAdapter(elvAdapter);
        for (int i=0;i<list.size();i++){
            elv.expandGroup(i);
        }
        //适配器点击事件
        adapter.setOnItemClickListener(new Diff_Right_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(SonBean.DataBean.ListBean listBean) {
                Intent intent = new Intent(getContext(), ShowSonActivity.class);
                //传值
                intent.putExtra("pscid",listBean.getPscid());
                //收值
                Intent it = getActivity().getIntent();
                //设值
                String uid = it.getStringExtra("uid");
                String token = it.getStringExtra("token");
                //传值
                intent.putExtra("uid",uid);
                intent.putExtra("token",token);
                getContext().startActivity(intent);
            }
        });
    }

    /**
     * 左边的列表
     * @param diffBean
     */
    @Override
    public void showdiff(DiffBean diffBean) {
        List<DiffBean.DataBean> list = diffBean.getData();
        lvadapter = new LVAdapter(list,getContext());
        lv.setAdapter(lvadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DiffBean.DataBean dataBean = (DiffBean.DataBean) adapterView.getItemAtPosition(i);
                int pscid = dataBean.getCid();
                sonPresenter.dos(pscid+"");
            }
        });
    }
}

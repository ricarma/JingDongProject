package test.bwie.apple.jingdongproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.adapter.GVAdapter;
import test.bwie.apple.jingdongproject.adapter.IndexMSAdapter;
import test.bwie.apple.jingdongproject.adapter.RVAdapter;
import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.bean.XiangQingBean;
import test.bwie.apple.jingdongproject.net.ImageLoaderHelper;
import test.bwie.apple.jingdongproject.presenter.DiffPresenter;
import test.bwie.apple.jingdongproject.presenter.IndexPresenter;
import test.bwie.apple.jingdongproject.presenter.XiangQingPresenter;
import test.bwie.apple.jingdongproject.view.IView.DiffView;
import test.bwie.apple.jingdongproject.view.IView.IndexView;
import test.bwie.apple.jingdongproject.view.IView.XiangQingView;
import test.bwie.apple.jingdongproject.view.MainActivity;
import test.bwie.apple.jingdongproject.view.SearchActivity;
import test.bwie.apple.jingdongproject.view.XiangQingActivity;
import test.bwie.apple.jingdongproject.widget.NoticeView;

/**
 * Created by Apple on 2017/12/12.
 */

public class IndexFragment extends Fragment implements IndexView,DiffView {
    //扫一扫
    private ImageView sao;
    //详情p层
    private XiangQingPresenter xiangQingPresenter;
    //主页面分类适配器
    private GVAdapter gvadapter;
    private ViewPager vp;
    private GridView gridview;
    //主界面秒杀适配器
    private IndexMSAdapter indexMSAdapter;
    private GridView shgv;
    //主页面banne
    private IndexPresenter indexPresenter;
    //主页面分类
    private DiffPresenter diffPresenter;
    //banner图片集合
    private List<String> images = new ArrayList<String>();
    //装2个fragment集合
    private List<Fragment> flist = new ArrayList<Fragment>();
    private VpFragment1 vpFragment1;
    private VpFragment2 vpFragment2;
    //轮播图
    private Banner banner;
    //推荐布局
    private RecyclerView rv;
    //推荐适配器
    private RVAdapter rvAdapter;
    //搜索框
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        //秒杀
        shgv = view.findViewById(R.id.hsgv);
        //轮播
        banner = view.findViewById(R.id.banner);
        //分类
        vp = view.findViewById(R.id.vp);
        rv = view.findViewById(R.id.rv);

        //扫一扫
        sao = view.findViewById(R.id.iv_sao);
        sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.initiateScan();
            }
        });
        //搜索
        editText = view.findViewById(R.id.et_sousuo);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(ii);
            }
        });
        //布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rv.setLayoutManager(gridLayoutManager);
        vpFragment1 = new VpFragment1();
        vpFragment2 = new VpFragment2();
        flist.add(vpFragment1);
        flist.add(vpFragment2);
        //主页面Banner
        indexPresenter = new IndexPresenter(this);
        indexPresenter.dodo();
        //主页面分类
        diffPresenter = new DiffPresenter(this);
        diffPresenter.dodo2();
        NoticeView noticeView = (NoticeView) view.findViewById(R.id.notice_view);
        List<String> notices = new ArrayList<>();
        notices.add("大促销下单拆福袋，亿万新年红包随便拿");
        notices.add("家电五折团，抢十亿无门槛现金红包");
        notices.add("星球大战剃须刀首发送200元代金券");
        noticeView.addNotice(notices);
        noticeView.startFlipping();
        return view;
    }

    //二维码
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            String result = scanResult.getContents();
            Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 展示Banner
     * 展示秒杀
     * 展示为你推荐
     * @param indexBean
     */
    @Override
    public void show(IndexBean indexBean) {
        List<IndexBean.DataBean> list = indexBean.getData();
        for (int i = 0; i < list.size(); i++) {
            String image = list.get(i).getIcon();
            images.add(image);
        }
        banner.setImageLoader(new ImageLoaderHelper());
        banner.setImages(images);
        banner.start();
        List<IndexBean.MiaoshaBean.ListBeanX> xList = indexBean.getMiaosha().getList();
        indexMSAdapter = new IndexMSAdapter(xList, getContext());
        shgv.setAdapter(indexMSAdapter);
        List<IndexBean.TuijianBean.ListBean> listBeans = indexBean.getTuijian().getList();
        rvAdapter = new RVAdapter(getContext(), listBeans);
        rv.setAdapter(rvAdapter);
        rvAdapter.setOnItemClickListener(new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClieck(String str) {
                //Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getContext(), XiangQingActivity.class);
                Intent intent = getActivity().getIntent();
                String uid = intent.getStringExtra("uid");
                String token = intent.getStringExtra("token");
                it.putExtra("token",token);
                it.putExtra("uid",uid);
                it.putExtra("pid", str);
                getContext().startActivity(it);
            }
        });
    }
    //展示主页分类
    @Override
    public void showdiff(DiffBean diffBean) {
        vp.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return flist.get(position);
            }

            @Override
            public int getCount() {
                return flist.size();
            }
        });
    }
}

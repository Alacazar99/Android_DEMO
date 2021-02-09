package com.example.helloword;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.helloword.RecyclerView.GridOneRecyclerViewAdapter;
import com.example.helloword.RecyclerView.GridTwoRecyclerViewAdapter;
import com.example.helloword.RecyclerView.StaggeredRecyclerAdapter;
import com.example.helloword.WebView.LunBoActivity;
import com.example.helloword.WebView.ViewPagerAdapter;
import com.example.helloword.WebView.WebViewActivity;
import com.example.helloword.customFunc.ImageViewRoundCystom;
import com.example.helloword.myAdapter.lunBoViewPager;
import com.example.helloword.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    private androidx.recyclerview.widget.RecyclerView myRecyclerStaggered;
    private Button mBtnUi,mSharedPre,banner,btnEvent;
    public static Intent intent;
    private LinearLayout mAinmation,mLinearLayout;
    private FragmentTabHost tabHost;
    private Toolbar toolbar;
    private ViewPager viewPager;

    // 轮播图广告 图片资源；
    private int[] img = new int[]{
            R.drawable.ad1,
            R.drawable.ad2,
            R.drawable.ad3,
            R.drawable.ad4
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "轮播1",
            "轮播2",
            "轮播3",
            "轮播4",
            "轮播5"
    };
    private TextView title;
    // 自动滚动；
    private Handler mHandler = new Handler();


    private View inflate;
    private FrameLayout frameLayoutViewPager;

    private androidx.recyclerview.widget.RecyclerView mGridRecycler;
    private androidx.recyclerview.widget.RecyclerView mGridRecycler2;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.Adapter mAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mLayoutManager2;

    private ViewPager mViewPager;
    private TextView mTvPagerTitle;
    private Button imageViewCustom;

    private List<ImageView> mImageList;//轮播的图片集合
    private String[] mImageTitles;//标题集合
    private int[] imageRess; // 图片资源集合；
    private int previousPosition = 0;//前一个被选中的position
    private List<View> mDots;//小点

    private boolean isStop = false;//线程是否停止
    private static int PAGER_TIOME = 5000;//间隔时间

    // 在values文件假下创建了pager_image_ids.xml文件，并定义了4张轮播图对应的id，用于点击事件
    private int[] imgae_ids = new int[]{R.id.pager_image1,R.id.pager_image2,R.id.pager_image3,R.id.pager_image4};

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//加上这句话，menu才会显示出来

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_main, container, false);
        // 定位布局中的按钮;
        initOnClick();

        // 初始化ToolBar;
        initToolBar();

        // 轮播图设置；
        init();

        // 初始化网格布局；
//        initData();
//        initView();

        // 初始化瀑布流布局；
        initStaggeredData();
        initStaggeredView();


        return inflate;
    }
    /**
     * 第一步、初始化控件
     */
    public void init() {
        mViewPager = (ViewPager) inflate.findViewById(R.id.lunboviewPager);
        mTvPagerTitle = (TextView) inflate.findViewById(R.id.tv_pager_title);
        initCarouselMapData();//初始化数据
        initCarouselMapView();//初始化View，设置适配器
        autoPlayView();//开启线程，自动播放
    }
    /**
     * 第二步、初始化数据（图片、标题、点击事件）
     */
    public void initCarouselMapData() {
        //初始化标题列表和图片
        mImageTitles = new String[]{"情人节礼物！", "游遍世界", "存钱", "HAPPY PARTY"};
        imageRess = new int[]{R.drawable.ad1, R.drawable.ad2, R.drawable.ad3, R.drawable.ad4};

        //添加图片到图片列表里
        mImageList = new ArrayList<>();
        ImageView iv;
        for (int i = 0; i < imageRess.length; i++) {
            iv = new ImageView(getActivity());
            iv.setBackgroundResource(imageRess[i]);//设置图片
            iv.setId(imgae_ids[i]);//顺便给图片设置id
            iv.setOnClickListener(new MainFragment.pagerImageOnClick());//设置图片点击事件
            mImageList.add(iv);
        }
        //添加轮播点
        LinearLayout linearLayoutDots = (LinearLayout) inflate.findViewById(R.id.lineLayout_dot);
        mDots = addDots(linearLayoutDots, fromResToDrawable(getActivity(), R.drawable.lunbopoints), mImageList.size());//其中fromResToDrawable()方法是我自定义的，目的是将资源文件转成Drawable
    }
    //图片点击事件
    private class pagerImageOnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.pager_image1:
                    Toast.makeText(getActivity(), "图片1被点击", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.pager_image2:
                    Toast.makeText(getActivity(), "图片2被点击", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.pager_image3:
                    Toast.makeText(getActivity(), "图片3被点击", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.pager_image4:
                    Toast.makeText(getActivity(), "图片4被点击", Toast.LENGTH_SHORT).show();
                    break;
            }
            ToastUtil.showMsg(getActivity(),"轮播图放大！！");
            intent = new Intent(getActivity(), LunBoActivity.class);
            startActivity(intent);
        }
    }
    /**
     *  第三步、给PagerViw设置适配器，并实现自动轮播功能
     */
    public void initCarouselMapView(){
        com.example.helloword.WebView.ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(mImageList, mViewPager);
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //伪无限循环，滑到最后一张图片又从新进入第一张图片
                int newPosition = position % mImageList.size();
                // 把当前选中的点给切换了, 还有描述信息也切换
                mTvPagerTitle.setText(mImageTitles[newPosition]);//图片下面设置显示文本
                //设置轮播点
                LinearLayout.LayoutParams newDotParams = (LinearLayout.LayoutParams) mDots.get(newPosition).getLayoutParams();
                newDotParams.width = 56;
                newDotParams.height = 24;
                mDots.get(newPosition).setLayoutParams(newDotParams);


                LinearLayout.LayoutParams oldDotParams = (LinearLayout.LayoutParams) mDots.get(previousPosition).getLayoutParams();
                oldDotParams.width = 24;
                oldDotParams.height = 24;

                mDots.get(newPosition).setLayoutParams(newDotParams);

                // 把当前的索引赋值给前一个索引变量, 方便下一次再切换.
                previousPosition = newPosition;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setFirstLocation();
    }
    /**
     * 第四步：设置刚打开app时显示的图片和文字
     */
    private void setFirstLocation() {
        mTvPagerTitle.setText(mImageTitles[previousPosition]);
        // 把ViewPager设置为默认选中Integer.MAX_VALUE / t2，从十几亿次开始轮播图片，达到无限循环目的;
//        int m = (Integer.MAX_VALUE / 2) % mImageList.size();
////      int currentPosition = Integer.MAX_VALUE / 2 - m;
        int currentPosition = Integer.MAX_VALUE % imageRess.length;
        mViewPager.setCurrentItem(currentPosition);
    }
    /**
     * 第五步: 设置自动播放,每隔PAGER_TIOME秒换一张图片
     */
    private void autoPlayView() {

        //自动播放图片
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop){
                    // 不是主线程；
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                        }
                    });
                    SystemClock.sleep(PAGER_TIOME);
                }
            }
        }).start();
    }
    /**
     * 资源图片转Drawable
     * @param context
     * @param resId
     * @return
     */
    public Drawable fromResToDrawable(Context context, int resId) {
        return context.getResources().getDrawable(resId);
    }
    /**
     * 动态添加一个点
     * @param linearLayout 添加到LinearLayout布局
     * @param backgount 设置
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public int addDot(final LinearLayout linearLayout, Drawable backgount) {
        final View dot = new View(getActivity());
        LinearLayout.LayoutParams dotParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dotParams.width = 16;
        dotParams.height = 16;
        dotParams.setMargins(4,0,4,0);
        dot.setLayoutParams(dotParams);
        dot.setBackground(backgount);
        dot.setId(View.generateViewId());
        linearLayout.addView(dot);
        return dot.getId();
    }

    /**
     * 添加多个轮播小点到横向线性布局
     * @param linearLayout
     * @param backgount
     * @param number
     * @return
     */
    public List<View> addDots(final LinearLayout linearLayout, Drawable backgount, int number){
        List<View> dots = new ArrayList<>();
        for (int i = 0; i < number; i++) {

            int dotId = addDot(linearLayout,backgount);
            dots.add(inflate.findViewById(dotId));
        }
        return dots;
    }

    // 定位布局中的元素点击事件;
    private void initOnClick(){
        // 定位布局中的元素;
        mBtnUi = inflate.findViewById(R.id.btn_ui);
        mSharedPre = inflate.findViewById(R.id.btn_SharedPre);
        banner = inflate.findViewById(R.id.btn_banner);
        btnEvent = inflate.findViewById(R.id.btn_event);
        frameLayoutViewPager = inflate.findViewById(R.id.frameLayoutViewPager);
        imageViewCustom = inflate.findViewById(R.id.imageViewCustom);
        // 定位到Activity中的Fragment中的布局元素，赋值；

        OnClick onClick = new OnClick();
        mBtnUi.setOnClickListener(onClick);
        mSharedPre.setOnClickListener(onClick);
        banner.setOnClickListener(onClick);
        btnEvent.setOnClickListener(onClick);
        frameLayoutViewPager.setOnClickListener(onClick);
        imageViewCustom.setOnClickListener(onClick);
    }

    // 设置动画
    private void initAinmation(){
         mAinmation = inflate.findViewById(R.id.llTestAnimation);
         mAinmation.animate().alpha(01).setDuration(3000).start();
         mAinmation.animate().translationYBy(50).setDuration(3000).start();
    }

  // 瀑布流；
  private void initStaggeredData(){
      // 初始化数据；
      mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
      mAdapter = new StaggeredRecyclerAdapter(getActivity(), new RecyclerView.OnItemTouchListener() {
          @Override
          public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
              return false;
          }

          @Override
          public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
              ToastUtil.showMsg(getActivity(),"click");
          }

          @Override
          public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

          }
      });
  }

    private void initStaggeredView(){
        myRecyclerStaggered = inflate.findViewById(R.id.rvMainstaggered);
        // 设置布局管理器；
        myRecyclerStaggered.setLayoutManager(mLayoutManager);
        // 设置adapater;
        myRecyclerStaggered.setAdapter(mAdapter);
        // 设置内边距
        myRecyclerStaggered.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int pad = getResources().getDimensionPixelSize(R.dimen.dividerHightLague);
            outRect.set(pad,pad,pad,pad);
        }
    }

//    public void setImage(int imgRes){
//        this.imgRes = imgRes;
//    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_ui:
                    // 事件
                    ToastUtil.showMsg(getActivity(),"UI布局界面");
//                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    intent = new Intent(getActivity(), UIActivity.class);
                    break;
                case R.id.btn_SharedPre:
                    // 事件
                    ToastUtil.showMsg(getActivity(),"疫情地图数据可视化");
                    intent = new Intent(getActivity(), DataStorageActivity.class);
                    break;
                case R.id.btn_banner:
                    ToastUtil.showMsg(getActivity(),"广告条banner");
                    intent = new Intent(getActivity(),BannerActivity.class);
                    break;
                case R.id.btn_event:
                    ToastUtil.showMsg(getActivity(),"WebView加载本地HTML");
                    intent = new Intent(getActivity(), WebViewActivity.class);
                    break;
                case R.id.frameLayoutViewPager:
                    // ToastUtil.showMsg(getActivity(),"轮播图单独监听");
                    intent = new Intent(getActivity(), LunBoActivity.class);
                    break;
                case R.id.imageViewCustom:
                    intent = new Intent(getActivity(), ImageViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
    // 初始化ToolBar;
    private void initToolBar(){
        toolbar = inflate.findViewById(R.id.toolBar);

//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        toolbar.setTitle("首页");
        toolbar.setSubtitle("二级标题");

        // 多了这句，点击事件会消失；
//         setSupportActionBar(toolbar);
        // 导航图标
        toolbar.setLogo(R.mipmap.ic_launcher);

        // 配置菜单；
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // int menuItemId = item.getItemId();
                switch (item.getItemId()) {
                    case R.id.action_search:
                        // Log.d("action_search");
                        ToastUtil.showMsg(getActivity(), "action_search");
                        break;
                    case R.id.action_settings1:
                        ToastUtil.showMsg(getActivity(),"action_settings1");
                        break;
                    case R.id.action_settings2:
                        ToastUtil.showMsg(getActivity(),"action_settings2");
                        break;
                    case R.id.action_settings3:
                        ToastUtil.showMsg(getActivity(),"action_settings3");
                        break;
                }
                return true;
            }
        });
    }
}

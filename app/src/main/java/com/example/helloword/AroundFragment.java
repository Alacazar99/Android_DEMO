package com.example.helloword;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloword.RecyclerView.GridOneRecyclerViewAdapter;
import com.example.helloword.RecyclerView.GridTwoRecyclerViewAdapter;
import com.example.helloword.RecyclerView.StaggeredRecyclerAdapter;
import com.example.helloword.RecyclerView.StaggeredRecyclerViewActivity;
import com.example.helloword.util.ToastUtil;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AroundFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AroundFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View inflate;
    private androidx.recyclerview.widget.RecyclerView myRecyclerStaggered;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private androidx.recyclerview.widget.RecyclerView mGridRecycler;
    private androidx.recyclerview.widget.RecyclerView mGridRecycler2;
    private RecyclerView.Adapter mAdapter2;
    private RecyclerView.LayoutManager mLayoutManager2;

    public AroundFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AroundFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AroundFragment newInstance(String param1, String param2) {
        AroundFragment fragment = new AroundFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate =  inflater.inflate(R.layout.fragment_around, container, false);

        // 初始化瀑布流；
        initStaggeredData();
        initStaggeredView();

        // 初始化网格布局；
        initData();
        initView();

        return inflate;
    }

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
        myRecyclerStaggered = inflate.findViewById(R.id.rv_staggered);
        // 设置布局管理器；
        myRecyclerStaggered.setLayoutManager(mLayoutManager);
        // 设置adapater;
        myRecyclerStaggered.setAdapter(mAdapter);
        // 设置内边距
        myRecyclerStaggered.addItemDecoration(new MyDecoration());
    }
    private void initData(){
        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mLayoutManager2 = new GridLayoutManager(getActivity(), 2);
        mAdapter = new GridOneRecyclerViewAdapter(getActivity());
        mAdapter2 = new GridTwoRecyclerViewAdapter(getActivity());
    }

    private void initView(){
        mGridRecycler = inflate.findViewById(R.id.rv_grid1);
        mGridRecycler2 = inflate.findViewById(R.id.rv_grid2);
        // 设置布局管理器;
        mGridRecycler.setLayoutManager(mLayoutManager);
        mGridRecycler2.setLayoutManager(mLayoutManager2);
        // 设置adapater;
        mGridRecycler.setAdapter((RecyclerView.Adapter) mAdapter);
        mGridRecycler2.setAdapter((RecyclerView.Adapter) mAdapter2);
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int pad = getResources().getDimensionPixelSize(R.dimen.dividerHightLague);
            outRect.set(pad,pad,pad,pad);
        }
    }
}

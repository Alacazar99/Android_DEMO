package com.example.helloword;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloword.util.ToastUtil;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View inflate;
    private Toolbar toolbar;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        inflate =  inflater.inflate(R.layout.fragment_blank, container, false);

        // 初始化ToolBar;
        // initToolBar();

        return inflate;
    }

    private void initToolBar(){
        toolbar = inflate.findViewById(R.id.toolBar);

//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        toolbar.setTitle("首页");
        // 多了这句，点击事件会消失；
//         setSupportActionBar(toolbar);
        // 导航图标
//        toolbar.setLogo(R.mipmap.ic_launcher);
        // 配置菜单；
        toolbar.inflateMenu(R.menu.searchtoolbar_menu);

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

package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloword.util.UserEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MineFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button goLogin,myLoginButton;
    private View view;
    private LinearLayout myTitleAll;
    private TextView myTitleName,myTitleSubName;
    private EditText editusername,editpassword;

    public MineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
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
          // EventBus注册；
        EventBus.getDefault().register(this);

    }


    public void initView(){
        goLogin = view.findViewById(R.id.goLogin);
        myTitleAll = view.findViewById(R.id.myTitleAll);
        myTitleName = view.findViewById(R.id.myTitleName);
        myTitleSubName = view.findViewById(R.id.myTitleSubName);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_mine, container, false);

        initView();

        goLogin = view.findViewById(R.id.goLogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
////                View loginAlertDialog = LayoutInflater.from(getActivity()).inflate(R.layout.layout_dialog_login,null);
////                editusername = loginAlertDialog.findViewById(R.id.edit1);
////                editpassword = loginAlertDialog.findViewById(R.id.edit2);
////                myLoginButton = loginAlertDialog.findViewById(R.id.myLoginButton);
////                builder.setView(loginAlertDialog).show();
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                // 销毁去登录按钮；
                goLogin.setVisibility(View.GONE);
                // 展示titleAll;
                myTitleAll.setVisibility(View.VISIBLE);
            }
        });

//        // 点击登录事件的监听；
//        myLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 销毁去登录按钮；
//                goLogin.setVisibility(View.GONE);
//                Toast.makeText(getActivity(),"登录成功！！", Toast.LENGTH_SHORT).show();
//                // 展示titleAll;
//                myTitleAll.setVisibility(View.VISIBLE);
//                // EventBus事件处理；
//                EventBus.getDefault().post(new UserEvent(editusername.getText().toString(),editpassword.getText().toString()));
//            }
//        });

        return view;
    }
    // 接受订阅事件；
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void testEventBus(UserEvent userEvent){
        myTitleName.setText("用户昵称："+userEvent.getUsername());
        myTitleSubName.setText("用户密码："+userEvent.getPassword());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }
}

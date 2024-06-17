package com.example.tangxiao.fragment;

import static android.app.Activity.RESULT_OK;


import static com.example.tangxiao.activity.LoginActivity.curUser;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tangxiao.R;
import com.example.tangxiao.User;
import com.example.tangxiao.activity.LoginActivity;
import com.example.tangxiao.activity.SettingsActivity;
import com.example.tangxiao.activity.UserActivity;
import com.example.tangxiao.database.DBRepository;

import java.lang.reflect.Field;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AttentionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttentionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String dbName = "HealthManager.db";
    private String tableName = "Users";

    public AttentionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AttentionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AttentionFragment newInstance(String param1, String param2) {
        AttentionFragment fragment = new AttentionFragment();
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
        View view = inflater.inflate(R.layout.fragment_attention, container, false);
        RelativeLayout rectangle = view.findViewById(R.id.rectangle_4);
        RelativeLayout relativeLayout3 = view.findViewById(R.id.relativeLayout3);
        RelativeLayout relativeLayout6 = view.findViewById(R.id.relativeLayout6);
        TextView medley=view.findViewById(R.id.medley);
        TextView email=view.findViewById(R.id.xiao_dcs_ou);
        medley.setText(curUser.getNickname());
        email.setText(curUser.getContact());
        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medley.setText(curUser.getNickname());
                email.setText(curUser.getContact());
            }
        });
        relativeLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
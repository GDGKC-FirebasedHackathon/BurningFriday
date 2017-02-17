package com.gdgkorea.partispot;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class AlbaInfoFragment extends Fragment {

    ImageView imageView_photo;
    EditText editText_name, editText_birthday, editText_phone, editText_major, editText_intro;
    MenuItem menuItem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        initView();


        return inflater.inflate(R.layout.fragment_alba_info, container, false);
    }

    private void initView() {
        imageView_photo = (ImageView) getView().findViewById(R.id.imageView_photo);

        editText_name = (EditText) getView().findViewById(R.id.editText_name);
        editText_birthday = (EditText) getView().findViewById(R.id.editText_birthday);
        editText_phone = (EditText) getView().findViewById(R.id.editText_phone);
        editText_major = (EditText) getView().findViewById(R.id.editText_major);
        editText_intro = (EditText) getView().findViewById(R.id.editText_intro);

        menuItem = (MenuItem) getView().findViewById(R.id.action_settings);

        menuItem.setTitle("내 정보 수정");
    }
}

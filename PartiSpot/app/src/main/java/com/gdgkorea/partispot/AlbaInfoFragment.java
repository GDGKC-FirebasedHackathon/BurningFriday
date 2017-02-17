package com.gdgkorea.partispot;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AlbaInfoFragment extends Fragment {

    View view;
    ImageView imageView_photo;
    EditText editText_name, editText_birthday, editText_phone, editText_major, editText_intro;
    boolean changeState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

        //view = inflater.inflate(R.layout.fragment_alba_info, container, false);

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }

        try{
            view = inflater.inflate(R.layout.fragment_alba_info, container, false);
        }
        catch (InflateException e){
            //setUpMapIfNeeded();
        }

        initModel();
        initView();

        setEditor();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // destroy all menu and re-call onCreateOptionsMenu
        getActivity().invalidateOptionsMenu();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_alba_info, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_setAlbaInfo :
                if(!changeState) {
                    changeState = true;
                    item.setIcon(R.mipmap.ic_save);
                }
                else {
                    changeState = false;
                    item.setIcon(R.mipmap.ic_edit);
                }
                setEditor();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        view = View.inflate(getContext(), R.layout.fragment_alba_info, null);

        imageView_photo = (ImageView) view.findViewById(R.id.imageView_photo);

        editText_name = (EditText) view.findViewById(R.id.editText_name);
        editText_birthday = (EditText) view.findViewById(R.id.editText_birthday);
        editText_phone = (EditText) view.findViewById(R.id.editText_phone);
        editText_major = (EditText) view.findViewById(R.id.editText_major);
        editText_intro = (EditText) view.findViewById(R.id.editText_intro);

    }

    private void initModel() {
        changeState = false;
    }

    private void setEditor() {

        editText_name.setFocusable(changeState);
        editText_birthday.setFocusable(changeState);
        editText_phone.setFocusable(changeState);
        editText_major.setFocusable(changeState);
        editText_intro.setFocusable(changeState);

        editText_name.setFocusableInTouchMode(changeState);
        editText_birthday.setFocusableInTouchMode(changeState);
        editText_phone.setFocusableInTouchMode(changeState);
        editText_major.setFocusableInTouchMode(changeState);
        editText_intro.setFocusableInTouchMode(changeState);

        editText_name.setClickable(changeState);
        editText_birthday.setClickable(changeState);
        editText_phone.setClickable(changeState);
        editText_major.setClickable(changeState);
        editText_intro.setClickable(changeState);
    }
}

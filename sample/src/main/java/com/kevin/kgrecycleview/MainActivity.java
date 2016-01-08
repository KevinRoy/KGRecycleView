package com.kevin.kgrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.kevin.lib.KGRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list)
    com.kevin.lib.KGRecyclerView list;

    private NumRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        adapter = new NumRecyclerAdapter(getLayoutInflater());

        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            strings.add(String.valueOf(i));
        }

        adapter.append(strings);

        list.Builder(this)
                .addLinearlayout()
                .addAdapter(adapter)
                .build();
    }
}

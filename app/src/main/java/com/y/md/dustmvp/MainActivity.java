package com.y.md.dustmvp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.y.md.dustmvp.adapter.MainAdapter;
import com.y.md.dustmvp.data.Dust;
import com.y.md.dustmvp.data.DustRepository;
import com.y.md.dustmvp.data.source.DustsRemoteDataSource;
import com.y.md.dustmvp.listener.OnItemClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, OnItemClickListener {

    private MainContract.Presenter mMainPresenter;

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();

        mMainPresenter = new MainPresenter(DustRepository.getInstance(DustsRemoteDataSource.getInstance()), this);
    }

    private void initLayout() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainAdapter = new MainAdapter(getApplicationContext(), this);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMainPresenter.start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mMainPresenter.result(requestCode, resultCode);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mMainPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showDusts(final List<Dust> dusts) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainAdapter.addItems(dusts);
            }
        });
    }

    @Override
    public void showAddDust() {
        //TODO: added dust
    }

    @Override
    public void showDustDetailsUi(String taskId) {
        //TODO: go to detail
    }

    @Override
    public void showLoadingDustsError() {
        //TODO: error
    }

    @Override
    public void showNoDusts() {
        //TODO: has no dust
    }

    @Override
    public void onItemClick(int position) {
        //TODO: itemClick
    }
}

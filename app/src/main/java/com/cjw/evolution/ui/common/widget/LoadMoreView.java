package com.cjw.evolution.ui.common.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.cjw.evolution.R;
import com.cjw.evolution.ui.common.adapter.IAdapterView;
import com.cjw.evolution.ui.common.recyclerview.LoadMoreStatus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CJW on 2016/10/6.
 */

public class LoadMoreView extends RelativeLayout implements IAdapterView {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.btn_reload)
    ImageView btnReload;

    public LoadMoreView(Context context) {
        super(context);
        View.inflate(context, R.layout.item_load_more_layout, this);
        ButterKnife.bind(this);
    }

    @Override
    public void bind(Object item, int position) {
        int status = (int) item;
        switch (status) {
            case LoadMoreStatus.LOAD_MORE_STATUS_NORMAL:
                progressBar.setVisibility(VISIBLE);
                btnReload.setVisibility(GONE);
                break;
            case LoadMoreStatus.LOAD_MORE_STATUS_FAILED:
                progressBar.setVisibility(GONE);
                btnReload.setVisibility(VISIBLE);
                break;
        }
    }

    public void setReloadListener(OnClickListener reloadListener){
        btnReload.setOnClickListener(reloadListener);
    }
}

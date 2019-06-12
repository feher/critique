package com.dreambroker.garage.critique;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    final int listItemCount = 100;

    @Inject
    protected MainViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder().build().inject(this);

        ListView list = (ListView) findViewById(R.id.list);

        if (list != null) {
            MainImageListAdapter adapter = new MainImageListAdapter(this);
            list.setAdapter(adapter);
            list.setDivider(null);
            list.setOnScrollListener(new ScrollListener());

            MainViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
            viewModel.getImageLiveData().observe(this, adapter::setImages);
        }
    }

    static class ScrollListener implements AbsListView.OnScrollListener {

        @Override
        public void onScrollStateChanged(AbsListView view, int state) {
        }

        @Override
        public void onScroll(AbsListView view, int firstItem, int visibleCount, int totalCount) {
            int height = view.getHeight();
            float middle = height / 2.0f;
            for (int i = 0; i < view.getChildCount(); i++) {
                View child = view.getChildAt(i);
                int childCenter = (child.getBottom() + child.getTop()) / 2;
                float diff = middle - childCenter;
                float offsetPercent = Math.abs(diff) / middle;
                float direction = Math.signum(diff);
                float clampedOffset = Math.min(offsetPercent, 0.5f);
                child.setRotation(direction * clampedOffset * 10.0f);
            }
        }
    }
}

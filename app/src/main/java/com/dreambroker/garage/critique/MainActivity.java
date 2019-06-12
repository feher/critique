package com.dreambroker.garage.critique;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import javax.inject.Inject;

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
            for (int i = 0; i < view.getChildCount(); i++) {
                view.getChildAt(i).setRotation(5.0f);
            }
        }
    }
}

package com.dreambroker.garage.critique;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    final int listItemCount = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        if (list != null) {
            list.setAdapter(new MainListAdapter(this, listItemCount));
            list.setDivider(null);
            list.setOnScrollListener(new ScrollListener());
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

package com.infovass.catering.MyFormat.Utils;

import android.widget.AbsListView;

/**
 * Created by hp on 8/26/2018.
 */

public abstract class LazyLoader implements AbsListView.OnScrollListener {

    private static final int DEFAULT_THRESHOLD = 10 ;

    private boolean loading = true  ;
    private int previousTotal = 0 ;
    private int threshold = DEFAULT_THRESHOLD ;

    public LazyLoader() {}

    public LazyLoader(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if(loading) {
            if(totalItemCount > previousTotal) {
                // the loading has finished
                loading = false ;
                previousTotal = totalItemCount ;
            }
        }

        // check if the List needs more data
        if(!loading && ((firstVisibleItem + visibleItemCount ) >= (totalItemCount - threshold))) {
            loading = true ;

            // List needs more data. Go fetch !!
            loadMore(view, firstVisibleItem,
                    visibleItemCount, totalItemCount);
        }
    }

    // Called when the user is nearing the end of the ListView
    // and the ListView is ready to add more items.
    public abstract void loadMore(AbsListView view, int firstVisibleItem,
                                  int visibleItemCount, int totalItemCount);
}
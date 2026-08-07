package com.bumptech.glide.integration.recyclerview;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestManager;

/* JADX INFO: loaded from: classes13.dex */
public final class RecyclerViewPreloader<T> extends RecyclerView.OnScrollListener {
    private final RecyclerToListViewScrollListener recyclerScrollListener;

    public RecyclerViewPreloader(Activity activity, ListPreloader.PreloadModelProvider<T> preloadModelProvider, ListPreloader.PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this(Glide.with(activity), preloadModelProvider, preloadSizeProvider, i);
    }

    public RecyclerViewPreloader(FragmentActivity fragmentActivity, ListPreloader.PreloadModelProvider<T> preloadModelProvider, ListPreloader.PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this(Glide.with(fragmentActivity), preloadModelProvider, preloadSizeProvider, i);
    }

    public RecyclerViewPreloader(Fragment fragment, ListPreloader.PreloadModelProvider<T> preloadModelProvider, ListPreloader.PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this(Glide.with(fragment), preloadModelProvider, preloadSizeProvider, i);
    }

    @Deprecated
    public RecyclerViewPreloader(android.app.Fragment fragment, ListPreloader.PreloadModelProvider<T> preloadModelProvider, ListPreloader.PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this(Glide.with(fragment), preloadModelProvider, preloadSizeProvider, i);
    }

    public RecyclerViewPreloader(RequestManager requestManager, ListPreloader.PreloadModelProvider<T> preloadModelProvider, ListPreloader.PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.recyclerScrollListener = new RecyclerToListViewScrollListener(new ListPreloader(requestManager, preloadModelProvider, preloadSizeProvider, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.recyclerScrollListener.onScrolled(recyclerView, i, i2);
    }
}

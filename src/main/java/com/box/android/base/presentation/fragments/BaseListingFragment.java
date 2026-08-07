package com.box.android.base.presentation.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.box.android.base.R;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseListingFragment extends Fragment implements BoxFragmentInterface, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView.Adapter mAdapter;
    private BroadcastReceiver mConnectivityReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.base.presentation.fragments.BaseListingFragment.1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ApplicationProvider.application.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                if (BaseListingFragment.this.mWaitingForConnection && z) {
                    BaseListingFragment.this.mWaitingForConnection = false;
                    BaseListingFragment.this.onRefresh();
                }
            }
        }
    };
    private View mEmptyView;
    private RecyclerView mItemsView;
    protected ProgressBar mProgress;
    protected SwipeRefreshLayout mSwipeRefresh;
    private boolean mWaitingForConnection;

    protected abstract RecyclerView.Adapter createAdapter();

    protected abstract boolean isContentAvailable();

    protected abstract void loadItems();

    protected int getLayout() {
        return R.layout.browse;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(getLayout(), viewGroup, false);
        this.mEmptyView = viewInflate.findViewById(R.id.empty_folder_layout);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.id.box_browsesdk_swipe_reresh);
        this.mSwipeRefresh = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.mSwipeRefresh.setColorSchemeColors(CommonBoxUtil.getColorFromAttribute(requireContext(), R.attr.colorAccent));
        this.mSwipeRefresh.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.box_browsesdk_items_recycler_view);
        this.mItemsView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mItemsView.addItemDecoration(new FooterDecoration(getResources()));
        BoxItemDividerDecoration itemDividerDecoration = getItemDividerDecoration();
        if (itemDividerDecoration != null) {
            this.mItemsView.addItemDecoration(itemDividerDecoration);
        }
        this.mProgress = (ProgressBar) viewInflate.findViewById(R.id.box_browsesdk_progress_bar);
        if (this.mAdapter == null) {
            RecyclerView.Adapter adapterCreateAdapter = createAdapter();
            this.mAdapter = adapterCreateAdapter;
            adapterCreateAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.box.android.base.presentation.fragments.BaseListingFragment.2
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeChanged(int i, int i2) {
                    BaseListingFragment.this.updateUI();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeRemoved(int i, int i2) {
                    BaseListingFragment.this.updateUI();
                }
            });
        }
        this.mItemsView.setAdapter(this.mAdapter);
        updateUI();
        return viewInflate;
    }

    protected BoxItemDividerDecoration getItemDividerDecoration() {
        return new BoxItemDividerDecoration(getResources(), getContext().getTheme());
    }

    protected void disableMenuItem(Menu menu, int i) {
        MenuItem menuItemFindItem = menu.findItem(i);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(false);
            menuItemFindItem.setVisible(false);
        }
    }

    protected void enableMenuItem(Menu menu, int i) {
        MenuItem menuItemFindItem = menu.findItem(i);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(true);
            menuItemFindItem.setVisible(true);
        }
    }

    protected void updateUI() {
        if (!isContentAvailable()) {
            this.mProgress.setVisibility(0);
            requestRootLayoutPass();
        } else {
            this.mEmptyView.setVisibility(this.mAdapter.getItemCount() != 0 ? 8 : 0);
            this.mProgress.setVisibility(8);
            requestRootLayoutPass();
        }
    }

    private void requestRootLayoutPass() {
        View view = getView();
        if (view != null) {
            view.requestLayout();
            view.invalidate();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        getActivity().registerReceiver(this.mConnectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        getActivity().unregisterReceiver(this.mConnectivityReceiver);
        super.onPause();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.mSwipeRefresh.setRefreshing(true);
        updateFromRemote();
    }

    public void scrollToTop() {
        this.mItemsView.smoothScrollToPosition(0);
    }

    protected void updateItems() {
        if (getActivity() == null || !isContentAvailable()) {
            return;
        }
        this.mProgress.setVisibility(8);
        this.mSwipeRefresh.setRefreshing(false);
        requestRootLayoutPass();
    }

    private static class FooterDecoration extends RecyclerView.ItemDecoration {
        private final int mFooterPadding;

        public FooterDecoration(Resources resources) {
            this.mFooterPadding = (int) resources.getDimension(R.dimen.box_browsesdk_list_footer_padding);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.bottom = this.mFooterPadding;
            }
        }
    }
}

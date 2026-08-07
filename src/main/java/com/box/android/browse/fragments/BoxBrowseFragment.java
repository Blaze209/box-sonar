package com.box.android.browse.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.IMainParent;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.browse.R;
import com.box.android.browse.adapters.BoxItemAdapter;
import com.box.android.browse.filters.BoxItemFilter;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.BoxResponseIntent;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.utils.SdkUtils;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BoxBrowseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, BoxItemAdapter.OnInteractionListener {
    protected static final String ARG_BOX_ITEM_FILTER = "argBoxBrowseFilter";
    protected static final String ARG_ID = "argId";
    protected static final String ARG_LIMIT = "argLimit";
    protected static final String ARG_NAME = "argName";
    public static final String ARG_USER_ID = "argUserId";
    protected static final String EXTRA_MULTI_SELECT_HANDLER = "com.box.android.browse.MULTI_SELECT_HANDLER";
    protected static final String EXTRA_SECONDARY_ACTION_LISTENER = "com.box.android.browse.SECONDARYACTIONLISTENER";
    public static final String TAG = "com.box.android.browse.fragments.BoxBrowseFragment";

    @Inject
    protected FeatureFlips featureFlips;

    @Inject
    protected Gen204PerformanceLogger gen204PerformanceLogger;
    protected BoxItemAdapter mAdapter;
    private BoxItemFilter mBoxItemFilter;

    @Inject
    protected IBrowseController mController;
    private boolean mIsConnected;
    protected ArrayList<BoxItem> mItems;
    protected RecyclerView mItemsView;
    private LocalBroadcastManager mLocalBroadcastmanager;
    protected MultiSelectHandler mMultiSelectHandler;
    protected ProgressBar mProgress;
    private View mRootView;
    protected OnSecondaryActionListener mSecondaryActionListener;
    protected SwipeRefreshLayout mSwipeRefresh;

    @Inject
    protected ThumbnailManager mThumbnailManager;
    private boolean mWaitingForConnection;
    private Set<OnUpdateListener> mUpdateListeners = new HashSet();
    protected BroadcastReceiver mBroadcastReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.browse.fragments.BoxBrowseFragment.1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (intent instanceof BoxResponseIntent) {
                BoxBrowseFragment.this.handleResponse((BoxResponseIntent) intent);
            }
        }
    };
    protected BroadcastReceiver mConnectivityReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.browse.fragments.BoxBrowseFragment.2
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                BoxBrowseFragment.this.mIsConnected = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                if (BoxBrowseFragment.this.mWaitingForConnection && BoxBrowseFragment.this.mIsConnected) {
                    BoxBrowseFragment.this.mWaitingForConnection = false;
                    BoxBrowseFragment.this.onRefresh();
                }
            }
        }
    };

    public interface OnItemClickListener {
        void onItemClick(BoxItem boxItem);
    }

    public interface OnSecondaryActionListener {
        boolean onSecondaryAction(BoxItem boxItem);
    }

    protected abstract void loadItems();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            if (SdkUtils.isBlank(getArguments().getString(ARG_USER_ID))) {
                throw new IllegalArgumentException("A valid session or user id must be provided");
            }
            this.mBoxItemFilter = (BoxItemFilter) getArguments().getSerializable(ARG_BOX_ITEM_FILTER);
        }
        if (bundle != null) {
            if (bundle.containsKey(EXTRA_SECONDARY_ACTION_LISTENER)) {
                this.mSecondaryActionListener = (OnSecondaryActionListener) bundle.getSerializable(EXTRA_SECONDARY_ACTION_LISTENER);
            }
            if (bundle.containsKey(EXTRA_MULTI_SELECT_HANDLER)) {
                this.mMultiSelectHandler = (MultiSelectHandler) bundle.getSerializable(EXTRA_MULTI_SELECT_HANDLER);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initBoxReceivers();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        cleanupBoxReceivers();
        super.onStop();
    }

    public void scrollToTop() {
        this.mItemsView.smoothScrollToPosition(0);
    }

    protected void initBoxReceivers() {
        getActivity().registerReceiver(this.mConnectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        getLocalBroadcastManager().registerReceiver(this.mBroadcastReceiver, getIntentFilter());
        ArrayList<BoxItem> arrayList = this.mItems;
        if (arrayList == null) {
            this.mProgress.setVisibility(0);
            loadItems();
        } else {
            updateItems(arrayList);
        }
    }

    protected void cleanupBoxReceivers() {
        getLocalBroadcastManager().unregisterReceiver(this.mBroadcastReceiver);
        getActivity().unregisterReceiver(this.mConnectivityReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        OnSecondaryActionListener onSecondaryActionListener = this.mSecondaryActionListener;
        if (onSecondaryActionListener instanceof Serializable) {
            bundle.putSerializable(EXTRA_SECONDARY_ACTION_LISTENER, (Serializable) onSecondaryActionListener);
        }
        Object obj = this.mMultiSelectHandler;
        if (obj instanceof Serializable) {
            bundle.putSerializable(EXTRA_MULTI_SELECT_HANDLER, (Serializable) obj);
        }
        super.onSaveInstanceState(bundle);
    }

    protected void handleResponse(BoxResponseIntent boxResponseIntent) {
        if (!boxResponseIntent.isSuccess() && (boxResponseIntent.getResponse().getRequest() instanceof BoxRequestsFolder.GetFolderWithAllItems)) {
            Toast.makeText(getContext(), R.string.box_browsesdk_problem_fetching_folder, 1).show();
        }
        if (boxResponseIntent.getAction().equals(BoxRequestsFile.DownloadThumbnail.class.getName())) {
            onDownloadedThumbnail(boxResponseIntent);
        }
    }

    protected int getLayout() {
        return R.layout.box_browsesdk_fragment_browse;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(getLayout(), viewGroup, false);
        this.mRootView = viewInflate;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.id.box_browsesdk_swipe_reresh);
        this.mSwipeRefresh = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(this);
            this.mSwipeRefresh.setColorSchemeColors(requireContext().getColor(R.color.box_accent));
            this.mSwipeRefresh.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        }
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(R.id.box_browsesdk_items_recycler_view);
        this.mItemsView = recyclerView;
        initRecyclerView(recyclerView);
        this.mProgress = (ProgressBar) this.mRootView.findViewById(R.id.box_browsesdk_progress_bar);
        BoxItemAdapter boxItemAdapterCreateAdapter = createAdapter();
        this.mAdapter = boxItemAdapterCreateAdapter;
        boxItemAdapterCreateAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.box.android.browse.fragments.BoxBrowseFragment.3
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                BoxBrowseFragment.this.updateUI();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                BoxBrowseFragment.this.updateUI();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                BoxBrowseFragment.this.updateUI();
            }
        });
        this.mItemsView.setAdapter(this.mAdapter);
        if (getMultiSelectHandler() != null) {
            getMultiSelectHandler().setItemAdapter(this.mAdapter);
        }
        return this.mRootView;
    }

    protected void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new BoxItemDividerDecoration(getResources(), recyclerView.getContext().getTheme()));
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), (int) getResources().getDimension(R.dimen.box_browsesdk_list_footer_padding));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (recyclerView.getItemAnimator() instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUI() {
        ArrayList<BoxItem> arrayList = this.mItems;
        if (arrayList == null) {
            return;
        }
        setEmptyState(arrayList.isEmpty());
    }

    protected void setEmptyState(boolean z) {
        ((ImageView) this.mRootView.findViewById(R.id.box_browsesdk_folder_empty)).setVisibility(z ? 0 : 8);
    }

    protected BoxItemAdapter createAdapter() {
        return new BoxItemAdapter(getActivity(), this.mThumbnailManager, this);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.mSwipeRefresh.setRefreshing(true);
        loadItems();
    }

    public IBrowseController getController() {
        return this.mController;
    }

    public void setController(IBrowseController iBrowseController) {
        this.mController = iBrowseController;
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public OnSecondaryActionListener getOnSecondaryActionListener() {
        return this.mSecondaryActionListener;
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public OnItemClickListener getOnItemClickListener() {
        return new OnItemClickListener() { // from class: com.box.android.browse.fragments.BoxBrowseFragment$$ExternalSyntheticLambda0
            @Override // com.box.android.browse.fragments.BoxBrowseFragment.OnItemClickListener
            public final void onItemClick(BoxItem boxItem) {
                this.f$0.lambda$getOnItemClickListener$0(boxItem);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getOnItemClickListener$0(BoxItem boxItem) {
        if (getActivity() instanceof IMainParent) {
            ((OnItemClickListener) getActivity()).onItemClick(boxItem);
        }
    }

    public <T extends OnSecondaryActionListener & Serializable> void setSecondaryActionListener(T t) {
        this.mSecondaryActionListener = t;
        BoxItemAdapter boxItemAdapter = this.mAdapter;
        if (boxItemAdapter != null) {
            boxItemAdapter.notifyItemRangeChanged(0, boxItemAdapter.getItemCount());
        }
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public MultiSelectHandler getMultiSelectHandler() {
        return this.mMultiSelectHandler;
    }

    public <T extends MultiSelectHandler & Serializable> void setMultiSelectHandler(T t) {
        this.mMultiSelectHandler = t;
        BoxItemAdapter boxItemAdapter = this.mAdapter;
        if (boxItemAdapter != null) {
            t.setItemAdapter(boxItemAdapter);
        }
    }

    protected LocalBroadcastManager getLocalBroadcastManager() {
        if (this.mLocalBroadcastmanager == null) {
            this.mLocalBroadcastmanager = LocalBroadcastManager.getInstance(getActivity());
        }
        return this.mLocalBroadcastmanager;
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public BoxItemFilter getItemFilter() {
        return this.mBoxItemFilter;
    }

    protected void checkConnectivity() {
        this.mWaitingForConnection = !this.mIsConnected;
    }

    protected void updateItems(ArrayList<BoxItem> arrayList) {
        if (getActivity() == null) {
            return;
        }
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        SwipeRefreshLayout swipeRefreshLayout = this.mSwipeRefresh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        ArrayList<BoxItem> arrayList2 = new ArrayList<>();
        for (BoxItem boxItem : arrayList) {
            if (getItemFilter() == null || getItemFilter().accept(boxItem)) {
                arrayList2.add(boxItem);
            }
        }
        this.mItems = arrayList2;
        BoxItemAdapter boxItemAdapter = this.mAdapter;
        if (boxItemAdapter != null) {
            boxItemAdapter.updateTo(arrayList2);
        }
    }

    protected void onDownloadedThumbnail(BoxResponseIntent boxResponseIntent) {
        BoxItemAdapter boxItemAdapter = this.mAdapter;
        if (boxItemAdapter != null) {
            this.mAdapter.notifyItemChanged(boxItemAdapter.indexOf(((BoxRequestsFile.DownloadThumbnail) boxResponseIntent.getRequest()).getId()));
        }
    }

    protected IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BoxRequestsFile.DownloadThumbnail.class.getName());
        return intentFilter;
    }

    public static abstract class MultiSelectHandler {
        boolean mIsMultiSelecting;
        transient WeakReference<BoxItemAdapter> mItemAdapter;
        HashSet<BoxItem> mSelectedItems = new HashSet<>();

        public abstract void handleItemSelected(BoxItem boxItem, boolean z, MultiSelectHandler multiSelectHandler);

        public abstract boolean isSelectable(BoxItem boxItem);

        public ArrayList<BoxItem> getSelectedBoxItems() {
            ArrayList<BoxItem> arrayList = new ArrayList<>(this.mSelectedItems.size());
            arrayList.addAll(this.mSelectedItems);
            return arrayList;
        }

        public int getSize() {
            return this.mSelectedItems.size();
        }

        public boolean isItemSelected(BoxItem boxItem) {
            return this.mSelectedItems.contains(boxItem);
        }

        public void toggle(BoxItem boxItem) {
            boolean z;
            if (boxItem == null || !isSelectable(boxItem)) {
                return;
            }
            if (isItemSelected(boxItem)) {
                this.mSelectedItems.remove(boxItem);
                z = false;
            } else {
                this.mSelectedItems.add(boxItem);
                z = true;
            }
            handleItemSelected(boxItem, z, this);
        }

        void setItemAdapter(BoxItemAdapter boxItemAdapter) {
            this.mItemAdapter = new WeakReference<>(boxItemAdapter);
        }

        public void selectAll() {
            if (this.mSelectedItems.size() < this.mItemAdapter.get().getItemCount()) {
                int size = this.mSelectedItems.size();
                for (BoxItem boxItem : this.mItemAdapter.get().getItems()) {
                    if (boxItem != null && isSelectable(boxItem) && !isItemSelected(boxItem)) {
                        this.mSelectedItems.add(boxItem);
                        handleItemSelected(boxItem, true, this);
                    }
                }
                if (size != this.mSelectedItems.size()) {
                    this.mItemAdapter.get().notifyItemRangeChanged(0, this.mItemAdapter.get().getItemCount());
                }
            }
        }

        public void deselectAll() {
            if (this.mSelectedItems.size() > 0) {
                this.mSelectedItems.clear();
                this.mItemAdapter.get().notifyItemRangeChanged(0, this.mItemAdapter.get().getItemCount());
            }
        }

        public boolean isEnabled() {
            return this.mIsMultiSelecting;
        }

        public void setEnabled(boolean z) {
            if (this.mIsMultiSelecting == z) {
                return;
            }
            this.mIsMultiSelecting = z;
            if (!z) {
                this.mSelectedItems.clear();
            }
            WeakReference<BoxItemAdapter> weakReference = this.mItemAdapter;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mItemAdapter.get().notifyItemRangeChanged(0, this.mItemAdapter.get().getItemCount());
        }
    }

    public void addOnUpdateListener(OnUpdateListener onUpdateListener) {
        synchronized (this.mUpdateListeners) {
            this.mUpdateListeners.add(onUpdateListener);
        }
    }

    public void removeOnUpdateListener(OnUpdateListener onUpdateListener) {
        synchronized (this.mUpdateListeners) {
            this.mUpdateListeners.remove(onUpdateListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        synchronized (this.mUpdateListeners) {
            this.mUpdateListeners.clear();
        }
        super.onDestroy();
    }

    protected void notifyUpdateListeners() {
        synchronized (this.mUpdateListeners) {
            Iterator<OnUpdateListener> it = this.mUpdateListeners.iterator();
            while (it.hasNext()) {
                it.next().onUpdate();
            }
        }
    }

    public static abstract class Builder<T extends BoxBrowseFragment> {
        protected Bundle mArgs = new Bundle();

        protected abstract T getInstance();

        protected void setFolderId(String str) {
            this.mArgs.putString(BoxBrowseFragment.ARG_ID, str);
        }

        protected void setFolderName(String str) {
            this.mArgs.putString(BoxBrowseFragment.ARG_NAME, str);
        }

        protected void setUserId(String str) {
            this.mArgs.putString(BoxBrowseFragment.ARG_USER_ID, str);
        }

        public <E extends Serializable & BoxItemFilter> void setBoxItemFilter(E e) {
            this.mArgs.putSerializable(BoxBrowseFragment.ARG_BOX_ITEM_FILTER, e);
        }

        public T build() {
            T t = (T) getInstance();
            t.setArguments(this.mArgs);
            return t;
        }
    }

    protected boolean hasFetchedFromNetwork(BoxIteratorItems boxIteratorItems) {
        if (boxIteratorItems == null || boxIteratorItems.getEntries() == null) {
            return false;
        }
        if (boxIteratorItems.fullSize() != null) {
            return true;
        }
        ArrayList<BoxItem> arrayList = this.mItems;
        return arrayList != null && arrayList.size() > 0;
    }
}

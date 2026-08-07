package com.box.android.browse.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.browse.R;
import com.box.android.browse.filters.BoxItemFilter;
import com.box.android.browse.fragments.BoxBrowseFragment;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.SdkUtils;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes10.dex */
public class BoxItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final int DELAY = 50;
    protected static final int INSERT_LIMIT = 10;
    protected static final int REMOVE_LIMIT = 5;
    private BoxBrowseFragment.OnItemClickListener mAnalyticsListener;
    protected final Context mContext;
    protected final OnInteractionListener mListener;
    WeakReference<RecyclerView> mRecyclerViewRef;
    protected ThumbnailManager mThumbnailManager;
    protected final ArrayList<BoxItem> mItems = new ArrayList<>();
    protected int BOX_ITEM_VIEW_TYPE = 0;
    protected ReadWriteLock mLock = new ReentrantReadWriteLock();
    protected final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface OnInteractionListener {
        BoxItemFilter getItemFilter();

        BoxBrowseFragment.MultiSelectHandler getMultiSelectHandler();

        BoxBrowseFragment.OnItemClickListener getOnItemClickListener();

        BoxBrowseFragment.OnSecondaryActionListener getOnSecondaryActionListener();
    }

    public BoxItemAdapter(Context context, ThumbnailManager thumbnailManager, OnInteractionListener onInteractionListener) {
        this.mContext = context;
        this.mListener = onInteractionListener;
        this.mThumbnailManager = thumbnailManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerViewRef = new WeakReference<>(recyclerView);
        super.onAttachedToRecyclerView(recyclerView);
    }

    protected boolean isRecyclerViewComputing() {
        WeakReference<RecyclerView> weakReference = this.mRecyclerViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.mRecyclerViewRef.get().isComputingLayout();
    }

    protected boolean isOnUiThread() {
        return this.mHandler.getLooper().getThread().equals(Thread.currentThread());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BoxItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.box_browsesdk_list_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((BoxItemViewHolder) viewHolder).bindItem(this.mItems.get(i));
    }

    protected HashMap<String, Integer> getPositionMap(List<BoxItem> list) {
        HashMap<String, Integer> map = new HashMap<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getUserId(), Integer.valueOf(i));
        }
        return map;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.BOX_ITEM_VIEW_TYPE;
    }

    public void removeAll() {
        if (isRecyclerViewComputing() || !isOnUiThread()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.box.android.browse.adapters.BoxItemAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    BoxItemAdapter.this.removeAll();
                }
            }, 50L);
            return;
        }
        Lock lockWriteLock = this.mLock.writeLock();
        lockWriteLock.lock();
        try {
            this.mItems.clear();
            notifyDataSetChanged();
        } finally {
            lockWriteLock.unlock();
        }
    }

    public void remove(final List<String> list) {
        boolean z;
        if (isRecyclerViewComputing() || !isOnUiThread()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.box.android.browse.adapters.BoxItemAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    BoxItemAdapter.this.remove(list);
                }
            }, 50L);
            return;
        }
        this.mLock.readLock().lock();
        try {
            HashMap<String, Integer> positionMap = getPositionMap(this.mItems);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (positionMap.containsKey(it.next())) {
                    this.mLock.readLock().unlock();
                    Lock lockWriteLock = this.mLock.writeLock();
                    lockWriteLock.lock();
                    HashSet hashSet = new HashSet(list.size());
                    try {
                        ArrayList arrayList = new ArrayList(list.size());
                        HashMap<String, Integer> positionMap2 = getPositionMap(this.mItems);
                        for (String str : list) {
                            Integer num = positionMap2.get(str);
                            if (num != null) {
                                hashSet.add(str);
                                arrayList.add(num);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList(this.mItems.size() - hashSet.size());
                        for (BoxItem boxItem : this.mItems) {
                            if (!hashSet.contains(boxItem.getUserId())) {
                                arrayList2.add(boxItem);
                            }
                        }
                        if (arrayList.size() <= 5) {
                            Collections.sort(arrayList);
                            z = true;
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                notifyItemRemoved(((Integer) arrayList.get(size)).intValue());
                            }
                        } else {
                            z = false;
                        }
                        this.mItems.clear();
                        this.mItems.addAll(arrayList2);
                        if (z && this.mItems.size() > 0) {
                            notifyItemRangeChanged(0, this.mItems.size());
                        } else {
                            notifyDataSetChanged();
                        }
                        lockWriteLock.unlock();
                        return;
                    } catch (Throwable th) {
                        lockWriteLock.unlock();
                        throw th;
                    }
                }
            }
            this.mLock.readLock().unlock();
        } catch (Throwable th2) {
            this.mLock.readLock().unlock();
            throw th2;
        }
    }

    public void updateTo(final ArrayList<BoxItem> arrayList) {
        if (isRecyclerViewComputing() || !isOnUiThread()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.box.android.browse.adapters.BoxItemAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    BoxItemAdapter.this.updateTo(arrayList);
                }
            }, 50L);
            return;
        }
        Lock lockWriteLock = this.mLock.writeLock();
        lockWriteLock.lock();
        try {
            if (this.mItems.size() == 0) {
                this.mItems.clear();
                this.mItems.addAll(arrayList);
                notifyDataSetChanged();
                return;
            }
            HashMap<String, Integer> positionMap = getPositionMap(this.mItems);
            ArrayList arrayList2 = new ArrayList();
            boolean z = false;
            for (int i = 0; i < arrayList.size(); i++) {
                Integer numRemove = positionMap.remove(arrayList.get(i).getUserId());
                if (numRemove == null) {
                    arrayList2.add(Integer.valueOf(i));
                } else {
                    if (!z) {
                        if (numRemove.equals(Integer.valueOf(i))) {
                            if (this.mItems.get(i) != arrayList.get(i)) {
                                z = !this.mItems.get(i).equals(arrayList.get(i));
                            }
                        }
                    }
                }
                z = true;
            }
            if (!(positionMap.size() > 0 || arrayList2.size() > 0 || arrayList.size() == 0) && !z) {
                return;
            }
            if (positionMap.size() == 0 && arrayList2.size() > 0 && arrayList2.size() <= 10) {
                this.mItems.clear();
                this.mItems.addAll(arrayList);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    notifyItemInserted(((Integer) it.next()).intValue());
                }
                notifyItemRangeChanged(0, this.mItems.size());
            } else if (positionMap.size() > 0 && positionMap.size() <= 5) {
                ArrayList arrayList3 = new ArrayList(positionMap.size());
                arrayList3.addAll(positionMap.values());
                Collections.sort(arrayList3);
                for (int size = arrayList3.size() - 1; size >= 0; size--) {
                    notifyItemRemoved(((Integer) arrayList3.get(size)).intValue());
                }
                this.mItems.clear();
                this.mItems.addAll(arrayList);
                if (this.mItems.isEmpty()) {
                    notifyDataSetChanged();
                } else {
                    notifyItemRangeChanged(0, this.mItems.size());
                }
            } else {
                this.mItems.clear();
                this.mItems.addAll(arrayList);
                notifyDataSetChanged();
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    public void add(final List<BoxItem> list) {
        if (list.size() == 0) {
            return;
        }
        if (isRecyclerViewComputing() || !isOnUiThread()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.box.android.browse.adapters.BoxItemAdapter.4
                @Override // java.lang.Runnable
                public void run() {
                    BoxItemAdapter.this.add(list);
                }
            }, 50L);
            return;
        }
        Lock lockWriteLock = this.mLock.writeLock();
        lockWriteLock.lock();
        this.mItems.addAll(list);
        try {
            notifyDataSetChanged();
        } finally {
            lockWriteLock.unlock();
        }
    }

    public void update(final BoxItem boxItem) {
        if (isRecyclerViewComputing() || !isOnUiThread()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.box.android.browse.adapters.BoxItemAdapter.5
                @Override // java.lang.Runnable
                public void run() {
                    BoxItemAdapter.this.update(boxItem);
                }
            }, 50L);
            return;
        }
        Lock lockWriteLock = this.mLock.writeLock();
        lockWriteLock.lock();
        for (int i = 0; i < this.mItems.size(); i++) {
            try {
                if (this.mItems.get(i).getUserId().equals(boxItem.getUserId())) {
                    this.mItems.set(i, boxItem);
                    notifyItemChanged(i);
                    lockWriteLock.unlock();
                    return;
                }
            } catch (Throwable th) {
                lockWriteLock.unlock();
                throw th;
            }
        }
        lockWriteLock.unlock();
    }

    public int indexOf(String str) {
        this.mLock.readLock().lock();
        for (int i = 0; i < this.mItems.size(); i++) {
            try {
                if (this.mItems.get(i).getUserId().equals(str)) {
                    return i;
                }
            } finally {
                this.mLock.readLock().unlock();
            }
        }
        return -1;
    }

    public ArrayList<BoxItem> getItems() {
        this.mLock.readLock().lock();
        try {
            return (ArrayList) this.mItems.clone();
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        long jHashCode;
        this.mLock.readLock().lock();
        try {
            try {
                jHashCode = Long.parseLong(this.mItems.get(i).getUserId());
            } catch (NumberFormatException unused) {
                jHashCode = this.mItems.get(i).getUserId().hashCode();
            }
            return jHashCode;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public void setAnalyticsListener(BoxBrowseFragment.OnItemClickListener onItemClickListener) {
        this.mAnalyticsListener = onItemClickListener;
    }

    public class BoxItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private static final String DESCRIPTION_TEMPLATE = "%s  • %s";
        BoxItem mItem;
        AppCompatCheckBox mItemCheckBox;
        TextView mMetaDescription;
        TextView mNameView;
        ProgressBar mProgressBar;
        ImageButton mSecondaryAction;
        BoxItemClickListener mSecondaryClickListener;
        ImageView mThumbView;
        View mView;

        public BoxItemViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            if (BoxItemAdapter.this.mListener.getMultiSelectHandler() != null) {
                view.setOnLongClickListener(this);
            }
            this.mView = view;
            this.mThumbView = (ImageView) view.findViewById(R.id.box_browsesdk_thumb_image);
            this.mNameView = (TextView) view.findViewById(R.id.box_browsesdk_name_text);
            this.mMetaDescription = (TextView) view.findViewById(R.id.metaline_description);
            this.mProgressBar = (ProgressBar) view.findViewById(R.id.spinner);
            this.mSecondaryAction = (ImageButton) view.findViewById(R.id.secondaryAction);
            this.mItemCheckBox = (AppCompatCheckBox) view.findViewById(R.id.boxItemCheckBox);
            BoxItemClickListener boxItemClickListener = new BoxItemClickListener();
            this.mSecondaryClickListener = boxItemClickListener;
            ImageButton imageButton = this.mSecondaryAction;
            if (imageButton != null) {
                imageButton.setOnClickListener(boxItemClickListener);
            }
        }

        public void bindItem(BoxItem boxItem) {
            onBindBoxItemViewHolder(this, boxItem);
            this.mItem = boxItem;
            this.mSecondaryClickListener.setListItem(boxItem);
        }

        protected void onBindBoxItemViewHolder(BoxItemViewHolder boxItemViewHolder, BoxItem boxItem) {
            if (boxItem == null) {
                return;
            }
            BoxItem item = boxItemViewHolder.getItem();
            boolean zEquals = (item == null || item.getUserId() == null || !item.getUserId().equals(boxItem.getUserId()) || item.getModifiedAt() == null || !item.getModifiedAt().equals(boxItem.getModifiedAt()) || item.getSize() == null || !item.getSize().equals(boxItem.getSize())) ? false : true;
            if (zEquals && (item instanceof BoxFolder)) {
                zEquals = Objects.equals(((BoxFolder) item).getHasCollaborations(), ((BoxFolder) boxItem).getHasCollaborations());
            }
            if (!zEquals) {
                boxItemViewHolder.getNameView().setText(boxItem.getName());
                boxItemViewHolder.getMetaDescription().setText(String.format(Locale.ENGLISH, "%s  • %s", boxItem.getModifiedAt() != null ? DateFormat.getDateInstance(2).format(boxItem.getModifiedAt()) : "", boxItem.getSize() != null ? SdkUtils.getLocalizedFileSize(BoxItemAdapter.this.mContext, boxItem.getSize().longValue()) : ""));
                BoxItemAdapter.this.mThumbnailManager.loadThumbnail(boxItem, boxItemViewHolder.getThumbView());
            }
            boxItemViewHolder.getProgressBar().setVisibility(8);
            boxItemViewHolder.getMetaDescription().setVisibility(0);
            boxItemViewHolder.getThumbView().setVisibility(0);
            boolean z = BoxItemAdapter.this.mListener.getItemFilter() == null || BoxItemAdapter.this.mListener.getItemFilter().isEnabled(boxItem);
            boxItemViewHolder.getView().setEnabled(z);
            boxItemViewHolder.getThumbView().setAlpha(CommonBoxUtil.getDimen(BoxItemAdapter.this.mContext, z ? com.box.android.common.R.dimen.box_item_thumbnail_alpha : com.box.android.common.R.dimen.box_item_thumbnail_alpha_disabled));
            if (z && BoxItemAdapter.this.mListener.getOnSecondaryActionListener() != null) {
                boxItemViewHolder.getSecondaryAction().setVisibility(0);
            } else {
                boxItemViewHolder.getSecondaryAction().setVisibility(8);
            }
            if (BoxItemAdapter.this.mListener.getMultiSelectHandler() != null && BoxItemAdapter.this.mListener.getMultiSelectHandler().isEnabled()) {
                boxItemViewHolder.getSecondaryAction().setVisibility(8);
                boxItemViewHolder.getCheckBox().setVisibility(0);
                boxItemViewHolder.getCheckBox().setEnabled(z && BoxItemAdapter.this.mListener.getMultiSelectHandler().isSelectable(boxItem));
                boxItemViewHolder.getCheckBox().setChecked(z && BoxItemAdapter.this.mListener.getMultiSelectHandler().isItemSelected(boxItem));
            } else {
                boxItemViewHolder.getCheckBox().setVisibility(8);
            }
            if (BoxItemAdapter.this.mListener.getItemFilter() != null) {
                if (BoxItemAdapter.this.mListener.getItemFilter().isEnabled(boxItem)) {
                    getView().setAlpha(1.0f);
                } else {
                    getView().setAlpha(0.5f);
                }
            }
        }

        public AppCompatCheckBox getCheckBox() {
            return this.mItemCheckBox;
        }

        public ImageButton getSecondaryAction() {
            return this.mSecondaryAction;
        }

        public BoxItem getItem() {
            return this.mItem;
        }

        public ProgressBar getProgressBar() {
            return this.mProgressBar;
        }

        public TextView getMetaDescription() {
            return this.mMetaDescription;
        }

        public TextView getNameView() {
            return this.mNameView;
        }

        public ImageView getThumbView() {
            return this.mThumbView;
        }

        public View getView() {
            return this.mView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (BoxItemAdapter.this.mListener.getMultiSelectHandler() == null) {
                return false;
            }
            if (BoxItemAdapter.this.mListener.getMultiSelectHandler().isEnabled()) {
                BoxItemAdapter.this.mListener.getMultiSelectHandler().deselectAll();
                BoxItemAdapter.this.mListener.getMultiSelectHandler().setEnabled(false);
            } else {
                BoxItemAdapter.this.mListener.getMultiSelectHandler().setEnabled(true);
                BoxItemAdapter.this.mListener.getMultiSelectHandler().toggle(this.mItem);
            }
            return true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BoxItemAdapter.this.mListener.getMultiSelectHandler() != null && BoxItemAdapter.this.mListener.getMultiSelectHandler().isEnabled()) {
                BoxItemAdapter.this.mListener.getMultiSelectHandler().toggle(this.mItem);
                onBindBoxItemViewHolder(this, this.mItem);
            } else {
                if (this.mItem == null || BoxItemAdapter.this.mListener == null) {
                    return;
                }
                BoxItemAdapter.this.mListener.getOnItemClickListener().onItemClick(this.mItem);
                if (BoxItemAdapter.this.mAnalyticsListener != null) {
                    BoxItemAdapter.this.mAnalyticsListener.onItemClick(this.mItem);
                }
            }
        }
    }

    private class BoxItemClickListener implements View.OnClickListener {
        protected BoxItem mItem;

        private BoxItemClickListener() {
        }

        void setListItem(BoxItem boxItem) {
            this.mItem = boxItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BoxItemAdapter.this.mListener.getOnSecondaryActionListener().onSecondaryAction(this.mItem);
        }
    }
}

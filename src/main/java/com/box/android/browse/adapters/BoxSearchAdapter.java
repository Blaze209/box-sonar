package com.box.android.browse.adapters;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.browse.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.controller.IBrowseController;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSearchItem;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class BoxSearchAdapter extends BoxItemAdapter {
    protected static final int FILTER_BUTTON_VIEW_TYPE = 3;
    public static final String LOAD_MORE_ID = "com.box.android.browse.LOAD_MORE";
    protected static final int LOAD_MORE_VIEW_TYPE = 1;
    protected static final int RESULTS_HEADER_VIEW_TYPE = 2;
    protected IBrowseController mController;
    private Runnable mFilterButtonClickListener;

    public BoxSearchAdapter(Context context, IBrowseController iBrowseController, ThumbnailManager thumbnailManager, BoxItemAdapter.OnInteractionListener onInteractionListener) {
        super(context, thumbnailManager, onInteractionListener);
        this.mController = iBrowseController;
        this.mThumbnailManager = thumbnailManager;
    }

    public void setFilterButtonClickListener(Runnable runnable) {
        this.mFilterButtonClickListener = runnable;
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BoxItemAdapter.BoxItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new LoadMoreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.box_browsesdk_list_item_progress_bar, viewGroup, false));
        }
        if (i == 2) {
            return new ResultsHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.box_browsesdk_recent_searches_header, viewGroup, false));
        }
        if (i == 3) {
            return new FilterButtonViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.box_browsesdk_search_filter_button, viewGroup, false));
        }
        return new SearchViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.box_browsesdk_list_item, viewGroup, false));
    }

    @Override // com.box.android.browse.adapters.BoxItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        BoxItem boxItem = this.mItems.get(i);
        if (boxItem instanceof ResultsHeader) {
            return 2;
        }
        if (boxItem instanceof LoadMoreItem) {
            return 1;
        }
        if (boxItem instanceof FilterButtonItem) {
            return 3;
        }
        return super.getItemViewType(i);
    }

    public void addLoadMoreItem(BoxRequestsSearch.Search search) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(LoadMoreItem.create(search));
        add(arrayList);
    }

    class SearchViewHolder extends BoxItemAdapter.BoxItemViewHolder {
        public SearchViewHolder(View view) {
            super(view);
        }

        @Override // com.box.android.browse.adapters.BoxItemAdapter.BoxItemViewHolder
        protected void onBindBoxItemViewHolder(BoxItemAdapter.BoxItemViewHolder boxItemViewHolder, BoxItem boxItem) {
            if (boxItem instanceof BoxSearchItem) {
                super.onBindBoxItemViewHolder(boxItemViewHolder, boxItem);
                BoxItem item = ((BoxSearchItem) boxItem).getItem();
                boxItemViewHolder.getNameView().setText(item.getName());
                boxItemViewHolder.getMetaDescription().setText(createPath(item, File.separator));
                BoxSearchAdapter.this.mThumbnailManager.loadThumbnail(item, boxItemViewHolder.getThumbView());
                boxItemViewHolder.getThumbView().setAlpha(CommonBoxUtil.getDimen(BoxSearchAdapter.this.mContext, com.box.android.common.R.dimen.box_item_thumbnail_alpha));
                boxItemViewHolder.getProgressBar().setVisibility(8);
                boxItemViewHolder.getMetaDescription().setVisibility(0);
                boxItemViewHolder.getThumbView().setVisibility(0);
            }
        }

        private String createPath(BoxItem boxItem, String str) {
            StringBuilder sb = new StringBuilder(str);
            if (boxItem.getPathCollection() != null) {
                Iterator<E> it = boxItem.getPathCollection().iterator();
                while (it.hasNext()) {
                    sb.append(((BoxFolder) it.next()).getName());
                    sb.append(str);
                }
            }
            return sb.toString();
        }
    }

    class LoadMoreViewHolder extends BoxItemAdapter.BoxItemViewHolder {
        public LoadMoreViewHolder(View view) {
            super(view);
        }

        @Override // com.box.android.browse.adapters.BoxItemAdapter.BoxItemViewHolder
        protected void onBindBoxItemViewHolder(BoxItemAdapter.BoxItemViewHolder boxItemViewHolder, BoxItem boxItem) {
            BoxSearchAdapter.this.mController.execute(((LoadMoreItem) boxItem).getRequest());
        }

        public void setError() {
            this.mThumbView.setImageResource(R.drawable.ic_box_browsesdk_refresh_grey_36dp);
            this.mThumbView.setVisibility(0);
            this.mProgressBar.setVisibility(8);
            this.mMetaDescription.setVisibility(0);
            this.mNameView.setText(BoxSearchAdapter.this.mContext.getResources().getString(R.string.box_browsesdk_error_retrieving_items));
            this.mMetaDescription.setText(BoxSearchAdapter.this.mContext.getResources().getString(R.string.box_browsesdk_tap_to_retry));
        }
    }

    class ResultsHeaderViewHolder extends BoxItemAdapter.BoxItemViewHolder {
        public ResultsHeaderViewHolder(View view) {
            super(view);
        }

        @Override // com.box.android.browse.adapters.BoxItemAdapter.BoxItemViewHolder
        protected void onBindBoxItemViewHolder(BoxItemAdapter.BoxItemViewHolder boxItemViewHolder, BoxItem boxItem) {
            ((TextView) boxItemViewHolder.getView().findViewById(R.id.text)).setText(Html.fromHtml(BoxSearchAdapter.this.mContext.getResources().getString(R.string.box_browsesdk_search_results_header, TextUtils.isEmpty(boxItem.getName()) ? BoxSearchAdapter.this.mContext.getResources().getString(R.string.files) : boxItem.getName())));
        }
    }

    class FilterButtonViewHolder extends BoxItemAdapter.BoxItemViewHolder {
        @Override // com.box.android.browse.adapters.BoxItemAdapter.BoxItemViewHolder
        protected void onBindBoxItemViewHolder(BoxItemAdapter.BoxItemViewHolder boxItemViewHolder, BoxItem boxItem) {
        }

        public FilterButtonViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.adapters.BoxSearchAdapter$FilterButtonViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$0(view2);
                }
            });
            view.setOnLongClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            if (BoxSearchAdapter.this.mFilterButtonClickListener != null) {
                BoxSearchAdapter.this.mFilterButtonClickListener.run();
            }
        }
    }
}

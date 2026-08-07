package com.box.android.base.presentation.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import com.box.android.base.R;
import com.box.android.common.utilities.CommonBoxUtil;

/* JADX INFO: loaded from: classes9.dex */
public class BoxSearchView extends SearchView {
    private static final String EXTRA_ORIGINAL_PARCELABLE = "extraOriginalParcelable";
    private boolean isExpanded;
    private OnBoxSearchListener mOnBoxSearchListener;

    public interface OnBoxSearchListener {
        void onQueryTextChange(String str);

        void onQueryTextSubmit(String str);

        void onSearchCollapsed();

        void onSearchExpanded();
    }

    public BoxSearchView(Context context) {
        super(context);
        initSearchView();
    }

    public BoxSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initSearchView();
    }

    private void initSearchView() {
        this.isExpanded = false;
        ImageView imageView = (ImageView) ((LinearLayout) findViewById(R.id.search_plate)).findViewById(R.id.search_close_btn);
        imageView.setImageResource(android.R.color.transparent);
        imageView.setClickable(false);
        ((EditText) findViewById(R.id.search_src_text)).setTextColor(CommonBoxUtil.getColorFromAttribute(getContext(), R.attr.searchPrimary));
        setImeOptions(301989891);
        setOnQueryTextListener(new SearchQueryTextListener());
        setOnSearchClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.views.BoxSearchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BoxSearchView.this.isExpanded = true;
                if (BoxSearchView.this.mOnBoxSearchListener != null) {
                    BoxSearchView.this.mOnBoxSearchListener.onSearchExpanded();
                }
            }
        });
        setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.box.android.base.presentation.views.BoxSearchView.2
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public boolean onClose() {
                BoxSearchView.this.isExpanded = false;
                if (BoxSearchView.this.mOnBoxSearchListener != null) {
                    BoxSearchView.this.mOnBoxSearchListener.onSearchCollapsed();
                }
                return false;
            }
        });
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public OnBoxSearchListener getSearchListener() {
        return this.mOnBoxSearchListener;
    }

    public void setSearchTerm(String str) {
        setQuery(str, false);
    }

    @Override // androidx.appcompat.widget.SearchView, android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_ORIGINAL_PARCELABLE, parcelableOnSaveInstanceState);
        return bundle;
    }

    @Override // androidx.appcompat.widget.SearchView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            super.onRestoreInstanceState(((Bundle) parcelable).getParcelable(EXTRA_ORIGINAL_PARCELABLE));
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    public void setOnBoxSearchListener(OnBoxSearchListener onBoxSearchListener) {
        this.mOnBoxSearchListener = onBoxSearchListener;
    }

    private class SearchQueryTextListener implements SearchView.OnQueryTextListener {
        private SearchQueryTextListener() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            if (BoxSearchView.this.mOnBoxSearchListener == null) {
                return true;
            }
            BoxSearchView.this.mOnBoxSearchListener.onQueryTextSubmit(str);
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (BoxSearchView.this.mOnBoxSearchListener != null) {
                BoxSearchView.this.mOnBoxSearchListener.onQueryTextChange(str);
            }
            ImageView imageView = (ImageView) ((LinearLayout) BoxSearchView.this.findViewById(R.id.search_plate)).findViewById(R.id.search_close_btn);
            if (imageView != null) {
                if (!str.isEmpty()) {
                    imageView.setImageResource(R.drawable.ic_search_clear_24);
                    imageView.setClickable(true);
                } else {
                    imageView.setImageResource(android.R.color.transparent);
                    imageView.setClickable(false);
                }
            }
            return true;
        }
    }
}

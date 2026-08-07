package com.box.android.browse.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.box.android.base.presentation.views.BoxSearchView;
import com.box.android.browse.R;
import com.box.android.browse.models.BoxSearchFilters;

/* JADX INFO: loaded from: classes10.dex */
public class AppSearchView extends BoxSearchView {

    public interface AppSearchViewListener extends BoxSearchView.OnBoxSearchListener {
        void onFilterIconClicked();
    }

    public AppSearchView(Context context) {
        super(context);
        showFilteringOption();
    }

    public AppSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        showFilteringOption();
    }

    private void showFilteringOption() {
        setSubmitButtonEnabled(true);
        ((ImageView) findViewById(R.id.search_go_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.views.AppSearchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BoxSearchView.OnBoxSearchListener searchListener = AppSearchView.this.getSearchListener();
                if (searchListener instanceof AppSearchViewListener) {
                    ((AppSearchViewListener) searchListener).onFilterIconClicked();
                }
            }
        });
    }

    public void setFilteringIcon(BoxSearchFilters boxSearchFilters) {
        ImageView imageView = (ImageView) findViewById(R.id.search_go_btn);
        if (boxSearchFilters != null && boxSearchFilters.mItemTypes.size() > 0) {
            imageView.setImageResource(com.box.android.base.R.drawable.ic_search_filter_enabled);
        } else {
            imageView.setImageResource(com.box.android.base.R.drawable.ic_search_filter_default);
        }
    }

    public void setFilterButtonVisible(boolean z) {
        ImageView imageView;
        setSubmitButtonEnabled(z);
        if (z || (imageView = (ImageView) findViewById(R.id.search_go_btn)) == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}

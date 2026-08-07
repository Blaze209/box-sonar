package com.box.android.base.presentation.adapters;

import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.R;
import com.box.android.base.models.BottomSheetMenuItem;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class BottomMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final boolean mIsRedesigned;
    private List<BottomSheetMenuItem> mMenuItems;

    public BottomMenuAdapter(List<BottomSheetMenuItem> list) {
        this(list, false);
    }

    public BottomMenuAdapter(List<BottomSheetMenuItem> list, boolean z) {
        this.mMenuItems = list;
        this.mIsRedesigned = z;
    }

    public List<BottomSheetMenuItem> getData() {
        return this.mMenuItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        if (this.mIsRedesigned) {
            i2 = R.layout.bottom_sheet_list_item_redesigned;
        } else {
            i2 = R.layout.bottom_sheet_list_item;
        }
        return new ViewHolder(layoutInflaterFrom.inflate(i2, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int i2;
        BottomSheetMenuItem bottomSheetMenuItem = this.mMenuItems.get(i);
        viewHolder.mTitle.setText(bottomSheetMenuItem.getTitle());
        if (bottomSheetMenuItem.getIcon() == null) {
            if (viewHolder.mIconContainer != null) {
                viewHolder.mIconContainer.setVisibility(8);
            } else {
                viewHolder.mIcon.setVisibility(8);
            }
        } else {
            viewHolder.mIcon.setImageDrawable(bottomSheetMenuItem.getIcon());
            if (viewHolder.mIconContainer != null) {
                viewHolder.mIconContainer.setBackgroundTintList(null);
                if (bottomSheetMenuItem.getId() == R.id.menu_delete) {
                    i2 = com.box.android.common.R.attr.notification;
                    TypedValue typedValue = new TypedValue();
                    viewHolder.itemView.getContext().getTheme().resolveAttribute(com.box.android.common.R.attr.notification_bg, typedValue, true);
                    viewHolder.mIconContainer.setBackgroundTintList(ColorStateList.valueOf(typedValue.data));
                } else {
                    i2 = com.box.android.common.R.attr.mainActiveControl;
                }
                TypedValue typedValue2 = new TypedValue();
                viewHolder.itemView.getContext().getTheme().resolveAttribute(i2, typedValue2, true);
                viewHolder.mIcon.setImageTintList(ColorStateList.valueOf(typedValue2.data));
                viewHolder.mIconContainer.setVisibility(0);
            } else {
                viewHolder.mIcon.setVisibility(0);
            }
        }
        boolean z = bottomSheetMenuItem.getState() == BottomSheetMenuItem.State.LOADING;
        boolean z2 = bottomSheetMenuItem.getState() == BottomSheetMenuItem.State.ENABLED;
        float f = z2 ? 1.0f : 0.4f;
        viewHolder.mTitle.setAlpha(f);
        if (viewHolder.mIconContainer != null) {
            viewHolder.mIconContainer.setAlpha(f);
        } else {
            viewHolder.mIcon.setAlpha(f);
        }
        viewHolder.mLoadingSpinner.setVisibility(z ? 0 : 8);
        viewHolder.itemView.setEnabled(z2);
        viewHolder.itemView.setClickable(z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BottomSheetMenuItem> list = this.mMenuItems;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIcon;
        FrameLayout mIconContainer;
        ProgressBar mLoadingSpinner;
        TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            this.mTitle = (TextView) view.findViewById(R.id.title);
            this.mIconContainer = (FrameLayout) view.findViewById(R.id.icon_container);
            this.mIcon = (ImageView) view.findViewById(R.id.item_icon);
            this.mLoadingSpinner = (ProgressBar) view.findViewById(R.id.loading_spinner);
        }
    }
}

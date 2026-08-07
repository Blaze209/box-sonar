package com.box.android.browse.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.Fragment;
import com.box.android.browse.R;
import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.common.utilities.CommonBoxUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public class BoxFilterSearchResultsFragment extends Fragment {
    public static final String EXTRA_FILTERS = "extraFilters";
    public static final String EXTRA_IS_REDESIGNED = "isRedesigned";
    private boolean mDateModifiedExpanded;
    private LinearLayout mDateModifiedView;
    private HashMap<BoxSearchFilters.ItemType, FileTypeData> mFileTypeMap;
    private BoxSearchFilters mFilters;
    private boolean mIsRedesigned;
    private boolean mItemSizeExpanded;
    private OnApplyListener mOnApplyListener;
    private ScrollView mScrollView;
    private LinearLayout mSizeView;

    public interface OnApplyListener {
        void onApply(BoxSearchFilters boxSearchFilters);
    }

    public static BoxFilterSearchResultsFragment newInstance(BoxSearchFilters boxSearchFilters, boolean z) {
        BoxFilterSearchResultsFragment boxFilterSearchResultsFragment = new BoxFilterSearchResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_FILTERS, boxSearchFilters);
        bundle.putBoolean(EXTRA_IS_REDESIGNED, z);
        boxFilterSearchResultsFragment.setArguments(bundle);
        return boxFilterSearchResultsFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mFilters = (BoxSearchFilters) getArguments().getSerializable(EXTRA_FILTERS);
            this.mIsRedesigned = getArguments().getBoolean(EXTRA_IS_REDESIGNED);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = R.layout.fragment_box_filter_search_results;
        if (this.mIsRedesigned) {
            i = R.layout.fragment_box_filter_search_results_redesigned;
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.mScrollView = (ScrollView) viewInflate.findViewById(R.id.scrollView);
        this.mDateModifiedView = (LinearLayout) viewInflate.findViewById(R.id.dateModified);
        this.mSizeView = (LinearLayout) viewInflate.findViewById(R.id.size);
        this.mDateModifiedExpanded = false;
        this.mItemSizeExpanded = false;
        setup(viewInflate);
        return viewInflate;
    }

    public BoxSearchFilters getCurrentFilters() {
        return this.mFilters;
    }

    public void setOnApplyListener(OnApplyListener onApplyListener) {
        this.mOnApplyListener = onApplyListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup(View view) {
        setupButtons(view);
        setupFileTypes(view);
        setupDateModified(view);
        setupSizeRange(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupSizeRange(View view) {
        for (BoxSearchFilters.ItemSize itemSize : BoxSearchFilters.ItemSize.values()) {
            setupSizeRange(view, itemSize, itemSize.getContainerId(), itemSize.getStringId());
        }
    }

    private void setupSizeRange(final View view, final BoxSearchFilters.ItemSize itemSize, int i, int i2) {
        View viewFindViewById = view.findViewById(i);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.text);
        ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.selected);
        ImageView imageView2 = (ImageView) viewFindViewById.findViewById(R.id.expand);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BoxFilterSearchResultsFragment boxFilterSearchResultsFragment = BoxFilterSearchResultsFragment.this;
                boxFilterSearchResultsFragment.mItemSizeExpanded = !boxFilterSearchResultsFragment.mItemSizeExpanded;
                BoxFilterSearchResultsFragment.this.mFilters.setItemSize(itemSize);
                BoxFilterSearchResultsFragment.this.setupSizeRange(view);
                BoxFilterSearchResultsFragment.this.enableDisableClearButton(view);
                BoxFilterSearchResultsFragment.this.mScrollView.post(new Runnable() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BoxFilterSearchResultsFragment.this.mScrollView.smoothScrollTo(0, BoxFilterSearchResultsFragment.this.mSizeView.getBottom());
                    }
                });
            }
        });
        textView.setText(getString(i2));
        if (this.mFilters.mItemSize == itemSize) {
            viewFindViewById.setVisibility(0);
            imageView.setVisibility(this.mItemSizeExpanded ? 0 : 8);
            imageView2.setVisibility(this.mItemSizeExpanded ? 8 : 0);
            textView.setTextColor(CommonBoxUtil.getColorFromAttribute(getContext(), R.attr.colorAccent));
            return;
        }
        viewFindViewById.setVisibility(this.mItemSizeExpanded ? 0 : 8);
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        textView.setTextColor(CommonBoxUtil.getColorFromAttribute(getContext(), R.attr.contentSecondary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupDateModified(View view) {
        for (BoxSearchFilters.ItemModifiedDate itemModifiedDate : BoxSearchFilters.ItemModifiedDate.values()) {
            setupDateModified(view, itemModifiedDate, itemModifiedDate.getContainerId(), itemModifiedDate.getStringId());
        }
    }

    private void setupDateModified(final View view, final BoxSearchFilters.ItemModifiedDate itemModifiedDate, int i, int i2) {
        View viewFindViewById = view.findViewById(i);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.text);
        ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.selected);
        ImageView imageView2 = (ImageView) viewFindViewById.findViewById(R.id.expand);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BoxFilterSearchResultsFragment boxFilterSearchResultsFragment = BoxFilterSearchResultsFragment.this;
                boxFilterSearchResultsFragment.mDateModifiedExpanded = !boxFilterSearchResultsFragment.mDateModifiedExpanded;
                BoxFilterSearchResultsFragment.this.mFilters.setItemModifiedDate(itemModifiedDate);
                BoxFilterSearchResultsFragment.this.setupDateModified(view);
                BoxFilterSearchResultsFragment.this.enableDisableClearButton(view);
                BoxFilterSearchResultsFragment.this.mScrollView.post(new Runnable() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BoxFilterSearchResultsFragment.this.mScrollView.smoothScrollTo(0, BoxFilterSearchResultsFragment.this.mDateModifiedView.getBottom());
                    }
                });
            }
        });
        textView.setText(getString(i2));
        if (this.mFilters.mItemModifiedDate == itemModifiedDate) {
            viewFindViewById.setVisibility(0);
            imageView.setVisibility(this.mDateModifiedExpanded ? 0 : 8);
            imageView2.setVisibility(this.mDateModifiedExpanded ? 8 : 0);
            textView.setTextColor(CommonBoxUtil.getColorFromAttribute(getContext(), R.attr.colorAccent));
            return;
        }
        viewFindViewById.setVisibility(this.mDateModifiedExpanded ? 0 : 8);
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        textView.setTextColor(CommonBoxUtil.getColorFromAttribute(getContext(), R.attr.contentSecondary));
    }

    private void setupFileTypes(final View view) {
        this.mFileTypeMap = new HashMap<>();
        for (BoxSearchFilters.ItemType itemType : BoxSearchFilters.ItemType.values()) {
            setupFileType(view, itemType, itemType.getContainerId(), itemType.getDrawableId(), itemType.getStringId());
        }
        final TextView textView = (TextView) view.findViewById(R.id.seeMoreFileType);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BoxFilterSearchResultsFragment.this.showHiddenFileTypes(textView, view);
            }
        });
        if (this.mFilters.mItemTypes.size() > 0) {
            showHiddenFileTypes(textView, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHiddenFileTypes(TextView textView, View view) {
        textView.setVisibility(8);
        view.findViewById(R.id.hiddenFileTypes).setVisibility(0);
    }

    private void setupFileType(final View view, final BoxSearchFilters.ItemType itemType, int i, int i2, int i3) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.icon);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.text);
        final AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) relativeLayout.findViewById(R.id.checkBox);
        imageView.setImageResource(i2);
        imageView.setAlpha(CommonBoxUtil.getDimen(getContext(), R.dimen.box_item_thumbnail_alpha));
        textView.setText(getString(i3));
        this.mFileTypeMap.put(itemType, new FileTypeData(itemType, relativeLayout, appCompatCheckBox));
        appCompatCheckBox.setChecked(this.mFilters.containsType(itemType));
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AppCompatCheckBox appCompatCheckBox2 = appCompatCheckBox;
                appCompatCheckBox2.setChecked(!appCompatCheckBox2.isChecked());
            }
        });
        appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (itemType == BoxSearchFilters.ItemType.Folder) {
                        for (BoxSearchFilters.ItemType itemType2 : BoxSearchFilters.ItemType.values()) {
                            if (itemType2 != BoxSearchFilters.ItemType.Folder && BoxFilterSearchResultsFragment.this.mFileTypeMap.get(itemType2) != null) {
                                ((FileTypeData) BoxFilterSearchResultsFragment.this.mFileTypeMap.get(itemType2)).mCheckBox.setChecked(false);
                            }
                        }
                    } else {
                        ((FileTypeData) BoxFilterSearchResultsFragment.this.mFileTypeMap.get(BoxSearchFilters.ItemType.Folder)).mCheckBox.setChecked(false);
                    }
                    BoxFilterSearchResultsFragment.this.mFilters.addItemType(itemType);
                } else {
                    BoxFilterSearchResultsFragment.this.mFilters.removeItemType(itemType);
                }
                BoxFilterSearchResultsFragment.this.enableDisableClearButton(view);
            }
        });
    }

    private void setupButtons(final View view) {
        ((Button) view.findViewById(R.id.apply_button)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BoxFilterSearchResultsFragment.this.mOnApplyListener != null) {
                    BoxFilterSearchResultsFragment.this.mOnApplyListener.onApply(BoxFilterSearchResultsFragment.this.mFilters);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(BoxSearchFragment.EXTRA_SEARCH_FILTERS, BoxFilterSearchResultsFragment.this.mFilters);
                BoxFilterSearchResultsFragment.this.getActivity().setResult(-1, intent);
                BoxFilterSearchResultsFragment.this.getActivity().finish();
            }
        });
        ((Button) view.findViewById(R.id.clear_filters_button)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxFilterSearchResultsFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BoxFilterSearchResultsFragment.this.mFilters.clearFilters();
                BoxFilterSearchResultsFragment.this.setup(view);
            }
        });
        enableDisableClearButton(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableDisableClearButton(View view) {
        ((Button) view.findViewById(R.id.clear_filters_button)).setEnabled(this.mFilters.anyFiltersSet());
    }

    class FileTypeData {
        AppCompatCheckBox mCheckBox;
        RelativeLayout mContainer;
        BoxSearchFilters.ItemType mItemType;

        public FileTypeData(BoxSearchFilters.ItemType itemType, RelativeLayout relativeLayout, AppCompatCheckBox appCompatCheckBox) {
            this.mItemType = itemType;
            this.mContainer = relativeLayout;
            this.mCheckBox = appCompatCheckBox;
        }
    }
}

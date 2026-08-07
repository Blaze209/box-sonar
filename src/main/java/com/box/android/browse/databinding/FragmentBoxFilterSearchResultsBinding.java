package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentBoxFilterSearchResultsBinding implements ViewBinding {
    public final Button applyButton;
    public final FilterSearchResultsFileTypeItemBinding audioFileTypeContainer;
    public final FilterSearchResultsFileTypeItemBinding autocadFileTypeContainer;
    public final FilterSearchResultsFileTypeItemBinding boxnoteFileTypeContainer;
    public final RelativeLayout clearApplyBar;
    public final Button clearFiltersButton;
    public final LinearLayout dateModified;
    public final FilterSearchResultsExpandableItemBinding dateModifiedContainerAnyTime;
    public final FilterSearchResultsExpandableItemBinding dateModifiedContainerPastDay;
    public final FilterSearchResultsExpandableItemBinding dateModifiedContainerPastMonth;
    public final FilterSearchResultsExpandableItemBinding dateModifiedContainerPastWeek;
    public final FilterSearchResultsExpandableItemBinding dateModifiedContainerPastYear;
    public final TextView dateModifiedLabel;
    public final FilterSearchResultsFileTypeItemBinding documentFileTypeContainer;
    public final TextView fileTypeLabel;
    public final FilterSearchResultsFileTypeItemBinding folderFileTypeContainer;
    public final LinearLayout hiddenFileTypes;
    public final FilterSearchResultsFileTypeItemBinding imageFileTypeContainer;
    public final FilterSearchResultsExpandableItemBinding itemSizeContainerAny;
    public final FilterSearchResultsExpandableItemBinding itemSizeContainerFiveToTwentyFive;
    public final FilterSearchResultsExpandableItemBinding itemSizeContainerLessThanOne;
    public final FilterSearchResultsExpandableItemBinding itemSizeContainerOneHundredToOneThousand;
    public final FilterSearchResultsExpandableItemBinding itemSizeContainerOneToFive;
    public final FilterSearchResultsExpandableItemBinding itemSizeContainerTwentyFiveToOneHundred;
    public final TextView itemSizeLabel;
    public final FilterSearchResultsFileTypeItemBinding pdfFileTypeContainer;
    public final FilterSearchResultsFileTypeItemBinding presentationFileTypeContainer;
    private final FrameLayout rootView;
    public final ScrollView scrollView;
    public final TextView seeMoreFileType;
    public final LinearLayout size;
    public final FilterSearchResultsFileTypeItemBinding spreadsheetFileTypeContainer;
    public final FilterSearchResultsFileTypeItemBinding videoFileTypeContainer;

    private FragmentBoxFilterSearchResultsBinding(FrameLayout frameLayout, Button button, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding2, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding3, RelativeLayout relativeLayout, Button button2, LinearLayout linearLayout, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding2, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding3, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding4, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding5, TextView textView, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding4, TextView textView2, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding5, LinearLayout linearLayout2, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding6, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding6, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding7, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding8, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding9, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding10, FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBinding11, TextView textView3, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding7, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding8, ScrollView scrollView, TextView textView4, LinearLayout linearLayout3, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding9, FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBinding10) {
        this.rootView = frameLayout;
        this.applyButton = button;
        this.audioFileTypeContainer = filterSearchResultsFileTypeItemBinding;
        this.autocadFileTypeContainer = filterSearchResultsFileTypeItemBinding2;
        this.boxnoteFileTypeContainer = filterSearchResultsFileTypeItemBinding3;
        this.clearApplyBar = relativeLayout;
        this.clearFiltersButton = button2;
        this.dateModified = linearLayout;
        this.dateModifiedContainerAnyTime = filterSearchResultsExpandableItemBinding;
        this.dateModifiedContainerPastDay = filterSearchResultsExpandableItemBinding2;
        this.dateModifiedContainerPastMonth = filterSearchResultsExpandableItemBinding3;
        this.dateModifiedContainerPastWeek = filterSearchResultsExpandableItemBinding4;
        this.dateModifiedContainerPastYear = filterSearchResultsExpandableItemBinding5;
        this.dateModifiedLabel = textView;
        this.documentFileTypeContainer = filterSearchResultsFileTypeItemBinding4;
        this.fileTypeLabel = textView2;
        this.folderFileTypeContainer = filterSearchResultsFileTypeItemBinding5;
        this.hiddenFileTypes = linearLayout2;
        this.imageFileTypeContainer = filterSearchResultsFileTypeItemBinding6;
        this.itemSizeContainerAny = filterSearchResultsExpandableItemBinding6;
        this.itemSizeContainerFiveToTwentyFive = filterSearchResultsExpandableItemBinding7;
        this.itemSizeContainerLessThanOne = filterSearchResultsExpandableItemBinding8;
        this.itemSizeContainerOneHundredToOneThousand = filterSearchResultsExpandableItemBinding9;
        this.itemSizeContainerOneToFive = filterSearchResultsExpandableItemBinding10;
        this.itemSizeContainerTwentyFiveToOneHundred = filterSearchResultsExpandableItemBinding11;
        this.itemSizeLabel = textView3;
        this.pdfFileTypeContainer = filterSearchResultsFileTypeItemBinding7;
        this.presentationFileTypeContainer = filterSearchResultsFileTypeItemBinding8;
        this.scrollView = scrollView;
        this.seeMoreFileType = textView4;
        this.size = linearLayout3;
        this.spreadsheetFileTypeContainer = filterSearchResultsFileTypeItemBinding9;
        this.videoFileTypeContainer = filterSearchResultsFileTypeItemBinding10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBoxFilterSearchResultsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBoxFilterSearchResultsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_box_filter_search_results, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBoxFilterSearchResultsBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        View viewFindChildViewById7;
        int i = R.id.apply_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.audioFileTypeContainer))) != null) {
            FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById);
            i = R.id.autocadFileTypeContainer;
            View viewFindChildViewById8 = ViewBindings.findChildViewById(view, i);
            if (viewFindChildViewById8 != null) {
                FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind2 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById8);
                i = R.id.boxnoteFileTypeContainer;
                View viewFindChildViewById9 = ViewBindings.findChildViewById(view, i);
                if (viewFindChildViewById9 != null) {
                    FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind3 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById9);
                    i = R.id.clear_apply_bar;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.clear_filters_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            i = R.id.dateModified;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.dateModifiedContainerAnyTime))) != null) {
                                FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById2);
                                i = R.id.dateModifiedContainerPastDay;
                                View viewFindChildViewById10 = ViewBindings.findChildViewById(view, i);
                                if (viewFindChildViewById10 != null) {
                                    FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind2 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById10);
                                    i = R.id.dateModifiedContainerPastMonth;
                                    View viewFindChildViewById11 = ViewBindings.findChildViewById(view, i);
                                    if (viewFindChildViewById11 != null) {
                                        FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind3 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById11);
                                        i = R.id.dateModifiedContainerPastWeek;
                                        View viewFindChildViewById12 = ViewBindings.findChildViewById(view, i);
                                        if (viewFindChildViewById12 != null) {
                                            FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind4 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById12);
                                            i = R.id.dateModifiedContainerPastYear;
                                            View viewFindChildViewById13 = ViewBindings.findChildViewById(view, i);
                                            if (viewFindChildViewById13 != null) {
                                                FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind5 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById13);
                                                i = R.id.dateModifiedLabel;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.documentFileTypeContainer))) != null) {
                                                    FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind4 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById3);
                                                    i = R.id.fileTypeLabel;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.folderFileTypeContainer))) != null) {
                                                        FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind5 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById4);
                                                        i = R.id.hiddenFileTypes;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.imageFileTypeContainer))) != null) {
                                                            FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind6 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById5);
                                                            i = R.id.itemSizeContainerAny;
                                                            View viewFindChildViewById14 = ViewBindings.findChildViewById(view, i);
                                                            if (viewFindChildViewById14 != null) {
                                                                FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind6 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById14);
                                                                i = R.id.itemSizeContainerFiveToTwentyFive;
                                                                View viewFindChildViewById15 = ViewBindings.findChildViewById(view, i);
                                                                if (viewFindChildViewById15 != null) {
                                                                    FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind7 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById15);
                                                                    i = R.id.itemSizeContainerLessThanOne;
                                                                    View viewFindChildViewById16 = ViewBindings.findChildViewById(view, i);
                                                                    if (viewFindChildViewById16 != null) {
                                                                        FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind8 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById16);
                                                                        i = R.id.itemSizeContainerOneHundredToOneThousand;
                                                                        View viewFindChildViewById17 = ViewBindings.findChildViewById(view, i);
                                                                        if (viewFindChildViewById17 != null) {
                                                                            FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind9 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById17);
                                                                            i = R.id.itemSizeContainerOneToFive;
                                                                            View viewFindChildViewById18 = ViewBindings.findChildViewById(view, i);
                                                                            if (viewFindChildViewById18 != null) {
                                                                                FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind10 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById18);
                                                                                i = R.id.itemSizeContainerTwentyFiveToOneHundred;
                                                                                View viewFindChildViewById19 = ViewBindings.findChildViewById(view, i);
                                                                                if (viewFindChildViewById19 != null) {
                                                                                    FilterSearchResultsExpandableItemBinding filterSearchResultsExpandableItemBindingBind11 = FilterSearchResultsExpandableItemBinding.bind(viewFindChildViewById19);
                                                                                    i = R.id.itemSizeLabel;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.pdfFileTypeContainer))) != null) {
                                                                                        FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind7 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById6);
                                                                                        i = R.id.presentationFileTypeContainer;
                                                                                        View viewFindChildViewById20 = ViewBindings.findChildViewById(view, i);
                                                                                        if (viewFindChildViewById20 != null) {
                                                                                            FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind8 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById20);
                                                                                            i = R.id.scrollView;
                                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                            if (scrollView != null) {
                                                                                                i = R.id.seeMoreFileType;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.size;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout3 != null && (viewFindChildViewById7 = ViewBindings.findChildViewById(view, (i = R.id.spreadsheetFileTypeContainer))) != null) {
                                                                                                        FilterSearchResultsFileTypeItemBinding filterSearchResultsFileTypeItemBindingBind9 = FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById7);
                                                                                                        i = R.id.videoFileTypeContainer;
                                                                                                        View viewFindChildViewById21 = ViewBindings.findChildViewById(view, i);
                                                                                                        if (viewFindChildViewById21 != null) {
                                                                                                            return new FragmentBoxFilterSearchResultsBinding((FrameLayout) view, button, filterSearchResultsFileTypeItemBindingBind, filterSearchResultsFileTypeItemBindingBind2, filterSearchResultsFileTypeItemBindingBind3, relativeLayout, button2, linearLayout, filterSearchResultsExpandableItemBindingBind, filterSearchResultsExpandableItemBindingBind2, filterSearchResultsExpandableItemBindingBind3, filterSearchResultsExpandableItemBindingBind4, filterSearchResultsExpandableItemBindingBind5, textView, filterSearchResultsFileTypeItemBindingBind4, textView2, filterSearchResultsFileTypeItemBindingBind5, linearLayout2, filterSearchResultsFileTypeItemBindingBind6, filterSearchResultsExpandableItemBindingBind6, filterSearchResultsExpandableItemBindingBind7, filterSearchResultsExpandableItemBindingBind8, filterSearchResultsExpandableItemBindingBind9, filterSearchResultsExpandableItemBindingBind10, filterSearchResultsExpandableItemBindingBind11, textView3, filterSearchResultsFileTypeItemBindingBind7, filterSearchResultsFileTypeItemBindingBind8, scrollView, textView4, linearLayout3, filterSearchResultsFileTypeItemBindingBind9, FilterSearchResultsFileTypeItemBinding.bind(viewFindChildViewById21));
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

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
public final class FragmentBoxFilterSearchResultsRedesignedBinding implements ViewBinding {
    public final Button applyButton;
    public final FilterSearchResultsFileTypeItemRedesignedBinding audioFileTypeContainer;
    public final FilterSearchResultsFileTypeItemRedesignedBinding autocadFileTypeContainer;
    public final FilterSearchResultsFileTypeItemRedesignedBinding boxnoteFileTypeContainer;
    public final RelativeLayout clearApplyBar;
    public final Button clearFiltersButton;
    public final LinearLayout dateModified;
    public final FilterSearchResultsExpandableItemRedesignedBinding dateModifiedContainerAnyTime;
    public final FilterSearchResultsExpandableItemRedesignedBinding dateModifiedContainerPastDay;
    public final FilterSearchResultsExpandableItemRedesignedBinding dateModifiedContainerPastMonth;
    public final FilterSearchResultsExpandableItemRedesignedBinding dateModifiedContainerPastWeek;
    public final FilterSearchResultsExpandableItemRedesignedBinding dateModifiedContainerPastYear;
    public final TextView dateModifiedLabel;
    public final FilterSearchResultsFileTypeItemRedesignedBinding documentFileTypeContainer;
    public final TextView fileTypeLabel;
    public final FilterSearchResultsFileTypeItemRedesignedBinding folderFileTypeContainer;
    public final LinearLayout hiddenFileTypes;
    public final FilterSearchResultsFileTypeItemRedesignedBinding imageFileTypeContainer;
    public final FilterSearchResultsExpandableItemRedesignedBinding itemSizeContainerAny;
    public final FilterSearchResultsExpandableItemRedesignedBinding itemSizeContainerFiveToTwentyFive;
    public final FilterSearchResultsExpandableItemRedesignedBinding itemSizeContainerLessThanOne;
    public final FilterSearchResultsExpandableItemRedesignedBinding itemSizeContainerOneHundredToOneThousand;
    public final FilterSearchResultsExpandableItemRedesignedBinding itemSizeContainerOneToFive;
    public final FilterSearchResultsExpandableItemRedesignedBinding itemSizeContainerTwentyFiveToOneHundred;
    public final TextView itemSizeLabel;
    public final FilterSearchResultsFileTypeItemRedesignedBinding pdfFileTypeContainer;
    public final FilterSearchResultsFileTypeItemRedesignedBinding presentationFileTypeContainer;
    private final FrameLayout rootView;
    public final ScrollView scrollView;
    public final TextView seeMoreFileType;
    public final LinearLayout size;
    public final FilterSearchResultsFileTypeItemRedesignedBinding spreadsheetFileTypeContainer;
    public final FilterSearchResultsFileTypeItemRedesignedBinding videoFileTypeContainer;

    private FragmentBoxFilterSearchResultsRedesignedBinding(FrameLayout frameLayout, Button button, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding2, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding3, RelativeLayout relativeLayout, Button button2, LinearLayout linearLayout, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding2, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding3, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding4, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding5, TextView textView, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding4, TextView textView2, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding5, LinearLayout linearLayout2, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding6, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding6, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding7, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding8, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding9, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding10, FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBinding11, TextView textView3, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding7, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding8, ScrollView scrollView, TextView textView4, LinearLayout linearLayout3, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding9, FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBinding10) {
        this.rootView = frameLayout;
        this.applyButton = button;
        this.audioFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding;
        this.autocadFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding2;
        this.boxnoteFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding3;
        this.clearApplyBar = relativeLayout;
        this.clearFiltersButton = button2;
        this.dateModified = linearLayout;
        this.dateModifiedContainerAnyTime = filterSearchResultsExpandableItemRedesignedBinding;
        this.dateModifiedContainerPastDay = filterSearchResultsExpandableItemRedesignedBinding2;
        this.dateModifiedContainerPastMonth = filterSearchResultsExpandableItemRedesignedBinding3;
        this.dateModifiedContainerPastWeek = filterSearchResultsExpandableItemRedesignedBinding4;
        this.dateModifiedContainerPastYear = filterSearchResultsExpandableItemRedesignedBinding5;
        this.dateModifiedLabel = textView;
        this.documentFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding4;
        this.fileTypeLabel = textView2;
        this.folderFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding5;
        this.hiddenFileTypes = linearLayout2;
        this.imageFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding6;
        this.itemSizeContainerAny = filterSearchResultsExpandableItemRedesignedBinding6;
        this.itemSizeContainerFiveToTwentyFive = filterSearchResultsExpandableItemRedesignedBinding7;
        this.itemSizeContainerLessThanOne = filterSearchResultsExpandableItemRedesignedBinding8;
        this.itemSizeContainerOneHundredToOneThousand = filterSearchResultsExpandableItemRedesignedBinding9;
        this.itemSizeContainerOneToFive = filterSearchResultsExpandableItemRedesignedBinding10;
        this.itemSizeContainerTwentyFiveToOneHundred = filterSearchResultsExpandableItemRedesignedBinding11;
        this.itemSizeLabel = textView3;
        this.pdfFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding7;
        this.presentationFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding8;
        this.scrollView = scrollView;
        this.seeMoreFileType = textView4;
        this.size = linearLayout3;
        this.spreadsheetFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding9;
        this.videoFileTypeContainer = filterSearchResultsFileTypeItemRedesignedBinding10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBoxFilterSearchResultsRedesignedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBoxFilterSearchResultsRedesignedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_box_filter_search_results_redesigned, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBoxFilterSearchResultsRedesignedBinding bind(View view) {
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
            FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById);
            i = R.id.autocadFileTypeContainer;
            View viewFindChildViewById8 = ViewBindings.findChildViewById(view, i);
            if (viewFindChildViewById8 != null) {
                FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind2 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById8);
                i = R.id.boxnoteFileTypeContainer;
                View viewFindChildViewById9 = ViewBindings.findChildViewById(view, i);
                if (viewFindChildViewById9 != null) {
                    FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind3 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById9);
                    i = R.id.clear_apply_bar;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.clear_filters_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            i = R.id.dateModified;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.dateModifiedContainerAnyTime))) != null) {
                                FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById2);
                                i = R.id.dateModifiedContainerPastDay;
                                View viewFindChildViewById10 = ViewBindings.findChildViewById(view, i);
                                if (viewFindChildViewById10 != null) {
                                    FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind2 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById10);
                                    i = R.id.dateModifiedContainerPastMonth;
                                    View viewFindChildViewById11 = ViewBindings.findChildViewById(view, i);
                                    if (viewFindChildViewById11 != null) {
                                        FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind3 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById11);
                                        i = R.id.dateModifiedContainerPastWeek;
                                        View viewFindChildViewById12 = ViewBindings.findChildViewById(view, i);
                                        if (viewFindChildViewById12 != null) {
                                            FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind4 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById12);
                                            i = R.id.dateModifiedContainerPastYear;
                                            View viewFindChildViewById13 = ViewBindings.findChildViewById(view, i);
                                            if (viewFindChildViewById13 != null) {
                                                FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind5 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById13);
                                                i = R.id.dateModifiedLabel;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.documentFileTypeContainer))) != null) {
                                                    FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind4 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById3);
                                                    i = R.id.fileTypeLabel;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.folderFileTypeContainer))) != null) {
                                                        FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind5 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById4);
                                                        i = R.id.hiddenFileTypes;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.imageFileTypeContainer))) != null) {
                                                            FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind6 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById5);
                                                            i = R.id.itemSizeContainerAny;
                                                            View viewFindChildViewById14 = ViewBindings.findChildViewById(view, i);
                                                            if (viewFindChildViewById14 != null) {
                                                                FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind6 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById14);
                                                                i = R.id.itemSizeContainerFiveToTwentyFive;
                                                                View viewFindChildViewById15 = ViewBindings.findChildViewById(view, i);
                                                                if (viewFindChildViewById15 != null) {
                                                                    FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind7 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById15);
                                                                    i = R.id.itemSizeContainerLessThanOne;
                                                                    View viewFindChildViewById16 = ViewBindings.findChildViewById(view, i);
                                                                    if (viewFindChildViewById16 != null) {
                                                                        FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind8 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById16);
                                                                        i = R.id.itemSizeContainerOneHundredToOneThousand;
                                                                        View viewFindChildViewById17 = ViewBindings.findChildViewById(view, i);
                                                                        if (viewFindChildViewById17 != null) {
                                                                            FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind9 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById17);
                                                                            i = R.id.itemSizeContainerOneToFive;
                                                                            View viewFindChildViewById18 = ViewBindings.findChildViewById(view, i);
                                                                            if (viewFindChildViewById18 != null) {
                                                                                FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind10 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById18);
                                                                                i = R.id.itemSizeContainerTwentyFiveToOneHundred;
                                                                                View viewFindChildViewById19 = ViewBindings.findChildViewById(view, i);
                                                                                if (viewFindChildViewById19 != null) {
                                                                                    FilterSearchResultsExpandableItemRedesignedBinding filterSearchResultsExpandableItemRedesignedBindingBind11 = FilterSearchResultsExpandableItemRedesignedBinding.bind(viewFindChildViewById19);
                                                                                    i = R.id.itemSizeLabel;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.pdfFileTypeContainer))) != null) {
                                                                                        FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind7 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById6);
                                                                                        i = R.id.presentationFileTypeContainer;
                                                                                        View viewFindChildViewById20 = ViewBindings.findChildViewById(view, i);
                                                                                        if (viewFindChildViewById20 != null) {
                                                                                            FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind8 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById20);
                                                                                            i = R.id.scrollView;
                                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                            if (scrollView != null) {
                                                                                                i = R.id.seeMoreFileType;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.size;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout3 != null && (viewFindChildViewById7 = ViewBindings.findChildViewById(view, (i = R.id.spreadsheetFileTypeContainer))) != null) {
                                                                                                        FilterSearchResultsFileTypeItemRedesignedBinding filterSearchResultsFileTypeItemRedesignedBindingBind9 = FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById7);
                                                                                                        i = R.id.videoFileTypeContainer;
                                                                                                        View viewFindChildViewById21 = ViewBindings.findChildViewById(view, i);
                                                                                                        if (viewFindChildViewById21 != null) {
                                                                                                            return new FragmentBoxFilterSearchResultsRedesignedBinding((FrameLayout) view, button, filterSearchResultsFileTypeItemRedesignedBindingBind, filterSearchResultsFileTypeItemRedesignedBindingBind2, filterSearchResultsFileTypeItemRedesignedBindingBind3, relativeLayout, button2, linearLayout, filterSearchResultsExpandableItemRedesignedBindingBind, filterSearchResultsExpandableItemRedesignedBindingBind2, filterSearchResultsExpandableItemRedesignedBindingBind3, filterSearchResultsExpandableItemRedesignedBindingBind4, filterSearchResultsExpandableItemRedesignedBindingBind5, textView, filterSearchResultsFileTypeItemRedesignedBindingBind4, textView2, filterSearchResultsFileTypeItemRedesignedBindingBind5, linearLayout2, filterSearchResultsFileTypeItemRedesignedBindingBind6, filterSearchResultsExpandableItemRedesignedBindingBind6, filterSearchResultsExpandableItemRedesignedBindingBind7, filterSearchResultsExpandableItemRedesignedBindingBind8, filterSearchResultsExpandableItemRedesignedBindingBind9, filterSearchResultsExpandableItemRedesignedBindingBind10, filterSearchResultsExpandableItemRedesignedBindingBind11, textView3, filterSearchResultsFileTypeItemRedesignedBindingBind7, filterSearchResultsFileTypeItemRedesignedBindingBind8, scrollView, textView4, linearLayout3, filterSearchResultsFileTypeItemRedesignedBindingBind9, FilterSearchResultsFileTypeItemRedesignedBinding.bind(viewFindChildViewById21));
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

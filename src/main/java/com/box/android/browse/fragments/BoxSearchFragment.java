package com.box.android.browse.fragments;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.media3.common.C;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.browse.R;
import com.box.android.browse.activities.FilterSearchResults;
import com.box.android.browse.activities.FilterSearchResultsActivity;
import com.box.android.browse.adapters.BoxItemAdapter;
import com.box.android.browse.adapters.BoxSearchAdapter;
import com.box.android.browse.adapters.FilterButtonItem;
import com.box.android.browse.adapters.ResultsHeader;
import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.domain.controller.BoxResponseIntent;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.box.androidsdk.content.requests.BoxResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class BoxSearchFragment extends BoxBrowseFragment {
    private static final int DEFAULT_LIMIT = 20;
    public static final String EXTRA_IS_REDESIGNED = "SearchFragment.IsRedesigned";
    public static final String EXTRA_PARENT_FOLDER = "SearchFragment.ExtraParentFolder";
    public static final String EXTRA_SEARCH_FILTERS = "SearchFragment.SearchFilters";
    private static final long ONE_MB = 1000000;
    private static final String OUT_ITEM = "outItem";
    private static final String OUT_OFFSET = "outOffset";
    public static final String OUT_QUERY = "outQuery";
    public static final int REQUEST_FILTER_SEARCH_RESULTS = 228;
    protected boolean mIsRedesigned;
    private HashMap<BoxSearchFilters.ItemType, String[]> mItemTypeToExtensions;
    private int mLimit;
    protected int mOffset = 0;
    private BoxFolder mParentFolder;
    private View mRedesignedFilterButton;
    protected BoxRequestsSearch.Search mRequest;
    private TextView mResultsTextInFilesHeader;
    protected BoxSearchFilters mSearchFilters;
    private View mSearchFiltersHeader;
    protected String mSearchQuery;

    @Override // com.box.android.browse.fragments.BoxBrowseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSearchQuery = null;
        if (getArguments() != null) {
            this.mLimit = getArguments().getInt("argLimit", 20);
            this.mSearchQuery = getArguments().getString(OUT_QUERY, null);
            this.mParentFolder = (BoxFolder) getArguments().getSerializable(EXTRA_PARENT_FOLDER);
            this.mSearchFilters = (BoxSearchFilters) getArguments().getSerializable(EXTRA_SEARCH_FILTERS);
            this.mIsRedesigned = getArguments().getBoolean(EXTRA_IS_REDESIGNED, false);
        }
        if (bundle != null) {
            this.mOffset = bundle.getInt(OUT_OFFSET);
            this.mSearchQuery = bundle.getString(OUT_QUERY, null);
            this.mSearchFilters = (BoxSearchFilters) bundle.getSerializable(EXTRA_SEARCH_FILTERS);
        }
        if (this.mSearchFilters == null) {
            this.mSearchFilters = new BoxSearchFilters();
        }
        ArrayList arrayList = new ArrayList(SupportedFileExtensions.INSTANCE.getDOCUMENT_EXTENSIONS());
        arrayList.addAll(SupportedFileExtensions.INSTANCE.getMICROSOFT_WORD_EXTENSIONS());
        arrayList.remove("pdf");
        ArrayList arrayList2 = new ArrayList(SupportedFileExtensions.INSTANCE.getIMAGE_EXTENSIONS());
        arrayList2.add(SupportedFileExtensions.AI_EXTENSION);
        arrayList2.add(SupportedFileExtensions.GIF_EXTENSION);
        arrayList2.add(SupportedFileExtensions.PSD_EXTENSION);
        arrayList2.addAll(SupportedFileExtensions.INSTANCE.getVECTOR_EXTENSIONS());
        ArrayList arrayList3 = new ArrayList(SupportedFileExtensions.INSTANCE.getPRESENTATION_EXTENSIONS());
        arrayList3.addAll(SupportedFileExtensions.INSTANCE.getMICROSOFT_POWERPOINT_EXTENSIONS());
        ArrayList arrayList4 = new ArrayList(SupportedFileExtensions.INSTANCE.getSPREADSHEET_EXTENSIONS());
        arrayList4.addAll(SupportedFileExtensions.INSTANCE.getMICROSOFT_EXCEL_EXTENSIONS());
        HashMap<BoxSearchFilters.ItemType, String[]> map = new HashMap<>();
        this.mItemTypeToExtensions = map;
        map.put(BoxSearchFilters.ItemType.Audio, (String[]) SupportedFileExtensions.INSTANCE.getAUDIO_EXTENSIONS().toArray(new String[0]));
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.Autocad, new String[]{SupportedFileExtensions.DWG_EXTENSION});
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.BoxNote, new String[]{"boxnote"});
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.Document, (String[]) arrayList.toArray(new String[0]));
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.Image, (String[]) arrayList2.toArray(new String[0]));
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.Pdf, new String[]{"pdf"});
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.Presentation, (String[]) arrayList3.toArray(new String[0]));
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.Spreadsheet, (String[]) arrayList4.toArray(new String[0]));
        this.mItemTypeToExtensions.put(BoxSearchFilters.ItemType.Video, (String[]) SupportedFileExtensions.INSTANCE.getVIDEO_EXTENSIONS().toArray(new String[0]));
        this.mRequest = null;
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BoxFolder boxFolder;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewFindViewById = viewOnCreateView.findViewById(R.id.filterResultsHeader);
        this.mSearchFiltersHeader = viewFindViewById;
        if (this.mIsRedesigned) {
            View viewFindViewById2 = viewOnCreateView.findViewById(R.id.redesignedFilterButton);
            this.mRedesignedFilterButton = viewFindViewById2;
            if (viewFindViewById2 != null) {
                String str = this.mSearchQuery;
                this.mRedesignedFilterButton.setVisibility(str != null && !str.isEmpty() ? 0 : 8);
                this.mRedesignedFilterButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxSearchFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateView$0(view);
                    }
                });
            }
            TextView textView = (TextView) viewOnCreateView.findViewById(R.id.resultsTextInFilesHeader);
            this.mResultsTextInFilesHeader = textView;
            if (textView != null && (boxFolder = this.mParentFolder) != null && !TextUtils.isEmpty(boxFolder.getName())) {
                this.mResultsTextInFilesHeader.setText(Html.fromHtml(getResources().getString(R.string.box_browsesdk_search_results_header, this.mParentFolder.getName())));
            }
            setupSearchFiltersHeader();
            if (this.mAdapter instanceof BoxSearchAdapter) {
                ((BoxSearchAdapter) this.mAdapter).setFilterButtonClickListener(new Runnable() { // from class: com.box.android.browse.fragments.BoxSearchFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.startFilterActivity();
                    }
                });
            }
            return viewOnCreateView;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxSearchFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        setupSearchFiltersHeader();
        return viewOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startFilterActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startFilterActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        search(this.mSearchQuery);
    }

    private void setFilterHeaderVisibility(int i) {
        View view;
        if (this.mIsRedesigned || (view = this.mSearchFiltersHeader) == null) {
            return;
        }
        if (i == 0) {
            setupSearchFiltersHeader();
        } else {
            view.setVisibility(8);
        }
    }

    protected void startFilterActivity() {
        if (this.mIsRedesigned) {
            startActivityForResult(FilterSearchResultsActivity.newFilterSearchResultsIntent(getActivity(), this.mSearchFilters), REQUEST_FILTER_SEARCH_RESULTS);
        } else {
            startActivityForResult(FilterSearchResults.newFilterSearchResultsIntent(getActivity(), this.mSearchFilters), REQUEST_FILTER_SEARCH_RESULTS);
        }
    }

    protected void setupSearchFiltersHeader() {
        if (this.mSearchFiltersHeader == null) {
            return;
        }
        BoxSearchFilters boxSearchFilters = this.mSearchFilters;
        if (boxSearchFilters != null && boxSearchFilters.anyFiltersSet()) {
            int i = 0;
            this.mSearchFiltersHeader.setVisibility(0);
            if (this.mIsRedesigned) {
                LinearLayout linearLayout = (LinearLayout) this.mSearchFiltersHeader.findViewById(R.id.filterChipsContainer);
                linearLayout.removeAllViews();
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(linearLayout.getContext());
                BoxSearchFilters.ItemType[] itemTypeArrValues = BoxSearchFilters.ItemType.values();
                int length = itemTypeArrValues.length;
                while (i < length) {
                    final BoxSearchFilters.ItemType itemType = itemTypeArrValues[i];
                    if (this.mSearchFilters.mItemTypes.contains(itemType)) {
                        addFilterChip(layoutInflaterFrom, linearLayout, itemType.getString(getContext()), new Runnable() { // from class: com.box.android.browse.fragments.BoxSearchFragment$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setupSearchFiltersHeader$2(itemType);
                            }
                        });
                    }
                    i++;
                }
                if (this.mSearchFilters.mItemModifiedDate != BoxSearchFilters.ItemModifiedDate.Any) {
                    addFilterChip(layoutInflaterFrom, linearLayout, this.mSearchFilters.mItemModifiedDate.getString(getContext()), new Runnable() { // from class: com.box.android.browse.fragments.BoxSearchFragment$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setupSearchFiltersHeader$3();
                        }
                    });
                }
                if (this.mSearchFilters.mItemSize != BoxSearchFilters.ItemSize.Any) {
                    addFilterChip(layoutInflaterFrom, linearLayout, this.mSearchFilters.mItemSize.getString(getContext()), new Runnable() { // from class: com.box.android.browse.fragments.BoxSearchFragment$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setupSearchFiltersHeader$4();
                        }
                    });
                    return;
                }
                return;
            }
            TextView textView = (TextView) this.mSearchFiltersHeader.findViewById(R.id.filterResults);
            ArrayList arrayList = new ArrayList();
            BoxSearchFilters.ItemType[] itemTypeArrValues2 = BoxSearchFilters.ItemType.values();
            int length2 = itemTypeArrValues2.length;
            while (i < length2) {
                BoxSearchFilters.ItemType itemType2 = itemTypeArrValues2[i];
                if (this.mSearchFilters.mItemTypes.contains(itemType2)) {
                    arrayList.add(itemType2.getString(getContext()));
                }
                i++;
            }
            if (this.mSearchFilters.mItemModifiedDate != BoxSearchFilters.ItemModifiedDate.Any) {
                arrayList.add(this.mSearchFilters.mItemModifiedDate.getString(getContext()));
            }
            if (this.mSearchFilters.mItemSize != BoxSearchFilters.ItemSize.Any) {
                arrayList.add(this.mSearchFilters.mItemSize.getString(getContext()));
            }
            textView.setText(TextUtils.join(getResources().getString(R.string.search_filter_label_delimiter), arrayList));
            return;
        }
        this.mSearchFiltersHeader.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupSearchFiltersHeader$2(BoxSearchFilters.ItemType itemType) {
        this.mSearchFilters.removeItemType(itemType);
        setupSearchFiltersHeader();
        search();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupSearchFiltersHeader$3() {
        this.mSearchFilters.setItemModifiedDate(BoxSearchFilters.ItemModifiedDate.Any);
        setupSearchFiltersHeader();
        search();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupSearchFiltersHeader$4() {
        this.mSearchFilters.setItemSize(BoxSearchFilters.ItemSize.Any);
        setupSearchFiltersHeader();
        search();
    }

    private void addFilterChip(LayoutInflater layoutInflater, LinearLayout linearLayout, String str, final Runnable runnable) {
        View viewInflate = layoutInflater.inflate(R.layout.box_browsesdk_search_filter_chip, (ViewGroup) linearLayout, false);
        ((TextView) viewInflate.findViewById(R.id.chipText)).setText(str);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.fragments.BoxSearchFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                runnable.run();
            }
        });
        linearLayout.addView(viewInflate);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 228) {
            this.mSearchFilters = (BoxSearchFilters) intent.getSerializableExtra(EXTRA_SEARCH_FILTERS);
            setupSearchFiltersHeader();
            search();
        }
    }

    public BoxFolder getParentFolder() {
        return this.mParentFolder;
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(BoxRequestsSearch.Search.class.getName());
        return intentFilter;
    }

    public String getSearchQuery() {
        String str = this.mSearchQuery;
        return str != null ? str : "";
    }

    public void search(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.equals(this.mSearchQuery) || this.mRequest == null) {
                this.mSearchQuery = strTrim;
                search();
            }
        }
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    protected void initRecyclerView(RecyclerView recyclerView) {
        super.initRecyclerView(recyclerView);
        if (this.mIsRedesigned) {
            ((BoxItemDividerDecoration) recyclerView.getItemDecorationAt(0)).setSkipLeadingPositions(0);
        }
    }

    protected void search() {
        BoxSearchFilters boxSearchFilters;
        TextView textView = this.mResultsTextInFilesHeader;
        if (textView != null) {
            textView.setVisibility(8);
        }
        String str = this.mSearchQuery;
        if (str != null && !str.equals("")) {
            if (this.mIsRedesigned) {
                View view = this.mRedesignedFilterButton;
                if (view != null) {
                    view.setVisibility(0);
                }
                if (this.mSearchFiltersHeader != null && (boxSearchFilters = this.mSearchFilters) != null && boxSearchFilters.anyFiltersSet()) {
                    this.mSearchFiltersHeader.setVisibility(0);
                }
            }
            this.mRequest = getController().getSearchRequest(this.mSearchQuery);
            this.mAdapter.removeAll();
            loadItems();
            this.mItems = null;
            this.mAdapter.notifyDataSetChanged();
            notifyUpdateListeners();
            return;
        }
        if (this.mIsRedesigned) {
            View view2 = this.mRedesignedFilterButton;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.mSearchFiltersHeader;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        this.mRequest = null;
        this.mProgress.setVisibility(8);
        setFilterHeaderVisibility(8);
        this.mItems = null;
        this.mAdapter.removeAll();
        this.mAdapter.notifyDataSetChanged();
        notifyUpdateListeners();
    }

    protected void executeRequest() {
        getController().execute(this.mRequest);
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    protected void loadItems() {
        if (this.mRequest != null) {
            this.mProgress.setVisibility(0);
            this.mOffset = 0;
            this.mRequest.setLimit(this.mLimit).setOffset(this.mOffset).limitAncestorFolderIds(new String[]{this.mParentFolder.getUserId()});
            BoxSearchFilters boxSearchFilters = this.mSearchFilters;
            if (boxSearchFilters != null) {
                HashSet<BoxSearchFilters.ItemType> hashSet = boxSearchFilters.mItemTypes;
                if (hashSet != null && hashSet.size() > 0) {
                    if (hashSet.contains(BoxSearchFilters.ItemType.Folder)) {
                        this.mRequest.limitType("folder");
                    } else {
                        this.mRequest.limitType("file");
                        HashSet hashSet2 = new HashSet();
                        Iterator<BoxSearchFilters.ItemType> it = hashSet.iterator();
                        while (it.hasNext()) {
                            for (String str : this.mItemTypeToExtensions.get(it.next())) {
                                hashSet2.add(str);
                            }
                        }
                        this.mRequest.limitFileExtensions((String[]) hashSet2.toArray(new String[hashSet2.size()]));
                    }
                }
                if (this.mSearchFilters.mItemModifiedDate != BoxSearchFilters.ItemModifiedDate.Any) {
                    Calendar calendar = Calendar.getInstance();
                    int i = AnonymousClass1.$SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemModifiedDate[this.mSearchFilters.mItemModifiedDate.ordinal()];
                    if (i == 1) {
                        calendar.add(5, -1);
                    } else if (i == 2) {
                        calendar.add(5, -7);
                    } else if (i == 3) {
                        calendar.add(2, -1);
                    } else if (i == 4) {
                        calendar.add(1, -1);
                    }
                    this.mRequest.limitLastUpdateTime(calendar.getTime(), null);
                }
                int i2 = AnonymousClass1.$SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize[this.mSearchFilters.mItemSize.ordinal()];
                if (i2 == 1) {
                    this.mRequest.limitSizeRange(0L, 1000000L);
                } else if (i2 == 2) {
                    this.mRequest.limitSizeRange(1000000L, DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US);
                } else if (i2 == 3) {
                    this.mRequest.limitSizeRange(DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US, 25000000L);
                } else if (i2 == 4) {
                    this.mRequest.limitSizeRange(25000000L, 100000000L);
                } else if (i2 == 5) {
                    this.mRequest.limitSizeRange(100000000L, C.NANOS_PER_SECOND);
                }
            }
            executeRequest();
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.fragments.BoxSearchFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemModifiedDate;
        static final /* synthetic */ int[] $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize;

        static {
            int[] iArr = new int[BoxSearchFilters.ItemSize.values().length];
            $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize = iArr;
            try {
                iArr[BoxSearchFilters.ItemSize.lessThanOneMb.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize[BoxSearchFilters.ItemSize.OneMbToFiveMb.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize[BoxSearchFilters.ItemSize.FiveMbToTwentyFiveMb.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize[BoxSearchFilters.ItemSize.TwentyFiveMbToHundredMb.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize[BoxSearchFilters.ItemSize.HundredMbToOneGB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemSize[BoxSearchFilters.ItemSize.Any.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[BoxSearchFilters.ItemModifiedDate.values().length];
            $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemModifiedDate = iArr2;
            try {
                iArr2[BoxSearchFilters.ItemModifiedDate.PastDay.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemModifiedDate[BoxSearchFilters.ItemModifiedDate.PastWeek.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemModifiedDate[BoxSearchFilters.ItemModifiedDate.PastMonth.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$box$android$browse$models$BoxSearchFilters$ItemModifiedDate[BoxSearchFilters.ItemModifiedDate.PastYear.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    protected BoxItemAdapter createAdapter() {
        return new BoxSearchAdapter(getActivity(), getController(), this.mThumbnailManager, this);
    }

    protected void updateTo(ArrayList<BoxItem> arrayList) {
        if (getActivity() == null) {
            return;
        }
        this.mProgress.setVisibility(8);
        setFilterHeaderVisibility(0);
        this.mItems = new ArrayList<>();
        this.mItems.addAll(arrayList);
        if (!this.mIsRedesigned && !this.mItems.isEmpty() && !(this.mItems.get(0) instanceof ResultsHeader)) {
            this.mItems.add(0, new ResultsHeader(this.mParentFolder));
        }
        updateRedesignedResultsInFilesHeader();
        this.mAdapter.updateTo(this.mItems);
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    protected void updateItems(ArrayList<BoxItem> arrayList) {
        if (getActivity() == null) {
            return;
        }
        this.mProgress.setVisibility(8);
        int itemCount = this.mAdapter.getItemCount() > 0 ? this.mAdapter.getItemCount() - 1 : 0;
        ArrayList<BoxItem> arrayList2 = new ArrayList<>();
        ArrayList<BoxItem> items = this.mAdapter.getItems();
        HashSet hashSet = new HashSet(items.size());
        Iterator<BoxItem> it = items.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getUserId());
        }
        for (BoxItem boxItem : arrayList) {
            if (!(boxItem instanceof FilterButtonItem) && (getItemFilter() == null || getItemFilter().accept(boxItem))) {
                if (!hashSet.contains(boxItem.getUserId())) {
                    arrayList2.add(boxItem);
                }
            }
        }
        if (itemCount > 0) {
            this.mItems.addAll(arrayList2);
            this.mAdapter.add(arrayList2);
            return;
        }
        this.mItems = arrayList2;
        if (!this.mIsRedesigned && arrayList2.size() > 0 && !(arrayList2.get(0) instanceof ResultsHeader)) {
            this.mItems.add(0, new ResultsHeader(this.mParentFolder));
        }
        updateRedesignedResultsInFilesHeader();
        this.mAdapter.updateTo(this.mItems);
    }

    private void updateRedesignedResultsInFilesHeader() {
        if (this.mResultsTextInFilesHeader != null) {
            BoxFolder boxFolder = this.mParentFolder;
            this.mResultsTextInFilesHeader.setVisibility((this.mItems.isEmpty() || !(boxFolder != null && !TextUtils.isEmpty(boxFolder.getName()))) ? 8 : 0);
        }
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(OUT_ITEM, this.mRequest);
        bundle.putInt(OUT_OFFSET, this.mOffset);
        String str = this.mSearchQuery;
        if (str != null) {
            bundle.putString(OUT_QUERY, str);
        }
        bundle.putSerializable(EXTRA_SEARCH_FILTERS, this.mSearchFilters);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    protected void handleResponse(BoxResponseIntent boxResponseIntent) {
        super.handleResponse(boxResponseIntent);
        BoxResponse response = boxResponseIntent.getResponse();
        if (!response.isSuccess() && !(response.getException() instanceof BoxException.CacheResultUnavailable) && (response.getRequest() instanceof BoxRequestsSearch.Search)) {
            Toast.makeText(getContext(), R.string.box_browsesdk_problem_performing_search, 1).show();
        }
        if (boxResponseIntent.getAction().equals(BoxRequestsSearch.Search.class.getName())) {
            onItemsFetched(boxResponseIntent.getResponse());
        }
    }

    protected void onItemsFetched(BoxResponse boxResponse) {
        if (!boxResponse.isSuccess()) {
            checkConnectivity();
            return;
        }
        if (boxResponse.getRequest().equals(this.mRequest)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(BoxSearchAdapter.LOAD_MORE_ID);
            this.mAdapter.remove(arrayList);
            if (boxResponse.getResult() instanceof BoxIteratorItems) {
                BoxIteratorItems boxIteratorItems = (BoxIteratorItems) boxResponse.getResult();
                if (((BoxRequestsSearch.Search) boxResponse.getRequest()).getOffset().intValue() == 0) {
                    this.mOffset = 0;
                    updateTo(boxIteratorItems.getEntries());
                } else {
                    updateItems(boxIteratorItems.getEntries());
                }
                this.mOffset += boxIteratorItems.size();
                if (boxIteratorItems.fullSize() != null && this.mOffset < boxIteratorItems.fullSize().longValue()) {
                    int iCalculateBestOffset = calculateBestOffset(this.mOffset, this.mLimit);
                    this.mOffset = iCalculateBestOffset;
                    ((BoxSearchAdapter) this.mAdapter).addLoadMoreItem(this.mRequest.setOffset(iCalculateBestOffset).setLimit(this.mLimit));
                }
            }
            setFilterHeaderVisibility(0);
        }
    }

    private static int calculateBestOffset(int i, int i2) {
        return ((int) Math.ceil(((double) i) / ((double) i2))) * i2;
    }

    public static class Builder extends BoxBrowseFragment.Builder<BoxSearchFragment> {
        public Builder(BoxSession boxSession, String str, BoxFolder boxFolder) {
            this.mArgs.putString(BoxBrowseFragment.ARG_USER_ID, boxSession.getUserId());
            this.mArgs.putInt("argLimit", 20);
            this.mArgs.putString(BoxSearchFragment.OUT_QUERY, str);
            this.mArgs.putSerializable(BoxSearchFragment.EXTRA_PARENT_FOLDER, BoxFolder.createFromIdAndName(boxFolder.getUserId(), boxFolder.getName()));
        }

        public Builder(BoxSession boxSession, String str, BoxFolder boxFolder, BoxSearchFilters boxSearchFilters) {
            this.mArgs.putString(BoxBrowseFragment.ARG_USER_ID, boxSession.getUserId());
            this.mArgs.putInt("argLimit", 20);
            this.mArgs.putString(BoxSearchFragment.OUT_QUERY, str);
            this.mArgs.putSerializable(BoxSearchFragment.EXTRA_PARENT_FOLDER, BoxFolder.createFromIdAndName(boxFolder.getUserId(), boxFolder.getName()));
            this.mArgs.putSerializable(BoxSearchFragment.EXTRA_SEARCH_FILTERS, boxSearchFilters);
        }

        public Builder(BoxSession boxSession, BoxFolder boxFolder) {
            this.mArgs.putString(BoxBrowseFragment.ARG_USER_ID, boxSession.getUserId());
            this.mArgs.putInt("argLimit", 20);
            this.mArgs.putSerializable(BoxSearchFragment.EXTRA_PARENT_FOLDER, BoxFolder.createFromIdAndName(boxFolder.getUserId(), boxFolder.getName()));
        }

        public Builder setLimit(int i) {
            this.mArgs.putInt("argLimit", i);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.box.android.browse.fragments.BoxBrowseFragment.Builder
        public BoxSearchFragment getInstance() {
            return new BoxSearchFragment();
        }
    }
}

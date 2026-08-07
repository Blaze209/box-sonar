package com.box.android.browse.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import com.box.android.browse.R;
import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.metrics.PerformanceType;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.models.observability.PerformanceEvent;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSearchItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItemDelete;
import com.box.androidsdk.content.requests.BoxRequestItemUpdate;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.box.androidsdk.content.requests.BoxResponse;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class SearchFragment extends Hilt_SearchFragment implements BoxFragmentInterface {
    private static String EXTRA_TITLE = "SearchFragment.ExtraTitle";
    private static final String SEARCH_RESULT_ITEM_TYPE = "item";
    private static final String SEARCH_RESULT_SHARED_LINK_TYPE = "shared link";
    public static final String TAG = "SearchFragment.TAG";
    private Function1<BoxSearchItem, Unit> itemClickListener;
    private Function1<BoxSearchItem, Unit> itemMoreActionClickListener;

    @Inject
    IBaseModelController mBaseMoco;
    private View mEmptyView;
    private ImageView mFilterIcon;
    private View mSearchFiltersHeader;

    @Inject
    protected TimeLogHelper mTimeLogHelper;

    public interface AppSearchListener {
        void loadRecentSearch();
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 4;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment, com.box.android.browse.fragments.BoxBrowseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        instantiateSecondaryActionListener();
    }

    public void setItemClickListener(Function1<BoxSearchItem, Unit> function1) {
        this.itemClickListener = function1;
    }

    public void setItemMoreActionClickListener(Function1<BoxSearchItem, Unit> function1) {
        this.itemMoreActionClickListener = function1;
        if (getOnSecondaryActionListener() instanceof SecondaryActionListener) {
            ((SecondaryActionListener) getOnSecondaryActionListener()).setMoreActionClickListener(this.itemMoreActionClickListener);
        }
    }

    protected void instantiateSecondaryActionListener() {
        if (getOnSecondaryActionListener() == null) {
            setSecondaryActionListener(new SecondaryActionListener(this, this.itemMoreActionClickListener));
        } else if (getOnSecondaryActionListener() instanceof SecondaryActionListener) {
            ((SecondaryActionListener) getOnSecondaryActionListener()).setFragment(this);
            ((SecondaryActionListener) getOnSecondaryActionListener()).setMoreActionClickListener(this.itemMoreActionClickListener);
        }
    }

    public static class SecondaryActionListener implements BoxBrowseFragment.OnSecondaryActionListener, Serializable {
        private transient Function1<BoxSearchItem, Unit> itemMoreActionClickListener;
        private transient BoxBrowseFragment mFragment;

        public SecondaryActionListener(BoxBrowseFragment boxBrowseFragment, Function1<BoxSearchItem, Unit> function1) {
            this.mFragment = boxBrowseFragment;
            this.itemMoreActionClickListener = function1;
        }

        public void setFragment(BoxBrowseFragment boxBrowseFragment) {
            this.mFragment = boxBrowseFragment;
        }

        public void setMoreActionClickListener(Function1<BoxSearchItem, Unit> function1) {
            this.itemMoreActionClickListener = function1;
        }

        @Override // com.box.android.browse.fragments.BoxBrowseFragment.OnSecondaryActionListener
        public boolean onSecondaryAction(BoxItem boxItem) {
            Function1<BoxSearchItem, Unit> function1 = this.itemMoreActionClickListener;
            if (function1 != null && (boxItem instanceof BoxSearchItem)) {
                function1.invoke((BoxSearchItem) boxItem);
                return false;
            }
            if (!(this.mFragment.getActivity() instanceof IBoxFragmentActivity)) {
                return false;
            }
            ((IBoxFragmentActivity) this.mFragment.getActivity()).showBottomSheet(boxItem);
            return false;
        }
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment, com.box.android.browse.adapters.BoxItemAdapter.OnInteractionListener
    public BoxBrowseFragment.OnItemClickListener getOnItemClickListener() {
        if (this.itemClickListener != null) {
            return new BoxBrowseFragment.OnItemClickListener() { // from class: com.box.android.browse.fragments.SearchFragment$$ExternalSyntheticLambda1
                @Override // com.box.android.browse.fragments.BoxBrowseFragment.OnItemClickListener
                public final void onItemClick(BoxItem boxItem) {
                    this.f$0.lambda$getOnItemClickListener$0(boxItem);
                }
            };
        }
        return super.getOnItemClickListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getOnItemClickListener$0(BoxItem boxItem) {
        if (boxItem instanceof BoxSearchItem) {
            this.itemClickListener.invoke((BoxSearchItem) boxItem);
        }
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    protected int getLayout() {
        return this.mIsRedesigned ? R.layout.box_browsesdk_fragment_search_redesigned : R.layout.browse;
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment, com.box.android.browse.fragments.BoxBrowseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ImageView imageView;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mFilterIcon = (ImageView) viewOnCreateView.findViewById(R.id.filterIcon);
        ((ImageView) viewOnCreateView.findViewById(R.id.empty_folder_image)).setImageResource(R.drawable.ic_missing140);
        ((TextView) viewOnCreateView.findViewById(R.id.empty_folder_text)).setText(R.string.empty_search_text);
        ((TextView) viewOnCreateView.findViewById(R.id.empty_folder_subtext)).setText(R.string.empty_search_subtext);
        this.mEmptyView = viewOnCreateView.findViewById(R.id.empty_folder_layout);
        if (this.mSwipeRefresh != null) {
            this.mSwipeRefresh.setEnabled(false);
        }
        if (getActivity() instanceof AppSearchListener) {
            ((AppSearchListener) getActivity()).loadRecentSearch();
        }
        if (getActivity() instanceof IBoxFragmentActivity) {
            ((IBoxFragmentActivity) getActivity()).dismissOutdatedSnackbar(this);
        }
        this.mSearchFiltersHeader = viewOnCreateView.findViewById(R.id.filterResultsHeader);
        setupSearchFiltersHeader();
        View view = this.mSearchFiltersHeader;
        if (view != null) {
            view.setOnClickListener(null);
        }
        if (this.mSearchFilters != null && this.mSearchFilters.anyFiltersSet() && (imageView = this.mFilterIcon) != null) {
            imageView.setVisibility(8);
        }
        this.mAdapter.setAnalyticsListener(new BoxBrowseFragment.OnItemClickListener() { // from class: com.box.android.browse.fragments.SearchFragment$$ExternalSyntheticLambda0
            @Override // com.box.android.browse.fragments.BoxBrowseFragment.OnItemClickListener
            public final void onItemClick(BoxItem boxItem) {
                this.f$0.lambda$onCreateView$1(boxItem);
            }
        });
        return viewOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(BoxItem boxItem) {
        if (this.mTimeLogHelper.isUnLoggedSessionInProgress()) {
            this.mTimeLogHelper.logSession();
        }
        int iIndexOf = this.mItems.indexOf(boxItem);
        boolean z = (boxItem instanceof BoxSearchItem) && ((BoxSearchItem) boxItem).getAccessibleSharedLink() != null;
        if (iIndexOf != -1) {
            BoxAmplitudeAnalytics.createSearchEventBuilder().logResultTapped(iIndexOf, z ? SEARCH_RESULT_SHARED_LINK_TYPE : "item");
        }
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.featureFlips.getMainScreenRedesign().getEnabled() && BoxAmplitudeAnalytics.getInstance().setCurrentPage(getAmplitudePageName())) {
            BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).logEvent(String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, getAmplitudePageName()));
        }
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment
    protected void setEmptyState(boolean z) {
        this.mEmptyView.setVisibility(z ? 0 : 8);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFragment(BoxMessage<?> boxMessage) {
        if (boxMessage instanceof BoxResponseMessage) {
            BoxResponseMessage boxResponseMessage = (BoxResponseMessage) boxMessage;
            BoxRequest request = boxResponseMessage.getRequest();
            BoxResponse response = boxResponseMessage.getResponse();
            if (request instanceof BoxRequestsSearch.Search) {
                onItemsFetched(response);
                return;
            }
            if (request instanceof BoxRequestItemUpdate) {
                BoxItem boxItem = (BoxItem) response.getResult();
                if (boxItem != null) {
                    this.mAdapter.update(boxItem);
                    return;
                }
                return;
            }
            if (request instanceof BoxRequestItemDelete) {
                this.mAdapter.remove(CommonBoxUtil.createWrapperList(((BoxRequestItemDelete) request).getId()));
            }
        }
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment
    protected void onItemsFetched(final BoxResponse boxResponse) {
        this.gen204PerformanceLogger.registerEnd(PerformanceType.SEARCH_API, boxResponse.getRequest().getRequestId().toString(), new Function1() { // from class: com.box.android.browse.fragments.SearchFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchFragment.lambda$onItemsFetched$2(boxResponse, (Long) obj);
            }
        });
        if (boxResponse.isSuccess()) {
            this.mTimeLogHelper.startSession();
        }
        super.onItemsFetched(boxResponse);
    }

    static /* synthetic */ Gen204Event lambda$onItemsFetched$2(BoxResponse boxResponse, Long l) {
        return new PerformanceEvent(PerformanceEvent.Type.SEARCH_API, boxResponse.isSuccess() ? "" : boxResponse.getException().getMessage(), l.longValue(), boxResponse.isSuccess() ? PerformanceEvent.Status.SUCCESS : PerformanceEvent.Status.FAILURE);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return getArguments().getString(EXTRA_TITLE);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean shouldUpdateFragment(BoxMessage<?> boxMessage) {
        if (!(boxMessage instanceof BoxResponseMessage)) {
            return false;
        }
        BoxRequest request = ((BoxResponseMessage) boxMessage).getRequest();
        return (request instanceof BoxRequestsSearch.Search) || (request instanceof BoxRequestItemDelete) || (request instanceof BoxRequestItemUpdate);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (getActivity() instanceof IBoxFragmentActivity) {
            Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.mainToolbar);
            if (toolbar != null) {
                toolbar.setVisibility(0);
            }
            View viewFindViewById = getActivity().findViewById(R.id.searchLayout);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            ListView listView = (ListView) getActivity().findViewById(R.id.recentSearchesListView);
            if (listView != null) {
                listView.setVisibility(8);
            }
        }
        super.onDestroyView();
    }

    public static class Builder extends BoxSearchFragment.Builder {
        public Builder(BoxSession boxSession, String str, BoxFolder boxFolder, BoxSearchFilters boxSearchFilters) {
            super(boxSession, str, boxFolder, boxSearchFilters);
        }

        public Builder(BoxSession boxSession, String str, BoxFolder boxFolder) {
            super(boxSession, str, boxFolder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.box.android.browse.fragments.BoxSearchFragment.Builder, com.box.android.browse.fragments.BoxBrowseFragment.Builder
        public BoxSearchFragment getInstance() {
            return new SearchFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mTimeLogHelper.isUnLoggedSessionInProgress()) {
            this.mTimeLogHelper.logSession();
        }
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment
    protected void executeRequest() {
        this.gen204PerformanceLogger.registerStart(PerformanceType.SEARCH_API, this.mRequest.getRequestId().toString());
        this.mBaseMoco.performRemote(this.mRequest);
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment
    protected void search() {
        if (this.mEmptyView != null) {
            if (StringUtils.isEmpty(this.mSearchQuery)) {
                this.mEmptyView.findViewById(R.id.empty_folder_text_container).setVisibility(8);
                this.mEmptyView.setVisibility(0);
            }
            super.search();
        }
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment, com.box.android.browse.fragments.BoxBrowseFragment
    protected void loadItems() {
        if (this.mRequest != null) {
            this.mEmptyView.findViewById(R.id.empty_folder_text_container).setVisibility(0);
            this.mEmptyView.setVisibility(8);
        }
        super.loadItems();
    }

    public void applyFilters(BoxSearchFilters boxSearchFilters) {
        ImageView imageView;
        this.mSearchFilters = boxSearchFilters;
        setupSearchFiltersHeader();
        if (this.mSearchFilters.anyFiltersSet() && (imageView = this.mFilterIcon) != null) {
            imageView.setVisibility(8);
        }
        search();
    }

    @Override // com.box.android.browse.fragments.BoxSearchFragment
    protected void setupSearchFiltersHeader() {
        if (this.mIsRedesigned) {
            super.setupSearchFiltersHeader();
        } else {
            if (this.mSearchFiltersHeader == null) {
                return;
            }
            if (this.mSearchFilters != null && this.mSearchFilters.anyFiltersSet()) {
                this.mSearchFiltersHeader.setVisibility(0);
            }
            super.setupSearchFiltersHeader();
        }
    }

    public BoxSearchFilters getSearchFilters() {
        return this.mSearchFilters;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_SEARCH;
    }

    public static class TimeLogHelper {
        private long mStartTime = -1;

        void startSession() {
            this.mStartTime = SystemClock.elapsedRealtime();
        }

        void logSession() {
            BoxAmplitudeAnalytics.createSearchEventBuilder().logTimeSpent(SystemClock.elapsedRealtime() - this.mStartTime);
            finishSession();
        }

        boolean isUnLoggedSessionInProgress() {
            return this.mStartTime > 0;
        }

        void finishSession() {
            this.mStartTime = -1L;
        }
    }

    public static class SearchActionLogHelper {
        String mRecentClicked = null;
        boolean mSearchLogged = false;

        public void setRecentClicked(String str) {
            this.mRecentClicked = str;
        }

        public boolean isQueryRecentClicked(String str) {
            return StringUtils.equals(str, this.mRecentClicked);
        }

        public void logRecentAction() {
            BoxAmplitudeAnalytics.createSearchEventBuilder().logAction(BoxAmplitudeAnalytics.SearchEventPropertyBuilder.SearchAction.SEARCH_ACTION_RECENT);
            this.mSearchLogged = true;
        }

        public void logTypingAction() {
            BoxAmplitudeAnalytics.createSearchEventBuilder().logAction(BoxAmplitudeAnalytics.SearchEventPropertyBuilder.SearchAction.SEARCH_ACTION_TYPING);
            this.mSearchLogged = true;
        }

        public boolean isSearchLogged() {
            return this.mSearchLogged;
        }

        public void clearSession() {
            this.mSearchLogged = false;
            this.mRecentClicked = null;
        }
    }
}

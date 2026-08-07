package com.pspdfkit.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.Nutrient;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.configuration.search.SearchConfiguration;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.search.CompareOptions;
import com.pspdfkit.document.search.SearchOptions;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.document.search.TextSearch;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.z50;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.listeners.OnVisibilityChangedListenerManager;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0006\b!\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002efB#\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010#\u001a\u00020\u001dJ\b\u00103\u001a\u000204H\u0004J\u0018\u0010\u0014\u001a\u0002042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00105\u001a\u000206H\u0017J\u0010\u00107\u001a\u0002042\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0002042\u0006\u00108\u001a\u000209H\u0016J\b\u0010;\u001a\u000204H\u0016J\b\u0010<\u001a\u000204H\u0016J\b\u0010=\u001a\u000204H\u0002J\b\u0010>\u001a\u00020?H\u0016J\u0006\u0010@\u001a\u000204J\b\u0010A\u001a\u000204H\u0014J\b\u0010B\u001a\u000204H\u0004J\b\u0010C\u001a\u000204H\u0004J\b\u0010D\u001a\u000204H\u0016J\u0018\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u0012\u0010I\u001a\u0002042\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020G2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MH\u0007J\u000e\u0010O\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010PJ\u0012\u0010Q\u001a\u0002042\b\u0010R\u001a\u0004\u0018\u000102H\u0004J\u0018\u0010S\u001a\u0002042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\tH\u0016J\b\u0010U\u001a\u00020VH\u0014J\u0010\u0010W\u001a\u0002042\u0006\u0010X\u001a\u00020VH\u0014J\b\u0010Y\u001a\u000204H$J\u0010\u0010Z\u001a\u0002042\u0006\u0010[\u001a\u00020GH$J\u0016\u0010\\\u001a\u0002042\f\u0010]\u001a\b\u0012\u0004\u0012\u0002020PH$J\b\u0010^\u001a\u000204H$J\u0010\u0010_\u001a\u0002042\u0006\u0010`\u001a\u00020aH$J\b\u0010b\u001a\u000204H$R\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\u00020\u001d8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006g"}, d2 = {"Lcom/pspdfkit/ui/search/AbstractPdfSearchView;", "Landroid/widget/FrameLayout;", "Lcom/pspdfkit/listeners/DocumentListener;", "Lcom/pspdfkit/ui/search/PdfSearchView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listeners", "Lcom/pspdfkit/listeners/OnVisibilityChangedListenerManager;", "getListeners", "()Lcom/pspdfkit/listeners/OnVisibilityChangedListenerManager;", "document", "Lcom/pspdfkit/document/PdfDocument;", "getDocument", "()Lcom/pspdfkit/document/PdfDocument;", "setDocument", "(Lcom/pspdfkit/document/PdfDocument;)V", "inputField", "Landroid/widget/EditText;", "getInputField", "()Landroid/widget/EditText;", "setInputField", "(Landroid/widget/EditText;)V", "startSearchEvenWhenNotDisplayed", "", "currentPage", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "isSearchInProgress", "searchInProgress", "Lio/reactivex/rxjava3/disposables/Disposable;", "textSearch", "Lcom/pspdfkit/document/search/TextSearch;", "searchConfiguration", "Lcom/pspdfkit/configuration/search/SearchConfiguration;", "getSearchConfiguration", "()Lcom/pspdfkit/configuration/search/SearchConfiguration;", "setSearchConfiguration", "(Lcom/pspdfkit/configuration/search/SearchConfiguration;)V", "searchViewListener", "Lcom/pspdfkit/ui/search/PdfSearchView$Listener;", "searchResults", "", "Lcom/pspdfkit/document/search/SearchResult;", "applyPolicy", "", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "addOnVisibilityChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/listeners/OnVisibilityChangedListener;", "removeOnVisibilityChangedListener", "show", "clearDocument", "cancelSearch", "getPSPDFViewType", "Lcom/pspdfkit/ui/PSPDFKitViews$Type;", "clearOnVisibilityChangedListeners", "onDetachedFromWindow", "showKeyboard", "hideKeyboard", "clearSearch", "setInputFieldText", "text", "", "startSearch", "setSearchViewListener", "performSearch", "searchQuery", "compareOptions", "Ljava/util/EnumSet;", "Lcom/pspdfkit/document/search/CompareOptions;", "getSearchResults", "", "dispatchSearchResultSelected", "selectedSearchResult", "onPageChanged", "pageIndex", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", "state", "clearSearchResults", "onSearchStarted", "query", "onMoreSearchResults", "results", "onSearchComplete", "onSearchError", "ex", "", "onSearchCanceled", "isIdle", "()Z", "SavedState", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractPdfSearchView extends FrameLayout implements DocumentListener, PdfSearchView {
    private static final String CACHE_PRELOAD_KEY = "#-CACHE-#";
    protected static final String LOG_TAG = "Nutri.SearchView";
    private static final int SEARCH_BUFFER_DURATION = 300;
    public static final int SEARCH_DELAY = 300;
    private int currentPage;
    private PdfDocument document;
    private EditText inputField;
    private final OnVisibilityChangedListenerManager listeners;
    private SearchConfiguration searchConfiguration;
    private Disposable searchInProgress;
    private List<SearchResult> searchResults;
    private PdfSearchView.Listener searchViewListener;
    private boolean startSearchEvenWhenNotDisplayed;
    private TextSearch textSearch;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/ui/search/AbstractPdfSearchView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "isDisplayingSearchResults", "", "()Z", "setDisplayingSearchResults", "(Z)V", "writeToParcel", "", "dest", "flags", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SavedState extends View.BaseSavedState {
        private boolean isDisplayingSearchResults;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.search.AbstractPdfSearchView$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AbstractPdfSearchView.SavedState createFromParcel(Parcel source) {
                source.getClass();
                return new AbstractPdfSearchView.SavedState(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AbstractPdfSearchView.SavedState[] newArray(int size) {
                return new AbstractPdfSearchView.SavedState[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            parcelable.getClass();
        }

        /* JADX INFO: renamed from: isDisplayingSearchResults, reason: from getter */
        public final boolean getIsDisplayingSearchResults() {
            return this.isDisplayingSearchResults;
        }

        public final void setDisplayingSearchResults(boolean z) {
            this.isDisplayingSearchResults = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.getClass();
            super.writeToParcel(dest, flags);
            dest.writeByte(this.isDisplayingSearchResults ? (byte) 1 : (byte) 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            parcel.getClass();
            this.isDisplayingSearchResults = parcel.readByte() != 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractPdfSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.listeners = new OnVisibilityChangedListenerManager();
        this.currentPage = -1;
        this.searchConfiguration = new SearchConfiguration(0, 0, false, null, 15, null);
    }

    private final void cancelSearch() {
        Disposable disposable = this.searchInProgress;
        if (disposable != null) {
            disposable.dispose();
        }
        this.searchInProgress = null;
        this.searchResults = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void performSearch$default(AbstractPdfSearchView abstractPdfSearchView, String str, EnumSet enumSet, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performSearch");
        }
        if ((i & 2) != 0) {
            enumSet = null;
        }
        abstractPdfSearchView.performSearch(str, enumSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0$0() {
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void addOnVisibilityChangedListener(OnVisibilityChangedListener listener) {
        listener.getClass();
        this.listeners.addOnVisibilityChangedListener(listener);
    }

    public final void applyPolicy() {
        EditText editText;
        if (this.inputField == null) {
            throw new IllegalStateException("Search view inputField not initialized.");
        }
        if (Nutrient.getApplicationPolicy().hasPermissionForEvent(ApplicationPolicy.PolicyEvent.TEXT_COPY_PASTE) || (editText = this.inputField) == null) {
            return;
        }
        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: com.pspdfkit.ui.search.AbstractPdfSearchView.applyPolicy.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                mode.getClass();
                item.getClass();
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getClass();
                menu.getClass();
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                mode.getClass();
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                mode.getClass();
                menu.getClass();
                return false;
            }
        });
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void clearDocument() {
        cancelSearch();
        hide();
        this.document = null;
        this.textSearch = null;
    }

    public final void clearOnVisibilityChangedListeners() {
        this.listeners.clear();
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void clearSearch() {
        if (this.searchInProgress != null) {
            cancelSearch();
            onSearchCanceled();
        }
        clearSearchResults();
        PdfSearchView.Listener listener = this.searchViewListener;
        if (listener != null) {
            listener.onSearchCleared();
        }
    }

    public abstract void clearSearchResults();

    public final void dispatchSearchResultSelected(SearchResult selectedSearchResult) {
        PdfSearchView.Listener listener = this.searchViewListener;
        if (listener != null) {
            listener.onSearchResultSelected(selectedSearchResult);
        }
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final PdfDocument getDocument() {
        return this.document;
    }

    public final EditText getInputField() {
        return this.inputField;
    }

    public final OnVisibilityChangedListenerManager getListeners() {
        return this.listeners;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public PSPDFKitViews.Type getPSPDFViewType() {
        return PSPDFKitViews.Type.VIEW_SEARCH;
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public SearchConfiguration getSearchConfiguration() {
        return this.searchConfiguration;
    }

    public final List<SearchResult> getSearchResults() {
        List<SearchResult> list = this.searchResults;
        if (list != null) {
            return CollectionsKt.toList(list);
        }
        return null;
    }

    public final void hideKeyboard() {
        EditText editText = this.inputField;
        if (editText != null) {
            hn.c(editText);
            editText.clearFocus();
        }
    }

    public boolean isIdle() {
        return true;
    }

    public final boolean isSearchInProgress() {
        Disposable disposable = this.searchInProgress;
        if (disposable != null) {
            return !disposable.isDisposed();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearSearch();
    }

    public abstract void onMoreSearchResults(List<SearchResult> results);

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageChanged(PdfDocument document, int pageIndex) {
        document.getClass();
        this.currentPage = pageIndex;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        state.getClass();
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.getIsDisplayingSearchResults()) {
            this.startSearchEvenWhenNotDisplayed = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            throw new IllegalStateException("onSaveInstanceState failed for PdfSearchView.");
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        List<SearchResult> list = this.searchResults;
        if (list != null) {
            z = list.isEmpty() ^ true;
        }
        savedState.setDisplayingSearchResults(z);
        return savedState;
    }

    public abstract void onSearchCanceled();

    public abstract void onSearchComplete();

    public abstract void onSearchError(Throwable ex);

    public abstract void onSearchStarted(String query);

    public final void performSearch(String str) {
        str.getClass();
        performSearch$default(this, str, null, 2, null);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void removeOnVisibilityChangedListener(OnVisibilityChangedListener listener) {
        listener.getClass();
        this.listeners.removeOnVisibilityChangedListener(listener);
    }

    public final void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public final void setDocument(PdfDocument pdfDocument) {
        this.document = pdfDocument;
    }

    public final void setInputField(EditText editText) {
        this.inputField = editText;
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void setInputFieldText(String text, boolean startSearch) {
        text.getClass();
        EditText editText = this.inputField;
        if (editText != null) {
            editText.setText(text);
        }
        EditText editText2 = this.inputField;
        if (editText2 != null) {
            editText2.setSelection(text.length());
        }
        if (startSearch) {
            clearSearch();
            post(new Runnable() { // from class: com.pspdfkit.ui.search.AbstractPdfSearchView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hideKeyboard();
                }
            });
            performSearch$default(this, text, null, 2, null);
        }
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void setSearchConfiguration(SearchConfiguration searchConfiguration) {
        searchConfiguration.getClass();
        this.searchConfiguration = searchConfiguration;
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void setSearchViewListener(PdfSearchView.Listener searchViewListener) {
        this.searchViewListener = searchViewListener;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
        TextSearch textSearch;
        if (isDisplayed() || (textSearch = this.textSearch) == null) {
            return;
        }
        this.searchInProgress = textSearch.performSearchAsync(CACHE_PRELOAD_KEY).ignoreElements().subscribe(new Action() { // from class: com.pspdfkit.ui.search.AbstractPdfSearchView$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                AbstractPdfSearchView.show$lambda$0$0();
            }
        }, new Consumer() { // from class: com.pspdfkit.ui.search.AbstractPdfSearchView$show$1$2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Throwable th) {
                th.getClass();
            }
        });
    }

    public final void showKeyboard() {
        EditText editText = this.inputField;
        if (editText != null) {
            editText.requestFocus();
            hn.a(editText, 0, (hn.d) null);
        }
    }

    public final void performSearch(final String searchQuery, EnumSet<CompareOptions> compareOptions) {
        Flowable<SearchResult> flowablePerformSearchAsync;
        TimeUnit timeUnit;
        Flowable<List<SearchResult>> flowableBuffer;
        Flowable<List<SearchResult>> flowableDelaySubscription;
        Flowable<List<SearchResult>> flowableObserveOn;
        Flowable<List<SearchResult>> flowableDoOnSubscribe;
        searchQuery.getClass();
        clearSearch();
        if (this.document == null) {
            PdfLog.w(LOG_TAG, "setDocumentFromUri() has to be called before search can be performed.", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (getSearchConfiguration().getStartSearchOnCurrentPage() && this.currentPage > -1) {
            int i = this.currentPage;
            PdfDocument pdfDocument = this.document;
            pdfDocument.getClass();
            arrayList.add(new Range(i, pdfDocument.getPageCount() - this.currentPage));
        }
        SearchOptions.Builder builderPriorityPages = new SearchOptions.Builder().snippetLength(getSearchConfiguration().getSnippetLength()).priorityPages(arrayList);
        builderPriorityPages.getClass();
        if (compareOptions != null) {
            builderPriorityPages.compareOptions(compareOptions);
        }
        Integer maxSearchResults = getSearchConfiguration().getMaxSearchResults();
        if (maxSearchResults != null) {
            builderPriorityPages.maxSearchResults(maxSearchResults.intValue());
        }
        SearchOptions searchOptionsBuild = builderPriorityPages.build();
        searchOptionsBuild.getClass();
        TextSearch textSearch = this.textSearch;
        this.searchInProgress = (textSearch == null || (flowablePerformSearchAsync = textSearch.performSearchAsync(searchQuery, searchOptionsBuild)) == null || (flowableBuffer = flowablePerformSearchAsync.buffer(300L, (timeUnit = TimeUnit.MILLISECONDS))) == null || (flowableDelaySubscription = flowableBuffer.delaySubscription(300L, timeUnit)) == null || (flowableObserveOn = flowableDelaySubscription.observeOn(AndroidSchedulers.mainThread())) == null || (flowableDoOnSubscribe = flowableObserveOn.doOnSubscribe(new Consumer() { // from class: com.pspdfkit.ui.search.AbstractPdfSearchView.performSearch.3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Subscription subscription) {
                subscription.getClass();
                List list = AbstractPdfSearchView.this.searchResults;
                if (list != null) {
                    list.clear();
                } else {
                    AbstractPdfSearchView.this.searchResults = new ArrayList();
                }
                AbstractPdfSearchView.this.onSearchStarted(searchQuery);
                PdfSearchView.Listener listener = AbstractPdfSearchView.this.searchViewListener;
                if (listener != null) {
                    listener.onSearchStarted(searchQuery);
                }
            }
        })) == null) ? null : (AnonymousClass4) flowableDoOnSubscribe.subscribeWith(new DisposableSubscriber<List<? extends SearchResult>>() { // from class: com.pspdfkit.ui.search.AbstractPdfSearchView.performSearch.4
            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (AbstractPdfSearchView.this.searchResults == null) {
                    return;
                }
                PdfSearchView.Listener listener = AbstractPdfSearchView.this.searchViewListener;
                if (listener != null) {
                    listener.onSearchCompleted();
                }
                i0 i0VarA = ar.a();
                Bundle bundleA = z50.a(i0VarA);
                bundleA.putInt(Analytics.Data.LENGTH, searchQuery.length());
                List list = AbstractPdfSearchView.this.searchResults;
                list.getClass();
                bundleA.putInt("count", list.size());
                i0VarA.a(Analytics.Event.PERFORM_SEARCH, bundleA);
                dispose();
                AbstractPdfSearchView.this.onSearchComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable e) {
                e.getClass();
                AbstractPdfSearchView.this.searchResults = null;
                AbstractPdfSearchView.this.onSearchError(e);
                PdfSearchView.Listener listener = AbstractPdfSearchView.this.searchViewListener;
                if (listener != null) {
                    listener.onSearchError(e);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(List<SearchResult> searchResultsChunk) {
                searchResultsChunk.getClass();
                List list = AbstractPdfSearchView.this.searchResults;
                if (list != null) {
                    AbstractPdfSearchView abstractPdfSearchView = AbstractPdfSearchView.this;
                    list.addAll(searchResultsChunk);
                    abstractPdfSearchView.onMoreSearchResults(searchResultsChunk);
                    PdfSearchView.Listener listener = abstractPdfSearchView.searchViewListener;
                    if (listener != null) {
                        listener.onMoreSearchResults(searchResultsChunk);
                    }
                }
            }
        });
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void setDocument(PdfDocument document, PdfConfiguration configuration) {
        document.getClass();
        configuration.getClass();
        this.document = document;
        this.textSearch = new TextSearch(document, configuration);
        if (isDisplayed() || this.startSearchEvenWhenNotDisplayed) {
            EditText editText = this.inputField;
            if (TextUtils.isEmpty(editText != null ? editText.getText() : null)) {
                return;
            }
            EditText editText2 = this.inputField;
            performSearch$default(this, String.valueOf(editText2 != null ? editText2.getText() : null), null, 2, null);
        }
    }
}

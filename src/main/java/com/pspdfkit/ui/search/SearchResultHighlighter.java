package com.pspdfkit.ui.search;

import android.content.Context;
import com.box.androidsdk.content.models.BoxFile;
import com.pspdfkit.R;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.internal.k00;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\b\b\u0001\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010 \u001a\u00020\t2\b\b\u0001\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b \u0010\u001dJ\u000f\u0010!\u001a\u00020\u0014H\u0007¢\u0006\u0004\b!\u0010\u001aJ\u0017\u0010#\u001a\u00020\t2\b\b\u0001\u0010\"\u001a\u00020\u0014¢\u0006\u0004\b#\u0010\u001dJ\u000f\u0010$\u001a\u00020\u0014H\u0007¢\u0006\u0004\b$\u0010\u001aJ\u0017\u0010&\u001a\u00020\t2\b\b\u0001\u0010%\u001a\u00020\u0014¢\u0006\u0004\b&\u0010\u001dJ\u000f\u0010'\u001a\u00020\u0014H\u0007¢\u0006\u0004\b'\u0010\u001aJ\u0017\u0010)\u001a\u00020\t2\b\b\u0001\u0010(\u001a\u00020\u0014¢\u0006\u0004\b)\u0010\u001dJ\u000f\u0010*\u001a\u00020\u0014H\u0007¢\u0006\u0004\b*\u0010\u001aJ\u0017\u0010,\u001a\u00020\t2\b\b\u0001\u0010+\u001a\u00020\u0014¢\u0006\u0004\b,\u0010\u001dJ\u000f\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020-¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0014H\u0007¢\u0006\u0004\b3\u0010\u001aJ\u0017\u00105\u001a\u00020\t2\b\b\u0001\u00104\u001a\u00020\u0014¢\u0006\u0004\b5\u0010\u001dJ\u000f\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0004\b6\u0010\u001aJ\u0017\u00108\u001a\u00020\t2\b\b\u0001\u00107\u001a\u00020\u0014¢\u0006\u0004\b8\u0010\u001dR\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020@0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "Lcom/pspdfkit/document/search/SearchResult;", "results", "", "setSearchResults", "(Ljava/util/List;)V", "addSearchResults", "clearSearchResults", "()V", "newSelectedSearchResult", "setSelectedSearchResult", "(Lcom/pspdfkit/document/search/SearchResult;)V", "Lcom/pspdfkit/document/PdfDocument;", "document", "", "pageIndex", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "getDrawablesForPage", "(Landroid/content/Context;Lcom/pspdfkit/document/PdfDocument;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchResultBackgroundColor", "()I", "searchResultBackgroundColor", "setSearchResultBackgroundColor", "(I)V", "getSearchResultBorderColor", "searchResultBorderColor", "setSearchResultBorderColor", "getSearchResultBorderWidth", "searchResultBorderWidth", "setSearchResultBorderWidth", "getSearchResultPadding", "searchResultPadding", "setSearchResultPadding", "getSearchResultAnnotationPadding", "searchResultAnnotationPadding", "setSearchResultAnnotationPadding", "getSearchResultAnimationPadding", "searchResultAnimationPadding", "setSearchResultAnimationPadding", "", "getSearchResultCornerRadiusToHeightRatio", "()F", "searchResultCornerRadiusToHeightRatio", "setSearchResultCornerRadiusToHeightRatio", "(F)V", "getSearchResultMinCornerRadius", "searchResultMinCornerRadius", "setSearchResultMinCornerRadius", "getSearchResultMaxCornerRadius", "searchResultMaxCornerRadius", "setSearchResultMaxCornerRadius", "Lcom/pspdfkit/internal/k00;", "themeConfiguration", "Lcom/pspdfkit/internal/k00;", "", "searchResults", "Ljava/util/List;", "", "Lcom/pspdfkit/ui/search/SearchResultDrawable;", "searchResultDrawableCache", "Ljava/util/Map;", "selectedSearchResult", "Lcom/pspdfkit/document/search/SearchResult;", "noteAnnotationSizePx", "I", "", BoxFile.FIELD_LOCK, "Ljava/lang/Object;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchResultHighlighter extends PdfDrawableProvider {
    public static final int $stable = 8;
    private final Object lock;
    private final int noteAnnotationSizePx;
    private final Map<SearchResult, SearchResultDrawable> searchResultDrawableCache;
    private final List<SearchResult> searchResults;
    private SearchResult selectedSearchResult;
    private final k00 themeConfiguration;

    public SearchResultHighlighter(Context context) {
        context.getClass();
        HashMap map = new HashMap();
        this.searchResultDrawableCache = map;
        this.lock = new Object();
        this.searchResults = new ArrayList();
        this.selectedSearchResult = null;
        map.clear();
        this.themeConfiguration = new k00(context);
        this.noteAnnotationSizePx = context.getResources().getDimensionPixelSize(R.dimen.pspdf__view_annotation_size);
    }

    public final void addSearchResults(List<SearchResult> results) {
        results.getClass();
        if (results.isEmpty()) {
            return;
        }
        synchronized (this.lock) {
            this.searchResults.addAll(results);
        }
        notifyDrawablesChanged();
    }

    public final void clearSearchResults() {
        synchronized (this.lock) {
            if (this.searchResults.isEmpty()) {
                return;
            }
            this.searchResults.clear();
            this.selectedSearchResult = null;
            this.searchResultDrawableCache.clear();
            Unit unit = Unit.INSTANCE;
            notifyDrawablesChanged();
        }
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider
    public Object getDrawablesForPage(Context context, PdfDocument pdfDocument, int i, Continuation<? super List<? extends PdfDrawable>> continuation) {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.searchResults.size());
            for (SearchResult searchResult : this.searchResults) {
                if (searchResult.pageIndex == i) {
                    SearchResultDrawable searchResultDrawable = this.searchResultDrawableCache.get(searchResult);
                    boolean zAreEqual = Intrinsics.areEqual(searchResult, this.selectedSearchResult);
                    if (searchResultDrawable == null || searchResultDrawable.isSelected() != zAreEqual) {
                        SearchResultDrawable searchResultDrawable2 = new SearchResultDrawable(searchResult, zAreEqual);
                        searchResultDrawable2.applyTheme(this.themeConfiguration, this.noteAnnotationSizePx);
                        arrayList.add(searchResultDrawable2);
                        this.searchResultDrawableCache.put(searchResult, searchResultDrawable2);
                    } else {
                        Boxing.boxBoolean(arrayList.add(searchResultDrawable));
                    }
                }
            }
        }
        return arrayList;
    }

    public final int getSearchResultAnimationPadding() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.f;
        }
        return i;
    }

    public final int getSearchResultAnnotationPadding() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.e;
        }
        return i;
    }

    public final int getSearchResultBackgroundColor() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.a;
        }
        return i;
    }

    public final int getSearchResultBorderColor() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.b;
        }
        return i;
    }

    public final int getSearchResultBorderWidth() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.c;
        }
        return i;
    }

    public final float getSearchResultCornerRadiusToHeightRatio() {
        float f;
        synchronized (this.lock) {
            f = this.themeConfiguration.g;
        }
        return f;
    }

    public final int getSearchResultMaxCornerRadius() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.i;
        }
        return i;
    }

    public final int getSearchResultMinCornerRadius() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.h;
        }
        return i;
    }

    public final int getSearchResultPadding() {
        int i;
        synchronized (this.lock) {
            i = this.themeConfiguration.d;
        }
        return i;
    }

    public final void setSearchResultAnimationPadding(int searchResultAnimationPadding) {
        synchronized (this.lock) {
            this.themeConfiguration.f = searchResultAnimationPadding;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultAnnotationPadding(int searchResultAnnotationPadding) {
        synchronized (this.lock) {
            this.themeConfiguration.e = searchResultAnnotationPadding;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultBackgroundColor(int searchResultBackgroundColor) {
        synchronized (this.lock) {
            this.themeConfiguration.a = searchResultBackgroundColor;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultBorderColor(int searchResultBorderColor) {
        synchronized (this.lock) {
            this.themeConfiguration.b = searchResultBorderColor;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultBorderWidth(int searchResultBorderWidth) {
        synchronized (this.lock) {
            this.themeConfiguration.c = searchResultBorderWidth;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultCornerRadiusToHeightRatio(float searchResultCornerRadiusToHeightRatio) {
        synchronized (this.lock) {
            this.themeConfiguration.g = searchResultCornerRadiusToHeightRatio;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultMaxCornerRadius(int searchResultMaxCornerRadius) {
        synchronized (this.lock) {
            this.themeConfiguration.i = searchResultMaxCornerRadius;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultMinCornerRadius(int searchResultMinCornerRadius) {
        synchronized (this.lock) {
            this.themeConfiguration.h = searchResultMinCornerRadius;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResultPadding(int searchResultPadding) {
        synchronized (this.lock) {
            this.themeConfiguration.d = searchResultPadding;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setSearchResults(List<SearchResult> results) {
        results.getClass();
        uw.a(results, "results", null);
        synchronized (this.lock) {
            if (Intrinsics.areEqual(this.searchResults, results)) {
                return;
            }
            this.searchResults.clear();
            this.searchResults.addAll(results);
            this.selectedSearchResult = null;
            this.searchResultDrawableCache.clear();
            Unit unit = Unit.INSTANCE;
            notifyDrawablesChanged();
        }
    }

    public final void setSelectedSearchResult(SearchResult newSelectedSearchResult) {
        synchronized (this.lock) {
            if (newSelectedSearchResult != null) {
                if (!this.searchResults.contains(newSelectedSearchResult)) {
                    throw new IllegalArgumentException("Can't select a SearchResult that wasn't previously provided using SearchResultHighlighter#setSearchResults.");
                }
            }
            SearchResult searchResult = this.selectedSearchResult;
            if (searchResult == newSelectedSearchResult) {
                return;
            }
            this.selectedSearchResult = newSelectedSearchResult;
            Unit unit = Unit.INSTANCE;
            if (searchResult == null || newSelectedSearchResult == null) {
                if (searchResult != null) {
                    notifyDrawablesChanged(searchResult.pageIndex);
                    return;
                } else {
                    if (newSelectedSearchResult != null) {
                        notifyDrawablesChanged(newSelectedSearchResult.pageIndex);
                        return;
                    }
                    return;
                }
            }
            int i = searchResult.pageIndex;
            int i2 = newSelectedSearchResult.pageIndex;
            if (i == i2) {
                notifyDrawablesChanged(i2);
            } else {
                notifyDrawablesChanged(i);
                notifyDrawablesChanged(newSelectedSearchResult.pageIndex);
            }
        }
    }
}

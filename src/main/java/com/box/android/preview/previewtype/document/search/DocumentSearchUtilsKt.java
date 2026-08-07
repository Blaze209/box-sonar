package com.box.android.preview.previewtype.document.search;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.document.search.SearchResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentSearchUtils.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\b"}, d2 = {"getNextIndex", "", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$Results;", "direction", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchResultsNavigationDirection;", "getByIndex", "Lcom/pspdfkit/document/search/SearchResult;", FirebaseAnalytics.Param.INDEX, "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DocumentSearchUtilsKt {

    /* JADX INFO: compiled from: DocumentSearchUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentSearchReducer.SearchResultsNavigationDirection.values().length];
            try {
                iArr[DocumentSearchReducer.SearchResultsNavigationDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocumentSearchReducer.SearchResultsNavigationDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getNextIndex(DocumentSearchReducer.SearchState.Results results, DocumentSearchReducer.SearchResultsNavigationDirection direction) {
        Integer num;
        Intrinsics.checkNotNullParameter(results, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        int lastIndex = CollectionsKt.getLastIndex(results.getResults().getValue());
        int i = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
        if (i == 1) {
            Integer numValueOf = Integer.valueOf(results.getSelectedResultIndex() - 1);
            num = numValueOf.intValue() >= 0 ? numValueOf : null;
            return num != null ? num.intValue() : lastIndex;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        Integer numValueOf2 = Integer.valueOf(results.getSelectedResultIndex() + 1);
        num = numValueOf2.intValue() <= lastIndex ? numValueOf2 : null;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final SearchResult getByIndex(DocumentSearchReducer.SearchState.Results results, int i) {
        Intrinsics.checkNotNullParameter(results, "<this>");
        return results.getResults().getValue().get(i);
    }
}

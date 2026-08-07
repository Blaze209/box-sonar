package com.box.android.preview.previewtype.document;

import android.view.View;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.preview.R;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/document/NutrientPdfViewsOnVisibilityChangeListener;", "Lcom/pspdfkit/listeners/OnVisibilityChangedListener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "onShow", "", "view", "Landroid/view/View;", "onHide", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NutrientPdfViewsOnVisibilityChangeListener implements OnVisibilityChangedListener {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Integer, DisplayMode> viewToDisplayModeMapping = MapsKt.mapOf(TuplesKt.to(Integer.valueOf(R.id.pspdf__activity_outline_view), DisplayMode.Outline), TuplesKt.to(Integer.valueOf(R.id.pspdf__activity_thumbnail_grid), DisplayMode.Thumbnails));
    private final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store;

    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onShow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public NutrientPdfViewsOnVisibilityChangeListener(Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> getStore() {
        return this.store;
    }

    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onHide(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (viewToDisplayModeMapping.get(Integer.valueOf(view.getId())) == ((DocumentPreviewReducer.State) StoreKt.stateValue(this.store)).getDisplayMode()) {
            this.store.send(new DocumentPreviewReducer.Action.SwitchDisplayMode(DisplayMode.FullItem));
        }
    }

    /* JADX INFO: compiled from: DocumentPreviewScreen.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/previewtype/document/NutrientPdfViewsOnVisibilityChangeListener$Companion;", "", "<init>", "()V", "viewToDisplayModeMapping", "", "", "Lcom/box/android/preview/previewtype/document/DisplayMode;", "getViewToDisplayModeMapping", "()Ljava/util/Map;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Integer, DisplayMode> getViewToDisplayModeMapping() {
            return NutrientPdfViewsOnVisibilityChangeListener.viewToDisplayModeMapping;
        }
    }
}

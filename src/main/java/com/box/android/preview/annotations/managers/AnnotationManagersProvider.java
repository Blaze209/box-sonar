package com.box.android.preview.annotations.managers;

import com.box.android.domain.models.ItemId;
import com.box.android.observability.DiagnosisParams;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AnnotationManagersProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "", "<init>", "()V", "itemIdToPdfAnnotationManager", "", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "itemIdToCreateAnnotationManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "getPdfAnnotationManager", "itemId", "getCreateAnnotationManager", "removeAnnotationManagers", "", DiagnosisParams.CLEAR_ON_LOGOUT, "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationManagersProvider {
    public static final int $stable = 8;
    private final Map<ItemId, BoxPdfAnnotationManager> itemIdToPdfAnnotationManager = new LinkedHashMap();
    private final Map<ItemId, CreateAnnotationsManager> itemIdToCreateAnnotationManager = new LinkedHashMap();

    @Inject
    public AnnotationManagersProvider() {
    }

    public final BoxPdfAnnotationManager getPdfAnnotationManager(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Map<ItemId, BoxPdfAnnotationManager> map = this.itemIdToPdfAnnotationManager;
        BoxPdfAnnotationManager boxPdfAnnotationManager = map.get(itemId);
        if (boxPdfAnnotationManager == null) {
            boxPdfAnnotationManager = new BoxPdfAnnotationManager();
            map.put(itemId, boxPdfAnnotationManager);
        }
        return boxPdfAnnotationManager;
    }

    public final CreateAnnotationsManager getCreateAnnotationManager(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Map<ItemId, CreateAnnotationsManager> map = this.itemIdToCreateAnnotationManager;
        CreateAnnotationsManager createAnnotationsManager = map.get(itemId);
        if (createAnnotationsManager == null) {
            createAnnotationsManager = new CreateAnnotationsManager(Dispatchers.getIO());
            map.put(itemId, createAnnotationsManager);
        }
        return createAnnotationsManager;
    }

    public final void removeAnnotationManagers(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.itemIdToCreateAnnotationManager.remove(itemId);
        this.itemIdToPdfAnnotationManager.remove(itemId);
    }

    public final void clear() {
        this.itemIdToCreateAnnotationManager.clear();
        this.itemIdToPdfAnnotationManager.clear();
    }
}

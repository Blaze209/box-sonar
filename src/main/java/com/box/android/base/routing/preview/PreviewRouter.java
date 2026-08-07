package com.box.android.base.routing.preview;

import android.content.Context;
import com.amplitude.api.Constants;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.androidsdk.content.models.BoxFile;
import kotlin.Metadata;

/* JADX INFO: compiled from: PreviewRouter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J*\u0010\u000f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/base/routing/preview/PreviewRouter;", "", "onAnnotationActivityClicked", "", "versionNumber", "", Constants.AMP_PLAN_VERSION_ID, "", "annotationId", "annotationLocationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "activityContext", "Landroid/content/Context;", "onTimestampClicked", "timestampMs", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PreviewRouter {
    void onAnnotationActivityClicked(int versionNumber, String versionId, String annotationId, AnnotationLocationModel annotationLocationModel, BoxFile boxFile, Context activityContext);

    void onTimestampClicked(String versionId, long timestampMs, FileModel fileModel, Context activityContext);
}

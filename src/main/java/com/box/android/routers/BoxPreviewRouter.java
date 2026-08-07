package com.box.android.routers;

import android.content.Context;
import android.content.Intent;
import com.amplitude.api.Constants;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.base.routing.preview.PreviewRouter;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.fileactivity.presentation.FileActivitiesActivity;
import com.box.android.preview.previousversion.PreviousVersionPreviewActivity;
import com.box.android.preview.utils.PreviewLauncher;
import com.box.androidsdk.content.models.BoxFile;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPreviewRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J0\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/routers/BoxPreviewRouter;", "Lcom/box/android/base/routing/preview/PreviewRouter;", "previewLauncher", "Lcom/box/android/preview/utils/PreviewLauncher;", "previousVersionPreviewObservability", "Lcom/box/android/domain/metrics/preview/PreviousVersionPreviewObservability;", "<init>", "(Lcom/box/android/preview/utils/PreviewLauncher;Lcom/box/android/domain/metrics/preview/PreviousVersionPreviewObservability;)V", "onAnnotationActivityClicked", "", "versionNumber", "", Constants.AMP_PLAN_VERSION_ID, "", "annotationId", "annotationLocationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "activityContext", "Landroid/content/Context;", "onTimestampClicked", "timestampMs", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "openPreviewWithTimeStamp", "openPreviewWithAnnotationSelected", "openPreviousVersionWithAnnotationSelected", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxPreviewRouter implements PreviewRouter {
    public static final int $stable = 8;
    private final PreviewLauncher previewLauncher;
    private final PreviousVersionPreviewObservability previousVersionPreviewObservability;

    @Inject
    public BoxPreviewRouter(PreviewLauncher previewLauncher, PreviousVersionPreviewObservability previousVersionPreviewObservability) {
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(previousVersionPreviewObservability, "previousVersionPreviewObservability");
        this.previewLauncher = previewLauncher;
        this.previousVersionPreviewObservability = previousVersionPreviewObservability;
    }

    @Override // com.box.android.base.routing.preview.PreviewRouter
    public void onAnnotationActivityClicked(int versionNumber, String versionId, String annotationId, AnnotationLocationModel annotationLocationModel, BoxFile boxFile, Context activityContext) {
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        if (versionId == null) {
            openPreviewWithAnnotationSelected(annotationId, FileModelMapper.toFileModel$default(FileModelMapper.INSTANCE, boxFile, false, 1, null), activityContext);
        } else {
            openPreviousVersionWithAnnotationSelected(versionNumber, versionId, annotationId, FileModelMapper.toFileModel$default(FileModelMapper.INSTANCE, boxFile, false, 1, null), activityContext);
        }
    }

    @Override // com.box.android.base.routing.preview.PreviewRouter
    public void onTimestampClicked(String versionId, long timestampMs, FileModel fileModel, Context activityContext) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        if (versionId == null) {
            openPreviewWithTimeStamp(timestampMs, fileModel, activityContext);
        }
    }

    private final void openPreviewWithTimeStamp(long timestampMs, FileModel fileModel, final Context activityContext) {
        IPreviewLauncher.launchPreview$default(this.previewLauncher, new IPreviewLauncher.NavigationData(activityContext, fileModel, PreviewSource.FileActivities.INSTANCE, null, new PreviewNavigationTarget.Timestamp(timestampMs), false, false, 104, null), null, new Function1() { // from class: com.box.android.routers.BoxPreviewRouter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxPreviewRouter.openPreviewWithTimeStamp$lambda$0(activityContext, (Intent) obj);
            }
        }, 2, null);
        if (activityContext instanceof FileActivitiesActivity) {
            ((FileActivitiesActivity) activityContext).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openPreviewWithTimeStamp$lambda$0(Context context, Intent launchPreview) {
        Intrinsics.checkNotNullParameter(launchPreview, "$this$launchPreview");
        if (context instanceof FileActivitiesActivity) {
            launchPreview.addFlags(131072);
        }
        return Unit.INSTANCE;
    }

    private final void openPreviewWithAnnotationSelected(String annotationId, FileModel boxFile, final Context activityContext) {
        IPreviewLauncher.launchPreview$default(this.previewLauncher, new IPreviewLauncher.NavigationData(activityContext, boxFile, PreviewSource.FileActivities.INSTANCE, null, new PreviewNavigationTarget.AnnotationOnPreview(annotationId), false, false, 104, null), null, new Function1() { // from class: com.box.android.routers.BoxPreviewRouter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxPreviewRouter.openPreviewWithAnnotationSelected$lambda$0(activityContext, (Intent) obj);
            }
        }, 2, null);
        if (activityContext instanceof FileActivitiesActivity) {
            ((FileActivitiesActivity) activityContext).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openPreviewWithAnnotationSelected$lambda$0(Context context, Intent launchPreview) {
        Intrinsics.checkNotNullParameter(launchPreview, "$this$launchPreview");
        if (context instanceof FileActivitiesActivity) {
            launchPreview.addFlags(131072);
        }
        return Unit.INSTANCE;
    }

    private final void openPreviousVersionWithAnnotationSelected(int versionNumber, String versionId, String annotationId, FileModel boxFile, Context activityContext) {
        activityContext.startActivity(PreviousVersionPreviewActivity.INSTANCE.getIntent(activityContext, boxFile, versionId, annotationId, PreviousVersionPreviewObservability.startPreviewMetric$default(this.previousVersionPreviewObservability, boxFile, versionNumber, 0L, null, 12, null)));
    }
}

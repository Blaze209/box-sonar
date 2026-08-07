package com.box.android.preview.previewtype.image;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.preview.annotations.cpl.AnnotationsEnvironment;
import com.box.android.preview.annotations.cpl.CreateAnnotationEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;", "", "annotationsEnvironment", "Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "createAnnotationEnvironment", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "observability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "<init>", "(Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/metrics/preview/PreviewObservability;)V", "getAnnotationsEnvironment", "()Lcom/box/android/preview/annotations/cpl/AnnotationsEnvironment;", "getCreateAnnotationEnvironment", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationEnvironment;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getObservability", "()Lcom/box/android/domain/metrics/preview/PreviewObservability;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePreviewEnvironment {
    public static final int $stable = 8;
    private final AnnotationsEnvironment annotationsEnvironment;
    private final CreateAnnotationEnvironment createAnnotationEnvironment;
    private final PreviewObservability observability;
    private final IUserContextManager userContextManager;

    @Inject
    public ImagePreviewEnvironment(AnnotationsEnvironment annotationsEnvironment, CreateAnnotationEnvironment createAnnotationEnvironment, IUserContextManager userContextManager, PreviewObservability observability) {
        Intrinsics.checkNotNullParameter(annotationsEnvironment, "annotationsEnvironment");
        Intrinsics.checkNotNullParameter(createAnnotationEnvironment, "createAnnotationEnvironment");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(observability, "observability");
        this.annotationsEnvironment = annotationsEnvironment;
        this.createAnnotationEnvironment = createAnnotationEnvironment;
        this.userContextManager = userContextManager;
        this.observability = observability;
    }

    public final AnnotationsEnvironment getAnnotationsEnvironment() {
        return this.annotationsEnvironment;
    }

    public final CreateAnnotationEnvironment getCreateAnnotationEnvironment() {
        return this.createAnnotationEnvironment;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final PreviewObservability getObservability() {
        return this.observability;
    }
}

package com.box.android.preview.annotations.managers;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.annotations.InkAnnotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateAnnotationsManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "Lcom/pspdfkit/annotations/InkAnnotation;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateAnnotationsManagerKt {
    public static final InkAnnotation copy(InkAnnotation inkAnnotation) {
        Intrinsics.checkNotNullParameter(inkAnnotation, "<this>");
        InkAnnotation inkAnnotation2 = new InkAnnotation(inkAnnotation.getPageIndex());
        inkAnnotation2.setLineWidth(inkAnnotation.getLineWidth());
        inkAnnotation2.setLines(inkAnnotation.getLines());
        inkAnnotation2.setColor(inkAnnotation.getColor());
        return inkAnnotation2;
    }
}

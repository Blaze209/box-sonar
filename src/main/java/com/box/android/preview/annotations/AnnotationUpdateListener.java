package com.box.android.preview.annotations;

import com.box.android.preview.annotations.model.Annotation;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnnotationUpdateListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/preview/annotations/AnnotationUpdateListener;", "", "onAnnotationUpdated", "", "annotation", "Lcom/box/android/preview/annotations/model/Annotation;", "pageIndex", "", "(Lcom/box/android/preview/annotations/model/Annotation;Ljava/lang/Integer;)V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnnotationUpdateListener {
    void onAnnotationUpdated(Annotation annotation, Integer pageIndex);
}

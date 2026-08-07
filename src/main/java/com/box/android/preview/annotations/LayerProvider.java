package com.box.android.preview.annotations;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.LayerDrawable;
import com.box.android.preview.annotations.model.AnnotationSelectedState;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayerProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/annotations/LayerProvider;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "getLayers", "Landroid/graphics/drawable/LayerDrawable;", "bounds", "Landroid/graphics/Rect;", "selectedState", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "intersection", "Landroid/graphics/RectF;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LayerProvider {
    public static final int $stable = 8;
    private final WeakReference<Context> context;

    public abstract LayerDrawable getLayers(Rect bounds, AnnotationSelectedState selectedState, RectF intersection);

    public LayerProvider(Context context) {
        this.context = new WeakReference<>(context);
    }

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    public static /* synthetic */ LayerDrawable getLayers$default(LayerProvider layerProvider, Rect rect, AnnotationSelectedState annotationSelectedState, RectF rectF, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLayers");
        }
        if ((i & 4) != 0) {
            rectF = null;
        }
        return layerProvider.getLayers(rect, annotationSelectedState, rectF);
    }
}

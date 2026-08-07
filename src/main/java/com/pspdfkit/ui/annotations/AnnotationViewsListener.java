package com.pspdfkit.ui.annotations;

import android.widget.EditText;
import com.pspdfkit.annotations.Annotation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/annotations/AnnotationViewsListener;", "", "onAnnotationEditTextViewCreated", "", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "editText", "Landroid/widget/EditText;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AnnotationViewsListener {
    void onAnnotationEditTextViewCreated(Annotation annotation, EditText editText);
}

package com.pspdfkit.internal;

import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.forms.FormProvider;
import com.pspdfkit.internal.jni.NativeFormField;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface fm extends FormProvider {
    void attachFormElement(FormField formField, List<? extends FormElement> list);

    FormElement createFormElement(FormField formField, WidgetAnnotation widgetAnnotation);

    FormField createFormField(int i, NativeFormField nativeFormField);

    kh getFormCache();

    boolean hasFieldsCache();

    void markFormAsSavedToDisk();

    FormField onFormFieldAdded(int i, NativeFormField nativeFormField);

    Object prepareFieldsCache(Continuation<? super Unit> continuation);

    void resetFormFields(List<? extends FormField> list, boolean z);

    void setDirty(boolean z);
}

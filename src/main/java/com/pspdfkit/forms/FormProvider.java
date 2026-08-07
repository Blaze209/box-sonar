package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface FormProvider {
    <T extends FormElementConfiguration> FormField addFormElementToPage(String str, T t);

    <T extends FormElementConfiguration> Single<FormField> addFormElementToPageAsync(String str, T t);

    <T extends FormElementConfiguration> FormField addFormElementsToPage(String str, List<T> list);

    <T extends FormElementConfiguration> Single<FormField> addFormElementsToPageAsync(String str, List<T> list);

    void addOnButtonFormFieldUpdatedListener(FormListeners.OnButtonFormFieldUpdatedListener onButtonFormFieldUpdatedListener);

    void addOnChoiceFormFieldUpdatedListener(FormListeners.OnChoiceFormFieldUpdatedListener onChoiceFormFieldUpdatedListener);

    void addOnFormFieldUpdatedListener(FormListeners.OnFormFieldUpdatedListener onFormFieldUpdatedListener);

    void addOnFormTabOrderUpdatedListener(FormListeners.OnFormTabOrderUpdatedListener onFormTabOrderUpdatedListener);

    void addOnTextFormFieldUpdatedListener(FormListeners.OnTextFormFieldUpdatedListener onTextFormFieldUpdatedListener);

    FormElement getFormElementForAnnotation(WidgetAnnotation widgetAnnotation);

    Maybe<FormElement> getFormElementForAnnotationAsync(WidgetAnnotation widgetAnnotation);

    FormElement getFormElementWithName(String str);

    Maybe<FormElement> getFormElementWithNameAsync(String str);

    List<FormElement> getFormElements();

    Single<List<FormElement>> getFormElementsAsync();

    FormField getFormFieldWithFullyQualifiedName(String str);

    Maybe<FormField> getFormFieldWithFullyQualifiedNameAsync(String str);

    List<FormField> getFormFields();

    Single<List<FormField>> getFormFieldsAsync();

    List<FormElement> getTabOrder();

    Single<List<FormElement>> getTabOrderAsync();

    boolean hasUnsavedChanges();

    boolean removeFormElementFromPage(FormElement formElement);

    Single<Boolean> removeFormElementFromPageAsync(FormElement formElement);

    void removeOnButtonFormFieldUpdatedListener(FormListeners.OnButtonFormFieldUpdatedListener onButtonFormFieldUpdatedListener);

    void removeOnChoiceFormFieldUpdatedListener(FormListeners.OnChoiceFormFieldUpdatedListener onChoiceFormFieldUpdatedListener);

    void removeOnFormFieldUpdatedListener(FormListeners.OnFormFieldUpdatedListener onFormFieldUpdatedListener);

    void removeOnFormTabOrderUpdatedListener(FormListeners.OnFormTabOrderUpdatedListener onFormTabOrderUpdatedListener);

    void removeOnTextFormFieldUpdatedListener(FormListeners.OnTextFormFieldUpdatedListener onTextFormFieldUpdatedListener);
}

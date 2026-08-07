package com.pspdfkit.annotations.actions;

import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.lm;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b'\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u0004H\u0096\u0080\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/pspdfkit/annotations/actions/AbstractFormAction;", "Lcom/pspdfkit/annotations/actions/Action;", "fieldNames", "", "", "subActions", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getFieldNames", "()Ljava/util/List;", "resolvedFormFields", "Lcom/pspdfkit/forms/FormField;", "shouldExcludeFormFields", "", "getFormFieldsAsync", "Lio/reactivex/rxjava3/core/Observable;", "document", "Lcom/pspdfkit/document/PdfDocument;", "getTargetFormFieldsAsync", "Lio/reactivex/rxjava3/core/Single;", "equals", "other", "", "hashCode", "", "toString", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractFormAction extends Action {
    private final List<String> fieldNames;
    private List<? extends FormField> resolvedFormFields;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0005¨\u0006\t"}, d2 = {"Lcom/pspdfkit/annotations/actions/AbstractFormAction$Companion;", "", "<init>", "()V", "toFieldNames", "", "", "formFields", "Lcom/pspdfkit/forms/FormField;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final List<String> toFieldNames(List<? extends FormField> formFields) {
            formFields.getClass();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(formFields, 10));
            Iterator<T> it = formFields.iterator();
            while (it.hasNext()) {
                arrayList.add(((FormField) it.next()).getName());
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractFormAction(List<String> list, List<? extends Action> list2) {
        super(list2);
        list.getClass();
        list2.getClass();
        this.fieldNames = CollectionsKt.toList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource getFormFieldsAsync$lambda$0(AbstractFormAction abstractFormAction, PdfDocument pdfDocument) {
        synchronized (abstractFormAction) {
            List<? extends FormField> list = abstractFormAction.resolvedFormFields;
            if (list != null) {
                return Observable.just(list);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (ar.b().a(NativeLicenseFeatures.ACRO_FORMS)) {
                for (FormField formField : pdfDocument.getFormProvider().getFormFields()) {
                    if (abstractFormAction.fieldNames.contains(formField.getName()) == (!abstractFormAction.shouldExcludeFormFields())) {
                        linkedHashSet.add(formField);
                    }
                }
            }
            return Observable.just(CollectionsKt.toList(linkedHashSet));
        }
    }

    @JvmStatic
    public static final List<String> toFieldNames(List<? extends FormField> list) {
        return INSTANCE.toFieldNames(list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AbstractFormAction) {
            return Intrinsics.areEqual(this.fieldNames, ((AbstractFormAction) other).fieldNames);
        }
        return false;
    }

    public final List<String> getFieldNames() {
        return this.fieldNames;
    }

    public final Observable<List<FormField>> getFormFieldsAsync(final PdfDocument document) {
        document.getClass();
        Observable<List<FormField>> observableDoOnNext = Observable.defer(new Supplier() { // from class: com.pspdfkit.annotations.actions.AbstractFormAction$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return AbstractFormAction.getFormFieldsAsync$lambda$0(this.f$0, document);
            }
        }).subscribeOn(((lm) document).b(5)).doOnNext(new Consumer() { // from class: com.pspdfkit.annotations.actions.AbstractFormAction.getFormFieldsAsync.2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(List<? extends FormField> list) {
                list.getClass();
                AbstractFormAction.this.resolvedFormFields = list;
            }
        });
        observableDoOnNext.getClass();
        return observableDoOnNext;
    }

    public final Single<List<FormField>> getTargetFormFieldsAsync(final PdfDocument document) {
        document.getClass();
        Single<List<FormField>> singleSubscribeOn = Observable.fromIterable(this.fieldNames).flatMapMaybe(new Function() { // from class: com.pspdfkit.annotations.actions.AbstractFormAction.getTargetFormFieldsAsync.1
            @Override // io.reactivex.rxjava3.functions.Function
            public final MaybeSource<? extends FormField> apply(String str) {
                str.getClass();
                return document.getFormProvider().getFormFieldWithFullyQualifiedNameAsync(str);
            }
        }).toList().subscribeOn(((lm) document).b(5));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    public int hashCode() {
        return this.fieldNames.hashCode();
    }

    public boolean shouldExcludeFormFields() {
        return false;
    }

    public String toString() {
        return "fieldNames=" + this.fieldNames;
    }

    public /* synthetic */ AbstractFormAction(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }
}

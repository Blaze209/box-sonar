package com.pspdfkit.annotations.actions;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.f4;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.lm;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\b\u0010\tBE\b\u0017\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\b\u0010\u000fJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0010J!\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010 R\u001a\u0010&\u001a\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/pspdfkit/annotations/actions/HideAction;", "Lcom/pspdfkit/annotations/actions/Action;", "", "Lcom/pspdfkit/internal/f4;", "annotationReferences", "", "hideTargets", "subActions", "<init>", "(Ljava/util/List;ZLjava/util/List;)V", "Lcom/pspdfkit/annotations/Annotation;", "annotations", "Lcom/pspdfkit/forms/FormElement;", "formElements", "shouldHide", "(Ljava/util/List;Ljava/util/List;ZLjava/util/List;)V", "()Z", "Lcom/pspdfkit/document/PdfDocument;", "document", "Lio/reactivex/rxjava3/core/Observable;", "getAnnotationsAsync", "(Lcom/pspdfkit/document/PdfDocument;)Lio/reactivex/rxjava3/core/Observable;", "", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/List;", "getAnnotationReferences", "()Ljava/util/List;", "Z", "resolvedAnnotations", "Lcom/pspdfkit/annotations/actions/ActionType;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HideAction extends Action {
    private final List<f4> annotationReferences;
    private final boolean hideTargets;
    private List<? extends Annotation> resolvedAnnotations;
    private final ActionType type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pspdfkit/annotations/actions/HideAction$Companion;", "", "<init>", "()V", "", "Lcom/pspdfkit/annotations/Annotation;", "annotations", "Lcom/pspdfkit/forms/FormElement;", "formElements", "Lcom/pspdfkit/internal/f4;", "toAnnotationReferences", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<f4> toAnnotationReferences(List<? extends Annotation> annotations, List<? extends FormElement> formElements) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            if (annotations != null) {
                for (Annotation annotation : annotations) {
                    int pageIndex = annotation.getPageIndex();
                    int objectNumber = annotation.getObjectNumber();
                    if (pageIndex != Integer.MIN_VALUE && objectNumber != Integer.MIN_VALUE) {
                        listCreateListBuilder.add(new f4(objectNumber));
                    }
                }
            }
            if (formElements != null) {
                Iterator<T> it = formElements.iterator();
                while (it.hasNext()) {
                    String name = ((FormElement) it.next()).getName();
                    name.getClass();
                    listCreateListBuilder.add(new f4(name));
                }
            }
            return CollectionsKt.build(listCreateListBuilder);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List toAnnotationReferences$default(Companion companion, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = null;
            }
            if ((i & 2) != 0) {
                list2 = null;
            }
            return companion.toAnnotationReferences(list, list2);
        }

        private Companion() {
        }
    }

    public HideAction(List<? extends Annotation> list, List<? extends FormElement> list2, boolean z) {
        this(list, list2, z, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource getAnnotationsAsync$lambda$0(HideAction hideAction, PdfDocument pdfDocument) {
        synchronized (hideAction) {
            List<? extends Annotation> list = hideAction.resolvedAnnotations;
            if (list != null) {
                return Observable.just(list);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(hideAction.annotationReferences.size());
            boolean zA = ar.b().a(NativeLicenseFeatures.ACRO_FORMS);
            HashSet hashSet = new HashSet(hideAction.annotationReferences.size());
            for (f4 f4Var : hideAction.annotationReferences) {
                String str = f4Var.c;
                if (str == null || str.length() == 0) {
                    hashSet.add(Integer.valueOf(f4Var.a));
                } else if (zA) {
                    for (FormElement formElement : pdfDocument.getFormProvider().getFormElements()) {
                        FormField formField = formElement.getFormField();
                        formField.getClass();
                        if (StringsKt.equals(formField.getName(), str, true) || StringsKt.equals(formField.getFullyQualifiedName(), str, true) || StringsKt.equals(formElement.getName(), str, true) || StringsKt.equals(formElement.getFullyQualifiedName(), str, true)) {
                            linkedHashSet.add(formElement.getAnnotation());
                        }
                    }
                }
            }
            if (!hashSet.isEmpty()) {
                linkedHashSet.addAll((Collection) BuildersKt__BuildersKt.runBlocking$default(null, new HideAction$getAnnotationsAsync$1$2(pdfDocument, hashSet, null), 1, null));
            }
            return Observable.just(CollectionsKt.toList(linkedHashSet));
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HideAction)) {
            return false;
        }
        HideAction hideAction = (HideAction) other;
        return this.hideTargets == hideAction.hideTargets && Intrinsics.areEqual(this.annotationReferences, hideAction.annotationReferences);
    }

    public final List<f4> getAnnotationReferences() {
        return this.annotationReferences;
    }

    public final Observable<List<Annotation>> getAnnotationsAsync(final PdfDocument document) {
        document.getClass();
        Observable<List<Annotation>> observableDoOnNext = Observable.defer(new Supplier() { // from class: com.pspdfkit.annotations.actions.HideAction$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return HideAction.getAnnotationsAsync$lambda$0(this.f$0, document);
            }
        }).subscribeOn(((lm) document).b(5)).doOnNext(new Consumer() { // from class: com.pspdfkit.annotations.actions.HideAction.getAnnotationsAsync.2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(List<? extends Annotation> list) {
                list.getClass();
                HideAction.this.resolvedAnnotations = list;
            }
        });
        observableDoOnNext.getClass();
        return observableDoOnNext;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    public int hashCode() {
        return Boolean.hashCode(this.hideTargets) + (this.annotationReferences.hashCode() * 31);
    }

    /* JADX INFO: renamed from: shouldHide, reason: from getter */
    public final boolean getHideTargets() {
        return this.hideTargets;
    }

    public String toString() {
        return "HideAction(shouldHide=" + this.hideTargets + ", targets=" + this.annotationReferences + ")";
    }

    public HideAction(List<? extends Annotation> list, boolean z) {
        this(list, null, z, null, 10, null);
    }

    public HideAction(boolean z) {
        this(null, null, z, null, 11, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HideAction(List<f4> list, boolean z, List<? extends Action> list2) {
        super(list2);
        list.getClass();
        list2.getClass();
        this.annotationReferences = list;
        this.hideTargets = z;
        this.type = ActionType.HIDE;
    }

    public /* synthetic */ HideAction(List list, boolean z, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<f4>) list, z, (List<? extends Action>) ((i & 4) != 0 ? CollectionsKt.emptyList() : list2));
    }

    public /* synthetic */ HideAction(List list, List list2, boolean z, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, z, (i & 8) != 0 ? CollectionsKt.emptyList() : list3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HideAction(List<? extends Annotation> list, List<? extends FormElement> list2, boolean z, List<? extends Action> list3) {
        this((List<f4>) INSTANCE.toAnnotationReferences(list, list2), z, list3);
        list3.getClass();
    }
}

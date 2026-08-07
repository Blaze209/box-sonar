package com.pspdfkit.annotations.actions;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.PdfDocument;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0004J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\n\u0010\u0013\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/annotations/actions/AbstractMediaAction;", "Lcom/pspdfkit/annotations/actions/Action;", "annotationObjectNumber", "", "subActions", "", "<init>", "(ILjava/util/List;)V", "getAnnotationObjectNumber", "()I", "getAnnotationAsync", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/pspdfkit/annotations/Annotation;", "pdfDocument", "Lcom/pspdfkit/document/PdfDocument;", "equals", "", "other", "", "hashCode", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractMediaAction extends Action {
    public static final int $stable = 8;
    private final int annotationObjectNumber;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMediaAction(int i, List<? extends Action> list) {
        super(list);
        list.getClass();
        this.annotationObjectNumber = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAnnotationAsync$lambda$0(PdfDocument pdfDocument, AbstractMediaAction abstractMediaAction) {
        return (List) BuildersKt__BuildersKt.runBlocking$default(null, new AbstractMediaAction$getAnnotationAsync$1$1(pdfDocument, abstractMediaAction, null), 1, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AbstractMediaAction) && this.annotationObjectNumber == ((AbstractMediaAction) other).annotationObjectNumber;
    }

    public final Maybe<Annotation> getAnnotationAsync(final PdfDocument pdfDocument) {
        pdfDocument.getClass();
        Maybe<Annotation> maybeFirstElement = Observable.fromCallable(new Callable() { // from class: com.pspdfkit.annotations.actions.AbstractMediaAction$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AbstractMediaAction.getAnnotationAsync$lambda$0(pdfDocument, this);
            }
        }).subscribeOn(Schedulers.io()).flatMapIterable(new Function() { // from class: com.pspdfkit.annotations.actions.AbstractMediaAction.getAnnotationAsync.2
            @Override // io.reactivex.rxjava3.functions.Function
            public final Iterable<Annotation> apply(List<? extends Annotation> list) {
                return list;
            }
        }).firstElement();
        maybeFirstElement.getClass();
        return maybeFirstElement;
    }

    public final int getAnnotationObjectNumber() {
        return this.annotationObjectNumber;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.annotationObjectNumber));
    }
}

package com.pspdfkit.annotations.actions;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.forms.FormElement;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0014\u001a\u00020\u000eH\u0096\u0080\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/annotations/actions/ActionSender;", "", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "<init>", "(Lcom/pspdfkit/annotations/Annotation;)V", "formElement", "Lcom/pspdfkit/forms/FormElement;", "(Lcom/pspdfkit/forms/FormElement;)V", "getAnnotation", "()Lcom/pspdfkit/annotations/Annotation;", "getFormElement", "()Lcom/pspdfkit/forms/FormElement;", "pageIndex", "", "getPageIndex", "()I", "equals", "", "other", "hashCode", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ActionSender {
    public static final int $stable = 8;
    private final Annotation annotation;
    private final FormElement formElement;

    public ActionSender(Annotation annotation) {
        annotation.getClass();
        this.annotation = annotation;
        this.formElement = null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionSender)) {
            return false;
        }
        ActionSender actionSender = (ActionSender) other;
        return Intrinsics.areEqual(this.annotation, actionSender.annotation) && Intrinsics.areEqual(this.formElement, actionSender.formElement);
    }

    public final Annotation getAnnotation() {
        return this.annotation;
    }

    public final FormElement getFormElement() {
        return this.formElement;
    }

    public final int getPageIndex() {
        Annotation annotation = this.annotation;
        if (annotation != null) {
            return annotation.getPageIndex();
        }
        FormElement formElement = this.formElement;
        if (formElement != null) {
            return formElement.getAnnotation().getPageIndex();
        }
        return Integer.MIN_VALUE;
    }

    public int hashCode() {
        return Objects.hash(this.annotation, this.formElement);
    }

    public ActionSender(FormElement formElement) {
        formElement.getClass();
        this.formElement = formElement;
        this.annotation = null;
    }
}

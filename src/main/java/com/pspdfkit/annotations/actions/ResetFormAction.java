package com.pspdfkit.annotations.actions;

import com.pspdfkit.forms.FormField;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nB\u001f\b\u0016\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0014\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0004H\u0096\u0080\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/annotations/actions/ResetFormAction;", "Lcom/pspdfkit/annotations/actions/AbstractFormAction;", "fieldNames", "", "", "excludeFormFields", "", "subActions", "Lcom/pspdfkit/annotations/actions/Action;", "<init>", "(Ljava/util/List;ZLjava/util/List;)V", "formFields", "Lcom/pspdfkit/forms/FormField;", "(Ljava/util/List;Z)V", "shouldExcludeFormFields", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "other", "", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ResetFormAction extends AbstractFormAction {
    public static final int $stable = 8;
    private final boolean excludeFormFields;
    private final ActionType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetFormAction(List<String> list, boolean z, List<? extends Action> list2) {
        super(list, list2);
        list.getClass();
        list2.getClass();
        this.excludeFormFields = z;
        this.type = ActionType.RESET_FORM;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResetFormAction) && super.equals(other) && this.excludeFormFields == ((ResetFormAction) other).excludeFormFields;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    public int hashCode() {
        return Boolean.hashCode(this.excludeFormFields) + (super.hashCode() * 31);
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    /* JADX INFO: renamed from: shouldExcludeFormFields, reason: from getter */
    public boolean getExcludeFormFields() {
        return this.excludeFormFields;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    public String toString() {
        return "ResetFormAction(" + super.toString() + ", excludeFormFields=" + this.excludeFormFields + ")";
    }

    public /* synthetic */ ResetFormAction(List list, boolean z, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResetFormAction(List<? extends FormField> list, boolean z) {
        this(AbstractFormAction.toFieldNames(list), z, null, 4, null);
        list.getClass();
    }
}

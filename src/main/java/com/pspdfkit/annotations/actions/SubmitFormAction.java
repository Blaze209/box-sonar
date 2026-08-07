package com.pspdfkit.annotations.actions;

import com.pspdfkit.forms.FormField;
import com.pspdfkit.internal.z40;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0082\u0004J\n\u0010\u001c\u001a\u00020\u001dH\u0096\u0080\u0004J\n\u0010\u001e\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/pspdfkit/annotations/actions/SubmitFormAction;", "Lcom/pspdfkit/annotations/actions/AbstractFormAction;", "uri", "", "fieldNames", "", "flags", "Ljava/util/EnumSet;", "Lcom/pspdfkit/annotations/actions/SubmitFormAction$SubmitFormActionFlag;", "subActions", "Lcom/pspdfkit/annotations/actions/Action;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/EnumSet;Ljava/util/List;)V", "formFields", "Lcom/pspdfkit/forms/FormField;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/EnumSet;)V", "getUri", "()Ljava/lang/String;", "shouldExcludeFormFields", "", "getFlags", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "other", "", "hashCode", "", "toString", "SubmitFormActionFlag", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SubmitFormAction extends AbstractFormAction {
    public static final int $stable = 8;
    private final EnumSet<SubmitFormActionFlag> flags;
    private final ActionType type;
    private final String uri;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/pspdfkit/annotations/actions/SubmitFormAction$SubmitFormActionFlag;", "", "<init>", "(Ljava/lang/String;I)V", "INCLUDE_EXCLUDE", "INCLUDE_NO_VALUE_FIELDS", "EXPORT_FORMAT", "GET_METHOD", "SUBMIT_COORDINATES", "XFDF", "INCLUDE_APPEND_SAVES", "INCLUDE_ANNOTATIONS", "SUBMIT_PDF", "CANONICAL_FORMAT", "EXCLUDE_NON_USER_ANNOTATIONS", "EMBED_FORM", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum SubmitFormActionFlag {
        INCLUDE_EXCLUDE,
        INCLUDE_NO_VALUE_FIELDS,
        EXPORT_FORMAT,
        GET_METHOD,
        SUBMIT_COORDINATES,
        XFDF,
        INCLUDE_APPEND_SAVES,
        INCLUDE_ANNOTATIONS,
        SUBMIT_PDF,
        CANONICAL_FORMAT,
        EXCLUDE_NON_USER_ANNOTATIONS,
        EMBED_FORM;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<SubmitFormActionFlag> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitFormAction(String str, List<String> list, EnumSet<SubmitFormActionFlag> enumSet, List<? extends Action> list2) {
        super(list, list2);
        str.getClass();
        list.getClass();
        enumSet.getClass();
        list2.getClass();
        this.uri = str;
        EnumSet<SubmitFormActionFlag> enumSetCopyOf = EnumSet.copyOf((EnumSet) enumSet);
        enumSetCopyOf.getClass();
        this.flags = enumSetCopyOf;
        this.type = ActionType.SUBMIT_FORM;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubmitFormAction) || !super.equals(other)) {
            return false;
        }
        SubmitFormAction submitFormAction = (SubmitFormAction) other;
        return Intrinsics.areEqual(this.uri, submitFormAction.uri) && Intrinsics.areEqual(this.flags, submitFormAction.flags);
    }

    public final EnumSet<SubmitFormActionFlag> getFlags() {
        EnumSet<SubmitFormActionFlag> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.flags);
        enumSetCopyOf.getClass();
        return enumSetCopyOf;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    public int hashCode() {
        return this.flags.hashCode() + z40.a(this.uri, super.hashCode() * 31, 31);
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    public boolean shouldExcludeFormFields() {
        return this.flags.contains(SubmitFormActionFlag.INCLUDE_EXCLUDE);
    }

    @Override // com.pspdfkit.annotations.actions.AbstractFormAction
    public String toString() {
        return "SubmitFormAction(uri='" + this.uri + "', " + super.toString() + ", flags=" + this.flags + ")";
    }

    public /* synthetic */ SubmitFormAction(String str, List list, EnumSet enumSet, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, enumSet, (i & 8) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubmitFormAction(String str, List<? extends FormField> list, EnumSet<SubmitFormActionFlag> enumSet) {
        this(str, AbstractFormAction.toFieldNames(list), enumSet, null, 8, null);
        str.getClass();
        list.getClass();
        enumSet.getClass();
    }
}

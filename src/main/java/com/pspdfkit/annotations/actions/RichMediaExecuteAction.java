package com.pspdfkit.annotations.actions;

import com.pspdfkit.annotations.RichMediaAnnotation;
import com.pspdfkit.document.PdfDocument;
import io.reactivex.rxjava3.core.Maybe;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0003J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0082\u0004J\n\u0010\u001b\u001a\u00020\u0005H\u0096\u0080\u0004J\n\u0010\u001c\u001a\u00020\u001dH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction;", "Lcom/pspdfkit/annotations/actions/AbstractMediaAction;", "actionType", "Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction$RichMediaExecuteActionType;", "screenAnnotationObjectNumber", "", "subActions", "", "Lcom/pspdfkit/annotations/actions/Action;", "<init>", "(Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction$RichMediaExecuteActionType;ILjava/util/List;)V", "getActionType", "()Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction$RichMediaExecuteActionType;", "getRichMediaAnnotationAsync", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/pspdfkit/annotations/RichMediaAnnotation;", "pdfDocument", "Lcom/pspdfkit/document/PdfDocument;", "getRichMediaExecuteActionType", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "", "other", "", "hashCode", "toString", "", "RichMediaExecuteActionType", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RichMediaExecuteAction extends AbstractMediaAction {
    public static final int $stable = 8;
    private final RichMediaExecuteActionType actionType;
    private final ActionType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction$RichMediaExecuteActionType;", "", "<init>", "(Ljava/lang/String;I)V", "PLAY", "PAUSE", "SEEK", "REWIND", "UNKNOWN", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum RichMediaExecuteActionType {
        PLAY,
        PAUSE,
        SEEK,
        REWIND,
        UNKNOWN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<RichMediaExecuteActionType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichMediaExecuteAction(RichMediaExecuteActionType richMediaExecuteActionType, int i, List<? extends Action> list) {
        super(i, list);
        richMediaExecuteActionType.getClass();
        list.getClass();
        this.actionType = richMediaExecuteActionType;
        this.type = ActionType.RICH_MEDIA_EXECUTE;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractMediaAction
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RichMediaExecuteAction) && super.equals(other) && this.actionType == ((RichMediaExecuteAction) other).actionType;
    }

    public final RichMediaExecuteActionType getActionType() {
        return this.actionType;
    }

    public final Maybe<RichMediaAnnotation> getRichMediaAnnotationAsync(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        Maybe maybeCast = getAnnotationAsync(pdfDocument).cast(RichMediaAnnotation.class);
        maybeCast.getClass();
        return maybeCast;
    }

    public final RichMediaExecuteActionType getRichMediaExecuteActionType() {
        return this.actionType;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractMediaAction
    public int hashCode() {
        return this.actionType.hashCode() + (super.hashCode() * 31);
    }

    public String toString() {
        return "RichMediaExecuteAction(actionType=" + this.actionType + ", screenAnnotationObjectNumber=" + getAnnotationObjectNumber() + ")";
    }

    public /* synthetic */ RichMediaExecuteAction(RichMediaExecuteActionType richMediaExecuteActionType, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(richMediaExecuteActionType, i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }
}

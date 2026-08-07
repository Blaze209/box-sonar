package com.pspdfkit.annotations.actions;

import com.pspdfkit.annotations.ScreenAnnotation;
import com.pspdfkit.document.PdfDocument;
import io.reactivex.rxjava3.core.Maybe;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001 B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0082\u0004J\n\u0010\u001e\u001a\u00020\u0005H\u0096\u0080\u0004J\n\u0010\u001f\u001a\u00020\u0007H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/pspdfkit/annotations/actions/RenditionAction;", "Lcom/pspdfkit/annotations/actions/AbstractMediaAction;", "renditionActionType", "Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType;", "screenAnnotationObjectNumber", "", JavascriptRunner.JAVA_SCRIPT_TYPE, "", "subActions", "", "Lcom/pspdfkit/annotations/actions/Action;", "<init>", "(Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType;ILjava/lang/String;Ljava/util/List;)V", "getRenditionActionType", "()Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType;", "getJavascript", "()Ljava/lang/String;", "getScreenAnnotationAsync", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/pspdfkit/annotations/ScreenAnnotation;", "pdfDocument", "Lcom/pspdfkit/document/PdfDocument;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "", "other", "", "hashCode", "toString", "RenditionActionType", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RenditionAction extends AbstractMediaAction {
    public static final int $stable = 8;
    private final String javascript;
    private final RenditionActionType renditionActionType;
    private final ActionType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType;", "", "<init>", "(Ljava/lang/String;I)V", "PLAY_STOP", "STOP", "PAUSE", "RESUME", "PLAY", "UNKNOWN", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum RenditionActionType {
        PLAY_STOP,
        STOP,
        PAUSE,
        RESUME,
        PLAY,
        UNKNOWN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType;", "value", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final RenditionActionType fromValue(int value) {
                RenditionActionType renditionActionType = (RenditionActionType) CollectionsKt.getOrNull(RenditionActionType.getEntries(), value);
                return renditionActionType == null ? RenditionActionType.UNKNOWN : renditionActionType;
            }

            private Companion() {
            }
        }

        @JvmStatic
        public static final RenditionActionType fromValue(int i) {
            return INSTANCE.fromValue(i);
        }

        public static EnumEntries<RenditionActionType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenditionAction(RenditionActionType renditionActionType, int i, String str, List<? extends Action> list) {
        super(i, list);
        renditionActionType.getClass();
        list.getClass();
        this.renditionActionType = renditionActionType;
        this.javascript = str;
        this.type = ActionType.RENDITION;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractMediaAction
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenditionAction) || !super.equals(other)) {
            return false;
        }
        RenditionAction renditionAction = (RenditionAction) other;
        return this.renditionActionType == renditionAction.renditionActionType && Intrinsics.areEqual(this.javascript, renditionAction.javascript);
    }

    public final String getJavascript() {
        return this.javascript;
    }

    public final RenditionActionType getRenditionActionType() {
        return this.renditionActionType;
    }

    public final Maybe<ScreenAnnotation> getScreenAnnotationAsync(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        Maybe maybeCast = getAnnotationAsync(pdfDocument).cast(ScreenAnnotation.class);
        maybeCast.getClass();
        return maybeCast;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    @Override // com.pspdfkit.annotations.actions.AbstractMediaAction
    public int hashCode() {
        int iHashCode = (this.renditionActionType.hashCode() + (super.hashCode() * 31)) * 31;
        String str = this.javascript;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "RenditionAction(renditionActionType=" + this.renditionActionType + ", screenAnnotationObjectNumber=" + getAnnotationObjectNumber() + ", javascript=" + this.javascript + ")";
    }

    public /* synthetic */ RenditionAction(RenditionActionType renditionActionType, int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(renditionActionType, i, str, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list);
    }
}

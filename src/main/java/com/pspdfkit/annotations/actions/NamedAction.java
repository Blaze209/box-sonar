package com.pspdfkit.annotations.actions;

import com.pspdfkit.internal.gr;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0082\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\u000bH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/pspdfkit/annotations/actions/NamedAction;", "Lcom/pspdfkit/annotations/actions/Action;", "namedActionType", "Lcom/pspdfkit/annotations/actions/NamedAction$NamedActionType;", "subActions", "", "<init>", "(Lcom/pspdfkit/annotations/actions/NamedAction$NamedActionType;Ljava/util/List;)V", "getNamedActionType", "()Lcom/pspdfkit/annotations/actions/NamedAction$NamedActionType;", "getActionString", "", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "", "other", "", "hashCode", "", "toString", "NamedActionType", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NamedAction extends Action {
    public static final int $stable = 8;
    private final NamedActionType namedActionType;
    private final ActionType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/annotations/actions/NamedAction$NamedActionType;", "", "<init>", "(Ljava/lang/String;I)V", "NEXTPAGE", "PREVIOUSPAGE", "FIRSTPAGE", "LASTPAGE", "GOBACK", "GOFORWARD", "GOTOPAGE", "FIND", "PRINT", "OUTLINE", "SEARCH", "BRIGHTNESS", "ZOOMIN", "ZOOMOUT", "SAVEAS", "INFO", "UNKNOWN", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum NamedActionType {
        NEXTPAGE,
        PREVIOUSPAGE,
        FIRSTPAGE,
        LASTPAGE,
        GOBACK,
        GOFORWARD,
        GOTOPAGE,
        FIND,
        PRINT,
        OUTLINE,
        SEARCH,
        BRIGHTNESS,
        ZOOMIN,
        ZOOMOUT,
        SAVEAS,
        INFO,
        UNKNOWN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<NamedActionType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NamedAction(NamedActionType namedActionType) {
        this(namedActionType, null, 2, 0 == true ? 1 : 0);
        namedActionType.getClass();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NamedAction) && this.namedActionType == ((NamedAction) other).namedActionType;
    }

    public final String getActionString() {
        NamedActionType namedActionType = this.namedActionType;
        Map<NamedActionType, String> map = gr.a;
        namedActionType.getClass();
        String str = gr.a.get(namedActionType);
        return str == null ? "Unknown" : str;
    }

    public final NamedActionType getNamedActionType() {
        return this.namedActionType;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.namedActionType.hashCode();
    }

    public String toString() {
        return "NamedAction(namedActionType=" + this.namedActionType + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NamedAction(NamedActionType namedActionType, List<? extends Action> list) {
        super(list);
        namedActionType.getClass();
        list.getClass();
        this.namedActionType = namedActionType;
        this.type = ActionType.NAMED;
    }

    public /* synthetic */ NamedAction(NamedActionType namedActionType, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(namedActionType, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}

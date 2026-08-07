package com.pspdfkit.annotations.actions;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0082\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0003H\u0096\u0080\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/annotations/actions/LaunchAction;", "Lcom/pspdfkit/annotations/actions/Action;", "path", "", "subActions", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "", "other", "", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LaunchAction extends Action {
    public static final int $stable = 8;
    private final String path;
    private final ActionType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchAction(String str, List<? extends Action> list) {
        super(list);
        list.getClass();
        this.path = str;
        this.type = ActionType.LAUNCH;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LaunchAction) {
            return Intrinsics.areEqual(this.path, ((LaunchAction) other).path);
        }
        return false;
    }

    public final String getPath() {
        return this.path;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.path;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "LaunchAction(path=" + this.path + ")";
    }

    public /* synthetic */ LaunchAction(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}

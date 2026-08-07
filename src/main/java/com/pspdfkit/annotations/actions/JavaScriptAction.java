package com.pspdfkit.annotations.actions;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0082\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/annotations/actions/JavaScriptAction;", "Lcom/pspdfkit/annotations/actions/Action;", JavascriptRunner.SCRIPT_NAME, "", "subActions", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getScript", "()Ljava/lang/String;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "hashCode", "", "equals", "", "other", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JavaScriptAction extends Action {
    public static final int $stable = 8;
    private final String script;
    private final ActionType type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JavaScriptAction(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
        str.getClass();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof JavaScriptAction) {
            return Intrinsics.areEqual(this.script, ((JavaScriptAction) other).script);
        }
        return false;
    }

    public final String getScript() {
        return this.script;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.script.hashCode();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaScriptAction(String str, List<? extends Action> list) {
        super(list);
        str.getClass();
        list.getClass();
        this.script = str;
        this.type = ActionType.JAVASCRIPT;
    }

    public /* synthetic */ JavaScriptAction(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}

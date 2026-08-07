package com.pspdfkit.annotations.actions;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pspdfkit/annotations/actions/Action;", "", "subActions", "", "<init>", "(Ljava/util/List;)V", "getSubActions", "()Ljava/util/List;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Action {
    public static final int $stable = 8;
    private final List<Action> subActions;

    /* JADX WARN: Multi-variable type inference failed */
    public Action() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<Action> getSubActions() {
        return this.subActions;
    }

    public abstract ActionType getType();

    /* JADX WARN: Multi-variable type inference failed */
    public Action(List<? extends Action> list) {
        list.getClass();
        this.subActions = list;
    }

    public /* synthetic */ Action(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}

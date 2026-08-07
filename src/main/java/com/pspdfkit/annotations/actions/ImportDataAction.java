package com.pspdfkit.annotations.actions;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/pspdfkit/annotations/actions/ImportDataAction;", "Lcom/pspdfkit/annotations/actions/Action;", "subActions", "", "<init>", "(Ljava/util/List;)V", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ImportDataAction extends Action {
    public static final int $stable = 8;
    private final ActionType type;

    /* JADX WARN: Multi-variable type inference failed */
    public ImportDataAction() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportDataAction(List<? extends Action> list) {
        super(list);
        list.getClass();
        this.type = ActionType.IMPORT_DATA;
    }

    public /* synthetic */ ImportDataAction(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}

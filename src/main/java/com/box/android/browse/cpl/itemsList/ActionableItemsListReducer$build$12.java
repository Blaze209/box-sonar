package com.box.android.browse.cpl.itemsList;

import com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ActionableItemsListReducer$build$12 extends FunctionReferenceImpl implements Function1<BoxAiMultidocAvailabilityReducer.Action, ActionableItemsListReducer.Action.BoxAiMultidocAvailabilityAction> {
    public static final ActionableItemsListReducer$build$12 INSTANCE = new ActionableItemsListReducer$build$12();

    ActionableItemsListReducer$build$12() {
        super(1, ActionableItemsListReducer.Action.BoxAiMultidocAvailabilityAction.class, "<init>", "<init>(Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ActionableItemsListReducer.Action.BoxAiMultidocAvailabilityAction invoke(BoxAiMultidocAvailabilityReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ActionableItemsListReducer.Action.BoxAiMultidocAvailabilityAction(p0);
    }
}

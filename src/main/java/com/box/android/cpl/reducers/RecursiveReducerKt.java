package com.box.android.cpl.reducers;

import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecursiveReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0092\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0010\b\u0002\u0010\u0004\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0005*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0016\b\b\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00072\u001a\b\b\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\t2\u0014\b\b\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"recursive", "Lcom/box/android/cpl/Reducable;", "State", "Action", "EmbeddedChildAction", "Lcom/box/android/cpl/Embedded;", "toChildState", "Lkotlin/Function1;", "toParentState", "Lkotlin/Function2;", "toParentAction", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RecursiveReducerKt {
    public static final /* synthetic */ <State, Action, EmbeddedChildAction extends Embedded<Action>> Reducable<State, Action> recursive(Reducable<State, Action> reducable, Function1<? super State, ? extends State> toChildState, Function2<? super State, ? super State, ? extends State> toParentState, final Function1<? super Action, ? extends EmbeddedChildAction> toParentAction) {
        Intrinsics.checkNotNullParameter(reducable, "<this>");
        Intrinsics.checkNotNullParameter(toChildState, "toChildState");
        Intrinsics.checkNotNullParameter(toParentState, "toParentState");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Intrinsics.needClassReification();
        return new RecursiveReducer(reducable, toChildState, anonymousClass1, toParentState, new Function1<Action, Action>() { // from class: com.box.android.cpl.reducers.RecursiveReducerKt.recursive.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Action invoke(Action action) {
                Action action2 = (Action) toParentAction.invoke(action);
                Intrinsics.reifiedOperationMarker(1, "Action");
                return action2;
            }
        });
    }
}

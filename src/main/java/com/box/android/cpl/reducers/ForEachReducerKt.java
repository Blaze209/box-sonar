package com.box.android.cpl.reducers;

import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Reducable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ForEachReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aÊ\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0005\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u000e\b\u0003\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00040\u0007\"\u0004\b\u0004\u0010\b\"\u0016\b\u0005\u0010\t\u0018\u0001*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\b0\n*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\r0\f2\u001a\b\b\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b0\u00010\u0011H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"forEach", "Lcom/box/android/cpl/Reducable;", "ParentState", "ParentAction", "ID", "", "ChildState", "Lcom/box/android/cpl/Identifiable;", "ChildAction", "EmbeddedItemAction", "Lcom/box/android/cpl/EmbeddedItem;", "itemsProperty", "Lkotlin/reflect/KProperty1;", "Lcom/box/android/cpl/IdentifiedList;", "toParentAction", "Lkotlin/Function2;", "child", "Lkotlin/Function0;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ForEachReducerKt {
    public static final /* synthetic */ <ID, ParentState, ParentAction, ChildState extends Identifiable<ID>, ChildAction, EmbeddedItemAction extends EmbeddedItem<ID, ChildAction>> Reducable<ParentState, ParentAction> forEach(Reducable<ParentState, ParentAction> reducable, final KProperty1<ParentState, IdentifiedList<ID, ChildState>> itemsProperty, final Function2<? super ID, ? super ChildAction, ? extends EmbeddedItemAction> toParentAction, Function0<? extends Reducable<ChildState, ChildAction>> child) {
        Intrinsics.checkNotNullParameter(reducable, "<this>");
        Intrinsics.checkNotNullParameter(itemsProperty, "itemsProperty");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        Intrinsics.checkNotNullParameter(child, "child");
        Reducable<ChildState, ChildAction> reducableInvoke = child.invoke();
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<ParentState, ChildState, ParentState>() { // from class: com.box.android.cpl.reducers.ForEachReducerKt.forEach.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Incorrect types in method signature: (TParentState;TChildState;)TParentState; */
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object parentState, Identifiable childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) itemsProperty.get((ParentState) parentState)).listByReplacingElement(childState);
                KProperty1<ParentState, IdentifiedList<ID, ChildState>> kProperty1 = itemsProperty;
                Intrinsics.reifiedOperationMarker(4, "ParentState");
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(Object.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        Object objCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, identifiedListListByReplacingElement)));
                        Intrinsics.reifiedOperationMarker(1, "ParentState");
                        return objCallBy;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        };
        Intrinsics.needClassReification();
        return new ForEachReducer(reducable, reducableInvoke, itemsProperty, anonymousClass1, function2, new Function2<ID, ChildAction, ParentAction>() { // from class: com.box.android.cpl.reducers.ForEachReducerKt.forEach.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ParentAction invoke(ID id, ChildAction childaction) {
                Intrinsics.checkNotNullParameter(id, "id");
                ParentAction parentaction = (ParentAction) toParentAction.invoke(id, childaction);
                Intrinsics.reifiedOperationMarker(1, "ParentAction");
                return parentaction;
            }
        });
    }
}

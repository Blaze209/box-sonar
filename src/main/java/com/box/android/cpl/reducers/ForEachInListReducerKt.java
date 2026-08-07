package com.box.android.cpl.reducers;

import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Reducable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.InvalidObjectException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ForEachInListReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a°\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0006\"\u0016\b\u0004\u0010\u0007\u0018\u0001*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00060\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\f0\u000b2\u001a\b\b\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00010\u0010H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"forEachInList", "Lcom/box/android/cpl/Reducable;", "ParentState", "ParentAction", "", "ChildState", "ChildAction", "EmbeddedItemAction", "Lcom/box/android/cpl/EmbeddedItem;", "", "listProperty", "Lkotlin/reflect/KProperty1;", "", "toParentAction", "Lkotlin/Function2;", "child", "Lkotlin/Function0;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ForEachInListReducerKt {
    public static final /* synthetic */ <ParentState, ParentAction, ChildState, ChildAction, EmbeddedItemAction extends EmbeddedItem<Integer, ChildAction>> Reducable<ParentState, ParentAction> forEachInList(Reducable<ParentState, ParentAction> reducable, final KProperty1<ParentState, ? extends List<? extends ChildState>> listProperty, final Function2<? super Integer, ? super ChildAction, ? extends EmbeddedItemAction> toParentAction, Function0<? extends Reducable<ChildState, ChildAction>> child) {
        Intrinsics.checkNotNullParameter(reducable, "<this>");
        Intrinsics.checkNotNullParameter(listProperty, "listProperty");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        Intrinsics.checkNotNullParameter(child, "child");
        Reducable<ChildState, ChildAction> reducableInvoke = child.invoke();
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Intrinsics.needClassReification();
        Function3<ParentState, ChildState, Integer, ParentState> function3 = new Function3<ParentState, ChildState, Integer, ParentState>() { // from class: com.box.android.cpl.reducers.ForEachInListReducerKt.forEachInList.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Integer num) {
                return invoke(obj, obj2, num.intValue());
            }

            public final ParentState invoke(ParentState parentState, ChildState childstate, int i) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                List mutableList = CollectionsKt.toMutableList((Collection) listProperty.get(parentState));
                mutableList.set(i, childstate);
                KProperty1<ParentState, List<ChildState>> kProperty1 = listProperty;
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
                        ParentState parentstate = (ParentState) kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, mutableList)));
                        Intrinsics.reifiedOperationMarker(1, "ParentState");
                        return parentstate;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        };
        Intrinsics.needClassReification();
        return new ForEachInListReducer(reducable, reducableInvoke, listProperty, anonymousClass1, function3, new Function2<Integer, ChildAction, ParentAction>() { // from class: com.box.android.cpl.reducers.ForEachInListReducerKt.forEachInList.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
                return invoke(num.intValue(), obj);
            }

            public final ParentAction invoke(int i, ChildAction childaction) {
                ParentAction parentaction = (ParentAction) toParentAction.invoke(Integer.valueOf(i), childaction);
                Intrinsics.reifiedOperationMarker(1, "ParentAction");
                return parentaction;
            }
        });
    }
}

package com.box.android.cpl.reducers;

import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.hermes.intl.Constants;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: IfLetReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a²\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0006\"\u0010\b\u0004\u0010\u0007\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00050\b\"\u0010\b\u0005\u0010\t\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00060\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\b\b\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00070\u000b2\u0014\b\b\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t0\u000b2\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00010\u000eH\u0086\bø\u0001\u0000\u001aÐ\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\b\b\u0002\u0010\u0005*\u00020\u0004\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\u0010\"\u0010\b\u0005\u0010\u0007\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00050\b\"\u0010\b\u0006\u0010\t\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00060\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u00122\u0014\b\b\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00070\u000b2\u0014\b\b\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t0\u000b2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00010\u000eH\u0086\bø\u0001\u0000\u001aº\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\b\b\u0002\u0010\u0005*\u0002H\u0010\"\u0004\b\u0003\u0010\u0006\"\b\b\u0004\u0010\u0010*\u00020\u0004\"\u0010\b\u0005\u0010\t\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00060\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00162\u0014\b\b\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t0\u000b2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00010\u000eH\u0086\bø\u0001\u0000\u001a \u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0006\"\u0010\b\u0004\u0010\t\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00060\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u00122\u0014\b\b\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t0\u000b2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00010\u000eH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"ifCaseLet", "Lcom/box/android/cpl/Reducable;", "ParentState", "ParentAction", "", "ChildState", "ChildAction", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "ConcreteAction", "toConcreteParentState", "Lkotlin/Function1;", "toParentAction", Constants.SENSITIVITY_CASE, "Lkotlin/Function0;", "ifCaseScope", "BaseState", "property", "Lkotlin/reflect/KProperty1;", "toConcreteState", "child", "concreteClass", "Lkotlin/reflect/KClass;", "scope", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class IfLetReducerKt {
    public static final /* synthetic */ <ParentState, ParentAction, ChildState, ChildAction, ConcreteAction extends Embedded<ChildAction>> Reducable<ParentState, ParentAction> scope(Reducable<ParentState, ParentAction> reducable, final KProperty1<ParentState, ? extends ChildState> property, final Function1<? super ChildAction, ? extends ConcreteAction> toParentAction, Function0<? extends Reducable<ChildState, ChildAction>> child) {
        Intrinsics.checkNotNullParameter(reducable, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        Intrinsics.checkNotNullParameter(child, "child");
        Reducable<ChildState, ChildAction> reducableInvoke = child.invoke();
        Intrinsics.needClassReification();
        Function1<ParentState, ChildState> function1 = new Function1<ParentState, ChildState>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.scope.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChildState invoke(ParentState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return property.invoke(it);
            }
        };
        Intrinsics.needClassReification();
        C10672 c10672 = C10672.INSTANCE;
        Intrinsics.needClassReification();
        Function2<ParentState, ChildState, ParentState> function2 = new Function2<ParentState, ChildState, ParentState>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.scope.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ParentState invoke(ParentState parentState, ChildState childstate) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1<ParentState, ChildState> kProperty1 = property;
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
                        ParentState parentstate = (ParentState) kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childstate)));
                        Intrinsics.reifiedOperationMarker(1, "ParentState");
                        return parentstate;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        };
        Intrinsics.needClassReification();
        return new IfLetReducer(reducable, reducableInvoke, function1, c10672, function2, new Function1<ChildAction, ParentAction>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.scope.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ParentAction invoke(ChildAction childaction) {
                ParentAction parentaction = (ParentAction) toParentAction.invoke(childaction);
                Intrinsics.reifiedOperationMarker(1, "ParentAction");
                return parentaction;
            }
        });
    }

    public static final /* synthetic */ <ParentState, ParentAction, ChildState, ChildAction, ConcreteState extends Embedded<ChildState>, ConcreteAction extends Embedded<ChildAction>> Reducable<ParentState, ParentAction> ifCaseLet(Reducable<ParentState, ParentAction> reducable, final Function1<? super ChildState, ? extends ConcreteState> toConcreteParentState, final Function1<? super ChildAction, ? extends ConcreteAction> toParentAction, Function0<? extends Reducable<ChildState, ChildAction>> function0) {
        Intrinsics.checkNotNullParameter(reducable, "<this>");
        Intrinsics.checkNotNullParameter(toConcreteParentState, "toConcreteParentState");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        Intrinsics.checkNotNullParameter(function0, "case");
        Reducable<ChildState, ChildAction> reducableInvoke = function0.invoke();
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Intrinsics.needClassReification();
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Intrinsics.needClassReification();
        Function2<ParentState, ChildState, ParentState> function2 = new Function2<ParentState, ChildState, ParentState>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseLet.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ParentState invoke(ParentState parentstate, ChildState childstate) {
                Intrinsics.checkNotNullParameter(parentstate, "<anonymous parameter 0>");
                ParentState parentstate2 = (ParentState) toConcreteParentState.invoke(childstate);
                Intrinsics.reifiedOperationMarker(1, "ParentState");
                return parentstate2;
            }
        };
        Intrinsics.needClassReification();
        return new IfLetReducer(reducable, reducableInvoke, anonymousClass1, anonymousClass2, function2, new Function1<ChildAction, ParentAction>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseLet.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ParentAction invoke(ChildAction childaction) {
                ParentAction parentaction = (ParentAction) toParentAction.invoke(childaction);
                Intrinsics.reifiedOperationMarker(1, "ParentAction");
                return parentaction;
            }
        });
    }

    public static final /* synthetic */ <ParentState, ParentAction, ChildState, ChildAction, BaseState, ConcreteState extends Embedded<ChildState>, ConcreteAction extends Embedded<ChildAction>> Reducable<ParentState, ParentAction> ifCaseScope(Reducable<ParentState, ParentAction> reducable, final KProperty1<ParentState, ? extends BaseState> property, final Function1<? super ChildState, ? extends ConcreteState> toConcreteState, final Function1<? super ChildAction, ? extends ConcreteAction> toParentAction, Function0<? extends Reducable<ChildState, ChildAction>> child) {
        Intrinsics.checkNotNullParameter(reducable, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(toConcreteState, "toConcreteState");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        Intrinsics.checkNotNullParameter(child, "child");
        Reducable<ChildState, ChildAction> reducableInvoke = child.invoke();
        Intrinsics.needClassReification();
        Function1<ParentState, ChildState> function1 = new Function1<ParentState, ChildState>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseScope.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChildState invoke(ParentState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = property.invoke(it);
                Intrinsics.reifiedOperationMarker(2, "ConcreteState");
                Embedded embedded = (Embedded) objInvoke;
                if (embedded != null) {
                    return (ChildState) embedded.getAction();
                }
                return null;
            }
        };
        Intrinsics.needClassReification();
        C10632 c10632 = C10632.INSTANCE;
        Intrinsics.needClassReification();
        Function2<ParentState, ChildState, ParentState> function2 = new Function2<ParentState, ChildState, ParentState>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseScope.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ParentState invoke(ParentState parentState, ChildState childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty kProperty = property;
                Object objInvoke = toConcreteState.invoke(childState);
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
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty.getName())) {
                        ParentState parentstate = (ParentState) kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        Intrinsics.reifiedOperationMarker(1, "ParentState");
                        return parentstate;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        };
        Intrinsics.needClassReification();
        return new IfLetReducer(reducable, reducableInvoke, function1, c10632, function2, new Function1<ChildAction, ParentAction>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseScope.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ParentAction invoke(ChildAction childaction) {
                ParentAction parentaction = (ParentAction) toParentAction.invoke(childaction);
                Intrinsics.reifiedOperationMarker(1, "ParentAction");
                return parentaction;
            }
        });
    }

    public static final /* synthetic */ <ParentState, ParentAction, ChildState extends BaseState, ChildAction, BaseState, ConcreteAction extends Embedded<ChildAction>> Reducable<ParentState, ParentAction> ifCaseScope(Reducable<ParentState, ParentAction> reducable, final KProperty1<ParentState, ? extends BaseState> property, final KClass<ChildState> concreteClass, final Function1<? super ChildAction, ? extends ConcreteAction> toParentAction, Function0<? extends Reducable<ChildState, ChildAction>> child) {
        Intrinsics.checkNotNullParameter(reducable, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(concreteClass, "concreteClass");
        Intrinsics.checkNotNullParameter(toParentAction, "toParentAction");
        Intrinsics.checkNotNullParameter(child, "child");
        Reducable<ChildState, ChildAction> reducableInvoke = child.invoke();
        Intrinsics.needClassReification();
        Function1 function1 = new Function1<ParentState, ChildState>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseScope.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChildState invoke(ParentState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (ChildState) kotlin.reflect.KClasses.safeCast(concreteClass, property.invoke(it));
            }
        };
        Intrinsics.needClassReification();
        AnonymousClass6 anonymousClass6 = AnonymousClass6.INSTANCE;
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<ParentState, ChildState, ParentState>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseScope.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ParentState invoke(ParentState parentState, ChildState childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty kProperty = property;
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
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty.getName())) {
                        ParentState parentstate = (ParentState) kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        Intrinsics.reifiedOperationMarker(1, "ParentState");
                        return parentstate;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        };
        Intrinsics.needClassReification();
        return new IfLetReducer(reducable, reducableInvoke, function1, anonymousClass6, function2, new Function1<ChildAction, ParentAction>() { // from class: com.box.android.cpl.reducers.IfLetReducerKt.ifCaseScope.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ParentAction invoke(ChildAction childaction) {
                ParentAction parentaction = (ParentAction) toParentAction.invoke(childaction);
                Intrinsics.reifiedOperationMarker(1, "ParentAction");
                return parentaction;
            }
        });
    }
}

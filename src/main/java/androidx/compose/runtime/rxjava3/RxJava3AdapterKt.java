package androidx.compose.runtime.rxjava3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RxJava3Adapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\n\b\u0001\u0010\u0003*\u0004\b\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\n\b\u0001\u0010\u0003*\u0004\b\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00072\u0006\u0010\u0005\u001a\u0002H\u0002H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\n\b\u0001\u0010\u0003*\u0004\b\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00030\t2\u0006\u0010\u0005\u001a\u0002H\u0002H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\n\b\u0001\u0010\u0003*\u0004\b\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010\u0005\u001a\u0002H\u0002H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aY\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0011*\u0002H\u00112\u0006\u0010\u0005\u001a\u0002H\u00032+\b\u0004\u0010\u0012\u001a%\u0012\u0004\u0012\u0002H\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013¢\u0006\u0002\b\u0017H\u0083\b¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b9¨\u0006\u0019"}, d2 = {"subscribeAsState", "Landroidx/compose/runtime/State;", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lio/reactivex/rxjava3/core/Observable;", "initial", "(Lio/reactivex/rxjava3/core/Observable;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "Lio/reactivex/rxjava3/core/Flowable;", "(Lio/reactivex/rxjava3/core/Flowable;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "Lio/reactivex/rxjava3/core/Single;", "(Lio/reactivex/rxjava3/core/Single;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "Lio/reactivex/rxjava3/core/Maybe;", "(Lio/reactivex/rxjava3/core/Maybe;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "", "Lio/reactivex/rxjava3/core/Completable;", "(Lio/reactivex/rxjava3/core/Completable;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "asState", ExifInterface.LATITUDE_SOUTH, "subscribe", "Lkotlin/Function2;", "Lkotlin/Function1;", "", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime-rxjava3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RxJava3AdapterKt {
    public static final <R, T extends R> State<R> subscribeAsState(final Observable<T> observable, R r, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -845703663, "C(subscribeAsState)N(initial)48@2087L34:RxJava3Adapter.kt#wvx964");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-845703663, i, -1, "androidx.compose.runtime.rxjava3.subscribeAsState (RxJava3Adapter.kt:48)");
        }
        int i2 = (i & 112) | (i & 14) | (((i >> 3) & 8) << 3);
        ComposerKt.sourceInformationMarkerStart(composer, -675894395, "CC(asState)N(initial,subscribe)129@5800L36,130@5841L129:RxJava3Adapter.kt#wvx964");
        ComposerKt.sourceInformationMarkerStart(composer, -994447831, "CC(remember):RxJava3Adapter.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(observable, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$1
            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Object obj = observable;
                final MutableState mutableState2 = mutableState;
                final Disposable disposableSubscribe = ((Observable) obj).subscribe(new RxJava3AdapterKt$sam$io_reactivex_rxjava3_functions_Consumer$0(new Function1<R, Unit>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                        invoke2(obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(R r2) {
                        mutableState2.setValue(r2);
                    }
                }));
                return new DisposableEffectResult() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$1.2
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        disposableSubscribe.dispose();
                    }
                };
            }
        }, composer, i2 & 14);
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState2 = mutableState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState2;
    }

    public static final <R, T extends R> State<R> subscribeAsState(final Flowable<T> flowable, R r, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1952109204, "C(subscribeAsState)N(initial)67@3009L34:RxJava3Adapter.kt#wvx964");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1952109204, i, -1, "androidx.compose.runtime.rxjava3.subscribeAsState (RxJava3Adapter.kt:67)");
        }
        int i2 = (i & 112) | (i & 14) | (((i >> 3) & 8) << 3);
        ComposerKt.sourceInformationMarkerStart(composer, -675894395, "CC(asState)N(initial,subscribe)129@5800L36,130@5841L129:RxJava3Adapter.kt#wvx964");
        ComposerKt.sourceInformationMarkerStart(composer, -994447831, "CC(remember):RxJava3Adapter.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(flowable, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$2
            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Object obj = flowable;
                final MutableState mutableState2 = mutableState;
                final Disposable disposableSubscribe = ((Flowable) obj).subscribe(new RxJava3AdapterKt$sam$io_reactivex_rxjava3_functions_Consumer$0(new Function1<R, Unit>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$2.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                        invoke2(obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(R r2) {
                        mutableState2.setValue(r2);
                    }
                }));
                return new DisposableEffectResult() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$2.2
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        disposableSubscribe.dispose();
                    }
                };
            }
        }, composer, i2 & 14);
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState2 = mutableState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState2;
    }

    public static final <R, T extends R> State<R> subscribeAsState(final Single<T> single, R r, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 919948588, "C(subscribeAsState)N(initial)86@3906L34:RxJava3Adapter.kt#wvx964");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(919948588, i, -1, "androidx.compose.runtime.rxjava3.subscribeAsState (RxJava3Adapter.kt:86)");
        }
        int i2 = (i & 112) | (i & 14) | (((i >> 3) & 8) << 3);
        ComposerKt.sourceInformationMarkerStart(composer, -675894395, "CC(asState)N(initial,subscribe)129@5800L36,130@5841L129:RxJava3Adapter.kt#wvx964");
        ComposerKt.sourceInformationMarkerStart(composer, -994447831, "CC(remember):RxJava3Adapter.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(single, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$3
            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Object obj = single;
                final MutableState mutableState2 = mutableState;
                final Disposable disposableSubscribe = ((Single) obj).subscribe(new RxJava3AdapterKt$sam$io_reactivex_rxjava3_functions_Consumer$0(new Function1<R, Unit>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$3.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                        invoke2(obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(R r2) {
                        mutableState2.setValue(r2);
                    }
                }));
                return new DisposableEffectResult() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$3.2
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        disposableSubscribe.dispose();
                    }
                };
            }
        }, composer, i2 & 14);
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState2 = mutableState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState2;
    }

    public static final <R, T extends R> State<R> subscribeAsState(final Maybe<T> maybe, R r, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1243760040, "C(subscribeAsState)N(initial)105@4822L34:RxJava3Adapter.kt#wvx964");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1243760040, i, -1, "androidx.compose.runtime.rxjava3.subscribeAsState (RxJava3Adapter.kt:105)");
        }
        int i2 = (i & 112) | (i & 14) | (((i >> 3) & 8) << 3);
        ComposerKt.sourceInformationMarkerStart(composer, -675894395, "CC(asState)N(initial,subscribe)129@5800L36,130@5841L129:RxJava3Adapter.kt#wvx964");
        ComposerKt.sourceInformationMarkerStart(composer, -994447831, "CC(remember):RxJava3Adapter.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(maybe, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$4
            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Object obj = maybe;
                final MutableState mutableState2 = mutableState;
                final Disposable disposableSubscribe = ((Maybe) obj).subscribe(new RxJava3AdapterKt$sam$io_reactivex_rxjava3_functions_Consumer$0(new Function1<R, Unit>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$4.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                        invoke2(obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(R r2) {
                        mutableState2.setValue(r2);
                    }
                }));
                return new DisposableEffectResult() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$4.2
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        disposableSubscribe.dispose();
                    }
                };
            }
        }, composer, i2 & 14);
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState2 = mutableState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState2;
    }

    public static final State<Boolean> subscribeAsState(final Completable completable, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1334238354, "C(subscribeAsState)122@5586L59:RxJava3Adapter.kt#wvx964");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1334238354, i, -1, "androidx.compose.runtime.rxjava3.subscribeAsState (RxJava3Adapter.kt:122)");
        }
        int i2 = (i & 14) | 48;
        ComposerKt.sourceInformationMarkerStart(composer, -675894395, "CC(asState)N(initial,subscribe)129@5800L36,130@5841L129:RxJava3Adapter.kt#wvx964");
        ComposerKt.sourceInformationMarkerStart(composer, -994447831, "CC(remember):RxJava3Adapter.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(completable, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$5
            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Object obj = completable;
                final MutableState mutableState2 = mutableState;
                final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$5.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        m6243invoke(bool);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m6243invoke(Boolean bool) {
                        mutableState2.setValue(bool);
                    }
                };
                final Disposable disposableSubscribe = ((Completable) obj).subscribe(new Action() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$5$1
                    @Override // io.reactivex.rxjava3.functions.Action
                    public final void run() {
                        function1.invoke(true);
                    }
                });
                return new DisposableEffectResult() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$subscribeAsState$$inlined$asState$5.2
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        disposableSubscribe.dispose();
                    }
                };
            }
        }, composer, i2 & 14);
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState2 = mutableState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState2;
    }

    private static final <T, S> State<T> asState(final S s, T t, final Function2<? super S, ? super Function1<? super T, Unit>, ? extends Disposable> function2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -675894395, "CC(asState)N(initial,subscribe)129@5800L36,130@5841L129:RxJava3Adapter.kt#wvx964");
        ComposerKt.sourceInformationMarkerStart(composer, -994447831, "CC(remember):RxJava3Adapter.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(s, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt.asState.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Function2<S, Function1<? super T, Unit>, Disposable> function3 = function2;
                S s2 = s;
                final MutableState<T> mutableState2 = mutableState;
                final Disposable disposableInvoke = function3.invoke(s2, new Function1<T, Unit>() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$asState$1$disposable$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(T t2) {
                        mutableState2.setValue(t2);
                    }
                });
                return new DisposableEffectResult() { // from class: androidx.compose.runtime.rxjava3.RxJava3AdapterKt$asState$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        disposableInvoke.dispose();
                    }
                };
            }
        }, composer, i & 14);
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }
}

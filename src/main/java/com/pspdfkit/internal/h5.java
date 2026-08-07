package com.pspdfkit.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SwipeToDismissBoxKt;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h5 {

    @DebugMetadata(c = "com.pspdfkit.internal.ui.annotations.AnnotationsListComposableKt$AnnotationsListComposable$1$1", f = "AnnotationsListComposable.kt", i = {}, l = {Token.SETELEM_OP}, m = "invokeSuspend", n = {}, nl = {Token.LOCAL_BLOCK}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ i5 b;
        public final /* synthetic */ MutableState<Boolean> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i5 i5Var, MutableState<Boolean> mutableState, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = i5Var;
            this.c = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i5 i5Var = this.b;
                if (i5Var.b.isEmpty() && i5Var.h) {
                    this.a = 1;
                    if (DelayKt.delay(50L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.c.setValue(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.c.setValue(Boolean.TRUE);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements PointerInputEventHandler {
        public final /* synthetic */ View a;

        @DebugMetadata(c = "com.pspdfkit.internal.ui.annotations.AnnotationsListComposableKt$AnnotationsListComposable$2$1$1$1$1", f = "AnnotationsListComposable.kt", i = {0}, l = {175}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, nl = {176}, s = {"L$0"}, v = 2)
        public static final class a extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            public int a;
            public /* synthetic */ Object b;
            public final /* synthetic */ View c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = view;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.c, continuation);
                aVar.b = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                a aVar = new a(this.c, continuation);
                aVar.b = awaitPointerEventScope;
                return aVar.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                a aVar;
                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.b = SpillingKt.nullOutSpilledVariable(awaitPointerEventScope);
                    this.a = 1;
                    aVar = this;
                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, aVar, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    aVar = this;
                }
                ViewParent parent = aVar.c.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                return Unit.INSTANCE;
            }
        }

        public b(View view) {
            this.a = view;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new a(this.a, null), continuation);
            return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.ui.annotations.AnnotationsListComposableKt$AnnotationsListComposable$2$1$2$1$1$3$2$1$1", f = "AnnotationsListComposable.kt", i = {}, l = {321}, m = "invokeSuspend", n = {}, nl = {322}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ SwipeToDismissBoxState b;
        public final /* synthetic */ Function1<fo, Unit> c;
        public final /* synthetic */ fo d;
        public final /* synthetic */ MutableState<Boolean> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SwipeToDismissBoxState swipeToDismissBoxState, Function1 function1, fo foVar, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.b = swipeToDismissBoxState;
            this.c = function1;
            this.d = foVar;
            this.e = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b.getCurrentValue() == SwipeToDismissBoxValue.EndToStart && this.b.getProgress() == 1.0f) {
                    this.e.setValue(Boolean.TRUE);
                    this.a = 1;
                    if (DelayKt.delay(300, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.c.invoke(this.d);
            return Unit.INSTANCE;
        }
    }

    public static final float a(float f) {
        return f * 0.5f;
    }

    public static final Unit a(i5 i5Var, Function1 function1, Function1 function2, Function2 function3, Function0 function0, Function0 function4, Modifier modifier, int i, Composer composer, int i2) {
        a(i5Var, (Function1<? super fo, Unit>) function1, (Function1<? super fo, Unit>) function2, (Function2<? super Long, ? super Long, Unit>) function3, (Function0<Unit>) function0, (Function0<Unit>) function4, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(i5 i5Var, Function1 function1, Function1 function2, Function2 function3, Function0 function0, Function0 function4, Modifier modifier, int i, Composer composer, int i2) {
        a(i5Var, (Function1<? super fo, Unit>) function1, (Function1<? super fo, Unit>) function2, (Function2<? super Long, ? super Long, Unit>) function3, (Function0<Unit>) function0, (Function0<Unit>) function4, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, long j, Function0 function0, Function0 function1, long j2, int i, int i2, Composer composer, int i3) {
        a(modifier, j, function0, function1, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit b(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    public static final Unit a(i5 i5Var, ot otVar, y2 y2Var, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-329661916, i, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:377)");
        }
        boolean z = i5Var.h;
        List<fo> list = i5Var.b;
        int i2 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (fo foVar : list) {
                if ((foVar instanceof fo.a) || (foVar instanceof fo.b)) {
                    i2++;
                    if (i2 < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        int i3 = otVar.c;
        float f = y2Var.e;
        r2 r2VarA = p2.a(otVar);
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        modifierFillMaxWidth$default.getClass();
        g2.a(z, i2, i3, f, r2VarA, modifierFillMaxWidth$default, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final class d implements PointerInputEventHandler {
        public final /* synthetic */ fo a;
        public final /* synthetic */ MutableState<Object> b;
        public final /* synthetic */ MutableFloatState c;
        public final /* synthetic */ MutableFloatState d;
        public final /* synthetic */ LazyListState e;
        public final /* synthetic */ Function2<Long, Long, Unit> f;

        /* JADX WARN: Multi-variable type inference failed */
        public d(fo foVar, MutableState<Object> mutableState, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, LazyListState lazyListState, Function2<? super Long, ? super Long, Unit> function2) {
            this.a = foVar;
            this.b = mutableState;
            this.c = mutableFloatState;
            this.d = mutableFloatState2;
            this.e = lazyListState;
            this.f = function2;
        }

        public static final Unit a(fo foVar, MutableState mutableState, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, Offset offset) {
            mutableState.setValue(Long.valueOf(foVar.b()));
            mutableFloatState.setFloatValue(0.0f);
            mutableFloatState2.setFloatValue(0.0f);
            return Unit.INSTANCE;
        }

        public static final Unit b(MutableState mutableState, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2) {
            mutableState.setValue(null);
            mutableFloatState.setFloatValue(0.0f);
            mutableFloatState2.setFloatValue(0.0f);
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            final fo foVar = this.a;
            final MutableState<Object> mutableState = this.b;
            final MutableFloatState mutableFloatState = this.c;
            final MutableFloatState mutableFloatState2 = this.d;
            Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.h5$d$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return h5.d.a(foVar, mutableState, mutableFloatState, mutableFloatState2, (Offset) obj);
                }
            };
            final MutableState<Object> mutableState2 = this.b;
            final MutableFloatState mutableFloatState3 = this.c;
            final MutableFloatState mutableFloatState4 = this.d;
            Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.h5$d$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return h5.d.a(mutableState2, mutableFloatState3, mutableFloatState4);
                }
            };
            final MutableState<Object> mutableState3 = this.b;
            final MutableFloatState mutableFloatState5 = this.c;
            final MutableFloatState mutableFloatState6 = this.d;
            Function0 function2 = new Function0() { // from class: com.pspdfkit.internal.h5$d$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return h5.d.b(mutableState3, mutableFloatState5, mutableFloatState6);
                }
            };
            final LazyListState lazyListState = this.e;
            final Function2<Long, Long, Unit> function3 = this.f;
            final MutableFloatState mutableFloatState7 = this.c;
            final MutableState<Object> mutableState4 = this.b;
            final MutableFloatState mutableFloatState8 = this.d;
            Object objDetectDragGestures = DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function2, new Function2() { // from class: com.pspdfkit.internal.h5$d$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h5.d.a(lazyListState, function3, mutableFloatState7, mutableState4, mutableFloatState8, (PointerInputChange) obj, (Offset) obj2);
                }
            }, continuation);
            return objDetectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures : Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit a(LazyListState lazyListState, Function2 function2, MutableFloatState mutableFloatState, MutableState mutableState, MutableFloatState mutableFloatState2, PointerInputChange pointerInputChange, Offset offset) {
            Object obj;
            Object next;
            LazyListItemInfo lazyListItemInfoPrevious;
            Object next2;
            pointerInputChange.getClass();
            pointerInputChange.consume();
            mutableFloatState.setFloatValue(Float.intBitsToFloat((int) (offset.m6579unboximpl() & 4294967295L)) + mutableFloatState.getFloatValue());
            List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
            Iterator<T> it = visibleItemsInfo.iterator();
            do {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((LazyListItemInfo) next).getKey(), mutableState.getValue()));
            LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) next;
            if (lazyListItemInfo != null) {
                int index = lazyListItemInfo.getIndex();
                ListIterator<LazyListItemInfo> listIterator = visibleItemsInfo.listIterator(visibleItemsInfo.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        lazyListItemInfoPrevious = null;
                        break;
                    }
                    lazyListItemInfoPrevious = listIterator.previous();
                    LazyListItemInfo lazyListItemInfo2 = lazyListItemInfoPrevious;
                    if ((lazyListItemInfo2.getKey() instanceof String) && lazyListItemInfo2.getIndex() < index) {
                        break;
                    }
                }
                LazyListItemInfo lazyListItemInfo3 = lazyListItemInfoPrevious;
                Iterator<T> it2 = visibleItemsInfo.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    LazyListItemInfo lazyListItemInfo4 = (LazyListItemInfo) next2;
                    if ((lazyListItemInfo4.getKey() instanceof String) && lazyListItemInfo4.getIndex() > index) {
                        break;
                    }
                }
                LazyListItemInfo lazyListItemInfo5 = (LazyListItemInfo) next2;
                float floatValue = mutableFloatState.getFloatValue();
                if (lazyListItemInfo3 != null) {
                    floatValue = RangesKt.coerceAtLeast(floatValue, (lazyListItemInfo3.getSize() + lazyListItemInfo3.getOffset()) - lazyListItemInfo.getOffset());
                }
                if (lazyListItemInfo5 != null) {
                    floatValue = RangesKt.coerceAtMost(floatValue, (lazyListItemInfo5.getOffset() - lazyListItemInfo.getOffset()) - lazyListItemInfo.getSize());
                }
                mutableFloatState2.setFloatValue(floatValue);
                int iRoundToInt = MathKt.roundToInt(mutableFloatState2.getFloatValue()) + (lazyListItemInfo.getSize() / 2) + lazyListItemInfo.getOffset();
                for (Object obj2 : visibleItemsInfo) {
                    LazyListItemInfo lazyListItemInfo6 = (LazyListItemInfo) obj2;
                    if (!Intrinsics.areEqual(lazyListItemInfo6.getKey(), mutableState.getValue()) && (lazyListItemInfo6.getKey() instanceof Long)) {
                        int offset2 = lazyListItemInfo6.getOffset();
                        if (iRoundToInt <= lazyListItemInfo6.getSize() + lazyListItemInfo6.getOffset() && offset2 <= iRoundToInt) {
                            obj = obj2;
                            break;
                        }
                    }
                }
                LazyListItemInfo lazyListItemInfo7 = (LazyListItemInfo) obj;
                if (lazyListItemInfo7 != null) {
                    Object key = lazyListItemInfo7.getKey();
                    key.getClass();
                    Long l = (Long) key;
                    l.longValue();
                    T value = mutableState.getValue();
                    value.getClass();
                    Long l2 = (Long) value;
                    l2.longValue();
                    function2.invoke(l2, l);
                    float size = lazyListItemInfo.getSize() * (lazyListItemInfo.getOffset() > lazyListItemInfo7.getOffset() ? 1 : -1);
                    mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + size);
                    mutableFloatState2.setFloatValue(mutableFloatState2.getFloatValue() + size);
                }
            }
            return Unit.INSTANCE;
        }

        public static final Unit a(MutableState mutableState, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2) {
            mutableState.setValue(null);
            mutableFloatState.setFloatValue(0.0f);
            mutableFloatState2.setFloatValue(0.0f);
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(i5 i5Var, Function1 function1, fo foVar) {
        if (!i5Var.i) {
            function1.invoke(foVar);
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(ot otVar, i5 i5Var, List list, Function0 function0, y2 y2Var, MutableState mutableState, final MutableState mutableState2, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        int i2;
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1103112073, i, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous> (AnnotationsListComposable.kt:415)");
        }
        boolean z = i5Var.i;
        otVar.getClass();
        int i3 = otVar.n;
        int i4 = otVar.o;
        if (z) {
            i2 = otVar.r;
        } else {
            i2 = otVar.q;
        }
        o2 o2Var = new o2(i3, i4, i2, otVar.v);
        boolean z2 = !list.isEmpty() && mutableState.getValue() == 0;
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return h5.a(mutableState2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        n2.a(o2Var, z2, function0, (Function0) objRememberedValue, y2Var, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 199680);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final i5 i5Var, final ot otVar, final y2 y2Var, LazyItemScope lazyItemScope, Composer composer, int i) {
        lazyItemScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-240115380, i, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:376)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(!i5Var.b.isEmpty(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-329661916, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return h5.a(i5Var, otVar, y2Var, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(List list, final y2 y2Var, final ot otVar, final i5 i5Var, final LazyListState lazyListState, final Function2 function2, final MutableState mutableState, final MutableFloatState mutableFloatState, final MutableFloatState mutableFloatState2, final Function1 function1, final Function1 function3, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        int i = -1;
        while (it.hasNext()) {
            fo foVar = (fo) it.next();
            if (foVar instanceof fo.c) {
                if (!arrayList2.isEmpty()) {
                    arrayList.add(new Pair(Integer.valueOf(i), CollectionsKt.toList(arrayList2)));
                }
                i = ((fo.c) foVar).b;
                arrayList2 = new ArrayList();
            } else {
                arrayList2.add(foVar);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(new Pair(Integer.valueOf(i), CollectionsKt.toList(arrayList2)));
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(TuplesKt.to((fo) obj, Integer.valueOf(i3)));
            i3 = i4;
        }
        Map map = MapsKt.toMap(arrayList3);
        int size = arrayList.size();
        while (i2 < size) {
            int i5 = i2 + 1;
            Pair pair = (Pair) arrayList.get(i2);
            final int iIntValue = ((Number) pair.component1()).intValue();
            final List list2 = (List) pair.component2();
            if (iIntValue >= 0) {
                LazyListScope.stickyHeader$default(lazyListScope, (Object) ("page_" + iIntValue), (Object) null, (Function4) ComposableLambdaKt.composableLambdaInstance(-1143914116, true, new Function4() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return h5.a(iIntValue, y2Var, otVar, (LazyItemScope) obj2, ((Integer) obj3).intValue(), (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }), 2, (Object) null);
            }
            final Map map2 = map;
            LazyListScope.items$default(lazyListScope, list2.size(), new Function1() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return h5.a(list2, ((Integer) obj2).intValue());
                }
            }, null, ComposableLambdaKt.composableLambdaInstance(526171482, true, new Function4() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    return h5.a(list2, map2, i5Var, lazyListState, function2, mutableState, mutableFloatState, mutableFloatState2, function1, otVar, y2Var, function3, (LazyItemScope) obj2, ((Integer) obj3).intValue(), (Composer) obj4, ((Integer) obj5).intValue());
                }
            }), 4, null);
            map = map2;
            i2 = i5;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-240115380, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return h5.a(i5Var, otVar, y2Var, (LazyItemScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    public static final Unit b(Context context, RowScope rowScope, Composer composer, int i) {
        rowScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1202823435, i, -1, "com.pspdfkit.internal.ui.annotations.DeleteDialog.<anonymous>.<anonymous> (AnnotationsListComposable.kt:474)");
            }
            String strA = no.a(context, R.string.pspdf__cancel, null);
            strA.getClass();
            String upperCase = strA.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            TextKt.m4494TextNvy7gAk(upperCase, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final i5 i5Var, final Function1<? super fo, Unit> function1, final Function1<? super fo, Unit> function2, final Function2<? super Long, ? super Long, Unit> function3, final Function0<Unit> function0, final Function0<Unit> function4, final Modifier modifier, Composer composer, final int i) {
        int i2;
        final Function2<? super Long, ? super Long, Unit> function5;
        final Function0<Unit> function6;
        Composer composer2;
        Modifier modifierPointerInput;
        BoxScopeInstance boxScopeInstance;
        boolean z;
        List<fo> list;
        y2 y2Var;
        ot otVar;
        LazyListState lazyListState;
        i5Var.getClass();
        function1.getClass();
        function2.getClass();
        function3.getClass();
        function0.getClass();
        function4.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-209060805);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(i5Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function5 = function3;
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-209060805, i2, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable (AnnotationsListComposable.kt:126)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final ot otVar2 = i5Var.a;
            if (otVar2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return h5.a(i5Var, function1, function2, function5, function0, function4, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            final List<fo> list2 = i5Var.b;
            final y2 y2Var2 = new y2(context, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            Boolean boolValueOf = Boolean.valueOf(i5Var.b.isEmpty() && i5Var.h);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(i5Var);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a(i5Var, mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 0);
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue5;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue6;
            View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifier, ColorKt.Color(otVar2.a), null, 2, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null);
            if (i5Var.i) {
                composerStartRestartGroup.startReplaceGroup(-972368901);
                Unit unit = Unit.INSTANCE;
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(view);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new b(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion4, unit, (PointerInputEventHandler) objRememberedValue7);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-972007317);
                composerStartRestartGroup.endReplaceGroup();
                modifierPointerInput = companion4;
            }
            Modifier modifierThen = modifierFillMaxSize$default.then(modifierPointerInput);
            boolean zChangedInstance3 = ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(list2) | composerStartRestartGroup.changed(y2Var2) | composerStartRestartGroup.changedInstance(otVar2) | composerStartRestartGroup.changedInstance(i5Var) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue8 == companion.getEmpty()) {
                boxScopeInstance = boxScopeInstance2;
                z = false;
                Function1 function7 = new Function1() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return h5.a(list2, y2Var2, otVar2, i5Var, lazyListStateRememberLazyListState, function3, mutableState3, mutableFloatState, mutableFloatState2, function2, function1, (LazyListScope) obj);
                    }
                };
                list = list2;
                y2Var = y2Var2;
                otVar = otVar2;
                lazyListState = lazyListStateRememberLazyListState;
                composerStartRestartGroup.updateRememberedValue(function7);
                objRememberedValue8 = function7;
            } else {
                boxScopeInstance = boxScopeInstance2;
                list = list2;
                y2Var = y2Var2;
                otVar = otVar2;
                lazyListState = lazyListStateRememberLazyListState;
                z = false;
            }
            final ot otVar3 = otVar;
            LazyDslKt.LazyColumn(modifierThen, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue8, composerStartRestartGroup, 0, 508);
            BoxScopeInstance boxScopeInstance3 = boxScopeInstance;
            AnimatedVisibilityKt.AnimatedVisibility((!i5Var.b.isEmpty() || i5Var.h) ? z : true, boxScopeInstance3.align(companion4, companion2.getCenter()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1178622095, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return h5.a(otVar3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            AnimatedVisibilityKt.AnimatedVisibility(((Boolean) mutableState2.getValue()).booleanValue(), boxScopeInstance3.align(companion4, companion2.getCenter()), (EnterTransition) null, (ExitTransition) null, (String) null, n9.a, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            composerStartRestartGroup.endNode();
            final List<fo> list3 = list;
            final y2 y2Var3 = y2Var;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, (i5Var.e && i5Var.d) ? true : z, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1103112073, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return h5.a(otVar3, i5Var, list3, function4, y2Var3, mutableState3, mutableState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870, 30);
            function6 = function0;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, ((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-391676608, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return h5.a(otVar3, function6, mutableState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870, 30);
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function6 = function0;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            final Function0<Unit> function8 = function6;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h5.b(i5Var, function1, function2, function3, function8, function4, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, y2 y2Var, ot otVar, LazyItemScope lazyItemScope, int i2, Composer composer, int i3) {
        lazyItemScope.getClass();
        if (composer.shouldExecute((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1143914116, i3, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:191)");
            }
            r40.a(StringResources_androidKt.stringResource(R.string.pspdf__annotation_list_page, new Object[]{Integer.valueOf(i + 1)}, composer, 0), y2Var, p2.a(otVar), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Object a(List list, int i) {
        return Long.valueOf(((fo) list.get(i)).b());
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(List list, Map map, final i5 i5Var, LazyListState lazyListState, Function2 function2, MutableState mutableState, MutableFloatState mutableFloatState, final MutableFloatState mutableFloatState2, Function1 function1, final ot otVar, final y2 y2Var, final Function1 function3, LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        final boolean z;
        Modifier modifierPointerInput;
        Modifier modifierAnimateItem$default;
        PdfConfiguration pdfConfiguration;
        fo foVar;
        PdfConfiguration pdfConfiguration2;
        lazyItemScope.getClass();
        int i3 = (i2 & 6) == 0 ? i2 | (composer.changed(lazyItemScope) ? 4 : 2) : i2;
        if ((i2 & 48) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if (composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(526171482, i3, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:204)");
            }
            final fo foVar2 = (fo) list.get(i);
            Integer num = (Integer) map.get(foVar2);
            final int iIntValue = num != null ? num.intValue() : -1;
            boolean zAreEqual = Intrinsics.areEqual(mutableState.getValue(), Long.valueOf(foVar2.b()));
            if (i5Var.j || (foVar = (fo) CollectionsKt.getOrNull(i5Var.b, iIntValue)) == null || !i5Var.i || (pdfConfiguration2 = i5Var.c) == null) {
                z = false;
            } else {
                List<fo> list2 = i5Var.b;
                int iC = foVar.c();
                list2.getClass();
                ArrayList arrayList = new ArrayList();
                for (Object obj : list2) {
                    if (obj instanceof fo.a) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = arrayList.get(i4);
                    i4++;
                    if (((fo.a) obj2).b.getPageIndex() == iC) {
                        arrayList2.add(obj2);
                    }
                }
                if (foVar.a(pdfConfiguration2, arrayList2.size())) {
                    z = true;
                } else {
                    z = false;
                }
            }
            fo foVar3 = (fo) CollectionsKt.getOrNull(i5Var.b, iIntValue);
            final boolean z2 = foVar3 != null && i5Var.i && (pdfConfiguration = i5Var.c) != null && foVar3.a(pdfConfiguration);
            if (z && list.size() > 1) {
                composer.startReplaceGroup(-1455284085);
                Modifier.Companion companion = Modifier.INSTANCE;
                Long lValueOf = Long.valueOf(foVar2.b());
                boolean zChangedInstance = composer.changedInstance(foVar2) | composer.changed(lazyListState) | composer.changed(function2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object dVar = new d(foVar2, mutableState, mutableFloatState, mutableFloatState2, lazyListState, function2);
                    composer.updateRememberedValue(dVar);
                    objRememberedValue = dVar;
                }
                modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, lValueOf, (PointerInputEventHandler) objRememberedValue);
                composer.endReplaceGroup();
            } else {
                foVar2 = foVar2;
                composer.startReplaceGroup(-1450081696);
                composer.endReplaceGroup();
                modifierPointerInput = Modifier.INSTANCE;
            }
            final Modifier modifier = modifierPointerInput;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            if (zAreEqual) {
                composer.startReplaceGroup(-1449800619);
                Modifier modifierZIndex = ZIndexModifierKt.zIndex(companion2, 1.0f);
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return h5.a(mutableFloatState2, (GraphicsLayerScope) obj3);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                modifierAnimateItem$default = GraphicsLayerModifierKt.graphicsLayer(modifierZIndex, (Function1) objRememberedValue2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1449404222);
                composer.endReplaceGroup();
                modifierAnimateItem$default = LazyItemScope.animateItem$default(lazyItemScope, companion2, null, null, null, 7, null);
            }
            Modifier modifierThen = companion2.then(modifierAnimateItem$default);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierThen);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            f2.a(companion4, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion4, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Object objRememberedValue3 = composer.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue3 == companion5.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion5.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return Float.valueOf(h5.a(((Float) obj3).floatValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            final SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = SwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, (Function1) objRememberedValue4, composer, 48, 1);
            SwipeToDismissBoxValue currentValue = swipeToDismissBoxStateRememberSwipeToDismissBoxState.getCurrentValue();
            Float fValueOf = Float.valueOf(swipeToDismissBoxStateRememberSwipeToDismissBoxState.getProgress());
            boolean zChangedInstance2 = composer.changedInstance(swipeToDismissBoxStateRememberSwipeToDismissBoxState) | composer.changed(function1) | composer.changedInstance(foVar2);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion5.getEmpty()) {
                Object cVar = new c(swipeToDismissBoxStateRememberSwipeToDismissBoxState, function1, foVar2, mutableState2, null);
                composer.updateRememberedValue(cVar);
                objRememberedValue5 = cVar;
            }
            EffectsKt.LaunchedEffect(currentValue, fValueOf, (Function2) objRememberedValue5, composer, 0);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, !((Boolean) mutableState2.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), companion3.getTop(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-1137067060, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return h5.a(swipeToDismissBoxStateRememberSwipeToDismissBoxState, z2, otVar, y2Var, i5Var, iIntValue, function3, foVar2, z, modifier, (AnimatedVisibilityScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composer, 54), composer, 1597446, 22);
            DividerKt.m3284HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final SwipeToDismissBoxState swipeToDismissBoxState, final boolean z, final ot otVar, final y2 y2Var, final i5 i5Var, final int i, final Function1 function1, final fo foVar, final boolean z2, final Modifier modifier, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i2) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1137067060, i2, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:333)");
        }
        SwipeToDismissBoxKt.SwipeToDismissBox(swipeToDismissBoxState, ComposableLambdaKt.rememberComposableLambda(1938657642, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return h5.a(z, swipeToDismissBoxState, otVar, y2Var, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), null, false, z, false, null, ComposableLambdaKt.rememberComposableLambda(1354660080, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return h5.a(otVar, i5Var, i, function1, foVar, z2, y2Var, modifier, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, SwipeToDismissBoxState.$stable | 12586032, 100);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(boolean z, SwipeToDismissBoxState swipeToDismissBoxState, ot otVar, y2 y2Var, RowScope rowScope, Composer composer, int i) {
        rowScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1938657642, i, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:338)");
            }
            if (z) {
                composer.startReplaceGroup(124684045);
                SwipeToDismissBoxValue dismissDirection = swipeToDismissBoxState.getDismissDirection();
                int i2 = otVar.l;
                int i3 = otVar.p;
                float f = y2Var.d;
                c50.a(dismissDirection, i2, i3, new d50(f, f), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 24576);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(125647928);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(ot otVar, final i5 i5Var, int i, final Function1 function1, final fo foVar, boolean z, y2 y2Var, Modifier modifier, RowScope rowScope, Composer composer, int i2) {
        fo foVar2;
        PdfConfiguration pdfConfiguration;
        rowScope.getClass();
        boolean z2 = false;
        if (composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1354660080, i2, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:355)");
            }
            r2 r2VarA = p2.a(otVar);
            if (!i5Var.j && (foVar2 = (fo) CollectionsKt.getOrNull(i5Var.b, i)) != null && i5Var.i && (pdfConfiguration = i5Var.c) != null && foVar2.a(pdfConfiguration)) {
                z2 = true;
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zChangedInstance = composer.changedInstance(i5Var) | composer.changed(function1) | composer.changedInstance(foVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return h5.a(i5Var, function1, foVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            q2.a(foVar, z, z2, r2VarA, y2Var, ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxSize$default, false, null, null, null, (Function0) objRememberedValue, 15, null), modifier, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(ot otVar, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1178622095, i, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous>.<anonymous> (AnnotationsListComposable.kt:396)");
        }
        TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__no_annotations, composer, 0), null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(otVar.u), 0L, null, null, 0L, 0, false, 0, 0, null, new TextStyle(ColorKt.Color(otVar.c), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null), composer, 0, 0, 130942);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(ot otVar, final Function0 function0, final MutableState mutableState, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391676608, i, -1, "com.pspdfkit.internal.ui.annotations.AnnotationsListComposable.<anonymous>.<anonymous> (AnnotationsListComposable.kt:426)");
        }
        long jColor = ColorKt.Color(otVar.a);
        boolean zChanged = composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return h5.a(function0, mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function1 = (Function0) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return h5.b(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        a(null, jColor, function1, (Function0) objRememberedValue2, ColorKt.Color(otVar.c), composer, 3072, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function0 function0, MutableState mutableState) {
        function0.invoke();
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final long j, final Function0<Unit> function0, final Function0<Unit> function1, final long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        Modifier modifier3;
        function0.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1775118542);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1775118542, i3, -1, "com.pspdfkit.internal.ui.annotations.DeleteDialog (AnnotationsListComposable.kt:446)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(function1, ComposableLambdaKt.rememberComposableLambda(18775018, true, new Function2() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h5.a(j2, function0, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifier3, ComposableLambdaKt.rememberComposableLambda(999729832, true, new Function2() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h5.a(function1, j2, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, ComposableLambdaKt.rememberComposableLambda(323678405, true, new Function2() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h5.a(context, j2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, j, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 9) & 14) | 1575984 | ((i3 << 6) & 896) | ((i3 << 21) & 234881024), 0, 16048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h5.a(modifier4, j, function0, function1, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(long j, Function0 function0, final Context context, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(18775018, i, -1, "com.pspdfkit.internal.ui.annotations.DeleteDialog.<anonymous> (AnnotationsListComposable.kt:454)");
            }
            ButtonColors buttonColorsM2878textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(0L, j, 0L, 0L, composer, ButtonDefaults.$stable << 12, 13);
            Modifier.Companion companion = Modifier.INSTANCE;
            companion.getClass();
            ButtonKt.TextButton((Function0<Unit>) function0, (Modifier) companion, false, (Shape) null, buttonColorsM2878textButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(221868621, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return h5.a(context, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Context context, RowScope rowScope, Composer composer, int i) {
        rowScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(221868621, i, -1, "com.pspdfkit.internal.ui.annotations.DeleteDialog.<anonymous>.<anonymous> (AnnotationsListComposable.kt:459)");
            }
            String strA = no.a(context, R.string.pspdf__clear_annotations, null);
            strA.getClass();
            String upperCase = strA.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            TextKt.m4494TextNvy7gAk(upperCase, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function0 function0, long j, final Context context, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(999729832, i, -1, "com.pspdfkit.internal.ui.annotations.DeleteDialog.<anonymous> (AnnotationsListComposable.kt:470)");
            }
            ButtonKt.TextButton((Function0<Unit>) function0, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(0L, j, 0L, 0L, composer, ButtonDefaults.$stable << 12, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1202823435, true, new Function3() { // from class: com.pspdfkit.internal.h5$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return h5.b(context, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Context context, long j, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(323678405, i, -1, "com.pspdfkit.internal.ui.annotations.DeleteDialog.<anonymous> (AnnotationsListComposable.kt:483)");
            }
            String strA = no.a(context, R.string.pspdf__clear_annotations_confirm, null);
            strA.getClass();
            TextKt.m4494TextNvy7gAk(strA, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m9104copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(MutableFloatState mutableFloatState, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.getClass();
        graphicsLayerScope.setTranslationY(mutableFloatState.getFloatValue());
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo754toPx0680j_4(Dp.m9687constructorimpl(8)));
        return Unit.INSTANCE;
    }
}

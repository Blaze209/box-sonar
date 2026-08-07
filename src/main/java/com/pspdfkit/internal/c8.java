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
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
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
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
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
import androidx.core.graphics.ColorUtils;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.imageutils.JfifUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.R;
import com.pspdfkit.bookmarks.Bookmark;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c8 {

    public static final class a implements PointerInputEventHandler {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: com.pspdfkit.internal.c8$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "io.nutrient.internal.ui.bookmarks.BookmarkListComposableKt$BookmarkListComposable$1$1$1$1$1", f = "BookmarkListComposable.kt", i = {0}, l = {122}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, nl = {123}, s = {"L$0"}, v = 2)
        public static final class C0257a extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            public int a;
            public /* synthetic */ Object b;
            public final /* synthetic */ View c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0257a(View view, Continuation<? super C0257a> continuation) {
                super(2, continuation);
                this.c = view;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0257a c0257a = new C0257a(this.c, continuation);
                c0257a.b = obj;
                return c0257a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                C0257a c0257a = new C0257a(this.c, continuation);
                c0257a.b = awaitPointerEventScope;
                return c0257a.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                C0257a c0257a;
                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.b = SpillingKt.nullOutSpilledVariable(awaitPointerEventScope);
                    this.a = 1;
                    c0257a = this;
                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, c0257a, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    c0257a = this;
                }
                ViewParent parent = c0257a.c.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                return Unit.INSTANCE;
            }
        }

        public a(View view) {
            this.a = view;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C0257a(this.a, null), continuation);
            return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.bookmarks.BookmarkListComposableKt$BookmarkListComposable$1$1$2$1$2$2$1$1", f = "BookmarkListComposable.kt", i = {}, l = {JfifUtil.MARKER_EOI}, m = "invokeSuspend", n = {}, nl = {218}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ SwipeToDismissBoxState b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function1<Bookmark, Unit> d;
        public final /* synthetic */ Bookmark e;
        public final /* synthetic */ MutableState<Boolean> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SwipeToDismissBoxState swipeToDismissBoxState, boolean z, Function1 function1, Bookmark bookmark, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.b = swipeToDismissBoxState;
            this.c = z;
            this.d = function1;
            this.e = bookmark;
            this.f = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b.getCurrentValue() == SwipeToDismissBoxValue.EndToStart && this.b.getProgress() == 1.0f && this.c) {
                    this.f.setValue(Boolean.TRUE);
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
            this.d.invoke(this.e);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.bookmarks.BookmarkListComposableKt$BookmarkListComposable$1$2$1$1", f = "BookmarkListComposable.kt", i = {0, 0, 0}, l = {335}, m = "invokeSuspend", n = {"it", "$i$a$-let-BookmarkListComposableKt$BookmarkListComposable$1$2$1$1$1", FirebaseAnalytics.Param.INDEX}, nl = {336}, s = {"L$0", "I$0", "I$1"}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public int b;
        public final /* synthetic */ f8 c;
        public final /* synthetic */ List<Bookmark> d;
        public final /* synthetic */ LazyListState e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(f8 f8Var, List<? extends Bookmark> list, LazyListState lazyListState, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = f8Var;
            this.d = list;
            this.e = lazyListState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Bookmark bookmark = this.c.k;
                if (bookmark != null) {
                    List<Bookmark> list = this.d;
                    LazyListState lazyListState = this.e;
                    int iIndexOf = list.indexOf(bookmark);
                    if (iIndexOf != -1 && iIndexOf > 0) {
                        this.a = SpillingKt.nullOutSpilledVariable(bookmark);
                        this.b = 1;
                        if (LazyListState.animateScrollToItem$default(lazyListState, iIndexOf, 0, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final float a(float f) {
        return f * 0.5f;
    }

    public static final Unit a(Modifier modifier, f8 f8Var, boolean z, Function0 function0, Function0 function1, Function1 function2, Function2 function3, Function1 function4, Function1 function5, Function0 function6, Function0 function7, Function1 function8, Function0 function9, Function2 function10, int i, int i2, Composer composer, int i3) {
        a(modifier, f8Var, z, function0, function1, function2, function3, function4, function5, function6, function7, function8, function9, function10, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    public static final Unit b(Modifier modifier, f8 f8Var, boolean z, Function0 function0, Function0 function1, Function1 function2, Function2 function3, Function1 function4, Function1 function5, Function0 function6, Function0 function7, Function1 function8, Function0 function9, Function2 function10, int i, int i2, Composer composer, int i3) {
        a(modifier, f8Var, z, function0, function1, function2, function3, function4, function5, function6, function7, function8, function9, function10, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    public static final Unit a(boolean z, f8 f8Var, Function1 function1, Bookmark bookmark, Function1 function2) {
        if (!z) {
            function2.invoke(bookmark);
        } else if (f8Var.g) {
            function1.invoke(bookmark);
        }
        return Unit.INSTANCE;
    }

    public static final void a(final Modifier modifier, final f8 f8Var, final boolean z, final Function0<Unit> function0, final Function0<Unit> function1, final Function1<? super Bookmark, Unit> function2, final Function2<? super Bookmark, ? super String, Unit> function3, final Function1<? super Bookmark, Unit> function4, final Function1<? super Bookmark, Boolean> function5, final Function0<Boolean> function6, final Function0<Unit> function7, final Function1<? super Bookmark, Unit> function8, final Function0<Unit> function9, final Function2<? super Integer, ? super Integer, Unit> function10, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function11;
        Function0<Unit> function12;
        int i4;
        Composer composer2;
        Modifier modifierPointerInput;
        CoroutineScope coroutineScope;
        boolean z2;
        Composer composer3;
        MutableIntState mutableIntState;
        ot otVar;
        g8 g8Var;
        final f8 f8Var2;
        modifier.getClass();
        f8Var.getClass();
        function0.getClass();
        function1.getClass();
        function2.getClass();
        function3.getClass();
        function4.getClass();
        function5.getClass();
        function6.getClass();
        function7.getClass();
        function8.getClass();
        function9.getClass();
        function10.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(347295147);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(f8Var) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function11 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function11) ? 2048 : 1024;
        } else {
            function11 = function0;
        }
        if ((i & 24576) == 0) {
            function12 = function1;
            i3 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
        } else {
            function12 = function1;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function7) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function8) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function9) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function10) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 1171) == 1170) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(347295147, i3, i5, "io.nutrient.internal.ui.bookmarks.BookmarkListComposable (BookmarkListComposable.kt:88)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final g8 g8Var2 = new g8(context, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            final List<Bookmark> list = f8Var.b;
            final ot otVar2 = f8Var.a;
            if (otVar2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0<Unit> function13 = function12;
                    final Function0<Unit> function14 = function11;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return c8.a(modifier, f8Var, z, function14, function13, function2, function3, function4, function5, function6, function7, function8, function9, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(-1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue3;
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1870387531);
                Unit unit = Unit.INSTANCE;
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(view);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new a(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion4, unit, (PointerInputEventHandler) objRememberedValue4);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1870749115);
                composerStartRestartGroup.endReplaceGroup();
                modifierPointerInput = companion4;
            }
            Modifier modifierThen = modifierFillMaxSize$default.then(modifierPointerInput);
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(list) | ((i3 & 896) == 256) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | ((i5 & 7168) == 2048) | ((234881024 & i3) == 67108864) | ((29360128 & i3) == 8388608) | composerStartRestartGroup.changedInstance(otVar2) | composerStartRestartGroup.changed(g8Var2) | composerStartRestartGroup.changedInstance(f8Var) | ((i5 & 112) == 32) | ((458752 & i3) == 131072) | ((i5 & 896) == 256);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                coroutineScope = coroutineScope2;
                z2 = false;
                composer3 = composerStartRestartGroup;
                Function1 function15 = new Function1() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return c8.a(list, z, lazyListStateRememberLazyListState, function10, mutableIntState2, mutableFloatState, function5, function4, otVar2, g8Var2, f8Var, function8, function2, function9, (LazyListScope) obj);
                    }
                };
                mutableIntState = mutableIntState2;
                otVar = otVar2;
                g8Var = g8Var2;
                f8Var2 = f8Var;
                composer3.updateRememberedValue(function15);
                objRememberedValue5 = function15;
            } else {
                coroutineScope = coroutineScope2;
                mutableIntState = mutableIntState2;
                otVar = otVar2;
                g8Var = g8Var2;
                z2 = false;
                composer3 = composerStartRestartGroup;
                f8Var2 = f8Var;
            }
            Composer composer4 = composer3;
            final ot otVar3 = otVar;
            LazyDslKt.LazyColumn(modifierThen, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue5, composer4, 0, 508);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, f8Var2.m, boxScopeInstance.align(companion4, companion2.getCenter()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1429773823, true, new Function3() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return c8.a(context, f8Var2, function7, function3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer4, 1572870, 28);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, list.isEmpty(), boxScopeInstance.align(companion4, companion2.getCenter()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(269073014, true, new Function3() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return c8.a(otVar3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer4, 1572870, 28);
            composer4.endNode();
            b8 b8Var = new b8(otVar3.d, otVar3.g, z ? otVar3.i : otVar3.h, otVar3.e);
            boolean z3 = (!function6.invoke().booleanValue() || f8Var2.p) ? z2 : true;
            boolean z4 = f8Var2.f;
            boolean z5 = (list.isEmpty() || mutableIntState.getIntValue() != -1) ? z2 : true;
            boolean z6 = f8Var2.p;
            boolean z7 = f8Var2.h;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
            int i6 = i3;
            if ((i6 & 7168) == 2048) {
                z2 = true;
            }
            final CoroutineScope coroutineScope3 = coroutineScope;
            boolean zChangedInstance3 = z2 | composer4.changedInstance(coroutineScope3) | composer4.changedInstance(f8Var2) | composer4.changedInstance(list) | composer4.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue6 = composer4.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == companion.getEmpty()) {
                final f8 f8Var3 = f8Var2;
                Function0 function16 = new Function0() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return c8.a(function0, coroutineScope3, f8Var3, list, lazyListStateRememberLazyListState);
                    }
                };
                composer4.updateRememberedValue(function16);
                objRememberedValue6 = function16;
            }
            a8.a(b8Var, (Function0) objRememberedValue6, function1, z3, z4, z5, z7, z6, g8Var, modifierFillMaxWidth$default, composer4, ((i6 >> 6) & 896) | 805306368);
            composer2 = composer4;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return c8.b(modifier, f8Var, z, function0, function1, function2, function3, function4, function5, function6, function7, function8, function9, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final class c implements PointerInputEventHandler {
        public final /* synthetic */ State<Integer> a;
        public final /* synthetic */ MutableIntState b;
        public final /* synthetic */ MutableFloatState c;
        public final /* synthetic */ LazyListState d;
        public final /* synthetic */ Function2<Integer, Integer, Unit> e;

        /* JADX WARN: Multi-variable type inference failed */
        public c(State<Integer> state, MutableIntState mutableIntState, MutableFloatState mutableFloatState, LazyListState lazyListState, Function2<? super Integer, ? super Integer, Unit> function2) {
            this.a = state;
            this.b = mutableIntState;
            this.c = mutableFloatState;
            this.d = lazyListState;
            this.e = function2;
        }

        public static final Unit a(LazyListState lazyListState, Function2 function2, MutableFloatState mutableFloatState, MutableIntState mutableIntState, PointerInputChange pointerInputChange, Offset offset) {
            Object obj;
            Object next;
            pointerInputChange.getClass();
            pointerInputChange.consume();
            mutableFloatState.setFloatValue(Float.intBitsToFloat((int) (offset.m6579unboximpl() & 4294967295L)) + mutableFloatState.getFloatValue());
            Iterator<T> it = lazyListState.getLayoutInfo().getVisibleItemsInfo().iterator();
            do {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((LazyListItemInfo) next).getIndex() != mutableIntState.getIntValue());
            LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) next;
            if (lazyListItemInfo != null) {
                int iRoundToInt = MathKt.roundToInt(mutableFloatState.getFloatValue()) + (lazyListItemInfo.getSize() / 2) + lazyListItemInfo.getOffset();
                for (Object obj2 : lazyListState.getLayoutInfo().getVisibleItemsInfo()) {
                    LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) obj2;
                    if (lazyListItemInfo2.getIndex() != mutableIntState.getIntValue()) {
                        int offset2 = lazyListItemInfo2.getOffset();
                        if (iRoundToInt <= lazyListItemInfo2.getSize() + lazyListItemInfo2.getOffset() && offset2 <= iRoundToInt) {
                            obj = obj2;
                            break;
                        }
                    }
                }
                LazyListItemInfo lazyListItemInfo3 = (LazyListItemInfo) obj;
                if (lazyListItemInfo3 != null) {
                    function2.invoke(Integer.valueOf(mutableIntState.getIntValue()), Integer.valueOf(lazyListItemInfo3.getIndex()));
                    mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + (lazyListItemInfo.getSize() * (mutableIntState.getIntValue() - lazyListItemInfo3.getIndex())));
                    mutableIntState.setIntValue(lazyListItemInfo3.getIndex());
                }
            }
            return Unit.INSTANCE;
        }

        public static final Unit b(MutableIntState mutableIntState, MutableFloatState mutableFloatState) {
            mutableIntState.setIntValue(-1);
            mutableFloatState.setFloatValue(0.0f);
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            final State<Integer> state = this.a;
            final MutableIntState mutableIntState = this.b;
            final MutableFloatState mutableFloatState = this.c;
            Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.c8$c$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return c8.c.a(state, mutableIntState, mutableFloatState, (Offset) obj);
                }
            };
            final MutableIntState mutableIntState2 = this.b;
            final MutableFloatState mutableFloatState2 = this.c;
            Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.c8$c$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return c8.c.a(mutableIntState2, mutableFloatState2);
                }
            };
            final MutableIntState mutableIntState3 = this.b;
            final MutableFloatState mutableFloatState3 = this.c;
            Function0 function2 = new Function0() { // from class: com.pspdfkit.internal.c8$c$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return c8.c.b(mutableIntState3, mutableFloatState3);
                }
            };
            final LazyListState lazyListState = this.d;
            final Function2<Integer, Integer, Unit> function3 = this.e;
            final MutableFloatState mutableFloatState4 = this.c;
            final MutableIntState mutableIntState4 = this.b;
            Object objDetectDragGestures = DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function2, new Function2() { // from class: com.pspdfkit.internal.c8$c$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return c8.c.a(lazyListState, function3, mutableFloatState4, mutableIntState4, (PointerInputChange) obj, (Offset) obj2);
                }
            }, continuation);
            return objDetectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures : Unit.INSTANCE;
        }

        public static final Unit a(State state, MutableIntState mutableIntState, MutableFloatState mutableFloatState, Offset offset) {
            mutableIntState.setIntValue(((Number) state.getValue()).intValue());
            mutableFloatState.setFloatValue(0.0f);
            return Unit.INSTANCE;
        }

        public static final Unit a(MutableIntState mutableIntState, MutableFloatState mutableFloatState) {
            mutableIntState.setIntValue(-1);
            mutableFloatState.setFloatValue(0.0f);
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(final List list, final boolean z, final LazyListState lazyListState, final Function2 function2, final MutableIntState mutableIntState, final MutableFloatState mutableFloatState, final Function1 function1, final Function1 function3, final ot otVar, final g8 g8Var, final f8 f8Var, final Function1 function4, final Function1 function5, final Function0 function0, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        LazyListScope.items$default(lazyListScope, list.size(), new Function1() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return c8.a(list, ((Integer) obj).intValue());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(2099445701, true, new Function4() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return c8.a(list, z, lazyListState, function2, mutableIntState, mutableFloatState, function1, function3, otVar, g8Var, f8Var, function4, function5, function0, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return Unit.INSTANCE;
    }

    public static final Object a(List list, int i) {
        String uuid = ((Bookmark) list.get(i)).getUuid();
        uuid.getClass();
        return uuid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(final List list, final boolean z, LazyListState lazyListState, Function2 function2, MutableIntState mutableIntState, final MutableFloatState mutableFloatState, Function1 function1, Function1 function3, final ot otVar, final g8 g8Var, final f8 f8Var, final Function1 function4, final Function1 function5, final Function0 function0, LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        Modifier modifierPointerInput;
        int i4;
        Modifier modifierAnimateItem$default;
        Bookmark bookmark;
        final boolean z2;
        SwipeToDismissBoxState swipeToDismissBoxState;
        lazyItemScope.getClass();
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if (composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2099445701, i3, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookmarkListComposable.kt:132)");
            }
            Bookmark bookmark2 = (Bookmark) CollectionsKt.getOrNull(list, i);
            if (bookmark2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            boolean z3 = mutableIntState.getIntValue() == i;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Integer.valueOf(i), composer, (i3 >> 3) & 14);
            if (z && list.size() > 1) {
                composer.startReplaceGroup(1273521357);
                Modifier.Companion companion = Modifier.INSTANCE;
                String uuid = bookmark2.getUuid();
                boolean zChanged = composer.changed(stateRememberUpdatedState) | composer.changed(lazyListState) | composer.changed(function2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new c(stateRememberUpdatedState, mutableIntState, mutableFloatState, lazyListState, function2);
                    composer.updateRememberedValue(objRememberedValue);
                }
                modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, uuid, (PointerInputEventHandler) objRememberedValue);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1276035581);
                composer.endReplaceGroup();
                modifierPointerInput = Modifier.INSTANCE;
            }
            final Modifier modifier = modifierPointerInput;
            boolean z4 = z3;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            if (z4) {
                composer.startReplaceGroup(1276288262);
                Modifier modifierZIndex = ZIndexModifierKt.zIndex(companion2, 1.0f);
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return c8.a(mutableFloatState, (GraphicsLayerScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierZIndex, (Function1) objRememberedValue2);
                composer.endReplaceGroup();
                modifierAnimateItem$default = modifierGraphicsLayer;
                i4 = 3;
            } else {
                composer.startReplaceGroup(1276657503);
                composer.endReplaceGroup();
                i4 = 3;
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
            MutableState mutableState = (MutableState) objRememberedValue3;
            boolean zBooleanValue = ((Boolean) function1.invoke(bookmark2)).booleanValue();
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion5.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Float.valueOf(c8.a(((Float) obj).floatValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = SwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, (Function1) objRememberedValue4, composer, 48, 1);
            SwipeToDismissBoxValue currentValue = swipeToDismissBoxStateRememberSwipeToDismissBoxState.getCurrentValue();
            Float fValueOf = Float.valueOf(swipeToDismissBoxStateRememberSwipeToDismissBoxState.getProgress());
            boolean zChangedInstance = composer.changedInstance(swipeToDismissBoxStateRememberSwipeToDismissBoxState) | composer.changed(zBooleanValue) | composer.changed(function3) | composer.changedInstance(bookmark2);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == companion5.getEmpty()) {
                bookmark = bookmark2;
                z2 = zBooleanValue;
                swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                Object bVar = new b(swipeToDismissBoxState, z2, function3, bookmark, mutableState, null);
                composer.updateRememberedValue(bVar);
                objRememberedValue5 = bVar;
            } else {
                z2 = zBooleanValue;
                swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                bookmark = bookmark2;
            }
            EffectsKt.LaunchedEffect(currentValue, fValueOf, (Function2) objRememberedValue5, composer, 0);
            final SwipeToDismissBoxState swipeToDismissBoxState2 = swipeToDismissBoxState;
            final Bookmark bookmark3 = bookmark;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, !((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, (EnterTransition) null, EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), companion3.getTop(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, i4, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(771155475, true, new Function3() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return c8.a(swipeToDismissBoxState2, z, z2, otVar, g8Var, list, f8Var, bookmark3, function4, function5, function0, modifier, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1597446, 22);
            DividerKt.m3284HorizontalDivider9IZ8Weo(null, 0.0f, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOutline(), composer, 0, 3);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final SwipeToDismissBoxState swipeToDismissBoxState, final boolean z, final boolean z2, final ot otVar, final g8 g8Var, final List list, final f8 f8Var, final Bookmark bookmark, final Function1 function1, final Function1 function2, final Function0 function0, final Modifier modifier, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(771155475, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookmarkListComposable.kt:229)");
        }
        SwipeToDismissBoxKt.SwipeToDismissBox(swipeToDismissBoxState, ComposableLambdaKt.rememberComposableLambda(1124073909, true, new Function3() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return c8.a(z, z2, swipeToDismissBoxState, otVar, g8Var, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), null, false, z, false, null, ComposableLambdaKt.rememberComposableLambda(-1694152081, true, new Function3() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return c8.a(z, list, otVar, f8Var, bookmark, function1, function2, function0, g8Var, modifier, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, SwipeToDismissBoxState.$stable | 12586032, 100);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(boolean z, boolean z2, SwipeToDismissBoxState swipeToDismissBoxState, ot otVar, g8 g8Var, RowScope rowScope, Composer composer, int i) {
        rowScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1124073909, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookmarkListComposable.kt:234)");
            }
            if (z) {
                composer.startReplaceGroup(-574084753);
                if (z2) {
                    composer.startReplaceGroup(-574044236);
                    c50.a(swipeToDismissBoxState.getDismissDirection(), otVar.l, otVar.k, new d50(g8Var.e, g8Var.f), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 24576);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-573078803);
                    BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.Color(otVar.a), null, 2, null), composer, 0);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-572641331);
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

    public static final Unit a(final boolean z, List list, ot otVar, final f8 f8Var, final Bookmark bookmark, final Function1 function1, final Function1 function2, Function0 function0, g8 g8Var, Modifier modifier, RowScope rowScope, Composer composer, int i) {
        rowScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1694152081, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookmarkListComposable.kt:260)");
            }
            boolean z2 = z && list.size() > 1;
            otVar.getClass();
            int i2 = otVar.m;
            int i3 = otVar.c;
            e8 e8Var = new e8(i2, i3, ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i3, 100), -1), otVar.f, otVar.u, otVar.v, otVar.w);
            Bookmark bookmark2 = f8Var.k;
            boolean z3 = (Intrinsics.areEqual(bookmark2 != null ? bookmark2.getUuid() : null, bookmark.getUuid()) && f8Var.o) || list.size() == 1;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zChanged = composer.changed(z) | composer.changedInstance(f8Var) | composer.changed(function1) | composer.changedInstance(bookmark) | composer.changed(function2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function3 = new Function0() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return c8.a(z, f8Var, function1, bookmark, function2);
                    }
                };
                composer.updateRememberedValue(function3);
                objRememberedValue = function3;
            }
            d8.a(bookmark, f8Var, e8Var, z, z2, z3, function0, g8Var, ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxSize$default, false, null, null, null, (Function0) objRememberedValue, 15, null), modifier, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Context context, final f8 f8Var, final Function0 function0, final Function2 function2, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        String name;
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1429773823, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListComposable.<anonymous>.<anonymous>.<anonymous> (BookmarkListComposable.kt:298)");
        }
        String strA = no.a(context, R.string.pspdf__name, null);
        strA.getClass();
        Bookmark bookmark = f8Var.n;
        if (bookmark == null || (name = bookmark.getName()) == null) {
            name = "";
        }
        String strA2 = no.a(context, R.string.pspdf__ok, null);
        strA2.getClass();
        String strA3 = no.a(context, R.string.pspdf__cancel, null);
        strA3.getClass();
        boolean zChanged = composer.changed(function0) | composer.changedInstance(f8Var) | composer.changed(function2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.c8$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return c8.a(function0, f8Var, function2, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        zc.a(strA, name, strA2, strA3, (Function1) objRememberedValue, function0, function0, null, composer, 0, 128);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function0 function0, f8 f8Var, Function2 function2, String str) {
        str.getClass();
        function0.invoke();
        Bookmark bookmark = f8Var.n;
        if (bookmark != null) {
            function2.invoke(bookmark, str);
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(ot otVar, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(269073014, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListComposable.<anonymous>.<anonymous>.<anonymous> (BookmarkListComposable.kt:316)");
        }
        TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__no_bookmarks, composer, 0), null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(otVar.u), 0L, null, null, 0L, 0, false, 0, 0, null, new TextStyle(ColorKt.Color(otVar.c), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null), composer, 0, 0, 130942);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function0 function0, CoroutineScope coroutineScope, f8 f8Var, List list, LazyListState lazyListState) {
        function0.invoke();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new d(f8Var, list, lazyListState, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final Unit a(MutableFloatState mutableFloatState, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.getClass();
        graphicsLayerScope.setTranslationY(mutableFloatState.getFloatValue());
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo754toPx0680j_4(Dp.m9687constructorimpl(8)));
        return Unit.INSTANCE;
    }
}

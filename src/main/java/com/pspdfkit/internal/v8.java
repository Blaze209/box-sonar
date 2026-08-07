package com.pspdfkit.internal;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.AiAssistantColorScheme;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.nutrient.data.models.AiAssistantEvents;
import io.nutrient.data.models.CompletionResponse;
import io.nutrient.data.models.DocumentErrorStates;
import io.nutrient.data.models.Issuer;
import io.nutrient.data.models.Link;
import io.nutrient.data.models.Suggestion;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class v8 {

    @DebugMetadata(c = "io.nutrient.internal.ui.ai.ui.ChatListKt$ChatList$1$1", f = "ChatList.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, nl = {86}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ LazyListState b;
        public final /* synthetic */ ImmutableList<CompletionResponse> c;
        public final /* synthetic */ State<Boolean> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LazyListState lazyListState, ImmutableList<CompletionResponse> immutableList, State<Boolean> state, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = lazyListState;
            this.c = immutableList;
            this.d = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.d.getValue().booleanValue()) {
                    LazyListState lazyListState = this.b;
                    int lastIndex = CollectionsKt.getLastIndex(this.c);
                    this.a = 1;
                    if (LazyListState.scrollToItem$default(lazyListState, lastIndex, 0, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
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

    public static final class b implements Function0<Unit> {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> function0) {
            this.a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.ai.ui.ChatListKt$ChatList$2$2$1", f = "ChatList.kt", i = {}, l = {Token.SET_REF_OP}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ LazyListState b;
        public final /* synthetic */ ImmutableList<CompletionResponse> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LazyListState lazyListState, ImmutableList<CompletionResponse> immutableList, Continuation<? super c> continuation) {
            super(1, continuation);
            this.b = lazyListState;
            this.c = immutableList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return new c(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LazyListState lazyListState = this.b;
                int lastIndex = CollectionsKt.getLastIndex(this.c);
                this.a = 1;
                if (lazyListState.animateScrollToItem(lastIndex, Integer.MAX_VALUE, this) == coroutine_suspended) {
                    return coroutine_suspended;
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

    public static final class d implements Function1<Integer, Object> {
        public final /* synthetic */ List a;

        public d(ImmutableList immutableList) {
            this.a = immutableList;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            this.a.get(num.intValue());
            return null;
        }
    }

    public static final class e implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ AiAssistantColorScheme b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function0 d;
        public final /* synthetic */ Function1 e;
        public final /* synthetic */ Function1 f;

        public e(ImmutableList immutableList, AiAssistantColorScheme aiAssistantColorScheme, boolean z, Function0 function0, Function1 function1, Function1 function2) {
            this.a = immutableList;
            this.b = aiAssistantColorScheme;
            this.c = z;
            this.d = function0;
            this.e = function1;
            this.f = function2;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            int i;
            String message;
            LazyItemScope lazyItemScope2 = lazyItemScope;
            int iIntValue = num.intValue();
            Composer composer2 = composer;
            int iIntValue2 = num2.intValue();
            if ((iIntValue2 & 6) == 0) {
                i = (composer2.changed(lazyItemScope2) ? 4 : 2) | iIntValue2;
            } else {
                i = iIntValue2;
            }
            if ((iIntValue2 & 48) == 0) {
                i |= composer2.changed(iIntValue) ? 32 : 16;
            }
            if (composer2.shouldExecute((i & Token.DOTQUERY) != 146, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                CompletionResponse completionResponse = (CompletionResponse) this.a.get(iIntValue);
                composer2.startReplaceGroup(67250548);
                if (completionResponse.getState() instanceof AiAssistantEvents.Error) {
                    composer2.startReplaceGroup(67279749);
                    boolean z = ((AiAssistantEvents.Error) completionResponse.getState()).getErrorStates() != DocumentErrorStates.EVALUATION_EXPIRED && ((AiAssistantEvents.Error) completionResponse.getState()).getRetryEnabled();
                    if (((AiAssistantEvents.Error) completionResponse.getState()).getErrorStates() == DocumentErrorStates.INTERNET_NOT_AVAILABLE) {
                        composer2.startReplaceGroup(67505770);
                        message = StringResources_androidKt.stringResource(R.string.pspdf__ai_assistant_unavailable_card_message, composer2, 0);
                        composer2.endReplaceGroup();
                    } else if (z) {
                        composer2.startReplaceGroup(67655128);
                        message = StringResources_androidKt.stringResource(R.string.pspdf__ai_assistant_failed_to_connect, composer2, 0);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(67923805);
                        composer2.endReplaceGroup();
                        message = ((AiAssistantEvents.Error) completionResponse.getState()).getMessage();
                    }
                    String str = message;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    AiAssistantColorScheme aiAssistantColorScheme = this.b;
                    boolean zAreEqual = Intrinsics.areEqual(completionResponse.getSender(), Issuer.INSTANCE.value(Issuer.HUMAN));
                    boolean z2 = this.c;
                    boolean zChanged = composer2.changed(this.d);
                    Object objRememberedValue = composer2.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new b(this.d);
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    u8.a(companion, aiAssistantColorScheme, zAreEqual, z, str, z2, (Function0<Unit>) objRememberedValue, composer2, 6, 0);
                    composer2 = composer2;
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(68468134);
                    u8.a(Modifier.INSTANCE, this.b, completionResponse, (Function1<? super Suggestion, Unit>) this.e, (Function1<? super Link, Unit>) this.f, this.c, composer2, 6, 0);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2.skipToGroupEnd();
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.ai.ui.ChatListKt$ScrollToBottomButton$3$1$1$1", f = "ChatList.kt", i = {}, l = {Token.SETCONSTVAR}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ Function1<Continuation<? super Unit>, Object> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new f(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Unit>, Object> function1 = this.b;
                this.a = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
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

    public static final int a(int i) {
        return i;
    }

    public static final Unit a(Modifier modifier, AiAssistantColorScheme aiAssistantColorScheme, ImmutableList immutableList, boolean z, Function0 function0, Function1 function1, Function1 function2, boolean z2, int i, int i2, Composer composer, int i3) {
        a(modifier, aiAssistantColorScheme, immutableList, z, function0, function1, function2, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final int b(int i) {
        return i;
    }

    public static final Unit a(Modifier modifier, boolean z, AiAssistantColorScheme aiAssistantColorScheme, Function1 function1, int i, Composer composer, int i2) {
        a(modifier, z, aiAssistantColorScheme, (Function1<? super Continuation<? super Unit>, ? extends Object>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final AiAssistantColorScheme aiAssistantColorScheme, final ImmutableList<CompletionResponse> immutableList, final boolean z, final Function0<Unit> function0, final Function1<? super Suggestion, Unit> function1, final Function1<? super Link, Unit> function2, boolean z2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z3;
        Function1<? super Suggestion, Unit> function3;
        boolean z4;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        Modifier modifier4;
        boolean z6;
        aiAssistantColorScheme.getClass();
        immutableList.getClass();
        function0.getClass();
        function1.getClass();
        function2.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1254534309);
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
            i3 |= composerStartRestartGroup.changed(aiAssistantColorScheme) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(immutableList) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z3 = z;
            i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        } else {
            z3 = z;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            function3 = function1;
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        } else {
            function3 = function1;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        int i5 = i2 & 128;
        if (i5 != 0) {
            i3 |= 12582912;
            z4 = z2;
        } else {
            z4 = z2;
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
            }
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            Modifier modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            boolean z7 = i5 != 0 ? true : z4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1254534309, i3, -1, "io.nutrient.internal.ui.ai.ui.ChatList (ChatList.kt:74)");
            }
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            boolean zChanged = composerStartRestartGroup.changed(immutableList);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(v8.a(lazyListStateRememberLazyListState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            State state = (State) objRememberedValue;
            boolean zChanged2 = composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changedInstance(immutableList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new a(lazyListStateRememberLazyListState, immutableList, state, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(immutableList, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, (i3 >> 6) & 14);
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            final boolean z8 = z7;
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, null), aiAssistantColorScheme.m13906getContainerColor0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(8), 0.0f, 2, null);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(immutableList) | ((i3 & 112) == 32) | ((29360128 & i3) == 8388608) | ((57344 & i3) == 16384) | ((458752 & i3) == 131072) | ((3670016 & i3) == 1048576) | ((i3 & 7168) == 2048);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                modifier4 = modifier5;
                final boolean z9 = z3;
                final Function1<? super Suggestion, Unit> function4 = function3;
                Function1 function5 = new Function1() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return v8.a(immutableList, z9, aiAssistantColorScheme, z8, function0, function4, function2, (LazyListScope) obj);
                    }
                };
                z6 = z8;
                composerStartRestartGroup.updateRememberedValue(function5);
                objRememberedValue3 = function5;
            } else {
                z6 = z8;
                modifier4 = modifier5;
            }
            LazyDslKt.LazyColumn(modifierM1220paddingVpY3zN4$default, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue3, composerStartRestartGroup, 0, 508);
            composer2 = composerStartRestartGroup;
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(boxScopeInstance.align(companion, companion2.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(10), 7, null);
            boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
            boolean zChanged3 = composer2.changed(lazyListStateRememberLazyListState) | composer2.changedInstance(r1);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new c(lazyListStateRememberLazyListState, immutableList, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            a(modifierM1222paddingqDBjuR0$default, zBooleanValue, aiAssistantColorScheme, (Function1<? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composer2, (i3 << 3) & 896);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z5 = z6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return v8.a(modifier3, aiAssistantColorScheme, immutableList, z, function0, function1, function2, z5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final boolean a(LazyListState lazyListState) {
        return lazyListState.getCanScrollForward();
    }

    public static final void a(Modifier modifier, boolean z, final AiAssistantColorScheme aiAssistantColorScheme, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Composer composer, final int i) {
        int i2;
        boolean z2;
        final Modifier modifier2;
        modifier.getClass();
        aiAssistantColorScheme.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1535140738);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(aiAssistantColorScheme) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1535140738, i2, -1, "io.nutrient.internal.ui.ai.ui.ScrollToBottomButton (ChatList.kt:147)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(v8.a(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EnterTransition enterTransitionPlus = enterTransitionFadeIn$default.plus(EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue2, 1, null));
            ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(v8.b(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            z2 = z;
            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier, enterTransitionPlus, exitTransitionFadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue3, 1, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(341258330, true, new Function3() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return v8.a(coroutineScope, function1, aiAssistantColorScheme, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 200064 | ((i2 << 3) & 112), 16);
            modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z2 = z;
            modifier2 = modifier;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return v8.a(modifier2, z3, aiAssistantColorScheme, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(final CoroutineScope coroutineScope, final Function1 function1, final AiAssistantColorScheme aiAssistantColorScheme, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(341258330, i, -1, "io.nutrient.internal.ui.ai.ui.ScrollToBottomButton.<anonymous> (ChatList.kt:155)");
        }
        boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return v8.a(coroutineScope, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ButtonKt.Button((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(aiAssistantColorScheme.m13908getInnerChatBackground0d7_KjU(), 0L, 0L, 0L, composer, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1368797258, true, new Function3() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return v8.a(aiAssistantColorScheme, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 805306368, 494);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(CoroutineScope coroutineScope, Function1 function1) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new f(function1, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final Unit a(AiAssistantColorScheme aiAssistantColorScheme, RowScope rowScope, Composer composer, int i) {
        rowScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1368797258, i, -1, "io.nutrient.internal.ui.ai.ui.ScrollToBottomButton.<anonymous>.<anonymous> (ChatList.kt:162)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_scroll_to_bottom, composer, 0), "Scroll to bottom", (Modifier) null, aiAssistantColorScheme.m13909getInnerChatTextColor0d7_KjU(), composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void a(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-743947679);
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743947679, i, -1, "io.nutrient.internal.ui.ai.ui.TypingIndicatorContainer (ChatList.kt:172)");
            }
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(12));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            o0.a(null, 0, 0.0f, 0.0f, 0L, 0L, 0.0f, composerStartRestartGroup, 0, 127);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.v8$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return v8.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(ImmutableList immutableList, boolean z, AiAssistantColorScheme aiAssistantColorScheme, boolean z2, Function0 function0, Function1 function1, Function1 function2, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        lazyListScope.items(immutableList.size(), null, new d(immutableList), ComposableLambdaKt.composableLambdaInstance(802480018, true, new e(immutableList, aiAssistantColorScheme, z2, function0, function1, function2)));
        if (z) {
            LazyListScope.item$default(lazyListScope, null, null, o9.a, 3, null);
        }
        return Unit.INSTANCE;
    }
}

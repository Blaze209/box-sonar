package com.pspdfkit.internal;

import android.content.Context;
import android.text.format.Formatter;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.document.files.EmbeddedFile;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class xf {

    @DebugMetadata(c = "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesComposableKt$EmbeddedFilesComposable$1$1", f = "EmbeddedFilesComposable.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, nl = {79}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ ag b;
        public final /* synthetic */ MutableState<Boolean> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ag agVar, MutableState<Boolean> mutableState, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = agVar;
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
                if (this.b.c) {
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

    public static final class b implements Function1<Integer, Object> {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            this.a.get(num.intValue());
            return null;
        }
    }

    public static final class c implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ y2 d;

        public c(List list, Context context, Function1 function1, y2 y2Var) {
            this.a = list;
            this.b = context;
            this.c = function1;
            this.d = y2Var;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            int i;
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
                EmbeddedFile embeddedFile = (EmbeddedFile) this.a.get(iIntValue);
                composer2.startReplaceGroup(-4885960);
                xf.a(embeddedFile, this.b, (Function1<? super EmbeddedFile, Unit>) this.c, this.d, composer2, 0);
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

    public static final class d implements Function1<Integer, Object> {
        public final /* synthetic */ List a;

        public d(List list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            this.a.get(num.intValue());
            return null;
        }
    }

    public static final class e implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ y2 d;

        public e(List list, Context context, Function1 function1, y2 y2Var) {
            this.a = list;
            this.b = context;
            this.c = function1;
            this.d = y2Var;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            int i;
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
                EmbeddedFile embeddedFile = (EmbeddedFile) this.a.get(iIntValue);
                composer2.startReplaceGroup(-1630562753);
                xf.a(embeddedFile, this.b, (Function1<? super EmbeddedFile, Unit>) this.c, this.d, composer2, 0);
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

    public static final Unit a(String str, String str2, Modifier modifier, y2 y2Var, int i, Composer composer, int i2) {
        a(str, str2, modifier, y2Var, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(ag agVar, Function1 function1, Modifier modifier, int i, Composer composer, int i2) {
        a(agVar, (Function1<? super EmbeddedFile, Unit>) function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(ag agVar, Function1 function1, Modifier modifier, int i, Composer composer, int i2) {
        a(agVar, (Function1<? super EmbeddedFile, Unit>) function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(EmbeddedFile embeddedFile, Context context, Function1 function1, y2 y2Var, int i, Composer composer, int i2) {
        a(embeddedFile, context, (Function1<? super EmbeddedFile, Unit>) function1, y2Var, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(ag agVar, Context context, Function1 function1, y2 y2Var, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        List<EmbeddedFile> list = agVar.a;
        lazyListScope.items(list.size(), null, new d(list), ComposableLambdaKt.composableLambdaInstance(802480018, true, new e(list, context, function1, y2Var)));
        return Unit.INSTANCE;
    }

    public static final Unit a(ag agVar, final y2 y2Var, final ot otVar, Context context, Function1 function1, LazyListScope lazyListScope) {
        LazyListScope lazyListScope2;
        lazyListScope.getClass();
        for (final vf vfVar : agVar.b) {
            if (vfVar.a >= 0) {
                lazyListScope2 = lazyListScope;
                LazyListScope.stickyHeader$default(lazyListScope2, (Object) null, (Object) null, (Function4) ComposableLambdaKt.composableLambdaInstance(1086503037, true, new Function4() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return xf.a(vfVar, y2Var, otVar, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }), 3, (Object) null);
            } else {
                lazyListScope2 = lazyListScope;
            }
            List<EmbeddedFile> list = vfVar.b;
            lazyListScope2.items(list.size(), null, new b(list), ComposableLambdaKt.composableLambdaInstance(802480018, true, new c(list, context, function1, y2Var)));
            lazyListScope = lazyListScope2;
        }
        return Unit.INSTANCE;
    }

    public static final void a(final ag agVar, final Function1<? super EmbeddedFile, Unit> function1, final Modifier modifier, Composer composer, final int i) {
        int i2;
        agVar.getClass();
        function1.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-182263524);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(agVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-182263524, i2, -1, "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesComposable (EmbeddedFilesComposable.kt:68)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final ot otVar = agVar.g;
            if (otVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return xf.a(agVar, function1, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            final y2 y2Var = new y2(context, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Boolean boolValueOf = Boolean.valueOf(agVar.c);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(agVar);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new a(agVar, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
            CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(TextStyle.m9104copyp1EtxEg$default((TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle()), ColorKt.Color(otVar.c), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null)), ComposableLambdaKt.rememberComposableLambda(-239143844, true, new Function2() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return xf.a(modifier, otVar, agVar, y2Var, context, function1, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return xf.b(agVar, function1, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(Modifier modifier, final ot otVar, final ag agVar, final y2 y2Var, final Context context, final Function1 function1, MutableState mutableState, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-239143844, i, -1, "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesComposable.<anonymous> (EmbeddedFilesComposable.kt:85)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifier, ColorKt.Color(otVar.a), null, 2, null);
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            AnimatedVisibilityKt.AnimatedVisibility(zBooleanValue, TestTagKt.testTag(boxScopeInstance.align(companion3, companion.getCenter()), "loading_progress"), (EnterTransition) null, (ExitTransition) null, (String) null, r9.a, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            Composer composer2 = composer;
            if (!agVar.b.isEmpty()) {
                composer2.startReplaceGroup(-499208299);
                boolean zChangedInstance = composer2.changedInstance(agVar) | composer2.changed(y2Var) | composer2.changedInstance(otVar) | composer2.changedInstance(context) | composer2.changed(function1);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function1 function2 = new Function1() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return xf.a(agVar, y2Var, otVar, context, function1, (LazyListScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(function2);
                    objRememberedValue = function2;
                }
                LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 511);
                composer2.endReplaceGroup();
            } else {
                List<EmbeddedFile> list = agVar.a;
                if (list != null && !list.isEmpty()) {
                    composer2.startReplaceGroup(-498235984);
                    boolean zChangedInstance2 = composer2.changedInstance(agVar) | composer2.changedInstance(context) | composer2.changed(function1) | composer2.changed(y2Var);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return xf.a(agVar, context, function1, y2Var, (LazyListScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue2, composer2, 0, 511);
                    composer2.endReplaceGroup();
                } else if (!agVar.c) {
                    composer2.startReplaceGroup(-497851863);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                    f2.a(companion2, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM6062constructorimpl2, currentCompositionLocalMap2);
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                    TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__no_attachments, composer2, 0), PaddingKt.m1218padding3ABfNKs(boxScopeInstance.align(TestTagKt.testTag(companion3, "no_attachments"), companion.getCenter()), y2Var.d), 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(otVar.u), 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262012);
                    composer2 = composer;
                    composer2.endNode();
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-497172436);
                    composer2.endReplaceGroup();
                }
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(vf vfVar, y2 y2Var, ot otVar, LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        lazyItemScope.getClass();
        if (composer.shouldExecute((i2 & 129) != 128, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1086503037, i2, -1, "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EmbeddedFilesComposable.kt:108)");
            }
            r40.a(StringResources_androidKt.stringResource(R.string.pspdf__page_with_number, new Object[]{Integer.valueOf(vfVar.a + 1)}, composer, 0), y2Var, p2.a(otVar), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void a(final EmbeddedFile embeddedFile, final Context context, final Function1<? super EmbeddedFile, Unit> function1, final y2 y2Var, Composer composer, final int i) {
        int i2;
        String shortFileSize;
        embeddedFile.getClass();
        context.getClass();
        function1.getClass();
        y2Var.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1799331135);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(embeddedFile) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(context) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(y2Var) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1799331135, i2, -1, "com.pspdfkit.internal.views.outline.embed.FileItemWithDivider (EmbeddedFilesComposable.kt:156)");
            }
            String fileName = embeddedFile.getFileName();
            fileName.getClass();
            String string = context.getString(R.string.pspdf__size);
            long fileSize = embeddedFile.getFileSize();
            if (((int) fileSize) == -1) {
                shortFileSize = context.getString(R.string.pspdf__page_binding_unknown);
                shortFileSize.getClass();
            } else {
                shortFileSize = Formatter.formatShortFileSize(context, fileSize);
                shortFileSize.getClass();
            }
            String str = string + ": " + shortFileSize;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), y2Var.d);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(embeddedFile) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return xf.a(function1, embeddedFile);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            a(fileName, str, ClickableKt.m632clickableoSLSa3U$default(modifierM1218padding3ABfNKs, false, null, null, null, (Function0) objRememberedValue, 15, null), y2Var, composerStartRestartGroup, i2 & 7168);
            DividerKt.m3284HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return xf.a(embeddedFile, context, function1, y2Var, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Function1 function1, EmbeddedFile embeddedFile) {
        function1.invoke(embeddedFile);
        return Unit.INSTANCE;
    }

    public static final void a(final String str, final String str2, final Modifier modifier, final y2 y2Var, Composer composer, final int i) {
        int i2;
        Composer composer2;
        str.getClass();
        str2.getClass();
        modifier.getClass();
        y2Var.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(236996111);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(y2Var) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(236996111, i2, -1, "com.pspdfkit.internal.views.outline.embed.EmbeddedFileItem (EmbeddedFilesComposable.kt:173)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion.getStart(), composerStartRestartGroup, 0);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, y2Var.c, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i2 & 14, 0, 262126);
            TextKt.m4494TextNvy7gAk(str2, null, Color.m6813copywmQWz5c$default(((TextStyle) composer2.consume(TextKt.getLocalTextStyle())).m9121getColor0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null, y2Var.c, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (i2 >> 3) & 14, 0, 262122);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.xf$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return xf.a(str, str2, modifier, y2Var, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

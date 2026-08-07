package com.pspdfkit.internal;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class oo {

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.ui.LowResComposableKt$LowResComposable$1$1", f = "LowResComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ az a;
        public final /* synthetic */ to b;
        public final /* synthetic */ Function1<az, Unit> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(az azVar, to toVar, Function1<? super az, Unit> function1, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = azVar;
            this.b = toVar;
            this.c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            if (this.a.a == 2) {
                to toVar = this.b;
                zo zoVar = toVar.b;
                if (zoVar != null) {
                    zoVar.b();
                }
                zo zoVar2 = toVar.c;
                if (zoVar2 != null) {
                    zoVar2.b();
                }
                toVar.b = null;
                toVar.c = null;
                Function1<az, Unit> function1 = this.c;
                az azVar = this.a;
                azVar.getClass();
                function1.invoke(az.a(azVar, 0, null, 14));
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.ui.LowResComposableKt$LowResComposable$2$1", f = "LowResComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ CoroutineScope a;
        public final /* synthetic */ az b;
        public final /* synthetic */ to c;
        public final /* synthetic */ List<Integer> d;
        public final /* synthetic */ m40 e;
        public final /* synthetic */ Function1<az, Unit> f;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.ui.LowResComposableKt$LowResComposable$2$1$1", f = "LowResComposable.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {"skipCache"}, nl = {79}, s = {"I$0"}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ az b;
            public final /* synthetic */ to c;
            public final /* synthetic */ List<Integer> d;
            public final /* synthetic */ m40 e;
            public final /* synthetic */ Function1<az, Unit> f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(az azVar, to toVar, List<Integer> list, m40 m40Var, Function1<? super az, Unit> function1, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = azVar;
                this.c = toVar;
                this.d = list;
                this.e = m40Var;
                this.f = function1;
            }

            public static final Unit a(az azVar, Function1 function1, int i, zo zoVar) {
                v7 v7Var = azVar.b;
                if (v7Var != null) {
                    v7Var.release();
                }
                v7 v7Var2 = null;
                if (zoVar != null) {
                    v7.INSTANCE.getClass();
                    zoVar.b.incrementAndGet();
                    v7Var2 = new v7(zoVar, v7.nextId.incrementAndGet(), null);
                }
                function1.invoke(az.a(azVar, i, v7Var2, 12));
                return Unit.INSTANCE;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, continuation);
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
                    if (this.b.a == 0) {
                        boolean z = !Intrinsics.areEqual((List) this.c.a.p.getValue(), this.d);
                        to toVar = this.c;
                        m40 m40Var = this.e;
                        toVar.getClass();
                        m40Var.getClass();
                        toVar.a = m40Var;
                        to toVar2 = this.c;
                        final az azVar = this.b;
                        final Function1<az, Unit> function1 = this.f;
                        Function2 function2 = new Function2() { // from class: com.pspdfkit.internal.oo$b$a$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return oo.b.a.a(azVar, function1, ((Integer) obj2).intValue(), (zo) obj3);
                            }
                        };
                        this.a = 1;
                        if (toVar2.a(azVar, z, function2, this) == coroutine_suspended) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(CoroutineScope coroutineScope, az azVar, to toVar, List<Integer> list, m40 m40Var, Function1<? super az, Unit> function1, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = coroutineScope;
            this.b = azVar;
            this.c = toVar;
            this.d = list;
            this.e = m40Var;
            this.f = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(this.a, null, null, new a(this.b, this.c, this.d, this.e, this.f, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function0<x7> {
        public c(Object obj) {
            super(0, obj, v7.class, "acquireLeaseOrNull", "acquireLeaseOrNull()Lcom/pspdfkit/internal/utilities/bitmap/BitmapLease;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final x7 invoke() {
            return ((v7) this.receiver).acquireLeaseOrNull();
        }
    }

    public static final class d implements DisposableEffectResult {
        public final /* synthetic */ to a;

        public d(to toVar) {
            this.a = toVar;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public final void dispose() {
            to toVar = this.a;
            zo zoVar = toVar.b;
            if (zoVar != null) {
                zoVar.b();
            }
            zo zoVar2 = toVar.c;
            if (zoVar2 != null) {
                zoVar2.b();
            }
            toVar.b = null;
            toVar.c = null;
        }
    }

    public static final Unit a(az azVar, Function1 function1, int i, Composer composer, int i2) {
        a(azVar, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(az azVar, Function1 function1, int i, Composer composer, int i2) {
        a(azVar, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(az azVar, final Function1<? super az, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Object bVar;
        to toVar;
        Object obj;
        m40 m40Var;
        final az azVar2 = azVar;
        function1 = function1;
        azVar2.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(272540704);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(azVar2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(272540704, i2, -1, "com.pspdfkit.internal.views.page.pageview.ui.LowResComposable (LowResComposable.kt:38)");
            }
            uu uuVar = (uu) composerStartRestartGroup.consume(ko.a);
            m40 m40Var2 = uuVar.b;
            if (m40Var2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.oo$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return oo.a(azVar2, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            List list = (List) m40Var2.p.getValue();
            composerStartRestartGroup.startMovableGroup(-81370792, Integer.valueOf(m40Var2.b));
            boolean zChanged = composerStartRestartGroup.changed(m40Var2.b);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new to(uuVar.a, m40Var2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            to toVar2 = (to) objRememberedValue2;
            Integer numValueOf = Integer.valueOf(list.hashCode());
            int i3 = i2 & 14;
            int i4 = i2 & 112;
            boolean zChangedInstance = (i3 == 4) | composerStartRestartGroup.changedInstance(toVar2) | (i4 == 32);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a(azVar2, toVar2, function1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 0);
            Integer numValueOf2 = Integer.valueOf(m40Var2.b);
            Integer numValueOf3 = Integer.valueOf(azVar2.a);
            Integer numValueOf4 = Integer.valueOf(list.hashCode());
            boolean zChangedInstance2 = (i4 == 32) | (i3 == 4) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(toVar2) | composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(m40Var2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                toVar = toVar2;
                obj = null;
                bVar = new b(coroutineScope, azVar2, toVar, list, m40Var2, function1, null);
                m40Var = m40Var2;
                composerStartRestartGroup.updateRememberedValue(bVar);
            } else {
                m40Var = m40Var2;
                bVar = objRememberedValue4;
                toVar = toVar2;
                obj = null;
            }
            Function2 function2 = (Function2) bVar;
            final to toVar3 = toVar;
            composer2 = composerStartRestartGroup;
            EffectsKt.LaunchedEffect(numValueOf2, numValueOf3, numValueOf4, function2, composer2, 0);
            Integer numValueOf5 = Integer.valueOf(m40Var.b);
            boolean zChangedInstance3 = composer2.changedInstance(toVar3);
            Object objRememberedValue5 = composer2.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.oo$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return oo.a(toVar3, (DisposableEffectScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            }
            EffectsKt.DisposableEffect(numValueOf5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composer2, 0);
            v7 v7Var = azVar2.b;
            if (v7Var == null) {
                composer2.startReplaceGroup(1774221270);
                SpacerKt.Spacer(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj), ColorKt.Color(uuVar.c), null, 2, null), composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1774437805);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj), ColorKt.Color(uuVar.c), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM589backgroundbw27NRU$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
                f2.a(companion3, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                long id = v7Var.getId();
                boolean zChangedInstance4 = composer2.changedInstance(v7Var);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new c(v7Var);
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                lz.a(id, (Function0) ((KFunction) objRememberedValue6), null, SizeKt.fillMaxSize$default(companion2, 0.0f, 1, obj), ContentScale.INSTANCE.getFillBounds(), null, composer2, 28032, 32);
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            composer2.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            azVar2 = azVar2;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.oo$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return oo.b(azVar2, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    public static final DisposableEffectResult a(to toVar, DisposableEffectScope disposableEffectScope) {
        disposableEffectScope.getClass();
        return new d(toVar);
    }
}

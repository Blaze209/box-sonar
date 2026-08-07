package com.pspdfkit.internal;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Size;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class oj {
    public static final Paint a = new Paint();

    public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function0<x7> {
        public a(Object obj) {
            super(0, obj, v7.class, "acquireLeaseOrNull", "acquireLeaseOrNull()Lcom/pspdfkit/internal/utilities/bitmap/BitmapLease;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final x7 invoke() {
            return ((v7) this.receiver).acquireLeaseOrNull();
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.ui.HighResComposableKt$HighResComposable$1$1", f = "HighResComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ az a;
        public final /* synthetic */ pj b;
        public final /* synthetic */ Function1<az, Unit> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(az azVar, pj pjVar, Function1<? super az, Unit> function1, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = azVar;
            this.b = pjVar;
            this.c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            if (this.a.a == 2) {
                this.b.a();
                Function1<az, Unit> function1 = this.c;
                az azVar = this.a;
                azVar.getClass();
                function1.invoke(az.a(azVar, 0, null, 14));
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.ui.HighResComposableKt$HighResComposable$2$1", f = "HighResComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ pj a;
        public final /* synthetic */ m40 b;
        public final /* synthetic */ az c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Function1<az, Unit> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(pj pjVar, m40 m40Var, az azVar, boolean z, Function1<? super az, Unit> function1, Continuation<? super c> continuation) {
            super(2, continuation);
            this.a = pjVar;
            this.b = m40Var;
            this.c = azVar;
            this.d = z;
            this.e = function1;
        }

        public static final Unit a(az azVar, Function1 function1, int i, zo zoVar, Float f, Rect rect) {
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
            function1.invoke(new az(i, v7Var2, f != null ? f.floatValue() : 1.0f, rect));
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.a, this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00d7  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            boolean z = !Intrinsics.areEqual(this.a.a.a(), this.b.a()) || this.c.a == 0;
            pj pjVar = this.a;
            m40 m40Var = this.b;
            pjVar.getClass();
            m40Var.getClass();
            pjVar.a = m40Var;
            if (!this.d) {
                return Unit.INSTANCE;
            }
            m40 m40Var2 = this.b;
            if (m40Var2.j) {
                return Unit.INSTANCE;
            }
            pj pjVar2 = this.a;
            Rect rect = m40Var2.e;
            final az azVar = this.c;
            final Function1<az, Unit> function1 = this.e;
            Function4<? super Integer, ? super zo, ? super Float, ? super Rect, Unit> function4 = new Function4() { // from class: com.pspdfkit.internal.oj$c$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    return oj.c.a(azVar, function1, ((Integer) obj2).intValue(), (zo) obj3, (Float) obj4, (Rect) obj5);
                }
            };
            pjVar2.getClass();
            rect.getClass();
            if (Math.abs(pjVar2.a.f - pjVar2.i) > 0.01f) {
                pjVar2.r.set(pjVar2.a.e);
                pjVar2.s = function4;
                pjVar2.q.tryEmit(Unit.INSTANCE);
            } else if (pjVar2.k.isEmpty()) {
                pjVar2.a(rect, function4);
            } else {
                float f = pjVar2.a.f / pjVar2.i;
                Rect rect2 = pjVar2.k;
                int i = (int) (rect2.left * f);
                int i2 = (int) (rect2.top * f);
                int i3 = (int) (rect2.right * f);
                int i4 = (int) (rect2.bottom * f);
                int iAbs = Math.abs(rect.left - i);
                int iAbs2 = Math.abs(rect.top - i2);
                int iAbs3 = Math.abs(rect.right - i3);
                int iAbs4 = Math.abs(rect.bottom - i4);
                int iWidth = (int) (rect.width() * pjVar2.f);
                int iHeight = (int) (rect.height() * pjVar2.f);
                if (iAbs > iWidth || iAbs2 > iHeight || iAbs3 > iWidth || iAbs4 > iHeight || z) {
                    pjVar2.a(rect, function4);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d implements DisposableEffectResult {
        public final /* synthetic */ pj a;

        public d(pj pjVar) {
            this.a = pjVar;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public final void dispose() {
            this.a.a();
        }
    }

    public static final Unit a(az azVar, float f, int i, Composer composer, int i2) {
        a(azVar, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(az azVar, float f, int i, Composer composer, int i2) {
        a(azVar, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(az azVar, Function1 function1, int i, Composer composer, int i2) {
        a(azVar, (Function1<? super az, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(az azVar, Function1 function1, int i, Composer composer, int i2) {
        a(azVar, (Function1<? super az, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final az azVar, final Function1<? super az, Unit> function1, Composer composer, final int i) {
        int i2;
        final pj pjVar;
        azVar.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(815699860);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(azVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(815699860, i2, -1, "com.pspdfkit.internal.views.page.pageview.ui.HighResComposable (HighResComposable.kt:35)");
            }
            m40 m40Var = ((uu) composerStartRestartGroup.consume(ko.a)).b;
            if (m40Var == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.oj$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return oj.a(azVar, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2147296218, 0, -1, "com.pspdfkit.internal.views.page.pageview.ui.rememberScreenSize (HighResComposable.kt:129)");
            }
            Configuration configuration = (Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            Size size = new Size((int) density.mo754toPx0680j_4(Dp.m9687constructorimpl(configuration.screenWidthDp)), (int) density.mo754toPx0680j_4(Dp.m9687constructorimpl(configuration.screenHeightDp)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i3 = m40Var.b;
            boolean z = m40Var.d;
            float f = m40Var.f;
            float f2 = m40Var.g.width;
            Rect rect = m40Var.e;
            Pair pair = new Pair(Float.valueOf(rect.exactCenterX()), Float.valueOf(rect.exactCenterY()));
            composerStartRestartGroup.startMovableGroup(-2091431610, Integer.valueOf(i3));
            boolean zChanged = composerStartRestartGroup.changed(i3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new pj(size, m40Var);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            pj pjVar2 = (pj) objRememberedValue;
            String strA = m40Var.a();
            int i4 = i2 & 14;
            int i5 = i2 & 112;
            boolean zChangedInstance = (i4 == 4) | composerStartRestartGroup.changedInstance(pjVar2) | (i5 == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new b(azVar, pjVar2, function1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(strA, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
            Object[] objArr = {Integer.valueOf(i3), Boolean.valueOf(m40Var.j), Float.valueOf(f), pair, Boolean.valueOf(z), Integer.valueOf(azVar.a), m40Var.a()};
            boolean zChangedInstance2 = (i5 == 32) | composerStartRestartGroup.changedInstance(pjVar2) | composerStartRestartGroup.changed(m40Var) | (i4 == 4) | composerStartRestartGroup.changed(z);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                pjVar = pjVar2;
                c cVar = new c(pjVar, m40Var, azVar, z, function1, null);
                composerStartRestartGroup.updateRememberedValue(cVar);
                objRememberedValue3 = cVar;
            } else {
                pjVar = pjVar2;
            }
            EffectsKt.LaunchedEffect(objArr, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 0);
            a(azVar, f2, composerStartRestartGroup, i4);
            Integer numValueOf = Integer.valueOf(i3);
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(pjVar);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.oj$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return oj.a(pjVar, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.DisposableEffect(numValueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, 0);
            composerStartRestartGroup.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.oj$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return oj.b(azVar, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(final az azVar, final float f, final Bitmap bitmap, Composer composer, int i) {
        bitmap.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2052140765, i, -1, "com.pspdfkit.internal.views.page.pageview.ui.DrawContainer.<anonymous> (HighResComposable.kt:104)");
        }
        final Rect rect = azVar.d;
        if (rect != null) {
            composer.startReplaceGroup(761175315);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zChanged = composer.changed(f) | composer.changed(azVar) | composer.changedInstance(bitmap) | composer.changedInstance(rect);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.oj$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return oj.a(f, azVar, bitmap, rect, (DrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(762053669);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void a(final az azVar, final float f, Composer composer, final int i) {
        int i2;
        azVar.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-274027387);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(azVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-274027387, i2, -1, "com.pspdfkit.internal.views.page.pageview.ui.DrawContainer (HighResComposable.kt:97)");
            }
            v7 v7Var = azVar.b;
            if (v7Var == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.oj$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return oj.a(azVar, f, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            long id = v7Var.getId();
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(v7Var);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a(v7Var);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            lz.a(id, (Function0) ((KFunction) objRememberedValue), ComposableLambdaKt.rememberComposableLambda(2052140765, true, new Function3() { // from class: com.pspdfkit.internal.oj$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return oj.a(azVar, f, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.oj$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return oj.b(azVar, f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(float f, az azVar, Bitmap bitmap, Rect rect, DrawScope drawScope) {
        drawScope.getClass();
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) / f) / azVar.c;
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas());
        int iSave = nativeCanvas.save();
        try {
            nativeCanvas.scale(fIntBitsToFloat, fIntBitsToFloat);
            try {
                nativeCanvas.drawBitmap(bitmap, (Rect) null, rect, a);
            } catch (RuntimeException unused) {
            }
            return Unit.INSTANCE;
        } finally {
            nativeCanvas.restoreToCount(iSave);
        }
    }

    public static final DisposableEffectResult a(pj pjVar, DisposableEffectScope disposableEffectScope) {
        disposableEffectScope.getClass();
        return new d(pjVar);
    }
}

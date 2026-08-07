package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.ContextCompat;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class ze {

    @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.signatures.composables.DrawElectronicSignatureScreenKt$CalculateSignatureBoxVerticalPadding$1$1", f = "DrawElectronicSignatureScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ WindowInfo c;
        public final /* synthetic */ Configuration d;
        public final /* synthetic */ Function1<Integer, Unit> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(int i, boolean z, WindowInfo windowInfo, Configuration configuration, Function1<? super Integer, Unit> function1, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = i;
            this.b = z;
            this.c = windowInfo;
            this.d = configuration;
            this.e = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            if (this.a <= 0 || this.b) {
                this.e.invoke(Boxing.boxInt(0));
            } else {
                int iMo8777getContainerSizeYbymL2g = (int) (this.c.mo8777getContainerSizeYbymL2g() >> 32);
                if (this.d.orientation == 1) {
                    this.e.invoke(Boxing.boxInt((this.a - ((int) ((iMo8777getContainerSizeYbymL2g * 2.0f) / 3.0f))) / 2));
                } else {
                    this.e.invoke(Boxing.boxInt(0));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(boolean z, int i, Function1 function1, int i2, Composer composer, int i3) {
        a(z, i, (Function1<? super Integer, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final MutableIntState b() {
        return SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final Unit a(ye yeVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, com.pspdfkit.internal.ui.dialog.signatures.e.b bVar, ElectronicSignatureOptions electronicSignatureOptions, long j, Function1 function1, Function0 function0, g20 g20Var, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        a(yeVar, z, z2, z3, z4, z5, bVar, electronicSignatureOptions, j, function1, function0, g20Var, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static final ElectronicSignatureControllerView b(ElectronicSignatureOptions electronicSignatureOptions, final ye yeVar, final MutableIntState mutableIntState, Context context) {
        context.getClass();
        ElectronicSignatureControllerView electronicSignatureControllerView = new ElectronicSignatureControllerView(context);
        electronicSignatureControllerView.setListener(new ElectronicSignatureControllerView.d() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView.d
            public final void a(int i) {
                ze.b(yeVar, mutableIntState, i);
            }
        });
        electronicSignatureControllerView.a(electronicSignatureOptions.getSignatureColorOptions());
        electronicSignatureControllerView.setOrientation(ElectronicSignatureControllerView.e.VERTICAL);
        electronicSignatureControllerView.setCurrentlySelectedColor(mutableIntState.getIntValue());
        return electronicSignatureControllerView;
    }

    public static final Unit a(g20 g20Var, Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1514259999, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.DrawElectronicSignatureScreen.<anonymous>.<anonymous> (DrawElectronicSignatureScreen.kt:174)");
        }
        l20.a(TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_margin, composer, 0), PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_margin, composer, 0), 3, null), "PSPDF_PICKER_ADD_SIGNATURE_FAB"), g20Var.a, ColorKt.Color(g20Var.b), ColorKt.Color(g20Var.c), PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_elevation, composer, 0), null, function0, composer, 0, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void b(ye yeVar, MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        yeVar.setInkColor(i);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:140:0x021b  */
    /* JADX WARN: Code duplicated, block: B:143:0x026b  */
    /* JADX WARN: Code duplicated, block: B:146:0x0277  */
    /* JADX WARN: Code duplicated, block: B:147:0x027b  */
    /* JADX WARN: Code duplicated, block: B:150:0x0294  */
    /* JADX WARN: Code duplicated, block: B:152:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:155:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:156:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:161:0x0308  */
    /* JADX WARN: Code duplicated, block: B:164:0x037a  */
    /* JADX WARN: Code duplicated, block: B:167:0x0386  */
    /* JADX WARN: Code duplicated, block: B:168:0x038a  */
    /* JADX WARN: Code duplicated, block: B:173:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:175:0x041a  */
    /* JADX WARN: Code duplicated, block: B:179:0x043f  */
    /* JADX WARN: Code duplicated, block: B:184:0x0462  */
    /* JADX WARN: Code duplicated, block: B:187:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:190:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:191:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:196:0x0506  */
    /* JADX WARN: Code duplicated, block: B:200:0x0591  */
    public static final void a(final ye yeVar, final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final com.pspdfkit.internal.ui.dialog.signatures.e.b bVar, final ElectronicSignatureOptions electronicSignatureOptions, final long j, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, final g20 g20Var, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        Composer composer2;
        final Modifier modifier2;
        boolean z6;
        final MutableIntState mutableIntState;
        Density density;
        int i7;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableIntState mutableIntState2;
        Object objRememberedValue2;
        final MutableIntState mutableIntState3;
        boolean zChanged;
        Object objRememberedValue3;
        Alignment.Companion companion2;
        ComposeUiNode.Companion companion3;
        Function0<ComposeUiNode> constructor;
        BoxScopeInstance boxScopeInstance;
        boolean zChangedInstance;
        Object objRememberedValue4;
        boolean zChanged2;
        Object objRememberedValue5;
        Function0<ComposeUiNode> constructor2;
        boolean zChanged3;
        Object objRememberedValue6;
        Function0<ComposeUiNode> constructor3;
        boolean zChangedInstance2;
        Object objRememberedValue7;
        Function0<ComposeUiNode> constructor4;
        boolean zChanged4;
        Object objRememberedValue8;
        yeVar.getClass();
        bVar.getClass();
        electronicSignatureOptions.getClass();
        function1.getClass();
        function0.getClass();
        g20Var.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1907229955);
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(yeVar) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(z5) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(bVar) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(electronicSignatureOptions) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(function0) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(g20Var) ? 32 : 16;
        }
        int i8 = i5;
        int i9 = i3 & 4096;
        if (i9 != 0) {
            i6 = i8 | 384;
        } else {
            int i10 = i8;
            if ((i2 & 384) == 0) {
                i10 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i6 = i10;
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i6 & Token.DOTQUERY) == 146) ? false : true, i4 & 1)) {
            Modifier modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1907229955, i4, i6, "com.pspdfkit.internal.ui.dialog.signatures.composables.DrawElectronicSignatureScreen (DrawElectronicSignatureScreen.kt:61)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            boolean z7 = z5 || z4;
            Object[] objArr = new Object[0];
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(electronicSignatureOptions) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3) {
                z6 = z7;
            } else {
                z6 = z7;
                if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                }
                mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue9, composerStartRestartGroup, 0);
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                i7 = i4;
                Object[] objArr2 = new Object[0];
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ze.a();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState2 = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue, composerStartRestartGroup, 48);
                Object[] objArr3 = new Object[0];
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ze.b();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableIntState3 = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
                int intValue = mutableIntState2.getIntValue();
                zChanged = composerStartRestartGroup.changed(mutableIntState3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(mutableIntState3, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                a(z5, intValue, (Function1<? super Integer, Unit>) objRememberedValue3, composerStartRestartGroup, (i7 >> 15) & 14);
                Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifier3, j, null, 2, null);
                Modifier modifier4 = modifier3;
                companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
                companion3 = ComposeUiNode.INSTANCE;
                constructor = companion3.getConstructor();
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
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(1552711271);
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                    constructor3 = companion3.getConstructor();
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    f2.a(companion3, composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(bVar) | composerStartRestartGroup.changed(mutableIntState);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ze.a(yeVar, bVar, mutableIntState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue7, ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null), null, composerStartRestartGroup, 0, 4);
                    DividerKt.m3284HorizontalDivider9IZ8Weo(null, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_divider_height, composerStartRestartGroup, 0), ColorKt.Color(4289309099L), composerStartRestartGroup, 384, 1);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                    constructor4 = companion3.getConstructor();
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    f2.a(companion3, composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM6062constructorimpl3, currentCompositionLocalMap3);
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl3, Integer.valueOf(iHashCode3), composerM6062constructorimpl3));
                    zChanged4 = composerStartRestartGroup.changed(mutableIntState) | composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(electronicSignatureOptions);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4 || objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ze.a(electronicSignatureOptions, yeVar, mutableIntState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue8, boxScopeInstance.align(companion4, companion2.getBottomStart()), null, composerStartRestartGroup, 0, 4);
                    b00.a(z2, z, function1, boxScopeInstance.align(PaddingKt.m1222paddingqDBjuR0$default(companion4, 0.0f, 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_save_chip_bottom_margin, composerStartRestartGroup, 0), 7, null), companion2.getBottomCenter()), composerStartRestartGroup, ((i7 >> 6) & 14) | (i7 & 112) | ((i7 >> 21) & 896));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1554736997);
                    zChangedInstance = composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(bVar) | composerStartRestartGroup.changed(mutableIntState) | composerStartRestartGroup.changedInstance(context);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ze.a(yeVar, bVar, context, mutableIntState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function2 = (Function1) objRememberedValue4;
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null);
                    zChanged2 = composerStartRestartGroup.changed(mutableIntState2);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ze.a(mutableIntState2, (LayoutCoordinates) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    AndroidView_androidKt.AndroidView(function2, PaddingKt.m1220paddingVpY3zN4$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxSize$default, (Function1) objRememberedValue5), 0.0f, density.mo751toDpu2uoSUM(mutableIntState3.getIntValue()), 1, null), null, composerStartRestartGroup, 0, 4);
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(boxScopeInstance.align(companion5, companion2.getBottomStart()), 0.0f, 1, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion2.getBottom(), composerStartRestartGroup, 48);
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                    constructor2 = companion3.getConstructor();
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    f2.a(companion3, composerM6062constructorimpl4, measurePolicyRowMeasurePolicy, composerM6062constructorimpl4, currentCompositionLocalMap4);
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl4, Integer.valueOf(iHashCode4), composerM6062constructorimpl4));
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    zChanged3 = composerStartRestartGroup.changed(mutableIntState) | composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(electronicSignatureOptions);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3 || objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ze.b(electronicSignatureOptions, yeVar, mutableIntState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue6, null, null, composerStartRestartGroup, 0, 6);
                    b00.a(z2, z, function1, PaddingKt.m1222paddingqDBjuR0$default(companion5, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__electronic_signature_save_signature_chip_padding, composerStartRestartGroup, 0), 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_save_chip_bottom_margin, composerStartRestartGroup, 0), 6, null), composerStartRestartGroup, ((i7 >> 6) & 14) | (i7 & 112) | ((i7 >> 21) & 896));
                    composer2 = composerStartRestartGroup;
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                AnimatedVisibilityKt.AnimatedVisibility(z3, boxScopeInstance.align(Modifier.INSTANCE, companion2.getBottomEnd()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1514259999, true, new Function3() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ze.a(g20Var, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ((i7 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            objRememberedValue9 = new Function0() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ze.a(electronicSignatureOptions, context);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue9, composerStartRestartGroup, 0);
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            i7 = i4;
            Object[] objArr4 = new Object[0];
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ze.a();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableIntState2 = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr4, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            Object[] objArr5 = new Object[0];
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ze.b();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableIntState3 = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr5, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            int intValue2 = mutableIntState2.getIntValue();
            zChanged = composerStartRestartGroup.changed(mutableIntState3);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ze.a(mutableIntState3, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ze.a(mutableIntState3, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            a(z5, intValue2, (Function1<? super Integer, Unit>) objRememberedValue3, composerStartRestartGroup, (i7 >> 15) & 14);
            Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(modifier3, j, null, 2, null);
            Modifier modifier5 = modifier3;
            companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default2);
            companion3 = ComposeUiNode.INSTANCE;
            constructor = companion3.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion3, composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM6062constructorimpl5, currentCompositionLocalMap5);
            Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl5, Integer.valueOf(iHashCode5), composerM6062constructorimpl5));
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z6) {
                composerStartRestartGroup.startReplaceGroup(1552711271);
                Modifier.Companion companion6 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
                int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion6);
                constructor3 = companion3.getConstructor();
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                f2.a(companion3, composerM6062constructorimpl6, measurePolicyColumnMeasurePolicy2, composerM6062constructorimpl6, currentCompositionLocalMap6);
                Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl6, Integer.valueOf(iHashCode6), composerM6062constructorimpl6));
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                zChangedInstance2 = composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(bVar) | composerStartRestartGroup.changed(mutableIntState);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(yeVar, bVar, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(yeVar, bVar, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue7, ColumnScope.weight$default(columnScopeInstance2, SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null), 1.0f, false, 2, null), null, composerStartRestartGroup, 0, 4);
                DividerKt.m3284HorizontalDivider9IZ8Weo(null, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_divider_height, composerStartRestartGroup, 0), ColorKt.Color(4289309099L), composerStartRestartGroup, 384, 1);
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
                constructor4 = companion3.getConstructor();
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                f2.a(companion3, composerM6062constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy4, composerM6062constructorimpl7, currentCompositionLocalMap7);
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl7, Integer.valueOf(iHashCode7), composerM6062constructorimpl7));
                zChanged4 = composerStartRestartGroup.changed(mutableIntState) | composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(electronicSignatureOptions);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue8 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(electronicSignatureOptions, yeVar, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(electronicSignatureOptions, yeVar, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue8, boxScopeInstance.align(companion6, companion2.getBottomStart()), null, composerStartRestartGroup, 0, 4);
                b00.a(z2, z, function1, boxScopeInstance.align(PaddingKt.m1222paddingqDBjuR0$default(companion6, 0.0f, 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_save_chip_bottom_margin, composerStartRestartGroup, 0), 7, null), companion2.getBottomCenter()), composerStartRestartGroup, ((i7 >> 6) & 14) | (i7 & 112) | ((i7 >> 21) & 896));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(1554736997);
                zChangedInstance = composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(bVar) | composerStartRestartGroup.changed(mutableIntState) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(yeVar, bVar, context, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(yeVar, bVar, context, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function3 = (Function1) objRememberedValue4;
                Modifier.Companion companion7 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion7, 0.0f, 1, null);
                zChanged2 = composerStartRestartGroup.changed(mutableIntState2);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(mutableIntState2, (LayoutCoordinates) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.a(mutableIntState2, (LayoutCoordinates) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                AndroidView_androidKt.AndroidView(function3, PaddingKt.m1220paddingVpY3zN4$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxSize$default2, (Function1) objRememberedValue5), 0.0f, density.mo751toDpu2uoSUM(mutableIntState3.getIntValue()), 1, null), null, composerStartRestartGroup, 0, 4);
                Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(boxScopeInstance.align(companion7, companion2.getBottomStart()), 0.0f, 1, null);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion2.getBottom(), composerStartRestartGroup, 48);
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
                constructor2 = companion3.getConstructor();
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                f2.a(companion3, composerM6062constructorimpl8, measurePolicyRowMeasurePolicy2, composerM6062constructorimpl8, currentCompositionLocalMap8);
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl8, Integer.valueOf(iHashCode8), composerM6062constructorimpl8));
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                zChanged3 = composerStartRestartGroup.changed(mutableIntState) | composerStartRestartGroup.changedInstance(yeVar) | composerStartRestartGroup.changedInstance(electronicSignatureOptions);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue6 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.b(electronicSignatureOptions, yeVar, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ze.b(electronicSignatureOptions, yeVar, mutableIntState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue6, null, null, composerStartRestartGroup, 0, 6);
                b00.a(z2, z, function1, PaddingKt.m1222paddingqDBjuR0$default(companion7, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__electronic_signature_save_signature_chip_padding, composerStartRestartGroup, 0), 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_save_chip_bottom_margin, composerStartRestartGroup, 0), 6, null), composerStartRestartGroup, ((i7 >> 6) & 14) | (i7 & 112) | ((i7 >> 21) & 896));
                composer2 = composerStartRestartGroup;
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            AnimatedVisibilityKt.AnimatedVisibility(z3, boxScopeInstance.align(Modifier.INSTANCE, companion2.getBottomEnd()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1514259999, true, new Function3() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ze.a(g20Var, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, ((i7 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ze.a(yeVar, z, z2, z3, z4, z5, bVar, electronicSignatureOptions, j, function1, function0, g20Var, modifier2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final MutableIntState a(ElectronicSignatureOptions electronicSignatureOptions, Context context) {
        return SnapshotIntStateKt.mutableIntStateOf(electronicSignatureOptions.getSignatureColorOptions().option1(context));
    }

    public static final MutableIntState a() {
        return SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final ye a(ye yeVar, com.pspdfkit.internal.ui.dialog.signatures.e.b bVar, MutableIntState mutableIntState, Context context) {
        context.getClass();
        yeVar.setListener(bVar);
        yeVar.setInkColor(mutableIntState.getIntValue());
        yeVar.setBackgroundColor(ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        return yeVar;
    }

    public static final ElectronicSignatureControllerView a(ElectronicSignatureOptions electronicSignatureOptions, final ye yeVar, final MutableIntState mutableIntState, Context context) {
        context.getClass();
        ElectronicSignatureControllerView electronicSignatureControllerView = new ElectronicSignatureControllerView(context);
        electronicSignatureControllerView.setListener(new ElectronicSignatureControllerView.d() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView.d
            public final void a(int i) {
                ze.a(yeVar, mutableIntState, i);
            }
        });
        electronicSignatureControllerView.a(electronicSignatureOptions.getSignatureColorOptions());
        electronicSignatureControllerView.setOrientation(ElectronicSignatureControllerView.e.HORIZONTAL);
        electronicSignatureControllerView.setCurrentlySelectedColor(mutableIntState.getIntValue());
        return electronicSignatureControllerView;
    }

    public static final ye a(ye yeVar, com.pspdfkit.internal.ui.dialog.signatures.e.b bVar, Context context, MutableIntState mutableIntState, Context context2) {
        context2.getClass();
        yeVar.setListener(bVar);
        yeVar.setInkColor(mutableIntState.getIntValue());
        yeVar.setBackgroundColor(ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        return yeVar;
    }

    public static final Unit a(MutableIntState mutableIntState, LayoutCoordinates layoutCoordinates) {
        layoutCoordinates.getClass();
        mutableIntState.setIntValue((int) (layoutCoordinates.mo8273getSizeYbymL2g() & 4294967295L));
        return Unit.INSTANCE;
    }

    public static final void a(final boolean z, final int i, final Function1<? super Integer, Unit> function1, Composer composer, final int i2) {
        int i3;
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(748107374);
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i4 = i3;
        if (composerStartRestartGroup.shouldExecute((i4 & Token.DOTQUERY) != 146, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(748107374, i4, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.CalculateSignatureBoxVerticalPadding (DrawElectronicSignatureScreen.kt:196)");
            }
            Configuration configuration = (Configuration) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            WindowInfo windowInfo = (WindowInfo) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
            Integer numValueOf = Integer.valueOf(i);
            boolean zChanged = ((i4 & 112) == 32) | ((i4 & 14) == 4) | composerStartRestartGroup.changed(windowInfo) | composerStartRestartGroup.changedInstance(configuration) | ((i4 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                a aVar = new a(i, z, windowInfo, configuration, function1, null);
                composerStartRestartGroup.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, (i4 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.ze$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ze.a(z, i, function1, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(ye yeVar, MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        yeVar.setInkColor(i);
    }

    public static final Unit a(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }
}

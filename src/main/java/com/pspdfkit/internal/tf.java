package com.pspdfkit.internal;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.TabIndicatorScope;
import androidx.compose.material3.TabKt;
import androidx.compose.material3.TabRowDefaults;
import androidx.compose.material3.TabRowKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.configuration.signatures.SignatureCreationMode;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class tf {

    @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.signatures.composables.ElectronicSignaturesTabsKt$ElectronicSignaturesTabs$2$1", f = "ElectronicSignaturesTabs.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<SignatureCreationMode, Unit> a;
        public final /* synthetic */ List<SignatureCreationMode> b;
        public final /* synthetic */ MutableIntState c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super SignatureCreationMode, Unit> function1, List<? extends SignatureCreationMode> list, MutableIntState mutableIntState, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = function1;
            this.b = list;
            this.c = mutableIntState;
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
            this.a.invoke(this.b.get(this.c.getIntValue()));
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(List list, long j, long j2, long j3, Function1 function1, Modifier modifier, boolean z, long j4, long j5, Modifier modifier2, Function0 function0, int i, int i2, int i3, Composer composer, int i4) {
        a(list, j, j2, j3, function1, modifier, z, j4, j5, modifier2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static final void a(List<? extends SignatureCreationMode> list, final long j, final long j2, final long j3, Function1<? super SignatureCreationMode, Unit> function1, Modifier modifier, boolean z, final long j4, final long j5, final Modifier modifier2, final Function0<Unit> function0, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        long j6;
        long j7;
        Modifier modifier3;
        boolean z2;
        int i5;
        final List<? extends SignatureCreationMode> list2;
        final Function1<? super SignatureCreationMode, Unit> function2;
        Composer composer2;
        final Modifier modifier4;
        final boolean z3;
        int i6;
        final MutableIntState mutableIntState;
        list.getClass();
        function1.getClass();
        modifier2.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(574900112);
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            j6 = j;
            i4 |= composerStartRestartGroup.changed(j6) ? 32 : 16;
        } else {
            j6 = j;
        }
        if ((i & 384) == 0) {
            j7 = j2;
            i4 |= composerStartRestartGroup.changed(j7) ? 256 : 128;
        } else {
            j7 = j2;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(j3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        int i7 = i3 & 32;
        if (i7 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier3 = modifier;
        } else {
            modifier3 = modifier;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier3) ? 131072 : 65536;
            }
        }
        int i8 = i3 & 64;
        if (i8 != 0) {
            i4 |= 1572864;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
            }
        }
        if ((i & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(j4) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(j5) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i9 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(function0) ? 4 : 2);
        } else {
            i5 = i2;
        }
        boolean z4 = true;
        if (composerStartRestartGroup.shouldExecute(((i9 & 306783379) == 306783378 && (i5 & 3) == 2) ? false : true, i9 & 1)) {
            Modifier modifier5 = i7 != 0 ? Modifier.INSTANCE : modifier3;
            boolean z5 = i8 != 0 ? false : z2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(574900112, i9, i5, "com.pspdfkit.internal.ui.dialog.signatures.composables.ElectronicSignaturesTabs (ElectronicSignaturesTabs.kt:51)");
            }
            Object[] objArr = new Object[0];
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.tf$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return tf.a();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            if (list.size() > 1) {
                composerStartRestartGroup.startReplaceGroup(-1479556298);
                Modifier modifierTestTag = TestTagKt.testTag(modifier5, "PSPDFKIT_ELECTRONIC_SIGNATURES_TABS");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                Modifier modifier6 = modifier5;
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                int i10 = i5;
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
                f2.a(companion2, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(1058718781);
                    Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_arrow_back, composerStartRestartGroup, 0);
                    Modifier modifierClip = ClipKt.clip(BackgroundKt.m589backgroundbw27NRU$default(modifier2, j6, null, 2, null), RoundedCornerShapeKt.getCircleShape());
                    boolean z6 = (i10 & 14) == 4;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z6 || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.tf$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return tf.a(function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    IconKt.m3575Iconww6aTOc(painterPainterResource, "", ClickableKt.m632clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue2, 15, null), j4, composerStartRestartGroup, Painter.$stable | 48 | ((i9 >> 12) & 7168), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(1059120913);
                    composer2.endReplaceGroup();
                }
                int intValue = mutableIntState2.getIntValue();
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(390632307, true, new Function3() { // from class: com.pspdfkit.internal.tf$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return tf.a(mutableIntState2, j5, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                list2 = list;
                z4 = true;
                mutableIntState = mutableIntState2;
                modifier4 = modifier6;
                i6 = i9;
                function2 = function1;
                int i11 = i6 << 3;
                TabRowKt.m4394SecondaryTabRowpAZo6Ak(intValue, companion3, j, j7, composableLambdaRememberComposableLambda, null, ComposableLambdaKt.rememberComposableLambda(-698770295, true, new Function2() { // from class: com.pspdfkit.internal.tf$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return tf.a(list2, mutableIntState, function2, modifier4, j3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, (i11 & 896) | 1597488 | (i11 & 7168), 32);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                modifier4 = modifier5;
                i6 = i9;
                composer2 = composerStartRestartGroup;
                mutableIntState = mutableIntState2;
                list2 = list;
                function2 = function1;
                composer2.startReplaceGroup(-1477469006);
                composer2.endReplaceGroup();
            }
            Unit unit = Unit.INSTANCE;
            if ((i6 & 57344) != 16384) {
                z4 = false;
            }
            boolean zChangedInstance = composer2.changedInstance(list2) | z4 | composer2.changed(mutableIntState);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a(function2, list2, mutableIntState, null);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z5;
        } else {
            list2 = list;
            function2 = function1;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier4 = modifier3;
            z3 = z2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1<? super SignatureCreationMode, Unit> function3 = function2;
            final Modifier modifier7 = modifier4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.tf$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return tf.a(list2, j, j2, j3, function3, modifier7, z3, j4, j5, modifier2, function0, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final MutableIntState a() {
        return SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final Unit a(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final Unit a(MutableIntState mutableIntState, long j, TabIndicatorScope tabIndicatorScope, Composer composer, int i) {
        tabIndicatorScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(390632307, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.ElectronicSignaturesTabs.<anonymous>.<anonymous> (ElectronicSignaturesTabs.kt:77)");
        }
        TabRowDefaults.INSTANCE.m4373SecondaryIndicator9IZ8Weo(TabIndicatorScope.tabIndicatorOffset$default(tabIndicatorScope, Modifier.INSTANCE, mutableIntState.getIntValue(), false, 2, null), Dp.m9687constructorimpl(6), j, composer, (TabRowDefaults.$stable << 9) | 48, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(MutableIntState mutableIntState, int i, Function1 function1, SignatureCreationMode signatureCreationMode) {
        mutableIntState.setIntValue(i);
        function1.invoke(signatureCreationMode);
        return Unit.INSTANCE;
    }

    public static final Unit a(SignatureCreationMode signatureCreationMode, ColumnScope columnScope, Composer composer, int i) {
        columnScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(801778947, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.ElectronicSignaturesTabs.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ElectronicSignaturesTabs.kt:101)");
            }
            TextKt.m4494TextNvy7gAk(signatureCreationMode.name(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(List list, final MutableIntState mutableIntState, final Function1 function1, Modifier modifier, long j, Composer composer, int i) {
        Composer composer2 = composer;
        boolean z = true;
        if (composer2.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-698770295, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.ElectronicSignaturesTabs.<anonymous>.<anonymous> (ElectronicSignaturesTabs.kt:86)");
            }
            final int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final SignatureCreationMode signatureCreationMode = (SignatureCreationMode) obj;
                boolean z2 = mutableIntState.getIntValue() == i2 ? z : false;
                boolean zChanged = composer2.changed(mutableIntState) | composer2.changed(i2) | composer2.changed(function1) | composer2.changed(signatureCreationMode.ordinal());
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.tf$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return tf.a(mutableIntState, i2, function1, signatureCreationMode);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                Modifier modifierClip = ClipKt.clip(modifier, RoundedCornerShapeKt.getCircleShape());
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                TabKt.m4363TabbogVsAg(z2, function0, TestTagKt.testTag(IndicationKt.indication(modifierClip, (MutableInteractionSource) objRememberedValue2, RippleKt.m4031rippleH2RKhps$default(true, 0.0f, j, 2, null)), "PSPDFKIT_ELECTRONIC_TAB_" + signatureCreationMode.name()), false, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(801778947, z, new Function3() { // from class: com.pspdfkit.internal.tf$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return tf.a(signatureCreationMode, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, 12582912, 120);
                composer2 = composer;
                i2 = i3;
                z = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

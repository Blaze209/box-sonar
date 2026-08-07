package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&JU\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "exposedDropdownSize", "Landroidx/compose/ui/Modifier;", "matchTextFieldWidth", "", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu$lambda$4(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, Function3 function3, int i, int i2, Composer composer, int i3) {
        exposedDropdownMenuBoxScope.ExposedDropdownMenu(z, function0, modifier, scrollState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:102:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:105:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x010a  */
    /* JADX WARN: Code duplicated, block: B:86:0x012f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0147  */
    /* JADX WARN: Code duplicated, block: B:93:0x0164  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ad  */
    public final void ExposedDropdownMenu(final boolean z, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        Modifier modifier2;
        ScrollState scrollState2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4;
        boolean z2;
        final Modifier modifier3;
        final ScrollState scrollState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final ScrollState scrollStateRememberScrollState;
        Object objRememberedValue;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        final MutableState mutableState;
        Object objRememberedValue3;
        int i4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1576205770);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,content)196@8241L42:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    scrollState2 = scrollState;
                    int i7 = composerStartRestartGroup.changed(scrollState2) ? 2048 : 1024;
                    i3 |= i7;
                } else {
                    scrollState2 = scrollState;
                }
                i3 |= i7;
            } else {
                scrollState2 = scrollState;
            }
            if ((i & 24576) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            } else {
                function4 = function3;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "184@7740L21");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier3 = companion;
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        modifier3 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1576205770, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:186)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389731840, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(132200795);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "200@8443L51,201@8534L7,203@8651L147,210@8968L337,207@8812L493");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389738313, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density = (Density) objConsume;
                        long jM9758getZeroRKDOV3M = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389745065, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5 = function4;
                        ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function1, new DropdownMenuPositionProvider(jM9758getZeroRKDOV3M, density, (Function2) objRememberedValue3, null), ComposableLambdaKt.rememberComposableLambda(1604457564, true, new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$3(mutableTransitionState, mutableState, scrollStateRememberScrollState, this, modifier3, function5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(123836716);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scrollState3 = scrollStateRememberScrollState;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    modifier3 = modifier2;
                }
                scrollStateRememberScrollState = scrollState2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1576205770, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:186)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389731840, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(132200795);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "200@8443L51,201@8534L7,203@8651L147,210@8968L337,207@8812L493");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389738313, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density2 = (Density) objConsume2;
                    long jM9758getZeroRKDOV3M2 = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389745065, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function3 function6 = function4;
                    ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function1, new DropdownMenuPositionProvider(jM9758getZeroRKDOV3M2, density2, (Function2) objRememberedValue3, null), ComposableLambdaKt.rememberComposableLambda(1604457564, true, new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$3(mutableTransitionState, mutableState, scrollStateRememberScrollState, this, modifier3, function6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(132200795);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "200@8443L51,201@8534L7,203@8651L147,210@8968L337,207@8812L493");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389738313, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density3 = (Density) objConsume3;
                    long jM9758getZeroRKDOV3M3 = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389745065, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function3 function7 = function4;
                    ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function1, new DropdownMenuPositionProvider(jM9758getZeroRKDOV3M3, density3, (Function2) objRememberedValue3, null), ComposableLambdaKt.rememberComposableLambda(1604457564, true, new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$3(mutableTransitionState, mutableState, scrollStateRememberScrollState, this, modifier3, function7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scrollState3 = scrollStateRememberScrollState;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState3 = scrollState2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$4(this.f$0, z, function0, modifier4, scrollState3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                scrollState2 = scrollState;
                if (composerStartRestartGroup.changed(scrollState2)) {
                }
                i3 |= i7;
            } else {
                scrollState2 = scrollState;
            }
            i3 |= i7;
        } else {
            scrollState2 = scrollState;
        }
        if ((i & 24576) == 0) {
            function4 = function3;
            if (composerStartRestartGroup.changedInstance(function4)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        } else {
            function4 = function3;
        }
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "184@7740L21");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    modifier3 = companion;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                } else {
                    modifier3 = companion;
                    scrollStateRememberScrollState = scrollState2;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    modifier3 = companion;
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                } else {
                    modifier3 = companion;
                    scrollStateRememberScrollState = scrollState2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1576205770, i3, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:186)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389731840, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MutableTransitionState(false);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableTransitionState = (MutableTransitionState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
            if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(132200795);
                ComposerKt.sourceInformation(composerStartRestartGroup, "200@8443L51,201@8534L7,203@8651L147,210@8968L337,207@8812L493");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389738313, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density4 = (Density) objConsume4;
                long jM9758getZeroRKDOV3M4 = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389745065, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function3 function8 = function4;
                ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function1, new DropdownMenuPositionProvider(jM9758getZeroRKDOV3M4, density4, (Function2) objRememberedValue3, null), ComposableLambdaKt.rememberComposableLambda(1604457564, true, new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$3(mutableTransitionState, mutableState, scrollStateRememberScrollState, this, modifier3, function8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(132200795);
                ComposerKt.sourceInformation(composerStartRestartGroup, "200@8443L51,201@8534L7,203@8651L147,210@8968L337,207@8812L493");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389738313, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density5 = (Density) objConsume5;
                long jM9758getZeroRKDOV3M5 = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1389745065, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function3 function9 = function4;
                ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function1, new DropdownMenuPositionProvider(jM9758getZeroRKDOV3M5, density5, (Function2) objRememberedValue3, null), ComposableLambdaKt.rememberComposableLambda(1604457564, true, new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$3(mutableTransitionState, mutableState, scrollStateRememberScrollState, this, modifier3, function9, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scrollState3 = scrollStateRememberScrollState;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            scrollState3 = scrollState2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$4(this.f$0, z, function0, modifier5, scrollState3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu$lambda$2$0(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m7216boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu$lambda$3(MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C211@8986L305:ExposedDropdownMenu.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1604457564, i, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:211)");
            }
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState, exposedDropdownSize$default(exposedDropdownMenuBoxScope, modifier, false, 1, null), function3, composer, MutableTransitionState.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

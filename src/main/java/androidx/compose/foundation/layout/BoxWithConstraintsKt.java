package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: BoxWithConstraints.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BoxWithConstraintsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxWithConstraints$lambda$1(Modifier modifier, Alignment alignment, boolean z, Function3 function3, int i, int i2, Composer composer, int i3) {
        BoxWithConstraints(modifier, alignment, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    public static final void BoxWithConstraints(Modifier modifier, Alignment alignment, boolean z, final Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Alignment alignment2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        Modifier.Companion companion;
        Alignment topStart;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy;
        boolean zChanged;
        Object objRememberedValue;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(380139498);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxWithConstraints)N(modifier,contentAlignment,propagateMinConstraints,content)63@3275L271,63@3248L298:BoxWithConstraints.kt#2w3rfo");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                alignment2 = alignment;
                i3 |= composerStartRestartGroup.changed(alignment2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    topStart = alignment2;
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i8 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(380139498, i3, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:61)");
                    }
                    measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, z2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 241849337, "CC(remember):BoxWithConstraints.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(measurePolicyMaybeCachedBoxMeasurePolicy) | ((i3 & 7168) == 2048);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SubcomposeLayoutKt.SubcomposeLayout(companion, (Function2) objRememberedValue, composerStartRestartGroup, i3 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final Alignment alignment3 = topStart;
                    final boolean z4 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxWithConstraintsKt.BoxWithConstraints$lambda$1(modifier3, alignment3, z4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                topStart = alignment2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(380139498, i3, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:61)");
                }
                measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, z2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 241849337, "CC(remember):BoxWithConstraints.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(measurePolicyMaybeCachedBoxMeasurePolicy) | ((i3 & 7168) == 2048);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SubcomposeLayoutKt.SubcomposeLayout(companion, (Function2) objRememberedValue, composerStartRestartGroup, i3 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = companion;
                final Alignment alignment4 = topStart;
                final boolean z5 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxWithConstraintsKt.BoxWithConstraints$lambda$1(modifier4, alignment4, z5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        alignment2 = alignment;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                topStart = alignment2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(380139498, i3, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:61)");
                }
                measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, z2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 241849337, "CC(remember):BoxWithConstraints.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(measurePolicyMaybeCachedBoxMeasurePolicy) | ((i3 & 7168) == 2048);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SubcomposeLayoutKt.SubcomposeLayout(companion, (Function2) objRememberedValue, composerStartRestartGroup, i3 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = companion;
                final Alignment alignment5 = topStart;
                final boolean z6 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxWithConstraintsKt.BoxWithConstraints$lambda$1(modifier5, alignment5, z6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            topStart = alignment2;
        } else {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i8 != 0) {
                topStart = Alignment.INSTANCE.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i4 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(380139498, i3, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:61)");
            }
            measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, z2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 241849337, "CC(remember):BoxWithConstraints.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(measurePolicyMaybeCachedBoxMeasurePolicy) | ((i3 & 7168) == 2048);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SubcomposeLayoutKt.SubcomposeLayout(companion, (Function2) objRememberedValue, composerStartRestartGroup, i3 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = companion;
            final Alignment alignment6 = topStart;
            final boolean z7 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxWithConstraintsKt.BoxWithConstraints$lambda$1(modifier6, alignment6, z7, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult BoxWithConstraints$lambda$0$0(MeasurePolicy measurePolicy, final Function3 function3, SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        final BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = new BoxWithConstraintsScopeImpl(subcomposeMeasureScope, constraints.getValue(), null);
        return measurePolicy.mo344measure3p2s80s(subcomposeMeasureScope, subcomposeMeasureScope.subcompose(Unit.INSTANCE, ComposableLambdaKt.composableLambdaInstance(-431986394, true, new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0$0(function3, boxWithConstraintsScopeImpl, (Composer) obj, ((Integer) obj2).intValue());
            }
        })), constraints.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxWithConstraints$lambda$0$0$0(Function3 function3, BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@3463L9:BoxWithConstraints.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-431986394, i, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:66)");
            }
            function3.invoke(boxWithConstraintsScopeImpl, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

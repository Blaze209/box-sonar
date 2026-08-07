package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Divider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "DividerAlpha", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Divider_oMI9zvI$lambda$0(Modifier modifier, long j, float f, float f2, int i, int i2, Composer composer, int i3) {
        m2381DivideroMI9zvI(modifier, j, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af A[PHI: r2 r4 r7 r9
      0x00af: PHI (r2v10 androidx.compose.ui.Modifier) = (r2v6 androidx.compose.ui.Modifier), (r2v12 androidx.compose.ui.Modifier) binds: [B:69:0x00e4, B:59:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00af: PHI (r4v31 int) = (r4v13 int), (r4v32 int) binds: [B:69:0x00e4, B:59:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00af: PHI (r7v8 long) = (r7v4 long), (r7v1 long) binds: [B:69:0x00e4, B:59:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00af: PHI (r9v8 float) = (r9v5 float), (r9v2 float) binds: [B:69:0x00e4, B:59:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:76:0x0101  */
    /* JADX WARN: Code duplicated, block: B:77:0x0106  */
    /* JADX WARN: Code duplicated, block: B:80:0x0126  */
    /* JADX WARN: Code duplicated, block: B:81:0x0157  */
    /* JADX WARN: Code duplicated, block: B:84:0x0187  */
    /* JADX WARN: Code duplicated, block: B:86:0x018d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0199  */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Divider-oMI9zvI, reason: not valid java name */
    public static final void m2381DivideroMI9zvI(Modifier modifier, long j, float f, float f2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM6813copywmQWz5c$default;
        float fM9687constructorimpl;
        int i4;
        float f3;
        int i5;
        boolean z;
        Modifier.Companion companion;
        final float f4;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM9687constructorimpl2;
        Modifier.Companion companionM1222paddingqDBjuR0$default;
        float fM9687constructorimpl3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249392198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Divider)N(modifier,color:c#ui.graphics.Color,thickness:c#ui.unit.Dp,startIndent:c#ui.unit.Dp)63@2271L94:Divider.kt#jmzs0o");
        int i6 = i2 & 1;
        if (i6 != 0) {
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
            jM6813copywmQWz5c$default = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(jM6813copywmQWz5c$default)) ? 32 : 16;
        } else {
            jM6813copywmQWz5c$default = j;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                fM9687constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM9687constructorimpl) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    f3 = f2;
                    if (composerStartRestartGroup.changed(f3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@1841L6");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -113;
                        }
                        if (i7 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(1);
                        }
                        if (i4 != 0) {
                            fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1249392198, i3, -1, "androidx.compose.material.Divider (Divider.kt:50)");
                        }
                        if (fM9687constructorimpl2 != 0.0f) {
                            companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, fM9687constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                        }
                        if (Dp.m9692equalsimpl0(fM9687constructorimpl, Dp.INSTANCE.m9705getHairlineD9Ej5fM())) {
                            composerStartRestartGroup.startReplaceGroup(-455979798);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "59@2198L7");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            fM9687constructorimpl3 = Dp.m9687constructorimpl(1.0f / ((Density) objConsume).getDensity());
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-455913241);
                            composerStartRestartGroup.endReplaceGroup();
                            fM9687constructorimpl3 = fM9687constructorimpl;
                        }
                        BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM1222paddingqDBjuR0$default), 0.0f, 1, null), fM9687constructorimpl3), jM6813copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f4 = fM9687constructorimpl2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        companion = modifier2;
                    }
                    fM9687constructorimpl2 = f3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1249392198, i3, -1, "androidx.compose.material.Divider (Divider.kt:50)");
                    }
                    if (fM9687constructorimpl2 != 0.0f) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, fM9687constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    if (Dp.m9692equalsimpl0(fM9687constructorimpl, Dp.INSTANCE.m9705getHairlineD9Ej5fM())) {
                        composerStartRestartGroup.startReplaceGroup(-455979798);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "59@2198L7");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(1.0f / ((Density) objConsume2).getDensity());
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-455913241);
                        composerStartRestartGroup.endReplaceGroup();
                        fM9687constructorimpl3 = fM9687constructorimpl;
                    }
                    BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM1222paddingqDBjuR0$default), 0.0f, 1, null), fM9687constructorimpl3), jM6813copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f4 = fM9687constructorimpl2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    f4 = f3;
                }
                f5 = fM9687constructorimpl;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final long j2 = jM6813copywmQWz5c$default;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DividerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DividerKt.Divider_oMI9zvI$lambda$0(modifier3, j2, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            f3 = f2;
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@1841L6");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl2 = f3;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl2 = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249392198, i3, -1, "androidx.compose.material.Divider (Divider.kt:50)");
                }
                if (fM9687constructorimpl2 != 0.0f) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, fM9687constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                if (Dp.m9692equalsimpl0(fM9687constructorimpl, Dp.INSTANCE.m9705getHairlineD9Ej5fM())) {
                    composerStartRestartGroup.startReplaceGroup(-455979798);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "59@2198L7");
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM9687constructorimpl3 = Dp.m9687constructorimpl(1.0f / ((Density) objConsume3).getDensity());
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-455913241);
                    composerStartRestartGroup.endReplaceGroup();
                    fM9687constructorimpl3 = fM9687constructorimpl;
                }
                BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM1222paddingqDBjuR0$default), 0.0f, 1, null), fM9687constructorimpl3), jM6813copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f4 = fM9687constructorimpl2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                f4 = f3;
            }
            f5 = fM9687constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = companion;
                final long j3 = jM6813copywmQWz5c$default;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DividerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DividerKt.Divider_oMI9zvI$lambda$0(modifier4, j3, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        fM9687constructorimpl = f;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                f3 = f2;
                if (composerStartRestartGroup.changed(f3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@1841L6");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl2 = f3;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl2 = f3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249392198, i3, -1, "androidx.compose.material.Divider (Divider.kt:50)");
                }
                if (fM9687constructorimpl2 != 0.0f) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, fM9687constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                if (Dp.m9692equalsimpl0(fM9687constructorimpl, Dp.INSTANCE.m9705getHairlineD9Ej5fM())) {
                    composerStartRestartGroup.startReplaceGroup(-455979798);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "59@2198L7");
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM9687constructorimpl3 = Dp.m9687constructorimpl(1.0f / ((Density) objConsume4).getDensity());
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-455913241);
                    composerStartRestartGroup.endReplaceGroup();
                    fM9687constructorimpl3 = fM9687constructorimpl;
                }
                BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM1222paddingqDBjuR0$default), 0.0f, 1, null), fM9687constructorimpl3), jM6813copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f4 = fM9687constructorimpl2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                f4 = f3;
            }
            f5 = fM9687constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = companion;
                final long j4 = jM6813copywmQWz5c$default;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DividerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DividerKt.Divider_oMI9zvI$lambda$0(modifier5, j4, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        f3 = f2;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "47@1841L6");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -113;
                }
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(1);
                }
                if (i4 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl2 = f3;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -113;
                }
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(1);
                }
                if (i4 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl2 = f3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249392198, i3, -1, "androidx.compose.material.Divider (Divider.kt:50)");
            }
            if (fM9687constructorimpl2 != 0.0f) {
                companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, fM9687constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            if (Dp.m9692equalsimpl0(fM9687constructorimpl, Dp.INSTANCE.m9705getHairlineD9Ej5fM())) {
                composerStartRestartGroup.startReplaceGroup(-455979798);
                ComposerKt.sourceInformation(composerStartRestartGroup, "59@2198L7");
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM9687constructorimpl3 = Dp.m9687constructorimpl(1.0f / ((Density) objConsume5).getDensity());
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-455913241);
                composerStartRestartGroup.endReplaceGroup();
                fM9687constructorimpl3 = fM9687constructorimpl;
            }
            BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM1222paddingqDBjuR0$default), 0.0f, 1, null), fM9687constructorimpl3), jM6813copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f4 = fM9687constructorimpl2;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            f4 = f3;
        }
        f5 = fM9687constructorimpl;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = companion;
            final long j5 = jM6813copywmQWz5c$default;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DividerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DividerKt.Divider_oMI9zvI$lambda$0(modifier6, j5, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

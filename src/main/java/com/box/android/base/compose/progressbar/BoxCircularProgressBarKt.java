package com.box.android.base.compose.progressbar;

import androidx.compose.material3.ProgressIndicatorDefaults;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.TestTagKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: BoxCircularProgressBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"BoxCircularProgressBar", "", "modifier", "Landroidx/compose/ui/Modifier;", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "progress", "Lkotlin/Function0;", "", "BoxCircularProgressBar-O8KfPlw", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JJFILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreviewBoxCircularProgressBar", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxCircularProgressBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxCircularProgressBar_O8KfPlw$lambda$1(Modifier modifier, String str, long j, long j2, float f, int i, Function0 function0, int i2, int i3, Composer composer, int i4) {
        m11734BoxCircularProgressBarO8KfPlw(modifier, str, j, j2, f, i, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewBoxCircularProgressBar$lambda$0(int i, Composer composer, int i2) {
        PreviewBoxCircularProgressBar(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0134  */
    /* JADX WARN: Code duplicated, block: B:102:0x0139  */
    /* JADX WARN: Code duplicated, block: B:105:0x013d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0142  */
    /* JADX WARN: Code duplicated, block: B:110:0x0151  */
    /* JADX WARN: Code duplicated, block: B:113:0x015b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0164  */
    /* JADX WARN: Code duplicated, block: B:117:0x0169  */
    /* JADX WARN: Code duplicated, block: B:118:0x0172  */
    /* JADX WARN: Code duplicated, block: B:121:0x017a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0184  */
    /* JADX WARN: Code duplicated, block: B:125:0x0197  */
    /* JADX WARN: Code duplicated, block: B:128:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:138:0x0223  */
    /* JADX WARN: Code duplicated, block: B:140:0x022e  */
    /* JADX WARN: Code duplicated, block: B:143:0x0241  */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x0105  */
    /* JADX INFO: renamed from: BoxCircularProgressBar-O8KfPlw, reason: not valid java name */
    public static final void m11734BoxCircularProgressBarO8KfPlw(Modifier modifier, String str, long j, long j2, float f, int i, Function0<Float> function0, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        String str2;
        long jM11533getMainActiveControl0d7_KjU;
        int i5;
        long jM6850getUnspecified0d7_KjU;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        boolean z;
        Composer composer2;
        final Function0<Float> function1;
        final Modifier modifier3;
        final String str3;
        final long j3;
        final long j4;
        final float f3;
        final int i10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        float fM3976getCircularStrokeWidthD9Ej5fM;
        int iM3973getCircularDeterminateStrokeCapKaPHkGw;
        float f4;
        boolean z2;
        boolean z3;
        int i11;
        int i12;
        long j5;
        long j6;
        Modifier.Companion companionTestTag;
        Modifier modifierThen;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(1529607614);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxCircularProgressBar)N(modifier,testTag,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,strokeCap:c#ui.graphics.StrokeCap,progress):BoxCircularProgressBar.kt#s0fs70");
        int i13 = i3 & 1;
        if (i13 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i14 = i3 & 2;
        if (i14 == 0) {
            if ((i2 & 48) == 0) {
                str2 = str;
                i4 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    int i15 = composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) ? 256 : 128;
                    i4 |= i15;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i4 |= i15;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    jM6850getUnspecified0d7_KjU = j2;
                    if (composerStartRestartGroup.changed(jM6850getUnspecified0d7_KjU)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        f2 = f;
                        int i16 = composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                        i4 |= i16;
                    } else {
                        f2 = f;
                    }
                    i4 |= i16;
                } else {
                    f2 = f;
                }
                if ((196608 & i2) == 0) {
                    if ((i3 & 32) == 0) {
                        i7 = i;
                        int i17 = composerStartRestartGroup.changed(i7) ? 131072 : 65536;
                        i4 |= i17;
                    } else {
                        i7 = i;
                    }
                    i4 |= i17;
                } else {
                    i7 = i;
                }
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "30@1348L6");
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            str2 = null;
                        }
                        if ((i3 & 4) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i4 &= -897;
                        }
                        if (i5 != 0) {
                            jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                        }
                        if ((i3 & 16) != 0) {
                            fM3976getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3976getCircularStrokeWidthD9Ej5fM();
                            i4 &= -57345;
                        } else {
                            fM3976getCircularStrokeWidthD9Ej5fM = f2;
                        }
                        if ((i3 & 32) != 0) {
                            iM3973getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3973getCircularDeterminateStrokeCapKaPHkGw();
                            i4 = (-458753) & i4;
                        } else {
                            iM3973getCircularDeterminateStrokeCapKaPHkGw = i7;
                        }
                        f4 = fM3976getCircularStrokeWidthD9Ej5fM;
                        z2 = false;
                        z3 = true;
                        if (i8 != 0) {
                            i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                            j5 = jM6850getUnspecified0d7_KjU;
                            function0 = null;
                            j6 = jM11533getMainActiveControl0d7_KjU;
                            i11 = 1529607614;
                        } else {
                            i11 = 1529607614;
                            i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                            j5 = jM6850getUnspecified0d7_KjU;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i11, i4, -1, "com.box.android.base.compose.progressbar.BoxCircularProgressBar (BoxCircularProgressBar.kt:35)");
                        }
                        if (str2 == null) {
                            z3 = z2;
                        }
                        if (z3) {
                            Intrinsics.checkNotNull(str2);
                            companionTestTag = TestTagKt.testTag(companion, str2);
                        } else {
                            companionTestTag = Modifier.INSTANCE;
                        }
                        modifierThen = companion.then(companionTestTag);
                        if (function0 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1062054822);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "41@1761L250");
                            composer2 = composerStartRestartGroup;
                            float f5 = f4;
                            long j8 = j6;
                            ProgressIndicatorKt.m3996CircularProgressIndicatorIyT6zlY(function0, modifierThen, j8, f5, j5, i12, 0.0f, composer2, ((i4 >> 18) & 14) | (i4 & 896) | ((i4 >> 3) & 7168) | (57344 & (i4 << 3)) | (i4 & 458752), 64);
                            j6 = j8;
                            f4 = f5;
                            j7 = j5;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            j7 = j5;
                            composerStartRestartGroup.startReplaceGroup(-1061787106);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "50@2033L182");
                            ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(modifierThen, j6, f4, j7, 0, 0.0f, composerStartRestartGroup, ((i4 >> 3) & 112) | ((i4 >> 6) & 896) | (i4 & 7168), 48);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        str3 = str2;
                        i10 = i12;
                        f3 = f4;
                        j4 = j7;
                        function1 = function0;
                        j3 = j6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                        }
                        companion = modifier2;
                        z2 = false;
                        z3 = true;
                        i11 = 1529607614;
                        j5 = jM6850getUnspecified0d7_KjU;
                        i12 = i7;
                        f4 = f2;
                    }
                    j6 = jM11533getMainActiveControl0d7_KjU;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i11, i4, -1, "com.box.android.base.compose.progressbar.BoxCircularProgressBar (BoxCircularProgressBar.kt:35)");
                    }
                    if (str2 == null) {
                        z3 = z2;
                    }
                    if (z3) {
                        Intrinsics.checkNotNull(str2);
                        companionTestTag = TestTagKt.testTag(companion, str2);
                    } else {
                        companionTestTag = Modifier.INSTANCE;
                    }
                    modifierThen = companion.then(companionTestTag);
                    if (function0 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1062054822);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "41@1761L250");
                        composer2 = composerStartRestartGroup;
                        float f6 = f4;
                        long j9 = j6;
                        ProgressIndicatorKt.m3996CircularProgressIndicatorIyT6zlY(function0, modifierThen, j9, f6, j5, i12, 0.0f, composer2, ((i4 >> 18) & 14) | (i4 & 896) | ((i4 >> 3) & 7168) | (57344 & (i4 << 3)) | (i4 & 458752), 64);
                        j6 = j9;
                        f4 = f6;
                        j7 = j5;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        j7 = j5;
                        composerStartRestartGroup.startReplaceGroup(-1061787106);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "50@2033L182");
                        ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(modifierThen, j6, f4, j7, 0, 0.0f, composerStartRestartGroup, ((i4 >> 3) & 112) | ((i4 >> 6) & 896) | (i4 & 7168), 48);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    str3 = str2;
                    i10 = i12;
                    f3 = f4;
                    j4 = j7;
                    function1 = function0;
                    j3 = j6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function1 = function0;
                    modifier3 = modifier2;
                    str3 = str2;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                    j4 = jM6850getUnspecified0d7_KjU;
                    f3 = f2;
                    i10 = i7;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.progressbar.BoxCircularProgressBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxCircularProgressBarKt.BoxCircularProgressBar_O8KfPlw$lambda$1(modifier3, str3, j3, j4, f3, i10, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            jM6850getUnspecified0d7_KjU = j2;
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                    }
                    i4 |= i16;
                } else {
                    f2 = f;
                }
                i4 |= i16;
            } else {
                f2 = f;
            }
            if ((196608 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    i7 = i;
                    if (composerStartRestartGroup.changed(i7)) {
                    }
                    i4 |= i17;
                } else {
                    i7 = i;
                }
                i4 |= i17;
            } else {
                i7 = i;
            }
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "30@1348L6");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        str2 = null;
                    }
                    if ((i3 & 4) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -897;
                    }
                    if (i5 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        fM3976getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3976getCircularStrokeWidthD9Ej5fM();
                        i4 &= -57345;
                    } else {
                        fM3976getCircularStrokeWidthD9Ej5fM = f2;
                    }
                    if ((i3 & 32) != 0) {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3973getCircularDeterminateStrokeCapKaPHkGw();
                        i4 = (-458753) & i4;
                    } else {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = i7;
                    }
                    f4 = fM3976getCircularStrokeWidthD9Ej5fM;
                    z2 = false;
                    z3 = true;
                    if (i8 != 0) {
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        function0 = null;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                        i11 = 1529607614;
                    } else {
                        i11 = 1529607614;
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        str2 = null;
                    }
                    if ((i3 & 4) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -897;
                    }
                    if (i5 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        fM3976getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3976getCircularStrokeWidthD9Ej5fM();
                        i4 &= -57345;
                    } else {
                        fM3976getCircularStrokeWidthD9Ej5fM = f2;
                    }
                    if ((i3 & 32) != 0) {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3973getCircularDeterminateStrokeCapKaPHkGw();
                        i4 = (-458753) & i4;
                    } else {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = i7;
                    }
                    f4 = fM3976getCircularStrokeWidthD9Ej5fM;
                    z2 = false;
                    z3 = true;
                    if (i8 != 0) {
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        function0 = null;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                        i11 = 1529607614;
                    } else {
                        i11 = 1529607614;
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i11, i4, -1, "com.box.android.base.compose.progressbar.BoxCircularProgressBar (BoxCircularProgressBar.kt:35)");
                }
                if (str2 == null) {
                    z3 = z2;
                }
                if (z3) {
                    Intrinsics.checkNotNull(str2);
                    companionTestTag = TestTagKt.testTag(companion, str2);
                } else {
                    companionTestTag = Modifier.INSTANCE;
                }
                modifierThen = companion.then(companionTestTag);
                if (function0 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1062054822);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "41@1761L250");
                    composer2 = composerStartRestartGroup;
                    float f7 = f4;
                    long j10 = j6;
                    ProgressIndicatorKt.m3996CircularProgressIndicatorIyT6zlY(function0, modifierThen, j10, f7, j5, i12, 0.0f, composer2, ((i4 >> 18) & 14) | (i4 & 896) | ((i4 >> 3) & 7168) | (57344 & (i4 << 3)) | (i4 & 458752), 64);
                    j6 = j10;
                    f4 = f7;
                    j7 = j5;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    j7 = j5;
                    composerStartRestartGroup.startReplaceGroup(-1061787106);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "50@2033L182");
                    ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(modifierThen, j6, f4, j7, 0, 0.0f, composerStartRestartGroup, ((i4 >> 3) & 112) | ((i4 >> 6) & 896) | (i4 & 7168), 48);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                str3 = str2;
                i10 = i12;
                f3 = f4;
                j4 = j7;
                function1 = function0;
                j3 = j6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function1 = function0;
                modifier3 = modifier2;
                str3 = str2;
                j3 = jM11533getMainActiveControl0d7_KjU;
                j4 = jM6850getUnspecified0d7_KjU;
                f3 = f2;
                i10 = i7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.progressbar.BoxCircularProgressBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxCircularProgressBarKt.BoxCircularProgressBar_O8KfPlw$lambda$1(modifier3, str3, j3, j4, f3, i10, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        str2 = str;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                jM11533getMainActiveControl0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                }
                i4 |= i15;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i4 |= i15;
        } else {
            jM11533getMainActiveControl0d7_KjU = j;
        }
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 3072) == 0) {
                jM6850getUnspecified0d7_KjU = j2;
                if (composerStartRestartGroup.changed(jM6850getUnspecified0d7_KjU)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                    }
                    i4 |= i16;
                } else {
                    f2 = f;
                }
                i4 |= i16;
            } else {
                f2 = f;
            }
            if ((196608 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    i7 = i;
                    if (composerStartRestartGroup.changed(i7)) {
                    }
                    i4 |= i17;
                } else {
                    i7 = i;
                }
                i4 |= i17;
            } else {
                i7 = i;
            }
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "30@1348L6");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        str2 = null;
                    }
                    if ((i3 & 4) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -897;
                    }
                    if (i5 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        fM3976getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3976getCircularStrokeWidthD9Ej5fM();
                        i4 &= -57345;
                    } else {
                        fM3976getCircularStrokeWidthD9Ej5fM = f2;
                    }
                    if ((i3 & 32) != 0) {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3973getCircularDeterminateStrokeCapKaPHkGw();
                        i4 = (-458753) & i4;
                    } else {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = i7;
                    }
                    f4 = fM3976getCircularStrokeWidthD9Ej5fM;
                    z2 = false;
                    z3 = true;
                    if (i8 != 0) {
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        function0 = null;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                        i11 = 1529607614;
                    } else {
                        i11 = 1529607614;
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        str2 = null;
                    }
                    if ((i3 & 4) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -897;
                    }
                    if (i5 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i3 & 16) != 0) {
                        fM3976getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3976getCircularStrokeWidthD9Ej5fM();
                        i4 &= -57345;
                    } else {
                        fM3976getCircularStrokeWidthD9Ej5fM = f2;
                    }
                    if ((i3 & 32) != 0) {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3973getCircularDeterminateStrokeCapKaPHkGw();
                        i4 = (-458753) & i4;
                    } else {
                        iM3973getCircularDeterminateStrokeCapKaPHkGw = i7;
                    }
                    f4 = fM3976getCircularStrokeWidthD9Ej5fM;
                    z2 = false;
                    z3 = true;
                    if (i8 != 0) {
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        function0 = null;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                        i11 = 1529607614;
                    } else {
                        i11 = 1529607614;
                        i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                        j5 = jM6850getUnspecified0d7_KjU;
                        j6 = jM11533getMainActiveControl0d7_KjU;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i11, i4, -1, "com.box.android.base.compose.progressbar.BoxCircularProgressBar (BoxCircularProgressBar.kt:35)");
                }
                if (str2 == null) {
                    z3 = z2;
                }
                if (z3) {
                    Intrinsics.checkNotNull(str2);
                    companionTestTag = TestTagKt.testTag(companion, str2);
                } else {
                    companionTestTag = Modifier.INSTANCE;
                }
                modifierThen = companion.then(companionTestTag);
                if (function0 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1062054822);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "41@1761L250");
                    composer2 = composerStartRestartGroup;
                    float f8 = f4;
                    long j11 = j6;
                    ProgressIndicatorKt.m3996CircularProgressIndicatorIyT6zlY(function0, modifierThen, j11, f8, j5, i12, 0.0f, composer2, ((i4 >> 18) & 14) | (i4 & 896) | ((i4 >> 3) & 7168) | (57344 & (i4 << 3)) | (i4 & 458752), 64);
                    j6 = j11;
                    f4 = f8;
                    j7 = j5;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    j7 = j5;
                    composerStartRestartGroup.startReplaceGroup(-1061787106);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "50@2033L182");
                    ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(modifierThen, j6, f4, j7, 0, 0.0f, composerStartRestartGroup, ((i4 >> 3) & 112) | ((i4 >> 6) & 896) | (i4 & 7168), 48);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                str3 = str2;
                i10 = i12;
                f3 = f4;
                j4 = j7;
                function1 = function0;
                j3 = j6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function1 = function0;
                modifier3 = modifier2;
                str3 = str2;
                j3 = jM11533getMainActiveControl0d7_KjU;
                j4 = jM6850getUnspecified0d7_KjU;
                f3 = f2;
                i10 = i7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.progressbar.BoxCircularProgressBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxCircularProgressBarKt.BoxCircularProgressBar_O8KfPlw$lambda$1(modifier3, str3, j3, j4, f3, i10, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        jM6850getUnspecified0d7_KjU = j2;
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                }
                i4 |= i16;
            } else {
                f2 = f;
            }
            i4 |= i16;
        } else {
            f2 = f;
        }
        if ((196608 & i2) == 0) {
            if ((i3 & 32) == 0) {
                i7 = i;
                if (composerStartRestartGroup.changed(i7)) {
                }
                i4 |= i17;
            } else {
                i7 = i;
            }
            i4 |= i17;
        } else {
            i7 = i;
        }
        i8 = i3 & 64;
        if (i8 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i4 |= i9;
        }
        if ((i4 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "30@1348L6");
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    str2 = null;
                }
                if ((i3 & 4) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i4 &= -897;
                }
                if (i5 != 0) {
                    jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                }
                if ((i3 & 16) != 0) {
                    fM3976getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3976getCircularStrokeWidthD9Ej5fM();
                    i4 &= -57345;
                } else {
                    fM3976getCircularStrokeWidthD9Ej5fM = f2;
                }
                if ((i3 & 32) != 0) {
                    iM3973getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3973getCircularDeterminateStrokeCapKaPHkGw();
                    i4 = (-458753) & i4;
                } else {
                    iM3973getCircularDeterminateStrokeCapKaPHkGw = i7;
                }
                f4 = fM3976getCircularStrokeWidthD9Ej5fM;
                z2 = false;
                z3 = true;
                if (i8 != 0) {
                    i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                    j5 = jM6850getUnspecified0d7_KjU;
                    function0 = null;
                    j6 = jM11533getMainActiveControl0d7_KjU;
                    i11 = 1529607614;
                } else {
                    i11 = 1529607614;
                    i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                    j5 = jM6850getUnspecified0d7_KjU;
                    j6 = jM11533getMainActiveControl0d7_KjU;
                }
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    str2 = null;
                }
                if ((i3 & 4) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i4 &= -897;
                }
                if (i5 != 0) {
                    jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                }
                if ((i3 & 16) != 0) {
                    fM3976getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3976getCircularStrokeWidthD9Ej5fM();
                    i4 &= -57345;
                } else {
                    fM3976getCircularStrokeWidthD9Ej5fM = f2;
                }
                if ((i3 & 32) != 0) {
                    iM3973getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3973getCircularDeterminateStrokeCapKaPHkGw();
                    i4 = (-458753) & i4;
                } else {
                    iM3973getCircularDeterminateStrokeCapKaPHkGw = i7;
                }
                f4 = fM3976getCircularStrokeWidthD9Ej5fM;
                z2 = false;
                z3 = true;
                if (i8 != 0) {
                    i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                    j5 = jM6850getUnspecified0d7_KjU;
                    function0 = null;
                    j6 = jM11533getMainActiveControl0d7_KjU;
                    i11 = 1529607614;
                } else {
                    i11 = 1529607614;
                    i12 = iM3973getCircularDeterminateStrokeCapKaPHkGw;
                    j5 = jM6850getUnspecified0d7_KjU;
                    j6 = jM11533getMainActiveControl0d7_KjU;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i11, i4, -1, "com.box.android.base.compose.progressbar.BoxCircularProgressBar (BoxCircularProgressBar.kt:35)");
            }
            if (str2 == null) {
                z3 = z2;
            }
            if (z3) {
                Intrinsics.checkNotNull(str2);
                companionTestTag = TestTagKt.testTag(companion, str2);
            } else {
                companionTestTag = Modifier.INSTANCE;
            }
            modifierThen = companion.then(companionTestTag);
            if (function0 != null) {
                composerStartRestartGroup.startReplaceGroup(-1062054822);
                ComposerKt.sourceInformation(composerStartRestartGroup, "41@1761L250");
                composer2 = composerStartRestartGroup;
                float f9 = f4;
                long j12 = j6;
                ProgressIndicatorKt.m3996CircularProgressIndicatorIyT6zlY(function0, modifierThen, j12, f9, j5, i12, 0.0f, composer2, ((i4 >> 18) & 14) | (i4 & 896) | ((i4 >> 3) & 7168) | (57344 & (i4 << 3)) | (i4 & 458752), 64);
                j6 = j12;
                f4 = f9;
                j7 = j5;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                j7 = j5;
                composerStartRestartGroup.startReplaceGroup(-1061787106);
                ComposerKt.sourceInformation(composerStartRestartGroup, "50@2033L182");
                ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(modifierThen, j6, f4, j7, 0, 0.0f, composerStartRestartGroup, ((i4 >> 3) & 112) | ((i4 >> 6) & 896) | (i4 & 7168), 48);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            str3 = str2;
            i10 = i12;
            f3 = f4;
            j4 = j7;
            function1 = function0;
            j3 = j6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function1 = function0;
            modifier3 = modifier2;
            str3 = str2;
            j3 = jM11533getMainActiveControl0d7_KjU;
            j4 = jM6850getUnspecified0d7_KjU;
            f3 = f2;
            i10 = i7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.progressbar.BoxCircularProgressBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxCircularProgressBarKt.BoxCircularProgressBar_O8KfPlw$lambda$1(modifier3, str3, j3, j4, f3, i10, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PreviewBoxCircularProgressBar(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(556660712);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewBoxCircularProgressBar)64@2372L49:BoxCircularProgressBar.kt#s0fs70");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(556660712, i, -1, "com.box.android.base.compose.progressbar.PreviewBoxCircularProgressBar (BoxCircularProgressBar.kt:63)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxCircularProgressBarKt.INSTANCE.m11736getLambda$1425929549$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.progressbar.BoxCircularProgressBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxCircularProgressBarKt.PreviewBoxCircularProgressBar$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

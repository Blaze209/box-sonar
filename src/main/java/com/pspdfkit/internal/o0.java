package com.pspdfkit.internal;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 {
    public static final Unit a(Modifier modifier, int i, float f, float f2, long j, long j2, float f3, int i2, int i3, Composer composer, int i4) {
        a(modifier, i, f, f2, j, j2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0130  */
    /* JADX WARN: Code duplicated, block: B:103:0x0137  */
    /* JADX WARN: Code duplicated, block: B:106:0x019d  */
    /* JADX WARN: Code duplicated, block: B:109:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:112:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:113:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:116:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:120:0x0200  */
    /* JADX WARN: Code duplicated, block: B:121:0x0203  */
    /* JADX WARN: Code duplicated, block: B:124:0x0211  */
    /* JADX WARN: Code duplicated, block: B:125:0x0214  */
    /* JADX WARN: Code duplicated, block: B:129:0x021f  */
    /* JADX WARN: Code duplicated, block: B:132:0x0229  */
    /* JADX WARN: Code duplicated, block: B:134:0x022f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0253  */
    /* JADX WARN: Code duplicated, block: B:139:0x0265  */
    /* JADX WARN: Code duplicated, block: B:142:0x027b  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0050  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    /* JADX WARN: Code duplicated, block: B:40:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:89:0x0105  */
    /* JADX WARN: Code duplicated, block: B:91:0x0109  */
    /* JADX WARN: Code duplicated, block: B:92:0x0111  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:95:0x011b  */
    /* JADX WARN: Code duplicated, block: B:97:0x011e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0129  */
    public static final void a(Modifier modifier, int i, float f, float f2, long j, long j2, float f3, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f4;
        int i9;
        int i10;
        long j3;
        int i11;
        int i12;
        long jColor;
        int i13;
        int i14;
        float f5;
        int i15;
        boolean z;
        final float f6;
        final long j4;
        final Modifier modifier2;
        Composer composer2;
        final int i16;
        final long j5;
        final float f7;
        final float f8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        long jM6851getWhite0d7_KjU;
        float fM9687constructorimpl3;
        final float f9;
        final State<Float> stateAnimateFloat;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Object objRememberedValue3;
        Composer composerStartRestartGroup = composer.startRestartGroup(389896580);
        int i17 = i3 & 1;
        if (i17 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i18 = i3 & 2;
        if (i18 == 0) {
            if ((i2 & 48) == 0) {
                i5 = i;
                i4 |= composerStartRestartGroup.changed(i5) ? 32 : 16;
            }
            i6 = i3 & 4;
            if (i6 != 0) {
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i4 |= i7;
                }
                i8 = i3 & 8;
                if (i8 != 0) {
                    if ((i2 & 3072) == 0) {
                        f4 = f2;
                        if (composerStartRestartGroup.changed(f4)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 16;
                    if (i10 != 0) {
                        i4 |= 24576;
                        j3 = j;
                    } else {
                        j3 = j;
                        if ((i2 & 24576) == 0) {
                            if (composerStartRestartGroup.changed(j3)) {
                                i11 = 16384;
                            } else {
                                i11 = 8192;
                            }
                            i4 |= i11;
                        }
                    }
                    i12 = i3 & 32;
                    if (i12 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        jColor = j2;
                    } else {
                        jColor = j2;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(jColor)) {
                                i13 = 131072;
                            } else {
                                i13 = 65536;
                            }
                            i4 |= i13;
                        }
                    }
                    i14 = i3 & 64;
                    if (i14 != 0) {
                        i4 |= 1572864;
                        f5 = f3;
                    } else {
                        f5 = f3;
                        if ((i2 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(f5)) {
                                i15 = 1048576;
                            } else {
                                i15 = 524288;
                            }
                            i4 |= i15;
                        }
                    }
                    if ((i4 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i18 != 0) {
                            i5 = 3;
                        }
                        if (i6 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(7);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        if (i8 != 0) {
                            fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
                        } else {
                            fM9687constructorimpl2 = f4;
                        }
                        if (i10 != 0) {
                            jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                        } else {
                            jM6851getWhite0d7_KjU = j3;
                        }
                        if (i12 != 0) {
                            jColor = ColorKt.Color(4284507761L);
                        }
                        if (i14 != 0) {
                            fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
                        } else {
                            fM9687constructorimpl3 = f5;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
                        }
                        f9 = fM9687constructorimpl;
                        stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        float fM9701unboximpl = ((Dp) objRememberedValue).m9701unboximpl();
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl), ((Dp) objRememberedValue2).m9701unboximpl());
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Modifier modifier4 = modifier3;
                        if ((i4 & 7168) == 2048) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        boolean z7 = z3 | z2;
                        if ((i4 & 112) == 32) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean zChanged = z7 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
                        if ((458752 & i4) == 131072) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = zChanged | z5 | ((i4 & 57344) == 16384);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z6 || objRememberedValue3 == companion.getEmpty()) {
                            final long j6 = jColor;
                            final float f10 = fM9687constructorimpl2;
                            final int i19 = i5;
                            final long j7 = jM6851getWhite0d7_KjU;
                            objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return o0.a(f9, f10, i19, j6, j7, stateAnimateFloat, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        CanvasKt.Canvas(modifierM1252height3ABfNKs, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composerStartRestartGroup;
                        i16 = i5;
                        f8 = f9;
                        modifier2 = modifier4;
                        f7 = fM9687constructorimpl3;
                        long j8 = jColor;
                        f6 = fM9687constructorimpl2;
                        j4 = j8;
                        j5 = jM6851getWhite0d7_KjU;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        long j9 = jColor;
                        f6 = f4;
                        j4 = j9;
                        modifier2 = modifier;
                        composer2 = composerStartRestartGroup;
                        i16 = i5;
                        j5 = j3;
                        f7 = f5;
                        f8 = f;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 3072;
                f4 = f2;
                i10 = i3 & 16;
                if (i10 != 0) {
                    i4 |= 24576;
                    j3 = j;
                } else {
                    j3 = j;
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i11 = 16384;
                        } else {
                            i11 = 8192;
                        }
                        i4 |= i11;
                    }
                }
                i12 = i3 & 32;
                if (i12 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    jColor = j2;
                } else {
                    jColor = j2;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(jColor)) {
                            i13 = 131072;
                        } else {
                            i13 = 65536;
                        }
                        i4 |= i13;
                    }
                }
                i14 = i3 & 64;
                if (i14 != 0) {
                    i4 |= 1572864;
                    f5 = f3;
                } else {
                    f5 = f3;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i4 |= i15;
                    }
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i18 != 0) {
                        i5 = 3;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(7);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i8 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
                    } else {
                        fM9687constructorimpl2 = f4;
                    }
                    if (i10 != 0) {
                        jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    } else {
                        jM6851getWhite0d7_KjU = j3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(4284507761L);
                    }
                    if (i14 != 0) {
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
                    } else {
                        fM9687constructorimpl3 = f5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
                    }
                    f9 = fM9687constructorimpl;
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    float fM9701unboximpl2 = ((Dp) objRememberedValue).m9701unboximpl();
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl2), ((Dp) objRememberedValue2).m9701unboximpl());
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Modifier modifier5 = modifier3;
                    if ((i4 & 7168) == 2048) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean z8 = z3 | z2;
                    if ((i4 & 112) == 32) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean zChanged2 = z8 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
                    if ((458752 & i4) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = zChanged2 | z5 | ((i4 & 57344) == 16384);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        final long j10 = jColor;
                        final float f11 = fM9687constructorimpl2;
                        final int i110 = i5;
                        final long j11 = jM6851getWhite0d7_KjU;
                        objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return o0.a(f9, f11, i110, j10, j11, stateAnimateFloat, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        final long j12 = jColor;
                        final float f12 = fM9687constructorimpl2;
                        final int i111 = i5;
                        final long j13 = jM6851getWhite0d7_KjU;
                        objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return o0.a(f9, f12, i111, j12, j13, stateAnimateFloat, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    CanvasKt.Canvas(modifierM1252height3ABfNKs2, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    i16 = i5;
                    f8 = f9;
                    modifier2 = modifier5;
                    f7 = fM9687constructorimpl3;
                    long j14 = jColor;
                    f6 = fM9687constructorimpl2;
                    j4 = j14;
                    j5 = jM6851getWhite0d7_KjU;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    long j15 = jColor;
                    f6 = f4;
                    j4 = j15;
                    modifier2 = modifier;
                    composer2 = composerStartRestartGroup;
                    i16 = i5;
                    j5 = j3;
                    f7 = f5;
                    f8 = f;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 384;
            i8 = i3 & 8;
            if (i8 != 0) {
                if ((i2 & 3072) == 0) {
                    f4 = f2;
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 16;
                if (i10 != 0) {
                    i4 |= 24576;
                    j3 = j;
                } else {
                    j3 = j;
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i11 = 16384;
                        } else {
                            i11 = 8192;
                        }
                        i4 |= i11;
                    }
                }
                i12 = i3 & 32;
                if (i12 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    jColor = j2;
                } else {
                    jColor = j2;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(jColor)) {
                            i13 = 131072;
                        } else {
                            i13 = 65536;
                        }
                        i4 |= i13;
                    }
                }
                i14 = i3 & 64;
                if (i14 != 0) {
                    i4 |= 1572864;
                    f5 = f3;
                } else {
                    f5 = f3;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i4 |= i15;
                    }
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i18 != 0) {
                        i5 = 3;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(7);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i8 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
                    } else {
                        fM9687constructorimpl2 = f4;
                    }
                    if (i10 != 0) {
                        jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    } else {
                        jM6851getWhite0d7_KjU = j3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(4284507761L);
                    }
                    if (i14 != 0) {
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
                    } else {
                        fM9687constructorimpl3 = f5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
                    }
                    f9 = fM9687constructorimpl;
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    float fM9701unboximpl3 = ((Dp) objRememberedValue).m9701unboximpl();
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierM1252height3ABfNKs3 = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl3), ((Dp) objRememberedValue2).m9701unboximpl());
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Modifier modifier6 = modifier3;
                    if ((i4 & 7168) == 2048) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean z9 = z3 | z2;
                    if ((i4 & 112) == 32) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean zChanged3 = z9 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
                    if ((458752 & i4) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = zChanged3 | z5 | ((i4 & 57344) == 16384);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        final long j16 = jColor;
                        final float f13 = fM9687constructorimpl2;
                        final int i112 = i5;
                        final long j17 = jM6851getWhite0d7_KjU;
                        objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return o0.a(f9, f13, i112, j16, j17, stateAnimateFloat, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        final long j18 = jColor;
                        final float f14 = fM9687constructorimpl2;
                        final int i113 = i5;
                        final long j19 = jM6851getWhite0d7_KjU;
                        objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return o0.a(f9, f14, i113, j18, j19, stateAnimateFloat, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    CanvasKt.Canvas(modifierM1252height3ABfNKs3, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    i16 = i5;
                    f8 = f9;
                    modifier2 = modifier6;
                    f7 = fM9687constructorimpl3;
                    long j110 = jColor;
                    f6 = fM9687constructorimpl2;
                    j4 = j110;
                    j5 = jM6851getWhite0d7_KjU;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    long j111 = jColor;
                    f6 = f4;
                    j4 = j111;
                    modifier2 = modifier;
                    composer2 = composerStartRestartGroup;
                    i16 = i5;
                    j5 = j3;
                    f7 = f5;
                    f8 = f;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            f4 = f2;
            i10 = i3 & 16;
            if (i10 != 0) {
                i4 |= 24576;
                j3 = j;
            } else {
                j3 = j;
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i11 = 16384;
                    } else {
                        i11 = 8192;
                    }
                    i4 |= i11;
                }
            }
            i12 = i3 & 32;
            if (i12 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                jColor = j2;
            } else {
                jColor = j2;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(jColor)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i4 |= i13;
                }
            }
            i14 = i3 & 64;
            if (i14 != 0) {
                i4 |= 1572864;
                f5 = f3;
            } else {
                f5 = f3;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i4 |= i15;
                }
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                if (i17 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i18 != 0) {
                    i5 = 3;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(7);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i8 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
                } else {
                    fM9687constructorimpl2 = f4;
                }
                if (i10 != 0) {
                    jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                } else {
                    jM6851getWhite0d7_KjU = j3;
                }
                if (i12 != 0) {
                    jColor = ColorKt.Color(4284507761L);
                }
                if (i14 != 0) {
                    fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
                } else {
                    fM9687constructorimpl3 = f5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
                }
                f9 = fM9687constructorimpl;
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                float fM9701unboximpl4 = ((Dp) objRememberedValue).m9701unboximpl();
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1252height3ABfNKs4 = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl4), ((Dp) objRememberedValue2).m9701unboximpl());
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier modifier7 = modifier3;
                if ((i4 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z10 = z3 | z2;
                if ((i4 & 112) == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean zChanged4 = z10 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
                if ((458752 & i4) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = zChanged4 | z5 | ((i4 & 57344) == 16384);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z6) {
                    final long j112 = jColor;
                    final float f15 = fM9687constructorimpl2;
                    final int i114 = i5;
                    final long j113 = jM6851getWhite0d7_KjU;
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return o0.a(f9, f15, i114, j112, j113, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final long j114 = jColor;
                    final float f16 = fM9687constructorimpl2;
                    final int i115 = i5;
                    final long j115 = jM6851getWhite0d7_KjU;
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return o0.a(f9, f16, i115, j114, j115, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                CanvasKt.Canvas(modifierM1252height3ABfNKs4, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                i16 = i5;
                f8 = f9;
                modifier2 = modifier7;
                f7 = fM9687constructorimpl3;
                long j116 = jColor;
                f6 = fM9687constructorimpl2;
                j4 = j116;
                j5 = jM6851getWhite0d7_KjU;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                long j117 = jColor;
                f6 = f4;
                j4 = j117;
                modifier2 = modifier;
                composer2 = composerStartRestartGroup;
                i16 = i5;
                j5 = j3;
                f7 = f5;
                f8 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        i5 = i;
        i6 = i3 & 4;
        if (i6 != 0) {
            if ((i2 & 384) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i4 |= i7;
            }
            i8 = i3 & 8;
            if (i8 != 0) {
                if ((i2 & 3072) == 0) {
                    f4 = f2;
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 16;
                if (i10 != 0) {
                    i4 |= 24576;
                    j3 = j;
                } else {
                    j3 = j;
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i11 = 16384;
                        } else {
                            i11 = 8192;
                        }
                        i4 |= i11;
                    }
                }
                i12 = i3 & 32;
                if (i12 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    jColor = j2;
                } else {
                    jColor = j2;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(jColor)) {
                            i13 = 131072;
                        } else {
                            i13 = 65536;
                        }
                        i4 |= i13;
                    }
                }
                i14 = i3 & 64;
                if (i14 != 0) {
                    i4 |= 1572864;
                    f5 = f3;
                } else {
                    f5 = f3;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i4 |= i15;
                    }
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i18 != 0) {
                        i5 = 3;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(7);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    if (i8 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
                    } else {
                        fM9687constructorimpl2 = f4;
                    }
                    if (i10 != 0) {
                        jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    } else {
                        jM6851getWhite0d7_KjU = j3;
                    }
                    if (i12 != 0) {
                        jColor = ColorKt.Color(4284507761L);
                    }
                    if (i14 != 0) {
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
                    } else {
                        fM9687constructorimpl3 = f5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
                    }
                    f9 = fM9687constructorimpl;
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    float fM9701unboximpl5 = ((Dp) objRememberedValue).m9701unboximpl();
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierM1252height3ABfNKs5 = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl5), ((Dp) objRememberedValue2).m9701unboximpl());
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Modifier modifier8 = modifier3;
                    if ((i4 & 7168) == 2048) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean z11 = z3 | z2;
                    if ((i4 & 112) == 32) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean zChanged5 = z11 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
                    if ((458752 & i4) == 131072) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = zChanged5 | z5 | ((i4 & 57344) == 16384);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        final long j118 = jColor;
                        final float f17 = fM9687constructorimpl2;
                        final int i116 = i5;
                        final long j119 = jM6851getWhite0d7_KjU;
                        objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return o0.a(f9, f17, i116, j118, j119, stateAnimateFloat, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        final long j1110 = jColor;
                        final float f18 = fM9687constructorimpl2;
                        final int i117 = i5;
                        final long j1111 = jM6851getWhite0d7_KjU;
                        objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return o0.a(f9, f18, i117, j1110, j1111, stateAnimateFloat, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    CanvasKt.Canvas(modifierM1252height3ABfNKs5, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    i16 = i5;
                    f8 = f9;
                    modifier2 = modifier8;
                    f7 = fM9687constructorimpl3;
                    long j1112 = jColor;
                    f6 = fM9687constructorimpl2;
                    j4 = j1112;
                    j5 = jM6851getWhite0d7_KjU;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    long j1113 = jColor;
                    f6 = f4;
                    j4 = j1113;
                    modifier2 = modifier;
                    composer2 = composerStartRestartGroup;
                    i16 = i5;
                    j5 = j3;
                    f7 = f5;
                    f8 = f;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            f4 = f2;
            i10 = i3 & 16;
            if (i10 != 0) {
                i4 |= 24576;
                j3 = j;
            } else {
                j3 = j;
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i11 = 16384;
                    } else {
                        i11 = 8192;
                    }
                    i4 |= i11;
                }
            }
            i12 = i3 & 32;
            if (i12 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                jColor = j2;
            } else {
                jColor = j2;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(jColor)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i4 |= i13;
                }
            }
            i14 = i3 & 64;
            if (i14 != 0) {
                i4 |= 1572864;
                f5 = f3;
            } else {
                f5 = f3;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i4 |= i15;
                }
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                if (i17 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i18 != 0) {
                    i5 = 3;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(7);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i8 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
                } else {
                    fM9687constructorimpl2 = f4;
                }
                if (i10 != 0) {
                    jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                } else {
                    jM6851getWhite0d7_KjU = j3;
                }
                if (i12 != 0) {
                    jColor = ColorKt.Color(4284507761L);
                }
                if (i14 != 0) {
                    fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
                } else {
                    fM9687constructorimpl3 = f5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
                }
                f9 = fM9687constructorimpl;
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                float fM9701unboximpl6 = ((Dp) objRememberedValue).m9701unboximpl();
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1252height3ABfNKs6 = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl6), ((Dp) objRememberedValue2).m9701unboximpl());
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier modifier9 = modifier3;
                if ((i4 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z12 = z3 | z2;
                if ((i4 & 112) == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean zChanged6 = z12 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
                if ((458752 & i4) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = zChanged6 | z5 | ((i4 & 57344) == 16384);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z6) {
                    final long j1114 = jColor;
                    final float f19 = fM9687constructorimpl2;
                    final int i118 = i5;
                    final long j1115 = jM6851getWhite0d7_KjU;
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return o0.a(f9, f19, i118, j1114, j1115, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final long j1116 = jColor;
                    final float f110 = fM9687constructorimpl2;
                    final int i119 = i5;
                    final long j1117 = jM6851getWhite0d7_KjU;
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return o0.a(f9, f110, i119, j1116, j1117, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                CanvasKt.Canvas(modifierM1252height3ABfNKs6, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                i16 = i5;
                f8 = f9;
                modifier2 = modifier9;
                f7 = fM9687constructorimpl3;
                long j1118 = jColor;
                f6 = fM9687constructorimpl2;
                j4 = j1118;
                j5 = jM6851getWhite0d7_KjU;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                long j1119 = jColor;
                f6 = f4;
                j4 = j1119;
                modifier2 = modifier;
                composer2 = composerStartRestartGroup;
                i16 = i5;
                j5 = j3;
                f7 = f5;
                f8 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        i8 = i3 & 8;
        if (i8 != 0) {
            if ((i2 & 3072) == 0) {
                f4 = f2;
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i4 |= i9;
            }
            i10 = i3 & 16;
            if (i10 != 0) {
                i4 |= 24576;
                j3 = j;
            } else {
                j3 = j;
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i11 = 16384;
                    } else {
                        i11 = 8192;
                    }
                    i4 |= i11;
                }
            }
            i12 = i3 & 32;
            if (i12 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                jColor = j2;
            } else {
                jColor = j2;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(jColor)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i4 |= i13;
                }
            }
            i14 = i3 & 64;
            if (i14 != 0) {
                i4 |= 1572864;
                f5 = f3;
            } else {
                f5 = f3;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i4 |= i15;
                }
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                if (i17 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i18 != 0) {
                    i5 = 3;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(7);
                } else {
                    fM9687constructorimpl = f;
                }
                if (i8 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
                } else {
                    fM9687constructorimpl2 = f4;
                }
                if (i10 != 0) {
                    jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                } else {
                    jM6851getWhite0d7_KjU = j3;
                }
                if (i12 != 0) {
                    jColor = ColorKt.Color(4284507761L);
                }
                if (i14 != 0) {
                    fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
                } else {
                    fM9687constructorimpl3 = f5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
                }
                f9 = fM9687constructorimpl;
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                float fM9701unboximpl7 = ((Dp) objRememberedValue).m9701unboximpl();
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierM1252height3ABfNKs7 = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl7), ((Dp) objRememberedValue2).m9701unboximpl());
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier modifier10 = modifier3;
                if ((i4 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z13 = z3 | z2;
                if ((i4 & 112) == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean zChanged7 = z13 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
                if ((458752 & i4) == 131072) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = zChanged7 | z5 | ((i4 & 57344) == 16384);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z6) {
                    final long j11110 = jColor;
                    final float f111 = fM9687constructorimpl2;
                    final int i1110 = i5;
                    final long j11111 = jM6851getWhite0d7_KjU;
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return o0.a(f9, f111, i1110, j11110, j11111, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final long j11112 = jColor;
                    final float f112 = fM9687constructorimpl2;
                    final int i1111 = i5;
                    final long j11113 = jM6851getWhite0d7_KjU;
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return o0.a(f9, f112, i1111, j11112, j11113, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                CanvasKt.Canvas(modifierM1252height3ABfNKs7, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                i16 = i5;
                f8 = f9;
                modifier2 = modifier10;
                f7 = fM9687constructorimpl3;
                long j11114 = jColor;
                f6 = fM9687constructorimpl2;
                j4 = j11114;
                j5 = jM6851getWhite0d7_KjU;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                long j11115 = jColor;
                f6 = f4;
                j4 = j11115;
                modifier2 = modifier;
                composer2 = composerStartRestartGroup;
                i16 = i5;
                j5 = j3;
                f7 = f5;
                f8 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        f4 = f2;
        i10 = i3 & 16;
        if (i10 != 0) {
            i4 |= 24576;
            j3 = j;
        } else {
            j3 = j;
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i11 = 16384;
                } else {
                    i11 = 8192;
                }
                i4 |= i11;
            }
        }
        i12 = i3 & 32;
        if (i12 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            jColor = j2;
        } else {
            jColor = j2;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(jColor)) {
                    i13 = 131072;
                } else {
                    i13 = 65536;
                }
                i4 |= i13;
            }
        }
        i14 = i3 & 64;
        if (i14 != 0) {
            i4 |= 1572864;
            f5 = f3;
        } else {
            f5 = f3;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i4 |= i15;
            }
        }
        if ((i4 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            if (i17 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier;
            }
            if (i18 != 0) {
                i5 = 3;
            }
            if (i6 != 0) {
                fM9687constructorimpl = Dp.m9687constructorimpl(7);
            } else {
                fM9687constructorimpl = f;
            }
            if (i8 != 0) {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(10);
            } else {
                fM9687constructorimpl2 = f4;
            }
            if (i10 != 0) {
                jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
            } else {
                jM6851getWhite0d7_KjU = j3;
            }
            if (i12 != 0) {
                jColor = ColorKt.Color(4284507761L);
            }
            if (i14 != 0) {
                fM9687constructorimpl3 = Dp.m9687constructorimpl(4);
            } else {
                fM9687constructorimpl3 = f5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(389896580, i4, -1, "io.nutrient.internal.ui.ai.ui.AnimatedTypingIndicator (AnimatedTypingIndicator.kt:52)");
            }
            f9 = fM9687constructorimpl;
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("Typing indicator animation", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null), "Typing indicator progress animation", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = Dp.m9685boximpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl((i5 + 1) * fM9687constructorimpl3) + Dp.m9687constructorimpl(i5 * fM9687constructorimpl2)));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            float fM9701unboximpl8 = ((Dp) objRememberedValue).m9701unboximpl();
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = Dp.m9685boximpl(Dp.m9687constructorimpl(2 * fM9687constructorimpl2));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1252height3ABfNKs8 = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, fM9701unboximpl8), ((Dp) objRememberedValue2).m9701unboximpl());
            if ((i4 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            Modifier modifier11 = modifier3;
            if ((i4 & 7168) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z14 = z3 | z2;
            if ((i4 & 112) == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean zChanged8 = z14 | z4 | composerStartRestartGroup.changed(stateAnimateFloat);
            if ((458752 & i4) == 131072) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = zChanged8 | z5 | ((i4 & 57344) == 16384);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z6) {
                final long j11116 = jColor;
                final float f113 = fM9687constructorimpl2;
                final int i1112 = i5;
                final long j11117 = jM6851getWhite0d7_KjU;
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return o0.a(f9, f113, i1112, j11116, j11117, stateAnimateFloat, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                final long j11118 = jColor;
                final float f114 = fM9687constructorimpl2;
                final int i1113 = i5;
                final long j11119 = jM6851getWhite0d7_KjU;
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return o0.a(f9, f114, i1113, j11118, j11119, stateAnimateFloat, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            CanvasKt.Canvas(modifierM1252height3ABfNKs8, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            i16 = i5;
            f8 = f9;
            modifier2 = modifier11;
            f7 = fM9687constructorimpl3;
            long j111110 = jColor;
            f6 = fM9687constructorimpl2;
            j4 = j111110;
            j5 = jM6851getWhite0d7_KjU;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            long j111111 = jColor;
            f6 = f4;
            j4 = j111111;
            modifier2 = modifier;
            composer2 = composerStartRestartGroup;
            i16 = i5;
            j5 = j3;
            f7 = f5;
            f8 = f;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.o0$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return o0.a(modifier2, i16, f8, f6, j5, j4, f7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(float f, float f2, int i, long j, long j2, State state, DrawScope drawScope) {
        float fA;
        DrawScope drawScope2 = drawScope;
        drawScope2.getClass();
        float f3 = drawScope2.mo754toPx0680j_4(f) / 2.0f;
        float f4 = drawScope2.mo754toPx0680j_4(f2) / 2.0f;
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            float fFloatValue = ((Number) state.getValue()).floatValue();
            float fA2 = a(fFloatValue, i, i3);
            int i4 = i - 1;
            float f5 = i;
            float f6 = 1.0f / f5;
            float f7 = f6 / 2.0f;
            int i5 = fFloatValue > (f6 * ((float) i4)) + f7 ? 1 : i2;
            int i6 = fFloatValue < f7 ? 1 : i2;
            if (i3 == 0 && i5 != 0) {
                fA = 1 - a(fFloatValue, i, i4);
            } else {
                fA = (i3 != i4 || i6 == 0) ? 0.0f : 1 - a(fFloatValue, i, i2);
            }
            float f8 = fA2 + fA;
            DrawScope.m7376drawCircleVaOC9Bg$default(drawScope2, ColorKt.m6865lerpjxsXWHM(j, j2, f8), ((f4 - f3) * f8) + f3, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope2.mo7395getSizeNHjbRc() >> 32)) / (i * 2)) + ((Float.intBitsToFloat((int) (drawScope2.mo7395getSizeNHjbRc() >> 32)) / f5) * i3))) << 32)), 0.0f, null, null, 0, 120, null);
            i3++;
            drawScope2 = drawScope;
            i2 = 0;
        }
        return Unit.INSTANCE;
    }

    public static final float a(float f, int i, int i2) {
        float f2 = 1;
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(f2 - (Math.abs(f - ((((i2 * 2) * i) + i) / ((i * 2) * i))) / (f2 / i)), 0.0f), 1.0f);
    }
}

package com.box.android.base.compose;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.BottomSheetDefaults;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxModalBottomSheet.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aA\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"BoxModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrimColor", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BoxModalBottomSheet-4erKP6g", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "UnpaddedDragHandle", "width", "height", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "UnpaddedDragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxModalBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxModalBottomSheet_4erKP6g$lambda$1(Function0 function0, Modifier modifier, SheetState sheetState, float f, long j, long j2, long j3, Function3 function3, int i, int i2, Composer composer, int i3) {
        m11602BoxModalBottomSheet4erKP6g(function0, modifier, sheetState, f, j, j2, j3, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnpaddedDragHandle_lgZ2HuY$lambda$1(Modifier modifier, float f, float f2, Shape shape, long j, int i, int i2, Composer composer, int i3) {
        m11603UnpaddedDragHandlelgZ2HuY(modifier, f, f2, shape, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0139 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x013b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0144  */
    /* JADX WARN: Code duplicated, block: B:116:0x0152  */
    /* JADX WARN: Code duplicated, block: B:119:0x0160  */
    /* JADX WARN: Code duplicated, block: B:122:0x0170  */
    /* JADX WARN: Code duplicated, block: B:125:0x017d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0190  */
    /* JADX WARN: Code duplicated, block: B:132:0x0206  */
    /* JADX WARN: Code duplicated, block: B:134:0x0210  */
    /* JADX WARN: Code duplicated, block: B:137:0x0221  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX INFO: renamed from: BoxModalBottomSheet-4erKP6g, reason: not valid java name */
    public static final void m11602BoxModalBottomSheet4erKP6g(final Function0<Unit> onDismissRequest, Modifier modifier, SheetState sheetState, float f, long j, long j2, long j3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SheetState sheetStateRememberModalBottomSheetState;
        float fM2815getSheetMaxWidthD9Ej5fM;
        long jM11542getPopupBackground0d7_KjU;
        long scrimColor;
        long jM3051contentColorForek8zF_U;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final SheetState sheetState2;
        final float f2;
        final long j4;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2065433764);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,containerColor:c#ui.graphics.Color,scrimColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)45@1995L21,59@2503L309,46@2021L791:BoxModalBottomSheet.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onDismissRequest) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    sheetStateRememberModalBottomSheetState = sheetState;
                    int i6 = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) ? 256 : 128;
                    i3 |= i6;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState;
                }
                i3 |= i6;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = f;
                    int i7 = composerStartRestartGroup.changed(fM2815getSheetMaxWidthD9Ej5fM) ? 2048 : 1024;
                    i3 |= i7;
                } else {
                    fM2815getSheetMaxWidthD9Ej5fM = f;
                }
                i3 |= i7;
            } else {
                fM2815getSheetMaxWidthD9Ej5fM = f;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    jM11542getPopupBackground0d7_KjU = j;
                    int i8 = composerStartRestartGroup.changed(jM11542getPopupBackground0d7_KjU) ? 16384 : 8192;
                    i3 |= i8;
                } else {
                    jM11542getPopupBackground0d7_KjU = j;
                }
                i3 |= i8;
            } else {
                jM11542getPopupBackground0d7_KjU = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    scrimColor = j2;
                    int i9 = composerStartRestartGroup.changed(scrimColor) ? 131072 : 65536;
                    i3 |= i9;
                } else {
                    scrimColor = j2;
                }
                i3 |= i9;
            } else {
                scrimColor = j2;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM3051contentColorForek8zF_U = j3;
                    int i10 = composerStartRestartGroup.changed(jM3051contentColorForek8zF_U) ? 1048576 : 524288;
                    i3 |= i10;
                } else {
                    jM3051contentColorForek8zF_U = j3;
                }
                i3 |= i10;
            } else {
                jM3051contentColorForek8zF_U = j3;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i4 = 8388608;
                } else {
                    i4 = 4194304;
                }
                i3 |= i4;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "38@1653L31,40@1782L6,41@1850L10,42@1888L31");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        jM11542getPopupBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11542getPopupBackground0d7_KjU();
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(jM11542getPopupBackground0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                        i3 &= -3670017;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                }
                float f3 = fM2815getSheetMaxWidthD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2065433764, i3, -1, "com.box.android.base.compose.BoxModalBottomSheet (BoxModalBottomSheet.kt:44)");
                }
                boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = modifier2;
                long j7 = jM11542getPopupBackground0d7_KjU;
                long j8 = scrimColor;
                SheetState sheetState3 = sheetStateRememberModalBottomSheetState;
                long j9 = jM3051contentColorForek8zF_U;
                ModalBottomSheetKt.m3811ModalBottomSheetYbuCTN8(onDismissRequest, modifier4, sheetState3, f3, false, null, j7, j9, 0.0f, j8, null, null, new ModalBottomSheetProperties(!zIsSystemInDarkTheme, !zIsSystemInDarkTheme, null, false, false, 28, null), ComposableLambdaKt.rememberComposableLambda(-2030433474, true, new Function3() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxModalBottomSheetKt.BoxModalBottomSheet_4erKP6g$lambda$0(content, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i3 & 8190) | ((i3 << 6) & 3670016) | ((i3 << 3) & 29360128) | (1879048192 & (i3 << 12)), 3078, 2352);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f3;
                j4 = j7;
                j6 = j9;
                j5 = j8;
                sheetState2 = sheetState3;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                f2 = fM2815getSheetMaxWidthD9Ej5fM;
                j4 = jM11542getPopupBackground0d7_KjU;
                j5 = scrimColor;
                j6 = jM3051contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxModalBottomSheetKt.BoxModalBottomSheet_4erKP6g$lambda$1(onDismissRequest, modifier3, sheetState2, f2, j4, j5, j6, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                sheetStateRememberModalBottomSheetState = sheetState;
                if (composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) {
                }
                i3 |= i6;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            i3 |= i6;
        } else {
            sheetStateRememberModalBottomSheetState = sheetState;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                fM2815getSheetMaxWidthD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM2815getSheetMaxWidthD9Ej5fM)) {
                }
                i3 |= i7;
            } else {
                fM2815getSheetMaxWidthD9Ej5fM = f;
            }
            i3 |= i7;
        } else {
            fM2815getSheetMaxWidthD9Ej5fM = f;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                jM11542getPopupBackground0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11542getPopupBackground0d7_KjU)) {
                }
                i3 |= i8;
            } else {
                jM11542getPopupBackground0d7_KjU = j;
            }
            i3 |= i8;
        } else {
            jM11542getPopupBackground0d7_KjU = j;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                scrimColor = j2;
                if (composerStartRestartGroup.changed(scrimColor)) {
                }
                i3 |= i9;
            } else {
                scrimColor = j2;
            }
            i3 |= i9;
        } else {
            scrimColor = j2;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                jM3051contentColorForek8zF_U = j3;
                if (composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                }
                i3 |= i10;
            } else {
                jM3051contentColorForek8zF_U = j3;
            }
            i3 |= i10;
        } else {
            jM3051contentColorForek8zF_U = j3;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i4 = 8388608;
            } else {
                i4 = 4194304;
            }
            i3 |= i4;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "38@1653L31,40@1782L6,41@1850L10,42@1888L31");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    jM11542getPopupBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11542getPopupBackground0d7_KjU();
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(jM11542getPopupBackground0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -3670017;
                }
            } else {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    jM11542getPopupBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11542getPopupBackground0d7_KjU();
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(jM11542getPopupBackground0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                    i3 &= -3670017;
                }
            }
            float f4 = fM2815getSheetMaxWidthD9Ej5fM;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2065433764, i3, -1, "com.box.android.base.compose.BoxModalBottomSheet (BoxModalBottomSheet.kt:44)");
            }
            boolean zIsSystemInDarkTheme2 = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            Modifier modifier5 = modifier2;
            long j10 = jM11542getPopupBackground0d7_KjU;
            long j11 = scrimColor;
            SheetState sheetState4 = sheetStateRememberModalBottomSheetState;
            long j12 = jM3051contentColorForek8zF_U;
            ModalBottomSheetKt.m3811ModalBottomSheetYbuCTN8(onDismissRequest, modifier5, sheetState4, f4, false, null, j10, j12, 0.0f, j11, null, null, new ModalBottomSheetProperties(!zIsSystemInDarkTheme2, !zIsSystemInDarkTheme2, null, false, false, 28, null), ComposableLambdaKt.rememberComposableLambda(-2030433474, true, new Function3() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxModalBottomSheetKt.BoxModalBottomSheet_4erKP6g$lambda$0(content, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i3 & 8190) | ((i3 << 6) & 3670016) | ((i3 << 3) & 29360128) | (1879048192 & (i3 << 12)), 3078, 2352);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f4;
            j4 = j10;
            j6 = j12;
            j5 = j11;
            sheetState2 = sheetState4;
            modifier3 = modifier5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            sheetState2 = sheetStateRememberModalBottomSheetState;
            f2 = fM2815getSheetMaxWidthD9Ej5fM;
            j4 = jM11542getPopupBackground0d7_KjU;
            j5 = scrimColor;
            j6 = jM3051contentColorForek8zF_U;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxModalBottomSheetKt.BoxModalBottomSheet_4erKP6g$lambda$1(onDismissRequest, modifier3, sheetState2, f2, j4, j5, j6, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxModalBottomSheet_4erKP6g$lambda$0(Function3 function3, ColumnScope ModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C60@2513L293:BoxModalBottomSheet.kt#vejmn0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2030433474, i, -1, "com.box.android.base.compose.BoxModalBottomSheet.<anonymous> (BoxModalBottomSheet.kt:60)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1836827537, "C62@2606L168,67@2787L9:BoxModalBottomSheet.kt#vejmn0");
            m11603UnpaddedDragHandlelgZ2HuY(PaddingKt.m1222paddingqDBjuR0$default(columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), 0.0f, Dp.m9687constructorimpl(16), 0.0f, 0.0f, 13, null), 0.0f, 0.0f, null, 0L, composer, 0, 30);
            function3.invoke(columnScopeInstance, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0179  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:88:0x010d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0124  */
    /* JADX WARN: Code duplicated, block: B:95:0x0160  */
    /* JADX WARN: Code duplicated, block: B:97:0x0169  */
    /* JADX INFO: renamed from: UnpaddedDragHandle-lgZ2HuY, reason: not valid java name */
    private static final void m11603UnpaddedDragHandlelgZ2HuY(Modifier modifier, float f, float f2, Shape shape, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float fM9687constructorimpl;
        int i4;
        float fM9687constructorimpl2;
        int i5;
        Shape extraLarge;
        long jM11536getMainInactiveControl0d7_KjU;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final float f3;
        final float f4;
        final Shape shape2;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1870975526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UnpaddedDragHandle)N(modifier,width:c#ui.unit.Dp,height:c#ui.unit.Dp,shape,color:c#ui.graphics.Color)84@3145L66,80@3056L155:BoxModalBottomSheet.kt#vejmn0");
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
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                fM9687constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM9687constructorimpl) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    fM9687constructorimpl2 = f2;
                    if (composerStartRestartGroup.changed(fM9687constructorimpl2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        extraLarge = shape;
                        int i8 = composerStartRestartGroup.changed(extraLarge) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        extraLarge = shape;
                    }
                    i3 |= i8;
                } else {
                    extraLarge = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        jM11536getMainInactiveControl0d7_KjU = j;
                        int i9 = composerStartRestartGroup.changed(jM11536getMainInactiveControl0d7_KjU) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        jM11536getMainInactiveControl0d7_KjU = j;
                    }
                    i3 |= i9;
                } else {
                    jM11536getMainInactiveControl0d7_KjU = j;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2974L6,78@3021L6");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(32);
                        }
                        if (i4 != 0) {
                            fM9687constructorimpl2 = Dp.m9687constructorimpl(4);
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
                        }
                        if ((i2 & 16) != 0) {
                            jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                            i3 &= -57345;
                        }
                        modifier4 = companion;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        modifier4 = modifier2;
                    }
                    final float f5 = fM9687constructorimpl;
                    final float f6 = fM9687constructorimpl2;
                    Shape shape3 = extraLarge;
                    long j3 = jM11536getMainInactiveControl0d7_KjU;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1870975526, i3, -1, "com.box.android.base.compose.UnpaddedDragHandle (BoxModalBottomSheet.kt:79)");
                    }
                    int i10 = i3 >> 6;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape3, j3, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1651499135, true, new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$0(f5, f6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 12582912 | (i10 & 112) | (i10 & 896), 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f4 = f6;
                    modifier3 = modifier4;
                    shape2 = shape3;
                    j2 = j3;
                    f3 = f5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = fM9687constructorimpl;
                    f4 = fM9687constructorimpl2;
                    shape2 = extraLarge;
                    j2 = jM11536getMainInactiveControl0d7_KjU;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$1(modifier3, f3, f4, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            fM9687constructorimpl2 = f2;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    extraLarge = shape;
                    if (composerStartRestartGroup.changed(extraLarge)) {
                    }
                    i3 |= i8;
                } else {
                    extraLarge = shape;
                }
                i3 |= i8;
            } else {
                extraLarge = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    jM11536getMainInactiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11536getMainInactiveControl0d7_KjU)) {
                    }
                    i3 |= i9;
                } else {
                    jM11536getMainInactiveControl0d7_KjU = j;
                }
                i3 |= i9;
            } else {
                jM11536getMainInactiveControl0d7_KjU = j;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2974L6,78@3021L6");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(32);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(4);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                        i3 &= -57345;
                    }
                    modifier4 = companion;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(32);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(4);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                        i3 &= -57345;
                    }
                    modifier4 = companion;
                }
                final float f7 = fM9687constructorimpl;
                final float f8 = fM9687constructorimpl2;
                Shape shape4 = extraLarge;
                long j4 = jM11536getMainInactiveControl0d7_KjU;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1870975526, i3, -1, "com.box.android.base.compose.UnpaddedDragHandle (BoxModalBottomSheet.kt:79)");
                }
                int i11 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape4, j4, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1651499135, true, new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$0(f7, f8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 12582912 | (i11 & 112) | (i11 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f4 = f8;
                modifier3 = modifier4;
                shape2 = shape4;
                j2 = j4;
                f3 = f7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = fM9687constructorimpl;
                f4 = fM9687constructorimpl2;
                shape2 = extraLarge;
                j2 = jM11536getMainInactiveControl0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$1(modifier3, f3, f4, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        fM9687constructorimpl = f;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                fM9687constructorimpl2 = f2;
                if (composerStartRestartGroup.changed(fM9687constructorimpl2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    extraLarge = shape;
                    if (composerStartRestartGroup.changed(extraLarge)) {
                    }
                    i3 |= i8;
                } else {
                    extraLarge = shape;
                }
                i3 |= i8;
            } else {
                extraLarge = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    jM11536getMainInactiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11536getMainInactiveControl0d7_KjU)) {
                    }
                    i3 |= i9;
                } else {
                    jM11536getMainInactiveControl0d7_KjU = j;
                }
                i3 |= i9;
            } else {
                jM11536getMainInactiveControl0d7_KjU = j;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2974L6,78@3021L6");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(32);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(4);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                        i3 &= -57345;
                    }
                    modifier4 = companion;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(32);
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(4);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                        i3 &= -57345;
                    }
                    modifier4 = companion;
                }
                final float f9 = fM9687constructorimpl;
                final float f10 = fM9687constructorimpl2;
                Shape shape5 = extraLarge;
                long j5 = jM11536getMainInactiveControl0d7_KjU;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1870975526, i3, -1, "com.box.android.base.compose.UnpaddedDragHandle (BoxModalBottomSheet.kt:79)");
                }
                int i12 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape5, j5, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1651499135, true, new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$0(f9, f10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 12582912 | (i12 & 112) | (i12 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f4 = f10;
                modifier3 = modifier4;
                shape2 = shape5;
                j2 = j5;
                f3 = f9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = fM9687constructorimpl;
                f4 = fM9687constructorimpl2;
                shape2 = extraLarge;
                j2 = jM11536getMainInactiveControl0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$1(modifier3, f3, f4, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        fM9687constructorimpl2 = f2;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                extraLarge = shape;
                if (composerStartRestartGroup.changed(extraLarge)) {
                }
                i3 |= i8;
            } else {
                extraLarge = shape;
            }
            i3 |= i8;
        } else {
            extraLarge = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                jM11536getMainInactiveControl0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11536getMainInactiveControl0d7_KjU)) {
                }
                i3 |= i9;
            } else {
                jM11536getMainInactiveControl0d7_KjU = j;
            }
            i3 |= i9;
        } else {
            jM11536getMainInactiveControl0d7_KjU = j;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "77@2974L6,78@3021L6");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(32);
                }
                if (i4 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(4);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                    i3 &= -57345;
                }
                modifier4 = companion;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(32);
                }
                if (i4 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(4);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                    i3 &= -57345;
                }
                modifier4 = companion;
            }
            final float f11 = fM9687constructorimpl;
            final float f12 = fM9687constructorimpl2;
            Shape shape6 = extraLarge;
            long j6 = jM11536getMainInactiveControl0d7_KjU;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1870975526, i3, -1, "com.box.android.base.compose.UnpaddedDragHandle (BoxModalBottomSheet.kt:79)");
            }
            int i13 = i3 >> 6;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape6, j6, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1651499135, true, new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$0(f11, f12, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 12582912 | (i13 & 112) | (i13 & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f4 = f12;
            modifier3 = modifier4;
            shape2 = shape6;
            j2 = j6;
            f3 = f11;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = fM9687constructorimpl;
            f4 = fM9687constructorimpl2;
            shape2 = extraLarge;
            j2 = jM11536getMainInactiveControl0d7_KjU;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxModalBottomSheetKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxModalBottomSheetKt.UnpaddedDragHandle_lgZ2HuY$lambda$1(modifier3, f3, f4, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnpaddedDragHandle_lgZ2HuY$lambda$0(float f, float f2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C85@3155L50:BoxModalBottomSheet.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651499135, i, -1, "com.box.android.base.compose.UnpaddedDragHandle.<anonymous> (BoxModalBottomSheet.kt:85)");
            }
            BoxKt.Box(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, f, f2), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

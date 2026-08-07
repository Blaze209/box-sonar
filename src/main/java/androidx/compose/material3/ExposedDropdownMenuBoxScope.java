package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\tH&J\u0095\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b*\u0010+J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0005H\u0007J\u009f\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b.\u0010/JU\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00100R\u0012\u0010\u000e\u001a\u00020\u0007X \u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\tX \u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u00011¨\u00062"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "enabled", "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "exposedDropdownSize", "matchAnchorWidth", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "matchTextFieldWidth", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public /* synthetic */ ExposedDropdownMenuBoxScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu$lambda$0(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, Function3 function3, int i, int i2, Composer composer, int i3) {
        exposedDropdownMenuBoxScope.ExposedDropdownMenu(z, function0, modifier, scrollState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_kbRbctU$lambda$0(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, boolean z2, boolean z3, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        exposedDropdownMenuBoxScope.m3327ExposedDropdownMenukbRbctU(z, function0, modifier, scrollState, z2, z3, shape, j, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_vNxi1II$lambda$6(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, boolean z2, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        exposedDropdownMenuBoxScope.m3328ExposedDropdownMenuvNxi1II(z, function0, modifier, scrollState, z2, shape, j, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    public abstract boolean getAlwaysFocusable$material3();

    /* JADX INFO: renamed from: getAnchorType-oYjWRB4$material3, reason: not valid java name */
    public abstract String mo3329getAnchorTypeoYjWRB4$material3();

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac, reason: not valid java name */
    public abstract Modifier mo3330menuAnchor2Hz36ac(Modifier modifier, String str, boolean z);

    private ExposedDropdownMenuBoxScope() {
    }

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3326menuAnchor2Hz36ac$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-2Hz36ac");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.mo3330menuAnchor2Hz36ac(modifier, str, z);
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0120  */
    /* JADX WARN: Code duplicated, block: B:104:0x012a  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x0133  */
    /* JADX WARN: Code duplicated, block: B:109:0x0138  */
    /* JADX WARN: Code duplicated, block: B:112:0x0140  */
    /* JADX WARN: Code duplicated, block: B:114:0x0146  */
    /* JADX WARN: Code duplicated, block: B:115:0x0149  */
    /* JADX WARN: Code duplicated, block: B:119:0x015e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0167  */
    /* JADX WARN: Code duplicated, block: B:126:0x0170  */
    /* JADX WARN: Code duplicated, block: B:128:0x017d  */
    /* JADX WARN: Code duplicated, block: B:142:0x01af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:147:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:153:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:159:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:162:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:164:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:165:0x020c  */
    /* JADX WARN: Code duplicated, block: B:168:0x0224  */
    /* JADX WARN: Code duplicated, block: B:171:0x0240  */
    /* JADX WARN: Code duplicated, block: B:174:0x0275  */
    /* JADX WARN: Code duplicated, block: B:176:0x0292  */
    /* JADX WARN: Code duplicated, block: B:178:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:181:0x02be  */
    /* JADX WARN: Code duplicated, block: B:184:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:188:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:190:0x0319  */
    /* JADX WARN: Code duplicated, block: B:193:0x0346  */
    /* JADX WARN: Code duplicated, block: B:195:0x034e  */
    /* JADX WARN: Code duplicated, block: B:199:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:201:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:204:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:94:0x010c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX WARN: Code duplicated, block: B:99:0x011d  */
    /* JADX INFO: renamed from: ExposedDropdownMenu-vNxi1II, reason: not valid java name */
    public final void m3328ExposedDropdownMenuvNxi1II(final boolean z, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, boolean z2, Shape shape, long j, float f, float f2, final BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function1;
        Modifier modifier2;
        ScrollState scrollState2;
        int i5;
        boolean z3;
        int i6;
        Shape shape2;
        final long containerColor;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z4;
        Composer composer2;
        final float f3;
        final Shape shape3;
        final Modifier modifier3;
        final ScrollState scrollState3;
        final boolean z5;
        final float f4;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        ScrollState scrollStateRememberScrollState;
        float fM3754getTonalElevationD9Ej5fM;
        float fM3753getShadowElevationD9Ej5fM;
        final Modifier modifier4;
        final Shape shape4;
        final long j2;
        final float f5;
        final ScrollState scrollState4;
        final float f6;
        final boolean z6;
        Object objRememberedValue;
        final MutableState mutableState;
        Density density;
        int top;
        Object objRememberedValue2;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue3;
        final MutableState mutableState2;
        boolean zChanged;
        Object objRememberedValue4;
        Object objRememberedValue5;
        int i15;
        int i16;
        int i17;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(-126848451);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,matchAnchorWidth,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)324@15347L53,325@15436L7,326@15487L10,333@15744L42:ExposedDropdownMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i19 = i3 & 4;
        if (i19 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    scrollState2 = scrollState;
                    int i20 = composerStartRestartGroup.changed(scrollState2) ? 2048 : 1024;
                    i4 |= i20;
                } else {
                    scrollState2 = scrollState;
                }
                i4 |= i20;
            } else {
                scrollState2 = scrollState;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i & 24576) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    shape2 = shape;
                    if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(shape2)) {
                        i18 = 65536;
                    } else {
                        i18 = 131072;
                    }
                    i4 |= i18;
                } else {
                    shape2 = shape;
                }
                if ((i & 1572864) == 0) {
                    containerColor = j;
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                        i17 = 524288;
                    } else {
                        i17 = 1048576;
                    }
                    i4 |= i17;
                } else {
                    containerColor = j;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 512;
                    if (i11 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i12 = 268435456;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i13 = i2 | i16;
                    } else {
                        i13 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i15 = 32;
                        } else {
                            i15 = 16;
                        }
                        i13 |= i15;
                    }
                    i14 = i13;
                    if ((i4 & 306783379) == 306783378 || (i14 & 19) != 18) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i19 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if ((i3 & 8) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -7169;
                            } else {
                                scrollStateRememberScrollState = scrollState2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 32) != 0) {
                                shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            }
                            if (i7 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i9 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                modifier4 = companion;
                                shape4 = shape2;
                                j2 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                scrollState4 = scrollStateRememberScrollState;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                z6 = z3;
                                borderStroke = null;
                            } else {
                                modifier4 = companion;
                                shape4 = shape2;
                                j2 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                scrollState4 = scrollStateRememberScrollState;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume;
                            top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                            if (z) {
                                composerStartRestartGroup.startReplaceGroup(629975788);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(614559333);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new MutableTransitionState(false);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                            if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                composerStartRestartGroup.startReplaceGroup(630380617);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                mutableState2 = (MutableState) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                        }
                                    }, 8, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                                composer2 = composerStartRestartGroup;
                                composer2.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(614559333);
                                composerStartRestartGroup.endReplaceGroup();
                                composer2 = composerStartRestartGroup;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z5 = z6;
                            scrollState3 = scrollState4;
                            shape3 = shape4;
                            containerColor = j2;
                            f3 = f5;
                            f4 = f6;
                            borderStroke2 = borderStroke;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            f5 = f;
                            f6 = f2;
                            shape4 = shape2;
                            j2 = containerColor;
                            modifier4 = modifier2;
                            scrollState4 = scrollState2;
                        }
                        z6 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume2;
                        top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                        if (z) {
                            composerStartRestartGroup.startReplaceGroup(629975788);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(614559333);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new MutableTransitionState(false);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                        if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(630380617);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 8, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 8, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(630380617);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 8, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 8, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z5 = z6;
                        scrollState3 = scrollState4;
                        shape3 = shape4;
                        containerColor = j2;
                        f3 = f5;
                        f4 = f6;
                        borderStroke2 = borderStroke;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f3 = f;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        scrollState3 = scrollState2;
                        z5 = z3;
                        f4 = f2;
                        borderStroke2 = borderStroke;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i11 = i3 & 512;
                if (i11 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i12 = 268435456;
                    }
                    i4 |= i12;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i13 = i2 | i16;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i15 = 32;
                    } else {
                        i15 = 16;
                    }
                    i13 |= i15;
                }
                i14 = i13;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 8) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -7169;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if (i7 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i9 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                            borderStroke = null;
                        } else {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                        }
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 8) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -7169;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if (i7 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i9 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                            borderStroke = null;
                        } else {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume3;
                    top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(629975788);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(614559333);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(630380617);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(630380617);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z5 = z6;
                    scrollState3 = scrollState4;
                    shape3 = shape4;
                    containerColor = j2;
                    f3 = f5;
                    f4 = f6;
                    borderStroke2 = borderStroke;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                    z5 = z3;
                    f4 = f2;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            z3 = z2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                shape2 = shape;
                if ((i3 & 32) == 0) {
                    i18 = 65536;
                } else {
                    i18 = 65536;
                }
                i4 |= i18;
            } else {
                shape2 = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i17 = 524288;
                } else {
                    i17 = 524288;
                }
                i4 |= i17;
            } else {
                containerColor = j;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i12 = 268435456;
                    }
                    i4 |= i12;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i13 = i2 | i16;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i15 = 32;
                    } else {
                        i15 = 16;
                    }
                    i13 |= i15;
                }
                i14 = i13;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 8) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -7169;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if (i7 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i9 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                            borderStroke = null;
                        } else {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                        }
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 8) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -7169;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if (i7 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i9 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                            borderStroke = null;
                        } else {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume4;
                    top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(629975788);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(614559333);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(630380617);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(630380617);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z5 = z6;
                    scrollState3 = scrollState4;
                    shape3 = shape4;
                    containerColor = j2;
                    f3 = f5;
                    f4 = f6;
                    borderStroke2 = borderStroke;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                    z5 = z3;
                    f4 = f2;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i11 = i3 & 512;
            if (i11 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i12 = 268435456;
                }
                i4 |= i12;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i13 = i2 | i16;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
                i13 |= i15;
            }
            i14 = i13;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                        borderStroke = null;
                    } else {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                    }
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                        borderStroke = null;
                    } else {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume5;
                top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(629975788);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                } else {
                    composerStartRestartGroup.startReplaceGroup(614559333);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(630380617);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(630380617);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z5 = z6;
                scrollState3 = scrollState4;
                shape3 = shape4;
                containerColor = j2;
                f3 = f5;
                f4 = f6;
                borderStroke2 = borderStroke;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f3 = f;
                shape3 = shape2;
                modifier3 = modifier2;
                scrollState3 = scrollState2;
                z5 = z3;
                f4 = f2;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i3 & 8) == 0) {
                scrollState2 = scrollState;
                if (composerStartRestartGroup.changed(scrollState2)) {
                }
                i4 |= i20;
            } else {
                scrollState2 = scrollState;
            }
            i4 |= i20;
        } else {
            scrollState2 = scrollState;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i & 24576) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                shape2 = shape;
                if ((i3 & 32) == 0) {
                    i18 = 65536;
                } else {
                    i18 = 65536;
                }
                i4 |= i18;
            } else {
                shape2 = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i17 = 524288;
                } else {
                    i17 = 524288;
                }
                i4 |= i17;
            } else {
                containerColor = j;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i12 = 268435456;
                    }
                    i4 |= i12;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i13 = i2 | i16;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i15 = 32;
                    } else {
                        i15 = 16;
                    }
                    i13 |= i15;
                }
                i14 = i13;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 8) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -7169;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if (i7 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i9 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                            borderStroke = null;
                        } else {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                        }
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 8) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -7169;
                        } else {
                            scrollStateRememberScrollState = scrollState2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 32) != 0) {
                            shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        }
                        if (i7 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i9 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                            borderStroke = null;
                        } else {
                            modifier4 = companion;
                            shape4 = shape2;
                            j2 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            scrollState4 = scrollStateRememberScrollState;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            z6 = z3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume6;
                    top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(629975788);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(614559333);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(630380617);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(630380617);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 8, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z5 = z6;
                    scrollState3 = scrollState4;
                    shape3 = shape4;
                    containerColor = j2;
                    f3 = f5;
                    f4 = f6;
                    borderStroke2 = borderStroke;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                    z5 = z3;
                    f4 = f2;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i11 = i3 & 512;
            if (i11 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i12 = 268435456;
                }
                i4 |= i12;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i13 = i2 | i16;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
                i13 |= i15;
            }
            i14 = i13;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                        borderStroke = null;
                    } else {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                    }
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                        borderStroke = null;
                    } else {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume7;
                top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(629975788);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                } else {
                    composerStartRestartGroup.startReplaceGroup(614559333);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(630380617);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(630380617);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z5 = z6;
                scrollState3 = scrollState4;
                shape3 = shape4;
                containerColor = j2;
                f3 = f5;
                f4 = f6;
                borderStroke2 = borderStroke;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f3 = f;
                shape3 = shape2;
                modifier3 = modifier2;
                scrollState3 = scrollState2;
                z5 = z3;
                f4 = f2;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        z3 = z2;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            shape2 = shape;
            if ((i3 & 32) == 0) {
                i18 = 65536;
            } else {
                i18 = 65536;
            }
            i4 |= i18;
        } else {
            shape2 = shape;
        }
        if ((i & 1572864) == 0) {
            containerColor = j;
            if ((i3 & 64) == 0) {
                i17 = 524288;
            } else {
                i17 = 524288;
            }
            i4 |= i17;
        } else {
            containerColor = j;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i4 |= i8;
        }
        i9 = i3 & 256;
        if (i9 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i4 |= i10;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i12 = 268435456;
                }
                i4 |= i12;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i13 = i2 | i16;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
                i13 |= i15;
            }
            i14 = i13;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                        borderStroke = null;
                    } else {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                    }
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 32) != 0) {
                        shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                        borderStroke = null;
                    } else {
                        modifier4 = companion;
                        shape4 = shape2;
                        j2 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        scrollState4 = scrollStateRememberScrollState;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        z6 = z3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume8;
                top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(629975788);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                } else {
                    composerStartRestartGroup.startReplaceGroup(614559333);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(630380617);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(630380617);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 8, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z5 = z6;
                scrollState3 = scrollState4;
                shape3 = shape4;
                containerColor = j2;
                f3 = f5;
                f4 = f6;
                borderStroke2 = borderStroke;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f3 = f;
                shape3 = shape2;
                modifier3 = modifier2;
                scrollState3 = scrollState2;
                z5 = z3;
                f4 = f2;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        i11 = i3 & 512;
        if (i11 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i12 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i12 = 268435456;
            }
            i4 |= i12;
        }
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i2 | i16;
        } else {
            i13 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        i14 = i13;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 8) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -7169;
                } else {
                    scrollStateRememberScrollState = scrollState2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i4 &= -458753;
                }
                if ((i3 & 64) != 0) {
                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if (i7 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                } else {
                    fM3754getTonalElevationD9Ej5fM = f;
                }
                if (i9 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                } else {
                    fM3753getShadowElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    modifier4 = companion;
                    shape4 = shape2;
                    j2 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    scrollState4 = scrollStateRememberScrollState;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    z6 = z3;
                    borderStroke = null;
                } else {
                    modifier4 = companion;
                    shape4 = shape2;
                    j2 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    scrollState4 = scrollStateRememberScrollState;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    z6 = z3;
                }
            } else {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 8) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -7169;
                } else {
                    scrollStateRememberScrollState = scrollState2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 32) != 0) {
                    shape2 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i4 &= -458753;
                }
                if ((i3 & 64) != 0) {
                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                }
                if (i7 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                } else {
                    fM3754getTonalElevationD9Ej5fM = f;
                }
                if (i9 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                } else {
                    fM3753getShadowElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    modifier4 = companion;
                    shape4 = shape2;
                    j2 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    scrollState4 = scrollStateRememberScrollState;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    z6 = z3;
                    borderStroke = null;
                } else {
                    modifier4 = companion;
                    shape4 = shape2;
                    j2 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    scrollState4 = scrollStateRememberScrollState;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    z6 = z3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-126848451, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642252302, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume9;
            top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(629975788);
                ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244863, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$1$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
            } else {
                composerStartRestartGroup.startReplaceGroup(614559333);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239609, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new MutableTransitionState(false);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableTransitionState = (MutableTransitionState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
            if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(630380617);
                ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 8, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 8, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(630380617);
                ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642233232, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642229341, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 8, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$4$0(mutableState2, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 8, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function1, ExposedDropdownMenu_androidKt.m3350popupPropertiesForAnchorTypeBTG8q0(mo3329getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$5(this.f$0, modifier4, z6, mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z5 = z6;
            scrollState3 = scrollState4;
            shape3 = shape4;
            containerColor = j2;
            f3 = f5;
            f4 = f6;
            borderStroke2 = borderStroke;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            f3 = f;
            shape3 = shape2;
            modifier3 = modifier2;
            scrollState3 = scrollState2;
            z5 = z3;
            f4 = f2;
            borderStroke2 = borderStroke;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6(this.f$0, z, function0, modifier3, scrollState3, z5, shape3, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_vNxi1II$lambda$1$0(MutableState mutableState) {
        mutableState.setValue(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_vNxi1II$lambda$4$0(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m7216boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenu_vNxi1II$lambda$5(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C355@16794L552:ExposedDropdownMenu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2063119149, i, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:355)");
            }
            MenuKt.m3796DropdownMenuContentQj0Zi0g(exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z), mutableTransitionState, mutableState, scrollState, shape, j, f, f2, borderStroke, function3, composer, (MutableTransitionState.$stable << 3) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes ExposedDropdownMenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(expression = "menuAnchor(type, enabled)", imports = {}))
    public final Modifier menuAnchor(Modifier modifier) {
        return m3326menuAnchor2Hz36ac$default(this, modifier, ExposedDropdownMenuAnchorType.INSTANCE.m3323getPrimaryNotEditableoYjWRB4(), false, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012e  */
    /* JADX WARN: Code duplicated, block: B:104:0x013a  */
    /* JADX WARN: Code duplicated, block: B:106:0x0140  */
    /* JADX WARN: Code duplicated, block: B:107:0x0143  */
    /* JADX WARN: Code duplicated, block: B:111:0x014b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0153  */
    /* JADX WARN: Code duplicated, block: B:114:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x015b  */
    /* JADX WARN: Code duplicated, block: B:119:0x016a  */
    /* JADX WARN: Code duplicated, block: B:123:0x0173  */
    /* JADX WARN: Code duplicated, block: B:126:0x017c  */
    /* JADX WARN: Code duplicated, block: B:128:0x018e  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:146:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01db  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:158:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:163:0x0201  */
    /* JADX WARN: Code duplicated, block: B:164:0x0208  */
    /* JADX WARN: Code duplicated, block: B:166:0x020c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0213  */
    /* JADX WARN: Code duplicated, block: B:169:0x0217  */
    /* JADX WARN: Code duplicated, block: B:170:0x0225  */
    /* JADX WARN: Code duplicated, block: B:173:0x023b  */
    /* JADX WARN: Code duplicated, block: B:176:0x0279  */
    /* JADX WARN: Code duplicated, block: B:178:0x028e  */
    /* JADX WARN: Code duplicated, block: B:181:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x0101  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:93:0x0111  */
    /* JADX WARN: Code duplicated, block: B:94:0x0118  */
    /* JADX WARN: Code duplicated, block: B:96:0x011c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0126  */
    /* JADX WARN: Code duplicated, block: B:99:0x0129  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper ExposedDropdownMenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    /* JADX INFO: renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    public final void m3327ExposedDropdownMenukbRbctU(final boolean z, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, boolean z2, boolean z3, Shape shape, long j, float f, float f2, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function1;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        Shape shape2;
        long containerColor;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z5;
        Composer composer2;
        final ScrollState scrollState2;
        final float f3;
        final boolean z6;
        final Shape shape3;
        final long j2;
        final Modifier modifier3;
        final boolean z7;
        final float f4;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ScrollState scrollStateRememberScrollState;
        boolean z8;
        boolean z9;
        Shape shape4;
        float fM3754getTonalElevationD9Ej5fM;
        float fM3753getShadowElevationD9Ej5fM;
        BorderStroke borderStroke3;
        ScrollState scrollState3;
        float f5;
        boolean z10;
        Shape shape5;
        float f6;
        int i15;
        int i16;
        int i17;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1772805535);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,focusable,matchTextFieldWidth,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)401@18683L460:ExposedDropdownMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i19 = i3 & 4;
        if (i19 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                i4 |= ((i3 & 8) == 0 || !composerStartRestartGroup.changed(scrollState)) ? 1024 : 2048;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z4 = z3;
            } else {
                z4 = z3;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
            }
            if ((i & 1572864) == 0) {
                shape2 = shape;
                if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(shape2)) {
                    i18 = 524288;
                } else {
                    i18 = 1048576;
                }
                i4 |= i18;
            } else {
                shape2 = shape;
            }
            if ((i & 12582912) == 0) {
                containerColor = j;
                if ((i3 & 128) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                    i17 = 4194304;
                } else {
                    i17 = 8388608;
                }
                i4 |= i17;
            } else {
                containerColor = j;
            }
            i7 = i3 & 256;
            if (i7 != 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i4 |= i8;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 1024;
                if (i11 != 0) {
                    i12 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i2 | i13;
                } else {
                    i12 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 32;
                    } else {
                        i16 = 16;
                    }
                    i12 |= i16;
                }
                if ((i2 & 384) != 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i15 = 256;
                    } else {
                        i15 = 128;
                    }
                    i12 |= i15;
                }
                i14 = i12;
                if ((i4 & 306775187) == 306775186 || (i14 & Token.DOTQUERY) != 146) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "391@18251L21,394@18390L5,395@18442L14");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 8) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i4 &= -7169;
                        } else {
                            scrollStateRememberScrollState = scrollState;
                        }
                        if ((i3 & 16) != 0) {
                            z8 = true;
                        } else {
                            z8 = z2;
                        }
                        z9 = i5 == 0 ? z4 : true;
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i4 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -29360129;
                        }
                        if (i7 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i9 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            scrollState3 = scrollStateRememberScrollState;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            z10 = z9;
                            shape5 = shape4;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            scrollState3 = scrollStateRememberScrollState;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            z10 = z9;
                            shape5 = shape4;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        scrollState3 = scrollState;
                        z8 = z2;
                        f5 = f;
                        f6 = f2;
                        borderStroke3 = borderStroke;
                        z10 = z4;
                        shape5 = shape2;
                    }
                    long j3 = containerColor;
                    Modifier modifier4 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1772805535, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
                    }
                    int i20 = i4 >> 3;
                    composer2 = composerStartRestartGroup;
                    m3328ExposedDropdownMenuvNxi1II(z, function1, modifier4, scrollState3, z10, shape5, j3, f5, f6, borderStroke3, function3, composer2, (i4 & 8190) | (57344 & i20) | (458752 & i20) | (3670016 & i20) | (29360128 & i20) | (i20 & 234881024) | ((i14 << 27) & C.ENCODING_PCM_DOUBLE), (i14 >> 3) & 126, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z8;
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                    z6 = z10;
                    shape3 = shape5;
                    j2 = j3;
                    f3 = f5;
                    f4 = f6;
                    borderStroke2 = borderStroke3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    scrollState2 = scrollState;
                    f3 = f;
                    z6 = z4;
                    shape3 = shape2;
                    j2 = containerColor;
                    modifier3 = modifier2;
                    z7 = z2;
                    f4 = f2;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_kbRbctU$lambda$0(this.f$0, z, function0, modifier3, scrollState2, z7, z6, shape3, j2, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i3 & 1024;
            if (i11 != 0) {
                i12 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i2 | i13;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i12 |= i16;
            }
            if ((i2 & 384) != 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i12 |= i15;
            }
            i14 = i12;
            if ((i4 & 306775187) == 306775186) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "391@18251L21,394@18390L5,395@18442L14");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    if ((i3 & 16) != 0) {
                        z8 = true;
                    } else {
                        z8 = z2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                } else {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    if ((i3 & 16) != 0) {
                        z8 = true;
                    } else {
                        z8 = z2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                }
                long j4 = containerColor;
                Modifier modifier5 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1772805535, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
                }
                int i21 = i4 >> 3;
                composer2 = composerStartRestartGroup;
                m3328ExposedDropdownMenuvNxi1II(z, function1, modifier5, scrollState3, z10, shape5, j4, f5, f6, borderStroke3, function3, composer2, (i4 & 8190) | (57344 & i21) | (458752 & i21) | (3670016 & i21) | (29360128 & i21) | (i21 & 234881024) | ((i14 << 27) & C.ENCODING_PCM_DOUBLE), (i14 >> 3) & 126, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
                modifier3 = modifier5;
                scrollState2 = scrollState3;
                z6 = z10;
                shape3 = shape5;
                j2 = j4;
                f3 = f5;
                f4 = f6;
                borderStroke2 = borderStroke3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                scrollState2 = scrollState;
                f3 = f;
                z6 = z4;
                shape3 = shape2;
                j2 = containerColor;
                modifier3 = modifier2;
                z7 = z2;
                f4 = f2;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_kbRbctU$lambda$0(this.f$0, z, function0, modifier3, scrollState2, z7, z6, shape3, j2, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i & 3072) != 0) {
            i4 |= ((i3 & 8) == 0 || !composerStartRestartGroup.changed(scrollState)) ? 1024 : 2048;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
        }
        if ((i & 1572864) == 0) {
            shape2 = shape;
            if ((i3 & 64) == 0) {
                i18 = 524288;
            } else {
                i18 = 524288;
            }
            i4 |= i18;
        } else {
            shape2 = shape;
        }
        if ((i & 12582912) == 0) {
            containerColor = j;
            if ((i3 & 128) == 0) {
                i17 = 4194304;
            } else {
                i17 = 4194304;
            }
            i4 |= i17;
        } else {
            containerColor = j;
        }
        i7 = i3 & 256;
        if (i7 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i4 |= i8;
        }
        i9 = i3 & 512;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            i11 = i3 & 1024;
            if (i11 != 0) {
                i12 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i2 | i13;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i12 |= i16;
            }
            if ((i2 & 384) != 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i12 |= i15;
            }
            i14 = i12;
            if ((i4 & 306775187) == 306775186) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "391@18251L21,394@18390L5,395@18442L14");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    if ((i3 & 16) != 0) {
                        z8 = true;
                    } else {
                        z8 = z2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                } else {
                    if (i19 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 8) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i4 &= -7169;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    if ((i3 & 16) != 0) {
                        z8 = true;
                    } else {
                        z8 = z2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i4 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -29360129;
                    }
                    if (i7 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i9 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        scrollState3 = scrollStateRememberScrollState;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        z10 = z9;
                        shape5 = shape4;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                }
                long j5 = containerColor;
                Modifier modifier6 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1772805535, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
                }
                int i22 = i4 >> 3;
                composer2 = composerStartRestartGroup;
                m3328ExposedDropdownMenuvNxi1II(z, function1, modifier6, scrollState3, z10, shape5, j5, f5, f6, borderStroke3, function3, composer2, (i4 & 8190) | (57344 & i22) | (458752 & i22) | (3670016 & i22) | (29360128 & i22) | (i22 & 234881024) | ((i14 << 27) & C.ENCODING_PCM_DOUBLE), (i14 >> 3) & 126, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
                modifier3 = modifier6;
                scrollState2 = scrollState3;
                z6 = z10;
                shape3 = shape5;
                j2 = j5;
                f3 = f5;
                f4 = f6;
                borderStroke2 = borderStroke3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                scrollState2 = scrollState;
                f3 = f;
                z6 = z4;
                shape3 = shape2;
                j2 = containerColor;
                modifier3 = modifier2;
                z7 = z2;
                f4 = f2;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_kbRbctU$lambda$0(this.f$0, z, function0, modifier3, scrollState2, z7, z6, shape3, j2, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i11 = i3 & 1024;
        if (i11 != 0) {
            i12 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i2 | i13;
        } else {
            i12 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i12 |= i16;
        }
        if ((i2 & 384) != 0) {
            if (composerStartRestartGroup.changed(this)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i12 |= i15;
        }
        i14 = i12;
        if ((i4 & 306775187) == 306775186) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "391@18251L21,394@18390L5,395@18442L14");
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 8) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -7169;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                if ((i3 & 16) != 0) {
                    z8 = true;
                } else {
                    z8 = z2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                } else {
                    shape4 = shape2;
                }
                if ((i3 & 128) != 0) {
                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -29360129;
                }
                if (i7 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                } else {
                    fM3754getTonalElevationD9Ej5fM = f;
                }
                if (i9 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                } else {
                    fM3753getShadowElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    scrollState3 = scrollStateRememberScrollState;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    z10 = z9;
                    shape5 = shape4;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                    scrollState3 = scrollStateRememberScrollState;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    z10 = z9;
                    shape5 = shape4;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                }
            } else {
                if (i19 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 8) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i4 &= -7169;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                if ((i3 & 16) != 0) {
                    z8 = true;
                } else {
                    z8 = z2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i4 &= -3670017;
                } else {
                    shape4 = shape2;
                }
                if ((i3 & 128) != 0) {
                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -29360129;
                }
                if (i7 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                } else {
                    fM3754getTonalElevationD9Ej5fM = f;
                }
                if (i9 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                } else {
                    fM3753getShadowElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    scrollState3 = scrollStateRememberScrollState;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    z10 = z9;
                    shape5 = shape4;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                    scrollState3 = scrollStateRememberScrollState;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    z10 = z9;
                    shape5 = shape4;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                }
            }
            long j6 = containerColor;
            Modifier modifier7 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1772805535, i4, i14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
            }
            int i23 = i4 >> 3;
            composer2 = composerStartRestartGroup;
            m3328ExposedDropdownMenuvNxi1II(z, function1, modifier7, scrollState3, z10, shape5, j6, f5, f6, borderStroke3, function3, composer2, (i4 & 8190) | (57344 & i23) | (458752 & i23) | (3670016 & i23) | (29360128 & i23) | (i23 & 234881024) | ((i14 << 27) & C.ENCODING_PCM_DOUBLE), (i14 >> 3) & 126, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z7 = z8;
            modifier3 = modifier7;
            scrollState2 = scrollState3;
            z6 = z10;
            shape3 = shape5;
            j2 = j6;
            f3 = f5;
            f4 = f6;
            borderStroke2 = borderStroke3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            scrollState2 = scrollState;
            f3 = f;
            z6 = z4;
            shape3 = shape2;
            j2 = containerColor;
            modifier3 = modifier2;
            z7 = z2;
            f4 = f2;
            borderStroke2 = borderStroke;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_kbRbctU$lambda$0(this.f$0, z, function0, modifier3, scrollState2, z7, z6, shape3, j2, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:83:0x0134  */
    /* JADX WARN: Code duplicated, block: B:85:0x013a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0145  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.material3.ExposedDropdownMenuBoxScope] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    public final /* synthetic */ void ExposedDropdownMenu(final boolean z, final Function0 function0, Modifier modifier, ScrollState scrollState, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final ScrollState scrollState2;
        Function3 function4;
        ?? r8;
        boolean z2;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier3;
        ScrollState scrollStateRememberScrollState;
        Object obj;
        int i4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1501437777);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,content)436@19905L5,437@19954L14,430@19657L498:ExposedDropdownMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
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
                obj = this;
                if (composerStartRestartGroup.changed(obj)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
                r8 = obj;
            } else {
                r8 = this;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "427@19565L21");
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
                        ComposerKt.traceEventStart(-1501437777, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:430)");
                    }
                    int i8 = i3 >> 9;
                    Composer composer3 = composerStartRestartGroup;
                    r8.m3327ExposedDropdownMenukbRbctU(z, function0, modifier3, scrollStateRememberScrollState, false, true, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function4, composer3, (i3 & 14) | 906166272 | (i3 & 112) | (i3 & 896) | (i3 & 7168), (i8 & 112) | 6 | (i8 & 896), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    scrollState2 = scrollStateRememberScrollState;
                    composer2 = composer3;
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
                    ComposerKt.traceEventStart(-1501437777, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:430)");
                }
                int i9 = i3 >> 9;
                Composer composer4 = composerStartRestartGroup;
                r8.m3327ExposedDropdownMenukbRbctU(z, function0, modifier3, scrollStateRememberScrollState, false, true, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function4, composer4, (i3 & 14) | 906166272 | (i3 & 112) | (i3 & 896) | (i3 & 7168), (i9 & 112) | 6 | (i9 & 896), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                scrollState2 = scrollStateRememberScrollState;
                composer2 = composer4;
            } else {
                Composer composer5 = composerStartRestartGroup;
                composer5.skipToGroupEnd();
                composer2 = composer5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$0(this.f$0, z, function0, modifier2, scrollState2, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
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
            obj = this;
            if (composerStartRestartGroup.changed(obj)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
            r8 = obj;
        } else {
            r8 = this;
        }
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "427@19565L21");
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
                ComposerKt.traceEventStart(-1501437777, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:430)");
            }
            int i10 = i3 >> 9;
            Composer composer6 = composerStartRestartGroup;
            r8.m3327ExposedDropdownMenukbRbctU(z, function0, modifier3, scrollStateRememberScrollState, false, true, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function4, composer6, (i3 & 14) | 906166272 | (i3 & 112) | (i3 & 896) | (i3 & 7168), (i10 & 112) | 6 | (i10 & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            scrollState2 = scrollStateRememberScrollState;
            composer2 = composer6;
        } else {
            Composer composer7 = composerStartRestartGroup;
            composer7.skipToGroupEnd();
            composer2 = composer7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$0(this.f$0, z, function0, modifier2, scrollState2, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }
}

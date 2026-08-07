package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001ac\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001f\"\u0014\u0010 \u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "scrollState", "Landroidx/compose/foundation/ScrollState;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", ViewProps.ON_CLICK, "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DefaultMenuProperties", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$0(Function0 function0, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        DropdownMenuItem(function0, modifier, z, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_4kj__NE$lambda$4(boolean z, Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2243DropdownMenu4kj_NE(z, function0, modifier, j, scrollState, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_ILWXrKs$lambda$0(boolean z, Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2244DropdownMenuILWXrKs(z, function0, modifier, j, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:74:0x0105  */
    /* JADX WARN: Code duplicated, block: B:77:0x0131  */
    /* JADX WARN: Code duplicated, block: B:79:0x013a  */
    /* JADX WARN: Code duplicated, block: B:82:0x014b  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final /* synthetic */ void m2244DropdownMenuILWXrKs(final boolean z, final Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        int i7;
        Function3 function4;
        int i8;
        boolean z2;
        final Modifier modifier3;
        Composer composer2;
        final long j2;
        final PopupProperties popupProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long jM9743constructorimpl;
        PopupProperties popupProperties3;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2042390678);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,properties,content)61@2359L21,56@2195L252:AndroidMenu.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(popupProperties)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                } else {
                    function4 = function3;
                }
                i8 = 0;
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    j2 = j;
                    popupProperties2 = popupProperties;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        float f = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) << 32));
                        i8 = 0;
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                    } else {
                        popupProperties3 = popupProperties;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2042390678, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:56)");
                    }
                    int i11 = i8;
                    ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(i11, composerStartRestartGroup, i11, 1);
                    int i12 = i3 & 8190;
                    int i13 = i3 << 3;
                    m2243DropdownMenu4kj_NE(z, function0, modifier4, jM9743constructorimpl, scrollStateRememberScrollState, popupProperties3, function4, composerStartRestartGroup, i12 | (458752 & i13) | (i13 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier4;
                    j2 = jM9743constructorimpl;
                    popupProperties2 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            } else {
                function4 = function3;
            }
            i8 = 0;
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                j2 = j;
                popupProperties2 = popupProperties;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    float f2 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) << 32));
                    i8 = 0;
                } else {
                    jM9743constructorimpl = j;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                } else {
                    popupProperties3 = popupProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2042390678, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:56)");
                }
                int i14 = i8;
                ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(i14, composerStartRestartGroup, i14, 1);
                int i15 = i3 & 8190;
                int i16 = i3 << 3;
                m2243DropdownMenu4kj_NE(z, function0, modifier4, jM9743constructorimpl, scrollStateRememberScrollState2, popupProperties3, function4, composerStartRestartGroup, i15 | (458752 & i16) | (i16 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                j2 = jM9743constructorimpl;
                popupProperties2 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changed(j)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(popupProperties)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            } else {
                function4 = function3;
            }
            i8 = 0;
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                j2 = j;
                popupProperties2 = popupProperties;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    float f3 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) << 32));
                    i8 = 0;
                } else {
                    jM9743constructorimpl = j;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                } else {
                    popupProperties3 = popupProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2042390678, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:56)");
                }
                int i17 = i8;
                ScrollState scrollStateRememberScrollState3 = ScrollKt.rememberScrollState(i17, composerStartRestartGroup, i17, 1);
                int i18 = i3 & 8190;
                int i19 = i3 << 3;
                m2243DropdownMenu4kj_NE(z, function0, modifier4, jM9743constructorimpl, scrollStateRememberScrollState3, popupProperties3, function4, composerStartRestartGroup, i18 | (458752 & i19) | (i19 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                j2 = jM9743constructorimpl;
                popupProperties2 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        if ((196608 & i) == 0) {
            function4 = function3;
            if (composerStartRestartGroup.changedInstance(function4)) {
                i9 = 131072;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        } else {
            function4 = function3;
        }
        i8 = 0;
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            j2 = j;
            popupProperties2 = popupProperties;
        } else {
            if (i10 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                float f4 = 0;
                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) << 32));
                i8 = 0;
            } else {
                jM9743constructorimpl = j;
            }
            if (i6 != 0) {
                popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
            } else {
                popupProperties3 = popupProperties;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2042390678, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:56)");
            }
            int i110 = i8;
            ScrollState scrollStateRememberScrollState4 = ScrollKt.rememberScrollState(i110, composerStartRestartGroup, i110, 1);
            int i111 = i3 & 8190;
            int i112 = i3 << 3;
            m2243DropdownMenu4kj_NE(z, function0, modifier4, jM9743constructorimpl, scrollStateRememberScrollState4, popupProperties3, function4, composerStartRestartGroup, i111 | (458752 & i112) | (i112 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            modifier3 = modifier4;
            j2 = jM9743constructorimpl;
            popupProperties2 = popupProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x016f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0193  */
    /* JADX WARN: Code duplicated, block: B:109:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:111:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:114:0x020a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0253  */
    /* JADX WARN: Code duplicated, block: B:120:0x025c  */
    /* JADX WARN: Code duplicated, block: B:123:0x026a  */
    /* JADX WARN: Code duplicated, block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5 A[PHI: r0 r7 r11 r13
      0x00f5: PHI (r0v24 int) = (r0v11 int), (r0v28 int) binds: [B:94:0x0140, B:82:0x00f3] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r7v21 androidx.compose.ui.Modifier) = (r7v5 androidx.compose.ui.Modifier), (r7v2 androidx.compose.ui.Modifier) binds: [B:94:0x0140, B:82:0x00f3] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r11v8 long) = (r11v5 long), (r11v2 long) binds: [B:94:0x0140, B:82:0x00f3] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r13v13 androidx.compose.foundation.ScrollState) = (r13v7 androidx.compose.foundation.ScrollState), (r13v6 androidx.compose.foundation.ScrollState) binds: [B:94:0x0140, B:82:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:85:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0105  */
    /* JADX WARN: Code duplicated, block: B:88:0x010c  */
    /* JADX WARN: Code duplicated, block: B:89:0x0130  */
    /* JADX WARN: Code duplicated, block: B:92:0x0135  */
    /* JADX WARN: Code duplicated, block: B:93:0x013e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0142  */
    /* JADX WARN: Code duplicated, block: B:98:0x0152  */
    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    public static final void m2243DropdownMenu4kj_NE(final boolean z, final Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long jM9743constructorimpl;
        int i5;
        ScrollState scrollStateRememberScrollState;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        int i8;
        boolean z2;
        final Modifier modifier3;
        final ScrollState scrollState2;
        final PopupProperties popupProperties3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        PopupProperties popupProperties4;
        final Modifier modifier4;
        final ScrollState scrollState3;
        Object objRememberedValue;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        final MutableState mutableState;
        Object objRememberedValue3;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1275450738);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,content)76@2730L42:AndroidMenu.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    jM9743constructorimpl = j;
                    if (composerStartRestartGroup.changed(jM9743constructorimpl)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        scrollStateRememberScrollState = scrollState;
                        int i12 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    i3 |= i12;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        popupProperties2 = popupProperties;
                        if (composerStartRestartGroup.changed(popupProperties2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    i8 = i3;
                    if ((i3 & 599187) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                float f = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) << 32));
                            }
                            if ((i2 & 16) != 0) {
                                i9 = i8 & (-57345);
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            } else {
                                i9 = i8;
                            }
                            if (i6 != 0) {
                                popupProperties4 = DefaultMenuProperties;
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                            } else {
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                popupProperties4 = popupProperties2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i9 = i8 & (-57345);
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                popupProperties4 = popupProperties2;
                            } else {
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                popupProperties4 = popupProperties2;
                                i9 = i8;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new MutableTransitionState(false);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableTransitionState = (MutableTransitionState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(-622294666);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-625181200);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        popupProperties3 = popupProperties4;
                        scrollState2 = scrollState3;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                    }
                    j2 = jM9743constructorimpl;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                popupProperties2 = popupProperties;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f2 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            popupProperties4 = DefaultMenuProperties;
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                        } else {
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                            popupProperties4 = popupProperties2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f3 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            popupProperties4 = DefaultMenuProperties;
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                        } else {
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                            popupProperties4 = popupProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(-622294666);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density2, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-622294666);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density3, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties4;
                    scrollState2 = scrollState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                }
                j2 = jM9743constructorimpl;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            jM9743constructorimpl = j;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                    }
                    i3 |= i12;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i3 |= i12;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f4 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            popupProperties4 = DefaultMenuProperties;
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                        } else {
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                            popupProperties4 = popupProperties2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f5 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f5))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f5))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            popupProperties4 = DefaultMenuProperties;
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                        } else {
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                            popupProperties4 = popupProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(-622294666);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density4, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-622294666);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density5, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties4;
                    scrollState2 = scrollState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                }
                j2 = jM9743constructorimpl;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            popupProperties2 = popupProperties;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f6 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f6))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f6))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        popupProperties4 = DefaultMenuProperties;
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                    } else {
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        popupProperties4 = popupProperties2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f7 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f7))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f7))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        popupProperties4 = DefaultMenuProperties;
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                    } else {
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        popupProperties4 = popupProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(-622294666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density6 = (Density) objConsume6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density6, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-622294666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density7 = (Density) objConsume7;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density7, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                popupProperties3 = popupProperties4;
                scrollState2 = scrollState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            }
            j2 = jM9743constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                jM9743constructorimpl = j;
                if (composerStartRestartGroup.changed(jM9743constructorimpl)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                    }
                    i3 |= i12;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i3 |= i12;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f8 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f8))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f8))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            popupProperties4 = DefaultMenuProperties;
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                        } else {
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                            popupProperties4 = popupProperties2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f9 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f9))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f9))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            popupProperties4 = DefaultMenuProperties;
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                        } else {
                            modifier4 = modifier2;
                            scrollState3 = scrollStateRememberScrollState;
                            popupProperties4 = popupProperties2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(-622294666);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density8 = (Density) objConsume8;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density8, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-622294666);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Density density9 = (Density) objConsume9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density9, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties4;
                    scrollState2 = scrollState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                }
                j2 = jM9743constructorimpl;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            popupProperties2 = popupProperties;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f10 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f10))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f10))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        popupProperties4 = DefaultMenuProperties;
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                    } else {
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        popupProperties4 = popupProperties2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f11 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f11))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f11))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        popupProperties4 = DefaultMenuProperties;
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                    } else {
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        popupProperties4 = popupProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(-622294666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localDensity10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density10 = (Density) objConsume10;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density10, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-622294666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localDensity11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density11 = (Density) objConsume11;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density11, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                popupProperties3 = popupProperties4;
                scrollState2 = scrollState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            }
            j2 = jM9743constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        jM9743constructorimpl = j;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                scrollStateRememberScrollState = scrollState;
                if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                }
                i3 |= i12;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i3 |= i12;
        } else {
            scrollStateRememberScrollState = scrollState;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f12 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f12))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f12))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        popupProperties4 = DefaultMenuProperties;
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                    } else {
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        popupProperties4 = popupProperties2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f13 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f13))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f13))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        popupProperties4 = DefaultMenuProperties;
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                    } else {
                        modifier4 = modifier2;
                        scrollState3 = scrollStateRememberScrollState;
                        popupProperties4 = popupProperties2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(-622294666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density12 = (Density) objConsume12;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density12, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-622294666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localDensity13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density13 = (Density) objConsume13;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density13, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                popupProperties3 = popupProperties4;
                scrollState2 = scrollState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            }
            j2 = jM9743constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        popupProperties2 = popupProperties;
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        i8 = i3;
        if ((i3 & 599187) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    float f14 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f14))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f14))) << 32));
                }
                if ((i2 & 16) != 0) {
                    i9 = i8 & (-57345);
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    popupProperties4 = DefaultMenuProperties;
                    modifier4 = modifier2;
                    scrollState3 = scrollStateRememberScrollState;
                } else {
                    modifier4 = modifier2;
                    scrollState3 = scrollStateRememberScrollState;
                    popupProperties4 = popupProperties2;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    float f15 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f15))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f15))) << 32));
                }
                if ((i2 & 16) != 0) {
                    i9 = i8 & (-57345);
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    popupProperties4 = DefaultMenuProperties;
                    modifier4 = modifier2;
                    scrollState3 = scrollStateRememberScrollState;
                } else {
                    modifier4 = modifier2;
                    scrollState3 = scrollStateRememberScrollState;
                    popupProperties4 = popupProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1275450738, i9, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MutableTransitionState(false);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableTransitionState = (MutableTransitionState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
            if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(-622294666);
                ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localDensity14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density14 = (Density) objConsume14;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density14, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-622294666);
                ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localDensity15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density15 = (Density) objConsume15;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9743constructorimpl, density15, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 112) | 3072 | ((i9 >> 9) & 896), 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            popupProperties3 = popupProperties4;
            scrollState2 = scrollState3;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            scrollState2 = scrollStateRememberScrollState;
            popupProperties3 = popupProperties2;
        }
        j2 = jM9743constructorimpl;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_4kj__NE$lambda$2$0(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m7216boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_4kj__NE$lambda$3(MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Modifier modifier, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C92@3434L259:AndroidMenu.android.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1788768427, i, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:92)");
            }
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState, modifier, function3, composer, MutableTransitionState.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x0103  */
    /* JADX WARN: Code duplicated, block: B:90:0x0112  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    public static final void DropdownMenuItem(final Function0<Unit> function0, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        final PaddingValues paddingValues2;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z5;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource3;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(670540513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItem)N(onClick,modifier,enabled,contentPadding,interactionSource,content)112@3970L160:AndroidMenu.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
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
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                        if ((74899 & i3) != 74898) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            paddingValues2 = paddingValues;
                            modifier3 = modifier2;
                            z4 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        } else {
                            if (i11 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i8 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                            }
                            MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z5;
                            paddingValues2 = dropdownMenuItemContentPadding;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i8 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                        }
                        MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i8 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                        }
                        MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i8 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                        }
                        MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i8 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                }
                MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource2 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
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
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i8 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                        }
                        MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        paddingValues2 = dropdownMenuItemContentPadding;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i8 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                }
                MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource2 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                    }
                    MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    paddingValues2 = dropdownMenuItemContentPadding;
                    mutableInteractionSource2 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i8 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                }
                MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource2 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i8 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                }
                MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                paddingValues2 = dropdownMenuItemContentPadding;
                mutableInteractionSource2 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 131072;
            } else {
                i10 = 65536;
            }
            i3 |= i10;
        }
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            paddingValues2 = paddingValues;
            modifier3 = modifier2;
            z4 = z2;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            if (i11 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (i6 != 0) {
                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
            } else {
                dropdownMenuItemContentPadding = paddingValues;
            }
            if (i8 != 0) {
                mutableInteractionSource3 = null;
            } else {
                mutableInteractionSource3 = mutableInteractionSource;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
            }
            MenuKt.DropdownMenuItemContent(function0, modifier4, z5, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z4 = z5;
            paddingValues2 = dropdownMenuItemContentPadding;
            mutableInteractionSource2 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z4, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return DefaultMenuProperties;
    }
}

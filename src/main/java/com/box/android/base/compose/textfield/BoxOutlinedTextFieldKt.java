package com.box.android.base.compose.textfield;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxOutlinedTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¹\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u001c\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"BoxOutlinedTextField", "", "text", "", "onTextChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", ReactTextInputShadowNode.PROP_PLACEHOLDER, "minLines", "", "maxLines", "isError", "containerColor", "Landroidx/compose/ui/graphics/Color;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onFocusChanged", "Landroidx/compose/ui/focus/FocusState;", "BoxOutlinedTextField-htLuCmU", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IIZJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "boxOutlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "boxOutlinedTextFieldColors-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "BoxOutlinedTextFieldPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxOutlinedTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxOutlinedTextFieldPreview$lambda$0(int i, Composer composer, int i2) {
        BoxOutlinedTextFieldPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxOutlinedTextField_htLuCmU$lambda$0(String str, Function1 function1, Modifier modifier, boolean z, Function2 function2, Function2 function3, int i, int i2, boolean z2, long j, MutableInteractionSource mutableInteractionSource, Function1 function4, int i3, int i4, int i5, Composer composer, int i6) {
        m11739BoxOutlinedTextFieldhtLuCmU(str, function1, modifier, z, function2, function3, i, i2, z2, j, mutableInteractionSource, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0135  */
    /* JADX WARN: Code duplicated, block: B:105:0x013c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:109:0x0148  */
    /* JADX WARN: Code duplicated, block: B:110:0x014b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0150  */
    /* JADX WARN: Code duplicated, block: B:115:0x015a  */
    /* JADX WARN: Code duplicated, block: B:116:0x015f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0163  */
    /* JADX WARN: Code duplicated, block: B:120:0x016d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0170  */
    /* JADX WARN: Code duplicated, block: B:123:0x0175  */
    /* JADX WARN: Code duplicated, block: B:126:0x0188  */
    /* JADX WARN: Code duplicated, block: B:130:0x0192  */
    /* JADX WARN: Code duplicated, block: B:133:0x019b  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:142:0x01cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:148:0x01da  */
    /* JADX WARN: Code duplicated, block: B:150:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:155:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:158:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:162:0x0202  */
    /* JADX WARN: Code duplicated, block: B:164:0x0206  */
    /* JADX WARN: Code duplicated, block: B:165:0x0208  */
    /* JADX WARN: Code duplicated, block: B:168:0x0215  */
    /* JADX WARN: Code duplicated, block: B:169:0x0217  */
    /* JADX WARN: Code duplicated, block: B:173:0x0229  */
    /* JADX WARN: Code duplicated, block: B:176:0x0238  */
    /* JADX WARN: Code duplicated, block: B:179:0x0293  */
    /* JADX WARN: Code duplicated, block: B:181:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:184:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:47:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:87:0x0107  */
    /* JADX WARN: Code duplicated, block: B:88:0x010a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0119  */
    /* JADX WARN: Code duplicated, block: B:95:0x011d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0128 A[ADDED_TO_REGION] */
    /* JADX INFO: renamed from: BoxOutlinedTextField-htLuCmU, reason: not valid java name */
    public static final void m11739BoxOutlinedTextFieldhtLuCmU(final String text, final Function1<? super String, Unit> onTextChange, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, int i, int i2, boolean z2, long j, MutableInteractionSource mutableInteractionSource, Function1<? super FocusState, Unit> function1, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z3;
        int i8;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i10;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z4;
        Composer composer2;
        final boolean z5;
        final Function1<? super FocusState, Unit> function6;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final int i26;
        final Modifier modifier3;
        final boolean z6;
        final int i27;
        final long j2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i28;
        long jM11498getAppBackground0d7_KjU;
        MutableInteractionSource mutableInteractionSource3;
        int i29;
        int i30;
        MutableInteractionSource mutableInteractionSource4;
        boolean z7;
        boolean z8;
        Function1<? super FocusState, Unit> function9;
        int i31;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        long j3;
        Modifier modifierFillMaxWidth$default;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onTextChange, "onTextChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(188361261);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxOutlinedTextField)N(text,onTextChange,modifier,enabled,label,placeholder,minLines,maxLines,isError,containerColor:c#ui.graphics.Color,interactionSource,onFocusChanged)73@3312L42,62@2965L395:BoxOutlinedTextField.kt#fjpkir");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(onTextChange) ? 32 : 16;
        }
        int i32 = i5 & 4;
        if (i32 == 0) {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 != 0) {
                if ((i3 & 3072) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i6 |= i8;
                }
                i9 = i5 & 16;
                if (i9 != 0) {
                    if ((i3 & 24576) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i6 |= i10;
                    }
                    i11 = i5 & 32;
                    if (i11 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function5 = function3;
                    } else {
                        function5 = function3;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i12 = 131072;
                            } else {
                                i12 = 65536;
                            }
                            i6 |= i12;
                        }
                    }
                    i13 = i5 & 64;
                    if (i13 != 0) {
                        i6 |= 1572864;
                        i14 = i;
                    } else {
                        i14 = i;
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(i14)) {
                                i15 = 1048576;
                            } else {
                                i15 = 524288;
                            }
                            i6 |= i15;
                        }
                    }
                    i16 = i5 & 128;
                    if (i16 != 0) {
                        i6 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                        i6 |= i17;
                    }
                    i18 = i5 & 256;
                    if (i18 != 0) {
                        if ((i3 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(z2)) {
                                i19 = 67108864;
                            } else {
                                i19 = 33554432;
                            }
                            i6 |= i19;
                        }
                        if ((i3 & 805306368) != 0) {
                            i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                        }
                        i20 = i5 & 1024;
                        if (i20 != 0) {
                            i21 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i22 = 4;
                            } else {
                                i22 = 2;
                            }
                            i21 = i4 | i22;
                        } else {
                            i21 = i4;
                        }
                        i23 = i5 & 2048;
                        if (i23 != 0) {
                            i21 |= 48;
                        } else if ((i4 & 48) != 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i24 = 32;
                            } else {
                                i24 = 16;
                            }
                            i21 |= i24;
                        }
                        i25 = i21;
                        if ((i6 & 306783379) == 306783378 || (i25 & 19) != 18) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                            if ((i3 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i32 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i7 != 0) {
                                    z3 = true;
                                }
                                if (i9 != 0) {
                                    function4 = null;
                                }
                                if (i11 != 0) {
                                    function5 = null;
                                }
                                if (i13 != 0) {
                                    i14 = 1;
                                }
                                if (i16 != 0) {
                                    i28 = Integer.MAX_VALUE;
                                } else {
                                    i28 = i2;
                                }
                                boolean z9 = i18 == 0 ? z2 : false;
                                if ((i5 & 512) != 0) {
                                    jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                    i6 &= -1879048193;
                                } else {
                                    jM11498getAppBackground0d7_KjU = j;
                                }
                                if (i20 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                i29 = i28;
                                i30 = i14;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                z7 = z3;
                                z8 = z9;
                                if (i23 != 0) {
                                    function9 = null;
                                } else {
                                    function9 = function1;
                                }
                                long j4 = jM11498getAppBackground0d7_KjU;
                                i31 = i6;
                                function10 = function4;
                                function11 = function5;
                                j3 = j4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i5 & 512) != 0) {
                                    i6 &= -1879048193;
                                }
                                i29 = i2;
                                z8 = z2;
                                mutableInteractionSource4 = mutableInteractionSource;
                                i31 = i6;
                                function10 = function4;
                                function11 = function5;
                                i30 = i14;
                                companion = modifier2;
                                z7 = z3;
                                j3 = j;
                                function9 = function1;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                            }
                            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                            if (function9 != null) {
                                modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                            }
                            TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                            int i33 = i31 << 6;
                            int i34 = (i31 & 7294) | (3670016 & i33) | (i33 & 29360128);
                            int i35 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                            int i36 = i25 & 14;
                            composer2 = composerStartRestartGroup;
                            long j5 = j3;
                            Function1<? super FocusState, Unit> function12 = function9;
                            Modifier modifier4 = companion;
                            OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U, composer2, i34, i35, i36, 2350896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z7;
                            function7 = function10;
                            function8 = function11;
                            z5 = z8;
                            i27 = i29;
                            i26 = i30;
                            mutableInteractionSource2 = mutableInteractionSource4;
                            modifier3 = modifier4;
                            function6 = function12;
                            j2 = j5;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z5 = z2;
                            function6 = function1;
                            function7 = function4;
                            function8 = function5;
                            i26 = i14;
                            modifier3 = modifier2;
                            z6 = z3;
                            i27 = i2;
                            j2 = j;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i6 |= 100663296;
                    if ((i3 & 805306368) != 0) {
                        i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    i20 = i5 & 1024;
                    if (i20 != 0) {
                        i21 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i22 = 4;
                        } else {
                            i22 = 2;
                        }
                        i21 = i4 | i22;
                    } else {
                        i21 = i4;
                    }
                    i23 = i5 & 2048;
                    if (i23 != 0) {
                        i21 |= 48;
                    } else if ((i4 & 48) != 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i24 = 32;
                        } else {
                            i24 = 16;
                        }
                        i21 |= i24;
                    }
                    i25 = i21;
                    if ((i6 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                        if ((i3 & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j6 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j6;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j7 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                        }
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                        if (function9 != null) {
                            modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                        }
                        TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U2 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                        int i37 = i31 << 6;
                        int i38 = (i31 & 7294) | (3670016 & i37) | (i37 & 29360128);
                        int i39 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                        int i310 = i25 & 14;
                        composer2 = composerStartRestartGroup;
                        long j8 = j3;
                        Function1<? super FocusState, Unit> function13 = function9;
                        Modifier modifier5 = companion;
                        OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U2, composer2, i38, i39, i310, 2350896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z7;
                        function7 = function10;
                        function8 = function11;
                        z5 = z8;
                        i27 = i29;
                        i26 = i30;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        modifier3 = modifier5;
                        function6 = function13;
                        j2 = j8;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z2;
                        function6 = function1;
                        function7 = function4;
                        function8 = function5;
                        i26 = i14;
                        modifier3 = modifier2;
                        z6 = z3;
                        i27 = i2;
                        j2 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 24576;
                function4 = function2;
                i11 = i5 & 32;
                if (i11 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function5 = function3;
                } else {
                    function5 = function3;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i6 |= i12;
                    }
                }
                i13 = i5 & 64;
                if (i13 != 0) {
                    i6 |= 1572864;
                    i14 = i;
                } else {
                    i14 = i;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i6 |= i15;
                    }
                }
                i16 = i5 & 128;
                if (i16 != 0) {
                    i6 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                    i6 |= i17;
                }
                i18 = i5 & 256;
                if (i18 != 0) {
                    if ((i3 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i19 = 67108864;
                        } else {
                            i19 = 33554432;
                        }
                        i6 |= i19;
                    }
                    if ((i3 & 805306368) != 0) {
                        i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    i20 = i5 & 1024;
                    if (i20 != 0) {
                        i21 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i22 = 4;
                        } else {
                            i22 = 2;
                        }
                        i21 = i4 | i22;
                    } else {
                        i21 = i4;
                    }
                    i23 = i5 & 2048;
                    if (i23 != 0) {
                        i21 |= 48;
                    } else if ((i4 & 48) != 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i24 = 32;
                        } else {
                            i24 = 16;
                        }
                        i21 |= i24;
                    }
                    i25 = i21;
                    if ((i6 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                        if ((i3 & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j9 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j9;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j10 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j10;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                        }
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                        if (function9 != null) {
                            modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                        }
                        TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U3 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                        int i311 = i31 << 6;
                        int i312 = (i31 & 7294) | (3670016 & i311) | (i311 & 29360128);
                        int i313 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                        int i314 = i25 & 14;
                        composer2 = composerStartRestartGroup;
                        long j11 = j3;
                        Function1<? super FocusState, Unit> function14 = function9;
                        Modifier modifier6 = companion;
                        OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U3, composer2, i312, i313, i314, 2350896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z7;
                        function7 = function10;
                        function8 = function11;
                        z5 = z8;
                        i27 = i29;
                        i26 = i30;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        modifier3 = modifier6;
                        function6 = function14;
                        j2 = j11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z2;
                        function6 = function1;
                        function7 = function4;
                        function8 = function5;
                        i26 = i14;
                        modifier3 = modifier2;
                        z6 = z3;
                        i27 = i2;
                        j2 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 100663296;
                if ((i3 & 805306368) != 0) {
                    i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                i20 = i5 & 1024;
                if (i20 != 0) {
                    i21 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i4 | i22;
                } else {
                    i21 = i4;
                }
                i23 = i5 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i4 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                if ((i6 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                    if ((i3 & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j12 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j12;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j13 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j13;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                    }
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (function9 != null) {
                        modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                    }
                    TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U4 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                    int i315 = i31 << 6;
                    int i316 = (i31 & 7294) | (3670016 & i315) | (i315 & 29360128);
                    int i317 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                    int i318 = i25 & 14;
                    composer2 = composerStartRestartGroup;
                    long j14 = j3;
                    Function1<? super FocusState, Unit> function15 = function9;
                    Modifier modifier7 = companion;
                    OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U4, composer2, i316, i317, i318, 2350896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z7;
                    function7 = function10;
                    function8 = function11;
                    z5 = z8;
                    i27 = i29;
                    i26 = i30;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier7;
                    function6 = function15;
                    j2 = j14;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z2;
                    function6 = function1;
                    function7 = function4;
                    function8 = function5;
                    i26 = i14;
                    modifier3 = modifier2;
                    z6 = z3;
                    i27 = i2;
                    j2 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 3072;
            z3 = z;
            i9 = i5 & 16;
            if (i9 != 0) {
                if ((i3 & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 32;
                if (i11 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function5 = function3;
                } else {
                    function5 = function3;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i6 |= i12;
                    }
                }
                i13 = i5 & 64;
                if (i13 != 0) {
                    i6 |= 1572864;
                    i14 = i;
                } else {
                    i14 = i;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i6 |= i15;
                    }
                }
                i16 = i5 & 128;
                if (i16 != 0) {
                    i6 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                    i6 |= i17;
                }
                i18 = i5 & 256;
                if (i18 != 0) {
                    if ((i3 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i19 = 67108864;
                        } else {
                            i19 = 33554432;
                        }
                        i6 |= i19;
                    }
                    if ((i3 & 805306368) != 0) {
                        i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    i20 = i5 & 1024;
                    if (i20 != 0) {
                        i21 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i22 = 4;
                        } else {
                            i22 = 2;
                        }
                        i21 = i4 | i22;
                    } else {
                        i21 = i4;
                    }
                    i23 = i5 & 2048;
                    if (i23 != 0) {
                        i21 |= 48;
                    } else if ((i4 & 48) != 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i24 = 32;
                        } else {
                            i24 = 16;
                        }
                        i21 |= i24;
                    }
                    i25 = i21;
                    if ((i6 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                        if ((i3 & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j15 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j15;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j16 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j16;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                        }
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                        if (function9 != null) {
                            modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                        }
                        TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U5 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                        int i319 = i31 << 6;
                        int i3110 = (i31 & 7294) | (3670016 & i319) | (i319 & 29360128);
                        int i3111 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                        int i3112 = i25 & 14;
                        composer2 = composerStartRestartGroup;
                        long j17 = j3;
                        Function1<? super FocusState, Unit> function16 = function9;
                        Modifier modifier8 = companion;
                        OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U5, composer2, i3110, i3111, i3112, 2350896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z7;
                        function7 = function10;
                        function8 = function11;
                        z5 = z8;
                        i27 = i29;
                        i26 = i30;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        modifier3 = modifier8;
                        function6 = function16;
                        j2 = j17;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z2;
                        function6 = function1;
                        function7 = function4;
                        function8 = function5;
                        i26 = i14;
                        modifier3 = modifier2;
                        z6 = z3;
                        i27 = i2;
                        j2 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 100663296;
                if ((i3 & 805306368) != 0) {
                    i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                i20 = i5 & 1024;
                if (i20 != 0) {
                    i21 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i4 | i22;
                } else {
                    i21 = i4;
                }
                i23 = i5 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i4 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                if ((i6 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                    if ((i3 & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j18 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j18;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j19 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                    }
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (function9 != null) {
                        modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                    }
                    TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U6 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                    int i3113 = i31 << 6;
                    int i3114 = (i31 & 7294) | (3670016 & i3113) | (i3113 & 29360128);
                    int i3115 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                    int i3116 = i25 & 14;
                    composer2 = composerStartRestartGroup;
                    long j110 = j3;
                    Function1<? super FocusState, Unit> function17 = function9;
                    Modifier modifier9 = companion;
                    OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U6, composer2, i3114, i3115, i3116, 2350896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z7;
                    function7 = function10;
                    function8 = function11;
                    z5 = z8;
                    i27 = i29;
                    i26 = i30;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier9;
                    function6 = function17;
                    j2 = j110;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z2;
                    function6 = function1;
                    function7 = function4;
                    function8 = function5;
                    i26 = i14;
                    modifier3 = modifier2;
                    z6 = z3;
                    i27 = i2;
                    j2 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 24576;
            function4 = function2;
            i11 = i5 & 32;
            if (i11 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
            } else {
                function5 = function3;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i6 |= i12;
                }
            }
            i13 = i5 & 64;
            if (i13 != 0) {
                i6 |= 1572864;
                i14 = i;
            } else {
                i14 = i;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i6 |= i15;
                }
            }
            i16 = i5 & 128;
            if (i16 != 0) {
                i6 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i17 = 8388608;
                } else {
                    i17 = 4194304;
                }
                i6 |= i17;
            }
            i18 = i5 & 256;
            if (i18 != 0) {
                if ((i3 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i19 = 67108864;
                    } else {
                        i19 = 33554432;
                    }
                    i6 |= i19;
                }
                if ((i3 & 805306368) != 0) {
                    i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                i20 = i5 & 1024;
                if (i20 != 0) {
                    i21 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i4 | i22;
                } else {
                    i21 = i4;
                }
                i23 = i5 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i4 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                if ((i6 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                    if ((i3 & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j111 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j111;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j112 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j112;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                    }
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (function9 != null) {
                        modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                    }
                    TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U7 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                    int i3117 = i31 << 6;
                    int i3118 = (i31 & 7294) | (3670016 & i3117) | (i3117 & 29360128);
                    int i3119 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                    int i31110 = i25 & 14;
                    composer2 = composerStartRestartGroup;
                    long j113 = j3;
                    Function1<? super FocusState, Unit> function18 = function9;
                    Modifier modifier10 = companion;
                    OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U7, composer2, i3118, i3119, i31110, 2350896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z7;
                    function7 = function10;
                    function8 = function11;
                    z5 = z8;
                    i27 = i29;
                    i26 = i30;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier10;
                    function6 = function18;
                    j2 = j113;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z2;
                    function6 = function1;
                    function7 = function4;
                    function8 = function5;
                    i26 = i14;
                    modifier3 = modifier2;
                    z6 = z3;
                    i27 = i2;
                    j2 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 100663296;
            if ((i3 & 805306368) != 0) {
                i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i20 = i5 & 1024;
            if (i20 != 0) {
                i21 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i4 | i22;
            } else {
                i21 = i4;
            }
            i23 = i5 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i4 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            if ((i6 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                if ((i3 & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j114 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j114;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j115 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j115;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                }
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                if (function9 != null) {
                    modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                }
                TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U8 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                int i31111 = i31 << 6;
                int i31112 = (i31 & 7294) | (3670016 & i31111) | (i31111 & 29360128);
                int i31113 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                int i31114 = i25 & 14;
                composer2 = composerStartRestartGroup;
                long j116 = j3;
                Function1<? super FocusState, Unit> function19 = function9;
                Modifier modifier11 = companion;
                OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U8, composer2, i31112, i31113, i31114, 2350896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
                function7 = function10;
                function8 = function11;
                z5 = z8;
                i27 = i29;
                i26 = i30;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier11;
                function6 = function19;
                j2 = j116;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z2;
                function6 = function1;
                function7 = function4;
                function8 = function5;
                i26 = i14;
                modifier3 = modifier2;
                z6 = z3;
                i27 = i2;
                j2 = j;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 384;
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 != 0) {
            if ((i3 & 3072) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i6 |= i8;
            }
            i9 = i5 & 16;
            if (i9 != 0) {
                if ((i3 & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 32;
                if (i11 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function5 = function3;
                } else {
                    function5 = function3;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i6 |= i12;
                    }
                }
                i13 = i5 & 64;
                if (i13 != 0) {
                    i6 |= 1572864;
                    i14 = i;
                } else {
                    i14 = i;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i14)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i6 |= i15;
                    }
                }
                i16 = i5 & 128;
                if (i16 != 0) {
                    i6 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                    i6 |= i17;
                }
                i18 = i5 & 256;
                if (i18 != 0) {
                    if ((i3 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i19 = 67108864;
                        } else {
                            i19 = 33554432;
                        }
                        i6 |= i19;
                    }
                    if ((i3 & 805306368) != 0) {
                        i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    i20 = i5 & 1024;
                    if (i20 != 0) {
                        i21 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i22 = 4;
                        } else {
                            i22 = 2;
                        }
                        i21 = i4 | i22;
                    } else {
                        i21 = i4;
                    }
                    i23 = i5 & 2048;
                    if (i23 != 0) {
                        i21 |= 48;
                    } else if ((i4 & 48) != 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i24 = 32;
                        } else {
                            i24 = 16;
                        }
                        i21 |= i24;
                    }
                    i25 = i21;
                    if ((i6 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                        if ((i3 & 1) != 0) {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j117 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j117;
                        } else {
                            if (i32 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                z3 = true;
                            }
                            if (i9 != 0) {
                                function4 = null;
                            }
                            if (i11 != 0) {
                                function5 = null;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                            }
                            if (i16 != 0) {
                                i28 = Integer.MAX_VALUE;
                            } else {
                                i28 = i2;
                            }
                            if (i18 == 0) {
                            }
                            if ((i5 & 512) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i6 &= -1879048193;
                            } else {
                                jM11498getAppBackground0d7_KjU = j;
                            }
                            if (i20 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i29 = i28;
                            i30 = i14;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z3;
                            z8 = z9;
                            if (i23 != 0) {
                                function9 = null;
                            } else {
                                function9 = function1;
                            }
                            long j118 = jM11498getAppBackground0d7_KjU;
                            i31 = i6;
                            function10 = function4;
                            function11 = function5;
                            j3 = j118;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                        }
                        modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                        if (function9 != null) {
                            modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                        }
                        TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U9 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                        int i31115 = i31 << 6;
                        int i31116 = (i31 & 7294) | (3670016 & i31115) | (i31115 & 29360128);
                        int i31117 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                        int i31118 = i25 & 14;
                        composer2 = composerStartRestartGroup;
                        long j119 = j3;
                        Function1<? super FocusState, Unit> function110 = function9;
                        Modifier modifier12 = companion;
                        OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U9, composer2, i31116, i31117, i31118, 2350896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z7;
                        function7 = function10;
                        function8 = function11;
                        z5 = z8;
                        i27 = i29;
                        i26 = i30;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        modifier3 = modifier12;
                        function6 = function110;
                        j2 = j119;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z2;
                        function6 = function1;
                        function7 = function4;
                        function8 = function5;
                        i26 = i14;
                        modifier3 = modifier2;
                        z6 = z3;
                        i27 = i2;
                        j2 = j;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 100663296;
                if ((i3 & 805306368) != 0) {
                    i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                i20 = i5 & 1024;
                if (i20 != 0) {
                    i21 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i4 | i22;
                } else {
                    i21 = i4;
                }
                i23 = i5 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i4 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                if ((i6 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                    if ((i3 & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j1110 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j1110;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j1111 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j1111;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                    }
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (function9 != null) {
                        modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                    }
                    TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U10 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                    int i31119 = i31 << 6;
                    int i311110 = (i31 & 7294) | (3670016 & i31119) | (i31119 & 29360128);
                    int i311111 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                    int i311112 = i25 & 14;
                    composer2 = composerStartRestartGroup;
                    long j1112 = j3;
                    Function1<? super FocusState, Unit> function111 = function9;
                    Modifier modifier13 = companion;
                    OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U10, composer2, i311110, i311111, i311112, 2350896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z7;
                    function7 = function10;
                    function8 = function11;
                    z5 = z8;
                    i27 = i29;
                    i26 = i30;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier13;
                    function6 = function111;
                    j2 = j1112;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z2;
                    function6 = function1;
                    function7 = function4;
                    function8 = function5;
                    i26 = i14;
                    modifier3 = modifier2;
                    z6 = z3;
                    i27 = i2;
                    j2 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 24576;
            function4 = function2;
            i11 = i5 & 32;
            if (i11 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
            } else {
                function5 = function3;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i6 |= i12;
                }
            }
            i13 = i5 & 64;
            if (i13 != 0) {
                i6 |= 1572864;
                i14 = i;
            } else {
                i14 = i;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i6 |= i15;
                }
            }
            i16 = i5 & 128;
            if (i16 != 0) {
                i6 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i17 = 8388608;
                } else {
                    i17 = 4194304;
                }
                i6 |= i17;
            }
            i18 = i5 & 256;
            if (i18 != 0) {
                if ((i3 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i19 = 67108864;
                    } else {
                        i19 = 33554432;
                    }
                    i6 |= i19;
                }
                if ((i3 & 805306368) != 0) {
                    i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                i20 = i5 & 1024;
                if (i20 != 0) {
                    i21 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i4 | i22;
                } else {
                    i21 = i4;
                }
                i23 = i5 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i4 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                if ((i6 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                    if ((i3 & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j1113 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j1113;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j1114 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j1114;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                    }
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (function9 != null) {
                        modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                    }
                    TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U11 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                    int i311113 = i31 << 6;
                    int i311114 = (i31 & 7294) | (3670016 & i311113) | (i311113 & 29360128);
                    int i311115 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                    int i311116 = i25 & 14;
                    composer2 = composerStartRestartGroup;
                    long j1115 = j3;
                    Function1<? super FocusState, Unit> function112 = function9;
                    Modifier modifier14 = companion;
                    OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U11, composer2, i311114, i311115, i311116, 2350896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z7;
                    function7 = function10;
                    function8 = function11;
                    z5 = z8;
                    i27 = i29;
                    i26 = i30;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier14;
                    function6 = function112;
                    j2 = j1115;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z2;
                    function6 = function1;
                    function7 = function4;
                    function8 = function5;
                    i26 = i14;
                    modifier3 = modifier2;
                    z6 = z3;
                    i27 = i2;
                    j2 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 100663296;
            if ((i3 & 805306368) != 0) {
                i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i20 = i5 & 1024;
            if (i20 != 0) {
                i21 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i4 | i22;
            } else {
                i21 = i4;
            }
            i23 = i5 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i4 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            if ((i6 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                if ((i3 & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j1116 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j1116;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j1117 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j1117;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                }
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                if (function9 != null) {
                    modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                }
                TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U12 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                int i311117 = i31 << 6;
                int i311118 = (i31 & 7294) | (3670016 & i311117) | (i311117 & 29360128);
                int i311119 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                int i3111110 = i25 & 14;
                composer2 = composerStartRestartGroup;
                long j1118 = j3;
                Function1<? super FocusState, Unit> function113 = function9;
                Modifier modifier15 = companion;
                OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U12, composer2, i311118, i311119, i3111110, 2350896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
                function7 = function10;
                function8 = function11;
                z5 = z8;
                i27 = i29;
                i26 = i30;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier15;
                function6 = function113;
                j2 = j1118;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z2;
                function6 = function1;
                function7 = function4;
                function8 = function5;
                i26 = i14;
                modifier3 = modifier2;
                z6 = z3;
                i27 = i2;
                j2 = j;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 3072;
        z3 = z;
        i9 = i5 & 16;
        if (i9 != 0) {
            if ((i3 & 24576) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i6 |= i10;
            }
            i11 = i5 & 32;
            if (i11 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
            } else {
                function5 = function3;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i6 |= i12;
                }
            }
            i13 = i5 & 64;
            if (i13 != 0) {
                i6 |= 1572864;
                i14 = i;
            } else {
                i14 = i;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i14)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i6 |= i15;
                }
            }
            i16 = i5 & 128;
            if (i16 != 0) {
                i6 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i17 = 8388608;
                } else {
                    i17 = 4194304;
                }
                i6 |= i17;
            }
            i18 = i5 & 256;
            if (i18 != 0) {
                if ((i3 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i19 = 67108864;
                    } else {
                        i19 = 33554432;
                    }
                    i6 |= i19;
                }
                if ((i3 & 805306368) != 0) {
                    i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                i20 = i5 & 1024;
                if (i20 != 0) {
                    i21 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i4 | i22;
                } else {
                    i21 = i4;
                }
                i23 = i5 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i4 & 48) != 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                if ((i6 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                    if ((i3 & 1) != 0) {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j1119 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j1119;
                    } else {
                        if (i32 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            function4 = null;
                        }
                        if (i11 != 0) {
                            function5 = null;
                        }
                        if (i13 != 0) {
                            i14 = 1;
                        }
                        if (i16 != 0) {
                            i28 = Integer.MAX_VALUE;
                        } else {
                            i28 = i2;
                        }
                        if (i18 == 0) {
                        }
                        if ((i5 & 512) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i6 &= -1879048193;
                        } else {
                            jM11498getAppBackground0d7_KjU = j;
                        }
                        if (i20 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i29 = i28;
                        i30 = i14;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z3;
                        z8 = z9;
                        if (i23 != 0) {
                            function9 = null;
                        } else {
                            function9 = function1;
                        }
                        long j11110 = jM11498getAppBackground0d7_KjU;
                        i31 = i6;
                        function10 = function4;
                        function11 = function5;
                        j3 = j11110;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                    }
                    modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (function9 != null) {
                        modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                    }
                    TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U13 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                    int i3111111 = i31 << 6;
                    int i3111112 = (i31 & 7294) | (3670016 & i3111111) | (i3111111 & 29360128);
                    int i3111113 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                    int i3111114 = i25 & 14;
                    composer2 = composerStartRestartGroup;
                    long j11111 = j3;
                    Function1<? super FocusState, Unit> function114 = function9;
                    Modifier modifier16 = companion;
                    OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U13, composer2, i3111112, i3111113, i3111114, 2350896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z7;
                    function7 = function10;
                    function8 = function11;
                    z5 = z8;
                    i27 = i29;
                    i26 = i30;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier16;
                    function6 = function114;
                    j2 = j11111;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z2;
                    function6 = function1;
                    function7 = function4;
                    function8 = function5;
                    i26 = i14;
                    modifier3 = modifier2;
                    z6 = z3;
                    i27 = i2;
                    j2 = j;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 100663296;
            if ((i3 & 805306368) != 0) {
                i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i20 = i5 & 1024;
            if (i20 != 0) {
                i21 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i4 | i22;
            } else {
                i21 = i4;
            }
            i23 = i5 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i4 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            if ((i6 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                if ((i3 & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j11112 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j11112;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j11113 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j11113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                }
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                if (function9 != null) {
                    modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                }
                TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U14 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                int i3111115 = i31 << 6;
                int i3111116 = (i31 & 7294) | (3670016 & i3111115) | (i3111115 & 29360128);
                int i3111117 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                int i3111118 = i25 & 14;
                composer2 = composerStartRestartGroup;
                long j11114 = j3;
                Function1<? super FocusState, Unit> function115 = function9;
                Modifier modifier17 = companion;
                OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U14, composer2, i3111116, i3111117, i3111118, 2350896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
                function7 = function10;
                function8 = function11;
                z5 = z8;
                i27 = i29;
                i26 = i30;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier17;
                function6 = function115;
                j2 = j11114;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z2;
                function6 = function1;
                function7 = function4;
                function8 = function5;
                i26 = i14;
                modifier3 = modifier2;
                z6 = z3;
                i27 = i2;
                j2 = j;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 24576;
        function4 = function2;
        i11 = i5 & 32;
        if (i11 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
        } else {
            function5 = function3;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i6 |= i12;
            }
        }
        i13 = i5 & 64;
        if (i13 != 0) {
            i6 |= 1572864;
            i14 = i;
        } else {
            i14 = i;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i14)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i6 |= i15;
            }
        }
        i16 = i5 & 128;
        if (i16 != 0) {
            i6 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(i2)) {
                i17 = 8388608;
            } else {
                i17 = 4194304;
            }
            i6 |= i17;
        }
        i18 = i5 & 256;
        if (i18 != 0) {
            if ((i3 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i19 = 67108864;
                } else {
                    i19 = 33554432;
                }
                i6 |= i19;
            }
            if ((i3 & 805306368) != 0) {
                i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i20 = i5 & 1024;
            if (i20 != 0) {
                i21 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i4 | i22;
            } else {
                i21 = i4;
            }
            i23 = i5 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i4 & 48) != 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            if ((i6 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
                if ((i3 & 1) != 0) {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j11115 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j11115;
                } else {
                    if (i32 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if (i11 != 0) {
                        function5 = null;
                    }
                    if (i13 != 0) {
                        i14 = 1;
                    }
                    if (i16 != 0) {
                        i28 = Integer.MAX_VALUE;
                    } else {
                        i28 = i2;
                    }
                    if (i18 == 0) {
                    }
                    if ((i5 & 512) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i6 &= -1879048193;
                    } else {
                        jM11498getAppBackground0d7_KjU = j;
                    }
                    if (i20 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i29 = i28;
                    i30 = i14;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z3;
                    z8 = z9;
                    if (i23 != 0) {
                        function9 = null;
                    } else {
                        function9 = function1;
                    }
                    long j11116 = jM11498getAppBackground0d7_KjU;
                    i31 = i6;
                    function10 = function4;
                    function11 = function5;
                    j3 = j11116;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
                }
                modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                if (function9 != null) {
                    modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
                }
                TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U15 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
                int i3111119 = i31 << 6;
                int i31111110 = (i31 & 7294) | (3670016 & i3111119) | (i3111119 & 29360128);
                int i31111111 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
                int i31111112 = i25 & 14;
                composer2 = composerStartRestartGroup;
                long j11117 = j3;
                Function1<? super FocusState, Unit> function116 = function9;
                Modifier modifier18 = companion;
                OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U15, composer2, i31111110, i31111111, i31111112, 2350896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
                function7 = function10;
                function8 = function11;
                z5 = z8;
                i27 = i29;
                i26 = i30;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier18;
                function6 = function116;
                j2 = j11117;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z2;
                function6 = function1;
                function7 = function4;
                function8 = function5;
                i26 = i14;
                modifier3 = modifier2;
                z6 = z3;
                i27 = i2;
                j2 = j;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 100663296;
        if ((i3 & 805306368) != 0) {
            i6 |= ((i5 & 512) == 0 || !composerStartRestartGroup.changed(j)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        i20 = i5 & 1024;
        if (i20 != 0) {
            i21 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i21 = i4 | i22;
        } else {
            i21 = i4;
        }
        i23 = i5 & 2048;
        if (i23 != 0) {
            i21 |= 48;
        } else if ((i4 & 48) != 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i24 = 32;
            } else {
                i24 = 16;
            }
            i21 |= i24;
        }
        i25 = i21;
        if ((i6 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "53@2669L6");
            if ((i3 & 1) != 0) {
                if (i32 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    z3 = true;
                }
                if (i9 != 0) {
                    function4 = null;
                }
                if (i11 != 0) {
                    function5 = null;
                }
                if (i13 != 0) {
                    i14 = 1;
                }
                if (i16 != 0) {
                    i28 = Integer.MAX_VALUE;
                } else {
                    i28 = i2;
                }
                if (i18 == 0) {
                }
                if ((i5 & 512) != 0) {
                    jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                    i6 &= -1879048193;
                } else {
                    jM11498getAppBackground0d7_KjU = j;
                }
                if (i20 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                i29 = i28;
                i30 = i14;
                mutableInteractionSource4 = mutableInteractionSource3;
                z7 = z3;
                z8 = z9;
                if (i23 != 0) {
                    function9 = null;
                } else {
                    function9 = function1;
                }
                long j11118 = jM11498getAppBackground0d7_KjU;
                i31 = i6;
                function10 = function4;
                function11 = function5;
                j3 = j11118;
            } else {
                if (i32 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    z3 = true;
                }
                if (i9 != 0) {
                    function4 = null;
                }
                if (i11 != 0) {
                    function5 = null;
                }
                if (i13 != 0) {
                    i14 = 1;
                }
                if (i16 != 0) {
                    i28 = Integer.MAX_VALUE;
                } else {
                    i28 = i2;
                }
                if (i18 == 0) {
                }
                if ((i5 & 512) != 0) {
                    jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                    i6 &= -1879048193;
                } else {
                    jM11498getAppBackground0d7_KjU = j;
                }
                if (i20 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                i29 = i28;
                i30 = i14;
                mutableInteractionSource4 = mutableInteractionSource3;
                z7 = z3;
                z8 = z9;
                if (i23 != 0) {
                    function9 = null;
                } else {
                    function9 = function1;
                }
                long j11119 = jM11498getAppBackground0d7_KjU;
                i31 = i6;
                function10 = function4;
                function11 = function5;
                j3 = j11119;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(188361261, i31, i25, "com.box.android.base.compose.textfield.BoxOutlinedTextField (BoxOutlinedTextField.kt:56)");
            }
            modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            if (function9 != null) {
                modifierFillMaxWidth$default = FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, function9);
            }
            TextFieldColors textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U16 = m11740boxOutlinedTextFieldColorsek8zF_U(j3, composerStartRestartGroup, (i31 >> 27) & 14);
            int i31111113 = i31 << 6;
            int i31111114 = (i31 & 7294) | (3670016 & i31111113) | (i31111113 & 29360128);
            int i31111115 = ((i31 >> 15) & 7168) | ((i31 << 3) & 234881024) | ((i31 << 9) & C.ENCODING_PCM_DOUBLE);
            int i31111116 = i25 & 14;
            composer2 = composerStartRestartGroup;
            long j111110 = j3;
            Function1<? super FocusState, Unit> function117 = function9;
            Modifier modifier19 = companion;
            OutlinedTextFieldKt.OutlinedTextField(text, onTextChange, modifierFillMaxWidth$default, z7, false, (TextStyle) null, function10, function11, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, z8, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, i29, i30, mutableInteractionSource4, (Shape) null, textFieldColorsM11740boxOutlinedTextFieldColorsek8zF_U16, composer2, i31111114, i31111115, i31111116, 2350896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z7;
            function7 = function10;
            function8 = function11;
            z5 = z8;
            i27 = i29;
            i26 = i30;
            mutableInteractionSource2 = mutableInteractionSource4;
            modifier3 = modifier19;
            function6 = function117;
            j2 = j111110;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z5 = z2;
            function6 = function1;
            function7 = function4;
            function8 = function5;
            i26 = i14;
            modifier3 = modifier2;
            z6 = z3;
            i27 = i2;
            j2 = j;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxOutlinedTextFieldKt.BoxOutlinedTextField_htLuCmU$lambda$0(text, onTextChange, modifier3, z6, function7, function8, i26, i27, z5, j2, mutableInteractionSource2, function6, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: boxOutlinedTextFieldColors-ek8zF_U, reason: not valid java name */
    private static final TextFieldColors m11740boxOutlinedTextFieldColorsek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 795015919, "C(boxOutlinedTextFieldColors)N(containerColor:c#ui.graphics.Color)80@3528L6,81@3584L6,82@3639L6,83@3720L6,90@3977L6,91@4033L6,93@4094L6,94@4160L6,95@4220L6,96@4311L6,98@4368L6,99@4426L6,100@4482L6,101@4565L6,103@4628L6,104@4698L6,105@4767L6,106@4862L6,79@3488L1432:BoxOutlinedTextField.kt#fjpkir");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(795015919, i, -1, "com.box.android.base.compose.textfield.boxOutlinedTextFieldColors (BoxOutlinedTextField.kt:79)");
        }
        TextFieldColors textFieldColorsM4466colors0hiis_0 = TextFieldDefaults.INSTANCE.m4466colors0hiis_0(BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), j, j, Color.m6813copywmQWz5c$default(j, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), j, BoxTheme.INSTANCE.getColors(composer, 6).m11562getTextFieldCursor0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), null, BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, ((i << 12) & 57344) | ((i << 15) & 458752) | ((i << 21) & 29360128), 0, 0, 0, 3072, 8356864, 4095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM4466colors0hiis_0;
    }

    private static final void BoxOutlinedTextFieldPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2138587295);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxOutlinedTextFieldPreview)113@5037L935:BoxOutlinedTextField.kt#fjpkir");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2138587295, i, -1, "com.box.android.base.compose.textfield.BoxOutlinedTextFieldPreview (BoxOutlinedTextField.kt:112)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxOutlinedTextFieldKt.INSTANCE.getLambda$879265388$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxOutlinedTextFieldKt.BoxOutlinedTextFieldPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

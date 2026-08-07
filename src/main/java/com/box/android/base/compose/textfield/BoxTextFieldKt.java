package com.box.android.base.compose.textfield;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.VisibilityKt;
import androidx.compose.material.icons.filled.VisibilityOffKt;
import androidx.compose.material.icons.rounded.ErrorKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u009d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0003¢\u0006\u0002\u0010\u001b\u001aC\u0010\u001c\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020!H\u0003¢\u0006\u0002\u0010\"\u001a\r\u0010#\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010$¨\u0006%²\u0006\n\u0010\u001e\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"BoxTextField", "", "text", "", "onTextChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "isTextChangePending", "label", ReactTextInputShadowNode.PROP_PLACEHOLDER, "errorText", "initialFocus", "minLines", "", "maxLines", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/runtime/Composer;III)V", "PasswordTrailingIcon", "passwordVisible", "onPasswordIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TrailingIcon", "isError", "isFocused", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZZZLandroidx/compose/runtime/Composer;I)V", "boxTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "BoxTextFieldPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$14(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, String str2, String str3, String str4, boolean z3, int i, int i2, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, int i3, int i4, int i5, Composer composer, int i6) {
        BoxTextField(str, function1, modifier, z, z2, str2, str3, str4, z3, i, i2, keyboardOptions, keyboardActions, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextFieldPreview$lambda$0(int i, Composer composer, int i2) {
        BoxTextFieldPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordTrailingIcon$lambda$1(boolean z, Function0 function0, int i, Composer composer, int i2) {
        PasswordTrailingIcon(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailingIcon$lambda$1(String str, Function1 function1, boolean z, boolean z2, boolean z3, int i, Composer composer, int i2) {
        TrailingIcon(str, function1, z, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:104:0x0142  */
    /* JADX WARN: Code duplicated, block: B:106:0x0146  */
    /* JADX WARN: Code duplicated, block: B:108:0x0150  */
    /* JADX WARN: Code duplicated, block: B:109:0x0153  */
    /* JADX WARN: Code duplicated, block: B:111:0x0158  */
    /* JADX WARN: Code duplicated, block: B:114:0x0162  */
    /* JADX WARN: Code duplicated, block: B:115:0x0165  */
    /* JADX WARN: Code duplicated, block: B:117:0x0169  */
    /* JADX WARN: Code duplicated, block: B:119:0x0173  */
    /* JADX WARN: Code duplicated, block: B:120:0x0176  */
    /* JADX WARN: Code duplicated, block: B:125:0x0183  */
    /* JADX WARN: Code duplicated, block: B:127:0x0187  */
    /* JADX WARN: Code duplicated, block: B:130:0x0192 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:133:0x0199  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:163:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:165:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:166:0x0201  */
    /* JADX WARN: Code duplicated, block: B:168:0x0205  */
    /* JADX WARN: Code duplicated, block: B:169:0x0207  */
    /* JADX WARN: Code duplicated, block: B:171:0x020b  */
    /* JADX WARN: Code duplicated, block: B:172:0x020f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0213  */
    /* JADX WARN: Code duplicated, block: B:175:0x023f  */
    /* JADX WARN: Code duplicated, block: B:178:0x0245  */
    /* JADX WARN: Code duplicated, block: B:179:0x027c  */
    /* JADX WARN: Code duplicated, block: B:183:0x0293  */
    /* JADX WARN: Code duplicated, block: B:186:0x02af  */
    /* JADX WARN: Code duplicated, block: B:189:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:190:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:193:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:196:0x030e  */
    /* JADX WARN: Code duplicated, block: B:199:0x031d  */
    /* JADX WARN: Code duplicated, block: B:200:0x033f  */
    /* JADX WARN: Code duplicated, block: B:203:0x036b  */
    /* JADX WARN: Code duplicated, block: B:206:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:207:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:210:0x03af  */
    /* JADX WARN: Code duplicated, block: B:212:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:215:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:216:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:218:0x0417  */
    /* JADX WARN: Code duplicated, block: B:219:0x0424  */
    /* JADX WARN: Code duplicated, block: B:221:0x0446  */
    /* JADX WARN: Code duplicated, block: B:222:0x0469  */
    /* JADX WARN: Code duplicated, block: B:223:0x046b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:228:0x0483  */
    /* JADX WARN: Code duplicated, block: B:230:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:231:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:233:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:236:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:239:0x0549  */
    /* JADX WARN: Code duplicated, block: B:241:0x0561  */
    /* JADX WARN: Code duplicated, block: B:244:0x057c  */
    /* JADX WARN: Code duplicated, block: B:246:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0064  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x006b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:42:0x0084  */
    /* JADX WARN: Code duplicated, block: B:44:0x0088  */
    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:85:0x0105  */
    /* JADX WARN: Code duplicated, block: B:87:0x010b  */
    /* JADX WARN: Code duplicated, block: B:88:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0118  */
    /* JADX WARN: Code duplicated, block: B:93:0x011b  */
    /* JADX WARN: Code duplicated, block: B:95:0x011f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0129  */
    /* JADX WARN: Code duplicated, block: B:98:0x012c  */
    public static final void BoxTextField(final String text, final Function1<? super String, Unit> onTextChange, Modifier modifier, boolean z, boolean z2, String str, String str2, String str3, boolean z3, int i, int i2, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z4;
        int i8;
        int i9;
        boolean z5;
        int i10;
        int i11;
        final String str4;
        int i12;
        int i13;
        final String str5;
        int i14;
        int i15;
        final String str6;
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
        int i26;
        boolean z6;
        Composer composer2;
        final int i27;
        final boolean z7;
        final String str7;
        final boolean z8;
        final String str8;
        final String str9;
        final Modifier modifier3;
        final boolean z9;
        final int i28;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z10;
        int i29;
        int i30;
        KeyboardOptions keyboardOptions3;
        boolean z11;
        KeyboardActions keyboardActions3;
        int i31;
        Modifier modifier4;
        KeyboardOptions keyboardOptions4;
        Object objRememberedValue;
        final MutableState mutableState;
        final boolean z12;
        boolean zM9316equalsimpl0;
        Object objRememberedValue2;
        final MutableState mutableState2;
        Object objRememberedValue3;
        FocusRequester focusRequester;
        FocusRequester focusRequester2;
        Composer composer3;
        Object objRememberedValue4;
        boolean z13;
        boolean z14;
        Object objRememberedValue5;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambdaRememberComposableLambda2;
        final String str10;
        boolean z15;
        boolean z16;
        ComposableLambda composableLambdaRememberComposableLambda3;
        int i32;
        ComposableLambda composableLambda;
        int i33;
        PasswordVisualTransformation none;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onTextChange, "onTextChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-414793698);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxTextField)N(text,onTextChange,modifier,enabled,isTextChangePending,label,placeholder,errorText,initialFocus,minLines,maxLines,keyboardOptions,keyboardActions)81@3842L34,85@4016L34,87@4077L29,98@4386L67,102@4518L61,158@6438L20,92@4187L2277:BoxTextField.kt#fjpkir");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(onTextChange) ? 32 : 16;
        }
        int i34 = i5 & 4;
        if (i34 == 0) {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 != 0) {
                if ((i3 & 3072) == 0) {
                    z4 = z;
                    if (composerStartRestartGroup.changed(z4)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i6 |= i8;
                }
                i9 = i5 & 16;
                if (i9 != 0) {
                    if ((i3 & 24576) == 0) {
                        z5 = z2;
                        if (composerStartRestartGroup.changed(z5)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i6 |= i10;
                    }
                    i11 = i5 & 32;
                    if (i11 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        str4 = str;
                    } else {
                        str4 = str;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(str4)) {
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
                        str5 = str2;
                    } else {
                        str5 = str2;
                        if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(str5)) {
                                i14 = 1048576;
                            } else {
                                i14 = 524288;
                            }
                            i6 |= i14;
                        }
                    }
                    i15 = i5 & 128;
                    if (i15 != 0) {
                        i6 |= 12582912;
                        str6 = str3;
                    } else {
                        str6 = str3;
                        if ((i3 & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(str6)) {
                                i16 = 8388608;
                            } else {
                                i16 = 4194304;
                            }
                            i6 |= i16;
                        }
                    }
                    i17 = i5 & 256;
                    if (i17 != 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i18 = 67108864;
                        } else {
                            i18 = 33554432;
                        }
                        i6 |= i18;
                    }
                    i19 = i5 & 512;
                    if (i19 != 0) {
                        if ((i3 & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(i)) {
                                i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i20 = 268435456;
                            }
                            i6 |= i20;
                        }
                        i21 = i5 & 1024;
                        if (i21 != 0) {
                            i22 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            if (composerStartRestartGroup.changed(i2)) {
                                i23 = 4;
                            } else {
                                i23 = 2;
                            }
                            i22 = i4 | i23;
                        } else {
                            i22 = i4;
                        }
                        i24 = i5 & 2048;
                        if (i24 != 0) {
                            if ((i4 & 48) == 0) {
                                if (composerStartRestartGroup.changed(keyboardOptions)) {
                                    i25 = 32;
                                } else {
                                    i25 = 16;
                                }
                                i22 |= i25;
                            }
                            if ((i4 & 384) != 0) {
                                i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                            }
                            i26 = i22;
                            if ((i6 & 306783379) == 306783378 || (i26 & Token.DOTQUERY) != 146) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                if ((i3 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i34 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i7 != 0) {
                                        z4 = true;
                                    }
                                    if (i9 != 0) {
                                        z5 = false;
                                    }
                                    if (i11 != 0) {
                                        str4 = null;
                                    }
                                    if (i13 != 0) {
                                        str5 = null;
                                    }
                                    if (i15 != 0) {
                                        str6 = null;
                                    }
                                    if (i17 != 0) {
                                        z10 = false;
                                    } else {
                                        z10 = z3;
                                    }
                                    if (i19 != 0) {
                                        i29 = 1;
                                    } else {
                                        i29 = i;
                                    }
                                    if (i21 != 0) {
                                        i30 = Integer.MAX_VALUE;
                                    } else {
                                        i30 = i2;
                                    }
                                    if (i24 != 0) {
                                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                    } else {
                                        keyboardOptions3 = keyboardOptions;
                                    }
                                    if ((i5 & 4096) != 0) {
                                        i26 &= -897;
                                        boolean z17 = z4;
                                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                        z11 = z17;
                                    } else {
                                        z11 = z4;
                                        keyboardActions3 = keyboardActions;
                                    }
                                    i31 = i26;
                                    modifier4 = modifier2;
                                    keyboardOptions4 = keyboardOptions3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i5 & 4096) != 0) {
                                        i26 &= -897;
                                    }
                                    z10 = z3;
                                    i29 = i;
                                    i30 = i2;
                                    z11 = z4;
                                    str6 = str6;
                                    str5 = str5;
                                    keyboardActions3 = keyboardActions;
                                    i31 = i26;
                                    modifier4 = modifier2;
                                    keyboardOptions4 = keyboardOptions;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableState = (MutableState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (str6 != null) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                boolean z18 = z11;
                                zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                mutableState2 = (MutableState) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                focusRequester = (FocusRequester) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (z10) {
                                    composerStartRestartGroup.startReplaceGroup(-497362224);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                                    focusRequester2 = focusRequester;
                                    composer3 = composerStartRestartGroup;
                                } else {
                                    focusRequester2 = focusRequester;
                                    composer3 = composerStartRestartGroup;
                                    composer3.startReplaceGroup(-501460796);
                                }
                                composer3.endReplaceGroup();
                                KeyboardActions keyboardActions4 = keyboardActions3;
                                int i35 = i31;
                                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                                ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                                objRememberedValue4 = composer3.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierTestTag = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester, (Function1) objRememberedValue4), str4 + ":TextField");
                                ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                                boolean zChanged = composer3.changed(z12);
                                if ((29360128 & i6) == 8388608) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                z14 = zChanged | z13;
                                objRememberedValue5 = composer3.rememberedValue();
                                if (!z14 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierTestTag, false, (Function1) objRememberedValue5, 1, null);
                                float f = 8;
                                float f2 = 0;
                                RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f2));
                                if (str4 == null) {
                                    composer3.startReplaceGroup(-496804876);
                                    composer3.endReplaceGroup();
                                    composableLambdaRememberComposableLambda = null;
                                } else {
                                    composer3.startReplaceGroup(-496804875);
                                    ComposerKt.sourceInformation(composer3, "*107@4710L26");
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composer3, 54);
                                    composer3.endReplaceGroup();
                                }
                                if (str5 == null) {
                                    composer3.startReplaceGroup(-496716309);
                                    composer3.endReplaceGroup();
                                    composableLambdaRememberComposableLambda2 = null;
                                } else {
                                    composer3.startReplaceGroup(-496716308);
                                    ComposerKt.sourceInformation(composer3, "*109@4812L169");
                                    composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composer3, 54);
                                    composer3.endReplaceGroup();
                                }
                                if (zM9316equalsimpl0) {
                                    composer3.startReplaceGroup(-496460899);
                                    ComposerKt.sourceInformation(composer3, "117@5046L207");
                                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composer3, 54);
                                    composer3.endReplaceGroup();
                                    composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda4;
                                    z15 = z5;
                                    str10 = str4;
                                    z16 = z12;
                                } else if (!z5 || z12 || BoxTextField$lambda$1(mutableState)) {
                                    composer3.startReplaceGroup(-496174583);
                                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                                    final boolean z19 = z5;
                                    final String str11 = str4;
                                    final boolean z20 = z12;
                                    str10 = str11;
                                    z15 = z19;
                                    z16 = z20;
                                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BoxTextFieldKt.BoxTextField$lambda$12(str11, onTextChange, z19, z20, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composer3, 54);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(-495865048);
                                    composer3.endReplaceGroup();
                                    z15 = z5;
                                    str10 = str4;
                                    z16 = z12;
                                    composableLambdaRememberComposableLambda3 = null;
                                }
                                if (str6 == null) {
                                    composer3.startReplaceGroup(-495789130);
                                    composer3.endReplaceGroup();
                                    composableLambda = null;
                                    i32 = 1;
                                } else {
                                    composer3.startReplaceGroup(-495789129);
                                    ComposerKt.sourceInformation(composer3, "*137@5746L314");
                                    i32 = 1;
                                    ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composer3, 54);
                                    composer3.endReplaceGroup();
                                    composableLambda = composableLambdaRememberComposableLambda5;
                                }
                                if (!zM9316equalsimpl0 && !BoxTextField$lambda$4(mutableState2)) {
                                    i33 = 0;
                                    none = new PasswordVisualTransformation((char) 0, i32, null);
                                } else {
                                    i33 = 0;
                                    none = VisualTransformation.INSTANCE.getNone();
                                }
                                int i36 = i6 & 7294;
                                int i37 = ((i35 << 12) & 4128768) | ((i35 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                                composer2 = composer3;
                                String str12 = str6;
                                String str13 = str10;
                                String str14 = str5;
                                Modifier modifier5 = modifier4;
                                TextFieldKt.TextField(text, onTextChange, modifierSemantics$default, z18, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions4, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt4, boxTextFieldColors(composer3, i33), composer2, i36, i37, 0, 1183024);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z7 = z18;
                                keyboardOptions2 = keyboardOptions4;
                                keyboardActions2 = keyboardActions4;
                                i28 = i30;
                                i27 = i29;
                                z9 = z10;
                                z8 = z15;
                                str7 = str12;
                                modifier3 = modifier5;
                                str8 = str13;
                                str9 = str14;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                i27 = i;
                                z7 = z4;
                                str7 = str6;
                                z8 = z5;
                                str8 = str4;
                                str9 = str5;
                                modifier3 = modifier2;
                                z9 = z3;
                                i28 = i2;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActions2 = keyboardActions;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i22 |= 48;
                        if ((i4 & 384) != 0) {
                            i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                        }
                        i26 = i22;
                        if ((i6 & 306783379) == 306783378) {
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z110 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z110;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            } else {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z111 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z111;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (str6 != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            boolean z112 = z11;
                            zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            focusRequester = (FocusRequester) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z10) {
                                composerStartRestartGroup.startReplaceGroup(-497362224);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                            } else {
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                                composer3.startReplaceGroup(-501460796);
                            }
                            composer3.endReplaceGroup();
                            KeyboardActions keyboardActions5 = keyboardActions3;
                            int i38 = i31;
                            Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                            ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue4 = composer3.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierTestTag2 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester2, (Function1) objRememberedValue4), str4 + ":TextField");
                            ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                            boolean zChanged2 = composer3.changed(z12);
                            if ((29360128 & i6) == 8388608) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            z14 = zChanged2 | z13;
                            objRememberedValue5 = composer3.rememberedValue();
                            if (!z14) {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierTestTag2, false, (Function1) objRememberedValue5, 1, null);
                            float f3 = 8;
                            float f4 = 0;
                            RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt5 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f4), Dp.m9687constructorimpl(f4));
                            if (str4 == null) {
                                composer3.startReplaceGroup(-496804876);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            } else {
                                composer3.startReplaceGroup(-496804875);
                                ComposerKt.sourceInformation(composer3, "*107@4710L26");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str5 == null) {
                                composer3.startReplaceGroup(-496716309);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda2 = null;
                            } else {
                                composer3.startReplaceGroup(-496716308);
                                ComposerKt.sourceInformation(composer3, "*109@4812L169");
                                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (zM9316equalsimpl0) {
                                composer3.startReplaceGroup(-496460899);
                                ComposerKt.sourceInformation(composer3, "117@5046L207");
                                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda6;
                                z15 = z5;
                                str10 = str4;
                                z16 = z12;
                            } else if (!z5) {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z113 = z5;
                                final String str15 = str4;
                                final boolean z21 = z12;
                                str10 = str15;
                                z15 = z113;
                                z16 = z21;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str15, onTextChange, z113, z21, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z114 = z5;
                                final String str16 = str4;
                                final boolean z22 = z12;
                                str10 = str16;
                                z15 = z114;
                                z16 = z22;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str16, onTextChange, z114, z22, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str6 == null) {
                                composer3.startReplaceGroup(-495789130);
                                composer3.endReplaceGroup();
                                composableLambda = null;
                                i32 = 1;
                            } else {
                                composer3.startReplaceGroup(-495789129);
                                ComposerKt.sourceInformation(composer3, "*137@5746L314");
                                i32 = 1;
                                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambda = composableLambdaRememberComposableLambda7;
                            }
                            if (!zM9316equalsimpl0) {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            } else {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            }
                            int i39 = i6 & 7294;
                            int i310 = ((i38 << 12) & 4128768) | ((i38 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                            composer2 = composer3;
                            String str17 = str6;
                            String str18 = str10;
                            String str19 = str5;
                            Modifier modifier6 = modifier4;
                            TextFieldKt.TextField(text, onTextChange, modifierSemantics$default2, z112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions5, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt5, boxTextFieldColors(composer3, i33), composer2, i39, i310, 0, 1183024);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z112;
                            keyboardOptions2 = keyboardOptions4;
                            keyboardActions2 = keyboardActions5;
                            i28 = i30;
                            i27 = i29;
                            z9 = z10;
                            z8 = z15;
                            str7 = str17;
                            modifier3 = modifier6;
                            str8 = str18;
                            str9 = str19;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i27 = i;
                            z7 = z4;
                            str7 = str6;
                            z8 = z5;
                            str8 = str4;
                            str9 = str5;
                            modifier3 = modifier2;
                            z9 = z3;
                            i28 = i2;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions2 = keyboardActions;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i6 |= 805306368;
                    i21 = i5 & 1024;
                    if (i21 != 0) {
                        i22 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i4 | i23;
                    } else {
                        i22 = i4;
                    }
                    i24 = i5 & 2048;
                    if (i24 != 0) {
                        if ((i4 & 48) == 0) {
                            if (composerStartRestartGroup.changed(keyboardOptions)) {
                                i25 = 32;
                            } else {
                                i25 = 16;
                            }
                            i22 |= i25;
                        }
                        if ((i4 & 384) != 0) {
                            i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                        }
                        i26 = i22;
                        if ((i6 & 306783379) == 306783378) {
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z115 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z115;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            } else {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z116 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z116;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (str6 != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            boolean z117 = z11;
                            zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            focusRequester = (FocusRequester) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z10) {
                                composerStartRestartGroup.startReplaceGroup(-497362224);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                            } else {
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                                composer3.startReplaceGroup(-501460796);
                            }
                            composer3.endReplaceGroup();
                            KeyboardActions keyboardActions6 = keyboardActions3;
                            int i311 = i31;
                            Modifier modifierFocusRequester3 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                            ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue4 = composer3.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierTestTag3 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester3, (Function1) objRememberedValue4), str4 + ":TextField");
                            ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                            boolean zChanged3 = composer3.changed(z12);
                            if ((29360128 & i6) == 8388608) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            z14 = zChanged3 | z13;
                            objRememberedValue5 = composer3.rememberedValue();
                            if (!z14) {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierTestTag3, false, (Function1) objRememberedValue5, 1, null);
                            float f5 = 8;
                            float f6 = 0;
                            RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt6 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f5), Dp.m9687constructorimpl(f5), Dp.m9687constructorimpl(f6), Dp.m9687constructorimpl(f6));
                            if (str4 == null) {
                                composer3.startReplaceGroup(-496804876);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            } else {
                                composer3.startReplaceGroup(-496804875);
                                ComposerKt.sourceInformation(composer3, "*107@4710L26");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str5 == null) {
                                composer3.startReplaceGroup(-496716309);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda2 = null;
                            } else {
                                composer3.startReplaceGroup(-496716308);
                                ComposerKt.sourceInformation(composer3, "*109@4812L169");
                                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (zM9316equalsimpl0) {
                                composer3.startReplaceGroup(-496460899);
                                ComposerKt.sourceInformation(composer3, "117@5046L207");
                                ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda8;
                                z15 = z5;
                                str10 = str4;
                                z16 = z12;
                            } else if (!z5) {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z118 = z5;
                                final String str110 = str4;
                                final boolean z23 = z12;
                                str10 = str110;
                                z15 = z118;
                                z16 = z23;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str110, onTextChange, z118, z23, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z119 = z5;
                                final String str111 = str4;
                                final boolean z24 = z12;
                                str10 = str111;
                                z15 = z119;
                                z16 = z24;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str111, onTextChange, z119, z24, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str6 == null) {
                                composer3.startReplaceGroup(-495789130);
                                composer3.endReplaceGroup();
                                composableLambda = null;
                                i32 = 1;
                            } else {
                                composer3.startReplaceGroup(-495789129);
                                ComposerKt.sourceInformation(composer3, "*137@5746L314");
                                i32 = 1;
                                ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambda = composableLambdaRememberComposableLambda9;
                            }
                            if (!zM9316equalsimpl0) {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            } else {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            }
                            int i312 = i6 & 7294;
                            int i313 = ((i311 << 12) & 4128768) | ((i311 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                            composer2 = composer3;
                            String str112 = str6;
                            String str113 = str10;
                            String str114 = str5;
                            Modifier modifier7 = modifier4;
                            TextFieldKt.TextField(text, onTextChange, modifierSemantics$default3, z117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions6, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt6, boxTextFieldColors(composer3, i33), composer2, i312, i313, 0, 1183024);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z117;
                            keyboardOptions2 = keyboardOptions4;
                            keyboardActions2 = keyboardActions6;
                            i28 = i30;
                            i27 = i29;
                            z9 = z10;
                            z8 = z15;
                            str7 = str112;
                            modifier3 = modifier7;
                            str8 = str113;
                            str9 = str114;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i27 = i;
                            z7 = z4;
                            str7 = str6;
                            z8 = z5;
                            str8 = str4;
                            str9 = str5;
                            modifier3 = modifier2;
                            z9 = z3;
                            i28 = i2;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions2 = keyboardActions;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i22 |= 48;
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z1110 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z1110;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z1111 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z1111;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z1112 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions7 = keyboardActions3;
                        int i314 = i31;
                        Modifier modifierFocusRequester4 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag4 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester4, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged4 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged4 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierTestTag4, false, (Function1) objRememberedValue5, 1, null);
                        float f7 = 8;
                        float f8 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt7 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f7), Dp.m9687constructorimpl(f7), Dp.m9687constructorimpl(f8), Dp.m9687constructorimpl(f8));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda10;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z1113 = z5;
                            final String str115 = str4;
                            final boolean z25 = z12;
                            str10 = str115;
                            z15 = z1113;
                            z16 = z25;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str115, onTextChange, z1113, z25, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z1114 = z5;
                            final String str116 = str4;
                            final boolean z26 = z12;
                            str10 = str116;
                            z15 = z1114;
                            z16 = z26;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str116, onTextChange, z1114, z26, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda11;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i315 = i6 & 7294;
                        int i316 = ((i314 << 12) & 4128768) | ((i314 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str117 = str6;
                        String str118 = str10;
                        String str119 = str5;
                        Modifier modifier8 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default4, z1112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions7, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt7, boxTextFieldColors(composer3, i33), composer2, i315, i316, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z1112;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions7;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str117;
                        modifier3 = modifier8;
                        str8 = str118;
                        str9 = str119;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 24576;
                z5 = z2;
                i11 = i5 & 32;
                if (i11 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    str4 = str;
                } else {
                    str4 = str;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(str4)) {
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
                    str5 = str2;
                } else {
                    str5 = str2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(str5)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i6 |= i14;
                    }
                }
                i15 = i5 & 128;
                if (i15 != 0) {
                    i6 |= 12582912;
                    str6 = str3;
                } else {
                    str6 = str3;
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(str6)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i6 |= i16;
                    }
                }
                i17 = i5 & 256;
                if (i17 != 0) {
                    i6 |= 100663296;
                } else if ((i3 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i6 |= i18;
                }
                i19 = i5 & 512;
                if (i19 != 0) {
                    if ((i3 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i20 = 268435456;
                        }
                        i6 |= i20;
                    }
                    i21 = i5 & 1024;
                    if (i21 != 0) {
                        i22 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i4 | i23;
                    } else {
                        i22 = i4;
                    }
                    i24 = i5 & 2048;
                    if (i24 != 0) {
                        if ((i4 & 48) == 0) {
                            if (composerStartRestartGroup.changed(keyboardOptions)) {
                                i25 = 32;
                            } else {
                                i25 = 16;
                            }
                            i22 |= i25;
                        }
                        if ((i4 & 384) != 0) {
                            i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                        }
                        i26 = i22;
                        if ((i6 & 306783379) == 306783378) {
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z1115 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z1115;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            } else {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z1116 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z1116;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (str6 != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            boolean z1117 = z11;
                            zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            focusRequester = (FocusRequester) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z10) {
                                composerStartRestartGroup.startReplaceGroup(-497362224);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                            } else {
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                                composer3.startReplaceGroup(-501460796);
                            }
                            composer3.endReplaceGroup();
                            KeyboardActions keyboardActions8 = keyboardActions3;
                            int i317 = i31;
                            Modifier modifierFocusRequester5 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                            ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue4 = composer3.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierTestTag5 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester5, (Function1) objRememberedValue4), str4 + ":TextField");
                            ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                            boolean zChanged5 = composer3.changed(z12);
                            if ((29360128 & i6) == 8388608) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            z14 = zChanged5 | z13;
                            objRememberedValue5 = composer3.rememberedValue();
                            if (!z14) {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifierTestTag5, false, (Function1) objRememberedValue5, 1, null);
                            float f9 = 8;
                            float f10 = 0;
                            RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt8 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f9), Dp.m9687constructorimpl(f9), Dp.m9687constructorimpl(f10), Dp.m9687constructorimpl(f10));
                            if (str4 == null) {
                                composer3.startReplaceGroup(-496804876);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            } else {
                                composer3.startReplaceGroup(-496804875);
                                ComposerKt.sourceInformation(composer3, "*107@4710L26");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str5 == null) {
                                composer3.startReplaceGroup(-496716309);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda2 = null;
                            } else {
                                composer3.startReplaceGroup(-496716308);
                                ComposerKt.sourceInformation(composer3, "*109@4812L169");
                                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (zM9316equalsimpl0) {
                                composer3.startReplaceGroup(-496460899);
                                ComposerKt.sourceInformation(composer3, "117@5046L207");
                                ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda12;
                                z15 = z5;
                                str10 = str4;
                                z16 = z12;
                            } else if (!z5) {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z1118 = z5;
                                final String str1110 = str4;
                                final boolean z27 = z12;
                                str10 = str1110;
                                z15 = z1118;
                                z16 = z27;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str1110, onTextChange, z1118, z27, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z1119 = z5;
                                final String str1111 = str4;
                                final boolean z28 = z12;
                                str10 = str1111;
                                z15 = z1119;
                                z16 = z28;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str1111, onTextChange, z1119, z28, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str6 == null) {
                                composer3.startReplaceGroup(-495789130);
                                composer3.endReplaceGroup();
                                composableLambda = null;
                                i32 = 1;
                            } else {
                                composer3.startReplaceGroup(-495789129);
                                ComposerKt.sourceInformation(composer3, "*137@5746L314");
                                i32 = 1;
                                ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambda = composableLambdaRememberComposableLambda13;
                            }
                            if (!zM9316equalsimpl0) {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            } else {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            }
                            int i318 = i6 & 7294;
                            int i319 = ((i317 << 12) & 4128768) | ((i317 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                            composer2 = composer3;
                            String str1112 = str6;
                            String str1113 = str10;
                            String str1114 = str5;
                            Modifier modifier9 = modifier4;
                            TextFieldKt.TextField(text, onTextChange, modifierSemantics$default5, z1117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions8, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt8, boxTextFieldColors(composer3, i33), composer2, i318, i319, 0, 1183024);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z1117;
                            keyboardOptions2 = keyboardOptions4;
                            keyboardActions2 = keyboardActions8;
                            i28 = i30;
                            i27 = i29;
                            z9 = z10;
                            z8 = z15;
                            str7 = str1112;
                            modifier3 = modifier9;
                            str8 = str1113;
                            str9 = str1114;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i27 = i;
                            z7 = z4;
                            str7 = str6;
                            z8 = z5;
                            str8 = str4;
                            str9 = str5;
                            modifier3 = modifier2;
                            z9 = z3;
                            i28 = i2;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions2 = keyboardActions;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i22 |= 48;
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11110 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11110;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z11112 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions9 = keyboardActions3;
                        int i3110 = i31;
                        Modifier modifierFocusRequester6 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag6 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester6, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged6 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged6 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifierTestTag6, false, (Function1) objRememberedValue5, 1, null);
                        float f11 = 8;
                        float f12 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt9 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f11), Dp.m9687constructorimpl(f11), Dp.m9687constructorimpl(f12), Dp.m9687constructorimpl(f12));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda14;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11113 = z5;
                            final String str1115 = str4;
                            final boolean z29 = z12;
                            str10 = str1115;
                            z15 = z11113;
                            z16 = z29;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str1115, onTextChange, z11113, z29, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11114 = z5;
                            final String str1116 = str4;
                            final boolean z210 = z12;
                            str10 = str1116;
                            z15 = z11114;
                            z16 = z210;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str1116, onTextChange, z11114, z210, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda15;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i3111 = i6 & 7294;
                        int i3112 = ((i3110 << 12) & 4128768) | ((i3110 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str1117 = str6;
                        String str1118 = str10;
                        String str1119 = str5;
                        Modifier modifier10 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default6, z11112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions9, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt9, boxTextFieldColors(composer3, i33), composer2, i3111, i3112, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z11112;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions9;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str1117;
                        modifier3 = modifier10;
                        str8 = str1118;
                        str9 = str1119;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 805306368;
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i4 | i23;
                } else {
                    i22 = i4;
                }
                i24 = i5 & 2048;
                if (i24 != 0) {
                    if ((i4 & 48) == 0) {
                        if (composerStartRestartGroup.changed(keyboardOptions)) {
                            i25 = 32;
                        } else {
                            i25 = 16;
                        }
                        i22 |= i25;
                    }
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11115 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11115;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11116 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11116;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z11117 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions10 = keyboardActions3;
                        int i3113 = i31;
                        Modifier modifierFocusRequester7 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag7 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester7, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged7 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged7 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifierTestTag7, false, (Function1) objRememberedValue5, 1, null);
                        float f13 = 8;
                        float f14 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt10 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f13), Dp.m9687constructorimpl(f13), Dp.m9687constructorimpl(f14), Dp.m9687constructorimpl(f14));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda16;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11118 = z5;
                            final String str11110 = str4;
                            final boolean z211 = z12;
                            str10 = str11110;
                            z15 = z11118;
                            z16 = z211;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11110, onTextChange, z11118, z211, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11119 = z5;
                            final String str11111 = str4;
                            final boolean z212 = z12;
                            str10 = str11111;
                            z15 = z11119;
                            z16 = z212;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11111, onTextChange, z11119, z212, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda17 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda17;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i3114 = i6 & 7294;
                        int i3115 = ((i3113 << 12) & 4128768) | ((i3113 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str11112 = str6;
                        String str11113 = str10;
                        String str11114 = str5;
                        Modifier modifier11 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default7, z11117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions10, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt10, boxTextFieldColors(composer3, i33), composer2, i3114, i3115, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z11117;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions10;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str11112;
                        modifier3 = modifier11;
                        str8 = str11113;
                        str9 = str11114;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i22 |= 48;
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111110 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111110;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z111112 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions11 = keyboardActions3;
                    int i3116 = i31;
                    Modifier modifierFocusRequester8 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag8 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester8, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged8 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged8 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifierTestTag8, false, (Function1) objRememberedValue5, 1, null);
                    float f15 = 8;
                    float f16 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt11 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f15), Dp.m9687constructorimpl(f15), Dp.m9687constructorimpl(f16), Dp.m9687constructorimpl(f16));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda18 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda18;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111113 = z5;
                        final String str11115 = str4;
                        final boolean z213 = z12;
                        str10 = str11115;
                        z15 = z111113;
                        z16 = z213;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11115, onTextChange, z111113, z213, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111114 = z5;
                        final String str11116 = str4;
                        final boolean z214 = z12;
                        str10 = str11116;
                        z15 = z111114;
                        z16 = z214;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11116, onTextChange, z111114, z214, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda19 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda19;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i3117 = i6 & 7294;
                    int i3118 = ((i3116 << 12) & 4128768) | ((i3116 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str11117 = str6;
                    String str11118 = str10;
                    String str11119 = str5;
                    Modifier modifier12 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default8, z111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions11, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt11, boxTextFieldColors(composer3, i33), composer2, i3117, i3118, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z111112;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions11;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str11117;
                    modifier3 = modifier12;
                    str8 = str11118;
                    str9 = str11119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 3072;
            z4 = z;
            i9 = i5 & 16;
            if (i9 != 0) {
                if ((i3 & 24576) == 0) {
                    z5 = z2;
                    if (composerStartRestartGroup.changed(z5)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 32;
                if (i11 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    str4 = str;
                } else {
                    str4 = str;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(str4)) {
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
                    str5 = str2;
                } else {
                    str5 = str2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(str5)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i6 |= i14;
                    }
                }
                i15 = i5 & 128;
                if (i15 != 0) {
                    i6 |= 12582912;
                    str6 = str3;
                } else {
                    str6 = str3;
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(str6)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i6 |= i16;
                    }
                }
                i17 = i5 & 256;
                if (i17 != 0) {
                    i6 |= 100663296;
                } else if ((i3 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i6 |= i18;
                }
                i19 = i5 & 512;
                if (i19 != 0) {
                    if ((i3 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i20 = 268435456;
                        }
                        i6 |= i20;
                    }
                    i21 = i5 & 1024;
                    if (i21 != 0) {
                        i22 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i4 | i23;
                    } else {
                        i22 = i4;
                    }
                    i24 = i5 & 2048;
                    if (i24 != 0) {
                        if ((i4 & 48) == 0) {
                            if (composerStartRestartGroup.changed(keyboardOptions)) {
                                i25 = 32;
                            } else {
                                i25 = 16;
                            }
                            i22 |= i25;
                        }
                        if ((i4 & 384) != 0) {
                            i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                        }
                        i26 = i22;
                        if ((i6 & 306783379) == 306783378) {
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z111115 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z111115;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            } else {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z111116 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z111116;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (str6 != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            boolean z111117 = z11;
                            zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            focusRequester = (FocusRequester) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z10) {
                                composerStartRestartGroup.startReplaceGroup(-497362224);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                            } else {
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                                composer3.startReplaceGroup(-501460796);
                            }
                            composer3.endReplaceGroup();
                            KeyboardActions keyboardActions12 = keyboardActions3;
                            int i3119 = i31;
                            Modifier modifierFocusRequester9 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                            ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue4 = composer3.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierTestTag9 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester9, (Function1) objRememberedValue4), str4 + ":TextField");
                            ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                            boolean zChanged9 = composer3.changed(z12);
                            if ((29360128 & i6) == 8388608) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            z14 = zChanged9 | z13;
                            objRememberedValue5 = composer3.rememberedValue();
                            if (!z14) {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifierTestTag9, false, (Function1) objRememberedValue5, 1, null);
                            float f17 = 8;
                            float f18 = 0;
                            RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt12 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f17), Dp.m9687constructorimpl(f17), Dp.m9687constructorimpl(f18), Dp.m9687constructorimpl(f18));
                            if (str4 == null) {
                                composer3.startReplaceGroup(-496804876);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            } else {
                                composer3.startReplaceGroup(-496804875);
                                ComposerKt.sourceInformation(composer3, "*107@4710L26");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str5 == null) {
                                composer3.startReplaceGroup(-496716309);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda2 = null;
                            } else {
                                composer3.startReplaceGroup(-496716308);
                                ComposerKt.sourceInformation(composer3, "*109@4812L169");
                                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (zM9316equalsimpl0) {
                                composer3.startReplaceGroup(-496460899);
                                ComposerKt.sourceInformation(composer3, "117@5046L207");
                                ComposableLambda composableLambdaRememberComposableLambda110 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda110;
                                z15 = z5;
                                str10 = str4;
                                z16 = z12;
                            } else if (!z5) {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z111118 = z5;
                                final String str111110 = str4;
                                final boolean z215 = z12;
                                str10 = str111110;
                                z15 = z111118;
                                z16 = z215;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str111110, onTextChange, z111118, z215, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z111119 = z5;
                                final String str111111 = str4;
                                final boolean z216 = z12;
                                str10 = str111111;
                                z15 = z111119;
                                z16 = z216;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str111111, onTextChange, z111119, z216, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str6 == null) {
                                composer3.startReplaceGroup(-495789130);
                                composer3.endReplaceGroup();
                                composableLambda = null;
                                i32 = 1;
                            } else {
                                composer3.startReplaceGroup(-495789129);
                                ComposerKt.sourceInformation(composer3, "*137@5746L314");
                                i32 = 1;
                                ComposableLambda composableLambdaRememberComposableLambda111 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambda = composableLambdaRememberComposableLambda111;
                            }
                            if (!zM9316equalsimpl0) {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            } else {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            }
                            int i31110 = i6 & 7294;
                            int i31111 = ((i3119 << 12) & 4128768) | ((i3119 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                            composer2 = composer3;
                            String str111112 = str6;
                            String str111113 = str10;
                            String str111114 = str5;
                            Modifier modifier13 = modifier4;
                            TextFieldKt.TextField(text, onTextChange, modifierSemantics$default9, z111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions12, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt12, boxTextFieldColors(composer3, i33), composer2, i31110, i31111, 0, 1183024);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z111117;
                            keyboardOptions2 = keyboardOptions4;
                            keyboardActions2 = keyboardActions12;
                            i28 = i30;
                            i27 = i29;
                            z9 = z10;
                            z8 = z15;
                            str7 = str111112;
                            modifier3 = modifier13;
                            str8 = str111113;
                            str9 = str111114;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i27 = i;
                            z7 = z4;
                            str7 = str6;
                            z8 = z5;
                            str8 = str4;
                            str9 = str5;
                            modifier3 = modifier2;
                            z9 = z3;
                            i28 = i2;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions2 = keyboardActions;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i22 |= 48;
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z1111110 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z1111110;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z1111111 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z1111111;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z1111112 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions13 = keyboardActions3;
                        int i31112 = i31;
                        Modifier modifierFocusRequester10 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag10 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester10, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged10 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged10 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(modifierTestTag10, false, (Function1) objRememberedValue5, 1, null);
                        float f19 = 8;
                        float f110 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt13 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f19), Dp.m9687constructorimpl(f19), Dp.m9687constructorimpl(f110), Dp.m9687constructorimpl(f110));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda112 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda112;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z1111113 = z5;
                            final String str111115 = str4;
                            final boolean z217 = z12;
                            str10 = str111115;
                            z15 = z1111113;
                            z16 = z217;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str111115, onTextChange, z1111113, z217, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z1111114 = z5;
                            final String str111116 = str4;
                            final boolean z218 = z12;
                            str10 = str111116;
                            z15 = z1111114;
                            z16 = z218;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str111116, onTextChange, z1111114, z218, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda113 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda113;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i31113 = i6 & 7294;
                        int i31114 = ((i31112 << 12) & 4128768) | ((i31112 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str111117 = str6;
                        String str111118 = str10;
                        String str111119 = str5;
                        Modifier modifier14 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default10, z1111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions13, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt13, boxTextFieldColors(composer3, i33), composer2, i31113, i31114, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z1111112;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions13;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str111117;
                        modifier3 = modifier14;
                        str8 = str111118;
                        str9 = str111119;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 805306368;
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i4 | i23;
                } else {
                    i22 = i4;
                }
                i24 = i5 & 2048;
                if (i24 != 0) {
                    if ((i4 & 48) == 0) {
                        if (composerStartRestartGroup.changed(keyboardOptions)) {
                            i25 = 32;
                        } else {
                            i25 = 16;
                        }
                        i22 |= i25;
                    }
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z1111115 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z1111115;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z1111116 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z1111116;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z1111117 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions14 = keyboardActions3;
                        int i31115 = i31;
                        Modifier modifierFocusRequester11 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag11 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester11, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged11 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged11 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(modifierTestTag11, false, (Function1) objRememberedValue5, 1, null);
                        float f111 = 8;
                        float f112 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt14 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f111), Dp.m9687constructorimpl(f111), Dp.m9687constructorimpl(f112), Dp.m9687constructorimpl(f112));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda114 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda114;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z1111118 = z5;
                            final String str1111110 = str4;
                            final boolean z219 = z12;
                            str10 = str1111110;
                            z15 = z1111118;
                            z16 = z219;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str1111110, onTextChange, z1111118, z219, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z1111119 = z5;
                            final String str1111111 = str4;
                            final boolean z2110 = z12;
                            str10 = str1111111;
                            z15 = z1111119;
                            z16 = z2110;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str1111111, onTextChange, z1111119, z2110, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda115 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda115;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i31116 = i6 & 7294;
                        int i31117 = ((i31115 << 12) & 4128768) | ((i31115 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str1111112 = str6;
                        String str1111113 = str10;
                        String str1111114 = str5;
                        Modifier modifier15 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default11, z1111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions14, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt14, boxTextFieldColors(composer3, i33), composer2, i31116, i31117, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z1111117;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions14;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str1111112;
                        modifier3 = modifier15;
                        str8 = str1111113;
                        str9 = str1111114;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i22 |= 48;
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z11111110 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z11111110;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z11111111 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z11111111;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z11111112 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions15 = keyboardActions3;
                    int i31118 = i31;
                    Modifier modifierFocusRequester12 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag12 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester12, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged12 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged12 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(modifierTestTag12, false, (Function1) objRememberedValue5, 1, null);
                    float f113 = 8;
                    float f114 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt15 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f113), Dp.m9687constructorimpl(f113), Dp.m9687constructorimpl(f114), Dp.m9687constructorimpl(f114));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda116 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda116;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z11111113 = z5;
                        final String str1111115 = str4;
                        final boolean z2111 = z12;
                        str10 = str1111115;
                        z15 = z11111113;
                        z16 = z2111;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str1111115, onTextChange, z11111113, z2111, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z11111114 = z5;
                        final String str1111116 = str4;
                        final boolean z2112 = z12;
                        str10 = str1111116;
                        z15 = z11111114;
                        z16 = z2112;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str1111116, onTextChange, z11111114, z2112, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda117 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda117;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i31119 = i6 & 7294;
                    int i311110 = ((i31118 << 12) & 4128768) | ((i31118 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str1111117 = str6;
                    String str1111118 = str10;
                    String str1111119 = str5;
                    Modifier modifier16 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default12, z11111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions15, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt15, boxTextFieldColors(composer3, i33), composer2, i31119, i311110, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z11111112;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions15;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str1111117;
                    modifier3 = modifier16;
                    str8 = str1111118;
                    str9 = str1111119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 24576;
            z5 = z2;
            i11 = i5 & 32;
            if (i11 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str4 = str;
            } else {
                str4 = str;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(str4)) {
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
                str5 = str2;
            } else {
                str5 = str2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(str5)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i6 |= i14;
                }
            }
            i15 = i5 & 128;
            if (i15 != 0) {
                i6 |= 12582912;
                str6 = str3;
            } else {
                str6 = str3;
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(str6)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i6 |= i16;
                }
            }
            i17 = i5 & 256;
            if (i17 != 0) {
                i6 |= 100663296;
            } else if ((i3 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i6 |= i18;
            }
            i19 = i5 & 512;
            if (i19 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i20 = 268435456;
                    }
                    i6 |= i20;
                }
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i4 | i23;
                } else {
                    i22 = i4;
                }
                i24 = i5 & 2048;
                if (i24 != 0) {
                    if ((i4 & 48) == 0) {
                        if (composerStartRestartGroup.changed(keyboardOptions)) {
                            i25 = 32;
                        } else {
                            i25 = 16;
                        }
                        i22 |= i25;
                    }
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111115 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111115;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111116 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111116;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z11111117 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions16 = keyboardActions3;
                        int i311111 = i31;
                        Modifier modifierFocusRequester13 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag13 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester13, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged13 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged13 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(modifierTestTag13, false, (Function1) objRememberedValue5, 1, null);
                        float f115 = 8;
                        float f116 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt16 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f115), Dp.m9687constructorimpl(f115), Dp.m9687constructorimpl(f116), Dp.m9687constructorimpl(f116));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda118 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda118;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111118 = z5;
                            final String str11111110 = str4;
                            final boolean z2113 = z12;
                            str10 = str11111110;
                            z15 = z11111118;
                            z16 = z2113;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11111110, onTextChange, z11111118, z2113, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111119 = z5;
                            final String str11111111 = str4;
                            final boolean z2114 = z12;
                            str10 = str11111111;
                            z15 = z11111119;
                            z16 = z2114;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11111111, onTextChange, z11111119, z2114, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda119 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda119;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i311112 = i6 & 7294;
                        int i311113 = ((i311111 << 12) & 4128768) | ((i311111 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str11111112 = str6;
                        String str11111113 = str10;
                        String str11111114 = str5;
                        Modifier modifier17 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default13, z11111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions16, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt16, boxTextFieldColors(composer3, i33), composer2, i311112, i311113, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z11111117;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions16;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str11111112;
                        modifier3 = modifier17;
                        str8 = str11111113;
                        str9 = str11111114;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i22 |= 48;
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111110 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111110;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111111 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111111;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z111111112 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions17 = keyboardActions3;
                    int i311114 = i31;
                    Modifier modifierFocusRequester14 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag14 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester14, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged14 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged14 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(modifierTestTag14, false, (Function1) objRememberedValue5, 1, null);
                    float f117 = 8;
                    float f118 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt17 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f117), Dp.m9687constructorimpl(f117), Dp.m9687constructorimpl(f118), Dp.m9687constructorimpl(f118));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda1110 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1110;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111113 = z5;
                        final String str11111115 = str4;
                        final boolean z2115 = z12;
                        str10 = str11111115;
                        z15 = z111111113;
                        z16 = z2115;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11111115, onTextChange, z111111113, z2115, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111114 = z5;
                        final String str11111116 = str4;
                        final boolean z2116 = z12;
                        str10 = str11111116;
                        z15 = z111111114;
                        z16 = z2116;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11111116, onTextChange, z111111114, z2116, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda1111 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda1111;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i311115 = i6 & 7294;
                    int i311116 = ((i311114 << 12) & 4128768) | ((i311114 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str11111117 = str6;
                    String str11111118 = str10;
                    String str11111119 = str5;
                    Modifier modifier18 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default14, z111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions17, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt17, boxTextFieldColors(composer3, i33), composer2, i311115, i311116, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z111111112;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions17;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str11111117;
                    modifier3 = modifier18;
                    str8 = str11111118;
                    str9 = str11111119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            i21 = i5 & 1024;
            if (i21 != 0) {
                i22 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i4 | i23;
            } else {
                i22 = i4;
            }
            i24 = i5 & 2048;
            if (i24 != 0) {
                if ((i4 & 48) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions)) {
                        i25 = 32;
                    } else {
                        i25 = 16;
                    }
                    i22 |= i25;
                }
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111115 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111115;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111116 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111116;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z111111117 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions18 = keyboardActions3;
                    int i311117 = i31;
                    Modifier modifierFocusRequester15 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag15 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester15, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged15 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged15 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(modifierTestTag15, false, (Function1) objRememberedValue5, 1, null);
                    float f119 = 8;
                    float f1110 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt18 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f119), Dp.m9687constructorimpl(f119), Dp.m9687constructorimpl(f1110), Dp.m9687constructorimpl(f1110));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda1112 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1112;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111118 = z5;
                        final String str111111110 = str4;
                        final boolean z2117 = z12;
                        str10 = str111111110;
                        z15 = z111111118;
                        z16 = z2117;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str111111110, onTextChange, z111111118, z2117, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111119 = z5;
                        final String str111111111 = str4;
                        final boolean z2118 = z12;
                        str10 = str111111111;
                        z15 = z111111119;
                        z16 = z2118;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str111111111, onTextChange, z111111119, z2118, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda1113 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda1113;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i311118 = i6 & 7294;
                    int i311119 = ((i311117 << 12) & 4128768) | ((i311117 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str111111112 = str6;
                    String str111111113 = str10;
                    String str111111114 = str5;
                    Modifier modifier19 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default15, z111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions18, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt18, boxTextFieldColors(composer3, i33), composer2, i311118, i311119, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z111111117;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions18;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str111111112;
                    modifier3 = modifier19;
                    str8 = str111111113;
                    str9 = str111111114;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i22 |= 48;
            if ((i4 & 384) != 0) {
                i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
            }
            i26 = i22;
            if ((i6 & 306783379) == 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z1111111110 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z1111111110;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                } else {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z1111111111 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z1111111111;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str6 != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z1111111112 = z11;
                zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                focusRequester = (FocusRequester) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-497362224);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                } else {
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(-501460796);
                }
                composer3.endReplaceGroup();
                KeyboardActions keyboardActions19 = keyboardActions3;
                int i3111110 = i31;
                Modifier modifierFocusRequester16 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierTestTag16 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester16, (Function1) objRememberedValue4), str4 + ":TextField");
                ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                boolean zChanged16 = composer3.changed(z12);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChanged16 | z13;
                objRememberedValue5 = composer3.rememberedValue();
                if (!z14) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default16 = SemanticsModifierKt.semantics$default(modifierTestTag16, false, (Function1) objRememberedValue5, 1, null);
                float f1111 = 8;
                float f1112 = 0;
                RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt19 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f1111), Dp.m9687constructorimpl(f1111), Dp.m9687constructorimpl(f1112), Dp.m9687constructorimpl(f1112));
                if (str4 == null) {
                    composer3.startReplaceGroup(-496804876);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composer3.startReplaceGroup(-496804875);
                    ComposerKt.sourceInformation(composer3, "*107@4710L26");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str5 == null) {
                    composer3.startReplaceGroup(-496716309);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda2 = null;
                } else {
                    composer3.startReplaceGroup(-496716308);
                    ComposerKt.sourceInformation(composer3, "*109@4812L169");
                    composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (zM9316equalsimpl0) {
                    composer3.startReplaceGroup(-496460899);
                    ComposerKt.sourceInformation(composer3, "117@5046L207");
                    ComposableLambda composableLambdaRememberComposableLambda1114 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1114;
                    z15 = z5;
                    str10 = str4;
                    z16 = z12;
                } else if (!z5) {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z1111111113 = z5;
                    final String str111111115 = str4;
                    final boolean z2119 = z12;
                    str10 = str111111115;
                    z15 = z1111111113;
                    z16 = z2119;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str111111115, onTextChange, z1111111113, z2119, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z1111111114 = z5;
                    final String str111111116 = str4;
                    final boolean z21110 = z12;
                    str10 = str111111116;
                    z15 = z1111111114;
                    z16 = z21110;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str111111116, onTextChange, z1111111114, z21110, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str6 == null) {
                    composer3.startReplaceGroup(-495789130);
                    composer3.endReplaceGroup();
                    composableLambda = null;
                    i32 = 1;
                } else {
                    composer3.startReplaceGroup(-495789129);
                    ComposerKt.sourceInformation(composer3, "*137@5746L314");
                    i32 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda1115 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda1115;
                }
                if (!zM9316equalsimpl0) {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                }
                int i3111111 = i6 & 7294;
                int i3111112 = ((i3111110 << 12) & 4128768) | ((i3111110 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                composer2 = composer3;
                String str111111117 = str6;
                String str111111118 = str10;
                String str111111119 = str5;
                Modifier modifier110 = modifier4;
                TextFieldKt.TextField(text, onTextChange, modifierSemantics$default16, z1111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions19, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt19, boxTextFieldColors(composer3, i33), composer2, i3111111, i3111112, 0, 1183024);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z1111111112;
                keyboardOptions2 = keyboardOptions4;
                keyboardActions2 = keyboardActions19;
                i28 = i30;
                i27 = i29;
                z9 = z10;
                z8 = z15;
                str7 = str111111117;
                modifier3 = modifier110;
                str8 = str111111118;
                str9 = str111111119;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i27 = i;
                z7 = z4;
                str7 = str6;
                z8 = z5;
                str8 = str4;
                str9 = str5;
                modifier3 = modifier2;
                z9 = z3;
                i28 = i2;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 384;
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 != 0) {
            if ((i3 & 3072) == 0) {
                z4 = z;
                if (composerStartRestartGroup.changed(z4)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i6 |= i8;
            }
            i9 = i5 & 16;
            if (i9 != 0) {
                if ((i3 & 24576) == 0) {
                    z5 = z2;
                    if (composerStartRestartGroup.changed(z5)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 32;
                if (i11 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    str4 = str;
                } else {
                    str4 = str;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(str4)) {
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
                    str5 = str2;
                } else {
                    str5 = str2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(str5)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i6 |= i14;
                    }
                }
                i15 = i5 & 128;
                if (i15 != 0) {
                    i6 |= 12582912;
                    str6 = str3;
                } else {
                    str6 = str3;
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(str6)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i6 |= i16;
                    }
                }
                i17 = i5 & 256;
                if (i17 != 0) {
                    i6 |= 100663296;
                } else if ((i3 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i6 |= i18;
                }
                i19 = i5 & 512;
                if (i19 != 0) {
                    if ((i3 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i20 = 268435456;
                        }
                        i6 |= i20;
                    }
                    i21 = i5 & 1024;
                    if (i21 != 0) {
                        i22 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i22 = i4 | i23;
                    } else {
                        i22 = i4;
                    }
                    i24 = i5 & 2048;
                    if (i24 != 0) {
                        if ((i4 & 48) == 0) {
                            if (composerStartRestartGroup.changed(keyboardOptions)) {
                                i25 = 32;
                            } else {
                                i25 = 16;
                            }
                            i22 |= i25;
                        }
                        if ((i4 & 384) != 0) {
                            i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                        }
                        i26 = i22;
                        if ((i6 & 306783379) == 306783378) {
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z1111111115 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z1111111115;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            } else {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                if (i11 != 0) {
                                    str4 = null;
                                }
                                if (i13 != 0) {
                                    str5 = null;
                                }
                                if (i15 != 0) {
                                    str6 = null;
                                }
                                if (i17 != 0) {
                                    z10 = false;
                                } else {
                                    z10 = z3;
                                }
                                if (i19 != 0) {
                                    i29 = 1;
                                } else {
                                    i29 = i;
                                }
                                if (i21 != 0) {
                                    i30 = Integer.MAX_VALUE;
                                } else {
                                    i30 = i2;
                                }
                                if (i24 != 0) {
                                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if ((i5 & 4096) != 0) {
                                    i26 &= -897;
                                    boolean z1111111116 = z4;
                                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                    z11 = z1111111116;
                                } else {
                                    z11 = z4;
                                    keyboardActions3 = keyboardActions;
                                }
                                i31 = i26;
                                modifier4 = modifier2;
                                keyboardOptions4 = keyboardOptions3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (str6 != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            boolean z1111111117 = z11;
                            zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState2 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            focusRequester = (FocusRequester) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z10) {
                                composerStartRestartGroup.startReplaceGroup(-497362224);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                            } else {
                                focusRequester2 = focusRequester;
                                composer3 = composerStartRestartGroup;
                                composer3.startReplaceGroup(-501460796);
                            }
                            composer3.endReplaceGroup();
                            KeyboardActions keyboardActions110 = keyboardActions3;
                            int i3111113 = i31;
                            Modifier modifierFocusRequester17 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                            ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                            objRememberedValue4 = composer3.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierTestTag17 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester17, (Function1) objRememberedValue4), str4 + ":TextField");
                            ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                            boolean zChanged17 = composer3.changed(z12);
                            if ((29360128 & i6) == 8388608) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            z14 = zChanged17 | z13;
                            objRememberedValue5 = composer3.rememberedValue();
                            if (!z14) {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics$default17 = SemanticsModifierKt.semantics$default(modifierTestTag17, false, (Function1) objRememberedValue5, 1, null);
                            float f1113 = 8;
                            float f1114 = 0;
                            RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt110 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f1113), Dp.m9687constructorimpl(f1113), Dp.m9687constructorimpl(f1114), Dp.m9687constructorimpl(f1114));
                            if (str4 == null) {
                                composer3.startReplaceGroup(-496804876);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            } else {
                                composer3.startReplaceGroup(-496804875);
                                ComposerKt.sourceInformation(composer3, "*107@4710L26");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str5 == null) {
                                composer3.startReplaceGroup(-496716309);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda2 = null;
                            } else {
                                composer3.startReplaceGroup(-496716308);
                                ComposerKt.sourceInformation(composer3, "*109@4812L169");
                                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (zM9316equalsimpl0) {
                                composer3.startReplaceGroup(-496460899);
                                ComposerKt.sourceInformation(composer3, "117@5046L207");
                                ComposableLambda composableLambdaRememberComposableLambda1116 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1116;
                                z15 = z5;
                                str10 = str4;
                                z16 = z12;
                            } else if (!z5) {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z1111111118 = z5;
                                final String str1111111110 = str4;
                                final boolean z21111 = z12;
                                str10 = str1111111110;
                                z15 = z1111111118;
                                z16 = z21111;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str1111111110, onTextChange, z1111111118, z21111, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-496174583);
                                ComposerKt.sourceInformation(composer3, "124@5332L291");
                                final boolean z1111111119 = z5;
                                final String str1111111111 = str4;
                                final boolean z21112 = z12;
                                str10 = str1111111111;
                                z15 = z1111111119;
                                z16 = z21112;
                                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111, onTextChange, z1111111119, z21112, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                            }
                            if (str6 == null) {
                                composer3.startReplaceGroup(-495789130);
                                composer3.endReplaceGroup();
                                composableLambda = null;
                                i32 = 1;
                            } else {
                                composer3.startReplaceGroup(-495789129);
                                ComposerKt.sourceInformation(composer3, "*137@5746L314");
                                i32 = 1;
                                ComposableLambda composableLambdaRememberComposableLambda1117 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer3, 54);
                                composer3.endReplaceGroup();
                                composableLambda = composableLambdaRememberComposableLambda1117;
                            }
                            if (!zM9316equalsimpl0) {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            } else {
                                i33 = 0;
                                none = VisualTransformation.INSTANCE.getNone();
                            }
                            int i3111114 = i6 & 7294;
                            int i3111115 = ((i3111113 << 12) & 4128768) | ((i3111113 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                            composer2 = composer3;
                            String str1111111112 = str6;
                            String str1111111113 = str10;
                            String str1111111114 = str5;
                            Modifier modifier111 = modifier4;
                            TextFieldKt.TextField(text, onTextChange, modifierSemantics$default17, z1111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions110, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt110, boxTextFieldColors(composer3, i33), composer2, i3111114, i3111115, 0, 1183024);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z1111111117;
                            keyboardOptions2 = keyboardOptions4;
                            keyboardActions2 = keyboardActions110;
                            i28 = i30;
                            i27 = i29;
                            z9 = z10;
                            z8 = z15;
                            str7 = str1111111112;
                            modifier3 = modifier111;
                            str8 = str1111111113;
                            str9 = str1111111114;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i27 = i;
                            z7 = z4;
                            str7 = str6;
                            z8 = z5;
                            str8 = str4;
                            str9 = str5;
                            modifier3 = modifier2;
                            z9 = z3;
                            i28 = i2;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions2 = keyboardActions;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i22 |= 48;
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111111110 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111111110;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111111111 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111111111;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z11111111112 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions111 = keyboardActions3;
                        int i3111116 = i31;
                        Modifier modifierFocusRequester18 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag18 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester18, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged18 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged18 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default18 = SemanticsModifierKt.semantics$default(modifierTestTag18, false, (Function1) objRememberedValue5, 1, null);
                        float f1115 = 8;
                        float f1116 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt111 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f1115), Dp.m9687constructorimpl(f1115), Dp.m9687constructorimpl(f1116), Dp.m9687constructorimpl(f1116));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda1118 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1118;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111111113 = z5;
                            final String str1111111115 = str4;
                            final boolean z21113 = z12;
                            str10 = str1111111115;
                            z15 = z11111111113;
                            z16 = z21113;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str1111111115, onTextChange, z11111111113, z21113, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111111114 = z5;
                            final String str1111111116 = str4;
                            final boolean z21114 = z12;
                            str10 = str1111111116;
                            z15 = z11111111114;
                            z16 = z21114;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str1111111116, onTextChange, z11111111114, z21114, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda1119 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda1119;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i3111117 = i6 & 7294;
                        int i3111118 = ((i3111116 << 12) & 4128768) | ((i3111116 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str1111111117 = str6;
                        String str1111111118 = str10;
                        String str1111111119 = str5;
                        Modifier modifier112 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default18, z11111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions111, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt111, boxTextFieldColors(composer3, i33), composer2, i3111117, i3111118, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z11111111112;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions111;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str1111111117;
                        modifier3 = modifier112;
                        str8 = str1111111118;
                        str9 = str1111111119;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 805306368;
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i4 | i23;
                } else {
                    i22 = i4;
                }
                i24 = i5 & 2048;
                if (i24 != 0) {
                    if ((i4 & 48) == 0) {
                        if (composerStartRestartGroup.changed(keyboardOptions)) {
                            i25 = 32;
                        } else {
                            i25 = 16;
                        }
                        i22 |= i25;
                    }
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111111115 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111111115;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111111116 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111111116;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z11111111117 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions112 = keyboardActions3;
                        int i3111119 = i31;
                        Modifier modifierFocusRequester19 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag19 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester19, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged19 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged19 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default19 = SemanticsModifierKt.semantics$default(modifierTestTag19, false, (Function1) objRememberedValue5, 1, null);
                        float f1117 = 8;
                        float f1118 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt112 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f1117), Dp.m9687constructorimpl(f1117), Dp.m9687constructorimpl(f1118), Dp.m9687constructorimpl(f1118));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda11110 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda11110;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111111118 = z5;
                            final String str11111111110 = str4;
                            final boolean z21115 = z12;
                            str10 = str11111111110;
                            z15 = z11111111118;
                            z16 = z21115;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11111111110, onTextChange, z11111111118, z21115, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111111119 = z5;
                            final String str11111111111 = str4;
                            final boolean z21116 = z12;
                            str10 = str11111111111;
                            z15 = z11111111119;
                            z16 = z21116;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111, onTextChange, z11111111119, z21116, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda11111 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda11111;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i31111110 = i6 & 7294;
                        int i31111111 = ((i3111119 << 12) & 4128768) | ((i3111119 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str11111111112 = str6;
                        String str11111111113 = str10;
                        String str11111111114 = str5;
                        Modifier modifier113 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default19, z11111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions112, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt112, boxTextFieldColors(composer3, i33), composer2, i31111110, i31111111, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z11111111117;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions112;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str11111111112;
                        modifier3 = modifier113;
                        str8 = str11111111113;
                        str9 = str11111111114;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i22 |= 48;
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111111110 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111111110;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111111111 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111111111;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z111111111112 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions113 = keyboardActions3;
                    int i31111112 = i31;
                    Modifier modifierFocusRequester110 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag110 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester110, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged110 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged110 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default110 = SemanticsModifierKt.semantics$default(modifierTestTag110, false, (Function1) objRememberedValue5, 1, null);
                    float f1119 = 8;
                    float f11110 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt113 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f1119), Dp.m9687constructorimpl(f1119), Dp.m9687constructorimpl(f11110), Dp.m9687constructorimpl(f11110));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda11112 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda11112;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111111113 = z5;
                        final String str11111111115 = str4;
                        final boolean z21117 = z12;
                        str10 = str11111111115;
                        z15 = z111111111113;
                        z16 = z21117;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11111111115, onTextChange, z111111111113, z21117, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111111114 = z5;
                        final String str11111111116 = str4;
                        final boolean z21118 = z12;
                        str10 = str11111111116;
                        z15 = z111111111114;
                        z16 = z21118;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11111111116, onTextChange, z111111111114, z21118, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda11113 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda11113;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i31111113 = i6 & 7294;
                    int i31111114 = ((i31111112 << 12) & 4128768) | ((i31111112 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str11111111117 = str6;
                    String str11111111118 = str10;
                    String str11111111119 = str5;
                    Modifier modifier114 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default110, z111111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions113, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt113, boxTextFieldColors(composer3, i33), composer2, i31111113, i31111114, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z111111111112;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions113;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str11111111117;
                    modifier3 = modifier114;
                    str8 = str11111111118;
                    str9 = str11111111119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 24576;
            z5 = z2;
            i11 = i5 & 32;
            if (i11 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str4 = str;
            } else {
                str4 = str;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(str4)) {
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
                str5 = str2;
            } else {
                str5 = str2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(str5)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i6 |= i14;
                }
            }
            i15 = i5 & 128;
            if (i15 != 0) {
                i6 |= 12582912;
                str6 = str3;
            } else {
                str6 = str3;
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(str6)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i6 |= i16;
                }
            }
            i17 = i5 & 256;
            if (i17 != 0) {
                i6 |= 100663296;
            } else if ((i3 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i6 |= i18;
            }
            i19 = i5 & 512;
            if (i19 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i20 = 268435456;
                    }
                    i6 |= i20;
                }
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i4 | i23;
                } else {
                    i22 = i4;
                }
                i24 = i5 & 2048;
                if (i24 != 0) {
                    if ((i4 & 48) == 0) {
                        if (composerStartRestartGroup.changed(keyboardOptions)) {
                            i25 = 32;
                        } else {
                            i25 = 16;
                        }
                        i22 |= i25;
                    }
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z111111111115 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z111111111115;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z111111111116 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z111111111116;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z111111111117 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions114 = keyboardActions3;
                        int i31111115 = i31;
                        Modifier modifierFocusRequester111 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag111 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester111, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged111 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged111 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default111 = SemanticsModifierKt.semantics$default(modifierTestTag111, false, (Function1) objRememberedValue5, 1, null);
                        float f11111 = 8;
                        float f11112 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt114 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f11111), Dp.m9687constructorimpl(f11111), Dp.m9687constructorimpl(f11112), Dp.m9687constructorimpl(f11112));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda11114 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda11114;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z111111111118 = z5;
                            final String str111111111110 = str4;
                            final boolean z21119 = z12;
                            str10 = str111111111110;
                            z15 = z111111111118;
                            z16 = z21119;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str111111111110, onTextChange, z111111111118, z21119, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z111111111119 = z5;
                            final String str111111111111 = str4;
                            final boolean z211110 = z12;
                            str10 = str111111111111;
                            z15 = z111111111119;
                            z16 = z211110;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str111111111111, onTextChange, z111111111119, z211110, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda11115 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda11115;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i31111116 = i6 & 7294;
                        int i31111117 = ((i31111115 << 12) & 4128768) | ((i31111115 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str111111111112 = str6;
                        String str111111111113 = str10;
                        String str111111111114 = str5;
                        Modifier modifier115 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default111, z111111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions114, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt114, boxTextFieldColors(composer3, i33), composer2, i31111116, i31111117, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z111111111117;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions114;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str111111111112;
                        modifier3 = modifier115;
                        str8 = str111111111113;
                        str9 = str111111111114;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i22 |= 48;
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z1111111111110 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z1111111111110;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z1111111111111 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z1111111111111;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z1111111111112 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions115 = keyboardActions3;
                    int i31111118 = i31;
                    Modifier modifierFocusRequester112 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag112 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester112, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged112 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged112 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default112 = SemanticsModifierKt.semantics$default(modifierTestTag112, false, (Function1) objRememberedValue5, 1, null);
                    float f11113 = 8;
                    float f11114 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt115 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f11113), Dp.m9687constructorimpl(f11113), Dp.m9687constructorimpl(f11114), Dp.m9687constructorimpl(f11114));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda11116 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda11116;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z1111111111113 = z5;
                        final String str111111111115 = str4;
                        final boolean z211111 = z12;
                        str10 = str111111111115;
                        z15 = z1111111111113;
                        z16 = z211111;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str111111111115, onTextChange, z1111111111113, z211111, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z1111111111114 = z5;
                        final String str111111111116 = str4;
                        final boolean z211112 = z12;
                        str10 = str111111111116;
                        z15 = z1111111111114;
                        z16 = z211112;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str111111111116, onTextChange, z1111111111114, z211112, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda11117 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda11117;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i31111119 = i6 & 7294;
                    int i311111110 = ((i31111118 << 12) & 4128768) | ((i31111118 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str111111111117 = str6;
                    String str111111111118 = str10;
                    String str111111111119 = str5;
                    Modifier modifier116 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default112, z1111111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions115, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt115, boxTextFieldColors(composer3, i33), composer2, i31111119, i311111110, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z1111111111112;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions115;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str111111111117;
                    modifier3 = modifier116;
                    str8 = str111111111118;
                    str9 = str111111111119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            i21 = i5 & 1024;
            if (i21 != 0) {
                i22 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i4 | i23;
            } else {
                i22 = i4;
            }
            i24 = i5 & 2048;
            if (i24 != 0) {
                if ((i4 & 48) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions)) {
                        i25 = 32;
                    } else {
                        i25 = 16;
                    }
                    i22 |= i25;
                }
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z1111111111115 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z1111111111115;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z1111111111116 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z1111111111116;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z1111111111117 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions116 = keyboardActions3;
                    int i311111111 = i31;
                    Modifier modifierFocusRequester113 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag113 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester113, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged113 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged113 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default113 = SemanticsModifierKt.semantics$default(modifierTestTag113, false, (Function1) objRememberedValue5, 1, null);
                    float f11115 = 8;
                    float f11116 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt116 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f11115), Dp.m9687constructorimpl(f11115), Dp.m9687constructorimpl(f11116), Dp.m9687constructorimpl(f11116));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda11118 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda11118;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z1111111111118 = z5;
                        final String str1111111111110 = str4;
                        final boolean z211113 = z12;
                        str10 = str1111111111110;
                        z15 = z1111111111118;
                        z16 = z211113;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111110, onTextChange, z1111111111118, z211113, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z1111111111119 = z5;
                        final String str1111111111111 = str4;
                        final boolean z211114 = z12;
                        str10 = str1111111111111;
                        z15 = z1111111111119;
                        z16 = z211114;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111111, onTextChange, z1111111111119, z211114, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda11119 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda11119;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i311111112 = i6 & 7294;
                    int i311111113 = ((i311111111 << 12) & 4128768) | ((i311111111 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str1111111111112 = str6;
                    String str1111111111113 = str10;
                    String str1111111111114 = str5;
                    Modifier modifier117 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default113, z1111111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions116, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt116, boxTextFieldColors(composer3, i33), composer2, i311111112, i311111113, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z1111111111117;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions116;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str1111111111112;
                    modifier3 = modifier117;
                    str8 = str1111111111113;
                    str9 = str1111111111114;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i22 |= 48;
            if ((i4 & 384) != 0) {
                i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
            }
            i26 = i22;
            if ((i6 & 306783379) == 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z11111111111110 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z11111111111110;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                } else {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z11111111111111 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z11111111111111;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str6 != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z11111111111112 = z11;
                zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                focusRequester = (FocusRequester) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-497362224);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                } else {
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(-501460796);
                }
                composer3.endReplaceGroup();
                KeyboardActions keyboardActions117 = keyboardActions3;
                int i311111114 = i31;
                Modifier modifierFocusRequester114 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierTestTag114 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester114, (Function1) objRememberedValue4), str4 + ":TextField");
                ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                boolean zChanged114 = composer3.changed(z12);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChanged114 | z13;
                objRememberedValue5 = composer3.rememberedValue();
                if (!z14) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default114 = SemanticsModifierKt.semantics$default(modifierTestTag114, false, (Function1) objRememberedValue5, 1, null);
                float f11117 = 8;
                float f11118 = 0;
                RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt117 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f11117), Dp.m9687constructorimpl(f11117), Dp.m9687constructorimpl(f11118), Dp.m9687constructorimpl(f11118));
                if (str4 == null) {
                    composer3.startReplaceGroup(-496804876);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composer3.startReplaceGroup(-496804875);
                    ComposerKt.sourceInformation(composer3, "*107@4710L26");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str5 == null) {
                    composer3.startReplaceGroup(-496716309);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda2 = null;
                } else {
                    composer3.startReplaceGroup(-496716308);
                    ComposerKt.sourceInformation(composer3, "*109@4812L169");
                    composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (zM9316equalsimpl0) {
                    composer3.startReplaceGroup(-496460899);
                    ComposerKt.sourceInformation(composer3, "117@5046L207");
                    ComposableLambda composableLambdaRememberComposableLambda111110 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda111110;
                    z15 = z5;
                    str10 = str4;
                    z16 = z12;
                } else if (!z5) {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z11111111111113 = z5;
                    final String str1111111111115 = str4;
                    final boolean z211115 = z12;
                    str10 = str1111111111115;
                    z15 = z11111111111113;
                    z16 = z211115;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111115, onTextChange, z11111111111113, z211115, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z11111111111114 = z5;
                    final String str1111111111116 = str4;
                    final boolean z211116 = z12;
                    str10 = str1111111111116;
                    z15 = z11111111111114;
                    z16 = z211116;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111116, onTextChange, z11111111111114, z211116, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str6 == null) {
                    composer3.startReplaceGroup(-495789130);
                    composer3.endReplaceGroup();
                    composableLambda = null;
                    i32 = 1;
                } else {
                    composer3.startReplaceGroup(-495789129);
                    ComposerKt.sourceInformation(composer3, "*137@5746L314");
                    i32 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda111111 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda111111;
                }
                if (!zM9316equalsimpl0) {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                }
                int i311111115 = i6 & 7294;
                int i311111116 = ((i311111114 << 12) & 4128768) | ((i311111114 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                composer2 = composer3;
                String str1111111111117 = str6;
                String str1111111111118 = str10;
                String str1111111111119 = str5;
                Modifier modifier118 = modifier4;
                TextFieldKt.TextField(text, onTextChange, modifierSemantics$default114, z11111111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions117, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt117, boxTextFieldColors(composer3, i33), composer2, i311111115, i311111116, 0, 1183024);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z11111111111112;
                keyboardOptions2 = keyboardOptions4;
                keyboardActions2 = keyboardActions117;
                i28 = i30;
                i27 = i29;
                z9 = z10;
                z8 = z15;
                str7 = str1111111111117;
                modifier3 = modifier118;
                str8 = str1111111111118;
                str9 = str1111111111119;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i27 = i;
                z7 = z4;
                str7 = str6;
                z8 = z5;
                str8 = str4;
                str9 = str5;
                modifier3 = modifier2;
                z9 = z3;
                i28 = i2;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 3072;
        z4 = z;
        i9 = i5 & 16;
        if (i9 != 0) {
            if ((i3 & 24576) == 0) {
                z5 = z2;
                if (composerStartRestartGroup.changed(z5)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i6 |= i10;
            }
            i11 = i5 & 32;
            if (i11 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str4 = str;
            } else {
                str4 = str;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(str4)) {
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
                str5 = str2;
            } else {
                str5 = str2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(str5)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i6 |= i14;
                }
            }
            i15 = i5 & 128;
            if (i15 != 0) {
                i6 |= 12582912;
                str6 = str3;
            } else {
                str6 = str3;
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(str6)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i6 |= i16;
                }
            }
            i17 = i5 & 256;
            if (i17 != 0) {
                i6 |= 100663296;
            } else if ((i3 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i6 |= i18;
            }
            i19 = i5 & 512;
            if (i19 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i20 = 268435456;
                    }
                    i6 |= i20;
                }
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i22 = i4 | i23;
                } else {
                    i22 = i4;
                }
                i24 = i5 & 2048;
                if (i24 != 0) {
                    if ((i4 & 48) == 0) {
                        if (composerStartRestartGroup.changed(keyboardOptions)) {
                            i25 = 32;
                        } else {
                            i25 = 16;
                        }
                        i22 |= i25;
                    }
                    if ((i4 & 384) != 0) {
                        i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                    }
                    i26 = i22;
                    if ((i6 & 306783379) == 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111111111115 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111111111115;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        } else {
                            if (i34 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i7 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            if (i11 != 0) {
                                str4 = null;
                            }
                            if (i13 != 0) {
                                str5 = null;
                            }
                            if (i15 != 0) {
                                str6 = null;
                            }
                            if (i17 != 0) {
                                z10 = false;
                            } else {
                                z10 = z3;
                            }
                            if (i19 != 0) {
                                i29 = 1;
                            } else {
                                i29 = i;
                            }
                            if (i21 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i2;
                            }
                            if (i24 != 0) {
                                keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if ((i5 & 4096) != 0) {
                                i26 &= -897;
                                boolean z11111111111116 = z4;
                                keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                z11 = z11111111111116;
                            } else {
                                z11 = z4;
                                keyboardActions3 = keyboardActions;
                            }
                            i31 = i26;
                            modifier4 = modifier2;
                            keyboardOptions4 = keyboardOptions3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (str6 != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean z11111111111117 = z11;
                        zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        focusRequester = (FocusRequester) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z10) {
                            composerStartRestartGroup.startReplaceGroup(-497362224);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                        } else {
                            focusRequester2 = focusRequester;
                            composer3 = composerStartRestartGroup;
                            composer3.startReplaceGroup(-501460796);
                        }
                        composer3.endReplaceGroup();
                        KeyboardActions keyboardActions118 = keyboardActions3;
                        int i311111117 = i31;
                        Modifier modifierFocusRequester115 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                        ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                        objRememberedValue4 = composer3.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierTestTag115 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester115, (Function1) objRememberedValue4), str4 + ":TextField");
                        ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                        boolean zChanged115 = composer3.changed(z12);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChanged115 | z13;
                        objRememberedValue5 = composer3.rememberedValue();
                        if (!z14) {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default115 = SemanticsModifierKt.semantics$default(modifierTestTag115, false, (Function1) objRememberedValue5, 1, null);
                        float f11119 = 8;
                        float f111110 = 0;
                        RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt118 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f11119), Dp.m9687constructorimpl(f11119), Dp.m9687constructorimpl(f111110), Dp.m9687constructorimpl(f111110));
                        if (str4 == null) {
                            composer3.startReplaceGroup(-496804876);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            composer3.startReplaceGroup(-496804875);
                            ComposerKt.sourceInformation(composer3, "*107@4710L26");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str5 == null) {
                            composer3.startReplaceGroup(-496716309);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda2 = null;
                        } else {
                            composer3.startReplaceGroup(-496716308);
                            ComposerKt.sourceInformation(composer3, "*109@4812L169");
                            composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (zM9316equalsimpl0) {
                            composer3.startReplaceGroup(-496460899);
                            ComposerKt.sourceInformation(composer3, "117@5046L207");
                            ComposableLambda composableLambdaRememberComposableLambda111112 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda111112;
                            z15 = z5;
                            str10 = str4;
                            z16 = z12;
                        } else if (!z5) {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111111111118 = z5;
                            final String str11111111111110 = str4;
                            final boolean z211117 = z12;
                            str10 = str11111111111110;
                            z15 = z11111111111118;
                            z16 = z211117;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111110, onTextChange, z11111111111118, z211117, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-496174583);
                            ComposerKt.sourceInformation(composer3, "124@5332L291");
                            final boolean z11111111111119 = z5;
                            final String str11111111111111 = str4;
                            final boolean z211118 = z12;
                            str10 = str11111111111111;
                            z15 = z11111111111119;
                            z16 = z211118;
                            composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111111, onTextChange, z11111111111119, z211118, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                        }
                        if (str6 == null) {
                            composer3.startReplaceGroup(-495789130);
                            composer3.endReplaceGroup();
                            composableLambda = null;
                            i32 = 1;
                        } else {
                            composer3.startReplaceGroup(-495789129);
                            ComposerKt.sourceInformation(composer3, "*137@5746L314");
                            i32 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda111113 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            composer3.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda111113;
                        }
                        if (!zM9316equalsimpl0) {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            i33 = 0;
                            none = VisualTransformation.INSTANCE.getNone();
                        }
                        int i311111118 = i6 & 7294;
                        int i311111119 = ((i311111117 << 12) & 4128768) | ((i311111117 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                        composer2 = composer3;
                        String str11111111111112 = str6;
                        String str11111111111113 = str10;
                        String str11111111111114 = str5;
                        Modifier modifier119 = modifier4;
                        TextFieldKt.TextField(text, onTextChange, modifierSemantics$default115, z11111111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions118, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt118, boxTextFieldColors(composer3, i33), composer2, i311111118, i311111119, 0, 1183024);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z7 = z11111111111117;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions2 = keyboardActions118;
                        i28 = i30;
                        i27 = i29;
                        z9 = z10;
                        z8 = z15;
                        str7 = str11111111111112;
                        modifier3 = modifier119;
                        str8 = str11111111111113;
                        str9 = str11111111111114;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        i27 = i;
                        z7 = z4;
                        str7 = str6;
                        z8 = z5;
                        str8 = str4;
                        str9 = str5;
                        modifier3 = modifier2;
                        z9 = z3;
                        i28 = i2;
                        keyboardOptions2 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i22 |= 48;
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111111111110 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111111111110;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111111111111 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111111111111;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z111111111111112 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions119 = keyboardActions3;
                    int i3111111110 = i31;
                    Modifier modifierFocusRequester116 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag116 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester116, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged116 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged116 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default116 = SemanticsModifierKt.semantics$default(modifierTestTag116, false, (Function1) objRememberedValue5, 1, null);
                    float f111111 = 8;
                    float f111112 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt119 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f111111), Dp.m9687constructorimpl(f111111), Dp.m9687constructorimpl(f111112), Dp.m9687constructorimpl(f111112));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda111114 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda111114;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111111111113 = z5;
                        final String str11111111111115 = str4;
                        final boolean z211119 = z12;
                        str10 = str11111111111115;
                        z15 = z111111111111113;
                        z16 = z211119;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111115, onTextChange, z111111111111113, z211119, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111111111114 = z5;
                        final String str11111111111116 = str4;
                        final boolean z2111110 = z12;
                        str10 = str11111111111116;
                        z15 = z111111111111114;
                        z16 = z2111110;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111116, onTextChange, z111111111111114, z2111110, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda111115 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda111115;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i3111111111 = i6 & 7294;
                    int i3111111112 = ((i3111111110 << 12) & 4128768) | ((i3111111110 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str11111111111117 = str6;
                    String str11111111111118 = str10;
                    String str11111111111119 = str5;
                    Modifier modifier1110 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default116, z111111111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions119, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt119, boxTextFieldColors(composer3, i33), composer2, i3111111111, i3111111112, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z111111111111112;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions119;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str11111111111117;
                    modifier3 = modifier1110;
                    str8 = str11111111111118;
                    str9 = str11111111111119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            i21 = i5 & 1024;
            if (i21 != 0) {
                i22 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i4 | i23;
            } else {
                i22 = i4;
            }
            i24 = i5 & 2048;
            if (i24 != 0) {
                if ((i4 & 48) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions)) {
                        i25 = 32;
                    } else {
                        i25 = 16;
                    }
                    i22 |= i25;
                }
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111111111115 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111111111115;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z111111111111116 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z111111111111116;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z111111111111117 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions1110 = keyboardActions3;
                    int i3111111113 = i31;
                    Modifier modifierFocusRequester117 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag117 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester117, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged117 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged117 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default117 = SemanticsModifierKt.semantics$default(modifierTestTag117, false, (Function1) objRememberedValue5, 1, null);
                    float f111113 = 8;
                    float f111114 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt1110 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f111113), Dp.m9687constructorimpl(f111113), Dp.m9687constructorimpl(f111114), Dp.m9687constructorimpl(f111114));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda111116 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda111116;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111111111118 = z5;
                        final String str111111111111110 = str4;
                        final boolean z2111111 = z12;
                        str10 = str111111111111110;
                        z15 = z111111111111118;
                        z16 = z2111111;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str111111111111110, onTextChange, z111111111111118, z2111111, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z111111111111119 = z5;
                        final String str111111111111111 = str4;
                        final boolean z2111112 = z12;
                        str10 = str111111111111111;
                        z15 = z111111111111119;
                        z16 = z2111112;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str111111111111111, onTextChange, z111111111111119, z2111112, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda111117 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda111117;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i3111111114 = i6 & 7294;
                    int i3111111115 = ((i3111111113 << 12) & 4128768) | ((i3111111113 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str111111111111112 = str6;
                    String str111111111111113 = str10;
                    String str111111111111114 = str5;
                    Modifier modifier1111 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default117, z111111111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions1110, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt1110, boxTextFieldColors(composer3, i33), composer2, i3111111114, i3111111115, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z111111111111117;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions1110;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str111111111111112;
                    modifier3 = modifier1111;
                    str8 = str111111111111113;
                    str9 = str111111111111114;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i22 |= 48;
            if ((i4 & 384) != 0) {
                i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
            }
            i26 = i22;
            if ((i6 & 306783379) == 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z1111111111111110 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z1111111111111110;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                } else {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z1111111111111111 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z1111111111111111;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str6 != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z1111111111111112 = z11;
                zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                focusRequester = (FocusRequester) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-497362224);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                } else {
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(-501460796);
                }
                composer3.endReplaceGroup();
                KeyboardActions keyboardActions1111 = keyboardActions3;
                int i3111111116 = i31;
                Modifier modifierFocusRequester118 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierTestTag118 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester118, (Function1) objRememberedValue4), str4 + ":TextField");
                ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                boolean zChanged118 = composer3.changed(z12);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChanged118 | z13;
                objRememberedValue5 = composer3.rememberedValue();
                if (!z14) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default118 = SemanticsModifierKt.semantics$default(modifierTestTag118, false, (Function1) objRememberedValue5, 1, null);
                float f111115 = 8;
                float f111116 = 0;
                RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt1111 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f111115), Dp.m9687constructorimpl(f111115), Dp.m9687constructorimpl(f111116), Dp.m9687constructorimpl(f111116));
                if (str4 == null) {
                    composer3.startReplaceGroup(-496804876);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composer3.startReplaceGroup(-496804875);
                    ComposerKt.sourceInformation(composer3, "*107@4710L26");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str5 == null) {
                    composer3.startReplaceGroup(-496716309);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda2 = null;
                } else {
                    composer3.startReplaceGroup(-496716308);
                    ComposerKt.sourceInformation(composer3, "*109@4812L169");
                    composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (zM9316equalsimpl0) {
                    composer3.startReplaceGroup(-496460899);
                    ComposerKt.sourceInformation(composer3, "117@5046L207");
                    ComposableLambda composableLambdaRememberComposableLambda111118 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda111118;
                    z15 = z5;
                    str10 = str4;
                    z16 = z12;
                } else if (!z5) {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z1111111111111113 = z5;
                    final String str111111111111115 = str4;
                    final boolean z2111113 = z12;
                    str10 = str111111111111115;
                    z15 = z1111111111111113;
                    z16 = z2111113;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str111111111111115, onTextChange, z1111111111111113, z2111113, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z1111111111111114 = z5;
                    final String str111111111111116 = str4;
                    final boolean z2111114 = z12;
                    str10 = str111111111111116;
                    z15 = z1111111111111114;
                    z16 = z2111114;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str111111111111116, onTextChange, z1111111111111114, z2111114, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str6 == null) {
                    composer3.startReplaceGroup(-495789130);
                    composer3.endReplaceGroup();
                    composableLambda = null;
                    i32 = 1;
                } else {
                    composer3.startReplaceGroup(-495789129);
                    ComposerKt.sourceInformation(composer3, "*137@5746L314");
                    i32 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda111119 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda111119;
                }
                if (!zM9316equalsimpl0) {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                }
                int i3111111117 = i6 & 7294;
                int i3111111118 = ((i3111111116 << 12) & 4128768) | ((i3111111116 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                composer2 = composer3;
                String str111111111111117 = str6;
                String str111111111111118 = str10;
                String str111111111111119 = str5;
                Modifier modifier1112 = modifier4;
                TextFieldKt.TextField(text, onTextChange, modifierSemantics$default118, z1111111111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions1111, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt1111, boxTextFieldColors(composer3, i33), composer2, i3111111117, i3111111118, 0, 1183024);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z1111111111111112;
                keyboardOptions2 = keyboardOptions4;
                keyboardActions2 = keyboardActions1111;
                i28 = i30;
                i27 = i29;
                z9 = z10;
                z8 = z15;
                str7 = str111111111111117;
                modifier3 = modifier1112;
                str8 = str111111111111118;
                str9 = str111111111111119;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i27 = i;
                z7 = z4;
                str7 = str6;
                z8 = z5;
                str8 = str4;
                str9 = str5;
                modifier3 = modifier2;
                z9 = z3;
                i28 = i2;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 24576;
        z5 = z2;
        i11 = i5 & 32;
        if (i11 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str4 = str;
        } else {
            str4 = str;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(str4)) {
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
            str5 = str2;
        } else {
            str5 = str2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(str5)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i6 |= i14;
            }
        }
        i15 = i5 & 128;
        if (i15 != 0) {
            i6 |= 12582912;
            str6 = str3;
        } else {
            str6 = str3;
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(str6)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i6 |= i16;
            }
        }
        i17 = i5 & 256;
        if (i17 != 0) {
            i6 |= 100663296;
        } else if ((i3 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i18 = 67108864;
            } else {
                i18 = 33554432;
            }
            i6 |= i18;
        }
        i19 = i5 & 512;
        if (i19 != 0) {
            if ((i3 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i20 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i20 = 268435456;
                }
                i6 |= i20;
            }
            i21 = i5 & 1024;
            if (i21 != 0) {
                i22 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i22 = i4 | i23;
            } else {
                i22 = i4;
            }
            i24 = i5 & 2048;
            if (i24 != 0) {
                if ((i4 & 48) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions)) {
                        i25 = 32;
                    } else {
                        i25 = 16;
                    }
                    i22 |= i25;
                }
                if ((i4 & 384) != 0) {
                    i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
                }
                i26 = i22;
                if ((i6 & 306783379) == 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z1111111111111115 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z1111111111111115;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    } else {
                        if (i34 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i7 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        if (i11 != 0) {
                            str4 = null;
                        }
                        if (i13 != 0) {
                            str5 = null;
                        }
                        if (i15 != 0) {
                            str6 = null;
                        }
                        if (i17 != 0) {
                            z10 = false;
                        } else {
                            z10 = z3;
                        }
                        if (i19 != 0) {
                            i29 = 1;
                        } else {
                            i29 = i;
                        }
                        if (i21 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i2;
                        }
                        if (i24 != 0) {
                            keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if ((i5 & 4096) != 0) {
                            i26 &= -897;
                            boolean z1111111111111116 = z4;
                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            z11 = z1111111111111116;
                        } else {
                            z11 = z4;
                            keyboardActions3 = keyboardActions;
                        }
                        i31 = i26;
                        modifier4 = modifier2;
                        keyboardOptions4 = keyboardOptions3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str6 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z1111111111111117 = z11;
                    zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    focusRequester = (FocusRequester) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z10) {
                        composerStartRestartGroup.startReplaceGroup(-497362224);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                    } else {
                        focusRequester2 = focusRequester;
                        composer3 = composerStartRestartGroup;
                        composer3.startReplaceGroup(-501460796);
                    }
                    composer3.endReplaceGroup();
                    KeyboardActions keyboardActions1112 = keyboardActions3;
                    int i3111111119 = i31;
                    Modifier modifierFocusRequester119 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                    ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                    objRememberedValue4 = composer3.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierTestTag119 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester119, (Function1) objRememberedValue4), str4 + ":TextField");
                    ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean zChanged119 = composer3.changed(z12);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChanged119 | z13;
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z14) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default119 = SemanticsModifierKt.semantics$default(modifierTestTag119, false, (Function1) objRememberedValue5, 1, null);
                    float f111117 = 8;
                    float f111118 = 0;
                    RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt1112 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f111117), Dp.m9687constructorimpl(f111117), Dp.m9687constructorimpl(f111118), Dp.m9687constructorimpl(f111118));
                    if (str4 == null) {
                        composer3.startReplaceGroup(-496804876);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        composer3.startReplaceGroup(-496804875);
                        ComposerKt.sourceInformation(composer3, "*107@4710L26");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str5 == null) {
                        composer3.startReplaceGroup(-496716309);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda2 = null;
                    } else {
                        composer3.startReplaceGroup(-496716308);
                        ComposerKt.sourceInformation(composer3, "*109@4812L169");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (zM9316equalsimpl0) {
                        composer3.startReplaceGroup(-496460899);
                        ComposerKt.sourceInformation(composer3, "117@5046L207");
                        ComposableLambda composableLambdaRememberComposableLambda1111110 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1111110;
                        z15 = z5;
                        str10 = str4;
                        z16 = z12;
                    } else if (!z5) {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z1111111111111118 = z5;
                        final String str1111111111111110 = str4;
                        final boolean z2111115 = z12;
                        str10 = str1111111111111110;
                        z15 = z1111111111111118;
                        z16 = z2111115;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111111110, onTextChange, z1111111111111118, z2111115, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-496174583);
                        ComposerKt.sourceInformation(composer3, "124@5332L291");
                        final boolean z1111111111111119 = z5;
                        final String str1111111111111111 = str4;
                        final boolean z2111116 = z12;
                        str10 = str1111111111111111;
                        z15 = z1111111111111119;
                        z16 = z2111116;
                        composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111111111, onTextChange, z1111111111111119, z2111116, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                    }
                    if (str6 == null) {
                        composer3.startReplaceGroup(-495789130);
                        composer3.endReplaceGroup();
                        composableLambda = null;
                        i32 = 1;
                    } else {
                        composer3.startReplaceGroup(-495789129);
                        ComposerKt.sourceInformation(composer3, "*137@5746L314");
                        i32 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda1111111 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        composer3.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda1111111;
                    }
                    if (!zM9316equalsimpl0) {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        i33 = 0;
                        none = VisualTransformation.INSTANCE.getNone();
                    }
                    int i31111111110 = i6 & 7294;
                    int i31111111111 = ((i3111111119 << 12) & 4128768) | ((i3111111119 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                    composer2 = composer3;
                    String str1111111111111112 = str6;
                    String str1111111111111113 = str10;
                    String str1111111111111114 = str5;
                    Modifier modifier1113 = modifier4;
                    TextFieldKt.TextField(text, onTextChange, modifierSemantics$default119, z1111111111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions1112, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt1112, boxTextFieldColors(composer3, i33), composer2, i31111111110, i31111111111, 0, 1183024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z1111111111111117;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions1112;
                    i28 = i30;
                    i27 = i29;
                    z9 = z10;
                    z8 = z15;
                    str7 = str1111111111111112;
                    modifier3 = modifier1113;
                    str8 = str1111111111111113;
                    str9 = str1111111111111114;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    i27 = i;
                    z7 = z4;
                    str7 = str6;
                    z8 = z5;
                    str8 = str4;
                    str9 = str5;
                    modifier3 = modifier2;
                    z9 = z3;
                    i28 = i2;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i22 |= 48;
            if ((i4 & 384) != 0) {
                i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
            }
            i26 = i22;
            if ((i6 & 306783379) == 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z11111111111111110 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z11111111111111110;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                } else {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z11111111111111111 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z11111111111111111;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str6 != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z11111111111111112 = z11;
                zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                focusRequester = (FocusRequester) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-497362224);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                } else {
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(-501460796);
                }
                composer3.endReplaceGroup();
                KeyboardActions keyboardActions1113 = keyboardActions3;
                int i31111111112 = i31;
                Modifier modifierFocusRequester1110 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierTestTag1110 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester1110, (Function1) objRememberedValue4), str4 + ":TextField");
                ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                boolean zChanged1110 = composer3.changed(z12);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChanged1110 | z13;
                objRememberedValue5 = composer3.rememberedValue();
                if (!z14) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default1110 = SemanticsModifierKt.semantics$default(modifierTestTag1110, false, (Function1) objRememberedValue5, 1, null);
                float f111119 = 8;
                float f1111110 = 0;
                RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt1113 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f111119), Dp.m9687constructorimpl(f111119), Dp.m9687constructorimpl(f1111110), Dp.m9687constructorimpl(f1111110));
                if (str4 == null) {
                    composer3.startReplaceGroup(-496804876);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composer3.startReplaceGroup(-496804875);
                    ComposerKt.sourceInformation(composer3, "*107@4710L26");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str5 == null) {
                    composer3.startReplaceGroup(-496716309);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda2 = null;
                } else {
                    composer3.startReplaceGroup(-496716308);
                    ComposerKt.sourceInformation(composer3, "*109@4812L169");
                    composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (zM9316equalsimpl0) {
                    composer3.startReplaceGroup(-496460899);
                    ComposerKt.sourceInformation(composer3, "117@5046L207");
                    ComposableLambda composableLambdaRememberComposableLambda1111112 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1111112;
                    z15 = z5;
                    str10 = str4;
                    z16 = z12;
                } else if (!z5) {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z11111111111111113 = z5;
                    final String str1111111111111115 = str4;
                    final boolean z2111117 = z12;
                    str10 = str1111111111111115;
                    z15 = z11111111111111113;
                    z16 = z2111117;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111111115, onTextChange, z11111111111111113, z2111117, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z11111111111111114 = z5;
                    final String str1111111111111116 = str4;
                    final boolean z2111118 = z12;
                    str10 = str1111111111111116;
                    z15 = z11111111111111114;
                    z16 = z2111118;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str1111111111111116, onTextChange, z11111111111111114, z2111118, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str6 == null) {
                    composer3.startReplaceGroup(-495789130);
                    composer3.endReplaceGroup();
                    composableLambda = null;
                    i32 = 1;
                } else {
                    composer3.startReplaceGroup(-495789129);
                    ComposerKt.sourceInformation(composer3, "*137@5746L314");
                    i32 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda1111113 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda1111113;
                }
                if (!zM9316equalsimpl0) {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                }
                int i31111111113 = i6 & 7294;
                int i31111111114 = ((i31111111112 << 12) & 4128768) | ((i31111111112 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                composer2 = composer3;
                String str1111111111111117 = str6;
                String str1111111111111118 = str10;
                String str1111111111111119 = str5;
                Modifier modifier1114 = modifier4;
                TextFieldKt.TextField(text, onTextChange, modifierSemantics$default1110, z11111111111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions1113, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt1113, boxTextFieldColors(composer3, i33), composer2, i31111111113, i31111111114, 0, 1183024);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z11111111111111112;
                keyboardOptions2 = keyboardOptions4;
                keyboardActions2 = keyboardActions1113;
                i28 = i30;
                i27 = i29;
                z9 = z10;
                z8 = z15;
                str7 = str1111111111111117;
                modifier3 = modifier1114;
                str8 = str1111111111111118;
                str9 = str1111111111111119;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i27 = i;
                z7 = z4;
                str7 = str6;
                z8 = z5;
                str8 = str4;
                str9 = str5;
                modifier3 = modifier2;
                z9 = z3;
                i28 = i2;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 805306368;
        i21 = i5 & 1024;
        if (i21 != 0) {
            i22 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            if (composerStartRestartGroup.changed(i2)) {
                i23 = 4;
            } else {
                i23 = 2;
            }
            i22 = i4 | i23;
        } else {
            i22 = i4;
        }
        i24 = i5 & 2048;
        if (i24 != 0) {
            if ((i4 & 48) == 0) {
                if (composerStartRestartGroup.changed(keyboardOptions)) {
                    i25 = 32;
                } else {
                    i25 = 16;
                }
                i22 |= i25;
            }
            if ((i4 & 384) != 0) {
                i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
            }
            i26 = i22;
            if ((i6 & 306783379) == 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z11111111111111115 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z11111111111111115;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                } else {
                    if (i34 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i7 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    if (i11 != 0) {
                        str4 = null;
                    }
                    if (i13 != 0) {
                        str5 = null;
                    }
                    if (i15 != 0) {
                        str6 = null;
                    }
                    if (i17 != 0) {
                        z10 = false;
                    } else {
                        z10 = z3;
                    }
                    if (i19 != 0) {
                        i29 = 1;
                    } else {
                        i29 = i;
                    }
                    if (i21 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i2;
                    }
                    if (i24 != 0) {
                        keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if ((i5 & 4096) != 0) {
                        i26 &= -897;
                        boolean z11111111111111116 = z4;
                        keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        z11 = z11111111111111116;
                    } else {
                        z11 = z4;
                        keyboardActions3 = keyboardActions;
                    }
                    i31 = i26;
                    modifier4 = modifier2;
                    keyboardOptions4 = keyboardOptions3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str6 != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z11111111111111117 = z11;
                zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                focusRequester = (FocusRequester) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z10) {
                    composerStartRestartGroup.startReplaceGroup(-497362224);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                } else {
                    focusRequester2 = focusRequester;
                    composer3 = composerStartRestartGroup;
                    composer3.startReplaceGroup(-501460796);
                }
                composer3.endReplaceGroup();
                KeyboardActions keyboardActions1114 = keyboardActions3;
                int i31111111115 = i31;
                Modifier modifierFocusRequester1111 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
                ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
                objRememberedValue4 = composer3.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierTestTag1111 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester1111, (Function1) objRememberedValue4), str4 + ":TextField");
                ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
                boolean zChanged1111 = composer3.changed(z12);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChanged1111 | z13;
                objRememberedValue5 = composer3.rememberedValue();
                if (!z14) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default1111 = SemanticsModifierKt.semantics$default(modifierTestTag1111, false, (Function1) objRememberedValue5, 1, null);
                float f1111111 = 8;
                float f1111112 = 0;
                RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt1114 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f1111111), Dp.m9687constructorimpl(f1111111), Dp.m9687constructorimpl(f1111112), Dp.m9687constructorimpl(f1111112));
                if (str4 == null) {
                    composer3.startReplaceGroup(-496804876);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                } else {
                    composer3.startReplaceGroup(-496804875);
                    ComposerKt.sourceInformation(composer3, "*107@4710L26");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str5 == null) {
                    composer3.startReplaceGroup(-496716309);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda2 = null;
                } else {
                    composer3.startReplaceGroup(-496716308);
                    ComposerKt.sourceInformation(composer3, "*109@4812L169");
                    composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (zM9316equalsimpl0) {
                    composer3.startReplaceGroup(-496460899);
                    ComposerKt.sourceInformation(composer3, "117@5046L207");
                    ComposableLambda composableLambdaRememberComposableLambda1111114 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1111114;
                    z15 = z5;
                    str10 = str4;
                    z16 = z12;
                } else if (!z5) {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z11111111111111118 = z5;
                    final String str11111111111111110 = str4;
                    final boolean z2111119 = z12;
                    str10 = str11111111111111110;
                    z15 = z11111111111111118;
                    z16 = z2111119;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111111110, onTextChange, z11111111111111118, z2111119, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(-496174583);
                    ComposerKt.sourceInformation(composer3, "124@5332L291");
                    final boolean z11111111111111119 = z5;
                    final String str11111111111111111 = str4;
                    final boolean z21111110 = z12;
                    str10 = str11111111111111111;
                    z15 = z11111111111111119;
                    z16 = z21111110;
                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111111111, onTextChange, z11111111111111119, z21111110, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                }
                if (str6 == null) {
                    composer3.startReplaceGroup(-495789130);
                    composer3.endReplaceGroup();
                    composableLambda = null;
                    i32 = 1;
                } else {
                    composer3.startReplaceGroup(-495789129);
                    ComposerKt.sourceInformation(composer3, "*137@5746L314");
                    i32 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda1111115 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    composer3.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda1111115;
                }
                if (!zM9316equalsimpl0) {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    i33 = 0;
                    none = VisualTransformation.INSTANCE.getNone();
                }
                int i31111111116 = i6 & 7294;
                int i31111111117 = ((i31111111115 << 12) & 4128768) | ((i31111111115 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
                composer2 = composer3;
                String str11111111111111112 = str6;
                String str11111111111111113 = str10;
                String str11111111111111114 = str5;
                Modifier modifier1115 = modifier4;
                TextFieldKt.TextField(text, onTextChange, modifierSemantics$default1111, z11111111111111117, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions1114, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt1114, boxTextFieldColors(composer3, i33), composer2, i31111111116, i31111111117, 0, 1183024);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z11111111111111117;
                keyboardOptions2 = keyboardOptions4;
                keyboardActions2 = keyboardActions1114;
                i28 = i30;
                i27 = i29;
                z9 = z10;
                z8 = z15;
                str7 = str11111111111111112;
                modifier3 = modifier1115;
                str8 = str11111111111111113;
                str9 = str11111111111111114;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i27 = i;
                z7 = z4;
                str7 = str6;
                z8 = z5;
                str8 = str4;
                str9 = str5;
                modifier3 = modifier2;
                z9 = z3;
                i28 = i2;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i22 |= 48;
        if ((i4 & 384) != 0) {
            i22 |= ((i5 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 128 : 256;
        }
        i26 = i22;
        if ((i6 & 306783379) == 306783378) {
            z6 = true;
        } else {
            z6 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
                if (i34 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i7 != 0) {
                    z4 = true;
                }
                if (i9 != 0) {
                    z5 = false;
                }
                if (i11 != 0) {
                    str4 = null;
                }
                if (i13 != 0) {
                    str5 = null;
                }
                if (i15 != 0) {
                    str6 = null;
                }
                if (i17 != 0) {
                    z10 = false;
                } else {
                    z10 = z3;
                }
                if (i19 != 0) {
                    i29 = 1;
                } else {
                    i29 = i;
                }
                if (i21 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i2;
                }
                if (i24 != 0) {
                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if ((i5 & 4096) != 0) {
                    i26 &= -897;
                    boolean z111111111111111110 = z4;
                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    z11 = z111111111111111110;
                } else {
                    z11 = z4;
                    keyboardActions3 = keyboardActions;
                }
                i31 = i26;
                modifier4 = modifier2;
                keyboardOptions4 = keyboardOptions3;
            } else {
                if (i34 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i7 != 0) {
                    z4 = true;
                }
                if (i9 != 0) {
                    z5 = false;
                }
                if (i11 != 0) {
                    str4 = null;
                }
                if (i13 != 0) {
                    str5 = null;
                }
                if (i15 != 0) {
                    str6 = null;
                }
                if (i17 != 0) {
                    z10 = false;
                } else {
                    z10 = z3;
                }
                if (i19 != 0) {
                    i29 = 1;
                } else {
                    i29 = i;
                }
                if (i21 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i2;
                }
                if (i24 != 0) {
                    keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if ((i5 & 4096) != 0) {
                    i26 &= -897;
                    boolean z111111111111111111 = z4;
                    keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    z11 = z111111111111111111;
                } else {
                    z11 = z4;
                    keyboardActions3 = keyboardActions;
                }
                i31 = i26;
                modifier4 = modifier2;
                keyboardOptions4 = keyboardOptions3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-414793698, i6, i31, "com.box.android.base.compose.textfield.BoxTextField (BoxTextField.kt:80)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815230848, "CC(remember):BoxTextField.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (str6 != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean z111111111111111112 = z11;
            zM9316equalsimpl0 = KeyboardType.m9316equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m9335getPasswordPjHm6EE());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815236416, "CC(remember):BoxTextField.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815238363, "CC(remember):BoxTextField.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            focusRequester = (FocusRequester) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-497362224);
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4139L36");
                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                focusRequester2 = focusRequester;
                composer3 = composerStartRestartGroup;
            } else {
                focusRequester2 = focusRequester;
                composer3 = composerStartRestartGroup;
                composer3.startReplaceGroup(-501460796);
            }
            composer3.endReplaceGroup();
            KeyboardActions keyboardActions1115 = keyboardActions3;
            int i31111111118 = i31;
            Modifier modifierFocusRequester1112 = FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), focusRequester2);
            ComposerKt.sourceInformationMarkerStart(composer3, 815248289, "CC(remember):BoxTextField.kt#9igjgp");
            objRememberedValue4 = composer3.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxTextFieldKt.BoxTextField$lambda$7$0(mutableState, (FocusState) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierTestTag1112 = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFocusRequester1112, (Function1) objRememberedValue4), str4 + ":TextField");
            ComposerKt.sourceInformationMarkerStart(composer3, 815252507, "CC(remember):BoxTextField.kt#9igjgp");
            boolean zChanged1112 = composer3.changed(z12);
            if ((29360128 & i6) == 8388608) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = zChanged1112 | z13;
            objRememberedValue5 = composer3.rememberedValue();
            if (!z14) {
                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxTextFieldKt.BoxTextField$lambda$8$0(z12, str6, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierSemantics$default1112 = SemanticsModifierKt.semantics$default(modifierTestTag1112, false, (Function1) objRememberedValue5, 1, null);
            float f1111113 = 8;
            float f1111114 = 0;
            RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt1115 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(Dp.m9687constructorimpl(f1111113), Dp.m9687constructorimpl(f1111113), Dp.m9687constructorimpl(f1111114), Dp.m9687constructorimpl(f1111114));
            if (str4 == null) {
                composer3.startReplaceGroup(-496804876);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composer3.startReplaceGroup(-496804875);
                ComposerKt.sourceInformation(composer3, "*107@4710L26");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(359248006, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$9$0(str4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
            }
            if (str5 == null) {
                composer3.startReplaceGroup(-496716309);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda2 = null;
            } else {
                composer3.startReplaceGroup(-496716308);
                ComposerKt.sourceInformation(composer3, "*109@4812L169");
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1809601082, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$10$0(str5, str4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
            }
            if (zM9316equalsimpl0) {
                composer3.startReplaceGroup(-496460899);
                ComposerKt.sourceInformation(composer3, "117@5046L207");
                ComposableLambda composableLambdaRememberComposableLambda1111116 = ComposableLambdaKt.rememberComposableLambda(-277530169, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$11(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda3 = composableLambdaRememberComposableLambda1111116;
                z15 = z5;
                str10 = str4;
                z16 = z12;
            } else if (!z5) {
                composer3.startReplaceGroup(-496174583);
                ComposerKt.sourceInformation(composer3, "124@5332L291");
                final boolean z111111111111111113 = z5;
                final String str11111111111111115 = str4;
                final boolean z21111111 = z12;
                str10 = str11111111111111115;
                z15 = z111111111111111113;
                z16 = z21111111;
                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111111115, onTextChange, z111111111111111113, z21111111, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-496174583);
                ComposerKt.sourceInformation(composer3, "124@5332L291");
                final boolean z111111111111111114 = z5;
                final String str11111111111111116 = str4;
                final boolean z21111112 = z12;
                str10 = str11111111111111116;
                z15 = z111111111111111114;
                z16 = z21111112;
                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1027261698, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$12(str11111111111111116, onTextChange, z111111111111111114, z21111112, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
            }
            if (str6 == null) {
                composer3.startReplaceGroup(-495789130);
                composer3.endReplaceGroup();
                composableLambda = null;
                i32 = 1;
            } else {
                composer3.startReplaceGroup(-495789129);
                ComposerKt.sourceInformation(composer3, "*137@5746L314");
                i32 = 1;
                ComposableLambda composableLambdaRememberComposableLambda1111117 = ComposableLambdaKt.rememberComposableLambda(1154575427, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxTextFieldKt.BoxTextField$lambda$13$0(str6, str10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda1111117;
            }
            if (!zM9316equalsimpl0) {
                i33 = 0;
                none = VisualTransformation.INSTANCE.getNone();
            } else {
                i33 = 0;
                none = VisualTransformation.INSTANCE.getNone();
            }
            int i31111111119 = i6 & 7294;
            int i311111111110 = ((i31111111118 << 12) & 4128768) | ((i31111111118 << 24) & 234881024) | (i6 & C.ENCODING_PCM_DOUBLE);
            composer2 = composer3;
            String str11111111111111117 = str6;
            String str11111111111111118 = str10;
            String str11111111111111119 = str5;
            Modifier modifier1116 = modifier4;
            TextFieldKt.TextField(text, onTextChange, modifierSemantics$default1112, z111111111111111112, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambda, z16, none, keyboardOptions4, keyboardActions1115, false, i30, i29, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1574RoundedCornerShapea9UjIt1115, boxTextFieldColors(composer3, i33), composer2, i31111111119, i311111111110, 0, 1183024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z7 = z111111111111111112;
            keyboardOptions2 = keyboardOptions4;
            keyboardActions2 = keyboardActions1115;
            i28 = i30;
            i27 = i29;
            z9 = z10;
            z8 = z15;
            str7 = str11111111111111117;
            modifier3 = modifier1116;
            str8 = str11111111111111118;
            str9 = str11111111111111119;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            i27 = i;
            z7 = z4;
            str7 = str6;
            z8 = z5;
            str8 = str4;
            str9 = str5;
            modifier3 = modifier2;
            z9 = z3;
            i28 = i2;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxTextFieldKt.BoxTextField$lambda$14(text, onTextChange, modifier3, z7, z8, str8, str9, str7, z9, i27, i28, keyboardOptions2, keyboardActions2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean BoxTextField$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BoxTextField$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean BoxTextField$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BoxTextField$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$7$0(MutableState mutableState, FocusState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        BoxTextField$lambda$2(mutableState, state.getHasFocus());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$8$0(boolean z, String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        if (z) {
            SemanticsPropertiesKt.error(semantics, str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$9$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4712L22:BoxTextField.kt#fjpkir");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(359248006, i, -1, "com.box.android.base.compose.textfield.BoxTextField.<anonymous>.<anonymous> (BoxTextField.kt:107)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$10$0(String str, String str2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C110@4830L137:BoxTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1809601082, i, -1, "com.box.android.base.compose.textfield.BoxTextField.<anonymous>.<anonymous> (BoxTextField.kt:110)");
            }
            TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, str2 + ":Placeholder"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$11(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C120@5183L38,118@5064L175:BoxTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-277530169, i, -1, "com.box.android.base.compose.textfield.BoxTextField.<anonymous> (BoxTextField.kt:118)");
            }
            boolean zBoxTextField$lambda$4 = BoxTextField$lambda$4(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -418515635, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxTextFieldKt.BoxTextField$lambda$11$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PasswordTrailingIcon(zBoxTextField$lambda$4, (Function0) objRememberedValue, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$11$0$0(MutableState mutableState) {
        BoxTextField$lambda$5(mutableState, !BoxTextField$lambda$4(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$12(String str, Function1 function1, boolean z, boolean z2, MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C125@5350L259:BoxTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1027261698, i, -1, "com.box.android.base.compose.textfield.BoxTextField.<anonymous> (BoxTextField.kt:125)");
            }
            TrailingIcon(str, function1, z, z2, BoxTextField$lambda$1(mutableState), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$13$0(String str, String str2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C142@5949L79,138@5764L282:BoxTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154575427, i, -1, "com.box.android.base.compose.textfield.BoxTextField.<anonymous>.<anonymous> (BoxTextField.kt:138)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, str2 + ":ErrorMessage");
            ComposerKt.sourceInformationMarkerStart(composer, 1445429554, "CC(remember):BoxTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxTextFieldKt.BoxTextField$lambda$13$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4494TextNvy7gAk(str, SemanticsModifierKt.semantics$default(modifierTestTag, false, (Function1) objRememberedValue, 1, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTextField$lambda$13$0$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.hideFromAccessibility(semantics);
        return Unit.INSTANCE;
    }

    private static final void PasswordTrailingIcon(final boolean z, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function1;
        Pair pair;
        Composer composerStartRestartGroup = composer.startRestartGroup(1068063235);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PasswordTrailingIcon)N(passwordVisible,onPasswordIconClick)173@6933L161,170@6814L280:BoxTextField.kt#fjpkir");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function1 = function0;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1068063235, i2, -1, "com.box.android.base.compose.textfield.PasswordTrailingIcon (BoxTextField.kt:163)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1554243720);
                ComposerKt.sourceInformation(composerStartRestartGroup, "165@6662L44");
                pair = TuplesKt.to(VisibilityKt.getVisibility(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.hide_password_label, composerStartRestartGroup, 0));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1554336069);
                ComposerKt.sourceInformation(composerStartRestartGroup, "167@6758L44");
                pair = TuplesKt.to(VisibilityOffKt.getVisibilityOff(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.show_password_label, composerStartRestartGroup, 0));
                composerStartRestartGroup.endReplaceGroup();
            }
            final ImageVector imageVector = (ImageVector) pair.component1();
            final String str = (String) pair.component2();
            function1 = function0;
            IconButtonKt.IconButton(function1, TestTagKt.testTag(Modifier.INSTANCE, "PasswordVisibilityIcon"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-552206431, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxTextFieldKt.PasswordTrailingIcon$lambda$0(imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 1572912, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxTextFieldKt.PasswordTrailingIcon$lambda$1(z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordTrailingIcon$lambda$0(ImageVector imageVector, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C177@7055L6,174@6943L145:BoxTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-552206431, i, -1, "com.box.android.base.compose.textfield.PasswordTrailingIcon.<anonymous> (BoxTextField.kt:174)");
            }
            IconKt.m3576Iconww6aTOc(imageVector, str, (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11513getContentSecondary0d7_KjU(), composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void TrailingIcon(final String str, final Function1<? super String, Unit> function1, final boolean z, final boolean z2, final boolean z3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-170997002);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrailingIcon)N(label,onTextChange,isTextChangePending,isError,isFocused):BoxTextField.kt#fjpkir");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-170997002, i2, -1, "com.box.android.base.compose.textfield.TrailingIcon (BoxTextField.kt:189)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1119355127);
                ComposerKt.sourceInformation(composerStartRestartGroup, "191@7317L179");
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(SizeKt.m1266size3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(TestTagKt.testTag(Modifier.INSTANCE, str + ":ProgressBar"), 0.0f, 0.0f, Dp.m9687constructorimpl(16), 0.0f, 11, null), Dp.m9687constructorimpl(24)), null, 0L, 0L, 0.0f, 0, null, composerStartRestartGroup, 0, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else if (z2) {
                composerStartRestartGroup.startReplaceGroup(-1119348646);
                ComposerKt.sourceInformation(composerStartRestartGroup, "200@7603L47,202@7746L6,198@7517L260");
                IconKt.m3576Iconww6aTOc(ErrorKt.getError(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0), TestTagKt.testTag(Modifier.INSTANCE, str + ":ErrorIndicator"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11563getTextFieldError0d7_KjU(), composerStartRestartGroup, 0, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (z3) {
                    composerStartRestartGroup.startReplaceGroup(-1119339484);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@7834L20,205@7800L366");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1119338742, "CC(remember):BoxTextField.kt#9igjgp");
                    boolean z4 = (i2 & 112) == 32;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxTextFieldKt.TrailingIcon$lambda$0$0(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, TestTagKt.testTag(Modifier.INSTANCE, str + ":ClearButton"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxTextFieldKt.INSTANCE.getLambda$841442392$base_generalProdRelease(), composerStartRestartGroup, 1572864, 60);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-347535572);
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxTextFieldKt.TrailingIcon$lambda$1(str, function1, z, z2, z3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailingIcon$lambda$0$0(Function1 function1) {
        function1.invoke("");
        return Unit.INSTANCE;
    }

    private static final TextFieldColors boxTextFieldColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 183136764, "C(boxTextFieldColors)220@8281L6,221@8337L6,222@8392L6,223@8473L6,225@8533L6,226@8599L6,227@8664L6,228@8755L6,230@8810L6,231@8866L6,233@8927L6,234@8993L6,235@9058L6,236@9149L6,238@9206L6,239@9264L6,240@9321L6,241@9404L6,243@9467L6,244@9537L6,245@9606L6,246@9701L6,248@9802L6,249@9878L6,250@9953L6,251@10054L6,219@8241L1836:BoxTextField.kt#fjpkir");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183136764, i, -1, "com.box.android.base.compose.textfield.boxTextFieldColors (BoxTextField.kt:219)");
        }
        TextFieldColors textFieldColorsM4466colors0hiis_0 = TextFieldDefaults.INSTANCE.m4466colors0hiis_0(BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11572getTextFieldText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11561getTextFieldContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11561getTextFieldContainer0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11561getTextFieldContainer0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11561getTextFieldContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11562getTextFieldCursor0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), null, BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11564getTextFieldIndicator0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11565getTextFieldLabel0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11566getTextFieldPlaceholder0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11571getTextFieldSupportingText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11571getTextFieldSupportingText0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, 6).m11571getTextFieldSupportingText0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, 6).m11563getTextFieldError0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 8356864, 4080);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM4466colors0hiis_0;
    }

    private static final void BoxTextFieldPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(689191133);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxTextFieldPreview)259@10216L2427:BoxTextField.kt#fjpkir");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(689191133, i, -1, "com.box.android.base.compose.textfield.BoxTextFieldPreview (BoxTextField.kt:258)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxTextFieldKt.INSTANCE.getLambda$130184680$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxTextFieldKt.BoxTextFieldPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

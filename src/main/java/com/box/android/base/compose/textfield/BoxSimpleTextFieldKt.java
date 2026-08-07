package com.box.android.base.compose.textfield;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActionsKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: BoxSimpleTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u007f\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"BoxSimpleTextField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "hintModifier", "colorConfigs", "Lcom/box/android/base/compose/textfield/BoxSimpleTextFieldColorConfigs;", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "clearButtonContentDescription", "onValueChange", "Lkotlin/Function1;", "onClearClicked", "Lkotlin/Function0;", "keyboardActions", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lcom/box/android/base/compose/textfield/BoxSimpleTextFieldColorConfigs;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "BoxSimpleTextFieldPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxSimpleTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextField$lambda$3(Modifier modifier, String str, String str2, Modifier modifier2, BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs, String str3, String str4, Function1 function1, Function0 function0, Function0 function2, int i, int i2, Composer composer, int i3) {
        BoxSimpleTextField(modifier, str, str2, modifier2, boxSimpleTextFieldColorConfigs, str3, str4, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$1(int i, Composer composer, int i2) {
        BoxSimpleTextFieldPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0162 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x0164  */
    /* JADX WARN: Code duplicated, block: B:110:0x016b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0172  */
    /* JADX WARN: Code duplicated, block: B:113:0x0175  */
    /* JADX WARN: Code duplicated, block: B:116:0x017b  */
    /* JADX WARN: Code duplicated, block: B:117:0x0185  */
    /* JADX WARN: Code duplicated, block: B:119:0x018a  */
    /* JADX WARN: Code duplicated, block: B:121:0x019c  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:127:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:133:0x0202  */
    /* JADX WARN: Code duplicated, block: B:134:0x0221  */
    /* JADX WARN: Code duplicated, block: B:137:0x0293  */
    /* JADX WARN: Code duplicated, block: B:140:0x029f  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:144:0x0331  */
    /* JADX WARN: Code duplicated, block: B:145:0x0333  */
    /* JADX WARN: Code duplicated, block: B:148:0x0375  */
    /* JADX WARN: Code duplicated, block: B:150:0x0382  */
    /* JADX WARN: Code duplicated, block: B:153:0x0396  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0094  */
    /* JADX WARN: Code duplicated, block: B:42:0x009a  */
    /* JADX WARN: Code duplicated, block: B:43:0x009d  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00df  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:82:0x0105  */
    /* JADX WARN: Code duplicated, block: B:83:0x0108  */
    /* JADX WARN: Code duplicated, block: B:85:0x010c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0116  */
    /* JADX WARN: Code duplicated, block: B:88:0x0119  */
    /* JADX WARN: Code duplicated, block: B:93:0x012e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0130  */
    /* JADX WARN: Code duplicated, block: B:97:0x0139  */
    /* JADX WARN: Code duplicated, block: B:99:0x014a  */
    public static final void BoxSimpleTextField(Modifier modifier, final String text, final String hint, Modifier modifier2, final BoxSimpleTextFieldColorConfigs colorConfigs, String str, String str2, final Function1<? super String, Unit> onValueChange, Function0<Unit> onClearClicked, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier3;
        int i3;
        final Modifier modifier4;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        Composer composer2;
        final Function0<Unit> function1;
        final String str3;
        final String str4;
        final Modifier modifier5;
        final Modifier modifier6;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str5;
        String strStringResource;
        String str6;
        Object objRememberedValue;
        Modifier modifier7;
        Function0<Unit> function3;
        Object objRememberedValue2;
        TextSelectionColors textSelectionColor;
        Function0<ComposeUiNode> constructor;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(colorConfigs, "colorConfigs");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(onClearClicked, "onClearClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2060563854);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSimpleTextField)N(modifier,text,hint,hintModifier,colorConfigs,testTag,clearButtonContentDescription,onValueChange,onClearClicked,keyboardActions)70@3255L7,71@3288L29,74@3420L36,76@3462L2056:BoxSimpleTextField.kt#fjpkir");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
            modifier3 = modifier;
        } else if ((i & 6) == 0) {
            modifier3 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier3) ? 4 : 2) | i;
        } else {
            modifier3 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(hint) ? 256 : 128;
        }
        int i13 = i2 & 8;
        if (i13 == 0) {
            if ((i & 3072) == 0) {
                modifier4 = modifier2;
                i3 |= composerStartRestartGroup.changed(modifier4) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(colorConfigs)) {
                    i11 = 16384;
                } else {
                    i11 = 8192;
                }
                i3 |= i11;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((i & 1572864) != 0) {
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(str2)) {
                        i10 = 524288;
                    } else {
                        i10 = 1048576;
                    }
                    i3 |= i10;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(onValueChange)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(onClearClicked)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i3 |= i8;
                }
                i6 = i2 & 512;
                if (i6 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function0)) {
                            i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i7 = 268435456;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            }
                            if (i13 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                str5 = "BoxSimpleTextField";
                            } else {
                                str5 = str;
                            }
                            if ((i2 & 64) != 0) {
                                strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                                i3 &= -3670017;
                            } else {
                                strStringResource = str2;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                str6 = str5;
                                modifier7 = modifier3;
                                function3 = (Function0) objRememberedValue;
                            } else {
                                str6 = str5;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                            }
                            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final FocusManager focusManager = (FocusManager) objConsume;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            final FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textSelectionColor = colorConfigs.getTextSelectionColor();
                            if (textSelectionColor == null) {
                                composerStartRestartGroup.startReplaceGroup(-221920231);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                                ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localTextSelectionColors);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textSelectionColor = (TextSelectionColors) objConsume2;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-221922091);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            TextSelectionColors textSelectionColors = textSelectionColor;
                            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 0L, composerStartRestartGroup, 6, 2);
                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                            Modifier modifier8 = modifier7;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            final Function0<Unit> function4 = function3;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                            final String str7 = str6;
                            final String str8 = strStringResource;
                            Modifier modifier9 = modifier4;
                            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance, focusRequester, str7, colorConfigs, function4, focusManager, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (text.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            function1 = onClearClicked;
                            composer2 = composerStartRestartGroup;
                            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str8, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str4 = str8;
                            str3 = str7;
                            modifier5 = modifier8;
                            function2 = function4;
                            modifier6 = modifier9;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            str6 = str;
                            strStringResource = str2;
                        }
                        modifier7 = modifier3;
                        function3 = function0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                        }
                        ProvidableCompositionLocal<FocusManager> localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localFocusManager2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final FocusManager focusManager2 = (FocusManager) objConsume3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final FocusRequester focusRequester2 = (FocusRequester) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textSelectionColor = colorConfigs.getTextSelectionColor();
                        if (textSelectionColor == null) {
                            composerStartRestartGroup.startReplaceGroup(-221920231);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors2 = TextSelectionColorsKt.getLocalTextSelectionColors();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localTextSelectionColors2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textSelectionColor = (TextSelectionColors) objConsume4;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-221922091);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        TextSelectionColors textSelectionColors2 = textSelectionColor;
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester2, 0L, composerStartRestartGroup, 6, 2);
                        Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                        Modifier modifier10 = modifier7;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        final Function0 function5 = function3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        final RowScope rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                        final String str9 = str6;
                        final String str10 = strStringResource;
                        Modifier modifier11 = modifier4;
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors2), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance2, focusRequester2, str9, colorConfigs, function5, focusManager2, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (text.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        function1 = onClearClicked;
                        composer2 = composerStartRestartGroup;
                        AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance2, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str10, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str10;
                        str3 = str9;
                        modifier5 = modifier10;
                        function2 = function5;
                        modifier6 = modifier11;
                    } else {
                        composer2 = composerStartRestartGroup;
                        function1 = onClearClicked;
                        composer2.skipToGroupEnd();
                        str3 = str;
                        str4 = str2;
                        modifier5 = modifier3;
                        modifier6 = modifier4;
                        function2 = function0;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Function0<Unit> function6 = function1;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        }
                        if (i13 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            str5 = "BoxSimpleTextField";
                        } else {
                            str5 = str;
                        }
                        if ((i2 & 64) != 0) {
                            strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                            i3 &= -3670017;
                        } else {
                            strStringResource = str2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = (Function0) objRememberedValue;
                        } else {
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = function0;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        }
                        if (i13 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            str5 = "BoxSimpleTextField";
                        } else {
                            str5 = str;
                        }
                        if ((i2 & 64) != 0) {
                            strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                            i3 &= -3670017;
                        } else {
                            strStringResource = str2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = (Function0) objRememberedValue;
                        } else {
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = function0;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                    }
                    ProvidableCompositionLocal<FocusManager> localFocusManager3 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localFocusManager3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final FocusManager focusManager3 = (FocusManager) objConsume5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final FocusRequester focusRequester3 = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textSelectionColor = colorConfigs.getTextSelectionColor();
                    if (textSelectionColor == null) {
                        composerStartRestartGroup.startReplaceGroup(-221920231);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors3 = TextSelectionColorsKt.getLocalTextSelectionColors();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localTextSelectionColors3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textSelectionColor = (TextSelectionColors) objConsume6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-221922091);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    TextSelectionColors textSelectionColors3 = textSelectionColor;
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester3, 0L, composerStartRestartGroup, 6, 2);
                    Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically3, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                    Modifier modifier12 = modifier7;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final Function0 function7 = function3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                    final String str11 = str6;
                    final String str12 = strStringResource;
                    Modifier modifier13 = modifier4;
                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors3), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance3, focusRequester3, str11, colorConfigs, function7, focusManager3, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (text.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    function1 = onClearClicked;
                    composer2 = composerStartRestartGroup;
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance3, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str12, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str12;
                    str3 = str11;
                    modifier5 = modifier12;
                    function2 = function7;
                    modifier6 = modifier13;
                } else {
                    composer2 = composerStartRestartGroup;
                    function1 = onClearClicked;
                    composer2.skipToGroupEnd();
                    str3 = str;
                    str4 = str2;
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    function2 = function0;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function8 = function1;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function8, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i & 1572864) != 0) {
                if ((i2 & 64) == 0) {
                    i10 = 524288;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onValueChange)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(onClearClicked)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            i6 = i2 & 512;
            if (i6 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i7 = 268435456;
                    }
                    i3 |= i7;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        }
                        if (i13 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            str5 = "BoxSimpleTextField";
                        } else {
                            str5 = str;
                        }
                        if ((i2 & 64) != 0) {
                            strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                            i3 &= -3670017;
                        } else {
                            strStringResource = str2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = (Function0) objRememberedValue;
                        } else {
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = function0;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        }
                        if (i13 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            str5 = "BoxSimpleTextField";
                        } else {
                            str5 = str;
                        }
                        if ((i2 & 64) != 0) {
                            strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                            i3 &= -3670017;
                        } else {
                            strStringResource = str2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = (Function0) objRememberedValue;
                        } else {
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = function0;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                    }
                    ProvidableCompositionLocal<FocusManager> localFocusManager4 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localFocusManager4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final FocusManager focusManager4 = (FocusManager) objConsume7;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final FocusRequester focusRequester4 = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textSelectionColor = colorConfigs.getTextSelectionColor();
                    if (textSelectionColor == null) {
                        composerStartRestartGroup.startReplaceGroup(-221920231);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors4 = TextSelectionColorsKt.getLocalTextSelectionColors();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume8 = composerStartRestartGroup.consume(localTextSelectionColors4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textSelectionColor = (TextSelectionColors) objConsume8;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-221922091);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    TextSelectionColors textSelectionColors4 = textSelectionColor;
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester4, 0L, composerStartRestartGroup, 6, 2);
                    Arrangement.HorizontalOrVertical spaceBetween4 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween4, centerVertically4, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                    Modifier modifier14 = modifier7;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final Function0 function9 = function3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance4 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                    final String str13 = str6;
                    final String str14 = strStringResource;
                    Modifier modifier15 = modifier4;
                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors4), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance4, focusRequester4, str13, colorConfigs, function9, focusManager4, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (text.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    function1 = onClearClicked;
                    composer2 = composerStartRestartGroup;
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance4, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str14, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str14;
                    str3 = str13;
                    modifier5 = modifier14;
                    function2 = function9;
                    modifier6 = modifier15;
                } else {
                    composer2 = composerStartRestartGroup;
                    function1 = onClearClicked;
                    composer2.skipToGroupEnd();
                    str3 = str;
                    str4 = str2;
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    function2 = function0;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function10 = function1;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function10, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        str5 = "BoxSimpleTextField";
                    } else {
                        str5 = str;
                    }
                    if ((i2 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                        i3 &= -3670017;
                    } else {
                        strStringResource = str2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = function0;
                    }
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        str5 = "BoxSimpleTextField";
                    } else {
                        str5 = str;
                    }
                    if ((i2 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                        i3 &= -3670017;
                    } else {
                        strStringResource = str2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = function0;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager5 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localFocusManager5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final FocusManager focusManager5 = (FocusManager) objConsume9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final FocusRequester focusRequester5 = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                textSelectionColor = colorConfigs.getTextSelectionColor();
                if (textSelectionColor == null) {
                    composerStartRestartGroup.startReplaceGroup(-221920231);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors5 = TextSelectionColorsKt.getLocalTextSelectionColors();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localTextSelectionColors5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textSelectionColor = (TextSelectionColors) objConsume10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-221922091);
                }
                composerStartRestartGroup.endReplaceGroup();
                TextSelectionColors textSelectionColors5 = textSelectionColor;
                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester5, 0L, composerStartRestartGroup, 6, 2);
                Arrangement.HorizontalOrVertical spaceBetween5 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(spaceBetween5, centerVertically5, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                Modifier modifier16 = modifier7;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final Function0 function11 = function3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance5 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                final String str15 = str6;
                final String str16 = strStringResource;
                Modifier modifier17 = modifier4;
                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors5), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance5, focusRequester5, str15, colorConfigs, function11, focusManager5, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (text.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                function1 = onClearClicked;
                composer2 = composerStartRestartGroup;
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance5, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str16, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str16;
                str3 = str15;
                modifier5 = modifier16;
                function2 = function11;
                modifier6 = modifier17;
            } else {
                composer2 = composerStartRestartGroup;
                function1 = onClearClicked;
                composer2.skipToGroupEnd();
                str3 = str;
                str4 = str2;
                modifier5 = modifier3;
                modifier6 = modifier4;
                function2 = function0;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0 function12 = function1;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function12, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier4 = modifier2;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changed(colorConfigs)) {
                i11 = 16384;
            } else {
                i11 = 8192;
            }
            i3 |= i11;
        }
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((i & 1572864) != 0) {
                if ((i2 & 64) == 0) {
                    i10 = 524288;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onValueChange)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(onClearClicked)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            i6 = i2 & 512;
            if (i6 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i7 = 268435456;
                    }
                    i3 |= i7;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        }
                        if (i13 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            str5 = "BoxSimpleTextField";
                        } else {
                            str5 = str;
                        }
                        if ((i2 & 64) != 0) {
                            strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                            i3 &= -3670017;
                        } else {
                            strStringResource = str2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = (Function0) objRememberedValue;
                        } else {
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = function0;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        }
                        if (i13 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            str5 = "BoxSimpleTextField";
                        } else {
                            str5 = str;
                        }
                        if ((i2 & 64) != 0) {
                            strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                            i3 &= -3670017;
                        } else {
                            strStringResource = str2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = (Function0) objRememberedValue;
                        } else {
                            str6 = str5;
                            modifier7 = modifier3;
                            function3 = function0;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                    }
                    ProvidableCompositionLocal<FocusManager> localFocusManager6 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localFocusManager6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final FocusManager focusManager6 = (FocusManager) objConsume11;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final FocusRequester focusRequester6 = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textSelectionColor = colorConfigs.getTextSelectionColor();
                    if (textSelectionColor == null) {
                        composerStartRestartGroup.startReplaceGroup(-221920231);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors6 = TextSelectionColorsKt.getLocalTextSelectionColors();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localTextSelectionColors6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textSelectionColor = (TextSelectionColors) objConsume12;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-221922091);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    TextSelectionColors textSelectionColors6 = textSelectionColor;
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester6, 0L, composerStartRestartGroup, 6, 2);
                    Arrangement.HorizontalOrVertical spaceBetween6 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(spaceBetween6, centerVertically6, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                    Modifier modifier18 = modifier7;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    final Function0 function13 = function3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    final RowScope rowScopeInstance6 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                    final String str17 = str6;
                    final String str18 = strStringResource;
                    Modifier modifier19 = modifier4;
                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors6), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance6, focusRequester6, str17, colorConfigs, function13, focusManager6, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (text.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    function1 = onClearClicked;
                    composer2 = composerStartRestartGroup;
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance6, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str18, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str18;
                    str3 = str17;
                    modifier5 = modifier18;
                    function2 = function13;
                    modifier6 = modifier19;
                } else {
                    composer2 = composerStartRestartGroup;
                    function1 = onClearClicked;
                    composer2.skipToGroupEnd();
                    str3 = str;
                    str4 = str2;
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    function2 = function0;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function14 = function1;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function14, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        str5 = "BoxSimpleTextField";
                    } else {
                        str5 = str;
                    }
                    if ((i2 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                        i3 &= -3670017;
                    } else {
                        strStringResource = str2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = function0;
                    }
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        str5 = "BoxSimpleTextField";
                    } else {
                        str5 = str;
                    }
                    if ((i2 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                        i3 &= -3670017;
                    } else {
                        strStringResource = str2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = function0;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager7 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localFocusManager7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final FocusManager focusManager7 = (FocusManager) objConsume13;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final FocusRequester focusRequester7 = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                textSelectionColor = colorConfigs.getTextSelectionColor();
                if (textSelectionColor == null) {
                    composerStartRestartGroup.startReplaceGroup(-221920231);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors7 = TextSelectionColorsKt.getLocalTextSelectionColors();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localTextSelectionColors7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textSelectionColor = (TextSelectionColors) objConsume14;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-221922091);
                }
                composerStartRestartGroup.endReplaceGroup();
                TextSelectionColors textSelectionColors7 = textSelectionColor;
                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester7, 0L, composerStartRestartGroup, 6, 2);
                Arrangement.HorizontalOrVertical spaceBetween7 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(spaceBetween7, centerVertically7, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                Modifier modifier110 = modifier7;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final Function0 function15 = function3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                final String str19 = str6;
                final String str110 = strStringResource;
                Modifier modifier111 = modifier4;
                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors7), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance7, focusRequester7, str19, colorConfigs, function15, focusManager7, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (text.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                function1 = onClearClicked;
                composer2 = composerStartRestartGroup;
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance7, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str110, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str110;
                str3 = str19;
                modifier5 = modifier110;
                function2 = function15;
                modifier6 = modifier111;
            } else {
                composer2 = composerStartRestartGroup;
                function1 = onClearClicked;
                composer2.skipToGroupEnd();
                str3 = str;
                str4 = str2;
                modifier5 = modifier3;
                modifier6 = modifier4;
                function2 = function0;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0 function16 = function1;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function16, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((i & 1572864) != 0) {
            if ((i2 & 64) == 0) {
                i10 = 524288;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(onValueChange)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(onClearClicked)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i3 |= i8;
        }
        i6 = i2 & 512;
        if (i6 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i7 = 268435456;
                }
                i3 |= i7;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        str5 = "BoxSimpleTextField";
                    } else {
                        str5 = str;
                    }
                    if ((i2 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                        i3 &= -3670017;
                    } else {
                        strStringResource = str2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = function0;
                    }
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        str5 = "BoxSimpleTextField";
                    } else {
                        str5 = str;
                    }
                    if ((i2 & 64) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                        i3 &= -3670017;
                    } else {
                        strStringResource = str2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        str6 = str5;
                        modifier7 = modifier3;
                        function3 = function0;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager8 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localFocusManager8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final FocusManager focusManager8 = (FocusManager) objConsume15;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final FocusRequester focusRequester8 = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                textSelectionColor = colorConfigs.getTextSelectionColor();
                if (textSelectionColor == null) {
                    composerStartRestartGroup.startReplaceGroup(-221920231);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors8 = TextSelectionColorsKt.getLocalTextSelectionColors();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume16 = composerStartRestartGroup.consume(localTextSelectionColors8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textSelectionColor = (TextSelectionColors) objConsume16;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-221922091);
                }
                composerStartRestartGroup.endReplaceGroup();
                TextSelectionColors textSelectionColors8 = textSelectionColor;
                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester8, 0L, composerStartRestartGroup, 6, 2);
                Arrangement.HorizontalOrVertical spaceBetween8 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(spaceBetween8, centerVertically8, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
                Modifier modifier112 = modifier7;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final Function0 function17 = function3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                final RowScope rowScopeInstance8 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
                final String str111 = str6;
                final String str112 = strStringResource;
                Modifier modifier113 = modifier4;
                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors8), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance8, focusRequester8, str111, colorConfigs, function17, focusManager8, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (text.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                function1 = onClearClicked;
                composer2 = composerStartRestartGroup;
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance8, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str112, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1600518, 18);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str112;
                str3 = str111;
                modifier5 = modifier112;
                function2 = function17;
                modifier6 = modifier113;
            } else {
                composer2 = composerStartRestartGroup;
                function1 = onClearClicked;
                composer2.skipToGroupEnd();
                str3 = str;
                str4 = str2;
                modifier5 = modifier3;
                modifier6 = modifier4;
                function2 = function0;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0 function18 = function1;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function18, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 805306368;
        if ((i3 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "65@3054L47,68@3206L3");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                }
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    str5 = "BoxSimpleTextField";
                } else {
                    str5 = str;
                }
                if ((i2 & 64) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                    i3 &= -3670017;
                } else {
                    strStringResource = str2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str6 = str5;
                    modifier7 = modifier3;
                    function3 = (Function0) objRememberedValue;
                } else {
                    str6 = str5;
                    modifier7 = modifier3;
                    function3 = function0;
                }
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                }
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    str5 = "BoxSimpleTextField";
                } else {
                    str5 = str;
                }
                if ((i2 & 64) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.clear_text_field_label, composerStartRestartGroup, 0);
                    i3 &= -3670017;
                } else {
                    strStringResource = str2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221926667, "CC(remember):BoxSimpleTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str6 = str5;
                    modifier7 = modifier3;
                    function3 = (Function0) objRememberedValue;
                } else {
                    str6 = str5;
                    modifier7 = modifier3;
                    function3 = function0;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2060563854, i3, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField (BoxSimpleTextField.kt:69)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager9 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume17 = composerStartRestartGroup.consume(localFocusManager9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager9 = (FocusManager) objConsume17;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221924017, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final FocusRequester focusRequester9 = (FocusRequester) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            textSelectionColor = colorConfigs.getTextSelectionColor();
            if (textSelectionColor == null) {
                composerStartRestartGroup.startReplaceGroup(-221920231);
                ComposerKt.sourceInformation(composerStartRestartGroup, "72@3407L7");
                ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors9 = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume18 = composerStartRestartGroup.consume(localTextSelectionColors9);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                textSelectionColor = (TextSelectionColors) objConsume18;
            } else {
                composerStartRestartGroup.startReplaceGroup(-221922091);
            }
            composerStartRestartGroup.endReplaceGroup();
            TextSelectionColors textSelectionColors9 = textSelectionColor;
            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester9, 0L, composerStartRestartGroup, 6, 2);
            Arrangement.HorizontalOrVertical spaceBetween9 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically9 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(spaceBetween9, centerVertically9, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
            Modifier modifier114 = modifier7;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            final Function0 function19 = function3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyRowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            final RowScope rowScopeInstance9 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788695286, "C81@3704L1269,81@3625L1348,117@5113L399,113@4983L529:BoxSimpleTextField.kt#fjpkir");
            final String str113 = str6;
            final String str114 = strStringResource;
            Modifier modifier115 = modifier4;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors9), ComposableLambdaKt.rememberComposableLambda(-926526770, true, new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0(rowScopeInstance9, focusRequester9, str113, colorConfigs, function19, focusManager9, text, onValueChange, hint, modifier4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (text.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            function1 = onClearClicked;
            composer2 = composerStartRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance9, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1967764042, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$1(function1, str114, colorConfigs, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 1600518, 18);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str114;
            str3 = str113;
            modifier5 = modifier114;
            function2 = function19;
            modifier6 = modifier115;
        } else {
            composer2 = composerStartRestartGroup;
            function1 = onClearClicked;
            composer2.skipToGroupEnd();
            str3 = str;
            str4 = str2;
            modifier5 = modifier3;
            modifier6 = modifier4;
            function2 = function0;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0 function110 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$3(modifier5, text, hint, modifier6, colorConfigs, str3, str4, onValueChange, function110, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextField$lambda$2$0(RowScope rowScope, FocusRequester focusRequester, String str, final BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs, final Function0 function0, final FocusManager focusManager, final String str2, Function1 function1, final String str3, final Modifier modifier, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C93@4305L110,97@4449L500,82@3718L1245:BoxSimpleTextField.kt#fjpkir");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-926526770, i, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField.<anonymous>.<anonymous> (BoxSimpleTextField.kt:82)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(RowScope.weight$default(rowScope, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester), 1.0f, false, 2, null), str);
            TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), boxSimpleTextFieldColorConfigs.m11748getContentColor0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            SolidColor solidColor = new SolidColor(boxSimpleTextFieldColorConfigs.m11749getCursorColor0d7_KjU(), null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, -1333976356, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            boolean zChanged = composer.changed(function0) | composer.changedInstance(focusManager);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0$0$0(function0, focusManager, (KeyboardActionScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicTextFieldKt.BasicTextField(str2, (Function1<? super String, Unit>) function1, modifierTestTag, false, false, textStyleM9104copyp1EtxEg$default, keyboardOptions, KeyboardActionsKt.KeyboardActions((Function1) objRememberedValue), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(362222385, true, new Function3() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxSimpleTextFieldKt.BoxSimpleTextField$lambda$2$0$1(str2, boxSimpleTextFieldColorConfigs, str3, modifier, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 102236160, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 15896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextField$lambda$2$0$0$0(Function0 function0, FocusManager focusManager, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function0.invoke();
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextField$lambda$2$0$1(String str, BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs, String str2, Modifier modifier, Function2 innerTextField, Composer composer, int i) {
        int i2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation(composer2, "CN(innerTextField)98@4489L442:BoxSimpleTextField.kt#fjpkir");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changedInstance(innerTextField) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(362222385, i2, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField.<anonymous>.<anonymous>.<anonymous> (BoxSimpleTextField.kt:98)");
            }
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1244011854, "C107@4893L16:BoxSimpleTextField.kt#fjpkir");
            if (str.length() == 0) {
                composer2.startReplaceGroup(-1243965882);
                ComposerKt.sourceInformation(composer2, "100@4569L273");
                TextKt.m4494TextNvy7gAk(str2, modifier, boxSimpleTextFieldColorConfigs.m11750getHintColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer2, 0, 12582912, 131064);
                composer2 = composer2;
            } else {
                composer2.startReplaceGroup(-1248507785);
            }
            composer2.endReplaceGroup();
            innerTextField.invoke(composer2, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextField$lambda$2$1(Function0 function0, String str, BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C118@5127L375:BoxSimpleTextField.kt#fjpkir");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1967764042, i, -1, "com.box.android.base.compose.textfield.BoxSimpleTextField.<anonymous>.<anonymous> (BoxSimpleTextField.kt:118)");
        }
        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, str, new ButtonItemIconResource.DrawableResource(R.drawable.ic_close_24dp), false, 17, null), null, null, boxSimpleTextFieldColorConfigs.m11747getClearButtonColor0d7_KjU(), 0.0f, composer, 0, 22);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void BoxSimpleTextFieldPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-576088447);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSimpleTextFieldPreview)144@5890L3457:BoxSimpleTextField.kt#fjpkir");
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-576088447, i, -1, "com.box.android.base.compose.textfield.BoxSimpleTextFieldPreview (BoxSimpleTextField.kt:143)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -362300606, "C149@6033L6,145@5907L788,171@6831L6,167@6705L813,193@7654L6,189@7528L894,215@8558L6,211@8432L909:BoxSimpleTextField.kt#fjpkir");
            float f = 64;
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null);
            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -900100610, "C152@6145L31,156@6318L13,155@6271L13,153@6189L496:BoxSimpleTextField.kt#fjpkir");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 663701020, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strBoxSimpleTextFieldPreview$lambda$0$0$1 = BoxSimpleTextFieldPreview$lambda$0$0$1(mutableState);
            BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs = new BoxSimpleTextFieldColorConfigs(Color.INSTANCE.m6851getWhite0d7_KjU(), Color.m6813copywmQWz5c$default(Color.INSTANCE.m6851getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6851getWhite0d7_KjU(), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 16, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 663706538, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$0$3$0(mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 663705034, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$0$4$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxSimpleTextField(null, strBoxSimpleTextFieldPreview$lambda$0$0$1, "Hint color is correct", null, boxSimpleTextFieldColorConfigs, null, null, function1, (Function0) objRememberedValue3, null, composerStartRestartGroup, 113246592, 617);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null);
            Alignment centerStart2 = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 749938158, "C174@6943L59,178@7144L13,177@7097L13,175@7015L493:BoxSimpleTextField.kt#fjpkir");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -391450577, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Content and Clear is correct", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strBoxSimpleTextFieldPreview$lambda$0$1$1 = BoxSimpleTextFieldPreview$lambda$0$1$1(mutableState2);
            BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs2 = new BoxSimpleTextFieldColorConfigs(Color.INSTANCE.m6851getWhite0d7_KjU(), Color.m6813copywmQWz5c$default(Color.INSTANCE.m6851getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6851getWhite0d7_KjU(), Color.INSTANCE.m6851getWhite0d7_KjU(), null, 16, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -391444191, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$1$3$0(mutableState2, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function1 function2 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -391445695, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$1$4$0(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxSimpleTextField(null, strBoxSimpleTextFieldPreview$lambda$0$1$1, "Search Hello World", null, boxSimpleTextFieldColorConfigs2, null, null, function2, (Function0) objRememberedValue6, null, composerStartRestartGroup, 113246592, 617);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM589backgroundbw27NRU$default3 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11576getTopBarBackgroundSecondary0d7_KjU(), null, 2, null);
            Alignment centerStart3 = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart3, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default3);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1035076200, "C196@7795L22,196@7778L39,203@8129L6,204@8189L6,205@8275L6,206@8356L6,200@7959L13,199@7912L13,197@7830L582:BoxSimpleTextField.kt#fjpkir");
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 310484523, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$2$0$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue7, composerStartRestartGroup, 48);
            String strBoxSimpleTextFieldPreview$lambda$0$2$1 = BoxSimpleTextFieldPreview$lambda$0$2$1(mutableState3);
            BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs3 = new BoxSimpleTextFieldColorConfigs(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null, 16, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 310489762, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableState3);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$2$3$0(mutableState3, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Function1 function3 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 310488258, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState3);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$2$4$0(mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxSimpleTextField(null, strBoxSimpleTextFieldPreview$lambda$0$2$1, "Hint color is correct", null, boxSimpleTextFieldColorConfigs3, null, null, function3, (Function0) objRememberedValue9, null, composerStartRestartGroup, 384, 617);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM589backgroundbw27NRU$default4 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null);
            Alignment centerStart4 = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart4, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default4);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1320212940, "C218@8687L50,218@8670L67,225@9048L6,226@9108L6,227@9194L6,228@9275L6,222@8879L13,221@8832L13,219@8750L581:BoxSimpleTextField.kt#fjpkir");
            Object[] objArr2 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1012419144, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$3$0$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue10, composerStartRestartGroup, 48);
            String strBoxSimpleTextFieldPreview$lambda$0$3$1 = BoxSimpleTextFieldPreview$lambda$0$3$1(mutableState4);
            BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs4 = new BoxSimpleTextFieldColorConfigs(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null, 16, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1012425251, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(mutableState4);
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$3$3$0(mutableState4, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            Function1 function4 = (Function1) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1012423747, "CC(remember):BoxSimpleTextField.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(mutableState4);
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function0() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$0$3$4$0(mutableState4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxSimpleTextField(null, strBoxSimpleTextFieldPreview$lambda$0$3$1, "Search Hello World 2", null, boxSimpleTextFieldColorConfigs4, null, null, function4, (Function0) objRememberedValue12, null, composerStartRestartGroup, 384, 617);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.BoxSimpleTextFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSimpleTextFieldKt.BoxSimpleTextFieldPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String BoxSimpleTextFieldPreview$lambda$0$0$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$0$4$0(MutableState mutableState) {
        mutableState.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$0$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    private static final String BoxSimpleTextFieldPreview$lambda$0$1$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$1$4$0(MutableState mutableState) {
        mutableState.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$1$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState BoxSimpleTextFieldPreview$lambda$0$2$0$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
    }

    private static final String BoxSimpleTextFieldPreview$lambda$0$2$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$2$4$0(MutableState mutableState) {
        mutableState.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$2$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState BoxSimpleTextFieldPreview$lambda$0$3$0$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Content and Clear is correct", null, 2, null);
    }

    private static final String BoxSimpleTextFieldPreview$lambda$0$3$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$3$4$0(MutableState mutableState) {
        mutableState.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTextFieldPreview$lambda$0$3$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }
}

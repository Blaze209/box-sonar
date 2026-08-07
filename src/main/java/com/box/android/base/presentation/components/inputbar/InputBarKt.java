package com.box.android.base.presentation.components.inputbar;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.UserAvatarKt;
import com.box.android.base.compose.UserAvatarUIModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a©\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"InputBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "inputBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "isEnabled", "", "placeHolderText", "", "submitIcon", "submitBtnContentDescription", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "currentUserAvatarUiModel", "Lcom/box/android/base/compose/UserAvatarUIModel;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "maxInputLines", "keyboardAction", "Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;", "timestampText", "", "onTextChanged", "Lkotlin/Function1;", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "onKeyboardActionHandled", "Lkotlin/Function0;", "onSubmitInput", "(Landroidx/compose/ui/Modifier;Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;ZIIILcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/base/compose/UserAvatarUIModel;Landroidx/compose/foundation/ScrollState;ILcom/box/android/base/presentation/components/inputbar/KeyboardAction;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBar$lambda$1(Modifier modifier, InputBoxValue inputBoxValue, boolean z, int i, int i2, int i3, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, UserAvatarUIModel userAvatarUIModel, ScrollState scrollState, int i4, KeyboardAction keyboardAction, String str, Function1 function1, Function0 function0, Function0 function2, int i5, int i6, int i7, Composer composer, int i8) {
        InputBar(modifier, inputBoxValue, z, i, i2, i3, defaultAvatarControllerWrapper, userAvatarUIModel, scrollState, i4, keyboardAction, str, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0174  */
    /* JADX WARN: Code duplicated, block: B:104:0x0179  */
    /* JADX WARN: Code duplicated, block: B:107:0x0183  */
    /* JADX WARN: Code duplicated, block: B:109:0x0189  */
    /* JADX WARN: Code duplicated, block: B:113:0x0191  */
    /* JADX WARN: Code duplicated, block: B:115:0x0197  */
    /* JADX WARN: Code duplicated, block: B:119:0x019f  */
    /* JADX WARN: Code duplicated, block: B:122:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:130:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:135:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:136:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01da  */
    /* JADX WARN: Code duplicated, block: B:142:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:148:0x0254  */
    /* JADX WARN: Code duplicated, block: B:151:0x0260  */
    /* JADX WARN: Code duplicated, block: B:152:0x0264  */
    /* JADX WARN: Code duplicated, block: B:155:0x0355  */
    /* JADX WARN: Code duplicated, block: B:157:0x035a  */
    /* JADX WARN: Code duplicated, block: B:160:0x036a  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x013c  */
    /* JADX WARN: Code duplicated, block: B:87:0x013f  */
    /* JADX WARN: Code duplicated, block: B:90:0x014f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0152  */
    /* JADX WARN: Code duplicated, block: B:93:0x0157  */
    /* JADX WARN: Code duplicated, block: B:96:0x015e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0165  */
    /* JADX WARN: Code duplicated, block: B:99:0x0169  */
    public static final void InputBar(final Modifier modifier, final InputBoxValue inputBoxValue, final boolean z, final int i, final int i2, final int i3, final DefaultAvatarControllerWrapper avatarControllerWrapper, final UserAvatarUIModel currentUserAvatarUiModel, ScrollState scrollState, int i4, final KeyboardAction keyboardAction, String str, final Function1<? super TextFieldValueUIModel, Unit> onTextChanged, final Function0<Unit> onKeyboardActionHandled, final Function0<Unit> onSubmitInput, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z3;
        Composer composer2;
        final ScrollState scrollState2;
        final int i14;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str3;
        Function0<ComposeUiNode> constructor;
        int iOrdinal;
        int i15;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(inputBoxValue, "inputBoxValue");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Intrinsics.checkNotNullParameter(currentUserAvatarUiModel, "currentUserAvatarUiModel");
        Intrinsics.checkNotNullParameter(onTextChanged, "onTextChanged");
        Intrinsics.checkNotNullParameter(onKeyboardActionHandled, "onKeyboardActionHandled");
        Intrinsics.checkNotNullParameter(onSubmitInput, "onSubmitInput");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1704773531);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputBar)N(modifier,inputBoxValue,isEnabled,placeHolderText,submitIcon,submitBtnContentDescription,avatarControllerWrapper,currentUserAvatarUiModel,scrollState,maxInputLines,keyboardAction,timestampText,onTextChanged,onKeyboardActionHandled,onSubmitInput)39@1583L7,41@1596L1267:InputBar.kt#epp6th");
        if ((i5 & 6) == 0) {
            i8 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i5 & 48) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(inputBoxValue) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            z2 = z;
            i8 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i5 & 3072) == 0) {
            i8 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i8 |= composerStartRestartGroup.changed(i2) ? 16384 : 8192;
        }
        if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i8 |= composerStartRestartGroup.changed(i3) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i8 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(currentUserAvatarUiModel) ? 8388608 : 4194304;
        }
        int i16 = i7 & 256;
        if (i16 != 0) {
            i8 |= 100663296;
        } else if ((i5 & 100663296) == 0) {
            i8 |= composerStartRestartGroup.changed(scrollState) ? 67108864 : 33554432;
        }
        int i17 = i7 & 512;
        if (i17 == 0) {
            if ((i5 & 805306368) == 0) {
                i8 |= composerStartRestartGroup.changed(i4) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
            if ((i6 & 6) == 0) {
                if (keyboardAction == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = keyboardAction.ordinal();
                }
                if (composerStartRestartGroup.changed(iOrdinal)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i9 = i6 | i15;
            } else {
                i9 = i6;
            }
            i10 = i9;
            i11 = i7 & 2048;
            if (i11 != 0) {
                i12 = i10 | 48;
            } else if ((i6 & 48) == 0) {
                i12 = i10 | (composerStartRestartGroup.changed(str) ? 32 : 16);
            } else {
                i12 = i10;
            }
            if ((i6 & 384) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(onTextChanged) ? 256 : 128;
            }
            if ((i6 & 3072) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(onKeyboardActionHandled) ? 2048 : 1024;
            }
            if ((i6 & 24576) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(onSubmitInput) ? 16384 : 8192;
            }
            i13 = i12;
            if ((i8 & 306783379) == 306783378 || (i13 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                scrollState2 = scrollState;
                i14 = i4;
                str2 = str;
            } else {
                if (i16 != 0) {
                    scrollState2 = null;
                } else {
                    scrollState2 = scrollState;
                }
                if (i17 != 0) {
                    i14 = 3;
                } else {
                    i14 = i4;
                }
                if (i11 != 0) {
                    str3 = null;
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1704773531, i8, i13, "com.box.android.base.presentation.components.inputbar.InputBar (InputBar.kt:38)");
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localFocusManager);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final FocusManager focusManager = (FocusManager) objConsume;
                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i18 = i8;
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
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -937772392, "C46@1759L225,51@1993L28,61@2438L409,52@2030L827:InputBar.kt#epp6th");
                UserAvatarKt.UserAvatar(currentUserAvatarUiModel, avatarControllerWrapper.getDefaultAvatarController(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()), composerStartRestartGroup, ((i18 >> 21) & 14) | 384, 0);
                composer2 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composer2, 6);
                final boolean z4 = z2;
                int i19 = i18 >> 3;
                InputTextFieldKt.InputTextField(inputBoxValue, i, onTextChanged, onKeyboardActionHandled, null, false, false, scrollState2, i14, keyboardAction, null, str3, ComposableLambdaKt.rememberComposableLambda(-768352680, true, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InputBarKt.InputBar$lambda$0$0(i2, i3, z4, focusManager, onSubmitInput, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, ((i18 >> 6) & 112) | (i19 & 14) | (i13 & 896) | (i13 & 7168) | (29360128 & i19) | (i19 & 234881024) | ((i13 << 27) & C.ENCODING_PCM_DOUBLE), (i13 & 112) | 384, 1136);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InputBarKt.InputBar$lambda$1(modifier, inputBoxValue, z, i, i2, i3, avatarControllerWrapper, currentUserAvatarUiModel, scrollState2, i14, keyboardAction, str2, onTextChanged, onKeyboardActionHandled, onSubmitInput, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i8 |= 805306368;
        if ((i6 & 6) == 0) {
            if (keyboardAction == null) {
                iOrdinal = -1;
            } else {
                iOrdinal = keyboardAction.ordinal();
            }
            if (composerStartRestartGroup.changed(iOrdinal)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i9 = i6 | i15;
        } else {
            i9 = i6;
        }
        i10 = i9;
        i11 = i7 & 2048;
        if (i11 != 0) {
            i12 = i10 | 48;
        } else if ((i6 & 48) == 0) {
            i12 = i10 | (composerStartRestartGroup.changed(str) ? 32 : 16);
        } else {
            i12 = i10;
        }
        if ((i6 & 384) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onTextChanged) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onKeyboardActionHandled) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onSubmitInput) ? 16384 : 8192;
        }
        i13 = i12;
        if ((i8 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            scrollState2 = scrollState;
            i14 = i4;
            str2 = str;
        } else {
            if (i16 != 0) {
                scrollState2 = null;
            } else {
                scrollState2 = scrollState;
            }
            if (i17 != 0) {
                i14 = 3;
            } else {
                i14 = i4;
            }
            if (i11 != 0) {
                str3 = null;
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1704773531, i8, i13, "com.box.android.base.presentation.components.inputbar.InputBar (InputBar.kt:38)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localFocusManager2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager2 = (FocusManager) objConsume2;
            Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i110 = i8;
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
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -937772392, "C46@1759L225,51@1993L28,61@2438L409,52@2030L827:InputBar.kt#epp6th");
            UserAvatarKt.UserAvatar(currentUserAvatarUiModel, avatarControllerWrapper.getDefaultAvatarController(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()), composerStartRestartGroup, ((i110 >> 21) & 14) | 384, 0);
            composer2 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composer2, 6);
            final boolean z5 = z2;
            int i111 = i110 >> 3;
            InputTextFieldKt.InputTextField(inputBoxValue, i, onTextChanged, onKeyboardActionHandled, null, false, false, scrollState2, i14, keyboardAction, null, str3, ComposableLambdaKt.rememberComposableLambda(-768352680, true, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputBarKt.InputBar$lambda$0$0(i2, i3, z5, focusManager2, onSubmitInput, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, ((i110 >> 6) & 112) | (i111 & 14) | (i13 & 896) | (i13 & 7168) | (29360128 & i111) | (i111 & 234881024) | ((i13 << 27) & C.ENCODING_PCM_DOUBLE), (i13 & 112) | 384, 1136);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputBarKt.InputBar$lambda$1(modifier, inputBoxValue, z, i, i2, i3, avatarControllerWrapper, currentUserAvatarUiModel, scrollState2, i14, keyboardAction, str2, onTextChanged, onKeyboardActionHandled, onSubmitInput, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBar$lambda$0$0(int i, int i2, boolean z, final FocusManager focusManager, final Function0 function0, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C63@2514L27,64@2584L43,66@2702L113,62@2456L377:InputBar.kt#epp6th");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768352680, i3, -1, "com.box.android.base.presentation.components.inputbar.InputBar.<anonymous>.<anonymous> (InputBar.kt:62)");
            }
            Painter painterPainterResource = PainterResources_androidKt.painterResource(i, composer, 0);
            String strStringResource = StringResources_androidKt.stringResource(i2, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 347457993, "CC(remember):InputBar.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(focusManager) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InputBarKt.InputBar$lambda$0$0$0$0(focusManager, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextFieldKt.m11823InputTextFieldActionButtonnBX6wN0(null, painterPainterResource, strStringResource, z, 0L, 0L, (Function0) objRememberedValue, composer, Painter.$stable << 3, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBar$lambda$0$0$0$0(FocusManager focusManager, Function0 function0) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function0.invoke();
        return Unit.INSTANCE;
    }
}

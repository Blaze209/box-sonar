package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ClickableText.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", ViewProps.OVERFLOW, "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", ViewProps.ON_CLICK, "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClickableTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$4(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1 function1, Function1 function2, int i3, int i4, Composer composer, int i5) {
        m1618ClickableText4YKlhWE(annotatedString, modifier, textStyle, z, i, i2, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0135  */
    /* JADX WARN: Code duplicated, block: B:105:0x0147  */
    /* JADX WARN: Code duplicated, block: B:107:0x0155  */
    /* JADX WARN: Code duplicated, block: B:110:0x015d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0178  */
    /* JADX WARN: Code duplicated, block: B:116:0x0197  */
    /* JADX WARN: Code duplicated, block: B:117:0x019a  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:122:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:128:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:130:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:133:0x0214  */
    /* JADX WARN: Code duplicated, block: B:135:0x021d  */
    /* JADX WARN: Code duplicated, block: B:138:0x0231  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0107  */
    /* JADX WARN: Code duplicated, block: B:91:0x010f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0113  */
    /* JADX WARN: Code duplicated, block: B:95:0x0116  */
    /* JADX WARN: Code duplicated, block: B:97:0x011a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0123  */
    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation. Check LinkAnnotation's documentation for more details and samples.")
    /* JADX INFO: renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    public static final void m1618ClickableText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1<? super TextLayoutResult, Unit> function1, final Function1<? super Integer, Unit> function2, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        int i8;
        int i9;
        int i10;
        int iM9583getClipgIe3tQ8;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
        Composer composer2;
        final boolean z3;
        final int i16;
        final TextStyle textStyle3;
        final Function1<? super TextLayoutResult, Unit> function3;
        final Modifier modifier3;
        final int i17;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextStyle textStyle4;
        boolean z4;
        int i18;
        int i19;
        final Function1<? super TextLayoutResult, Unit> function4;
        Object objRememberedValue;
        final MutableState mutableState;
        boolean z5;
        ClickableTextKt$ClickableText$pressIndicator$1$1 clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue;
        boolean z6;
        Object objRememberedValue2;
        Object objRememberedValue3;
        int i20;
        Composer composerStartRestartGroup = composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClickableText)N(text,modifier,style,softWrap,overflow:c#ui.text.style.TextOverflow,maxLines,onTextLayout,onClick)77@3766L2,80@3825L52,82@3942L208,97@4371L76,90@4156L298:ClickableText.kt#423gt5");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i21 = i4 & 2;
        if (i21 == 0) {
            if ((i3 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 != 0) {
                if ((i3 & 384) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 8;
                if (i8 != 0) {
                    if ((i3 & 3072) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 16;
                    if (i10 != 0) {
                        if ((i3 & 24576) == 0) {
                            iM9583getClipgIe3tQ8 = i;
                            if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                                i11 = 16384;
                            } else {
                                i11 = 8192;
                            }
                            i5 |= i11;
                        }
                        i12 = i4 & 32;
                        if (i12 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(i2)) {
                                i13 = 131072;
                            } else {
                                i13 = 65536;
                            }
                            i5 |= i13;
                        }
                        i14 = i4 & 64;
                        if (i14 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i15 = 1048576;
                            } else {
                                i15 = 524288;
                            }
                            i5 |= i15;
                        }
                        if ((i3 & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i20 = 8388608;
                            } else {
                                i20 = 4194304;
                            }
                            i5 |= i20;
                        }
                        if ((i5 & 4793491) != 4793490) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z3 = z;
                            i16 = i2;
                            textStyle3 = textStyle2;
                            function3 = function1;
                        } else {
                            if (i21 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                textStyle4 = TextStyle.INSTANCE.getDefault();
                            } else {
                                textStyle4 = textStyle2;
                            }
                            if (i8 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i10 != 0) {
                                iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                            }
                            if (i12 != 0) {
                                i19 = Integer.MAX_VALUE;
                                i18 = i14;
                            } else {
                                i18 = i14;
                                i19 = i2;
                            }
                            if (i18 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function4 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function4 = function1;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                            if ((29360128 & i5) == 8388608) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z5 || clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                                composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierThen = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                            z6 = (i5 & 3670016) == 1048576;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function3 = function4;
                            textStyle3 = textStyle4;
                            z3 = z4;
                            i16 = i19;
                        }
                        modifier3 = modifier2;
                        i17 = iM9583getClipgIe3tQ8;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i5 |= 24576;
                    iM9583getClipgIe3tQ8 = i;
                    i12 = i4 & 32;
                    if (i12 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i13 = 131072;
                        } else {
                            i13 = 65536;
                        }
                        i5 |= i13;
                    }
                    i14 = i4 & 64;
                    if (i14 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i5 |= i20;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        i16 = i2;
                        textStyle3 = textStyle2;
                        function3 = function1;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle4 = textStyle2;
                        }
                        if (i8 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i10 != 0) {
                            iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                        }
                        if (i12 != 0) {
                            i19 = Integer.MAX_VALUE;
                            i18 = i14;
                        } else {
                            i18 = i14;
                            i19 = i2;
                        }
                        if (i18 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function4 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                        if ((29360128 & i5) == 8388608) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        } else {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierThen2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                        if ((i5 & 3670016) == 1048576) {
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen2, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        textStyle3 = textStyle4;
                        z3 = z4;
                        i16 = i19;
                    }
                    modifier3 = modifier2;
                    i17 = iM9583getClipgIe3tQ8;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 3072;
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        iM9583getClipgIe3tQ8 = i;
                        if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                            i11 = 16384;
                        } else {
                            i11 = 8192;
                        }
                        i5 |= i11;
                    }
                    i12 = i4 & 32;
                    if (i12 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i13 = 131072;
                        } else {
                            i13 = 65536;
                        }
                        i5 |= i13;
                    }
                    i14 = i4 & 64;
                    if (i14 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i5 |= i20;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        i16 = i2;
                        textStyle3 = textStyle2;
                        function3 = function1;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle4 = textStyle2;
                        }
                        if (i8 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i10 != 0) {
                            iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                        }
                        if (i12 != 0) {
                            i19 = Integer.MAX_VALUE;
                            i18 = i14;
                        } else {
                            i18 = i14;
                            i19 = i2;
                        }
                        if (i18 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function4 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                        if ((29360128 & i5) == 8388608) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        } else {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierThen3 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion3, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                        if ((i5 & 3670016) == 1048576) {
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen3, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        textStyle3 = textStyle4;
                        z3 = z4;
                        i16 = i19;
                    }
                    modifier3 = modifier2;
                    i17 = iM9583getClipgIe3tQ8;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                iM9583getClipgIe3tQ8 = i;
                i12 = i4 & 32;
                if (i12 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 64;
                if (i14 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i5 |= i15;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i5 |= i20;
                }
                if ((i5 & 4793491) != 4793490) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    i16 = i2;
                    textStyle3 = textStyle2;
                    function3 = function1;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i8 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i10 != 0) {
                        iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                    }
                    if (i12 != 0) {
                        i19 = Integer.MAX_VALUE;
                        i18 = i14;
                    } else {
                        i18 = i14;
                        i19 = i2;
                    }
                    if (i18 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function4 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                    if ((29360128 & i5) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    } else {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen4 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion4, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                    if ((i5 & 3670016) == 1048576) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen4, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    textStyle3 = textStyle4;
                    z3 = z4;
                    i16 = i19;
                }
                modifier3 = modifier2;
                i17 = iM9583getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 384;
            textStyle2 = textStyle;
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        iM9583getClipgIe3tQ8 = i;
                        if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                            i11 = 16384;
                        } else {
                            i11 = 8192;
                        }
                        i5 |= i11;
                    }
                    i12 = i4 & 32;
                    if (i12 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i13 = 131072;
                        } else {
                            i13 = 65536;
                        }
                        i5 |= i13;
                    }
                    i14 = i4 & 64;
                    if (i14 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i5 |= i20;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        i16 = i2;
                        textStyle3 = textStyle2;
                        function3 = function1;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle4 = textStyle2;
                        }
                        if (i8 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i10 != 0) {
                            iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                        }
                        if (i12 != 0) {
                            i19 = Integer.MAX_VALUE;
                            i18 = i14;
                        } else {
                            i18 = i14;
                            i19 = i2;
                        }
                        if (i18 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function4 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                        if ((29360128 & i5) == 8388608) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        } else {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierThen5 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion5, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                        if ((i5 & 3670016) == 1048576) {
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen5, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        textStyle3 = textStyle4;
                        z3 = z4;
                        i16 = i19;
                    }
                    modifier3 = modifier2;
                    i17 = iM9583getClipgIe3tQ8;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                iM9583getClipgIe3tQ8 = i;
                i12 = i4 & 32;
                if (i12 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 64;
                if (i14 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i5 |= i15;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i5 |= i20;
                }
                if ((i5 & 4793491) != 4793490) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    i16 = i2;
                    textStyle3 = textStyle2;
                    function3 = function1;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i8 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i10 != 0) {
                        iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                    }
                    if (i12 != 0) {
                        i19 = Integer.MAX_VALUE;
                        i18 = i14;
                    } else {
                        i18 = i14;
                        i19 = i2;
                    }
                    if (i18 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function4 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                    if ((29360128 & i5) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    } else {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen6 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion6, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                    if ((i5 & 3670016) == 1048576) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen6, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    textStyle3 = textStyle4;
                    z3 = z4;
                    i16 = i19;
                }
                modifier3 = modifier2;
                i17 = iM9583getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    iM9583getClipgIe3tQ8 = i;
                    if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                        i11 = 16384;
                    } else {
                        i11 = 8192;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 32;
                if (i12 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 64;
                if (i14 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i5 |= i15;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i5 |= i20;
                }
                if ((i5 & 4793491) != 4793490) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    i16 = i2;
                    textStyle3 = textStyle2;
                    function3 = function1;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i8 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i10 != 0) {
                        iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                    }
                    if (i12 != 0) {
                        i19 = Integer.MAX_VALUE;
                        i18 = i14;
                    } else {
                        i18 = i14;
                        i19 = i2;
                    }
                    if (i18 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function4 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                    if ((29360128 & i5) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    } else {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen7 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion7, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                    if ((i5 & 3670016) == 1048576) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen7, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    textStyle3 = textStyle4;
                    z3 = z4;
                    i16 = i19;
                }
                modifier3 = modifier2;
                i17 = iM9583getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            iM9583getClipgIe3tQ8 = i;
            i12 = i4 & 32;
            if (i12 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i13 = 131072;
                } else {
                    i13 = 65536;
                }
                i5 |= i13;
            }
            i14 = i4 & 64;
            if (i14 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i5 |= i15;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i5 |= i20;
            }
            if ((i5 & 4793491) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                i16 = i2;
                textStyle3 = textStyle2;
                function3 = function1;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle4 = textStyle2;
                }
                if (i8 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i10 != 0) {
                    iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                }
                if (i12 != 0) {
                    i19 = Integer.MAX_VALUE;
                    i18 = i14;
                } else {
                    i18 = i14;
                    i19 = i2;
                }
                if (i18 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function4 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion8 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                if ((29360128 & i5) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                } else {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierThen8 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion8, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                if ((i5 & 3670016) == 1048576) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen8, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                textStyle3 = textStyle4;
                z3 = z4;
                i16 = i19;
            }
            modifier3 = modifier2;
            i17 = iM9583getClipgIe3tQ8;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 != 0) {
            if ((i3 & 384) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i5 |= i7;
            }
            i8 = i4 & 8;
            if (i8 != 0) {
                if ((i3 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 16;
                if (i10 != 0) {
                    if ((i3 & 24576) == 0) {
                        iM9583getClipgIe3tQ8 = i;
                        if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                            i11 = 16384;
                        } else {
                            i11 = 8192;
                        }
                        i5 |= i11;
                    }
                    i12 = i4 & 32;
                    if (i12 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i2)) {
                            i13 = 131072;
                        } else {
                            i13 = 65536;
                        }
                        i5 |= i13;
                    }
                    i14 = i4 & 64;
                    if (i14 != 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i5 |= i15;
                    }
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i5 |= i20;
                    }
                    if ((i5 & 4793491) != 4793490) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        i16 = i2;
                        textStyle3 = textStyle2;
                        function3 = function1;
                    } else {
                        if (i21 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            textStyle4 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle4 = textStyle2;
                        }
                        if (i8 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i10 != 0) {
                            iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                        }
                        if (i12 != 0) {
                            i19 = Integer.MAX_VALUE;
                            i18 = i14;
                        } else {
                            i18 = i14;
                            i19 = i2;
                        }
                        if (i18 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function4 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier.Companion companion9 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                        if ((29360128 & i5) == 8388608) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        } else {
                            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                            composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierThen9 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion9, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                        if ((i5 & 3670016) == 1048576) {
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen9, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        textStyle3 = textStyle4;
                        z3 = z4;
                        i16 = i19;
                    }
                    modifier3 = modifier2;
                    i17 = iM9583getClipgIe3tQ8;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                iM9583getClipgIe3tQ8 = i;
                i12 = i4 & 32;
                if (i12 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 64;
                if (i14 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i5 |= i15;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i5 |= i20;
                }
                if ((i5 & 4793491) != 4793490) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    i16 = i2;
                    textStyle3 = textStyle2;
                    function3 = function1;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i8 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i10 != 0) {
                        iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                    }
                    if (i12 != 0) {
                        i19 = Integer.MAX_VALUE;
                        i18 = i14;
                    } else {
                        i18 = i14;
                        i19 = i2;
                    }
                    if (i18 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function4 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion10 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                    if ((29360128 & i5) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    } else {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen10 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion10, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                    if ((i5 & 3670016) == 1048576) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen10, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    textStyle3 = textStyle4;
                    z3 = z4;
                    i16 = i19;
                }
                modifier3 = modifier2;
                i17 = iM9583getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    iM9583getClipgIe3tQ8 = i;
                    if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                        i11 = 16384;
                    } else {
                        i11 = 8192;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 32;
                if (i12 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 64;
                if (i14 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i5 |= i15;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i5 |= i20;
                }
                if ((i5 & 4793491) != 4793490) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    i16 = i2;
                    textStyle3 = textStyle2;
                    function3 = function1;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i8 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i10 != 0) {
                        iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                    }
                    if (i12 != 0) {
                        i19 = Integer.MAX_VALUE;
                        i18 = i14;
                    } else {
                        i18 = i14;
                        i19 = i2;
                    }
                    if (i18 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function4 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                    if ((29360128 & i5) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    } else {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen11 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion11, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                    if ((i5 & 3670016) == 1048576) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen11, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    textStyle3 = textStyle4;
                    z3 = z4;
                    i16 = i19;
                }
                modifier3 = modifier2;
                i17 = iM9583getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            iM9583getClipgIe3tQ8 = i;
            i12 = i4 & 32;
            if (i12 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i13 = 131072;
                } else {
                    i13 = 65536;
                }
                i5 |= i13;
            }
            i14 = i4 & 64;
            if (i14 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i5 |= i15;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i5 |= i20;
            }
            if ((i5 & 4793491) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                i16 = i2;
                textStyle3 = textStyle2;
                function3 = function1;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle4 = textStyle2;
                }
                if (i8 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i10 != 0) {
                    iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                }
                if (i12 != 0) {
                    i19 = Integer.MAX_VALUE;
                    i18 = i14;
                } else {
                    i18 = i14;
                    i19 = i2;
                }
                if (i18 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function4 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion12 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                if ((29360128 & i5) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                } else {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierThen12 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion12, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                if ((i5 & 3670016) == 1048576) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen12, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                textStyle3 = textStyle4;
                z3 = z4;
                i16 = i19;
            }
            modifier3 = modifier2;
            i17 = iM9583getClipgIe3tQ8;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        textStyle2 = textStyle;
        i8 = i4 & 8;
        if (i8 != 0) {
            if ((i3 & 3072) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i5 |= i9;
            }
            i10 = i4 & 16;
            if (i10 != 0) {
                if ((i3 & 24576) == 0) {
                    iM9583getClipgIe3tQ8 = i;
                    if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                        i11 = 16384;
                    } else {
                        i11 = 8192;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 32;
                if (i12 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i13 = 131072;
                    } else {
                        i13 = 65536;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 64;
                if (i14 != 0) {
                    i5 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i5 |= i15;
                }
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i5 |= i20;
                }
                if ((i5 & 4793491) != 4793490) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    i16 = i2;
                    textStyle3 = textStyle2;
                    function3 = function1;
                } else {
                    if (i21 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        textStyle4 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i8 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i10 != 0) {
                        iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                    }
                    if (i12 != 0) {
                        i19 = Integer.MAX_VALUE;
                        i18 = i14;
                    } else {
                        i18 = i14;
                        i19 = i2;
                    }
                    if (i18 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function4 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion13 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                    if ((29360128 & i5) == 8388608) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    } else {
                        clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                        composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen13 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion13, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                    if ((i5 & 3670016) == 1048576) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen13, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    textStyle3 = textStyle4;
                    z3 = z4;
                    i16 = i19;
                }
                modifier3 = modifier2;
                i17 = iM9583getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            iM9583getClipgIe3tQ8 = i;
            i12 = i4 & 32;
            if (i12 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i13 = 131072;
                } else {
                    i13 = 65536;
                }
                i5 |= i13;
            }
            i14 = i4 & 64;
            if (i14 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i5 |= i15;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i5 |= i20;
            }
            if ((i5 & 4793491) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                i16 = i2;
                textStyle3 = textStyle2;
                function3 = function1;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle4 = textStyle2;
                }
                if (i8 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i10 != 0) {
                    iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                }
                if (i12 != 0) {
                    i19 = Integer.MAX_VALUE;
                    i18 = i14;
                } else {
                    i18 = i14;
                    i19 = i2;
                }
                if (i18 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function4 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion14 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                if ((29360128 & i5) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                } else {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierThen14 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion14, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                if ((i5 & 3670016) == 1048576) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen14, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                textStyle3 = textStyle4;
                z3 = z4;
                i16 = i19;
            }
            modifier3 = modifier2;
            i17 = iM9583getClipgIe3tQ8;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        i10 = i4 & 16;
        if (i10 != 0) {
            if ((i3 & 24576) == 0) {
                iM9583getClipgIe3tQ8 = i;
                if (composerStartRestartGroup.changed(iM9583getClipgIe3tQ8)) {
                    i11 = 16384;
                } else {
                    i11 = 8192;
                }
                i5 |= i11;
            }
            i12 = i4 & 32;
            if (i12 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i13 = 131072;
                } else {
                    i13 = 65536;
                }
                i5 |= i13;
            }
            i14 = i4 & 64;
            if (i14 != 0) {
                i5 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i5 |= i15;
            }
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i5 |= i20;
            }
            if ((i5 & 4793491) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                i16 = i2;
                textStyle3 = textStyle2;
                function3 = function1;
            } else {
                if (i21 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    textStyle4 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle4 = textStyle2;
                }
                if (i8 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i10 != 0) {
                    iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
                }
                if (i12 != 0) {
                    i19 = Integer.MAX_VALUE;
                    i18 = i14;
                } else {
                    i18 = i14;
                    i19 = i2;
                }
                if (i18 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function4 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion15 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                if ((29360128 & i5) == 8388608) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                } else {
                    clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                    composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierThen15 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion15, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                if ((i5 & 3670016) == 1048576) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen15, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                textStyle3 = textStyle4;
                z3 = z4;
                i16 = i19;
            }
            modifier3 = modifier2;
            i17 = iM9583getClipgIe3tQ8;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        iM9583getClipgIe3tQ8 = i;
        i12 = i4 & 32;
        if (i12 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(i2)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i5 |= i13;
        }
        i14 = i4 & 64;
        if (i14 != 0) {
            i5 |= 1572864;
        } else if ((i3 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i15 = 1048576;
            } else {
                i15 = 524288;
            }
            i5 |= i15;
        }
        if ((i3 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i20 = 8388608;
            } else {
                i20 = 4194304;
            }
            i5 |= i20;
        }
        if ((i5 & 4793491) != 4793490) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z3 = z;
            i16 = i2;
            textStyle3 = textStyle2;
            function3 = function1;
        } else {
            if (i21 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i6 != 0) {
                textStyle4 = TextStyle.INSTANCE.getDefault();
            } else {
                textStyle4 = textStyle2;
            }
            if (i8 != 0) {
                z4 = true;
            } else {
                z4 = z;
            }
            if (i10 != 0) {
                iM9583getClipgIe3tQ8 = TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
            }
            if (i12 != 0) {
                i19 = Integer.MAX_VALUE;
                i18 = i14;
            } else {
                i18 = i14;
                i19 = i2;
            }
            if (i18 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function4 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function4 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier.Companion companion16 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
            if ((29360128 & i5) == 8388608) {
                z5 = true;
            } else {
                z5 = false;
            }
            clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
            } else {
                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function2);
                composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierThen16 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion16, function2, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
            if ((i5 & 3670016) == 1048576) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function4, (TextLayoutResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            BasicTextKt.m1608BasicTextCL7eQgs(annotatedString, modifierThen16, textStyle4, (Function1) objRememberedValue2, iM9583getClipgIe3tQ8, z4, i19, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
            textStyle3 = textStyle4;
            z3 = z4;
            i16 = i19;
        }
        modifier3 = modifier2;
        i17 = iM9583getClipgIe3tQ8;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z3, i17, i16, function3, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$3$0(MutableState mutableState, Function1 function1, TextLayoutResult textLayoutResult) {
        mutableState.setValue(textLayoutResult);
        function1.invoke(textLayoutResult);
        return Unit.INSTANCE;
    }
}

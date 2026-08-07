package com.box.android.compose.betafeedback;

import android.net.Uri;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.bumptech.glide.integration.compose.GlideImageKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BetaFeedbackScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u0092\u0001\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2'\u0010\u000e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0012\u001a1\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001a¨\u0006\u001c²\u0006\n\u0010\t\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"BetaFeedbackScreen", "", "screenshotUri", "Landroid/net/Uri;", "onSendFeedback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "feedbackText", "", "includeScreenshot", "onCancel", "Lkotlin/Function0;", "onShowDiscardConfirmation", "Lkotlin/Function1;", "onConfirm", "initialFeedbackText", "(Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ScreenshotSection", "onIncludeScreenshotChanged", "(Landroid/net/Uri;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ScreenshotPreview", "uri", "(Landroid/net/Uri;Landroidx/compose/runtime/Composer;I)V", "BetaFeedbackScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "BetaFeedbackScreenWithScreenshotPreview", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BetaFeedbackScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$8(Uri uri, Function2 function2, Function0 function0, Function1 function1, String str, int i, int i2, Composer composer, int i3) {
        BetaFeedbackScreen(uri, function2, function0, function1, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreenPreview$lambda$0(int i, Composer composer, int i2) {
        BetaFeedbackScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreenWithScreenshotPreview$lambda$0(int i, Composer composer, int i2) {
        BetaFeedbackScreenWithScreenshotPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScreenshotPreview$lambda$1(Uri uri, int i, Composer composer, int i2) {
        ScreenshotPreview(uri, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScreenshotSection$lambda$1(Uri uri, boolean z, Function1 function1, int i, Composer composer, int i2) {
        ScreenshotSection(uri, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x009a  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:56:0x00af  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:68:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:71:0x0105  */
    /* JADX WARN: Code duplicated, block: B:74:0x0169  */
    /* JADX WARN: Code duplicated, block: B:76:0x0172  */
    /* JADX WARN: Code duplicated, block: B:79:0x017f  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    public static final void BetaFeedbackScreen(Uri uri, final Function2<? super String, ? super Boolean, Unit> onSendFeedback, final Function0<Unit> onCancel, final Function1<? super Function0<Unit>, Unit> onShowDiscardConfirmation, String str, Composer composer, final int i, final int i2) {
        Uri uri2;
        int i3;
        String str2;
        boolean z;
        Composer composer2;
        final Uri uri3;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Uri uri4;
        final String str4;
        boolean z2;
        Object objRememberedValue;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(onSendFeedback, "onSendFeedback");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onShowDiscardConfirmation, "onShowDiscardConfirmation");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1101879442);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BetaFeedbackScreen)N(screenshotUri,onSendFeedback,onCancel,onShowDiscardConfirmation,initialFeedbackText)58@2572L39,58@2555L56,59@2658L24,59@2641L41,62@2715L1633,102@4384L6,103@4415L1470,61@2688L3197:BetaFeedbackScreen.kt#z2bog0");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            uri2 = uri;
        } else if ((i & 6) == 0) {
            uri2 = uri;
            i3 = (composerStartRestartGroup.changedInstance(uri2) ? 4 : 2) | i;
        } else {
            uri2 = uri;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSendFeedback) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCancel) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onShowDiscardConfirmation) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                str2 = str;
                i3 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                uri3 = uri2;
                str3 = str2;
            } else {
                if (i4 != 0) {
                    uri4 = null;
                } else {
                    uri4 = uri2;
                }
                if (i5 != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1101879442, i3, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreen (BetaFeedbackScreen.kt:57)");
                }
                Object[] objArr = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1950788245, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$0$0(str4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 0);
                Object[] objArr2 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1950790982, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$3$0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1492636118, true, new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$6(mutableState, onShowDiscardConfirmation, onCancel, onSendFeedback, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                long jM11511getContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11511getContentBackground0d7_KjU();
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-139057921, true, new Function3() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$7(mutableState, uri4, mutableState2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composer2 = composerStartRestartGroup;
                String str5 = str4;
                Uri uri5 = uri4;
                ScaffoldKt.m4038ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, jM11511getContentBackground0d7_KjU, 0L, null, composableLambdaRememberComposableLambda2, composer2, 805306416, 445);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str5;
                uri3 = uri5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$8(uri3, onSendFeedback, onCancel, onShowDiscardConfirmation, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        str2 = str;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            uri3 = uri2;
            str3 = str2;
        } else {
            if (i4 != 0) {
                uri4 = null;
            } else {
                uri4 = uri2;
            }
            if (i5 != 0) {
                str4 = "";
            } else {
                str4 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1101879442, i3, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreen (BetaFeedbackScreen.kt:57)");
            }
            Object[] objArr3 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1950788245, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            if ((57344 & i3) == 16384) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$0$0(str4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$0$0(str4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue, composerStartRestartGroup, 0);
            Object[] objArr4 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1950790982, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$3$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr4, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1492636118, true, new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$6(mutableState3, onShowDiscardConfirmation, onCancel, onSendFeedback, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            long jM11511getContentBackground0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11511getContentBackground0d7_KjU();
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-139057921, true, new Function3() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$7(mutableState3, uri4, mutableState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            composer2 = composerStartRestartGroup;
            String str6 = str4;
            Uri uri6 = uri4;
            ScaffoldKt.m4038ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda3, null, null, null, 0, jM11511getContentBackground0d7_KjU2, 0L, null, composableLambdaRememberComposableLambda4, composer2, 805306416, 445);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str6;
            uri3 = uri6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$8(uri3, onSendFeedback, onCancel, onShowDiscardConfirmation, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState BetaFeedbackScreen$lambda$0$0(String str) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
    }

    private static final String BetaFeedbackScreen$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState BetaFeedbackScreen$lambda$3$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    }

    private static final boolean BetaFeedbackScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BetaFeedbackScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$6(final MutableState mutableState, final Function1 function1, final Function0 function0, final Function2 function2, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C71@3067L610,86@3705L470,98@4283L6,97@4220L104,63@2729L1609:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1492636118, i, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreen.<anonymous> (BetaFeedbackScreen.kt:63)");
            }
            AppBarKt.m2785TopAppBargNPyAyM(ComposableSingletons$BetaFeedbackScreenKt.INSTANCE.getLambda$571135214$box_generalProdRelease(), null, ComposableLambdaKt.rememberComposableLambda(-1709986704, true, new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$6$0(mutableState, function1, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(1106528729, true, new Function3() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$6$1(function2, mutableState, mutableState2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11575getTopBarBackground0d7_KjU(), 0L, 0L, 0L, 0L, 0L, composer, TopAppBarDefaults.$stable << 18, 62), null, null, composer, 3462, 434);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$6$0(final MutableState mutableState, final Function1 function1, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@3110L247,72@3089L570:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1709986704, i, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreen.<anonymous>.<anonymous> (BetaFeedbackScreen.kt:72)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1675253447, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState) | composer.changed(function1) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$6$0$0$0(function1, function0, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BetaFeedbackScreenKt.INSTANCE.m12415getLambda$1200407154$box_generalProdRelease(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$6$0$0$0(Function1 function1, final Function0 function0, MutableState mutableState) {
        if (BetaFeedbackScreen$lambda$1(mutableState).length() > 0) {
            function1.invoke(new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$6$0$0$0$0(function0);
                }
            });
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$6$0$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$6$1(final Function2 function2, final MutableState mutableState, final MutableState mutableState2, RowScope TopAppBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C87@3748L95,87@3727L430:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1106528729, i, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreen.<anonymous>.<anonymous> (BetaFeedbackScreen.kt:87)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1777779368, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function2) | composer.changed(mutableState) | composer.changed(mutableState2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$6$1$0$0(function2, mutableState, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BetaFeedbackScreenKt.INSTANCE.getLambda$404953723$box_generalProdRelease(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$6$1$0$0(Function2 function2, MutableState mutableState, MutableState mutableState2) {
        function2.invoke(BetaFeedbackScreen$lambda$1(mutableState), Boolean.valueOf(BetaFeedbackScreen$lambda$4(mutableState2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$7(final MutableState mutableState, Uri uri, final MutableState mutableState2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)109@4617L21,104@4442L1437:BetaFeedbackScreen.kt#z2bog0");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-139057921, i2, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreen.<anonymous> (BetaFeedbackScreen.kt:104)");
            }
            float f = 16;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1218padding3ABfNKs(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), Dp.m9687constructorimpl(f)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1503407591, "C125@5293L6,113@4753L21,111@4664L818:BetaFeedbackScreen.kt#z2bog0");
            String strBetaFeedbackScreen$lambda$1 = BetaFeedbackScreen$lambda$1(mutableState);
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(200));
            TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m9310getSentencesIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 126, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1198430634, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$7$0$0$0(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(strBetaFeedbackScreen$lambda$1, (Function1<? super String, Unit>) objRememberedValue, modifierM1252height3ABfNKs, false, false, textStyleM9104copyp1EtxEg$default, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BetaFeedbackScreenKt.INSTANCE.m12416getLambda$1895053074$box_generalProdRelease(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 12583296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 8355672);
            if (uri != null) {
                composer.startReplaceGroup(-1502549419);
                ComposerKt.sourceInformation(composer, "134@5575L41,138@5811L26,135@5633L222");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
                boolean zBetaFeedbackScreen$lambda$4 = BetaFeedbackScreen$lambda$4(mutableState2);
                ComposerKt.sourceInformationMarkerStart(composer, 1198464495, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(mutableState2);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BetaFeedbackScreenKt.BetaFeedbackScreen$lambda$7$0$1$0(mutableState2, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ScreenshotSection(uri, zBetaFeedbackScreen$lambda$4, (Function1) objRememberedValue2, composer, 0);
            } else {
                composer.startReplaceGroup(-1508072627);
            }
            composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$7$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BetaFeedbackScreen$lambda$7$0$1$0(MutableState mutableState, boolean z) {
        BetaFeedbackScreen$lambda$5(mutableState, z);
        return Unit.INSTANCE;
    }

    private static final void ScreenshotSection(final Uri uri, final boolean z, final Function1<? super Boolean, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1510704979);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScreenshotSection)N(screenshotUri,includeScreenshot,onIncludeScreenshotChanged)147@6032L668:BetaFeedbackScreen.kt#z2bog0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1510704979, i3, -1, "com.box.android.compose.betafeedback.ScreenshotSection (BetaFeedbackScreen.kt:146)");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 71131041, "C148@6049L497:BetaFeedbackScreen.kt#z2bog0");
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1673108757, "C152@6185L129,157@6356L57,159@6505L6,156@6327L209:BetaFeedbackScreen.kt#z2bog0");
            CheckboxKt.Checkbox(z, function1, null, false, null, null, composerStartRestartGroup, (i3 >> 3) & 126, 60);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.beta_feedback_include_screenshot, composerStartRestartGroup, 6), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(71640370);
                ComposerKt.sourceInformation(composerStartRestartGroup, "164@6593L40,165@6646L38");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                ScreenshotPreview(uri, composerStartRestartGroup, i3 & 14);
            } else {
                composerStartRestartGroup.startReplaceGroup(65109445);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackScreenKt.ScreenshotSection$lambda$1(uri, z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ScreenshotPreview(final Uri uri, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2087366183);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScreenshotPreview)N(uri)178@6973L6,173@6805L470:BetaFeedbackScreen.kt#z2bog0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087366183, i2, -1, "com.box.android.compose.betafeedback.ScreenshotPreview (BetaFeedbackScreen.kt:172)");
            }
            float f = 8;
            Modifier modifierM604borderxT4_qwU = BorderKt.m604borderxT4_qwU(ClipKt.clip(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(200)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f))), Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f)));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM604borderxT4_qwU);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1142757899, "C182@7110L57,180@7040L229:BetaFeedbackScreen.kt#z2bog0");
            GlideImageKt.GlideImage(uri, StringResources_androidKt.stringResource(R.string.beta_feedback_screenshot_preview, composerStartRestartGroup, 6), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ContentScale.INSTANCE.getFit(), 0.0f, null, null, null, null, null, composerStartRestartGroup, (i2 & 14) | 24960, 0, 2024);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackScreenKt.ScreenshotPreview$lambda$1(uri, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BetaFeedbackScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1757478814);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BetaFeedbackScreenPreview)195@7435L166:BetaFeedbackScreen.kt#z2bog0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1757478814, i, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreenPreview (BetaFeedbackScreen.kt:194)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BetaFeedbackScreenKt.INSTANCE.getLambda$1490594733$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackScreenKt.BetaFeedbackScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BetaFeedbackScreenWithScreenshotPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(99980598);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BetaFeedbackScreenWithScreenshotPreview)207@7695L238:BetaFeedbackScreen.kt#z2bog0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(99980598, i, -1, "com.box.android.compose.betafeedback.BetaFeedbackScreenWithScreenshotPreview (BetaFeedbackScreen.kt:206)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BetaFeedbackScreenKt.INSTANCE.getLambda$1796219201$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.compose.betafeedback.BetaFeedbackScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BetaFeedbackScreenKt.BetaFeedbackScreenWithScreenshotPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

package com.box.android.base.compose.dialog;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.model.DialogButtonsConfig;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAlertDialogWithIcon.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aQ\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"BoxAlertDialogWithIcon", "", "title", "", "text", HubsObservability.HUB_ASSET_ICON, "positiveButton", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "negativeButton", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "(IIILcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "BoxAlertDialogWithIconPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAlertDialogWithIconKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialogWithIcon$lambda$3(int i, int i2, int i3, ButtonItem.TextButtonItem textButtonItem, ButtonItem.TextButtonItem textButtonItem2, Function0 function0, int i4, int i5, Composer composer, int i6) {
        BoxAlertDialogWithIcon(i, i2, i3, textButtonItem, textButtonItem2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialogWithIconPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAlertDialogWithIconPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x0128  */
    /* JADX WARN: Code duplicated, block: B:76:0x012e  */
    /* JADX WARN: Code duplicated, block: B:79:0x013b  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    public static final void BoxAlertDialogWithIcon(final int i, final int i2, final int i3, final ButtonItem.TextButtonItem positiveButton, ButtonItem.TextButtonItem textButtonItem, Function0<Unit> function0, Composer composer, final int i4, final int i5) {
        int i6;
        ButtonItem.TextButtonItem textButtonItem2;
        int i7;
        Function0<Unit> function1;
        int i8;
        boolean z;
        Composer composer2;
        final ButtonItem.TextButtonItem textButtonItem3;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ButtonItem.TextButtonItem textButtonItem4;
        DialogButtonsConfig.PositiveButton positiveButton2;
        Intrinsics.checkNotNullParameter(positiveButton, "positiveButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(1848160589);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAlertDialogWithIcon)N(title,text,icon,positiveButton,negativeButton,onDismiss)31@1152L26,60@2057L154,43@1532L251,52@1801L236,41@1468L817:BoxAlertDialogWithIcon.kt#fwd9q");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(i3) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(positiveButton) ? 2048 : 1024;
        }
        int i9 = i5 & 16;
        if (i9 == 0) {
            if ((i4 & 24576) == 0) {
                textButtonItem2 = textButtonItem;
                i6 |= composerStartRestartGroup.changed(textButtonItem2) ? 16384 : 8192;
            }
            i7 = i5 & 32;
            if (i7 != 0) {
                if ((196608 & i4) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i6 |= i8;
                }
                if ((74899 & i6) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i6 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    textButtonItem3 = textButtonItem2;
                    function2 = function1;
                } else {
                    if (i9 != 0) {
                        textButtonItem4 = null;
                    } else {
                        textButtonItem4 = textButtonItem2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1848160589, i6, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIcon (BoxAlertDialogWithIcon.kt:30)");
                    }
                    String strStringResource = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i6 & 14);
                    if (textButtonItem4 != null) {
                        positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem4);
                    } else {
                        positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                    }
                    ButtonItem.TextButtonItem textButtonItem5 = textButtonItem4;
                    Function0<Unit> function3 = function1;
                    composer2 = composerStartRestartGroup;
                    BoxDialogKt.m11710BoxDialog0S3VyRs(function3, ComposableLambdaKt.rememberComposableLambda(-943408058, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), positiveButton2, null, null, strStringResource, ComposableLambdaKt.rememberComposableLambda(-1469409781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$1(i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1002370252, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0L, 0L, composer2, ((i6 >> 15) & 14) | 14155824, 792);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textButtonItem3 = textButtonItem5;
                    function2 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$3(i, i2, i3, positiveButton, textButtonItem3, function2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function1 = function0;
            if ((74899 & i6) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i6 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                textButtonItem3 = textButtonItem2;
                function2 = function1;
            } else {
                if (i9 != 0) {
                    textButtonItem4 = null;
                } else {
                    textButtonItem4 = textButtonItem2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1848160589, i6, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIcon (BoxAlertDialogWithIcon.kt:30)");
                }
                String strStringResource2 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i6 & 14);
                if (textButtonItem4 != null) {
                    positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem4);
                } else {
                    positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                }
                ButtonItem.TextButtonItem textButtonItem6 = textButtonItem4;
                Function0<Unit> function4 = function1;
                composer2 = composerStartRestartGroup;
                BoxDialogKt.m11710BoxDialog0S3VyRs(function4, ComposableLambdaKt.rememberComposableLambda(-943408058, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), positiveButton2, null, null, strStringResource2, ComposableLambdaKt.rememberComposableLambda(-1469409781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$1(i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1002370252, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), 0L, 0L, composer2, ((i6 >> 15) & 14) | 14155824, 792);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textButtonItem3 = textButtonItem6;
                function2 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$3(i, i2, i3, positiveButton, textButtonItem3, function2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 24576;
        textButtonItem2 = textButtonItem;
        i7 = i5 & 32;
        if (i7 != 0) {
            if ((196608 & i4) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i6 |= i8;
            }
            if ((74899 & i6) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i6 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                textButtonItem3 = textButtonItem2;
                function2 = function1;
            } else {
                if (i9 != 0) {
                    textButtonItem4 = null;
                } else {
                    textButtonItem4 = textButtonItem2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1848160589, i6, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIcon (BoxAlertDialogWithIcon.kt:30)");
                }
                String strStringResource3 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i6 & 14);
                if (textButtonItem4 != null) {
                    positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem4);
                } else {
                    positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                }
                ButtonItem.TextButtonItem textButtonItem7 = textButtonItem4;
                Function0<Unit> function5 = function1;
                composer2 = composerStartRestartGroup;
                BoxDialogKt.m11710BoxDialog0S3VyRs(function5, ComposableLambdaKt.rememberComposableLambda(-943408058, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), positiveButton2, null, null, strStringResource3, ComposableLambdaKt.rememberComposableLambda(-1469409781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$1(i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1002370252, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), 0L, 0L, composer2, ((i6 >> 15) & 14) | 14155824, 792);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textButtonItem3 = textButtonItem7;
                function2 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$3(i, i2, i3, positiveButton, textButtonItem3, function2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function1 = function0;
        if ((74899 & i6) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i6 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            textButtonItem3 = textButtonItem2;
            function2 = function1;
        } else {
            if (i9 != 0) {
                textButtonItem4 = null;
            } else {
                textButtonItem4 = textButtonItem2;
            }
            if (i7 != 0) {
                function1 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848160589, i6, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIcon (BoxAlertDialogWithIcon.kt:30)");
            }
            String strStringResource4 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i6 & 14);
            if (textButtonItem4 != null) {
                positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem4);
            } else {
                positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
            }
            ButtonItem.TextButtonItem textButtonItem8 = textButtonItem4;
            Function0<Unit> function6 = function1;
            composer2 = composerStartRestartGroup;
            BoxDialogKt.m11710BoxDialog0S3VyRs(function6, ComposableLambdaKt.rememberComposableLambda(-943408058, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), positiveButton2, null, null, strStringResource4, ComposableLambdaKt.rememberComposableLambda(-1469409781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$1(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1002370252, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), 0L, 0L, composer2, ((i6 >> 15) & 14) | 14155824, 792);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textButtonItem3 = textButtonItem8;
            function2 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon$lambda$3(i, i2, i3, positiveButton, textButtonItem3, function2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialogWithIcon$lambda$1(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C45@1579L21,44@1546L227:BoxAlertDialogWithIcon.kt#fwd9q");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1469409781, i2, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIcon.<anonymous> (BoxAlertDialogWithIcon.kt:44)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, TestTagKt.testTag(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), "BoxDialogIcon"), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 432, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialogWithIcon$lambda$2(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C54@1844L26,53@1815L212:BoxAlertDialogWithIcon.kt#fwd9q");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1002370252, i2, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIcon.<anonymous> (BoxAlertDialogWithIcon.kt:53)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogTitle"), 0L, null, TextUnitKt.getSp(24), null, FontWeight.INSTANCE.getW400(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1597488, 0, 262060);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialogWithIcon$lambda$0(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C62@2100L25,61@2071L130:BoxAlertDialogWithIcon.kt#fwd9q");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-943408058, i2, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIcon.<anonymous> (BoxAlertDialogWithIcon.kt:61)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogText"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxAlertDialogWithIconPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-125087980);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAlertDialogWithIconPreview)76@2413L499:BoxAlertDialogWithIcon.kt#fwd9q");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-125087980, i, -1, "com.box.android.base.compose.dialog.BoxAlertDialogWithIconPreview (BoxAlertDialogWithIcon.kt:75)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAlertDialogWithIconKt.INSTANCE.m11716getLambda$1060935319$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogWithIconKt.BoxAlertDialogWithIconPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

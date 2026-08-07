package com.box.android.preview.previewtype.boxnote;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.FormatIndentDecreaseKt;
import androidx.compose.material.icons.automirrored.outlined.FormatIndentIncreaseKt;
import androidx.compose.material.icons.automirrored.outlined.FormatListBulletedKt;
import androidx.compose.material.icons.outlined.ChecklistKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.ContentCopyKt;
import androidx.compose.material.icons.outlined.ContentCutKt;
import androidx.compose.material.icons.outlined.ContentPasteKt;
import androidx.compose.material.icons.outlined.FormatBoldKt;
import androidx.compose.material.icons.outlined.FormatItalicKt;
import androidx.compose.material.icons.outlined.FormatListNumberedKt;
import androidx.compose.material.icons.outlined.FormatUnderlinedKt;
import androidx.compose.material3.BottomAppBarDefaults;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.cpl.Store;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: BoxNotesCABView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001aI\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"BoxNotesCABView", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "BoxNotesButton", "iconRes", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "isSelected", "", "modifier", "Landroidx/compose/ui/Modifier;", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "BoxNotesCABViewPreview", "(Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxNotesCABViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesButton$lambda$1(ImageVector imageVector, String str, Function0 function0, boolean z, Modifier modifier, String str2, int i, int i2, Composer composer, int i3) {
        BoxNotesButton(imageVector, str, function0, z, modifier, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$3(Store store, int i, Composer composer, int i2) {
        BoxNotesCABView(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABViewPreview$lambda$0(int i, Composer composer, int i2) {
        BoxNotesCABViewPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxNotesCABView(final Store<BoxNoteEditModeReducer.State, BoxNoteEditModeReducer.Action> store, Composer composer, final int i) {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1727184513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxNotesCABView)N(store)52@2615L29,54@2698L68,54@2650L116,61@2866L6,63@2972L12,64@3016L21,58@2772L4982:BoxNotesCABView.kt#m6nu90");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1727184513, i2, -1, "com.box.android.preview.previewtype.boxnote.BoxNotesCABView (BoxNotesCABView.kt:51)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            composerStartRestartGroup = composerStartRestartGroup;
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1966947493, "CC(remember):BoxNotesCABView.kt#9igjgp");
            int i4 = i2 & 14;
            boolean z = i4 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LifecycleEffectKt.LifecycleEventEffect(event, null, (Function0) objRememberedValue, composerStartRestartGroup, 6, 2);
            Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(WindowInsetsPaddingKt.windowInsetsPadding(WindowInsetsPadding_androidKt.imePadding(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), null, 2, null)), BottomAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, BottomAppBarDefaults.$stable)), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHorizontalScroll$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894893693, "C70@3262L45,71@3331L50,68@3169L299,108@4842L44,109@4910L50,106@4744L361,116@5215L46,117@5285L52,114@5115L371,124@5600L49,125@5673L55,122@5496L387,132@6012L51,133@6087L56,130@5893L396,140@6405L51,141@6480L56,138@6299L383,148@6789L49,149@6862L55,146@6692L369,156@7192L46,157@7262L52,154@7071L332,164@7534L47,165@7605L53,162@7413L335:BoxNotesCABView.kt#m6nu90");
            ImageVector close = CloseKt.getClose(Icons.Outlined.INSTANCE);
            String strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030956273, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z2 = i4 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(close, strStringResource, (Function0) objRememberedValue2, true, null, "BoxNotes:CloseButton", composerStartRestartGroup, 199680, 16);
            if (!BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).isSelectionMode() || !BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).isMobileCopyPasteEnabled()) {
                i3 = -1898180283;
                composerStartRestartGroup.startReplaceGroup(-1898180283);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1894657815);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3659L43,80@3730L49,77@3553L324");
                ImageVector contentCut = ContentCutKt.getContentCut(Icons.Outlined.INSTANCE);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.talkback_label_cut, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030943506, "CC(remember):BoxNotesCABView.kt#9igjgp");
                boolean z3 = i4 == 4;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i3 = -1898180283;
                BoxNotesButton(contentCut, strStringResource2, (Function0) objRememberedValue3, false, null, "BoxNotes:CutButton", composerStartRestartGroup, 199680, 16);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (!BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).isSelectionMode() || !BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).isMobileCopyPasteEnabled()) {
                composerStartRestartGroup.startReplaceGroup(i3);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1894242043);
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4079L44,90@4151L50,87@3972L328");
                ImageVector contentCopy = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.talkback_label_copy, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030930033, "CC(remember):BoxNotesCABView.kt#9igjgp");
                boolean z4 = i4 == 4;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxNotesButton(contentCopy, strStringResource3, (Function0) objRememberedValue4, false, null, "BoxNotes:CopyButton", composerStartRestartGroup, 199680, 16);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (!BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).getHasPasteData() || !BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).isMobileCopyPasteEnabled()) {
                composerStartRestartGroup.startReplaceGroup(i3);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1893825279);
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@4500L45,100@4573L51,97@4392L332");
                ImageVector contentPaste = ContentPasteKt.getContentPaste(Icons.Outlined.INSTANCE);
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.talkback_label_paste, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030916528, "CC(remember):BoxNotesCABView.kt#9igjgp");
                boolean z5 = i4 == 4;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxNotesButton(contentPaste, strStringResource4, (Function0) objRememberedValue5, false, null, "BoxNotes:PasteButton", composerStartRestartGroup, 199680, 16);
            }
            composerStartRestartGroup.endReplaceGroup();
            ImageVector formatBold = FormatBoldKt.getFormatBold(Icons.Outlined.INSTANCE);
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.talkback_label_bold, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030905745, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z6 = i4 == 4;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(formatBold, strStringResource5, (Function0) objRememberedValue6, BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).getTextStyle().contains(BoxNoteEditModeReducer.TextStyle.BOLD), null, "BoxNotes:BoldButton", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            ImageVector formatItalic = FormatItalicKt.getFormatItalic(Icons.Outlined.INSTANCE);
            String strStringResource6 = StringResources_androidKt.stringResource(R.string.talkback_label_italic, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030893743, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z7 = i4 == 4;
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (z7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$5$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(formatItalic, strStringResource6, (Function0) objRememberedValue7, BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).getTextStyle().contains(BoxNoteEditModeReducer.TextStyle.ITALIC), null, "BoxNotes:ItalicButton", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            ImageVector formatUnderlined = FormatUnderlinedKt.getFormatUnderlined(Icons.Outlined.INSTANCE);
            String strStringResource7 = StringResources_androidKt.stringResource(R.string.talkback_label_underline, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030881324, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z8 = i4 == 4;
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (z8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$6$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(formatUnderlined, strStringResource7, (Function0) objRememberedValue8, BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).getTextStyle().contains(BoxNoteEditModeReducer.TextStyle.UNDERLINE), null, "BoxNotes:UnderlineButton", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            ImageVector formatListBulleted = FormatListBulletedKt.getFormatListBulleted(Icons.AutoMirrored.Outlined.INSTANCE);
            String strStringResource8 = StringResources_androidKt.stringResource(R.string.talkback_label_bullet_list, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030868075, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z9 = i4 == 4;
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (z9 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$7$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Function0 function0 = (Function0) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(formatListBulleted, strStringResource8, function0, BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).getListStyle() == BoxNoteEditModeReducer.ListStyle.BULLET, null, "BoxNotes:BulletListButton", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            ImageVector formatListNumbered = FormatListNumberedKt.getFormatListNumbered(Icons.Outlined.INSTANCE);
            String strStringResource9 = StringResources_androidKt.stringResource(R.string.talkback_label_number_list, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030855499, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z10 = i4 == 4;
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$8$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            Function0 function1 = (Function0) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(formatListNumbered, strStringResource9, function1, BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).getListStyle() == BoxNoteEditModeReducer.ListStyle.NUMBER, null, "BoxNotes:NumberListButton", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            ImageVector checklist = ChecklistKt.getChecklist(Icons.Outlined.INSTANCE);
            String strStringResource10 = StringResources_androidKt.stringResource(R.string.talkback_label_checklist, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030843276, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z11 = i4 == 4;
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$9$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            Function0 function2 = (Function0) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(checklist, strStringResource10, function2, BoxNotesCABView$lambda$0(stateCollectAsStateWithLifecycle).getListStyle() == BoxNoteEditModeReducer.ListStyle.CHECK, null, "BoxNotes:CheckListButton", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            ImageVector formatIndentIncrease = FormatIndentIncreaseKt.getFormatIndentIncrease(Icons.AutoMirrored.Outlined.INSTANCE);
            String strStringResource11 = StringResources_androidKt.stringResource(R.string.talkback_label_indent, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030830479, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z12 = i4 == 4;
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$10$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(formatIndentIncrease, strStringResource11, (Function0) objRememberedValue12, false, null, "BoxNotes:IndentButton", composerStartRestartGroup, 199680, 16);
            ImageVector formatIndentDecrease = FormatIndentDecreaseKt.getFormatIndentDecrease(Icons.AutoMirrored.Outlined.INSTANCE);
            String strStringResource12 = StringResources_androidKt.stringResource(R.string.talkback_label_outdent, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1030819502, "CC(remember):BoxNotesCABView.kt#9igjgp");
            boolean z13 = i4 == 4;
            Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue13 = new Function0() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxNotesCABViewKt.BoxNotesCABView$lambda$2$11$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxNotesButton(formatIndentDecrease, strStringResource12, (Function0) objRememberedValue13, false, null, "BoxNotes:OutdentButton", composerStartRestartGroup, 199680, 16);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNotesCABViewKt.BoxNotesCABView$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$1$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Initialize.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$0$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Exit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$1$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Cut.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$2$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Copy.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$3$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Paste.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$4$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Bold.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$5$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Italic.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$6$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Underline.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$7$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.BulletList.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$8$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.NumberList.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$9$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.CheckList.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$10$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Indent.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesCABView$lambda$2$11$0(Store store) {
        store.send(BoxNoteEditModeReducer.Action.Outdent.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x0112  */
    /* JADX WARN: Code duplicated, block: B:74:0x011e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0122  */
    /* JADX WARN: Code duplicated, block: B:78:0x017c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0186  */
    /* JADX WARN: Code duplicated, block: B:83:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:84:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:87:0x01da  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    private static final void BoxNotesButton(final ImageVector imageVector, final String str, final Function0<Unit> function0, final boolean z, Modifier modifier, String str2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        String str3;
        int i5;
        boolean z2;
        final Modifier.Companion companion;
        final String str4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str5;
        Function0<ComposeUiNode> constructor;
        Modifier.Companion companionTestTag;
        Composer composerStartRestartGroup = composer.startRestartGroup(1351059340);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxNotesButton)N(iconRes,contentDescription,onClick,isSelected,modifier,testTag)185@8088L723:BoxNotesCABView.kt#m6nu90");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i6 = i2 & 16;
        if (i6 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    str3 = str2;
                    if (composerStartRestartGroup.changed(str3)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    str4 = str3;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str5 = null;
                    } else {
                        str5 = str3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1351059340, i3, -1, "com.box.android.preview.previewtype.boxnote.BoxNotesButton (BoxNotesCABView.kt:184)");
                    }
                    float f = 60;
                    Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(f)), 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -158990556, "C196@8423L382,191@8236L569:BoxNotesCABView.kt#m6nu90");
                    Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f));
                    if (str5 != null || (companionTestTag = TestTagKt.testTag(Modifier.INSTANCE, str5)) == null) {
                        companionTestTag = Modifier.INSTANCE;
                    }
                    str4 = str5;
                    IconButtonKt.IconButton(function0, modifierM1266size3ABfNKs.then(companionTestTag), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1034868632, true, new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxNotesCABViewKt.BoxNotesButton$lambda$0$1(z, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 1572864, 60);
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
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxNotesCABViewKt.BoxNotesButton$lambda$1(imageVector, str, function0, z, companion, str4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str3 = str2;
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                str4 = str3;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    str5 = null;
                } else {
                    str5 = str3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1351059340, i3, -1, "com.box.android.preview.previewtype.boxnote.BoxNotesButton (BoxNotesCABView.kt:184)");
                }
                float f2 = 60;
                Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(f2)), 0.0f, 1, null);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -158990556, "C196@8423L382,191@8236L569:BoxNotesCABView.kt#m6nu90");
                Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2));
                if (str5 != null) {
                    companionTestTag = Modifier.INSTANCE;
                } else {
                    companionTestTag = Modifier.INSTANCE;
                }
                str4 = str5;
                IconButtonKt.IconButton(function0, modifierM1266size3ABfNKs2.then(companionTestTag), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1034868632, true, new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxNotesCABViewKt.BoxNotesButton$lambda$0$1(z, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 1572864, 60);
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
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxNotesCABViewKt.BoxNotesButton$lambda$1(imageVector, str, function0, z, companion, str4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                str3 = str2;
                if (composerStartRestartGroup.changed(str3)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                str4 = str3;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    str5 = null;
                } else {
                    str5 = str3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1351059340, i3, -1, "com.box.android.preview.previewtype.boxnote.BoxNotesButton (BoxNotesCABView.kt:184)");
                }
                float f3 = 60;
                Modifier modifierFillMaxHeight$default3 = SizeKt.fillMaxHeight$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(f3)), 0.0f, 1, null);
                Alignment center3 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -158990556, "C196@8423L382,191@8236L569:BoxNotesCABView.kt#m6nu90");
                Modifier modifierM1266size3ABfNKs3 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f3));
                if (str5 != null) {
                    companionTestTag = Modifier.INSTANCE;
                } else {
                    companionTestTag = Modifier.INSTANCE;
                }
                str4 = str5;
                IconButtonKt.IconButton(function0, modifierM1266size3ABfNKs3.then(companionTestTag), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1034868632, true, new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxNotesCABViewKt.BoxNotesButton$lambda$0$1(z, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 1572864, 60);
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
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxNotesCABViewKt.BoxNotesButton$lambda$1(imageVector, str, function0, z, companion, str4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        str3 = str2;
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            str4 = str3;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                str5 = null;
            } else {
                str5 = str3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1351059340, i3, -1, "com.box.android.preview.previewtype.boxnote.BoxNotesButton (BoxNotesCABView.kt:184)");
            }
            float f4 = 60;
            Modifier modifierFillMaxHeight$default4 = SizeKt.fillMaxHeight$default(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(f4)), 0.0f, 1, null);
            Alignment center4 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -158990556, "C196@8423L382,191@8236L569:BoxNotesCABView.kt#m6nu90");
            Modifier modifierM1266size3ABfNKs4 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f4));
            if (str5 != null) {
                companionTestTag = Modifier.INSTANCE;
            } else {
                companionTestTag = Modifier.INSTANCE;
            }
            str4 = str5;
            IconButtonKt.IconButton(function0, modifierM1266size3ABfNKs4.then(companionTestTag), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1034868632, true, new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNotesCABViewKt.BoxNotesButton$lambda$0$1(z, imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 1572864, 60);
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNotesCABViewKt.BoxNotesButton$lambda$1(imageVector, str, function0, z, companion, str4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxNotesButton$lambda$0$1(boolean z, ImageVector imageVector, String str, Composer composer, int i) {
        long jM11536getMainInactiveControl0d7_KjU;
        ComposerKt.sourceInformation(composer, "C197@8437L358:BoxNotesCABView.kt#m6nu90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1034868632, i, -1, "com.box.android.preview.previewtype.boxnote.BoxNotesButton.<anonymous>.<anonymous> (BoxNotesCABView.kt:197)");
            }
            if (z) {
                composer.startReplaceGroup(-496009199);
                ComposerKt.sourceInformation(composer, "201@8609L6");
                jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-495930769);
                ComposerKt.sourceInformation(composer, "203@8688L6");
                jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11536getMainInactiveControl0d7_KjU();
                composer.endReplaceGroup();
            }
            IconKt.m3576Iconww6aTOc(imageVector, str, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), jM11536getMainInactiveControl0d7_KjU, composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxNotesCABViewPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1285948218);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxNotesCABViewPreview)216@8955L493:BoxNotesCABView.kt#m6nu90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1285948218, i, -1, "com.box.android.preview.previewtype.boxnote.BoxNotesCABViewPreview (BoxNotesCABView.kt:215)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$BoxNotesCABViewKt.INSTANCE.getLambda$2122963942$preview_generalProdRelease(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxNotesCABViewKt.BoxNotesCABViewPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final BoxNoteEditModeReducer.State BoxNotesCABView$lambda$0(State<BoxNoteEditModeReducer.State> state) {
        return state.getValue();
    }
}

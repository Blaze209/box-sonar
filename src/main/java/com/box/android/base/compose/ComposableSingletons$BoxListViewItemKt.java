package com.box.android.base.compose;

import android.graphics.Bitmap;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.R;
import com.box.android.base.compose.divider.BoxItemListingDividerKt;
import com.box.android.base.models.ClickActionsConfig;
import com.box.android.base.models.ListItemInfo;
import com.box.android.base.models.OfflineBadgeType;
import com.box.android.base.models.SecondaryActionType;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxListViewItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxListViewItemKt {
    public static final ComposableSingletons$BoxListViewItemKt INSTANCE = new ComposableSingletons$BoxListViewItemKt();
    private static Function2<Composer, Integer, Unit> lambda$941968644 = ComposableLambdaKt.composableLambdaInstance(941968644, false, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxListViewItemKt.lambda_941968644$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$863540061 = ComposableLambdaKt.composableLambdaInstance(863540061, false, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$863540061$base_generalProdRelease() {
        return lambda$863540061;
    }

    public final Function2<Composer, Integer, Unit> getLambda$941968644$base_generalProdRelease() {
        return lambda$941968644;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_941968644$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BoxListViewItem.kt#vejmn0");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(941968644, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$941968644.<anonymous> (BoxListViewItem.kt:68)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void lambda_863540061$lambda$0$ListItemWithDivider(boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1341343064, "C(ListItemWithDivider)N(showDivider,content)465@18698L145:BoxListViewItem.kt#vejmn0");
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1341343064, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.ListItemWithDivider (BoxListViewItem.kt:464)");
        }
        Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter, false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -572192097, "C466@18763L9:BoxListViewItem.kt#vejmn0");
        function2.invoke(composer, Integer.valueOf((i >> 3) & 14));
        if (z) {
            composer.startReplaceGroup(1782658841);
            ComposerKt.sourceInformation(composer, "467@18806L23");
            composer2 = composer;
            BoxItemListingDividerKt.m11726BoxItemListingDivideryajeYGU(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-590808032);
        }
        composer2.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0$3$0(ListItemInfo listItemInfo, ClickActionsConfig clickActionsConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C477@19055L410:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930595625, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:477)");
            }
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(ListItemInfo.copy$default(listItemInfo, null, null, null, null, OfflineBadgeType.UpToDate.INSTANCE, true, 9L, true, 15, null), false, false, false, clickActionsConfig, null, 0, true, null, composer, 12607488, 366);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0$3$1(ListItemInfo listItemInfo, ClickActionsConfig clickActionsConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C489@19530L453:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2025249760, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:489)");
            }
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(ListItemInfo.copy$default(listItemInfo, null, new ItemThumbnail.Icon(R.drawable.ic_folder_shared, null, 2, null), null, null, OfflineBadgeType.Pending.INSTANCE, true, 11L, false, Token.SETELEM_OP, null), false, false, false, clickActionsConfig, null, 0, true, null, composer, 12607488, 366);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0$3$2(ListItemInfo listItemInfo, ClickActionsConfig clickActionsConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C501@20048L357:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(118234401, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:501)");
            }
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(ListItemInfo.copy$default(listItemInfo, null, new ItemThumbnail.Icon(R.drawable.ic_file_pdf, null, 2, null), null, null, OfflineBadgeType.UpToDate.INSTANCE, false, 0L, false, 237, null), false, false, false, clickActionsConfig, null, 0, true, null, composer, 12607488, 366);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0$3$3(ListItemInfo listItemInfo, ClickActionsConfig clickActionsConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C511@20470L401:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2033248734, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:511)");
            }
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(ListItemInfo.copy$default(listItemInfo, null, new ItemThumbnail.Icon(R.drawable.ic_file_image, null, 2, null), null, null, null, false, 0L, false, 253, null), false, false, false, clickActionsConfig, SecondaryActionType.Checkbox.INSTANCE, 0, true, null, composer, 12804480, 330);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0$3$4(ListItemInfo listItemInfo, ClickActionsConfig clickActionsConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C522@20936L522:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(110235427, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:522)");
            }
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(ListItemInfo.copy$default(listItemInfo, null, null, null, null, OfflineBadgeType.OutOfDate.INSTANCE, true, 9L, true, 15, null), false, true, false, clickActionsConfig, SecondaryActionType.Checkbox.INSTANCE, 0, true, null, composer, 12804480, 330);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0$3$5(ListItemInfo listItemInfo, ClickActionsConfig clickActionsConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C536@21523L412:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2041247708, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:536)");
            }
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(ListItemInfo.copy$default(listItemInfo, null, new ItemThumbnail.Icon(R.drawable.ic_folder_external, null, 2, null), null, null, null, false, 0L, false, 253, null), false, false, false, clickActionsConfig, SecondaryActionType.BottomSheetMenu.INSTANCE, 0, true, null, composer, 12804144, 332);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0$3$6(ListItemInfo listItemInfo, ClickActionsConfig clickActionsConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C547@22021L580:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(102236453, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:547)");
            }
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(ListItemInfo.copy$default(listItemInfo, null, new ItemThumbnail.Icon(R.drawable.ic_folder_personal, null, 2, null), null, null, OfflineBadgeType.UpToDate.INSTANCE, true, 1L, true, 13, null), false, false, false, clickActionsConfig, SecondaryActionType.BottomSheetMenu.INSTANCE, 0, true, null, composer, 12804096, 334);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_863540061$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C460@18555L3,474@18971L6,471@18863L3762:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(863540061, i, -1, "com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt.lambda$863540061.<anonymous> (BoxListViewItem.kt:449)");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(48, 48, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(ColorKt.m6868toArgb8_81llA(Color.INSTANCE.m6844getGray0d7_KjU()));
            final ListItemInfo listItemInfo = new ListItemInfo("Sales Growth And Revenue Projection", new ItemThumbnail.PreviewThumbnail(bitmapCreateBitmap), "194.5 MB · Sep 24, 2025 by Zokirjon Mamadjonov Test 1", "", null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
            ComposerKt.sourceInformationMarkerStart(composer, 933325696, "CC(remember):BoxListViewItem.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final ClickActionsConfig clickActionsConfig = new ClickActionsConfig((Function0) objRememberedValue, null, null, null, 14, null);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer, 6).m11498getAppBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -895542334, "C476@19037L442,476@19017L462,488@19512L485,488@19492L505,500@20030L389,500@20010L409,510@20452L433,510@20432L453,521@20918L554,521@20898L574,535@21505L444,535@21485L464,546@22003L612,546@21962L653:BoxListViewItem.kt#vejmn0");
            lambda_863540061$lambda$0$ListItemWithDivider(false, ComposableLambdaKt.rememberComposableLambda(930595625, true, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0$3$0(listItemInfo, clickActionsConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            lambda_863540061$lambda$0$ListItemWithDivider(false, ComposableLambdaKt.rememberComposableLambda(-2025249760, true, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0$3$1(listItemInfo, clickActionsConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            lambda_863540061$lambda$0$ListItemWithDivider(false, ComposableLambdaKt.rememberComposableLambda(118234401, true, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0$3$2(listItemInfo, clickActionsConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            lambda_863540061$lambda$0$ListItemWithDivider(false, ComposableLambdaKt.rememberComposableLambda(-2033248734, true, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0$3$3(listItemInfo, clickActionsConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            lambda_863540061$lambda$0$ListItemWithDivider(false, ComposableLambdaKt.rememberComposableLambda(110235427, true, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0$3$4(listItemInfo, clickActionsConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            lambda_863540061$lambda$0$ListItemWithDivider(false, ComposableLambdaKt.rememberComposableLambda(-2041247708, true, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0$3$5(listItemInfo, clickActionsConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            lambda_863540061$lambda$0$ListItemWithDivider(false, ComposableLambdaKt.rememberComposableLambda(102236453, true, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$BoxListViewItemKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$BoxListViewItemKt.lambda_863540061$lambda$0$3$6(listItemInfo, clickActionsConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 54, 0);
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
}

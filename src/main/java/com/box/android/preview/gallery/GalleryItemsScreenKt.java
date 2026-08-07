package com.box.android.preview.gallery;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxItemThumbnailKt;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarSecondaryKt;
import com.box.android.browse.R;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.utils.SupportedFileExtensions;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GalleryItemsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a!\u0010\b\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003H\u0003¢\u0006\u0002\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"GalleryItemsScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$State;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "GalleryItemsContent", "GalleryItem", "Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "GalleryItemsTopBar", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GalleryItemsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItem$lambda$3(Store store, int i, Composer composer, int i2) {
        GalleryItem(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItemsContent$lambda$2(Store store, int i, Composer composer, int i2) {
        GalleryItemsContent(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItemsScreen$lambda$1(Store store, int i, Composer composer, int i2) {
        GalleryItemsScreen(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItemsTopBar$lambda$3(Store store, int i, Composer composer, int i2) {
        GalleryItemsTopBar(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void GalleryItemsScreen(final Store<GalleryItemsReducer.State, GalleryItemsReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1643587646);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GalleryItemsScreen)N(store)34@1633L83:GalleryItemsScreen.kt#thyhyb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643587646, i2, -1, "com.box.android.preview.gallery.GalleryItemsScreen (GalleryItemsScreen.kt:33)");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -288566021, "C35@1650L25,36@1684L26:GalleryItemsScreen.kt#thyhyb");
            int i3 = i2 & 14;
            GalleryItemsTopBar(store, composerStartRestartGroup, i3);
            GalleryItemsContent(store, composerStartRestartGroup, i3);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GalleryItemsScreenKt.GalleryItemsScreen$lambda$1(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void GalleryItemsContent(final Store<GalleryItemsReducer.State, GalleryItemsReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2126634921);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GalleryItemsContent)N(store)42@1856L29,51@2210L353,45@1919L644:GalleryItemsScreen.kt#thyhyb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126634921, i2, -1, "com.box.android.preview.gallery.GalleryItemsContent (GalleryItemsScreen.kt:41)");
            }
            final IdentifiedList<String, ItemThumbnailReducer.State> items = GalleryItemsContent$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getItems();
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "GalleryScreen:Items");
            GridCells.Fixed fixed = new GridCells.Fixed(3);
            float f = 4;
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null);
            GridCells.Fixed fixed2 = fixed;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 708289464, "CC(remember):GalleryItemsScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(items) | ((i2 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GalleryItemsScreenKt.GalleryItemsContent$lambda$1$0(items, store, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyGridDslKt.LazyVerticalGrid(fixed2, modifierTestTag, null, paddingValuesM1215PaddingValuesa9UjIt4$default, false, horizontalOrVerticalM1073spacedBy0680j_4, horizontalOrVerticalM1073spacedBy0680j_5, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 1772592, 0, 916);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GalleryItemsScreenKt.GalleryItemsContent$lambda$2(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItemsContent$lambda$1$0(final IdentifiedList identifiedList, final Store store, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.items$default(LazyVerticalGrid, identifiedList.size(), new Function1() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GalleryItemsScreenKt.GalleryItemsContent$lambda$1$0$0(identifiedList, ((Integer) obj).intValue());
            }
        }, null, null, ComposableLambdaKt.composableLambdaInstance(-920653092, true, new Function4() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return GalleryItemsScreenKt.GalleryItemsContent$lambda$1$0$1(store, identifiedList, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 12, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object GalleryItemsContent$lambda$1$0$0(IdentifiedList identifiedList, int i) {
        return ((ItemThumbnailReducer.State) identifiedList.get(i)).getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItemsContent$lambda$1$0$1(Store store, IdentifiedList identifiedList, LazyGridItemScope items, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(items, "$this$items");
        ComposerKt.sourceInformation(composer, "CN(it)60@2468L47,56@2318L229:GalleryItemsScreen.kt#thyhyb");
        if ((i2 & 48) == 0) {
            i2 |= composer.changed(i) ? 32 : 16;
        }
        if (!composer.shouldExecute((i2 & Token.COLONCOLON) != 144, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-920653092, i2, -1, "com.box.android.preview.gallery.GalleryItemsContent.<anonymous>.<anonymous>.<anonymous> (GalleryItemsScreen.kt:56)");
            }
            GalleryItemsScreenKt$GalleryItemsContent$1$1$2$1 galleryItemsScreenKt$GalleryItemsContent$1$1$2$1 = new PropertyReference1Impl() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$GalleryItemsContent$1$1$2$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((GalleryItemsReducer.State) obj).getItems();
                }
            };
            String id = ((ItemThumbnailReducer.State) identifiedList.get(i)).getId();
            ComposerKt.sourceInformationMarkerStart(composer, 15646859, "CC(remember):GalleryItemsScreen.kt#9igjgp");
            GalleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1 galleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1RememberedValue = composer.rememberedValue();
            if (galleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                galleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1RememberedValue = GalleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1.INSTANCE;
                composer.updateRememberedValue(galleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            GalleryItem(store.scope(galleryItemsScreenKt$GalleryItemsContent$1$1$2$1, id, (Function2<? super String, ? super LocalAction, ? extends Action>) ((KFunction) galleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1RememberedValue)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void GalleryItem(final Store<ItemThumbnailReducer.State, ItemThumbnailReducer.Action> store, Composer composer, final int i) {
        int i2;
        String extension;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1592716719);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GalleryItem)N(store)69@2705L29,74@2870L132,74@2849L153,83@3134L71:GalleryItemsScreen.kt#thyhyb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1592716719, i2, -1, "com.box.android.preview.gallery.GalleryItem (GalleryItemsScreen.kt:68)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ItemThumbnail thumbnail = GalleryItem$lambda$0(stateCollectAsStateWithLifecycle).getThumbnail();
            boolean z = thumbnail instanceof ItemThumbnail.PreviewThumbnail;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1592400395, "CC(remember):GalleryItemsScreen.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | (i3 == 4);
            GalleryItemsScreenKt$GalleryItem$1$1 galleryItemsScreenKt$GalleryItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            ImageVector playArrow = null;
            if (zChanged || galleryItemsScreenKt$GalleryItem$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                galleryItemsScreenKt$GalleryItem$1$1RememberedValue = new GalleryItemsScreenKt$GalleryItem$1$1(store, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(galleryItemsScreenKt$GalleryItem$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) galleryItemsScreenKt$GalleryItem$1$1RememberedValue, composerStartRestartGroup, 6);
            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(TestTagKt.testTag(Modifier.INSTANCE, "GalleryItem:" + GalleryItemsReducerKt.itemModel(GalleryItem$lambda$0(stateCollectAsStateWithLifecycle)).getName()), 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1592392008, "CC(remember):GalleryItemsScreen.kt#9igjgp");
            boolean z2 = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GalleryItemsScreenKt.GalleryItem$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierAspectRatio$default, false, null, null, null, (Function0) objRememberedValue, 15, null);
            ItemModel itemModel = GalleryItemsReducerKt.itemModel(GalleryItem$lambda$0(stateCollectAsStateWithLifecycle));
            FileModel fileModel = itemModel instanceof FileModel ? (FileModel) itemModel : null;
            if (fileModel != null && (extension = fileModel.getExtension()) != null && SupportedFileExtensions.INSTANCE.isVideoExtension(extension)) {
                playArrow = PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault());
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-2119216529);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@3439L146");
                BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(thumbnail, modifierM632clickableoSLSa3U$default, Dp.m9687constructorimpl(0), null, playArrow, composerStartRestartGroup, ItemThumbnail.$stable | 384, 8);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2119053996);
                ComposerKt.sourceInformation(composerStartRestartGroup, "101@3607L13");
                BoxKt.Box(modifierM632clickableoSLSa3U$default, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GalleryItemsScreenKt.GalleryItem$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItem$lambda$2$0(Store store) {
        store.send(ItemThumbnailReducer.Action.Clicked.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void GalleryItemsTopBar(final Store<GalleryItemsReducer.State, GalleryItemsReducer.Action> store, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1241833300);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GalleryItemsTopBar)N(store)107@3765L29,122@4404L87,126@4559L62,120@4336L285:GalleryItemsScreen.kt#thyhyb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1241833300, i2, -1, "com.box.android.preview.gallery.GalleryItemsTopBar (GalleryItemsScreen.kt:106)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            PreviewSource previewSource = GalleryItemsTopBar$lambda$0(stateCollectAsStateWithLifecycle).getPreviewSource();
            String strParentConsideringRootFolder = ItemModelKt.parentConsideringRootFolder(GalleryItemsTopBar$lambda$0(stateCollectAsStateWithLifecycle).getInitialFileModel());
            int size = GalleryItemsTopBar$lambda$0(stateCollectAsStateWithLifecycle).getItems().size();
            if (Intrinsics.areEqual(previewSource, PreviewSource.Offline.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-599094702);
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@4024L62");
                strParentConsideringRootFolder = StringResources_androidKt.stringResource(R.string.Offlined_Items, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(previewSource, PreviewSource.Recents.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-599091637);
                ComposerKt.sourceInformation(composerStartRestartGroup, "115@4120L55");
                strParentConsideringRootFolder = StringResources_androidKt.stringResource(R.string.recents, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(previewSource, PreviewSource.CaptureHistory.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-599088539);
                ComposerKt.sourceInformation(composerStartRestartGroup, "116@4216L81");
                strParentConsideringRootFolder = StringResources_androidKt.stringResource(com.box.android.coreservices.R.string.box_capture_capture_history, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-599085474);
                composerStartRestartGroup.endReplaceGroup();
            }
            String str = strParentConsideringRootFolder;
            String strPluralStringResource = StringResources_androidKt.pluralStringResource(com.box.android.preview.R.plurals.num_items, size, new Object[]{Integer.valueOf(size)}, composerStartRestartGroup, 0);
            if (size <= 0) {
                strPluralStringResource = null;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -599077582, "CC(remember):GalleryItemsScreen.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GalleryItemsScreenKt.GalleryItemsTopBar$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxSimpleTopBarSecondaryKt.BoxSimpleTopBarSecondary(str, strPluralStringResource, (Function0) objRememberedValue, composerStartRestartGroup, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.gallery.GalleryItemsScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GalleryItemsScreenKt.GalleryItemsTopBar$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryItemsTopBar$lambda$2$0(Store store) {
        store.send(new GalleryItemsReducer.Action.Close(null, 1, null));
        return Unit.INSTANCE;
    }

    private static final GalleryItemsReducer.State GalleryItemsContent$lambda$0(State<GalleryItemsReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemThumbnailReducer.State GalleryItem$lambda$0(State<ItemThumbnailReducer.State> state) {
        return state.getValue();
    }

    private static final GalleryItemsReducer.State GalleryItemsTopBar$lambda$0(State<GalleryItemsReducer.State> state) {
        return state.getValue();
    }
}

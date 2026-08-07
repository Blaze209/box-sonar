package com.box.android.contentpicker.contentsourcepicker;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxCheckBoxKt;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.base.compose.BoxItemThumbnailKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxTypography;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.presentation.components.FileExtensionBadgeKt;
import com.box.android.browse.cpl.RecentsItemPickerViewModel;
import com.box.android.browse.cpl.itempicker.ItemPickerReducer;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.contentpicker.ContentPickerActivityKt;
import com.box.android.contentpicker.ContentPickerReducer;
import com.box.android.contentpicker.ContentPickerViewModel;
import com.box.android.contentpicker.R;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.box.android.domain.models.ItemId;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.apache.hc.core5.http.HttpStatus;

/* JADX INFO: compiled from: ContentSourcePickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\n\u001aP\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\r0\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0002\u001a\u001b\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010#\u001a\r\u0010$\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010%\"\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020*X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020-X\u008a\u0084\u0002"}, d2 = {"ContentSourcePickerScreen", "", "recentsItemPickerViewModel", "Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;", "contentPickerViewModel", "Lcom/box/android/contentpicker/ContentPickerViewModel;", "openMultiTabItemPicker", "Lkotlin/Function0;", "onCaptureMedia", "onUploadContent", "(Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;Lcom/box/android/contentpicker/ContentPickerViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getContentPickerSources", "", "Lkotlin/Triple;", "", "carouselThumbnailShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCarouselThumbnailShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "Header", "onViewAll", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RecentsCarousel", "(Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;Landroidx/compose/runtime/Composer;I)V", "RecentsCarouselMessage", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "LoadedRecentsCarouselItem", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "isSelected", "", "(Lcom/box/android/cpl/Store;ZLandroidx/compose/runtime/Composer;I)V", "SkeletonRecentsCarouselItem", "(Landroidx/compose/runtime/Composer;I)V", "content-picker_generalProdRelease", "contentPickerState", "Lcom/box/android/contentpicker/ContentPickerReducer$State;", "state", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "itemState", "alpha", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContentSourcePickerScreenKt {
    private static final RoundedCornerShape carouselThumbnailShape = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentSourcePickerScreen$lambda$4(RecentsItemPickerViewModel recentsItemPickerViewModel, ContentPickerViewModel contentPickerViewModel, Function0 function0, Function0 function1, Function0 function2, int i, Composer composer, int i2) {
        ContentSourcePickerScreen(recentsItemPickerViewModel, contentPickerViewModel, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Header$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        Header(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadedRecentsCarouselItem$lambda$2(Store store, boolean z, int i, Composer composer, int i2) {
        LoadedRecentsCarouselItem(store, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentsCarousel$lambda$5(RecentsItemPickerViewModel recentsItemPickerViewModel, int i, Composer composer, int i2) {
        RecentsCarousel(recentsItemPickerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentsCarouselMessage$lambda$1(String str, int i, Composer composer, int i2) {
        RecentsCarouselMessage(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkeletonRecentsCarouselItem$lambda$2(int i, Composer composer, int i2) {
        SkeletonRecentsCarouselItem(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ContentSourcePickerScreen(final RecentsItemPickerViewModel recentsItemPickerViewModel, final ContentPickerViewModel contentPickerViewModel, final Function0<Unit> openMultiTabItemPicker, final Function0<Unit> onCaptureMedia, final Function0<Unit> onUploadContent, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(recentsItemPickerViewModel, "recentsItemPickerViewModel");
        Intrinsics.checkNotNullParameter(contentPickerViewModel, "contentPickerViewModel");
        Intrinsics.checkNotNullParameter(openMultiTabItemPicker, "openMultiTabItemPicker");
        Intrinsics.checkNotNullParameter(onCaptureMedia, "onCaptureMedia");
        Intrinsics.checkNotNullParameter(onUploadContent, "onUploadContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-514121830);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContentSourcePickerScreen)N(recentsItemPickerViewModel,contentPickerViewModel,openMultiTabItemPicker,onCaptureMedia,onUploadContent)82@3822L7,84@3849L211,93@4145L92,93@4124L113,96@4293L29,98@4379L6,98@4328L3138:ContentSourcePickerScreen.kt#53w6ms");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? composerStartRestartGroup.changed(recentsItemPickerViewModel) : composerStartRestartGroup.changedInstance(recentsItemPickerViewModel) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(contentPickerViewModel) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(openMultiTabItemPicker) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCaptureMedia) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onUploadContent) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-514121830, i3, -1, "com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreen (ContentSourcePickerScreen.kt:81)");
            }
            ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localActivity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Activity activity = (Activity) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -149829427, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = getContentPickerSources(openMultiTabItemPicker, onCaptureMedia, onUploadContent);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            List<Triple> list = (List) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Store<ContentPickerReducer.State, ContentPickerReducer.Action> store = contentPickerViewModel.getStore();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -149820074, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(store);
            ContentSourcePickerScreenKt$ContentSourcePickerScreen$1$1 contentSourcePickerScreenKt$ContentSourcePickerScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || contentSourcePickerScreenKt$ContentSourcePickerScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                contentSourcePickerScreenKt$ContentSourcePickerScreen$1$1RememberedValue = new ContentSourcePickerScreenKt$ContentSourcePickerScreen$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(contentSourcePickerScreenKt$ContentSourcePickerScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) contentSourcePickerScreenKt$ContentSourcePickerScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 705578103, "C99@4412L30,101@4452L43,141@6219L1241,136@5901L1559:ContentSourcePickerScreen.kt#53w6ms");
            Header(openMultiTabItemPicker, composerStartRestartGroup, (i3 >> 6) & 14);
            RecentsCarousel(recentsItemPickerViewModel, composerStartRestartGroup, RecentsItemPickerViewModel.$stable | (i3 & 14));
            composerStartRestartGroup.startReplaceGroup(161309478);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*129@5699L6,130@5766L6,128@5645L156,105@4616L252,112@4903L698,104@4572L1309");
            for (Triple triple : list) {
                final int iIntValue = ((Number) triple.component1()).intValue();
                final int iIntValue2 = ((Number) triple.component2()).intValue();
                Composer composer2 = composerStartRestartGroup;
                ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(-2106867835, true, new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContentSourcePickerScreenKt.ContentSourcePickerScreen$lambda$3$0$0(iIntValue2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), ClickableKt.m632clickableoSLSa3U$default(Modifier.INSTANCE, false, null, null, null, (Function0) triple.component3(), 15, null), null, null, ComposableLambdaKt.rememberComposableLambda(972669321, true, new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContentSourcePickerScreenKt.ContentSourcePickerScreen$lambda$3$0$1(iIntValue, iIntValue2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, ListItemDefaults.INSTANCE.m3668colorsJ08w3E(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, ListItemDefaults.$stable << 27, 508), 0.0f, 0.0f, composer2, 24582, HttpStatus.SC_PRECONDITION_REQUIRED);
                composerStartRestartGroup = composer2;
                stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
            }
            final State state = stateCollectAsStateWithLifecycle;
            composerStartRestartGroup.endReplaceGroup();
            Composer composer3 = composerStartRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, ContentSourcePickerScreen$lambda$2(state).getGlobalSelectionCount() > 0, TestTagKt.testTag(Modifier.INSTANCE, "AddItemsButton"), EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null)), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-313113844, true, new Function3() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ContentSourcePickerScreenKt.ContentSourcePickerScreen$lambda$3$1(state, activity, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer3, 1600902, 16);
            composerStartRestartGroup = composer3;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContentSourcePickerScreenKt.ContentSourcePickerScreen$lambda$4(recentsItemPickerViewModel, contentPickerViewModel, openMultiTabItemPicker, onCaptureMedia, onUploadContent, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentSourcePickerScreen$lambda$3$0$0(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C107@4675L25,108@4748L10,109@4811L6,106@4638L212:ContentSourcePickerScreen.kt#53w6ms");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2106867835, i2, -1, "com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreen.<anonymous>.<anonymous>.<anonymous> (ContentSourcePickerScreen.kt:106)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentSourcePickerScreen$lambda$3$0$1(int i, int i2, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C117@5111L6,113@4925L658:ContentSourcePickerScreen.kt#53w6ms");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(972669321, i3, -1, "com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreen.<anonymous>.<anonymous>.<anonymous> (ContentSourcePickerScreen.kt:113)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11534getMainActiveControlBackground0d7_KjU(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 703025987, "C122@5361L28,123@5440L25,124@5511L6,120@5256L305:ContentSourcePickerScreen.kt#53w6ms");
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i, composer, 0), StringResources_androidKt.stringResource(i2, composer, 0), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), composer, Painter.$stable | 384, 0);
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
    public static final Unit ContentSourcePickerScreen$lambda$3$1$0$0(Activity activity, State state) {
        Intent intentBuildContentPickerResultIntent$default = activity != null ? ContentPickerActivityKt.buildContentPickerResultIntent$default(activity, ContentSourcePickerScreen$lambda$2(state).getSelectedItems(), null, 2, null) : null;
        if (activity != null) {
            activity.setResult(-1, intentBuildContentPickerResultIntent$default);
        }
        if (activity != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentSourcePickerScreen$lambda$3$1$1(State state, RowScope ElevatedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ElevatedButton, "$this$ElevatedButton");
        ComposerKt.sourceInformation(composer, "C158@7097L255,163@7396L10,157@7071L365:ContentSourcePickerScreen.kt#53w6ms");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1569581166, i, -1, "com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreen.<anonymous>.<anonymous>.<anonymous> (ContentSourcePickerScreen.kt:157)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.add_num_items, RangesKt.coerceAtLeast(ContentSourcePickerScreen$lambda$2(state).getGlobalSelectionCount(), 1), new Object[]{Integer.valueOf(RangesKt.coerceAtLeast(ContentSourcePickerScreen$lambda$2(state).getGlobalSelectionCount(), 1))}, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<Triple<Integer, Integer, Function0<Unit>>> getContentPickerSources(Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2) {
        return CollectionsKt.listOf((Object[]) new Triple[]{new Triple(Integer.valueOf(R.drawable.boxlogo_white), Integer.valueOf(R.string.add_from_box), function0), new Triple(Integer.valueOf(R.drawable.ic_fab_action_capture_media), Integer.valueOf(R.string.new_media), function1), new Triple(Integer.valueOf(R.drawable.ic_fab_action_upload_content_updated), Integer.valueOf(R.string.fab_upload_content_menu_title), function2)});
    }

    public static final RoundedCornerShape getCarouselThumbnailShape() {
        return carouselThumbnailShape;
    }

    private static final void Header(final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1261884457);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Header)N(onViewAll)192@8108L506:ContentSourcePickerScreen.kt#53w6ms");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261884457, i2, -1, "com.box.android.contentpicker.contentsourcepicker.Header (ContentSourcePickerScreen.kt:191)");
            }
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(20), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 331580758, "C194@8178L32,195@8246L10,196@8299L6,193@8160L166,198@8335L27,200@8389L33,201@8458L10,202@8510L6,199@8371L237:ContentSourcePickerScreen.kt#53w6ms");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.recents, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composer2, 0, 0, 131066);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, 0);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.view_all, composer2, 0), ClickableKt.m632clickableoSLSa3U$default(Modifier.INSTANCE, false, null, null, null, function0, 15, null), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelLarge(), composer2, 0, 0, 131064);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContentSourcePickerScreenKt.Header$lambda$1(function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void RecentsCarousel(final RecentsItemPickerViewModel recentsItemPickerViewModel, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-935470581);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecentsCarousel)N(recentsItemPickerViewModel)211@8794L29,212@8847L184,220@9058L135,220@9037L156:ContentSourcePickerScreen.kt#53w6ms");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(recentsItemPickerViewModel) : composerStartRestartGroup.changedInstance(recentsItemPickerViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-935470581, i2, -1, "com.box.android.contentpicker.contentsourcepicker.RecentsCarousel (ContentSourcePickerScreen.kt:209)");
            }
            Store<ItemPickerReducer.State, ItemPickerReducer.Action> store = recentsItemPickerViewModel.getStore();
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1339056605, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = store.scope(new PropertyReference1Impl() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$RecentsCarousel$currentStore$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ItemPickerReducer.State) obj).getStack();
                    }
                }, 0, ContentSourcePickerScreenKt$RecentsCarousel$currentStore$1$2.INSTANCE);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Store store2 = (Store) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1339049902, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(store);
            ContentSourcePickerScreenKt$RecentsCarousel$1$1 contentSourcePickerScreenKt$RecentsCarousel$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || contentSourcePickerScreenKt$RecentsCarousel$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                contentSourcePickerScreenKt$RecentsCarousel$1$1RememberedValue = new ContentSourcePickerScreenKt$RecentsCarousel$1$1(store, store2, null);
                composerStartRestartGroup.updateRememberedValue(contentSourcePickerScreenKt$RecentsCarousel$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) contentSourcePickerScreenKt$RecentsCarousel$1$1RememberedValue, composerStartRestartGroup, 6);
            final IdentifiedList<ItemId.Remote, ItemReducer.State> items = RecentsCarousel$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getItems();
            final ItemsListReducer.LoadingState itemLoadingState = RecentsCarousel$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getItemLoadingState();
            if ((itemLoadingState instanceof ItemsListReducer.LoadingState.PartiallyLoaded) || (itemLoadingState instanceof ItemsListReducer.LoadingState.FullyLoaded)) {
                composerStartRestartGroup.startReplaceGroup(1439521808);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (items.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(1439528690);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "230@9506L45,230@9483L69");
                    RecentsCarouselMessage(StringResources_androidKt.stringResource(R.string.no_recents_available, composerStartRestartGroup, 0), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1439657960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "232@9637L768,232@9590L815");
                    PaddingValues paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(16));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1339030741, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(items) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(itemLoadingState);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ContentSourcePickerScreenKt.RecentsCarousel$lambda$3$0(items, itemLoadingState, store2, stateCollectAsStateWithLifecycle, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LazyDslKt.LazyRow(null, null, paddingValuesM1211PaddingValues0680j_4, false, null, null, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 384, 507);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else if (itemLoadingState instanceof ItemsListReducer.LoadingState.Loading) {
                composerStartRestartGroup.startReplaceGroup(1440559471);
                ComposerKt.sourceInformation(composerStartRestartGroup, "254@10571L254,254@10497L328");
                PaddingValues paddingValuesM1211PaddingValues0680j_5 = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(16));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1339001367, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ContentSourcePickerScreenKt.RecentsCarousel$lambda$4$0((LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyDslKt.LazyRow(null, null, paddingValuesM1211PaddingValues0680j_5, false, null, null, null, false, null, (Function1) objRememberedValue3, composerStartRestartGroup, 817889664, 379);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1440905121);
                ComposerKt.sourceInformation(composerStartRestartGroup, "264@10890L38,264@10867L62");
                RecentsCarouselMessage(StringResources_androidKt.stringResource(R.string.generic_error, composerStartRestartGroup, 0), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContentSourcePickerScreenKt.RecentsCarousel$lambda$5(recentsItemPickerViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentsCarousel$lambda$3$0(IdentifiedList identifiedList, ItemsListReducer.LoadingState loadingState, final Store store, final State state, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final IdentifiedList identifiedList2 = identifiedList;
        final ContentSourcePickerScreenKt$RecentsCarousel$lambda$3$0$$inlined$items$default$1 contentSourcePickerScreenKt$RecentsCarousel$lambda$3$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$RecentsCarousel$lambda$3$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(ItemReducer.State state2) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((ItemReducer.State) obj);
            }
        };
        LazyRow.items(identifiedList2.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$RecentsCarousel$lambda$3$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return contentSourcePickerScreenKt$RecentsCarousel$lambda$3$0$$inlined$items$default$1.invoke(identifiedList2.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$RecentsCarousel$lambda$3$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                ItemReducer.State state2 = (ItemReducer.State) identifiedList2.get(i);
                composer.startReplaceGroup(1524749561);
                ComposerKt.sourceInformation(composer, "CN(item)*238@9917L35,234@9706L380,242@10111L28:ContentSourcePickerScreen.kt#53w6ms");
                Store store2 = store;
                ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$1 contentSourcePickerScreenKt$RecentsCarousel$2$1$1$1 = new PropertyReference1Impl() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ItemsListReducer.State) obj).getItems();
                    }
                };
                ItemId.Remote id = state2.getId();
                ComposerKt.sourceInformationMarkerStart(composer, 464833820, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
                ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1 contentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1RememberedValue = composer.rememberedValue();
                if (contentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    contentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1RememberedValue = ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1.INSTANCE;
                    composer.updateRememberedValue(contentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ContentSourcePickerScreenKt.LoadedRecentsCarouselItem(store2.scope(contentSourcePickerScreenKt$RecentsCarousel$2$1$1$1, id, (Function2<? super ItemId.Remote, ? super LocalAction, ? extends Action>) ((KFunction) contentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1RememberedValue)), ContentSourcePickerScreenKt.RecentsCarousel$lambda$0(state).getItemsListViewState().isItemSelected(state2.getId()), composer, 0);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (loadingState instanceof ItemsListReducer.LoadingState.PartiallyLoaded) {
            LazyListScope.item$default(LazyRow, null, null, ComposableSingletons$ContentSourcePickerScreenKt.INSTANCE.getLambda$2128783273$content_picker_generalProdRelease(), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentsCarousel$lambda$4$0(LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyListScope.items$default(LazyRow, Integer.MAX_VALUE, null, null, ComposableSingletons$ContentSourcePickerScreenKt.INSTANCE.m12427getLambda$908272000$content_picker_generalProdRelease(), 6, null);
        return Unit.INSTANCE;
    }

    public static final void RecentsCarouselMessage(final String text, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(87044408);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecentsCarouselMessage)N(text)271@11008L233:ContentSourcePickerScreen.kt#53w6ms");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(text) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(87044408, i2, -1, "com.box.android.contentpicker.contentsourcepicker.RecentsCarouselMessage (ContentSourcePickerScreen.kt:270)");
            }
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(128));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1252height3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -531736055, "C275@11199L6,272@11099L136:ContentSourcePickerScreen.kt#53w6ms");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(text, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxNormal14(), composer2, i2 & 14, 0, 131066);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContentSourcePickerScreenKt.RecentsCarouselMessage$lambda$1(text, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void LoadedRecentsCarouselItem(final Store<ItemReducer.State, ItemReducer.Action> store, final boolean z, Composer composer, final int i) {
        int i2;
        long jM11517getDivider0d7_KjU;
        Modifier.Companion companionM1218padding3ABfNKs;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-77065081);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedRecentsCarouselItem)N(store,isSelected)282@11396L29,283@11430L1966:ContentSourcePickerScreen.kt#53w6ms");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-77065081, i2, -1, "com.box.android.contentpicker.contentsourcepicker.LoadedRecentsCarouselItem (ContentSourcePickerScreen.kt:281)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Modifier modifierM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(120));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1271width3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1537661235, "C284@11471L1654,325@13134L29,329@13266L10,330@13317L6,326@13172L218:ContentSourcePickerScreen.kt#53w6ms");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 540941758, "C297@12027L94,286@11552L743,304@12329L319,304@12308L340,317@12895L220:ContentSourcePickerScreen.kt#53w6ms");
            ItemThumbnail thumbnail = LoadedRecentsCarouselItem$lambda$0(stateCollectAsStateWithLifecycle).getThumbnailState().getThumbnail();
            Modifier modifierM1271width3ABfNKs2 = SizeKt.m1271width3ABfNKs(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(84)), Dp.m9687constructorimpl(124));
            float fM9687constructorimpl = Dp.m9687constructorimpl(2);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1090919850);
                composerStartRestartGroup.endReplaceGroup();
                jM11517getDivider0d7_KjU = BoxColorPalette.INSTANCE.m11358getBOX_BLUE_800d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1090918798);
                ComposerKt.sourceInformation(composerStartRestartGroup, "293@11849L6");
                jM11517getDivider0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11517getDivider0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            }
            RoundedCornerShape roundedCornerShape = carouselThumbnailShape;
            Modifier modifierClip = ClipKt.clip(BorderKt.m604borderxT4_qwU(modifierM1271width3ABfNKs2, fM9687constructorimpl, jM11517getDivider0d7_KjU, roundedCornerShape), roundedCornerShape);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1090913239, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z2 = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ContentSourcePickerScreenKt.LoadedRecentsCarouselItem$lambda$1$0$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue, 15, null);
            if (!(thumbnail instanceof ItemThumbnail.PreviewThumbnail)) {
                companionM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(20));
            } else {
                companionM1218padding3ABfNKs = Modifier.INSTANCE;
            }
            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(thumbnail, modifierM632clickableoSLSa3U$default.then(companionM1218padding3ABfNKs), 0.0f, null, null, composerStartRestartGroup, ItemThumbnail.$stable, 28);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1090903350, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | (i3 == 4);
            ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1 contentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || contentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                contentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1RememberedValue = new ContentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1(store, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(contentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) contentSourcePickerScreenKt$LoadedRecentsCarouselItem$1$1$3$1RememberedValue, composerStartRestartGroup, 6);
            String fileExtension = CommonBoxUtil.getFileExtension(LoadedRecentsCarouselItem$lambda$0(stateCollectAsStateWithLifecycle).getName(), "");
            if (fileExtension.length() <= 0) {
                composerStartRestartGroup.startReplaceGroup(529493271);
            } else {
                composerStartRestartGroup.startReplaceGroup(542163653);
                ComposerKt.sourceInformation(composerStartRestartGroup, "315@12786L82");
                FileExtensionBadgeKt.FileExtensionBadge(fileExtension, PaddingKt.m1218padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomStart()), Dp.m9687constructorimpl(8)), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            float f = 8;
            BoxCheckBoxKt.BoxCheckbox(PaddingKt.m1218padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), Dp.m9687constructorimpl(f)), z, null, false, composerStartRestartGroup, (i2 & 112) | 384, 8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
            TextKt.m4494TextNvy7gAk(LoadedRecentsCarouselItem$lambda$0(stateCollectAsStateWithLifecycle).getName(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 2, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, 0, 24960, 110586);
            composerStartRestartGroup = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContentSourcePickerScreenKt.LoadedRecentsCarouselItem$lambda$2(store, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadedRecentsCarouselItem$lambda$1$0$0$0(Store store) {
        store.send(ItemReducer.Action.CheckboxClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void SkeletonRecentsCarouselItem(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1978006364);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SkeletonRecentsCarouselItem)338@13480L6,339@13538L45,340@13612L283,350@13901L918:ContentSourcePickerScreen.kt#53w6ms");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1978006364, i, -1, "com.box.android.contentpicker.contentsourcepicker.SkeletonRecentsCarouselItem (ContentSourcePickerScreen.kt:337)");
            }
            long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
            State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("shimmer", composerStartRestartGroup, 6, 0), 0.03f, 0.1f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(HubAssetRemoteDataSource.HUB_BANNER_SCALED_SIZE, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "shimmerAlpha", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            float f = 120;
            Modifier modifierM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1271width3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 476439850, "C351@13942L260,360@14211L29,361@14249L259,370@14517L29,371@14555L258:ContentSourcePickerScreen.kt#53w6ms");
            BoxKt.Box(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1271width3ABfNKs(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(80)), Dp.m9687constructorimpl(f)), Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default, SkeletonRecentsCarouselItem$lambda$0(stateAnimateFloat), 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16))), composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
            float f2 = 14;
            float f3 = 4;
            BoxKt.Box(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(100)), Dp.m9687constructorimpl(f2)), Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default, SkeletonRecentsCarouselItem$lambda$0(stateAnimateFloat), 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f3))), composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f3)), composerStartRestartGroup, 6);
            BoxKt.Box(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(60)), Dp.m9687constructorimpl(f2)), Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default, SkeletonRecentsCarouselItem$lambda$0(stateAnimateFloat), 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f3))), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContentSourcePickerScreenKt.SkeletonRecentsCarouselItem$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ContentPickerReducer.State ContentSourcePickerScreen$lambda$2(State<ContentPickerReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentSourcePickerScreen$lambda$3$1(final State state, final Activity activity, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C151@6743L6,152@6815L6,150@6675L181,143@6275L306,156@7053L397,142@6233L1217:ContentSourcePickerScreen.kt#53w6ms");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-313113844, i, -1, "com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreen.<anonymous>.<anonymous> (ContentSourcePickerScreen.kt:142)");
        }
        RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(100));
        ButtonColors buttonColorsM2853elevatedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2853elevatedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11518getFabButtonBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11519getFabButtonContent0d7_KjU(), 0L, 0L, composer, ButtonDefaults.$stable << 12, 12);
        PaddingValues paddingValuesM1213PaddingValuesYgX7TsA$default = PaddingKt.m1213PaddingValuesYgX7TsA$default(0.0f, Dp.m9687constructorimpl(12), 1, null);
        Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 2, null), 0.0f, Dp.m9687constructorimpl(8), 0.0f, Dp.m9687constructorimpl(24), 5, null);
        ComposerKt.sourceInformationMarkerStart(composer, -254691266, "CC(remember):ContentSourcePickerScreen.kt#9igjgp");
        boolean zChanged = composer.changed(state) | composer.changedInstance(activity);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ContentSourcePickerScreenKt.ContentSourcePickerScreen$lambda$3$1$0$0(activity, state);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ButtonKt.ElevatedButton((Function0<Unit>) objRememberedValue, modifierM1222paddingqDBjuR0$default, false, (Shape) roundedCornerShapeM1573RoundedCornerShape0680j_4, buttonColorsM2853elevatedButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, paddingValuesM1213PaddingValuesYgX7TsA$default, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1569581166, true, new Function3() { // from class: com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ContentSourcePickerScreenKt.ContentSourcePickerScreen$lambda$3$1$1(state, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 817889328, 356);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemPickerReducer.State RecentsCarousel$lambda$0(State<ItemPickerReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemReducer.State LoadedRecentsCarouselItem$lambda$0(State<ItemReducer.State> state) {
        return state.getValue();
    }

    private static final float SkeletonRecentsCarouselItem$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}

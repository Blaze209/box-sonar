package com.box.android.preview.previewtype.audio.playlist;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MusicNoteKt;
import androidx.compose.material.icons.filled.PauseKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.session.MediaController;
import com.box.android.base.compose.BoxColorsKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposePreviewMocks;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarSecondaryKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.AudioItem;
import com.box.android.preview.R;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.hc.core5.http.HttpStatus;

/* JADX INFO: compiled from: PreviewPlaylistScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a!\u0010\t\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\n\u001a=\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001a!\u0010\u0017\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\n\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0015H\u0002\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"PreviewPlaylistScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$State;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "(Lcom/box/android/cpl/Store;Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;Landroidx/compose/runtime/Composer;I)V", "PlaylistItemsContent", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "PlaylistItem", BoxCommonConstants.EXTRA_FILE_NAME, "", "isEnabled", "", "onItemClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "itemState", "Lcom/box/android/preview/previewtype/audio/playlist/PlaylistItemState;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lcom/box/android/preview/previewtype/audio/playlist/PlaylistItemState;Landroidx/compose/runtime/Composer;II)V", "PlaylistTopBar", "toImageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlaylistItemsContentPreview", "(Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewPlaylistScreenKt {

    /* JADX INFO: compiled from: PreviewPlaylistScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlaylistItemState.values().length];
            try {
                iArr[PlaylistItemState.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlaylistItemState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlaylistItemState.NOT_ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItem$lambda$3(String str, boolean z, Function0 function0, Modifier modifier, PlaylistItemState playlistItemState, int i, int i2, Composer composer, int i3) {
        PlaylistItem(str, z, function0, modifier, playlistItemState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItemsContent$lambda$1(Store store, int i, Composer composer, int i2) {
        PlaylistItemsContent(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItemsContent$lambda$4(Store store, int i, Composer composer, int i2) {
        PlaylistItemsContent(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItemsContentPreview$lambda$1(int i, Composer composer, int i2) {
        PlaylistItemsContentPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistTopBar$lambda$3(Store store, int i, Composer composer, int i2) {
        PlaylistTopBar(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPlaylistScreen$lambda$2(Store store, Media3AudioPlayerManager media3AudioPlayerManager, int i, Composer composer, int i2) {
        PreviewPlaylistScreen(store, media3AudioPlayerManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviewPlaylistScreen(final Store<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action> store, final Media3AudioPlayerManager audioPlayerManager, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(audioPlayerManager, "audioPlayerManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(1821134817);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewPlaylistScreen)N(store,audioPlayerManager)53@2541L80,58@2650L239,58@2627L262:PreviewPlaylistScreen.kt#fw1ql1");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(audioPlayerManager) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1821134817, i2, -1, "com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreen (PreviewPlaylistScreen.kt:52)");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1630680417, "C54@2558L21,55@2588L27:PreviewPlaylistScreen.kt#fw1ql1");
            int i3 = i2 & 14;
            PlaylistTopBar(store, composerStartRestartGroup, i3);
            PlaylistItemsContent(store, composerStartRestartGroup, i3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2058878608, "CC(remember):PreviewPlaylistScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(audioPlayerManager) | (i3 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PreviewPlaylistScreenKt.PreviewPlaylistScreen$lambda$1$0(store, audioPlayerManager, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PreviewPlaylistScreen$lambda$2(store, audioPlayerManager, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PreviewPlaylistScreen$lambda$1$0(Store store, final Media3AudioPlayerManager media3AudioPlayerManager, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final AudioPlayerPlaylistStateListener audioPlayerPlaylistStateListener = new AudioPlayerPlaylistStateListener(store);
        MediaController mediaController = media3AudioPlayerManager.getMediaController();
        if (mediaController != null) {
            mediaController.addListener(audioPlayerPlaylistStateListener);
        }
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$PreviewPlaylistScreen$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                MediaController mediaController2 = media3AudioPlayerManager.getMediaController();
                if (mediaController2 != null) {
                    mediaController2.removeListener(audioPlayerPlaylistStateListener);
                }
            }
        };
    }

    public static final void PlaylistItemsContent(final Store<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1667180019);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlaylistItemsContent)N(store)69@3036L29,72@3135L23,73@3243L682,73@3163L762,92@3964L6,93@4010L212,93@3975L247:PreviewPlaylistScreen.kt#fw1ql1");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1667180019, i2, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistItemsContent (PreviewPlaylistScreen.kt:68)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final PreviewPlaylistReducer.ActivePlaylistItem activeItem = PlaylistItemsContent$lambda$0(stateCollectAsStateWithLifecycle).getActiveItem();
            if (activeItem != null) {
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                PaddingValues paddingValuesM1213PaddingValuesYgX7TsA$default = PaddingKt.m1213PaddingValuesYgX7TsA$default(0.0f, Dp.m9687constructorimpl(16), 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 137208349, "CC(remember):PreviewPlaylistScreen.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(activeItem) | ((i2 & 14) == 4);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewPlaylistScreenKt.PlaylistItemsContent$lambda$2$0(stateCollectAsStateWithLifecycle, activeItem, store, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyDslKt.LazyColumn(null, lazyListStateRememberLazyListState, paddingValuesM1213PaddingValuesYgX7TsA$default, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 384, 505);
                int iM11638toPx8Feqmps = ComposeUtilsKt.m11638toPx8Feqmps(Dp.m9687constructorimpl(64), composerStartRestartGroup, 6);
                List<AudioItem> items = PlaylistItemsContent$lambda$0(stateCollectAsStateWithLifecycle).getItems();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 137232423, "CC(remember):PreviewPlaylistScreen.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(activeItem) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changed(iM11638toPx8Feqmps);
                PreviewPlaylistScreenKt$PlaylistItemsContent$2$1 previewPlaylistScreenKt$PlaylistItemsContent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || previewPlaylistScreenKt$PlaylistItemsContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    previewPlaylistScreenKt$PlaylistItemsContent$2$1RememberedValue = new PreviewPlaylistScreenKt$PlaylistItemsContent$2$1(lazyListStateRememberLazyListState, iM11638toPx8Feqmps, stateCollectAsStateWithLifecycle, activeItem, null);
                    composerStartRestartGroup.updateRememberedValue(previewPlaylistScreenKt$PlaylistItemsContent$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(items, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) previewPlaylistScreenKt$PlaylistItemsContent$2$1RememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PreviewPlaylistScreenKt.PlaylistItemsContent$lambda$1(store, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PlaylistItemsContent$lambda$4(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItemsContent$lambda$2$0(State state, final PreviewPlaylistReducer.ActivePlaylistItem activePlaylistItem, final Store store, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List<AudioItem> items = PlaylistItemsContent$lambda$0(state).getItems();
        final Function1 function1 = new Function1() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewPlaylistScreenKt.PlaylistItemsContent$lambda$2$0$0((AudioItem) obj);
            }
        };
        final PreviewPlaylistScreenKt$PlaylistItemsContent$lambda$2$0$$inlined$items$default$1 previewPlaylistScreenKt$PlaylistItemsContent$lambda$2$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$PlaylistItemsContent$lambda$2$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(AudioItem audioItem) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((AudioItem) obj);
            }
        };
        LazyColumn.items(items.size(), new Function1<Integer, Object>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$PlaylistItemsContent$lambda$2$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function1.invoke(items.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$PlaylistItemsContent$lambda$2$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return previewPlaylistScreenKt$PlaylistItemsContent$lambda$2$0$$inlined$items$default$1.invoke(items.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$PlaylistItemsContent$lambda$2$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                PlaylistItemState playlistItemState;
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
                final AudioItem audioItem = (AudioItem) items.get(i);
                composer.startReplaceGroup(-1835494795);
                ComposerKt.sourceInformation(composer, "CN(item)*82@3611L63,79@3463L446:PreviewPlaylistScreen.kt#fw1ql1");
                boolean zAreEqual = Intrinsics.areEqual(activePlaylistItem.getItem().getFileModel().getItemId(), audioItem.getFileModel().getItemId());
                String name = audioItem.getFileModel().getName();
                boolean z = audioItem instanceof AudioItem.Playable;
                ComposerKt.sourceInformationMarkerStart(composer, -474844518, "CC(remember):PreviewPlaylistScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store) | composer.changedInstance(audioItem);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Store store2 = store;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$PlaylistItemsContent$1$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            store2.send(new PreviewPlaylistReducer.Action.ItemClicked(audioItem));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (zAreEqual && activePlaylistItem.isPlaying()) {
                    playlistItemState = PlaylistItemState.PLAYING;
                } else {
                    playlistItemState = (!zAreEqual || activePlaylistItem.isPlaying()) ? PlaylistItemState.NOT_ACTIVE : PlaylistItemState.PAUSED;
                }
                PreviewPlaylistScreenKt.PlaylistItem(name, z, function0, null, playlistItemState, composer, 0, 8);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object PlaylistItemsContent$lambda$2$0$0(AudioItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFileModel().getItemId().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:65:0x0118  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    public static final void PlaylistItem(final String str, boolean z, final Function0<Unit> function0, Modifier modifier, final PlaylistItemState playlistItemState, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final boolean z3;
        Composer composer2;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Modifier.Companion companionM632clickableoSLSa3U$default;
        boolean z4;
        Object objRememberedValue;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(202877654);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlaylistItem)N(fileName,isEnabled,onItemClick,modifier,itemState)128@5255L6,129@5321L6,127@5209L165,112@4653L351,121@5031L142,107@4415L965:PreviewPlaylistScreen.kt#fw1ql1");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(playlistItemState.ordinal())) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((i3 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(202877654, i3, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistItem (PreviewPlaylistScreen.kt:106)");
                }
                composerStartRestartGroup.startReplaceGroup(1691907256);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@4606L17");
                Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), "PlaylistItem:" + str + ":" + playlistItemState.name());
                if (z) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1289088839, "CC(remember):PreviewPlaylistScreen.kt#9igjgp");
                    z4 = (i3 & 896) == 256;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PreviewPlaylistScreenKt.PlaylistItem$lambda$0$0$0(function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null);
                } else {
                    companionM632clickableoSLSa3U$default = Modifier.INSTANCE;
                }
                Modifier modifierThen = modifierTestTag.then(companionM632clickableoSLSa3U$default);
                composerStartRestartGroup.endReplaceGroup();
                z3 = z;
                modifier3 = modifier4;
                ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(842621624, true, new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewPlaylistScreenKt.PlaylistItem$lambda$1(playlistItemState, z3, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), modifierThen, null, null, ComposableLambdaKt.rememberComposableLambda(-818685644, true, new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewPlaylistScreenKt.PlaylistItem$lambda$2(playlistItemState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ListItemDefaults.INSTANCE.m3668colorsJ08w3E(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), 0L, BoxColorsKt.m11587enabledek8zF_U$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), z3, 0.0f, 2, null), 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ListItemDefaults.$stable << 27, 506), 0.0f, 0.0f, composerStartRestartGroup, 24582, HttpStatus.SC_PRECONDITION_REQUIRED);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                z3 = z;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z5 = z3;
                final Modifier modifier5 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewPlaylistScreenKt.PlaylistItem$lambda$3(str, z5, function0, modifier5, playlistItemState, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changed(playlistItemState.ordinal())) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((i3 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(202877654, i3, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistItem (PreviewPlaylistScreen.kt:106)");
            }
            composerStartRestartGroup.startReplaceGroup(1691907256);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*111@4606L17");
            Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), "PlaylistItem:" + str + ":" + playlistItemState.name());
            if (z) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1289088839, "CC(remember):PreviewPlaylistScreen.kt#9igjgp");
                if ((i3 & 896) == 256) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PreviewPlaylistScreenKt.PlaylistItem$lambda$0$0$0(function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PreviewPlaylistScreenKt.PlaylistItem$lambda$0$0$0(function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue, 15, null);
            } else {
                companionM632clickableoSLSa3U$default = Modifier.INSTANCE;
            }
            Modifier modifierThen2 = modifierTestTag2.then(companionM632clickableoSLSa3U$default);
            composerStartRestartGroup.endReplaceGroup();
            z3 = z;
            modifier3 = modifier4;
            ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(842621624, true, new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PlaylistItem$lambda$1(playlistItemState, z3, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifierThen2, null, null, ComposableLambdaKt.rememberComposableLambda(-818685644, true, new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PlaylistItem$lambda$2(playlistItemState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ListItemDefaults.INSTANCE.m3668colorsJ08w3E(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), 0L, BoxColorsKt.m11587enabledek8zF_U$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), z3, 0.0f, 2, null), 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ListItemDefaults.$stable << 27, 506), 0.0f, 0.0f, composerStartRestartGroup, 24582, HttpStatus.SC_PRECONDITION_REQUIRED);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z3 = z;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z6 = z3;
            final Modifier modifier6 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PlaylistItem$lambda$3(str, z6, function0, modifier6, playlistItemState, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItem$lambda$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItem$lambda$1(PlaylistItemState playlistItemState, boolean z, String str, Composer composer, int i) {
        long jM11533getMainActiveControl0d7_KjU;
        ComposerKt.sourceInformation(composer, "C113@4667L327:PreviewPlaylistScreen.kt#fw1ql1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(842621624, i, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistItem.<anonymous> (PreviewPlaylistScreen.kt:113)");
            }
            TextStyle boxNormal16 = BoxTheme.INSTANCE.getTypography().getBoxNormal16();
            if (playlistItemState == PlaylistItemState.NOT_ACTIVE) {
                composer.startReplaceGroup(-1989432182);
                ComposerKt.sourceInformation(composer, "116@4825L6");
                jM11533getMainActiveControl0d7_KjU = BoxColorsKt.m11587enabledek8zF_U$default(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), z, 0.0f, 2, null);
            } else {
                composer.startReplaceGroup(-1989430903);
                ComposerKt.sourceInformation(composer, "116@4876L6");
                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
            }
            composer.endReplaceGroup();
            TextKt.m4494TextNvy7gAk(str, null, jM11533getMainActiveControl0d7_KjU, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, boxNormal16, composer, 0, 24960, 110586);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItem$lambda$2(PlaylistItemState playlistItemState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C122@5045L118:PreviewPlaylistScreen.kt#fw1ql1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-818685644, i, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistItem.<anonymous> (PreviewPlaylistScreen.kt:122)");
            }
            IconKt.m3576Iconww6aTOc(toImageVector(playlistItemState), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void PlaylistTopBar(final Store<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action> store, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1556825128);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlaylistTopBar)N(store)136@5529L29,139@5642L59,140@5722L63,141@5830L53,138@5600L289:PreviewPlaylistScreen.kt#fw1ql1");
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
                ComposerKt.traceEventStart(-1556825128, i2, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistTopBar (PreviewPlaylistScreen.kt:135)");
            }
            int size = PlaylistTopBar$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getItems().size();
            String strStringResource = StringResources_androidKt.stringResource(R.string.preview_playlist_screen_title, composerStartRestartGroup, 0);
            String strPluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.num_items, size, new Object[]{Integer.valueOf(size)}, composerStartRestartGroup, 0);
            if (size <= 0) {
                strPluralStringResource = null;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1460315315, "CC(remember):PreviewPlaylistScreen.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreviewPlaylistScreenKt.PlaylistTopBar$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxSimpleTopBarSecondaryKt.BoxSimpleTopBarSecondary(strStringResource, strPluralStringResource, (Function0) objRememberedValue, composerStartRestartGroup, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PlaylistTopBar$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistTopBar$lambda$2$0(Store store) {
        store.send(new PreviewPlaylistReducer.Action.Close(null, 1, null));
        return Unit.INSTANCE;
    }

    private static final ImageVector toImageVector(PlaylistItemState playlistItemState) {
        int i = WhenMappings.$EnumSwitchMapping$0[playlistItemState.ordinal()];
        if (i == 1) {
            return PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault());
        }
        if (i == 2) {
            return PauseKt.getPause(Icons.INSTANCE.getDefault());
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return MusicNoteKt.getMusicNote(Icons.INSTANCE.getDefault());
    }

    private static final void PlaylistItemsContentPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1418655962);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlaylistItemsContentPreview)183@7187L90,183@7178L99:PreviewPlaylistScreen.kt#fw1ql1");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1418655962, i, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistItemsContentPreview (PreviewPlaylistScreen.kt:161)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new FileModel[]{FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), null, "Audio Track 1", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217725, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), FileModel.INSTANCE.createItemId("file-id-2"), "Audio Track 2", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217724, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), FileModel.INSTANCE.createItemId("file-id-3"), "Audio Track 3", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217724, null), FileModel.copy$default(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), FileModel.INSTANCE.createItemId("file-id-4"), "Audio Track 4", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217724, null)});
            FileModel fileModel = (FileModel) listListOf.get(0);
            URI uriCreate = URI.create("temp/path1");
            Intrinsics.checkNotNullExpressionValue(uriCreate, "create(...)");
            FileModel fileModel2 = (FileModel) listListOf.get(1);
            URI uriCreate2 = URI.create("temp/path2");
            Intrinsics.checkNotNullExpressionValue(uriCreate2, "create(...)");
            FileModel fileModel3 = (FileModel) listListOf.get(3);
            URI uriCreate3 = URI.create("temp/path4");
            Intrinsics.checkNotNullExpressionValue(uriCreate3, "create(...)");
            List listListOf2 = CollectionsKt.listOf((Object[]) new AudioItem[]{new AudioItem.Playable(fileModel, uriCreate), new AudioItem.Playable(fileModel2, uriCreate2), new AudioItem.Disabled((FileModel) listListOf.get(2)), new AudioItem.Playable(fileModel3, uriCreate3)});
            final PreviewPlaylistReducer.State state = new PreviewPlaylistReducer.State((FileModel) listListOf.get(0), PreviewSource.Browse.INSTANCE, new PreviewPlaylistReducer.ActivePlaylistItem((AudioItem) listListOf2.get(1), true), listListOf2, null, 16, null);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(150027183, true, new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PlaylistItemsContentPreview$lambda$0(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewPlaylistScreenKt.PlaylistItemsContentPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaylistItemsContentPreview$lambda$0(PreviewPlaylistReducer.State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C184@7197L74:PreviewPlaylistScreen.kt#fw1ql1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(150027183, i, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistItemsContentPreview.<anonymous> (PreviewPlaylistScreen.kt:184)");
            }
            PlaylistItemsContent(ComposePreviewUtilsKt.createMockStore(state), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewPlaylistReducer.State PlaylistItemsContent$lambda$0(State<PreviewPlaylistReducer.State> state) {
        return state.getValue();
    }

    private static final PreviewPlaylistReducer.State PlaylistTopBar$lambda$0(State<PreviewPlaylistReducer.State> state) {
        return state.getValue();
    }
}

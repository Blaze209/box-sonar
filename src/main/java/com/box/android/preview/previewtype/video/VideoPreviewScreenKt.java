package com.box.android.preview.previewtype.video;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.MotionEvent;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.annotations.model.DocumentSize;
import com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt;
import com.box.android.preview.annotations.ui.compose.CreateAnnotationDialogsKt;
import com.box.android.preview.integration.nutrient.BoxBaseDocumentListener;
import com.box.android.preview.integration.nutrient.NutrientPdfViewConfigurator;
import com.box.android.preview.integration.nutrient.NutrientPdfViewKt;
import com.box.android.preview.previewtype.image.ImagePdfFragmentBuilder;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.utils.Size;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001ak\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001aQ\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0003¢\u0006\u0002\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\"X\u008a\u008e\u0002"}, d2 = {"NUTRIENT_LOADING_TIME_MS", "", "VideoPreviewScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "videoPlayerManager", "Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager;", "videoPlayersProvider", "Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "getAnnotationsManager", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "getCreateAnnotationManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "enqueuedAnnotationId", "", "(Lcom/box/android/cpl/Store;Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager;Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/SnackbarHostState;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "VideoAnnotationsOverlay", "uri", "Landroid/net/Uri;", "annotationsManager", "createAnnotationsManager", "onPlayPausedClicked", "Lkotlin/Function0;", "(Landroid/net/Uri;Lcom/box/android/cpl/Store;Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state", "shouldDisplayProgressBar", "", "videoAnnotationState", "showPlayPauseButton"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoPreviewScreenKt {
    private static final int NUTRIENT_LOADING_TIME_MS = 500;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoAnnotationsOverlay$lambda$11(Uri uri, Store store, BoxPdfAnnotationManager boxPdfAnnotationManager, CreateAnnotationsManager createAnnotationsManager, String str, Function0 function0, int i, Composer composer, int i2) {
        VideoAnnotationsOverlay(uri, store, boxPdfAnnotationManager, createAnnotationsManager, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerView VideoPreviewScreen$lambda$5$0$0(PlayerView playerView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return playerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPreviewScreen$lambda$6(Store store, Media3VideoPlayerManager media3VideoPlayerManager, VideoPlayersProvider videoPlayersProvider, Function1 function1, Function1 function2, SnackbarHostState snackbarHostState, String str, int i, Composer composer, int i2) {
        VideoPreviewScreen(store, media3VideoPlayerManager, videoPlayersProvider, function1, function2, snackbarHostState, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void VideoPreviewScreen(final Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> store, final Media3VideoPlayerManager media3VideoPlayerManager, final VideoPlayersProvider videoPlayersProvider, Function1<? super ItemId, BoxPdfAnnotationManager> function1, final Function1<? super ItemId, CreateAnnotationsManager> getCreateAnnotationManager, SnackbarHostState snackbarHostState, final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        boolean z;
        LifecycleOwner lifecycleOwner;
        final Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> store2;
        Media3VideoPlayerManager media3VideoPlayerManager2;
        VideoPlayersProvider videoPlayersProvider2;
        ExoPlayer exoPlayer;
        State state;
        Object obj;
        Composer composer3;
        final ExoPlayer exoPlayer2;
        int i3;
        Composer composer4;
        Composer composer5;
        final Media3VideoPlayerManager videoPlayerManager = media3VideoPlayerManager;
        final VideoPlayersProvider videoPlayersProvider3 = videoPlayersProvider;
        Function1<? super ItemId, BoxPdfAnnotationManager> getAnnotationsManager = function1;
        SnackbarHostState snackbarHostState2 = snackbarHostState;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(videoPlayerManager, "videoPlayerManager");
        Intrinsics.checkNotNullParameter(videoPlayersProvider3, "videoPlayersProvider");
        Intrinsics.checkNotNullParameter(getAnnotationsManager, "getAnnotationsManager");
        Intrinsics.checkNotNullParameter(getCreateAnnotationManager, "getCreateAnnotationManager");
        Intrinsics.checkNotNullParameter(snackbarHostState2, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-889747256);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VideoPreviewScreen)N(store,videoPlayerManager,videoPlayersProvider,getAnnotationsManager,getCreateAnnotationManager,snackbarHostState,enqueuedAnnotationId)79@3726L29,80@3801L7,82@3830L129,86@3997L515,86@3964L548,98@4545L6,99@4610L7,100@4639L383:VideoPreviewScreen.kt#278b2y");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(videoPlayerManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(videoPlayersProvider3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getAnnotationsManager) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(getCreateAnnotationManager) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            Composer composer6 = composerStartRestartGroup;
            composer6.skipToGroupEnd();
            composer2 = composer6;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-889747256, i2, -1, "com.box.android.preview.previewtype.video.VideoPreviewScreen (VideoPreviewScreen.kt:78)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Composer composer7 = composerStartRestartGroup;
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composer7, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer7.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            final LifecycleOwner lifecycleOwner2 = (LifecycleOwner) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer7, -348603511, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            Object objRememberedValue = composer7.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = videoPlayerManager.createPlayer(VideoPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getUrl(), FileModel.INSTANCE.isWatermarked(VideoPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getFile()));
                composer7.updateRememberedValue(objRememberedValue);
            }
            final ExoPlayer exoPlayer3 = (ExoPlayer) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerStart(composer7, -348597781, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            int i4 = i2 & 14;
            boolean zChangedInstance = composer7.changedInstance(videoPlayerManager) | composer7.changedInstance(exoPlayer3) | composer7.changedInstance(lifecycleOwner2) | (i4 == 4) | composer7.changedInstance(videoPlayersProvider3) | composer7.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue2 = composer7.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                z = true;
                objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return VideoPreviewScreenKt.VideoPreviewScreen$lambda$2$0(lifecycleOwner2, store, videoPlayerManager, exoPlayer3, videoPlayersProvider3, stateCollectAsStateWithLifecycle, (DisposableEffectScope) obj2);
                    }
                };
                lifecycleOwner = lifecycleOwner2;
                store2 = store;
                media3VideoPlayerManager2 = videoPlayerManager;
                videoPlayersProvider2 = videoPlayersProvider3;
                exoPlayer = exoPlayer3;
                state = stateCollectAsStateWithLifecycle;
                composer7.updateRememberedValue(objRememberedValue2);
            } else {
                store2 = store;
                state = stateCollectAsStateWithLifecycle;
                exoPlayer = exoPlayer3;
                lifecycleOwner = lifecycleOwner2;
                z = true;
                media3VideoPlayerManager2 = videoPlayerManager;
                videoPlayersProvider2 = videoPlayersProvider3;
            }
            ComposerKt.sourceInformationMarkerEnd(composer7);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer7, 0);
            int iM6868toArgb8_81llA = ColorKt.m6868toArgb8_81llA(BoxTheme.INSTANCE.getColors(composer7, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU());
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer7, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer7.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            Context context = (Context) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composer7, -348577369, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            Object objRememberedValue3 = composer7.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                PlayerView playerView = new PlayerView(context);
                playerView.setEnableComposeSurfaceSyncWorkaround(z);
                exoPlayer.seekTo(VideoPreviewScreen$lambda$0(state).getSeekPosition());
                playerView.setPlayer(exoPlayer);
                media3VideoPlayerManager2.playerViewSetup(store2, playerView);
                playerView.setShutterBackgroundColor(iM6868toArgb8_81llA);
                videoPlayersProvider2.putPlayerView(VideoPreviewScreen$lambda$0(state).getFile().getItemId(), playerView);
                composer7.updateRememberedValue(playerView);
                obj = playerView;
            } else {
                obj = objRememberedValue3;
            }
            final PlayerView playerView2 = (PlayerView) obj;
            ComposerKt.sourceInformationMarkerEnd(composer7);
            if (!VideoPreviewScreen$lambda$0(state).isLoaded()) {
                composer7.startReplaceGroup(2074388698);
                composer3 = composer7;
            } else {
                composer7.startReplaceGroup(2079498645);
                ComposerKt.sourceInformation(composer7, "113@5095L319,113@5084L330,122@5423L2888");
                ComposerKt.sourceInformationMarkerStart(composer7, -348562841, r15);
                boolean z2 = i4 == 4;
                Object objRememberedValue4 = composer7.rememberedValue();
                if (z2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return VideoPreviewScreenKt.VideoPreviewScreen$lambda$4$0(store2);
                        }
                    };
                    composer7.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                Function0 function0Remembered = ComposeUtilsKt.remembered((Function0) objRememberedValue4, composer7, 0);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ExoPlayer exoPlayer4 = exoPlayer;
                ComposerKt.sourceInformationMarkerStart(composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer7, 0));
                CompositionLocalMap currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer7, modifierFillMaxSize$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer7.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer7.startReusableNode();
                if (composer7.getInserting()) {
                    composer7.createNode(constructor);
                } else {
                    composer7.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer7);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer7, -930236399, "C124@5515L14,123@5476L192,130@5759L338,130@5682L415,189@8212L89:VideoPreviewScreen.kt#278b2y");
                ComposerKt.sourceInformationMarkerStart(composer7, -168556521, r15);
                boolean zChangedInstance2 = composer7.changedInstance(playerView2);
                Object objRememberedValue5 = composer7.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return VideoPreviewScreenKt.VideoPreviewScreen$lambda$5$0$0(playerView2, (Context) obj2);
                        }
                    };
                    composer7.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue5, TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "Preview:VideoPreview"), null, composer7, 48, 4);
                List<FileActivityModel.AnnotationModel> annotations = VideoPreviewScreen$lambda$0(state).getFrameAnnotationState().getAnnotations();
                ComposerKt.sourceInformationMarkerStart(composer7, -168548389, r15);
                boolean z3 = ((i2 & 3670016) == 1048576) | (i4 == 4);
                VideoPreviewScreenKt$VideoPreviewScreen$2$2$1 videoPreviewScreenKt$VideoPreviewScreen$2$2$1RememberedValue = composer7.rememberedValue();
                if (z3 || videoPreviewScreenKt$VideoPreviewScreen$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    videoPreviewScreenKt$VideoPreviewScreen$2$2$1RememberedValue = new VideoPreviewScreenKt$VideoPreviewScreen$2$2$1(str, store, null);
                    composer7.updateRememberedValue(videoPreviewScreenKt$VideoPreviewScreen$2$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                EffectsKt.LaunchedEffect(str, annotations, (Function2) videoPreviewScreenKt$VideoPreviewScreen$2$2$1RememberedValue, composer7, (i2 >> 18) & 14);
                FrameAnnotationReducer.State frameAnnotationState = VideoPreviewScreen$lambda$0(state).getFrameAnnotationState();
                if (!frameAnnotationState.isExportingFrame()) {
                    Composer composer8 = composer7;
                    exoPlayer2 = exoPlayer4;
                    i3 = 6;
                    composer8.startReplaceGroup(-935757159);
                    composer4 = composer8;
                } else {
                    composer7.startReplaceGroup(-929575790);
                    ComposerKt.sourceInformation(composer7, "142@6293L70,158@6991L193,158@6970L214");
                    playerView2.hideController();
                    ComposerKt.sourceInformationMarkerStart(composer7, -168531569, r15);
                    Object objRememberedValue6 = composer7.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composer7.updateRememberedValue(objRememberedValue6);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    if (!VideoPreviewScreen$lambda$5$3(mutableState)) {
                        Composer composer9 = composer7;
                        exoPlayer2 = exoPlayer4;
                        composer9.startReplaceGroup(-935757159);
                        composer5 = composer9;
                    } else {
                        composer7.startReplaceGroup(-929380614);
                        ComposerKt.sourceInformation(composer7, "151@6685L123,146@6432L503");
                        Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(TestTagKt.testTag(Modifier.INSTANCE, "FrameLoadingOverlay"), 0.0f, 1, null), Color.m6813copywmQWz5c$default(Color.INSTANCE.m6840getBlack0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer7, -168518972, "CC(remember):VideoPreviewScreen.kt#9igjgp");
                        VideoPreviewScreenKt$VideoPreviewScreen$2$3$1 videoPreviewScreenKt$VideoPreviewScreen$2$3$1RememberedValue = composer7.rememberedValue();
                        if (videoPreviewScreenKt$VideoPreviewScreen$2$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            videoPreviewScreenKt$VideoPreviewScreen$2$3$1RememberedValue = new PointerInputEventHandler() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoPreviewScreen$2$3$1
                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    return Unit.INSTANCE;
                                }
                            };
                            composer7.updateRememberedValue(videoPreviewScreenKt$VideoPreviewScreen$2$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer7);
                        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM589backgroundbw27NRU$default, unit, (PointerInputEventHandler) videoPreviewScreenKt$VideoPreviewScreen$2$3$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer7, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composer7.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer7, modifierPointerInput);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer7.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer7.startReusableNode();
                        if (composer7.getInserting()) {
                            composer7.createNode(constructor2);
                        } else {
                            composer7.useNode();
                        }
                        Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer7);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer7, -40084026, "C155@6857L56:VideoPreviewScreen.kt#278b2y");
                        exoPlayer2 = exoPlayer4;
                        BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), null, 0L, 0L, 0.0f, 0, null, composer7, 0, 126);
                        Composer composer10 = composer7;
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        composer10.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        ComposerKt.sourceInformationMarkerEnd(composer10);
                        composer5 = composer10;
                    }
                    composer5.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer5, -168509110, r15);
                    VideoPreviewScreenKt$VideoPreviewScreen$2$5$1 videoPreviewScreenKt$VideoPreviewScreen$2$5$1RememberedValue = composer5.rememberedValue();
                    if (videoPreviewScreenKt$VideoPreviewScreen$2$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        videoPreviewScreenKt$VideoPreviewScreen$2$5$1RememberedValue = new VideoPreviewScreenKt$VideoPreviewScreen$2$5$1(mutableState, null);
                        composer5.updateRememberedValue(videoPreviewScreenKt$VideoPreviewScreen$2$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    i3 = 6;
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoPreviewScreenKt$VideoPreviewScreen$2$5$1RememberedValue, composer5, 6);
                    composer4 = composer5;
                }
                composer4.endReplaceGroup();
                URI exportedFrameUri = frameAnnotationState.getExportedFrameUri();
                if (exportedFrameUri == null) {
                    composer4.startReplaceGroup(-928543398);
                    composer4.endReplaceGroup();
                    getAnnotationsManager = function1;
                } else {
                    composer4.startReplaceGroup(-928543397);
                    ComposerKt.sourceInformation(composer4, "*167@7345L94,170@7481L89,179@7938L64,173@7587L433,183@8060L125,183@8037L148");
                    playerView2.hideController();
                    ComposerKt.sourceInformationMarkerStart(composer4, -585922738, r15);
                    CreateAnnotationsManager createAnnotationsManagerRememberedValue = composer4.rememberedValue();
                    if (createAnnotationsManagerRememberedValue == Composer.INSTANCE.getEmpty()) {
                        createAnnotationsManagerRememberedValue = getCreateAnnotationManager.invoke(VideoPreviewScreen$lambda$0(state).getFile().getItemId());
                        composer4.updateRememberedValue(createAnnotationsManagerRememberedValue);
                    }
                    CreateAnnotationsManager createAnnotationsManager = (CreateAnnotationsManager) createAnnotationsManagerRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerStart(composer4, -585918391, r15);
                    BoxPdfAnnotationManager boxPdfAnnotationManagerRememberedValue = composer4.rememberedValue();
                    if (boxPdfAnnotationManagerRememberedValue == Composer.INSTANCE.getEmpty()) {
                        getAnnotationsManager = function1;
                        boxPdfAnnotationManagerRememberedValue = getAnnotationsManager.invoke(VideoPreviewScreen$lambda$0(state).getFile().getItemId());
                        composer4.updateRememberedValue(boxPdfAnnotationManagerRememberedValue);
                    } else {
                        getAnnotationsManager = function1;
                    }
                    BoxPdfAnnotationManager boxPdfAnnotationManager = (BoxPdfAnnotationManager) boxPdfAnnotationManagerRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    String string = exportedFrameUri.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    Uri uri = Uri.parse(string);
                    ComposerKt.sourceInformationMarkerStart(composer4, -585903792, r15);
                    boolean zChangedInstance3 = composer4.changedInstance(exoPlayer2);
                    Object objRememberedValue7 = composer4.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return VideoPreviewScreenKt.VideoPreviewScreen$lambda$5$8$2$0(exoPlayer2);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    int i5 = i3;
                    VideoAnnotationsOverlay(uri, store, boxPdfAnnotationManager, createAnnotationsManager, str, (Function0) objRememberedValue7, composer4, ((i2 << 3) & 112) | ((i2 >> 6) & 57344));
                    Unit unit3 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -585899827, r15);
                    boolean zChangedInstance4 = composer4.changedInstance(playerView2);
                    Object objRememberedValue8 = composer4.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return VideoPreviewScreenKt.VideoPreviewScreen$lambda$5$8$3$0(playerView2, (DisposableEffectScope) obj2);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    EffectsKt.DisposableEffect(unit3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue8, composer4, i5);
                    Unit unit4 = Unit.INSTANCE;
                    composer4.endReplaceGroup();
                    Unit unit5 = Unit.INSTANCE;
                }
                snackbarHostState2 = snackbarHostState;
                AnnotationsOverlayKt.AnnotationMessaging((Store) function0Remembered.invoke(), snackbarHostState2, composer4, (i2 >> 12) & 112);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer3 = composer4;
            }
            composer3.endReplaceGroup();
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                composer2 = composer3;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1<? super ItemId, BoxPdfAnnotationManager> function2 = getAnnotationsManager;
            final SnackbarHostState snackbarHostState3 = snackbarHostState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return VideoPreviewScreenKt.VideoPreviewScreen$lambda$6(store, media3VideoPlayerManager, videoPlayersProvider, function2, getCreateAnnotationManager, snackbarHostState3, str, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VideoPreviewScreen$lambda$2$0(final LifecycleOwner lifecycleOwner, Store store, final Media3VideoPlayerManager media3VideoPlayerManager, final ExoPlayer exoPlayer, final VideoPlayersProvider videoPlayersProvider, final State state, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                VideoPreviewScreenKt.VideoPreviewScreen$lambda$2$0$0(media3VideoPlayerManager, exoPlayer, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycleRegistry().addObserver(lifecycleEventObserver);
        store.send(VideoPreviewReducer.Action.Observe.INSTANCE);
        store.send(new VideoPreviewReducer.Action.FrameAnnotation(FrameAnnotationReducer.Action.FetchAnnotations.INSTANCE));
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoPreviewScreen$lambda$2$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                videoPlayersProvider.release(VideoPreviewScreenKt.VideoPreviewScreen$lambda$0(state).getFile().getItemId());
                lifecycleOwner.getLifecycleRegistry().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoPreviewScreen$lambda$2$0$0(Media3VideoPlayerManager media3VideoPlayerManager, ExoPlayer exoPlayer, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        media3VideoPlayerManager.handleLifecycle(exoPlayer, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store VideoPreviewScreen$lambda$4$0(Store store) {
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((VideoPreviewReducer.State) obj).getFrameAnnotationState();
            }
        }, VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$2.INSTANCE).scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FrameAnnotationReducer.State) obj).getAnnotationsState();
            }
        }, VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$4.INSTANCE);
    }

    private static final boolean VideoPreviewScreen$lambda$5$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoPreviewScreen$lambda$5$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPreviewScreen$lambda$5$8$2$0(ExoPlayer exoPlayer) {
        exoPlayer.play();
        return Unit.INSTANCE;
    }

    private static final void VideoAnnotationsOverlay(final Uri uri, Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> store, final BoxPdfAnnotationManager boxPdfAnnotationManager, final CreateAnnotationsManager createAnnotationsManager, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        BoxPdfAnnotationManager boxPdfAnnotationManager2;
        final MutableState mutableState;
        int i3;
        boolean z;
        int i4;
        final Function0 function1;
        int i5;
        final Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> store2 = store;
        Composer composerStartRestartGroup = composer.startRestartGroup(932858330);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VideoAnnotationsOverlay)N(uri,store,annotationsManager,createAnnotationsManager,enqueuedAnnotationId,onPlayPausedClicked)204@8775L7,205@8827L29,208@8962L34,210@9044L395,210@9033L406,222@9482L287,222@9471L298,233@9912L27,234@9965L105,234@9944L126,241@10163L31,238@10076L3785,327@13890L211,327@13867L234:VideoPreviewScreen.kt#278b2y");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(store2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            boxPdfAnnotationManager2 = boxPdfAnnotationManager;
            i2 |= composerStartRestartGroup.changedInstance(boxPdfAnnotationManager2) ? 256 : 128;
        } else {
            boxPdfAnnotationManager2 = boxPdfAnnotationManager;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(createAnnotationsManager) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(932858330, i2, -1, "com.box.android.preview.previewtype.video.VideoAnnotationsOverlay (VideoPreviewScreen.kt:203)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            final FrameAnnotationReducer.State frameAnnotationState = VideoAnnotationsOverlay$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getFrameAnnotationState();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171293252, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171290267, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            int i6 = i2 & 112;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(frameAnnotationState) | (i6 == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$4$0(frameAnnotationState, store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0 function0Remembered = ComposeUtilsKt.remembered((Function0) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171276359, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            boolean z2 = i6 == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$5$0(store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0 function0Remembered2 = ComposeUtilsKt.remembered((Function0) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171262859, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final Animatable animatable = (Animatable) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171261085, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(animatable);
            VideoPreviewScreenKt$VideoAnnotationsOverlay$1$1 videoPreviewScreenKt$VideoAnnotationsOverlay$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || videoPreviewScreenKt$VideoAnnotationsOverlay$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                videoPreviewScreenKt$VideoAnnotationsOverlay$1$1RememberedValue = new VideoPreviewScreenKt$VideoAnnotationsOverlay$1$1(animatable, null);
                composerStartRestartGroup.updateRememberedValue(videoPreviewScreenKt$VideoAnnotationsOverlay$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoPreviewScreenKt$VideoAnnotationsOverlay$1$1RememberedValue, composerStartRestartGroup, 6);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171254823, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(animatable);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$8$0(animatable, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxSize$default, (Function1) objRememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2134811175, "C302@13045L810,295@12739L1116:VideoPreviewScreen.kt#278b2y");
            if (!NutrientPdfViewConfigurator.INSTANCE.isEnvironmentSetUp(context)) {
                mutableState = mutableState2;
                i3 = 32;
                z = false;
                i4 = 6;
                composerStartRestartGroup.startReplaceGroup(2124567906);
            } else {
                composerStartRestartGroup.startReplaceGroup(2134834889);
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@10299L135,248@10471L1565,281@12164L80,278@12050L597,292@12660L59");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -485325145, "CC(remember):VideoPreviewScreen.kt#9igjgp");
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = NutrientPdfViewConfigurator.INSTANCE.createPdfActivityConfiguration(context, PageFitMode.FIT_TO_SCREEN);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                PdfActivityConfiguration pdfActivityConfiguration = (PdfActivityConfiguration) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -485318211, "CC(remember):VideoPreviewScreen.kt#9igjgp");
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    final BoxPdfAnnotationManager boxPdfAnnotationManager3 = boxPdfAnnotationManager2;
                    mutableState = mutableState2;
                    function1 = function0Remembered2;
                    i5 = 32;
                    objRememberedValue7 = new BoxBaseDocumentListener(function1, boxPdfAnnotationManager3, createAnnotationsManager) { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoAnnotationsOverlay$3$documentListener$1$1
                        @Override // com.box.android.preview.integration.nutrient.BoxBaseDocumentListener, com.pspdfkit.listeners.DocumentListener
                        public void onDocumentLoaded(PdfDocument document) {
                            Intrinsics.checkNotNullParameter(document, "document");
                            super.onDocumentLoaded(document);
                            if (str != null) {
                                Size pageSize = document.getPageSize(0);
                                Intrinsics.checkNotNullExpressionValue(pageSize, "getPageSize(...)");
                                store2.send(new VideoPreviewReducer.Action.FrameAnnotation(new FrameAnnotationReducer.Action.DisplayAnnotation(str, new DocumentSize(pageSize.width, pageSize.height))));
                            }
                        }

                        @Override // com.box.android.preview.integration.nutrient.BoxBaseDocumentListener, com.pspdfkit.listeners.DocumentListener
                        public boolean onPageClick(PdfDocument document, int pageIndex, MotionEvent event, PointF pagePosition, Annotation clickedAnnotation) {
                            Intrinsics.checkNotNullParameter(document, "document");
                            super.onPageClick(document, pageIndex, event, pagePosition, clickedAnnotation);
                            MutableState<Boolean> mutableState3 = mutableState;
                            VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$3(mutableState3, !VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$2(mutableState3) && clickedAnnotation == null);
                            return true;
                        }
                    };
                    store2 = store2;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    mutableState = mutableState2;
                    function1 = function0Remembered2;
                    i5 = 32;
                }
                VideoPreviewScreenKt$VideoAnnotationsOverlay$3$documentListener$1$1 videoPreviewScreenKt$VideoAnnotationsOverlay$3$documentListener$1$1 = (VideoPreviewScreenKt$VideoAnnotationsOverlay$3$documentListener$1$1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -485265520, "CC(remember):VideoPreviewScreen.kt#9igjgp");
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new ImagePdfFragmentBuilder(pdfActivityConfiguration);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i7 = i2 << 9;
                int i8 = 113246208 | PdfActivityConfiguration.$stable | ((i2 << 3) & 112) | (PdfActivityConfiguration.$stable << 9) | (458752 & i7) | (i7 & 3670016);
                i4 = 6;
                Function0 function2 = function1;
                i3 = i5;
                z = false;
                NutrientPdfViewKt.NutrientPdfView(pdfActivityConfiguration, uri, null, (ImagePdfFragmentBuilder) objRememberedValue8, videoPreviewScreenKt$VideoAnnotationsOverlay$3$documentListener$1$1, boxPdfAnnotationManager, createAnnotationsManager, null, null, function2, function0Remembered, null, composerStartRestartGroup, i8, 0, 2052);
                composerStartRestartGroup = composerStartRestartGroup;
                CreateAnnotationDialogsKt.CreateAnnotationDialogs((Store) function0Remembered.invoke(), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            Composer composer2 = composerStartRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(VideoAnnotationsOverlay$lambda$2(mutableState), ClipKt.clip(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), RoundedCornerShapeKt.getCircleShape()), EnterExitTransitionKt.expandIn$default(null, Alignment.INSTANCE.getCenter(), false, null, 13, null), EnterExitTransitionKt.shrinkOut$default(null, Alignment.INSTANCE.getCenter(), false, null, 13, null), (String) null, ComposableLambdaKt.rememberComposableLambda(828022968, true, new Function3() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$9$3(function0, store2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 200064, 16);
            composerStartRestartGroup = composer2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171135379, "CC(remember):VideoPreviewScreen.kt#9igjgp");
            boolean z3 = i6 == i3 ? true : z;
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$10$0(store2, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue9, composerStartRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$11(uri, store2, boxPdfAnnotationManager, createAnnotationsManager, str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoAnnotationsOverlay$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoAnnotationsOverlay$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store VideoAnnotationsOverlay$lambda$4$0(FrameAnnotationReducer.State state, Store store) {
        if (state.getCreateAnnotationState() != null) {
            return store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((VideoPreviewReducer.State) obj).getFrameAnnotationState();
                }
            }, VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$2.INSTANCE).ifScope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((FrameAnnotationReducer.State) obj).getCreateAnnotationState();
                }
            }, VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$4.INSTANCE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store VideoAnnotationsOverlay$lambda$5$0(Store store) {
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((VideoPreviewReducer.State) obj).getFrameAnnotationState();
            }
        }, VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$2.INSTANCE).scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FrameAnnotationReducer.State) obj).getAnnotationsState();
            }
        }, VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$4.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoAnnotationsOverlay$lambda$8$0(Animatable animatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(((Number) animatable.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoAnnotationsOverlay$lambda$9$3(final Function0 function0, final Store store, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C304@13097L282,303@13059L786:VideoPreviewScreen.kt#278b2y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(828022968, i, -1, "com.box.android.preview.previewtype.video.VideoAnnotationsOverlay.<anonymous>.<anonymous> (VideoPreviewScreen.kt:303)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1161124434, "CC(remember):VideoPreviewScreen.kt#9igjgp");
        boolean zChanged = composer.changed(function0) | composer.changed(store);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoPreviewScreenKt.VideoAnnotationsOverlay$lambda$9$3$0$0(function0, store);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(72)), RoundedCornerShapeKt.getCircleShape()), Color.m6813copywmQWz5c$default(Color.INSTANCE.m6840getBlack0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$VideoPreviewScreenKt.INSTANCE.getLambda$1691579990$preview_generalProdRelease(), composer, 1572864, 60);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoAnnotationsOverlay$lambda$9$3$0$0(Function0 function0, Store store) {
        function0.invoke();
        store.send(new VideoPreviewReducer.Action.FrameAnnotation(FrameAnnotationReducer.Action.Release.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPreviewReducer.State VideoPreviewScreen$lambda$0(State<VideoPreviewReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VideoPreviewScreen$lambda$5$8$3$0(final PlayerView playerView, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoPreviewScreen$lambda$5$8$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                playerView.showController();
            }
        };
    }

    private static final VideoPreviewReducer.State VideoAnnotationsOverlay$lambda$0(State<VideoPreviewReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult VideoAnnotationsOverlay$lambda$10$0(final Store store, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoAnnotationsOverlay$lambda$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                store.send(new VideoPreviewReducer.Action.FrameAnnotation(FrameAnnotationReducer.Action.Release.INSTANCE));
            }
        };
    }
}

package com.box.android.preview.previewtype.audio;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.common.Tracks;
import androidx.media3.session.MediaController;
import androidx.media3.ui.PlayerControlView;
import com.box.android.base.compose.BoxSizes;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.R;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.preview.PreviewReducerScopingKt;
import com.box.android.preview.previewtype.audio.listener.AudioPlayerCurrentTrackStateListener;
import com.box.android.preview.previewtype.audio.listener.AudioPlayerTrackChangeListener;
import com.box.android.preview.previewtype.audio.model.AudioTrack;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AudioPlayerController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a?\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003¢\u0006\u0002\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0017\u001a\u001f\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003¢\u0006\u0002\u0010\u001b\u001a$\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001a2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u0003H\u0002¨\u0006 ²\u0006\n\u0010!\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002²\u0006\f\u0010\"\u001a\u0004\u0018\u00010#X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"AudioPlayerController", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "getAudioPlayerManager", "Lkotlin/Function0;", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "UpdateCoverArtEffect", "mediaController", "Landroidx/media3/session/MediaController;", "selectedItemId", "Lcom/box/android/domain/models/ItemId;", "onCoverArtChanged", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "(Landroidx/media3/session/MediaController;Lcom/box/android/domain/models/ItemId;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SendActionItemOpenedEffect", "onItemChanged", "(Lcom/box/android/domain/models/ItemId;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RetryPlayingEffect", "needRetryPlaying", "", "(ZLandroidx/media3/session/MediaController;Landroidx/compose/runtime/Composer;I)V", "sendInitialStateInfo", "isPlaying", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "preview_generalProdRelease", "state", "currentAudioTrackListener", "Lcom/box/android/preview/previewtype/audio/listener/AudioPlayerCurrentTrackStateListener;", "audioState"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AudioPlayerControllerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AudioPlayerController$lambda$17(Store store, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AudioPlayerController(store, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AudioPlayerController$lambda$4(Store store, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AudioPlayerController(store, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RetryPlayingEffect$lambda$1(boolean z, MediaController mediaController, int i, Composer composer, int i2) {
        RetryPlayingEffect(z, mediaController, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x033c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0354  */
    /* JADX WARN: Code duplicated, block: B:120:0x0364  */
    /* JADX WARN: Code duplicated, block: B:123:0x037a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0380  */
    /* JADX WARN: Code duplicated, block: B:128:0x038c  */
    /* JADX WARN: Code duplicated, block: B:129:0x039a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:34:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:58:0x010e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0176 A[LOOP:0: B:61:0x0170->B:63:0x0176, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:77:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:80:0x021d  */
    /* JADX WARN: Code duplicated, block: B:83:0x022e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0256  */
    /* JADX WARN: Code duplicated, block: B:86:0x0259  */
    /* JADX WARN: Code duplicated, block: B:93:0x026f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0290  */
    public static final void AudioPlayerController(final Store<PreviewReducer.State, PreviewReducer.Action> store, final Function0<Media3AudioPlayerManager> getAudioPlayerManager, Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final Modifier.Companion companion;
        State stateCollectAsStateWithLifecycle;
        Object objRememberedValue;
        final MutableState mutableState;
        Modifier modifier4;
        Object objRememberedValue2;
        Modifier modifier5;
        Composer composer3;
        Context context;
        ArrayList arrayList;
        int i4;
        boolean z2;
        boolean zChangedInstance;
        AudioPlayerControllerKt$AudioPlayerController$4$1 audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue;
        State state;
        MutableState mutableState2;
        int i5;
        AudioPlayerControllerKt$AudioPlayerController$audioStore$2$1 audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue;
        final Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> storeItemAudioStore;
        Object objRememberedValue3;
        MutableState mutableState3;
        final MutableState mutableState4;
        Composer composer4;
        final MutableState mutableState5;
        int i6;
        Object objRememberedValue4;
        int i7;
        int i8;
        AudioPlayerControllerKt$AudioPlayerController$5$1 audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(getAudioPlayerManager, "getAudioPlayerManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-716791457);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AudioPlayerController)N(store,getAudioPlayerManager,modifier)37@1629L29,38@1686L51,62@2661L7,63@2742L572,63@2673L641,74@3384L35,76@3511L33,113@5114L283,113@5080L317:AudioPlayerController.kt#1vwak5");
        int i9 = (i & 6) == 0 ? (composerStartRestartGroup.changed(store) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(getAudioPlayerManager) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i9 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i3 = i9;
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-716791457, i3, -1, "com.box.android.preview.previewtype.audio.AudioPlayerController (AudioPlayerController.kt:36)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1641814030, "CC(remember):AudioPlayerController.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (AudioPlayerController$lambda$0(stateCollectAsStateWithLifecycle).isPlaylistInitialLoadingInProgress()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AudioPlayerControllerKt.AudioPlayerController$lambda$4(store, getAudioPlayerManager, companion, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    modifier4 = companion;
                    if (AudioPlayerController$lambda$2(mutableState) == null) {
                        composerStartRestartGroup.startReplaceGroup(643762541);
                        composerStartRestartGroup.endReplaceGroup();
                        modifier5 = modifier4;
                        composer3 = composerStartRestartGroup;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(643762542);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*48@2112L356,47@2077L545");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 61144094, "CC(remember):AudioPlayerController.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AudioPlayerControllerKt.AudioPlayerController$lambda$5$0$0(mutableState, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier5 = modifier4;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue2, TestTagKt.testTag(SizeKt.m1252height3ABfNKs(modifier4, BoxSizes.INSTANCE.m11607getAudioPlayerControllerHeightD9Ej5fM()), "Preview:AudioPlayerController"), null, composerStartRestartGroup, 6, 4);
                        composer3 = composerStartRestartGroup;
                        composer3.endReplaceGroup();
                    }
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composer3.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    context = (Context) objConsume;
                    List<AudioTrack> playlist = AudioPlayerController$lambda$0(stateCollectAsStateWithLifecycle).getPlaylist();
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(playlist, 10));
                    for (AudioTrack audioTrack : playlist) {
                        arrayList.add(TuplesKt.to(audioTrack.getFileModel().getItemId(), audioTrack.getUri()));
                    }
                    ArrayList arrayList2 = arrayList;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1641779717, "CC(remember):AudioPlayerController.kt#9igjgp");
                    boolean zChanged = composer3.changed(stateCollectAsStateWithLifecycle);
                    i4 = i3 & 112;
                    if (i4 == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance = zChanged | z2 | composer3.changedInstance(context);
                    audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue = composer3.rememberedValue();
                    if (!zChangedInstance || audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        state = stateCollectAsStateWithLifecycle;
                        mutableState2 = mutableState;
                        i5 = 0;
                        audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue = new AudioPlayerControllerKt$AudioPlayerController$4$1(getAudioPlayerManager, context, state, mutableState2, null);
                        composer3.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue);
                    } else {
                        state = stateCollectAsStateWithLifecycle;
                        mutableState2 = mutableState;
                        i5 = 0;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(arrayList2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue, composer3, i5);
                    AudioPlayerControllerKt$AudioPlayerController$audioStore$1 audioPlayerControllerKt$AudioPlayerController$audioStore$1 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$AudioPlayerController$audioStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((PreviewReducer.State) obj).getPreviewItem();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composer3, -1641759710, "CC(remember):AudioPlayerController.kt#9igjgp");
                    audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue = composer3.rememberedValue();
                    if (audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue = AudioPlayerControllerKt$AudioPlayerController$audioStore$2$1.INSTANCE;
                        composer3.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    storeItemAudioStore = PreviewReducerScopingKt.itemAudioStore(store.scope(audioPlayerControllerKt$AudioPlayerController$audioStore$1, (Function1) ((KFunction) audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue)));
                    ComposerKt.sourceInformationMarkerStart(composer3, -1641755648, "CC(remember):AudioPlayerController.kt#9igjgp");
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState3 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (storeItemAudioStore != null) {
                        composer3.startReplaceGroup(645265887);
                        ComposerKt.sourceInformation(composer3, "78@3644L663,78@3583L724");
                        ItemId selectedItemId = AudioPlayerController$lambda$0(state).getSelectedItemId();
                        MediaController mediaControllerAudioPlayerController$lambda$2 = AudioPlayerController$lambda$2(mutableState2);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1641750762, "CC(remember):AudioPlayerController.kt#9igjgp");
                        int i11 = (composer3.changed(state) ? 1 : 0) | (composer3.changed(storeItemAudioStore) ? 1 : 0);
                        if (i4 == 32) {
                            i7 = 1;
                        } else {
                            i7 = i5;
                        }
                        i8 = i11 | i7;
                        audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue = composer3.rememberedValue();
                        if (i8 == 0 || audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableState6 = mutableState2;
                            mutableState5 = mutableState3;
                            State state2 = state;
                            composer4 = composer3;
                            mutableState4 = mutableState6;
                            state = state2;
                            audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue = new AudioPlayerControllerKt$AudioPlayerController$5$1(storeItemAudioStore, getAudioPlayerManager, mutableState6, mutableState5, state2, null);
                            composer4.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue);
                        } else {
                            mutableState4 = mutableState2;
                            composer4 = composer3;
                            mutableState5 = mutableState3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        EffectsKt.LaunchedEffect(selectedItemId, mediaControllerAudioPlayerController$lambda$2, (Function2) audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue, composer4, i5);
                    } else {
                        mutableState4 = mutableState2;
                        composer4 = composer3;
                        mutableState5 = mutableState3;
                        storeItemAudioStore = storeItemAudioStore;
                        composer4.startReplaceGroup(641697539);
                    }
                    composer4.endReplaceGroup();
                    if (storeItemAudioStore != null || AudioPlayerController$lambda$2(mutableState4) == null) {
                        composer2 = composer4;
                        composer2.startReplaceGroup(641697539);
                    } else {
                        composer4.startReplaceGroup(646055395);
                        ComposerKt.sourceInformation(composer4, "96@4487L54,94@4380L171,103@4774L66,99@4561L289,106@4895L29,107@4933L135");
                        ItemId selectedItemId2 = AudioPlayerController$lambda$0(state).getSelectedItemId();
                        ComposerKt.sourceInformationMarkerStart(composer4, -1641724395, "CC(remember):AudioPlayerController.kt#9igjgp");
                        boolean zChanged2 = composer4.changed(storeItemAudioStore);
                        Object objRememberedValue5 = composer4.rememberedValue();
                        if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return AudioPlayerControllerKt.AudioPlayerController$lambda$13$0(storeItemAudioStore);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        SendActionItemOpenedEffect(selectedItemId2, (Function0) objRememberedValue5, composer4, i5);
                        MediaController mediaControllerAudioPlayerController$lambda$3 = AudioPlayerController$lambda$2(mutableState4);
                        Intrinsics.checkNotNull(mediaControllerAudioPlayerController$lambda$3);
                        ItemId selectedItemId3 = AudioPlayerController$lambda$0(state).getSelectedItemId();
                        ComposerKt.sourceInformationMarkerStart(composer4, -1641715199, "CC(remember):AudioPlayerController.kt#9igjgp");
                        boolean zChanged3 = composer4.changed(storeItemAudioStore);
                        Object objRememberedValue6 = composer4.rememberedValue();
                        if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AudioPlayerControllerKt.AudioPlayerController$lambda$14$0(storeItemAudioStore, (Bitmap) obj);
                                }
                            };
                            composer4.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        UpdateCoverArtEffect(mediaControllerAudioPlayerController$lambda$3, selectedItemId3, (Function1) objRememberedValue6, getAudioPlayerManager, composer4, (i3 << 6) & 7168);
                        Composer composer5 = composer4;
                        composer2 = composer5;
                        RetryPlayingEffect(AudioPlayerController$lambda$15(FlowExtKt.collectAsStateWithLifecycle(storeItemAudioStore.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer5, 0, 7)).getNeedRetryPlaying(), AudioPlayerController$lambda$2(mutableState4), composer2, i5);
                    }
                    composer2.endReplaceGroup();
                    MediaController mediaControllerAudioPlayerController$lambda$4 = AudioPlayerController$lambda$2(mutableState4);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1641704102, "CC(remember):AudioPlayerController.kt#9igjgp");
                    i6 = (i3 & 14) != 4 ? i5 : 1;
                    objRememberedValue4 = composer2.rememberedValue();
                    if (i6 == 0 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AudioPlayerControllerKt.AudioPlayerController$lambda$16$0(store, mutableState4, mutableState5, (DisposableEffectScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.DisposableEffect(mediaControllerAudioPlayerController$lambda$4, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, i5);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            store = store;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Store<PreviewReducer.State, PreviewReducer.Action> store2 = store;
                function2 = new Function2() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AudioPlayerControllerKt.AudioPlayerController$lambda$17(store2, getAudioPlayerManager, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i9 |= 384;
        modifier2 = modifier;
        i3 = i9;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-716791457, i3, -1, "com.box.android.preview.previewtype.audio.AudioPlayerController (AudioPlayerController.kt:36)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1641814030, "CC(remember):AudioPlayerController.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (AudioPlayerController$lambda$0(stateCollectAsStateWithLifecycle).isPlaylistInitialLoadingInProgress()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AudioPlayerControllerKt.AudioPlayerController$lambda$4(store, getAudioPlayerManager, companion, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                modifier4 = companion;
                if (AudioPlayerController$lambda$2(mutableState) == null) {
                    composerStartRestartGroup.startReplaceGroup(643762541);
                    composerStartRestartGroup.endReplaceGroup();
                    modifier5 = modifier4;
                    composer3 = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(643762542);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*48@2112L356,47@2077L545");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 61144094, "CC(remember):AudioPlayerController.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AudioPlayerControllerKt.AudioPlayerController$lambda$5$0$0(mutableState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier5 = modifier4;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue2, TestTagKt.testTag(SizeKt.m1252height3ABfNKs(modifier4, BoxSizes.INSTANCE.m11607getAudioPlayerControllerHeightD9Ej5fM()), "Preview:AudioPlayerController"), null, composerStartRestartGroup, 6, 4);
                    composer3 = composerStartRestartGroup;
                    composer3.endReplaceGroup();
                }
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer3.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                context = (Context) objConsume2;
                List<AudioTrack> playlist2 = AudioPlayerController$lambda$0(stateCollectAsStateWithLifecycle).getPlaylist();
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(playlist2, 10));
                while (r1.hasNext()) {
                    arrayList.add(TuplesKt.to(audioTrack.getFileModel().getItemId(), audioTrack.getUri()));
                }
                ArrayList arrayList3 = arrayList;
                ComposerKt.sourceInformationMarkerStart(composer3, -1641779717, "CC(remember):AudioPlayerController.kt#9igjgp");
                boolean zChanged4 = composer3.changed(stateCollectAsStateWithLifecycle);
                i4 = i3 & 112;
                if (i4 == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = zChanged4 | z2 | composer3.changedInstance(context);
                audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue = composer3.rememberedValue();
                if (zChangedInstance) {
                    state = stateCollectAsStateWithLifecycle;
                    mutableState2 = mutableState;
                    i5 = 0;
                    audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue = new AudioPlayerControllerKt$AudioPlayerController$4$1(getAudioPlayerManager, context, state, mutableState2, null);
                    composer3.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue);
                } else {
                    state = stateCollectAsStateWithLifecycle;
                    mutableState2 = mutableState;
                    i5 = 0;
                    audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue = new AudioPlayerControllerKt$AudioPlayerController$4$1(getAudioPlayerManager, context, state, mutableState2, null);
                    composer3.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(arrayList3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) audioPlayerControllerKt$AudioPlayerController$4$1RememberedValue, composer3, i5);
                AudioPlayerControllerKt$AudioPlayerController$audioStore$1 audioPlayerControllerKt$AudioPlayerController$audioStore$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$AudioPlayerController$audioStore$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((PreviewReducer.State) obj).getPreviewItem();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer3, -1641759710, "CC(remember):AudioPlayerController.kt#9igjgp");
                audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue = composer3.rememberedValue();
                if (audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue = AudioPlayerControllerKt$AudioPlayerController$audioStore$2$1.INSTANCE;
                    composer3.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                storeItemAudioStore = PreviewReducerScopingKt.itemAudioStore(store.scope(audioPlayerControllerKt$AudioPlayerController$audioStore$2, (Function1) ((KFunction) audioPlayerControllerKt$AudioPlayerController$audioStore$2$1RememberedValue)));
                ComposerKt.sourceInformationMarkerStart(composer3, -1641755648, "CC(remember):AudioPlayerController.kt#9igjgp");
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                mutableState3 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (storeItemAudioStore != null) {
                    composer3.startReplaceGroup(645265887);
                    ComposerKt.sourceInformation(composer3, "78@3644L663,78@3583L724");
                    ItemId selectedItemId4 = AudioPlayerController$lambda$0(state).getSelectedItemId();
                    MediaController mediaControllerAudioPlayerController$lambda$5 = AudioPlayerController$lambda$2(mutableState2);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1641750762, "CC(remember):AudioPlayerController.kt#9igjgp");
                    int i12 = (composer3.changed(state) ? 1 : 0) | (composer3.changed(storeItemAudioStore) ? 1 : 0);
                    if (i4 == 32) {
                        i7 = 1;
                    } else {
                        i7 = i5;
                    }
                    i8 = i12 | i7;
                    audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue = composer3.rememberedValue();
                    if (i8 == 0) {
                        MutableState mutableState7 = mutableState2;
                        mutableState5 = mutableState3;
                        State state3 = state;
                        composer4 = composer3;
                        mutableState4 = mutableState7;
                        state = state3;
                        audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue = new AudioPlayerControllerKt$AudioPlayerController$5$1(storeItemAudioStore, getAudioPlayerManager, mutableState7, mutableState5, state3, null);
                        composer4.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue);
                    } else {
                        MutableState mutableState8 = mutableState2;
                        mutableState5 = mutableState3;
                        State state4 = state;
                        composer4 = composer3;
                        mutableState4 = mutableState8;
                        state = state4;
                        audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue = new AudioPlayerControllerKt$AudioPlayerController$5$1(storeItemAudioStore, getAudioPlayerManager, mutableState8, mutableState5, state4, null);
                        composer4.updateRememberedValue(audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    EffectsKt.LaunchedEffect(selectedItemId4, mediaControllerAudioPlayerController$lambda$5, (Function2) audioPlayerControllerKt$AudioPlayerController$5$1RememberedValue, composer4, i5);
                } else {
                    mutableState4 = mutableState2;
                    composer4 = composer3;
                    mutableState5 = mutableState3;
                    storeItemAudioStore = storeItemAudioStore;
                    composer4.startReplaceGroup(641697539);
                }
                composer4.endReplaceGroup();
                if (storeItemAudioStore != null) {
                    composer2 = composer4;
                    composer2.startReplaceGroup(641697539);
                } else {
                    composer2 = composer4;
                    composer2.startReplaceGroup(641697539);
                }
                composer2.endReplaceGroup();
                MediaController mediaControllerAudioPlayerController$lambda$6 = AudioPlayerController$lambda$2(mutableState4);
                ComposerKt.sourceInformationMarkerStart(composer2, -1641704102, "CC(remember):AudioPlayerController.kt#9igjgp");
                if ((i3 & 14) != 4) {
                }
                objRememberedValue4 = composer2.rememberedValue();
                if (i6 == 0) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AudioPlayerControllerKt.AudioPlayerController$lambda$16$0(store, mutableState4, mutableState5, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AudioPlayerControllerKt.AudioPlayerController$lambda$16$0(store, mutableState4, mutableState5, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.DisposableEffect(mediaControllerAudioPlayerController$lambda$6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, i5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        store = store;
        composer2 = composerStartRestartGroup;
        composer2.skipToGroupEnd();
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Store store3 = store;
            function2 = new Function2() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioPlayerControllerKt.AudioPlayerController$lambda$17(store3, getAudioPlayerManager, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MediaController AudioPlayerController$lambda$2(MutableState<MediaController> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerControlView AudioPlayerController$lambda$5$0$0(MutableState mutableState, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View rootView = LayoutInflater.from(context).inflate(R.layout.preview_audio_player_controller, (ViewGroup) null, false).getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type androidx.media3.ui.PlayerControlView");
        PlayerControlView playerControlView = (PlayerControlView) rootView;
        playerControlView.setPlayer(AudioPlayerController$lambda$2(mutableState));
        return playerControlView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioPlayerCurrentTrackStateListener AudioPlayerController$lambda$10(MutableState<AudioPlayerCurrentTrackStateListener> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AudioPlayerController$lambda$13$0(Store store) {
        store.send(AudioPreviewReducer.Action.Opened.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AudioPlayerController$lambda$14$0(Store store, Bitmap it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new AudioPreviewReducer.Action.UpdateCoverArt(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult AudioPlayerController$lambda$16$0(Store store, final MutableState mutableState, final MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final AudioPlayerTrackChangeListener audioPlayerTrackChangeListener = new AudioPlayerTrackChangeListener(store);
        MediaController mediaControllerAudioPlayerController$lambda$2 = AudioPlayerController$lambda$2(mutableState);
        if (mediaControllerAudioPlayerController$lambda$2 != null) {
            mediaControllerAudioPlayerController$lambda$2.addListener(audioPlayerTrackChangeListener);
        }
        return new DisposableEffectResult() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$AudioPlayerController$lambda$16$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                MediaController mediaControllerAudioPlayerController$lambda$3;
                MediaController mediaControllerAudioPlayerController$lambda$4 = AudioPlayerControllerKt.AudioPlayerController$lambda$2(mutableState);
                if (mediaControllerAudioPlayerController$lambda$4 != null) {
                    mediaControllerAudioPlayerController$lambda$4.removeListener(audioPlayerTrackChangeListener);
                }
                AudioPlayerCurrentTrackStateListener audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$10 = AudioPlayerControllerKt.AudioPlayerController$lambda$10(mutableState2);
                if (audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$10 == null || (mediaControllerAudioPlayerController$lambda$3 = AudioPlayerControllerKt.AudioPlayerController$lambda$2(mutableState)) == null) {
                    return;
                }
                mediaControllerAudioPlayerController$lambda$3.removeListener(audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$10);
            }
        };
    }

    private static final void UpdateCoverArtEffect(MediaController mediaController, ItemId itemId, Function1<? super Bitmap, Unit> function1, Function0<Media3AudioPlayerManager> function0, Composer composer, int i) {
        ItemId itemId2;
        ComposerKt.sourceInformationMarkerStart(composer, -814436335, "C(UpdateCoverArtEffect)N(mediaController,selectedItemId,onCoverArtChanged,getAudioPlayerManager)135@5790L320,135@5728L382:AudioPlayerController.kt#1vwak5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-814436335, i, -1, "com.box.android.preview.previewtype.audio.UpdateCoverArtEffect (AudioPlayerController.kt:134)");
        }
        Tracks currentTracks = mediaController.getCurrentTracks();
        ComposerKt.sourceInformationMarkerStart(composer, -989261391, "CC(remember):AudioPlayerController.kt#9igjgp");
        boolean zChangedInstance = ((((i & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i & 3072) == 2048) | composer.changedInstance(itemId) | composer.changedInstance(mediaController) | ((((i & 896) ^ 384) > 256 && composer.changed(function1)) || (i & 384) == 256);
        AudioPlayerControllerKt$UpdateCoverArtEffect$1$1 audioPlayerControllerKt$UpdateCoverArtEffect$1$1RememberedValue = composer.rememberedValue();
        if (zChangedInstance || audioPlayerControllerKt$UpdateCoverArtEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            itemId2 = itemId;
            audioPlayerControllerKt$UpdateCoverArtEffect$1$1RememberedValue = new AudioPlayerControllerKt$UpdateCoverArtEffect$1$1(function0, itemId2, mediaController, function1, null);
            composer.updateRememberedValue(audioPlayerControllerKt$UpdateCoverArtEffect$1$1RememberedValue);
        } else {
            itemId2 = itemId;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(currentTracks, itemId2, (Function2) audioPlayerControllerKt$UpdateCoverArtEffect$1$1RememberedValue, composer, i & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    private static final void SendActionItemOpenedEffect(ItemId itemId, Function0<Unit> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1091659601, "C(SendActionItemOpenedEffect)N(selectedItemId,onItemChanged)151@6351L31,151@6320L62:AudioPlayerController.kt#1vwak5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1091659601, i, -1, "com.box.android.preview.previewtype.audio.SendActionItemOpenedEffect (AudioPlayerController.kt:150)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1112852498, "CC(remember):AudioPlayerController.kt#9igjgp");
        boolean z = (((i & 112) ^ 48) > 32 && composer.changed(function0)) || (i & 48) == 32;
        AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1 audioPlayerControllerKt$SendActionItemOpenedEffect$1$1RememberedValue = composer.rememberedValue();
        if (z || audioPlayerControllerKt$SendActionItemOpenedEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            audioPlayerControllerKt$SendActionItemOpenedEffect$1$1RememberedValue = new AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1(function0, null);
            composer.updateRememberedValue(audioPlayerControllerKt$SendActionItemOpenedEffect$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(itemId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) audioPlayerControllerKt$SendActionItemOpenedEffect$1$1RememberedValue, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    private static final void RetryPlayingEffect(final boolean z, final MediaController mediaController, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1122575871);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RetryPlayingEffect)N(needRetryPlaying,mediaController)158@6537L149,158@6497L189:AudioPlayerController.kt#1vwak5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(mediaController) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1122575871, i2, -1, "com.box.android.preview.previewtype.audio.RetryPlayingEffect (AudioPlayerController.kt:157)");
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 758625076, "CC(remember):AudioPlayerController.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(mediaController) | (i3 == 4);
            AudioPlayerControllerKt$RetryPlayingEffect$1$1 audioPlayerControllerKt$RetryPlayingEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || audioPlayerControllerKt$RetryPlayingEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                audioPlayerControllerKt$RetryPlayingEffect$1$1RememberedValue = new AudioPlayerControllerKt$RetryPlayingEffect$1$1(z, mediaController, null);
                composerStartRestartGroup.updateRememberedValue(audioPlayerControllerKt$RetryPlayingEffect$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) audioPlayerControllerKt$RetryPlayingEffect$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AudioPlayerControllerKt.RetryPlayingEffect$lambda$1(z, mediaController, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendInitialStateInfo(boolean z, Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> store) {
        if (z) {
            store.send(AudioPreviewReducer.Action.Playing.INSTANCE);
        } else {
            store.send(AudioPreviewReducer.Action.Paused.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewReducer.State AudioPlayerController$lambda$0(State<PreviewReducer.State> state) {
        return state.getValue();
    }

    private static final AudioPreviewReducer.State AudioPlayerController$lambda$15(State<AudioPreviewReducer.State> state) {
        return state.getValue();
    }
}

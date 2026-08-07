package com.box.android.preview.previewtype.audio.playlist;

import android.content.Intent;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: PreviewPlaylistActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PlaylistActivityContent;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$State;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/box/android/cpl/Store;Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;)V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaylistActivityContent {
    public static final int $stable = 0;

    public PlaylistActivityContent(final FragmentActivity activity, final Store<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action> store, final Media3AudioPlayerManager audioPlayerManager) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(audioPlayerManager, "audioPlayerManager");
        StoreKt.observe(store, new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.audio.playlist.PlaylistActivityContent.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewPlaylistReducer.State) obj).getCloseRoute();
            }
        }, LifecycleOwnerKt.getLifecycleScope(activity), new Function1() { // from class: com.box.android.preview.previewtype.audio.playlist.PlaylistActivityContent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaylistActivityContent._init_$lambda$0(activity, (PreviewPlaylistReducer.Close) obj);
            }
        });
        ComponentActivityKt.setContent$default(activity, null, ComposableLambdaKt.composableLambdaInstance(1088180259, true, new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PlaylistActivityContent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaylistActivityContent._init_$lambda$1(store, audioPlayerManager, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        store.send(PreviewPlaylistReducer.Action.Fetch.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(FragmentActivity fragmentActivity, PreviewPlaylistReducer.Close close) {
        Intent intent;
        if (close != null) {
            FileModel itemModel = close.getItemModel();
            if (itemModel != null) {
                intent = new Intent();
                intent.putExtra(PreviewPlaylistActivity.RESULT_SELECTED_PLAYLIST_ITEM_MODEL, itemModel);
            } else {
                intent = null;
            }
            fragmentActivity.setResult(-1, intent);
            fragmentActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(final Store store, final Media3AudioPlayerManager media3AudioPlayerManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C75@3238L80,75@3229L89:PreviewPlaylistActivity.kt#fw1ql1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1088180259, i, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistActivityContent.<anonymous> (PreviewPlaylistActivity.kt:75)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(424332088, true, new Function2() { // from class: com.box.android.preview.previewtype.audio.playlist.PlaylistActivityContent$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlaylistActivityContent.lambda$1$0(store, media3AudioPlayerManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$1$0(Store store, Media3AudioPlayerManager media3AudioPlayerManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C76@3256L48:PreviewPlaylistActivity.kt#fw1ql1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424332088, i, -1, "com.box.android.preview.previewtype.audio.playlist.PlaylistActivityContent.<anonymous>.<anonymous> (PreviewPlaylistActivity.kt:76)");
            }
            PreviewPlaylistScreenKt.PreviewPlaylistScreen(store, media3AudioPlayerManager, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

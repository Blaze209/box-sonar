package com.box.android.preview.previewtype.video;

import androidx.media3.common.Player;
import androidx.media3.ui.PlayerView;
import com.box.android.domain.models.ItemId;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPlayersProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "", "<init>", "()V", "itemIdToPlayerView", "", "Lcom/box/android/domain/models/ItemId;", "Landroidx/media3/ui/PlayerView;", "putPlayerView", "", "itemId", "playerView", "getPlayerView", "getPlayer", "Landroidx/media3/common/Player;", "release", "releaseAll", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoPlayersProvider {
    public static final int $stable = 8;
    private final Map<ItemId, PlayerView> itemIdToPlayerView = new LinkedHashMap();

    @Inject
    public VideoPlayersProvider() {
    }

    public final void putPlayerView(ItemId itemId, PlayerView playerView) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        release(itemId);
        this.itemIdToPlayerView.put(itemId, playerView);
    }

    public final PlayerView getPlayerView(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return this.itemIdToPlayerView.get(itemId);
    }

    public final Player getPlayer(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        PlayerView playerView = this.itemIdToPlayerView.get(itemId);
        if (playerView != null) {
            return playerView.getPlayer();
        }
        return null;
    }

    public final void release(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        PlayerView playerViewRemove = this.itemIdToPlayerView.remove(itemId);
        Player player = playerViewRemove != null ? playerViewRemove.getPlayer() : null;
        if (player != null) {
            player.release();
        }
    }

    public final void releaseAll() {
        Iterator it = CollectionsKt.toSet(this.itemIdToPlayerView.keySet()).iterator();
        while (it.hasNext()) {
            release((ItemId) it.next());
        }
    }
}

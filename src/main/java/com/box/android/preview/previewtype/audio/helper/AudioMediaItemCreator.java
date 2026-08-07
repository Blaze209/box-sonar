package com.box.android.preview.previewtype.audio.helper;

import androidx.media3.common.MediaItem;
import com.box.android.domain.models.item.FileModel;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioMediaItemCreator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/previewtype/audio/helper/AudioMediaItemCreator;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/media3/common/MediaItem;", "uri", "Ljava/net/URI;", "file", "Lcom/box/android/domain/models/item/FileModel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioMediaItemCreator {
    public static final int $stable = 0;

    @Inject
    public AudioMediaItemCreator() {
    }

    public final MediaItem create(URI uri, FileModel file) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(file, "file");
        MediaItem mediaItemBuild = new MediaItem.Builder().setUri(uri.toString()).setMediaId(file.getItemId().toString()).build();
        Intrinsics.checkNotNullExpressionValue(mediaItemBuild, "build(...)");
        MediaItem mediaItemBuild2 = mediaItemBuild.buildUpon().setMediaMetadata(mediaItemBuild.mediaMetadata.buildUpon().setTitle(file.getName()).build()).build();
        Intrinsics.checkNotNullExpressionValue(mediaItemBuild2, "build(...)");
        return mediaItemBuild2;
    }
}

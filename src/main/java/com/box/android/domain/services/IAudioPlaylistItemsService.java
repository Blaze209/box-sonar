package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IAudioPlaylistItemsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ0\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "", "fetchAudioPlaylistItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/services/AudioItem;", "Lcom/box/android/domain/models/DomainError;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "isAudioPlaylistAvailable", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAudioPlaylistItemsService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Flow<Result<List<AudioItem>, DomainError>> fetchAudioPlaylistItems(FileModel fileModel, PreviewSource previewSource);

    boolean isAudioPlaylistAvailable(FileModel fileModel, PreviewSource previewSource);

    /* JADX INFO: compiled from: IAudioPlaylistItemsService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/domain/services/IAudioPlaylistItemsService$Companion;", "", "<init>", "()V", "PREVIEW_SOURCES_PLAYLIST_NOT_ALLOWED", "", "Lcom/box/android/domain/models/preview/PreviewSource;", "getPREVIEW_SOURCES_PLAYLIST_NOT_ALLOWED", "()Ljava/util/List;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final List<PreviewSource> PREVIEW_SOURCES_PLAYLIST_NOT_ALLOWED = CollectionsKt.listOf((Object[]) new PreviewSource[]{PreviewSource.Collection.INSTANCE, PreviewSource.Favorites.INSTANCE, PreviewSource.Transfers.INSTANCE});

        private Companion() {
        }

        public final List<PreviewSource> getPREVIEW_SOURCES_PLAYLIST_NOT_ALLOWED() {
            return PREVIEW_SOURCES_PLAYLIST_NOT_ALLOWED;
        }
    }
}

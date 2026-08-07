package com.box.android.domain.services;

import android.graphics.Bitmap;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import java.io.File;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: compiled from: IThumbnailService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ,\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0007H&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IThumbnailService;", "", "getThumbnail", "Landroid/graphics/Bitmap;", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "isLargeThumbnailNeeded", "", "loadFromCacheOnly", "(Lcom/box/androidsdk/content/models/BoxFile;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnailFileModel", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBestThumbnail", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnailFile", "Ljava/io/File;", "isLargeThumbnail", "isRepresentationThumbnailAvailable", "item", "Lcom/box/androidsdk/content/models/BoxItem;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IThumbnailService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Object getBestThumbnail(FileModel fileModel, Continuation<? super Bitmap> continuation);

    @Deprecated(message = "Use getThumbnailFileModel instead")
    Object getThumbnail(BoxFile boxFile, boolean z, boolean z2, Continuation<? super Bitmap> continuation);

    File getThumbnailFile(BoxFile boxFile, boolean isLargeThumbnail);

    Object getThumbnailFileModel(FileModel fileModel, boolean z, boolean z2, Continuation<? super Bitmap> continuation);

    boolean isRepresentationThumbnailAvailable(BoxItem item);

    /* JADX INFO: compiled from: IThumbnailService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getThumbnail$default(IThumbnailService iThumbnailService, BoxFile boxFile, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbnail");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return iThumbnailService.getThumbnail(boxFile, z, z2, continuation);
    }

    static /* synthetic */ Object getThumbnailFileModel$default(IThumbnailService iThumbnailService, FileModel fileModel, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbnailFileModel");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return iThumbnailService.getThumbnailFileModel(fileModel, z, z2, continuation);
    }

    static /* synthetic */ File getThumbnailFile$default(IThumbnailService iThumbnailService, BoxFile boxFile, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbnailFile");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return iThumbnailService.getThumbnailFile(boxFile, z);
    }

    /* JADX INFO: compiled from: IThumbnailService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/domain/services/IThumbnailService$Companion;", "", "<init>", "()V", "REP_SUPPORTED_THUMBNAIL_EXTENSIONS", "", "", "getREP_SUPPORTED_THUMBNAIL_EXTENSIONS", "()Ljava/util/Set;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<String> REP_SUPPORTED_THUMBNAIL_EXTENSIONS;

        private Companion() {
        }

        public final Set<String> getREP_SUPPORTED_THUMBNAIL_EXTENSIONS() {
            return REP_SUPPORTED_THUMBNAIL_EXTENSIONS;
        }

        static {
            SpreadBuilder spreadBuilder = new SpreadBuilder(17);
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getIMAGE_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getVECTOR_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.add(SupportedFileExtensions.AI_EXTENSION);
            spreadBuilder.add(SupportedFileExtensions.PSD_EXTENSION);
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getVIDEO_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getDOCUMENT_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getIWORK_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getPRESENTATION_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getSPREADSHEET_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getMICROSOFT_EXCEL_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getMICROSOFT_POWERPOINT_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getMICROSOFT_WORD_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.add(SupportedFileExtensions.DWG_EXTENSION);
            spreadBuilder.addSpread(SupportedFileExtensions.INSTANCE.getINDESIGN_EXTENSIONS().toArray(new String[0]));
            spreadBuilder.add(SupportedFileExtensions.XBD_EXTENSION);
            spreadBuilder.add(SupportedFileExtensions.XDW_EXTENSION);
            spreadBuilder.add(SupportedFileExtensions.GIF_EXTENSION);
            REP_SUPPORTED_THUMBNAIL_EXTENSIONS = SetsKt.setOf(spreadBuilder.toArray(new String[spreadBuilder.size()]));
        }
    }
}

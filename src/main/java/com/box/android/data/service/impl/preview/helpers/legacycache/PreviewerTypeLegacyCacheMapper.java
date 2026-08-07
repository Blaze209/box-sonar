package com.box.android.data.service.impl.preview.helpers.legacycache;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.utils.SupportedFileExtensions;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewerTypeLegacyCacheMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewerTypeLegacyCacheMapper;", "", "<init>", "()V", "getPreviewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewerTypeLegacyCacheMapper {
    @Inject
    public PreviewerTypeLegacyCacheMapper() {
    }

    public final PreviewerType getPreviewerType(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        String extension = fileModel.getExtension();
        if (SupportedFileExtensions.INSTANCE.isImageExtension(extension) || SupportedFileExtensions.INSTANCE.isVectorExtension(extension) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(extension) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(extension)) {
            return PreviewerType.Image;
        }
        if (SupportedFileExtensions.INSTANCE.isGifExtension(extension)) {
            return PreviewerType.GIF;
        }
        if (SupportedFileExtensions.INSTANCE.isVideoExtension(extension)) {
            return PreviewerType.Video;
        }
        if (SupportedFileExtensions.INSTANCE.isCodeExtension(extension)) {
            return PreviewerType.Code;
        }
        return SupportedFileExtensions.INSTANCE.isAudioExtension(extension) ? PreviewerType.Audio : PreviewerType.PDF;
    }
}

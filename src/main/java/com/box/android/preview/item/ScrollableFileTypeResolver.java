package com.box.android.preview.item;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.ScrollableFileType;
import com.box.android.domain.utils.SupportedFileExtensions;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollableFileTypeResolver.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/preview/item/ScrollableFileTypeResolver;", "Lcom/box/android/preview/item/IScrollableFileTypeResolver;", "<init>", "()V", "getScrollableFileType", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScrollableFileTypeResolver implements IScrollableFileTypeResolver {
    public static final int $stable = 0;

    @Inject
    public ScrollableFileTypeResolver() {
    }

    @Override // com.box.android.preview.item.IScrollableFileTypeResolver
    public ScrollableFileType getScrollableFileType(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        String fileExtension = CommonBoxUtil.getFileExtension(fileModel.getName(), "");
        if (SupportedFileExtensions.INSTANCE.isMicrosoftPowerPointExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isPresentationExtension(fileExtension)) {
            return ScrollableFileType.POWERPOINT;
        }
        return SupportedFileExtensions.INSTANCE.isMicrosoftWordExtension(fileExtension) ? ScrollableFileType.WORD : ScrollableFileType.PDF;
    }
}

package com.box.android.data.service.impl.preview;

import com.box.android.common.extensions.ListExtensionsKt;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.ThrowableDomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.preview.PreviewerMapping;
import com.box.android.domain.preview.PreviewerTypeResolver;
import com.box.androidsdk.content.models.BoxFile;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewerMappingsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\u00020\u0013*\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/service/impl/preview/PreviewerMappingsService;", "", "previewerTypeResolver", "Lcom/box/android/domain/preview/PreviewerTypeResolver;", "<init>", "(Lcom/box/android/domain/preview/PreviewerTypeResolver;)V", "resolveMappings", "", "Lcom/box/android/domain/preview/PreviewerMapping;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/domain/models/RepresentationModel;", "representationsFetchError", "Lcom/box/android/domain/models/DomainError;", "resolveLocalPreview", "fileExtension", "", "isWatermarked", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewerMappingsService {
    private final PreviewerTypeResolver previewerTypeResolver;

    @Inject
    public PreviewerMappingsService(PreviewerTypeResolver previewerTypeResolver) {
        Intrinsics.checkNotNullParameter(previewerTypeResolver, "previewerTypeResolver");
        this.previewerTypeResolver = previewerTypeResolver;
    }

    public final List<PreviewerMapping> resolveMappings(FileModel fileModel, List<RepresentationModel> representations, DomainError representationsFetchError) throws ThrowableDomainError {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(representations, "representations");
        String extension = fileModel.getExtension();
        List<PreviewerMapping> listFilterIf = ListExtensionsKt.filterIf(this.previewerTypeResolver.preferredPreviewers(extension, representations), isWatermarked(fileModel), new Function1() { // from class: com.box.android.data.service.impl.preview.PreviewerMappingsService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PreviewerMappingsService.resolveMappings$lambda$0((PreviewerMapping) obj));
            }
        });
        if (representationsFetchError != null && listFilterIf.isEmpty()) {
            throw new ThrowableDomainError(representationsFetchError);
        }
        if (listFilterIf.isEmpty()) {
            throw new ThrowableDomainError(new FilePreviewDomainError.NotSupportedTypeError("Preview is not supported for this file. File extension: " + extension));
        }
        return listFilterIf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resolveMappings$lambda$0(PreviewerMapping it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.getContent(), PreviewContentType.Original.INSTANCE);
    }

    public final PreviewerMapping resolveLocalPreview(String fileExtension) {
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        return (PreviewerMapping) CollectionsKt.firstOrNull((List) this.previewerTypeResolver.preferredPreviewers(fileExtension, CollectionsKt.emptyList()));
    }

    private final boolean isWatermarked(FileModel fileModel) {
        WatermarkModel watermark = fileModel.getWatermark();
        return watermark != null && watermark.isWatermarked();
    }
}

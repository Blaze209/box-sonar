package com.box.android.data.mappers.representations;

import com.box.android.data.api.models.RepresentationDTO;
import com.box.android.data.api.models.RepresentationInfoDTO;
import com.box.android.data.mappers.RepresentationToDomainUtilsKt;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationPropertiesModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/representations/RepresentationDTODomainMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/RepresentationModel;", "Lcom/box/android/data/api/models/RepresentationDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RepresentationDTODomainMapper {
    public static final RepresentationDTODomainMapper INSTANCE = new RepresentationDTODomainMapper();

    private RepresentationDTODomainMapper() {
    }

    public final RepresentationModel toDomain(RepresentationDTO representationDTO) {
        String url;
        Intrinsics.checkNotNullParameter(representationDTO, "<this>");
        String urlTemplate = representationDTO.getContent().getUrlTemplate();
        RepresentationInfoDTO info = representationDTO.getInfo();
        if (info == null || (url = info.getUrl()) == null) {
            url = "";
        }
        return new RepresentationModel(urlTemplate, url, new RepresentationPropertiesModel(representationDTO.getProperties().getDimensions(), Boolean.parseBoolean(representationDTO.getProperties().isPaged()), Boolean.parseBoolean(representationDTO.getProperties().isThumbnail())), RepresentationToDomainUtilsKt.toDomain(representationDTO.getRepresentationType()), RepresentationToDomainUtilsKt.toDomain(representationDTO.getStatus()));
    }
}

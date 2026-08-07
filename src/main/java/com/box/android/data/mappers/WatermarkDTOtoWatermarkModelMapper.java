package com.box.android.data.mappers;

import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.domain.models.item.WatermarkModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkDTOtoWatermarkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/WatermarkDTOtoWatermarkModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/WatermarkModel;", "Lcom/box/android/data/api/models/WatermarkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WatermarkDTOtoWatermarkModelMapper {
    public static final WatermarkDTOtoWatermarkModelMapper INSTANCE = new WatermarkDTOtoWatermarkModelMapper();

    private WatermarkDTOtoWatermarkModelMapper() {
    }

    public final WatermarkModel toDomain(WatermarkDTO watermarkDTO) {
        Intrinsics.checkNotNullParameter(watermarkDTO, "<this>");
        return new WatermarkModel(watermarkDTO.isWatermarked(), watermarkDTO.isWatermarkInherited(), watermarkDTO.isWatermarkedByAccessPolicy());
    }
}

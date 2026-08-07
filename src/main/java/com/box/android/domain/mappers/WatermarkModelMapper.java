package com.box.android.domain.mappers;

import com.box.android.domain.models.item.WatermarkModel;
import com.box.androidsdk.content.models.BoxWatermark;
import com.eclipsesource.json.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\b*\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/box/android/domain/mappers/WatermarkModelMapper;", "", "<init>", "()V", "toWatermarkModel", "Lcom/box/android/domain/models/item/WatermarkModel;", "Lcom/box/androidsdk/content/models/BoxWatermark;", "toJsonObject", "Lcom/eclipsesource/json/JsonObject;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WatermarkModelMapper {
    public static final WatermarkModelMapper INSTANCE = new WatermarkModelMapper();

    private WatermarkModelMapper() {
    }

    public final WatermarkModel toWatermarkModel(BoxWatermark boxWatermark) {
        Intrinsics.checkNotNullParameter(boxWatermark, "<this>");
        return new WatermarkModel(boxWatermark.getIsWatermarked(), false, false, 6, null);
    }

    public final JsonObject toJsonObject(WatermarkModel watermarkModel) {
        Intrinsics.checkNotNullParameter(watermarkModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(BoxWatermark.FIELD_IS_WATERMARKED, watermarkModel.isWatermarked());
        jsonObject.add(BoxWatermark.FIELD_IS_WATERMARK_INHERITED, watermarkModel.isWatermarkInherited());
        jsonObject.add(BoxWatermark.FIELD_IS_WATERMARKED_BY_ACCESS_POLICY, watermarkModel.isWatermarkedByAccessPolicy());
        return jsonObject;
    }
}

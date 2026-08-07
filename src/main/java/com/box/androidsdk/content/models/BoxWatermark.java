package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxWatermark.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/androidsdk/content/models/BoxWatermark;", "Lcom/box/androidsdk/content/models/BoxJsonObject;", "jsonObject", "Lcom/eclipsesource/json/JsonObject;", "<init>", "(Lcom/eclipsesource/json/JsonObject;)V", "getIsWatermarked", "", "toString", "", "Companion", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxWatermark extends BoxJsonObject {
    public static final String FIELD_IS_WATERMARKED = "is_watermarked";
    public static final String FIELD_IS_WATERMARKED_BY_ACCESS_POLICY = "is_watermarked_by_access_policy";
    public static final String FIELD_IS_WATERMARK_INHERITED = "is_watermark_inherited";

    /* JADX WARN: Multi-variable type inference failed */
    public BoxWatermark() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BoxWatermark(JsonObject jsonObject) {
        super(jsonObject);
    }

    public /* synthetic */ BoxWatermark(JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new JsonObject() : jsonObject);
    }

    public final boolean getIsWatermarked() {
        Boolean propertyAsBoolean = getPropertyAsBoolean(FIELD_IS_WATERMARKED);
        if (propertyAsBoolean != null) {
            return propertyAsBoolean.booleanValue();
        }
        return false;
    }

    public String toString() {
        return "Watermark: " + getIsWatermarked();
    }
}

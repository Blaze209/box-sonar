package com.box.android.data.api.models.inboxnotifications;

import androidx.core.provider.FontsContractCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/TextAtomDTO;", "", "type", "", "value", "fontWeight", "fontStyle", TtmlNode.ATTR_TTS_TEXT_DECORATION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getValue", "getFontWeight", "getFontStyle", "getTextDecoration", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextAtomDTO {
    private final String fontStyle;
    private final String fontWeight;
    private final String textDecoration;
    private final String type;
    private final String value;

    public static /* synthetic */ TextAtomDTO copy$default(TextAtomDTO textAtomDTO, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textAtomDTO.type;
        }
        if ((i & 2) != 0) {
            str2 = textAtomDTO.value;
        }
        if ((i & 4) != 0) {
            str3 = textAtomDTO.fontWeight;
        }
        if ((i & 8) != 0) {
            str4 = textAtomDTO.fontStyle;
        }
        if ((i & 16) != 0) {
            str5 = textAtomDTO.textDecoration;
        }
        String str6 = str5;
        String str7 = str3;
        return textAtomDTO.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFontStyle() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTextDecoration() {
        return this.textDecoration;
    }

    public final TextAtomDTO copy(@Json(name = "type") String type, @Json(name = "value") String value, @Json(name = FontsContractCompat.Columns.WEIGHT) String fontWeight, @Json(name = "font_style") String fontStyle, @Json(name = "text_decoration") String textDecoration) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        return new TextAtomDTO(type, value, fontWeight, fontStyle, textDecoration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextAtomDTO)) {
            return false;
        }
        TextAtomDTO textAtomDTO = (TextAtomDTO) other;
        return Intrinsics.areEqual(this.type, textAtomDTO.type) && Intrinsics.areEqual(this.value, textAtomDTO.value) && Intrinsics.areEqual(this.fontWeight, textAtomDTO.fontWeight) && Intrinsics.areEqual(this.fontStyle, textAtomDTO.fontStyle) && Intrinsics.areEqual(this.textDecoration, textAtomDTO.textDecoration);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.value.hashCode()) * 31;
        String str = this.fontWeight;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fontStyle;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.textDecoration;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TextAtomDTO(type=" + this.type + ", value=" + this.value + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", textDecoration=" + this.textDecoration + ")";
    }

    public TextAtomDTO(@Json(name = "type") String type, @Json(name = "value") String value, @Json(name = FontsContractCompat.Columns.WEIGHT) String str, @Json(name = "font_style") String str2, @Json(name = "text_decoration") String str3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.type = type;
        this.value = value;
        this.fontWeight = str;
        this.fontStyle = str2;
        this.textDecoration = str3;
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final String getFontStyle() {
        return this.fontStyle;
    }

    public final String getTextDecoration() {
        return this.textDecoration;
    }
}

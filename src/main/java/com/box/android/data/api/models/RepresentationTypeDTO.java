package com.box.android.data.api.models;

import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: RepresentationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/api/models/RepresentationTypeDTO;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PDF", "JPG", "PNG", "MP4", "DASH", "FILMSTRIP", "THREED", "MP3", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum RepresentationTypeDTO {
    PDF("pdf"),
    JPG(BoxRepresentation.TYPE_JPG),
    PNG(BoxRepresentation.TYPE_PNG),
    MP4(BoxRepresentation.TYPE_MP4),
    DASH(BoxRepresentation.TYPE_DASH),
    FILMSTRIP(BoxRepresentation.TYPE_FILMSTRIP),
    THREED("3d"),
    MP3(BoxRepresentation.TYPE_MP3);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<RepresentationTypeDTO> getEntries() {
        return $ENTRIES;
    }

    RepresentationTypeDTO(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}

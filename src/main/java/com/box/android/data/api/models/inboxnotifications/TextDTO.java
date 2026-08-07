package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/TextDTO;", "", "type", "", "atoms", "", "Lcom/box/android/data/api/models/inboxnotifications/TextAtomDTO;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getAtoms", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextDTO {
    private final List<TextAtomDTO> atoms;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextDTO copy$default(TextDTO textDTO, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textDTO.type;
        }
        if ((i & 2) != 0) {
            list = textDTO.atoms;
        }
        return textDTO.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<TextAtomDTO> component2() {
        return this.atoms;
    }

    public final TextDTO copy(@Json(name = "type") String type, @Json(name = "atoms") List<TextAtomDTO> atoms) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(atoms, "atoms");
        return new TextDTO(type, atoms);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextDTO)) {
            return false;
        }
        TextDTO textDTO = (TextDTO) other;
        return Intrinsics.areEqual(this.type, textDTO.type) && Intrinsics.areEqual(this.atoms, textDTO.atoms);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.atoms.hashCode();
    }

    public String toString() {
        return "TextDTO(type=" + this.type + ", atoms=" + this.atoms + ")";
    }

    public TextDTO(@Json(name = "type") String type, @Json(name = "atoms") List<TextAtomDTO> atoms) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(atoms, "atoms");
        this.type = type;
        this.atoms = atoms;
    }

    public final List<TextAtomDTO> getAtoms() {
        return this.atoms;
    }

    public final String getType() {
        return this.type;
    }
}

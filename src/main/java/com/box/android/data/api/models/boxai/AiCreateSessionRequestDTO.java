package com.box.android.data.api.models.boxai;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.modules.dialog.AlertFragment;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiCreateSessionRequestDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiCreateSessionRequestDTO;", "", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "usePrepare", "", "<init>", "(Ljava/util/List;Z)V", "getItems", "()Ljava/util/List;", "getUsePrepare", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiCreateSessionRequestDTO {
    private final List<ItemIdDTO> items;
    private final boolean usePrepare;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AiCreateSessionRequestDTO copy$default(AiCreateSessionRequestDTO aiCreateSessionRequestDTO, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = aiCreateSessionRequestDTO.items;
        }
        if ((i & 2) != 0) {
            z = aiCreateSessionRequestDTO.usePrepare;
        }
        return aiCreateSessionRequestDTO.copy(list, z);
    }

    public final List<ItemIdDTO> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getUsePrepare() {
        return this.usePrepare;
    }

    public final AiCreateSessionRequestDTO copy(@Json(name = AlertFragment.ARG_ITEMS) List<ItemIdDTO> items, @Json(name = "use_prepare") boolean usePrepare) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new AiCreateSessionRequestDTO(items, usePrepare);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiCreateSessionRequestDTO)) {
            return false;
        }
        AiCreateSessionRequestDTO aiCreateSessionRequestDTO = (AiCreateSessionRequestDTO) other;
        return Intrinsics.areEqual(this.items, aiCreateSessionRequestDTO.items) && this.usePrepare == aiCreateSessionRequestDTO.usePrepare;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + Boolean.hashCode(this.usePrepare);
    }

    public String toString() {
        return "AiCreateSessionRequestDTO(items=" + this.items + ", usePrepare=" + this.usePrepare + ")";
    }

    public AiCreateSessionRequestDTO(@Json(name = AlertFragment.ARG_ITEMS) List<ItemIdDTO> items, @Json(name = "use_prepare") boolean z) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.usePrepare = z;
    }

    public /* synthetic */ AiCreateSessionRequestDTO(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? true : z);
    }

    public final List<ItemIdDTO> getItems() {
        return this.items;
    }

    public final boolean getUsePrepare() {
        return this.usePrepare;
    }
}

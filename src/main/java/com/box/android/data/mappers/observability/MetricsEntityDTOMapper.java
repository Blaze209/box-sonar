package com.box.android.data.mappers.observability;

import com.box.android.data.api.models.observability.ActionsMetricsDTO;
import com.box.android.data.api.models.observability.ApdexMetricsDTO;
import com.box.android.data.api.models.observability.DiagnosticsMetricsDTO;
import com.box.android.data.api.models.observability.MetricsDTO;
import com.box.android.data.api.models.observability.MetricsEventsDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsEntityDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/mappers/observability/MetricsEntityDTOMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/data/api/models/observability/MetricsDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "actionsMetricsEntityDTOMapper", "Lcom/box/android/data/mappers/observability/ActionsMetricsEntityDTOMapper;", "diagnosticsMetricsEntityDTOMapper", "Lcom/box/android/data/mappers/observability/DiagnosticsMetricsEntityDTOMapper;", "apdexMetricsEntityDTOMapper", "Lcom/box/android/data/mappers/observability/ApdexMetricsEntityDTOMapper;", "toEntity", "sourceModel", "fromEntity", "entityModel", "getJsonFromEntityList", "", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsEntityDTOMapper implements EntityMapper<MetricsEntity, MetricsDTO> {
    private final ActionsMetricsEntityDTOMapper actionsMetricsEntityDTOMapper;
    private final ApdexMetricsEntityDTOMapper apdexMetricsEntityDTOMapper;
    private final DiagnosticsMetricsEntityDTOMapper diagnosticsMetricsEntityDTOMapper;
    private final Moshi moshi;

    /* JADX INFO: compiled from: MetricsEntityDTOMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MetricsCategory.values().length];
            try {
                iArr[MetricsCategory.DIAGNOSTICS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MetricsCategory.ACTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MetricsCategory.APDEX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public MetricsEntityDTOMapper(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
        this.actionsMetricsEntityDTOMapper = new ActionsMetricsEntityDTOMapper();
        this.diagnosticsMetricsEntityDTOMapper = new DiagnosticsMetricsEntityDTOMapper();
        this.apdexMetricsEntityDTOMapper = new ApdexMetricsEntityDTOMapper();
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public MetricsEntity toEntity(MetricsDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        int i = WhenMappings.$EnumSwitchMapping$0[sourceModel.getCategory().ordinal()];
        if (i == 1) {
            return this.diagnosticsMetricsEntityDTOMapper.toEntity((DiagnosticsMetricsDTO) sourceModel);
        }
        if (i == 2) {
            return this.actionsMetricsEntityDTOMapper.toEntity((ActionsMetricsDTO) sourceModel);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return this.apdexMetricsEntityDTOMapper.toEntity((ApdexMetricsDTO) sourceModel);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public MetricsDTO fromEntity(MetricsEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        int i = WhenMappings.$EnumSwitchMapping$0[entityModel.getCategory().ordinal()];
        if (i == 1) {
            return this.diagnosticsMetricsEntityDTOMapper.fromEntity(entityModel);
        }
        if (i == 2) {
            return this.actionsMetricsEntityDTOMapper.fromEntity(entityModel);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return this.apdexMetricsEntityDTOMapper.fromEntity(entityModel);
    }

    public final String getJsonFromEntityList(List<MetricsEntity> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(MetricsEventsDTO.class);
        List<MetricsEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(fromEntity((MetricsEntity) it.next()));
        }
        String json = jsonAdapterAdapter.toJson(new MetricsEventsDTO(arrayList));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}

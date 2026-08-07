package com.box.android.data.utilities;

import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.data.persistence.logging.MetricsEventType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsEntityGrouper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/utilities/MetricsEntityGrouper;", "", "<init>", "()V", "knownActionEventTypes", "", "", "groupBy", "", "metricsEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "addOptional", "", "", "field", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsEntityGrouper {
    public static final MetricsEntityGrouper INSTANCE = new MetricsEntityGrouper();
    private static final Set<String> knownActionEventTypes;

    private MetricsEntityGrouper() {
    }

    static {
        EnumEntries<MetricsEventType> entries = MetricsEventType.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        Iterator<MetricsEventType> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getLogType());
        }
        knownActionEventTypes = CollectionsKt.toSet(arrayList);
    }

    public final List<Object> groupBy(MetricsEntity metricsEntity) {
        Intrinsics.checkNotNullParameter(metricsEntity, "metricsEntity");
        if (metricsEntity.getCategory() == MetricsCategory.APDEX) {
            List<Object> listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(metricsEntity.getCategory());
            listCreateListBuilder.add(metricsEntity.getEventType());
            listCreateListBuilder.add(metricsEntity.getUserId());
            listCreateListBuilder.add(metricsEntity.getEnterpriseId());
            MetricsEntityGrouper metricsEntityGrouper = INSTANCE;
            metricsEntityGrouper.addOptional(listCreateListBuilder, metricsEntity.getMilestone());
            metricsEntityGrouper.addOptional(listCreateListBuilder, metricsEntity.getDuration());
            metricsEntityGrouper.addOptional(listCreateListBuilder, metricsEntity.getSecondaryMeasurement());
            metricsEntityGrouper.addOptional(listCreateListBuilder, metricsEntity.getScore());
            metricsEntityGrouper.addOptional(listCreateListBuilder, metricsEntity.getSizeKB());
            metricsEntityGrouper.addOptional(listCreateListBuilder, metricsEntity.getFailed());
            return CollectionsKt.build(listCreateListBuilder);
        }
        if (metricsEntity.getCategory() == MetricsCategory.ACTIONS && Intrinsics.areEqual(metricsEntity.getEventType(), MetricsEventType.HUBS.getLogType())) {
            List<Object> listCreateListBuilder2 = CollectionsKt.createListBuilder();
            listCreateListBuilder2.add(metricsEntity.getCategory());
            listCreateListBuilder2.add(metricsEntity.getEventType());
            MetricsEntityGrouper metricsEntityGrouper2 = INSTANCE;
            metricsEntityGrouper2.addOptional(listCreateListBuilder2, metricsEntity.getSubtype());
            metricsEntityGrouper2.addOptional(listCreateListBuilder2, metricsEntity.getDuration());
            metricsEntityGrouper2.addOptional(listCreateListBuilder2, metricsEntity.getFailed());
            metricsEntityGrouper2.addOptional(listCreateListBuilder2, metricsEntity.getFailReason());
            metricsEntityGrouper2.addOptional(listCreateListBuilder2, metricsEntity.getValue());
            metricsEntityGrouper2.addOptional(listCreateListBuilder2, metricsEntity.getMessage());
            listCreateListBuilder2.add(metricsEntity.getUserId());
            listCreateListBuilder2.add(metricsEntity.getEnterpriseId());
            return CollectionsKt.build(listCreateListBuilder2);
        }
        if (metricsEntity.getCategory() == MetricsCategory.ACTIONS && Intrinsics.areEqual(metricsEntity.getEventType(), MetricsEventType.BOX_AI.getLogType())) {
            List<Object> listCreateListBuilder3 = CollectionsKt.createListBuilder();
            listCreateListBuilder3.add(metricsEntity.getCategory());
            listCreateListBuilder3.add(metricsEntity.getEventType());
            MetricsEntityGrouper metricsEntityGrouper3 = INSTANCE;
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getMessage());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getFileName());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getValue());
            listCreateListBuilder3.add(metricsEntity.getUserId());
            listCreateListBuilder3.add(metricsEntity.getEnterpriseId());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getSubtype());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getNumOfParallelChunks());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getDuration());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getType());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getFailed());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getFailReason());
            metricsEntityGrouper3.addOptional(listCreateListBuilder3, metricsEntity.getNumItems());
            return CollectionsKt.build(listCreateListBuilder3);
        }
        if (metricsEntity.getCategory() == MetricsCategory.ACTIONS && !knownActionEventTypes.contains(metricsEntity.getEventType())) {
            List<Object> listCreateListBuilder4 = CollectionsKt.createListBuilder();
            listCreateListBuilder4.add(metricsEntity.getCategory());
            listCreateListBuilder4.add(metricsEntity.getEventType());
            MetricsEntityGrouper metricsEntityGrouper4 = INSTANCE;
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getSourceTab());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getSubtype());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getJobManagerVersion());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getFileId());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getFolderId());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getItemState());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getType());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getUiSource());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getCompletionStatusString());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getValue());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getMessage());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getFailReason());
            metricsEntityGrouper4.addOptional(listCreateListBuilder4, metricsEntity.getDuration());
            listCreateListBuilder4.add(metricsEntity.getUserId());
            listCreateListBuilder4.add(metricsEntity.getEnterpriseId());
            return CollectionsKt.build(listCreateListBuilder4);
        }
        List<Object> listCreateListBuilder5 = CollectionsKt.createListBuilder();
        listCreateListBuilder5.add(metricsEntity.getCategory());
        listCreateListBuilder5.add(metricsEntity.getEventType());
        MetricsEntityGrouper metricsEntityGrouper5 = INSTANCE;
        metricsEntityGrouper5.addOptional(listCreateListBuilder5, metricsEntity.getMessage());
        metricsEntityGrouper5.addOptional(listCreateListBuilder5, metricsEntity.getFileName());
        metricsEntityGrouper5.addOptional(listCreateListBuilder5, metricsEntity.getValue());
        metricsEntityGrouper5.addOptional(listCreateListBuilder5, metricsEntity.getFileId());
        metricsEntityGrouper5.addOptional(listCreateListBuilder5, metricsEntity.getFailed());
        metricsEntityGrouper5.addOptional(listCreateListBuilder5, metricsEntity.getFailReason());
        listCreateListBuilder5.add(metricsEntity.getUserId());
        listCreateListBuilder5.add(metricsEntity.getEnterpriseId());
        return CollectionsKt.build(listCreateListBuilder5);
    }

    private final void addOptional(List<Object> list, Object obj) {
        if (obj != null) {
            list.add(obj);
        }
    }
}

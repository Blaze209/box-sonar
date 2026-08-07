package com.box.android.preview.iteminformation;

import com.box.android.domain.models.metadata.FileMetadataInstanceModel;
import com.box.android.domain.models.metadata.FileMetadataModel;
import com.box.android.domain.models.metadata.MetadataTemplateFieldModel;
import com.box.android.domain.models.metadata.MetadataTemplateModel;
import com.box.androidsdk.content.models.BoxOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;

/* JADX INFO: compiled from: MetadataItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\"\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b\u001a4\u0010\n\u001a\u00020\u000b*\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"templateCompositeKey", "", "templateKey", "scope", "toItem", "Lcom/box/android/preview/iteminformation/MetadataItem;", "Lcom/box/android/domain/models/metadata/FileMetadataInstanceModel;", "templates", "", "Lcom/box/android/domain/models/metadata/MetadataTemplateModel;", "toMetadataField", "Lcom/box/android/preview/iteminformation/MetadataField;", "Lcom/box/android/domain/models/metadata/FileMetadataModel;", "fieldLabelMap", "fieldTypeMap", "FIELD_KEY_CAPTURE_TIMESTAMP", "formatCaptureTimestamp", "iso8601", "formatDateField", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MetadataItemKt {
    private static final String FIELD_KEY_CAPTURE_TIMESTAMP = "captureTimestamp";

    public static final String templateCompositeKey(String templateKey, String scope) {
        Intrinsics.checkNotNullParameter(templateKey, "templateKey");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return templateKey + "_" + scope;
    }

    public static /* synthetic */ MetadataItem toItem$default(FileMetadataInstanceModel fileMetadataInstanceModel, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return toItem(fileMetadataInstanceModel, map);
    }

    public static final MetadataItem toItem(FileMetadataInstanceModel fileMetadataInstanceModel, Map<String, MetadataTemplateModel> templates) {
        LinkedHashMap linkedHashMapEmptyMap;
        LinkedHashMap linkedHashMapEmptyMap2;
        String templateKey;
        List<MetadataTemplateFieldModel> fields;
        List<MetadataTemplateFieldModel> fields2;
        Intrinsics.checkNotNullParameter(fileMetadataInstanceModel, "<this>");
        Intrinsics.checkNotNullParameter(templates, "templates");
        MetadataTemplateModel metadataTemplateModel = templates.get(templateCompositeKey(fileMetadataInstanceModel.getTemplateKey(), fileMetadataInstanceModel.getScope()));
        if (metadataTemplateModel != null && metadataTemplateModel.getHidden()) {
            return null;
        }
        if (metadataTemplateModel == null || (fields2 = metadataTemplateModel.getFields()) == null) {
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        } else {
            List<MetadataTemplateFieldModel> list = fields2;
            linkedHashMapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (MetadataTemplateFieldModel metadataTemplateFieldModel : list) {
                Pair pair = TuplesKt.to(metadataTemplateFieldModel.getKey(), metadataTemplateFieldModel.getDisplayName());
                linkedHashMapEmptyMap.put(pair.getFirst(), pair.getSecond());
            }
        }
        if (metadataTemplateModel == null || (fields = metadataTemplateModel.getFields()) == null) {
            linkedHashMapEmptyMap2 = MapsKt.emptyMap();
        } else {
            List<MetadataTemplateFieldModel> list2 = fields;
            linkedHashMapEmptyMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
            for (MetadataTemplateFieldModel metadataTemplateFieldModel2 : list2) {
                Pair pair2 = TuplesKt.to(metadataTemplateFieldModel2.getKey(), metadataTemplateFieldModel2.getType());
                linkedHashMapEmptyMap2.put(pair2.getFirst(), pair2.getSecond());
            }
        }
        String id = fileMetadataInstanceModel.getId();
        if (metadataTemplateModel == null || (templateKey = metadataTemplateModel.getDisplayName()) == null) {
            templateKey = fileMetadataInstanceModel.getTemplateKey();
        }
        List<FileMetadataModel> fields3 = fileMetadataInstanceModel.getFields();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fields3, 10));
        Iterator<T> it = fields3.iterator();
        while (it.hasNext()) {
            arrayList.add(toMetadataField((FileMetadataModel) it.next(), linkedHashMapEmptyMap, linkedHashMapEmptyMap2));
        }
        MetadataItem metadataItem = new MetadataItem(id, templateKey, ExtensionsKt.toImmutableList(arrayList));
        if (metadataItem.getFields().isEmpty()) {
            return null;
        }
        return metadataItem;
    }

    private static final MetadataField toMetadataField(FileMetadataModel fileMetadataModel, Map<String, String> map, Map<String, String> map2) {
        String value;
        boolean zAreEqual = Intrinsics.areEqual(map2.get(fileMetadataModel.getKey()), BoxOrder.SORT_DATE);
        if (Intrinsics.areEqual(fileMetadataModel.getKey(), FIELD_KEY_CAPTURE_TIMESTAMP)) {
            value = formatCaptureTimestamp(fileMetadataModel.getValue());
            if (value == null) {
                value = fileMetadataModel.getValue();
            }
        } else if (!zAreEqual || (value = formatDateField(fileMetadataModel.getValue())) == null) {
            value = fileMetadataModel.getValue();
        }
        String key = fileMetadataModel.getKey();
        String key2 = map.get(fileMetadataModel.getKey());
        if (key2 == null) {
            key2 = fileMetadataModel.getKey();
        }
        return new MetadataField(key, key2, value);
    }

    private static final String formatCaptureTimestamp(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.US);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM d, yyyy, h:mm a", Locale.getDefault());
            Date date = simpleDateFormat.parse(str);
            if (date != null) {
                return simpleDateFormat2.format(date);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static final String formatDateField(String str) {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US);
            simpleDateFormat.setTimeZone(timeZone);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
            simpleDateFormat2.setTimeZone(timeZone);
            Date date = simpleDateFormat.parse(str);
            if (date != null) {
                return simpleDateFormat2.format(date);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}

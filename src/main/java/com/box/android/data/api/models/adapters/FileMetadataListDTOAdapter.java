package com.box.android.data.api.models.adapters;

import com.box.android.data.api.models.FileMetadataInstanceDTO;
import com.box.android.data.api.models.FileMetadataListDTO;
import com.box.android.data.api.models.MetadataReservedKeys;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.ToJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileMetadataListDTOAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/api/models/adapters/FileMetadataListDTOAdapter;", "", "<init>", "()V", "fromJson", "Lcom/box/android/data/api/models/FileMetadataListDTO;", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toFileMetadataInstanceDTO", "Lcom/box/android/data/api/models/FileMetadataInstanceDTO;", "", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileMetadataListDTOAdapter {
    @FromJson
    public final FileMetadataListDTO fromJson(JsonReader reader) throws IOException {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(reader, "reader");
        Object jsonValue = reader.readJsonValue();
        Map map = jsonValue instanceof Map ? (Map) jsonValue : null;
        if (map == null) {
            return new FileMetadataListDTO(null, null, 3, null);
        }
        Object obj = map.get("entries");
        List list = obj instanceof List ? (List) obj : null;
        if (list == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof Map) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FileMetadataInstanceDTO fileMetadataInstanceDTO = toFileMetadataInstanceDTO((Map) it.next());
                if (fileMetadataInstanceDTO != null) {
                    arrayList2.add(fileMetadataInstanceDTO);
                }
            }
            arrayListEmptyList = arrayList2;
        }
        Object obj3 = map.get(BoxIterator.FIELD_LIMIT);
        Number number = obj3 instanceof Number ? (Number) obj3 : null;
        return new FileMetadataListDTO(arrayListEmptyList, number != null ? Integer.valueOf(number.intValue()) : null);
    }

    @ToJson
    public final void toJson(JsonWriter writer, FileMetadataListDTO value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("FileMetadataListDTO is read-only");
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00f9  */
    private final FileMetadataInstanceDTO toFileMetadataInstanceDTO(Map<String, ? extends Object> map) {
        String string;
        Object obj;
        String string2;
        Object obj2;
        String string3;
        String string4;
        Pair pair;
        Object obj3 = map.get(MetadataReservedKeys.ID);
        if (obj3 == null || (string = obj3.toString()) == null || (obj = map.get(MetadataReservedKeys.SCOPE)) == null || (string2 = obj.toString()) == null || (obj2 = map.get(MetadataReservedKeys.TEMPLATE)) == null || (string3 = obj2.toString()) == null) {
            return null;
        }
        Object obj4 = map.get(MetadataReservedKeys.PARENT);
        String string5 = obj4 != null ? obj4.toString() : null;
        if (string5 == null) {
            string5 = "";
        }
        String str = string5;
        Object obj5 = map.get(MetadataReservedKeys.VERSION);
        Number number = obj5 instanceof Number ? (Number) obj5 : null;
        int iIntValue = number != null ? number.intValue() : 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            if (!StringsKt.startsWith$default(entry.getKey(), MetadataReservedKeys.PREFIX, false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str2 = (String) entry2.getKey();
            Object value = entry2.getValue();
            if (value == null) {
                string4 = null;
            } else if (value instanceof Double) {
                Number number2 = (Number) value;
                string4 = number2.doubleValue() % 1.0d == 0.0d ? String.valueOf((long) number2.doubleValue()) : String.valueOf(number2.doubleValue());
            } else {
                string4 = value.toString();
            }
            if (string4 == null) {
                pair = null;
            } else {
                if (StringsKt.isBlank(string4)) {
                    string4 = null;
                }
                if (string4 != null) {
                    pair = TuplesKt.to(str2, string4);
                } else {
                    pair = null;
                }
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return new FileMetadataInstanceDTO(string, string2, string3, str, iIntValue, MapsKt.toMap(arrayList));
    }
}

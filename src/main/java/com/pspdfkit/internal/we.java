package com.pspdfkit.internal;

import com.pspdfkit.document.PdfValue;
import com.pspdfkit.document.metadata.DocumentXmpMetadata;
import com.pspdfkit.internal.jni.NativeXMPMetadataRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class we extends xd implements DocumentXmpMetadata {
    public we(lm lmVar, boolean z) {
        super(lmVar, z);
    }

    @Override // com.pspdfkit.document.metadata.DocumentXmpMetadata
    public final PdfValue get(String str, String str2) {
        str.getClass();
        str2.getClass();
        int i = 0;
        NativeXMPMetadataRecord fromXMP = this.b.getFromXMP(str, str2, 0);
        if (fromXMP == null) {
            return null;
        }
        if (fromXMP.getSingleValue() != null) {
            return new PdfValue(fromXMP.getSingleValue());
        }
        if (fromXMP.getMultipleValues() == null) {
            return null;
        }
        ArrayList<HashMap<String, String>> multipleValues = fromXMP.getMultipleValues();
        ArrayList arrayList = new ArrayList();
        int size = multipleValues.size();
        while (i < size) {
            HashMap<String, String> map = multipleValues.get(i);
            i++;
            HashMap map2 = new HashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                map2.put(entry.getKey(), new PdfValue(entry.getValue()));
            }
            arrayList.add(new PdfValue(map2));
        }
        return new PdfValue(arrayList);
    }

    @Override // com.pspdfkit.document.metadata.DocumentXmpMetadata
    public final void set(String str, String str2, String str3, String str4) {
        str.getClass();
        str3.getClass();
        str4.getClass();
        if (!this.a) {
            throw new UnsupportedOperationException("Document metadata are read-only!");
        }
        synchronized (this) {
            this.b.setInXMP(str, new NativeXMPMetadataRecord(str2, null, false), str3, str4, 0);
            this.d = true;
            Unit unit = Unit.INSTANCE;
        }
    }
}

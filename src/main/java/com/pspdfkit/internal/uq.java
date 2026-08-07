package com.pspdfkit.internal;

import com.pspdfkit.document.PdfValue;
import com.pspdfkit.internal.jni.NativePDFObject;
import com.pspdfkit.internal.jni.NativePDFObjectType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class uq {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[PdfValue.PdfValueType.values().length];
            b = iArr;
            try {
                iArr[PdfValue.PdfValueType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PdfValue.PdfValueType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[PdfValue.PdfValueType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[PdfValue.PdfValueType.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[PdfValue.PdfValueType.ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[PdfValue.PdfValueType.DICTIONARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[PdfValue.PdfValueType.NULLOBJ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[NativePDFObjectType.values().length];
            a = iArr2;
            try {
                iArr2[NativePDFObjectType.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[NativePDFObjectType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[NativePDFObjectType.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[NativePDFObjectType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[NativePDFObjectType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[NativePDFObjectType.ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[NativePDFObjectType.DICTIONARY.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static PdfValue a(NativePDFObject nativePDFObject) {
        if (nativePDFObject == null) {
            return null;
        }
        switch (a.a[nativePDFObject.type().ordinal()]) {
            case 1:
            case 2:
                String strStringValue = nativePDFObject.stringValue();
                return strStringValue == null ? new PdfValue() : new PdfValue(strStringValue);
            case 3:
                return new PdfValue(nativePDFObject.integerValue());
            case 4:
                return new PdfValue(nativePDFObject.doubleValue());
            case 5:
                return new PdfValue(nativePDFObject.booleanValue());
            case 6:
                ArrayList<NativePDFObject> arrayListArrayValue = nativePDFObject.arrayValue();
                if (arrayListArrayValue == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int size = arrayListArrayValue.size();
                int i = 0;
                while (i < size) {
                    NativePDFObject nativePDFObject2 = arrayListArrayValue.get(i);
                    i++;
                    arrayList.add(a(nativePDFObject2));
                }
                return new PdfValue(arrayList);
            case 7:
                HashMap<String, NativePDFObject> mapDictionaryValue = nativePDFObject.dictionaryValue();
                if (mapDictionaryValue == null) {
                    return null;
                }
                HashMap map = new HashMap();
                for (Map.Entry<String, NativePDFObject> entry : mapDictionaryValue.entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue()));
                }
                return new PdfValue(map);
            default:
                return new PdfValue();
        }
    }

    public static NativePDFObject a(PdfValue pdfValue) {
        if (pdfValue == null) {
            return null;
        }
        switch (a.b[pdfValue.getType().ordinal()]) {
            case 1:
                return NativePDFObject.createString(pdfValue.getString());
            case 2:
                return NativePDFObject.createDouble(pdfValue.getDouble());
            case 3:
                return NativePDFObject.createBool(pdfValue.getBoolean());
            case 4:
                return NativePDFObject.createInteger(pdfValue.getLong());
            case 5:
                ArrayList arrayList = new ArrayList();
                Iterator<PdfValue> it = pdfValue.getArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(a(it.next()));
                }
                return NativePDFObject.createArray(arrayList);
            case 6:
                HashMap map = new HashMap();
                for (Map.Entry<String, PdfValue> entry : pdfValue.getDictionary().entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue()));
                }
                return NativePDFObject.createDictionary(map);
            case 7:
                return null;
            default:
                throw new IllegalArgumentException("PdfValue type " + pdfValue.getType() + " cannot be serialized to native!");
        }
    }
}

package com.pspdfkit.internal;

import android.text.TextUtils;
import com.pspdfkit.document.PdfValue;
import com.pspdfkit.document.metadata.DocumentPdfMetadata;
import com.pspdfkit.internal.jni.NativeDateUtilities;
import com.pspdfkit.internal.jni.NativeProcessorConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class yd extends xd implements DocumentPdfMetadata {
    public static final List<String> e = Arrays.asList(NativeProcessorConfiguration.METADATA_TITLE, NativeProcessorConfiguration.METADATA_AUTHOR, NativeProcessorConfiguration.METADATA_SUBJECT, NativeProcessorConfiguration.METADATA_KEYWORDS, NativeProcessorConfiguration.METADATA_CREATOR, NativeProcessorConfiguration.METADATA_PRODUCER, NativeProcessorConfiguration.METADATA_CREATION_DATE, NativeProcessorConfiguration.METADATA_MODIFICATION_DATE);

    public yd(lm lmVar, boolean z) {
        super(lmVar, z);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final PdfValue get(String str) {
        str.getClass();
        return uq.a(this.b.getFromPDF(str, 0));
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final String getAuthor() {
        return (String) this.c.get(NativeProcessorConfiguration.METADATA_AUTHOR);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final Date getCreationDate() {
        String str = (String) this.c.get(NativeProcessorConfiguration.METADATA_CREATION_DATE);
        if (str == null) {
            return null;
        }
        return NativeDateUtilities.stringToPdfDate(str);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final String getCreator() {
        return (String) this.c.get(NativeProcessorConfiguration.METADATA_CREATOR);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final List<String> getKeywords() {
        List listEmptyList;
        String str = (String) this.c.get(NativeProcessorConfiguration.METADATA_KEYWORDS);
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<String> listSplit = new Regex("\\s*,\\s*").split(str, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
            break;
        }
        ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            if (listIterator.previous().length() != 0) {
                listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                break;
            }
        }
        for (String str2 : (String[]) listEmptyList.toArray(new String[0])) {
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        if (str.length() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final Map<String, PdfValue> getMetadata() {
        HashMap map;
        synchronized (this) {
            map = new HashMap();
            Iterator<String> it = this.b.getTopLevelKeysFromPDF(0).iterator();
            it.getClass();
            while (it.hasNext()) {
                String next = it.next();
                PdfValue pdfValueA = uq.a(this.b.getFromPDF(next, 0));
                if (pdfValueA != null) {
                    map.put(next, pdfValueA);
                }
            }
        }
        return map;
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final Date getModificationDate() {
        String str = (String) this.c.get(NativeProcessorConfiguration.METADATA_MODIFICATION_DATE);
        if (str == null) {
            return null;
        }
        return NativeDateUtilities.stringToPdfDate(str);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final String getProducer() {
        return (String) this.c.get(NativeProcessorConfiguration.METADATA_PRODUCER);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final String getSubject() {
        return (String) this.c.get(NativeProcessorConfiguration.METADATA_SUBJECT);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final String getTitle() {
        return (String) this.c.get(NativeProcessorConfiguration.METADATA_TITLE);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void set(String str, PdfValue pdfValue) {
        str.getClass();
        if (!this.a) {
            throw new UnsupportedOperationException("Document metadata are read-only!");
        }
        synchronized (this) {
            this.b.setInPDF(str, uq.a(pdfValue), 0);
            if (e.contains(str)) {
                HashMap map = this.c;
                if (pdfValue == null) {
                } else {
                    String string = pdfValue.getString();
                    string.getClass();
                }
            }
            this.d = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setAuthor(String str) {
        set(NativeProcessorConfiguration.METADATA_AUTHOR, str != null ? new PdfValue(str) : null);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setCreationDate(Date date) {
        if (date == null) {
            set(NativeProcessorConfiguration.METADATA_CREATION_DATE, null);
        } else {
            set(NativeProcessorConfiguration.METADATA_CREATION_DATE, new PdfValue(NativeDateUtilities.pdfDateToString(date)));
        }
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setCreator(String str) {
        set(NativeProcessorConfiguration.METADATA_CREATOR, str != null ? new PdfValue(str) : null);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setKeywords(List<String> list) {
        if (list == null || list.isEmpty()) {
            set(NativeProcessorConfiguration.METADATA_KEYWORDS, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!TextUtils.isEmpty(list.get(i))) {
                sb.append(list.get(i));
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
        }
        set(NativeProcessorConfiguration.METADATA_KEYWORDS, new PdfValue(sb.toString()));
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setModificationDate(Date date) {
        if (date == null) {
            set(NativeProcessorConfiguration.METADATA_MODIFICATION_DATE, null);
        } else {
            set(NativeProcessorConfiguration.METADATA_MODIFICATION_DATE, new PdfValue(NativeDateUtilities.pdfDateToString(date)));
        }
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setProducer(String str) {
        set(NativeProcessorConfiguration.METADATA_PRODUCER, str != null ? new PdfValue(str) : null);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setSubject(String str) {
        set(NativeProcessorConfiguration.METADATA_SUBJECT, str != null ? new PdfValue(str) : null);
    }

    @Override // com.pspdfkit.document.metadata.DocumentPdfMetadata
    public final void setTitle(String str) {
        set(NativeProcessorConfiguration.METADATA_TITLE, str != null ? new PdfValue(str) : null);
    }
}

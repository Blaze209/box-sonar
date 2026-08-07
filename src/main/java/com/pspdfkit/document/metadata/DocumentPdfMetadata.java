package com.pspdfkit.document.metadata;

import com.pspdfkit.document.PdfValue;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentPdfMetadata {
    PdfValue get(String str);

    String getAuthor();

    Date getCreationDate();

    String getCreator();

    List<String> getKeywords();

    Map<String, PdfValue> getMetadata();

    Date getModificationDate();

    String getProducer();

    String getSubject();

    String getTitle();

    boolean hasUnsavedChanges();

    void set(String str, PdfValue pdfValue);

    void setAuthor(String str);

    void setCreationDate(Date date);

    void setCreator(String str);

    void setKeywords(List<String> list);

    void setModificationDate(Date date);

    void setProducer(String str);

    void setSubject(String str);

    void setTitle(String str);
}

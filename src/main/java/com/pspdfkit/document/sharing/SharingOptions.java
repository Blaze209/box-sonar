package com.pspdfkit.document.sharing;

import com.box.android.domain.utils.SupportedFileExtensions;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.z40;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class SharingOptions {
    private final PdfProcessorTask.AnnotationProcessingMode annotationProcessingMode;
    private final String documentName;
    private final List<Range> pages;

    public SharingOptions(PdfProcessorTask.AnnotationProcessingMode annotationProcessingMode) {
        this(annotationProcessingMode, Collections.singletonList(new Range(0, Integer.MAX_VALUE)), "");
    }

    private boolean isInRange(int i, Range range) {
        return range.getStartPosition() <= i && i < range.getEndPosition();
    }

    private static int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static List<Range> parsePageRange(String str, int i) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.replaceAll("\\s", "").split(",")) {
            String[] strArrSplit = str2.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            if (strArrSplit.length == 2) {
                int i2 = parseInt(strArrSplit[0], 0);
                int i3 = parseInt(strArrSplit[1], 0);
                if (i2 <= 0 || i2 > i3 || i3 > i) {
                    arrayList.clear();
                    break;
                }
                arrayList.add(new Range(i2 - 1, (i3 - i2) + 1));
            } else {
                if (strArrSplit.length != 1) {
                    continue;
                } else {
                    int i4 = parseInt(strArrSplit[0], 0);
                    if (i4 <= 0 || i4 > i) {
                        arrayList.clear();
                        break;
                    }
                    arrayList.add(new Range(i4 - 1, 1));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SharingOptions)) {
            return false;
        }
        SharingOptions sharingOptions = (SharingOptions) obj;
        return this.annotationProcessingMode == sharingOptions.annotationProcessingMode && this.documentName.equals(sharingOptions.documentName) && this.pages.equals(sharingOptions.pages);
    }

    public PdfProcessorTask.AnnotationProcessingMode getAnnotationProcessingMode() {
        return this.annotationProcessingMode;
    }

    public String getDocumentName() {
        return this.documentName;
    }

    public Set<Integer> getPagesToRemove(int i) {
        HashSet hashSet = new HashSet();
        if (this.pages.size() > 1) {
            Collections.sort(this.pages);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (i2 >= this.pages.size()) {
                hashSet.add(Integer.valueOf(i3));
            } else if (i3 < this.pages.get(i2).getStartPosition()) {
                hashSet.add(Integer.valueOf(i3));
            } else if (!isInRange(i3, this.pages.get(i2))) {
                while (i2 < this.pages.size() && i3 >= this.pages.get(i2).getEndPosition()) {
                    i2++;
                }
                if (i2 >= this.pages.size() || !isInRange(i3, this.pages.get(i2))) {
                    hashSet.add(Integer.valueOf(i3));
                }
            }
        }
        return hashSet;
    }

    public PdfProcessorTask getProcessorTask(PdfDocument pdfDocument) {
        Set<Integer> pagesToRemove = getPagesToRemove(pdfDocument.getPageCount());
        if (pagesToRemove.isEmpty() && getAnnotationProcessingMode() == PdfProcessorTask.AnnotationProcessingMode.KEEP) {
            return null;
        }
        PdfProcessorTask pdfProcessorTaskChangeAllAnnotations = PdfProcessorTask.fromDocument(pdfDocument).changeAllAnnotations(getAnnotationProcessingMode());
        pdfProcessorTaskChangeAllAnnotations.removePages(pagesToRemove);
        return pdfProcessorTaskChangeAllAnnotations;
    }

    public int hashCode() {
        return this.pages.hashCode() + z40.a(this.documentName, this.annotationProcessingMode.hashCode() * 31, 31);
    }

    public String toString() {
        return "SharingOptions{annotationProcessingMode=" + this.annotationProcessingMode + ", documentName='" + this.documentName + "', pages=" + this.pages + AbstractJsonLexerKt.END_OBJ;
    }

    public SharingOptions(PdfProcessorTask.AnnotationProcessingMode annotationProcessingMode, List<Range> list) {
        this(annotationProcessingMode, list, "");
    }

    public SharingOptions(String str) {
        this(PdfProcessorTask.AnnotationProcessingMode.KEEP, Collections.singletonList(new Range(0, Integer.MAX_VALUE)), str);
    }

    public SharingOptions(PdfProcessorTask.AnnotationProcessingMode annotationProcessingMode, List<Range> list, String str) {
        uw.a(annotationProcessingMode, "annotationProcessingMode", null);
        uw.a(list, SupportedFileExtensions.PAGES_EXTENSION, null);
        uw.a(str, "documentName", null);
        this.annotationProcessingMode = annotationProcessingMode;
        this.pages = list;
        this.documentName = str.trim();
    }

    public SharingOptions(SharingOptions sharingOptions) {
        this.annotationProcessingMode = sharingOptions.annotationProcessingMode;
        this.documentName = sharingOptions.documentName;
        this.pages = new ArrayList(sharingOptions.pages);
    }
}

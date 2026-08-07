package com.pspdfkit.utils;

import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.ComboBoxFormElement;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormOption;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.ListBoxFormElement;
import com.pspdfkit.forms.TextFormElement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"createTextBlock", "Lcom/pspdfkit/datastructures/TextBlock;", "Lcom/pspdfkit/annotations/Annotation;", "document", "Lcom/pspdfkit/document/PdfDocument;", "range", "Lcom/pspdfkit/datastructures/Range;", "pageIndex", "", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TextBlockHelpersKt {
    public static final TextBlock createTextBlock(Annotation annotation, PdfDocument pdfDocument, Range range) {
        annotation.getClass();
        pdfDocument.getClass();
        range.getClass();
        if (!annotation.isAttached() || annotation.getPageIndex() < 0 || annotation.getPageIndex() >= pdfDocument.getPageCount()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            throw new IllegalArgumentException(String.format(Locale.getDefault(), "annotation %s is not attached to the document, or page index invalid %d.", Arrays.copyOf(new Object[]{annotation, Integer.valueOf(annotation.getPageIndex())}, 2)).toString());
        }
        String contents = annotation.getContents();
        if (contents == null && annotation.getType() == AnnotationType.WIDGET) {
            FormElement formElement = ((WidgetAnnotation) annotation).getFormElement();
            if (formElement != null && formElement.getType() == FormType.TEXT) {
                contents = ((TextFormElement) formElement).getText();
            } else if (formElement != null && formElement.getType() == FormType.COMBOBOX) {
                StringBuilder sb = new StringBuilder();
                Iterator<FormOption> it = ((ComboBoxFormElement) formElement).getOptions().iterator();
                while (it.hasNext()) {
                    sb.append(it.next().getLabel());
                    sb.append('\n');
                }
                contents = sb.toString();
            } else if (formElement != null && formElement.getType() == FormType.LISTBOX) {
                StringBuilder sb2 = new StringBuilder();
                Iterator<FormOption> it2 = ((ListBoxFormElement) formElement).getOptions().iterator();
                while (it2.hasNext()) {
                    sb2.append(it2.next().getLabel());
                    sb2.append('\n');
                }
                contents = sb2.toString();
            }
        }
        if (contents == null) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            throw new IllegalArgumentException(String.format(Locale.getDefault(), "annotation has empty contents: %s", Arrays.copyOf(new Object[]{annotation}, 1)));
        }
        TextBlock textBlockCreate = TextBlock.create(annotation.getPageIndex(), range, CollectionsKt.listOf(annotation.getBoundingBox()), contents.substring(range.getStartPosition(), range.getEndPosition()));
        textBlockCreate.getClass();
        return textBlockCreate;
    }

    public static final TextBlock createTextBlock(PdfDocument pdfDocument, int i, Range range) {
        pdfDocument.getClass();
        range.getClass();
        if (i < pdfDocument.getPageCount()) {
            List<RectF> pageTextRects = pdfDocument.getPageTextRects(i, range.getStartPosition(), range.getLength(), true);
            pageTextRects.getClass();
            String pageText = pdfDocument.getPageText(i, range.getStartPosition(), range.getLength());
            pageText.getClass();
            TextBlock textBlockCreate = TextBlock.create(i, range, pageTextRects, pageText);
            textBlockCreate.getClass();
            return textBlockCreate;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        throw new IllegalArgumentException(String.format(Locale.getDefault(), "pageIndex %d exceeds document page count of %d.", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(pdfDocument.getPageCount())}, 2)).toString());
    }
}

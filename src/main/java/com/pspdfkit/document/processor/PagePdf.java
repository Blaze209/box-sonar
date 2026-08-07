package com.pspdfkit.document.processor;

import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeDataDescriptor;
import com.pspdfkit.internal.jni.NativeItemConfiguration;
import com.pspdfkit.internal.jni.NativeItemRelativePosition;
import com.pspdfkit.internal.jni.NativeItemZPosition;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PagePdf {
    private final Context context;
    private final Matrix matrix;
    private final int pageIndex;
    private String password;
    private final Uri pdfFile;
    private final PagePosition position;
    private final DataProvider provider;
    private PageZOrder zOrder;

    public PagePdf(Context context, Uri uri) {
        this(context, uri, 0, new Matrix());
    }

    public NativeItemConfiguration getItemConfiguration() {
        return new NativeItemConfiguration(null, getNativeDataDescriptor(), Integer.valueOf(this.pageIndex), this.position == null ? null : NativeItemRelativePosition.values()[this.position.ordinal()], getNativeZPosition(), this.matrix);
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public NativeDataDescriptor getNativeDataDescriptor() {
        Uri uri = this.pdfFile;
        if (uri == null) {
            return DataProviderShim.createNativeDataDescriptor(this.provider, this.password);
        }
        String strA = wg.a(this.context, uri);
        return strA != null ? new NativeDataDescriptor(strA, null, this.password, null, null) : DataProviderShim.createNativeDataDescriptor(new ContentResolverDataProvider(this.pdfFile), this.password);
    }

    public NativeItemZPosition getNativeZPosition() {
        return NativeItemZPosition.values()[this.zOrder.ordinal()];
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public PagePosition getPosition() {
        return this.position;
    }

    public PageZOrder getZOrder() {
        return this.zOrder;
    }

    public void setDocumentPassword(String str) {
        this.password = str;
    }

    public void setZOrder(PageZOrder pageZOrder) {
        uw.a(pageZOrder, "zOrder", null);
        this.zOrder = pageZOrder;
    }

    public PagePdf(Context context, Uri uri, PagePosition pagePosition) {
        this(context, uri, 0, pagePosition);
    }

    public PagePdf(Context context, Uri uri, Matrix matrix) {
        this(context, uri, 0, matrix);
    }

    public PagePdf(Context context, DataProvider dataProvider) {
        this(context, dataProvider, 0, new Matrix());
    }

    public PagePdf(Context context, DataProvider dataProvider, PagePosition pagePosition) {
        this(context, dataProvider, 0, pagePosition);
    }

    public PagePdf(Context context, DataProvider dataProvider, Matrix matrix) {
        this(context, dataProvider, 0, matrix);
    }

    public PagePdf(Context context, Uri uri, int i) {
        this(context, uri, i, new Matrix());
    }

    public PagePdf(Context context, Uri uri, int i, PagePosition pagePosition) {
        this.zOrder = PageZOrder.FOREGROUND;
        uw.a(context, "context", null);
        uw.a(uri, "pdfFile", null);
        uw.a(pagePosition, ViewProps.POSITION, null);
        this.context = context;
        this.pdfFile = uri;
        this.pageIndex = i;
        this.position = pagePosition;
        this.matrix = new Matrix();
        this.provider = null;
    }

    public PagePdf(Context context, Uri uri, int i, Matrix matrix) {
        this.zOrder = PageZOrder.FOREGROUND;
        uw.a(context, "context", null);
        uw.a(uri, "pdfFile", null);
        uw.a(matrix, "matrix", null);
        this.context = context;
        this.pdfFile = uri;
        this.pageIndex = i;
        this.position = null;
        this.matrix = matrix;
        this.provider = null;
    }

    public PagePdf(Context context, DataProvider dataProvider, int i) {
        this(context, dataProvider, i, new Matrix());
    }

    public PagePdf(Context context, DataProvider dataProvider, int i, PagePosition pagePosition) {
        this.zOrder = PageZOrder.FOREGROUND;
        uw.a(context, "context", null);
        uw.a(dataProvider, "pdfDataProvider", null);
        uw.a(pagePosition, ViewProps.POSITION, null);
        this.context = context;
        this.provider = dataProvider;
        this.pageIndex = i;
        this.position = pagePosition;
        this.matrix = new Matrix();
        this.pdfFile = null;
    }

    public PagePdf(Context context, DataProvider dataProvider, int i, Matrix matrix) {
        this.zOrder = PageZOrder.FOREGROUND;
        uw.a(context, "context", null);
        uw.a(dataProvider, "pdfDataProvider", null);
        uw.a(matrix, "matrix", null);
        this.context = context;
        this.provider = dataProvider;
        this.pageIndex = i;
        this.position = null;
        this.matrix = matrix;
        this.pdfFile = null;
    }

    public PagePdf(Context context, PdfDocument pdfDocument, int i) {
        this(context, pdfDocument, i, new Matrix());
    }

    public PagePdf(Context context, PdfDocument pdfDocument, int i, Matrix matrix) {
        this(context, pdfDocument, i, matrix, null);
    }

    public PagePdf(Context context, PdfDocument pdfDocument, int i, PagePosition pagePosition) {
        this(context, pdfDocument, i, new Matrix(), pagePosition);
    }

    private PagePdf(Context context, PdfDocument pdfDocument, int i, Matrix matrix, PagePosition pagePosition) {
        this.zOrder = PageZOrder.FOREGROUND;
        uw.a(context, "context", null);
        uw.a(pdfDocument, "document", null);
        uw.a(matrix, "matrix", null);
        lm lmVar = (lm) pdfDocument;
        List listUnmodifiableList = Collections.unmodifiableList(lmVar.A);
        listUnmodifiableList.getClass();
        DocumentSource documentSource = (DocumentSource) listUnmodifiableList.get(lmVar.c(i));
        if (documentSource.isFileSource()) {
            this.pdfFile = documentSource.getFileUri();
            this.provider = null;
        } else {
            this.provider = documentSource.getDataProvider();
            this.pdfFile = null;
        }
        this.password = documentSource.getPassword();
        this.context = context;
        this.pageIndex = i;
        this.position = pagePosition;
        this.matrix = matrix;
    }
}

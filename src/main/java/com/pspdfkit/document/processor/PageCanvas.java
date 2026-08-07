package com.pspdfkit.document.processor;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.pdf.PdfDocument;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeItemConfiguration;
import com.pspdfkit.internal.jni.NativeItemRelativePosition;
import com.pspdfkit.internal.jni.NativeItemZPosition;
import com.pspdfkit.internal.rq;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.Size;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class PageCanvas {
    private final NewPage.OnDrawCanvasCallback canvasCallback;
    private Matrix matrix;
    private final Size pageSize;
    private PagePosition position;
    private PageZOrder zOrder;

    public PageCanvas(Size size, NewPage.OnDrawCanvasCallback onDrawCanvasCallback) {
        this.zOrder = PageZOrder.FOREGROUND;
        this.matrix = new Matrix();
        this.position = null;
        uw.a(size, "pageSize", null);
        uw.a(onDrawCanvasCallback, "callback", null);
        this.pageSize = size;
        this.canvasCallback = onDrawCanvasCallback;
    }

    public NativeItemConfiguration getItemConfiguration() {
        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.Page pageStartPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder((int) Math.ceil(this.pageSize.width), (int) Math.ceil(this.pageSize.height), 0).create());
        Canvas canvas = pageStartPage.getCanvas();
        canvas.translate(0.0f, ((float) Math.ceil(this.pageSize.height)) - this.pageSize.height);
        this.canvasCallback.onDrawCanvas(canvas);
        pdfDocument.finishPage(pageStartPage);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        try {
            try {
                pdfDocument.writeTo(byteArrayOutputStream);
                pdfDocument.close();
                return new NativeItemConfiguration(null, DataProviderShim.createNativeDataDescriptor(new rq(byteArrayOutputStream.toByteArray())), null, this.position == null ? null : NativeItemRelativePosition.values()[this.position.ordinal()], NativeItemZPosition.values()[this.zOrder.ordinal()], this.matrix);
            } catch (IOException e) {
                throw new IllegalStateException("Couldn't write the document canvas to an output stream.", e);
            }
        } catch (Throwable th) {
            pdfDocument.close();
            throw th;
        }
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public PagePosition getPosition() {
        return this.position;
    }

    public PageZOrder getZOrder() {
        return this.zOrder;
    }

    public void setZOrder(PageZOrder pageZOrder) {
        uw.a(pageZOrder, "zOrder", null);
        this.zOrder = pageZOrder;
    }

    public PageCanvas(Size size, NewPage.OnDrawCanvasCallback onDrawCanvasCallback, Matrix matrix) {
        this.zOrder = PageZOrder.FOREGROUND;
        this.matrix = new Matrix();
        this.position = null;
        uw.a(size, "pageSize", null);
        uw.a(onDrawCanvasCallback, "callback", null);
        uw.a(matrix, "matrix", null);
        this.pageSize = size;
        this.canvasCallback = onDrawCanvasCallback;
        this.position = null;
        this.matrix = matrix;
    }

    public PageCanvas(Size size, NewPage.OnDrawCanvasCallback onDrawCanvasCallback, PagePosition pagePosition) {
        this.zOrder = PageZOrder.FOREGROUND;
        this.matrix = new Matrix();
        this.position = null;
        uw.a(size, "pageSize", null);
        uw.a(onDrawCanvasCallback, "callback", null);
        uw.a(pagePosition, ViewProps.POSITION, null);
        this.pageSize = size;
        this.canvasCallback = onDrawCanvasCallback;
        this.position = pagePosition;
        this.matrix = new Matrix();
    }
}

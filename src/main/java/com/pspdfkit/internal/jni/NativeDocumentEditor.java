package com.pspdfkit.internal.jni;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentEditor {

    public static final class CppProxy extends NativeDocumentEditor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentEditor EditDocument(NativeDocument nativeDocument);

        public static native NativeDocumentEditor NewDocument();

        private native void nativeDestroy(long j);

        private native ArrayList<NativeEditingChange> native_addPage(long j, int i, NativeNewPageConfiguration nativeNewPageConfiguration);

        private native ArrayList<NativeEditingChange> native_addPages(long j, int i, ArrayList<NativeNewPageConfiguration> arrayList);

        private native boolean native_applyInstantJson(long j, String str, boolean z);

        private native boolean native_applyXfdf(long j, String str, NativeXFDFOptions nativeXFDFOptions);

        private native void native_beginUpdates(long j);

        private native boolean native_canRedo(long j);

        private native boolean native_canUndo(long j);

        private native void native_changeBox(long j, int i, NativePDFBoxType nativePDFBoxType, RectF rectF);

        private native void native_clearPageLabels(long j);

        private native void native_clearRenderedPagesCache(long j);

        private native ArrayList<NativeEditingChange> native_commitUpdates(long j);

        private native ArrayList<NativeEditingChange> native_discardUpdates(long j);

        private native ArrayList<NativeEditingChange> native_duplicatePages(long j, HashSet<Integer> hashSet);

        private native boolean native_exportPagesToDataSink(long j, HashSet<Integer> hashSet, NativeDataSink nativeDataSink, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native boolean native_exportPagesToFilePath(long j, HashSet<Integer> hashSet, String str, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native int native_getPageCount(long j);

        private native Size native_getRotatedPageSize(long j, int i);

        private native int native_getRotation(long j, int i);

        private native boolean native_isInsideUpdateGroup(long j);

        private native boolean native_isPageRenderedInCache(long j, int i, int i2, int i3, int i4, NativePageRenderingConfig nativePageRenderingConfig);

        private native ArrayList<NativeEditingChange> native_movePages(long j, HashSet<Integer> hashSet, int i);

        private native ArrayList<NativeEditingChange> native_redo(long j);

        private native ArrayList<NativeEditingChange> native_removePages(long j, HashSet<Integer> hashSet);

        private native void native_render(long j, int i, Bitmap bitmap, NativePageRenderingConfig nativePageRenderingConfig);

        private native ArrayList<NativeEditingChange> native_rotatePagesBy(long j, HashSet<Integer> hashSet, int i);

        private native void native_setMaxMemoryLimitForRenderedPagesCache(long j, long j2);

        private native void native_setPageLabel(long j, int i, String str);

        private native ArrayList<NativeEditingChange> native_undo(long j);

        private native boolean native_writeToDataSink(long j, NativeDataSink nativeDataSink, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native boolean native_writeToFilePath(long j, String str, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> addPage(int i, NativeNewPageConfiguration nativeNewPageConfiguration) {
            return native_addPage(this.nativeRef, i, nativeNewPageConfiguration);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> addPages(int i, ArrayList<NativeNewPageConfiguration> arrayList) {
            return native_addPages(this.nativeRef, i, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean applyInstantJson(String str, boolean z) {
            return native_applyInstantJson(this.nativeRef, str, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean applyXfdf(String str, NativeXFDFOptions nativeXFDFOptions) {
            return native_applyXfdf(this.nativeRef, str, nativeXFDFOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public void beginUpdates() {
            native_beginUpdates(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean canRedo() {
            return native_canRedo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean canUndo() {
            return native_canUndo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public void changeBox(int i, NativePDFBoxType nativePDFBoxType, RectF rectF) {
            native_changeBox(this.nativeRef, i, nativePDFBoxType, rectF);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public void clearPageLabels() {
            native_clearPageLabels(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public void clearRenderedPagesCache() {
            native_clearRenderedPagesCache(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> commitUpdates() {
            return native_commitUpdates(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> discardUpdates() {
            return native_discardUpdates(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> duplicatePages(HashSet<Integer> hashSet) {
            return native_duplicatePages(this.nativeRef, hashSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean exportPagesToDataSink(HashSet<Integer> hashSet, NativeDataSink nativeDataSink, NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_exportPagesToDataSink(this.nativeRef, hashSet, nativeDataSink, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean exportPagesToFilePath(HashSet<Integer> hashSet, String str, NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_exportPagesToFilePath(this.nativeRef, hashSet, str, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public int getPageCount() {
            return native_getPageCount(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public Size getRotatedPageSize(int i) {
            return native_getRotatedPageSize(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public int getRotation(int i) {
            return native_getRotation(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean isInsideUpdateGroup() {
            return native_isInsideUpdateGroup(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean isPageRenderedInCache(int i, int i2, int i3, int i4, NativePageRenderingConfig nativePageRenderingConfig) {
            return native_isPageRenderedInCache(this.nativeRef, i, i2, i3, i4, nativePageRenderingConfig);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> movePages(HashSet<Integer> hashSet, int i) {
            return native_movePages(this.nativeRef, hashSet, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> redo() {
            return native_redo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> removePages(HashSet<Integer> hashSet) {
            return native_removePages(this.nativeRef, hashSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public void render(int i, Bitmap bitmap, NativePageRenderingConfig nativePageRenderingConfig) {
            native_render(this.nativeRef, i, bitmap, nativePageRenderingConfig);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> rotatePagesBy(HashSet<Integer> hashSet, int i) {
            return native_rotatePagesBy(this.nativeRef, hashSet, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public void setMaxMemoryLimitForRenderedPagesCache(long j) {
            native_setMaxMemoryLimitForRenderedPagesCache(this.nativeRef, j);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public void setPageLabel(int i, String str) {
            native_setPageLabel(this.nativeRef, i, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public ArrayList<NativeEditingChange> undo() {
            return native_undo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean writeToDataSink(NativeDataSink nativeDataSink, NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_writeToDataSink(this.nativeRef, nativeDataSink, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentEditor
        public boolean writeToFilePath(String str, NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_writeToFilePath(this.nativeRef, str, nativeDocumentSaveOptions);
        }
    }

    public static NativeDocumentEditor EditDocument(NativeDocument nativeDocument) {
        return CppProxy.EditDocument(nativeDocument);
    }

    public static NativeDocumentEditor NewDocument() {
        return CppProxy.NewDocument();
    }

    public abstract ArrayList<NativeEditingChange> addPage(int i, NativeNewPageConfiguration nativeNewPageConfiguration);

    public abstract ArrayList<NativeEditingChange> addPages(int i, ArrayList<NativeNewPageConfiguration> arrayList);

    public abstract boolean applyInstantJson(String str, boolean z);

    public abstract boolean applyXfdf(String str, NativeXFDFOptions nativeXFDFOptions);

    public abstract void beginUpdates();

    public abstract boolean canRedo();

    public abstract boolean canUndo();

    public abstract void changeBox(int i, NativePDFBoxType nativePDFBoxType, RectF rectF);

    public abstract void clearPageLabels();

    public abstract void clearRenderedPagesCache();

    public abstract ArrayList<NativeEditingChange> commitUpdates();

    public abstract ArrayList<NativeEditingChange> discardUpdates();

    public abstract ArrayList<NativeEditingChange> duplicatePages(HashSet<Integer> hashSet);

    public abstract boolean exportPagesToDataSink(HashSet<Integer> hashSet, NativeDataSink nativeDataSink, NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract boolean exportPagesToFilePath(HashSet<Integer> hashSet, String str, NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract int getPageCount();

    public abstract Size getRotatedPageSize(int i);

    public abstract int getRotation(int i);

    public abstract boolean isInsideUpdateGroup();

    public abstract boolean isPageRenderedInCache(int i, int i2, int i3, int i4, NativePageRenderingConfig nativePageRenderingConfig);

    public abstract ArrayList<NativeEditingChange> movePages(HashSet<Integer> hashSet, int i);

    public abstract ArrayList<NativeEditingChange> redo();

    public abstract ArrayList<NativeEditingChange> removePages(HashSet<Integer> hashSet);

    public abstract void render(int i, Bitmap bitmap, NativePageRenderingConfig nativePageRenderingConfig);

    public abstract ArrayList<NativeEditingChange> rotatePagesBy(HashSet<Integer> hashSet, int i);

    public abstract void setMaxMemoryLimitForRenderedPagesCache(long j);

    public abstract void setPageLabel(int i, String str);

    public abstract ArrayList<NativeEditingChange> undo();

    public abstract boolean writeToDataSink(NativeDataSink nativeDataSink, NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract boolean writeToFilePath(String str, NativeDocumentSaveOptions nativeDocumentSaveOptions);
}

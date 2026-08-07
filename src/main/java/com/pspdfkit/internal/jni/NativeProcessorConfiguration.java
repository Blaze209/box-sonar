package com.pspdfkit.internal.jni;

import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeProcessorConfiguration {
    public static final String METADATA_AUTHOR = "Author";
    public static final String METADATA_CREATION_DATE = "CreationDate";
    public static final String METADATA_CREATOR = "Creator";
    public static final String METADATA_DEFAULT_PRODUCER = "PSPDFKit";
    public static final String METADATA_KEYWORDS = "Keywords";
    public static final String METADATA_MODIFICATION_DATE = "ModDate";
    public static final String METADATA_PRODUCER = "Producer";
    public static final String METADATA_SUBJECT = "Subject";
    public static final String METADATA_TITLE = "Title";

    public static final class CppProxy extends NativeProcessorConfiguration {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeProcessorConfiguration copy(NativeProcessorConfiguration nativeProcessorConfiguration);

        public static native NativeProcessorConfiguration create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native void native_addNewPage(long j, int i, NativeNewPageConfiguration nativeNewPageConfiguration);

        private native void native_adjustPageColors(long j, int i, Integer num, EnumSet<NativePageColorOptions> enumSet);

        private native void native_applyAllRedactAnnotations(long j);

        private native void native_applyRedactAnnotations(long j, int i);

        private native void native_changeBox(long j, int i, NativePDFBoxType nativePDFBoxType, RectF rectF);

        private native void native_changeFormFieldNames(long j, HashMap<String, String> map);

        private native void native_changeFormMappingNames(long j, HashMap<String, String> map);

        private native void native_changePageIndex(long j, HashSet<Integer> hashSet);

        private native void native_clearApplyRedactAnnotations(long j, int i);

        private native void native_clearMetadata(long j);

        private native void native_clearPageColorAdjustment(long j, int i);

        private native void native_clearPageLabels(long j);

        private native void native_clearPerformOcr(long j, HashSet<Integer> hashSet);

        private native NativeProcessOperation native_getAnnotationOperation(long j, int i, int i2, NativeAnnotationType nativeAnnotationType);

        private native HashMap<String, String> native_getMetadata(long j);

        private native int native_getPageCount(long j);

        private native NativePageInfo native_getPageInfo(long j, int i);

        private native void native_mergeAutoRotatedContentFromDataDescriptor(long j, int i, NativeDataDescriptor nativeDataDescriptor, int i2, NativeItemZPosition nativeItemZPosition, Matrix matrix, NativeBlendMode nativeBlendMode);

        private native void native_mergeContentFromDataDescriptor(long j, int i, NativeDataDescriptor nativeDataDescriptor, int i2, NativeItemZPosition nativeItemZPosition, Matrix matrix, NativeBlendMode nativeBlendMode);

        private native void native_mergeContentFromItem(long j, int i, NativeItemConfiguration nativeItemConfiguration);

        private native void native_movePages(long j, HashSet<Integer> hashSet, int i);

        private native void native_performOcr(long j, HashSet<Integer> hashSet, NativeOcrLanguage nativeOcrLanguage);

        private native void native_processAnnotations(long j, ArrayList<NativeAnnotation> arrayList, NativeProcessOperation nativeProcessOperation);

        private native void native_processAnnotationsWithOperation(long j, ArrayList<NativeAnnotationType> arrayList, NativeProcessOperation nativeProcessOperation);

        private native void native_processFormsWithOperation(long j, ArrayList<NativeFormType> arrayList, NativeProcessOperation nativeProcessOperation);

        private native void native_removeAllPages(long j);

        private native void native_removePages(long j, HashSet<Integer> hashSet);

        private native void native_rotatePage(long j, int i, int i2);

        private native void native_scalePage(long j, int i, int i2, int i3, NativePageSizeFormat nativePageSizeFormat);

        private native void native_setPageLabel(long j, int i, String str);

        private native void native_setShouldStripGeneratedBlankPages(long j, boolean z);

        private native void native_updateMetadata(long j, HashMap<String, String> map);

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

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void addNewPage(int i, NativeNewPageConfiguration nativeNewPageConfiguration) {
            native_addNewPage(this.nativeRef, i, nativeNewPageConfiguration);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void adjustPageColors(int i, Integer num, EnumSet<NativePageColorOptions> enumSet) {
            native_adjustPageColors(this.nativeRef, i, num, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void applyAllRedactAnnotations() {
            native_applyAllRedactAnnotations(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void applyRedactAnnotations(int i) {
            native_applyRedactAnnotations(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void changeBox(int i, NativePDFBoxType nativePDFBoxType, RectF rectF) {
            native_changeBox(this.nativeRef, i, nativePDFBoxType, rectF);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void changeFormFieldNames(HashMap<String, String> map) {
            native_changeFormFieldNames(this.nativeRef, map);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void changeFormMappingNames(HashMap<String, String> map) {
            native_changeFormMappingNames(this.nativeRef, map);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void changePageIndex(HashSet<Integer> hashSet) {
            native_changePageIndex(this.nativeRef, hashSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void clearApplyRedactAnnotations(int i) {
            native_clearApplyRedactAnnotations(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void clearMetadata() {
            native_clearMetadata(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void clearPageColorAdjustment(int i) {
            native_clearPageColorAdjustment(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void clearPageLabels() {
            native_clearPageLabels(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void clearPerformOcr(HashSet<Integer> hashSet) {
            native_clearPerformOcr(this.nativeRef, hashSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public NativeProcessOperation getAnnotationOperation(int i, int i2, NativeAnnotationType nativeAnnotationType) {
            return native_getAnnotationOperation(this.nativeRef, i, i2, nativeAnnotationType);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public HashMap<String, String> getMetadata() {
            return native_getMetadata(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public int getPageCount() {
            return native_getPageCount(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public NativePageInfo getPageInfo(int i) {
            return native_getPageInfo(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void mergeAutoRotatedContentFromDataDescriptor(int i, NativeDataDescriptor nativeDataDescriptor, int i2, NativeItemZPosition nativeItemZPosition, Matrix matrix, NativeBlendMode nativeBlendMode) {
            native_mergeAutoRotatedContentFromDataDescriptor(this.nativeRef, i, nativeDataDescriptor, i2, nativeItemZPosition, matrix, nativeBlendMode);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void mergeContentFromDataDescriptor(int i, NativeDataDescriptor nativeDataDescriptor, int i2, NativeItemZPosition nativeItemZPosition, Matrix matrix, NativeBlendMode nativeBlendMode) {
            native_mergeContentFromDataDescriptor(this.nativeRef, i, nativeDataDescriptor, i2, nativeItemZPosition, matrix, nativeBlendMode);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void mergeContentFromItem(int i, NativeItemConfiguration nativeItemConfiguration) {
            native_mergeContentFromItem(this.nativeRef, i, nativeItemConfiguration);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void movePages(HashSet<Integer> hashSet, int i) {
            native_movePages(this.nativeRef, hashSet, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void performOcr(HashSet<Integer> hashSet, NativeOcrLanguage nativeOcrLanguage) {
            native_performOcr(this.nativeRef, hashSet, nativeOcrLanguage);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void processAnnotations(ArrayList<NativeAnnotation> arrayList, NativeProcessOperation nativeProcessOperation) {
            native_processAnnotations(this.nativeRef, arrayList, nativeProcessOperation);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void processAnnotationsWithOperation(ArrayList<NativeAnnotationType> arrayList, NativeProcessOperation nativeProcessOperation) {
            native_processAnnotationsWithOperation(this.nativeRef, arrayList, nativeProcessOperation);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void processFormsWithOperation(ArrayList<NativeFormType> arrayList, NativeProcessOperation nativeProcessOperation) {
            native_processFormsWithOperation(this.nativeRef, arrayList, nativeProcessOperation);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void removeAllPages() {
            native_removeAllPages(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void removePages(HashSet<Integer> hashSet) {
            native_removePages(this.nativeRef, hashSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void rotatePage(int i, int i2) {
            native_rotatePage(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void scalePage(int i, int i2, int i3, NativePageSizeFormat nativePageSizeFormat) {
            native_scalePage(this.nativeRef, i, i2, i3, nativePageSizeFormat);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void setPageLabel(int i, String str) {
            native_setPageLabel(this.nativeRef, i, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void setShouldStripGeneratedBlankPages(boolean z) {
            native_setShouldStripGeneratedBlankPages(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeProcessorConfiguration
        public void updateMetadata(HashMap<String, String> map) {
            native_updateMetadata(this.nativeRef, map);
        }
    }

    public static NativeProcessorConfiguration copy(NativeProcessorConfiguration nativeProcessorConfiguration) {
        return CppProxy.copy(nativeProcessorConfiguration);
    }

    public static NativeProcessorConfiguration create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract void addNewPage(int i, NativeNewPageConfiguration nativeNewPageConfiguration);

    public abstract void adjustPageColors(int i, Integer num, EnumSet<NativePageColorOptions> enumSet);

    public abstract void applyAllRedactAnnotations();

    public abstract void applyRedactAnnotations(int i);

    public abstract void changeBox(int i, NativePDFBoxType nativePDFBoxType, RectF rectF);

    public abstract void changeFormFieldNames(HashMap<String, String> map);

    public abstract void changeFormMappingNames(HashMap<String, String> map);

    public abstract void changePageIndex(HashSet<Integer> hashSet);

    public abstract void clearApplyRedactAnnotations(int i);

    public abstract void clearMetadata();

    public abstract void clearPageColorAdjustment(int i);

    public abstract void clearPageLabels();

    public abstract void clearPerformOcr(HashSet<Integer> hashSet);

    public abstract NativeProcessOperation getAnnotationOperation(int i, int i2, NativeAnnotationType nativeAnnotationType);

    public abstract HashMap<String, String> getMetadata();

    public abstract int getPageCount();

    public abstract NativePageInfo getPageInfo(int i);

    public abstract void mergeAutoRotatedContentFromDataDescriptor(int i, NativeDataDescriptor nativeDataDescriptor, int i2, NativeItemZPosition nativeItemZPosition, Matrix matrix, NativeBlendMode nativeBlendMode);

    public abstract void mergeContentFromDataDescriptor(int i, NativeDataDescriptor nativeDataDescriptor, int i2, NativeItemZPosition nativeItemZPosition, Matrix matrix, NativeBlendMode nativeBlendMode);

    public abstract void mergeContentFromItem(int i, NativeItemConfiguration nativeItemConfiguration);

    public abstract void movePages(HashSet<Integer> hashSet, int i);

    public abstract void performOcr(HashSet<Integer> hashSet, NativeOcrLanguage nativeOcrLanguage);

    public abstract void processAnnotations(ArrayList<NativeAnnotation> arrayList, NativeProcessOperation nativeProcessOperation);

    public abstract void processAnnotationsWithOperation(ArrayList<NativeAnnotationType> arrayList, NativeProcessOperation nativeProcessOperation);

    public abstract void processFormsWithOperation(ArrayList<NativeFormType> arrayList, NativeProcessOperation nativeProcessOperation);

    public abstract void removeAllPages();

    public abstract void removePages(HashSet<Integer> hashSet);

    public abstract void rotatePage(int i, int i2);

    public abstract void scalePage(int i, int i2, int i3, NativePageSizeFormat nativePageSizeFormat);

    public abstract void setPageLabel(int i, String str);

    public abstract void setShouldStripGeneratedBlankPages(boolean z);

    public abstract void updateMetadata(HashMap<String, String> map);
}

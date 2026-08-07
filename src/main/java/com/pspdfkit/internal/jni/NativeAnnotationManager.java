package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAnnotationManager {

    public static final class CppProxy extends NativeAnnotationManager {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeResult attachBinaryInstantJson(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider, String str);

        public static native NativeAnnotationManager create(NativeDocument nativeDocument, NativeDataProvider nativeDataProvider);

        public static native boolean hasBinaryInstantJsonAttachment(NativeAnnotation nativeAnnotation);

        private native void nativeDestroy(long j);

        private native NativeAnnotation native_appendAnnotationState(long j, NativeAnnotation nativeAnnotation, NativeAnnotationStateChange nativeAnnotationStateChange);

        private native NativeResult native_attachToDocumentIfNotAttached(long j, NativeAnnotation nativeAnnotation, Integer num, Integer num2);

        private native void native_clearCache(long j);

        private native NativeAnnotation native_createAnnotation(long j, int i, NativeAnnotationType nativeAnnotationType, Integer num);

        private native NativeAnnotation native_createAnnotationFromInstantJson(long j, String str);

        private native void native_dropAnnotation(long j, int i);

        private native NativeAnnotation native_getAnnotation(long j, long j2, long j3);

        private native ArrayList<NativeAnnotation> native_getAnnotationReplies(long j, NativeAnnotation nativeAnnotation);

        private native ArrayList<NativeAnnotation> native_getAnnotations(long j, int i);

        private native ArrayList<NativeAnnotation> native_getAnnotationsForDeletion(long j, NativeAnnotation nativeAnnotation, NativeReplyType nativeReplyType);

        private native ArrayList<NativeAnnotation> native_getAnnotationsForMeasurementContentFormat(long j, NativeMeasurementContentFormat nativeMeasurementContentFormat);

        private native String native_getAnnotationsJson(long j, long j2);

        private native ArrayList<NativeAnnotation> native_getFlattenedAnnotationReplies(long j, NativeAnnotation nativeAnnotation, NativeReplyType nativeReplyType);

        private native NativeAnnotation native_getHeldAnnotation(long j, int i);

        private native int native_getInstantCommentCount(long j, NativeAnnotation nativeAnnotation);

        private native String native_getInstantIdentifier(long j, NativeAnnotation nativeAnnotation);

        private native byte[] native_getProperties(long j, NativeAnnotation nativeAnnotation);

        private native ArrayList<NativeAnnotationStateChange> native_getReviewHistory(long j, NativeAnnotation nativeAnnotation);

        private native NativeAnnotationReviewSummary native_getReviewSummary(long j, NativeAnnotation nativeAnnotation, String str);

        private native int native_holdAnnotation(long j, NativeAnnotation nativeAnnotation);

        private native ArrayList<NativeAnnotationMapping> native_refreshCacheForPage(long j, int i);

        private native NativeAnnotationListResult native_removeAnnotation(long j, NativeAnnotation nativeAnnotation);

        private native NativeResult native_reorderAnnotation(long j, long j2, int i, Integer num);

        private native void native_synchronizeAnnotationToBackend(long j, NativeAnnotation nativeAnnotation, boolean z);

        private native void native_synchronizeToBackend(long j);

        private native String native_toInstantJson(long j, NativeAnnotation nativeAnnotation);

        private native void native_updateAnnotationTransforms(long j);

        private native NativeUpdatePropertiesResult native_updateProperties(long j, NativeAnnotation nativeAnnotation, byte[] bArr, byte[] bArr2);

        public static native NativeAttachmentResult writeBinaryInstantJsonAttachment(NativeAnnotation nativeAnnotation, NativeDataSink nativeDataSink);

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

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeAnnotation appendAnnotationState(NativeAnnotation nativeAnnotation, NativeAnnotationStateChange nativeAnnotationStateChange) {
            return native_appendAnnotationState(this.nativeRef, nativeAnnotation, nativeAnnotationStateChange);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeResult attachToDocumentIfNotAttached(NativeAnnotation nativeAnnotation, Integer num, Integer num2) {
            return native_attachToDocumentIfNotAttached(this.nativeRef, nativeAnnotation, num, num2);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public void clearCache() {
            native_clearCache(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeAnnotation createAnnotation(int i, NativeAnnotationType nativeAnnotationType, Integer num) {
            return native_createAnnotation(this.nativeRef, i, nativeAnnotationType, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeAnnotation createAnnotationFromInstantJson(String str) {
            return native_createAnnotationFromInstantJson(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public void dropAnnotation(int i) {
            native_dropAnnotation(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeAnnotation getAnnotation(long j, long j2) {
            return native_getAnnotation(this.nativeRef, j, j2);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public ArrayList<NativeAnnotation> getAnnotationReplies(NativeAnnotation nativeAnnotation) {
            return native_getAnnotationReplies(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public ArrayList<NativeAnnotation> getAnnotations(int i) {
            return native_getAnnotations(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public ArrayList<NativeAnnotation> getAnnotationsForDeletion(NativeAnnotation nativeAnnotation, NativeReplyType nativeReplyType) {
            return native_getAnnotationsForDeletion(this.nativeRef, nativeAnnotation, nativeReplyType);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public ArrayList<NativeAnnotation> getAnnotationsForMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat) {
            return native_getAnnotationsForMeasurementContentFormat(this.nativeRef, nativeMeasurementContentFormat);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public String getAnnotationsJson(long j) {
            return native_getAnnotationsJson(this.nativeRef, j);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public ArrayList<NativeAnnotation> getFlattenedAnnotationReplies(NativeAnnotation nativeAnnotation, NativeReplyType nativeReplyType) {
            return native_getFlattenedAnnotationReplies(this.nativeRef, nativeAnnotation, nativeReplyType);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeAnnotation getHeldAnnotation(int i) {
            return native_getHeldAnnotation(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public int getInstantCommentCount(NativeAnnotation nativeAnnotation) {
            return native_getInstantCommentCount(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public String getInstantIdentifier(NativeAnnotation nativeAnnotation) {
            return native_getInstantIdentifier(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public byte[] getProperties(NativeAnnotation nativeAnnotation) {
            return native_getProperties(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public ArrayList<NativeAnnotationStateChange> getReviewHistory(NativeAnnotation nativeAnnotation) {
            return native_getReviewHistory(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeAnnotationReviewSummary getReviewSummary(NativeAnnotation nativeAnnotation, String str) {
            return native_getReviewSummary(this.nativeRef, nativeAnnotation, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public int holdAnnotation(NativeAnnotation nativeAnnotation) {
            return native_holdAnnotation(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public ArrayList<NativeAnnotationMapping> refreshCacheForPage(int i) {
            return native_refreshCacheForPage(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeAnnotationListResult removeAnnotation(NativeAnnotation nativeAnnotation) {
            return native_removeAnnotation(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeResult reorderAnnotation(long j, int i, Integer num) {
            return native_reorderAnnotation(this.nativeRef, j, i, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public void synchronizeAnnotationToBackend(NativeAnnotation nativeAnnotation, boolean z) {
            native_synchronizeAnnotationToBackend(this.nativeRef, nativeAnnotation, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public void synchronizeToBackend() {
            native_synchronizeToBackend(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public String toInstantJson(NativeAnnotation nativeAnnotation) {
            return native_toInstantJson(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public void updateAnnotationTransforms() {
            native_updateAnnotationTransforms(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationManager
        public NativeUpdatePropertiesResult updateProperties(NativeAnnotation nativeAnnotation, byte[] bArr, byte[] bArr2) {
            return native_updateProperties(this.nativeRef, nativeAnnotation, bArr, bArr2);
        }
    }

    public static NativeResult attachBinaryInstantJson(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider, String str) {
        return CppProxy.attachBinaryInstantJson(nativeAnnotation, nativeDataProvider, str);
    }

    public static NativeAnnotationManager create(NativeDocument nativeDocument, NativeDataProvider nativeDataProvider) {
        return CppProxy.create(nativeDocument, nativeDataProvider);
    }

    public static boolean hasBinaryInstantJsonAttachment(NativeAnnotation nativeAnnotation) {
        return CppProxy.hasBinaryInstantJsonAttachment(nativeAnnotation);
    }

    public static NativeAttachmentResult writeBinaryInstantJsonAttachment(NativeAnnotation nativeAnnotation, NativeDataSink nativeDataSink) {
        return CppProxy.writeBinaryInstantJsonAttachment(nativeAnnotation, nativeDataSink);
    }

    public abstract NativeAnnotation appendAnnotationState(NativeAnnotation nativeAnnotation, NativeAnnotationStateChange nativeAnnotationStateChange);

    public abstract NativeResult attachToDocumentIfNotAttached(NativeAnnotation nativeAnnotation, Integer num, Integer num2);

    public abstract void clearCache();

    public abstract NativeAnnotation createAnnotation(int i, NativeAnnotationType nativeAnnotationType, Integer num);

    public abstract NativeAnnotation createAnnotationFromInstantJson(String str);

    public abstract void dropAnnotation(int i);

    public abstract NativeAnnotation getAnnotation(long j, long j2);

    public abstract ArrayList<NativeAnnotation> getAnnotationReplies(NativeAnnotation nativeAnnotation);

    public abstract ArrayList<NativeAnnotation> getAnnotations(int i);

    public abstract ArrayList<NativeAnnotation> getAnnotationsForDeletion(NativeAnnotation nativeAnnotation, NativeReplyType nativeReplyType);

    public abstract ArrayList<NativeAnnotation> getAnnotationsForMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat);

    public abstract String getAnnotationsJson(long j);

    public abstract ArrayList<NativeAnnotation> getFlattenedAnnotationReplies(NativeAnnotation nativeAnnotation, NativeReplyType nativeReplyType);

    public abstract NativeAnnotation getHeldAnnotation(int i);

    public abstract int getInstantCommentCount(NativeAnnotation nativeAnnotation);

    public abstract String getInstantIdentifier(NativeAnnotation nativeAnnotation);

    public abstract byte[] getProperties(NativeAnnotation nativeAnnotation);

    public abstract ArrayList<NativeAnnotationStateChange> getReviewHistory(NativeAnnotation nativeAnnotation);

    public abstract NativeAnnotationReviewSummary getReviewSummary(NativeAnnotation nativeAnnotation, String str);

    public abstract int holdAnnotation(NativeAnnotation nativeAnnotation);

    public abstract ArrayList<NativeAnnotationMapping> refreshCacheForPage(int i);

    public abstract NativeAnnotationListResult removeAnnotation(NativeAnnotation nativeAnnotation);

    public abstract NativeResult reorderAnnotation(long j, int i, Integer num);

    public abstract void synchronizeAnnotationToBackend(NativeAnnotation nativeAnnotation, boolean z);

    public abstract void synchronizeToBackend();

    public abstract String toInstantJson(NativeAnnotation nativeAnnotation);

    public abstract void updateAnnotationTransforms();

    public abstract NativeUpdatePropertiesResult updateProperties(NativeAnnotation nativeAnnotation, byte[] bArr, byte[] bArr2);
}

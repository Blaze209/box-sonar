package com.pspdfkit.internal.jni;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAnnotation {

    public static final class CppProxy extends NativeAnnotation {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        private native Integer native_getAbsolutePageIndex(long j);

        private native Boolean native_getAdditionalDataBoolean(long j, String str);

        private native String native_getAdditionalDataString(long j, String str);

        private native Long native_getAnnotationId(long j);

        private native NativeAnnotationType native_getAnnotationType(long j);

        private native String native_getAnnotationTypeString(long j);

        private native long native_getIdentifier(long j);

        private native String native_getInstantRecordGroup(long j);

        private native EnumSet<NativeInstantRecordOperations> native_getInstantRecordOperations(long j);

        private native Float native_getLineHeightFactor(long j);

        private native Integer native_getPageIndex(long j);

        private native NativePlatformAnnotation native_getPlatformAnnotation(long j);

        private native boolean native_hasAppearanceStream(long j);

        private native boolean native_isMeasurementTextDisplayed(long j);

        private native boolean native_isSavedToDocument(long j);

        private native void native_setAdditionalDataBoolean(long j, String str, Boolean bool, boolean z);

        private native void native_setAdditionalDataString(long j, String str, String str2, boolean z);

        private native void native_setInstantRecordGroup(long j, String str);

        private native void native_setIsSavedToDocument(long j, boolean z);

        private native void native_setPlatformAnnotation(long j, NativePlatformAnnotation nativePlatformAnnotation);

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

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public Integer getAbsolutePageIndex() {
            return native_getAbsolutePageIndex(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public Boolean getAdditionalDataBoolean(String str) {
            return native_getAdditionalDataBoolean(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public String getAdditionalDataString(String str) {
            return native_getAdditionalDataString(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public Long getAnnotationId() {
            return native_getAnnotationId(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public NativeAnnotationType getAnnotationType() {
            return native_getAnnotationType(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public String getAnnotationTypeString() {
            return native_getAnnotationTypeString(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public long getIdentifier() {
            return native_getIdentifier(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public String getInstantRecordGroup() {
            return native_getInstantRecordGroup(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public EnumSet<NativeInstantRecordOperations> getInstantRecordOperations() {
            return native_getInstantRecordOperations(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public Float getLineHeightFactor() {
            return native_getLineHeightFactor(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public Integer getPageIndex() {
            return native_getPageIndex(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public NativePlatformAnnotation getPlatformAnnotation() {
            return native_getPlatformAnnotation(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public boolean hasAppearanceStream() {
            return native_hasAppearanceStream(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public boolean isMeasurementTextDisplayed() {
            return native_isMeasurementTextDisplayed(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public boolean isSavedToDocument() {
            return native_isSavedToDocument(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public void setAdditionalDataBoolean(String str, Boolean bool, boolean z) {
            native_setAdditionalDataBoolean(this.nativeRef, str, bool, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public void setAdditionalDataString(String str, String str2, boolean z) {
            native_setAdditionalDataString(this.nativeRef, str, str2, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public void setInstantRecordGroup(String str) {
            native_setInstantRecordGroup(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public void setIsSavedToDocument(boolean z) {
            native_setIsSavedToDocument(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotation
        public void setPlatformAnnotation(NativePlatformAnnotation nativePlatformAnnotation) {
            native_setPlatformAnnotation(this.nativeRef, nativePlatformAnnotation);
        }
    }

    public abstract Integer getAbsolutePageIndex();

    public abstract Boolean getAdditionalDataBoolean(String str);

    public abstract String getAdditionalDataString(String str);

    public abstract Long getAnnotationId();

    public abstract NativeAnnotationType getAnnotationType();

    public abstract String getAnnotationTypeString();

    public abstract long getIdentifier();

    public abstract String getInstantRecordGroup();

    public abstract EnumSet<NativeInstantRecordOperations> getInstantRecordOperations();

    public abstract Float getLineHeightFactor();

    public abstract Integer getPageIndex();

    public abstract NativePlatformAnnotation getPlatformAnnotation();

    public abstract boolean hasAppearanceStream();

    public abstract boolean isMeasurementTextDisplayed();

    public abstract boolean isSavedToDocument();

    public abstract void setAdditionalDataBoolean(String str, Boolean bool, boolean z);

    public abstract void setAdditionalDataString(String str, String str2, boolean z);

    public abstract void setInstantRecordGroup(String str);

    public abstract void setIsSavedToDocument(boolean z);

    public abstract void setPlatformAnnotation(NativePlatformAnnotation nativePlatformAnnotation);
}

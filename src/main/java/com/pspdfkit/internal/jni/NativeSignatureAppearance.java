package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeSignatureAppearance {

    public static final class CppProxy extends NativeSignatureAppearance {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeSignatureAppearance create(NativeSignatureAppearanceMode nativeSignatureAppearanceMode);

        private native void nativeDestroy(long j);

        private native boolean native_getReuseExistingSignatureAppearanceStream(long j);

        private native boolean native_getShowDateTimezone(long j);

        private native boolean native_getShowSignDate(long j);

        private native boolean native_getShowSignatureLocation(long j);

        private native boolean native_getShowSignatureReason(long j);

        private native boolean native_getShowSignerName(long j);

        private native boolean native_getShowWatermark(long j);

        private native NativeSignatureAppearanceMode native_getSignatureAppearanceMode(long j);

        private native NativeAnnotationAppearanceStream native_getSignatureGraphic(long j);

        private native NativeAnnotationAppearanceStream native_getSignatureWatermark(long j);

        private native void native_setReuseExistingSignatureAppearanceStream(long j, boolean z);

        private native void native_setShowDateTimezone(long j, boolean z);

        private native void native_setShowSignDate(long j, boolean z);

        private native void native_setShowSignatureLocation(long j, boolean z);

        private native void native_setShowSignatureReason(long j, boolean z);

        private native void native_setShowSignerName(long j, boolean z);

        private native void native_setShowWatermark(long j, boolean z);

        private native void native_setSignatureGraphic(long j, NativeAnnotationAppearanceStream nativeAnnotationAppearanceStream);

        private native void native_setSignatureWatermark(long j, NativeAnnotationAppearanceStream nativeAnnotationAppearanceStream);

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

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public boolean getReuseExistingSignatureAppearanceStream() {
            return native_getReuseExistingSignatureAppearanceStream(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public boolean getShowDateTimezone() {
            return native_getShowDateTimezone(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public boolean getShowSignDate() {
            return native_getShowSignDate(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public boolean getShowSignatureLocation() {
            return native_getShowSignatureLocation(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public boolean getShowSignatureReason() {
            return native_getShowSignatureReason(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public boolean getShowSignerName() {
            return native_getShowSignerName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public boolean getShowWatermark() {
            return native_getShowWatermark(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public NativeSignatureAppearanceMode getSignatureAppearanceMode() {
            return native_getSignatureAppearanceMode(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public NativeAnnotationAppearanceStream getSignatureGraphic() {
            return native_getSignatureGraphic(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public NativeAnnotationAppearanceStream getSignatureWatermark() {
            return native_getSignatureWatermark(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setReuseExistingSignatureAppearanceStream(boolean z) {
            native_setReuseExistingSignatureAppearanceStream(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setShowDateTimezone(boolean z) {
            native_setShowDateTimezone(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setShowSignDate(boolean z) {
            native_setShowSignDate(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setShowSignatureLocation(boolean z) {
            native_setShowSignatureLocation(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setShowSignatureReason(boolean z) {
            native_setShowSignatureReason(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setShowSignerName(boolean z) {
            native_setShowSignerName(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setShowWatermark(boolean z) {
            native_setShowWatermark(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setSignatureGraphic(NativeAnnotationAppearanceStream nativeAnnotationAppearanceStream) {
            native_setSignatureGraphic(this.nativeRef, nativeAnnotationAppearanceStream);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureAppearance
        public void setSignatureWatermark(NativeAnnotationAppearanceStream nativeAnnotationAppearanceStream) {
            native_setSignatureWatermark(this.nativeRef, nativeAnnotationAppearanceStream);
        }
    }

    public static NativeSignatureAppearance create(NativeSignatureAppearanceMode nativeSignatureAppearanceMode) {
        return CppProxy.create(nativeSignatureAppearanceMode);
    }

    public abstract boolean getReuseExistingSignatureAppearanceStream();

    public abstract boolean getShowDateTimezone();

    public abstract boolean getShowSignDate();

    public abstract boolean getShowSignatureLocation();

    public abstract boolean getShowSignatureReason();

    public abstract boolean getShowSignerName();

    public abstract boolean getShowWatermark();

    public abstract NativeSignatureAppearanceMode getSignatureAppearanceMode();

    public abstract NativeAnnotationAppearanceStream getSignatureGraphic();

    public abstract NativeAnnotationAppearanceStream getSignatureWatermark();

    public abstract void setReuseExistingSignatureAppearanceStream(boolean z);

    public abstract void setShowDateTimezone(boolean z);

    public abstract void setShowSignDate(boolean z);

    public abstract void setShowSignatureLocation(boolean z);

    public abstract void setShowSignatureReason(boolean z);

    public abstract void setShowSignerName(boolean z);

    public abstract void setShowWatermark(boolean z);

    public abstract void setSignatureGraphic(NativeAnnotationAppearanceStream nativeAnnotationAppearanceStream);

    public abstract void setSignatureWatermark(NativeAnnotationAppearanceStream nativeAnnotationAppearanceStream);
}

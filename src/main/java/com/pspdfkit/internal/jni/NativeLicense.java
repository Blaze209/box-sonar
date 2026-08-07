package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeLicense {

    public static final class CppProxy extends NativeLicense {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeLicense license();

        private native void nativeDestroy(long j);

        private native ArrayList<String> native_allowedFileUris(long j);

        private native String native_extraContentSignature(long j);

        private native EnumSet<NativeLicenseFeatures> native_features(long j);

        private native boolean native_isBeta(long j);

        private native boolean native_isDemo(long j);

        private native boolean native_isManualDemo(long j);

        private native boolean native_isValidOrEvaluation(long j);

        private native ArrayList<String> native_jsonFeatures(long j);

        private native Date native_originalPurchaseDate(long j);

        private native NativeSignatureFeatureAvailability native_signatureFeatureAvailability(long j);

        private native boolean native_supportsAnyFeature(long j, EnumSet<NativeLicenseFeatures> enumSet);

        private native boolean native_supportsFeatures(long j, EnumSet<NativeLicenseFeatures> enumSet);

        public static native String rawJsonString();

        public static native void setLicenseDelegate(NativeLicenseDelegate nativeLicenseDelegate);

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

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public ArrayList<String> allowedFileUris() {
            return native_allowedFileUris(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public String extraContentSignature() {
            return native_extraContentSignature(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public EnumSet<NativeLicenseFeatures> features() {
            return native_features(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public boolean isBeta() {
            return native_isBeta(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public boolean isDemo() {
            return native_isDemo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public boolean isManualDemo() {
            return native_isManualDemo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public boolean isValidOrEvaluation() {
            return native_isValidOrEvaluation(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public ArrayList<String> jsonFeatures() {
            return native_jsonFeatures(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public Date originalPurchaseDate() {
            return native_originalPurchaseDate(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public NativeSignatureFeatureAvailability signatureFeatureAvailability() {
            return native_signatureFeatureAvailability(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public boolean supportsAnyFeature(EnumSet<NativeLicenseFeatures> enumSet) {
            return native_supportsAnyFeature(this.nativeRef, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeLicense
        public boolean supportsFeatures(EnumSet<NativeLicenseFeatures> enumSet) {
            return native_supportsFeatures(this.nativeRef, enumSet);
        }
    }

    public static NativeLicense license() {
        return CppProxy.license();
    }

    public static String rawJsonString() {
        return CppProxy.rawJsonString();
    }

    public static void setLicenseDelegate(NativeLicenseDelegate nativeLicenseDelegate) {
        CppProxy.setLicenseDelegate(nativeLicenseDelegate);
    }

    public abstract ArrayList<String> allowedFileUris();

    public abstract String extraContentSignature();

    public abstract EnumSet<NativeLicenseFeatures> features();

    public abstract boolean isBeta();

    public abstract boolean isDemo();

    public abstract boolean isManualDemo();

    public abstract boolean isValidOrEvaluation();

    public abstract ArrayList<String> jsonFeatures();

    public abstract Date originalPurchaseDate();

    public abstract NativeSignatureFeatureAvailability signatureFeatureAvailability();

    public abstract boolean supportsAnyFeature(EnumSet<NativeLicenseFeatures> enumSet);

    public abstract boolean supportsFeatures(EnumSet<NativeLicenseFeatures> enumSet);
}

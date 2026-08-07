package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeFormObserver {

    public static final class CppProxy extends NativeFormObserver {
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

        private native void native_formDidAddFormField(long j, NativeDocument nativeDocument, int i, NativeFormField nativeFormField);

        private native void native_formDidChange(long j, NativeDocument nativeDocument, int i, String str);

        private native void native_formDidChangeAction(long j, NativeDocument nativeDocument, int i, int i2);

        private native void native_formDidChangeButtonSelection(long j, NativeDocument nativeDocument, int i, String str, int i2, boolean z);

        private native void native_formDidChangeFlags(long j, NativeDocument nativeDocument, int i, int i2);

        private native void native_formDidReset(long j, NativeDocument nativeDocument, int i, String str, int i2);

        private native void native_formDidSelectOption(long j, NativeDocument nativeDocument, int i, String str, int i2, ArrayList<Integer> arrayList);

        private native void native_formDidSetCustomOption(long j, NativeDocument nativeDocument, int i, String str, int i2, String str2);

        private native void native_formDidSetMaxLength(long j, NativeDocument nativeDocument, int i, String str, int i2, int i3);

        private native void native_formDidSetRichText(long j, NativeDocument nativeDocument, int i, String str, int i2, String str2);

        private native void native_formDidSetText(long j, NativeDocument nativeDocument, int i, String str, int i2, String str2);

        private native void native_formDidSetValue(long j, NativeDocument nativeDocument, int i, String str);

        private native void native_formTabOrderDidRecalculate(long j, NativeDocument nativeDocument, int i);

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

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidAddFormField(NativeDocument nativeDocument, int i, NativeFormField nativeFormField) {
            native_formDidAddFormField(this.nativeRef, nativeDocument, i, nativeFormField);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidChange(NativeDocument nativeDocument, int i, String str) {
            native_formDidChange(this.nativeRef, nativeDocument, i, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidChangeAction(NativeDocument nativeDocument, int i, int i2) {
            native_formDidChangeAction(this.nativeRef, nativeDocument, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidChangeButtonSelection(NativeDocument nativeDocument, int i, String str, int i2, boolean z) {
            native_formDidChangeButtonSelection(this.nativeRef, nativeDocument, i, str, i2, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidChangeFlags(NativeDocument nativeDocument, int i, int i2) {
            native_formDidChangeFlags(this.nativeRef, nativeDocument, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidReset(NativeDocument nativeDocument, int i, String str, int i2) {
            native_formDidReset(this.nativeRef, nativeDocument, i, str, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidSelectOption(NativeDocument nativeDocument, int i, String str, int i2, ArrayList<Integer> arrayList) {
            native_formDidSelectOption(this.nativeRef, nativeDocument, i, str, i2, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidSetCustomOption(NativeDocument nativeDocument, int i, String str, int i2, String str2) {
            native_formDidSetCustomOption(this.nativeRef, nativeDocument, i, str, i2, str2);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidSetMaxLength(NativeDocument nativeDocument, int i, String str, int i2, int i3) {
            native_formDidSetMaxLength(this.nativeRef, nativeDocument, i, str, i2, i3);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidSetRichText(NativeDocument nativeDocument, int i, String str, int i2, String str2) {
            native_formDidSetRichText(this.nativeRef, nativeDocument, i, str, i2, str2);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidSetText(NativeDocument nativeDocument, int i, String str, int i2, String str2) {
            native_formDidSetText(this.nativeRef, nativeDocument, i, str, i2, str2);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formDidSetValue(NativeDocument nativeDocument, int i, String str) {
            native_formDidSetValue(this.nativeRef, nativeDocument, i, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormObserver
        public void formTabOrderDidRecalculate(NativeDocument nativeDocument, int i) {
            native_formTabOrderDidRecalculate(this.nativeRef, nativeDocument, i);
        }
    }

    public abstract void formDidAddFormField(NativeDocument nativeDocument, int i, NativeFormField nativeFormField);

    public abstract void formDidChange(NativeDocument nativeDocument, int i, String str);

    public abstract void formDidChangeAction(NativeDocument nativeDocument, int i, int i2);

    public abstract void formDidChangeButtonSelection(NativeDocument nativeDocument, int i, String str, int i2, boolean z);

    public abstract void formDidChangeFlags(NativeDocument nativeDocument, int i, int i2);

    public abstract void formDidReset(NativeDocument nativeDocument, int i, String str, int i2);

    public abstract void formDidSelectOption(NativeDocument nativeDocument, int i, String str, int i2, ArrayList<Integer> arrayList);

    public abstract void formDidSetCustomOption(NativeDocument nativeDocument, int i, String str, int i2, String str2);

    public abstract void formDidSetMaxLength(NativeDocument nativeDocument, int i, String str, int i2, int i3);

    public abstract void formDidSetRichText(NativeDocument nativeDocument, int i, String str, int i2, String str2);

    public abstract void formDidSetText(NativeDocument nativeDocument, int i, String str, int i2, String str2);

    public abstract void formDidSetValue(NativeDocument nativeDocument, int i, String str);

    public abstract void formTabOrderDidRecalculate(NativeDocument nativeDocument, int i);
}

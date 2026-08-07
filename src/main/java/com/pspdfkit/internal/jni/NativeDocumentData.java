package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentData {

    public static final class CppProxy extends NativeDocumentData {
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

        private native void native_clear(long j);

        private native void native_clearKey(long j, String str);

        private native Float native_getFloat(long j, String str);

        private native ArrayList<Float> native_getFloatList(long j, String str);

        private native Integer native_getInt(long j, String str);

        private native ArrayList<Integer> native_getIntList(long j, String str);

        private native ArrayList<String> native_getKeys(long j);

        private native String native_getString(long j, String str);

        private native ArrayList<String> native_getStringList(long j, String str);

        private native void native_putFloat(long j, String str, Float f);

        private native void native_putFloatList(long j, String str, ArrayList<Float> arrayList);

        private native void native_putInt(long j, String str, Integer num);

        private native void native_putIntList(long j, String str, ArrayList<Integer> arrayList);

        private native void native_putString(long j, String str, String str2);

        private native void native_putStringList(long j, String str, ArrayList<String> arrayList);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void clear() {
            native_clear(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void clearKey(String str) {
            native_clearKey(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public Float getFloat(String str) {
            return native_getFloat(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public ArrayList<Float> getFloatList(String str) {
            return native_getFloatList(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public Integer getInt(String str) {
            return native_getInt(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public ArrayList<Integer> getIntList(String str) {
            return native_getIntList(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public ArrayList<String> getKeys() {
            return native_getKeys(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public String getString(String str) {
            return native_getString(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public ArrayList<String> getStringList(String str) {
            return native_getStringList(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void putFloat(String str, Float f) {
            native_putFloat(this.nativeRef, str, f);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void putFloatList(String str, ArrayList<Float> arrayList) {
            native_putFloatList(this.nativeRef, str, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void putInt(String str, Integer num) {
            native_putInt(this.nativeRef, str, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void putIntList(String str, ArrayList<Integer> arrayList) {
            native_putIntList(this.nativeRef, str, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void putString(String str, String str2) {
            native_putString(this.nativeRef, str, str2);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentData
        public void putStringList(String str, ArrayList<String> arrayList) {
            native_putStringList(this.nativeRef, str, arrayList);
        }
    }

    public abstract void clear();

    public abstract void clearKey(String str);

    public abstract Float getFloat(String str);

    public abstract ArrayList<Float> getFloatList(String str);

    public abstract Integer getInt(String str);

    public abstract ArrayList<Integer> getIntList(String str);

    public abstract ArrayList<String> getKeys();

    public abstract String getString(String str);

    public abstract ArrayList<String> getStringList(String str);

    public abstract void putFloat(String str, Float f);

    public abstract void putFloatList(String str, ArrayList<Float> arrayList);

    public abstract void putInt(String str, Integer num);

    public abstract void putIntList(String str, ArrayList<Integer> arrayList);

    public abstract void putString(String str, String str2);

    public abstract void putStringList(String str, ArrayList<String> arrayList);
}

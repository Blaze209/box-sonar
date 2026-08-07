package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePDFObject {

    public static final class CppProxy extends NativePDFObject {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePDFObject createArray(ArrayList<NativePDFObject> arrayList);

        public static native NativePDFObject createBool(boolean z);

        public static native NativePDFObject createDictionary(HashMap<String, NativePDFObject> map);

        public static native NativePDFObject createDouble(double d);

        public static native NativePDFObject createInteger(long j);

        public static native NativePDFObject createString(String str);

        private native void nativeDestroy(long j);

        private native ArrayList<NativePDFObject> native_arrayValue(long j);

        private native boolean native_booleanValue(long j);

        private native HashMap<String, NativePDFObject> native_dictionaryValue(long j);

        private native double native_doubleValue(long j);

        private native long native_integerValue(long j);

        private native String native_stringValue(long j);

        private native NativePDFObjectType native_type(long j);

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

        @Override // com.pspdfkit.internal.jni.NativePDFObject
        public ArrayList<NativePDFObject> arrayValue() {
            return native_arrayValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFObject
        public boolean booleanValue() {
            return native_booleanValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFObject
        public HashMap<String, NativePDFObject> dictionaryValue() {
            return native_dictionaryValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFObject
        public double doubleValue() {
            return native_doubleValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFObject
        public long integerValue() {
            return native_integerValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFObject
        public String stringValue() {
            return native_stringValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFObject
        public NativePDFObjectType type() {
            return native_type(this.nativeRef);
        }
    }

    public static NativePDFObject createArray(ArrayList<NativePDFObject> arrayList) {
        return CppProxy.createArray(arrayList);
    }

    public static NativePDFObject createBool(boolean z) {
        return CppProxy.createBool(z);
    }

    public static NativePDFObject createDictionary(HashMap<String, NativePDFObject> map) {
        return CppProxy.createDictionary(map);
    }

    public static NativePDFObject createDouble(double d) {
        return CppProxy.createDouble(d);
    }

    public static NativePDFObject createInteger(long j) {
        return CppProxy.createInteger(j);
    }

    public static NativePDFObject createString(String str) {
        return CppProxy.createString(str);
    }

    public abstract ArrayList<NativePDFObject> arrayValue();

    public abstract boolean booleanValue();

    public abstract HashMap<String, NativePDFObject> dictionaryValue();

    public abstract double doubleValue();

    public abstract long integerValue();

    public abstract String stringValue();

    public abstract NativePDFObjectType type();
}

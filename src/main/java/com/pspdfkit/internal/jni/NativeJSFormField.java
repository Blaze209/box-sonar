package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeJSFormField {

    public static final class CppProxy extends NativeJSFormField {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeJSFormField create(ArrayList<NativeFormField> arrayList, NativeDocumentProvider nativeDocumentProvider);

        public static native NativeJSFormField findFormFieldFromFqn(String str, NativeJSFormField nativeJSFormField);

        private native void nativeDestroy(long j);

        private native NativeJSFormField native_getChild(long j, String str);

        private native ArrayList<NativeJSFormField> native_getChildren(long j);

        private native NativeDocumentProvider native_getDocumentProvider(long j);

        private native NativeAnnotation native_getFormElement(long j);

        private native NativeFormField native_getFormField(long j);

        private native String native_getFqn(long j);

        private native String native_getName(long j);

        private native void native_setFormField(long j, NativeFormField nativeFormField);

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

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public NativeJSFormField getChild(String str) {
            return native_getChild(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public ArrayList<NativeJSFormField> getChildren() {
            return native_getChildren(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public NativeDocumentProvider getDocumentProvider() {
            return native_getDocumentProvider(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public NativeAnnotation getFormElement() {
            return native_getFormElement(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public NativeFormField getFormField() {
            return native_getFormField(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public String getFqn() {
            return native_getFqn(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public String getName() {
            return native_getName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJSFormField
        public void setFormField(NativeFormField nativeFormField) {
            native_setFormField(this.nativeRef, nativeFormField);
        }
    }

    public static NativeJSFormField create(ArrayList<NativeFormField> arrayList, NativeDocumentProvider nativeDocumentProvider) {
        return CppProxy.create(arrayList, nativeDocumentProvider);
    }

    public static NativeJSFormField findFormFieldFromFqn(String str, NativeJSFormField nativeJSFormField) {
        return CppProxy.findFormFieldFromFqn(str, nativeJSFormField);
    }

    public abstract NativeJSFormField getChild(String str);

    public abstract ArrayList<NativeJSFormField> getChildren();

    public abstract NativeDocumentProvider getDocumentProvider();

    public abstract NativeAnnotation getFormElement();

    public abstract NativeFormField getFormField();

    public abstract String getFqn();

    public abstract String getName();

    public abstract void setFormField(NativeFormField nativeFormField);
}

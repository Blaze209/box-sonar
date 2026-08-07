package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeFormManager {

    public static final class CppProxy extends NativeFormManager {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeFormManager create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native NativeFormFieldCreationResult native_createAndInsertFormField(long j, NativeFormType nativeFormType, String str, ArrayList<NativeAnnotation> arrayList, ArrayList<String> arrayList2);

        private native ArrayList<ArrayList<NativeFormField>> native_getFormFields(long j);

        private native ArrayList<NativeFormField> native_getFormFieldsForProvider(long j, int i);

        private native ArrayList<NativeTabOrder> native_getTabOrder(long j);

        private native NativeTabOrder native_getTabOrderForProvider(long j, int i);

        private native void native_registerFormObserver(long j, NativeFormObserver nativeFormObserver);

        private native NativeFormRemovalResult native_removeFormFields(long j, ArrayList<NativeFormField> arrayList);

        private native NativeFormRemovalResult native_removeFormWidgets(long j, ArrayList<NativeAnnotation> arrayList);

        private native NativeFormResetResult native_resetForm(long j, ArrayList<NativeFormField> arrayList, EnumSet<NativeFormResetFlags> enumSet);

        private native void native_unregisterFormObserver(long j, NativeFormObserver nativeFormObserver);

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

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public NativeFormFieldCreationResult createAndInsertFormField(NativeFormType nativeFormType, String str, ArrayList<NativeAnnotation> arrayList, ArrayList<String> arrayList2) {
            return native_createAndInsertFormField(this.nativeRef, nativeFormType, str, arrayList, arrayList2);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public ArrayList<ArrayList<NativeFormField>> getFormFields() {
            return native_getFormFields(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public ArrayList<NativeFormField> getFormFieldsForProvider(int i) {
            return native_getFormFieldsForProvider(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public ArrayList<NativeTabOrder> getTabOrder() {
            return native_getTabOrder(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public NativeTabOrder getTabOrderForProvider(int i) {
            return native_getTabOrderForProvider(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public void registerFormObserver(NativeFormObserver nativeFormObserver) {
            native_registerFormObserver(this.nativeRef, nativeFormObserver);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public NativeFormRemovalResult removeFormFields(ArrayList<NativeFormField> arrayList) {
            return native_removeFormFields(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public NativeFormRemovalResult removeFormWidgets(ArrayList<NativeAnnotation> arrayList) {
            return native_removeFormWidgets(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public NativeFormResetResult resetForm(ArrayList<NativeFormField> arrayList, EnumSet<NativeFormResetFlags> enumSet) {
            return native_resetForm(this.nativeRef, arrayList, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormManager
        public void unregisterFormObserver(NativeFormObserver nativeFormObserver) {
            native_unregisterFormObserver(this.nativeRef, nativeFormObserver);
        }
    }

    public static NativeFormManager create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract NativeFormFieldCreationResult createAndInsertFormField(NativeFormType nativeFormType, String str, ArrayList<NativeAnnotation> arrayList, ArrayList<String> arrayList2);

    public abstract ArrayList<ArrayList<NativeFormField>> getFormFields();

    public abstract ArrayList<NativeFormField> getFormFieldsForProvider(int i);

    public abstract ArrayList<NativeTabOrder> getTabOrder();

    public abstract NativeTabOrder getTabOrderForProvider(int i);

    public abstract void registerFormObserver(NativeFormObserver nativeFormObserver);

    public abstract NativeFormRemovalResult removeFormFields(ArrayList<NativeFormField> arrayList);

    public abstract NativeFormRemovalResult removeFormWidgets(ArrayList<NativeAnnotation> arrayList);

    public abstract NativeFormResetResult resetForm(ArrayList<NativeFormField> arrayList, EnumSet<NativeFormResetFlags> enumSet);

    public abstract void unregisterFormObserver(NativeFormObserver nativeFormObserver);
}

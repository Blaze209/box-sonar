package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeFormControl {

    public static final class CppProxy extends NativeFormControl {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeFormControl create(NativeFormField nativeFormField);

        private native void nativeDestroy(long j);

        private native boolean native_deselectButton(long j, int i);

        private native NativeJSResult native_executeKeystrokeEventForComboOrListFields(long j, String str);

        private native NativeJSResult native_executeKeystrokeEventForTextSelection(long j, String str, String str2, NativeTextRange nativeTextRange, boolean z);

        private native String native_getButtonDownCaption(long j, int i);

        private native String native_getButtonNormalCaption(long j, int i);

        private native String native_getButtonRolloverCaption(long j, int i);

        private native String native_getCustomValue(long j);

        private native String native_getExportValue(long j, int i);

        private native String native_getFQN(long j);

        private native NativeFormField native_getFormField(long j);

        private native int native_getMaxLength(long j);

        private native ArrayList<NativeFormOption> native_getOptions(long j);

        private native String native_getRichText(long j);

        private native String native_getSanitizedButtonValue(long j, int i);

        private native String native_getSanitizedOnState(long j, int i);

        private native ArrayList<Integer> native_getSelectedButtonWidgetIds(long j);

        private native ArrayList<Integer> native_getSelectedIndexes(long j);

        private native String native_getText(long j);

        private native boolean native_isButtonSelected(long j, int i);

        private native boolean native_isCustomValueSet(long j);

        private native boolean native_isDirty(long j);

        private native boolean native_reset(long j);

        private native boolean native_selectButton(long j, int i);

        private native boolean native_setButtonDownCaption(long j, String str, int i);

        private native boolean native_setButtonNormalCaption(long j, String str, int i);

        private native boolean native_setButtonRolloverCaption(long j, String str, int i);

        private native void native_setCustomValue(long j, String str);

        private native boolean native_setDefaultValue(long j, NativeFormValue nativeFormValue);

        private native void native_setDirty(long j, boolean z);

        private native void native_setExportValue(long j, int i, String str);

        private native void native_setMaxLength(long j, int i);

        private native void native_setOnState(long j, int i, String str);

        private native void native_setOptions(long j, ArrayList<NativeFormOption> arrayList);

        private native boolean native_setRichText(long j, String str);

        private native boolean native_setSelectedButtonWidgetIds(long j, ArrayList<Integer> arrayList);

        private native void native_setSelectedIndexes(long j, ArrayList<Integer> arrayList);

        private native boolean native_setText(long j, String str);

        private native boolean native_setValue(long j, NativeFormValue nativeFormValue);

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

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean deselectButton(int i) {
            return native_deselectButton(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public NativeJSResult executeKeystrokeEventForComboOrListFields(String str) {
            return native_executeKeystrokeEventForComboOrListFields(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public NativeJSResult executeKeystrokeEventForTextSelection(String str, String str2, NativeTextRange nativeTextRange, boolean z) {
            return native_executeKeystrokeEventForTextSelection(this.nativeRef, str, str2, nativeTextRange, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getButtonDownCaption(int i) {
            return native_getButtonDownCaption(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getButtonNormalCaption(int i) {
            return native_getButtonNormalCaption(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getButtonRolloverCaption(int i) {
            return native_getButtonRolloverCaption(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getCustomValue() {
            return native_getCustomValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getExportValue(int i) {
            return native_getExportValue(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getFQN() {
            return native_getFQN(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public NativeFormField getFormField() {
            return native_getFormField(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public int getMaxLength() {
            return native_getMaxLength(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public ArrayList<NativeFormOption> getOptions() {
            return native_getOptions(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getRichText() {
            return native_getRichText(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getSanitizedButtonValue(int i) {
            return native_getSanitizedButtonValue(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getSanitizedOnState(int i) {
            return native_getSanitizedOnState(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public ArrayList<Integer> getSelectedButtonWidgetIds() {
            return native_getSelectedButtonWidgetIds(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public ArrayList<Integer> getSelectedIndexes() {
            return native_getSelectedIndexes(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public String getText() {
            return native_getText(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean isButtonSelected(int i) {
            return native_isButtonSelected(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean isCustomValueSet() {
            return native_isCustomValueSet(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean isDirty() {
            return native_isDirty(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean reset() {
            return native_reset(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean selectButton(int i) {
            return native_selectButton(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setButtonDownCaption(String str, int i) {
            return native_setButtonDownCaption(this.nativeRef, str, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setButtonNormalCaption(String str, int i) {
            return native_setButtonNormalCaption(this.nativeRef, str, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setButtonRolloverCaption(String str, int i) {
            return native_setButtonRolloverCaption(this.nativeRef, str, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public void setCustomValue(String str) {
            native_setCustomValue(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setDefaultValue(NativeFormValue nativeFormValue) {
            return native_setDefaultValue(this.nativeRef, nativeFormValue);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public void setDirty(boolean z) {
            native_setDirty(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public void setExportValue(int i, String str) {
            native_setExportValue(this.nativeRef, i, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public void setMaxLength(int i) {
            native_setMaxLength(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public void setOnState(int i, String str) {
            native_setOnState(this.nativeRef, i, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public void setOptions(ArrayList<NativeFormOption> arrayList) {
            native_setOptions(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setRichText(String str) {
            return native_setRichText(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setSelectedButtonWidgetIds(ArrayList<Integer> arrayList) {
            return native_setSelectedButtonWidgetIds(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public void setSelectedIndexes(ArrayList<Integer> arrayList) {
            native_setSelectedIndexes(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setText(String str) {
            return native_setText(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormControl
        public boolean setValue(NativeFormValue nativeFormValue) {
            return native_setValue(this.nativeRef, nativeFormValue);
        }
    }

    public static NativeFormControl create(NativeFormField nativeFormField) {
        return CppProxy.create(nativeFormField);
    }

    public abstract boolean deselectButton(int i);

    public abstract NativeJSResult executeKeystrokeEventForComboOrListFields(String str);

    public abstract NativeJSResult executeKeystrokeEventForTextSelection(String str, String str2, NativeTextRange nativeTextRange, boolean z);

    public abstract String getButtonDownCaption(int i);

    public abstract String getButtonNormalCaption(int i);

    public abstract String getButtonRolloverCaption(int i);

    public abstract String getCustomValue();

    public abstract String getExportValue(int i);

    public abstract String getFQN();

    public abstract NativeFormField getFormField();

    public abstract int getMaxLength();

    public abstract ArrayList<NativeFormOption> getOptions();

    public abstract String getRichText();

    public abstract String getSanitizedButtonValue(int i);

    public abstract String getSanitizedOnState(int i);

    public abstract ArrayList<Integer> getSelectedButtonWidgetIds();

    public abstract ArrayList<Integer> getSelectedIndexes();

    public abstract String getText();

    public abstract boolean isButtonSelected(int i);

    public abstract boolean isCustomValueSet();

    public abstract boolean isDirty();

    public abstract boolean reset();

    public abstract boolean selectButton(int i);

    public abstract boolean setButtonDownCaption(String str, int i);

    public abstract boolean setButtonNormalCaption(String str, int i);

    public abstract boolean setButtonRolloverCaption(String str, int i);

    public abstract void setCustomValue(String str);

    public abstract boolean setDefaultValue(NativeFormValue nativeFormValue);

    public abstract void setDirty(boolean z);

    public abstract void setExportValue(int i, String str);

    public abstract void setMaxLength(int i);

    public abstract void setOnState(int i, String str);

    public abstract void setOptions(ArrayList<NativeFormOption> arrayList);

    public abstract boolean setRichText(String str);

    public abstract boolean setSelectedButtonWidgetIds(ArrayList<Integer> arrayList);

    public abstract void setSelectedIndexes(ArrayList<Integer> arrayList);

    public abstract boolean setText(String str);

    public abstract boolean setValue(NativeFormValue nativeFormValue);
}

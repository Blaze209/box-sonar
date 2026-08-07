package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeFormField {

    public static final class CppProxy extends NativeFormField {
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

        private native boolean native_documentModifiedSinceSignature(long j);

        private native String native_getAlternateFieldName(long j);

        private native ArrayList<Integer> native_getAnnotationWidgetIds(long j);

        private native int native_getCalculationOrderIndex(long j);

        private native EnumSet<NativeFormChoiceFlags> native_getChoiceFlags(long j);

        private native NativeFormValue native_getDefaultValue(long j);

        private native String native_getEditingContents(long j);

        private native String native_getFQN(long j);

        private native String native_getFQNForAnnotationWidgetId(long j, int i);

        private native EnumSet<NativeFormFlags> native_getFlags(long j);

        private native int native_getFormIndex(long j);

        private native String native_getFormattedContents(long j);

        private native String native_getMappingName(long j);

        private native String native_getName(long j);

        private native String native_getNameForAnnotationWidgetId(long j, int i);

        private native ArrayList<Integer> native_getOverlappingInkAndStampSignatureIds(long j, int i);

        private native ArrayList<Integer> native_getOverlappingInkSignatureIds(long j, int i);

        private native Long native_getPDFObjectId(long j);

        private native Integer native_getPageForAnnotation(long j, int i);

        private native EnumSet<NativeFormRadioFlags> native_getRadioFlags(long j);

        private native NativeSignatureInfo native_getSignatureInfo(long j);

        private native EnumSet<NativeFormTextFlags> native_getTextFlags(long j);

        private native NativeFormType native_getType(long j);

        private native NativeFormValue native_getValue(long j);

        private native NativeAnnotationPager native_getWidgetAnnotations(long j);

        private native boolean native_hasOptPdfArray(long j);

        private native void native_iOSSetSerializeIntoPdf(long j, boolean z);

        private native NativeSignatureRemovalResult native_removeDigitalSignature(long j);

        private native void native_setAlternateFieldName(long j, String str);

        private native void native_setChoiceFlags(long j, EnumSet<NativeFormChoiceFlags> enumSet);

        private native void native_setFlags(long j, EnumSet<NativeFormFlags> enumSet);

        private native void native_setMappingName(long j, String str);

        private native void native_setRadioFlags(long j, EnumSet<NativeFormRadioFlags> enumSet);

        private native void native_setSignatureInfo(long j, NativeSignatureInfo nativeSignatureInfo);

        private native void native_setTextFlags(long j, EnumSet<NativeFormTextFlags> enumSet);

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

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public boolean documentModifiedSinceSignature() {
            return native_documentModifiedSinceSignature(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getAlternateFieldName() {
            return native_getAlternateFieldName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public ArrayList<Integer> getAnnotationWidgetIds() {
            return native_getAnnotationWidgetIds(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public int getCalculationOrderIndex() {
            return native_getCalculationOrderIndex(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public EnumSet<NativeFormChoiceFlags> getChoiceFlags() {
            return native_getChoiceFlags(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public NativeFormValue getDefaultValue() {
            return native_getDefaultValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getEditingContents() {
            return native_getEditingContents(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getFQN() {
            return native_getFQN(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getFQNForAnnotationWidgetId(int i) {
            return native_getFQNForAnnotationWidgetId(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public EnumSet<NativeFormFlags> getFlags() {
            return native_getFlags(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public int getFormIndex() {
            return native_getFormIndex(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getFormattedContents() {
            return native_getFormattedContents(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getMappingName() {
            return native_getMappingName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getName() {
            return native_getName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public String getNameForAnnotationWidgetId(int i) {
            return native_getNameForAnnotationWidgetId(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public ArrayList<Integer> getOverlappingInkAndStampSignatureIds(int i) {
            return native_getOverlappingInkAndStampSignatureIds(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public ArrayList<Integer> getOverlappingInkSignatureIds(int i) {
            return native_getOverlappingInkSignatureIds(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public Long getPDFObjectId() {
            return native_getPDFObjectId(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public Integer getPageForAnnotation(int i) {
            return native_getPageForAnnotation(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public EnumSet<NativeFormRadioFlags> getRadioFlags() {
            return native_getRadioFlags(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public NativeSignatureInfo getSignatureInfo() {
            return native_getSignatureInfo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public EnumSet<NativeFormTextFlags> getTextFlags() {
            return native_getTextFlags(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public NativeFormType getType() {
            return native_getType(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public NativeFormValue getValue() {
            return native_getValue(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public NativeAnnotationPager getWidgetAnnotations() {
            return native_getWidgetAnnotations(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public boolean hasOptPdfArray() {
            return native_hasOptPdfArray(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void iOSSetSerializeIntoPdf(boolean z) {
            native_iOSSetSerializeIntoPdf(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public NativeSignatureRemovalResult removeDigitalSignature() {
            return native_removeDigitalSignature(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void setAlternateFieldName(String str) {
            native_setAlternateFieldName(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void setChoiceFlags(EnumSet<NativeFormChoiceFlags> enumSet) {
            native_setChoiceFlags(this.nativeRef, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void setFlags(EnumSet<NativeFormFlags> enumSet) {
            native_setFlags(this.nativeRef, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void setMappingName(String str) {
            native_setMappingName(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void setRadioFlags(EnumSet<NativeFormRadioFlags> enumSet) {
            native_setRadioFlags(this.nativeRef, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void setSignatureInfo(NativeSignatureInfo nativeSignatureInfo) {
            native_setSignatureInfo(this.nativeRef, nativeSignatureInfo);
        }

        @Override // com.pspdfkit.internal.jni.NativeFormField
        public void setTextFlags(EnumSet<NativeFormTextFlags> enumSet) {
            native_setTextFlags(this.nativeRef, enumSet);
        }
    }

    public abstract boolean documentModifiedSinceSignature();

    public abstract String getAlternateFieldName();

    public abstract ArrayList<Integer> getAnnotationWidgetIds();

    public abstract int getCalculationOrderIndex();

    public abstract EnumSet<NativeFormChoiceFlags> getChoiceFlags();

    public abstract NativeFormValue getDefaultValue();

    public abstract String getEditingContents();

    public abstract String getFQN();

    public abstract String getFQNForAnnotationWidgetId(int i);

    public abstract EnumSet<NativeFormFlags> getFlags();

    public abstract int getFormIndex();

    public abstract String getFormattedContents();

    public abstract String getMappingName();

    public abstract String getName();

    public abstract String getNameForAnnotationWidgetId(int i);

    public abstract ArrayList<Integer> getOverlappingInkAndStampSignatureIds(int i);

    public abstract ArrayList<Integer> getOverlappingInkSignatureIds(int i);

    public abstract Long getPDFObjectId();

    public abstract Integer getPageForAnnotation(int i);

    public abstract EnumSet<NativeFormRadioFlags> getRadioFlags();

    public abstract NativeSignatureInfo getSignatureInfo();

    public abstract EnumSet<NativeFormTextFlags> getTextFlags();

    public abstract NativeFormType getType();

    public abstract NativeFormValue getValue();

    public abstract NativeAnnotationPager getWidgetAnnotations();

    public abstract boolean hasOptPdfArray();

    public abstract void iOSSetSerializeIntoPdf(boolean z);

    public abstract NativeSignatureRemovalResult removeDigitalSignature();

    public abstract void setAlternateFieldName(String str);

    public abstract void setChoiceFlags(EnumSet<NativeFormChoiceFlags> enumSet);

    public abstract void setFlags(EnumSet<NativeFormFlags> enumSet);

    public abstract void setMappingName(String str);

    public abstract void setRadioFlags(EnumSet<NativeFormRadioFlags> enumSet);

    public abstract void setSignatureInfo(NativeSignatureInfo nativeSignatureInfo);

    public abstract void setTextFlags(EnumSet<NativeFormTextFlags> enumSet);
}

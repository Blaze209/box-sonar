package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentProvider {
    public static final String ALTERNATE_DOCUMENTS_ENABLED_KEY = "enabled";
    public static final String ALTERNATE_DOCUMENTS_STATUS_NOTIFICATION = "alternate_documents_status";
    public static final String DOCUMENT_PROVIDER_UNIQUE_ID_KEY = "document_provider_unique_id";

    public static final class CppProxy extends NativeDocumentProvider {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native byte getDefaultMaximumAlternateDocuments();

        private native void nativeDestroy(long j);

        private native boolean native_addMeasurementContentFormat(long j, NativeMeasurementContentFormat nativeMeasurementContentFormat);

        private native boolean native_canSave(long j);

        private native boolean native_cancelRenderProcess(long j, int i, int i2);

        private native void native_configureDocumentScriptExecutor(long j, String str);

        private native void native_executeDocumentLevelJavascripts(long j);

        private native NativeAPStreamDocumentGenerator native_getAPStreamDocumentGenerator(long j);

        private native NativeAnnotationChangeTracking native_getAnnotationChangeTrackingSnapshot(long j, int i, int i2);

        private native byte[] native_getChangingFileId(long j);

        private native NativePDFVersion native_getCurrentPdfVersion(long j);

        private native EnumSet<NativeDocumentPermissions> native_getCurrentPermissions(long j);

        private native int native_getDataHash(long j);

        private native NativeDataProvider native_getDataProvider(long j);

        private native ArrayList<String> native_getDocumentLevelJavascripts(long j);

        private native NativeJSDocumentScriptExecutor native_getDocumentScriptExecutor(long j);

        private native String native_getFilePath(long j);

        private native NativeFormFieldChangeTracking native_getFormFieldChangeTrackingSnapshot(long j, int i, int i2);

        private native NativeLabelParser native_getLabelParser(long j);

        private native byte native_getMaximumAlternateDocuments(long j);

        private native Long native_getMaximumImageCacheSize(long j);

        private native ArrayList<NativeMeasurementContentFormat> native_getMeasurementContentFormats(long j);

        private native HashMap<String, String> native_getMetadata(long j);

        private native NativeOutlineParser native_getOutlineParser(long j);

        private native NativePage native_getPage(long j, int i);

        private native NativePageBinding native_getPageBinding(long j);

        private native int native_getPageCount(long j);

        private native NativePageInfo native_getPageInfo(long j, int i);

        private native byte[] native_getPermanentFileId(long j);

        private native NativeMeasurementSecondaryUnit native_getSecondaryMeasurementUnit(long j);

        private native NativeTextParserResult native_getTextParserForPage(long j, int i);

        private native String native_getTitle(long j);

        private native String native_getUniqueIdentifier(long j);

        private native EnumSet<NativeDocumentPermissions> native_getUserPasswordPermissions(long j);

        private native String native_getXmpMetadata(long j);

        private native boolean native_hasXfaForms(long j);

        private native boolean native_isEncrypted(long j);

        private native boolean native_needsSave(long j);

        private native void native_removeMeasurementContentFormat(long j, NativeMeasurementContentFormat nativeMeasurementContentFormat);

        private native void native_repairFormFields(long j);

        private native Integer native_resolveNamedDestination(long j, String str);

        private native NativeDocumentSaveResult native_save(long j, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native NativeDocumentSaveResult native_saveAs(long j, NativeSaveAsDestination nativeSaveAsDestination, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native NativeDocumentSaveResult native_saveCheckpoint(long j, String str);

        private native NativeDocumentSaveResult native_saveIfModified(long j, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native void native_setAPStreamDocumentGenerator(long j, NativeAPStreamDocumentGenerator nativeAPStreamDocumentGenerator);

        private native void native_setMaxRenderableContentSize(long j, Long l);

        private native void native_setMaximumAlternateDocuments(long j, byte b);

        private native void native_setMaximumImageCacheSize(long j, long j2);

        private native void native_setPageBinding(long j, NativePageBinding nativePageBinding);

        private native void native_setPageInfo(long j, NativePageInfo nativePageInfo, int i);

        private native void native_setSecondaryMeasurementUnit(long j, NativeMeasurementSecondaryUnit nativeMeasurementSecondaryUnit);

        private native boolean native_signaturesAllowAnnotationModification(long j);

        private native void native_syncToBackend(long j);

        private native void native_syncToBackendWithSaveOptions(long j, EnumSet<NativeDocumentSaveFlags> enumSet);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public boolean addMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat) {
            return native_addMeasurementContentFormat(this.nativeRef, nativeMeasurementContentFormat);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public boolean canSave() {
            return native_canSave(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public boolean cancelRenderProcess(int i, int i2) {
            return native_cancelRenderProcess(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void configureDocumentScriptExecutor(String str) {
            native_configureDocumentScriptExecutor(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void executeDocumentLevelJavascripts() {
            native_executeDocumentLevelJavascripts(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeAPStreamDocumentGenerator getAPStreamDocumentGenerator() {
            return native_getAPStreamDocumentGenerator(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeAnnotationChangeTracking getAnnotationChangeTrackingSnapshot(int i, int i2) {
            return native_getAnnotationChangeTrackingSnapshot(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public byte[] getChangingFileId() {
            return native_getChangingFileId(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativePDFVersion getCurrentPdfVersion() {
            return native_getCurrentPdfVersion(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public EnumSet<NativeDocumentPermissions> getCurrentPermissions() {
            return native_getCurrentPermissions(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public int getDataHash() {
            return native_getDataHash(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeDataProvider getDataProvider() {
            return native_getDataProvider(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public ArrayList<String> getDocumentLevelJavascripts() {
            return native_getDocumentLevelJavascripts(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeJSDocumentScriptExecutor getDocumentScriptExecutor() {
            return native_getDocumentScriptExecutor(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public String getFilePath() {
            return native_getFilePath(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeFormFieldChangeTracking getFormFieldChangeTrackingSnapshot(int i, int i2) {
            return native_getFormFieldChangeTrackingSnapshot(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeLabelParser getLabelParser() {
            return native_getLabelParser(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public byte getMaximumAlternateDocuments() {
            return native_getMaximumAlternateDocuments(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public Long getMaximumImageCacheSize() {
            return native_getMaximumImageCacheSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public ArrayList<NativeMeasurementContentFormat> getMeasurementContentFormats() {
            return native_getMeasurementContentFormats(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public HashMap<String, String> getMetadata() {
            return native_getMetadata(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeOutlineParser getOutlineParser() {
            return native_getOutlineParser(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativePage getPage(int i) {
            return native_getPage(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativePageBinding getPageBinding() {
            return native_getPageBinding(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public int getPageCount() {
            return native_getPageCount(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativePageInfo getPageInfo(int i) {
            return native_getPageInfo(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public byte[] getPermanentFileId() {
            return native_getPermanentFileId(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeMeasurementSecondaryUnit getSecondaryMeasurementUnit() {
            return native_getSecondaryMeasurementUnit(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeTextParserResult getTextParserForPage(int i) {
            return native_getTextParserForPage(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public String getTitle() {
            return native_getTitle(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public String getUniqueIdentifier() {
            return native_getUniqueIdentifier(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public EnumSet<NativeDocumentPermissions> getUserPasswordPermissions() {
            return native_getUserPasswordPermissions(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public String getXmpMetadata() {
            return native_getXmpMetadata(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public boolean hasXfaForms() {
            return native_hasXfaForms(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public boolean isEncrypted() {
            return native_isEncrypted(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public boolean needsSave() {
            return native_needsSave(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void removeMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat) {
            native_removeMeasurementContentFormat(this.nativeRef, nativeMeasurementContentFormat);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void repairFormFields() {
            native_repairFormFields(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public Integer resolveNamedDestination(String str) {
            return native_resolveNamedDestination(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeDocumentSaveResult save(NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_save(this.nativeRef, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeDocumentSaveResult saveAs(NativeSaveAsDestination nativeSaveAsDestination, NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_saveAs(this.nativeRef, nativeSaveAsDestination, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeDocumentSaveResult saveCheckpoint(String str) {
            return native_saveCheckpoint(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public NativeDocumentSaveResult saveIfModified(NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_saveIfModified(this.nativeRef, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void setAPStreamDocumentGenerator(NativeAPStreamDocumentGenerator nativeAPStreamDocumentGenerator) {
            native_setAPStreamDocumentGenerator(this.nativeRef, nativeAPStreamDocumentGenerator);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void setMaxRenderableContentSize(Long l) {
            native_setMaxRenderableContentSize(this.nativeRef, l);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void setMaximumAlternateDocuments(byte b) {
            native_setMaximumAlternateDocuments(this.nativeRef, b);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void setMaximumImageCacheSize(long j) {
            native_setMaximumImageCacheSize(this.nativeRef, j);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void setPageBinding(NativePageBinding nativePageBinding) {
            native_setPageBinding(this.nativeRef, nativePageBinding);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void setPageInfo(NativePageInfo nativePageInfo, int i) {
            native_setPageInfo(this.nativeRef, nativePageInfo, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void setSecondaryMeasurementUnit(NativeMeasurementSecondaryUnit nativeMeasurementSecondaryUnit) {
            native_setSecondaryMeasurementUnit(this.nativeRef, nativeMeasurementSecondaryUnit);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public boolean signaturesAllowAnnotationModification() {
            return native_signaturesAllowAnnotationModification(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void syncToBackend() {
            native_syncToBackend(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentProvider
        public void syncToBackendWithSaveOptions(EnumSet<NativeDocumentSaveFlags> enumSet) {
            native_syncToBackendWithSaveOptions(this.nativeRef, enumSet);
        }
    }

    public static byte getDefaultMaximumAlternateDocuments() {
        return CppProxy.getDefaultMaximumAlternateDocuments();
    }

    public abstract boolean addMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat);

    public abstract boolean canSave();

    public abstract boolean cancelRenderProcess(int i, int i2);

    public abstract void configureDocumentScriptExecutor(String str);

    public abstract void executeDocumentLevelJavascripts();

    public abstract NativeAPStreamDocumentGenerator getAPStreamDocumentGenerator();

    public abstract NativeAnnotationChangeTracking getAnnotationChangeTrackingSnapshot(int i, int i2);

    public abstract byte[] getChangingFileId();

    public abstract NativePDFVersion getCurrentPdfVersion();

    public abstract EnumSet<NativeDocumentPermissions> getCurrentPermissions();

    public abstract int getDataHash();

    public abstract NativeDataProvider getDataProvider();

    public abstract ArrayList<String> getDocumentLevelJavascripts();

    public abstract NativeJSDocumentScriptExecutor getDocumentScriptExecutor();

    public abstract String getFilePath();

    public abstract NativeFormFieldChangeTracking getFormFieldChangeTrackingSnapshot(int i, int i2);

    public abstract NativeLabelParser getLabelParser();

    public abstract byte getMaximumAlternateDocuments();

    public abstract Long getMaximumImageCacheSize();

    public abstract ArrayList<NativeMeasurementContentFormat> getMeasurementContentFormats();

    public abstract HashMap<String, String> getMetadata();

    public abstract NativeOutlineParser getOutlineParser();

    public abstract NativePage getPage(int i);

    public abstract NativePageBinding getPageBinding();

    public abstract int getPageCount();

    public abstract NativePageInfo getPageInfo(int i);

    public abstract byte[] getPermanentFileId();

    public abstract NativeMeasurementSecondaryUnit getSecondaryMeasurementUnit();

    public abstract NativeTextParserResult getTextParserForPage(int i);

    public abstract String getTitle();

    public abstract String getUniqueIdentifier();

    public abstract EnumSet<NativeDocumentPermissions> getUserPasswordPermissions();

    public abstract String getXmpMetadata();

    public abstract boolean hasXfaForms();

    public abstract boolean isEncrypted();

    public abstract boolean needsSave();

    public abstract void removeMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat);

    public abstract void repairFormFields();

    public abstract Integer resolveNamedDestination(String str);

    public abstract NativeDocumentSaveResult save(NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract NativeDocumentSaveResult saveAs(NativeSaveAsDestination nativeSaveAsDestination, NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract NativeDocumentSaveResult saveCheckpoint(String str);

    public abstract NativeDocumentSaveResult saveIfModified(NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract void setAPStreamDocumentGenerator(NativeAPStreamDocumentGenerator nativeAPStreamDocumentGenerator);

    public abstract void setMaxRenderableContentSize(Long l);

    public abstract void setMaximumAlternateDocuments(byte b);

    public abstract void setMaximumImageCacheSize(long j);

    public abstract void setPageBinding(NativePageBinding nativePageBinding);

    public abstract void setPageInfo(NativePageInfo nativePageInfo, int i);

    public abstract void setSecondaryMeasurementUnit(NativeMeasurementSecondaryUnit nativeMeasurementSecondaryUnit);

    public abstract boolean signaturesAllowAnnotationModification();

    public abstract void syncToBackend();

    public abstract void syncToBackendWithSaveOptions(EnumSet<NativeDocumentSaveFlags> enumSet);
}

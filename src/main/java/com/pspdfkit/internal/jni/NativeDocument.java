package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocument {

    public static final class CppProxy extends NativeDocument {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native String generateUid(ArrayList<NativeDataDescriptor> arrayList, String str);

        public static native NativePDFFileStatus isValidPDF(NativeDataProvider nativeDataProvider);

        private native void nativeDestroy(long j);

        private native boolean native_addMeasurementContentFormat(long j, NativeMeasurementContentFormat nativeMeasurementContentFormat);

        private native boolean native_canSave(long j);

        private native boolean native_cancelRenderProcess(long j, int i, int i2);

        private native void native_clearPageCache(long j);

        private native void native_enableAutomaticLinkExtraction(long j, boolean z);

        private native NativeBookmarkManager native_getBookmarkManager(long j);

        private native byte[] native_getChangingDocumentId(long j);

        private native String native_getChangingDocumentIdString(long j);

        private native NativePDFVersion native_getCurrentPdfVersion(long j);

        private native EnumSet<NativeDocumentPermissions> native_getCurrentPermissions(long j);

        private native int native_getDataHash(long j);

        private native byte[] native_getDocumentId(long j);

        private native String native_getDocumentIdString(long j);

        private native ArrayList<NativeDocumentProvider> native_getDocumentProviders(long j);

        private native NativeDocumentJavaScriptStatus native_getJavascriptStatus(long j);

        private native ArrayList<NativeMeasurementContentFormat> native_getMeasurementContentFormats(long j);

        private native HashMap<String, String> native_getMetadata(long j);

        private native NativeOutlineParser native_getOutlineParser(long j);

        private native NativePage native_getPage(long j, int i);

        private native NativePageBinding native_getPageBinding(long j);

        private native int native_getPageCount(long j);

        private native Integer native_getPageIndexForPageLabel(long j, String str, boolean z);

        private native NativePageInfo native_getPageInfo(long j, int i);

        private native String native_getPageLabel(long j, int i, boolean z);

        private native int native_getProviderPageOffset(long j, int i);

        private native NativeMeasurementSecondaryUnit native_getSecondaryMeasurementUnit(long j);

        private native NativeTextParserResult native_getTextParserForPage(long j, int i);

        private native EnumSet<NativeTextParserOptions> native_getTextParserOptions(long j);

        private native String native_getTitle(long j);

        private native String native_getUid(long j);

        private native EnumSet<NativeDocumentPermissions> native_getUserPasswordPermissions(long j);

        private native boolean native_hasAnyPasswordSet(long j);

        private native boolean native_hasOutline(long j);

        private native boolean native_hasPage(long j, int i);

        private native boolean native_mergeToFilePath(long j, String str, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native boolean native_needsSave(long j);

        private native NativeDocumentProvider native_reloadDocumentProvider(long j, NativeDocumentProvider nativeDocumentProvider, NativeDataDescriptor nativeDataDescriptor);

        private native void native_removeMeasurementContentFormat(long j, NativeMeasurementContentFormat nativeMeasurementContentFormat);

        private native NativeDocumentSaveResult native_save(long j, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native NativeDocumentSaveResult native_saveCheckpoint(long j, String str);

        private native NativeDocumentSaveResult native_saveIfModified(long j, NativeDocumentSaveOptions nativeDocumentSaveOptions);

        private native void native_setJavascriptStatus(long j, NativeDocumentJavaScriptStatus nativeDocumentJavaScriptStatus);

        private native void native_setPageBinding(long j, NativePageBinding nativePageBinding);

        private native void native_setSecondaryMeasurementUnit(long j, NativeMeasurementSecondaryUnit nativeMeasurementSecondaryUnit);

        private native void native_setTextParserOptions(long j, EnumSet<NativeTextParserOptions> enumSet);

        private native void native_setUid(long j, String str);

        public static native NativeDocumentOpenResult open(ArrayList<NativeDataDescriptor> arrayList);

        public static native NativeDocumentOpenResult openFile(String str);

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

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean addMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat) {
            return native_addMeasurementContentFormat(this.nativeRef, nativeMeasurementContentFormat);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean canSave() {
            return native_canSave(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean cancelRenderProcess(int i, int i2) {
            return native_cancelRenderProcess(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void clearPageCache() {
            native_clearPageCache(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void enableAutomaticLinkExtraction(boolean z) {
            native_enableAutomaticLinkExtraction(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeBookmarkManager getBookmarkManager() {
            return native_getBookmarkManager(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public byte[] getChangingDocumentId() {
            return native_getChangingDocumentId(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public String getChangingDocumentIdString() {
            return native_getChangingDocumentIdString(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativePDFVersion getCurrentPdfVersion() {
            return native_getCurrentPdfVersion(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public EnumSet<NativeDocumentPermissions> getCurrentPermissions() {
            return native_getCurrentPermissions(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public int getDataHash() {
            return native_getDataHash(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public byte[] getDocumentId() {
            return native_getDocumentId(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public String getDocumentIdString() {
            return native_getDocumentIdString(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public ArrayList<NativeDocumentProvider> getDocumentProviders() {
            return native_getDocumentProviders(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeDocumentJavaScriptStatus getJavascriptStatus() {
            return native_getJavascriptStatus(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public ArrayList<NativeMeasurementContentFormat> getMeasurementContentFormats() {
            return native_getMeasurementContentFormats(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public HashMap<String, String> getMetadata() {
            return native_getMetadata(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeOutlineParser getOutlineParser() {
            return native_getOutlineParser(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativePage getPage(int i) {
            return native_getPage(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativePageBinding getPageBinding() {
            return native_getPageBinding(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public int getPageCount() {
            return native_getPageCount(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public Integer getPageIndexForPageLabel(String str, boolean z) {
            return native_getPageIndexForPageLabel(this.nativeRef, str, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativePageInfo getPageInfo(int i) {
            return native_getPageInfo(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public String getPageLabel(int i, boolean z) {
            return native_getPageLabel(this.nativeRef, i, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public int getProviderPageOffset(int i) {
            return native_getProviderPageOffset(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeMeasurementSecondaryUnit getSecondaryMeasurementUnit() {
            return native_getSecondaryMeasurementUnit(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeTextParserResult getTextParserForPage(int i) {
            return native_getTextParserForPage(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public EnumSet<NativeTextParserOptions> getTextParserOptions() {
            return native_getTextParserOptions(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public String getTitle() {
            return native_getTitle(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public String getUid() {
            return native_getUid(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public EnumSet<NativeDocumentPermissions> getUserPasswordPermissions() {
            return native_getUserPasswordPermissions(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean hasAnyPasswordSet() {
            return native_hasAnyPasswordSet(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean hasOutline() {
            return native_hasOutline(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean hasPage(int i) {
            return native_hasPage(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean mergeToFilePath(String str, NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_mergeToFilePath(this.nativeRef, str, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public boolean needsSave() {
            return native_needsSave(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeDocumentProvider reloadDocumentProvider(NativeDocumentProvider nativeDocumentProvider, NativeDataDescriptor nativeDataDescriptor) {
            return native_reloadDocumentProvider(this.nativeRef, nativeDocumentProvider, nativeDataDescriptor);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void removeMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat) {
            native_removeMeasurementContentFormat(this.nativeRef, nativeMeasurementContentFormat);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeDocumentSaveResult save(NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_save(this.nativeRef, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeDocumentSaveResult saveCheckpoint(String str) {
            return native_saveCheckpoint(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public NativeDocumentSaveResult saveIfModified(NativeDocumentSaveOptions nativeDocumentSaveOptions) {
            return native_saveIfModified(this.nativeRef, nativeDocumentSaveOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void setJavascriptStatus(NativeDocumentJavaScriptStatus nativeDocumentJavaScriptStatus) {
            native_setJavascriptStatus(this.nativeRef, nativeDocumentJavaScriptStatus);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void setPageBinding(NativePageBinding nativePageBinding) {
            native_setPageBinding(this.nativeRef, nativePageBinding);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void setSecondaryMeasurementUnit(NativeMeasurementSecondaryUnit nativeMeasurementSecondaryUnit) {
            native_setSecondaryMeasurementUnit(this.nativeRef, nativeMeasurementSecondaryUnit);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void setTextParserOptions(EnumSet<NativeTextParserOptions> enumSet) {
            native_setTextParserOptions(this.nativeRef, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocument
        public void setUid(String str) {
            native_setUid(this.nativeRef, str);
        }
    }

    public static String generateUid(ArrayList<NativeDataDescriptor> arrayList, String str) {
        return CppProxy.generateUid(arrayList, str);
    }

    public static NativePDFFileStatus isValidPDF(NativeDataProvider nativeDataProvider) {
        return CppProxy.isValidPDF(nativeDataProvider);
    }

    public static NativeDocumentOpenResult open(ArrayList<NativeDataDescriptor> arrayList) {
        return CppProxy.open(arrayList);
    }

    public static NativeDocumentOpenResult openFile(String str) {
        return CppProxy.openFile(str);
    }

    public abstract boolean addMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat);

    public abstract boolean canSave();

    public abstract boolean cancelRenderProcess(int i, int i2);

    public abstract void clearPageCache();

    public abstract void enableAutomaticLinkExtraction(boolean z);

    public abstract NativeBookmarkManager getBookmarkManager();

    public abstract byte[] getChangingDocumentId();

    public abstract String getChangingDocumentIdString();

    public abstract NativePDFVersion getCurrentPdfVersion();

    public abstract EnumSet<NativeDocumentPermissions> getCurrentPermissions();

    public abstract int getDataHash();

    public abstract byte[] getDocumentId();

    public abstract String getDocumentIdString();

    public abstract ArrayList<NativeDocumentProvider> getDocumentProviders();

    public abstract NativeDocumentJavaScriptStatus getJavascriptStatus();

    public abstract ArrayList<NativeMeasurementContentFormat> getMeasurementContentFormats();

    public abstract HashMap<String, String> getMetadata();

    public abstract NativeOutlineParser getOutlineParser();

    public abstract NativePage getPage(int i);

    public abstract NativePageBinding getPageBinding();

    public abstract int getPageCount();

    public abstract Integer getPageIndexForPageLabel(String str, boolean z);

    public abstract NativePageInfo getPageInfo(int i);

    public abstract String getPageLabel(int i, boolean z);

    public abstract int getProviderPageOffset(int i);

    public abstract NativeMeasurementSecondaryUnit getSecondaryMeasurementUnit();

    public abstract NativeTextParserResult getTextParserForPage(int i);

    public abstract EnumSet<NativeTextParserOptions> getTextParserOptions();

    public abstract String getTitle();

    public abstract String getUid();

    public abstract EnumSet<NativeDocumentPermissions> getUserPasswordPermissions();

    public abstract boolean hasAnyPasswordSet();

    public abstract boolean hasOutline();

    public abstract boolean hasPage(int i);

    public abstract boolean mergeToFilePath(String str, NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract boolean needsSave();

    public abstract NativeDocumentProvider reloadDocumentProvider(NativeDocumentProvider nativeDocumentProvider, NativeDataDescriptor nativeDataDescriptor);

    public abstract void removeMeasurementContentFormat(NativeMeasurementContentFormat nativeMeasurementContentFormat);

    public abstract NativeDocumentSaveResult save(NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract NativeDocumentSaveResult saveCheckpoint(String str);

    public abstract NativeDocumentSaveResult saveIfModified(NativeDocumentSaveOptions nativeDocumentSaveOptions);

    public abstract void setJavascriptStatus(NativeDocumentJavaScriptStatus nativeDocumentJavaScriptStatus);

    public abstract void setPageBinding(NativePageBinding nativePageBinding);

    public abstract void setSecondaryMeasurementUnit(NativeMeasurementSecondaryUnit nativeMeasurementSecondaryUnit);

    public abstract void setTextParserOptions(EnumSet<NativeTextParserOptions> enumSet);

    public abstract void setUid(String str);
}

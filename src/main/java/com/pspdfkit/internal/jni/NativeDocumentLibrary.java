package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentLibrary {

    public static final class CppProxy extends NativeDocumentLibrary {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentLibrary create(String str, NativeDatabaseEncryptionProvider nativeDatabaseEncryptionProvider, NativeEncryptionKeyProvider nativeEncryptionKeyProvider, NativeThreadPriority nativeThreadPriority, String str2, NativeFTSVersion nativeFTSVersion);

        private native void nativeDestroy(long j);

        private native void native_addIndexingObserver(long j, NativeDocumentLibraryIndexingObserver nativeDocumentLibraryIndexingObserver);

        private native void native_cancelAllPreviewTextOperations(long j);

        private native void native_cancelAllTasks(long j);

        private native void native_clearAllIndexes(long j);

        private native void native_enqueueDocumentDescriptors(long j, ArrayList<NativeLibraryDocumentDescriptor> arrayList, EnumSet<NativeEnqueueOptions> enumSet);

        private native void native_enqueueDocuments(long j, ArrayList<NativeDocument> arrayList, ArrayList<ArrayList<NativeAnnotation>> arrayList2, ArrayList<byte[]> arrayList3, EnumSet<NativeEnqueueOptions> enumSet);

        private native String native_getDatabaseFilePath(long j);

        private native int native_getMaxConcurrentOperations(long j);

        private native NativeDocumentLibraryIndexStatusProgress native_indexStatus(long j, String str);

        private native int native_indexedUidCount(long j);

        private native ArrayList<String> native_indexedUids(long j);

        private native boolean native_isIndexing(long j);

        private native boolean native_isSuspended(long j);

        private native byte[] native_metadataForUid(long j, String str);

        private native void native_query(long j, NativeDocumentLibraryQuery nativeDocumentLibraryQuery, NativeDocumentLibraryQueryResultHandler nativeDocumentLibraryQueryResultHandler);

        private native ArrayList<String> native_queuedUids(long j);

        private native void native_removeDocuments(long j, ArrayList<String> arrayList);

        private native void native_removeIndexingObserver(long j, NativeDocumentLibraryIndexingObserver nativeDocumentLibraryIndexingObserver);

        private native boolean native_saveReversedText(long j);

        private native void native_setMaxConcurrentOperations(long j, int i);

        private native void native_setSaveReversedText(long j, boolean z);

        private native void native_setSuspended(long j, boolean z);

        public static native String porterTokenizerName();

        public static native String unicodeTokenizerName();

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void addIndexingObserver(NativeDocumentLibraryIndexingObserver nativeDocumentLibraryIndexingObserver) {
            native_addIndexingObserver(this.nativeRef, nativeDocumentLibraryIndexingObserver);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void cancelAllPreviewTextOperations() {
            native_cancelAllPreviewTextOperations(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void cancelAllTasks() {
            native_cancelAllTasks(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void clearAllIndexes() {
            native_clearAllIndexes(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void enqueueDocumentDescriptors(ArrayList<NativeLibraryDocumentDescriptor> arrayList, EnumSet<NativeEnqueueOptions> enumSet) {
            native_enqueueDocumentDescriptors(this.nativeRef, arrayList, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void enqueueDocuments(ArrayList<NativeDocument> arrayList, ArrayList<ArrayList<NativeAnnotation>> arrayList2, ArrayList<byte[]> arrayList3, EnumSet<NativeEnqueueOptions> enumSet) {
            native_enqueueDocuments(this.nativeRef, arrayList, arrayList2, arrayList3, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public String getDatabaseFilePath() {
            return native_getDatabaseFilePath(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public int getMaxConcurrentOperations() {
            return native_getMaxConcurrentOperations(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public NativeDocumentLibraryIndexStatusProgress indexStatus(String str) {
            return native_indexStatus(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public int indexedUidCount() {
            return native_indexedUidCount(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public ArrayList<String> indexedUids() {
            return native_indexedUids(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public boolean isIndexing() {
            return native_isIndexing(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public boolean isSuspended() {
            return native_isSuspended(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public byte[] metadataForUid(String str) {
            return native_metadataForUid(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void query(NativeDocumentLibraryQuery nativeDocumentLibraryQuery, NativeDocumentLibraryQueryResultHandler nativeDocumentLibraryQueryResultHandler) {
            native_query(this.nativeRef, nativeDocumentLibraryQuery, nativeDocumentLibraryQueryResultHandler);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public ArrayList<String> queuedUids() {
            return native_queuedUids(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void removeDocuments(ArrayList<String> arrayList) {
            native_removeDocuments(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void removeIndexingObserver(NativeDocumentLibraryIndexingObserver nativeDocumentLibraryIndexingObserver) {
            native_removeIndexingObserver(this.nativeRef, nativeDocumentLibraryIndexingObserver);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public boolean saveReversedText() {
            return native_saveReversedText(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void setMaxConcurrentOperations(int i) {
            native_setMaxConcurrentOperations(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void setSaveReversedText(boolean z) {
            native_setSaveReversedText(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentLibrary
        public void setSuspended(boolean z) {
            native_setSuspended(this.nativeRef, z);
        }
    }

    public static NativeDocumentLibrary create(String str, NativeDatabaseEncryptionProvider nativeDatabaseEncryptionProvider, NativeEncryptionKeyProvider nativeEncryptionKeyProvider, NativeThreadPriority nativeThreadPriority, String str2, NativeFTSVersion nativeFTSVersion) {
        return CppProxy.create(str, nativeDatabaseEncryptionProvider, nativeEncryptionKeyProvider, nativeThreadPriority, str2, nativeFTSVersion);
    }

    public static String porterTokenizerName() {
        return CppProxy.porterTokenizerName();
    }

    public static String unicodeTokenizerName() {
        return CppProxy.unicodeTokenizerName();
    }

    public abstract void addIndexingObserver(NativeDocumentLibraryIndexingObserver nativeDocumentLibraryIndexingObserver);

    public abstract void cancelAllPreviewTextOperations();

    public abstract void cancelAllTasks();

    public abstract void clearAllIndexes();

    public abstract void enqueueDocumentDescriptors(ArrayList<NativeLibraryDocumentDescriptor> arrayList, EnumSet<NativeEnqueueOptions> enumSet);

    public abstract void enqueueDocuments(ArrayList<NativeDocument> arrayList, ArrayList<ArrayList<NativeAnnotation>> arrayList2, ArrayList<byte[]> arrayList3, EnumSet<NativeEnqueueOptions> enumSet);

    public abstract String getDatabaseFilePath();

    public abstract int getMaxConcurrentOperations();

    public abstract NativeDocumentLibraryIndexStatusProgress indexStatus(String str);

    public abstract int indexedUidCount();

    public abstract ArrayList<String> indexedUids();

    public abstract boolean isIndexing();

    public abstract boolean isSuspended();

    public abstract byte[] metadataForUid(String str);

    public abstract void query(NativeDocumentLibraryQuery nativeDocumentLibraryQuery, NativeDocumentLibraryQueryResultHandler nativeDocumentLibraryQueryResultHandler);

    public abstract ArrayList<String> queuedUids();

    public abstract void removeDocuments(ArrayList<String> arrayList);

    public abstract void removeIndexingObserver(NativeDocumentLibraryIndexingObserver nativeDocumentLibraryIndexingObserver);

    public abstract boolean saveReversedText();

    public abstract void setMaxConcurrentOperations(int i);

    public abstract void setSaveReversedText(boolean z);

    public abstract void setSuspended(boolean z);
}

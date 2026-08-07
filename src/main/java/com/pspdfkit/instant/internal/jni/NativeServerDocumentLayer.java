package com.pspdfkit.instant.internal.jni;

import com.pspdfkit.internal.jni.NativeAnnotation;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeServerDocumentLayer {

    public static final class CppProxy extends NativeServerDocumentLayer {
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

        private native NativeRecordContentMigrationTransactionResult native_attemptContentMigration(long j);

        private native NativeCommentThreadResult native_commentsForAnnotation(long j, NativeAnnotation nativeAnnotation);

        private native NativeCommentInsertionResult native_createComment(long j, String str, String str2, byte[] bArr, NativeAnnotation nativeAnnotation);

        private native void native_didRefreshAfterApplyingChanges(long j, NativeServerChangeApplicator nativeServerChangeApplicator, boolean z);

        private native NativeProgressReporterResult native_downloadDocument(long j, NativeInstantJWT nativeInstantJWT, NativeProgressObserver nativeProgressObserver);

        private native NativeAssetManager native_getAssetManager(long j);

        private native String native_getCreatorName(long j);

        private native NativeServerDocumentLayerState native_getCurrentState(long j);

        private native NativeMaybeStringResult native_getDefaultRecordGroup(long j);

        private native NativeServerDocumentLayerDelegate native_getDelegate(long j);

        private native NativeDocumentResult native_getDocument(long j);

        private native String native_getDocumentIdentifier(long j);

        private native NativeInstantJWT native_getJWT(long j);

        private native String native_getLayerName(long j);

        private native String native_getLocalDatabasePath(long j);

        private native String native_getLocalDocumentPath(long j);

        private native NativeMaybeStringResult native_getSourcePdfSha(long j);

        private native String native_getUserId(long j);

        private native void native_invalidate(long j);

        private native boolean native_isDownloaded(long j);

        private native NativeCommentThreadResult native_removeCommentWithId(long j, String str, NativeAnnotation nativeAnnotation);

        private native NativeInstantError native_removeLayerStorage(long j);

        private native NativeMaybeStringResult native_resetDefaultRecordGroup(long j);

        private native NativeProgressReporterResult native_scheduleDownloadOfAsset(long j, String str);

        private native NativeInstantError native_setDefaultRecordGroup(long j, String str);

        private native void native_setDelegate(long j, NativeServerDocumentLayerDelegate nativeServerDocumentLayerDelegate);

        private native boolean native_softDeleteCommentRootWithoutChildren(long j, NativeAnnotation nativeAnnotation);

        private native NativeInstantError native_startSyncingWithHint(long j, NativeSyncRequestHint nativeSyncRequestHint);

        private native void native_stopSyncing(long j, boolean z);

        private native void native_updateAuthenticationToken(long j, NativeInstantJWT nativeInstantJWT);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeRecordContentMigrationTransactionResult attemptContentMigration() {
            return native_attemptContentMigration(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeCommentThreadResult commentsForAnnotation(NativeAnnotation nativeAnnotation) {
            return native_commentsForAnnotation(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeCommentInsertionResult createComment(String str, String str2, byte[] bArr, NativeAnnotation nativeAnnotation) {
            return native_createComment(this.nativeRef, str, str2, bArr, nativeAnnotation);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public void didRefreshAfterApplyingChanges(NativeServerChangeApplicator nativeServerChangeApplicator, boolean z) {
            native_didRefreshAfterApplyingChanges(this.nativeRef, nativeServerChangeApplicator, z);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeProgressReporterResult downloadDocument(NativeInstantJWT nativeInstantJWT, NativeProgressObserver nativeProgressObserver) {
            return native_downloadDocument(this.nativeRef, nativeInstantJWT, nativeProgressObserver);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeAssetManager getAssetManager() {
            return native_getAssetManager(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public String getCreatorName() {
            return native_getCreatorName(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeServerDocumentLayerState getCurrentState() {
            return native_getCurrentState(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeMaybeStringResult getDefaultRecordGroup() {
            return native_getDefaultRecordGroup(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeServerDocumentLayerDelegate getDelegate() {
            return native_getDelegate(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeDocumentResult getDocument() {
            return native_getDocument(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public String getDocumentIdentifier() {
            return native_getDocumentIdentifier(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeInstantJWT getJWT() {
            return native_getJWT(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public String getLayerName() {
            return native_getLayerName(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public String getLocalDatabasePath() {
            return native_getLocalDatabasePath(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public String getLocalDocumentPath() {
            return native_getLocalDocumentPath(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeMaybeStringResult getSourcePdfSha() {
            return native_getSourcePdfSha(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public String getUserId() {
            return native_getUserId(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public void invalidate() {
            native_invalidate(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public boolean isDownloaded() {
            return native_isDownloaded(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeCommentThreadResult removeCommentWithId(String str, NativeAnnotation nativeAnnotation) {
            return native_removeCommentWithId(this.nativeRef, str, nativeAnnotation);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeInstantError removeLayerStorage() {
            return native_removeLayerStorage(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeMaybeStringResult resetDefaultRecordGroup() {
            return native_resetDefaultRecordGroup(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeProgressReporterResult scheduleDownloadOfAsset(String str) {
            return native_scheduleDownloadOfAsset(this.nativeRef, str);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeInstantError setDefaultRecordGroup(String str) {
            return native_setDefaultRecordGroup(this.nativeRef, str);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public void setDelegate(NativeServerDocumentLayerDelegate nativeServerDocumentLayerDelegate) {
            native_setDelegate(this.nativeRef, nativeServerDocumentLayerDelegate);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public boolean softDeleteCommentRootWithoutChildren(NativeAnnotation nativeAnnotation) {
            return native_softDeleteCommentRootWithoutChildren(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public NativeInstantError startSyncingWithHint(NativeSyncRequestHint nativeSyncRequestHint) {
            return native_startSyncingWithHint(this.nativeRef, nativeSyncRequestHint);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public void stopSyncing(boolean z) {
            native_stopSyncing(this.nativeRef, z);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer
        public void updateAuthenticationToken(NativeInstantJWT nativeInstantJWT) {
            native_updateAuthenticationToken(this.nativeRef, nativeInstantJWT);
        }
    }

    public abstract NativeRecordContentMigrationTransactionResult attemptContentMigration();

    public abstract NativeCommentThreadResult commentsForAnnotation(NativeAnnotation nativeAnnotation);

    public abstract NativeCommentInsertionResult createComment(String str, String str2, byte[] bArr, NativeAnnotation nativeAnnotation);

    public abstract void didRefreshAfterApplyingChanges(NativeServerChangeApplicator nativeServerChangeApplicator, boolean z);

    public abstract NativeProgressReporterResult downloadDocument(NativeInstantJWT nativeInstantJWT, NativeProgressObserver nativeProgressObserver);

    public abstract NativeAssetManager getAssetManager();

    public abstract String getCreatorName();

    public abstract NativeServerDocumentLayerState getCurrentState();

    public abstract NativeMaybeStringResult getDefaultRecordGroup();

    public abstract NativeServerDocumentLayerDelegate getDelegate();

    public abstract NativeDocumentResult getDocument();

    public abstract String getDocumentIdentifier();

    public abstract NativeInstantJWT getJWT();

    public abstract String getLayerName();

    public abstract String getLocalDatabasePath();

    public abstract String getLocalDocumentPath();

    public abstract NativeMaybeStringResult getSourcePdfSha();

    public abstract String getUserId();

    public abstract void invalidate();

    public abstract boolean isDownloaded();

    public abstract NativeCommentThreadResult removeCommentWithId(String str, NativeAnnotation nativeAnnotation);

    public abstract NativeInstantError removeLayerStorage();

    public abstract NativeMaybeStringResult resetDefaultRecordGroup();

    public abstract NativeProgressReporterResult scheduleDownloadOfAsset(String str);

    public abstract NativeInstantError setDefaultRecordGroup(String str);

    public abstract void setDelegate(NativeServerDocumentLayerDelegate nativeServerDocumentLayerDelegate);

    public abstract boolean softDeleteCommentRootWithoutChildren(NativeAnnotation nativeAnnotation);

    public abstract NativeInstantError startSyncingWithHint(NativeSyncRequestHint nativeSyncRequestHint);

    public abstract void stopSyncing(boolean z);

    public abstract void updateAuthenticationToken(NativeInstantJWT nativeInstantJWT);
}

package com.pspdfkit.instant.internal.jni;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeServerDocumentLayerDelegate {
    public abstract void didBeginLoadingAsset(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeProgressReporter nativeProgressReporter);

    public abstract void didBeginReceivingData(NativeServerDocumentLayer nativeServerDocumentLayer);

    public abstract void didBeginSendingAssetData(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeProgressReporter nativeProgressReporter);

    public abstract void didBeginSyncCycle(NativeServerDocumentLayer nativeServerDocumentLayer);

    public abstract void didBeginTransfer(NativeServerDocumentLayer nativeServerDocumentLayer, NativeSyncRequestType nativeSyncRequestType, NativeProgressReporter nativeProgressReporter, NativeProgressReporter nativeProgressReporter2);

    public abstract void didDetectCorruption(NativeServerDocumentLayer nativeServerDocumentLayer);

    public abstract void didFailLoadingAsset(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeInstantError nativeInstantError);

    public abstract void didFailSendingAssetData(NativeServerDocumentLayer nativeServerDocumentLayer, String str, NativeInstantError nativeInstantError);

    public abstract void didFailSyncing(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantError nativeInstantError);

    public abstract void didFailUpdatingAuthenticationToken(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantError nativeInstantError);

    public abstract void didFinishLoadingAsset(NativeServerDocumentLayer nativeServerDocumentLayer, NativeAsset nativeAsset);

    public abstract void didFinishSendingAssetData(NativeServerDocumentLayer nativeServerDocumentLayer, String str);

    public abstract void didFinishSyncing(NativeServerDocumentLayer nativeServerDocumentLayer);

    public abstract void didUpdateAuthenticationToken(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantJWT nativeInstantJWT, EnumSet<NativeLayerCapabilities> enumSet);

    public abstract void isBecomingInvalid(NativeServerDocumentLayer nativeServerDocumentLayer);

    public abstract void wantsToApplyChanges(NativeServerDocumentLayer nativeServerDocumentLayer, NativeServerChangeApplicator nativeServerChangeApplicator);
}

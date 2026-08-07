package com.pspdfkit.internal;

import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeProgressReporter;
import com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import com.pspdfkit.instant.internal.jni.NativeSyncRequestType;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public interface v4 {
    Object a(NativeServerDocumentLayer nativeServerDocumentLayer, NativeServerChangeApplicator nativeServerChangeApplicator, ContinuationImpl continuationImpl);

    void a(NativeServerDocumentLayer nativeServerDocumentLayer);

    void a(NativeServerDocumentLayer nativeServerDocumentLayer, NativeInstantError nativeInstantError);

    void a(NativeServerDocumentLayer nativeServerDocumentLayer, NativeSyncRequestType nativeSyncRequestType, NativeProgressReporter nativeProgressReporter, NativeProgressReporter nativeProgressReporter2);

    void b(NativeServerDocumentLayer nativeServerDocumentLayer);

    void c(NativeServerDocumentLayer nativeServerDocumentLayer);
}

package com.pspdfkit.instant.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public enum NativeServerDocumentLayerState {
    UNKNOWN,
    NEEDS_RECORD_CONTENT_MIGRATION,
    MIGRATING_RECORD_CONTENT,
    NEEDS_RESET_FOR_DATABASE_MIGRATION,
    RESETTING_FOR_DATABASE_MIGRATION,
    CLEAN,
    PENDING_CHANGES,
    PUSHING_CHANGES,
    FETCHING_CHANGES,
    INVALID
}

package com.box.android.data.api.models.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadJobStates;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INITIAL_STATE", "PREFLIGHT_CHECK_STATE", "UPLOAD_WHOLE_FILE_STATE", "UPLOAD_SESSION_CREATION_STATE", "UPLOAD_CHUNK_STATE", "UPLOAD_COMMIT_SESSION_STATE", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum UploadJobStates {
    INITIAL_STATE("initial"),
    PREFLIGHT_CHECK_STATE("preflight"),
    UPLOAD_WHOLE_FILE_STATE("upload_whole_file"),
    UPLOAD_SESSION_CREATION_STATE("upload_session_creation"),
    UPLOAD_CHUNK_STATE("uploading_chunk"),
    UPLOAD_COMMIT_SESSION_STATE("commit_session");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<UploadJobStates> getEntries() {
        return $ENTRIES;
    }

    UploadJobStates(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}

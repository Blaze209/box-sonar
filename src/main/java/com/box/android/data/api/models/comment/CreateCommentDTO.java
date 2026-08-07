package com.box.android.data.api.models.comment;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateCommentDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/api/models/comment/CreateCommentDTO;", "", "comment", "", "<init>", "(Ljava/lang/String;)V", "getComment", "()Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCommentDTO {
    private final String comment;

    public CreateCommentDTO(@Json(name = "message") String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.comment = comment;
    }

    public final String getComment() {
        return this.comment;
    }
}

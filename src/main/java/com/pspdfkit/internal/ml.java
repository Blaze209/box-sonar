package com.pspdfkit.internal;

import com.pspdfkit.instant.internal.jni.NativeComment;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ml {
    public final String a;
    public final String b;
    public final String c;
    public final Date d;
    public final Date e;

    public ml(NativeComment nativeComment) {
        nativeComment.getClass();
        String id = nativeComment.getId();
        id.getClass();
        String authorName = nativeComment.getAuthorName();
        authorName.getClass();
        String content = nativeComment.getContent();
        content.getClass();
        Date createdAt = nativeComment.getCreatedAt();
        createdAt.getClass();
        Date updatedAt = nativeComment.getUpdatedAt();
        updatedAt.getClass();
        id.getClass();
        authorName.getClass();
        content.getClass();
        createdAt.getClass();
        updatedAt.getClass();
        this.a = id;
        this.b = authorName;
        this.c = content;
        this.d = createdAt;
        this.e = updatedAt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ml)) {
            return false;
        }
        ml mlVar = (ml) obj;
        return Intrinsics.areEqual(this.a, mlVar.a) && Intrinsics.areEqual(this.b, mlVar.b) && Intrinsics.areEqual(this.c, mlVar.c) && Intrinsics.areEqual(this.d, mlVar.d) && Intrinsics.areEqual(this.e, mlVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + z40.a(this.c, z40.a(this.b, this.a.hashCode() * 31, 31), 31)) * 31);
    }

    public final String toString() {
        return "InstantComment(commentId=" + this.a + ", authorName=" + this.b + ", text=" + this.c + ", creationDate=" + this.d + ", lastModificationDate=" + this.e + ")";
    }
}

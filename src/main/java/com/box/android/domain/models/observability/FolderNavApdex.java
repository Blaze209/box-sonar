package com.box.android.domain.models.observability;

import kotlin.Metadata;

/* JADX INFO: compiled from: ApdexType.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/FolderNavApdex;", "Lcom/box/android/domain/models/observability/ApdexType;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FolderNavApdex implements ApdexType {
    public static final FolderNavApdex INSTANCE = new FolderNavApdex();
    private static final String name = "folder_nav";

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderNavApdex)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return -550581367;
    }

    public String toString() {
        return "FolderNavApdex";
    }

    private FolderNavApdex() {
    }

    @Override // com.box.android.domain.models.observability.ApdexType
    public String getName() {
        return name;
    }
}

package com.box.android.data.persistence;

import com.box.android.domain.models.DocumentPageFilterType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedDocumentPageEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/data/persistence/DocumentPageFilterTypeConverter;", "", "<init>", "()V", "fromDocumentPageFilterType", "", "value", "Lcom/box/android/domain/models/DocumentPageFilterType;", "toDocumentPageFilterType", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentPageFilterTypeConverter {
    public final String fromDocumentPageFilterType(DocumentPageFilterType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.name();
    }

    public final DocumentPageFilterType toDocumentPageFilterType(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return DocumentPageFilterType.valueOf(value);
    }
}

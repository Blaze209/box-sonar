package com.box.android.data.mappers.annotation;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationEntityDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"fromJsonOrNull", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/squareup/moshi/JsonAdapter;", "jsonString", "", "(Lcom/squareup/moshi/JsonAdapter;Ljava/lang/String;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnnotationEntityDomainMapperKt {
    public static final <T> T fromJsonOrNull(JsonAdapter<T> jsonAdapter, String jsonString) {
        T t;
        Intrinsics.checkNotNullParameter(jsonAdapter, "<this>");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            Result.Companion companion = Result.INSTANCE;
            t = (T) Result.m14780constructorimpl(jsonAdapter.fromJson(jsonString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            t = (T) Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14786isFailureimpl(t)) {
            return null;
        }
        return t;
    }
}

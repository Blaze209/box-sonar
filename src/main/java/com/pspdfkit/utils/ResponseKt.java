package com.pspdfkit.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"map", "Lcom/pspdfkit/utils/Response;", "R", ExifInterface.GPS_DIRECTION_TRUE, ViewProps.TRANSFORM, "Lkotlin/Function1;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ResponseKt {
    public static final <T, R> Response<R> map(Response<? extends T> response, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (response instanceof Response.Success) {
            return new Response.Success(transform.invoke((Object) ((Response.Success) response).getData()));
        }
        if (response instanceof Response.SuccessEmpty) {
            return Response.SuccessEmpty.INSTANCE;
        }
        if (response instanceof Response.Error) {
            return new Response.Error(((Response.Error) response).getException());
        }
        if (response instanceof Response.Loading) {
            return Response.Loading.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}

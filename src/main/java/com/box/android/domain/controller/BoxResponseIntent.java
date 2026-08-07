package com.box.android.domain.controller;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IBrowseController.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 !*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0001!B\u0019\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0012\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u00060\u0018j\u0002`\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/box/android/domain/controller/BoxResponseIntent;", ExifInterface.LONGITUDE_EAST, "Lcom/box/androidsdk/content/models/BoxObject;", "Landroid/content/Intent;", "response", "Lcom/box/androidsdk/content/requests/BoxResponse;", "<init>", "(Lcom/box/androidsdk/content/requests/BoxResponse;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getResponse", "()Lcom/box/androidsdk/content/requests/BoxResponse;", "isSuccess", "", "()Z", "request", "Lcom/box/androidsdk/content/requests/BoxRequest;", "getRequest", "()Lcom/box/androidsdk/content/requests/BoxRequest;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "getResult", "()Lcom/box/androidsdk/content/models/BoxObject;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException", "()Ljava/lang/Exception;", "writeToParcel", "", "out", "flags", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxResponseIntent<E extends BoxObject> extends Intent {
    private final BoxResponse<E> response;
    public static final Parcelable.Creator<BoxResponseIntent<?>> CREATOR = new Parcelable.Creator<BoxResponseIntent<?>>() { // from class: com.box.android.domain.controller.BoxResponseIntent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoxResponseIntent<?> createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new BoxResponseIntent<>(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoxResponseIntent<?>[] newArray(int size) {
            return new BoxResponseIntent[size];
        }
    };

    public /* synthetic */ BoxResponseIntent(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public final BoxResponse<E> getResponse() {
        return this.response;
    }

    public BoxResponseIntent(BoxResponse<E> boxResponse) {
        this.response = boxResponse;
        Intrinsics.checkNotNull(boxResponse);
        if (boxResponse.getRequest() != null) {
            setAction(boxResponse.getRequest().getClass().getName());
        }
    }

    public final boolean isSuccess() {
        BoxResponse<E> boxResponse = this.response;
        Intrinsics.checkNotNull(boxResponse);
        return boxResponse.isSuccess();
    }

    public final BoxRequest<?, ?> getRequest() {
        BoxResponse<E> boxResponse = this.response;
        Intrinsics.checkNotNull(boxResponse);
        BoxRequest<?, ?> request = boxResponse.getRequest();
        Intrinsics.checkNotNullExpressionValue(request, "getRequest(...)");
        return request;
    }

    public final E getResult() {
        BoxResponse<E> boxResponse = this.response;
        Intrinsics.checkNotNull(boxResponse);
        return (E) boxResponse.getResult();
    }

    public final Exception getException() {
        BoxResponse<E> boxResponse = this.response;
        Intrinsics.checkNotNull(boxResponse);
        Exception exception = boxResponse.getException();
        Intrinsics.checkNotNullExpressionValue(exception, "getException(...)");
        return exception;
    }

    @Override // android.content.Intent, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, flags);
        out.writeSerializable(this.response);
    }

    private BoxResponseIntent(Parcel parcel) {
        readFromParcel(parcel);
        Serializable serializable = parcel.readSerializable();
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.box.androidsdk.content.requests.BoxResponse<E of com.box.android.domain.controller.BoxResponseIntent>");
        this.response = (BoxResponse) serializable;
    }
}

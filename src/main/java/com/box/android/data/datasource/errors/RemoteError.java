package com.box.android.data.datasource.errors;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.IGenericError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001e2\u00020\u0001:\f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u0082\u0001\u0014\u001f !\"#$%&'()*+,-./012¨\u00063"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError;", "Lcom/box/android/domain/models/IGenericError;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "className", "getClassName", "equals", "", "other", "", "hashCode", "Unknown", "BadRequest", "Forbidden", "NotFound", "Unauthorized", "Conflict", "PreconditionFailed", "UnprocessableEntity", "InternalServerError", "UnknownHostError", "NetworkError", "Companion", "Lcom/box/android/data/datasource/errors/AnnotationsRemoteError;", "Lcom/box/android/data/datasource/errors/CollaborationRemoteError;", "Lcom/box/android/data/datasource/errors/CollectionsRemoteError;", "Lcom/box/android/data/datasource/errors/CreateFolderRemoteError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError;", "Lcom/box/android/data/datasource/errors/ObservabilityRemoteError;", "Lcom/box/android/data/datasource/errors/PushNotificationSettingsRemoteError;", "Lcom/box/android/data/datasource/errors/RemoteError$BadRequest;", "Lcom/box/android/data/datasource/errors/RemoteError$Conflict;", "Lcom/box/android/data/datasource/errors/RemoteError$Forbidden;", "Lcom/box/android/data/datasource/errors/RemoteError$InternalServerError;", "Lcom/box/android/data/datasource/errors/RemoteError$NetworkError;", "Lcom/box/android/data/datasource/errors/RemoteError$NotFound;", "Lcom/box/android/data/datasource/errors/RemoteError$PreconditionFailed;", "Lcom/box/android/data/datasource/errors/RemoteError$Unauthorized;", "Lcom/box/android/data/datasource/errors/RemoteError$Unknown;", "Lcom/box/android/data/datasource/errors/RemoteError$UnknownHostError;", "Lcom/box/android/data/datasource/errors/RemoteError$UnprocessableEntity;", "Lcom/box/android/data/datasource/errors/RequestCancelledError;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class RemoteError implements IGenericError {
    public static final int HTTP_UNPROCESSABLE_ENTITY = 422;
    private final String className;
    private final int code;
    private final String message;

    public /* synthetic */ RemoteError(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str);
    }

    private RemoteError(int i, String str) {
        this.code = i;
        this.message = str;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        this.className = name;
    }

    public /* synthetic */ RemoteError(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, null);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public final String getClassName() {
        return this.className;
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$Unknown;", "Lcom/box/android/data/datasource/errors/RemoteError;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unknown extends RemoteError {
        private final int code;
        private final String message;

        public static /* synthetic */ Unknown copy$default(Unknown unknown, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unknown.code;
            }
            if ((i2 & 2) != 0) {
                str = unknown.message;
            }
            return unknown.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Unknown copy(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Unknown(code, message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unknown)) {
                return false;
            }
            Unknown unknown = (Unknown) other;
            return this.code == unknown.code && Intrinsics.areEqual(this.message, unknown.message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Unknown(code=" + this.code + ", message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Unknown(int i, String message) {
            super(i, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(message, "message");
            this.code = i;
            this.message = message;
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int getCode() {
            return this.code;
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$BadRequest;", "Lcom/box/android/data/datasource/errors/RemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BadRequest extends RemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public BadRequest() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ BadRequest copy$default(BadRequest badRequest, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = badRequest.message;
            }
            return badRequest.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final BadRequest copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new BadRequest(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BadRequest) && Intrinsics.areEqual(this.message, ((BadRequest) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "BadRequest(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BadRequest(String message) {
            super(400, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ BadRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$Forbidden;", "Lcom/box/android/data/datasource/errors/RemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Forbidden extends RemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public Forbidden() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Forbidden copy$default(Forbidden forbidden, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = forbidden.message;
            }
            return forbidden.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Forbidden copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Forbidden(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Forbidden) && Intrinsics.areEqual(this.message, ((Forbidden) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Forbidden(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Forbidden(String message) {
            super(403, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ Forbidden(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$NotFound;", "Lcom/box/android/data/datasource/errors/RemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NotFound extends RemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public NotFound() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NotFound copy$default(NotFound notFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notFound.message;
            }
            return notFound.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NotFound copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NotFound(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NotFound) && Intrinsics.areEqual(this.message, ((NotFound) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NotFound(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NotFound(String message) {
            super(404, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ NotFound(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$Unauthorized;", "Lcom/box/android/data/datasource/errors/RemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unauthorized extends RemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public Unauthorized() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Unauthorized copy$default(Unauthorized unauthorized, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unauthorized.message;
            }
            return unauthorized.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Unauthorized copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Unauthorized(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unauthorized) && Intrinsics.areEqual(this.message, ((Unauthorized) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Unauthorized(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Unauthorized(String message) {
            super(401, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ Unauthorized(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$Conflict;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Conflict extends RemoteError {
        /* JADX WARN: Multi-variable type inference failed */
        public Conflict() {
            super(409, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$PreconditionFailed;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PreconditionFailed extends RemoteError {
        public static final PreconditionFailed INSTANCE = new PreconditionFailed();

        /* JADX WARN: Multi-variable type inference failed */
        private PreconditionFailed() {
            super(412, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$UnprocessableEntity;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UnprocessableEntity extends RemoteError {
        public static final UnprocessableEntity INSTANCE = new UnprocessableEntity();

        /* JADX WARN: Multi-variable type inference failed */
        private UnprocessableEntity() {
            super(422, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$InternalServerError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InternalServerError extends RemoteError {
        public static final InternalServerError INSTANCE = new InternalServerError();

        /* JADX WARN: Multi-variable type inference failed */
        private InternalServerError() {
            super(500, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$UnknownHostError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UnknownHostError extends RemoteError {
        /* JADX WARN: Multi-variable type inference failed */
        public UnknownHostError() {
            super(-1, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/RemoteError$NetworkError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NetworkError extends RemoteError {
        public static final NetworkError INSTANCE = new NetworkError();

        /* JADX WARN: Multi-variable type inference failed */
        private NetworkError() {
            super(-1, null, 2, 0 == true ? 1 : 0);
        }
    }

    public boolean equals(Object other) {
        String str = this.className;
        RemoteError remoteError = other instanceof RemoteError ? (RemoteError) other : null;
        return Intrinsics.areEqual(str, remoteError != null ? remoteError.className : null);
    }

    public int hashCode() {
        return this.className.hashCode();
    }
}

package com.box.android.data.api.models.observability;

import com.amplitude.api.AmplitudeClient;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadLogSiblingDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010*\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u00061"}, d2 = {"Lcom/box/android/data/api/models/observability/ClientLogMetadata;", "", "currentTime", "", "hashedUserInfo", "JSONFileName", "loginEmail", "fileNameUnhashedWithExtension", OAuthActivity.USER_ID, "logFileName", "userInfo", "fileNameHashedWithExtension", "fileNameHashedWithoutExtension", "fileNameUnhashedWithoutExtension", "logFileExtnesion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCurrentTime", "()Ljava/lang/String;", "getHashedUserInfo", "getJSONFileName", "getLoginEmail", "getFileNameUnhashedWithExtension", "getUserId", "getLogFileName", "getUserInfo", "getFileNameHashedWithExtension", "getFileNameHashedWithoutExtension", "getFileNameUnhashedWithoutExtension", "getLogFileExtnesion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ClientLogMetadata {
    private final String JSONFileName;
    private final String currentTime;
    private final String fileNameHashedWithExtension;
    private final String fileNameHashedWithoutExtension;
    private final String fileNameUnhashedWithExtension;
    private final String fileNameUnhashedWithoutExtension;
    private final String hashedUserInfo;
    private final String logFileExtnesion;
    private final String logFileName;
    private final String loginEmail;
    private final String userId;
    private final String userInfo;

    public static /* synthetic */ ClientLogMetadata copy$default(ClientLogMetadata clientLogMetadata, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clientLogMetadata.currentTime;
        }
        if ((i & 2) != 0) {
            str2 = clientLogMetadata.hashedUserInfo;
        }
        if ((i & 4) != 0) {
            str3 = clientLogMetadata.JSONFileName;
        }
        if ((i & 8) != 0) {
            str4 = clientLogMetadata.loginEmail;
        }
        if ((i & 16) != 0) {
            str5 = clientLogMetadata.fileNameUnhashedWithExtension;
        }
        if ((i & 32) != 0) {
            str6 = clientLogMetadata.userId;
        }
        if ((i & 64) != 0) {
            str7 = clientLogMetadata.logFileName;
        }
        if ((i & 128) != 0) {
            str8 = clientLogMetadata.userInfo;
        }
        if ((i & 256) != 0) {
            str9 = clientLogMetadata.fileNameHashedWithExtension;
        }
        if ((i & 512) != 0) {
            str10 = clientLogMetadata.fileNameHashedWithoutExtension;
        }
        if ((i & 1024) != 0) {
            str11 = clientLogMetadata.fileNameUnhashedWithoutExtension;
        }
        if ((i & 2048) != 0) {
            str12 = clientLogMetadata.logFileExtnesion;
        }
        String str13 = str11;
        String str14 = str12;
        String str15 = str9;
        String str16 = str10;
        String str17 = str7;
        String str18 = str8;
        String str19 = str5;
        String str20 = str6;
        return clientLogMetadata.copy(str, str2, str3, str4, str19, str20, str17, str18, str15, str16, str13, str14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCurrentTime() {
        return this.currentTime;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getFileNameHashedWithoutExtension() {
        return this.fileNameHashedWithoutExtension;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getFileNameUnhashedWithoutExtension() {
        return this.fileNameUnhashedWithoutExtension;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLogFileExtnesion() {
        return this.logFileExtnesion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHashedUserInfo() {
        return this.hashedUserInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getJSONFileName() {
        return this.JSONFileName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLoginEmail() {
        return this.loginEmail;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFileNameUnhashedWithExtension() {
        return this.fileNameUnhashedWithExtension;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLogFileName() {
        return this.logFileName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUserInfo() {
        return this.userInfo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFileNameHashedWithExtension() {
        return this.fileNameHashedWithExtension;
    }

    public final ClientLogMetadata copy(@Json(name = "current_time") String currentTime, @Json(name = "hashed_user_info") String hashedUserInfo, @Json(name = "json_file_name") String JSONFileName, @Json(name = "login_email") String loginEmail, @Json(name = "file_name_unhashed_with_extension") String fileNameUnhashedWithExtension, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "log_file_name") String logFileName, @Json(name = "user_info") String userInfo, @Json(name = "file_name_hashed_with_extension") String fileNameHashedWithExtension, @Json(name = "file_name_hashed_without_extension") String fileNameHashedWithoutExtension, @Json(name = "file_name_unhashed_without_extension") String fileNameUnhashedWithoutExtension, @Json(name = "log_file_extension") String logFileExtnesion) {
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Intrinsics.checkNotNullParameter(hashedUserInfo, "hashedUserInfo");
        Intrinsics.checkNotNullParameter(JSONFileName, "JSONFileName");
        Intrinsics.checkNotNullParameter(loginEmail, "loginEmail");
        Intrinsics.checkNotNullParameter(fileNameUnhashedWithExtension, "fileNameUnhashedWithExtension");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(logFileName, "logFileName");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(fileNameHashedWithExtension, "fileNameHashedWithExtension");
        Intrinsics.checkNotNullParameter(fileNameHashedWithoutExtension, "fileNameHashedWithoutExtension");
        Intrinsics.checkNotNullParameter(fileNameUnhashedWithoutExtension, "fileNameUnhashedWithoutExtension");
        Intrinsics.checkNotNullParameter(logFileExtnesion, "logFileExtnesion");
        return new ClientLogMetadata(currentTime, hashedUserInfo, JSONFileName, loginEmail, fileNameUnhashedWithExtension, userId, logFileName, userInfo, fileNameHashedWithExtension, fileNameHashedWithoutExtension, fileNameUnhashedWithoutExtension, logFileExtnesion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientLogMetadata)) {
            return false;
        }
        ClientLogMetadata clientLogMetadata = (ClientLogMetadata) other;
        return Intrinsics.areEqual(this.currentTime, clientLogMetadata.currentTime) && Intrinsics.areEqual(this.hashedUserInfo, clientLogMetadata.hashedUserInfo) && Intrinsics.areEqual(this.JSONFileName, clientLogMetadata.JSONFileName) && Intrinsics.areEqual(this.loginEmail, clientLogMetadata.loginEmail) && Intrinsics.areEqual(this.fileNameUnhashedWithExtension, clientLogMetadata.fileNameUnhashedWithExtension) && Intrinsics.areEqual(this.userId, clientLogMetadata.userId) && Intrinsics.areEqual(this.logFileName, clientLogMetadata.logFileName) && Intrinsics.areEqual(this.userInfo, clientLogMetadata.userInfo) && Intrinsics.areEqual(this.fileNameHashedWithExtension, clientLogMetadata.fileNameHashedWithExtension) && Intrinsics.areEqual(this.fileNameHashedWithoutExtension, clientLogMetadata.fileNameHashedWithoutExtension) && Intrinsics.areEqual(this.fileNameUnhashedWithoutExtension, clientLogMetadata.fileNameUnhashedWithoutExtension) && Intrinsics.areEqual(this.logFileExtnesion, clientLogMetadata.logFileExtnesion);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.currentTime.hashCode() * 31) + this.hashedUserInfo.hashCode()) * 31) + this.JSONFileName.hashCode()) * 31) + this.loginEmail.hashCode()) * 31) + this.fileNameUnhashedWithExtension.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.logFileName.hashCode()) * 31) + this.userInfo.hashCode()) * 31) + this.fileNameHashedWithExtension.hashCode()) * 31) + this.fileNameHashedWithoutExtension.hashCode()) * 31) + this.fileNameUnhashedWithoutExtension.hashCode()) * 31) + this.logFileExtnesion.hashCode();
    }

    public String toString() {
        return "ClientLogMetadata(currentTime=" + this.currentTime + ", hashedUserInfo=" + this.hashedUserInfo + ", JSONFileName=" + this.JSONFileName + ", loginEmail=" + this.loginEmail + ", fileNameUnhashedWithExtension=" + this.fileNameUnhashedWithExtension + ", userId=" + this.userId + ", logFileName=" + this.logFileName + ", userInfo=" + this.userInfo + ", fileNameHashedWithExtension=" + this.fileNameHashedWithExtension + ", fileNameHashedWithoutExtension=" + this.fileNameHashedWithoutExtension + ", fileNameUnhashedWithoutExtension=" + this.fileNameUnhashedWithoutExtension + ", logFileExtnesion=" + this.logFileExtnesion + ")";
    }

    public ClientLogMetadata(@Json(name = "current_time") String currentTime, @Json(name = "hashed_user_info") String hashedUserInfo, @Json(name = "json_file_name") String JSONFileName, @Json(name = "login_email") String loginEmail, @Json(name = "file_name_unhashed_with_extension") String fileNameUnhashedWithExtension, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "log_file_name") String logFileName, @Json(name = "user_info") String userInfo, @Json(name = "file_name_hashed_with_extension") String fileNameHashedWithExtension, @Json(name = "file_name_hashed_without_extension") String fileNameHashedWithoutExtension, @Json(name = "file_name_unhashed_without_extension") String fileNameUnhashedWithoutExtension, @Json(name = "log_file_extension") String logFileExtnesion) {
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Intrinsics.checkNotNullParameter(hashedUserInfo, "hashedUserInfo");
        Intrinsics.checkNotNullParameter(JSONFileName, "JSONFileName");
        Intrinsics.checkNotNullParameter(loginEmail, "loginEmail");
        Intrinsics.checkNotNullParameter(fileNameUnhashedWithExtension, "fileNameUnhashedWithExtension");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(logFileName, "logFileName");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(fileNameHashedWithExtension, "fileNameHashedWithExtension");
        Intrinsics.checkNotNullParameter(fileNameHashedWithoutExtension, "fileNameHashedWithoutExtension");
        Intrinsics.checkNotNullParameter(fileNameUnhashedWithoutExtension, "fileNameUnhashedWithoutExtension");
        Intrinsics.checkNotNullParameter(logFileExtnesion, "logFileExtnesion");
        this.currentTime = currentTime;
        this.hashedUserInfo = hashedUserInfo;
        this.JSONFileName = JSONFileName;
        this.loginEmail = loginEmail;
        this.fileNameUnhashedWithExtension = fileNameUnhashedWithExtension;
        this.userId = userId;
        this.logFileName = logFileName;
        this.userInfo = userInfo;
        this.fileNameHashedWithExtension = fileNameHashedWithExtension;
        this.fileNameHashedWithoutExtension = fileNameHashedWithoutExtension;
        this.fileNameUnhashedWithoutExtension = fileNameUnhashedWithoutExtension;
        this.logFileExtnesion = logFileExtnesion;
    }

    public final String getCurrentTime() {
        return this.currentTime;
    }

    public final String getHashedUserInfo() {
        return this.hashedUserInfo;
    }

    public final String getJSONFileName() {
        return this.JSONFileName;
    }

    public final String getLoginEmail() {
        return this.loginEmail;
    }

    public final String getFileNameUnhashedWithExtension() {
        return this.fileNameUnhashedWithExtension;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getLogFileName() {
        return this.logFileName;
    }

    public final String getUserInfo() {
        return this.userInfo;
    }

    public final String getFileNameHashedWithExtension() {
        return this.fileNameHashedWithExtension;
    }

    public final String getFileNameHashedWithoutExtension() {
        return this.fileNameHashedWithoutExtension;
    }

    public final String getFileNameUnhashedWithoutExtension() {
        return this.fileNameUnhashedWithoutExtension;
    }

    public final String getLogFileExtnesion() {
        return this.logFileExtnesion;
    }
}

package com.box.android.observability;

import android.net.Uri;
import com.box.android.domain.models.observability.DiagnosisMode;
import com.box.android.domain.models.observability.DiagnosisModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DiagnosisParamParser.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/observability/DiagnosisParamParser;", "", "<init>", "()V", "parseToModel", "Lcom/box/android/domain/models/observability/DiagnosisModel;", "uri", "Landroid/net/Uri;", "parseDiagnosisMode", "Lcom/box/android/domain/models/observability/DiagnosisMode;", "parseDuration", "", "(Landroid/net/Uri;)Ljava/lang/Integer;", "parseUploadAtCompletion", "", "(Landroid/net/Uri;)Ljava/lang/Boolean;", "parseClearOnLogout", "parseLogTag", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiagnosisParamParser {
    public static final int $stable = 0;
    public static final DiagnosisParamParser INSTANCE = new DiagnosisParamParser();

    private DiagnosisParamParser() {
    }

    public final DiagnosisModel parseToModel(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        DiagnosisModel.Builder builder = new DiagnosisModel.Builder(string);
        DiagnosisParamParser diagnosisParamParser = INSTANCE;
        DiagnosisMode diagnosisMode = diagnosisParamParser.parseDiagnosisMode(uri);
        if (diagnosisMode != null) {
            builder.mode(diagnosisMode);
        }
        Integer duration = diagnosisParamParser.parseDuration(uri);
        if (duration != null) {
            builder.duration(duration.intValue());
        }
        Boolean uploadAtCompletion = diagnosisParamParser.parseUploadAtCompletion(uri);
        if (uploadAtCompletion != null) {
            builder.shouldUpload(uploadAtCompletion.booleanValue());
        }
        Boolean clearOnLogout = diagnosisParamParser.parseClearOnLogout(uri);
        if (clearOnLogout != null) {
            builder.shouldClearLogs(clearOnLogout.booleanValue());
        }
        String logTag = diagnosisParamParser.parseLogTag(uri);
        if (logTag != null) {
            builder.tag(logTag);
        }
        return builder.build();
    }

    public final DiagnosisMode parseDiagnosisMode(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter(DiagnosisParams.DIAGNOSIS_MODE);
        String str = queryParameter;
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] charArray = queryParameter.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return DiagnosisMode.Util.getMode(charArray[0]);
    }

    public final Integer parseDuration(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter(DiagnosisParams.DIAGNOSIS_DURATION);
        if (queryParameter != null) {
            return StringsKt.toIntOrNull(queryParameter);
        }
        return null;
    }

    public final Boolean parseUploadAtCompletion(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter(DiagnosisParams.UPLOAD_AT_COMPLETION);
        if (queryParameter != null) {
            return Boolean.valueOf(StringsKt.equals(queryParameter, "y", true));
        }
        return null;
    }

    public final Boolean parseClearOnLogout(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter(DiagnosisParams.CLEAR_ON_LOGOUT);
        if (queryParameter != null) {
            return Boolean.valueOf(StringsKt.equals(queryParameter, "y", true));
        }
        return null;
    }

    public final String parseLogTag(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return uri.getQueryParameter("tag");
    }
}

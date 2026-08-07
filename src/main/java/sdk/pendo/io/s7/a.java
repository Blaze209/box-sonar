package sdk.pendo.io.s7;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.responses.converters.gson.PendoGsonRequestBodyConverter;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\u0005\u001a\u00020\n\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/s7/a;", "", "", "content", "Lsdk/pendo/io/e2/c0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/l4/r;", "response", "responseOf", "", "", "statusCode", "", "errorString", "b", "Lsdk/pendo/io/e2/e0;", "responseBody", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final sdk.pendo.io.e2.c0 a(String content) {
        if (content != null) {
            return sdk.pendo.io.e2.c0.INSTANCE.a(content, PendoGsonRequestBodyConverter.JSON_MEDIA_TYPE);
        }
        return null;
    }

    public final boolean a(int statusCode) {
        return statusCode == 451 || statusCode == 500 || statusCode == 401 || statusCode == 403 || statusCode == 406 || statusCode == 301;
    }

    public final void b(String errorString) {
        Intrinsics.checkNotNullParameter(errorString, "errorString");
        PendoLogger.d("APIUtils Socket Error: " + errorString, new Object[0]);
    }

    public final String a(sdk.pendo.io.e2.e0 responseBody) {
        if (responseBody == null) {
            return "";
        }
        sdk.pendo.io.s2.f e = responseBody.getE();
        e.request(Long.MAX_VALUE);
        sdk.pendo.io.s2.d buffer = e.getBuffer();
        sdk.pendo.io.e2.x c = responseBody.getC();
        if (c == null) {
            return "";
        }
        try {
            Charset charsetA = c.a(Charset.forName("UTF-8"));
            return (responseBody.getD() == 0 || charsetA == null) ? "" : buffer.clone().readString(charsetA);
        } catch (UnsupportedCharsetException unused) {
            PendoLogger.d("APIUtils Couldn't decode the response body; charset is likely malformed.", new Object[0]);
            return "";
        }
    }

    public final <T> void a(sdk.pendo.io.l4.r<T> response, String responseOf) {
        String strValidate;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(responseOf, "responseOf");
        int iB = response.b();
        sdk.pendo.io.e2.e0 e0VarC = response.c();
        try {
            if (response.c() == null) {
                PendoLogger.w("APIUtils Retrofit backend error -> response: " + responseOf + ", statusCode: " + iB + ", errorBody is null", new Object[0]);
                return;
            }
            String strA = a(e0VarC);
            if (a(iB) && (strValidate = JsonWebTokenValidator.INSTANCE.validate(strA)) != null) {
                strA = new JSONObject(strValidate).toString();
                Intrinsics.checkNotNullExpressionValue(strA, "toString(...)");
            }
            PendoLogger.w("APIUtils Retrofit backend error -> response: " + responseOf + ", statusCode: " + iB + ", errorBody: " + ((Object) strA), new Object[0]);
        } catch (external.sdk.pendo.io.jose4j.jwt.consumer.c unused) {
            PendoLogger.w("APIUtils Retrofit backend error -> response: " + responseOf + ", statusCode: " + iB + ", JWT can't validate errorBody", new Object[0]);
        } catch (IOException unused2) {
            PendoLogger.w("APIUtils Retrofit backend error -> response: " + responseOf + ", statusCode: " + iB + ", can't extract errorBody", new Object[0]);
        } catch (IllegalStateException unused3) {
            PendoLogger.w("APIUtils Retrofit backend error -> response: " + responseOf + ", statusCode: " + iB + ", JWT can't validate errorBody", new Object[0]);
        } catch (JSONException unused4) {
            PendoLogger.w("APIUtils Retrofit backend error -> response: " + responseOf + ", statusCode: " + iB + ", can't convert errorBody to JSON", new Object[0]);
        }
    }
}

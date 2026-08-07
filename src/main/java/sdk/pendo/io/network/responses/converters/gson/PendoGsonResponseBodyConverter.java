package sdk.pendo.io.network.responses.converters.gson;

import external.sdk.pendo.io.gson.TypeAdapter;
import external.sdk.pendo.io.jose4j.jwt.consumer.c;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Scanner;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.g0.a;
import sdk.pendo.io.l4.f;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.s7.d;

/* JADX INFO: loaded from: classes4.dex */
final class PendoGsonResponseBodyConverter<T> implements f<e0, T> {
    private static final String TAG = "PendoGsonResponseBodyConverter";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> mAdapter;
    private final Type mType;

    PendoGsonResponseBodyConverter(TypeAdapter<T> typeAdapter, Type type) {
        this.mAdapter = typeAdapter;
        this.mType = type;
    }

    private T validateAndParseResponse(String str, boolean z) {
        try {
            return this.mAdapter.a(JsonWebTokenValidator.INSTANCE.validate(str));
        } catch (c e) {
            PendoLogger.d(e, "PendoGsonResponseBodyConverter ->" + e.getMessage(), new Object[0]);
            if (!z) {
                return null;
            }
            d.a(str, "init", e.getMessage());
            return null;
        }
    }

    @Override // sdk.pendo.io.l4.f
    public T convert(e0 e0Var) {
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(e0Var.a(), UTF8);
            try {
                Scanner scannerUseDelimiter = new Scanner(inputStreamReader).useDelimiter("\\A");
                String next = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
                Type type = this.mType;
                T tValidateAndParseResponse = validateAndParseResponse(next, type != null ? a.a(type).a().equals(InitModel.class) : false);
                try {
                    inputStreamReader.close();
                } catch (IOException unused) {
                }
                e0Var.close();
                return tValidateAndParseResponse;
            } catch (Throwable th) {
                th = th;
                try {
                    PendoLogger.d(th, "PendoGsonResponseBodyConverter ->" + th.getMessage(), new Object[0]);
                    return null;
                } finally {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                    e0Var.close();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
        }
    }
}

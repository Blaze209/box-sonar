package com.pspdfkit.internal;

import com.google.common.net.HttpHeaders;
import com.pspdfkit.document.providers.AiAssistantPdfPasswordProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import io.nutrient.data.models.CompletionResponse;
import io.nutrient.data.models.IngestionResponse;
import io.nutrient.data.models.None;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public final String a;
    public final String b;
    public final Json c;
    public final OkHttpClient d;
    public final MediaType e;
    public final MediaType f;

    public static abstract class a<T> {

        /* JADX INFO: renamed from: com.pspdfkit.internal.y$a$a, reason: collision with other inner class name */
        public static final class C0295a extends a {
            public final int a;
            public final String b;

            public C0295a(int i, String str) {
                this.a = i;
                this.b = str;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0295a)) {
                    return false;
                }
                C0295a c0295a = (C0295a) obj;
                return this.a == c0295a.a && Intrinsics.areEqual(this.b, c0295a.b);
            }

            public final int hashCode() {
                return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
            }

            public final String toString() {
                return "Error(code=" + this.a + ", message=" + this.b + ")";
            }
        }

        public static final class b extends a {
            public final Exception a;

            public b(Exception exc) {
                this.a = exc;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.areEqual(this.a, ((b) obj).a);
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Exception(e=" + this.a + ")";
            }
        }

        public static final class c<T> extends a<T> {
            public final T a;

            public c(T t) {
                this.a = t;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && Intrinsics.areEqual(this.a, ((c) obj).a);
            }

            public final int hashCode() {
                T t = this.a;
                if (t == null) {
                    return 0;
                }
                return t.hashCode();
            }

            public final String toString() {
                return "Success(data=" + this.a + ")";
            }
        }
    }

    public static final class b {
        public static String a(String str) {
            return "base64:" + ByteString.INSTANCE.encodeUtf8(str).base64();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(String str, String str2) {
        Json jsonJson$default = JsonKt.Json$default(null, new Function1() { // from class: com.pspdfkit.internal.y$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return y.a((JsonBuilder) obj);
            }
        }, 1, null);
        str.getClass();
        str2.getClass();
        jsonJson$default.getClass();
        this.a = str;
        this.b = str2;
        this.c = jsonJson$default;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        httpLoggingInterceptor.redactHeader("pdf-password");
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.d = builderAddInterceptor.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
        MediaType.Companion companion = MediaType.INSTANCE;
        this.e = companion.get("application/json");
        this.f = companion.get(DocumentSharingIntentHelper.MIME_TYPE_PDF);
    }

    public static final Unit a(JsonBuilder jsonBuilder) {
        jsonBuilder.getClass();
        jsonBuilder.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    public static Socket b(String str, String str2) {
        str.getClass();
        str2.getClass();
        if (StringsKt.startsWith(str, "https", true) || StringsKt.startsWith(str, "http", true)) {
            str = StringsKt.replaceFirst(str, "http", "ws", true);
        }
        String path = new URI(str).getPath();
        String str3 = str + "/socket/v1/document-assistant";
        path.getClass();
        Socket socket = IO.socket(new URI(str3), IO.Options.builder().setPath(path + (StringsKt.endsWith$default(path, "/", false, 2, (Object) null) ? "" : "/") + "socket.io").setReconnection(true).setReconnectionAttempts(2).setTransports(new String[]{"websocket"}).setAuth(MapsKt.mapOf(new Pair("token", str2))).build());
        socket.getClass();
        return socket;
    }

    public final a a(DataProvider dataProvider, String str) {
        try {
            RequestBody.Companion companion = RequestBody.INSTANCE;
            byte[] bArr = dataProvider.read(dataProvider.getSize(), 0L);
            bArr.getClass();
            RequestBody requestBodyCreate$default = RequestBody.Companion.create$default(companion, bArr, this.f, 0, 0, 6, (Object) null);
            AiAssistantPdfPasswordProvider aiAssistantPdfPasswordProvider = dataProvider instanceof AiAssistantPdfPasswordProvider ? (AiAssistantPdfPasswordProvider) dataProvider : null;
            String pdfPassword = aiAssistantPdfPasswordProvider != null ? aiAssistantPdfPasswordProvider.getPdfPassword() : null;
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            mapCreateMapBuilder.put("Authorization", "Token token=" + str);
            mapCreateMapBuilder.put("Content-Type", this.f.getMediaType());
            mapCreateMapBuilder.put(HttpHeaders.ORIGIN, this.a);
            if (pdfPassword != null) {
                mapCreateMapBuilder.put("pdf-password", b.a(pdfPassword));
            }
            Unit unit = Unit.INSTANCE;
            try {
                Response responseExecute = this.d.newCall(a("POST", "/client/api/v1/documents/ingest", MapsKt.build(mapCreateMapBuilder), requestBodyCreate$default)).execute();
                String strString = responseExecute.body().string();
                if (!responseExecute.isSuccessful()) {
                    int iCode = responseExecute.code();
                    if (strString.length() == 0) {
                        strString = "Unknown error occurred";
                    }
                    return new a.C0295a(iCode, strString);
                }
                if (strString.length() == 0) {
                    if (new None() instanceof IngestionResponse) {
                        return new a.c((IngestionResponse) new None());
                    }
                    throw new Exception("Use None::class as return type for APIs with empty responses");
                }
                Json json = this.c;
                json.getSerializersModule();
                return new a.c(json.decodeFromString(IngestionResponse.INSTANCE.serializer(), strString));
            } catch (IOException e) {
                return new a.b(e);
            }
        } catch (Exception e2) {
            return new a.b(e2);
        }
    }

    public final a<None> a(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        try {
            try {
                Response responseExecute = this.d.newCall(a("GET", String.format("/client/api/v1/documents/%s/fileHash/%s", Arrays.copyOf(new Object[]{str, str2}, 2)), MapsKt.mapOf(TuplesKt.to("Authorization", "Token token=" + str3), TuplesKt.to("Content-Type", this.e.getMediaType()), TuplesKt.to(HttpHeaders.ORIGIN, this.a)), (RequestBody) null)).execute();
                String strString = responseExecute.body().string();
                if (responseExecute.isSuccessful()) {
                    if (strString.length() == 0) {
                        new None();
                        return new a.c(new None());
                    }
                    Json json = this.c;
                    json.getSerializersModule();
                    return new a.c(json.decodeFromString(None.INSTANCE.serializer(), strString));
                }
                int iCode = responseExecute.code();
                if (strString.length() == 0) {
                    strString = "Unknown error occurred";
                }
                return new a.C0295a(iCode, strString);
            } catch (IOException e) {
                return new a.b(e);
            }
        } catch (Exception e2) {
            return new a.b(e2);
        }
    }

    public final a<None> a(String str, String str2, String str3, String str4) {
        String str5;
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        try {
            if (str3.length() > 0) {
                str5 = String.format("/client/api/v1/documents/%s/layers/%s/ingest/%s", Arrays.copyOf(new Object[]{str, str3, str4}, 3));
            } else {
                str5 = String.format("/client/api/v1/documents/%s/ingest/%s", Arrays.copyOf(new Object[]{str, str4}, 2));
            }
            try {
                Response responseExecute = this.d.newCall(a("GET", str5, MapsKt.mapOf(TuplesKt.to("Authorization", "Token token=" + str2), TuplesKt.to("Content-Type", this.e.getMediaType()), TuplesKt.to(HttpHeaders.ORIGIN, this.a)), (RequestBody) null)).execute();
                String strString = responseExecute.body().string();
                if (responseExecute.isSuccessful()) {
                    if (strString.length() == 0) {
                        new None();
                        return new a.c(new None());
                    }
                    Json json = this.c;
                    json.getSerializersModule();
                    return new a.c(json.decodeFromString(None.INSTANCE.serializer(), strString));
                }
                int iCode = responseExecute.code();
                if (strString.length() == 0) {
                    strString = "Unknown error occurred";
                }
                return new a.C0295a(iCode, strString);
            } catch (IOException e) {
                return new a.b(e);
            }
        } catch (Exception e2) {
            return new a.b(e2);
        }
    }

    public final a a(String str, String str2) {
        try {
            try {
                Response responseExecute = this.d.newCall(a("GET", String.format("/client/api/v1/sessions/%s", Arrays.copyOf(new Object[]{str}, 1)), MapsKt.mapOf(TuplesKt.to("Authorization", "Token token=" + str2), TuplesKt.to("Content-Type", this.e.getMediaType()), TuplesKt.to(HttpHeaders.ORIGIN, this.a)), (RequestBody) null)).execute();
                String strString = responseExecute.body().string();
                if (responseExecute.isSuccessful()) {
                    if (strString.length() == 0) {
                        if (new None() instanceof List) {
                            return new a.c((List) new None());
                        }
                        throw new Exception("Use None::class as return type for APIs with empty responses");
                    }
                    Json json = this.c;
                    json.getSerializersModule();
                    return new a.c(json.decodeFromString(new ArrayListSerializer(CompletionResponse.INSTANCE.serializer()), strString));
                }
                int iCode = responseExecute.code();
                if (strString.length() == 0) {
                    strString = "Unknown error occurred";
                }
                return new a.C0295a(iCode, strString);
            } catch (IOException e) {
                return new a.b(e);
            }
        } catch (Exception e2) {
            return new a.b(e2);
        }
    }

    public final Request a(String str, String str2, Map<String, String> map, RequestBody requestBody) {
        Request.Builder builderMethod = new Request.Builder().url(this.b + str2).method(str, requestBody);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderMethod.addHeader(entry.getKey(), entry.getValue());
        }
        return builderMethod.build();
    }
}

package com.pspdfkit.internal;

import android.content.Context;
import android.util.Base64;
import com.pspdfkit.internal.jni.NativeDigitalSignatureBinaryResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureCreationError;
import com.pspdfkit.internal.jni.NativeTimestampAuthorityInfo;
import com.pspdfkit.internal.jni.NativeTimestamper;
import com.pspdfkit.signatures.timestamp.TimestampData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal$processTimeStamp$2", f = "SigningManagerInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class q20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends byte[]>>, Object> {
    public /* synthetic */ Object a;
    public final /* synthetic */ TimestampData b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ Context d;

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal$processTimeStamp$2$1", f = "SigningManagerInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        public final /* synthetic */ TimestampData a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TimestampData timestampData, byte[] bArr, Context context, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = timestampData;
            this.b = bArr;
            this.c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            TimestampData timestampData = this.a;
            byte[] bArr = this.b;
            bArr.getClass();
            String strGenerateTimestampRequest = NativeTimestamper.generateTimestampRequest(new NativeTimestampAuthorityInfo(timestampData.getUrl(), timestampData.getUsername(), timestampData.getPassword()), bArr, true);
            Json.Companion companion = Json.INSTANCE;
            strGenerateTimestampRequest.getClass();
            companion.getSerializersModule();
            r60 r60Var = (r60) companion.decodeFromString(r60.Companion.serializer(), strGenerateTimestampRequest);
            File cacheDir = this.c.getCacheDir();
            cacheDir.getClass();
            File file = new File(cacheDir, "timestamp_request.tsq");
            if (file.exists()) {
                file.delete();
            }
            r60Var.getClass();
            byte[] bArrDecode = Base64.decode(r60Var.c, 0);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArrDecode);
            fileOutputStream.close();
            Response responseExecute = new OkHttpClient().newCall(new Request.Builder().url(r60Var.f).post(RequestBody.Companion.create$default(RequestBody.INSTANCE, file, (MediaType) null, 1, (Object) null)).addHeader("Content-Type", r60Var.a).build()).execute();
            byte[] bArrEncode = Base64.encode(responseExecute.body().bytes(), 0);
            int iCode = responseExecute.code();
            bArrEncode.getClass();
            rc rcVar = new rc(r60Var.d, iCode, new String(bArrEncode, Charsets.UTF_8));
            companion.getSerializersModule();
            NativeDigitalSignatureBinaryResult nativeDigitalSignatureBinaryResultDeserializeTimestampToken = NativeTimestamper.deserializeTimestampToken(companion.encodeToString(rc.Companion.serializer(), rcVar));
            nativeDigitalSignatureBinaryResultDeserializeTimestampToken.getClass();
            if (!nativeDigitalSignatureBinaryResultDeserializeTimestampToken.getHasError()) {
                return nativeDigitalSignatureBinaryResultDeserializeTimestampToken.getValue();
            }
            NativeDigitalSignatureCreationError error = nativeDigitalSignatureBinaryResultDeserializeTimestampToken.getError();
            throw new RuntimeException(error != null ? error.getErrorMessage() : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q20(TimestampData timestampData, byte[] bArr, Context context, Continuation<? super q20> continuation) {
        super(2, continuation);
        this.b = timestampData;
        this.c = bArr;
        this.d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        q20 q20Var = new q20(this.b, this.c, this.d, continuation);
        q20Var.a = obj;
        return q20Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends byte[]>> continuation) {
        return ((q20) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.a;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new a(this.b, this.c, this.d, null), 2, null);
    }
}

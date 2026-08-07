package sdk.pendo.io.p7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.h7.m;
import sdk.pendo.io.n4.k;
import sdk.pendo.io.n4.o;
import sdk.pendo.io.n4.t;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lsdk/pendo/io/p7/d;", "", "Lsdk/pendo/io/e2/c0;", "body", "", "sdkVersion", "currentTime", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/e2/c0;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/h7/m;", "b", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface d {
    @k({"Content-Encoding: deflate"})
    @o("/data/mobile/rec")
    Object a(@sdk.pendo.io.n4.a c0 c0Var, @t("v") String str, @t("ct") String str2, Continuation<? super Unit> continuation);

    @k({"Content-Encoding: gzip"})
    @o("/data/mobile/recordingconf")
    Object b(@sdk.pendo.io.n4.a c0 c0Var, @t("v") String str, @t("ct") String str2, Continuation<? super m> continuation);
}

package sdk.pendo.io.q7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.h7.m;
import sdk.pendo.io.h7.n;
import sdk.pendo.io.h7.q;
import sdk.pendo.io.models.SessionData;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\nJ!\u0010\u0005\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/q7/a;", "", "Lsdk/pendo/io/h7/n;", "envelope", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/h7/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/models/SessionData;", "sessionData", "Lsdk/pendo/io/h7/m;", "(Lsdk/pendo/io/models/SessionData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lsdk/pendo/io/h7/q;", BoxConvertedPushNotificationDevice.EVENTS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface a {
    Object a(List<? extends q> list, Continuation<? super Unit> continuation);

    Object a(n nVar, Continuation<? super Unit> continuation);

    Object a(SessionData sessionData, Continuation<? super m> continuation);
}

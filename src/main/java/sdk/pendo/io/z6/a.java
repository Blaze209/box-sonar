package sdk.pendo.io.z6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/z6/a;", "Lsdk/pendo/io/z6/b;", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lkotlinx/coroutines/CoroutineDispatcher;", "io", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "c", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "d", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "main", "default", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a implements b {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final CoroutineDispatcher io = Dispatchers.getIO();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final MainCoroutineDispatcher main = Dispatchers.getMain();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final CoroutineDispatcher default = Dispatchers.getDefault();

    private a() {
    }

    @Override // sdk.pendo.io.z6.b
    public CoroutineDispatcher a() {
        return io;
    }

    @Override // sdk.pendo.io.z6.b
    public CoroutineDispatcher c() {
        return default;
    }

    @Override // sdk.pendo.io.z6.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public MainCoroutineDispatcher b() {
        return main;
    }
}

package androidx.media3.effect;

import androidx.media3.common.util.Consumer;
import kotlin.Metadata;

/* JADX INFO: compiled from: RenderingPacketConsumer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\nH&¨\u0006\r"}, d2 = {"Landroidx/media3/effect/RenderingPacketConsumer;", "I", "O", "Landroidx/media3/effect/PacketConsumer;", "setRenderOutput", "", "output", "(Ljava/lang/Object;)V", "setErrorConsumer", "errorConsumer", "Landroidx/media3/common/util/Consumer;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RenderingPacketConsumer<I, O> extends PacketConsumer<I> {
    void setErrorConsumer(Consumer<Exception> errorConsumer);

    void setRenderOutput(O output);
}

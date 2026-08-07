package androidx.media3.effect;

import kotlin.Metadata;

/* JADX INFO: compiled from: PacketProcessor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H&¨\u0006\u0007"}, d2 = {"Landroidx/media3/effect/PacketProcessor;", "I", "O", "Landroidx/media3/effect/PacketConsumer;", "setOutput", "", "output", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PacketProcessor<I, O> extends PacketConsumer<I> {
    void setOutput(PacketConsumer<O> output);
}

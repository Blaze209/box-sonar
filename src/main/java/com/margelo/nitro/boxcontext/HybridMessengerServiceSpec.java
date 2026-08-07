package com.margelo.nitro.boxcontext;

import com.facebook.jni.HybridData;
import com.margelo.nitro.core.HybridObject;
import com.margelo.nitro.core.Promise;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HybridMessengerServiceSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH'J.\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH'J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH'J\t\u0010\u0013\u001a\u00020\u0005H\u0082 R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/margelo/nitro/boxcontext/HybridMessengerServiceSpec;", "Lcom/margelo/nitro/core/HybridObject;", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "updateNative", "", "hybridData", "toString", "", "sendMessage", "recipientId", SemanticAttributes.MessagingDestinationKindValues.TOPIC, "message", "getResult", "Lcom/margelo/nitro/core/Promise;", "resultTopic", "listen", "initHybrid", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HybridMessengerServiceSpec extends HybridObject {
    protected static final String TAG = "HybridMessengerServiceSpec";
    private HybridData mHybridData;

    private final native HybridData initHybrid();

    public abstract Promise<String> getResult(String recipientId, String topic, String message, String resultTopic);

    public abstract Promise<String> listen(String recipientId, String topic);

    public abstract void sendMessage(String recipientId, String topic, String message);

    public HybridMessengerServiceSpec() {
        HybridData hybridDataInitHybrid = initHybrid();
        this.mHybridData = hybridDataInitHybrid;
        super.updateNative(hybridDataInitHybrid);
    }

    @Override // com.margelo.nitro.core.HybridObject
    protected void updateNative(HybridData hybridData) {
        Intrinsics.checkNotNullParameter(hybridData, "hybridData");
        this.mHybridData = hybridData;
        super.updateNative(hybridData);
    }

    @Override // com.margelo.nitro.core.HybridObject
    public String toString() {
        return "[HybridObject MessengerService]";
    }
}

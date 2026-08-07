package com.margelo.nitro.com.nitromarkdown;

import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxFile;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HybridMarkdownSession.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010 \u001a\u00020\u000bH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/margelo/nitro/com/nitromarkdown/HybridMarkdownSession;", "Lcom/margelo/nitro/com/nitromarkdown/HybridMarkdownSessionSpec;", "<init>", "()V", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "listeners", "", "", "Lkotlin/Function0;", "", "nextListenerId", BoxFile.FIELD_LOCK, "", "value", "", "highlightPosition", "getHighlightPosition", "()D", "setHighlightPosition", "(D)V", "memorySize", "getMemorySize", "()J", "append", "chunk", "", DiagnosisParams.CLEAR_ON_LOGOUT, "getAllText", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "notifyListeners", "react-native-nitro-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HybridMarkdownSession extends HybridMarkdownSessionSpec {
    private double highlightPosition;
    private long nextListenerId;
    private StringBuilder buffer = new StringBuilder();
    private final Map<Long, Function0<Unit>> listeners = new LinkedHashMap();
    private final Object lock = new Object();

    @Override // com.margelo.nitro.com.nitromarkdown.HybridMarkdownSessionSpec
    public double getHighlightPosition() {
        return this.highlightPosition;
    }

    @Override // com.margelo.nitro.com.nitromarkdown.HybridMarkdownSessionSpec
    public void setHighlightPosition(double d) {
        synchronized (this.lock) {
            this.highlightPosition = d;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.margelo.nitro.core.HybridObject
    public long getMemorySize() {
        return this.buffer.length();
    }

    @Override // com.margelo.nitro.com.nitromarkdown.HybridMarkdownSessionSpec
    public void append(String chunk) {
        Intrinsics.checkNotNullParameter(chunk, "chunk");
        synchronized (this.lock) {
            this.buffer.append(chunk);
        }
        notifyListeners();
    }

    @Override // com.margelo.nitro.com.nitromarkdown.HybridMarkdownSessionSpec
    public void clear() {
        synchronized (this.lock) {
            StringsKt.clear(this.buffer);
            setHighlightPosition(0.0d);
            Unit unit = Unit.INSTANCE;
        }
        notifyListeners();
    }

    @Override // com.margelo.nitro.com.nitromarkdown.HybridMarkdownSessionSpec
    public String getAllText() {
        String string;
        synchronized (this.lock) {
            string = this.buffer.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        }
        return string;
    }

    @Override // com.margelo.nitro.com.nitromarkdown.HybridMarkdownSessionSpec
    public Function0<Unit> addListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Ref.LongRef longRef = new Ref.LongRef();
        synchronized (this.lock) {
            long j = this.nextListenerId;
            this.nextListenerId = 1 + j;
            longRef.element = j;
            this.listeners.put(Long.valueOf(longRef.element), listener);
            Unit unit = Unit.INSTANCE;
        }
        return new Function0() { // from class: com.margelo.nitro.com.nitromarkdown.HybridMarkdownSession$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HybridMarkdownSession.addListener$lambda$6(this.f$0, longRef);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addListener$lambda$6(HybridMarkdownSession hybridMarkdownSession, Ref.LongRef longRef) {
        synchronized (hybridMarkdownSession.lock) {
            hybridMarkdownSession.listeners.remove(Long.valueOf(longRef.element));
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void notifyListeners() {
        List list;
        synchronized (this.lock) {
            list = CollectionsKt.toList(this.listeners.values());
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }
}

package zipkin2.internal;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Call;
import zipkin2.Callback;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AggregateCall<I, O> extends Call.Base<O> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final List<Call<I>> delegate;
    final Logger log = Logger.getLogger(getClass().getName());

    protected abstract void append(I i, O o);

    protected O finish(O o) {
        return o;
    }

    protected abstract boolean isEmpty(O o);

    protected abstract O newOutput();

    public static Call<Void> newVoidCall(List<Call<Void>> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("calls were empty");
        }
        return list.size() == 1 ? list.get(0) : new AggregateVoidCall(list);
    }

    static final class AggregateVoidCall extends AggregateCall<Void, Void> {
        volatile boolean empty;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zipkin2.internal.AggregateCall
        public Void newOutput() {
            return null;
        }

        AggregateVoidCall(List<Call<Void>> list) {
            super(list);
            this.empty = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zipkin2.internal.AggregateCall
        public void append(Void r1, Void r2) {
            this.empty = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zipkin2.internal.AggregateCall
        public boolean isEmpty(Void r1) {
            return this.empty;
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public AggregateVoidCall clone() {
            return new AggregateVoidCall(cloneCalls());
        }
    }

    protected AggregateCall(List<Call<I>> list) {
        this.delegate = list;
    }

    @Override // zipkin2.Call.Base
    protected O doExecute() throws IOException {
        int size = this.delegate.size();
        O oNewOutput = newOutput();
        Throwable th = null;
        for (int i = 0; i < size; i++) {
            Call<I> call = this.delegate.get(i);
            try {
                append(call.execute(), oNewOutput);
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else if (this.log.isLoggable(Level.INFO)) {
                    this.log.log(Level.INFO, "error from " + call, th2);
                }
            }
        }
        if (th == null) {
            return finish(oNewOutput);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        throw ((IOException) th);
    }

    @Override // zipkin2.Call.Base
    protected void doEnqueue(Callback<O> callback) {
        int size = this.delegate.size();
        AtomicInteger atomicInteger = new AtomicInteger(size);
        AtomicReference atomicReference = new AtomicReference();
        O oNewOutput = newOutput();
        for (int i = 0; i < size; i++) {
            Call<I> call = this.delegate.get(i);
            call.enqueue(new CountdownCallback(call, atomicInteger, atomicReference, oNewOutput, callback));
        }
    }

    @Override // zipkin2.Call.Base
    protected void doCancel() {
        int size = this.delegate.size();
        for (int i = 0; i < size; i++) {
            this.delegate.get(i).cancel();
        }
    }

    class CountdownCallback implements Callback<I> {
        final Call<I> call;
        final Callback<O> callback;
        final AtomicReference<Throwable> firstError;
        final AtomicInteger remaining;

        @Nullable
        final O result;

        CountdownCallback(Call<I> call, AtomicInteger atomicInteger, AtomicReference<Throwable> atomicReference, O o, Callback<O> callback) {
            this.call = call;
            this.remaining = atomicInteger;
            this.firstError = atomicReference;
            this.result = o;
            this.callback = callback;
        }

        @Override // zipkin2.Callback
        public void onSuccess(I i) {
            synchronized (this.callback) {
                AggregateCall.this.append(i, this.result);
                if (this.remaining.decrementAndGet() > 0) {
                    return;
                }
                Throwable th = this.firstError.get();
                if (th != null) {
                    this.callback.onError(th);
                } else {
                    this.callback.onSuccess((O) AggregateCall.this.finish(this.result));
                }
            }
        }

        @Override // zipkin2.Callback
        public synchronized void onError(Throwable th) {
            if (AggregateCall.this.log.isLoggable(Level.INFO)) {
                AggregateCall.this.log.log(Level.INFO, "error from " + this.call, th);
            }
            synchronized (this.callback) {
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.firstError, null, th);
                if (this.remaining.decrementAndGet() > 0) {
                    return;
                }
                this.callback.onError(this.firstError.get());
            }
        }
    }

    protected final List<Call<I>> cloneCalls() {
        int size = this.delegate.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.delegate.get(i).clone());
        }
        return arrayList;
    }

    public final List<Call<I>> delegate() {
        return this.delegate;
    }

    public String toString() {
        return "AggregateCall{" + this.delegate + "}";
    }
}

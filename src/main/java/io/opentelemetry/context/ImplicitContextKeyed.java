package io.opentelemetry.context;

/* JADX INFO: loaded from: classes4.dex */
public interface ImplicitContextKeyed {
    Context storeInContext(Context context);

    default Scope makeCurrent() {
        return Context.current().with(this).makeCurrent();
    }
}

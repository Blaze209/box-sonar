package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
public interface Function extends Scriptable, Callable {
    @Override // external.sdk.pendo.io.mozilla.javascript.Callable
    Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);

    Scriptable construct(Context context, Scriptable scriptable, Object[] objArr);
}

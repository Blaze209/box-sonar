package external.sdk.pendo.io.mozilla.javascript;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Ref implements Serializable {
    private static final long serialVersionUID = 4044540354730911424L;

    public boolean delete(Context context) {
        return false;
    }

    public abstract Object get(Context context);

    public boolean has(Context context) {
        return true;
    }

    public Object set(Context context, Scriptable scriptable, Object obj) {
        return set(context, obj);
    }

    @Deprecated
    public abstract Object set(Context context, Object obj);
}

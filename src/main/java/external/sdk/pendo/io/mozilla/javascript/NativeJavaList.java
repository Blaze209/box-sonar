package external.sdk.pendo.io.mozilla.javascript;

import com.pspdfkit.analytics.Analytics;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaList extends NativeJavaObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private List<Object> list;

    public NativeJavaList(Scriptable scriptable, Object obj) {
        super(scriptable, obj, obj.getClass());
        this.list = (List) obj;
    }

    private boolean isWithValidIndex(int i) {
        return i >= 0 && i < this.list.size();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (!isWithValidIndex(i)) {
            return Undefined.instance;
        }
        Context context = Context.getContext();
        Object obj = this.list.get(i);
        return context.getWrapFactory().wrap(context, this, obj, obj.getClass());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaList";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        List list = (List) this.javaObject;
        Object[] objArr = new Object[list.size()];
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return objArr;
            }
            objArr[size] = Integer.valueOf(size);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (isWithValidIndex(i)) {
            return true;
        }
        return super.has(i, scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (isWithValidIndex(i)) {
            this.list.set(i, Context.jsToJava(obj, Object.class));
        } else {
            super.put(i, scriptable, obj);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        return SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol) ? Boolean.TRUE : super.get(symbol, scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        if (SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol)) {
            return true;
        }
        return super.has(symbol, scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return Analytics.Data.LENGTH.equals(str) ? Integer.valueOf(this.list.size()) : super.get(str, scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        if (str.equals(Analytics.Data.LENGTH)) {
            return true;
        }
        return super.has(str, scriptable);
    }
}

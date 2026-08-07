package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeStringIterator extends ES6Iterator {
    private static final String ITERATOR_TAG = "StringIterator";
    private static final long serialVersionUID = 1;
    private int index;
    private String string;

    private NativeStringIterator() {
    }

    NativeStringIterator(Scriptable scriptable, Object obj) {
        super(scriptable, ITERATOR_TAG);
        this.index = 0;
        this.string = ScriptRuntime.toString(obj);
    }

    static void init(ScriptableObject scriptableObject, boolean z) {
        ES6Iterator.init(scriptableObject, z, new NativeStringIterator(), ITERATOR_TAG);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "String Iterator";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ES6Iterator
    protected String getTag() {
        return ITERATOR_TAG;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ES6Iterator
    protected boolean isDone(Context context, Scriptable scriptable) {
        return this.index >= this.string.length();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ES6Iterator
    protected Object nextValue(Context context, Scriptable scriptable) {
        int iOffsetByCodePoints = this.string.offsetByCodePoints(this.index, 1);
        String strSubstring = this.string.substring(this.index, iOffsetByCodePoints);
        this.index = iOffsetByCodePoints;
        return strSubstring;
    }
}

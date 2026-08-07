package external.sdk.pendo.io.mozilla.javascript.xmlimpl;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes4.dex */
class XMLCtor extends IdFunctionObject {
    private static final int Id_defaultSettings = 1;
    private static final int Id_ignoreComments = 1;
    private static final int Id_ignoreProcessingInstructions = 2;
    private static final int Id_ignoreWhitespace = 3;
    private static final int Id_prettyIndent = 4;
    private static final int Id_prettyPrinting = 5;
    private static final int Id_setSettings = 3;
    private static final int Id_settings = 2;
    private static final int MAX_FUNCTION_ID = 3;
    private static final int MAX_INSTANCE_ID = 5;
    private static final Object XMLCTOR_TAG = "XMLCtor";
    static final long serialVersionUID = -8708195078359817341L;
    private XmlProcessor options;

    XMLCtor(XML xml, Object obj, int i, int i2) {
        super(xml, obj, i, i2);
        this.options = xml.getProcessor();
        activatePrototypeMap(3);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0035  */
    /* JADX WARN: Code duplicated, block: B:33:0x0038 A[SYNTHETIC] */
    private void readSettings(Scriptable scriptable) {
        for (int i = 1; i <= 5; i++) {
            int maxInstanceId = super.getMaxInstanceId() + i;
            Object property = ScriptableObject.getProperty(scriptable, getInstanceIdName(maxInstanceId));
            if (property != Scriptable.NOT_FOUND) {
                if (i == 1 || i == 2 || i == 3) {
                    if (!(property instanceof Boolean)) {
                        setInstanceIdValue(maxInstanceId, property);
                    }
                } else if (i != 4) {
                    if (i != 5) {
                        throw new IllegalStateException();
                    }
                    if (!(property instanceof Boolean)) {
                        setInstanceIdValue(maxInstanceId, property);
                    }
                } else if (property instanceof Number) {
                    setInstanceIdValue(maxInstanceId, property);
                }
            }
        }
    }

    private void writeSetting(Scriptable scriptable) {
        for (int i = 1; i <= 5; i++) {
            int maxInstanceId = super.getMaxInstanceId() + i;
            ScriptableObject.putProperty(scriptable, getInstanceIdName(maxInstanceId), getInstanceIdValue(maxInstanceId));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        if (!idFunctionObject.hasTag(XMLCTOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            this.options.setDefault();
        } else if (iMethodId != 2) {
            if (iMethodId != 3) {
                throw new IllegalArgumentException(String.valueOf(iMethodId));
            }
            if (objArr.length == 0 || (obj = objArr[0]) == null || obj == Undefined.instance) {
                this.options.setDefault();
            } else if (obj instanceof Scriptable) {
                readSettings((Scriptable) obj);
            }
            return Undefined.instance;
        }
        Scriptable scriptableNewObject = context.newObject(scriptable);
        writeSetting(scriptableNewObject);
        return scriptableNewObject;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 12) {
            str2 = "prettyIndent";
            i = 4;
        } else if (length == 14) {
            char cCharAt = str.charAt(0);
            if (cCharAt == 'i') {
                str2 = "ignoreComments";
                i = 1;
            } else if (cCharAt == 'p') {
                str2 = "prettyPrinting";
                i = 5;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 16) {
            str2 = "ignoreWhitespace";
            i = 3;
        } else if (length != 28) {
            str2 = null;
            i = 0;
        } else {
            str2 = "ignoreProcessingInstructions";
            i = 2;
        }
        int i2 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            return IdScriptableObject.instanceIdInfo(6, super.getMaxInstanceId() + i2);
        }
        throw new IllegalStateException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 8) {
            str2 = BoxAnalyticsParams.CATEGORY_SETTINGS;
            i = 2;
        } else if (length == 11) {
            str2 = "setSettings";
            i = 3;
        } else if (length == 15) {
            str2 = "defaultSettings";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            return "ignoreComments";
        }
        if (maxInstanceId == 2) {
            return "ignoreProcessingInstructions";
        }
        if (maxInstanceId == 3) {
            return "ignoreWhitespace";
        }
        if (maxInstanceId != 4) {
            return maxInstanceId != 5 ? super.getInstanceIdName(i) : "prettyPrinting";
        }
        return "prettyIndent";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            return ScriptRuntime.wrapBoolean(this.options.isIgnoreComments());
        }
        if (maxInstanceId == 2) {
            return ScriptRuntime.wrapBoolean(this.options.isIgnoreProcessingInstructions());
        }
        if (maxInstanceId == 3) {
            return ScriptRuntime.wrapBoolean(this.options.isIgnoreWhitespace());
        }
        if (maxInstanceId != 4) {
            return maxInstanceId != 5 ? super.getInstanceIdValue(i) : ScriptRuntime.wrapBoolean(this.options.isPrettyPrinting());
        }
        return ScriptRuntime.wrapInt(this.options.getPrettyIndent());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return super.getMaxInstanceId() + 5;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return (scriptable instanceof XML) || (scriptable instanceof XMLList);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        if (i != 1) {
            if (i == 2) {
                str = BoxAnalyticsParams.CATEGORY_SETTINGS;
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException(String.valueOf(i));
                }
                str2 = "setSettings";
            }
            initPrototypeMethod(XMLCTOR_TAG, i, str2, i2);
        }
        str = "defaultSettings";
        String str3 = str;
        i2 = 0;
        str2 = str3;
        initPrototypeMethod(XMLCTOR_TAG, i, str2, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            this.options.setIgnoreComments(ScriptRuntime.toBoolean(obj));
            return;
        }
        if (maxInstanceId == 2) {
            this.options.setIgnoreProcessingInstructions(ScriptRuntime.toBoolean(obj));
            return;
        }
        if (maxInstanceId == 3) {
            this.options.setIgnoreWhitespace(ScriptRuntime.toBoolean(obj));
            return;
        }
        if (maxInstanceId == 4) {
            this.options.setPrettyIndent(ScriptRuntime.toInt32(obj));
        } else if (maxInstanceId != 5) {
            super.setInstanceIdValue(i, obj);
        } else {
            this.options.setPrettyPrinting(ScriptRuntime.toBoolean(obj));
        }
    }
}

package external.sdk.pendo.io.mozilla.javascript.optimizer;

import external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons;
import external.sdk.pendo.io.mozilla.javascript.IRFactory;
import external.sdk.pendo.io.mozilla.javascript.JavaAdapter;
import external.sdk.pendo.io.mozilla.javascript.ObjToIntMap;
import external.sdk.pendo.io.mozilla.javascript.Parser;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: loaded from: classes4.dex */
public class ClassCompiler {
    private CompilerEnvirons compilerEnv;
    private String mainMethodClassName;
    private Class<?> targetExtends;
    private Class<?>[] targetImplements;

    public ClassCompiler(CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons == null) {
            throw new IllegalArgumentException();
        }
        this.compilerEnv = compilerEnvirons;
        this.mainMethodClassName = "external.sdk.pendo.io.mozilla.javascript.optimizer.OptRuntime";
    }

    public Object[] compileToClassFiles(String str, String str2, int i, String str3) {
        ScriptNode scriptNodeTransformTree = new IRFactory(this.compilerEnv).transformTree(new Parser(this.compilerEnv).parse(str, str2, i));
        Class<?> targetExtends = getTargetExtends();
        Class<?>[] targetImplements = getTargetImplements();
        boolean z = targetImplements == null && targetExtends == null;
        String strMakeAuxiliaryClassName = z ? str3 : makeAuxiliaryClassName(str3, "1");
        Codegen codegen = new Codegen();
        codegen.setMainMethodClass(this.mainMethodClassName);
        byte[] bArrCompileToClassFile = codegen.compileToClassFile(this.compilerEnv, strMakeAuxiliaryClassName, scriptNodeTransformTree, scriptNodeTransformTree.getEncodedSource(), false);
        if (z) {
            return new Object[]{strMakeAuxiliaryClassName, bArrCompileToClassFile};
        }
        int functionCount = scriptNodeTransformTree.getFunctionCount();
        ObjToIntMap objToIntMap = new ObjToIntMap(functionCount);
        for (int i2 = 0; i2 != functionCount; i2++) {
            FunctionNode functionNode = scriptNodeTransformTree.getFunctionNode(i2);
            String name = functionNode.getName();
            if (name != null && name.length() != 0) {
                objToIntMap.put(name, functionNode.getParamCount());
            }
        }
        if (targetExtends == null) {
            targetExtends = ScriptRuntime.ObjectClass;
        }
        return new Object[]{str3, JavaAdapter.createAdapterCode(objToIntMap, str3, targetExtends, targetImplements, strMakeAuxiliaryClassName), strMakeAuxiliaryClassName, bArrCompileToClassFile};
    }

    public CompilerEnvirons getCompilerEnv() {
        return this.compilerEnv;
    }

    public String getMainMethodClass() {
        return this.mainMethodClassName;
    }

    public Class<?> getTargetExtends() {
        return this.targetExtends;
    }

    public Class<?>[] getTargetImplements() {
        Class<?>[] clsArr = this.targetImplements;
        if (clsArr == null) {
            return null;
        }
        return (Class[]) clsArr.clone();
    }

    protected String makeAuxiliaryClassName(String str, String str2) {
        return str + str2;
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClassName = str;
    }

    public void setTargetExtends(Class<?> cls) {
        this.targetExtends = cls;
    }

    public void setTargetImplements(Class<?>[] clsArr) {
        this.targetImplements = clsArr == null ? null : (Class[]) clsArr.clone();
    }
}

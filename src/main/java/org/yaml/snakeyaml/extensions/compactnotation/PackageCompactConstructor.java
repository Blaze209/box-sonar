package org.yaml.snakeyaml.extensions.compactnotation;

import org.yaml.snakeyaml.LoaderOptions;

/* JADX INFO: loaded from: classes5.dex */
public class PackageCompactConstructor extends CompactConstructor {
    private final String packageName;

    public PackageCompactConstructor(String str) {
        super(new LoaderOptions());
        this.packageName = str;
    }

    @Override // org.yaml.snakeyaml.constructor.Constructor
    protected Class<?> getClassForName(String str) throws ClassNotFoundException {
        if (str.indexOf(46) < 0) {
            try {
                return Class.forName(this.packageName + "." + str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.getClassForName(str);
    }
}

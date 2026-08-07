package org.yaml.snakeyaml.resolver;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;

/* JADX INFO: loaded from: classes5.dex */
public class Resolver {
    protected Map<Character, List<ResolverTuple>> yamlImplicitResolvers = new HashMap();
    public static final Pattern BOOL = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
    public static final Pattern FLOAT = Pattern.compile("^([-+]?(?:[0-9][0-9_]*)\\.[0-9_]*(?:[eE][-+]?[0-9]+)?|[-+]?(?:[0-9][0-9_]*)(?:[eE][-+]?[0-9]+)|[-+]?\\.[0-9_]+(?:[eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
    public static final Pattern INT = Pattern.compile("^(?:[-+]?0b_*[0-1][0-1_]*|[-+]?0_*[0-7][0-7_]*|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x_*[0-9a-fA-F][0-9a-fA-F_]*|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
    public static final Pattern MERGE = Pattern.compile("^(?:<<)$");
    public static final Pattern NULL = Pattern.compile("^(?:~|null|Null|NULL| )$");
    public static final Pattern EMPTY = Pattern.compile("^$");
    public static final Pattern TIMESTAMP = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern VALUE = Pattern.compile("^(?:=)$");
    public static final Pattern YAML = Pattern.compile("^(?:!|&|\\*)$");

    protected void addImplicitResolvers() {
        addImplicitResolver(Tag.BOOL, BOOL, "yYnNtTfFoO", 10);
        addImplicitResolver(Tag.INT, INT, "-+0123456789");
        addImplicitResolver(Tag.FLOAT, FLOAT, "-+0123456789.");
        addImplicitResolver(Tag.MERGE, MERGE, SimpleComparison.LESS_THAN_OPERATION, 10);
        addImplicitResolver(Tag.NULL, NULL, "~nN\u0000", 10);
        addImplicitResolver(Tag.NULL, EMPTY, null, 10);
        addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, "0123456789", 50);
        addImplicitResolver(Tag.YAML, YAML, "!&*", 10);
    }

    public Resolver() {
        addImplicitResolvers();
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str) {
        addImplicitResolver(tag, pattern, str, 1024);
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str, int i) {
        if (str == null) {
            List<ResolverTuple> arrayList = this.yamlImplicitResolvers.get(null);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.yamlImplicitResolvers.put(null, arrayList);
            }
            arrayList.add(new ResolverTuple(tag, pattern, i));
            return;
        }
        for (char c : str.toCharArray()) {
            Character chValueOf = Character.valueOf(c);
            if (chValueOf.charValue() == 0) {
                chValueOf = null;
            }
            List<ResolverTuple> arrayList2 = this.yamlImplicitResolvers.get(chValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                this.yamlImplicitResolvers.put(chValueOf, arrayList2);
            }
            arrayList2.add(new ResolverTuple(tag, pattern, i));
        }
    }

    public Tag resolve(NodeId nodeId, String str, boolean z) {
        List<ResolverTuple> list;
        if (nodeId == NodeId.scalar && z) {
            if (str.length() == 0) {
                list = this.yamlImplicitResolvers.get((char) 0);
            } else {
                list = this.yamlImplicitResolvers.get(Character.valueOf(str.charAt(0)));
            }
            if (list != null) {
                for (ResolverTuple resolverTuple : list) {
                    Tag tag = resolverTuple.getTag();
                    Pattern regexp = resolverTuple.getRegexp();
                    if (str.length() <= resolverTuple.getLimit() && regexp.matcher(str).matches()) {
                        return tag;
                    }
                }
            }
            if (this.yamlImplicitResolvers.containsKey(null)) {
                for (ResolverTuple resolverTuple2 : this.yamlImplicitResolvers.get(null)) {
                    Tag tag2 = resolverTuple2.getTag();
                    Pattern regexp2 = resolverTuple2.getRegexp();
                    if (str.length() <= resolverTuple2.getLimit() && regexp2.matcher(str).matches()) {
                        return tag2;
                    }
                }
            }
        }
        int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[nodeId.ordinal()];
        if (i == 1) {
            return Tag.STR;
        }
        if (i == 2) {
            return Tag.SEQ;
        }
        return Tag.MAP;
    }

    /* JADX INFO: renamed from: org.yaml.snakeyaml.resolver.Resolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$nodes$NodeId;

        static {
            int[] iArr = new int[NodeId.values().length];
            $SwitchMap$org$yaml$snakeyaml$nodes$NodeId = iArr;
            try {
                iArr[NodeId.scalar.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.sequence.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}

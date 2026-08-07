package kotlin.reflect.jvm.internal.impl.renderer;

import com.microsoft.identity.client.internal.MsalUtils;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RenderingUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RenderingUtilsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleMutabilityOrArrayElementVarianceType$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public static final String render(Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        if (!shouldBeEscaped(name)) {
            String strAsString = name.asString();
            Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return strAsString;
        }
        StringBuilder sb = new StringBuilder();
        String strAsString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString2, "asString(...)");
        return sb.append("`" + strAsString2).append('`').toString();
    }

    private static final boolean shouldBeEscaped(Name name) {
        String strAsString = name.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        if (KeywordStringsGenerated.KEYWORDS.contains(strAsString)) {
            return true;
        }
        String str = strAsString;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                return true;
            }
        }
        return str.length() == 0 || !Character.isJavaIdentifierStart(strAsString.codePointAt(0));
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        return renderFqName(fqNameUnsafe.pathSegments());
    }

    public static final String renderFqName(List<Name> pathSegments) {
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name name : pathSegments) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        return sb.toString();
    }

    public static /* synthetic */ String renderFlexibleMutabilityOrArrayElementVarianceType$default(String str, String str2, Function0 function0, Function0 function1, Function1 function2, int i, Object obj) {
        if ((i & 16) != 0) {
            function2 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj2) {
                    return RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType$lambda$0((String) obj2);
                }
            };
        }
        return renderFlexibleMutabilityOrArrayElementVarianceType(str, str2, function0, function1, function2);
    }

    public static final String renderFlexibleMutabilityOrArrayElementVarianceType(String lowerRendered, String upperRendered, Function0<String> renderKotlinCollectionsPrefix, Function0<String> renderKotlinPrefix, Function1<? super String, String> escape) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(renderKotlinCollectionsPrefix, "renderKotlinCollectionsPrefix");
        Intrinsics.checkNotNullParameter(renderKotlinPrefix, "renderKotlinPrefix");
        Intrinsics.checkNotNullParameter(escape, "escape");
        String strInvoke = renderKotlinCollectionsPrefix.invoke();
        String strReplacePrefixesInTypeRepresentations = replacePrefixesInTypeRepresentations(lowerRendered, strInvoke + "Mutable", upperRendered, strInvoke, strInvoke + "(Mutable)");
        if (strReplacePrefixesInTypeRepresentations != null) {
            return strReplacePrefixesInTypeRepresentations;
        }
        String strReplacePrefixesInTypeRepresentations2 = replacePrefixesInTypeRepresentations(lowerRendered, strInvoke + "MutableMap.MutableEntry", upperRendered, strInvoke + "Map.Entry", strInvoke + "(Mutable)Map.(Mutable)Entry");
        if (strReplacePrefixesInTypeRepresentations2 != null) {
            return strReplacePrefixesInTypeRepresentations2;
        }
        String strInvoke2 = renderKotlinPrefix.invoke();
        String strReplacePrefixesInTypeRepresentations3 = replacePrefixesInTypeRepresentations(lowerRendered, strInvoke2 + escape.invoke("Array<"), upperRendered, strInvoke2 + escape.invoke("Array<out "), strInvoke2 + escape.invoke("Array<(out) "));
        if (strReplacePrefixesInTypeRepresentations3 != null) {
            return strReplacePrefixesInTypeRepresentations3;
        }
        return null;
    }

    public static final String replacePrefixesInTypeRepresentations(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(lowerPrefix, "lowerPrefix");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(upperPrefix, "upperPrefix");
        Intrinsics.checkNotNullParameter(foldedPrefix, "foldedPrefix");
        if (StringsKt.startsWith$default(lowerRendered, lowerPrefix, false, 2, (Object) null) && StringsKt.startsWith$default(upperRendered, upperPrefix, false, 2, (Object) null)) {
            String strSubstring = lowerRendered.substring(lowerPrefix.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strSubstring2 = upperRendered.substring(upperPrefix.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            String str = foldedPrefix + strSubstring;
            if (Intrinsics.areEqual(strSubstring, strSubstring2)) {
                return str;
            }
            if (typeStringsDifferOnlyInNullability(strSubstring, strSubstring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean typeStringsDifferOnlyInNullability(String lower, String upper) {
        Intrinsics.checkNotNullParameter(lower, "lower");
        Intrinsics.checkNotNullParameter(upper, "upper");
        if (Intrinsics.areEqual(lower, StringsKt.replace$default(upper, MsalUtils.QUERY_STRING_SYMBOL, "", false, 4, (Object) null))) {
            return true;
        }
        return (StringsKt.endsWith$default(upper, MsalUtils.QUERY_STRING_SYMBOL, false, 2, (Object) null) && Intrinsics.areEqual(new StringBuilder().append(lower).append('?').toString(), upper)) || Intrinsics.areEqual(new StringBuilder("(").append(lower).append(")?").toString(), upper);
    }
}

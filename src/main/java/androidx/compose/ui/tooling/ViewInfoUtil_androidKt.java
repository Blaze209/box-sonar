package androidx.compose.ui.tooling;

import androidx.compose.ui.unit.IntRect;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ViewInfoUtil.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u001a2\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¨\u0006\n"}, d2 = {"filterTree", "", "Landroidx/compose/ui/tooling/ViewInfo;", ViewProps.FILTER, "Lkotlin/Function1;", "", "toDebugString", "", "indentation", "", "ui-tooling"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewInfoUtil_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterTree$lambda$0(ViewInfo viewInfo) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toDebugString$lambda$0(ViewInfo viewInfo) {
        return true;
    }

    static /* synthetic */ List filterTree$default(List list, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(ViewInfoUtil_androidKt.filterTree$lambda$0((ViewInfo) obj2));
                }
            };
        }
        return filterTree(list, function1);
    }

    private static final List<ViewInfo> filterTree(List<ViewInfo> list, Function1<? super ViewInfo, Boolean> function1) {
        List listListOf;
        ArrayList arrayList = new ArrayList();
        for (ViewInfo viewInfo : list) {
            List<ViewInfo> listFilterTree = filterTree(viewInfo.getChildren(), function1);
            ArrayList arrayList2 = new ArrayList();
            for (ViewInfo viewInfo2 : listFilterTree) {
                CollectionsKt.addAll(arrayList2, viewInfo2.getLocation() == null ? viewInfo2.getChildren() : CollectionsKt.listOf(viewInfo2));
            }
            ArrayList arrayList3 = arrayList2;
            if (function1.invoke(viewInfo).booleanValue()) {
                listListOf = CollectionsKt.listOf(new ViewInfo(viewInfo.getFileName(), viewInfo.getLineNumber(), viewInfo.getBounds(), viewInfo.getLocation(), arrayList3, viewInfo.getLayoutInfo(), viewInfo.getName()));
            } else {
                listListOf = CollectionsKt.listOf(new ViewInfo("<root>", -1, IntRect.INSTANCE.getZero(), null, arrayList3, null, null));
            }
            CollectionsKt.addAll(arrayList, listListOf);
        }
        return arrayList;
    }

    public static /* synthetic */ String toDebugString$default(List list, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(ViewInfoUtil_androidKt.toDebugString$lambda$0((ViewInfo) obj2));
                }
            };
        }
        return toDebugString(list, i, function1);
    }

    public static final String toDebugString(List<ViewInfo> list, int i, Function1<? super ViewInfo, Boolean> function1) {
        String strRepeat = StringsKt.repeat(".", i);
        StringBuilder sb = new StringBuilder();
        for (ViewInfo viewInfo : CollectionsKt.sortedWith(filterTree(list, function1), ComparisonsKt.compareBy(new Function1() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ViewInfoUtil_androidKt.toDebugString$lambda$1((ViewInfo) obj);
            }
        }, new Function1() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ViewInfoUtil_androidKt.toDebugString$lambda$2((ViewInfo) obj);
            }
        }, new Function1() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ViewInfoUtil_androidKt.toDebugString$lambda$3((ViewInfo) obj);
            }
        }))) {
            if (viewInfo.getLocation() != null) {
                StringBuilder sbAppend = sb.append(strRepeat + '|' + viewInfo.getFileName() + AbstractJsonLexerKt.COLON + viewInfo.getLineNumber());
                Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
                Intrinsics.checkNotNullExpressionValue(sbAppend.append('\n'), "append(...)");
            } else {
                StringBuilder sbAppend2 = sb.append(strRepeat + "|<root>");
                Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(...)");
                Intrinsics.checkNotNullExpressionValue(sbAppend2.append('\n'), "append(...)");
            }
            String string = StringsKt.trim((CharSequence) toDebugString(viewInfo.getChildren(), i + 1, function1)).toString();
            if (string.length() > 0) {
                StringBuilder sbAppend3 = sb.append(string);
                Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(...)");
                Intrinsics.checkNotNullExpressionValue(sbAppend3.append('\n'), "append(...)");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable toDebugString$lambda$1(ViewInfo viewInfo) {
        return viewInfo.getFileName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable toDebugString$lambda$2(ViewInfo viewInfo) {
        return Integer.valueOf(viewInfo.getLineNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable toDebugString$lambda$3(ViewInfo viewInfo) {
        return Integer.valueOf(viewInfo.allChildren().size());
    }
}

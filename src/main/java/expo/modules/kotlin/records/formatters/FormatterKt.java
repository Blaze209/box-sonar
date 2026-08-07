package expo.modules.kotlin.records.formatters;

import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Formatter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001f\b\u0001\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"formatter", "Lexpo/modules/kotlin/records/formatters/Formatter;", "RecordType", "Lexpo/modules/kotlin/records/Record;", "body", "Lkotlin/Function1;", "Lexpo/modules/kotlin/records/formatters/Formatter$Builder;", "", "Lkotlin/ExtensionFunctionType;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FormatterKt {
    public static final <RecordType extends Record> Formatter<RecordType> formatter(Function1<? super Formatter.Builder<RecordType>, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Formatter.Builder builder = new Formatter.Builder();
        body.invoke(builder);
        return builder.build$expo_modules_core_release();
    }
}

package sdk.pendo.io.w2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002*>\u0010\f\u001a\u0004\b\u0000\u0010\u0007\"\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\b\u000b2\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\b\u000b*\n\u0010\r\"\u00020\u00052\u00020\u0005¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KClass;", "clazz", "Lsdk/pendo/io/d3/a;", "typeQualifier", "scopeQualifier", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "Lkotlin/ExtensionFunctionType;", "Definition", "IndexKey", "koin-core"}, k = 2, mv = {1, 9, 0})
public final class b {
    public static final String a(KClass<?> clazz, sdk.pendo.io.d3.a aVar, sdk.pendo.io.d3.a scopeQualifier) {
        String value;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        if (aVar == null || (value = aVar.getValue()) == null) {
            value = "";
        }
        return sdk.pendo.io.h3.a.a(clazz) + AbstractJsonLexerKt.COLON + value + AbstractJsonLexerKt.COLON + scopeQualifier;
    }
}

package sdk.pendo.io.w2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxClassification;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bl\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012'\u0010 \u001a#\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u00000\u0019j\b\u0012\u0004\u0012\u00028\u0000`\u001c¢\u0006\u0002\b\u001d\u0012\u0006\u0010&\u001a\u00020!\u0012\u0012\b\u0002\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100'¢\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0017R8\u0010 \u001a#\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u00000\u0019j\b\u0012\u0004\u0012\u00028\u0000`\u001c¢\u0006\u0002\b\u001d8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u000b\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R,\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lsdk/pendo/io/w2/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "toString", "other", "", "equals", "", "hashCode", "Lsdk/pendo/io/d3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/d3/a;", "d", "()Lsdk/pendo/io/d3/a;", "scopeQualifier", "Lkotlin/reflect/KClass;", "b", "Lkotlin/reflect/KClass;", "()Lkotlin/reflect/KClass;", "primaryType", "c", "setQualifier", "(Lsdk/pendo/io/d3/a;)V", "qualifier", "Lkotlin/Function2;", "Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "Lexternal/sdk/pendo/io/org/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", BoxClassification.FIELD_DEFINITION, "Lsdk/pendo/io/w2/d;", "e", "Lsdk/pendo/io/w2/d;", "getKind", "()Lsdk/pendo/io/w2/d;", "kind", "", "f", "Ljava/util/List;", "getSecondaryTypes", "()Ljava/util/List;", "setSecondaryTypes", "(Ljava/util/List;)V", "secondaryTypes", "Lsdk/pendo/io/w2/c;", "g", "Lsdk/pendo/io/w2/c;", "getCallbacks", "()Lsdk/pendo/io/w2/c;", "setCallbacks", "(Lsdk/pendo/io/w2/c;)V", "callbacks", "<init>", "(Lsdk/pendo/io/d3/a;Lkotlin/reflect/KClass;Lsdk/pendo/io/d3/a;Lkotlin/jvm/functions/Function2;Lsdk/pendo/io/w2/d;Ljava/util/List;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final /* data */ class a<T> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.d3.a scopeQualifier;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final KClass<?> primaryType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private sdk.pendo.io.d3.a qualifier;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, T> definition;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final d kind;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private List<? extends KClass<?>> secondaryTypes;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private c<T> callbacks;

    /* JADX INFO: renamed from: sdk.pendo.io.w2.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/reflect/KClass;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 9, 0})
    static final class C0505a extends Lambda implements Function1<KClass<?>, CharSequence> {
        public static final C0505a a = new C0505a();

        C0505a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(KClass<?> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return sdk.pendo.io.h3.a.a(it);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(sdk.pendo.io.d3.a scopeQualifier, KClass<?> primaryType, sdk.pendo.io.d3.a aVar, Function2<? super sdk.pendo.io.f3.a, ? super sdk.pendo.io.c3.a, ? extends T> definition, d kind, List<? extends KClass<?>> secondaryTypes) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(primaryType, "primaryType");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        this.scopeQualifier = scopeQualifier;
        this.primaryType = primaryType;
        this.qualifier = aVar;
        this.definition = definition;
        this.kind = kind;
        this.secondaryTypes = secondaryTypes;
        this.callbacks = new c<>(null, 1, null);
    }

    public final Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, T> a() {
        return this.definition;
    }

    public final KClass<?> b() {
        return this.primaryType;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final sdk.pendo.io.d3.a getQualifier() {
        return this.qualifier;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final sdk.pendo.io.d3.a getScopeQualifier() {
        return this.scopeQualifier;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type external.sdk.pendo.io.org.koin.core.definition.BeanDefinition<*>");
        a aVar = (a) other;
        return Intrinsics.areEqual(this.primaryType, aVar.primaryType) && Intrinsics.areEqual(this.qualifier, aVar.qualifier) && Intrinsics.areEqual(this.scopeQualifier, aVar.scopeQualifier);
    }

    public int hashCode() {
        sdk.pendo.io.d3.a aVar = this.qualifier;
        return ((((aVar != null ? aVar.hashCode() : 0) * 31) + this.primaryType.hashCode()) * 31) + this.scopeQualifier.hashCode();
    }

    public String toString() {
        String str;
        String string = this.kind.toString();
        String str2 = "'" + sdk.pendo.io.h3.a.a(this.primaryType) + '\'';
        if (this.qualifier == null || (str = ",qualifier:" + this.qualifier) == null) {
            str = "";
        }
        return "[" + string + AbstractJsonLexerKt.COLON + str2 + str + (Intrinsics.areEqual(this.scopeQualifier, sdk.pendo.io.e3.c.INSTANCE.a()) ? "" : ",scope:" + this.scopeQualifier) + (this.secondaryTypes.isEmpty() ? "" : ",binds:" + CollectionsKt.joinToString$default(this.secondaryTypes, ",", null, null, 0, null, C0505a.a, 30, null)) + AbstractJsonLexerKt.END_LIST;
    }
}

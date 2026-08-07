package sdk.pendo.io.f3;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import sdk.pendo.io.a3.b;
import sdk.pendo.io.a3.c;
import sdk.pendo.io.x2.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B-\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\n\u0010\u001e\u001a\u00060\u0016j\u0002`\u001b\u0012\b\b\u0002\u0010!\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020#¢\u0006\u0004\bE\u0010FJA\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nH\u0002¢\u0006\u0004\b\f\u0010\rJN\u0010\f\u001a\u0004\b\u00028\u0000\"\u0004\b\u0000\u0010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0010JC\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nH\u0002¢\u0006\u0004\b\f\u0010\u0012J\u001e\u0010\f\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002JE\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u0014\u0010\u0012JC\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u0015\u0010\u0012J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0015\u0010\u0019R\u001b\u0010\u001e\u001a\u00060\u0016j\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\f\u0010\u001dR\u0017\u0010!\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R \u0010*\u001a\u00020#8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00000+j\b\u0012\u0004\u0012\u00020\u0000`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R*\u00107\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b0\u00101\u0012\u0004\b6\u0010)\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00010+j\b\u0012\u0004\u0012\u00020\u0001`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010.R<\u0010B\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0;0:j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0;`<8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b=\u0010>\u0012\u0004\bA\u0010)\u001a\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010 \u0082\u0002\u0004\n\u0002\b9¨\u0006G"}, d2 = {"Lsdk/pendo/io/f3/a;", "", "Lexternal/sdk/pendo/io/org/koin/mp/Lockable;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/d3/a;", "qualifier", "Lkotlin/reflect/KClass;", "clazz", "Lkotlin/Function0;", "Lsdk/pendo/io/c3/a;", "Lexternal/sdk/pendo/io/org/koin/core/parameter/ParametersDefinition;", "parameterDef", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/d3/a;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lsdk/pendo/io/z2/b;", "instanceContext", "(Lsdk/pendo/io/d3/a;Lkotlin/reflect/KClass;Lsdk/pendo/io/z2/b;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "parameters", "(Lkotlin/reflect/KClass;Lsdk/pendo/io/d3/a;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "c", "b", "", "toString", "Lsdk/pendo/io/d3/a;", "()Lsdk/pendo/io/d3/a;", "scopeQualifier", "Lexternal/sdk/pendo/io/org/koin/core/scope/ScopeID;", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "", "Z", "isRoot", "()Z", "Lsdk/pendo/io/u2/a;", "d", "Lsdk/pendo/io/u2/a;", "get_koin", "()Lsdk/pendo/io/u2/a;", "get_koin$annotations", "()V", "_koin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "linkedScopes", "f", "Ljava/lang/Object;", "get_source", "()Ljava/lang/Object;", "set_source", "(Ljava/lang/Object;)V", "get_source$annotations", "_source", "g", "_callbacks", "Ljava/lang/ThreadLocal;", "Lkotlin/collections/ArrayDeque;", "Lexternal/sdk/pendo/io/org/koin/mp/ThreadLocal;", CmcdData.STREAMING_FORMAT_HLS, "Ljava/lang/ThreadLocal;", "get_parameterStackLocal", "()Ljava/lang/ThreadLocal;", "get_parameterStackLocal$annotations", "_parameterStackLocal", "i", "_closed", "<init>", "(Lsdk/pendo/io/d3/a;Ljava/lang/String;ZLsdk/pendo/io/u2/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.d3.a scopeQualifier;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String id;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final boolean isRoot;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.u2.a _koin;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final ArrayList<a> linkedScopes;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Object _source;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final ArrayList<Object> _callbacks;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final ThreadLocal<ArrayDeque<sdk.pendo.io.c3.a>> _parameterStackLocal;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean _closed;

    /* JADX INFO: renamed from: sdk.pendo.io.f3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
    static final class C0384a extends Lambda implements Function0<String> {
        final /* synthetic */ sdk.pendo.io.c3.a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0384a(sdk.pendo.io.c3.a aVar) {
            super(0);
            this.a = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "| >> parameters " + this.a + ' ';
        }
    }

    public a(sdk.pendo.io.d3.a scopeQualifier, String id, boolean z, sdk.pendo.io.u2.a _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.scopeQualifier = scopeQualifier;
        this.id = id;
        this.isRoot = z;
        this._koin = _koin;
        this.linkedScopes = new ArrayList<>();
        this._callbacks = new ArrayList<>();
        this._parameterStackLocal = new ThreadLocal<>();
    }

    private final <T> T a(KClass<?> clazz, sdk.pendo.io.d3.a qualifier, Function0<? extends sdk.pendo.io.c3.a> parameters) {
        Iterator<a> it = this.linkedScopes.iterator();
        T t = null;
        while (it.hasNext() && (t = (T) it.next().c(clazz, qualifier, parameters)) == null) {
        }
        return t;
    }

    public final <T> T b(KClass<?> clazz, sdk.pendo.io.d3.a qualifier, Function0<? extends sdk.pendo.io.c3.a> parameters) {
        String str;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        c logger = this._koin.getLogger();
        b bVar = b.DEBUG;
        if (!logger.a(bVar)) {
            return (T) a(qualifier, clazz, parameters);
        }
        if (qualifier == null || (str = " with qualifier '" + qualifier + '\'') == null) {
            str = "";
        }
        this._koin.getLogger().a(bVar, "|- '" + sdk.pendo.io.h3.a.a(clazz) + '\'' + str + " ...");
        sdk.pendo.io.i3.a aVar = sdk.pendo.io.i3.a.a;
        long jA = aVar.a();
        T t = (T) a(qualifier, clazz, parameters);
        this._koin.getLogger().a(bVar, "|- '" + sdk.pendo.io.h3.a.a(clazz) + "' in " + ((aVar.a() - jA) / 1000000.0d) + " ms");
        return t;
    }

    public final <T> T c(KClass<?> clazz, sdk.pendo.io.d3.a qualifier, Function0<? extends sdk.pendo.io.c3.a> parameters) {
        c logger;
        StringBuilder sbAppend;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) b(clazz, qualifier, parameters);
        } catch (sdk.pendo.io.x2.a unused) {
            logger = this._koin.getLogger();
            sbAppend = new StringBuilder("* Scope closed - no instance found for ").append(sdk.pendo.io.h3.a.a(clazz)).append(" on scope ").append(this);
            logger.a(sbAppend.toString());
            return null;
        } catch (d unused2) {
            logger = this._koin.getLogger();
            sbAppend = new StringBuilder("* No instance found for type '").append(sdk.pendo.io.h3.a.a(clazz)).append("' on scope '").append(this).append('\'');
            logger.a(sbAppend.toString());
            return null;
        }
    }

    public String toString() {
        return "['" + this.id + "']";
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final sdk.pendo.io.d3.a getScopeQualifier() {
        return this.scopeQualifier;
    }

    private final <T> T a(sdk.pendo.io.d3.a qualifier, KClass<?> clazz, Function0<? extends sdk.pendo.io.c3.a> parameterDef) throws sdk.pendo.io.x2.a {
        if (this._closed) {
            throw new sdk.pendo.io.x2.a("Scope '" + this.id + "' is closed");
        }
        ArrayDeque<sdk.pendo.io.c3.a> arrayDeque = null;
        sdk.pendo.io.c3.a aVarInvoke = parameterDef != null ? parameterDef.invoke() : null;
        if (aVarInvoke != null) {
            this._koin.getLogger().a(b.DEBUG, new C0384a(aVarInvoke));
            arrayDeque = this._parameterStackLocal.get();
            if (arrayDeque == null) {
                arrayDeque = new ArrayDeque<>();
                this._parameterStackLocal.set(arrayDeque);
            }
            arrayDeque.addFirst(aVarInvoke);
        }
        T t = (T) a(qualifier, clazz, new sdk.pendo.io.z2.b(this._koin.getLogger(), this, aVarInvoke), parameterDef);
        if (arrayDeque != null) {
            this._koin.getLogger().a("| << parameters");
            arrayDeque.removeFirstOrNull();
        }
        return t;
    }

    private final <T> T a(sdk.pendo.io.d3.a qualifier, KClass<?> clazz, sdk.pendo.io.z2.b instanceContext, Function0<? extends sdk.pendo.io.c3.a> parameterDef) throws d {
        Object obj;
        sdk.pendo.io.c3.a aVarFirstOrNull;
        T t = (T) this._koin.getInstanceRegistry().a(qualifier, clazz, this.scopeQualifier, instanceContext);
        if (t == null) {
            this._koin.getLogger().a("|- ? t:'" + sdk.pendo.io.h3.a.a(clazz) + "' - q:'" + qualifier + "' look in injected parameters");
            ArrayDeque<sdk.pendo.io.c3.a> arrayDeque = this._parameterStackLocal.get();
            T t2 = null;
            t = (arrayDeque == null || (aVarFirstOrNull = arrayDeque.firstOrNull()) == null) ? null : (T) aVarFirstOrNull.c(clazz);
            if (t == null) {
                if (!this.isRoot) {
                    this._koin.getLogger().a("|- ? t:'" + sdk.pendo.io.h3.a.a(clazz) + "' - q:'" + qualifier + "' look at scope source");
                    Object obj2 = this._source;
                    if (obj2 != null && clazz.isInstance(obj2) && qualifier == null && (obj = this._source) != null) {
                        t2 = (T) obj;
                    }
                }
                if (t2 != null) {
                    return t2;
                }
                this._koin.getLogger().a("|- ? t:'" + sdk.pendo.io.h3.a.a(clazz) + "' - q:'" + qualifier + "' look in other scopes");
                T t3 = (T) a(clazz, qualifier, parameterDef);
                if (t3 != null) {
                    return t3;
                }
                if (parameterDef != null) {
                    this._parameterStackLocal.remove();
                    this._koin.getLogger().a("|- << parameters");
                }
                a(qualifier, clazz);
                throw new KotlinNothingValueException();
            }
        }
        return t;
    }

    private final Void a(sdk.pendo.io.d3.a qualifier, KClass<?> clazz) throws d {
        String str;
        if (qualifier == null || (str = " and qualifier '" + qualifier + '\'') == null) {
            str = "";
        }
        throw new d("No definition found for type '" + sdk.pendo.io.h3.a.a(clazz) + '\'' + str + ". Check your Modules configuration and add missing type and/or qualifier!");
    }
}

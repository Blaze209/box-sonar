package sdk.pendo.io.s7;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.JWTSessionData;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0007R\u001b\u0010\u000b\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\b\u0010\u000f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/s7/v;", "Lsdk/pendo/io/w5/a;", "", "jwtToken", "signingKeyName", "", "expectedType", "Lsdk/pendo/io/models/JWTSessionData;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Landroid/content/Context;", "context", "decodedBodyString", "b", "Lkotlin/Lazy;", "()Landroid/content/Context;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class v implements sdk.pendo.io.w5.a {
    public static final v a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final Lazy context;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class a extends Lambda implements Function0<Context> {
        final /* synthetic */ sdk.pendo.io.v2.a a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sdk.pendo.io.v2.a aVar, sdk.pendo.io.d3.a aVar2, Function0 function0) {
            super(0);
            this.a = aVar;
            this.b = aVar2;
            this.c = function0;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [android.content.Context, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            sdk.pendo.io.v2.a aVar = this.a;
            return (aVar instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(Context.class), this.b, this.c);
        }
    }

    static {
        v vVar = new v();
        a = vVar;
        context = LazyKt.lazy(sdk.pendo.io.i3.b.a.a(), (Function0) new a(vVar, null, null));
    }

    private v() {
    }

    public final byte[] a(String jwtToken) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(jwtToken, "jwtToken");
        List<String> listSplit = new Regex("\\.").split(jwtToken, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
            break;
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length != 3) {
            return null;
        }
        return sdk.pendo.io.k0.a.a(strArr[1]);
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.w5.a.C0510a.a(this);
    }

    public final String a(Context context2, int expectedType, String decodedBodyString) {
        String string;
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(decodedBodyString, "decodedBodyString");
        String string2 = context2.getString(R.string.pnd_error_jwt_body_format, decodedBodyString);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (expectedType == 1) {
            string = context2.getString(R.string.pnd_expected_jwt_visitor_format);
            sb = new StringBuilder();
        } else if (expectedType == 2) {
            string = context2.getString(R.string.pnd_expected_jwt_account_format);
            sb = new StringBuilder();
        } else {
            if (expectedType != 3) {
                return "Invalid expected type";
            }
            string2 = string2 + context2.getString(R.string.pnd_expected_jwt_account_format);
            string = context2.getString(R.string.pnd_expected_jwt_visitor_format);
            sb = new StringBuilder();
        }
        return sb.append(string2).append(string).toString();
    }

    public final synchronized JWTSessionData a(String jwtToken, String signingKeyName, int expectedType) {
        int i;
        Intrinsics.checkNotNullParameter(jwtToken, "jwtToken");
        Intrinsics.checkNotNullParameter(signingKeyName, "signingKeyName");
        byte[] bArrA = a(jwtToken);
        if (bArrA == null) {
            return null;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bArrA, UTF_8);
        PendoLogger.d("Decoded: ".concat(str), new Object[0]);
        try {
            JWTSessionData jWTSessionData = (JWTSessionData) new external.sdk.pendo.io.gson.a().c().a().a(str, JWTSessionData.class);
            Map<String, Object> accountData = jWTSessionData.getAccountData();
            if (accountData != null) {
                Object objRemove = accountData.remove("id");
                Intrinsics.checkNotNull(objRemove, "null cannot be cast to non-null type kotlin.String");
                jWTSessionData.setAccountId((String) objRemove);
                i = 2;
            } else {
                i = 0;
            }
            Map<String, Object> visitorData = jWTSessionData.getVisitorData();
            if (visitorData != null) {
                Object objRemove2 = visitorData.remove("id");
                Intrinsics.checkNotNull(objRemove2, "null cannot be cast to non-null type kotlin.String");
                jWTSessionData.setVisitorId((String) objRemove2);
                i++;
            }
            if (i != expectedType) {
                v vVar = a;
                throw new sdk.pendo.io.y5.h(vVar.a(vVar.a(), expectedType, str));
            }
            jWTSessionData.setJwt(jwtToken);
            jWTSessionData.setSigningKeyName(signingKeyName);
            return jWTSessionData;
        } catch (Exception e) {
            PendoLogger.e(e, "JWT extract error {" + e + ".message}", new Object[0]);
            return null;
        }
    }

    public final Context a() {
        return (Context) context.getValue();
    }
}

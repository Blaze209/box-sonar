package sdk.pendo.io.j7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lsdk/pendo/io/j7/c;", "Lsdk/pendo/io/j7/v;", "child", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/j7/v;)V", "", "f", "()Ljava/util/List;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "()Ljava/lang/StringBuilder;", "Lorg/json/JSONArray;", "c", "()Lorg/json/JSONArray;", "Lsdk/pendo/io/j7/e;", "G", "Lsdk/pendo/io/j7/e;", ViewProps.DISPLAY, "Lsdk/pendo/io/j7/p;", "H", "Lsdk/pendo/io/j7/p;", ViewProps.OVERFLOW, "", "I", "Ljava/util/List;", "srChildNodes", "", "id", ViewProps.Z_INDEX, "", "elementName", "<init>", "(IILjava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public class c extends v {

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private e display;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private p overflow;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private List<v> srChildNodes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, int i2, String elementName) {
        super(i, i2, elementName, "div");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        this.display = new e(e.a.FLEX);
        this.overflow = new p(p.a.HIDDEN);
    }

    public final void a(v child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.srChildNodes == null) {
            this.srChildNodes = new ArrayList();
        }
        List<v> list = this.srChildNodes;
        if (list != null) {
            list.add(child);
        }
    }

    @Override // sdk.pendo.io.j7.v
    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        List<v> list = this.srChildNodes;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((v) it.next()).a());
            }
        }
        return jSONArray;
    }

    @Override // sdk.pendo.io.j7.v
    public StringBuilder d() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) super.d());
        e eVar = this.display;
        if (eVar != null) {
            sb.append(eVar.c());
        }
        p pVar = this.overflow;
        if (pVar != null) {
            sb.append(pVar.c());
        }
        return sb;
    }

    public final List<v> f() {
        List<v> list = this.srChildNodes;
        return list == null ? CollectionsKt.emptyList() : list;
    }
}

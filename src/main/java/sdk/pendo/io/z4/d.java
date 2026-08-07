package sdk.pendo.io.z4;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    class a implements b {
        final /* synthetic */ sdk.pendo.io.a5.a a;
        final /* synthetic */ String b;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a c;

        a(sdk.pendo.io.a5.a aVar, String str, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a) {
            this.a = aVar;
            this.b = str;
            this.c = interfaceC0343a;
        }

        @Override // sdk.pendo.io.z4.d.b
        public void destroy() {
            this.a.a(this.b, this.c);
        }
    }

    public interface b {
        void destroy();
    }

    public static b a(sdk.pendo.io.a5.a aVar, String str, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a) {
        aVar.b(str, interfaceC0343a);
        return new a(aVar, str, interfaceC0343a);
    }
}

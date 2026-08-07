package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class k60 extends b30<rg> {
    public final /* synthetic */ com.pspdfkit.internal.views.document.editor.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ l60 c;

    public k60(l60 l60Var, com.pspdfkit.internal.views.document.editor.a aVar, int i) {
        this.c = l60Var;
        this.a = aVar;
        this.b = i;
    }

    @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        rg rgVar = (rg) obj;
        if (((Integer) ((n60) this.a.itemView).getTag()).intValue() == this.b) {
            ((n60) this.a.itemView).setThumbnailDrawable(rgVar);
        }
        this.c.a();
    }
}

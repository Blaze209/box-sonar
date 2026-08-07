package com.pspdfkit.undo.edit.contentediting;

import com.pspdfkit.internal.dc;
import com.pspdfkit.internal.ng;
import com.pspdfkit.internal.t00;
import com.pspdfkit.internal.x60;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0016\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00192\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010!¨\u0006\""}, d2 = {"Lcom/pspdfkit/undo/edit/contentediting/ContentEditingNativeChangeEdit;", "Lcom/pspdfkit/undo/edit/contentediting/ContentEditingEdit;", "", "pageIndex", "", "textBlockId", "Lcom/pspdfkit/internal/x60;", "undoData", "redoData", "Lcom/pspdfkit/internal/ng;", "externalControlState", "", "deleted", "<init>", "(ILjava/lang/String;Lcom/pspdfkit/internal/x60;Lcom/pspdfkit/internal/x60;Lcom/pspdfkit/internal/ng;Ljava/lang/Boolean;)V", "forUndo", "dataFor", "(Z)Lcom/pspdfkit/internal/x60;", "Lkotlin/UInt;", "Lcom/pspdfkit/internal/contentediting/models/HistoryIndex;", "version-OGnWXxg", "(Z)I", "version", "selStart", "(Z)Ljava/lang/Integer;", "Lcom/pspdfkit/internal/contentediting/models/Cluster;", "selEnd", "isDeleted", "(Z)Ljava/lang/Boolean;", "Lcom/pspdfkit/internal/x60;", "Lcom/pspdfkit/internal/ng;", "getExternalControlState", "()Lcom/pspdfkit/internal/ng;", "Ljava/lang/Boolean;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentEditingNativeChangeEdit extends ContentEditingEdit {
    public static final int $stable = 0;
    private final Boolean deleted;
    private final ng externalControlState;
    private final x60 redoData;
    private final x60 undoData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentEditingNativeChangeEdit(int i, String str, x60 x60Var, x60 x60Var2, ng ngVar, Boolean bool) {
        super(i, str);
        str.getClass();
        x60Var.getClass();
        x60Var2.getClass();
        ngVar.getClass();
        this.undoData = x60Var;
        this.redoData = x60Var2;
        this.externalControlState = ngVar;
        this.deleted = bool;
    }

    private final x60 dataFor(boolean forUndo) {
        return forUndo ? this.undoData : this.redoData;
    }

    public final ng getExternalControlState() {
        return this.externalControlState;
    }

    public final Boolean isDeleted(boolean forUndo) {
        Boolean bool = this.deleted;
        if (bool == null) {
            return null;
        }
        boolean zBooleanValue = bool.booleanValue();
        if (forUndo) {
            zBooleanValue = !zBooleanValue;
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public final Integer selEnd(boolean forUndo) {
        t00 t00Var = dataFor(forUndo).b;
        if (t00Var != null) {
            return Integer.valueOf(t00Var.b);
        }
        return null;
    }

    public final Integer selStart(boolean forUndo) {
        x60 x60VarDataFor = dataFor(forUndo);
        t00 t00Var = x60VarDataFor.b;
        if (t00Var != null) {
            return Integer.valueOf(t00Var.a);
        }
        dc dcVar = x60VarDataFor.c;
        if (dcVar != null) {
            return Integer.valueOf(dcVar.a);
        }
        return null;
    }

    /* JADX INFO: renamed from: version-OGnWXxg, reason: not valid java name */
    public final int m14307versionOGnWXxg(boolean forUndo) {
        return dataFor(forUndo).a;
    }

    public /* synthetic */ ContentEditingNativeChangeEdit(int i, String str, x60 x60Var, x60 x60Var2, ng ngVar, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, x60Var, x60Var2, ngVar, (i2 & 32) != 0 ? null : bool);
    }
}

package com.pspdfkit.internal;

import io.nutrient.data.models.CompletionResponse;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final ImmutableList<CompletionResponse> e;
    public final a f;

    public static final class a {
        public final String a;

        public a(String str) {
            this.a = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ContextualParameters(contextText=" + this.a + ")";
        }
    }

    public b0() {
        this(0);
    }

    public static b0 a(b0 b0Var, boolean z, boolean z2, boolean z3, boolean z4, ImmutableList immutableList, a aVar, int i) {
        if ((i & 1) != 0) {
            z = b0Var.a;
        }
        boolean z5 = z;
        if ((i & 2) != 0) {
            z2 = b0Var.b;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = b0Var.c;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = b0Var.d;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            immutableList = b0Var.e;
        }
        ImmutableList immutableList2 = immutableList;
        if ((i & 32) != 0) {
            aVar = b0Var.f;
        }
        b0Var.getClass();
        immutableList2.getClass();
        return new b0(z5, z6, z7, z8, immutableList2, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a == b0Var.a && this.b == b0Var.b && this.c == b0Var.c && this.d == b0Var.d && Intrinsics.areEqual(this.e, b0Var.e) && Intrinsics.areEqual(this.f, b0Var.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + mv.a(this.d, mv.a(this.c, mv.a(this.b, Boolean.hashCode(this.a) * 31, 31), 31), 31)) * 31;
        a aVar = this.f;
        return iHashCode + (aVar == null ? 0 : aVar.a.hashCode());
    }

    public final String toString() {
        return "AiAssistantUiState(isLoading=" + this.a + ", isConnectionAvailable=" + this.b + ", isAiAssistantTyping=" + this.c + ", isSubmitButtonEnabled=" + this.d + ", chat=" + this.e + ", contextualParameters=" + this.f + ")";
    }

    public b0(boolean z, boolean z2, boolean z3, boolean z4, ImmutableList<CompletionResponse> immutableList, a aVar) {
        immutableList.getClass();
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = immutableList;
        this.f = aVar;
    }

    public final PersistentList<CompletionResponse> a(CompletionResponse completionResponse) {
        completionResponse.getClass();
        ImmutableList<CompletionResponse> immutableList = this.e;
        CompletionResponse completionResponse2 = immutableList.get(immutableList.size() - 1);
        List mutableList = CollectionsKt.toMutableList((Collection) this.e);
        mutableList.set(this.e.size() - 1, CompletionResponse.copy$default(completionResponse2, null, null, null, 0L, 0, completionResponse2.getContent() + completionResponse.getContent(), false, null, null, null, null, 2015, null));
        return ExtensionsKt.toPersistentList(mutableList);
    }

    public /* synthetic */ b0(int i) {
        this(false, true, false, true, ExtensionsKt.persistentListOf(), null);
    }
}

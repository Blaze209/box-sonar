package com.pspdfkit.internal;

import com.pspdfkit.annotations.note.AnnotationStateChange;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface gs {
    Object a(cs csVar, AnnotationStateChange annotationStateChange, Continuation<? super Unit> continuation);

    Object a(ds dsVar, Continuation<? super Unit> continuation);

    Object a(Continuation<? super ds> continuation);

    String a();

    void a(int i);

    void a(cs csVar, int i);

    void a(cs csVar, String str);

    void a(ds dsVar, String str);

    void a(hs hsVar);

    void a(String str);

    void a(List<? extends ds> list);

    boolean a(ds dsVar);

    Object b(ds dsVar, Continuation<? super Boolean> continuation);

    Object b(Continuation<? super List<? extends ds>> continuation);

    boolean b();

    boolean b(ds dsVar);

    void c(ds dsVar);

    boolean c();

    List<String> d();

    ds e();

    boolean f();

    String g();

    String getTitle();

    boolean h();

    boolean i();

    void j();

    boolean k();

    boolean l();

    int m();

    List<Integer> n();

    void o();

    boolean p();
}

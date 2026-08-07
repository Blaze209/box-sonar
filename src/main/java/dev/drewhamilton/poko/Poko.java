package dev.drewhamilton.poko;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: compiled from: Poko.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0002\u0002\u0003B\u0000¨\u0006\u0004"}, d2 = {"Ldev/drewhamilton/poko/Poko;", "", "Skip", "ReadArrayContent", "poko-annotations"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface Poko {

    /* JADX INFO: compiled from: Poko.kt */
    @Target({})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ldev/drewhamilton/poko/Poko$ReadArrayContent;", "", "poko-annotations"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ReadArrayContent {
    }

    /* JADX INFO: compiled from: Poko.kt */
    @Target({})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ldev/drewhamilton/poko/Poko$Skip;", "", "poko-annotations"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SkipSupport
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Skip {
    }
}

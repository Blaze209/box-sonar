package com.apollographql.apollo3.cache.normalized.internal;

import androidx.exifinterface.media.ExifInterface;
import com.box.androidsdk.content.models.BoxFile;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Lock.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/internal/Lock;", "", "()V", BoxFile.FIELD_LOCK, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "read", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Lock {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public final <T> T read(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            return block.invoke();
        } finally {
            lock.unlock();
        }
    }

    public final <T> T write(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            T tInvoke = block.invoke();
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            return tInvoke;
        } finally {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }
}

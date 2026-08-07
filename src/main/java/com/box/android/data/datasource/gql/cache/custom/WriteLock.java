package com.box.android.data.datasource.gql.cache.custom;

import androidx.exifinterface.media.ExifInterface;
import com.box.androidsdk.content.models.BoxFile;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WriteLock.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/custom/WriteLock;", "", "<init>", "()V", BoxFile.FIELD_LOCK, "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "read", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WriteLock {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public final <T> T read(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke();
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

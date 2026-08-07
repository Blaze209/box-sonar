package com.microsoft.identity.common.java.controllers;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public class CommandResultCacheItem {
    private static final int VALIDITY_DURATION = 30;
    private Date mExpiresOn = getExpiresOn();
    private CommandResult mValue;

    public CommandResultCacheItem(CommandResult commandResult) {
        this.mValue = commandResult;
    }

    private Date getExpiresOn() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, 30);
        return calendar.getTime();
    }

    public boolean isExpired() {
        return Calendar.getInstance().getTime().after(this.mExpiresOn);
    }

    public CommandResult getValue() {
        return this.mValue;
    }
}

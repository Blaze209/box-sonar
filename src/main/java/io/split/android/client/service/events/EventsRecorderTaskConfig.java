package io.split.android.client.service.events;

/* JADX INFO: loaded from: classes4.dex */
public class EventsRecorderTaskConfig {
    private final int eventsPerPush;

    public EventsRecorderTaskConfig(int eventsPerPush) {
        this.eventsPerPush = eventsPerPush;
    }

    public int getEventsPerPush() {
        return this.eventsPerPush;
    }
}

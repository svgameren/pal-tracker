package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> repo = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {
        long id = repo.size() + 1;
        timeEntry.setId(id);
        repo.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return repo.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        final TimeEntry target = repo.get(id);

        target.setProjectId(timeEntry.getProjectId());
        target.setUserId(timeEntry.getUserId());
        target.setDate(timeEntry.getDate());
        target.setHours(timeEntry.getHours());

        return target;
    }

    @Override
    public void delete(Long id) {
        repo.remove(id);
    }

}

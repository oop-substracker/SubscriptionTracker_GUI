package model.DefaultEntries;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

public class EntryList {

    private List<Entry> entryList;

    public EntryList() {
        entryList = new ArrayList<>();
        initEntryList();
    }

    public void initEntryList() {
        Entry e1 = new Entry("Spotify", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/assets/spotify.png"))));
        Entry e2 = new Entry("Netflix", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/assets/spotify.png"))));
        Entry e3 = new Entry("Youtube", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/assets/spotify.png"))));
        Entry e4 = new Entry("Dribble", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/assets/spotify.png"))));
        Entry e5 = new Entry("ChatGpt", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/assets/spotify.png"))));
        Entry e6 = new Entry("Instagram", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/assets/spotify.png"))));

        entryList.addAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
}

package com.example.teamproject;

import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JournalTest {

    /*@Test
    public void verify_item_is_added_to_list_when_populated() {
        try {
            Journal journal = new Journal();
            Field field = journal.getClass().getDeclaredField("entries");
            field.setAccessible(true);

            Map<String, Entry> items = (Map<String, Entry>) field.get(journal);
            int length = items.size();

            journal.addEntry(LocalDate.parse("2020-01-13"), "This is an entry");
            items = (Map<String, Entry>) field.get(journal);

            assertTrue(length < items.size());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }*/

    /*@Test
    public void verify_item_rejected_on_non_populated() {
        try {
            Journal journal = new Journal();
            Field field = journal.getClass().getDeclaredField("entries");
            field.setAccessible(true);

            Map<String, Entry> items = (Map<String, Entry>) field.get(journal);
            int length = items.size();

            journal.addEntry(LocalDate.parse("06/23/2020"), "");
            fail("verify_item_rejected_on_non_populated should have failed");
        } catch (Exception e) {
            assertTrue(true);
        }
    }*/

    @Test
    public void verify_display_with_valid_date() {
        try {
            Journal journal = new Journal();
            Field field = journal.getClass().getDeclaredField("entries");
            field.setAccessible(true);

            Map<String, Entry> items = (Map<String, Entry>) field.get(journal);
            Entry entry = new Entry();
            entry.setContent("This is an entry");

            items.put("01/22/2020", entry);

            journal.displaySelection("01/22/2020");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void verify_display_without_valid_date() {
        try {
            Journal journal = new Journal();

            journal.displaySelection("01/23/2020");
            fail("verify_display_without_valid_date should have failed");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void verify_item_is_deleted_when_found() {
        try {
            Journal journal = new Journal();

            Field field = journal.getClass().getDeclaredField("entries");
            field.setAccessible(true);

            Map<String, Entry> items = (Map<String, Entry>) field.get(journal);
            Entry entry = new Entry();
            entry.setContent("This is an entry");

            items.put("01/22/2020", entry);
            assertTrue(items.containsKey("01/22/2020"));

            journal.removeEntry("01/22/2020");

            assertFalse(items.containsKey("01/22/2020"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void verify_non_existent_item_fails() {
        try {
            Journal journal = new Journal();
            journal.removeEntry("01/22/2020");

            fail("verify_non_existent_item_fails should have failed");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}

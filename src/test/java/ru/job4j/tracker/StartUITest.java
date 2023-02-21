package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

 class StartUITest {
    @Test
     void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, List.of(actions));
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
     void whenEdit() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "item name", "1", "1", "Edited", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new EditAction(output), new ExitAction()
        };
        new StartUI(output).init(in, tracker, List.of(actions));
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Edited");
    }

    @Test
     void whenDelete() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, List.of(actions));
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
     void whenEditOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(output.toString()).hasToString(
                "Menu:" + ln
                        + "0. === Edit ===" + ln
                        + "1. === Exit program ===" + ln
                        + "=== Edit application ===" + ln
                        + "Application changed successfully." + ln
                        + "Menu:" + ln
                        + "0. === Edit ===" + ln
                        + "1. === Exit program ===" + ln
        );
    }

    @Test
     void whenFindAllOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(output.toString()).hasToString(
                "Menu:" + ln
                        + "0. === Show all ===" + ln
                        + "1. === Exit program ===" + ln
                        + "=== Show all applications ===" + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. === Show all ===" + ln
                        + "1. === Exit program ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"6", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).hasToString(
                "Menu:" + ln
                        + "0. === Exit program ===" + ln
                        + "Wrong input, you can select: 0-0" + ln
                        + "Menu:" + ln
                        + "0. === Exit program ===" + ln
        );
    }
}
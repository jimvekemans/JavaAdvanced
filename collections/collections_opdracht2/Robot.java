package collections_opdracht2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Robot {
    private String name;
    private Queue<Command> commands;

    {
        commands = new PriorityQueue<>();
    }

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCommand(Action action, String value) {
        Command command = new Command(action, value);
        commands.add(command);
    }

    public int getCommandCount() {
        return commands.size();
    }

    public void executeNext() {
        System.out.println(
                (commands.isEmpty()) ?
                        "IDLE" :
                        commands.poll().display()
        );
    }


    public class Command {
        private Action action;
        private String value;

        private int priority;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Command(Action action) {
            this(action, null);
        }

        public Command(Action action, String value) {
            this.action = action;
            this.value = value;
        }

        public Action getAction() {
            return action;
        }

        public String getValue() {
            return value;
        }

        public String display() {
            if (value == null) {
                return action.toString();
            }
            return action.toString() + "<" + value + ">";
        }
    }
}
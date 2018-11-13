package opdracht2;

public class Robot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCommand(Action action, String value) {
        Command command = new Command(action, value);
    }

    public int getCommandCount() {
        // TODO implement method
        return 0;
    }

    public void executeNext() {
        // TODO implement method
    }


    private class Command {
        private Action action;
        private String value;

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
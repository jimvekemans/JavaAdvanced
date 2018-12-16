package opdracht3;

import opdracht2.Robot;

import java.util.PriorityQueue;

public class PrioBot extends Robot {
    private PriorityQueue<Command> commandPriorityQueue;

    {
        commandPriorityQueue = new PriorityQueue<>(
                100,
                (firstcommand, secondcommand) ->
                        (firstcommand.getPriority() > secondcommand.getPriority()) ? -1 : 1
        );
    }

    public PrioBot(String name) {
        super(name);
    }

    public void addCommand(Command command, int priority) {
        command.setPriority(priority);
        commandPriorityQueue.add(command);
    }

    @Override
    public void executeNext() {
        commandPriorityQueue.poll().display();
    }

}

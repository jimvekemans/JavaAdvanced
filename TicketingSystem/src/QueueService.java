import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueService {
    HashMap<String, Queue<User>> userQueueMap;

    void addToQueue(String eventId, User user) {
        if (userQueueMap == null) {
            userQueueMap = new HashMap<>();
        }

        if (!userQueueMap.containsKey(eventId))
            userQueueMap.put(eventId, new PriorityQueue<>());

        userQueueMap.get(eventId).add(user);
    }

    Queue<User> getQueue(String eventId) {
        return userQueueMap.get(eventId);
    }

    User getNextInLine(String eventId) {
        return userQueueMap.get(eventId).poll();
    }

    void removeFromQueue(String eventId) {
        userQueueMap.get(eventId).remove();
    }

    int printQueue(String eventId) {
        userQueueMap.get(eventId).forEach(System.out::println);
        return userQueueMap.get(eventId).size();
    }
}

package oefening2;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameCollection {
    private ArrayList<VideoGame> videoGameArrayList = new ArrayList<>();

    ArrayList<VideoGame> selectGames(Predicate<VideoGame> filter) {
        return videoGameArrayList.stream()
                .filter(filter)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    void addGame(VideoGame game) {
        videoGameArrayList.add(game);
    }
}

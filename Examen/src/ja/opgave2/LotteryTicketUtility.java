package ja.opgave2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class LotteryTicketUtility {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LotteryTicket mapToLotteryTicket(String[] data) {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setDateTime(LocalDateTime.parse(data[0], DATE_TIME_FORMATTER));
        ticket.setSellingPoint(data[1]);
        List<Integer> ticketNumbers = Arrays.asList(data[2].split("-")).stream().map(number -> Integer.parseInt(number)).collect(Collectors.toList());
        ticket.setChosenNumbers(ticketNumbers);
        ticket.setTicketNumber(Integer.parseInt(data[3]));
        ticket.setQuickpick(data[data.length - 1].equalsIgnoreCase("Q"));//als laatste deel van data 'Q' is, dan is het quickpick
        return ticket;
    }

    public static double getPercentageQuickPick(List<LotteryTicket> lotteryTickets) {
        return 100 * lotteryTickets.stream()
                .filter(ticket -> ticket.isQuickpick())
                .count() / lotteryTickets.size();
    }

    public static int findLargestTicketNumber(List<LotteryTicket> lotteryTickets) {
        return lotteryTickets.stream()
                .mapToInt(ticket -> ticket.getTicketNumber())
                .max().getAsInt();
    }

    public static LotteryTicket findWinningLotteryTicket(List<LotteryTicket> lotteryTickets, List<Integer> winningNumbers) {
        return lotteryTickets.stream()
                .filter(ticket -> ticket.getChosenNumbers().containsAll(winningNumbers))
                .findAny().get();
    }

    public static long countNumberOfLotteryTicketsWithAmountOfNumbersValid(List<LotteryTicket> lotteryTickets, List<Integer> winningNumbers, int amount) {
        //een set kan geen dubbels bevatten, dit kunnen we gebruiken om te kijken welke nummers zowel in de gekozen als de winnende nummers voorkomen.
        //dit betkent dat als (chosenNumbers.size() + winningNumbers.size()) - Set<Integer> allNumbers groter is dan het gekozen amount, het ticket minstens het meegegeven aantal nummers correct heeft
        return lotteryTickets.stream()
                .filter(ticket -> {
                    Set<Integer> allNumbers = new TreeSet<>(winningNumbers);
                    List<Integer> chosenNumbers = ticket.getChosenNumbers();
                    allNumbers.addAll(ticket.getChosenNumbers());
                    return chosenNumbers.size() + winningNumbers.size() - allNumbers.size() == amount;
                })
                .count();
    }

    public static void printFiveBestSellingPoints(List<LotteryTicket> lotteryTickets) {
        HashMap<String, Integer> sellingPointsMap = new HashMap<>();
        //eerst alle waardes plaatsen in de hashmap
        lotteryTickets.stream()
                .map(ticket -> ticket.getSellingPoint())
                .forEach(sellingPointString ->
                        sellingPointsMap.put(sellingPointString, 0)
                );
        //daarna tellen hoevaak elke plaats een ticketje verkocht heeft
        lotteryTickets.stream()
                .map(ticket -> ticket.getSellingPoint())
                .forEach(sellingPointString ->
                        sellingPointsMap.put(sellingPointString, sellingPointsMap.get(sellingPointString) + 1)
                );
        sellingPointsMap.keySet().stream()
                .sorted((sellingPointString1, sellingPointString2) -> sellingPointsMap.get(sellingPointString2).compareTo(sellingPointsMap.get(sellingPointString1)))
                .limit(5)
                .forEach(sellingPointString -> System.out.println(sellingPointString + " : " + sellingPointsMap.get(sellingPointString)));
    }
}

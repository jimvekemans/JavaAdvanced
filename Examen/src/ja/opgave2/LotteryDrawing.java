package ja.opgave2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryDrawing {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {
        LocalDateTime tijdstipTrekking = LocalDateTime.now();
        List<Integer> winningNumbers = new ArrayList<>();
        List<LotteryTicket> lotteryTickets = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("resources/verkoop_trekking_20190115.txt"))) {
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();
            tijdstipTrekking = LocalDateTime.parse(firstLine, DATE_TIME_FORMATTER);
            winningNumbers = Arrays.asList(
                    secondLine.split("-"))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            lotteryTickets = reader.lines()
                    .map(ticketString -> ticketString.split(";"))
                    .map(LotteryTicketUtility::mapToLotteryTicket)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Datum trekking: " + tijdstipTrekking.format(DATE_TIME_FORMATTER));
        System.out.println("Winnende nummers: " + winningNumbers);
        System.out.println("Aantal verkochte loten: " + lotteryTickets.size());
        System.out.println("Percentage quickpick: " + LotteryTicketUtility.getPercentageQuickPick(lotteryTickets));
        System.out.println("Winnend lot: " + LotteryTicketUtility.findWinningLotteryTicket(lotteryTickets, winningNumbers));
        System.out.println("Hoogste ticket number: " + LotteryTicketUtility.findLargestTicketNumber(lotteryTickets));
        System.out.println("5 juist: " + LotteryTicketUtility.countNumberOfLotteryTicketsWithAmountOfNumbersValid(lotteryTickets, winningNumbers, 5));
        System.out.println("4 juist: " + LotteryTicketUtility.countNumberOfLotteryTicketsWithAmountOfNumbersValid(lotteryTickets, winningNumbers, 4));
        System.out.println("3 juist: " + LotteryTicketUtility.countNumberOfLotteryTicketsWithAmountOfNumbersValid(lotteryTickets, winningNumbers, 3));
        System.out.println("Top verkooppunten: ");
        LotteryTicketUtility.printFiveBestSellingPoints(lotteryTickets);
    }
}

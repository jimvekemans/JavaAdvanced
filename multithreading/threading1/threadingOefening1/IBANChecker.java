package threading1.threadingOefening1;

import java.util.ArrayList;
import java.util.List;

public class IBANChecker implements Runnable {
    private String IBANCode;

    public IBANChecker(String IBANCode) {
        this.IBANCode = IBANCode;
    }

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        threadList.add(new Thread(new IBANChecker("BE68 5390 0754 7034")));
        threadList.add(new Thread(new IBANChecker("BE80 7350 0861 3277")));
        threadList.add(new Thread(new IBANChecker("BE71 0961 2345 6769")));
        threadList.add(new Thread(new IBANChecker("BE12 1231 2345 6712")));

        threadList.forEach(Thread::start);
    }

    private boolean IBANValid(String IBANCode) {
        //alle spaties verwijderen
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : IBANCode.toCharArray()) {
            if (c != ' ') {
                stringBuilder.append(c);
            }
        }

        //controleer of het controlegetal (op 3e en 4e positie) tussen 2 en 98 ligt
        int firstTwoNumbers = Integer.parseInt(stringBuilder.toString().substring(2, 4));
        if (firstTwoNumbers < 2 || firstTwoNumbers > 98) {
            return false;
        }

        //verplaats de eerste 4 karakters naar het einde
        stringBuilder.append(
                stringBuilder.substring(0, 4)
        );
        stringBuilder.replace(0, 4, "");

        //vervang elke letter door 2 cijfers, waarbij A = 10, B = 11, ..., Z = 35
        for (int i = 0; i < stringBuilder.length(); i++) {
            char localChar = stringBuilder.charAt(i);
            if (Character.isLetter(localChar)) {
                stringBuilder.replace(i, i + 1, String.valueOf((int) localChar));
            }
        }

        //bereken dan de restwaarde na deling door 97 (modulo)
        int modulo = (int) Double.parseDouble(stringBuilder.toString()) % 97;

        //als de restwaarde 1 is, dan is de IBAN code valide
        return modulo == 1;
    }

    @Override
    public void run() {
        System.out.println(
                IBANValid(IBANCode) ?
                        (IBANCode + ": valid") :
                        (IBANCode + ": not valid")
        );
    }
}

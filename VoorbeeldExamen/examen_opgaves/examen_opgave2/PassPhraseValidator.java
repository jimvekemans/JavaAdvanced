package examen_opgave2;

import java.util.List;

public class PassPhraseValidator<T> extends Thread {
    List<T> passPhrase;

    public PassPhraseValidator(List<T> passPhrase) {
        this.passPhrase = passPhrase;
    }

    public List<T> getPassPhrase() {
        return passPhrase;
    }

    public boolean isValid() {
        long sizeBeforeRemovingDuplicates = passPhrase.size();
        long sizeAfterRemovingDuplicates = passPhrase.stream().distinct().count();
        return sizeBeforeRemovingDuplicates == sizeAfterRemovingDuplicates;
    }
}

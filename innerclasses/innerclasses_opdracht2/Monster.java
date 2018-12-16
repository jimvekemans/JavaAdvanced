package innerclasses_opdracht2;

public interface Monster {
    void menace();

    interface DangerousMonster {
        void destroy(Monster monster);
    }
}

package opdracht2;

public class HorrorShow {
    public static void main(String[] args) {
        class Vampire implements Monster {

            @Override
            public void menace() {
                System.out.println("I'll drink your blood!");
            }
        }
        class Werewolf implements Monster, Monster.DangerousMonster {

            @Override
            public void destroy(Monster monster) {
                menace();
                monster.menace();
                System.out.println("Big fight... ");
                System.out.println(this.getClass().getSimpleName() + " killed one " + monster.getClass().getSimpleName());
            }

            @Override
            public void menace() {
                System.out.println("I'll destroy you!");
            }
        }
        Werewolf werewolf = new Werewolf();
        werewolf.destroy(new Vampire());
        werewolf.destroy(new Monster() {
            @Override
            public void menace() {
                System.out.println("You smell like wet dog");
            }
        });
    }
}

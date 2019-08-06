import java.nio.file.Paths;
import java.util.Collection;

public class App {
    public static void main(String[] args) {
        Collection<Property> propertyCollection = PropertyService.getAllProperties(Paths.get("./SacramentoHomes/sacramentorealestatetransactions.csv"));
        System.out.println(propertyCollection.stream().filter(property -> property.getStringVersion().length() > 20)
                .count());

    }
}

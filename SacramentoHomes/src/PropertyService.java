import javax.xml.bind.PropertyException;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collectors;

public class PropertyService {
    static Collection<Property> getAllProperties(Path filePath) {
        Collection<Property> propertyCollection = null;
        try {
            propertyCollection = Files.readAllLines(filePath).stream()
                    .map(Property::parseStringToProperty)
                    .collect(Collectors.toList());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        return propertyCollection;
    }
}

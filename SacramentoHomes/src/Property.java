import com.sun.media.sound.PortMixerProvider;

import javax.swing.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Property {
    private String street, city, state, stringVersion;
    private int zip, beds, baths;
    private float sqft, price, latitude, longitude;
    private LocalDateTime sale_date;
    private PropertyType propertyType;

    public Property(String string) {
        this.stringVersion = string;
        Property localProperty = Property.parseStringToProperty(string);
        setBaths(localProperty.getBaths());
    }

    public static Property parseStringToProperty(String text) {
        Property property = null;
        String[] lineParts = text.split(",");
        property.setStreet(lineParts[0]);
        property.setCity(lineParts[1]);
        property.setState(lineParts[3]);
        try {
            property.setZip(Integer.parseInt(lineParts[2]));
            property.setBeds((Integer.parseInt(lineParts[4])));
            property.setBaths(Integer.parseInt(lineParts[5]));
            property.setSqft(Float.parseFloat(lineParts[6]));
            property.setPrice(Float.parseFloat(lineParts[9]));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        for (PropertyType type : PropertyType.values()) {
            if (lineParts[7].equalsIgnoreCase(type.getType())) {
                property.setPropertyType(type);
                break;
            }
        }
        Local
        return property;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStringVersion() {
        return stringVersion;
    }

    public void setStringVersion(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public float getSqft() {
        return sqft;
    }

    public void setSqft(float sqft) {
        this.sqft = sqft;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public LocalDate getSale_date() {
        return sale_date;
    }

    public void setSale_date(LocalDate sale_date) {
        this.sale_date = sale_date;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }
}

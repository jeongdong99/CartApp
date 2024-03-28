import java.util.Objects;
import java.util.UUID;

public class Product {
    private final String KEY;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.KEY = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getKEY() {
        return KEY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return price == product.price && Objects.equals(name, product.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

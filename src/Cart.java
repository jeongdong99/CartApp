import java.util.HashMap;
import java.util.Map;

public class Cart {
    private HashMap<Product, Integer> items = new HashMap<Product, Integer>();

    public void addProduct(Product product, int quantity) {
        if (items.containsKey(product)) {
            System.out.println("[ERROR] "+product.getName()+"은 장바구니에 이미 있습니다.");
        } else {
            System.out.println(product.getName()+" "+quantity+"개 담기");
            items.put(product, quantity);
        }
    }

    public void removeProduct(Product product, int quantity) {
        if (!items.containsKey(product)) {
            System.out.println("[ERROR] "+product.getName()+"은 장바구니에 없습니다.");
        } else {
            int finalQuantity = items.get(product) - quantity;
            if (finalQuantity == 0) {
                items.remove(product);
            } else {
                System.out.println(product.getName()+" "+quantity+"개 빼기");
                items.put(product, items.get(product) - quantity);
            }

        }
    }

    public void showItems() {
        System.out.println();
        System.out.println("====장바구니에 담긴 상품 목록====");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
    }

}

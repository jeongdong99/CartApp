import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CartApp {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<Product>();

        // TODO: csv 파일 읽어오기
        String csvFile = "./List.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                productSet.add(new Product(data[0], Integer.parseInt(data[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }
        System.out.println();
        
        // 리스트로 바꾸기
        List<Product> productList = List.copyOf(productSet);
        // 장바구니 생성
        Cart myCart = new Cart();

        // TODO: 상품을 장바구니에 추가
        myCart.addProduct(productList.get(0), 2); // 지갑 2개 담기
        myCart.addProduct(productList.get(1), 3); // 신발 3개 담기
        myCart.addProduct(productList.get(0), 1); // 지갑 또 담기
        System.out.println();
        // TODO: 상품을 장바구니에서 제거
        myCart.removeProduct(productList.get(0), 1); // 지갑 1개 빼기
        myCart.removeProduct(productList.get(2), 1); // 가방 빼기
        // TODO: 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        myCart.showItems();
    }
}
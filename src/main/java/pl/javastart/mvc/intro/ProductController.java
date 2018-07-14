package pl.javastart.mvc.intro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping
    public String home() {
        return "index.html";
    }

    @RequestMapping("/produkty")
    @ResponseBody
    public String products() {
        List<Product> products = productRepository.getProducts();
        double price = 0;
        String result = "";

        for (Product product : products) {
            result += product.toString() + "<br>";
            price = price + product.getPrice();
        }
        return result + "<br>" + "Suma cen wynosi " + price + "<br>";
    }

    //    @RequestMapping("/add")
//    public String addUser(HttpServletRequest request) {
//        String nazwa = request.getParameter("nazwa");
//        String cena = request.getParameter("cena");
//        String kategoria = request.getParameter("kategoria");
//
//        Product product = new Product(nazwa, Double.parseDouble(cena), kategoria);
//        productRepository.addProduct(product);
//
//        return "redirect:/sukces";
//    }
    @RequestMapping("/add")
    public String addUser(@RequestParam(value = "nazwa") String nazwa, @RequestParam(value = "cena") double cena, @RequestParam(value = "kategoria") String kategoria) {

        Product product = new Product(nazwa, cena, kategoria);
        productRepository.addProduct(product);

        return "redirect:/sukces";
    }

    @RequestMapping("/sukces")
    public String success() {
        return "sukces.html";
    }

    @RequestMapping("/produktySpoz")
    @ResponseBody
    public String productsSpoz() {
        List<Product> products = productRepository.getProducts();
        double price=0;
        String result  = "";

        for (Product product : products) {
            if (product.getCategory().equals("Art.spożywcze")) {
                result += product.toString() + "<br>";
                price = price + product.getPrice();
            }
        }
        return result+ "<br>" + "Suma cen wynosi " + price  + "<br>";
    }
//    @RequestMapping(value = "/produkty?kategoria={kat}")
//    @ResponseBody
//    public String products(@PathVariable String kat) {
//        List<Product> products = productRepository.getProducts();
//        double price = 0, priceAll=0;
//        String resultAll = "", result = "", category = "";
//
//        switch (kat) {
//            case "spozywcze":
//                category = "Art.spożywcze";
//                break;
//            case "domowe":
//                category = "Art.gosp.domowego";
//                break;
//            case "inne":
//                category = "Inne";
//                break;
//            case "":
//                category = "All";
//                break;
//        }
//
//        for (Product product : products) {
//            if (category.equals("")) {
//                resultAll += product.toString() + "<br>";
//                priceAll = priceAll + product.getPrice();
//            }
//            if (product.getCategory().equals(category)) {
//                result += product.toString() + "<br>";
//                price = price + product.getPrice();
//            }
//
//        }
//        if (category.equals("")) return resultAll + "<br>" + "Suma cen wynosi " + priceAll + "<br>";
//        else return result + "<br>" + "Suma cen wynosi " + price + "<br>";
//
//    }
//}
    @RequestMapping("/produktyGosp")
    @ResponseBody
    public String productsGosp() {
        List<Product> products = productRepository.getProducts();
        double price=0;
        String result  = "";

        for (Product product : products) {
            if (product.getCategory().equals("Art.gosp.domowego")) {
                result += product.toString() + "<br>";
                price = price + product.getPrice();
            }
        }
        return result+ "<br>" + "Suma cen wynosi " + price  + "<br>";
    }

    @RequestMapping("/produktyInne")
    @ResponseBody
    public String productsInne() {
        List<Product> products = productRepository.getProducts();
        double price=0;
        String result  = "";

        for (Product product : products) {
            if (product.getCategory().equals("Inne")) {
                result += product.toString() + "<br>";
                price = price + product.getPrice();
            }
        }
        return result+ "<br>" + "Suma cen wynosi " + price  + "<br>";
    }
}

package pl.javastart.mvc.intro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ResponseBody
    @RequestMapping("/abc")
    public String asdasdasdsasd() {
        System.out.println("Zadziałało!");

        return "Cześć!";
    }

    @RequestMapping
    public String home(){
        return "index.html";
    }

    @RequestMapping("/produkty")
    @ResponseBody
    public String users() {
        List<Product> products = productRepository.getProducts();

        String result  = "";

        for (Product product : products) {
            result += product.toString() + "<br>";
        }
        return result;
    }

    @RequestMapping("/add")
    public String addUser(HttpServletRequest request) {
        String nazwa = request.getParameter("nazwa");
        String cena = request.getParameter("cena");
        String kategoria = request.getParameter("kategoria");

        Product product = new Product(nazwa, Double.parseDouble(cena), kategoria);
        productRepository.addProduct(product);

        return "redirect:/success";
    }
}

package springapp.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import springapp.domain.Product;


@Service
public class ProductService {

	
	@PreAuthorize("hasPermission('Product', 'get')")
	public Product getProduct(){
		
		Product prod = new Product();
		
		prod.setId(123);
		prod.setDescription("A fine product");
		prod.setType("Appliance");
		
		return prod;
	}
}

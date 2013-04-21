package springapp.fitnesse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springapp.service.SaleService;

public abstract class SpringFitnesseFixture {

	public SpringFitnesseFixture(){
		setUpSpring();
	}
	
	protected SaleService saleService;

	protected void setUpSpring() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"classpath:test-context.xml")
				.getAutowireCapableBeanFactory();
		saleService = (SaleService)beanFactory.getBean("saleService");
	}
}

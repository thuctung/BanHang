package detai.cnjva.configFile;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;import org.springframework.web.servlet.view.InternalResourceViewResolver;

<<<<<<< HEAD
import detai.cnjva.DAO.Implement.giohangImplement;
import detai.cnjva.DAO.Interface.giohangInterface;
import detai.cnjva.DAOFile.UserDAO;
=======
>>>>>>> 52e6a33538b2e5838241aa8910f6bc7c9dc53908


 
@Configuration
@ComponentScan("detai.cnjva.*") 
public class ApplicationContextConfig { 
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }  
    
<<<<<<< HEAD
    @Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ptmpcn");
        dataSource.setUsername("root");
        dataSource.setPassword("votandong");
        
        return dataSource;
	}
    @Bean
    public UserDAO getContactDAO() {
        return new UserDAO(getDataSource());
    }
    @Bean
    public giohangInterface getGiohangInterface()
    {
    	return new giohangImplement(getDataSource());
    }
=======
>>>>>>> 52e6a33538b2e5838241aa8910f6bc7c9dc53908
    
}
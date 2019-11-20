package detai.cnjva.configFile;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import detai.cnjva.DAO.Implement.giohangImplement;
import detai.cnjva.DAO.Interface.giohangInterface;
import detai.cnjva.DAOFile.UserDAO;

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
    public giohangInterface getGiohangInterface()
    {
    	return new giohangImplement(getDataSource());
    }
    
}
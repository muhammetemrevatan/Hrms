package kodlamaio.hrms.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.cloudinary.CloudinaryManager;
import kodlamaio.hrms.core.cloudinary.CloudinaryService;


@Configuration
public class CloudinaryConfig {
	
 	@Bean
    public Cloudinary cloudinarySettings(){
        return new Cloudinary(ObjectUtils.asMap(
        		"cloud_name", "nasii",
        		"api_key", "759441369417482",
        		"api_secret", "JiZarj59GDvtyfVZErxOrGdsUFU"));
    }
 	
    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinarySettings());
    }

}

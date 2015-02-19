package gdes.adf.sansbootjavaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"gdes.adf.sansbootjavaconfig.mvc"})
@EnableWebMvc
public class DispatcherConfig {

}

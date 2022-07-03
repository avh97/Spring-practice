package by.khaletski.practice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("by.khaletski.practice")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
}

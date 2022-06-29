package by.khaletski.practice;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "The Wind Cries Mary";
    }
}

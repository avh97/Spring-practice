package by.khaletski.practice;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "I Don't Want to Set the World on Fire";
    }
}

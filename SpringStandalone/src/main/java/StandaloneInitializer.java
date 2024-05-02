import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StandaloneInitializer {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StandaloneInitializer.class);
    }

}

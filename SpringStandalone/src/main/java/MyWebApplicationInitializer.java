import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

/** NOT detected on purpose, see <a href="https://github.com/spring-projects/spring-boot/issues/522">this Github issue</a> */
public class MyWebApplicationInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) {
        servletContext.addServlet("console-dispatcher", new ConsoleServletDispatcher());
    }
}

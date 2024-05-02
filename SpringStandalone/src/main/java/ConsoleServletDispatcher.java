import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Trying to achieve the same as F!F Console Backend's Spring Servlet Dispatcher
 * */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ConsoleServletDispatcher extends DispatcherServlet implements javax.servlet.Servlet {

    public ConsoleServletDispatcher() {
        setContextConfigLocation(ResourceUtils.CLASSPATH_URL_PREFIX + "/FrankFrameworkApiContext2.xml");
        setDetectAllHandlerMappings(false); //Else it will use the parent's (EnvironmentContext) Spring Integration mapping
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        //don't wire the ApplicationContext,
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletRegistration.Dynamic registration = (ServletRegistration.Dynamic) servletConfig.getServletContext().getServletRegistration(servletConfig.getServletName());
        registration.setLoadOnStartup(1);
        registration.addMapping("/custom/*");
//        registration.setMultipartConfig(new MultipartConfigElement(""));

       super.init(servletConfig);
    }

}

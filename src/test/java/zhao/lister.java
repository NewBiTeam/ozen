package zhao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class lister implements ServletContextListener{
	
	public static Logger logger = LoggerFactory.getLogger(lister.class);
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// 当Servlet容器启动Web应用时调用该方法。在调用完该方法之后，容器再对Filter初始化，
		// 并且对那些在Web应用启动时就需要被初始化的Servlet进行初始化。
		logger.info("-----启动项目成功");
		ServletContext servletContext = event.getServletContext();
		//上下文用的，（页面也可以用）
		servletContext.setAttribute("base", servletContext.getContextPath());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// 当Servlet容器终止Web应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet和Filter过滤器。
		logger.info("----------结束");
	}

}

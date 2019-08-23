package util;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;     //Spring应用上下文环境

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext
     * @throws BeansException
     *
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     *
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);

    }

    /**
     * 获取类型为requiredType的对象
     * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     *
     * @param name         bean注册名
     * @param requiredType 返回对象类型
     * @return Object 返回requiredType类型对象
     * @throws BeansException
     *
     */
    public static Object getBean(String name, Class requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     * @return boolean
     * @throws NoSuchBeanDefinitionException
     *
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }

    /**
     * @param name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     *
     */
    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     *
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(name);
    }


//
//	private static ServletContext servletContext = null;
//
//	public static void bindSessionContext(ServletContext servletContext) {
//		if (SpringHelper.servletContext == null) {
//			SpringHelper.servletContext = servletContext;
//		}
//	}
//
//	public static Object getBean(String beanName) {
//		WebApplicationContext context = (WebApplicationContext) servletContext
//				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		return context.getBean(beanName);
//	}
//
//	public static Object getBean(String beanName, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		ServletContext servletContext = session.getServletContext();
//		WebApplicationContext context = (WebApplicationContext) servletContext
//				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		return context.getBean(beanName);
//	}
//
//	public static Object getBean(String beanName, ServletContext servletContext) {
//		WebApplicationContext context = (WebApplicationContext) servletContext
//				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		return context.getBean(beanName);
//	}
//
//	public static ServletContext getServletContext() {
//		return servletContext;
//	}
//
//	public static void debugRequest(HttpServletRequest request,
//			ServletContext servletContext) {
//		System.out.println("Protocol: " + request.getProtocol() + "<br>");
//		System.out.println("Scheme: " + request.getScheme() + "<br>");
//		System.out.println("Server Name: " + request.getServerName() + "<br>");
//		System.out.println("Server Port: " + request.getServerPort() + "<br>");
//		System.out.println("Protocol: " + request.getProtocol() + "<br>");
//		System.out.println("Server Info: " + servletContext.getServerInfo()
//				+ "<br>");
//		System.out.println("Remote Addr: " + request.getRemoteAddr() + "<br>");
//		System.out.println("Remote Host: " + request.getRemoteHost() + "<br>");
//		System.out.println("Character Encoding: "
//				+ request.getCharacterEncoding() + "<br>");
//		System.out.println("Content Length: " + request.getContentLength()
//				+ "<br>");
//		System.out
//				.println("Content Type: " + request.getContentType() + "<br>");
//		System.out.println("Auth Type: " + request.getAuthType() + "<br>");
//		System.out.println("HTTP Method: " + request.getMethod() + "<br>");
//		System.out.println("Path Info: " + request.getPathInfo() + "<br>");
//		System.out.println("Path Trans: " + request.getPathTranslated()
//				+ "<br>");
//		System.out
//				.println("Query String: " + request.getQueryString() + "<br>");
//		System.out.println("Remote User: " + request.getRemoteUser() + "<br>");
//		System.out.println("Session Id: " + request.getRequestedSessionId()
//				+ "<br>");
//		System.out.println("Request URI: " + request.getRequestURI() + "<br>");
//		System.out
//				.println("Servlet Path: " + request.getServletPath() + "<br>");
//		System.out.println("Accept: " + request.getHeader("Accept") + "<br>");
//		System.out.println("Host: " + request.getHeader("Host") + "<br>");
//		System.out
//				.println("Referer : " + request.getHeader("Referer") + "<br>");
//		System.out.println("Accept-Language : "
//				+ request.getHeader("Accept-Language") + "<br>");
//		System.out.println("Accept-Encoding : "
//				+ request.getHeader("Accept-Encoding") + "<br>");
//		System.out.println("User-Agent : " + request.getHeader("User-Agent")
//				+ "<br>");
//		System.out.println("Connection : " + request.getHeader("Connection")
//				+ "<br>");
//		System.out.println("Cookie : " + request.getHeader("Cookie") + "<br>");
//
//	}

}

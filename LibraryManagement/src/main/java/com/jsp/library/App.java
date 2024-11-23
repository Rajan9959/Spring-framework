package com.jsp.library;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jsp.library.IService.ILibraryService;
import com.jsp.library.IService.ILibraryServiceImpl;
import com.jsp.library.configuration.JpaConfig;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext("LibraryConfig.xml");
    	System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    	ILibraryService service = context.getBean("libraryService",ILibraryService.class);
    	
        service.addBook();
    }
}

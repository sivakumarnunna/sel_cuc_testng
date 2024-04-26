package com.test.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.ITestAnnotation;

import com.utlis.base.ConfigReader;

public class AnnotationTransformer  implements IAnnotationTransformer{
	

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(Retry.class);
	   
}
	

	  @Override
	  public void transform(IDataProviderAnnotation annotation, Method method) {
	  
		  
          boolean myBooleanProperty = Boolean.parseBoolean(ConfigReader.getProperty("parallel"));

	      annotation.setParallel(myBooleanProperty);
	
	    
}
}

package com.ipj.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor{

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) 
	{
		List<IMethodInstance> sortedMethods = new ArrayList<IMethodInstance>();
		
		Map<String,String> test1 = new HashMap<String, String>();
		test1.put("name", "test1");
		test1.put("count", "1");
		//test1.put("execute", "yes");
		
		Map<String,String> test2 = new HashMap<String, String>();
		test2.put("name", "test2");
		test2.put("count", "2");
		//test2.put("execute", "no");
		
		Map<String,String> test3 = new HashMap<String, String>();
		test3.put("name", "test3");
		test3.put("count", "1");
		
		List<Map<String,String>> tests = new ArrayList<Map<String, String>>();
		tests.add(test1);
		tests.add(test2);
		tests.add(test3);
		
		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<tests.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(tests.get(j).get("name")))
				{
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(tests.get(j).get("count")));
					sortedMethods.add(methods.get(i));
				}
			}
		}
		
		return sortedMethods;
	}

}

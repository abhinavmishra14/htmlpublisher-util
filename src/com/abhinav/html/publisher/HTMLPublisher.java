/*
 * Created By: Abhinav Kumar Mishra
 * Copyright &COPY; 2013-2016.
 * All rights reserved.
 */
package com.abhinav.html.publisher;

import com.abhinav.html.publisher.utils.HTMLPubUtils;

/**
 * This class HTMLPublisher<br/>
 * Publishes the index.html
 * 
 * @since 2016
 * @author Abhinav Kumar Mishra
 */
public class HTMLPublisher {
	public static void main(String[] args) throws Exception {
		System.out.println("[HTMLPublisher:] HTMLPublisher reading the inputs...");
		String srcPath = args.length > 0 ? args[0]	: HTMLPubUtils.EMPTY;
		System.out.println("[HTMLPublisher:] HTMLPublisher Input dir: "+srcPath);
		if(srcPath!=null && srcPath!=HTMLPubUtils.EMPTY && !srcPath.equals(HTMLPubUtils.EMPTY)){
			System.out.println("[HTMLPublisher:] HTMLPublisher initializing the publish request...");
			HTMLPublishingProcessor processor = new HTMLPublishingProcessor();
			processor.publish(srcPath);
		}else{
			System.out.println("[HTMLPublisher:] Source path or target outpur dir path are null, please check the inputs!");
		}
	}
}

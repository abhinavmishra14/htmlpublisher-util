/*
 * Created By: Abhinav Kumar Mishra
 * Copyright &copy; 2013-2016. Abhinav Kumar Mishra. 
 * All rights reserved.
 */
package com.abhinav.html.publisher.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class DirectoryTraverser.<br/>
 * It returns lists the files in a collection by traversing directories recursively.
 * 
 * @since 2016
 * @author Abhinav Kumar Mishra
 */
public final class DirectoryTraverser {
	
	/**
	 * Gets the content uri.
	 * 
	 * @param input the input
	 * @return the content uri
	 * @throws FileNotFoundException the file not found exception
	 */
	public static Set<File> getContentUri(String input) throws FileNotFoundException {
		File startingDirectory = new File(input);
		return  getFileListing(startingDirectory);
	}

	/**
	 * Gets the file listing. Recursively traverse a directory tree and return a
	 * List of all Files found,the List is sorted using File.compareTo() method.
	 * 
	 * @param aStartingDir the a starting dir
	 * @return the file listing
	 * @throws FileNotFoundException the file not found exception
	 */
	public static Set<File> getFileListing(File aStartingDir)
			throws FileNotFoundException {
		validateDirectory(aStartingDir);
		return getFileListingNoSort(aStartingDir);
	}

	/**
	 * Gets the file listing no sort.
	 * 
	 * @param aStartingDir the a starting dir
	 * @return the file listing no sort
	 * @throws FileNotFoundException the file not found exception
	 */
	private static Set<File> getFileListingNoSort(File aStartingDir)
			throws FileNotFoundException {
		Set<File> result = new TreeSet<File>();
		File[] filesAndDirs = aStartingDir.listFiles();
		List<File> filesDirs = Arrays.asList(filesAndDirs);
		Iterator<File> filesDirsItr = filesDirs.iterator();
		while (filesDirsItr.hasNext()) {
			File file = (File) filesDirsItr.next();
			result.add(file); // always add, even if directory
			if (!file.isFile()) {
				//Must be a directory recursive call!
				Set<File> deeperList = getFileListingNoSort(file);
				result.addAll(deeperList);
			}
		}
		return result;
	}

	/**
	 * If directory exists then it is valid. If directory is valid then it can
	 * be read.
	 *
	 * @param aDirectory the a directory
	 */
	private static void validateDirectory(File aDirectory) {
		if (aDirectory == null) {
			throw new IllegalArgumentException("Directory should not be null.");
		}
		if (!aDirectory.exists()) {
			try {
				throw new FileNotFoundException("Directory does not exist: "
						+ aDirectory);
			} catch (FileNotFoundException e) {
				System.out.println("[DirectoryProcessorHelper:] Exception thrown: "+e.getMessage());
			}
		}
		if (!aDirectory.isDirectory()) {
			throw new IllegalArgumentException("Is not a directory: "
					+ aDirectory);
		}
		if (!aDirectory.canRead()) {
			throw new IllegalArgumentException("Directory cannot be read: "
					+ aDirectory);
		}
	}
}
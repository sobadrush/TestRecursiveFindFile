package com.ctbc.TestRecursiveFindFile;

import java.io.File;
import java.util.Collection;

public class FileUtilRecuriveTest {

	public static void main(String[] args) {
		String workspaceStr = System.getProperty("user.dir") + "/src/TestFolder";
		java.io.File fileDir = new java.io.File(workspaceStr);
		boolean isRecursive = true;
		Collection<File> fileCollection = org.apache.commons.io.FileUtils.listFiles(fileDir, null /*所有檔案，不限定附檔名*/ , isRecursive);
		for (File file : fileCollection) {
			System.out.println(file.getName());
		}
	}
}

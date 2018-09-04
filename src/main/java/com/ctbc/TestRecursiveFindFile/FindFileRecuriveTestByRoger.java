package com.ctbc.TestRecursiveFindFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFileRecuriveTestByRoger {

	public static void main(String[] args) {
		String workspaceStr = System.getProperty("user.dir") + "/src/TestFolder";

		// ============ 測試 findSingleFile =============
		File ff = FindFileRecuriveTestByRoger.findSingleFile(workspaceStr, "BB.txt");
		System.out.println("ff = " + ff.getAbsolutePath());
		// ============ 測試 findAllFile =============
//		List<File> gg = FindFileRecuriveTestByRoger.findAllFile(workspaceStr);
//		System.err.println("gg.size = " + gg.size());
//		for (File ff : gg) {
//			System.out.println(ff);
//		}
	}

	public static File findSingleFile(String pathStr, String searchName/* 要找的目標字串 */) {
		java.io.File fileDir = new java.io.File(pathStr);

		int i = 0;
		File[] files = fileDir.listFiles();
		for (File ff : files) {
			i++;
//			System.out.println(ff.getName());
//			System.out.println(ff.getAbsolutePath());
			if (ff.isDirectory()) {
				// 若是資料夾，遞迴往下層找
				return findSingleFile(ff.getAbsolutePath(), searchName);
			} else {
				// 若不資料夾

				if (ff.getName().equals(searchName)) {
					return ff; //【遞迴終止條件】找到檔案了，return File
				} else {
					continue;
				}
				
			}
		}
		return fileDir;
	}

	public static List<File> findAllFile(String pathStr) {
		java.io.File fileDir = new java.io.File(pathStr);

		int i = 0;
		List<File> fList = new ArrayList<>();
		File[] files = fileDir.listFiles();
		for (File ff : files) {
//			System.out.println(ff.getName());
//			System.out.println(ff.getAbsolutePath());
			i++;
			if (ff.isDirectory()) {
				// 若是資料夾，遞迴往下層找
				fList.addAll(findAllFile(ff.getAbsolutePath()));
			} else {
				// 若不資料夾
				fList.add(ff);
				if (i < files.length) { // 若最外層的for...each還沒跑完，就是說還有未判斷的File資料的話→continue
					continue;
				}
				return fList; // 【遞迴終止條件】判斷完畢了，return List
			}
		}
		return fList;
	}

}

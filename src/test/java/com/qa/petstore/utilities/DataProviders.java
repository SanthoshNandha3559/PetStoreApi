package com.qa.petstore.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "testData")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//ApiData.xlsx";
		ExcelUtility utility = new ExcelUtility(path);

		int row = utility.getRowCount("Sheet1");
		int cell = utility.getCellCount("Sheet1", row);

		String apiData[][] = new String[row][cell];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < cell; j++) {
				apiData[i - 1][j] = utility.getCellData("Sheet1", i, j);
			}
		}
		return apiData;
	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//ApiData.xlsx";
		ExcelUtility utility = new ExcelUtility(path);
		int row = utility.getRowCount("Sheet1");
		String apiData[] = new String[row];
		for (int i = 1; i <= row; i++) {
			apiData[i - 1] = utility.getCellData("Sheet1", i, 1);
		}
		return apiData;
	}
}

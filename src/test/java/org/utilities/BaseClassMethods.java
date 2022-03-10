
package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassMethods {
 public static WebDriver driver;

	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void launchFireFox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	public static void windMax() {
		driver.manage().window().maximize();

	}

	public static void closeWindow() {
		driver.close();

	}

	public static void windowRefresh() {
		driver.navigate().refresh();

	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void passValue(WebElement e, String value) {
		e.sendKeys(value);

	}

	public static void btnclick(WebElement e) {
		e.click();
	
	}

	public static void printTitle() {
		String t = driver.getTitle();
		System.out.println(t);

	}

	public static void printCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void printTxt(WebElement e) {
		String text = e.getText();
		System.out.println(text);

	}

	public static void printAttribute(WebElement e, String name) {
		String attribute = e.getAttribute(name);
		System.out.println(attribute);
	}

	public static void moveTo(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	public static void dragDrop(WebElement e, WebElement b) {
		Actions a = new Actions(driver);
		a.dragAndDrop(e, b).perform();
	}

	public static void upDown(WebElement e, String name) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.SHIFT).sendKeys(e, name).keyUp(Keys.SHIFT).perform();
	}

	public static void douClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	public static void conClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	public static void press(int code) throws AWTException {
		Robot r = new Robot();
		r.keyPress(code);
	}

	public static void release(int code) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(code);
	}

	public static void alertOk() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void alertCancel() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void alertPass(String txt) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(txt);
	}

	public static void alertprint() {
		Alert a = driver.switchTo().alert();
		a.getText();
	}

	public static void screenShot(String path) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File tem = t.getScreenshotAs(OutputType.FILE);
		File per = new File(path);
		FileUtils.copyFile(tem, per);
	}

	public static void javaExeSetValue(String s, WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(s, e);

	}

	public static void javaExePrint(String s, WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(s, e);

	}

	public static void javaExeScrollDwn(WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", e);

	}

	public static void javaExeScrollDUp(WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(false)", e);

	}

	public static void javaExeHighLight(String s, WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(s, e);

	}

	public static void selectvalue(WebElement e, String v) {
		Select s = new Select(e);
		s.selectByValue(v);
	}

	public static void selectTxt(WebElement e, String v) {
		Select s = new Select(e);
		s.selectByVisibleText(v);
	}

	public static void selectIndex(WebElement e, int i) {
		Select s = new Select(e);
		s.selectByIndex(i);
	}

	public static void deSelectvalue(WebElement e, String v) {
		Select s = new Select(e);
		s.deselectByValue(v);
	}

	public static void deSelectTxt(WebElement e, String v) {
		Select s = new Select(e);
		s.deselectByVisibleText(v);
	}

	public static void deSelectIndex(WebElement e, int i) {
		Select s = new Select(e);
		s.deselectByIndex(i);
	}

	public static void deSelect(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}

	public static void dropDownSize(WebElement e) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		System.out.println(options.size());
	}

	public static void dropDownGetAll(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allOptions = s.getAllSelectedOptions();
		System.out.println(allOptions);
	}

	public static void dropDownGetFirst(WebElement e) {
		Select s = new Select(e);
		WebElement firstOption = s.getFirstSelectedOption();
		System.out.println(firstOption);
	}

	public static void switchFrames(WebElement e) {
		WebDriver f = driver.switchTo().frame(e);

	}

	public static void parentFrames() {
		WebDriver parentFrame = driver.switchTo().parentFrame();

	}

	public static void defaultFrame() {
		WebDriver defaultFrame = driver.switchTo().defaultContent();

	}

	public static void parentWindow() {
		String windowHandle = driver.getWindowHandle();

	}

	public static void windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();

	}

	public static void switchWindows() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if(!string.equals(windowHandle)) {
			driver.switchTo().window(string);
		}

	}}

	public static void closeWindows() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			driver.close();
		}

	}

	public static void quitWindow() {
		driver.quit();

	}

	public static void findrow(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
		}
	}

	public static void findHeading(WebElement row) {
		List<WebElement> headings = row.findElements(By.tagName("tr"));
		for (int i = 0; i < headings.size(); i++) {
			WebElement heading = headings.get(i);
		}
	}

	public static void findData(WebElement row) {
		List<WebElement> datas = row.findElements(By.tagName("td"));
		for (int j = 0; j < datas.size(); j++) {
			WebElement data = datas.get(j);
		}
	}

	public static void webTableTxt(WebElement table, String txt) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data1 = datas.get(j);
				String text = data1.getText();
				System.out.println(text);
				if (text.equals(txt)) {
					System.out.println("TEXT POSITION");
					System.out.println("ROW POSITION :" + (i + 1));
					System.out.println("COLOUM POSITION :" + (j + 1));

				}
			}

		}

	}

	public static void implicitWait(long s, TimeUnit su) {
		driver.manage().timeouts().implicitlyWait(s, su);
	}

	public static void conditionWaitAlert(long seconds) {
		WebDriverWait w = new WebDriverWait(driver, seconds);
		w.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void fluentWait(long s, long pollingSecond) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(s))
				.pollingEvery(Duration.ofSeconds(pollingSecond)).ignoring(Throwable.class);

	}

	public static String getData(int rowNumber, int cellNumber) throws IOException {
		File f = new File("G:\\\\selenium\\\\FrameWorkEx\\\\excelsheet\\\\DataDrivenEx.xlsxsss");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		Row row = s.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd/MM//YYYY");
				value = sim.format(d);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(l);

			}
		}
		return value;

	}

}


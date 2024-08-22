package selenium;

import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {

    public static void main(String[] args) {
        // Đường dẫn đến chromedriver
        System.setProperty("webdriver.chrome.driver", "E:\\SWT\\chromedriver-win64\\chromedriver.exe");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Chọn test case để chạy:");
                System.out.println("1. Test Login Successfully");
                System.out.println("2. Login failed with incorrect credentials");
                System.out.println("3. Login failed with null values");
                System.out.println("4. Thoát");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        testLoginSuccessfully(driver);
                        break;
                    case 2:
                        testLoginFailedWithIncorrectCredentials(driver);
                        break;
                    case 3:
                        testLoginFailedWithNullValues(driver);
                        break;
                    case 4:
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }

    private static void testLoginSuccessfully(WebDriver driver) {
        try {
            navigateToLoginPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div[2]/form/button")));

            usernameField.sendKeys("Adam");
            passwordField.sendKeys("123");
            signInButton.click();

            wait.until(ExpectedConditions.urlContains("home"));
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "http://localhost:9999/Project/home"; // Expected output
            
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Test Login Successfully - Pass");
            } else {
                System.out.println("Test Login Successfully - Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testLoginFailedWithIncorrectCredentials(WebDriver driver) {
        try {
            navigateToLoginPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div[2]/form/button")));

            usernameField.sendKeys("vuphan");
            passwordField.sendKeys("abc123");
            signInButton.click();

            boolean isErrorDisplayed = wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("login"),
                    ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Username or password is incorrect")
            ));

            String expectedMessage = "Username or password is incorrect"; // Expected output
            if (isErrorDisplayed) {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.contains("login")) {
                    WebElement bodyText = driver.findElement(By.tagName("body"));
                    if (bodyText.getText().contains(expectedMessage)) {
                        System.out.println("Test Login Failed With Incorrect Credentials - Pass");
                    } else {
                        System.out.println("Test Login Failed With Incorrect Credentials - Fail");
                    }
                } else {
                    System.out.println("Test Login Failed With Incorrect Credentials - Fail");
                }
            } else {
                System.out.println("Test Login Failed With Incorrect Credentials - Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testLoginFailedWithNullValues(WebDriver driver) {
        try {
            navigateToLoginPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div[2]/form/button")));

            signInButton.click();

            boolean isErrorDisplayed = wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("login"),
                    ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Username or password is required")
            ));

            String expectedMessage = "Username or password is required"; // Expected output
            if (isErrorDisplayed) {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.contains("login")) {
                    WebElement bodyText = driver.findElement(By.tagName("body"));
                    if (bodyText.getText().contains(expectedMessage)) {
                        System.out.println("Test Login Failed With Null Values - Pass");
                    } else {
                        System.out.println("Test Login Failed With Null Values - Fail");
                    }
                } else {
                    System.out.println("Test Login Failed With Null Values - Fail");
                }
            } else {
                System.out.println("Test Login Failed With Null Values - Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateToLoginPage(WebDriver driver) {
        try {
            driver.get("http://localhost:9999/Project/login.jsp");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.urlContains("login"));
            System.out.println("Đã điều hướng đến trang đăng nhập.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

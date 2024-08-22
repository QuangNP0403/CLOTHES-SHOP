package selenium;

import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSignUp {

    public static void main(String[] args) {
        // Đường dẫn đến chromedriver
        System.setProperty("webdriver.chrome.driver", "E:\\SWT\\chromedriver-win64\\chromedriver.exe");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Chọn test case để chạy:");
                System.out.println("1. Test Sign Up Successfully");
                System.out.println("2. Sign Up failed with error value");
                System.out.println("3. Sign Up failed with null value");
                System.out.println("4. Thoát");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        testSignUpSuccessfully(driver);
                        break;
                    case 2:
                        testSignUpFailedWithErrorValue(driver);
                        break;
                    case 3:
                        testAddAccountFailedWithNullValue(driver);
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

    private static void testSignUpSuccessfully(WebDriver driver) {
        try {
            navigateToSignUpPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
            WebElement repeatPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("repass")));
            WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address")));
            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div[1]/form/button")));

            usernameField.sendKeys("newuser");
            passwordField.sendKeys("password123");
            repeatPasswordField.sendKeys("password123");
            addressField.sendKeys("123 Main St");
            phoneNumberField.sendKeys("1234567890");
            submitButton.click();
            wait.until(ExpectedConditions.urlContains("home"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("home")) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testSignUpFailedWithErrorValue(WebDriver driver) {
        try {
            navigateToSignUpPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
            WebElement repeatPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("repass")));
            WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address")));
            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div[1]/form/button")));

            usernameField.sendKeys("erroruser");
            passwordField.sendKeys("errorpassword");
            repeatPasswordField.sendKeys("errorpasswor");
            addressField.sendKeys("456 Error St");
            phoneNumberField.sendKeys("0987654321");

            submitButton.click();

            wait.until(ExpectedConditions.urlContains("login.jsp"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("login.jsp")) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testAddAccountFailedWithNullValue(WebDriver driver) {
        try {
            navigateToSignUpPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div[1]/form/button")));

            // Click the submit button without filling in any fields
            submitButton.click();

            // Wait for either the error message to appear or the page to redirect
            boolean isErrorDisplayed = wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("signup"), // Stay on the same page if there's an error
                    ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "error message") // Error message in the body
            ));

            // Check for URL or error message to determine the outcome
            if (isErrorDisplayed) {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.contains("signup")) {
                    WebElement bodyText = driver.findElement(By.tagName("body"));
                    if (bodyText.getText().contains("error message")) {
                        System.out.println("Pass");
                    } else {
                        System.out.println("Fail");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateToSignUpPage(WebDriver driver) {
        try {
            driver.get("http://localhost:9999/Project/login.jsp");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            System.out.println("Đã điều hướng đến trang đăng ký.");
            WebElement buttonSignup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signUp\"]")));
            buttonSignup.click();
            System.out.println("Bấm nút chuyển sang đăng kí thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

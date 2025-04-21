package UI;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import static org.testng.Assert.*;

public class FormTest extends BaseTest {

    @Test
    public void testWebForm() {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Ифвафа Ффав Фаваф");
        assertEquals(textInput.getAttribute("value"), "Ифвафа Ффав Фаваф");

        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("ЧАЧА");
        assertEquals(textarea.getAttribute("value"), "ЧАЧА");


        WebElement password = driver.findElement(By.name("my-password"));
        password.sendKeys("Password");
        assertEquals(password.getAttribute("value"), "Password");

        WebElement dropdown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropdown);
        select.selectByValue("2");
        assertEquals(select.getFirstSelectedOption().getAttribute("value"), "2");

        WebElement datalist = driver.findElement(By.name("my-datalist"));
        datalist.sendKeys("Seattle");
        assertEquals(datalist.getAttribute("value"), "Seattle");

        WebElement checkbox1 = driver.findElement(By.id("my-check-1"));
        WebElement checkbox2 = driver.findElement(By.id("my-check-2"));

        if (!checkbox1.isSelected()) checkbox1.click();
        if (!checkbox2.isSelected()) checkbox2.click();

        assertTrue(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());

        WebElement radioButton = driver.findElement(By.id("my-radio-2"));
        radioButton.click();
        assertTrue(radioButton.isSelected());

        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        colorPicker.sendKeys("#00FF00");
        assertEquals(colorPicker.getAttribute("value").toLowerCase(), "#00ff00");

        WebElement datePicker = driver.findElement(By.name("my-date"));

        datePicker.sendKeys("09-23-2024");
        assertEquals(datePicker.getAttribute("value"), "09-23-2024");

        WebElement range = driver.findElement(By.name("my-range"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].value = '10'; arguments[0].dispatchEvent(new Event('change'));", range);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        assertEquals(message.getText(), "Received!");
    }
}
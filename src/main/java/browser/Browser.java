package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Класс для управления браузером.
 * Содержит методы для создания и настройки WebDriver.
 */
public class Browser {

    /**
     * Создает и настраивает экземпляр WebDriver для Chrome.
     * Использует WebDriverManager для автоматической загрузки драйвера.
     *
     * @return Настроенный экземпляр WebDriver
     */
    public static WebDriver createDriver() {
        // Настраиваем WebDriverManager для автоматической загрузки ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Создаем объект настроек Chrome
        ChromeOptions options = new ChromeOptions();

        // Добавляем опции для Chrome
        options.addArguments("--start-maximized"); // Запуск в максимальном размере
        options.addArguments("--remote-allow-origins=*"); // Разрешаем удаленные подключения
        options.addArguments("--disable-notifications"); // Отключаем уведомления

        // Создаем и возвращаем экземпляр ChromeDriver с настройками
        return new ChromeDriver(options);
    }
}
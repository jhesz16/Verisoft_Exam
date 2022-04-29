import Pages.GlobalHelpers;
import Pages.HTMLTables;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Driver.Setup.getBrowser;
import static Driver.Setup.getDriver;
import static Pages.GlobalHelpers.driver;

public class base {
    public static GlobalHelpers helpers;
    public static HTMLTables htmlTables;

    @BeforeMethod
    public void setupClass() throws IOException {
        getDriver(getBrowser());
        helpers = new GlobalHelpers();
        htmlTables = PageFactory.initElements(driver, HTMLTables.class);
    }

    @DataProvider(name = "htmlTableGetData")
    public Object[][] getData(Method fileName) {
        String path = "src\\test\\java\\TestData\\HTMLTable";
        List<String> arrayList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            arrayList = stream
                    .filter(s -> !s.contains("#"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][] array = new Object[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            String row = arrayList.get(i);
            array[i] = Arrays.stream(row.split(",")).toArray();
        }
        return array;
    }

}

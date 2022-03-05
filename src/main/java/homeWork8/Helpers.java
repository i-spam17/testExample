package homeWork8;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Collection;

public class Helpers {
    public static boolean isElementExist(WebElement element, String elementName) {
        try {
            element.getText().equals(elementName);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static SelenideElement getElement(Collection<SelenideElement> selenideElementCollection, String nameWebElement) {

        System.out.println(nameWebElement + "    " + Selenide.elements(selenideElementCollection));
        return   Selenide.elements(selenideElementCollection).stream().filter(el -> el.getText().equals(nameWebElement))
                .findFirst()
                .get();
    }

    public static class DnDFromJS {
//        js.ExecuteScript(jsfile + "$('#[sourceElement]').simulateDragDrop({dropTarget: '#[targetElement]'})");



//    //Drag 1st control to layout
//    String js_filepath = "c:\\selenium-java-2.33.0\\drag_and_drop_helper.js";
//    String java_script="";
//    String text;
//
//    BufferedReader input = new BufferedReader(new FileReader(js_filepath));
//    StringBuffer buffer = new StringBuffer();
//
//    while ((text = input.readLine()) != null)
//            buffer.append(text + " ");
//    java_script = buffer.toString();
//
//    input.close();
//
//    String source = "__htmlview0--Button1";
//    String target = "__htmlview0--homePage-intHeader";
//    java_script = java_script+"$('#"+source+"').simulate( '#" +target+ "');" ;
//    ((JavascriptExecutor)driver).executeScript(java_script);

//        String filePath = "C://homeWork7/help/dragAndDropHelper.js";
//        StringBuffer buffer = new StringBuffer();
//
//        String line;
//        BufferedReader br;
//
//        {
//            try {
//                br = new BufferedReader(new FileReader(filePath));
//                while ((line = br.readLine())!=null)
//                    buffer.append(line);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        String javaScript = buffer.toString();
//        javaScript = javaScript + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});";
//        ((JavascriptExecutor)driver).executeScript(javaScript);


    }
}

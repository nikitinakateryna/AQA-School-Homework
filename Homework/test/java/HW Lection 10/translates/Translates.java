package translates;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementShould;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selenide;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;



public class Translates {

    @Test
    public void translations() throws ElementShould {


        HashMap<String,String> localeAndTranslations = new HashMap<>();

        localeAndTranslations.put("fr", "J'étudierai le test");
        localeAndTranslations.put("de", "Ich werde testng cool studieren");
        localeAndTranslations.put("pl", "Badam testng fajny");
        localeAndTranslations.put("es", "Estudiaré testng genial");
        localeAndTranslations.put("it", "Studierò Testng Cool");
        localeAndTranslations.put("lv", "Es studēšu testng atdzist");
        localeAndTranslations.put("lt", "Aš studijuosiu „testng Cool");
        localeAndTranslations.put("mk", "Ḱe učam test kul");
        localeAndTranslations.put("nl", "Ik zal testng cool bestuderen");
        localeAndTranslations.put("pt", "Vou estudar testng legal");
        localeAndTranslations.put("ro", "Voi studia testng cool");
        localeAndTranslations.put("sr", "Ја ћу проучити тестнг цоол");
        localeAndTranslations.put("sk", "Budem študovať testng cool");
        localeAndTranslations.put("sl", "Preučeval bom testng kul");
        localeAndTranslations.put("tr", "Testng serin çalışacağım");
        localeAndTranslations.put("fi", "Opiskelen testiä viileänä");
        localeAndTranslations.put("cs", "Budu studovat testng cool");
        localeAndTranslations.put("sv", "Jag kommer att studera testng cool");
        localeAndTranslations.put("et", "Uurin testi jahedat");


        for (String lang : localeAndTranslations.keySet()){
            try {
                Selenide.open("https://translate.google.com/?sl=uk&tl=" + lang + "&text=Я%20круто%20вивчу%20TestNG&op=translate");

                SelenideElement element = $x("//*[@id='yDmH0d']/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[2]/div/div[7]/div/div[1]/span[1]/span");

                element.shouldHave(Condition.text(localeAndTranslations.get(lang)));

            } catch (ElementShould e) {

                System.out.println("No expected translation found for language: " + lang);
                e.printStackTrace();
            }
        }
    }
}



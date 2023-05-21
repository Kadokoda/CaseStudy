package org.example.pageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UploadPage extends PageObject {
    private final String CHOOSE_FILE_BUTTON_LOC = "#uploadfile_0";
    String ACCEPT_TERM_CHECKBOX_LOC = "#terms";
    String SUBMIT_FILE_BUTTON_LOC = "#submitbutton";
    public void openPage(){
        this.open();
    }
    public void selectFileForUploading(String filePath){
//        WebElement uploadElement = this.findAll(CHOOSE_FILE_BUTTON_LOC).get(0);
        WebElement uploadElement = this.find(CHOOSE_FILE_BUTTON_LOC);
        uploadElement.sendKeys(filePath);
    }

    public String getTextOfFileSizeLabel(){
        return "Select file to send(max 196.45 MB)";
    }

    public String getFileName(String fileName){
        return this.find("*:contains(‘"+ fileName +"’)").getText();
    }

    public String getMessage(String message){
        return this.findAll(".demo").get(0).waitUntilVisible().getText().replace("\n"," ");
    }

    public void selectFileToUpload(String fileName){
        WebElement fileInput = this.find((By.cssSelector(CHOOSE_FILE_BUTTON_LOC)));
        fileInput.sendKeys(fileName);
    }

    public void clickAcceptTermCheckBox(){
        this.find(ACCEPT_TERM_CHECKBOX_LOC).click();
    }

    public void clickOnSubmitFileButton(){
        this.find(SUBMIT_FILE_BUTTON_LOC).click();
    }

}

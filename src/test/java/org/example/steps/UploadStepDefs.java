package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pageObject.UploadPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UploadStepDefs {
    String currentPath = System.getProperty("user.dir");
    private final UploadPage uploadPage = new UploadPage();
    private final String PATH_TO_DATA = currentPath + "/src/test/resources/data/";
    private final String VALID_FILE = "valid.txt";
    private final String FILE_SIZE = "MB.txt";
    private final String FILE_LONG_NAME = "this_is_a_very_long_file_name_with_multiple_words_and_characters_that_exceeds_the_typical_length_limit_for_a_file_name.txt";
    private final String FILE_SPECIAL_NAME = "!@#!!!.txt";


    @Given("the user is on the file upload page")
    public void userIsOnUploadPage() {
        uploadPage.openPage();
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton() {

    }

    @When("the user select a file to upload")
    public void theUserSelectFileForUploading() {
        uploadPage.selectFileForUploading(PATH_TO_DATA + VALID_FILE);
    }

    @And("the information box of file size showing {string}")
    public void theInformationBoxOfFileSizeShowing(String expectedResult) {
        String actualResult = uploadPage.getTextOfFileSizeLabel();
        assertTrue(actualResult.equals(expectedResult));
    }

    @And("checks the I accept terms of service checkbox")
    public void checksTheCheckbox() {
        uploadPage.clickAcceptTermCheckBox();
    }

    @And("user clicks on the Submit File button")
    public void clickOnSubmitFileButton() {
        uploadPage.clickOnSubmitFileButton();
    }

    @And("the message {string} should be shown")
    public void theMessageShouldBeShown(String message) {
        assertTrue(uploadPage.getMessage(message).equals(message));
    }

    @When("the user selects a large file which is larger than {double} MB upload")
    public void theUserSelectsALargeFileWhichIsLargerThanMBUpload(double fileSize) {
        uploadPage.selectFileForUploading(PATH_TO_DATA + fileSize + FILE_SIZE);
    }

    @When("the user selects a long file name to upload")
    public void theUserSelectsALongFileNameToUpload() {
        uploadPage.selectFileForUploading(PATH_TO_DATA + FILE_LONG_NAME);
    }

    @When("the user selects a file with special character in name to upload")
    public void theUserSelectsAFileWithSpecialCharacterInNameToUpload() {
        uploadPage.selectFileForUploading(PATH_TO_DATA + FILE_SPECIAL_NAME);
    }
}

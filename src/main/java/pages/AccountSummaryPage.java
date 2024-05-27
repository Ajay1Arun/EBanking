package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AccountSummaryPage {

    private WebDriver driver;
    BaseClass baseClass=new BaseClass(driver);


    //==============WebElements===============

    @FindBy(xpath = "//select[@name=\"listAccounts\"]")
    WebElement selectAcc;

    @FindBy(xpath = "//input[@id=\"btnGetAccount\"]")
    WebElement GoButton;

    @FindBy(xpath = "//td[contains(text(),'View Account Details:')]")
    WebElement viewAccDetails;

    @FindBy(xpath = "//th[contains(text(),'Balance Detail')]")
    WebElement balanceDetails;

//===========initalize the constructor===========

public AccountSummaryPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}


    //===============Methods implimentation============

    public void viewAccountSummary(){
        viewAccDetails.getText();
        System.out.println(viewAccDetails);
    }

    public void SelectAccount(){
    baseClass.selectByIndex(selectAcc,0);
    selectAcc.isSelected();

    }

    public void clickGoButton(){

    baseClass.waitForElementClickable(GoButton);
    GoButton.click();

    }

    public void SummaryDetails(){
        balanceDetails.getText();
        System.out.println(balanceDetails);
    }

}

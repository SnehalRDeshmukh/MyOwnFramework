package com.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class  FacebookRegiPage{

	WebDriver driver;

	public FacebookRegiPage(WebDriver d) {
		this.driver = d;

	}

	@FindBy(xpath = "//a[@class='_97w5']")
	WebElement regilink;

	@FindBy(name ="reg_email__")
	WebElement email;
	
	@FindBy(name="reg_email_confirmation__") WebElement reEmail;

	@FindBy(id ="password_step_input")
	WebElement pswd;

	@FindBy(id = "day")
	WebElement day;

	@FindBy(id = "month")
	WebElement month;

	@FindBy(id = "year")
	WebElement year;

	@FindBy(name = "firstname")
	WebElement firstname;

	@FindBy(name = "lastname")
	WebElement surname;

	@FindBy(xpath ="//label[text()='Female']")
	WebElement female;

	@FindBy(id = "u_0_5_l+")
	WebElement male;

	@FindBy(name = "websubmit")
	WebElement signupBtn;

	public static void FaceBookDropDown(WebElement w, String value) {

		Select dd = new Select(w);
		List<WebElement> alloptions = dd.getOptions();

		for (WebElement e : alloptions) {
			System.out.println(e.getText());
			if (e.getText().contains(value)) {
				e.click();
				System.out.println("Match found...");
				break;
			}

		}

	}

	public void RegistrationFaceBook(String mail, String pasw, String FName, String Lname) {
		email.sendKeys(mail);
		reEmail.sendKeys(mail);
		pswd.sendKeys(pasw);
		FacebookRegiPage.FaceBookDropDown(day, "3");
		FacebookRegiPage.FaceBookDropDown(month, "Oct");
		FacebookRegiPage.FaceBookDropDown(year, "1990");
		firstname.sendKeys(FName);
		surname.sendKeys(Lname);
		female.click();
		signupBtn.click();

	}

}

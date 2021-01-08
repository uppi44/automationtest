package CasestudyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CasestudyBase.CasestudyConfigBrowser;

public class LoginPage extends CasestudyConfigBrowser {
	
	@FindBy(xpath="//h1[@align='center']")
	WebElement expected_heading;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='userErrMsg']")
	WebElement expected_usernameerrmsg;
	
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="userPwd")
	WebElement password;
	
    @FindBy(xpath="//div[@id='pwdErrMsg']")
	WebElement expected_passworderrmsg;
	
	public String getHeading() {
		WebElement actual_heading = driver.findElement(By.xpath("//h1[@align='center']"));
		return actual_heading.getText();
	}
	
	public String expectedHeading() {
		return expected_heading.getText();
	}
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String usernamelogin() {
		loginBtn.click();
		WebElement actual_usernameerrmsg = driver.findElement(By.xpath("//div[@id='userErrMsg']"));
		return actual_usernameerrmsg.getText();
	}
	
	public String passwordlogin() {
		username.sendKeys("admin");
		loginBtn.click();
		WebElement actual_passworderrmsg = driver.findElement(By.xpath("//div[@id='pwdErrMsg']"));
		return actual_passworderrmsg.getText();
	}
	
	public String expectedUsernameErr() {
		return expected_usernameerrmsg.getText();	
	}
	
	public String expectedPwdErr() {
		return expected_passworderrmsg.getText();
	}
	
	public void login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	public void closeBrowser() {
		driver.close();
		
	
	}
}

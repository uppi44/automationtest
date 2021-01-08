package CasestudyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import CasestudyBase.CasestudyConfigBrowser;

public class ConfirmationPage extends CasestudyConfigBrowser {
	
	@FindBy(xpath="//h1[@align='center']")
	WebElement expected_success_message;
	
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String bookingConfirmation() {
		WebElement actual_success_message = driver.findElement(By.xpath("//h1[@align='center']"));
		return actual_success_message.getText();
}
}

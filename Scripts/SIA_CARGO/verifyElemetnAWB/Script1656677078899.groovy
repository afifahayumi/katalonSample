import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.InternalData as InternalData

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.siacargo.com/')

WebUI.click(findTestObject('Object Repository/Page_Welcome to SIA Cargo/strong_Track      Shipment'))

WebUI.switchToWindowTitle('Track Shipment')

InternalData iData = findTestData('internal_awb')

awb = iData.getValue(1, 1)

WebUI.setText(findTestObject('Object Repository/Page_Track Shipment/input_Air Waybill 1_Suffix1'), awb)

System.out.println(awb)

WebUI.click(findTestObject('SIA_CARGO/Page_Track Shipment/input__btnQuery'))

awbdata = WebUI.getText(findTestObject('Page_Welcome to SIA Cargo/td_AWB  618-45793705'))

String awbString = awbdata

String[] parts = awbString.split('-')

String awbOnly = parts[(parts.length - 1)]

System.out.println(awbOnly)

if (awb == awbOnly) {
    System.out.println('......Airway bill is Correct.......')
} else {
    System.out.println('......Airwaay bil invalid..........')
}

WebUI.click(findTestObject('Object Repository/Page_Track Shipment/input_Shipment Delivered_btnSearchAgain'))

for (i = 0; i < 2; i++) {
    WebUI.setText(findTestObject('SIA_CARGO/Page_Track Shipment/Page_Track Shipment/input_Air Waybill 2_Suffix2'), iData.getValue(
            'awbno', 2))

    WebUI.setText(findTestObject('SIA_CARGO/Page_Track Shipment/Page_Track Shipment/input_Air Waybill 3_Suffix3'), iData.getValue(
            'awbno', 3))
}

errorMsg=WebUI.getText(findTestObject('SIA_CARGO/Page_Track Shipment/Page_Track Shipment/span_Please check entries highlighted'))

def error = '* Please check entries highlighted.'
if(errorMsg==error) {
	System.out.println("this Error cause of incorrect AWB")
	}else {
		System.out.println("thisawb not caused errror")
	}


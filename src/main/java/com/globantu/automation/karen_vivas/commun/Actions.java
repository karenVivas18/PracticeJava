package com.globantu.automation.karen_vivas.commun;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Quotes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Actions implements ISelect  {
    private final WebElement element;

    protected Actions(WebElement element) {
        this.element = element;
    }
    public static String formatLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
    public List<WebElement> getOptions() {
        return this.element.findElements(By.tagName("option"));
    }
    public WebElement findOptionsByValue(String value) {
        WebElement options = this.element.findElement(By.xpath(".//option[@value = " + Quotes.escape(value) + "]"));
            return options;
    }
    public List<WebElement> findElementsInList(By by) {
        return this.element.findElements(by);
    }
    public List<String> getAllValuesByDataId(String dataValue){
       return findElementsInList(By.cssSelector("[data-test-id= " + Quotes.escape(dataValue) + "]"))
               .stream()
               .map(WebElement::getText).collect(Collectors.toList());
    }
    public  List<WebElement> getAllElementByDataId(String dataValue){
        return findElementsInList(By.cssSelector("[data-test-id= " + Quotes.escape(dataValue) + "]"));
    }

    public  WebElement getElementByIndex(int index ,String dataValue ){
        List<WebElement> elements = this.getAllElementByDataId(dataValue);
            return elements.get(index);
    }
    public int convertDurationToMinutes(String duration){
        String[] parts = duration.split("h|\\s");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours *60 + minutes;
    }

}

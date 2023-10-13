package com.vti.examwebsise.examonline.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Arrays;

@UtilityClass
public class HtmlUtils {


    public String removeTag(@NonNull String htmlCode) {
        String[] parts = htmlCode.split("<p>");
        String headerHtml = "";
        String codeHtml = "";
        if (parts.length >= 2) {
            headerHtml = "<p>" + parts[1];
            codeHtml = "<p>" + parts[2];
        }
        StringBuilder code = new StringBuilder();
        String[] lines = codeHtml.split("\n");
        for (String line : lines) {
            code.append("<p>").append(line).append("</p>");
        }
        return headerHtml + code;
    }
    public String removeTag2(@NonNull String htmlCode) {
        htmlCode = htmlCode.replace("&nbsp;", "%space");
        Document doc = Jsoup.parse(htmlCode);
        StringBuilder b = new StringBuilder();
        for (Element p : doc.select("p")) {
            b.append(p.text());
            b.append(System.getProperty("line.separator"));
        }

        return b.toString().replaceAll("%space", " ");

    }


}

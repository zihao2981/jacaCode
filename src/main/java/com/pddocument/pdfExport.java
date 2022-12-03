//package com.pddocument;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType0Font;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * 使用itext
// * 除了iext还有apache的dpfbox
// */
//public class pdfExport {
//
//    /**
//     * @param page
//     * @param contentStream
//     * @param y the y-coordinate of the first row
//     * @param margin the padding on left and right of table
//     * @param content a 2d array containing the table data
//     * @throws IOException
//     */
//    public static void drawTable(PDDocument doc, PDPage page, PDPageContentStream contentStream,
//                                 float y, float margin,
//                                 String[][] content) throws IOException {
//        final int rows = content.length;
//        final int cols = content[0].length;
//        final float rowHeight = 20f;
//        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
//        final float tableHeight = rowHeight * rows;
//        final float colWidth = tableWidth / (float) cols;
//        final float cellMargin = 5f;
//        //draw the rows
//        float nexty = y;
//        for (int i = 0; i <= rows; i++) {
////            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
//            contentStream.moveTo(margin,nexty);
//            contentStream.lineTo(margin + tableWidth,nexty);
//            contentStream.stroke();
//            nexty -= rowHeight;
//        }
//        //draw the columns
//        float nextx = margin;
//        for (int i = 0; i <= cols; i++) {
////            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
//            contentStream.moveTo(nextx,y);
//            contentStream.lineTo(nextx,y - tableHeight);
//            contentStream.stroke();
//            nexty -= rowHeight;
//            nextx += colWidth;
//        }
//        //now add the text
//        float textx = margin + cellMargin;
//        float texty = y - 15;
//        for (int i = 0; i < content.length; i++) {
//            for (int j = 0; j < content[i].length; j++) {
//                String text = content[i][j];
//                contentStream.beginText();
//                contentStream.newLineAtOffset(textx, texty);
//                contentStream.showText(text);
//                contentStream.endText();
//                textx += colWidth;
//            }
//            texty -= rowHeight;
//            textx = margin + cellMargin;
//        }
//    }
//    public static void drawTable2(PDDocument doc, PDPage page, PDPageContentStream contentStream,
//                                 float y, float margin,
//                                 String[][] content) throws IOException {
//        {
//            final int rows = content.length;
//            final int cols = content[0].length;
//            final float rowHeight = 20f;
//            final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
//            final float tableHeight = rowHeight * rows;
//            final float colWidth = tableWidth / (float) cols;
//            final float cellMargin = 5f;
//            int[] mulRow=new int[rows+1];
//            for (int i = 0; i <= rows; i++) {
//                mulRow[i]=1;
//            }
//            //now add the text
//            float textx = margin + cellMargin;
//            float texty = y - 15;
//            for (int i = 0; i < content.length; i++) {
//                for (int j = 0; j < content[i].length; j++) {
//                    float textyx=texty;
//                    String text = content[i][j];
//                    int mul=text.length()/4+(text.length()%4!=0?1:0);
//                    if(mul>1){
//                        for (int k = 0; k < mul-1; k++) {
//                            String sb = text.substring(0+4*k,4+4*k);
//                            contentStream.beginText();
//                            contentStream.newLineAtOffset(textx, textyx);
//                            contentStream.showText(sb);
//                            contentStream.endText();
//                            textyx-=rowHeight;
//                        }
//                        if(text.length()%4!=0){
//                            String sb2 = text.substring((mul-1)*4,text.length());
//                            contentStream.beginText();
//                            contentStream.newLineAtOffset(textx, textyx);
//                            contentStream.showText(sb2);
//                            contentStream.endText();
//                        }else{
//                            String sb2 = text.substring((mul-1)*4,text.length());
//                            contentStream.beginText();
//                            contentStream.newLineAtOffset(textx, textyx);
//                            contentStream.showText(sb2);
//                            contentStream.endText();
//                        }
//                        if(mul>mulRow[i]){
//                            mulRow[i]=mul;
//                        }
//                    }else {
//                        contentStream.beginText();
//                        contentStream.newLineAtOffset(textx, textyx);
//                        contentStream.showText(text);
//                        contentStream.endText();
//                    }
//                    textx += colWidth;
//                }
//                texty = texty - (rowHeight * mulRow[i]);
//                textx = margin + cellMargin;
//            }
//            //draw the rows
//            float nexty = y;
//            for (int i = 0; i <= rows; i++) {
//                contentStream.moveTo(margin,nexty);
//                contentStream.lineTo(margin + tableWidth,nexty);
//                contentStream.stroke();
//                nexty = nexty- rowHeight*mulRow[i];
//            }
//            //draw the columns
//            float nextx = margin;
//            int count= 0;
//            for (int i = 0; i < rows; i++) {
//                count+=mulRow[i];
//            }
//            for (int i = 0; i <= cols; i++) {
//                contentStream.moveTo(nextx,y);
//                contentStream.lineTo(nextx,y - rowHeight*count);
//                contentStream.stroke();
//                nextx += colWidth;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        PDDocument doc = new PDDocument();
//        PDPage page = new PDPage();
//        doc.addPage(page);
//
//        PDPageContentStream contentStream
//                = new PDPageContentStream(doc, page);
//        String[][] content = {{"处评分32131245fawfa发我发我发我12", "2021评分1", "质控事", "202-08"},
//                {"被质控医疗机构", "d112", "2412", "质控事件"},
//                {"e1241", "f文241", "3421", "质控事件1"},
//        };
//        String[][] content2 = {{"a", "b", "1", "1", "1","c中", "d", "2", "1", "1"},
//                {"c中", "d", "2", "1", "1","c中", "d", "2", "1", "1"},};
//        String[][] content3 = {{"任务事件", "任务名称", "创建者"},
//                {"任务事件", "任务名称", "创建者"},};
//
//        contentStream.setFont(PDType0Font.load(doc, new File("C:\\Windows\\Fonts\\simfang.TTF")), 12);
//        contentStream.beginText();
//        contentStream.newLineAtOffset(100, 710);
//        contentStream.showText("任务名称：处方质控任务");
//        contentStream.endText();
//        contentStream.beginText();
//        contentStream.newLineAtOffset(100, 410);
//        contentStream.showText("抽样详情");
//        contentStream.endText();
//        contentStream.beginText();
//        contentStream.newLineAtOffset(100, 310);
//        contentStream.showText("抽样详情");
//        contentStream.endText();
//        drawTable2(doc, page, contentStream, 700, 100, content);
//        drawTable(doc, page, contentStream, 400, 100, content2);
//        drawTable(doc, page, contentStream, 300, 100, content3);
//        contentStream.close();
//        doc.save("F:/1test_table.pdf");
//    }
//}
package com.com.pddocument;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;

public class pdfExport {

    /**
     * @param page
     * @param contentStream
     * @param y the y-coordinate of the first row
     * @param margin the padding on left and right of table
     * @param content a 2d array containing the table data
     * @throws IOException
     */
    public static void drawTable(PDDocument doc, PDPage page, PDPageContentStream contentStream,
                                 float y, float margin,
                                 String[][] content) throws IOException {
        final int rows = content.length;
        final int cols = content[0].length;
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 5f;

        //draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        //draw the columns
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        //now add the text
        //contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.setFont(PDType0Font.load(doc, new File("C:\\Windows\\Fonts\\simfang.TTF")), 12);
        float textx = margin + cellMargin;
        float texty = y - 15;
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                String text = content[i][j];
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
    }

    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);

        PDPageContentStream contentStream
                = new PDPageContentStream(doc, page);

        String[][] content = {{"a", "b", "1"},
                {"c中", "d", "2"},
                {"e", "f文", "3"},
                {"g", "h", "4的"},
                {"i", "j", "5测试"}};

        drawTable(doc, page, contentStream, 700, 100, content);
        contentStream.close();
        doc.save("F:/test_table.pdf");
    }
}
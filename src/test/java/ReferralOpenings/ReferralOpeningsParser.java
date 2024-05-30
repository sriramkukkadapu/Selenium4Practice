package ReferralOpenings;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
//import org.vandeseer.easytable.TableDrawer;
//import org.vandeseer.easytable.settings.BorderStyle;
//import org.vandeseer.easytable.settings.HorizontalAlignment;
//import org.vandeseer.easytable.structure.Row;
//import org.vandeseer.easytable.structure.Table;
//import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;

public class ReferralOpeningsParser {
	
	public static void main(String args[]) throws IOException {
		BufferedReader fis=new BufferedReader(new FileReader("referralopeningsdata.txt"));  // Duplicates/Emails.txt
		Map<String,String> resultMap=new TreeMap<String,String>(Comparator.reverseOrder());
		
		String temp="";
		
		int counter=0;
		String opening=null;
		String location=null;
		
		String finalOutput = "";
		
		String output_openings="";
		String output_locations="";
		
		while (temp != null) {
			temp = fis.readLine();
			if(temp==null) break;
//			if(hsetOpening.contains(temp))
			opening=temp;
//			System.out.println(temp);
			temp = fis.readLine();
			location=temp;
//			System.out.println(temp);
			
			if(resultMap.containsKey(opening)) {
				String currentLocationInMap = resultMap.get(opening);
				String appenedLocation = currentLocationInMap+", "+location;
				resultMap.put(opening, appenedLocation);
			}
			else
			{
				resultMap.put(opening,location);
			}
		}
		
//		Collections.sort(resultMap);
//		System.out.println(resultMap);
		Set<String> keyset =resultMap.keySet(); 
		
		for(String e:keyset) {
			
			finalOutput = finalOutput+e;
			output_openings = output_openings + e + "\n";
			finalOutput = finalOutput + " " +resultMap.get(e)+"\n";
			
			output_locations = output_locations +  resultMap.get(e)+"\n";
		}
		
		finalOutput = finalOutput.replace(", India", "");
		finalOutput = finalOutput.replace(":", " - ");		
//		System.out.println(finalOutput);
		
//		System.out.println(keyset);
		
		System.out.println(output_openings);
		System.out.println("=================");
		System.out.println(output_locations);
		
//		
//		PDDocument document = new PDDocument();
//        final PDPage page = new PDPage(PDRectangle.A4);
//        document.addPage(page);
//
//        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
//
//            // Build the table
//            Table myTable = Table.builder()
//                    .addColumnsOfWidth(200, 200)
//                    .padding(2)
//                    .addRow(Row.builder()
//                            .add(TextCell.builder().text("One One").borderWidth(4).borderColorLeft(Color.MAGENTA).backgroundColor(Color.WHITE).build())
//                            .add(TextCell.builder().text("One Two").borderWidth(0).backgroundColor(Color.YELLOW).build())
//                            .build())
//                    .addRow(Row.builder()
//                            .padding(10)
//                            .add(TextCell.builder().text("Two One").textColor(Color.RED).build())
//                            .add(TextCell.builder().text("Two Two")
//                                    .borderWidthRight(1f)
//                                    .borderStyleRight(BorderStyle.DOTTED)
//                                    .horizontalAlignment(HorizontalAlignment.RIGHT)
//                                    .build())
//                            .build())
//                    .build();
//
//            // Set up the drawer
//            TableDrawer tableDrawer = TableDrawer.builder()
//                    .contentStream(contentStream)
//                    .startX(20f)
//                    .startY(page.getMediaBox().getUpperRightY() - 20f)
//                    .table(myTable)
//                    .build();
//
//            // And go for it!
//            tableDrawer.draw();
//        }
//
//        document.save("example.pdf");
		
		
	}

}

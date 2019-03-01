package com.journaldev.bootifulmongodb.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;

import com.itextpdf.text.Image;
@RestController
@RequestMapping(value = "/rest")

public class PdfGenerator {
	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public String generatePDF() throws DocumentException, IOException {
		// For inserting text
		Document document = new Document();

		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\lenovo\\Desktop\\text.pdf"));

		document.open();

		document.add(new Paragraph("Sample 1: Hello, this is Concretepage.com"));

		document.close();
		System.out.println("Done");
		
		// for inserting tables
		 Document document2 = new Document();
		  PdfPTable table = new PdfPTable(new float[] { 2, 1, 2 });
		  table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		  table.addCell("Name");
	          table.addCell("Age");
	          table.addCell("Location");
		  table.setHeaderRows(1);
		  PdfPCell[] cells = table.getRow(0).getCells(); 
		  for (int j=0;j<cells.length;j++){
		     cells[j].setBackgroundColor(BaseColor.GRAY);
		  }
	          for (int i=1;i<5;i++){
	    	     table.addCell("Name:"+i);
	             table.addCell("Age:"+i);
	             table.addCell("Location:"+i);
	          }
		  PdfWriter.getInstance(document2, new FileOutputStream("C:\\Users\\lenovo\\Desktop\\tables.pdf"));
		  document2.open();
	          document2.add(table);
		  document2.close();
		  System.out.println("Done");
			
			// for inserting lists
			Document document1 = new Document();
			List list = new List(List.ORDERED);
		        list.setAutoindent(false);
		        list.setSymbolIndent(42);	
		        list.add(new ListItem("Ram"));	
		        list.add(new ListItem("Shyam"));
		        list.add(new ListItem("Mohan"));
		        list.add(new ListItem("Ganesh"));
		        PdfWriter.getInstance(document1, new FileOutputStream("C:\\Users\\lenovo\\Desktop\\lists.pdf"));
		        document1.open();
		        document1.add(list);
			document1.close();
			System.out.println("Done");
			
			//inserting images
			  // Creating a PdfWriter       
			Document document3 = new Document();

		      PdfWriter.getInstance(document3, new FileOutputStream("C:\\Users\\lenovo\\Desktop\\pict.pdf"));
		        document3.open();
		      // Creating a PdfDocument       
		                     
		  
		      Image img = Image.getInstance("C:\\Users\\lenovo\\Desktop\\Auction-System-For-The-Farmers-SpringBoot-MongoDB\\images\\roman.jpg");
		      
		      // Adding image to the document       
		      document3.add(img);              
		      
		      // Closing the document       
		      document3.close();              
		      
		      System.out.println("Image added"); 
				return "Generated Successfully";


	}
	

}

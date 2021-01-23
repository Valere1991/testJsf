package com.valere.pdfexport;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.valere.entities.Kunde;

public class KundePDFExporter {
	
	private List<Kunde> listKunden;

	public KundePDFExporter(List<Kunde> listKunden) {
		this.listKunden = listKunden;
	}
	
	private void writeTableHeader(PdfPTable table) {
		
		
		
	}
	
	private void writeTableData(PdfPTable table) {
		
		for (Kunde kunde : listKunden) {
			table.addCell(kunde.getVorname());
			table.addCell(kunde.getName());
			table.addCell(kunde.getStr());
			table.addCell(String.valueOf(kunde.getPlz()));
			table.addCell(kunde.getStadt());
		}
		
	}
	
	
	public void export(HttpServletResponse response) throws DocumentException, IOException, com.itextpdf.text.DocumentException {
		Document document = new  Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		
		document.add(new Paragraph("Autohaus D "));
		
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		table.setSpacingAfter(100);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.add(new Paragraph("1. Fahrzeugtyp: QWER / "	+ "Fahrzeugbezeichnung: 1234DFL / " +	"Hersteller: Opel / " +	"Leistung: 74 KW / "	+ "Verkaufspreis: 7 000 €"));
		document.add(new Chunk("\n"));
		document.add(new Paragraph("2. Fahrzeugtyp: C4 / "	+ "Fahrzeugbezeichnung: CHN41K / " +	"Hersteller: Mercedez / " +	"Leistung: 98 KW / "	+ "Verkaufspreis: 12 000 €"));
		document.add(new Chunk("\n"));
		document.add(new Paragraph("3. Fahrzeugtyp: Focus / "	+ "Fahrzeugbezeichnung: SBDMH521 / " +	"Hersteller: Ford / " +	"Leistung: 69 KW / "	+ "Verkaufspreis: 4 200 €"));
		document.add(new Chunk("\n"));
		document.add(new Paragraph("4. Fahrzeugtyp: 632 / "	+ "Fahrzeugbezeichnung: BGDD / " +	"Hersteller: MAZDA / " +	"Leistung: 63 KW / "	+ "Verkaufspreis: 3 000 €"));
		document.add(new Chunk("\n"));
		document.add(new Paragraph("5. Fahrzeugtyp: T25 / "	+ "Fahrzeugbezeichnung: 455 / " +	"Hersteller: BMW / " +	"Leistung: 96 KW / "	+ "Verkaufspreis: 3 000 €"));
		
				
		document.close();
		
	}

}
